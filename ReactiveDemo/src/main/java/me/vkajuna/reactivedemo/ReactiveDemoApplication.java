package me.vkajuna.reactivedemo;

import me.vkajuna.reactivedemo.student.Student;
import me.vkajuna.reactivedemo.student.StudentRepository;
import me.vkajuna.reactivedemo.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            for (int i = 0; i < 3000; i++) {
                repository.save(
                Student.builder().firstname("Valence" + i)
                        .lastname("Kajuna" +i)
                        .age(i)
                        .build()
                ).subscribe();
            }
        };
    }
}
