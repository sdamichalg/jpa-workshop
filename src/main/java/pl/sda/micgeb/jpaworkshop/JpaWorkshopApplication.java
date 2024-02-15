package pl.sda.micgeb.jpaworkshop;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.micgeb.jpaworkshop.repository.EmployeeRepository;
import pl.sda.micgeb.jpaworkshop.service.InitService;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaWorkshopApplication implements CommandLineRunner {

    private final InitService initService;

    public static void main(String[] args) {
        SpringApplication.run(JpaWorkshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initService.createSimpleData();
    }
}
