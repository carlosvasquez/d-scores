package org.devdom.tracker.bean;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.devdom.tracker.model.dao.GroupRatingDao;
import org.devdom.tracker.model.dto.GroupInformation;

/**
 *
 * @author Carlos Vasquez Polanco
 */
public class GroupInformationController {
    
    private final GroupRatingDao dao = new GroupRatingDao();
    
    public GroupInformation getGroupInformation(){
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String,String> request = externalContext.getRequestParameterMap();
        
        String groupId = request.get("g");
        
        try {
            return dao.findGroupInformationById(groupId);
        } catch (Exception ex) {
            Logger.getLogger(GroupInformationController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}