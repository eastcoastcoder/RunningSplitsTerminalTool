
class RunningModel {
	
	private String time;
	private int laps, distance, trackSize, rawTime, lapTime;
	
	//Accessors
	public int getTrackSize(){ return trackSize; }
	public String getTime(){ return time; }
	public int getDistance(){ return distance; }
	public int getLaps(){ return laps; }
	public int getLapTime(){ return lapTime; }
	public int getRawTime(){ return rawTime; }
	
	//Mutators
	public void setTrackSize(int trackSize){ this.trackSize = trackSize; }
	public void setTime(String time){ this.time = time; }
	public void setDistance(int distance){ this.distance = distance; }
	public void calcLaps(){
		laps = getDistance()/getTrackSize();
	}
	public void calcLapTime(){ 
		lapTime = getRawTime()/getLaps(); 
	}
	//rawTime is time completely in seconds
	private void calcRawTime(int min, int sec){ 
		rawTime = (min*60)+sec;
	}
		
	public String calcIndividualLap(){
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
		calcLapTime();
		return formatEverything(getLapTime());
	}
	
	
	private String formatEverything(int totalTime){
		int fixedMinutes = totalTime/60;
		int fixedSeconds = totalTime%60;
		return fixedMinutes + ":" + fixedSeconds;
	}
	
	public void lapPrinter(){
		int remaining = getLapTime();
		
		for(int i = 1; i < getLaps()+1; i++){
			System.out.println("Lap " + i + ": " + formatEverything(remaining));
			remaining += getLapTime();
		}
		
	}
	
	
}