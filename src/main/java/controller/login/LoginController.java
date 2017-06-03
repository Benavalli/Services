package controller.login;

import data.model.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.login.LoginService;
import service.util.ServiceUtils;
import org.apache.log4j.Logger;

@RestController
@RequestMapping(produces = "application/json")
public class LoginController {

    static Logger log = Logger.getLogger(LoginController.class.getName());

    @Autowired
    LoginService loginService;

    @RequestMapping(value = ServiceUtils.RestUriConstants.EXIST_LOGIN, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity getLogin(@RequestParam(value="loginName", required = true) String loginName,
                          @RequestParam(value="password", required = true) String password){

        log.info("Init getLogin for: ".concat(loginName));
        Login login = loginService.getLogin(loginName, password);

       if(login != null) {
           return new ResponseEntity(login, HttpStatus.ACCEPTED);
       }

       return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = ServiceUtils.RestUriConstants.SAVE_LOGIN,  method = RequestMethod.POST)
    public ResponseEntity insertLogin(@RequestBody Login login) {
        log.info("Init insertLogin");
        loginService.insertLogin(login);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = ServiceUtils.RestUriConstants.UPDATE_LOGIN,  method = RequestMethod.POST)
    public ResponseEntity updateLogin(@RequestBody Login login) {
        log.info("Init updateLogin");
        loginService.updateLogin(login);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = ServiceUtils.RestUriConstants.DELETE_LOGIN,  method = RequestMethod.POST)
    public ResponseEntity deleteLogin(@RequestBody Login login) {
        log.info("Init deleteLogin");
        loginService.deleteLogin(login);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = ServiceUtils.RestUriConstants.EXIST_LOGIN,  method = RequestMethod.GET)
    public ResponseEntity existLogin(@RequestParam(value="loginName", required = true) String loginName) {
        log.info("Init existLogin for: ".concat(loginName));
        if(loginService.existLogin(loginName)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
