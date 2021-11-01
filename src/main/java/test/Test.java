package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName test.Test
 * @date 2021/9/2 21:00
 */
public class Test {
    public static void main(String[] args) {
        //读excel
        String path = "E:\\产品分类对象新建导入模板.xlsx";
        Workbook sheets = readExcel(path);
        Sheet sheet = sheets.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        Row row = null;
        List<Category> categoryList = new ArrayList<>();
        for(int i = 0;i<rows;i++){
            row = sheet.getRow(i);
            MasterFieldVal masterFieldVal = new MasterFieldVal((String)getCellFormatValue(row.getCell(1)),(String)getCellFormatValue(row.getCell(0)),(String)getCellFormatValue(row.getCell(2)));
            Category category = new Category("materialGroup",masterFieldVal);
            categoryList.add(category);
        }
        System.out.println(categoryList.toString());
        JSONArray jsonArray = new JSONArray(Collections.singletonList(categoryList));
        System.out.println(jsonArray);
    }

    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:{
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Category{
        String objAPIName;
        MasterFieldVal masterFieldVal;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class MasterFieldVal{
        String number;
        String parentNumber;
        String name;
    }

}
