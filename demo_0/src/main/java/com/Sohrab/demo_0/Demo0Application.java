package com.Sohrab.demo_0;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.Sohrab.demo_0.domain.Course;
import com.Sohrab.demo_0.domain.Professor;
import com.Sohrab.demo_0.domain.Student;
import com.Sohrab.demo_0.repositories.CourseRepository;
import com.Sohrab.demo_0.repositories.ProfessorRepository;
import com.Sohrab.demo_0.repositories.StudentRepository;
import com.Sohrab.demo_0.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Demo0Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo0Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository,
										CourseRepository courseRepository,
										StudentService studentService,
										ProfessorRepository professorRepository
	){
		return args -> {
		Student sohrab = new Student(
			"sohrab",
			"sheikh Mohammadi",
			"sohrab.sh2612@gmail.com",
			"1234"
		) ;
		Student saeed = new Student(
				"saeed",
				"ghorbani",
				"saeedghorbani@gmail.com",
				"5678"
		);
		studentRepository.saveAll(List.of(sohrab,saeed));

		Professor kamran = new Professor(
				"Arezoo",
				"kamran",
				"ar.kamran@gmail.com",
				"a1r1z1o1o1"
		);
		Course cad = new Course(
				"cad",
				"c1a1d1"

		);

		kamran.addCourse(cad);
		professorRepository.save(kamran);
		};
	}
}
