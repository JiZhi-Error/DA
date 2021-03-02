package com.tencent.thumbplayer.api;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TPPlayerState {
    public static final int COMPLETE = 7;
    public static final int ERROR = 10;
    public static final int IDLE = 1;
    public static final int INDEX = 0;
    public static final int INITIALIZED = 2;
    private static final SparseArray<String> NS_STATES;
    public static final int PAUSE = 6;
    public static final int PREPARED = 4;
    public static final int PREPARING = 3;
    public static final int RELEASED = 11;
    public static final int START = 5;
    public static final int STOPPED = 9;
    public static final int STOPPING = 8;
    private int mCurState = 1;
    private int mInnerPlayState = 1;
    private int mLastState = 1;
    private int mPreState = 1;
    private c.h mStateChangeListener;

    @Retention(RetentionPolicy.SOURCE)
    public @interface STATE {
    }

    static {
        AppMethodBeat.i(189047);
        SparseArray<String> sparseArray = new SparseArray<>();
        NS_STATES = sparseArray;
        sparseArray.put(1, "IDLE");
        NS_STATES.put(2, "INITIALIZED");
        NS_STATES.put(3, "PREPARING");
        NS_STATES.put(4, "PREPARED");
        NS_STATES.put(5, "START");
        NS_STATES.put(6, "PAUSE");
        NS_STATES.put(7, "COMPLETE");
        NS_STATES.put(8, "STOPPING");
        NS_STATES.put(9, "STOPPED");
        NS_STATES.put(10, "ERROR");
        NS_STATES.put(11, "RELEASED");
        AppMethodBeat.o(189047);
    }

    public synchronized void changeState(int i2) {
        AppMethodBeat.i(189045);
        if (this.mCurState != i2) {
            this.mPreState = this.mCurState;
            this.mCurState = i2;
            if (this.mStateChangeListener != null) {
                this.mStateChangeListener.onStateChange(this.mPreState, this.mCurState);
            }
        }
        AppMethodBeat.o(189045);
    }

    public synchronized void setLastState(int i2) {
        if (this.mLastState != i2) {
            this.mLastState = i2;
        }
    }

    public synchronized void setInnerPlayStateState(int i2) {
        if (this.mInnerPlayState != i2) {
            this.mInnerPlayState = i2;
        }
    }

    public synchronized int state() {
        return this.mCurState;
    }

    public synchronized int lastState() {
        return this.mLastState;
    }

    public synchronized int preState() {
        return this.mPreState;
    }

    public synchronized int innerPlayState() {
        return this.mInnerPlayState;
    }

    public synchronized boolean is(int i2) {
        return this.mCurState == i2;
    }

    public void setOnPlayerStateChangeListener(c.h hVar) {
        this.mStateChangeListener = hVar;
    }

    public synchronized String toString() {
        String str;
        AppMethodBeat.i(189046);
        str = "state[ cur : " + NS_STATES.get(this.mCurState) + " , pre : " + NS_STATES.get(this.mPreState) + " , last : " + NS_STATES.get(this.mLastState) + " , inner play : " + NS_STATES.get(this.mInnerPlayState) + " ]";
        AppMethodBeat.o(189046);
        return str;
    }
}
