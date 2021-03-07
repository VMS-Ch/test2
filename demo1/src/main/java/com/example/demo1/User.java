package com.example.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.swing.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author zms
 * @date 2021/03/05 15:22
 */
@Data
@AllArgsConstructor
public class User {

    @Min(22)
    private int age;
    @Min(22)
    private int id;
    @NotBlank
    private String name;


}
