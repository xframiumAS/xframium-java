/*******************************************************************************
 * xFramium
 *
 * Copyright 2016 by Moreland Labs, Ltd. (http://www.morelandlabs.com)
 *
 * Some open source application is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later version.
 *  
 * Some open source application is distributed in the hope that it will 
 * be useful, but WITHOUT ANY WARRANTY; without even the implied warranty 
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  
 * You should have received a copy of the GNU General Public License
 * along with xFramium.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPL-3.0+ <http://spdx.org/licenses/GPL-3.0+>
 *******************************************************************************/
package org.xframium.gesture.device.action.spi.perfecto;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.xframium.application.ApplicationDescriptor;
import org.xframium.application.ApplicationRegistry;
import org.xframium.exception.ScriptConfigurationException;
import org.xframium.gesture.device.action.AbstractDefaultAction;
import org.xframium.gesture.device.action.DeviceAction;
import org.xframium.integrations.perfectoMobile.rest.PerfectoMobile;
import org.xframium.integrations.perfectoMobile.rest.bean.Handset;

// TODO: Auto-generated Javadoc
/**
 * The Class OpenApplicationAction.
 */
public class OpenApplicationAction extends AbstractDefaultAction implements DeviceAction
{
	
	/* (non-Javadoc)
	 * @see com.perfectoMobile.gesture.device.action.AbstractDefaultAction#_executeAction(org.openqa.selenium.WebDriver, java.util.List)
	 */
	@Override
	public boolean _executeAction( WebDriver webDriver, List<Object> parameterList )
	{
		String executionId = getExecutionId( webDriver );
		String deviceName = getDeviceName( webDriver );
		
		String applicationName = (String) parameterList.get( 0 );

		ApplicationDescriptor appDesc = ApplicationRegistry.instance().getApplication( applicationName );
		
		if ( appDesc == null )
		    throw new ScriptConfigurationException( "The Application " + applicationName + " does not exist" );
	
		if ( appDesc.isWeb() )
		{
    		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
    		if ( webDriver.getWindowHandles() != null && webDriver.getWindowHandles().size() > 0 )
    		    webDriver.findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);
    		
    		webDriver.get( appDesc.getUrl() );
    		    
		}
		else
		{
    		Handset localDevice = PerfectoMobile.instance().devices().getDevice( deviceName );
    		
    		if ( localDevice.getOs().toLowerCase().equals( "ios" ) )				
    			PerfectoMobile.instance().application().open( executionId, deviceName, appDesc.getName(), appDesc.getAppleIdentifier() );
    		else if ( localDevice.getOs().toLowerCase().equals( "android" ) )
    			PerfectoMobile.instance().application().open( executionId, deviceName, appDesc.getName(), appDesc.getAndroidIdentifier() );
    		else
    			throw new IllegalArgumentException( "Could not install application to " + localDevice.getOs() );
    		
    		
    		if ( webDriver instanceof ContextAware )
    			( ( ContextAware ) webDriver ).context( "NATIVE_APP" );
		}
		return true;
	}

}
