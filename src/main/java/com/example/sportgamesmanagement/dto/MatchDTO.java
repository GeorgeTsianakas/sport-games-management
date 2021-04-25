package com.example.sportgamesmanagement.dto;

import com.example.sportgamesmanagement.model.Match;
import com.example.sportgamesmanagement.model.Sport;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(name = "Match", description = "Data transfer object for a match", oneOf = Match.class)
public class MatchDTO {

//    @ApiModelProperty(value = "ID value of the match", required = true)
    @Schema(description = "Unique identifier of the match.", example = "1")
    private String id;
//    @ApiModelProperty(value = "Description of which teams are participating in the match", required = true)
    @Schema(description = "Description of which teams are participating in the match.", example = "AEK - PAO")
    private String description;
//    @ApiModelProperty(value = "Date of the match", required = true)
    @Schema(description = "Date of the match.", example = "25/11/2020")
    private Date match_date;
//    @ApiModelProperty(value = "Time of the match", required = true)
    @Schema(description = "Time of the match.", example = "15:30")
    private Time match_time;
//    @ApiModelProperty(value = "Name of the 1st team", required = true)
    @Schema(description = "Name of the 1st team.", example = "AEK")
    private String team_a;
//    @ApiModelProperty(value = "Name of 2nd team", required = true)
    @Schema(description = "Name of 2nd team.", example = "PAO")
    private String team_b;
//    @ApiModelProperty(value = "Name of sport(either Football or Basketball)", required = true)
    @Schema(description = "Name of sport(either Football or Basketball).", example = "Basketball")
    private Sport sport;

    List<MatchDTO> matches;

}
