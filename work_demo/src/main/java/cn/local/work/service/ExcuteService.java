package cn.local.work.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.io.*;

@Slf4j
@Component
public class ExcuteService {

    @Autowired private JdbcTemplate jdbcTemplate;


    public ByteArrayOutputStream excuteFile() throws Exception{
        String sql = "select id as instanceId, coupon_id as couponId,create_time as createTime from teskechers_crmep_benefit.benefit_instance where ifnull(disabled, 0) = 0 and project_id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql,"1068");
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("sheet"+1);
            Row headRow=sheet.createRow(0);
            headRow.createCell(0).setCellValue("优惠券ID");
            headRow.createCell(1).setCellValue("优惠券码");
            int rowCount =1;
            while (sqlRowSet.next()){
                String id = sqlRowSet.getString("instanceId");
                String couponId = sqlRowSet.getString("couponId");
                Row first=sheet.createRow(rowCount);
                first.createCell(0).setCellValue(id);
                first.createCell(1).setCellValue(couponId);
                rowCount++;
            }
            workbook.write(os);
            os.flush();
            log.info("加密前的 file size:{}",os.size());

            ByteArrayInputStream workbookInput = new ByteArrayInputStream(os.toByteArray());

            // 创建POIFS文件系统 加密文件
            POIFSFileSystem fs = new POIFSFileSystem();
            EncryptionInfo info = new EncryptionInfo(EncryptionMode.standard);
            Encryptor enc = info.getEncryptor();
            enc.confirmPassword("itemProject");
            // 然后把字节输入到输入流，然后输入到OPC包里面
            OPCPackage opc = OPCPackage.open(workbookInput);
            OutputStream outputStream = enc.getDataStream(fs);

            opc.save(outputStream);
            opc.close();

            os = new ByteArrayOutputStream();
            fs.writeFilesystem(os);
            os.flush();

//            inputStream.close();
            workbook.close();
            os.close();

            return os;
        } catch (IOException e) {
            log.error("异常:",e);
        }
            return null;
        }


    }
