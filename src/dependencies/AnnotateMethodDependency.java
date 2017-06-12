package dependencies;

import java.util.Properties;

import enums.ViolationProperties;

public final class AnnotateMethodDependency extends AnnotateDependency {
	private final String methodNameA;
	
	public AnnotateMethodDependency(String classNameA, String classNameB, Integer lineNumber, Integer offset, Integer length, String methodNameA) {
		super(classNameA,classNameB,lineNumber,offset,length);
		this.methodNameA = methodNameA;
	}

	public String getMethodName() {
		return this.methodNameA;
	}
	
	public String toString() {
		return "'" + 
				this.classNameA + "' contains the method '" + this.methodNameA + 
				"' which is annotated by '" + this.classNameB + "'";
	}
	
	@Override
	public Properties props() {
		Properties props = super.props();
		props.put(ViolationProperties.METHOD_NAME_A.getKey(), this.methodNameA);
		return props;
	}
}