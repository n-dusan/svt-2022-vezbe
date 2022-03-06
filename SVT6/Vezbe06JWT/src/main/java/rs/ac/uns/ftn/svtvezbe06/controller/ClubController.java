package rs.ac.uns.ftn.svtvezbe06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.svtvezbe06.model.entity.Club;
import rs.ac.uns.ftn.svtvezbe06.service.ClubService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clubs")
public class ClubController {

    @Autowired
    ClubService clubService;

    @GetMapping
    public ResponseEntity<List<Club>> getAll(){
        return new ResponseEntity<>(clubService.getAll(), HttpStatus.OK);
    }

    //Ovo je primer za hasAnyRole, ali, ako cemo navesti SVE role koje imamo u sistemu,
    //nema potrebe uopste da navodimo role.
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Club> getOne(@PathVariable Long id){
        Optional<Club> club = clubService.getById(id);
        if(club.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(club.get(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Club> create(@RequestBody Club club){
        Club createdClub= clubService.save(club);
        if(createdClub == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(createdClub, HttpStatus.OK);
    }
}
