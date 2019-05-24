package com.loiane.springcloudhello.getjson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.loiane.springcloudhello.model.Contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

	private String type;
    private Value value;
    
    
    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    
    }
	
	
}
