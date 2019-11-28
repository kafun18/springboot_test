import {getRequest} from "./api"

export const initMenu = (router,store)=>{
    if (store.state.routes.length > 0) {
        return;
    }

    getRequest("/system/config/menu").then(data=>{
        if (data) {
            let fmtRoutes = formatRoutes(data);
            router.addRoutes(fmtRoutes);
            store.commit('initRoutes',fmtRoutes);
        }
    })
}

export const formatRoutes = (routes)=>{
    let fmRoutes=[];
    routes.forEach(route=>{
        let {
            path,
            component,
            name,
            meta,
            iconCls,
            children
        } = route;
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
              if (component.startsWith("Home")){
                require(['../page/'+component+'.vue'],resolve);
              }else if (component.startsWith("Emp")){
                require(['../page/emp/'+component+'.vue'],resolve);
              }else if (component.startsWith("Per")){
                require(['../page/per/'+component+'.vue'],resolve);
              }else if (component.startsWith("Sal")){
                require(['../page/sal/'+component+'.vue'],resolve);
              }else if (component.startsWith("Sta")){
                require(['../page/sta/'+component+'.vue'],resolve);
              }else if (component.startsWith("Sys")){
                require(['../page/sys/'+component+'.vue'],resolve);
              }
            }
        }
        fmRoutes.push(fmRoute);
    })
    return fmRoutes;
}
