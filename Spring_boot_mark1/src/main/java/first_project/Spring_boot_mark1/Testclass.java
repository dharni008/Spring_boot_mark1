package first_project.Spring_boot_mark1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class Testclass {
    @GetMapping("/addTwoNum")
    public static int addTwoNum(@RequestParam int a, @RequestParam int b){
        return a+b;
    }
    @GetMapping("/mulTwoNum")
    public static int mulTwoNum(@RequestParam int a, @RequestParam int b){
        return a*b;
    }

}
