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
package org.xframium.integrations.perfectoMobile.rest.bean;

import org.xframium.integrations.rest.bean.AbstractBean;
import org.xframium.integrations.rest.bean.Bean.BeanDescriptor;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageExecution.
 */
@BeanDescriptor( beanName="response" )
public class ImageExecution extends AbstractBean
{
	
	/** The width. */
	@FieldDescriptor ( fieldPath="screenAnalysis.resultRegion.width" )
	private String width;
	
	/** The height. */
	@FieldDescriptor ( fieldPath="screenAnalysis.resultRegion.width" )
	private String height;

	/** The grade. */
	@FieldDescriptor ( fieldPath="screenAnalysis.grade" )
	private String grade;
	
	/** The status. */
	@FieldDescriptor ( fieldPath="returnValue" )
	private String status;
	
	@FieldDescriptor ( fieldPath="screenAnalysis.resultRegion.top" )
    private String top;
	
	@FieldDescriptor ( fieldPath="screenAnalysis.resultRegion.left" )
    private String left;
	
	@FieldDescriptor ( fieldPath="screenAnalysis.analyzedRegion.width" )
    private String screenWidth;
	
	@FieldDescriptor ( fieldPath="screenAnalysis.analyzedRegion.height" )
    private String screenHeight;
	
	

	public String getScreenWidth()
    {
        return screenWidth;
    }

    public void setScreenWidth( String screenWidth )
    {
        this.screenWidth = screenWidth;
    }

    public String getScreenHeight()
    {
        return screenHeight;
    }

    public void setScreenHeight( String screenHeight )
    {
        this.screenHeight = screenHeight;
    }

    /**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public String getWidth()
	{
		return width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public String getHeight()
	{
		return height;
	}

	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public String getGrade()
	{
		return grade;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth( String width )
	{
		this.width = width;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight( String height )
	{
		this.height = height;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade( String grade )
	{
		this.grade = grade;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus( String status )
	{
		this.status = status;
	}

	public String getTop()
    {
        return top;
    }

    public void setTop( String top )
    {
        this.top = top;
    }

    public String getLeft()
    {
        return left;
    }

    public void setLeft( String left )
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return "ImageExecution [width=" + width + ", height=" + height + ", grade=" + grade + ", status=" + status + ", top=" + top + ", left=" + left + ", screenWidth=" + screenWidth + ", screenHeight=" + screenHeight + "]";
    }

	
	
	
	

}
