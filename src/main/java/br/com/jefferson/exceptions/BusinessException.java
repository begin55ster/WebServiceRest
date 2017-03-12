package br.com.jefferson.exceptions;

  public class BusinessException extends Exception {
  
		private static final long serialVersionUID = 1L;
		private String msg;
		
	    public BusinessException(String msg){
	       super(msg);
	       this.msg = msg;
	    }
	    
	    public BusinessException(String msg, Throwable causa){
	    	super(msg, causa);
	    }
	    
	    public String getMessage(){
	       return msg;
	    }
	    
  }

  
 
