package com.example.asm.controller;

import com.example.asm.dto.DomainDto;
import com.example.asm.service.IDomainService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/scan")
public class ScanController {
    @Autowired
    IDomainService domainService;
    @GetMapping
    public String findAllDomain(Model model,
                                @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                @RequestParam("search") Optional<String> search,
                                HttpServletRequest request){
        int pageIndex = page.orElse(1);
        int pageSize = size.orElse(5);
        String searchField = search.orElse(null);
        Page<DomainDto> domainPage = this.domainService.findAllPage(PageRequest.of(pageIndex-1,pageSize, Sort.by("createdDate").descending()));
        if(searchField!=null){
            searchField = URLDecoder.decode(searchField);
            domainPage = this.domainService.searchPage(PageRequest.of(pageIndex-1,pageSize,Sort.by("createdDate").descending()),searchField);
        }
        model.addAttribute("domains", domainPage);
        int totalPage = domainPage.getTotalPages();
        if(totalPage>0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("curPage", pageIndex);
        }
        request.getSession().setAttribute("ref",request.getRequestURI());
        model.addAttribute("searchField", searchField);
        return "allscan";
    }
    @GetMapping(value = "/setting")
    public String getSetting(){
        return "setting";
    }
}
