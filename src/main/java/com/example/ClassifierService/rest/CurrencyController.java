package com.example.ClassifierService.rest;

import com.example.ClassifierService.models.Currency;
import com.example.ClassifierService.services.api.ICurrencyService;
import org.springframework.data.domain.PageImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/classifier/сurrency")
public class CurrencyController {
    private final ICurrencyService currencyService;

    public CurrencyController(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }


    /**
     * Создает валюту
     *
     * @param currencyRaw тело валюты с title(название)
     * @return созданную валюту
     */
    @PostMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Currency createCurrency(@RequestBody Currency currencyRaw) {
        return currencyService.createCurrency(currencyRaw);
    }

  /**
   * Дает список валют по номеру страницы и ее размеру
   *
   * @param page номер страницы(больше 0)
   * @param size кол-во объектов на странице(размер страницы(больше 0))
   * @return список счетов
   */
  @GetMapping(value = {"{page}/{size}", "{page}/{size}/"}, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public PageImpl<Currency> getCurrency(@PathVariable int page, @PathVariable int size) {
      return currencyService.getCurrency(page, size);
  }

    @GetMapping(value = {"{uuid}", "{uuid}/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public boolean checkCurrencyByUUID(@PathVariable UUID uuid) {
        return currencyService.checkCurrencyByUUID(uuid);
    }


}
