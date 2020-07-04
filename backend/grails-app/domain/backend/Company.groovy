package backend

class Company {
    
    Long id
    String name
    String segment
    
    static hasMany = [stocks: Stock]
    
    static constraints = {
        name blank:false
        segment blank:false
    }
}
