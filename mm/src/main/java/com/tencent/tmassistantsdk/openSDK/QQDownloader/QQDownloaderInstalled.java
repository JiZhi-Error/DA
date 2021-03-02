package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.util.TMLog;

public class QQDownloaderInstalled extends BroadcastReceiver {
    private static final String TAG = "QQDownloaderInstalled";
    protected static QQDownloaderInstalled mInstance = null;
    protected boolean isRegisted = false;
    protected IQQDownloaderInstalled mListener = null;

    public interface IQQDownloaderInstalled {
        void onQQDownloaderInstalled(Context context);
    }

    private QQDownloaderInstalled() {
    }

    public static synchronized QQDownloaderInstalled getInstance() {
        QQDownloaderInstalled qQDownloaderInstalled;
        synchronized (QQDownloaderInstalled.class) {
            AppMethodBeat.i(102098);
            if (mInstance == null) {
                mInstance = new QQDownloaderInstalled();
            }
            qQDownloaderInstalled = mInstance;
            AppMethodBeat.o(102098);
        }
        return qQDownloaderInstalled;
    }

    public void onReceive(final Context context, Intent intent) {
        AppMethodBeat.i(102099);
        TMLog.i(TAG, "onReceive!");
        h.RTc.ba(new Runnable() {
            /* class com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(102097);
                if (QQDownloaderInstalled.this.mListener != null) {
                    QQDownloaderInstalled.this.mListener.onQQDownloaderInstalled(context);
                }
                AppMethodBeat.o(102097);
            }
        });
        AppMethodBeat.o(102099);
    }

    public void registeReceiver(Context context) {
        AppMethodBeat.i(102100);
        if (!this.isRegisted) {
            TMLog.i(TAG, "registeReceiver   context" + context + "  receiver:" + this);
            try {
                this.isRegisted = true;
                AppMethodBeat.o(102100);
                return;
            } catch (Throwable th) {
                TMLog.i(TAG, "registeReceiver exception!!!");
                this.isRegisted = false;
                Log.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102100);
    }

    public void unRegisteReceiver(Context context) {
        AppMethodBeat.i(102101);
        if (context == null || mInstance == null) {
            AppMethodBeat.o(102101);
            return;
        }
        if (this.isRegisted) {
            TMLog.i(TAG, "realy unRegisteReceiver  context:" + context + "  receiver:" + this);
            try {
                this.isRegisted = false;
                AppMethodBeat.o(102101);
                return;
            } catch (Throwable th) {
                TMLog.i(TAG, "unRegisteReceiver exception!!!");
                this.isRegisted = false;
                Log.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102101);
    }

    public void registeListener(IQQDownloaderInstalled iQQDownloaderInstalled) {
        this.mListener = iQQDownloaderInstalled;
    }

    public void unregisteListener() {
        this.mListener = null;
    }
}
