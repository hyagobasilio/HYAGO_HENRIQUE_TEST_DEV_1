 package backend

import java.time.LocalDateTime
import java.time.ZoneId

import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class CompanyService {

    def listAll() {
       Company.list()
    }
	
    def save(Company company) {
        company.validate()
        company.save()
        company
    }
	
	List<Stock> getStocks(String companyName, Integer numbersOfHoursUntilNow) {
		def timeStart = System.currentTimeMillis()
		
		Company company = Company.findByName(companyName)
		def startHour = LocalDateTime.now().minusHours(numbersOfHoursUntilNow)
		Date datahora = Date.from(startHour.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
		List<Stock> stocks = Stock.findAllByPriceDateGreaterThanEqualsAndCompany(datahora, company, [sort: 'priceDate', order: 'asc'])
		
		stocks.each { 
			println it as JSON
		}
		println startHour 
		println "Duration of execution: " + System.currentTimeMillis() - timeStart
		println "Total records: " + stocks.size()
		stocks
	}
}
