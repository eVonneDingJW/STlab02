/**
 * Created by DingJingwen on 16/4/17.
 */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{


    WebDriver driver;
    Map<String,String> map;

    @Before
    public void setUp(){
        try {
            driver = new FirefoxDriver();
            map = App.read();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        for(Map.Entry<String,String> entry:map.entrySet()){

            driver.get("http://www.ncfxy.com");
            String a = entry.getKey();
            WebElement element = driver.findElement(By.id("name"));
            element.clear();
            element.sendKeys(a);
            WebElement password = driver.findElement(By.id("pwd"));
            password.clear();
            password.sendKeys(a.substring(4));

            WebElement button = driver.findElement(By.xpath(".//*[@id='submit']"));
            button.click();

            WebElement mail = driver.findElement(By.xpath(".//*[@id='table-main']/tr[1]/td[2]"));
            assertEquals(mail.getText(),entry.getValue());


        }
    }




}

