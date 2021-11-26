package challenge.ravn.controller;

import challenge.ravn.response.SalesResponse;
import challenge.ravn.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {
    private final SalesService salesService;

    @GetMapping("/bestSellers")
    public ArrayList<SalesResponse> getBestSellers(
            @RequestParam(required = false, defaultValue = "10") Integer count) {
        return salesService.getBestSellers(count);
    }


}
