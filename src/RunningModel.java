
class RunningModel {
	private String time;
	private int laps, distance, trackSize, rawTime;
	
	public void setTrackSize(int trackSize){ this.trackSize = trackSize; }
	public int getTrackSize(){ return trackSize; }
	
	public void setTime(String time){ this.time = time; }
	public String getTime(){ return time; }
	
	public void setDistance(int distance){ this.distance = distance; }
	public int getDistance(){ return distance; }
	
	public int calcLaps(){
		laps = getDistance()/getTrackSize();
		return laps;
	}
	public int getLaps(){ return laps; }
	
	public int calcLapTime(){ 
		return getRawTime()/getLaps(); 
	}
	
	//rawTime is time completely in seconds
	private void calcRawTime(int min, int sec){ 
		rawTime = (min*60)+sec;
	}
	public int getRawTime(){ return rawTime; }
	
	public String doMath(){
		int minutes = 0, 
			seconds = 0;

		if (getTime().charAt(1) == ':'){
			//X:XX Format
			minutes = Integer.parseInt(String.valueOf(getTime().charAt(0)));
			seconds = Integer.parseInt(String.valueOf(getTime().charAt(2) + String.valueOf(getTime().charAt(3))));
		} else if (getTime().charAt(2) == ':'){
			//XX:XX Format
			minutes = Integer.parseInt(String.valueOf(getTime().charAt(0) + String.valueOf(getTime().charAt(1))));
			seconds = Integer.parseInt(String.valueOf(getTime().charAt(3) + String.valueOf(getTime().charAt(4))));
		}
	
		calcRawTime(minutes, seconds);

		return formatEverything(calcLapTime());
	}
	
	
	private String formatEverything(int totalTime){
		int fixedMinutes = totalTime/60;
		int fixedSeconds = totalTime%60;
		return fixedMinutes + ":" + fixedSeconds;
	}
	
	public void lapPrinter(){
		int remaining = calcLapTime();
		
		for(int i = 1; i < getLaps()+1; i++){
			System.out.println("Lap " + i + ": " + formatEverything(remaining));
			remaining += calcLapTime();
		}
		
	}
	
	
}