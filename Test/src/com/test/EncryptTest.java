package com.test;

/**
 * ���ܽ��ܹ�����
 * ����ʹ��Ĭ�ϵ�key��Ҳ�����Լ����ã�������ʲôkey���ܾ�Ҫ��ʲôkey����
 * 
 * @author jiachengyu
 * 
 * @date 2014��9��2��
 */
public class EncryptTest {

	private static String EncryptKey = "This is a default key";

	private static byte[] keyBytes;

	static {
		keyBytes = EncryptKey.getBytes();
	}

	public static void setEncryptKey(String key) {
		EncryptKey = key;
		keyBytes = EncryptKey.getBytes();
	}

	/**
	 * ���ַ������м���
	 * @param str
	 *            �� ��Ҫ���ܵ��ַ���
	 */
	public static String encryptStr(String eStr) {
		byte[] eBytes = eStr.getBytes();
		byte[] outBytes = new byte[eBytes.length];

		for (int i = 0; i < eBytes.length; i++) {
			outBytes[i] = (byte) ((eBytes[i] + keyBytes[i % keyBytes.length]) % 256);
		}
		return byteArr2HexStr(outBytes);
	}

	/**
	 * ��ʮ�����Ƽ����ַ�������
	 * @param dStr
	 *            �� ��Ҫ���ܵ��ַ���
	 */
	public static String decryptStr(String dStr) {
		byte[] dBytes = hexStr2ByteArr(dStr);
		byte[] outBytes = new byte[dBytes.length];

		for (int i = 0; i < dBytes.length; i++) {
			byte tempKeyByte = keyBytes[i % keyBytes.length];
			if (dBytes[i] < tempKeyByte) {
				outBytes[i] = (byte) (dBytes[i] + 256 - tempKeyByte);
			} else {
				outBytes[i] = (byte) (dBytes[i] - tempKeyByte);
			}
		}
		return new String(outBytes);
	}

	/**
	 * ��byte����ת��Ϊ��ʾ16����ֵ���ַ����� �磺byte[]{8,18}ת��Ϊ��0813�� ��public static byte[]
	 * hexStr2ByteArr(String strIn) ��Ϊ�����ת������
	 * @param arrB
	 *            ��Ҫת����byte����
	 * @return ת������ַ���
	 */
	public static String byteArr2HexStr(byte[] arrB) {
		int iLen = arrB.length;
		// ÿ��byte�������ַ����ܱ�ʾ�������ַ����ĳ��������鳤�ȵ�����
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// �Ѹ���ת��Ϊ����
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// С��0F������Ҫ��ǰ�油0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * ����ʾ16����ֵ���ַ���ת��Ϊbyte���飬 ��public static String byteArr2HexStr(byte[] arrB)
	 * ��Ϊ�����ת������
	 * @param strIn
	 *            ��Ҫת�����ַ���
	 * @return ת�����byte����
	 */
	public static byte[] hexStr2ByteArr(String strIn) {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// �����ַ���ʾһ���ֽڣ������ֽ����鳤�����ַ������ȳ���2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

}
