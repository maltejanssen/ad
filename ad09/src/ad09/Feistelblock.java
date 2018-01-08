package ad09;

import java.math.BigInteger;

public class Feistelblock {

	public final int BLOCKSIZE;

	// blocksize/2 for each blockpart
	private byte[] right;
	private byte[] left;

	/**
	 * initialized with two blockparts with BLOCKSIZE/2 for each
	 * 
	 * @param right
	 * @param left
	 */
	public Feistelblock(byte[] right, byte[] left, int blocksize) {
		this.right = right;
		this.left = left;
		this.BLOCKSIZE = blocksize;
	}

	public void cycle(byte[] key, int cycleRepetition) {

		for (int i = 0; i < cycleRepetition; i++) {


			// 2: generate a new blockpart F(R,K)
			byte[] F = F(key);

			// 3: bitwise XOR(L,F) generates new R
			XOR(F);
			// 1: swaps the blockparts
			swap();

		}

	}

	public void swap() {
		byte[] temp = right;
		right = left;
		left = temp;
	}

	private byte[] F(byte[] key) {
		//generates the BigInterger to represent each byte array
		BigInteger R = new BigInteger(1, right);
		BigInteger K = new BigInteger(1, key);
		//System.out.println(K.toString(radix));

		BigInteger bigIntF = (R.pow(2).add(K)).mod(new BigInteger("2").pow(64).subtract(new BigInteger("1")));
		return Feistel.BigInt2Byte(bigIntF, BLOCKSIZE / 2);
	}

	private void XOR(byte[] F) {
		byte[] newR = new byte[BLOCKSIZE / 2];

		// bitwise XOR on each element of the L and F
		for (int i = 0; i < BLOCKSIZE / 2; i++) {
			newR[i] = (byte) (left[i] ^ F[i]);
		}

		// saves the new blockpart R
		left = newR;
	}

	public byte[] getRight() {
		return right;
	}

	public byte[] getLeft() {
		return left;
	}

	
}
