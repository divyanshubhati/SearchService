package com.zotdrive.searchservice.controller;

import com.zotdrive.searchservice.document.FileObject;
import com.zotdrive.searchservice.search.SearchReq;
import com.zotdrive.searchservice.search.SearchRequestDTO;
import com.zotdrive.searchservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> save(@RequestBody final FileObject file) {

        if(service.saveFile(file)){
            return new ResponseEntity<>("Filed added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Issue creating file", HttpStatus.PRECONDITION_FAILED);
        }
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
    public ResponseEntity<String> update(@RequestBody final FileObject updatedFileObject){
        if(updatedFileObject.getId() == null){
            return new ResponseEntity<>("FileId missing", HttpStatus.PRECONDITION_FAILED);
        }
        if(service.update(updatedFileObject)){
            return new ResponseEntity<>("Filed updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Issue updating file", HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<String> delete(@PathVariable final String fileId ){

        if(service.updateFileStatus(fileId, true)) {
            return new ResponseEntity<>("Filed deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Issue deleting file", HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PutMapping("/recover/{fileId}")
    public ResponseEntity<String> recover(@PathVariable final String fileId){
        if(service.updateFileStatus(fileId, false)){
            return new ResponseEntity<>("Filed recovered successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Issue recovering file", HttpStatus.PRECONDITION_FAILED);
        }
    }


}
