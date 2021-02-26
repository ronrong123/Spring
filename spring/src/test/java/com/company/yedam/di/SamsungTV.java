package com.company.yedam.di;

public class SamsungTV implements TV{

	Speaker speaker;

	//생성자를 통해 스피커를 주입받을것임
	public SamsungTV() {}
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
