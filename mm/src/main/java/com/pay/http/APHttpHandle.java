package com.pay.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class APHttpHandle extends Handler {
    private static APHttpHandle handle;
    private static byte[] lock = new byte[0];
    private HashMap<String, IAPHttpAnsObserver> observerMap = new HashMap<>();

    private APHttpHandle() {
        AppMethodBeat.i(193278);
        AppMethodBeat.o(193278);
    }

    public static APHttpHandle getIntanceHandel() {
        AppMethodBeat.i(193279);
        synchronized (lock) {
            try {
                if (handle == null) {
                    try {
                        if (Thread.currentThread() != Looper.getMainLooper().getThread() && Looper.myLooper() == null) {
                            Looper.prepare();
                        }
                    } catch (Exception e2) {
                        APLog.i("APHttpHandle", e2.toString());
                    }
                    handle = new APHttpHandle();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(193279);
                throw th;
            }
        }
        APHttpHandle aPHttpHandle = handle;
        AppMethodBeat.o(193279);
        return aPHttpHandle;
    }

    public void release() {
        handle = null;
    }

    public void register(String str, IAPHttpAnsObserver iAPHttpAnsObserver) {
        AppMethodBeat.i(193280);
        if (this.observerMap != null) {
            this.observerMap.put(str, iAPHttpAnsObserver);
        }
        AppMethodBeat.o(193280);
    }

    public void unregister(String str) {
        AppMethodBeat.i(193281);
        if (this.observerMap != null) {
            this.observerMap.remove(str);
        }
        AppMethodBeat.o(193281);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(193282);
        runObserverOnMainThread(message);
        AppMethodBeat.o(193282);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void runObserverOnMainThread(Message message) {
        AppMethodBeat.i(193283);
        try {
            int i2 = message.what;
            APBaseHttpAns aPBaseHttpAns = (APBaseHttpAns) message.obj;
            String httpReqKey = aPBaseHttpAns.getHttpReqKey();
            IAPHttpAnsObserver iAPHttpAnsObserver = this.observerMap.get(httpReqKey);
            if (iAPHttpAnsObserver == null) {
                AppMethodBeat.o(193283);
                return;
            }
            unregister(httpReqKey);
            switch (i2) {
                case 3:
                    iAPHttpAnsObserver.onFinish(aPBaseHttpAns);
                    AppMethodBeat.o(193283);
                    return;
                case 4:
                    iAPHttpAnsObserver.onError(aPBaseHttpAns);
                    AppMethodBeat.o(193283);
                    return;
                case 5:
                    iAPHttpAnsObserver.onStop(aPBaseHttpAns);
                    break;
            }
            AppMethodBeat.o(193283);
        } catch (Exception e2) {
            AppMethodBeat.o(193283);
        }
    }
}
