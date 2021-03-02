package com.samsung.android.sdk.look.bezelinteraction;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.samsung.android.bezelinteraction.BezelEvent;
import com.samsung.android.bezelinteraction.IBezelCallback;
import com.samsung.android.bezelinteraction.IBezelManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class SlookBezelInteraction {
    public static final String SERVICE_NAME = "BezelInteractionService";
    private static final String TAG = "SlookBezelInteraction";
    private static Context mContext = null;
    private static IBezelManager mService = null;
    private final CopyOnWriteArrayList<BezelListenerDelegate> mListenerDelegates = new CopyOnWriteArrayList<>();

    public interface BezelListener {
        void onItemSelected(BezelEvent bezelEvent);
    }

    public SlookBezelInteraction(Context context) {
        AppMethodBeat.i(76246);
        mContext = context;
        getService();
        AppMethodBeat.o(76246);
    }

    private synchronized IBezelManager getService() {
        IBezelManager iBezelManager;
        AppMethodBeat.i(76247);
        if (mService == null) {
            mService = IBezelManager.Stub.asInterface(ServiceManager.getService(SERVICE_NAME));
        } else if (!mService.asBinder().isBinderAlive()) {
            mService = IBezelManager.Stub.asInterface(ServiceManager.getService(SERVICE_NAME));
        }
        iBezelManager = mService;
        AppMethodBeat.o(76247);
        return iBezelManager;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x002c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x002c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: java.util.concurrent.CopyOnWriteArrayList<com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction$BezelListenerDelegate>, java.util.concurrent.CopyOnWriteArrayList */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction$BezelListenerDelegate] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction$BezelListenerDelegate] */
    public final void registerListener(BezelListener bezelListener) {
        BezelListenerDelegate bezelListenerDelegate;
        AppMethodBeat.i(76248);
        if (bezelListener == null) {
            AppMethodBeat.o(76248);
            return;
        }
        synchronized (this.mListenerDelegates) {
            try {
                Iterator<BezelListenerDelegate> it = this.mListenerDelegates.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        bezelListenerDelegate = 0;
                        break;
                    }
                    bezelListenerDelegate = it.next();
                    if (bezelListenerDelegate.getListener().equals(bezelListener)) {
                        break;
                    }
                }
                if (bezelListenerDelegate == 0) {
                    bezelListenerDelegate = new BezelListenerDelegate(bezelListener, null);
                    this.mListenerDelegates.add(bezelListenerDelegate);
                }
                try {
                    IBezelManager service = getService();
                    if (service != null) {
                        service.registerCallback((IBinder) bezelListenerDelegate, new ComponentName(mContext.getPackageName(), mContext.getClass().getCanonicalName()));
                    }
                } catch (RemoteException e2) {
                }
            } finally {
                AppMethodBeat.o(76248);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x002c */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction$BezelListenerDelegate, android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction$BezelListenerDelegate] */
    public final void unregisterListener(BezelListener bezelListener) {
        BezelListenerDelegate bezelListenerDelegate;
        AppMethodBeat.i(76249);
        if (bezelListener == null) {
            AppMethodBeat.o(76249);
            return;
        }
        synchronized (this.mListenerDelegates) {
            try {
                Iterator<BezelListenerDelegate> it = this.mListenerDelegates.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        bezelListenerDelegate = 0;
                        break;
                    }
                    bezelListenerDelegate = it.next();
                    if (bezelListenerDelegate.getListener().equals(bezelListener)) {
                        break;
                    }
                }
                if (bezelListenerDelegate != 0) {
                    try {
                        IBezelManager service = getService();
                        if (service != null && service.unregisterCallback((IBinder) bezelListenerDelegate)) {
                            this.mListenerDelegates.remove((Object) bezelListenerDelegate);
                            bezelListenerDelegate.mHandler = null;
                            bezelListenerDelegate.mListener = null;
                        }
                    } catch (RemoteException e2) {
                    }
                    AppMethodBeat.o(76249);
                }
            } finally {
                AppMethodBeat.o(76249);
            }
        }
    }

    static class BezelListenerDelegate extends IBezelCallback.Stub {
        public Handler mHandler;
        public BezelListener mListener;

        static class ListenerHandler extends Handler {
            public BezelListener mListener = null;

            public ListenerHandler(Looper looper, BezelListener bezelListener) {
                super(looper);
                this.mListener = bezelListener;
            }

            public void handleMessage(Message message) {
                BezelEvent bezelEvent;
                AppMethodBeat.i(76254);
                if (!(this.mListener == null || (bezelEvent = (BezelEvent) message.obj) == null)) {
                    this.mListener.onItemSelected(bezelEvent);
                }
                AppMethodBeat.o(76254);
            }
        }

        BezelListenerDelegate(BezelListener bezelListener, Handler handler) {
            AppMethodBeat.i(76251);
            this.mListener = bezelListener;
            this.mHandler = new ListenerHandler(handler == null ? SlookBezelInteraction.mContext.getMainLooper() : handler.getLooper(), this.mListener);
            AppMethodBeat.o(76251);
        }

        public BezelListener getListener() {
            return this.mListener;
        }

        public void onBezelCallback(BezelEvent bezelEvent) {
            AppMethodBeat.i(76252);
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = bezelEvent;
            this.mHandler.sendMessage(obtain);
            AppMethodBeat.o(76252);
        }

        public String getListenerInfo() {
            AppMethodBeat.i(76253);
            String obj = this.mListener.toString();
            AppMethodBeat.o(76253);
            return obj;
        }
    }

    public final void enableBezelInteraction(boolean z) {
        AppMethodBeat.i(76250);
        try {
            IBezelManager service = getService();
            if (service != null) {
                service.enableBezelInteraction(z);
            }
            AppMethodBeat.o(76250);
        } catch (RemoteException e2) {
            AppMethodBeat.o(76250);
        }
    }
}
