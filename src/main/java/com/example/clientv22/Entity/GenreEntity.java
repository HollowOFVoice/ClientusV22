package com.example.clientv22.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GenreEntity {

    private Long id;
    private String title;



    @Override
    public String toString() {
        return

                 title;
    }
}
