
package org.jasig.portal;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Map;
import java.util.List;

import org.xml.sax.helpers.AttributeListImpl;

import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;


/**
 * Filter incorporating channel and category attributes for the structure transformation
 * @author Peter Kharchenko
 * @version $Revision$
 */

public class StructureAttributesIncorporationFilter extends SAXFilterImpl 
{
    protected StructureStylesheetUserPreferences fsup;

    
    public StructureAttributesIncorporationFilter (DocumentHandler handler, StructureStylesheetUserPreferences prefs)
    { 
	super (handler); 
	this.fsup=prefs;
    }
    
    public void startElement (java.lang.String name, org.xml.sax.AttributeList atts) throws SAXException 
    {
	// recognizing "channel"   
	if (name.equals ("channel")) {
	    List al=fsup.getChannelAttributeNames();
	    if(al.size()>0) {
		AttributeListImpl attsImpl=new AttributeListImpl(atts);
		String channelID = attsImpl.getValue ("ID");
		
		for(int i=0;i<al.size();i++) {
		    String attrName=(String) al.get(i);
		    attsImpl.addAttribute(attrName,"CDATA",fsup.getChannelAttributeValue(channelID,attrName));
		    Logger.log(Logger.DEBUG,"adding attribute to channel="+channelID+" "+attrName+"="+fsup.getChannelAttributeValue(channelID,attrName));
		}
		super.startElement(name,attsImpl);
	    }
	} else 	if (name.equals ("category")) {
	    List al=fsup.getCategoryAttributeNames();
	    if(al.size()>0) {
		AttributeListImpl attsImpl=new AttributeListImpl(atts);
		String categoryID = attsImpl.getValue ("ID");
		for(int i=0;i<al.size();i++) {
		    String attrName=(String) al.get(i);
		    attsImpl.addAttribute(attrName,"CDATA",fsup.getCategoryAttributeValue(categoryID,attrName));
		    Logger.log(Logger.DEBUG,"adding attribute to category="+categoryID+" "+attrName+"="+fsup.getCategoryAttributeValue(categoryID,attrName));
		}
		super.startElement(name,attsImpl);
	    }

	} else 
	    super.startElement (name, atts);
    }
}

