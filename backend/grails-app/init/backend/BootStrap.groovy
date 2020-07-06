package backend
import java.time.LocalDate
import java.time.ZoneId

class BootStrap {

    def companyService
	def stockService

    def init = { servletContext ->
        Company company1 = companyService.save(new Company(name: "Ford", segment: "Veicle"))
        Company company2 = companyService.save(new Company(name: "Nike", segment: "Shoes"))
        Company company3 = companyService.save(new Company(name: "DELL", segment: "Personal Computer"))
		
		Random r = new Random()
		
        def startDay = LocalDate.now().minusDays(2)
		startDay.datesUntil(LocalDate.now()).forEach { data -> 
			
			def startHour = data.atTime(10, 0)
			def endHour = data.atTime(18, 0)
			
			while(startHour.compareTo(endHour) < 1) {
				double randomValue = (1 + (100 - 1) * r.nextDouble()).trunc(2);
				println randomValue
				println startHour
				Date datahora = Date.from(startHour.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
				stockService.save(
					new Stock(price: randomValue, priceDate: datahora, company: company1)
				)
				stockService.save(
					new Stock(price: randomValue, priceDate: datahora, company: company2)
				)
				stockService.save(
					new Stock(price: randomValue, priceDate: datahora, company: company3)
				)
				startHour = startHour.plusMinutes(1)
			}
		}

    }
    def destroy = {
    }
}
