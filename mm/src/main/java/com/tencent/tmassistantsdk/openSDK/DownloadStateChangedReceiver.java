package com.tencent.tmassistantsdk.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadStateChangedReceiver extends BroadcastReceiver {
    private static final String TAG = "DownloadStateChangedReceiver";
    protected static DownloadStateChangedReceiver mInstance = null;
    protected MMHandler handler;
    protected boolean isRegisted;
    ArrayList<IDownloadStateChangedListener> mListeners;

    public DownloadStateChangedReceiver() {
        AppMethodBeat.i(102086);
        this.handler = null;
        this.isRegisted = false;
        this.mListeners = new ArrayList<>();
        this.handler = new MMHandler("downloadStateChangedThread");
        AppMethodBeat.o(102086);
    }

    public static synchronized DownloadStateChangedReceiver getInstance() {
        DownloadStateChangedReceiver downloadStateChangedReceiver;
        synchronized (DownloadStateChangedReceiver.class) {
            AppMethodBeat.i(102087);
            if (mInstance == null) {
                mInstance = new DownloadStateChangedReceiver();
            }
            downloadStateChangedReceiver = mInstance;
            AppMethodBeat.o(102087);
        }
        return downloadStateChangedReceiver;
    }

    public void onReceive(Context context, final Intent intent) {
        AppMethodBeat.i(102088);
        if (this.handler != null) {
            this.handler.post(new Runnable() {
                /* class com.tencent.tmassistantsdk.openSDK.DownloadStateChangedReceiver.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(102085);
                    TMQQDownloaderStateChangeParam tMQQDownloaderStateChangeParam = new TMQQDownloaderStateChangeParam();
                    tMQQDownloaderStateChangeParam.hostPackageName = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_HOST_PAGECKAGENAME);
                    tMQQDownloaderStateChangeParam.hostVersion = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_HOST_VERSION);
                    tMQQDownloaderStateChangeParam.taskId = intent.getStringExtra("taskId");
                    tMQQDownloaderStateChangeParam.errorCode = Util.getInt(intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_ERROR_CODE), 0);
                    tMQQDownloaderStateChangeParam.errorMsg = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
                    tMQQDownloaderStateChangeParam.state = Util.getInt(intent.getStringExtra("state"), 0);
                    TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam();
                    tMQQDownloaderOpenSDKParam.SNGAppId = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_SNGAPPID);
                    tMQQDownloaderOpenSDKParam.taskAppId = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_APPID);
                    tMQQDownloaderOpenSDKParam.taskApkId = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_APKID);
                    tMQQDownloaderOpenSDKParam.taskPackageName = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_PACKAGENAME);
                    tMQQDownloaderOpenSDKParam.taskVersion = Util.getInt(intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_VERSION), 0);
                    tMQQDownloaderOpenSDKParam.via = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_VIA);
                    tMQQDownloaderOpenSDKParam.uin = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_UIN);
                    tMQQDownloaderOpenSDKParam.uinType = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_UINTYPE);
                    tMQQDownloaderStateChangeParam.param = tMQQDownloaderOpenSDKParam;
                    Iterator<IDownloadStateChangedListener> it = DownloadStateChangedReceiver.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onDownloadStateChanged(tMQQDownloaderStateChangeParam);
                    }
                    AppMethodBeat.o(102085);
                }
            });
        }
        AppMethodBeat.o(102088);
    }

    public void registeReceiver(Context context) {
        AppMethodBeat.i(102089);
        if (!this.isRegisted) {
            TMLog.i(TAG, "registeReceiver   context" + context + "  receiver:" + this);
            try {
                TMLog.i(TAG, String.valueOf(context.registerReceiver(this, new IntentFilter(OpenSDKTool4Assistant.OPENSDK_ACTION_NAME))));
                this.isRegisted = true;
                AppMethodBeat.o(102089);
                return;
            } catch (Throwable th) {
                TMLog.i(TAG, "registeReceiver exception!!!");
                this.isRegisted = false;
                Log.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102089);
    }

    public void unRegisteReceiver(Context context) {
        AppMethodBeat.i(102090);
        if (context == null || mInstance == null) {
            AppMethodBeat.o(102090);
            return;
        }
        if (this.isRegisted) {
            TMLog.i(TAG, "realy unRegisteReceiver  context:" + context + "  receiver:" + this);
            try {
                context.unregisterReceiver(this);
                this.isRegisted = false;
                AppMethodBeat.o(102090);
                return;
            } catch (Throwable th) {
                TMLog.i(TAG, "unRegisteReceiver exception!!!");
                this.isRegisted = false;
                Log.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102090);
    }

    public void addDownloadStateChangedListener(IDownloadStateChangedListener iDownloadStateChangedListener) {
        AppMethodBeat.i(102091);
        if (iDownloadStateChangedListener != null && !this.mListeners.contains(iDownloadStateChangedListener)) {
            this.mListeners.add(iDownloadStateChangedListener);
        }
        AppMethodBeat.o(102091);
    }

    public void removeDownloadStateChangedListener(IDownloadStateChangedListener iDownloadStateChangedListener) {
        AppMethodBeat.i(102092);
        if (iDownloadStateChangedListener != null) {
            this.mListeners.remove(iDownloadStateChangedListener);
        }
        AppMethodBeat.o(102092);
    }
}
