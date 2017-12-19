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

			// 1: swaps the blockparts
			swap();

			// 2: generate a new blockpart F(R,K)
			byte[] F = F(key);

			// 3: bitwise XOR(L,F) generates new R
			XOR(F);

		}

	}

	private void swap() {
		byte[] temp = right;
		right = left;
		left = temp;
	}

	private byte[] F(byte[] key) {
		//generates the BigInterger to represent each byte array
		BigInteger R = new BigInteger(1, right);
		BigInteger K = new BigInteger(1, key);

		BigInteger bigIntF = (R.pow(2).add(K)).mod(new BigInteger("2").pow(64).subtract(new BigInteger("1")));
		return BigInt2Byte(bigIntF, BLOCKSIZE / 2);
	}

	private void XOR(byte[] F) {
		byte[] newR = new byte[BLOCKSIZE / 2];

		// bitwise XOR on each element of the L and F
		for (int i = 0; i < BLOCKSIZE / 2; i++) {
			newR[i] = (byte) (left[i] ^ F[i]);
		}

		// saves the new blockpart R
		right = newR;
	}

	public byte[] getRight() {
		return right;
	}

	public byte[] getLeft() {
		return left;
	}

	/**
	 * Solution ref.: RSA Verschlüsselung: Ronald Rivest, Adi Shamir, Leonard
	 * Adleman
	 * 
	 * @param src
	 * @param bytesize
	 * @return
	 */
	static byte[] BigInt2Byte(BigInteger src, int bytesize) {
		byte[] out = new byte[bytesize];
		BigInteger mod = new BigInteger("2");
		mod = mod.pow(bytesize * 8);
		src = src.mod(mod);
		int startdst = bytesize - src.toByteArray().length;
		int cpylength = src.toByteArray().length;

		if ((src.bitLength() % 8) != 0) {
			System.arraycopy(src.toByteArray(), 0, out, startdst, cpylength);
		} else {
			System.arraycopy(src.toByteArray(), 1, out, startdst + 1, cpylength - 1);
		}
		return out;
	}
}
