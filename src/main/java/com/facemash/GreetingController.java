package com.facemash;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;


@RestController
@RequestMapping
public class GreetingController {

    @RequestMapping(method = RequestMethod.POST, value = "/newelems")
    public String greeting(@RequestParam(value = "winner") Integer winner, @RequestParam(value = "looser") Integer looser) throws SQLException, ClassNotFoundException {
        Database database = new Database();
        database.changepicturerait(winner, true);
        database.changepicturerait(looser, false);
        return database.getlist().get(0).getWay() + " " + database.getlist().get(1).getWay();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/newelems")
    public ModelAndView greetinghey() {
        return new ModelAndView("/index.jsp");
    }
}
