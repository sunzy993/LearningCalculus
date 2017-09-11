package com.sunzy.dichotomy;

/**
 * ʹ�ö��ַ����㷽�̵Ľ�
 * @author sunzy
 *
 */
public class Dichotomy {
	public static void main(String[] args) {
		Dichotomy dichotomy = new Dichotomy();
		dichotomy.estimateRoot();
	}
	
	/**
	 * �����ض�����ĸ���ֵ
	 * @return ���̵ĸ�
	 */
	private void estimateRoot() {
		double errorBand = getErrorBand(), leftBoundary = getLeftBoundary(), rightBoundary = getRightBoundary(), tempRoot, error;
		log(String.format("Starting estimate root: left boundary %s, right boundary %s, error band %s", leftBoundary, rightBoundary, errorBand));
		if(errorBand <= 0 || getDependentVariable(leftBoundary) * getDependentVariable(rightBoundary) > 0) {
			log("I don't think there is a estimatable root acquiring the demand, quiting!");
			return;
		}
		while(true) {
			// ȡ�м�ֵ��Ϊ��ʱ��
			tempRoot = (leftBoundary + rightBoundary) / 2;
			// ������ʱ�������
			error = getDependentVariable(tempRoot);
			if (Math.abs(error) < getErrorBand()) {
				// �����Ҫ�����Χ�ڣ���������
				log(String.format("Got estimated root %s with error %s, end computing!", tempRoot, error));
			} else if (error > 0) {
				rightBoundary = tempRoot;
			} else {
				leftBoundary = tempRoot;
			}
		}
	}
	
	/**
	 * ���ݺ����Ա����õ�����ֵ
	 * @param iv independent variable �Ա���
	 * @return dependent variable �����������ֵ
	 */
	private double getDependentVariable(double iv) {
		return iv * iv * iv + 1.1 * iv * iv + 0.9 * iv -1.4;
	}
	
	private double getErrorBand() {
		return 0.001;
	}
	
	private double getLeftBoundary() {
		return 1;
	}
	
	private double getRightBoundary() {
		return 0;
	}
	
	private static void log(String msg) {
		System.out.println(msg);
	}
	
}
