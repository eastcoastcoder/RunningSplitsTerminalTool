
class RunningModel {
	
	private String totalTime;
	private String[] lapTimesArray;
	private int trackSize, distance, remaining;
	
	//Public Methods
	//Mutators
	public void setTrackSize(int trackSize){ this.trackSize = trackSize; }
	public void setDistance(int distance){ this.distance = distance; }
	public void setTotalTime(String totalTime){ this.totalTime = totalTime; }
	
	//Accessors	
	public int getLapSeconds(){ 
		return getTotalSeconds()/getNumberLaps();
	}
	
	public String getLapTime(){ 
		return formatTime(getLapSeconds()); 
	}
	
	public int getNumberLaps(){ 
		return distance/trackSize; 
	}
	
	public int getSpareSeconds(){
		return getTotalSeconds() - (remaining-getLapSeconds());
	}

	public int getTotalSeconds(){
		String[] timeParts = totalTime.split(":");
		int minutes = Integer.parseInt(timeParts[0]);
		int seconds = Integer.parseInt(timeParts[1]);
		
		return (minutes*60)+seconds;
	}

	public String[] getLapTimesArray(){
		lapTimesArray = new String[getNumberLaps()];
		remaining = getLapSeconds();

		for(int i = 0; i < getNumberLaps(); i++){
			lapTimesArray[i] = formatTime(remaining);
			remaining += getLapSeconds();
		}
		return lapTimesArray;
	}
	
	//Private Methods
	private String formatTime(int totalTime){
		int formattedMinutes = totalTime/60;
		int formattedSeconds = totalTime%60;
		return formattedMinutes + ":" + String.format("%02d", formattedSeconds);
	}
		
}