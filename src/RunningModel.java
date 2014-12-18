
class RunningModel {
	
	private String lapTime, totalTime;
	private int trackSize, distance, numLaps, lapSeconds, totalSeconds, spareSeconds;
	
	//Accessors
	public String getLapTime(){ return lapTime; }
	public String getTotalTime(){ return totalTime; }
	public int getTrackSize(){ return trackSize; }
	public int getDistance(){ return distance; }
	public int getNumberLaps(){ return numLaps; }
	public int getLapSeconds(){ return lapSeconds; }
	public int getTotalSeconds(){ return totalSeconds; }
	public int getSpareSeconds(){ return spareSeconds; }
	
	//Mutators
	public void setTrackSize(int trackSize){ this.trackSize = trackSize; }
	public void setDistance(int distance){ this.distance = distance; }
	public void setTotalTime(String totalTime){ this.totalTime = totalTime; }
	
	//Public Methods
	public void calcNumberLaps(){
		numLaps = getDistance()/getTrackSize();
	}
	
	public void calcLapSeconds(){
		String[] timeParts = getTotalTime().split(":");
		int minutes = Integer.parseInt(timeParts[0]);
		int seconds = Integer.parseInt(timeParts[1]);
		
		totalSeconds = (minutes*60)+seconds;
		lapSeconds = getTotalSeconds()/getNumberLaps();
	}

	public void calcLapTime(){
		lapTime = formatTime(getLapSeconds());
	}
	
	public void calcSpare(int remaining){
		spareSeconds = getTotalSeconds() - (remaining-getLapSeconds());
	}
	
	public void lapPrinter(){
		int remaining = getLapSeconds();
		
		for(int i = 1; i <= getNumberLaps(); i++){
			System.out.println("Lap " + i + ": " + formatTime(remaining));
			remaining += getLapSeconds();
		}
		
		calcSpare(remaining);
		if (getSpareSeconds() != 0)
			System.out.println("Spare: " + getSpareSeconds() + "s");
	}
	
	//Private Methods
	private String formatTime(int totalTime){
		int formattedMinutes = totalTime/60;
		int formattedSeconds = totalTime%60;
		return formattedMinutes + ":" + String.format("%02d", formattedSeconds);
	}
	
}