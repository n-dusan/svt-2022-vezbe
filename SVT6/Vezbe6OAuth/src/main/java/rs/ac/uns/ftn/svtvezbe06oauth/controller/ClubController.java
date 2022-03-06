package rs.ac.uns.ftn.svtvezbe06oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.svtvezbe06oauth.model.Club;
import rs.ac.uns.ftn.svtvezbe06oauth.service.ClubService;

import java.util.List;

@RestController
@RequestMapping("clubs")
public class ClubController {

    @Autowired
    ClubService clubService;

    @GetMapping
    public ResponseEntity<List<Club>> getAll(){
        return new ResponseEntity<>(clubService.getAll(), HttpStatus.OK);
    }

}
