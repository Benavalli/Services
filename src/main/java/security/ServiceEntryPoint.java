package security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import service.util.ServiceUtils;

@Component
public class ServiceEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.addHeader(ServiceUtils.SecurityConstants.AUTHENTICATE_TYPE,
                String.format(ServiceUtils.SecurityConstants.BASIC_REALM, getRealmName()));
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(ServiceUtils.SecurityConstants.REALM_NAME);
    }
}