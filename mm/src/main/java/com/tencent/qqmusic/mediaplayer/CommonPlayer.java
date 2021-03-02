package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.downstream.FileDataSink;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.HttpDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.upstream.TracerDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.Thread;
import java.util.List;

public class CommonPlayer extends BaseMediaPlayer {
    private static final int INIT_STATE_CHECK_TIME = 5000;
    private static final String TAG = "CommonPlayer";
    private int currentState;
    private Looper eventLooper;
    private CorePlayer mAudioPlayer;
    private int mBufferPercentage;
    private final ListPlayerListenerCallback mCallback;
    private long mDuration;
    private final QMThreadExecutor mExecutor;
    private String mLocalPlayPath;
    private boolean mPreferMediaCodecDecode;
    private Float mSpeedToSet;
    private OpenedResources openedResources;

    static /* synthetic */ String access$1000(CommonPlayer commonPlayer, String str) {
        AppMethodBeat.i(76479);
        String auxiliary = commonPlayer.auxiliary(str);
        AppMethodBeat.o(76479);
        return auxiliary;
    }

    static /* synthetic */ void access$300(CommonPlayer commonPlayer, int i2, int i3, int i4) {
        AppMethodBeat.i(76477);
        commonPlayer.onError(i2, i3, i4);
        AppMethodBeat.o(76477);
    }

    static /* synthetic */ void access$400(CommonPlayer commonPlayer, IDataSource iDataSource) {
        AppMethodBeat.i(76478);
        commonPlayer.setDataSourceInternal(iDataSource);
        AppMethodBeat.o(76478);
    }

    /* access modifiers changed from: package-private */
    public class CorePlayerCallback implements PlayerCallback {
        private final IDataSource mDataSource;
        private final IDataSourceFactory mFactory;

        private CorePlayerCallback(IDataSourceFactory iDataSourceFactory, IDataSource iDataSource) {
            this.mFactory = iDataSourceFactory;
            this.mDataSource = iDataSource;
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playThreadStart(CorePlayer corePlayer) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerPrepared(CorePlayer corePlayer) {
            AppMethodBeat.i(76591);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerPrepared() callback prepared");
                CommonPlayer.this.TransferStateTo(2);
                CommonPlayer.this.mCallback.onPrepared(CommonPlayer.this);
                AppMethodBeat.o(76591);
                return;
            }
            Logger.i(CommonPlayer.TAG, "different playerPrepared");
            AppMethodBeat.o(76591);
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerStopped(CorePlayer corePlayer) {
            AppMethodBeat.i(76592);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerStopped() callback stopped");
                AppMethodBeat.o(76592);
                return;
            }
            Logger.i(CommonPlayer.TAG, "different playerStopped");
            AppMethodBeat.o(76592);
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerStarted(CorePlayer corePlayer) {
            AppMethodBeat.i(76593);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerStarted() callback started");
                CommonPlayer.this.mCallback.onStarted(CommonPlayer.this);
                AppMethodBeat.o(76593);
                return;
            }
            Logger.i(CommonPlayer.TAG, "different playerStarted");
            AppMethodBeat.o(76593);
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerSeekCompletion(CorePlayer corePlayer, int i2) {
            AppMethodBeat.i(76594);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerSeekCompletion() callback seek completion");
                CommonPlayer.this.mCallback.onSeekComplete(CommonPlayer.this, i2);
                AppMethodBeat.o(76594);
                return;
            }
            Logger.i(CommonPlayer.TAG, "different playerSeekCompletion");
            AppMethodBeat.o(76594);
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerPaused(CorePlayer corePlayer) {
            AppMethodBeat.i(76595);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerPaused() callback paused");
                AppMethodBeat.o(76595);
                return;
            }
            Logger.i(CommonPlayer.TAG, "different playerPaused");
            AppMethodBeat.o(76595);
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerException(CorePlayer corePlayer, int i2, int i3, int i4) {
            AppMethodBeat.i(76596);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.e(CommonPlayer.TAG, "playerException() callback exception what = " + i2 + ",extra = " + i3 + " mAudioPlayer:" + CommonPlayer.this.mAudioPlayer);
                if (CommonPlayer.this.mAudioPlayer != null) {
                    Logger.e(CommonPlayer.TAG, "handleMessage state = ".concat(String.valueOf(CommonPlayer.this.mAudioPlayer.getPlayerState())));
                    Logger.e(CommonPlayer.TAG, "handleMessage isInit = " + CommonPlayer.this.mAudioPlayer.isInit() + ",isStartDecode = " + CommonPlayer.this.mAudioPlayer.hasDecodeData() + ",decodeSuccess = " + CommonPlayer.this.mAudioPlayer.hasDecodeDataSuccess());
                }
                if (!CommonPlayer.this.mPreferMediaCodecDecode || i2 != 91) {
                    CommonPlayer.access$300(CommonPlayer.this, i2, i3, i4);
                    AppMethodBeat.o(76596);
                    return;
                }
                CommonPlayer.this.mPreferMediaCodecDecode = false;
                if (this.mFactory != null) {
                    try {
                        CommonPlayer.this.setDataSource(this.mFactory);
                        CommonPlayer.this.prepare();
                        AppMethodBeat.o(76596);
                    } catch (Exception e2) {
                        Logger.e(CommonPlayer.TAG, "retry nativeDecoder", e2);
                        CommonPlayer.access$300(CommonPlayer.this, i2, i3, i4);
                        AppMethodBeat.o(76596);
                    }
                } else if (this.mDataSource != null) {
                    CommonPlayer.access$400(CommonPlayer.this, this.mDataSource);
                    CommonPlayer.this.prepare();
                    AppMethodBeat.o(76596);
                } else {
                    CommonPlayer.access$300(CommonPlayer.this, i2, i3, i4);
                    AppMethodBeat.o(76596);
                }
            } else {
                Logger.i(CommonPlayer.TAG, "different playerException");
                AppMethodBeat.o(76596);
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerEnded(CorePlayer corePlayer) {
            AppMethodBeat.i(76597);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerEnded() callback ended");
                CommonPlayer.this.TransferStateTo(7);
                CommonPlayer.this.mCallback.onCompletion(CommonPlayer.this);
                AppMethodBeat.o(76597);
                return;
            }
            Logger.i(CommonPlayer.TAG, "different playerEnded");
            AppMethodBeat.o(76597);
        }
    }

    public CommonPlayer() {
        this(null, null, false, new QMThreadExecutor() {
            /* class com.tencent.qqmusic.mediaplayer.CommonPlayer.AnonymousClass1 */

            @Override // com.tencent.qqmusic.mediaplayer.QMThreadExecutor
            public void execute(Runnable runnable, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
                AppMethodBeat.i(76676);
                Thread thread = new Thread(runnable, "decoder");
                thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                thread.start();
                AppMethodBeat.o(76676);
            }
        });
        AppMethodBeat.i(76433);
        AppMethodBeat.o(76433);
    }

    public CommonPlayer(PlayerListenerCallback playerListenerCallback) {
        this(playerListenerCallback, null, false, new QMThreadExecutor() {
            /* class com.tencent.qqmusic.mediaplayer.CommonPlayer.AnonymousClass2 */

            @Override // com.tencent.qqmusic.mediaplayer.QMThreadExecutor
            public void execute(Runnable runnable, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
                AppMethodBeat.i(76598);
                Thread thread = new Thread(runnable, "decoder");
                thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                thread.start();
                AppMethodBeat.o(76598);
            }
        });
        AppMethodBeat.i(76434);
        AppMethodBeat.o(76434);
    }

    public CommonPlayer(PlayerListenerCallback playerListenerCallback, Looper looper, boolean z, QMThreadExecutor qMThreadExecutor) {
        boolean z2 = false;
        AppMethodBeat.i(76435);
        this.mCallback = new ListPlayerListenerCallback();
        this.mAudioPlayer = null;
        this.currentState = 0;
        this.mSpeedToSet = null;
        this.mPreferMediaCodecDecode = false;
        this.mLocalPlayPath = null;
        if (playerListenerCallback != null) {
            this.mCallback.add(playerListenerCallback);
        }
        this.eventLooper = looper;
        if (Build.VERSION.SDK_INT >= 23 && z) {
            z2 = true;
        }
        this.mPreferMediaCodecDecode = z2;
        this.mExecutor = qMThreadExecutor;
        reset();
        AppMethodBeat.o(76435);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public int getDuration() {
        long j2 = 0;
        AppMethodBeat.i(76436);
        if (this.mAudioPlayer != null) {
            this.mDuration = this.mAudioPlayer.getDuration();
            int i2 = (int) this.mDuration;
            AppMethodBeat.o(76436);
            return i2;
        }
        Logger.e(TAG, "getDuration() mAudioPlayer is null!");
        if (this.mDuration > 0) {
            j2 = this.mDuration;
        }
        int i3 = (int) j2;
        AppMethodBeat.o(76436);
        return i3;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public int getPlayerState() {
        return this.currentState;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public boolean isPlaying() {
        AppMethodBeat.i(76437);
        if (this.mAudioPlayer == null) {
            Logger.e(TAG, "isPlaying() mAudioPlayer is null!");
            AppMethodBeat.o(76437);
            return false;
        } else if (this.mAudioPlayer.getPlayerState() == 4) {
            AppMethodBeat.o(76437);
            return true;
        } else {
            AppMethodBeat.o(76437);
            return false;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void pause() {
        AppMethodBeat.i(76438);
        TransferStateTo(5);
        Logger.i(TAG, auxiliary("[pause]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.pause(false);
        } else {
            Logger.e(TAG, "pause() mAudioPlayer is null!");
        }
        notifyPauseSong();
        AppMethodBeat.o(76438);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void pauseRealTime() {
        AppMethodBeat.i(76439);
        TransferStateTo(5);
        Logger.i(TAG, auxiliary("[pauseRealTime]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.pause(true);
        } else {
            Logger.e(TAG, "pauseRealTime() mAudioPlayer is null!");
        }
        notifyPauseSong();
        AppMethodBeat.o(76439);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void prepare() {
        AppMethodBeat.i(76440);
        TransferStateTo(3);
        Logger.i(TAG, auxiliary("[prepare]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.prepare();
            AppMethodBeat.o(76440);
            return;
        }
        Logger.e(TAG, "prepare() null mAudioPlayer!");
        AppMethodBeat.o(76440);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void prepareAsync() {
        AppMethodBeat.i(76441);
        UnSupportMethodException unSupportMethodException = new UnSupportMethodException("Soft decode player cannot support prepareAsync");
        AppMethodBeat.o(76441);
        throw unSupportMethodException;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void release() {
        AppMethodBeat.i(76442);
        TransferStateTo(8);
        Logger.i(TAG, auxiliary("[release]"));
        resetInternal();
        this.mCallback.clear();
        AppMethodBeat.o(76442);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void reset() {
        AppMethodBeat.i(76443);
        TransferStateTo(0);
        Logger.i(TAG, auxiliary("[reset]"));
        resetInternal();
        AppMethodBeat.o(76443);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void seekTo(int i2) {
        AppMethodBeat.i(76444);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.seek(i2);
            AppMethodBeat.o(76444);
            return;
        }
        Logger.e(TAG, "seekTo() mAudioPlayer is null!");
        AppMethodBeat.o(76444);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(String str) {
        AppMethodBeat.i(76445);
        if (str == null) {
            Logger.e(TAG, "setDataSource() ERROR:the path is null!");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("the path is null!");
            AppMethodBeat.o(76445);
            throw illegalArgumentException;
        }
        TransferStateTo(1);
        Logger.i(TAG, "setDataSource, path: ".concat(String.valueOf(str)));
        this.mBufferPercentage = 100;
        setDataSourceInternal(new FileDataSource(str));
        AppMethodBeat.o(76445);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(76446);
        UnSupportMethodException unSupportMethodException = new UnSupportMethodException("Soft decode player cannot support setDataSource by FileDescriptor");
        AppMethodBeat.o(76446);
        throw unSupportMethodException;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setVolume(float f2, float f3) {
        AppMethodBeat.i(76447);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setVolume(f2, f3);
        }
        AppMethodBeat.o(76447);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void start() {
        AppMethodBeat.i(76448);
        TransferStateTo(4);
        Logger.i(TAG, auxiliary("[start]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.play();
        } else {
            Logger.e(TAG, "start() mAudioPlayer is null!");
        }
        notifyStartPlaySong();
        AppMethodBeat.o(76448);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void stop() {
        AppMethodBeat.i(76449);
        try {
            TransferStateTo(6);
            Logger.i(TAG, auxiliary("[stop]"));
            if (this.mAudioPlayer != null) {
                this.mAudioPlayer.stop();
                AppMethodBeat.o(76449);
                return;
            }
            Logger.e(TAG, "stop() mAudioPlayer is null!");
            AppMethodBeat.o(76449);
        } catch (Exception e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(76449);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setPlayerListenerCallback(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.i(76450);
        this.mCallback.clear();
        this.mCallback.add(playerListenerCallback);
        AppMethodBeat.o(76450);
    }

    public void addPlayerListenerCallback(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.i(76451);
        this.mCallback.add(playerListenerCallback);
        AppMethodBeat.o(76451);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public long getCurrentPosition() {
        AppMethodBeat.i(76452);
        if (this.mAudioPlayer != null) {
            long curPosition = this.mAudioPlayer.getCurPosition();
            AppMethodBeat.o(76452);
            return curPosition;
        }
        Logger.e(TAG, "getCurrentPosition() mAudioPlayer is null!");
        AppMethodBeat.o(76452);
        return 0;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void flush() {
        AppMethodBeat.i(76453);
        if (this.mAudioPlayer == null) {
            Logger.e(TAG, "[getCurrentFrame] mAudioPlayer is null!");
            AppMethodBeat.o(76453);
            return;
        }
        this.mAudioPlayer.flush();
        AppMethodBeat.o(76453);
    }

    public long getDecodePosition() {
        AppMethodBeat.i(76454);
        if (this.mAudioPlayer != null) {
            long curPositionByDecoder = this.mAudioPlayer.getCurPositionByDecoder();
            AppMethodBeat.o(76454);
            return curPositionByDecoder;
        }
        Logger.e(TAG, "getDecodePosition() ERROR : mAudioPlayer is null!");
        AppMethodBeat.o(76454);
        return 0;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        AppMethodBeat.i(76455);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            setDataSource(uri.toString());
            AppMethodBeat.o(76455);
        } else if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https")) {
            setDataSource(new DefaultMediaHTTPService(), uri);
            AppMethodBeat.o(76455);
        } else {
            if (!scheme.equalsIgnoreCase("content")) {
                scheme.equalsIgnoreCase("file");
            }
            AppMethodBeat.o(76455);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(IMediaHTTPService iMediaHTTPService, Uri uri) {
        AppMethodBeat.i(76456);
        try {
            File createTempFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
            createTempFile.delete();
            if (!createTempFile.createNewFile()) {
                onError(90, 103, 0);
                AppMethodBeat.o(76456);
                return;
            }
            String absolutePath = createTempFile.getAbsolutePath();
            CacheDataSource cacheDataSource = new CacheDataSource(new HttpDataSource(uri, null, iMediaHTTPService), new FileDataSource(absolutePath), new FileDataSink(absolutePath), insureEventLooper());
            this.openedResources = new OpenedResources();
            this.openedResources.bufferFile = createTempFile;
            this.openedResources.dataSource = cacheDataSource;
            cacheDataSource.setListener(new BufferListener());
            setDataSourceInternal(cacheDataSource);
            AppMethodBeat.o(76456);
        } catch (IOException e2) {
            onError(90, 103, 0);
            AppMethodBeat.o(76456);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(IDataSourceFactory iDataSourceFactory) {
        AppMethodBeat.i(76457);
        if (iDataSourceFactory == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("dataSourceFactory is null!");
            AppMethodBeat.o(76457);
            throw illegalArgumentException;
        }
        TransferStateTo(1);
        CorePlayerCallback corePlayerCallback = new CorePlayerCallback(iDataSourceFactory, null);
        if (this.mPreferMediaCodecDecode) {
            this.mAudioPlayer = new CorePlayer(iDataSourceFactory.createDataSource(), null, corePlayerCallback, insureEventLooper(), new MediaCodecDecoder(), this.mExecutor);
        } else {
            INativeDataSource createNativeDataSource = iDataSourceFactory.createNativeDataSource();
            if (createNativeDataSource != null) {
                this.mAudioPlayer = new CorePlayer(null, createNativeDataSource, corePlayerCallback, insureEventLooper(), new NativeDecoder(), this.mExecutor);
            } else {
                this.mAudioPlayer = new CorePlayer(iDataSourceFactory.createDataSource(), null, corePlayerCallback, insureEventLooper(), new NativeDecoder(), this.mExecutor);
            }
        }
        this.mAudioPlayer.setThreadName(iDataSourceFactory.toString());
        setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
        if (this.mLocalPlayPath != null) {
            this.mAudioPlayer.setPlayPath(this.mLocalPlayPath);
        }
        AppMethodBeat.o(76457);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(TrackInfo trackInfo) {
        AppMethodBeat.i(76458);
        TransferStateTo(1);
        Logger.i(TAG, "setDataSource, trackInfo.getUri: " + trackInfo.getUri());
        Logger.i(TAG, "setDataSource, trackInfo.range: " + trackInfo.getRange().toString());
        this.mBufferPercentage = 100;
        TrackDataSource trackDataSource = new TrackDataSource(trackInfo);
        List<PlayerListenerCallback> collection = this.mCallback.toCollection();
        this.mCallback.clear();
        this.mCallback.add(trackDataSource);
        this.mCallback.addAll(collection);
        TransferStateTo(1);
        TracerDataSource tracerDataSource = new TracerDataSource(trackDataSource);
        this.mAudioPlayer = new TrackCorePlayer(tracerDataSource, new CorePlayerCallback(null, tracerDataSource), insureEventLooper(), this.mExecutor);
        trackDataSource.setTrackStateCallback((TrackCorePlayer) this.mAudioPlayer);
        this.mAudioPlayer.setThreadName(trackDataSource.toString());
        setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
        AppMethodBeat.o(76458);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(Context context, final UriLoader uriLoader) {
        AppMethodBeat.i(76459);
        setDataSource(new IDataSourceFactory() {
            /* class com.tencent.qqmusic.mediaplayer.CommonPlayer.AnonymousClass3 */

            @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
            public IDataSource createDataSource() {
                AppMethodBeat.i(76575);
                CacheDataSource createFromUriLoader = CacheDataSource.Factory.createFromUriLoader(uriLoader);
                AppMethodBeat.o(76575);
                return createFromUriLoader;
            }

            @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
            public INativeDataSource createNativeDataSource() {
                return null;
            }
        });
        AppMethodBeat.o(76459);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setAudioStreamType(int i2) {
        AppMethodBeat.i(76460);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setAudioStreamType(i2);
        }
        AppMethodBeat.o(76460);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setWakeMode(Context context, int i2) {
        AppMethodBeat.i(76461);
        UnSupportMethodException unSupportMethodException = new UnSupportMethodException("Soft decode player cannot support setWakeMode");
        AppMethodBeat.o(76461);
        throw unSupportMethodException;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public long getCurrentPositionFromFile() {
        return 0;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public AudioInformation getCurrentAudioInformation() {
        AppMethodBeat.i(76462);
        if (this.mAudioPlayer != null) {
            AudioInformation currentAudioInformation = this.mAudioPlayer.getCurrentAudioInformation();
            AppMethodBeat.o(76462);
            return currentAudioInformation;
        }
        AppMethodBeat.o(76462);
        return null;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public int getSessionId() {
        AppMethodBeat.i(76463);
        if (this.mAudioPlayer != null) {
            int sessionId = this.mAudioPlayer.getSessionId();
            AppMethodBeat.o(76463);
            return sessionId;
        }
        AppMethodBeat.o(76463);
        return 0;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public int getDecoderType() {
        return this.mPreferMediaCodecDecode ? 2 : 1;
    }

    /* access modifiers changed from: package-private */
    public void setPlayerMode(int i2) {
        AppMethodBeat.i(76464);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setPlayerMode(i2);
        }
        AppMethodBeat.o(76464);
    }

    /* access modifiers changed from: package-private */
    public int getPlayerMode() {
        AppMethodBeat.i(76465);
        if (this.mAudioPlayer != null) {
            int playerMode = this.mAudioPlayer.getPlayerMode();
            AppMethodBeat.o(76465);
            return playerMode;
        }
        AppMethodBeat.o(76465);
        return 0;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void addAudioListener(IAudioListener iAudioListener) {
        AppMethodBeat.i(76466);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.addAudioListener(iAudioListener);
        }
        AppMethodBeat.o(76466);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void removeAudioListener(IAudioListener iAudioListener) {
        AppMethodBeat.i(76467);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.removeAudioListener(iAudioListener);
        }
        AppMethodBeat.o(76467);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public SeekTable createSeekTable() {
        AppMethodBeat.i(76468);
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer == null) {
            IllegalStateException illegalStateException = new IllegalStateException("not initialized!");
            AppMethodBeat.o(76468);
            throw illegalStateException;
        }
        SeekTable createSeekTable = corePlayer.createSeekTable();
        AppMethodBeat.o(76468);
        return createSeekTable;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void TransferStateTo(int i2) {
        AppMethodBeat.i(76469);
        Logger.i("StateRunner", this.currentState + " -> " + i2);
        this.currentState = i2;
        if (this.mCallback != null) {
            this.mCallback.onStateChanged(this, i2);
        }
        AppMethodBeat.o(76469);
    }

    private Looper insureEventLooper() {
        AppMethodBeat.i(76470);
        if (this.eventLooper == null) {
            HandlerThread handlerThread = new HandlerThread("CommonPlayer_EventHandler_" + hashCode());
            handlerThread.start();
            this.eventLooper = handlerThread.getLooper();
        }
        Looper looper = this.eventLooper;
        AppMethodBeat.o(76470);
        return looper;
    }

    private void onError(int i2, int i3) {
        AppMethodBeat.i(76471);
        onError(i2, i3, 0);
        AppMethodBeat.o(76471);
    }

    private void onError(int i2, int i3, int i4) {
        AppMethodBeat.i(76472);
        TransferStateTo(9);
        Logger.e(TAG, "onError prefer MediaCodec " + this.mPreferMediaCodecDecode);
        this.mCallback.onError(this, i2, i3, i4);
        AppMethodBeat.o(76472);
    }

    private void resetInternal() {
        AppMethodBeat.i(76473);
        if (this.openedResources != null) {
            this.openedResources.release();
        }
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.release();
            this.mAudioPlayer = null;
        }
        if (!(this.eventLooper == null || this.eventLooper == Looper.getMainLooper())) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.eventLooper.quitSafely();
            } else {
                this.eventLooper.quit();
            }
            this.eventLooper = null;
        }
        this.mDuration = 0;
        this.mBufferPercentage = 0;
        this.mSpeedToSet = null;
        AppMethodBeat.o(76473);
    }

    private String auxiliary(String str) {
        AppMethodBeat.i(76474);
        CorePlayer corePlayer = this.mAudioPlayer;
        String str2 = this.mPreferMediaCodecDecode ? "[MediaCodec]" : "";
        if (corePlayer == null) {
            AppMethodBeat.o(76474);
            return BuildConfig.COMMAND;
        }
        String str3 = "[" + corePlayer + "]" + str2 + str;
        AppMethodBeat.o(76474);
        return str3;
    }

    public int getBufferedPercentage() {
        return this.mBufferPercentage;
    }

    private void setDataSourceInternal(IDataSource iDataSource) {
        AppMethodBeat.i(76475);
        TransferStateTo(1);
        this.mAudioPlayer = new CorePlayer(new TracerDataSource(iDataSource), null, new CorePlayerCallback(null, iDataSource), insureEventLooper(), this.mPreferMediaCodecDecode ? new MediaCodecDecoder() : new NativeDecoder(), this.mExecutor);
        this.mAudioPlayer.setThreadName(iDataSource.toString());
        setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
        AppMethodBeat.o(76475);
    }

    /* access modifiers changed from: package-private */
    public class BufferListener implements CacheDataSource.Listener {
        private BufferListener() {
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
        public void onBufferStarted(long j2) {
            AppMethodBeat.i(76416);
            Logger.i(CommonPlayer.TAG, CommonPlayer.access$1000(CommonPlayer.this, "buffer started."));
            AppMethodBeat.o(76416);
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
        public void onBufferEnded() {
            AppMethodBeat.i(76417);
            Logger.i(CommonPlayer.TAG, CommonPlayer.access$1000(CommonPlayer.this, "buffer ended."));
            AppMethodBeat.o(76417);
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
        public void onUpStreamTransfer(long j2, long j3) {
            AppMethodBeat.i(76418);
            if (CommonPlayer.this.getPlayerState() == 2 || CommonPlayer.this.getPlayerState() == 4) {
                int round = (int) Math.round((((double) j2) / ((double) j3)) * 100.0d);
                if (round == CommonPlayer.this.mBufferPercentage) {
                    AppMethodBeat.o(76418);
                    return;
                }
                CommonPlayer.this.mBufferPercentage = round;
                CommonPlayer.this.mCallback.onBufferingUpdate(CommonPlayer.this, CommonPlayer.this.mBufferPercentage);
                AppMethodBeat.o(76418);
                return;
            }
            AppMethodBeat.o(76418);
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
        public long onStreamingError(IOException iOException) {
            AppMethodBeat.i(76419);
            Logger.e(CommonPlayer.TAG, CommonPlayer.access$1000(CommonPlayer.this, "streaming error!"), iOException);
            AppMethodBeat.o(76419);
            return -1;
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
        public void onStreamingFinished() {
            AppMethodBeat.i(76420);
            CommonPlayer.this.mBufferPercentage = 100;
            Logger.i(CommonPlayer.TAG, CommonPlayer.access$1000(CommonPlayer.this, "streaming finished"));
            AppMethodBeat.o(76420);
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.TransferListener
        public void onTransferStart() {
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.TransferListener
        public void onBytesTransferring(long j2, long j3) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.TransferListener
        public void onBytesTransferred(long j2, long j3) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.TransferListener
        public void onBytesTransferError(long j2, long j3, long j4) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.TransferListener
        public void onTransferEnd() {
        }
    }

    public void setSpeed(float f2) {
        AppMethodBeat.i(175614);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setSpeed(f2);
            AppMethodBeat.o(175614);
            return;
        }
        this.mSpeedToSet = Float.valueOf(f2);
        AppMethodBeat.o(175614);
    }

    public float getSpeed() {
        AppMethodBeat.i(190286);
        float f2 = 1.0f;
        if (this.mAudioPlayer != null) {
            f2 = this.mAudioPlayer.getSpeed();
        } else if (this.mSpeedToSet != null) {
            f2 = this.mSpeedToSet.floatValue();
        }
        AppMethodBeat.o(190286);
        return f2;
    }

    private void setSpeedToCorePlayerIfNeeded(CorePlayer corePlayer) {
        AppMethodBeat.i(175615);
        if (this.mSpeedToSet != null) {
            corePlayer.setSpeed(this.mSpeedToSet.floatValue());
            this.mSpeedToSet = null;
        }
        AppMethodBeat.o(175615);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setPlayLocalPath(String str) {
        AppMethodBeat.i(76476);
        this.mLocalPlayPath = str;
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setPlayPath(this.mLocalPlayPath);
        }
        AppMethodBeat.o(76476);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setLeastCommonMultiple(int i2) {
        AppMethodBeat.i(175616);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setLeastCommonMultiple(i2);
        }
        AppMethodBeat.o(175616);
    }

    /* access modifiers changed from: package-private */
    public static class OpenedResources {
        private File bufferFile;
        private CacheDataSource dataSource;

        private OpenedResources() {
        }

        /* access modifiers changed from: package-private */
        public void release() {
            AppMethodBeat.i(76722);
            if (this.bufferFile != null && !this.bufferFile.delete()) {
                Logger.w(CommonPlayer.TAG, "[release] failed to delete buffer file: " + this.bufferFile);
            }
            if (this.dataSource != null) {
                this.dataSource.setListener(null);
                this.dataSource.releaseLock();
            }
            AppMethodBeat.o(76722);
        }
    }
}
