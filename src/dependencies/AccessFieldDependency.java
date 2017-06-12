package dependencies;

import java.util.Properties;

import enums.ViolationProperties;


public final class AccessFieldDependency extends AccessDependency {
	private final String methodNameA;
	private final String fieldNameB;
	private final boolean staticAccess;
	
	public AccessFieldDependency(String classNameA, String classNameB, Integer lineNumberA, Integer offset, Integer length, String methodName, String fieldName, boolean staticAccess) {
		super(classNameA,classNameB,lineNumberA, offset, length);
		this.methodNameA = methodName;
		this.fieldNameB = fieldName;
		this.staticAccess = staticAccess;
	}

	public String getMethodName() {
		return this.methodNameA;
	}
	
	public String getFieldName() {
		return this.fieldNameB;
	}

	public boolean isStaticAccess() {
		return this.staticAccess;
	}
	
	@Override
	public String toString() {
		return "'" + 
			this.classNameA + "' contains the method '" + this.methodNameA + 
			"' that accesses " + ((this.staticAccess) ? "statically " : "") + "the field '" + this.fieldNameB + 
			"' of an object of '" + this.classNameB + "'";
	}
	
	@Override
	public Properties props() {
		Properties props = super.props();
		props.put(ViolationProperties.METHOD_NAME_A.getKey(), this.methodNameA);
		props.put(ViolationProperties.FIELD_NAME_B.getKey(), this.fieldNameB);
		props.put(ViolationProperties.STATIC_ACCESS.getKey(), "" + this.staticAccess);
		return props;
	}
}