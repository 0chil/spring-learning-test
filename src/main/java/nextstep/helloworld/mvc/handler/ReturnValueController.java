package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

   @GetMapping("message")
   @ResponseBody // 응답이 메서드의 리턴과 일치한다
   public String string() {
       return "message";
   }

   @GetMapping("users")
   @ResponseBody
   public User responseBodyForUser() {
       return new User("name", "email");
   }

   @GetMapping("users/{id}")
   public ResponseEntity<User> responseEntity(@PathVariable Long id) {
       return ResponseEntity.ok(new User("name", "email"));
   }

   @GetMapping("members")
   public ResponseEntity<Object> responseEntityFor400() {
       return ResponseEntity.badRequest().build();
   }

   @GetMapping("thymeleaf")
   public String thymeleaf() {
       return "sample";
   }
}