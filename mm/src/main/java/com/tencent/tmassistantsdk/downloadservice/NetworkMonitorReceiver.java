package com.tencent.tmassistantsdk.downloadservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class NetworkMonitorReceiver extends BroadcastReceiver {
    protected static final int MSG_DELAY_TIME = 3500;
    protected static final int MSG_resumeDownloadTime = 67;
    protected static final String TAG = "NetworkMonitorReceiver";
    protected static NetworkMonitorReceiver mInstance = null;
    protected boolean isRegisterReceiver = false;
    protected final MMHandler mNetworkChangedHandler = new MMHandler() {
        /* class com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public void handleMessage(Message message) {
            AppMethodBeat.i(102016);
            super.handleMessage(message);
            switch (message.what) {
                case 67:
                    NetworkMonitorReceiver.this.notifyNetworkChanged();
                    break;
            }
            AppMethodBeat.o(102016);
        }
    };
    ArrayList<INetworkChangedObserver> mObs = new ArrayList<>();

    public interface INetworkChangedObserver {
        void onNetworkChanged();
    }

    public NetworkMonitorReceiver() {
        AppMethodBeat.i(102017);
        AppMethodBeat.o(102017);
    }

    public static synchronized NetworkMonitorReceiver getInstance() {
        NetworkMonitorReceiver networkMonitorReceiver;
        synchronized (NetworkMonitorReceiver.class) {
            AppMethodBeat.i(102018);
            if (mInstance == null) {
                mInstance = new NetworkMonitorReceiver();
            }
            networkMonitorReceiver = mInstance;
            AppMethodBeat.o(102018);
        }
        return networkMonitorReceiver;
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(102019);
        TMLog.i(TAG, "network changed!");
        this.mNetworkChangedHandler.removeMessages(67);
        Message obtain = Message.obtain();
        obtain.what = 67;
        this.mNetworkChangedHandler.sendMessageDelayed(obtain, 3500);
        AppMethodBeat.o(102019);
    }

    public void registerReceiver() {
        AppMethodBeat.i(102020);
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            AppMethodBeat.o(102020);
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(this, intentFilter);
            this.isRegisterReceiver = true;
            AppMethodBeat.o(102020);
        } catch (Throwable th) {
            this.isRegisterReceiver = false;
            Log.printErrStackTrace(TAG, th, "", new Object[0]);
            AppMethodBeat.o(102020);
        }
    }

    public void unregisterReceiver() {
        AppMethodBeat.i(102021);
        if (mInstance == null) {
            AppMethodBeat.o(102021);
            return;
        }
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            AppMethodBeat.o(102021);
            return;
        }
        try {
            if (this.isRegisterReceiver) {
                context.unregisterReceiver(this);
                this.isRegisterReceiver = false;
            }
            AppMethodBeat.o(102021);
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "", new Object[0]);
            AppMethodBeat.o(102021);
        }
    }

    public void addNetworkChangedObserver(INetworkChangedObserver iNetworkChangedObserver) {
        AppMethodBeat.i(102022);
        if (!this.mObs.contains(iNetworkChangedObserver) && iNetworkChangedObserver != null) {
            this.mObs.add(iNetworkChangedObserver);
        }
        AppMethodBeat.o(102022);
    }

    public void removeNetworkChangedObserver(INetworkChangedObserver iNetworkChangedObserver) {
        AppMethodBeat.i(102023);
        if (iNetworkChangedObserver != null) {
            this.mObs.remove(iNetworkChangedObserver);
        }
        AppMethodBeat.o(102023);
    }

    public void notifyNetworkChanged() {
        AppMethodBeat.i(102024);
        Iterator<INetworkChangedObserver> it = this.mObs.iterator();
        while (it.hasNext()) {
            it.next().onNetworkChanged();
        }
        AppMethodBeat.o(102024);
    }
}
