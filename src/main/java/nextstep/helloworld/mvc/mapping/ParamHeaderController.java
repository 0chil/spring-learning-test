package nextstep.helloworld.mvc.mapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param-header")
public class ParamHeaderController {

    @GetMapping(value = "/message")
    public ResponseEntity<String> message() {
        return ResponseEntity.ok().body("message");
    }

    @GetMapping(value = "/message", params = "name=hello") // 파라미터 검사(값이 있는지, 지정된 값인지)
    public ResponseEntity<String> messageForParam() {
        return ResponseEntity.ok().body("hello");
    }

    @GetMapping(value = "/message", headers = "HEADER=hi") // 헤더 검사(값이 있는지, 지정된 값인지)
    public ResponseEntity<String> messageForHeader() {
        return ResponseEntity.ok().body("hi");
    }
}