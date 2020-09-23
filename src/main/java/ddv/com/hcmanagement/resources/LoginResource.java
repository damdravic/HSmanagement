package ddv.com.hcmanagement.resources;

import ddv.com.hcmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@CrossOrigin
@RestController
public class LoginResource {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping("/token")
    public Map<String ,String> token(HttpSession session , HttpServletRequest request){
        System.out.println(request.getRemoteHost());

        String remoteHost = request.getRemoteHost();
        int portNumber = request.getRemotePort();
        System.out.println(remoteHost +":" + portNumber);
        System.out.println(request.getRemoteAddr());

        return Collections.singletonMap("token",session.getId());
    }

    @CrossOrigin
    @RequestMapping("/checkSession")
    public ResponseEntity checkSession(){


        System.out.println(" step 6");

        return new ResponseEntity("SessionActive !", HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("user/logout")
    public ResponseEntity logout(){
        SecurityContextHolder.clearContext();
        System.out.println(" step 7");

        return new ResponseEntity("Logout Successfully",HttpStatus.OK);
    }




}
