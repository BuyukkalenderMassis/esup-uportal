/**
 * Copyright (c) 2000-2009, Jasig, Inc.
 * See license distributed with this file and available online at
 * https://www.ja-sig.org/svn/jasig-parent/tags/rel-10/license-header.txt
 */

package org.jasig.portal.portlets.registerportal;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Eric Dalquist
 * @version $Revision$
 */
public class PortalRegistrationHelper {
    protected final Log logger = LogFactory.getLog(this.getClass());
    
    private IPortalDataCollator portalDataCollator;
    
    /**
     * @param portalDataCollator the portalDataCollator to set
     */
    public void setPortalDataCollator(IPortalDataCollator portalDataCollator) {
        this.portalDataCollator = portalDataCollator;
    }

    public PortalRegistrationRequest createRegistrationRequest() {
        final Map<String, String> dataToSubmit = new LinkedHashMap<String, String>();
        
        final Set<String> possibleDataKeys = this.portalDataCollator.getPossibleDataKeys();
        for (final String possibleDataKey : possibleDataKeys) {
            dataToSubmit.put(possibleDataKey, Boolean.TRUE.toString());
        }
        
        final PortalRegistrationRequest registrationRequest = new PortalRegistrationRequest();
        registrationRequest.setDataToSubmit(dataToSubmit);
        
        return registrationRequest;
    }
    
    public PortalRegistrationData getRegistrationData(PortalRegistrationRequest registrationRequest) {
        this.logger.debug(registrationRequest);
        
        final PortalRegistrationData registrationData = new PortalRegistrationData();
        registrationData.setDeployerAddress(registrationRequest.getDeployerAddress());
        registrationData.setDeployerName(registrationRequest.getDeployerName());
        registrationData.setInstitutionName(registrationRequest.getInstitutionName());
        registrationData.setPortalName(registrationRequest.getPortalName());
        registrationData.setPortalUrl(registrationRequest.getPortalUrl());
        registrationData.setShareInfo(registrationRequest.isShareInfo());
        
        final Set<String> dataToCollect = new LinkedHashSet<String>();
        final Map<String, String> dataToSubmit = registrationRequest.getDataToSubmit();
        for (final Map.Entry<String, String> dataToSubmitEntry : dataToSubmit.entrySet()) {
            if (Boolean.parseBoolean(dataToSubmitEntry.getValue())) {
                dataToCollect.add(dataToSubmitEntry.getKey());
            }
        }
        
        final Map<String, Object> collectedData = this.portalDataCollator.getCollectedData(dataToCollect);
        registrationData.setCollectedData(collectedData);
        
        return registrationData;
    }
    
    public void submitRegistration(PortalRegistrationData portalRegistrationData) {
        //TODO figure out how to submit data?
    }
}