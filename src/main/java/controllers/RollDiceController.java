package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rolldice(){
        return "dice/roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public  String rollDiceGuess(@PathVariable int guess, Model model){
        String message;
        int random = (int) Math.ceil(Math.random() * 6);

        if (random == guess) {
            message = "You guessed the right random number!";
        } else {
            message = "Sorry, your guess was wrong,  please try again";
        }
        model.addAttribute("message", message);
        model.addAttribute("guess", guess);
        model.addAttribute("random", random);

        return "dice/roll-dice-guess";
    }
}
