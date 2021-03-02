package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.a.a.a.a;
import com.tencent.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tmassistantsdk.util.Base64;
import com.tencent.tmassistantsdk.util.Cryptor;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadOpenSDKClient extends TMAssistantDownloadSDKClientBase {
    protected static final String TAG = "TMAssistantDownloadOpenSDKClient";
    private byte _hellAccFlag_;
    ArrayList<IAssistantOnActionListener> mListeners = new ArrayList<>();
    protected boolean retryBindResult = false;
    protected int retryCount = 0;

    public TMAssistantDownloadOpenSDKClient(Context context, String str, String str2) {
        super(context, str, str2);
        AppMethodBeat.i(101869);
        this.mServiceCallback = new b.a() {
            /* class com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadOpenSDKClient.AnonymousClass1 */

            @Override // com.tencent.a.a.a.b
            public void onActionResult(byte[] bArr) {
                AppMethodBeat.i(101867);
                TMLog.i(TMAssistantDownloadOpenSDKClient.TAG, "onActionResult  callBack data:" + bArr + "  mListeners.size:" + TMAssistantDownloadOpenSDKClient.this.mListeners.size());
                TMAssistantDownloadSDKMessageThread.getInstance().postActionResult(bArr, TMAssistantDownloadOpenSDKClient.this.mListeners);
                AppMethodBeat.o(101867);
            }
        };
        AppMethodBeat.o(101869);
    }

    public byte[] sendSyncData(byte[] bArr) {
        a aVar;
        AppMethodBeat.i(101870);
        if (TextUtils.isEmpty(this.mClientKey) || (aVar = (a) super.getServiceInterface()) == null) {
            AppMethodBeat.o(101870);
            return null;
        }
        byte[] b2 = aVar.b(this.mClientKey, bArr);
        AppMethodBeat.o(101870);
        return b2;
    }

    public void sendAsyncData(byte[] bArr) {
        a aVar;
        AppMethodBeat.i(101871);
        if (!TextUtils.isEmpty(this.mClientKey) && (aVar = (a) super.getServiceInterface()) != null) {
            aVar.c(this.mClientKey, bArr);
        }
        AppMethodBeat.o(101871);
    }

    public void addAssistantOnActionListener(IAssistantOnActionListener iAssistantOnActionListener) {
        AppMethodBeat.i(101872);
        TMLog.i(TAG, "addAssistantOnActionListener");
        if (iAssistantOnActionListener != null && !this.mListeners.contains(iAssistantOnActionListener)) {
            this.mListeners.add(iAssistantOnActionListener);
        }
        AppMethodBeat.o(101872);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void onDownloadSDKServiceInvalid() {
        AppMethodBeat.i(101873);
        if (this.mListeners != null && this.mListeners.size() > 0) {
            Iterator<IAssistantOnActionListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                IAssistantOnActionListener next = it.next();
                if (next != null) {
                    next.onDownloadSDKServiceInvalid();
                }
            }
        }
        AppMethodBeat.o(101873);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void stubAsInterface(IBinder iBinder) {
        AppMethodBeat.i(101874);
        this.mServiceInterface = a.AbstractBinderC0128a.k(iBinder);
        AppMethodBeat.o(101874);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void registerServiceCallback() {
        AppMethodBeat.i(101875);
        String encodeToString = Base64.encodeToString(new Cryptor().encrypt(String.valueOf(System.currentTimeMillis()).getBytes(), this.mClientKey.getBytes()), 0);
        int a2 = ((a) this.mServiceInterface).a(this.mClientKey, encodeToString, (b) this.mServiceCallback);
        TMLog.i(TAG, "onServiceConnected,registerActionCallback:" + this.mClientKey + ",tokenString:" + encodeToString + ",threadId:" + Thread.currentThread().getId() + ",mServiceCallback:" + this.mServiceCallback + ",registed result:" + a2);
        if (a2 == 2) {
            onDownloadSDKServiceInvalid();
        }
        AppMethodBeat.o(101875);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public Intent getBindServiceIntent() {
        AppMethodBeat.i(101876);
        Intent intent = new Intent(this.mDwonloadServiceName);
        intent.setPackage("com.tencent.android.qqdownloader");
        AppMethodBeat.o(101876);
        return intent;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public void unRegisterServiceCallback() {
        AppMethodBeat.i(101877);
        if (((a) this.mServiceInterface).a((b) this.mServiceCallback) == 2) {
            onDownloadSDKServiceInvalid();
        }
        AppMethodBeat.o(101877);
    }

    @Override // com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
    public synchronized boolean initTMAssistantDownloadSDK() {
        boolean initTMAssistantDownloadSDK;
        AppMethodBeat.i(101878);
        initTMAssistantDownloadSDK = super.initTMAssistantDownloadSDK();
        TMLog.i(TAG, "initTMAssistantDownloadSDK bindResult:".concat(String.valueOf(initTMAssistantDownloadSDK)));
        if (!initTMAssistantDownloadSDK) {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
                intent.addFlags(268435456);
                Context context = this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } catch (Exception e2) {
                TMLog.w(TAG, "retry bind service startActivity Exception:" + e2.toString());
            }
            final MMHandler mMHandler = new MMHandler("retry_thread");
            mMHandler.postDelayed(new Runnable() {
                /* class com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadOpenSDKClient.AnonymousClass2 */

                public void run() {
                    AppMethodBeat.i(101868);
                    try {
                        TMAssistantDownloadOpenSDKClient.this.retryBindResult = TMAssistantDownloadOpenSDKClient.this.mContext.bindService(TMAssistantDownloadOpenSDKClient.this.getBindServiceIntent(), TMAssistantDownloadOpenSDKClient.this, 1);
                    } catch (Exception e2) {
                        TMLog.e(TMAssistantDownloadOpenSDKClient.TAG, "retry bind service Exception:" + e2.toString());
                    }
                    TMAssistantDownloadOpenSDKClient.this.retryCount++;
                    TMLog.i(TMAssistantDownloadOpenSDKClient.TAG, "retry bind service! retryBindResult:" + TMAssistantDownloadOpenSDKClient.this.retryBindResult + ",retryCount:" + TMAssistantDownloadOpenSDKClient.this.retryCount);
                    if (!TMAssistantDownloadOpenSDKClient.this.retryBindResult && TMAssistantDownloadOpenSDKClient.this.retryCount < 3) {
                        mMHandler.postDelayed(this, 1000);
                    }
                    AppMethodBeat.o(101868);
                }
            }, 1000);
        }
        AppMethodBeat.o(101878);
        return initTMAssistantDownloadSDK;
    }

    public static String about() {
        return "TMAssistantDownloadOpenSDKClient_2014_03_06_11_20_release_25634";
    }
}
