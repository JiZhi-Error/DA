package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MTimerHandler extends MMHandler {
    private static final int MAX_TIMERID = 8192;
    private static final String TAG = "MicroMsg.MTimerHandler";
    private static int timerID;
    private final CallBack mCallBack;
    private final boolean mLoop;
    private long mLoopInterval = 0;
    private boolean mStop = false;
    private final int myTimerID;

    public interface CallBack {
        boolean onTimerExpired();
    }

    public MTimerHandler(CallBack callBack, boolean z) {
        AppMethodBeat.i(157715);
        this.mCallBack = callBack;
        this.myTimerID = incTimerID();
        this.mLoop = z;
        if (Thread.currentThread().getName().equals("initThread") || "initThread".equals(a.hmF())) {
            Log.e(TAG, "MTimerHandler can not init handler with initThread, stack %s", Util.getStack());
        }
        AppMethodBeat.o(157715);
    }

    public MTimerHandler(Looper looper, CallBack callBack, boolean z) {
        super(looper);
        AppMethodBeat.i(157716);
        this.mCallBack = callBack;
        this.myTimerID = incTimerID();
        this.mLoop = z;
        if (Thread.currentThread().getName().equals("initThread") || "initThread".equals(a.hmF())) {
            Log.e(TAG, "MTimerHandler can not init handler with initThread, stack %s", Util.getStack());
        }
        AppMethodBeat.o(157716);
    }

    public MTimerHandler(String str, CallBack callBack, boolean z) {
        super(str);
        AppMethodBeat.i(182965);
        this.mCallBack = callBack;
        this.myTimerID = incTimerID();
        this.mLoop = z;
        AppMethodBeat.o(182965);
    }

    public MTimerHandler(a aVar, CallBack callBack, boolean z) {
        super(aVar);
        AppMethodBeat.i(182966);
        this.mCallBack = callBack;
        this.myTimerID = incTimerID();
        this.mLoop = z;
        AppMethodBeat.o(182966);
    }

    private static int incTimerID() {
        if (timerID >= 8192) {
            timerID = 0;
        }
        int i2 = timerID + 1;
        timerID = i2;
        return i2;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(157717);
        stopTimer();
        super.finalize();
        AppMethodBeat.o(157717);
    }

    @Override // com.tencent.mm.sdk.platformtools.MMHandler
    public void handleMessage(Message message) {
        AppMethodBeat.i(157718);
        if (message.what == this.myTimerID) {
            if (this.mCallBack == null) {
                AppMethodBeat.o(157718);
                return;
            } else if (!this.mCallBack.onTimerExpired()) {
                AppMethodBeat.o(157718);
                return;
            } else if (this.mLoop && !this.mStop) {
                sendEmptyMessageDelayed(this.myTimerID, this.mLoopInterval);
            }
        }
        AppMethodBeat.o(157718);
    }

    public void startTimer(long j2) {
        AppMethodBeat.i(186051);
        startTimer(j2, j2);
        AppMethodBeat.o(186051);
    }

    public void stopTimer() {
        AppMethodBeat.i(157720);
        removeMessages(this.myTimerID);
        this.mStop = true;
        AppMethodBeat.o(157720);
    }

    public void startTimer(long j2, long j3) {
        AppMethodBeat.i(157721);
        this.mLoopInterval = j3;
        stopTimer();
        this.mStop = false;
        sendEmptyMessageDelayed(this.myTimerID, j2);
        AppMethodBeat.o(157721);
    }

    public boolean stopped() {
        AppMethodBeat.i(157722);
        if (this.mStop || !hasMessages(this.myTimerID)) {
            AppMethodBeat.o(157722);
            return true;
        }
        AppMethodBeat.o(157722);
        return false;
    }

    @Override // com.tencent.mm.sdk.platformtools.MMHandler
    public String toString() {
        AppMethodBeat.i(157723);
        if (this.mCallBack == null) {
            String str = "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
            AppMethodBeat.o(157723);
            return str;
        }
        String str2 = "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.mCallBack.getClass().getName() + "}";
        AppMethodBeat.o(157723);
        return str2;
    }
}
