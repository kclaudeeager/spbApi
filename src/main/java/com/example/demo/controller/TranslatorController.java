package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Translator;
import com.example.demo.repository.TranslatorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/v1")
public class TranslatorController {

  @Autowired
  private TranslatorRepository translatorRepository;

  @PostMapping("/translate")
  public Translator createTransilTranslator(HttpServletRequest request, @Validated @RequestBody Translator translator) {
    return translatorRepository.save(translator);
  }

  @GetMapping("/translate")
  public List<Translator> getAlltTranslators(HttpServletRequest request) {
    return translatorRepository.findAll();
  }

  @GetMapping("/translate/{id}")
  public ResponseEntity<Translator> gettranslateById(HttpServletRequest request, @PathVariable(value = "id") Long id) {
    Translator trans = translatorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Translate  not found :: " + id));
    return ResponseEntity.ok().body(trans);
  }

}
