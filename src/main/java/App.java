import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/output", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String album = req.queryParams("album");
            String artist = req.queryParams("artist");
            String genre = req.queryParams("genre");
            model.put("album", album);
            model.put("artist", artist);
            model.put("genre", genre);
//            String stringCD = String.join("Album " + album + " Artist " + artist + " Genre " + genre);
            return new ModelAndView(model, "output.hbs");
        }, new HandlebarsTemplateEngine());
    }
}