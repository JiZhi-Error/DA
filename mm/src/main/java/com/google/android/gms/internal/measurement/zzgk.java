package com.google.android.gms.internal.measurement;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;

/* access modifiers changed from: package-private */
public final class zzgk extends Thread {
    private final /* synthetic */ zzgg zzalz;
    private final Object zzamc = new Object();
    private final BlockingQueue<zzgj<?>> zzamd;

    public zzgk(zzgg zzgg, String str, BlockingQueue<zzgj<?>> blockingQueue) {
        this.zzalz = zzgg;
        AppMethodBeat.i(1582);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzamd = blockingQueue;
        setName(str);
        AppMethodBeat.o(1582);
    }

    private final void zza(InterruptedException interruptedException) {
        AppMethodBeat.i(1585);
        this.zzalz.zzge().zzip().zzg(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        AppMethodBeat.o(1585);
    }

    public final void run() {
        AppMethodBeat.i(1583);
        boolean z = false;
        while (!z) {
            try {
                this.zzalz.zzalv.acquire();
                z = true;
            } catch (InterruptedException e2) {
                zza(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzgj<?> poll = this.zzamd.poll();
                if (poll != null) {
                    Process.setThreadPriority(poll.zzamb ? threadPriority : 10);
                    poll.run();
                } else {
                    synchronized (this.zzamc) {
                        try {
                            if (this.zzamd.peek() == null && !(this.zzalz.zzalw)) {
                                try {
                                    this.zzamc.wait(30000);
                                } catch (InterruptedException e3) {
                                    zza(e3);
                                }
                            }
                        } finally {
                            AppMethodBeat.o(1583);
                        }
                    }
                    synchronized (this.zzalz.zzalu) {
                        try {
                            if (this.zzamd.peek() == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
            synchronized (this.zzalz.zzalu) {
                try {
                    this.zzalz.zzalv.release();
                    this.zzalz.zzalu.notifyAll();
                    if (this == this.zzalz.zzalo) {
                        this.zzalz.zzalo = null;
                    } else if (this == this.zzalz.zzalp) {
                        this.zzalz.zzalp = null;
                    } else {
                        this.zzalz.zzge().zzim().log("Current scheduler thread is neither worker nor network");
                    }
                } finally {
                    AppMethodBeat.o(1583);
                }
            }
        } catch (Throwable th2) {
            AppMethodBeat.o(1583);
            throw th2;
        }
    }

    public final void zzjn() {
        AppMethodBeat.i(1584);
        synchronized (this.zzamc) {
            try {
                this.zzamc.notifyAll();
            } finally {
                AppMethodBeat.o(1584);
            }
        }
    }
}
