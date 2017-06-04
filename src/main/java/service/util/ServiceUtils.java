package service.util;

public class ServiceUtils {

    private ServiceUtils(){};

    public static final class RestUriConstants {
        public static final String GET_LOGIN = "/getLogin";
        public static final String SAVE_LOGIN = "/insertLogin";
        public static final String DELETE_LOGIN = "/deleteLogin";
        public static final String UPDATE_LOGIN = "/updateLogin";
        public static final String EXIST_LOGIN = "/existLogin";
        private RestUriConstants(){};
    }

    public static final class SecurityConstants {
        public static final String AUTHENTICATE_TYPE = "WWW-Authenticate";
        public static final String BASIC_REALM = "Basic realm=\"%s\"";
        public static final String REALM_NAME = "Services Realm";
        private SecurityConstants(){};
    }
}
