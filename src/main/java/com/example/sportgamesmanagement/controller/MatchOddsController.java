package com.example.sportgamesmanagement.controller;

import com.example.sportgamesmanagement.dto.MatchOddsDTO;
import com.example.sportgamesmanagement.model.Match;
import com.example.sportgamesmanagement.model.MatchOdds;
import com.example.sportgamesmanagement.service.MatchOddsService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

//@Api(description = "This is Match Odd API")
@Component
@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(MatchOddsController.BASE_URL)
public class MatchOddsController {

    public static final String BASE_URL = "/api/match/odd";

    private static final Logger logger = Logger.getLogger(MatchOddsController.class.getName());

    private final MatchOddsService matchOddsService;

    //@ApiOperation(value = "Create a match odd", notes = "(C)RUD, Creating new Match Odd, POST Request", produces = "application/json", consumes = "application/json")
    @Operation(summary = "Add a new Match odd", description = "endpoint for creating an entity", tags = {"MatchOdd"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Match Odd created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Match odd already exists")})
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMatchOdds(@RequestBody MatchOddsDTO matchOddsDTO) {
        logger.log(Level.INFO, "Creating new Match Odds");
        MatchOdds matchOdds = matchOddsService.create(matchOddsDTO);
        if (Objects.nonNull(matchOdds)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //@ApiOperation(value = "Update an existing match odd", notes = "CR(U)D, Update based in ID, PUT Request", produces = "application/json", consumes = "application/json")
    @Operation(summary = "Update an existing Match odd", description = "Update based in ID", tags = {"MatchOdd"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Match Odd not found")})
    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMatchOdds(@RequestBody MatchOddsDTO matchOddsDTO) {
        logger.log(Level.INFO, "Updating Match Odds with id: " + matchOddsDTO.getOdd_id());
        MatchOdds matchOdds = matchOddsService.update(matchOddsDTO);
        if (Objects.nonNull(matchOdds)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //@ApiOperation(value = "View a specific match odd", notes = "C(R)UD, View odds based in match ID, GET Request", produces = "application/json")
    @Operation(summary = "Find match odd by ID", description = "Returns a single match odd", tags = {"MatchOdd"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = MatchOdds.class))),
            @ApiResponse(responseCode = "404", description = "There is no such match")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMatchOdd(@RequestParam("matchOddId") String matchOddId) {
        logger.log(Level.INFO, "Fetching Match with id: " + matchOddId);
        MatchOddsDTO matchOdd = matchOddsService.getById(matchOddId);
        return ResponseEntity.ok(matchOdd);
    }

    //@ApiOperation(value = "View all match odds", notes = "C(R)UD, View all odds of all matches, GET Request", produces = "application/json")
    @Operation(summary = "View all match odds", description = " ", tags = {"MatchOdd"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = MatchOdds.class))))})
    @GetMapping(value = "/getAllMatchOdds", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllMatchOdds() {
        logger.log(Level.INFO, "Fetching all Match Odds");
        List<MatchOddsDTO> matchOdds = this.matchOddsService.getAll();
        return ResponseEntity.ok(matchOdds);
    }

    //@ApiOperation(value = "Delete a specific match odd", notes = "CRU(D), Delete a match odd, DELETE Request")
    @Operation(summary = "Deletes a match odd", description = "Delete an odd", tags = {"MatchOdd"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Match odd not found")})
    @DeleteMapping
    public ResponseEntity deleteMatchOdds(@RequestParam("matchOddId") String matchOddId) {
        logger.log(Level.INFO, "Deleting Match with id: " + matchOddId);
        this.matchOddsService.delete(matchOddId);
        return ResponseEntity.noContent().build();
    }

}
