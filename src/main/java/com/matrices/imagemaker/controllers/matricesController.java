package com.matrices.imagemaker.controllers;

import com.matrices.imagemaker.models.matrizSetup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matices")
@Slf4j
public class matricesController {

    @PostMapping("/")
    public int calculateMatriz(@RequestBody matrizSetup setup) {

        Integer[][] matriz = new Integer[setup.getRows()][setup.getColumns()];
        int sum = 0;

        for (int r = 0; r < setup.getRows(); r++) {
            for (int c = 0; c < setup.getColumns(); c++) {
                int z = setup.getZ();
                
                int set = 0;
                if ((r + 1) == 1) {
                     set = z;
                }
                else {
                    set = z + r;
                }
                
                if (r <= setup.getY() && c <= setup.getX()) {
                    sum += set;
                }
                
                matriz[r][c] = set;
            }
        }
        
        return sum;
    }

}
