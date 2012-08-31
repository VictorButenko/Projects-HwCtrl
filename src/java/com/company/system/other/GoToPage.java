

package com.company.system.other;

/**
 *
 * @author ---GPL---
 * 
 * The class for storing url's of the pages.
 * If it looks like 'page.xhtml', so a client will be
 * FORWARDING to the page 'page.xhml'. 
 * In the other case, if it looks like: 'page.xhtml?faces-redirect=true' - 
 * a client will be REDIRECTING to this page.
 */
public final class GoToPage {
    
    //The main page. main.xhtml (using redirecting)
    public static final String main           = "main.xhtml?faces-redirect=true";
    public static final String infrastructure = "infrastructure.xhtml?faces-redirect=true";
    // The pages for creating new Persons 
    public static final String createLTc      =  "createLeadTc.xhtml?faces-redirect=true";
    public static final String createPartner  =  "createPartner.xhtml?faces-redirect=true";
    public static final String createWorker    =  "createWorker.xhtml?faces-redirect=true";
    public static final String createErid     =  "createErid.xhtml?faces-redirect=true";
    //Forwarding
    public static final String forwardWorker   =  "createWorker.xhtml";
    public static final String forwardPartner =  "createPartner.xhtml";
    public static final String forwardLeadTc  =  "createLeadTc.xhtml";
    public static final String forwardErid    =  "createErid.xhtml";
    
    //For HW
    public static final String createMM   =  "createMM.xhtml?faces-redirect=true";
    public static final String forwardMM  =  "createMM.xhtml";
    public static final String createBC   =  "createBC.xhtml?faces-redirect=true";
    
}
