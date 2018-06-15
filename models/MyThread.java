package models;

public abstract class MyThread implements Runnable{

	private Thread thread;
	private String name;
	private boolean stop;
	private boolean pause;
	
	public MyThread(String name) {
		this.name = name;
		thread = new Thread(this, this.name);
	}
	
	public void start(){
		thread.start();
	}
	
	public synchronized void stop(){
		pause = false;
		stop = true;
		notify();
		
	}
	
	public synchronized void pause(){
		pause = true;
	}
	
	public synchronized void resume(){
		pause = false;
		notify();
	}
	
	@Override
	public void run() {
		while (!stop) {
			executeTask();
			synchronized (this) {
				while (pause) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (stop)
					break;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	abstract void executeTask();
	
	public Thread getThread() {
		return thread;
	}
}