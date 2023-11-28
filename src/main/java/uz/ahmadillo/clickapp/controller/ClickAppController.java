package uz.ahmadillo.clickapp.controller;

import org.springframework.web.bind.annotation.*;
import uz.ahmadillo.clickapp.TransferRequest;
import uz.ahmadillo.clickapp.service.ClickAppService;

import javax.transaction.Transactional;

@RestController
@CrossOrigin("*")
@RequestMapping("/click")
public class ClickAppController {

    private final ClickAppService clickAppService;

    public ClickAppController(ClickAppService clickAppService) {
        this.clickAppService = clickAppService;
    }


    @PostMapping("/userId/transfer")
    public void transferMoney(@PathVariable Long userId, @RequestBody TransferRequest transferRequest) {
        clickAppService.transferMoney(userId, transferRequest.getSourceCardId(), transferRequest.getDestinationCardId(), transferRequest.getAmount());
    }
}
