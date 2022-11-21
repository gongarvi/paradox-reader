package com.paradoxcalculator.europa.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class GameSessionCreationRequest {
    MultipartFile file;
}
