package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class GmsClientEventManager implements Handler.Callback {
    private final Handler mHandler;
    private final Object mLock = new Object();
    private final GmsClientEventState zztf;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zztg = new ArrayList<>();
    @VisibleForTesting
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzth = new ArrayList<>();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzti = new ArrayList<>();
    private volatile boolean zztj = false;
    private final AtomicInteger zztk = new AtomicInteger(0);
    private boolean zztl = false;

    @VisibleForTesting
    public interface GmsClientEventState {
        Bundle getConnectionHint();

        boolean isConnected();
    }

    public GmsClientEventManager(Looper looper, GmsClientEventState gmsClientEventState) {
        AppMethodBeat.i(11826);
        this.zztf = gmsClientEventState;
        this.mHandler = new Handler(looper, this);
        AppMethodBeat.o(11826);
    }

    public final boolean areCallbacksEnabled() {
        return this.zztj;
    }

    public final void disableCallbacks() {
        AppMethodBeat.i(11827);
        this.zztj = false;
        this.zztk.incrementAndGet();
        AppMethodBeat.o(11827);
    }

    public final void enableCallbacks() {
        this.zztj = true;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(11838);
        if (message.what == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.mLock) {
                try {
                    if (this.zztj && this.zztf.isConnected() && this.zztg.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(this.zztf.getConnectionHint());
                    }
                } finally {
                    AppMethodBeat.o(11838);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
        AppMethodBeat.o(11838);
        return false;
    }

    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        AppMethodBeat.i(11833);
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            try {
                contains = this.zztg.contains(connectionCallbacks);
            } finally {
                AppMethodBeat.o(11833);
            }
        }
        return contains;
    }

    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        AppMethodBeat.i(11836);
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            try {
                contains = this.zzti.contains(onConnectionFailedListener);
            } finally {
                AppMethodBeat.o(11836);
            }
        }
        return contains;
    }

    @VisibleForTesting
    public final void onConnectionFailure(ConnectionResult connectionResult) {
        int i2 = 0;
        AppMethodBeat.i(11831);
        Preconditions.checkState(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.mLock) {
            try {
                ArrayList arrayList = new ArrayList(this.zzti);
                int i3 = this.zztk.get();
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) obj;
                    if (this.zztj && this.zztk.get() == i3) {
                        if (this.zzti.contains(onConnectionFailedListener)) {
                            onConnectionFailedListener.onConnectionFailed(connectionResult);
                        }
                    } else {
                        return;
                    }
                }
                AppMethodBeat.o(11831);
            } finally {
                AppMethodBeat.o(11831);
            }
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void onConnectionSuccess() {
        AppMethodBeat.i(11828);
        synchronized (this.mLock) {
            try {
                onConnectionSuccess(this.zztf.getConnectionHint());
            } finally {
                AppMethodBeat.o(11828);
            }
        }
    }

    @VisibleForTesting
    public final void onConnectionSuccess(Bundle bundle) {
        boolean z = true;
        int i2 = 0;
        AppMethodBeat.i(11829);
        Preconditions.checkState(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.mLock) {
            try {
                Preconditions.checkState(!this.zztl);
                this.mHandler.removeMessages(1);
                this.zztl = true;
                if (this.zzth.size() != 0) {
                    z = false;
                }
                Preconditions.checkState(z);
                ArrayList arrayList = new ArrayList(this.zztg);
                int i3 = this.zztk.get();
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                    if (!this.zztj || !this.zztf.isConnected() || this.zztk.get() != i3) {
                        break;
                    } else if (!this.zzth.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(bundle);
                    }
                }
                this.zzth.clear();
                this.zztl = false;
            } finally {
                AppMethodBeat.o(11829);
            }
        }
    }

    @VisibleForTesting
    public final void onUnintentionalDisconnection(int i2) {
        int i3 = 0;
        AppMethodBeat.i(11830);
        Preconditions.checkState(Looper.myLooper() == this.mHandler.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.mLock) {
            try {
                this.zztl = true;
                ArrayList arrayList = new ArrayList(this.zztg);
                int i4 = this.zztk.get();
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                    if (!this.zztj || this.zztk.get() != i4) {
                        break;
                    } else if (this.zztg.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnectionSuspended(i2);
                    }
                }
                this.zzth.clear();
                this.zztl = false;
            } finally {
                AppMethodBeat.o(11830);
            }
        }
    }

    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(11832);
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            try {
                if (this.zztg.contains(connectionCallbacks)) {
                    String valueOf = String.valueOf(connectionCallbacks);
                    new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered");
                } else {
                    this.zztg.add(connectionCallbacks);
                }
            } finally {
                AppMethodBeat.o(11832);
            }
        }
        if (this.zztf.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(11835);
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            try {
                if (this.zzti.contains(onConnectionFailedListener)) {
                    String valueOf = String.valueOf(onConnectionFailedListener);
                    new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered");
                } else {
                    this.zzti.add(onConnectionFailedListener);
                }
            } finally {
                AppMethodBeat.o(11835);
            }
        }
    }

    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(11834);
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            try {
                if (!this.zztg.remove(connectionCallbacks)) {
                    String valueOf = String.valueOf(connectionCallbacks);
                    new StringBuilder(String.valueOf(valueOf).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(valueOf).append(" not found");
                } else if (this.zztl) {
                    this.zzth.add(connectionCallbacks);
                }
            } finally {
                AppMethodBeat.o(11834);
            }
        }
    }

    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(11837);
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            try {
                if (!this.zzti.remove(onConnectionFailedListener)) {
                    String valueOf = String.valueOf(onConnectionFailedListener);
                    new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found");
                }
            } finally {
                AppMethodBeat.o(11837);
            }
        }
    }
}
