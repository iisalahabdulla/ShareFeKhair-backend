package com.example.sharefekhair.controller;

import com.example.sharefekhair.DTO.ResponseAPI;
import com.example.sharefekhair.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ResponseAPI<?>> getTeachers() {
        return ResponseEntity.status(200).body(new ResponseAPI<>(teacherService.getTeachers(),200));
    }

    @PostMapping
    public ResponseEntity<ResponseAPI<?>> addTeacherToClass(
            @RequestParam Integer teacher_id, @RequestParam Integer class_id){
        teacherService.addTeacherToClass(teacher_id,class_id);
        return ResponseEntity.status(201).body(new ResponseAPI<>("Class Added", 201));
    }
}
