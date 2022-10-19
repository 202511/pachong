package com.example.pachong;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
                try {
                    //问题1 ： 我们要获取文件目录
                    System.out.println("第二版本");
                    System.out.println("dasd asd ");
                    System.out.println("大大大大大");
                    System.out.println("yy");
                    File file1 = new File("C:\\GP\\2020_multiple");
                    ArrayList<String> strings = new ArrayList<>();
                    if ( file1.isDirectory())
                    {
                        File[] files = file1.listFiles();



                        try {
                            if(files!=null) {
                                for (File file : files) {
                                    Document parse = Jsoup.parse(file, "UTF-8");
                                    Elements select = parse.select("#generalArticleEditForm00080101_bidOrgDetailTDP > p");
                                    for (Element element : select) {
                                        String s = element.toString();
                                        int i = s.indexOf("&nbsp;&nbsp;");
                                        String substring = s.substring(i + "&nbsp;&nbsp;".length());
                                        int i1 = substring.indexOf("&nbsp;&nbsp;");
                                        strings.add(substring.substring(0, i1));

                                    }


                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\86136\\Desktop\\test.xlsx");

                        HSSFWorkbook sheets = new HSSFWorkbook(fileInputStream);

                        HSSFSheet name = sheets.getSheet("name");
                        int i=11;
                        for (String string : strings) {
                            HSSFRow row1 = name.createRow(++i);
                            row1.createCell(i).setCellValue(string);
                        }
                        File file = new File("C:\\Users\\86136\\Desktop\\test.xlsx");
                        sheets.write(file);
                        sheets.close();

                    }

//                    File file = new File("C:\\Users\\86136\\Desktop\\（佛山市禅城区粮食储备库）佛山市禅城区粮食仓库租赁项目(第二次)（440604-202002-8623-0001）的成交结果公告.html");
//                    Document document =Jsoup.parse(file,"UTF-8");
//                    Elements elements=document.select("#detail > div.main > div > div.vF_deail_maincontent > div > div.vF_detail_content_container > div > table:nth-child(14) > tbody > tr:nth-child(2) > td:nth-child(6) ");
//                    for (Element element : elements) {
//                        System.out.println(element);
//                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }



    }
}
