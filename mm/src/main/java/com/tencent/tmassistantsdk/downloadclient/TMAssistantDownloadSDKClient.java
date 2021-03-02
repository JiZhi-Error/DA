package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class TMAssistantDownloadSDKClient extends TMAssistantDownloadSDKClientBase {
    protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService";
    protected static final String TAG = "TMAssistantDownloadSDKClient";
    protected ReferenceQueue<ITMAssistantDownloadSDKClientListener> mListenerReferenceQueue = new ReferenceQueue<>();
    protected ArrayList<WeakReference<ITMAssistantDownloadSDKClientListener>> mWeakListenerArrayList = new ArrayList<>();

    public TMAssistantDownloadSDKClient(Context context, String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
        AppMethodBeat.i(101881);
        this.mServiceCallback = new ITMAssistantDownloadSDKServiceCallback.Stub() {
            /* class com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient.AnonymousClass1 */

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback
            public void OnDownloadSDKServiceTaskStateChanged(String str, String str2, int i2, int i3, String str3, boolean z, boolean z2) {
                AppMethodBeat.i(101879);
                TMLog.i(TMAssistantDownloadSDKClient.TAG, "OnDownloadStateChanged,clientKey:" + str + ",state:" + i2 + ", errorcode" + i3 + ",url:" + str2);
                Iterator<WeakReference<ITMAssistantDownloadSDKClientListener>> it = TMAssistantDownloadSDKClient.this.mWeakListenerArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference<ITMAssistantDownloadSDKClientListener> next = it.next();
                    ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener = next.get();
                    if (iTMAssistantDownloadSDKClientListener == null) {
                        TMLog.i(TMAssistantDownloadSDKClient.TAG, " listener = " + iTMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + next);
                    }
                    TMAssistantDownloadSDKMessageThread.getInstance().postTaskStateChangedMessage(TMAssistantDownloadSDKClient.this, iTMAssistantDownloadSDKClientListener, str2, i2, i3, str3, z, z2);
                }
                AppMethodBeat.o(101879);
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback
            public void OnDownloadSDKServiceTaskProgressChanged(String str, String str2, long j2, long j3) {
                AppMethodBeat.i(101880);
                TMLog.i(TMAssistantDownloadSDKClient.TAG, "OnDownloadProgressChanged,clientKey:" + str + ",receivedLen:" + j2 + ",totalLen:" + j3 + ",url:" + str2);
                Iterator<WeakReference<ITMAssistantDownloadSDKClientListener>> it = TMAssistantDownloadSDKClient.this.mWeakListenerArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference<ITMAssistantDownloadSDKClientListener> next = it.next();
                    ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener = next.get();
                    if (iTMAssistantDownloadSDKClientListener == null) {
                        TMLog.i(TMAssistantDownloadSDKClient.TAG, " listener = " + iTMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + next);
                    }
                    TMAssistantDownloadSDKMessageThread.getInstance().postTaskProgressChangedMessage(TMAssistantDownloadSDKClient.this, iTMAssistantDownloadSDKClientListener, str2, j2, j3);
                }
                AppMethodBeat.o(101880);
            }
        };
        AppMethodBeat.o(101881);
    }

    public synchronized TMAssistantDownloadTaskInfo getDownloadTaskState(String str) {
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
        AppMethodBeat.i(101882);
        TMLog.i(TAG, "getDownloadTaskState,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
            AppMethodBeat.o(101882);
            throw illegalArgumentException;
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            tMAssistantDownloadTaskInfo = iTMAssistantDownloadSDKServiceInterface.getDownloadTaskInfo(this.mClientKey, str);
            AppMethodBeat.o(101882);
        } else {
            super.initTMAssistantDownloadSDK();
            tMAssistantDownloadTaskInfo = null;
            AppMethodBeat.o(101882);
        }
        return tMAssistantDownloadTaskInfo;
    }

    public synchronized int startDownloadTask(String str, String str2) {
        int startDownloadTask;
        AppMethodBeat.i(101883);
        startDownloadTask = startDownloadTask(str, "", 0, 0, str2, null, true, null);
        AppMethodBeat.o(101883);
        return startDownloadTask;
    }

    public synchronized int startDownloadTask(String str, String str2, Map<String, String> map) {
        int startDownloadTask;
        AppMethodBeat.i(101884);
        startDownloadTask = startDownloadTask(str, "", 0, 0, str2, null, true, map);
        AppMethodBeat.o(101884);
        return startDownloadTask;
    }

    public synchronized int startDownloadTask(String str, String str2, String str3) {
        int startDownloadTask;
        AppMethodBeat.i(101885);
        startDownloadTask = startDownloadTask(str, "", 0, 0, str2, str3, true, null);
        AppMethodBeat.o(101885);
        return startDownloadTask;
    }

    public synchronized int startDownloadTask(String str, String str2, long j2, int i2, String str3, String str4, boolean z, Map<String, String> map) {
        int i3;
        AppMethodBeat.i(101886);
        TMLog.i(TAG, "startDownloadTask,clientKey:" + this.mClientKey + ",url:" + str + ",contentType:" + str3);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
            AppMethodBeat.o(101886);
            throw illegalArgumentException;
        } else if (!str3.equals("resource/tm.android.unknown") || !TextUtils.isEmpty(str4)) {
            ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
            if (iTMAssistantDownloadSDKServiceInterface != null) {
                iTMAssistantDownloadSDKServiceInterface.setServiceSetingIsDownloadWifiOnly(z);
                i3 = iTMAssistantDownloadSDKServiceInterface.startDownloadTask(this.mClientKey, str, str2, j2, 0, str3, str4, map);
                AppMethodBeat.o(101886);
            } else {
                TMLog.i(TAG, "startDownloadTask, serviceInterface is null");
                super.initTMAssistantDownloadSDK();
                i3 = 0;
                AppMethodBeat.o(101886);
            }
        } else {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
            AppMethodBeat.o(101886);
            throw illegalArgumentException2;
        }
        return i3;
    }

    public synchronized void pauseDownloadTask(String str) {
        AppMethodBeat.i(101887);
        TMLog.i(TAG, "pauseDownloadTask,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
            AppMethodBeat.o(101887);
            throw illegalArgumentException;
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.pauseDownloadTask(this.mClientKey, str);
            AppMethodBeat.o(101887);
        } else {
            TMLog.i(TAG, "pauseDownloadTask, serviceInterface is null");
            super.initTMAssistantDownloadSDK();
            AppMethodBeat.o(101887);
        }
    }

    public synchronized void cancelDownloadTask(String str) {
        AppMethodBeat.i(101888);
        TMLog.i(TAG, "cancelDownloadTask,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
            AppMethodBeat.o(101888);
            throw illegalArgumentException;
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.cancelDownloadTask(this.mClientKey, str);
            AppMethodBeat.o(101888);
        } else {
            TMLog.i(TAG, "cancelDownloadTask, serviceInterface is null");
            super.initTMAssistantDownloadSDK();
            AppMethodBeat.o(101888);
        }
    }

    public synchronized boolean registerDownloadTaskListener(ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener) {
        boolean z;
        AppMethodBeat.i(101889);
        if (iTMAssistantDownloadSDKClientListener != null) {
            while (true) {
                Reference<? extends ITMAssistantDownloadSDKClientListener> poll = this.mListenerReferenceQueue.poll();
                if (poll == null) {
                    break;
                }
                TMLog.i(TAG, "registerDownloadTaskListener removed listener!!!!");
                this.mWeakListenerArrayList.remove(poll);
            }
            Iterator<WeakReference<ITMAssistantDownloadSDKClientListener>> it = this.mWeakListenerArrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().get() == iTMAssistantDownloadSDKClientListener) {
                        AppMethodBeat.o(101889);
                        z = true;
                        break;
                    }
                } else {
                    this.mWeakListenerArrayList.add(new WeakReference<>(iTMAssistantDownloadSDKClientListener, this.mListenerReferenceQueue));
                    AppMethodBeat.o(101889);
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            AppMethodBeat.o(101889);
        }
        return z;
    }

    public synchronized boolean unRegisterDownloadTaskListener(ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener) {
        boolean z;
        AppMethodBeat.i(101890);
        if (iTMAssistantDownloadSDKClientListener != null) {
            Iterator<WeakReference<ITMAssistantDownloadSDKClientListener>> it = this.mWeakListenerArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    AppMethodBeat.o(101890);
                    z = false;
                    break;
                }
                WeakReference<ITMAssistantDownloadSDKClientListener> next = it.next();
                if (next.get() == iTMAssistantDownloadSDKClientListener) {
                    this.mWeakListenerArrayList.remove(next);
                    z = true;
                    AppMethodBeat.o(101890);
                    break;
                }
            }
        } else {
            AppMethodBeat.o(101890);
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void onDownloadSDKServiceInvalid() {
        AppMethodBeat.i(101891);
        Iterator<WeakReference<ITMAssistantDownloadSDKClientListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            TMAssistantDownloadSDKMessageThread.getInstance().postSDKServiceInvalidMessage(this, it.next().get());
        }
        AppMethodBeat.o(101891);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void stubAsInterface(IBinder iBinder) {
        AppMethodBeat.i(101892);
        this.mServiceInterface = ITMAssistantDownloadSDKServiceInterface.Stub.asInterface(iBinder);
        AppMethodBeat.o(101892);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void registerServiceCallback() {
        AppMethodBeat.i(101893);
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).registerDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
        AppMethodBeat.o(101893);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public Intent getBindServiceIntent() {
        AppMethodBeat.i(101894);
        Intent intent = new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
        AppMethodBeat.o(101894);
        return intent;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void unRegisterServiceCallback() {
        AppMethodBeat.i(101895);
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).unregisterDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
        AppMethodBeat.o(101895);
    }

    public static String about() {
        return "TMAssistantDownloadSDKClient_2014_03_06_11_20_release_25634";
    }
}
