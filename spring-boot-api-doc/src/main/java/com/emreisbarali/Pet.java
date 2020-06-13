package com.emreisbarali;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "My Pet Object", description = "My Pet Model")
public class Pet {

    @ApiModelProperty(value = "The unique id of pet object")
    private int id;
    @ApiModelProperty(value = "The name of pet object")
    private String name;
    @ApiModelProperty(value = "The date of pet object")
    private Date date;
}
