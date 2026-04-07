
public class ThoseAreSomeFancyThreadsMain {

	public static void main(String[] args) {
		
		//"Indicate running 
		System.out.println("Running single threaded maths right meow");
		
		//Start Timer
		long startTime = System.nanoTime();
		
		//Do the math
		SingleThreadedMath.runTheMaths("mathProblemsTotal.txt", "mathSolutionsTotal.txt");
		
		//End the Time
		long endTime = System.nanoTime();

		long singleThreadedTime = (endTime-startTime);
		System.out.println("Done! It took " + singleThreadedTime + " nanoseconds to complete the maths single threadedly");
		
		
		//get the threads ready...
		MultiThreadedMaths thread1 = new MultiThreadedMaths("mathProblemsSplit1.txt", "mathSolutionsSplit1.txt");
		MultiThreadedMaths thread2 = new MultiThreadedMaths("mathProblemsSplit2.txt", "mathSolutionsSplit2.txt");
		
		System.out.println("Running 2 threaded maths right meow");
		
		//start the timer
		startTime = System.nanoTime();
		
		//Fire up thread1
		thread1.start();
		
		//Fire up thread2
		thread2.start();
		
		//while either of the threads is still alive and processing, let this thread sleep for a millisecond then check again
		while(thread1.isAlive() || thread2.isAlive())
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//Done!
		endTime = System.nanoTime();
		
		long dualThreadedTime = (endTime-startTime);
		System.out.println("Done! It took " + dualThreadedTime + " nanoseconds to complete the maths with 2 threads");
		
		long timeDifference = (singleThreadedTime - dualThreadedTime);
		System.out.println(".Single Threaded Time - Dual Threaded Time = " + timeDifference + " nanoseconds");
		System.out.println(".Dual Threaded was approximately " + ((double)singleThreadedTime/dualThreadedTime)*100 + "% faster");
		}
		

}
