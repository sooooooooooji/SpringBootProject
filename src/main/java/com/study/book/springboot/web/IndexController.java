package com.study.book.springboot.web;

import com.study.book.springboot.config.auth.LoginUser;
import com.study.book.springboot.config.auth.dto.SessionUser;
import com.study.book.springboot.service.posts.PostsService;
import com.study.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

//    @GetMapping("/")
//    public String index(Model model){
//        //src/main/resource/templates
//        //확장자는 .mustache
//        model.addAttribute("posts", postsService.findAllDesc());
//
//        SessionUser user = (SessionUser)httpSession.getAttribute("user");
//
//        if(user != null){
//            model.addAttribute("userName", user.getName());
//        }
//
//        return  "index";//머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정됨
//    }

    //위에 반복되는 코드를 아래 메소드로 단축시킴
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }


    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
