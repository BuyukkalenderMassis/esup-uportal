<%--

    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License. You may obtain a
    copy of the License at:

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on
    an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied. See the License for the
    specific language governing permissions and limitations
    under the License.

--%>

<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!-- START: VALUES BEING PASSED FROM BACKEND -->

<%@page import="org.jasig.portal.spring.PortalApplicationContextLocator"%>


<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.jasig.portal.api.portlet.PortletDelegationLocator"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="org.jasig.portal.portlet.om.IPortletWindowId"%>
<%@page import="org.jasig.portal.api.portlet.PortletDelegationDispatcher"%>
<%@page import="org.jasig.portal.api.portlet.DelegateState"%>
<%@page import="org.jasig.portal.channels.portlet.IPortletAdaptor"%>
<%@page import="org.jasig.portal.api.portlet.DelegationRequest"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Arrays"%>



<portlet:actionURL var="navigationUrl">
    <portlet:param name="execution" value="${flowExecutionKey}" />
</portlet:actionURL>
<!-- END: VALUES BEING PASSED FROM BACKEND -->

<!--
PORTLET DEVELOPMENT STANDARDS AND GUIDELINES
| For the standards and guidelines that govern
| the user interface of this portlet
| including HTML, CSS, JavaScript, accessibilty,
| naming conventions, 3rd Party libraries
| (like jQuery and the Fluid Skinning System)
| and more, refer to:
| http://www.ja-sig.org/wiki/x/cQ
-->
    
<!-- Portlet -->
<div class="fl-widget portlet" role="section">

  <!-- Portlet Title -->
  <div class="fl-widget-titlebar portlet-title" role="sectionhead">
    <h2 role="heading">
      <spring:message code="edit-portlet.configMode"/>
    </h2>
  </div> <!-- end: portlet-title -->
  
  <!-- Portlet Body -->
  <div class="fl-widget-content portlet-body" role="main">
    <up:render-delegate fname="${CHANNEL_FNAME}" portletMode="CONFIG">
        <up:parent-url>
            <up:param name="execution" value="${flowExecutionKey}"/>
            <up:param name="_eventId" value="configModeAction"/>
        </up:parent-url>
    </up:render-delegate>
    
  </div> <!-- end: portlet-body -->
  
</div> <!-- end: portlet -->