package utils;

public class TestExecutionManager 
{
	private static boolean stopExecution = false;

    public static void stopExecution() {
        stopExecution = true;
    }

    public static boolean isExecutionStopped() {
        return stopExecution;
    }
}
