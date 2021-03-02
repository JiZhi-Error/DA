package com.tencent.wcdb.support;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.ICancellationSignal;

public final class CancellationSignal {
    private boolean mCancelInProgress;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;
    private ICancellationSignal mRemote;

    public interface OnCancelListener {
        void onCancel();
    }

    public final boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.mIsCanceled;
        }
        return z;
    }

    public final void throwIfCanceled() {
        AppMethodBeat.i(3377);
        if (isCanceled()) {
            OperationCanceledException operationCanceledException = new OperationCanceledException();
            AppMethodBeat.o(3377);
            throw operationCanceledException;
        }
        AppMethodBeat.o(3377);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.onCancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r1 == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003d, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r3.mCancelInProgress = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0045, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(3378);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0048, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0049, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x004b, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(3378);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x004e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r0 == null) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cancel() {
        /*
            r3 = this;
            r2 = 3378(0xd32, float:4.734E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            monitor-enter(r3)
            boolean r0 = r3.mIsCanceled     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r3)     // Catch:{ all -> 0x0030 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x000e:
            return
        L_0x000f:
            r0 = 1
            r3.mIsCanceled = r0
            r0 = 1
            r3.mCancelInProgress = r0
            com.tencent.wcdb.support.CancellationSignal$OnCancelListener r0 = r3.mOnCancelListener
            com.tencent.wcdb.support.ICancellationSignal r1 = r3.mRemote
            monitor-exit(r3)
            if (r0 == 0) goto L_0x001f
            r0.onCancel()     // Catch:{ all -> 0x003c }
        L_0x001f:
            if (r1 == 0) goto L_0x0024
            r1.cancel()     // Catch:{ RemoteException -> 0x004f }
        L_0x0024:
            monitor-enter(r3)
            r0 = 0
            r3.mCancelInProgress = r0     // Catch:{ all -> 0x0036 }
            r3.notifyAll()     // Catch:{ all -> 0x0036 }
            monitor-exit(r3)     // Catch:{ all -> 0x0036 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x000e
        L_0x0030:
            r0 = move-exception
            monitor-exit(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0036:
            r0 = move-exception
            monitor-exit(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x003c:
            r0 = move-exception
            monitor-enter(r3)
            r1 = 0
            r3.mCancelInProgress = r1     // Catch:{ all -> 0x0049 }
            r3.notifyAll()     // Catch:{ all -> 0x0049 }
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0049:
            r0 = move-exception
            monitor-exit(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x004f:
            r0 = move-exception
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.support.CancellationSignal.cancel():void");
    }

    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        AppMethodBeat.i(3379);
        synchronized (this) {
            try {
                waitForCancelFinishedLocked();
                if (this.mOnCancelListener != onCancelListener) {
                    this.mOnCancelListener = onCancelListener;
                    if (!this.mIsCanceled || onCancelListener == null) {
                        AppMethodBeat.o(3379);
                        return;
                    }
                    onCancelListener.onCancel();
                    AppMethodBeat.o(3379);
                }
            } finally {
                AppMethodBeat.o(3379);
            }
        }
    }

    public final void setRemote(ICancellationSignal iCancellationSignal) {
        AppMethodBeat.i(3380);
        synchronized (this) {
            try {
                waitForCancelFinishedLocked();
                if (this.mRemote != iCancellationSignal) {
                    this.mRemote = iCancellationSignal;
                    if (!this.mIsCanceled || iCancellationSignal == null) {
                        AppMethodBeat.o(3380);
                        return;
                    }
                    try {
                        iCancellationSignal.cancel();
                        AppMethodBeat.o(3380);
                    } catch (RemoteException e2) {
                        AppMethodBeat.o(3380);
                    }
                }
            } finally {
                AppMethodBeat.o(3380);
            }
        }
    }

    private void waitForCancelFinishedLocked() {
        AppMethodBeat.i(3381);
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException e2) {
            }
        }
        AppMethodBeat.o(3381);
    }

    public static ICancellationSignal createTransport() {
        AppMethodBeat.i(3382);
        Transport transport = new Transport();
        AppMethodBeat.o(3382);
        return transport;
    }

    public static CancellationSignal fromTransport(ICancellationSignal iCancellationSignal) {
        if (iCancellationSignal instanceof Transport) {
            return ((Transport) iCancellationSignal).mCancellationSignal;
        }
        return null;
    }

    static final class Transport extends ICancellationSignal.Stub {
        final CancellationSignal mCancellationSignal;

        private Transport() {
            AppMethodBeat.i(3375);
            this.mCancellationSignal = new CancellationSignal();
            AppMethodBeat.o(3375);
        }

        @Override // com.tencent.wcdb.support.ICancellationSignal
        public final void cancel() {
            AppMethodBeat.i(3376);
            this.mCancellationSignal.cancel();
            AppMethodBeat.o(3376);
        }
    }
}
