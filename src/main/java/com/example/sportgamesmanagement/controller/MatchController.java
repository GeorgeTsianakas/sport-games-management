package com.example.sportgamesmanagement.controller;

import com.example.sportgamesmanagement.dto.MatchDTO;
import com.example.sportgamesmanagement.model.Match;
import com.example.sportgamesmanagement.service.MatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(description = "This is Match API")
@Component
@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(MatchController.BASE_URL)
public class MatchController {

    public static final String BASE_URL = "/api/match";

    private static final Logger logger = Logger.getLogger(MatchController.class.getName());

    private final MatchService matchService;

    @ApiOperation(value = "Create a match", notes = "(C)RUD, Creating new Match, POST Request")
    @Operation(summary = "Add a new Match", description = "endpoint for creating an entity", tags = {"Match"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Match created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Match already exists")})
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMatch(@RequestBody MatchDTO matchDTO) {
        logger.log(Level.INFO, "Creating new Match");
        Match match = matchService.create(matchDTO);
        if (Objects.nonNull(match)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Update an existing match", notes = "CR(U)D, Update based in ID, PUT Request")
    @Operation(summary = "Update an existing Match", description = "Update based in ID", tags = {"Match"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Match not found")})
    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMatch(@RequestBody MatchDTO matchDTO) {
        logger.log(Level.INFO, "Updating Match with id: " + matchDTO.getId());
        Match match = matchService.update(matchDTO);
        if (Objects.nonNull(match)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "View a match", notes = "C(R)UD, View based in ID, GET Request")
    @Operation(summary = "Find match by ID", description = "Returns a single game", tags = {"Match"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Match.class))),
            @ApiResponse(responseCode = "404", description = "There is no such match")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMatch(@RequestParam("matchId") String matchId) {
        logger.log(Level.INFO, "Fetching Match with id: " + matchId);
        MatchDTO match = matchService.getById(matchId);
        return ResponseEntity.ok(match);
    }

    @ApiOperation(value = "View all matches", notes = "C(R)UD, View all games, GET Request")
    @Operation(summary = "View all matches", description = " ", tags = {"Match"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Match.class))))})
    @GetMapping(value = "/getAllMatches", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllMatches() {
        logger.log(Level.INFO, "Fetching all Matches");
        List<MatchDTO> matches = this.matchService.getAll();
        return ResponseEntity.ok(matches);
    }

    @ApiOperation(value = "Delete a match", notes = "CRU(D), Delete a game, DELETE Request")
    @Operation(summary = "Deletes a match", description = "Delete a game", tags = {"Match"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Match not found")})
    @DeleteMapping
    public ResponseEntity deleteMatch(@RequestParam("matchId") String matchId) {
        logger.log(Level.INFO, "Deleting Match with id: " + matchId);
        this.matchService.delete(matchId);
        return ResponseEntity.noContent().build();
    }

}
