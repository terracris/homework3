import java.util.LinkedList;

class ShowSummary {
	
	// TODO ALL DONE, WRITE TEST CASES
	LinkedList<Show> daytime;
	LinkedList<Show> primetime;
	LinkedList<Show> latenight;
	
	ShowSummary() 
	{
		this.daytime = new LinkedList<Show>();
		this.primetime = new LinkedList<Show>();
		this.latenight = new LinkedList<Show>();
	}
	
	ShowSummary(LinkedList<Show> daytime, LinkedList<Show> primetime, LinkedList<Show> latenight)
	{
		this.daytime = daytime;
		this.primetime = primetime;
		this.latenight = latenight;
	}

//LENGTH CHECK -- TESTED AND WORKS LIKE A TREAT
	//helper func
	private boolean isSameLength(Object showSummary) {
		ShowSummary aShowSummary = (ShowSummary) showSummary;
		return this.daytime.size() == aShowSummary.daytime.size()
							&&
				this.primetime.size() == aShowSummary.primetime.size()
				&&
				this.latenight.size() == aShowSummary.latenight.size();		
	}
	 

	//ORDER CHECK -- TESTED AND WORKS LIKE A TREAT -- HAVE TO INCORPERATE CHECKING IF SHOWS ARE THE SAME TOO

	
	public boolean equals(Object showSummary) {
		ShowSummary aShowSummary = (ShowSummary) showSummary;
		boolean result0 = true;
		boolean result1 = true;
		boolean result2 = true;
		if (this.isSameLength(aShowSummary) == true)
		{
		for(int i = 0; i < aShowSummary.daytime.size(); i++) {
			if(aShowSummary.daytime.get(i).equals(this.daytime.get(i)))
				result0 = result0 && true;
			else
				result0 = false;
		}
		//return result;
		for(int j = 0; j < aShowSummary.primetime.size(); j++) {
			if(aShowSummary.primetime.get(j).equals(this.primetime.get(j)))
				result1 = result1 && true;
			else
				result1 = false;
		}
		//return result1;
		for(int k = 0; k < aShowSummary.latenight.size(); k++) {
			if(aShowSummary.latenight.get(k).equals(this.latenight.get(k)))
				result2 = result2 && true;
			else
				result2 = false;
		}
	return result0 && result1 && result2 ;
}
		else
			return false;
	}
	
}