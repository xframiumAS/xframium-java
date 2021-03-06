package org.xframium.terminal.driver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.*;
import java.util.*;

import org.openqa.selenium.*;

import org.xframium.terminal.driver.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1()
    {
        try
        {
            Properties props = new Properties();
            props.load( Thread.currentThread().getContextClassLoader().getResourceAsStream( "test.properties" ));

            Tn3270TerminalDriver.StartupDetails details =
                new  Tn3270TerminalDriver.StartupDetails( props.getProperty("test.terminal.host"),
                                                          Integer.parseInt(props.getProperty("test.terminal.port")),
                                                          Integer.parseInt(props.getProperty("test.terminal.type")),
                                                          props.getProperty("test.app.start"),
                                                          props.getProperty("test.app.file"),
                                                          props.getProperty("test.app.name"),
                                                          props.getProperty("test.app.images"),
                                                          Boolean.parseBoolean(props.getProperty("test.terminal.visible")));

            Tn3270TerminalDriver driver = new Tn3270TerminalDriver( details );

            sleep(3000);

            WebElement element = driver.findElement( new By.ByXPath( "//screen[name='SystemBanner']/link[name='ack']" ));
            element.click();

            sleep(3000);

            element = driver.findElement( new By.ByXPath( "//screen[name='Login']/field[name='username']" ));
            element.sendKeys("$000");
            element = driver.findElement( new By.ByXPath( "//screen[name='Login']/field[name='password']" ));
            element.sendKeys("music");
            element.submit();

            sleep(3000);
            
            element = driver.findElement( new By.ByXPath( "//screen[name='ABlankScreen']/field[name='menu-entry']" ));
            element.sendKeys("admin");
            element.submit();

            sleep(3000);

            element = driver.findElement( new By.ByXPath( "//screen[name='AdminMenu']/field[name='option']" ));
            element.sendKeys("3");
            element.click();

            sleep(3000);

            element = driver.findElement( new By.ByXPath( "//screen[name='FileSystemMenu']/link[name='file-system-help']" ));
            element.click();

            sleep(3000);

            element = driver.findElement( new By.ByXPath( "//screen[name='FileSystemHelp']/field[name='help-text']" ));

            System.out.println( "Got text: " + element.getText() );

            java.io.File theFile = ((TakesScreenshot) driver).getScreenshotAs( OutputType.FILE );

            System.out.println("snapshot saved to: " + theFile.getAbsolutePath() );

            driver.close();

            System.out.println("Driver is closed");
        }
        catch( Throwable e )
        {
            e.printStackTrace();
        }
    }

    public void testApp2()
    {
        try
        {
            Properties props = new Properties();
            props.load( Thread.currentThread().getContextClassLoader().getResourceAsStream( "test.properties" ));

            Tn3270TerminalDriver.StartupDetails details =
                new  Tn3270TerminalDriver.StartupDetails( props.getProperty("test.terminal.host"),
                                                          Integer.parseInt(props.getProperty("test.terminal.port")),
                                                          Integer.parseInt(props.getProperty("test.terminal.type")),
                                                          props.getProperty("test.app.start"),
                                                          props.getProperty("test.app.file"),
                                                          props.getProperty("test.app.name"),
                                                          props.getProperty("test.app.images"),
                                                          Boolean.parseBoolean(props.getProperty("test.terminal.visible")));

            Tn3270TerminalDriver driver = new Tn3270TerminalDriver( details );

            sleep(3000);

            WebElement element = driver.findElement( new By.ByXPath( "//screen[name='SystemBanner']/link[name='ack']" ));
            element.click();

            sleep(3000);

            element = driver.findElement( new By.ByXPath( "//screen[name='Login']/field[name='username']" ));
            element.sendKeys("$000");
            element = driver.findElement( new By.ByXPath( "//screen[name='Login']/field[name='password']" ));
            element.sendKeys("music");
            element.submit();

            sleep(3000);
            
            element = driver.findElement( new By.ByXPath( "//screen[name='ABlankScreen']/field[name='menu-entry']" ));
            element.sendKeys("admin");
            element.submit();

            sleep(3000);

            element = driver.findElement( new By.ByXPath( "//screen[name='AdminMenu']/field[name='option']" ));
            element.sendKeys("11");
            element.click();

            sleep(3000);

            element = driver.findElement( new By.ByXPath( "//screen[name='SystemHelpMenu']/link[name='internet']" ));
            element.click();

            sleep(3000);

            element = driver.findElement( new By.ByXPath( "//screen[name='InternetCommands']/field[name='option']" ));
            element.sendKeys("ping");
            element.click();

            sleep(3000);

            element = driver.findElement( new By.ByXPath( "//screen[name='PingDetails']/field[name='ping-syntax']" ));

            System.out.println( "Got text: " + element.getText() );

            java.io.File theFile = ((TakesScreenshot) driver).getScreenshotAs( OutputType.FILE );

            System.out.println("snapshot saved to: " + theFile.getAbsolutePath() );

            driver.close();

            System.out.println("Driver is closed");
        }
        catch( Throwable e )
        {
            e.printStackTrace();
        }
    }

    private void sleep( int duration )
        throws Exception 
    {
        Thread.currentThread().sleep( duration );
    }
}
