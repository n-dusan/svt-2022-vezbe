package rs.ac.uns.ftn.svtvezbe04.primer02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rs.ac.uns.ftn.svtvezbe04.primer02.entity.Gorivo;
import rs.ac.uns.ftn.svtvezbe04.primer02.entity.Menjac;
import rs.ac.uns.ftn.svtvezbe04.primer02.entity.Vozilo;
import rs.ac.uns.ftn.svtvezbe04.primer02.service.GorivoService;
import rs.ac.uns.ftn.svtvezbe04.primer02.service.MenjacService;
import rs.ac.uns.ftn.svtvezbe04.primer02.service.VoziloService;

import java.util.Date;

@Controller
public class TestController {

    @Autowired
    private GorivoService gorivoService;

    @Autowired
    private MenjacService menjacService;

    @Autowired
    private VoziloService voziloService;

    @GetMapping("/")
    @ResponseBody
    public String test() {
        Gorivo dizel = new Gorivo();
        dizel.setTipGoriva("dizel");

        Gorivo benzin = new Gorivo();
        benzin.setTipGoriva("benzin");

        dizel = gorivoService.save(dizel);

        benzin = gorivoService.save(benzin);

        Menjac automatski = new Menjac();
        automatski.setTipMenjaca("automatski");

        Menjac rucni = new Menjac();
        rucni.setTipMenjaca("rucni");

        rucni = menjacService.save(automatski);
        rucni = menjacService.save(rucni);

        Vozilo fiatPunto = new Vozilo(5, 5, 3, 4500, new Date(), 1999, benzin, 1000, rucni, "Fiat Punto", 90000l, 60, 1200, false);
        Vozilo zastavaYugo = new Vozilo(5, 4, 3, 1200, new Date(), 1989, benzin, 900, rucni, "Zastava Yugo", 97000l, 45, 726, false);

        fiatPunto = voziloService.save(fiatPunto);
        zastavaYugo = voziloService.save(zastavaYugo);

        System.out.println("Entities persisted:\n" + dizel + "\n" + benzin);

        System.out.println("Entities persisted:\n" + fiatPunto + "\n" + zastavaYugo);

        return "Select * from gorivo";
    }

}
