package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Locker {
    private boolean released = false;
    private V8 runtime;
    private Thread thread = null;

    V8Locker(V8 v8) {
        AppMethodBeat.i(62127);
        this.runtime = v8;
        acquire();
        AppMethodBeat.o(62127);
    }

    public Thread getThread() {
        return this.thread;
    }

    public synchronized void acquire() {
        AppMethodBeat.i(62128);
        if (this.thread != null && this.thread != Thread.currentThread()) {
            Error error = new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
            AppMethodBeat.o(62128);
            throw error;
        } else if (this.thread == Thread.currentThread()) {
            AppMethodBeat.o(62128);
        } else {
            this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
            this.thread = Thread.currentThread();
            this.released = false;
            AppMethodBeat.o(62128);
        }
    }

    public synchronized boolean tryAcquire() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(62129);
            if (this.thread != null && this.thread != Thread.currentThread()) {
                AppMethodBeat.o(62129);
            } else if (this.thread == Thread.currentThread()) {
                AppMethodBeat.o(62129);
                z = true;
            } else {
                this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
                this.thread = Thread.currentThread();
                this.released = false;
                AppMethodBeat.o(62129);
                z = true;
            }
        }
        return z;
    }

    public synchronized void release() {
        AppMethodBeat.i(62130);
        if ((!this.released || this.thread != null) && !this.runtime.isReleased()) {
            checkThread();
            this.runtime.releaseLock(this.runtime.getV8RuntimePtr());
            this.thread = null;
            this.released = true;
            AppMethodBeat.o(62130);
        } else {
            AppMethodBeat.o(62130);
        }
    }

    public void checkThread() {
        AppMethodBeat.i(62131);
        if (this.released && this.thread == null) {
            Error error = new Error("Invalid V8 thread access: the locker has been released!");
            AppMethodBeat.o(62131);
            throw error;
        } else if (this.thread != Thread.currentThread()) {
            Error error2 = new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
            AppMethodBeat.o(62131);
            throw error2;
        } else {
            AppMethodBeat.o(62131);
        }
    }

    public boolean hasLock() {
        AppMethodBeat.i(62132);
        if (this.thread == Thread.currentThread()) {
            AppMethodBeat.o(62132);
            return true;
        }
        AppMethodBeat.o(62132);
        return false;
    }
}
