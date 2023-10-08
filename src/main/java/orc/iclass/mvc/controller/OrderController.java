package orc.iclass.mvc.controller;

import orc.iclass.mvc.dto.OrderDto;
import orc.iclass.mvc.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/order")
@Controller
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service){
        this.service = service;
    }

    @GetMapping("/orderForm")
    public void insert(){
    }

    // 주문 처리 컨트롤러
    @PostMapping("/save")
    public String save(OrderDto vo, RedirectAttributes redirectAttributes){
        service.insert(vo);
        redirectAttributes.addAttribute("bidx", vo.getBidx());
        return "redirect:/order/orderConfirm";
    }

    // 주문 목록 컨트롤러
    @GetMapping( "/orderDetail")
    public void orderDetail(@RequestParam("email") String email, Model model){
        List<OrderDto> list = service.selectByEmail(email);
        model.addAttribute("list", list);
        model.addAttribute("email", email);
    }
    @GetMapping("/orderConfirm")
    public void orderConfirm(@RequestParam("bidx") int bidx, Model model){
        OrderDto vo = service.selectByBidx(bidx);
        model.addAttribute("vo", vo);
        model.addAttribute("bidx", bidx);
    }

    @GetMapping("/orderList")
    public void orderList(Model model){
        List<String> list = service.selectOrderByEmail();
        model.addAttribute("list",list);
    }


}
