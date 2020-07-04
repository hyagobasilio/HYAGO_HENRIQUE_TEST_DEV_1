package backend

import grails.gorm.transactions.Transactional

@Transactional
class StockService {
	
	def listAll() {
		Stock.list()
	}

    def save(Stock stock) {
		stock.save()
		stock
    }
}
