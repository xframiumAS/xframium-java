package org.xframium.examples.java.test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.xframium.artifact.AbstractArtifact;
import org.xframium.artifact.ArtifactManager;
import org.xframium.artifact.ArtifactTime;
import org.xframium.device.factory.DeviceWebDriver;
import org.xframium.device.ng.AbstractJavaTest;
import org.xframium.device.ng.TestContainer;
import org.xframium.device.ng.TestName;
import org.xframium.device.ng.TestPackage;
import org.xframium.driver.ConfigurationReader;
import org.xframium.driver.TXTConfigurationReader;
import org.xframium.driver.XMLConfigurationReader;
import org.xframium.examples.java.page.WebHomePage;
import org.xframium.page.StepStatus;
import org.xframium.page.keyWord.KeyWordPage;
import org.xframium.page.keyWord.step.spi.KWSCompare2.CompareType;
import org.xframium.reporting.ExecutionContextStep;

public class WebHome extends AbstractJavaTest
{
    
    //
    // A sample artifact class demonstrating the ability to create and link your own artifacts
    //
    public static class WebHomeArtifact extends AbstractArtifact
    {
        
        public WebHomeArtifact()
        {
            //
            // Starting with TAB_ adds a new tab to the report. Neither creates the artifact but does not link it 
            //
            setArtifactType( "TAB_WEBHOME" );
        }
        
        private void addStep( ExecutionContextStep step, StringBuilder stepMap, String indentAppend )
        {
            stepMap.append( indentAppend ).append( step.getStep().getName() ).append( "(" ).append(  step.getStep().getKw() ).append( ")" ).append( "\r\n" );
            if ( step.getStepList() != null && !step.getStepList().isEmpty() )
            {
                String newAppend = indentAppend + "   ";
                for ( ExecutionContextStep s : step.getStepList() )
                {
                    addStep( s, stepMap, newAppend );
                }
            }
        }

        @Override
        protected File _generateArtifact( File rootFolder, DeviceWebDriver webDriver ) throws Exception
        {
            StringBuilder stepMap = new StringBuilder();
            
            for ( ExecutionContextStep s : webDriver.getExecutionContext().getStepList() )
            {
                addStep( s, stepMap, "" );
            }

            return writeToDisk( rootFolder, "webHomeArtifact.txt", stepMap.toString().getBytes() );

        }
    }
    
    
    /**
     * The class that configuration your setupSuite method should contain a reference to the ConfigurationReader. This will be used by
     * the afterSuite method to cleanup up the code
     */
    private static ConfigurationReader cR = null;
    
    /**
     * The setupSuite method allows you to use the xFramium configuration XML or property file.
     */
    @BeforeSuite
    public void setupSuite( ITestContext tC )
    {
        //
        // Register our Test Artifact
        //
        
        ArtifactManager.instance().registerArtifact( ArtifactTime.AFTER_TEST, "TAB_WEBHOME", WebHomeArtifact.class );

        //
        // Specify your xFramium configuration file here as TXT or XML
        //
        
        File configurationFile = new File( "resources\\driverConfig.xml" );
        System.out.println( configurationFile.getAbsolutePath() );
        
        if ( configurationFile.getName().toLowerCase().endsWith( ".xml" ) )
            cR = new XMLConfigurationReader();
        else if ( configurationFile.getName().toLowerCase().endsWith( ".txt" ) )
            cR = new TXTConfigurationReader();
        cR.readConfiguration( configurationFile, false );
        
    }
    
    /**
     * The afterAuite method will clean up and generate the necessary artifacts
     */
    @AfterSuite
    public void afterSuite()
    {
       cR.afterSuite();
    }
    
    
    
    /**
     * This is the FULL xFramium java implementation with custom page objects tied to the backend configuration
     * @param testContainer
     * @throws Exception
     */
    @Test( dataProvider = "deviceManager")
    public void testXFramiumWithJavaPOM( TestContainer testContainer ) throws Exception
    {
        //
        // Get access to the test and device
        //
        TestPackage testPackage = testPackageContainer.get();      
        TestName testName = testPackage.getTestName();
        
        //
        // Create the Page proxy class
        //
        DeviceWebDriver webDriver = testPackage.getConnectedDevice().getWebDriver();
        WebHomePage wPage = (WebHomePage) createPage( WebHomePage.class, webDriver );
        
        //
        // Optionally start a step container to allowing for reporting structure
        //
        startStep( testName, "Step One", "Testing the Toggle Button" );
        String beforeClick = wPage.getElement( WebHomePage.TOGGLE_VALUE ).getValue();
        wPage.getElement( WebHomePage.TOGGLE_BUTTON ).click();
        String afterClick = wPage.getElement( WebHomePage.TOGGLE_VALUE ).getValue();
        
        
        
        Assert.assertTrue( (Boolean) executeStep( "COMPARE2", "Step One", CompareType.STRING.name(), new String[] { "Value One==" + beforeClick, "Value Two==" + afterClick }, webDriver ).get( "RESULT" ) );
        dumpState( webDriver );
        
        stopStep( testName, StepStatus.SUCCESS, null );
        
        startStep( testName, "Step Two", "Testing Attributes" );
        String typeAttribute = wPage.getElement( WebHomePage.TOGGLE_BUTTON ).getAttribute( "type" );
        Assert.assertTrue( (Boolean) executeStep( "COMPARE2", "Step One", CompareType.STRING.name(), new String[] { "Value One==" + typeAttribute, "Value Two==button" }, webDriver ).get( "RESULT" ) );
        stopStep( testName, StepStatus.SUCCESS, null );
        dumpState( webDriver, "afterAttribute", 5, 5 );
        
        startStep( testName, "Step Three", "Testing Wait For" );
        Assert.assertFalse( wPage.getElement( WebHomePage.DELETE_BUTTON ).isVisible() );
        wPage.getElement( WebHomePage.ACCORDIAN_OPEN ).click();
        Assert.assertTrue( wPage.getElement( WebHomePage.DELETE_BUTTON ).waitForVisible( 12, TimeUnit.SECONDS ) );
        stopStep( testName, StepStatus.SUCCESS, null );
        dumpState( webDriver, "afterWaitFor", 2, 5 );

    }
    
    /**
     * This is the xFramium java implementation with synthetic page objects tied to the backend configuration.  In this mode, you do not need to create your Java page objects
     * @param testContainer
     * @throws Exception
     */
    @Test( dataProvider = "deviceManager")
    public void testXFramiumWithKWPOM( TestContainer testContainer ) throws Exception
    {
        //
        // Get access to the test and device
        //
        TestPackage testPackage = testPackageContainer.get();      
        TestName testName = testPackage.getTestName();
        
        //
        // Create the Page proxy class
        //
        DeviceWebDriver webDriver = testPackage.getConnectedDevice().getWebDriver();
        KeyWordPage wPage = (KeyWordPage) createPage( "home", webDriver );
        
        //
        // Optionally start a step container to allowing for reporting structure
        //
        startStep( testName, "Step One", "Testing the Toggle Button" );
        String beforeClick = wPage.getElement( WebHomePage.TOGGLE_VALUE ).getValue();
        wPage.getElement( WebHomePage.TOGGLE_BUTTON ).click();
        String afterClick = wPage.getElement( WebHomePage.TOGGLE_VALUE ).getValue();
        Assert.assertFalse( (Boolean) executeStep( "COMPARE2", "Step One", CompareType.STRING.name(), new String[] { "Value One==" + beforeClick, "Value Two==" + afterClick }, webDriver ).get( "RESULT" ) );
        dumpState( webDriver );
        
        stopStep( testName, StepStatus.SUCCESS, null );
        
        startStep( testName, "Step Two", "Testing Attributes" );
        String typeAttribute = wPage.getElement( WebHomePage.TOGGLE_BUTTON ).getAttribute( "type" );
        Assert.assertTrue( (Boolean) executeStep( "COMPARE2", "Step One", CompareType.STRING.name(), new String[] { "Value One==" + typeAttribute, "Value Two==button" }, webDriver ).get( "RESULT" ) );
        stopStep( testName, StepStatus.SUCCESS, null );
        dumpState( webDriver, "afterAttribute", 5, 5 );
        
        startStep( testName, "Step Three", "Testing Wait For" );
        Assert.assertFalse( wPage.getElement( WebHomePage.DELETE_BUTTON ).isVisible() );
        wPage.getElement( WebHomePage.ACCORDIAN_OPEN ).click();
        Assert.assertTrue( wPage.getElement( WebHomePage.DELETE_BUTTON ).waitForVisible( 12, TimeUnit.SECONDS ) );
        stopStep( testName, StepStatus.SUCCESS, null );
        dumpState( webDriver, "afterWaitFor", 2, 5 );

    }
    
    /**
     * xFramium can be used with the standard Selenium and Appium interfaces.  Use the TestContainer and TestPackge as descriped below as well
     * as the hook into the internal reporting system
     * @param testContainer
     * @throws Exception
     */
    
    @Test( dataProvider = "deviceManager" )
    public void testNativeSeleniumAppium( TestContainer testContainer ) throws Exception
    {
        //
        // Get access to the test and device
        //
        TestPackage testPackage = testPackageContainer.get();      
        TestName testName = testPackage.getTestName();
        
        //
        // Enable some basic reporting
        //
        DeviceWebDriver webDriver = testPackage.getConnectedDevice().getWebDriver();
        webDriver.setReportingElement( true );
        
        
        //
        // Optionally start a step container to allowing for reporting structure
        //
        startStep( testName, "Step One", "Testing the Toggle Button" );
        String beforeClick = webDriver.findElement( By.id( "singleModel" ) ).getText();
        webDriver.findElement( By.xpath( "//button[text()='Toggle Value']" ) ).click();
        String afterClick = webDriver.findElement( By.id( "singleModel" ) ).getText();
        
        Assert.assertTrue( false );
        
        Assert.assertFalse( (Boolean) executeStep( "COMPARE2", "Step One", CompareType.STRING.name(), new String[] { "Value One==" + beforeClick, "Value Two==" + afterClick }, webDriver ).get( "RESULT" ) );
        dumpState( webDriver );
        
        
        
        stopStep( testName, StepStatus.SUCCESS, null );
        
        startStep( testName, "Step Two", "Testing Attributes" );
        String typeAttribute = webDriver.findElement( By.xpath( "//button[text()='Toggle Value']" ) ).getAttribute( "type" );
        Assert.assertTrue( (Boolean) executeStep( "COMPARE2", "Step One", CompareType.STRING.name(), new String[] { "Value One==" + typeAttribute, "Value Two==button" }, webDriver ).get( "RESULT" ) );
        stopStep( testName, StepStatus.SUCCESS, null );
        dumpState( webDriver, "afterAttribute", 5, 5 );
        
        startStep( testName, "Step Three", "Testing Wait For" );
        Assert.assertFalse( webDriver.findElement( By.id( "deleteButton" ) ).isDisplayed() );
        webDriver.findElement( By.xpath( "//div[@id='aOpen']//a" ) ).click();
        Assert.assertTrue( new WebDriverWait( webDriver, 12 ).ignoring( NotFoundException.class ).until( ExpectedConditions.visibilityOfElementLocated( By.id( "deleteButton" ) ) ).isDisplayed() );
        stopStep( testName, StepStatus.SUCCESS, null );
        dumpState( webDriver, "afterWaitFor", 2, 5 );

    }
    
    
}