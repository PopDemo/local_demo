import com.google.common.collect.Lists;
import com.shuyun.excel.write.Excel2007Write;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

@Slf4j
public class FileDownlodDemo {

    public static void main(String[] args) {
        excuteFile();

    }

    public static void excuteFile(){
        String filename="C:\\Users\\MI\\Downloads\\(1043)AA无主代金券模板20210610 (1).xlsx";

//        XSSFWorkbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("sheet"+1);
//        Row headRow=sheet.createRow(0);
//        headRow.createCell(0).setCellValue("one");
//        headRow.createCell(1).setCellValue("two");
//        headRow.createCell(2).setCellValue("three");
//        headRow.createCell(3).setCellValue("four");
//
//        Row firstRow=sheet.createRow(1);
//        firstRow.createCell(0).setCellValue("1");
//        firstRow.createCell(1).setCellValue("2");
//        firstRow.createCell(2).setCellValue("3");
//        firstRow.createCell(3).setCellValue("4");

        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Excel2007Write excel = new Excel2007Write();
            excel.addHead(Lists.newArrayList("优惠券ID", "优惠券码"));



        }catch (Exception e){
            log.error("e:",e);
        }

        FileOutputStream fos=null;

        try {
            //保存此XSSFWorkbook对象为xlsx文件
//            workbook.write(new FileOutputStream(filename));

            POIFSFileSystem fs = new POIFSFileSystem();
            EncryptionInfo info = new EncryptionInfo(EncryptionMode.standard);
            Encryptor enc = info.getEncryptor();
            //设置密码
            enc.confirmPassword("zmf");
            //加密文件
            OPCPackage opc = OPCPackage.open(new File(filename), PackageAccess.READ_WRITE);
            OutputStream os = enc.getDataStream(fs);
            opc.save(os);
            opc.close();

            //把加密后的文件写回到流
            fos = new FileOutputStream(filename);
            fs.writeFilesystem(fos);

            fos.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("over");
    }


}
