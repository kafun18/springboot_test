package mdm_web.mdm_test;

import mdm_web.IMdSharingCenterService;
import mdm_web.IMdSharingCenterServicePortType;
import mdm_web.MdmRetVO;

public class test {
    public static void main(String[] args) {
        IMdSharingCenterService imdcs =
                new IMdSharingCenterService();
        IMdSharingCenterServicePortType imdcsp =
                imdcs.getPort(IMdSharingCenterServicePortType.class);
        MdmRetVO vo = imdcsp.queryMdByCondition("ETL","mdm_merchants",
                "name='吴基松'",false,"json");
        System.out.println(vo.getData().getValue());

    }
}
