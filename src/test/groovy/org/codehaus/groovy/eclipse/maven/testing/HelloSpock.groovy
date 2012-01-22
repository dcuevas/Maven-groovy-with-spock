package org.codehaus.groovy.eclipse.maven.testing;

import static org.junit.Assert.*
import spock.lang.Specification
import spock.lang.Unroll

class HelloSpock extends Specification {
	@Unroll({"$name should be $length"})
	def "length of Spock's and his friends' names"() {
		expect:
	    name.size() == length
	
		where:
		name | length
		"Spock" | 5 
		"Kirk" |4 
		"Scotty" | 6
		"McCoy" | 5
	}
	
	def "check lengths using arrays"() { 
		expect: name.size() == length
		
		where:
		name << ["Spock","Kirk","Scotty"]
		length << [5,4,6]
	}
	
	def "check lengths using pairs"() {
		expect: name.size() == length
		
		where:
		[name,length] << [["Spock",5],["Kirk",4],["Scotty",6]]
	}
	
	@Unroll({"$barTemp after convert should be $resultConcated"})
	def "concat Hola word afterwards"() {
		expect: barTemp.convert("Hola") == resultConcated
		
		where:
		barTemp | resultConcated
		new Bar("Canela") | "HolaCanela"
		new Bar("") | "Hola"
		new Bar(" ") | "Hola "
	}
}
