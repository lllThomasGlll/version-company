package com.version.company.Controller;

import com.version.company.model.CompanyModel;
import com.version.company.model.CompanyAppDTO;
import com.version.company.model.CompanyRequest;
import com.version.company.service.CompanyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyModel> findAll() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyModel> findById(@PathVariable Long id) {
        return companyService.finById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CompanyModel company) {
        return companyService.create(company); // Retorna directamente la respuesta que ya ha sido preparada en el servicio
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompanyModel> update(@PathVariable Long id, @RequestBody CompanyRequest datos) {
        return companyService.update(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean eliminado = companyService.delete(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("Codigo/{codigo_company}")
    public CompanyAppDTO findByCode(@PathVariable String codigo_company) {
        return companyService.getCompanyAppVersion(codigo_company);
    }
}

