package com.fellows.entity;

public class Clock {


	private static final int ANGLE_HOUR = 30;


	private static final int ANGLE_MINUTE = 6;

	private int hour;
	private int minute;
	private int angle;

	public void setHour(int hour) {
		this.hour = hour;
	}


	public void setMinute(int minute) {
		this.minute = minute;
	}


	/**
	 * retorna o angulo
	 * 
	 * @return
	 */
	public int getAngle() {
		return calculateTimeAngle();
	}

	/**
	 * O ângulo de uma hora são 30°
	 * 
	 * 12 horas, são 360 graus, logo, uma hora são 360/12 = 30°
	 * 
	 * O angulo da hora também sofrerá influência do ponteiro dos minutos.
	 * 
	 *  60 minutos está para 30 graus, assim como
	 *   M minutos está para  X graus
	 *   
	 *   Aplicando a regra de tres simples, temos:
	 *   
	 *         Angulo_Hora * M 
	 *   x = --------------------
	 *              60 
	 */
	private int getHourAngle(int hour) {
		int angle = (this.hour * ANGLE_HOUR) + ((ANGLE_HOUR * this.minute) / 60);
		return angle;
	}

	/**
	 * O ângulo de um minuto são 6°
	 * 
	 * 60 minutos são 360 graus, logo, um minuto são 360/60 = 6°
	 * 
	 */
	private int getMinuteAngle(int minute) {
		int angle = minute * ANGLE_MINUTE;
		return angle;
	}

	/**
	 * Calcula o menor ângulo entre os ponteiros do relógio
	 * 
	 * @return
	 */
	private int calculateTimeAngle() {
		this.angle = Math.abs(getHourAngle(this.hour) - getMinuteAngle(this.minute));
		if (this.angle > 180) {
			this.angle = 360 - this.angle;
		}
		return this.angle;

	}

	@Override
	public String toString() {
		return "{\"angle\":" + getAngle() + "}";
	}

}
