package org.example.controller;

import org.example.model.User;
import org.example.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    /**
     *
     * @param awardId
     * @param memberIds
     * @return
     * url服务路径可变用{变量名}表示，可变部分与方法参数绑定但需要注释@pathVariable以及变量名一致
     * 在参数列表上的注释 还有@RequestParam表示该参数不可缺省  @requestBody 当参数列表接收application/json
     * 数据类型时需要用此注释注明 才可接收到 当然为其他数据类型时该注释的参数无法接收 即@requestBody 仅相关于json
     * 注意：参数列表可以接收客户端发来的数据 当用POJO对象作为参数列表来接收是全盘接收 未传入的属性值赋null
     * 一般接收到的参数信息较多时采用对象来接收 也可以用指定的参数列来接收需要的属性值
     */

    @PostMapping("/add/{awardId}")
    public Object add(@PathVariable Integer awardId,
                      @RequestBody List<Integer> memberIds){
        int n = recordService.add(awardId, memberIds);
        return null;
    }

    @GetMapping("/delete/member")
    public Object deleteByMemberId(Integer id){
        int n = recordService.deleteByMemberId(id);
        return null;
    }

    @GetMapping("/delete/award")
    public Object deleteByAwardId(Integer id){
        int n = recordService.deleteByAwardId(id);
        return null;
    }

    @GetMapping("/delete/setting")
    public Object deleteBySettingId(HttpSession session){
        User user = (User) session.getAttribute("user");
        int n = recordService.deleteBySettingId(user.getSettingId());
        return null;
    }

}
