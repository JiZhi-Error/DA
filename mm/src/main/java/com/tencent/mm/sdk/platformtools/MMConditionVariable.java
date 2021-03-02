package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMConditionVariable {
    private volatile boolean mCondition;

    public MMConditionVariable() {
        this.mCondition = false;
    }

    public MMConditionVariable(boolean z) {
        this.mCondition = z;
    }

    public void open() {
        AppMethodBeat.i(157615);
        synchronized (this) {
            try {
                boolean z = this.mCondition;
                this.mCondition = true;
                if (!z) {
                    notifyAll();
                }
            } finally {
                AppMethodBeat.o(157615);
            }
        }
    }

    public void close() {
        synchronized (this) {
            this.mCondition = false;
        }
    }

    public void block() {
        AppMethodBeat.i(157616);
        synchronized (this) {
            while (!this.mCondition) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException e2) {
                    }
                } finally {
                    AppMethodBeat.o(157616);
                }
            }
        }
    }

    public boolean block(long j2) {
        boolean z;
        AppMethodBeat.i(230336);
        if (j2 != 0) {
            synchronized (this) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = currentTimeMillis + j2;
                    while (!this.mCondition && currentTimeMillis < j3) {
                        try {
                            wait(j3 - currentTimeMillis);
                        } catch (InterruptedException e2) {
                        }
                        currentTimeMillis = System.currentTimeMillis();
                    }
                    z = this.mCondition;
                } finally {
                    AppMethodBeat.o(230336);
                }
            }
            return z;
        }
        block();
        AppMethodBeat.o(230336);
        return true;
    }

    public boolean isOpen() {
        return this.mCondition;
    }

    public String toString() {
        AppMethodBeat.i(157618);
        String str = "MMConditionVariable[" + hashCode() + "," + isOpen() + "]";
        AppMethodBeat.o(157618);
        return str;
    }
}
