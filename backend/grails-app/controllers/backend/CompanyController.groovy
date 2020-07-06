package backend

import java.time.LocalDate
import java.time.ZoneId

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import grails.converters.JSON

@RestController
@RequestMapping("company")
class CompanyController {

    CompanyService companyService
	StockService stockService
	
    
    //static responseFormats = ['json']
	@CrossOrigin(origins = "*")
	@GetMapping
    def index() {
        def companies = companyService.listAll()
		JSON.use('deep')
        render(text: companies as JSON, contentType: 'application/json', encoding: 'UTF-8')
		
    }
	
	def stock() {
		
		def companyName = params?.company ?: "Nike"
		def minutesBefore = params?.minutes ? Integer.parseInt(params.minutes): 600
		
		List<Stock> stocks = companyService.getStocks(companyName, minutesBefore)
		
		render(text: [ totalRecords: stocks.size(), data: stocks] as JSON, contentType: 'application/json', encoding: 'UTF-8')
	}

}