package com.note.techNote;

import com.note.techNote.pricipal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechNoteApplication /*implements CommandLineRunner*/ {

	public static void main(String[] args) {
		SpringApplication.run(TechNoteApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal = new Principal();
//
//
//	}
}
