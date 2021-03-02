package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingServiceConnection implements ServiceConnection {
    private boolean zzaj = false;
    private final BlockingQueue<IBinder> zzak = new LinkedBlockingQueue();

    public BlockingServiceConnection() {
        AppMethodBeat.i(4360);
        AppMethodBeat.o(4360);
    }

    public IBinder getService() {
        AppMethodBeat.i(4363);
        Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (this.zzaj) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot call get on this connection more than once");
            AppMethodBeat.o(4363);
            throw illegalStateException;
        }
        this.zzaj = true;
        IBinder take = this.zzak.take();
        AppMethodBeat.o(4363);
        return take;
    }

    public IBinder getServiceWithTimeout(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(4362);
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.zzaj) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot call get on this connection more than once");
            AppMethodBeat.o(4362);
            throw illegalStateException;
        }
        this.zzaj = true;
        IBinder poll = this.zzak.poll(j2, timeUnit);
        if (poll == null) {
            TimeoutException timeoutException = new TimeoutException("Timed out waiting for the service connection");
            AppMethodBeat.o(4362);
            throw timeoutException;
        }
        AppMethodBeat.o(4362);
        return poll;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(4361);
        this.zzak.add(iBinder);
        AppMethodBeat.o(4361);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
