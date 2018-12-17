package lord.taylor.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
 
public class Excel
{
    public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
 
    /*public Excel(String xlFilePath) throws Exception
    {
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        //fis.close();
    }
 
    public List<String> getCellData(String sheetName, String colName)
    {
  
        try
        {
    		List<String> rowList = new ArrayList<String>();

            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
           // System.out.println("sheetName" +sheetName);
            row = sheet.getRow(0);
            for(int i = 1; i < row.getLastCellNum(); i++)
            {
            	for(int j=0;j<row.getLastCellNum();j++)
            	{//System.out.println();
            	
                if(row.getCell(j).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = j;
            
 
            row = sheet.getRow(i);
            cell = row.getCell(col_Num);
            System.out.println(row.getCell(j).getStringCellValue());
 
            if(cell.getCellTypeEnum() == CellType.STRING) {
            	System.out.println("cell.getCellTypeEnum()"+cell.getCellTypeEnum());
                return cell.getStringCellValue();
            }
            else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
            {
                String cellValue = String.valueOf(cell.getNumericCellValue());
                System.out.println("cellValue"+cellValue);
                if(HSSFDateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date date = cell.getDateCellValue();
                    cellValue = df.format(date);
                }
                return cellValue;
            }else if(cell.getCellTypeEnum() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
            	}
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
           return "data does not exist  in Excel";
        }
		return colName;
       
        
 */   
    public static DataFormatter formatter= new DataFormatter();
    public int DataSet=-1;
    
    public  Object[][] readVariant() throws IOException
    {
    FileInputStream fileInputStream= new FileInputStream(System.getProperty("user.dir") +"//src//main//resources//test.xlsx"); //Excel sheet file location get mentioned here
    XSSFWorkbook wb = new XSSFWorkbook (fileInputStream);
    XSSFSheet worksheet = wb.getSheet("ProductInfo");
    XSSFRow Row=worksheet.getRow(0);


        int RowNum = worksheet.getPhysicalNumberOfRows();// count  number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum
        Object Data[][]= new Object[RowNum-1][ColNum]; // pass count data in array

            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
            {
                XSSFRow row= worksheet.getRow(i+1);

                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        XSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data
                        else
                        {
                            String value=formatter.formatCellValue(cell);
                            Data[i][j]=value; //This formatter get  all values as string i.e integer, float all type data value
                        }
                    }
                }
            }



        return Data;
    }
}
        