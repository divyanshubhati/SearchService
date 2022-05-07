package com.zotdrive.searchservice.controller;

import com.zotdrive.searchservice.document.File;
import com.zotdrive.searchservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/file")
public class FileController {

    private final FileService service;

    @Autowired
    public FileController(FileService service){
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody final File file) {
        service.save(file);
    }

    @GetMapping("/{id}")
    public File findById(@PathVariable final Long id) {
        return service.findById(id);
    }
}
