package com.tencent.tav.decoder;

import com.tencent.tav.decoder.logger.Logger;

public abstract class ReActionThread extends Thread {
    private static final String TAG = "ReActionThread";
    private boolean hasAction = false;
    private boolean release = false;

    /* access modifiers changed from: protected */
    public abstract void doAction();

    public ReActionThread(String str) {
        super(str);
    }

    public void action() {
        this.hasAction = true;
        synchronized (this) {
            notifyAll();
        }
        Logger.v(TAG, "action: " + this + " " + hashCode());
    }

    public synchronized void release() {
        if (!this.release) {
            this.release = true;
            synchronized (this) {
                notifyAll();
                try {
                    synchronized (this) {
                        wait(20);
                    }
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    public void run() {
        Logger.d(TAG, "run start: " + this + " " + hashCode());
        while (!this.release) {
            while (!this.hasAction && !this.release) {
                synchronized (this) {
                    try {
                        wait(10);
                    } catch (InterruptedException e2) {
                    }
                }
            }
            this.hasAction = false;
            if (!this.release) {
                doAction();
            }
            synchronized (this) {
                notifyAll();
            }
        }
        Logger.d(TAG, "run finish: " + this + " " + hashCode());
    }
}
