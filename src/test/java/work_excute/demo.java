package work_excute;


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

@SpringBootTest
public class demo {

    @Test
    public void excuteTest() throws Exception{
        String sql = "select id as instanceId, coupon_id as couponId,create_time as createTime from benefit_instance where ifnull(disabled, 0) = 0 and project_id = ?";
        jdbeTemplate.quer




    }






}
