package infra;

import java.util.Random;

public class OTPGenerator {

	public String generate() {
		Random random = new Random();
		String OPT = "";
		for(int i = 1; i <= 6; i++) {
			int tmp = random.nextInt(0, 10);
			OPT += tmp;
		}
		return OPT;
	}
}
