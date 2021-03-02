package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface d {
    int getDurationMs();

    Bitmap getFrameAtTime(long j2);

    int getScaledHeight();

    int getScaledWidth();

    void init(String str, int i2, int i3, int i4);

    void release();

    void reuseBitmap(Bitmap bitmap);

    public static class a {
        private Lock aIR = new ReentrantLock();
        private volatile int size = 0;
        private LinkedBlockingQueue<d> zya;
        private final int zyb;
        private Callable<d> zyc;

        public a(int i2, Callable<d> callable) {
            AppMethodBeat.i(107638);
            this.zyb = i2;
            this.zya = new LinkedBlockingQueue<>(i2);
            this.zyc = callable;
            AppMethodBeat.o(107638);
        }

        public final d ekq() {
            d dVar = null;
            AppMethodBeat.i(107639);
            long currentTicks = Util.currentTicks();
            Log.d("FetcherPool", "acquireFetcher");
            if (this.zya == null) {
                Log.d("FetcherPool", "acquireFetcher no pool directly return null");
                AppMethodBeat.o(107639);
            } else {
                this.aIR.lock();
                Log.d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", Integer.valueOf(this.zya.size()), Integer.valueOf(this.size), Integer.valueOf(this.zyb));
                if (this.zya == null) {
                    this.aIR.unlock();
                    AppMethodBeat.o(107639);
                } else {
                    if (!this.zya.isEmpty() || this.size >= this.zyb) {
                        Log.d("FetcherPool", "waiting fetcher");
                        this.aIR.unlock();
                        dVar = this.zya.poll(5, TimeUnit.SECONDS);
                    } else {
                        Log.d("FetcherPool", "new fetcher");
                        this.size++;
                        this.aIR.unlock();
                        dVar = ekr();
                    }
                    Log.d("FetcherPool", "time flee, acquireFetcher cost time %d", Long.valueOf(Util.ticksToNow(currentTicks)));
                    AppMethodBeat.o(107639);
                }
            }
            return dVar;
        }

        private d ekr() {
            AppMethodBeat.i(107640);
            if (this.zyc == null) {
                IllegalStateException illegalStateException = new IllegalStateException("fetcher generator can not be null.");
                AppMethodBeat.o(107640);
                throw illegalStateException;
            }
            long currentTicks = Util.currentTicks();
            try {
                d call = this.zyc.call();
                Log.d("FetcherPool", "time flee, construct fetcher instance cost %d", Long.valueOf(Util.ticksToNow(currentTicks)));
                AppMethodBeat.o(107640);
                return call;
            } catch (Exception e2) {
                Log.printErrStackTrace("FetcherPool", e2, " fetcher generater call error %s", e2.getMessage());
                AppMethodBeat.o(107640);
                throw e2;
            }
        }

        public final void a(d dVar) {
            AppMethodBeat.i(107641);
            Log.d("FetcherPool", "reuseFetcher");
            if (dVar == null) {
                Log.e("FetcherPool", "Null object can not be reused.");
                AppMethodBeat.o(107641);
            } else if (this.zya == null) {
                dVar.release();
                AppMethodBeat.o(107641);
            } else if (this.zya.contains(dVar)) {
                IllegalStateException illegalStateException = new IllegalStateException("fetcher already in pool");
                AppMethodBeat.o(107641);
                throw illegalStateException;
            } else {
                this.zya.offer(dVar);
                AppMethodBeat.o(107641);
            }
        }

        public final void destroy() {
            AppMethodBeat.i(107642);
            if (this.zya == null) {
                AppMethodBeat.o(107642);
                return;
            }
            this.aIR.lock();
            if (this.zya == null) {
                this.aIR.unlock();
                AppMethodBeat.o(107642);
                return;
            }
            try {
                Iterator<d> it = this.zya.iterator();
                while (it.hasNext()) {
                    it.next().release();
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("FetcherPool", e2, "destroy fetcher %s", e2.getMessage());
            } finally {
                this.zya = null;
                this.aIR.unlock();
                AppMethodBeat.o(107642);
            }
        }
    }
}
