package com.javaweb.controller.admin;



import com.javaweb.converter.BuildingConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.enums.District;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.BuildingService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller(value="buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private IUserService userService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private BuildingConverter buildingConverter;

    @GetMapping(value="/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelSearch", buildingSearchRequest); // khi ấn tìm kiếm nó vẫn hiện ở field
        List<BuildingSearchResponse> reponseList = buildingService.findAllBuilding(buildingSearchRequest);
        mav.addObject("buildingList", reponseList);
        mav.addObject("listStaffs", userService.getStaffs()); // trả ra 1 list staffs có trạng thái là 1
        mav.addObject("districts", District.type());
        mav.addObject("typeCodes", TypeCode.type());
        if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            Long staffId = SecurityUtils.getPrincipal().getId();
            buildingSearchRequest.setStaffId(staffId);
            mav.addObject("buildings",buildingService.findAllBuilding(buildingSearchRequest));
        }
        else{
            mav.addObject("buildings",buildingService.findAllBuilding(buildingSearchRequest));
        }
        return mav;
    }

    @GetMapping(value="/admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute("buildingEdit") BuildingDTO buildingDTO,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("districts", District.type());
        mav.addObject("typeCodes", TypeCode.type());
        return mav;

    }

    @RequestMapping(value="/admin/building-edit-{id}",method = RequestMethod.GET)
    public ModelAndView buildingEdit(@PathVariable("id") Long Id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        // xuong DB tim theo id
        BuildingEntity building = buildingRepository.findById(Id).get();
        BuildingDTO buildingDTO = buildingConverter.toBuildingDTO(building);
        mav.addObject("buildingEdit", buildingDTO);
        mav.addObject("districts", District.type());
        mav.addObject("typeCodes", TypeCode.type());
        return mav;

    }

}
