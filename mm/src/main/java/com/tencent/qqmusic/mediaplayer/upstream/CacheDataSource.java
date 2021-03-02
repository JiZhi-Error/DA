package com.tencent.qqmusic.mediaplayer.upstream;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.DataRangeTracker;
import com.tencent.qqmusic.mediaplayer.downstream.FileDataSink;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.perf.Collectable;
import com.tencent.qqmusic.mediaplayer.perf.ErrorUploadCollector;
import com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector;
import com.tencent.qqmusic.mediaplayer.upstream.Loader;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.tav.coremedia.TimeUtil;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class CacheDataSource implements Collectable, IDataSource {
    private static final int CHUNK_LOAD_BUFFER_SIZE = 8192;
    private static final int DISCONTINUITY_THRESHOLD = 8192;
    static final long NO_RESET_PENDING = Long.MIN_VALUE;
    private static final int PROFILE_ending = 10;
    private static final int PROFILE_isCached = 8;
    private static final int PROFILE_lock = 5;
    private static final int PROFILE_onBufferEnd = 7;
    private static final int PROFILE_onBufferStarted = 4;
    private static final int PROFILE_onBytesTransferred = 9;
    private static final int PROFILE_onBytesTransferring = 3;
    private static final int PROFILE_onReadContinuity = 1;
    private static final int PROFILE_onReadDiscontinuity = 2;
    private static final int PROFILE_readAt = 6;
    private static final int PROFILE_total = 0;
    private static final int READ_WAIT_TIMEOUT = 30000;
    private static final String TAG = "CacheDataSource";
    private static final String[] profiles = {"total", "onReadContinuity", "onReadDiscontinuity", "onBytesTransferring", "onBufferStarted", "lock", "readAt", "onBufferEnd", "isCached", "onBytesTransferred", "ending"};
    private final IDataSource cacheSource;
    private final DataRangeTracker cachedDataTracker;
    private long[] costs;
    private long currentLoadStartPosition;
    private Chunk currentLoadingChunk;
    private volatile boolean isToReleaseLock;
    private volatile boolean isWaitingForFirstPiece;
    private Listener listener;
    private boolean loadFinished;
    private final Loader loader;
    private long nextContinuousPosition;
    private boolean opened;
    protected long pendingRestartPositionByte;
    protected long pendingStartPositionByte;
    private TimerTask pendingTask;
    private Timer restartHandler;

    public interface Listener extends TransferListener {
        void onBufferEnded();

        void onBufferStarted(long j2);

        long onStreamingError(IOException iOException);

        void onStreamingFinished();

        void onUpStreamTransfer(long j2, long j3);
    }

    static /* synthetic */ void access$1100(CacheDataSource cacheDataSource, long j2, long j3) {
        AppMethodBeat.i(190306);
        cacheDataSource.scheduleRestart(j2, j3);
        AppMethodBeat.o(190306);
    }

    static /* synthetic */ void access$200(CacheDataSource cacheDataSource, long j2) {
        AppMethodBeat.i(190304);
        cacheDataSource.restartLoading(j2);
        AppMethodBeat.o(190304);
    }

    static /* synthetic */ boolean access$300(CacheDataSource cacheDataSource) {
        AppMethodBeat.i(190305);
        boolean startLoadingIfNeeded = cacheDataSource.startLoadingIfNeeded();
        AppMethodBeat.o(190305);
        return startLoadingIfNeeded;
    }

    public CacheDataSource(final IDataSource iDataSource, IDataSource iDataSource2, final IDataSink iDataSink, final Looper looper) {
        this(iDataSource2, new Loader.Factory() {
            /* class com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.AnonymousClass1 */

            @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Factory
            public Loader createLoader(Loader.Listener listener) {
                AppMethodBeat.i(76493);
                AnonymousClass1 r0 = new DefaultLoader(looper, new DummyUriLoader(null), listener) {
                    /* class com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.AnonymousClass1.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    @Override // com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
                    public IDataSource createUpStream(StreamingRequest streamingRequest) {
                        return iDataSource;
                    }

                    /* access modifiers changed from: protected */
                    @Override // com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
                    public IDataSink createCacheSink(StreamingRequest streamingRequest) {
                        return iDataSink;
                    }
                };
                AppMethodBeat.o(76493);
                return r0;
            }
        });
        AppMethodBeat.i(76546);
        AppMethodBeat.o(76546);
    }

    public CacheDataSource(IDataSource iDataSource, Loader.Factory factory) {
        AppMethodBeat.i(76547);
        this.currentLoadStartPosition = NO_RESET_PENDING;
        this.isWaitingForFirstPiece = false;
        this.costs = new long[profiles.length];
        this.isToReleaseLock = false;
        this.cacheSource = iDataSource;
        this.cachedDataTracker = new DataRangeTracker();
        this.opened = false;
        this.loadFinished = false;
        this.loader = factory.createLoader(new LoaderListener());
        AppMethodBeat.o(76547);
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }

    public void releaseLock() {
        AppMethodBeat.i(190302);
        Logger.i(TAG, "[releaseLock]");
        this.isToReleaseLock = true;
        AppMethodBeat.o(190302);
    }

    public boolean isCacheFileComplete() {
        AppMethodBeat.i(76548);
        long continuousStart = this.cachedDataTracker.getContinuousStart();
        long continuousEnd = this.cachedDataTracker.getContinuousEnd();
        if (continuousEnd != -1 && continuousEnd == this.loader.getUpstreamSize() - 1 && continuousStart == 0) {
            AppMethodBeat.o(76548);
            return true;
        }
        AppMethodBeat.o(76548);
        return false;
    }

    public Loader getLoader() {
        return this.loader;
    }

    /* access modifiers changed from: protected */
    public boolean waitForFirstPiece(int i2, long j2) {
        AppMethodBeat.i(190303);
        this.isWaitingForFirstPiece = true;
        boolean lock = this.cachedDataTracker.lock(0, i2, j2, null);
        this.isWaitingForFirstPiece = false;
        AppMethodBeat.o(190303);
        return lock;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() {
        AppMethodBeat.i(76550);
        Logger.i(TAG, "[open] enter.");
        if (this.opened) {
            AppMethodBeat.o(76550);
            return;
        }
        this.nextContinuousPosition = 0;
        this.pendingRestartPositionByte = NO_RESET_PENDING;
        this.cacheSource.open();
        this.loader.prepare();
        startLoadingIfNeeded();
        if (this.listener != null) {
            this.listener.onTransferStart();
        }
        this.opened = true;
        Logger.i(TAG, "[open] opened = true;");
        Logger.i(TAG, "[open] exit");
        AppMethodBeat.o(76550);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j2, byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        boolean z;
        AppMethodBeat.i(76551);
        int i6 = -1;
        try {
            if (!this.opened) {
                Logger.e(TAG, "[readAt] not opened!");
                this.cachedDataTracker.abandonLock();
                throw new IOException("[readAt] not opened!");
            } else if (j2 < 0) {
                Logger.e(TAG, "[readAt] invalid position: ".concat(String.valueOf(j2)));
                IOException iOException = new IOException("invalid position: ".concat(String.valueOf(j2)));
                AppMethodBeat.o(76551);
                throw iOException;
            } else {
                this.cachedDataTracker.setFileTotalSize(getSize());
                boolean isCached = isCached(j2, i3);
                if (j2 == this.nextContinuousPosition) {
                    onReadContinuity(j2);
                } else {
                    onReadDiscontinuity(j2, isCached);
                }
                if (this.listener != null) {
                    this.listener.onBytesTransferring(j2, (long) i3);
                }
                if (isCached) {
                    i6 = this.cacheSource.readAt(j2, bArr, i2, i3);
                }
                if (i6 >= 0) {
                    i5 = i6;
                } else if (!this.loader.isLoading()) {
                    int readAt = this.cacheSource.readAt(j2, bArr, i2, i3);
                    Logger.e(TAG, "[readAt] load not started: " + j2 + ", size: " + i3 + ", read: " + readAt);
                    i5 = readAt;
                } else {
                    Logger.w(TAG, "[readAt] load has started, lock util data has been downloaded : " + j2 + ", size: " + i3 + ", read: " + i6);
                    if (this.listener != null) {
                        this.listener.onBufferStarted(j2);
                    }
                    try {
                        this.cachedDataTracker.lock(j2, i3, getBufferTimeout(j2, i3), new DataRangeTracker.LockJudgerCallback() {
                            /* class com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.AnonymousClass2 */

                            @Override // com.tencent.qqmusic.mediaplayer.DataRangeTracker.LockJudgerCallback
                            public boolean isToAbandonLock() {
                                AppMethodBeat.i(190300);
                                boolean z = CacheDataSource.this.isToReleaseLock;
                                AppMethodBeat.o(190300);
                                return z;
                            }
                        });
                        if (this.listener != null) {
                            this.listener.onBufferEnded();
                        }
                        i5 = this.cacheSource.readAt(j2, bArr, i2, i3);
                    } catch (InterruptedException e2) {
                        IOException iOException2 = new IOException("interrupted!", e2);
                        AppMethodBeat.o(76551);
                        throw iOException2;
                    }
                }
                if (i5 > 0) {
                    this.nextContinuousPosition = ((long) i5) + j2;
                    z = false;
                } else if (i5 < 0) {
                    z = true;
                    Logger.e(TAG, "[readAt]: read error! read < 0， read = ".concat(String.valueOf(i5)));
                } else {
                    z = i3 != 0;
                    Logger.e(TAG, "[readAt]: read error! read = 0, hasError = ".concat(String.valueOf(z)));
                }
                if (this.listener != null) {
                    if (z) {
                        this.listener.onBytesTransferError(j2, (long) i3, (long) i5);
                    } else {
                        this.listener.onBytesTransferred(j2, (long) i5);
                    }
                }
                AppMethodBeat.o(76551);
                return i5;
            }
        } catch (Throwable th) {
            Logger.e(TAG, "[readAt] error occurred: ".concat(String.valueOf(j2)), th);
            throw th;
        } finally {
            AppMethodBeat.o(76551);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() {
        AppMethodBeat.i(76552);
        long j2 = 0;
        if (this.loader != null) {
            j2 = this.loader.getUpstreamSize();
        }
        AppMethodBeat.o(76552);
        return j2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() {
        AppMethodBeat.i(76553);
        AudioFormat.AudioType audioFormat = FormatDetector.getAudioFormat((IDataSource) this, false);
        AppMethodBeat.o(76553);
        return audioFormat;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(76554);
        Logger.i(TAG, "[close] enter.");
        if (!this.opened) {
            Logger.i(TAG, "[close] not opened. return");
            AppMethodBeat.o(76554);
            return;
        }
        this.cachedDataTracker.abandonLock();
        try {
            this.loader.shutdown();
        } catch (InterruptedException e2) {
        }
        this.cacheSource.close();
        if (this.listener != null) {
            this.listener.onTransferEnd();
        }
        reportProfiling();
        this.opened = false;
        Logger.i(TAG, "[close] exit");
        AppMethodBeat.o(76554);
    }

    private void reportProfiling() {
    }

    public synchronized boolean continueLoadIfNeeded() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(76555);
            if (!this.opened) {
                Logger.w(TAG, "[continueLoadIfNeeded] not opened!");
                AppMethodBeat.o(76555);
            } else if (this.pendingRestartPositionByte == NO_RESET_PENDING) {
                AppMethodBeat.o(76555);
            } else if (this.loadFinished) {
                AppMethodBeat.o(76555);
            } else {
                long j2 = this.pendingRestartPositionByte;
                this.pendingRestartPositionByte = NO_RESET_PENDING;
                scheduleRestart(j2, 0);
                Logger.i(TAG, "[continueLoadIfNeeded] schedule restart from: ".concat(String.valueOf(j2)));
                z = true;
                AppMethodBeat.o(76555);
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public long getBufferTimeout(long j2, int i2) {
        return 30000;
    }

    private void onReadDiscontinuity(long j2, boolean z) {
        long max;
        AppMethodBeat.i(76556);
        if (j2 == this.currentLoadStartPosition) {
            AppMethodBeat.o(76556);
            return;
        }
        long j3 = j2 - this.currentLoadStartPosition;
        if (j3 < 0 || j3 >= 8192) {
            synchronized (this.cachedDataTracker) {
                try {
                    max = Math.max(j2, this.cachedDataTracker.findStart(j2));
                } catch (Throwable th) {
                    AppMethodBeat.o(76556);
                    throw th;
                }
            }
            if (this.currentLoadStartPosition == max) {
                AppMethodBeat.o(76556);
                return;
            }
            long j4 = max - this.currentLoadStartPosition;
            if (j4 >= 0 && j4 < 8192) {
                AppMethodBeat.o(76556);
            } else if (max == getSize()) {
                AppMethodBeat.o(76556);
            } else {
                Chunk chunk = this.currentLoadingChunk;
                if (!z || chunk == null || !chunk.contains(max)) {
                    restartLoading(max);
                    AppMethodBeat.o(76556);
                    return;
                }
                AppMethodBeat.o(76556);
            }
        } else {
            AppMethodBeat.o(76556);
        }
    }

    private void onReadContinuity(long j2) {
    }

    private synchronized boolean startLoadingIfNeeded() {
        Chunk chunk;
        boolean z;
        AppMethodBeat.i(76557);
        if (this.loadFinished) {
            z = false;
            AppMethodBeat.o(76557);
        } else {
            long j2 = this.pendingStartPositionByte;
            this.pendingStartPositionByte = NO_RESET_PENDING;
            if (!this.opened) {
                if (j2 == NO_RESET_PENDING) {
                    Logger.i(TAG, "[startLoadingIfNeeded] start a fresh load");
                    chunk = new Chunk(8192, 0, -1);
                } else {
                    Logger.i(TAG, "[startLoadingIfNeeded] start a pending load: ".concat(String.valueOf(j2)));
                    chunk = new Chunk(8192, j2, -1);
                }
            } else if (j2 == NO_RESET_PENDING) {
                IllegalStateException illegalStateException = new IllegalStateException("pendingStartPositionByte must be set!");
                AppMethodBeat.o(76557);
                throw illegalStateException;
            } else {
                Logger.i(TAG, "[startLoadingIfNeeded] restart a pending load: ".concat(String.valueOf(j2)));
                chunk = new Chunk(8192, j2, -1);
            }
            this.currentLoadingChunk = chunk;
            this.currentLoadStartPosition = chunk.start;
            this.cachedDataTracker.unblock();
            this.loader.startLoading(chunk);
            z = true;
            AppMethodBeat.o(76557);
        }
        return z;
    }

    private synchronized void restartLoading(long j2) {
        AppMethodBeat.i(76558);
        Logger.i(TAG, "[restartLoading] from: ".concat(String.valueOf(j2)));
        this.pendingStartPositionByte = j2;
        this.loadFinished = false;
        if (this.loader.isLoading()) {
            this.cachedDataTracker.block();
            this.loader.cancelLoading();
            AppMethodBeat.o(76558);
        } else {
            clearState();
            startLoadingIfNeeded();
            AppMethodBeat.o(76558);
        }
    }

    private boolean isCached(long j2, int i2) {
        AppMethodBeat.i(76559);
        long upstreamSize = this.loader.getUpstreamSize();
        if (upstreamSize > 0 && ((long) i2) + j2 > upstreamSize - 1 && (i2 = (int) ((upstreamSize - j2) - 1)) < 0) {
            j2 += (long) i2;
            i2 = 0;
        }
        boolean isCached = this.cachedDataTracker.isCached(j2, i2);
        AppMethodBeat.o(76559);
        return isCached;
    }

    private void clearState() {
        this.loadFinished = false;
    }

    @SuppressLint({"DefaultLocale"})
    private synchronized void scheduleRestart(final long j2, long j3) {
        AppMethodBeat.i(76560);
        Logger.i(TAG, String.format("[scheduleRestart] position: %d, delay: %d", Long.valueOf(j2), Long.valueOf(j3)));
        if (this.restartHandler == null) {
            this.restartHandler = new Timer("CacheDataSource.Restart");
        }
        if (this.pendingTask != null) {
            this.pendingTask.cancel();
            this.restartHandler.purge();
        }
        this.pendingTask = new TimerTask() {
            /* class com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(190301);
                Logger.i(CacheDataSource.TAG, "[scheduleRestart] restart loading from position: " + j2);
                CacheDataSource.access$200(CacheDataSource.this, j2);
                AppMethodBeat.o(190301);
            }
        };
        this.restartHandler.schedule(this.pendingTask, j3);
        AppMethodBeat.o(76560);
    }

    class LoaderListener implements Loader.Listener {
        private long loadedPosition;

        private LoaderListener() {
            this.loadedPosition = CacheDataSource.NO_RESET_PENDING;
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener
        public synchronized void onLoadCancelled(boolean z) {
            AppMethodBeat.i(76565);
            Logger.i(CacheDataSource.TAG, "[onLoadCancelled] enter. terminated: ".concat(String.valueOf(z)));
            if (!z) {
                try {
                    if (!CacheDataSource.access$300(CacheDataSource.this)) {
                        CacheDataSource.this.cachedDataTracker.abandonLock();
                    }
                    AppMethodBeat.o(76565);
                } catch (IllegalStateException e2) {
                    onLoadError(new IOException("failed to start load after cancelling", e2));
                }
            }
            CacheDataSource.this.cachedDataTracker.abandonLock();
            AppMethodBeat.o(76565);
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener
        public void onLoadCompleted() {
            AppMethodBeat.i(76566);
            CacheDataSource.this.currentLoadStartPosition = CacheDataSource.NO_RESET_PENDING;
            CacheDataSource.this.currentLoadingChunk = null;
            CacheDataSource.this.loadFinished = true;
            CacheDataSource.this.cachedDataTracker.abandonLock();
            if (CacheDataSource.this.listener != null) {
                CacheDataSource.this.listener.onStreamingFinished();
            }
            AppMethodBeat.o(76566);
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener
        public void onLoadProgress(long j2, long j3) {
            AppMethodBeat.i(76567);
            this.loadedPosition = j3;
            CacheDataSource.this.cachedDataTracker.addRange(j2, j3, CacheDataSource.this.isWaitingForFirstPiece);
            Loader loader = CacheDataSource.this.loader;
            Listener listener = CacheDataSource.this.listener;
            if (!(listener == null || loader == null)) {
                CacheDataSource.this.cachedDataTracker.setFileTotalSize(loader.getUpstreamSize());
                listener.onUpStreamTransfer(j3, loader.getUpstreamSize());
            }
            AppMethodBeat.o(76567);
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener
        public void onLoadError(IOException iOException) {
            long j2;
            AppMethodBeat.i(76568);
            Logger.e(CacheDataSource.TAG, "[onLoadError] enter.", iOException);
            if (this.loadedPosition == CacheDataSource.NO_RESET_PENDING) {
                j2 = 0;
            } else {
                j2 = this.loadedPosition;
            }
            CacheDataSource.this.pendingRestartPositionByte = this.loadedPosition;
            if (CacheDataSource.this.listener != null) {
                long onStreamingError = CacheDataSource.this.listener.onStreamingError(iOException);
                if (onStreamingError >= 0) {
                    CacheDataSource.access$1100(CacheDataSource.this, j2, onStreamingError);
                    CacheDataSource.this.pendingRestartPositionByte = CacheDataSource.NO_RESET_PENDING;
                    AppMethodBeat.o(76568);
                    return;
                }
                CacheDataSource.this.currentLoadStartPosition = CacheDataSource.NO_RESET_PENDING;
                CacheDataSource.this.currentLoadingChunk = null;
                CacheDataSource.this.cachedDataTracker.abandonLock();
                AppMethodBeat.o(76568);
                return;
            }
            CacheDataSource.this.currentLoadStartPosition = CacheDataSource.NO_RESET_PENDING;
            CacheDataSource.this.currentLoadingChunk = null;
            CacheDataSource.this.cachedDataTracker.abandonLock();
            AppMethodBeat.o(76568);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.Collectable
    public void accept(PlayerInfoCollector playerInfoCollector) {
        AppMethodBeat.i(76561);
        long j2 = 0;
        for (int i2 = 1; i2 < profiles.length; i2++) {
            j2 += this.costs[i2];
        }
        double length = ((double) (this.costs[0] - j2)) / ((double) this.costs.length);
        long[] jArr = new long[this.costs.length];
        System.arraycopy(this.costs, 0, jArr, 0, this.costs.length);
        for (int i3 = 1; i3 < jArr.length; i3++) {
            jArr[i3] = Math.max(jArr[i3] - ((long) length), 0L);
        }
        for (int i4 = 1; i4 < profiles.length; i4++) {
            playerInfoCollector.putLong("CacheDataSource." + profiles[i4], jArr[i4] / TimeUtil.SECOND_TO_US);
        }
        AppMethodBeat.o(76561);
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.Collectable
    public void accept(ErrorUploadCollector errorUploadCollector) {
    }

    public static class Factory {
        public static CacheDataSource createFromLoader(File file, Loader.Factory factory) {
            AppMethodBeat.i(76498);
            CacheDataSource cacheDataSource = new CacheDataSource(new FileDataSource(file.getAbsolutePath()), factory);
            AppMethodBeat.o(76498);
            return cacheDataSource;
        }

        public static CacheDataSource createFromUriLoader(UriLoader uriLoader) {
            AppMethodBeat.i(76499);
            try {
                final File createTempFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
                ensureFile(createTempFile);
                CacheDataSource cacheDataSource = new CacheDataSource(new FileDataSource(createTempFile.getAbsolutePath()) {
                    /* class com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.AnonymousClass1 */

                    @Override // java.io.Closeable, com.tencent.qqmusic.mediaplayer.upstream.FileDataSource, java.lang.AutoCloseable
                    public final void close() {
                        AppMethodBeat.i(76492);
                        try {
                            super.close();
                        } catch (IOException e2) {
                        }
                        if (!createTempFile.delete()) {
                            Logger.w(CacheDataSource.TAG, "failed to delete buffer file: " + createTempFile);
                        }
                        AppMethodBeat.o(76492);
                    }
                }, createDefaultLoaderFactory(createTempFile, uriLoader));
                AppMethodBeat.o(76499);
                return cacheDataSource;
            } catch (IOException e2) {
                DataSourceException dataSourceException = new DataSourceException(-8, "failed to ensure buffer file!", e2);
                AppMethodBeat.o(76499);
                throw dataSourceException;
            }
        }

        public static CacheDataSource createFromUriLoader(File file, UriLoader uriLoader) {
            AppMethodBeat.i(76500);
            CacheDataSource cacheDataSource = new CacheDataSource(new FileDataSource(file.getAbsolutePath()), createDefaultLoaderFactory(file, uriLoader));
            AppMethodBeat.o(76500);
            return cacheDataSource;
        }

        public static CacheDataSource createFromUri(File file, Uri uri) {
            AppMethodBeat.i(76501);
            CacheDataSource createFromUriLoader = createFromUriLoader(file, new DummyUriLoader(uri));
            AppMethodBeat.o(76501);
            return createFromUriLoader;
        }

        private static void ensureFile(File file) {
            AppMethodBeat.i(76502);
            file.delete();
            if (!file.createNewFile()) {
                IOException iOException = new IOException("failed to create file!");
                AppMethodBeat.o(76502);
                throw iOException;
            }
            AppMethodBeat.o(76502);
        }

        private static Loader.Factory createDefaultLoaderFactory(final File file, final UriLoader uriLoader) {
            AppMethodBeat.i(76503);
            AnonymousClass2 r0 = new Loader.Factory() {
                /* class com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.AnonymousClass2 */

                @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Factory
                public final Loader createLoader(Loader.Listener listener) {
                    AppMethodBeat.i(76545);
                    AnonymousClass1 r0 = new DefaultLoader(Looper.getMainLooper(), uriLoader, listener) {
                        /* class com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.AnonymousClass2.AnonymousClass1 */

                        /* access modifiers changed from: protected */
                        @Override // com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
                        public IDataSource createUpStream(StreamingRequest streamingRequest) {
                            AppMethodBeat.i(76494);
                            HttpDataSource httpDataSource = new HttpDataSource(streamingRequest.uri, streamingRequest.headers, new DefaultMediaHTTPService());
                            AppMethodBeat.o(76494);
                            return httpDataSource;
                        }

                        /* access modifiers changed from: protected */
                        @Override // com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
                        public IDataSink createCacheSink(StreamingRequest streamingRequest) {
                            AppMethodBeat.i(76495);
                            FileDataSink fileDataSink = new FileDataSink(file.getAbsolutePath());
                            AppMethodBeat.o(76495);
                            return fileDataSink;
                        }
                    };
                    AppMethodBeat.o(76545);
                    return r0;
                }
            };
            AppMethodBeat.o(76503);
            return r0;
        }
    }
}
