package piggyTest;

import com.univocity.parsers.annotations.FixedWidth;
import com.univocity.parsers.annotations.Parsed;

public  class testBean {

		public testBean() {
		}



		@Parsed
		@FixedWidth(from = 0, to =4)
		int a;

		@Override
		public String toString() {
			return "testBean [a=" + a + ", b=" + b + "]";
		}

		@Parsed
		@FixedWidth(from = 4, to = 9)
		String b;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public String getB() {
			return b;
		}

		public void setB(String b) {
			this.b = b;
		}
		
	}