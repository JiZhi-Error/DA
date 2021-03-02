package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

class ProxyCache {
    private static final int MAX_READ_SOURCE_ATTEMPTS = 1;
    private final Cache cache;
    private volatile int percentsAvailable = -1;
    private final AtomicInteger readSourceErrorsCount;
    private final Source source;
    private volatile Thread sourceReaderThread;
    private final Object stopLock = new Object();
    private volatile boolean stopped;
    private final Object wc = new Object();

    static /* synthetic */ void access$100(ProxyCache proxyCache) {
        AppMethodBeat.i(183610);
        proxyCache.readSource();
        AppMethodBeat.o(183610);
    }

    public ProxyCache(Source source2, Cache cache2) {
        AppMethodBeat.i(183603);
        this.source = (Source) Preconditions.checkNotNull(source2);
        this.cache = (Cache) Preconditions.checkNotNull(cache2);
        this.readSourceErrorsCount = new AtomicInteger();
        AppMethodBeat.o(183603);
    }

    public int read(byte[] bArr, long j2, int i2) {
        AppMethodBeat.i(223187);
        ProxyCacheUtils.assertBuffer(bArr, j2, i2);
        while (!this.cache.isCompleted() && this.cache.available() < ((long) i2) + j2 && !this.stopped) {
            readSourceAsync();
            waitForSourceData();
            checkReadSourceErrorsCount();
        }
        int read = this.cache.read(bArr, j2, i2);
        if (this.cache.isCompleted() && this.percentsAvailable != 100) {
            this.percentsAvailable = 100;
            onCachePercentsAvailableChanged(100);
        }
        AppMethodBeat.o(223187);
        return read;
    }

    private void checkReadSourceErrorsCount() {
        AppMethodBeat.i(223188);
        int i2 = this.readSourceErrorsCount.get();
        if (i2 > 0) {
            this.readSourceErrorsCount.set(0);
            ProxyCacheException proxyCacheException = new ProxyCacheException("Error reading source " + i2 + " times");
            AppMethodBeat.o(223188);
            throw proxyCacheException;
        }
        AppMethodBeat.o(223188);
    }

    public void shutdown() {
        AppMethodBeat.i(223189);
        synchronized (this.stopLock) {
            try {
                Logger.debug("Shutdown proxy for " + this.source);
                try {
                    this.stopped = true;
                    if (this.sourceReaderThread != null) {
                        this.sourceReaderThread.interrupt();
                    }
                    this.cache.close();
                } catch (ProxyCacheException e2) {
                    onError(e2);
                }
            } finally {
                AppMethodBeat.o(223189);
            }
        }
    }

    private synchronized void readSourceAsync() {
        AppMethodBeat.i(183605);
        boolean z = (this.sourceReaderThread == null || this.sourceReaderThread.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.stopped && !this.cache.isCompleted() && !z) {
            this.sourceReaderThread = new Thread(new SourceReaderRunnable(), "Source reader for " + this.source);
            this.sourceReaderThread.start();
        }
        AppMethodBeat.o(183605);
    }

    private void waitForSourceData() {
        AppMethodBeat.i(223190);
        synchronized (this.wc) {
            try {
                this.wc.wait(1000);
                try {
                } catch (Throwable th) {
                    AppMethodBeat.o(223190);
                    throw th;
                }
            } catch (InterruptedException e2) {
                ProxyCacheException proxyCacheException = new ProxyCacheException("Waiting source data is interrupted!", e2);
                AppMethodBeat.o(223190);
                throw proxyCacheException;
            }
        }
        AppMethodBeat.o(223190);
    }

    private void notifyNewCacheDataAvailable(long j2, long j3) {
        AppMethodBeat.i(183606);
        onCacheAvailable(j2, j3);
        synchronized (this.wc) {
            try {
                this.wc.notifyAll();
            } finally {
                AppMethodBeat.o(183606);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCacheAvailable(long j2, long j3) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(223191);
        int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1)) == 0 ? 100 : (int) ((((float) j2) / ((float) j3)) * 100.0f);
        if (i2 != this.percentsAvailable) {
            z = true;
        } else {
            z = false;
        }
        if (j3 < 0) {
            z2 = false;
        }
        if (z2 && z) {
            onCachePercentsAvailableChanged(i2);
        }
        this.percentsAvailable = i2;
        AppMethodBeat.o(223191);
    }

    /* access modifiers changed from: protected */
    public void onCachePercentsAvailableChanged(int i2) {
    }

    private void readSource() {
        AppMethodBeat.i(223192);
        long j2 = -1;
        long j3 = 0;
        try {
            long available = this.cache.available();
            this.source.open(available);
            j2 = this.source.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = this.source.read(bArr);
                if (read != -1) {
                    synchronized (this.stopLock) {
                        try {
                            if (!isStopped()) {
                                this.cache.append(bArr, read);
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(223192);
                            throw th;
                        }
                    }
                } else {
                    tryComplete();
                    onSourceRead();
                    closeSource();
                    notifyNewCacheDataAvailable(j3, j2);
                    AppMethodBeat.o(223192);
                    return;
                }
                available = j3 + ((long) read);
                notifyNewCacheDataAvailable(available, j2);
            }
        } catch (Throwable th2) {
            this.readSourceErrorsCount.incrementAndGet();
            onError(th2);
        } finally {
            closeSource();
            notifyNewCacheDataAvailable(j3, j2);
            AppMethodBeat.o(223192);
        }
    }

    private void onSourceRead() {
        AppMethodBeat.i(223193);
        this.percentsAvailable = 100;
        onCachePercentsAvailableChanged(this.percentsAvailable);
        AppMethodBeat.o(223193);
    }

    private void tryComplete() {
        AppMethodBeat.i(223194);
        synchronized (this.stopLock) {
            try {
                if (!isStopped() && this.cache.available() == this.source.length()) {
                    this.cache.complete();
                }
            } finally {
                AppMethodBeat.o(223194);
            }
        }
    }

    private boolean isStopped() {
        AppMethodBeat.i(183607);
        if (Thread.currentThread().isInterrupted() || this.stopped) {
            AppMethodBeat.o(183607);
            return true;
        }
        AppMethodBeat.o(183607);
        return false;
    }

    private void closeSource() {
        AppMethodBeat.i(183608);
        try {
            this.source.close();
            AppMethodBeat.o(183608);
        } catch (ProxyCacheException e2) {
            onError(new ProxyCacheException("Error closing source " + this.source, e2));
            AppMethodBeat.o(183608);
        }
    }

    /* access modifiers changed from: protected */
    public final void onError(Throwable th) {
        AppMethodBeat.i(183609);
        if (th instanceof InterruptedProxyCacheException) {
            Logger.debug("ProxyCache is interrupted");
            AppMethodBeat.o(183609);
            return;
        }
        Logger.error("ProxyCache error");
        AppMethodBeat.o(183609);
    }

    /* access modifiers changed from: package-private */
    public class SourceReaderRunnable implements Runnable {
        private SourceReaderRunnable() {
        }

        public void run() {
            AppMethodBeat.i(183602);
            ProxyCache.access$100(ProxyCache.this);
            AppMethodBeat.o(183602);
        }
    }
}
