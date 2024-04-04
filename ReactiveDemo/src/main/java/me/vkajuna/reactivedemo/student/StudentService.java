package me.vkajuna.reactivedemo.student;

import io.r2dbc.spi.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Mono<Student> save (Student student){
        return repository.save(student);
    }
    public Flux<Student> findAll(){
        return repository
                .findAll().delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findById(Integer id){
        return repository.findById(id);
    }
}
