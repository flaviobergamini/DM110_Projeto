package br.inatel.trabalho.support;

public enum AuditOperations {
	CREATE("Create"),
	READ("Read all"),
	READ_BY_CODE("Read by code"),
	UPDATE("Update"),
	DELETE("Delete");
	
	private final String operation;
	
	AuditOperations(String operation){
		this.operation = operation;
	}
	
	public String getOperation() {
        return operation;
    }
}
