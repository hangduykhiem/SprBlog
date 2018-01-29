package com.hangduykhiem.springboottest;

import com.hangduykhiem.springboottest.model.Blog;
import com.hangduykhiem.springboottest.repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    // Get All Blogs
    @GetMapping("/blogs")
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    // Create a new Blog
    @PostMapping("/blogs")
    public Blog createBlog(@Valid @RequestBody Blog blog) {
        return blogRepository.save(blog);
    }

    // Get a Single Blog
    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable(value = "id") Long blogId) {
        Blog blog = blogRepository.findOne(blogId);
        if(blog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(blog);
    }

    // Update a Blog
    @PutMapping("/blogs/{id}")
    public ResponseEntity<Blog> updateblog(@PathVariable(value = "id") Long blogId,
                                           @Valid @RequestBody Blog blogDetails) {
        Blog blog = blogRepository.findOne(blogId);
        if(blog == null) {
            return ResponseEntity.notFound().build();
        }

        blog.setTitle(blogDetails.getTitle());
        blog.setContent(blogDetails.getContent());

        Blog updatedblog = blogRepository.save(blog);
        return ResponseEntity.ok(updatedblog);
    }

    // Delete a Blog
    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable(value = "id") Long blogId) {
        Blog blog = blogRepository.findOne(blogId);
        if(blog == null) {
            return ResponseEntity.notFound().build();
        }

        blogRepository.delete(blog);
        return ResponseEntity.ok().build();
    }

}
