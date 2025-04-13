package com.hackathon.hackhazards.multilingualcommunicator.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TextTranslateRequestDTO {
    String input;
    String outputLang;
}
