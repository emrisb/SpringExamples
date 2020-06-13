package com.emreisbarali;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "My Pet API Documentation")
public class PetController {

    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init() {
        petList.add(new Pet(1, "asd", new Date()));
    }

    @PostMapping
    @ApiOperation(value = "New pet addition method", notes = "Be careful in use")
    public ResponseEntity<Pet> save(@RequestBody @ApiParam(value = "animal") Pet pet) {
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping()
    @ApiOperation(value = "Pet list method", notes = "This method brings all data")
    public ResponseEntity<List<Pet>> listAll() {
        return ResponseEntity.ok(petList);
    }

}
