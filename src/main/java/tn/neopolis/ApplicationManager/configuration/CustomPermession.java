package tn.neopolis.ApplicationManager.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import tn.neopolis.ApplicationManager.DTO.MyUserLogin;
import tn.neopolis.ApplicationManager.models.Privilege;
import tn.neopolis.ApplicationManager.models.User;

import java.io.Serializable;

@Configuration
@Component
public class CustomPermession implements PermissionEvaluator {



    @Override
    public boolean hasPermission(
            Authentication auth, Object targetDomainObject, Object permission) {
        if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)) {
            return false;
        }
        String targetType = targetDomainObject.getClass().getSimpleName().toUpperCase();

        return hasPrivilege(auth, targetType, permission.toString().toUpperCase());
    }

    @Override
    public boolean hasPermission(
            Authentication auth, Serializable targetId, String targetType, Object permission) {
        if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        }
        return hasPrivilege(auth, targetType.toUpperCase(),
                permission.toString().toUpperCase());
    }


    private boolean hasPrivilege(Authentication auth, String targetType, String permission) {
        User user = ((MyUserLogin) auth.getPrincipal()).getUser();
        for (Privilege privilege : user.getUprivileges()) {
            if (privilege.getName().toUpperCase().equals(permission)) {
                return true;
            }

        }
        return false;
    }

}

