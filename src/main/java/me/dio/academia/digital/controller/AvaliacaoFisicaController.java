package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.exception.CaptureErrorsException;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

  @Autowired
  private AvaliacaoFisicaServiceImpl service;

  @PostMapping
  public ResponseEntity<AvaliacaoFisica> create(@RequestBody AvaliacaoFisicaForm form, Errors errors) throws Exception {

    if (errors.hasErrors()) {
      throw new CaptureErrorsException(errors);
    }

    AvaliacaoFisica avaliacaoFisica = service.create(form);

    return  ResponseEntity.ok().body(avaliacaoFisica);
  }

  @GetMapping
  public List<AvaliacaoFisica> getAll(){
    return service.getAll();
  }

}
