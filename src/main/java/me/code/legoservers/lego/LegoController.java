package me.code.legoservers.lego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin()
@RequestMapping("/")
public class LegoController {

    @Autowired
    private LegoService legoService;

    @PutMapping("/search/{themes}")
    public Collection search(@PathVariable("themes") String themes) {
           return legoService.getSearchLego(themes);
    }

    @GetMapping("/getAll")
    public Collection<Lego> getAll() {
            return legoService.getAll();
    }
}
