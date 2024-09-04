package com.exfinder.controller;

import java.util.ArrayList;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.exfinder.dto.AuthoritiesDto;
import com.exfinder.dto.UserDto;
import com.exfinder.service.AdminService;


@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/admin/admin", method = RequestMethod.GET)
	public String admin(Model model) throws Exception {
		ArrayList<UserDto> userList = adminService.selectAll(); // DB에서 데이터 가져오기
		model.addAttribute("userList", userList); // 모델에 추가하여 JSP로 전달
		
		ArrayList<AuthoritiesDto> authorityList = adminService.selectAllAuthorities(); // DB에서 권한 데이터 가져오기
	    model.addAttribute("authorityList", authorityList); // 모델에 추가하여 JSP로 전달
		return "/admin/admin";
	}
	
	// 권한 업데이트를 처리하는 POST 요청
    @RequestMapping(value = "/admin/updateAuthority", method = RequestMethod.POST)
    public String updateAuthority(@RequestParam String u_id, @RequestParam String authority, RedirectAttributes redirectAttributes) {
        try {
            AuthoritiesDto authoritiesDto = new AuthoritiesDto(u_id, authority);
            adminService.updateAuthority(authoritiesDto);
            redirectAttributes.addFlashAttribute("message", "권한변경 성공!");
        } catch (Exception e) {
            logger.error("Error updating authority", e);
            redirectAttributes.addFlashAttribute("error", "권한변경 실패.");
        }
        return "redirect:/admin/admin"; // 권한 업데이트 후 다시 관리자 페이지로 리다이렉트
    }
    // 계정상태 업데이트를 처리하는 POST 요청
    @RequestMapping(value = "/admin/updateStatus", method = RequestMethod.POST)
    public String updateStatus(@RequestParam String u_id, @RequestParam int enabled, RedirectAttributes redirectAttributes) {
        try {
            adminService.updateStatus(u_id, enabled);
            redirectAttributes.addFlashAttribute("message", "상태변경 성공!");
        } catch (Exception e) {
            logger.error("Error updating status", e);
            redirectAttributes.addFlashAttribute("error", "상태변경 실패.");
        }
        return "redirect:/admin/admin"; // 상태 업데이트 후 다시 관리자 페이지로 리다이렉트
    }
    
   
}

