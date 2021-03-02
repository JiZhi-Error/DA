package com.tencent.tmassistantsdk.downloadclient;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.util.ParamPair;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKMessageThread extends MMHandler {
    private static TMAssistantDownloadSDKMessageThread mInstance = null;
    private static HandlerThread mMessagehandlerThread = null;
    private static final int postActionResult = 4;
    private static final int postSDKServiceInvalidMessage = 3;
    private static final int postTaskProgressChangedMessage = 2;
    private static final int postTaskStateChangedMessage = 1;

    private TMAssistantDownloadSDKMessageThread(a aVar) {
        super(aVar);
    }

    public static synchronized TMAssistantDownloadSDKMessageThread getInstance() {
        TMAssistantDownloadSDKMessageThread tMAssistantDownloadSDKMessageThread;
        synchronized (TMAssistantDownloadSDKMessageThread.class) {
            AppMethodBeat.i(101903);
            if (mInstance == null) {
                mInstance = new TMAssistantDownloadSDKMessageThread(a.bqt("TMAssistantDownloadSDKMessageThread"));
            }
            tMAssistantDownloadSDKMessageThread = mInstance;
            AppMethodBeat.o(101903);
        }
        return tMAssistantDownloadSDKMessageThread;
    }

    @Override // com.tencent.mm.sdk.platformtools.MMHandler
    public void handleMessage(Message message) {
        AppMethodBeat.i(101904);
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                ParamPair paramPair = (ParamPair) message.obj;
                T t = paramPair.mFirstParam;
                V v = paramPair.mSecondParam;
                Bundle data = message.getData();
                String string = data.getString("url");
                int i2 = data.getInt("state");
                int i3 = data.getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE);
                String string2 = data.getString(OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
                boolean z = data.getBoolean("hasChangeUrl");
                boolean z2 = data.getBoolean("autoRetry");
                if (v != null) {
                    v.OnDownloadSDKTaskStateChanged(t, string, i2, i3, string2, z, z2);
                    AppMethodBeat.o(101904);
                    return;
                }
                break;
            case 2:
                ParamPair paramPair2 = (ParamPair) message.obj;
                T t2 = paramPair2.mFirstParam;
                V v2 = paramPair2.mSecondParam;
                Bundle data2 = message.getData();
                String string3 = data2.getString("url");
                long j2 = data2.getLong("receiveDataLen");
                long j3 = data2.getLong("totalDataLen");
                if (v2 != null) {
                    v2.OnDownloadSDKTaskProgressChanged(t2, string3, j2, j3);
                    AppMethodBeat.o(101904);
                    return;
                }
                break;
            case 3:
                ParamPair paramPair3 = (ParamPair) message.obj;
                T t3 = paramPair3.mFirstParam;
                V v3 = paramPair3.mSecondParam;
                if (v3 != null) {
                    v3.OnDwonloadSDKServiceInvalid(t3);
                    AppMethodBeat.o(101904);
                    return;
                }
                break;
            case 4:
                ParamPair paramPair4 = (ParamPair) message.obj;
                byte[] bArr = (byte[]) paramPair4.mFirstParam;
                V v4 = paramPair4.mSecondParam;
                if (v4 != null) {
                    Iterator it = v4.iterator();
                    while (it.hasNext()) {
                        IAssistantOnActionListener iAssistantOnActionListener = (IAssistantOnActionListener) it.next();
                        if (iAssistantOnActionListener != null) {
                            iAssistantOnActionListener.onActionResult(bArr);
                        }
                    }
                    break;
                }
                break;
        }
        AppMethodBeat.o(101904);
    }

    public void postTaskStateChangedMessage(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener, String str, int i2, int i3, String str2, boolean z, boolean z2) {
        AppMethodBeat.i(101905);
        if (iTMAssistantDownloadSDKClientListener == null || tMAssistantDownloadSDKClient == null) {
            AppMethodBeat.o(101905);
            return;
        }
        Message obtainMessage = getInstance().obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = new ParamPair(tMAssistantDownloadSDKClient, iTMAssistantDownloadSDKClientListener);
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putInt("state", i2);
        bundle.putInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i3);
        bundle.putString(OpenSDKTool4Assistant.EXTRA_ERROR_MSG, str2);
        bundle.putBoolean("hasChangeUrl", z);
        bundle.putBoolean("autoRetry", z2);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
        AppMethodBeat.o(101905);
    }

    public void postTaskProgressChangedMessage(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener, String str, long j2, long j3) {
        AppMethodBeat.i(101906);
        if (iTMAssistantDownloadSDKClientListener == null || tMAssistantDownloadSDKClient == null) {
            TMLog.i("TMAssistantDownloadSDKMessageThread", "listenr:" + iTMAssistantDownloadSDKClientListener + " === sdkClient" + tMAssistantDownloadSDKClient);
            AppMethodBeat.o(101906);
            return;
        }
        Message obtainMessage = getInstance().obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.obj = new ParamPair(tMAssistantDownloadSDKClient, iTMAssistantDownloadSDKClientListener);
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putLong("receiveDataLen", j2);
        bundle.putLong("totalDataLen", j3);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
        AppMethodBeat.o(101906);
    }

    public void postSDKServiceInvalidMessage(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener) {
        AppMethodBeat.i(101907);
        if (iTMAssistantDownloadSDKClientListener == null || tMAssistantDownloadSDKClient == null) {
            AppMethodBeat.o(101907);
            return;
        }
        Message obtainMessage = getInstance().obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.obj = new ParamPair(tMAssistantDownloadSDKClient, iTMAssistantDownloadSDKClientListener);
        obtainMessage.sendToTarget();
        AppMethodBeat.o(101907);
    }

    public void postActionResult(byte[] bArr, ArrayList<IAssistantOnActionListener> arrayList) {
        AppMethodBeat.i(101908);
        if (!(bArr == null || arrayList == null)) {
            Message obtainMessage = getInstance().obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.obj = new ParamPair(bArr, arrayList);
            obtainMessage.sendToTarget();
        }
        AppMethodBeat.o(101908);
    }
}
