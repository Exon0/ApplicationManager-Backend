package tn.neopolis.ApplicationManager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import tn.neopolis.ApplicationManager.models.Privilege;
import tn.neopolis.ApplicationManager.models.User;
import tn.neopolis.ApplicationManager.repositories.UserRepository;
import tn.neopolis.ApplicationManager.services.MyUserDetailsService;
import tn.neopolis.ApplicationManager.services.UserService;

import java.io.Serializable;
@Configuration
@Component
public class CustomPermession implements PermissionEvaluator {

    @Autowired
    @Qualifier("MyUserDetailsService")
    private MyUserDetailsService myUserDetailsService;//



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
        User user=(User) myUserDetailsService.loadUserByUsername("ilyes");
        for (Privilege privilege : user.getUprivileges()) {
            if (privilege.getName().startsWith(targetType) &&
                    privilege.getName().contains(permission)) {
                return true;
            }

        }
        return false;
    }

    }

