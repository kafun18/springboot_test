
package mdm_web;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IMdSharingCenterServicePortType", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IMdSharingCenterServicePortType {


    /**
     * 
     * @param string
     * @param string1
     * @param list
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:deleteListMdByIds")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "deleteListMdByIds", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.DeleteListMdByIds")
    @ResponseWrapper(localName = "deleteListMdByIdsResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.DeleteListMdByIdsResponse")
    public MdmRetVO deleteListMdByIds(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "list", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        List<String> list);

    /**
     * 
     * @param _boolean
     * @param string
     * @param string1
     * @param list
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:queryListMdByIds")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryListMdByIds", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryListMdByIds")
    @ResponseWrapper(localName = "queryListMdByIdsResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryListMdByIdsResponse")
    public MdmRetVO queryListMdByIds(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "list", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        List<String> list,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean);

    /**
     * 
     * @param _boolean
     * @param string
     * @param string1
     * @param string2
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:queryNewMdAfter")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryNewMdAfter", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryNewMdAfter")
    @ResponseWrapper(localName = "queryNewMdAfterResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryNewMdAfterResponse")
    public MdmRetVO queryNewMdAfter(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean);

    /**
     * 
     * @param _boolean
     * @param string
     * @param string4
     * @param string1
     * @param string2
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:queryMdByCondition")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryMdByCondition", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMdByCondition")
    @ResponseWrapper(localName = "queryMdByConditionResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMdByConditionResponse")
    public MdmRetVO queryMdByCondition(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean,
        @WebParam(name = "string4", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string4);

    /**
     * 
     * @param _boolean
     * @param string
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:changeBackgroundTaskStatus")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "changeBackgroundTaskStatus", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.ChangeBackgroundTaskStatus")
    @ResponseWrapper(localName = "changeBackgroundTaskStatusResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.ChangeBackgroundTaskStatusResponse")
    public String changeBackgroundTaskStatus(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean);

    /**
     * 
     * @param string
     * @param list
     * @return
     *     returns java.util.List<mdm_web.IDMapping>
     */
    @WebMethod(action = "urn:queryMDMCodeByIdsMulti")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryMDMCodeByIdsMulti", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMDMCodeByIdsMulti")
    @ResponseWrapper(localName = "queryMDMCodeByIdsMultiResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMDMCodeByIdsMultiResponse")
    public List<IDMapping> queryMDMCodeByIdsMulti(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "list", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        List<SourceIDBean> list);

    /**
     * 
     * @param string
     * @param string3
     * @param string1
     * @param list
     * @return
     *     returns java.util.List<mdm_web.QueryIdsSingleResponse.Return>
     */
    @WebMethod(action = "urn:queryIdsSingle")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryIdsSingle", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryIdsSingle")
    @ResponseWrapper(localName = "queryIdsSingleResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryIdsSingleResponse")
    public List<mdm_web.QueryIdsSingleResponse.Return> queryIdsSingle(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "list", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        List<String> list,
        @WebParam(name = "string3", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string3);

    /**
     * 
     * @param _boolean
     * @param string
     * @param string1
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:queryXmlListMdByType")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryXmlListMdByType", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryXmlListMdByType")
    @ResponseWrapper(localName = "queryXmlListMdByTypeResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryXmlListMdByTypeResponse")
    public MdmRetVO queryXmlListMdByType(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean);

    /**
     * 
     * @param _boolean
     * @param string
     * @param string1
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:queryListMdByType")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryListMdByType", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryListMdByType")
    @ResponseWrapper(localName = "queryListMdByTypeResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryListMdByTypeResponse")
    public MdmRetVO queryListMdByType(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean);

    /**
     * 
     * @param string
     * @param string3
     * @param string1
     * @param string2
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:queryMdmcodeByGdCode")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryMdmcodeByGdCode", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMdmcodeByGdCode")
    @ResponseWrapper(localName = "queryMdmcodeByGdCodeResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMdmcodeByGdCodeResponse")
    public MdmRetVO queryMdmcodeByGdCode(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2,
        @WebParam(name = "string3", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string3);

    /**
     * 
     * @param _boolean
     * @param string
     * @param string1
     * @param string2
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:queryXmlMdById")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryXmlMdById", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryXmlMdById")
    @ResponseWrapper(localName = "queryXmlMdByIdResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryXmlMdByIdResponse")
    public MdmRetVO queryXmlMdById(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean);

    /**
     * 
     * @param _boolean
     * @param string
     * @param string1
     * @param string2
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:queryMdByName")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryMdByName", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMdByName")
    @ResponseWrapper(localName = "queryMdByNameResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMdByNameResponse")
    public MdmRetVO queryMdByName(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean);

    /**
     * 
     * @param _boolean
     * @param string
     * @param string1
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:subscribeMd")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "subscribeMd", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.SubscribeMd")
    @ResponseWrapper(localName = "subscribeMdResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.SubscribeMdResponse")
    public String subscribeMd(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean);

    /**
     * 
     * @param string
     * @param string1
     * @param string2
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:updateMd")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "updateMd", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.UpdateMd")
    @ResponseWrapper(localName = "updateMdResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.UpdateMdResponse")
    public MdmRetVO updateMd(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2);

    /**
     * 
     * @param _boolean
     * @param string
     * @param string1
     * @param string2
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:queryMdById")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryMdById", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMdById")
    @ResponseWrapper(localName = "queryMdByIdResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMdByIdResponse")
    public MdmRetVO queryMdById(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean);

    /**
     * 
     * @param string
     * @param string1
     * @param string2
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:deleteMdById")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "deleteMdById", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.DeleteMdById")
    @ResponseWrapper(localName = "deleteMdByIdResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.DeleteMdByIdResponse")
    public MdmRetVO deleteMdById(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2);

    /**
     * 
     * @param _boolean
     * @param string
     * @param string1
     * @param string2
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:queryMdByCode")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryMdByCode", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMdByCode")
    @ResponseWrapper(localName = "queryMdByCodeResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryMdByCodeResponse")
    public MdmRetVO queryMdByCode(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2,
        @WebParam(name = "boolean", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        Boolean _boolean);

    /**
     * 
     * @param string
     * @param string2
     * @param list
     * @return
     *     returns java.util.List<mdm_web.IDMapping>
     */
    @WebMethod(action = "urn:queryIdsMulti")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "queryIdsMulti", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryIdsMulti")
    @ResponseWrapper(localName = "queryIdsMultiResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.QueryIdsMultiResponse")
    public List<IDMapping> queryIdsMulti(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "list", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        List<SourceIDBean> list,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2);

    /**
     * 
     * @param string
     * @param string1
     * @param string2
     * @return
     *     returns mdm_web.MdmRetVO
     */
    @WebMethod(action = "urn:insertMd")
    @WebResult(targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
    @RequestWrapper(localName = "insertMd", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.InsertMd")
    @ResponseWrapper(localName = "insertMdResponse", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", className = "mdm_web.InsertMdResponse")
    public MdmRetVO insertMd(
        @WebParam(name = "string", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string,
        @WebParam(name = "string1", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string1,
        @WebParam(name = "string2", targetNamespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService")
        String string2);

}
