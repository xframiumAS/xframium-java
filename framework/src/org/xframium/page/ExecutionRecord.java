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
package org.xframium.page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class ExecutionRecord.
 */
public class ExecutionRecord
{
    private static DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss");
	/** The group. */
	private String group;
	
	/** The name. */
	private String name;
	
	/** The type. */
	private String type;
	
	/** The time stamp. */
	private long timeStamp;
	
	/** The run time. */
	private long runTime;
	
	/** The status. */
	private StepStatus status;
	
	/** The t. */
	private Throwable t;
	
	private boolean fromCache = false;

        private String deviceName;
	
	/**
	 * Instantiates a new execution record.
	 *
	 * @param group the group
	 * @param name the name
	 * @param type the type
	 * @param timeStamp the time stamp
	 * @param runTime the run time
	 * @param status the status
	 * @param detail the detail
	 * @param t the t
	 */
        public ExecutionRecord( String group, String name, String type, long timeStamp, long runTime, StepStatus status, String detail,
                            Throwable t, boolean fromCache, String deviceName )
	{
		super();
		this.group = group;
		this.name = name;
		this.type = type;
		this.timeStamp = timeStamp;
		this.runTime = runTime;
		this.status = status;
		this.detail = detail;
		this.t = t;
		this.fromCache = fromCache;
                this.deviceName = deviceName;
	}
	
	public boolean isFromCache()
    {
        return fromCache;
    }

    public void setFromCache( boolean fromCache )
    {
        this.fromCache = fromCache;
    }

    /**
	 * Gets the t.
	 *
	 * @return the t
	 */
	public Throwable getT()
	{
		return t;
	}

	/**
	 * Sets the t.
	 *
	 * @param t the new t
	 */
	public void setT( Throwable t )
	{
		this.t = t;
	}

	/**
	 * Checks if is status.
	 *
	 * @return true, if is status
	 */
	public StepStatus getStatus()
	{
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus( StepStatus status )
	{
		this.status = status;
	}

	/** The detail. */
	private String detail;
	
	/**
	 * Gets the group.
	 *
	 * @return the group
	 */
	public String getGroup()
	{
		return group;
	}
	
	/**
	 * Sets the group.
	 *
	 * @param group the new group
	 */
	public void setGroup( String group )
	{
		this.group = group;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName( String name )
	{
		this.name = name;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType( String type )
	{
		this.type = type;
	}
	
	/**
	 * Gets the time stamp.
	 *
	 * @return the time stamp
	 */
	public long getTimeStamp()
	{
		return timeStamp;
	}
	
	/**
	 * Sets the time stamp.
	 *
	 * @param timeStamp the new time stamp
	 */
	public void setTimeStamp( long timeStamp )
	{
		this.timeStamp = timeStamp;
	}
	
	/**
	 * Gets the run time.
	 *
	 * @return the run time
	 */
	public long getRunTime()
	{
		return runTime;
	}
	
	/**
	 * Sets the run time.
	 *
	 * @param runTime the new run time
	 */
	public void setRunTime( long runTime )
	{
		this.runTime = runTime;
	}
	
	/**
	 * Gets the detail.
	 *
	 * @return the detail
	 */
	public String getDetail()
	{
		return detail;
	}
	
	/**
	 * Sets the detail.
	 *
	 * @param detail the new detail
	 */
	public void setDetail( String detail )
	{
		this.detail = detail;
	}


    	/**
	 * Gets the device name.
	 *
	 * @return the device name
	 */
	public String getDeviceName()
	{
		return deviceName;
	}
	
	/**
	 * Sets the detail.
	 *
	 * @param val the device name
	 */
	public void setDeviceName( String val )
	{
		this.deviceName = val;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return group + "," + name + "," + type + "," + timeStamp + "," + runTime + "," + status + "," + detail;
	}
	
	/**
	 * To html.
	 *
	 * @return the string
	 */
	public String toHTML( int index )
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		String useGroup = group;
		if ( useGroup != null && !useGroup.isEmpty() )
			if ( name != null && !name.isEmpty() )
				useGroup = useGroup + "." + name;
		else
			if ( name != null && !name.isEmpty() )
				useGroup = name;
			else
				useGroup = "";
		
		
		stringBuffer.append( "<tr><td>" );	
		
		if ( status.equals( StepStatus.REPORT ) )
		    stringBuffer.append( useGroup.replace( "\t", "<br/>" ) );
		else
			stringBuffer.append( useGroup );
		
		String testRunLength = String.format( "%,.3f", (double)runTime / 1000.0 );
        
		
		stringBuffer.append( "</td><td>" ).append( type ).append( "</td>" );
		stringBuffer.append( "<td>" ).append( timeFormat.format( new Date( timeStamp ) ) + "(" + runTime + ")" ).append( "</td>" );
		
		String buttonType = "danger";
		switch( status )
        {
            case FAILURE:
                stringBuffer.append( "<td style=\"padding-top: 10px; \" align=\"center\"><span class=\"label label-danger\">Fail</span></td>" );
                break;
            case FAILURE_IGNORED:
                stringBuffer.append( "<td style=\"padding-top: 10px; \" align=\"center\"><span class=\"label label-warning\">Ignored</span></td>" );
                buttonType="warning";
                break;
            case REPORT:
                stringBuffer.append( "<td style=\"padding-top: 10px; \" align=\"center\"><span class=\"label label-info\">Information</span></td>" );
                break;  
            case SUCCESS:
                buttonType="success";
                if ( fromCache )
                    stringBuffer.append( "<td style=\"padding-top: 10px; \" align=\"center\"><span class=\"label label-success\">Pass</span></td>" );
                else
                    stringBuffer.append( "<td style=\"padding-top: 10px; \" align=\"center\"><span class=\"label label-success\"><b>Pass</b></span></td>" );
                break;
        }
		
		stringBuffer.append( "</tr>" );
		if ( !status.equals( StepStatus.SUCCESS ) && detail != null && !detail.isEmpty() )
		{
			String backgroundColor = "";
			
			
			stringBuffer.append( "<tr" ).append( backgroundColor ).append( "><td></td><td colspan=3><h6>" ).append( detail ).append( "</h6></td></tr>");
			if ( t != null )
			{
				stringBuffer.append( "<tr" ).append( backgroundColor ).append( "><td></td><td colSpan='3'><a class=\"btn btn-" + buttonType + "\" role=\"button\" data-toggle=\"collapse\" href=\"#exception").append( index ).append( "\" aria-expanded=\"false\">View Error Detail</a><div class=\"collapse\" id=\"exception").append( index  ).append( "\"><h6>" );
				
				stringBuffer.append( t.getMessage() ).append( "<br/>");
				for( StackTraceElement s : t.getStackTrace() )
					stringBuffer.append( "&nbsp;&nbsp;&nbsp;&nbsp;").append( s.toString() ).append( "<br/>");
				stringBuffer.append( "</h6></div></td></tr>");
				
			}
		}
		
		
		return stringBuffer.toString();
	}
	
}


