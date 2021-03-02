package com.tencent.midas.control;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;

public class APCallBackResultReceiver extends ResultReceiver {
    private Receiver mReceiver;

    public interface Receiver {
        void onReceiveResult(int i2, Bundle bundle);
    }

    public APCallBackResultReceiver(Handler handler) {
        super(handler);
    }

    public void setReceiver(Receiver receiver) {
        this.mReceiver = receiver;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        AppMethodBeat.i(192948);
        APLog.i("APCallBackResultReceiver", "onReceiveResult resultCode:" + i2 + " mReceiver:" + this.mReceiver);
        if (this.mReceiver != null) {
            this.mReceiver.onReceiveResult(i2, bundle);
        }
        AppMethodBeat.o(192948);
    }
}
