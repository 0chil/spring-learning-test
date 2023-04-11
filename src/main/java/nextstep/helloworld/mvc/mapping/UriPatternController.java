package nextstep.helloworld.mvc.mapping;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uri-pattern")
public class UriPatternController {

    @GetMapping("/users/{id}")
    public ResponseEntity<User> pathVariable(@PathVariable(name = "id") Long id) {
        User user = new User(id, "이름", "email");
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/patterns/{:[a,b]}")
    // REGEX는 {:REGEX} 로 사용한다. 이름은 {somename:REGEX} 식으로 쓸 수 있다 (PathVariable)
    public ResponseEntity<String> pattern() {
        return ResponseEntity.ok().body("pattern");
    }

    @GetMapping("/patterns/**")
    public ResponseEntity<String> patternStars() {
        return ResponseEntity.ok().body("pattern-multi");
    }
}