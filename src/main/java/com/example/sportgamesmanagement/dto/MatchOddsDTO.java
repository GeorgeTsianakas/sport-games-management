package com.example.sportgamesmanagement.dto;

import com.example.sportgamesmanagement.model.Match;
import com.example.sportgamesmanagement.model.MatchOdds;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(name = "MatchOdd", description = "Data transfer object for a match odd", oneOf = MatchOdds.class)
public class MatchOddsDTO {

    @ApiModelProperty(value = "ID value of the odd", required = true)
    @Schema(description = "Unique identifier of the odd.", example = "1")
    private String odd_id;
    @ApiModelProperty(value = "ID value of the match", required = true)
    @Schema(description = "Unique identifier of the match where the odd references.", example = "111")
    private Match match;
    @ApiModelProperty(value = "Value of the specifier", required = true)
    @Schema(description = "Identifier of the odd specifier.", example = "X")
    private String specifier;
    @ApiModelProperty(value = "Value of the specifier's odd", required = true)
    @Schema(description = "Identifier of the specifier's odd.", example = "2.25")
    private double odd;

    List<MatchOddsDTO> odds;

}
