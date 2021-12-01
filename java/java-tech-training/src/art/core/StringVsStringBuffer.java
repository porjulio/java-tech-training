package art.core;

public class StringVsStringBuffer {
	public static void main(String[] args) {
		testString();
		testStringBuffer();
		testStringBuilder();
	}

	private static void testString() {
		int testNumber = 200000;
		String testString = "";

		long start = System.currentTimeMillis();
		for (int ctr = 0; ctr < testNumber; ctr++) {
			testString = testString + ctr + " ";
		}
		long end = System.currentTimeMillis();	
		System.out.println("String : " + (end-start));
	}
	private static void testStringBuffer() {
		int testNumber =200000;
		StringBuffer stringBuffer = new StringBuffer();

		long start = System.currentTimeMillis();
		for (int ctr = 0; ctr < testNumber; ctr++) {
			stringBuffer.append(ctr + " ");
		}
		long end = System.currentTimeMillis();	
		System.out.println("String Buffer : " + (end-start));
	}
	
	private static void testStringBuilder() {
		int testNumber = 200000;
		StringBuilder stringBuilder = new StringBuilder();
		
		long start = System.currentTimeMillis();
		for (int ctr = 0; ctr < testNumber; ctr++) {
			stringBuilder.append(ctr + " ");
		}
		long end = System.currentTimeMillis();
		System.out.println("String Builder : " + (end-start));
	}
}
