/* Copyright 2002 The JA-SIG Collaborative.  All rights reserved.
*  See license distributed with this file and
*  available online at http://www.uportal.org/license.html
*/

package org.jasig.portal.layout.restrictions.alm;


import org.jasig.portal.layout.node.ILayoutNode;
import org.jasig.portal.layout.node.IUserLayoutNodeDescription;

/**
 * HiddenRestriction checks the restriction on the "hidden" property for a given ALNode object.
 * 
 * Prior to uPortal 2.5, this class existed in the package org.jasig.portal.layout.restrictions.
 * It was moved to its present package to reflect that it is part of Aggregated Layouts.
 *
 * @author <a href="mailto:mvi@immagic.com">Michael Ivanov</a>
 * @version $Revision$
 */
public class HiddenRestriction extends BooleanRestriction {


         public HiddenRestriction(String name,String nodePath) {
           super(name,nodePath);
         }

         public HiddenRestriction(String name) {
           super(name);
         }

         public HiddenRestriction() {
            super();
         }

         
         /**
           * Gets the boolean property value for the specified node
         */
         protected boolean getBooleanPropertyValue( ILayoutNode node ) {
           IUserLayoutNodeDescription nodeDesc = node.getNodeDescription();
           return nodeDesc.isHidden();
         }


}