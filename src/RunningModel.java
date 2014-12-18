
class RunningModel {
	
	private String totalTime;
	private int numLaps, distance, trackSize, totalSeconds, lapTime;
	
	//Accessors
	public int getTrackSize(){ return trackSize; }
	public int getDistance(){ return distance; }
	public int getNumberLaps(){ return numLaps; }
	public int getLapSeconds(){ return lapTime; }
	public int getTotalSeconds(){ return totalSeconds; }
	public String getLapTime(){ return formatTime(getLapSeconds()); }
	public String getTotalTime(){ return totalTime; }
	
	//Mutators
	public void setTrackSize(int trackSize){ this.trackSize = trackSize; }
	public void setTotalTime(String totalTime){ this.totalTime = totalTime; }
	public void setDistance(int distance){ this.distance = distance; }
	
	//Public Methods
	public void calcNumberLaps(){
		numLaps = getDistance()/getTrackSize();
	}

	public void calcIndividualLap(){
		String[] timeParts = getTotalTime().split(":");
		int minutes = Integer.parseInt(timeParts[0]);
		int seconds = Integer.parseInt(timeParts[1]);
		
		totalSeconds = (minutes*60)+seconds;
		lapTime = getTotalSeconds()/getNumberLaps();
	}
	
	public void lapPrinter(){
		int remaining = getLapSeconds();
		
		for(int i = 1; i <= getNumberLaps(); i++){
			System.out.println("Lap " + i + ": " + formatTime(remaining));
			remaining += getLapSeconds();
		}
		
		if (getTotalSeconds() - (remaining-getLapSeconds()) != 0)
			System.out.println("Spare: " + (getTotalSeconds() - (remaining-getLapSeconds())) + "s");
	}
	
	private String formatTime(int totalTime){
		int formattedMinutes = totalTime/60;
		int formattedSeconds = totalTime%60;
		return formattedMinutes + ":" + String.format("%02d", formattedSeconds);
	}
	
	
}