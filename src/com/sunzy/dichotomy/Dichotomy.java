package com.sunzy.dichotomy;

/**
 * 使用二分法估算方程的解
 * @author sunzy
 *
 */
public class Dichotomy {
	public static void main(String[] args) {
		Dichotomy dichotomy = new Dichotomy();
		dichotomy.estimateRoot();
	}
	
	/**
	 * 估算特定区间的根的值
	 * @return 方程的根
	 */
	private void estimateRoot() {
		double errorBand = getErrorBand(), leftBoundary = getLeftBoundary(), rightBoundary = getRightBoundary(), tempRoot, error;
		log(String.format("Starting estimate root: left boundary %s, right boundary %s, error band %s", leftBoundary, rightBoundary, errorBand));
		if(errorBand <= 0 || getDependentVariable(leftBoundary) * getDependentVariable(rightBoundary) > 0) {
			log("I don't think there is a estimatable root acquiring the demand, quiting!");
			return;
		}
		while(true) {
			// 取中间值作为临时根
			tempRoot = (leftBoundary + rightBoundary) / 2;
			// 计算临时根的误差
			error = getDependentVariable(tempRoot);
			if (Math.abs(error) < getErrorBand()) {
				// 误差在要求的误差范围内，结束运行
				log(String.format("Got estimated root %s with error %s, end computing!", tempRoot, error));
			} else if (error > 0) {
				rightBoundary = tempRoot;
			} else {
				leftBoundary = tempRoot;
			}
		}
	}
	
	/**
	 * 根据函数自变量得到函数值
	 * @param iv independent variable 自变量
	 * @return dependent variable 因变量，函数值
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
