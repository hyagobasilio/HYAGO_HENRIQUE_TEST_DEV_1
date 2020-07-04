package backend

import java.time.LocalDate
import java.time.ZoneId

import grails.converters.JSON

class CompanyController {

    CompanyService companyService
	StockService stockService
	
    
    static responseFormats = ['json']

    def index() {
        def results = companyService.listAll()
        
        render(text: results as JSON, contentType: 'application/json', encoding: 'UTF-8')
    }
	
	def stock() {
		
		def companyName = params?.company ?: "Nike"
		def minutesBefore = params?.minutes ? Integer.parseInt(params.minutes): 600
		
		List<Stock> stocks = companyService.getStocks(companyName, minutesBefore)
		
		render(text: [ totalRecords: stocks.size(), data: stocks] as JSON, contentType: 'application/json', encoding: 'UTF-8')
	}

}