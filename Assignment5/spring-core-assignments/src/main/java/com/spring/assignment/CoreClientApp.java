package com.spring.assignment;

import com.spring.assignment.task1.Movie;
import com.spring.assignment.task2.DefaultMessage;
import com.spring.assignment.task3.DrawShape;
import com.spring.assignment.task4.ConstructorMessage;
import com.spring.assignment.task5.SetterMessage;
import com.spring.assignment.task6.Student;
import com.spring.assignment.task7.Player;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class CoreClientApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("========== TASK 1: Movie ==========");
        Movie movie = context.getBean("movie", Movie.class);
        movie.display();

        System.out.println("\n========== TASK 2: DefaultMessage ==========");
        DefaultMessage defMsg = context.getBean("defaultMessage", DefaultMessage.class);
        System.out.println("Default Message: " + defMsg.getMessage());

        System.out.println("\n========== TASK 3: Abstract Shape Injection ==========");
        DrawShape drawShape = context.getBean("drawShape", DrawShape.class);
        drawShape.draw();

        System.out.println("\n========== TASK 4: Constructor Injection ==========");
        ConstructorMessage cMsg = context.getBean("constructorMessage", ConstructorMessage.class);
        System.out.println("Constructor Injected: " + cMsg.getMessage());

        System.out.println("\n========== TASK 5: Setter Injection ==========");
        SetterMessage sMsg = context.getBean("setterMessage", SetterMessage.class);
        System.out.println("Setter Injected: " + sMsg.getMessage());

        System.out.println("\n========== TASK 6: Students and Tests ==========");
        Student st1 = context.getBean("student1", Student.class);
        Student st2 = context.getBean("student2", Student.class);
        st1.display();
        st2.display();

        System.out.println("\n========== TASK 7: Players & Filter by Country ==========");
        List<Player> players = Arrays.asList(
                context.getBean("player1", Player.class),
                context.getBean("player2", Player.class),
                context.getBean("player3", Player.class),
                context.getBean("player4", Player.class),
                context.getBean("player5", Player.class)
        );
        players.forEach(Player::display);

        String searchCountry = "India";
        System.out.println("\nPlayers from " + searchCountry + ":");
        players.stream()
                .filter(p -> p.getCountry().getCountryName().equalsIgnoreCase(searchCountry))
                .forEach(p -> System.out.println("- " + p.getPlayerName()));

        ((ClassPathXmlApplicationContext) context).close();
    }
}