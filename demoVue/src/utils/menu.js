import {getRequest} from "./api"

export const initMenu = (router,store)=>{
    if (store.state.routes.length > 0) {
        return;
    }

    getRequest("/system/config/menu").then(data=>{
        if (data) {
            let mtRoutes = formatRoutes(data);
            router.addRoutes(fmRoutes);
            store.commit('initRoutes',fmRoutes);
        }
    })
}

export const formatRoutes = (routes)=>{
    let fmRoutes=[];
    routes.forEach(routes=>{
        let {
            path,
            component,
            name,
            meta,
            iconCls,
            children
        } = routes;
        if (children && children instanceof Array) {
            children = formatRoutes(children);
        }
        let fmRoute = {
            path:path,
            name:name,
            iconCls:iconCls,
            meta:meta,
            children:children,
            component(resolve){
                require(['../page/'+component+'.vue'],resolve);
            }
        }
        fmRoutes.push(fmRoute);
    })
    return fmRoutes;
}