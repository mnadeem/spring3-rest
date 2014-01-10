package com.nadeem.app.rest.support;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author xprk075 (Nadeem Mohammad)
 */

@Aspect
public class UserRoleAuthorizationAspect
{

    @Before(value = "execution(* *(..)) && @annotation(rolesAllowed)", argNames = "joinPoint,rolesAllowed")
    public final void authorize(final JoinPoint joinPoint, final RolesAllowed rolesAllowed)
    {
        HttpServletRequest request = getHttpServletRequest();
        if (shouldAuthorize(rolesAllowed))
        {
            if (!isUserAuthorized(request, rolesAllowed.value()))
            {
                throw new UnauthorizedError();
            }
        }
    }

    private HttpServletRequest getHttpServletRequest()
    {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    private boolean shouldAuthorize(final RolesAllowed rolesAllowed)
    {
        return rolesAllowed != null && rolesAllowed.value().length != 0;
    }

    private boolean isUserAuthorized(final HttpServletRequest request, final String[] roles)
    {
        for (String role : roles) {
            if (request.isUserInRole(role)) {
                return true;
            }
        }
        return false;
    }
}
