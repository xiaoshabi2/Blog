package com.gwd.controller.TestController;
import com.alibaba.fastjson.JSON;
import com.gwd.service.ArchivesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/testArchivesController")
public class TestArchivesController {

    @Resource
    private ArchivesService archivesService;

    private static int topId=11;

    @RequestMapping("/selectAllArchives")
    public void selectAllArchives(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(archivesService.selectAllArchives()));
        out.flush();
        out.close();
    }


}
