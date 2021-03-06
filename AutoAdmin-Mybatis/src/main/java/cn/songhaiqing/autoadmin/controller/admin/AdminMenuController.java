package cn.songhaiqing.autoadmin.controller.admin;

import cn.songhaiqing.autoadmin.annotation.AdminPermission;
import cn.songhaiqing.autoadmin.base.BaseController;
import cn.songhaiqing.autoadmin.base.BaseQuery;
import cn.songhaiqing.autoadmin.base.BaseResponse;
import cn.songhaiqing.autoadmin.base.BaseResponseList;
import cn.songhaiqing.autoadmin.entity.Menu;
import cn.songhaiqing.autoadmin.model.MenuViewModel;
import cn.songhaiqing.autoadmin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/admin/menu")
public class AdminMenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menuView")
    public ModelAndView menuView() {
        return new ModelAndView("/admin/menu");
    }

    @RequestMapping(value = "/addMenuView")
    public ModelAndView addMenuView() {
        List<MenuViewModel> menus = menuService.getParentMenu();
        ModelAndView modelAndView = new ModelAndView("/admin/menuAdd");
        modelAndView.addObject("menus", menus);
        return modelAndView;
    }

    @RequestMapping(value = "/updateMenuView")
    public ModelAndView updateMenuView(@RequestParam Long id) {
        Menu menu = menuService.getMenu(id);
        List<MenuViewModel> menus = menuService.getParentMenu();
        ModelAndView model = new ModelAndView("/admin/menuUpdate");
        model.addObject("menu", menu);
        model.addObject("menus", menus);
        return model;
    }

    @RequestMapping(value = "/getMenuPage")
    public BaseResponseList getMenu(BaseQuery query) {
        return menuService.getMenuPage(query);
    }

    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    public BaseResponse addMenu(MenuViewModel model) {
        menuService.addMenu(model);
        return success();
    }

    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
    public BaseResponse updateMenu(MenuViewModel model) {
        menuService.updateMenu(model);
        return success();
    }

    @RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
    public BaseResponse deleteMenu(@RequestParam Long[] ids) {
        menuService.deleteMenu(ids);
        return success();
    }
}
