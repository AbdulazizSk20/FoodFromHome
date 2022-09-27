package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ResponseDTO<T> {
	
	private T result;
	
	public ResponseDTO(T result) {
		
		this.result=result;		
	}


}
