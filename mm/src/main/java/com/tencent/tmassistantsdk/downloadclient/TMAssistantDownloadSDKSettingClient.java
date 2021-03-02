package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface;

public class TMAssistantDownloadSDKSettingClient extends TMAssistantDownloadSDKClientBase {
    protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.TMAssistantDownloadSDKService";

    public TMAssistantDownloadSDKSettingClient(Context context, String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
    }

    public synchronized int getVersion() {
        int i2;
        AppMethodBeat.i(101909);
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            i2 = iTMAssistantDownloadSDKServiceInterface.getServiceVersion();
            AppMethodBeat.o(101909);
        } else {
            super.initTMAssistantDownloadSDK();
            i2 = 0;
            AppMethodBeat.o(101909);
        }
        return i2;
    }

    public synchronized void setDownloadSDKWifiOnly(boolean z) {
        AppMethodBeat.i(101910);
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.setServiceSetingIsDownloadWifiOnly(z);
            AppMethodBeat.o(101910);
        } else {
            super.initTMAssistantDownloadSDK();
            AppMethodBeat.o(101910);
        }
    }

    public synchronized void setDownloadSDKMaxTaskNum(int i2) {
        AppMethodBeat.i(101911);
        if (i2 <= 0 || i2 > 10) {
            AppMethodBeat.o(101911);
        } else {
            ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
            if (iTMAssistantDownloadSDKServiceInterface != null) {
                iTMAssistantDownloadSDKServiceInterface.setServiceSetingMaxTaskNum(i2);
                AppMethodBeat.o(101911);
            } else {
                super.initTMAssistantDownloadSDK();
                AppMethodBeat.o(101911);
            }
        }
    }

    public synchronized boolean isAllDownloadFinished() {
        boolean z;
        AppMethodBeat.i(101912);
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            z = iTMAssistantDownloadSDKServiceInterface.isAllDownloadFinished();
        } else {
            super.initTMAssistantDownloadSDK();
            z = false;
        }
        AppMethodBeat.o(101912);
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void onDownloadSDKServiceInvalid() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void stubAsInterface(IBinder iBinder) {
        AppMethodBeat.i(101913);
        this.mServiceInterface = ITMAssistantDownloadSDKServiceInterface.Stub.asInterface(iBinder);
        AppMethodBeat.o(101913);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void registerServiceCallback() {
        AppMethodBeat.i(101914);
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).registerDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
        AppMethodBeat.o(101914);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public Intent getBindServiceIntent() {
        AppMethodBeat.i(101915);
        Intent intent = new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
        AppMethodBeat.o(101915);
        return intent;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void unRegisterServiceCallback() {
        AppMethodBeat.i(101916);
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).unregisterDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
        AppMethodBeat.o(101916);
    }
}
