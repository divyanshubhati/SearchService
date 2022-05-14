package com.zotdrive.searchservice.controller;

import com.zotdrive.searchservice.document.FileObject;
import com.zotdrive.searchservice.search.SearchReq;
import com.zotdrive.searchservice.search.SearchRequestDTO;
import com.zotdrive.searchservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/file")
public class FileController {

    private final FileService service;

    @Autowired
    public FileController(FileService service){
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody final FileObject file) {
        service.saveFile(file);
    }

    @GetMapping("/{id}")
    public FileObject findById(@PathVariable final String id) {
        return service.getFileById(id);
    }

//    @GetMapping("/search/{keyword}")
//    public List<FileObject> findByKeyword(@PathVariable final  String keyword) {
//        return service.findKeyWord(keyword);
//    }

//    @PostMapping("/search")
//    public List<FileObject> search(@RequestBody final SearchReq dto) {
//        return service.search(dto);
//    }
//
//    @GetMapping("/search/{date}")
//    public List<FileObject> getAllFileCreatedSince(
//            @PathVariable
//            @DateTimeFormat(pattern = "yyyy-MM-dd")
//            final Date date){
//        return service.getAllVehiclesCreatedSince(date);
//    }
//
//    @PostMapping("/searchcreatedsince/{date}")
//    public List<FileObject> searchCreatedSince(
//            @RequestBody final SearchReq dto,
//            @PathVariable
//            @DateTimeFormat(pattern = "yyyy-MM-dd")
//            final Date date) {
//        return service.searchCreatedSince(dto, date);
//    }

    @PostMapping("/search")
    public List<FileObject> search(
            @RequestBody final SearchRequestDTO dto) {
        return service.searchUsingDTO(dto);
    }

    @PutMapping("/update")
    public void update(@RequestBody final FileObject updatedFileObject){
        service.update(updatedFileObject);
    }

    @DeleteMapping("/{fileId}")
    public void delete(@PathVariable final String fileId ){
        service.updateFileStatus(fileId, true);
    }

    @PutMapping("/recover/{fileId}")
    public void recover(@PathVariable final String fileId){
        service.updateFileStatus(fileId, false);
    }


}
