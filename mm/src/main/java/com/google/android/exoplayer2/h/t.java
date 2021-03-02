package com.google.android.exoplayer2.h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class t {
    final ExecutorService bFG;
    b<? extends c> bFH;
    IOException bxE;

    public interface a<T extends c> {
        int a(T t, long j2, long j3, IOException iOException);

        void a(T t, long j2, long j3);

        void a(T t, long j2, long j3, boolean z);
    }

    public interface c {
        void vA();

        boolean vB();

        void vC();
    }

    public interface d {
        void vv();
    }

    public static final class f extends IOException {
        public f(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
            AppMethodBeat.i(93095);
            AppMethodBeat.o(93095);
        }
    }

    public t(String str) {
        AppMethodBeat.i(93096);
        this.bFG = x.bE(str);
        AppMethodBeat.o(93096);
    }

    public final <T extends c> long a(T t, a<T> aVar, int i2) {
        AppMethodBeat.i(93097);
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.i.a.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i2, elapsedRealtime).start(0);
        AppMethodBeat.o(93097);
        return elapsedRealtime;
    }

    public final boolean isLoading() {
        return this.bFH != null;
    }

    public final void cancelLoading() {
        AppMethodBeat.i(93098);
        this.bFH.cancel(false);
        AppMethodBeat.o(93098);
    }

    public final boolean a(d dVar) {
        AppMethodBeat.i(93099);
        boolean z = false;
        if (this.bFH != null) {
            this.bFH.cancel(true);
            if (dVar != null) {
                this.bFG.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.vv();
            z = true;
        }
        this.bFG.shutdown();
        AppMethodBeat.o(93099);
        return z;
    }

    @SuppressLint({"HandlerLeak"})
    final class b<T extends c> extends Handler implements Runnable {
        private final T bFI;
        private final a<T> bFJ;
        public final int bFK;
        private IOException bFL;
        private int bFM;
        private volatile Thread bFN;
        private volatile boolean released;
        private final long startTimeMs;

        public b(Looper looper, T t, a<T> aVar, int i2, long j2) {
            super(looper);
            this.bFI = t;
            this.bFJ = aVar;
            this.bFK = i2;
            this.startTimeMs = j2;
        }

        public final void start(long j2) {
            AppMethodBeat.i(93088);
            com.google.android.exoplayer2.i.a.checkState(t.this.bFH == null);
            t.this.bFH = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
                AppMethodBeat.o(93088);
                return;
            }
            execute();
            AppMethodBeat.o(93088);
        }

        public final void cancel(boolean z) {
            AppMethodBeat.i(93089);
            this.released = z;
            this.bFL = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.bFI.vA();
                if (this.bFN != null) {
                    this.bFN.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.bFJ.a((c) this.bFI, elapsedRealtime, elapsedRealtime - this.startTimeMs, true);
            }
            AppMethodBeat.o(93089);
        }

        public final void run() {
            AppMethodBeat.i(93090);
            try {
                this.bFN = Thread.currentThread();
                if (!this.bFI.vB()) {
                    v.beginSection("load:" + this.bFI.getClass().getSimpleName());
                    try {
                        this.bFI.vC();
                        v.endSection();
                    } catch (Throwable th) {
                        v.endSection();
                        AppMethodBeat.o(93090);
                        throw th;
                    }
                }
                if (!this.released) {
                    sendEmptyMessage(2);
                }
                AppMethodBeat.o(93090);
            } catch (IOException e2) {
                if (!this.released) {
                    obtainMessage(3, e2).sendToTarget();
                }
                AppMethodBeat.o(93090);
            } catch (InterruptedException e3) {
                com.google.android.exoplayer2.i.a.checkState(this.bFI.vB());
                if (!this.released) {
                    sendEmptyMessage(2);
                }
                AppMethodBeat.o(93090);
            } catch (Exception e4) {
                if (!this.released) {
                    obtainMessage(3, new f(e4)).sendToTarget();
                }
                AppMethodBeat.o(93090);
            } catch (OutOfMemoryError e5) {
                if (!this.released) {
                    obtainMessage(3, new f(e5)).sendToTarget();
                }
                AppMethodBeat.o(93090);
            } catch (Error e6) {
                if (!this.released) {
                    obtainMessage(4, e6).sendToTarget();
                }
                AppMethodBeat.o(93090);
                throw e6;
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void handleMessage(Message message) {
            int i2;
            AppMethodBeat.i(93091);
            if (this.released) {
                AppMethodBeat.o(93091);
            } else if (message.what == 0) {
                execute();
                AppMethodBeat.o(93091);
            } else if (message.what == 4) {
                Error error = (Error) message.obj;
                AppMethodBeat.o(93091);
                throw error;
            } else {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = elapsedRealtime - this.startTimeMs;
                if (this.bFI.vB()) {
                    this.bFJ.a((c) this.bFI, elapsedRealtime, j2, false);
                    AppMethodBeat.o(93091);
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.bFJ.a((c) this.bFI, elapsedRealtime, j2, false);
                        AppMethodBeat.o(93091);
                        return;
                    case 2:
                        this.bFJ.a(this.bFI, elapsedRealtime, j2);
                        AppMethodBeat.o(93091);
                        return;
                    case 3:
                        this.bFL = (IOException) message.obj;
                        int a2 = this.bFJ.a(this.bFI, elapsedRealtime, j2, this.bFL);
                        if (a2 != 3) {
                            if (a2 != 2) {
                                if (a2 == 1) {
                                    i2 = 1;
                                } else {
                                    i2 = this.bFM + 1;
                                }
                                this.bFM = i2;
                                start((long) Math.min((this.bFM - 1) * 1000, 5000));
                                break;
                            }
                        } else {
                            t.this.bxE = this.bFL;
                            AppMethodBeat.o(93091);
                            return;
                        }
                        break;
                }
                AppMethodBeat.o(93091);
            }
        }

        private void execute() {
            AppMethodBeat.i(93092);
            this.bFL = null;
            t.this.bFG.execute(t.this.bFH);
            AppMethodBeat.o(93092);
        }

        private void finish() {
            t.this.bFH = null;
        }
    }

    static final class e extends Handler implements Runnable {
        private final d bFP;

        public e(d dVar) {
            this.bFP = dVar;
        }

        public final void run() {
            AppMethodBeat.i(93093);
            sendEmptyMessage(0);
            AppMethodBeat.o(93093);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(93094);
            this.bFP.vv();
            AppMethodBeat.o(93094);
        }
    }
}
