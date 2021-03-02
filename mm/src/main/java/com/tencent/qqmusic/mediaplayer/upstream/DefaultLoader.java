package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.upstream.Loader;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class DefaultLoader extends Thread implements Loader {
    private static final int MSG_LOAD_CANCELLED = 5;
    private static final int MSG_LOAD_COMPLETED = 3;
    private static final int MSG_LOAD_ERROR = 4;
    private static final int MSG_LOAD_PROGRESS = 2;
    private static final int MSG_LOAD_STARTED = 1;
    private static final int SIZE_UNSET = -1;
    private static final String TAG = "DefaultLoader";
    private final Chunk END_OF_QUEUE = new Chunk(0, 0, 0);
    private IDataSink cacheSink;
    private volatile boolean cancelled = false;
    private final BlockingQueue<Chunk> chunks;
    private final Handler eventHandler;
    private volatile boolean isLoading = false;
    private volatile boolean shutdown;
    private IDataSource upstream;
    private long upstreamSize = -1;
    private final UriLoader uriLoader;

    /* access modifiers changed from: protected */
    public abstract IDataSink createCacheSink(StreamingRequest streamingRequest);

    /* access modifiers changed from: protected */
    public abstract IDataSource createUpStream(StreamingRequest streamingRequest);

    protected DefaultLoader(Looper looper, UriLoader uriLoader2, final Loader.Listener listener) {
        this.uriLoader = uriLoader2;
        this.eventHandler = new Handler(looper, new Handler.Callback() {
            /* class com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader.AnonymousClass1 */

            public boolean handleMessage(Message message) {
                AppMethodBeat.i(76497);
                if (listener == null) {
                    AppMethodBeat.o(76497);
                    return false;
                }
                switch (message.what) {
                    case 1:
                    default:
                        DefaultLoader.this.isLoading = false;
                        Logger.i(DefaultLoader.TAG, "[handleMessage] loading = false");
                        switch (message.what) {
                            case 3:
                                listener.onLoadCompleted();
                                AppMethodBeat.o(76497);
                                return true;
                            case 4:
                                listener.onLoadError((IOException) message.obj);
                                AppMethodBeat.o(76497);
                                return true;
                            case 5:
                                listener.onLoadCancelled(DefaultLoader.this.shutdown);
                                AppMethodBeat.o(76497);
                                return true;
                            default:
                                AppMethodBeat.o(76497);
                                return false;
                        }
                    case 2:
                        listener.onLoadProgress((long) message.arg1, (long) message.arg2);
                        AppMethodBeat.o(76497);
                        return true;
                }
            }
        });
        this.chunks = new LinkedBlockingQueue(1);
    }

    public void run() {
        while (!this.shutdown) {
            try {
                Chunk take = this.chunks.take();
                if (this.END_OF_QUEUE == take) {
                    Logger.i(TAG, "[run] end of queue!");
                    return;
                }
                try {
                    if (loadChunk(take)) {
                        this.eventHandler.obtainMessage(3).sendToTarget();
                    } else {
                        this.eventHandler.obtainMessage(5).sendToTarget();
                    }
                } catch (IOException e2) {
                    Logger.e(TAG, "[run] got error!", e2);
                    this.eventHandler.obtainMessage(4, e2).sendToTarget();
                }
            } catch (InterruptedException e3) {
                Logger.w(TAG, "[run] interrupted when taking chunk");
                return;
            }
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public void prepare() {
        if (this.upstream != null) {
            this.upstream.close();
        }
        if (this.cacheSink != null) {
            this.cacheSink.close();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public boolean isLoading() {
        if (this.uriLoader.isLoading()) {
            return true;
        }
        if (!this.isLoading || this.shutdown) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public void cancelLoading() {
        Logger.i(TAG, "[cancelLoading] cancel");
        this.uriLoader.cancelLoading();
        this.cancelled = true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public void startLoading(Chunk chunk) {
        Logger.i(TAG, "[startLoading] chunk: ".concat(String.valueOf(chunk)));
        this.chunks.clear();
        if (!this.chunks.offer(chunk)) {
            throw new IllegalStateException("exceeds maximum of queue!");
        }
        this.isLoading = true;
        Logger.i(TAG, "[handleMessage] loading = true");
        this.cancelled = false;
        if (getState() == Thread.State.NEW) {
            this.uriLoader.startLoading(0, TimeUnit.MILLISECONDS, new UriLoader.Callback() {
                /* class com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader.AnonymousClass2 */

                @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader.Callback
                public void onSucceed(StreamingRequest streamingRequest) {
                    AppMethodBeat.i(76521);
                    Logger.i(DefaultLoader.TAG, "[startLoading] uriLoader.startLoading onSucceed");
                    IDataSource createUpStream = DefaultLoader.this.createUpStream(streamingRequest);
                    try {
                        createUpStream.open();
                        DefaultLoader.this.upstreamSize = createUpStream.getSize();
                    } catch (IOException e2) {
                        DefaultLoader.this.eventHandler.obtainMessage(4, e2).sendToTarget();
                    }
                    IDataSink createCacheSink = DefaultLoader.this.createCacheSink(streamingRequest);
                    try {
                        createCacheSink.open();
                    } catch (IOException e3) {
                        DefaultLoader.this.eventHandler.obtainMessage(4, e3).sendToTarget();
                    }
                    DefaultLoader.this.cacheSink = createCacheSink;
                    DefaultLoader.this.upstream = createUpStream;
                    DefaultLoader.this.start();
                    AppMethodBeat.o(76521);
                }

                @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader.Callback
                public void onFailed(Throwable th) {
                    AppMethodBeat.i(76522);
                    DefaultLoader.this.eventHandler.obtainMessage(4, new IOException("failed to load uri", th)).sendToTarget();
                    AppMethodBeat.o(76522);
                }

                @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader.Callback
                public void onCancelled() {
                    AppMethodBeat.i(76523);
                    DefaultLoader.this.eventHandler.obtainMessage(5).sendToTarget();
                    AppMethodBeat.o(76523);
                }
            });
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public void shutdown() {
        Logger.i(TAG, "[shutdown] enter");
        this.shutdown = true;
        this.chunks.offer(this.END_OF_QUEUE);
        join();
        try {
            if (this.upstream != null) {
                this.upstream.close();
            }
        } catch (IOException e2) {
            Logger.w(TAG, "[shutdown] failed to close upstream");
        }
        try {
            if (this.cacheSink != null) {
                this.cacheSink.close();
            }
        } catch (IOException e3) {
            Logger.w(TAG, "[shutdown] failed to close cacheSink");
        }
        Logger.i(TAG, "[shutdown] exit");
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public long getUpstreamSize() {
        return this.upstreamSize;
    }

    private boolean loadChunk(Chunk chunk) {
        long j2;
        boolean z;
        if (this.upstream == null || this.cacheSink == null) {
            throw new IllegalStateException("loader must be prepared first!");
        }
        long j3 = chunk.start;
        long j4 = chunk.size;
        Logger.d(TAG, "[loadChunk] enter. startPosition: " + j3 + ", chunkSize: " + j4);
        byte[] bArr = new byte[chunk.bufferSize];
        boolean z2 = j4 == -1;
        int length = z2 ? bArr.length : (int) Math.min((long) bArr.length, j4);
        long j5 = 0;
        boolean z3 = false;
        while (true) {
            j2 = j5;
            z = z3;
            long j6 = j3 + j2;
            try {
                int readAt = this.upstream.readAt(j6, bArr, 0, length);
                if (readAt == -1) {
                    Logger.i(TAG, "[loadChunk] read EOF.");
                    break;
                } else if (readAt == 0) {
                    Logger.d(TAG, "[loadChunk] read none.");
                    break;
                } else if (readAt < 0) {
                    throw new IOException(new SourceReadException("read error: ".concat(String.valueOf(readAt)), ""));
                } else {
                    try {
                        long write = (((long) this.cacheSink.write(j6, bArr, 0, readAt)) + j6) - 1;
                        j5 = ((long) readAt) + j2;
                        this.eventHandler.removeMessages(2);
                        this.eventHandler.obtainMessage(2, (int) j3, (int) write).sendToTarget();
                        z3 = this.cancelled || this.shutdown;
                        if (z3 || (!z2 && j5 >= j4)) {
                            j2 = j5;
                            z = z3;
                        }
                    } catch (IOException e2) {
                        throw new IOException(new SinkWriteException(e2));
                    }
                }
            } catch (IOException e3) {
                throw new IOException(new SourceReadException(e3, ""));
            }
        }
        j2 = j5;
        z = z3;
        Logger.d(TAG, "[loadChunk] exit. startPosition: " + j3 + ", loadedBytes: " + j2 + ", this.cancelled: " + this.cancelled + ", shutdown: " + this.shutdown);
        if (!z) {
            return true;
        }
        return false;
    }
}
