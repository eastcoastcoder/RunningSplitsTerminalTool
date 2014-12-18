
class RunningModel {
	
	private String totalTime;
	private int numLaps, distance, trackSize, totalSeconds, lapTime;
	
	//Accessors
	public int getTrackSize(){ return trackSize; }
	public String getTotalTime(){ return totalTime; }
	public int getDistance(){ return distance; }
	public int getNumberLaps(){ return numLaps; }
	public int getLapTime(){ return lapTime; }
	public int getTotalSeconds(){ return totalSeconds; }
	
	//Mutators
	public void setTrackSize(int trackSize){ this.trackSize = trackSize; }
	public void setTotalTime(String totalTime){ this.totalTime = totalTime; }
	public void setDistance(int distance){ this.distance = distance; }
	
	//Public Methods
	public void calcLaps(){
		numLaps = getDistance()/getTrackSize();
	}

	public String calcIndividualLap(){
		int minutes = 0, 
			seconds = 0;

		if (getTotalTime().charAt(1) == ':'){
			//X:XX Format
			minutes = Integer.parseInt(String.valueOf(getTotalTime().charAt(0)));
			seconds = Integer.parseInt(String.valueOf(getTotalTime().charAt(2) + String.valueOf(getTotalTime().charAt(3))));
		} else if (getTotalTime().charAt(2) == ':'){
			//XX:XX Format
			minutes = Integer.parseInt(String.valueOf(getTotalTime().charAt(0) + String.valueOf(getTotalTime().charAt(1))));
			seconds = Integer.parseInt(String.valueOf(getTotalTime().charAt(3) + String.valueOf(getTotalTime().charAt(4))));
		}
	
		calcTotalSeconds(minutes, seconds);	
		calcLapTime();
		return formatTime(getLapTime());
	}
	
	public void lapPrinter(){
		int remaining = getLapTime();
		
		for(int i = 1; i < getNumberLaps(); i++){
			System.out.println("Lap " + i + ": " + formatTime(remaining));
			remaining += getLapTime();
		}
		System.out.println("Lap " + getNumberLaps() + ": " + getTotalTime());
	}
	
	//Private Methods
	private void calcTotalSeconds(int min, int sec){ 
		totalSeconds = (min*60)+sec;
	}
	
	private void calcLapTime(){ 
		lapTime = getTotalSeconds()/getNumberLaps(); 
	}
	
	private String formatTime(int totalTime){
		int formattedMinutes = totalTime/60;
		int formattedSeconds = totalTime%60;
		return formattedMinutes + ":" + formattedSeconds;
	}
	
	
}