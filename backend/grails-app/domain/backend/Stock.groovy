
package backend

class Stock {

    Double price
    Date priceDate

    static belongsTo = [company: Company]

    static constraints = {
    }
}
