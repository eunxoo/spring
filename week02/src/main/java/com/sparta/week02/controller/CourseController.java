package com.sparta.week02.controller;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.models.CourseRequestDto;
import com.sparta.week02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {
    private final CourseRepository courseRepository;

//GET
    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
//POST
    private final CourseService courseService;
    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto){
        //requestDto는 생성 요청을 의미한다.
        //강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요한데 그 정보를 가져오는 녀석이다.

        //저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 한다.
        //새로운 생성자를 만든다.
        Course course = new Course(requestDto);
        return courseRepository.save(course);
    }
//PUT
    @PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }

//DELETE
    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return id;
    }
}