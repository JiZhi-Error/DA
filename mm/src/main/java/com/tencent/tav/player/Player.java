package com.tencent.tav.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.player.IPlayer;

public class Player implements Handler.Callback, IPlayer {
    private static final int DEFAULT_MAX_CACHE_SIZE = 60;
    public static final String TAG = "PlayerThreadMain";
    public static final int TYPE_PROGRESS = 2;
    public static final int TYPE_STATES = 1;
    public static final int TYPE_VIEWPORT_UPDATE = 3;
    public static String time = "time";
    private AVPlayerActionAtItemEnd actionAtItemEnd;
    private Asset asset;
    private int bgColor;
    private PlayerItem currentItem;
    private ErrorMsg errMsg;
    private boolean loop;
    private AudioFocusHelper mAudioFocuser;
    private boolean mHasPostedSeek;
    private CMTime mLastSeekTargetTimeUs;
    Handler mMainHandler;
    private CMTimeRange mPlayRange;
    private PlayerThread mPlayThread;
    private IPlayer.PlayerListener mPlayerListener;
    private IPlayer.PlayerStatus mPlayerStatus;
    private CMTime mPosition;
    private CMTime mSeekTargetTimeUs;
    private boolean muted;
    private OnCompositionUpdateListener onCompositionUpdateListener;
    private PlayerLayer playerLayer;
    private float rate;
    private volatile boolean released;
    private PlayerStatus status;
    private OnViewportUpdateListener viewportUpdateListener;
    private float volume;

    enum PlayerStatus {
        PlayerStatusUnknown,
        PlayerStatusReadyToPlay,
        PlayerStatusFailed;

        public static PlayerStatus valueOf(String str) {
            AppMethodBeat.i(218554);
            PlayerStatus playerStatus = (PlayerStatus) Enum.valueOf(PlayerStatus.class, str);
            AppMethodBeat.o(218554);
            return playerStatus;
        }

        static {
            AppMethodBeat.i(218555);
            AppMethodBeat.o(218555);
        }
    }

    enum AVPlayerActionAtItemEnd {
        AVPlayerActionAtItemEndAdvance,
        AVPlayerActionAtItemEndPause,
        AVPlayerActionAtItemEndNone;

        public static AVPlayerActionAtItemEnd valueOf(String str) {
            AppMethodBeat.i(218551);
            AVPlayerActionAtItemEnd aVPlayerActionAtItemEnd = (AVPlayerActionAtItemEnd) Enum.valueOf(AVPlayerActionAtItemEnd.class, str);
            AppMethodBeat.o(218551);
            return aVPlayerActionAtItemEnd;
        }

        static {
            AppMethodBeat.i(218552);
            AppMethodBeat.o(218552);
        }
    }

    public Player(String str) {
        this(new PlayerItem(str));
        AppMethodBeat.i(218556);
        AppMethodBeat.o(218556);
    }

    public Player(PlayerItem playerItem) {
        AppMethodBeat.i(218557);
        this.mPlayerStatus = IPlayer.PlayerStatus.IDLE;
        this.loop = false;
        this.released = false;
        this.bgColor = WebView.NIGHT_MODE_COLOR;
        this.currentItem = playerItem;
        this.mMainHandler = new Handler(Looper.getMainLooper(), this);
        this.asset = this.currentItem.getAsset();
        this.currentItem.start(this);
        this.mPlayThread = this.currentItem.getPlayerThreadMain();
        AppMethodBeat.o(218557);
    }

    public float getRate() {
        return this.rate;
    }

    public void setRate(float f2) {
        AppMethodBeat.i(218558);
        setRate(f2, 60);
        AppMethodBeat.o(218558);
    }

    public void setRate(float f2, int i2) {
        AppMethodBeat.i(218559);
        if (!(this.mPlayerStatus == IPlayer.PlayerStatus.PLAYING || this.mPlayerStatus == IPlayer.PlayerStatus.PAUSED)) {
            this.rate = f2;
            this.currentItem.setRate(f2, i2);
        }
        AppMethodBeat.o(218559);
    }

    public PlayerStatus getStatus() {
        return this.status;
    }

    public ErrorMsg getErrMsg() {
        return this.errMsg;
    }

    public void setBgColor(int i2) {
        this.bgColor = i2;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public CMTime currentTime() {
        AppMethodBeat.i(218560);
        if (this.mPlayThread == null) {
            CMTime cMTime = CMTime.CMTimeZero;
            AppMethodBeat.o(218560);
            return cMTime;
        }
        CMTime position = this.mPlayThread.getPosition();
        AppMethodBeat.o(218560);
        return position;
    }

    public RenderContextParams getRenderContextParams() {
        AppMethodBeat.i(218561);
        if (this.mPlayThread != null) {
            RenderContextParams renderContextParams = this.mPlayThread.getRenderContextParams();
            AppMethodBeat.o(218561);
            return renderContextParams;
        }
        AppMethodBeat.o(218561);
        return null;
    }

    public void setRenderContextParams(RenderContextParams renderContextParams) {
        AppMethodBeat.i(218562);
        if (this.mPlayThread != null) {
            this.mPlayThread.setRenderContextParams(renderContextParams);
        }
        AppMethodBeat.o(218562);
    }

    public PlayerItem getCurrentItem() {
        return this.currentItem;
    }

    public void replaceCurrentItemWithPlayerItem(PlayerItem playerItem) {
        AppMethodBeat.i(218563);
        update(playerItem, position());
        AppMethodBeat.o(218563);
    }

    public void seekToTime(CMTime cMTime) {
        AppMethodBeat.i(218564);
        seekToTime(cMTime, null);
        AppMethodBeat.o(218564);
    }

    public void seekToTime(CMTime cMTime, CMTime cMTime2, CMTime cMTime3) {
        AppMethodBeat.i(218565);
        seekToTime(cMTime, cMTime2, cMTime3, null);
        AppMethodBeat.o(218565);
    }

    @Override // com.tencent.tav.player.IPlayer
    public void seekToTime(CMTime cMTime, Callback callback) {
        AppMethodBeat.i(218566);
        CMTime cMTime2 = CMTime.CMTimeZero;
        seekToTime(cMTime, cMTime2, cMTime2, callback);
        AppMethodBeat.o(218566);
    }

    public void seekToTime(CMTime cMTime, CMTime cMTime2, CMTime cMTime3, Callback callback) {
        AppMethodBeat.i(218567);
        if (this.released) {
            AppMethodBeat.o(218567);
            return;
        }
        this.mSeekTargetTimeUs = cMTime;
        this.mLastSeekTargetTimeUs = this.mSeekTargetTimeUs;
        this.mPlayThread.updatePositionRightAway(this.mSeekTargetTimeUs);
        this.mPlayThread.enableScheduleNext(true);
        this.mPlayThread.cancelAllPendingSeeks();
        this.mPlayThread.sendMessage(5, this.mSeekTargetTimeUs, "main", callback);
        AppMethodBeat.o(218567);
    }

    public void refreshSurface(Callback callback) {
        AppMethodBeat.i(218568);
        if (this.released) {
            AppMethodBeat.o(218568);
            return;
        }
        this.mPlayThread.sendMessage(26, callback, "main");
        AppMethodBeat.o(218568);
    }

    public void setRateAtTimeAndHostTime(float f2, CMTime cMTime, CMTime cMTime2) {
    }

    public void enAbleAudioFocus(Context context, boolean z) {
        AppMethodBeat.i(218569);
        if (z) {
            if (this.mAudioFocuser == null) {
                this.mAudioFocuser = new AudioFocusHelper(context, this);
                AppMethodBeat.o(218569);
                return;
            }
        } else if (this.mAudioFocuser != null) {
            this.mAudioFocuser.release();
        }
        AppMethodBeat.o(218569);
    }

    @Override // com.tencent.tav.player.IPlayer
    public int videoWidth() {
        AppMethodBeat.i(218570);
        if (this.currentItem == null) {
            AppMethodBeat.o(218570);
            return 0;
        }
        int i2 = (int) this.currentItem.getPresentationSize().width;
        AppMethodBeat.o(218570);
        return i2;
    }

    @Override // com.tencent.tav.player.IPlayer
    public int videoHeight() {
        AppMethodBeat.i(218571);
        if (this.currentItem == null) {
            AppMethodBeat.o(218571);
            return 0;
        }
        int i2 = (int) this.currentItem.getPresentationSize().height;
        AppMethodBeat.o(218571);
        return i2;
    }

    @Override // com.tencent.tav.player.IPlayer
    public void setPlayerListener(IPlayer.PlayerListener playerListener) {
        this.mPlayerListener = playerListener;
    }

    @Override // com.tencent.tav.player.IPlayer
    public void setOnCompositionUpdateListener(OnCompositionUpdateListener onCompositionUpdateListener2) {
        this.onCompositionUpdateListener = onCompositionUpdateListener2;
    }

    /* access modifiers changed from: package-private */
    public void bindLayer(PlayerLayer playerLayer2) {
        AppMethodBeat.i(218572);
        this.playerLayer = playerLayer2;
        this.currentItem.bindLayer(playerLayer2);
        AppMethodBeat.o(218572);
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized IPlayer.PlayerStatus currentStatus() {
        return this.mPlayerStatus;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized CMTime duration() {
        CMTime duration;
        AppMethodBeat.i(218573);
        if (this.asset == null) {
            duration = CMTime.CMTimeZero;
            AppMethodBeat.o(218573);
        } else {
            duration = this.asset.getDuration();
            AppMethodBeat.o(218573);
        }
        return duration;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized CMTime position() {
        CMTime position;
        AppMethodBeat.i(218574);
        if (this.mPlayThread == null) {
            position = CMTime.CMTimeZero;
            AppMethodBeat.o(218574);
        } else {
            position = this.mPlayThread.getPosition();
            AppMethodBeat.o(218574);
        }
        return position;
    }

    public CGRect getGlViewport() {
        AppMethodBeat.i(218575);
        if (this.mPlayThread == null) {
            AppMethodBeat.o(218575);
            return null;
        }
        CGRect glViewportRect = this.mPlayThread.getGlViewportRect();
        AppMethodBeat.o(218575);
        return glViewportRect;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void update(PlayerItem playerItem, CMTime cMTime) {
        AppMethodBeat.i(218576);
        if (this.released) {
            AppMethodBeat.o(218576);
        } else {
            this.currentItem = playerItem;
            this.asset = playerItem.getAsset();
            this.currentItem.updateDecoderTrack();
            this.mMainHandler.removeMessages(2);
            this.mPlayThread.removePendingUpdateCompositionMessage();
            this.mPlayThread.updatePositionRightAway(cMTime);
            this.mPlayThread.removeReadSampleMessage();
            this.mPlayThread.enableScheduleNext(false);
            this.mPlayThread.sendMessage(11, new UpdateCompositionMessage(playerItem, this.onCompositionUpdateListener), "update clips");
            this.mLastSeekTargetTimeUs = CMTime.CMTimeZero;
            AppMethodBeat.o(218576);
        }
    }

    public synchronized void update(PlayerItem playerItem, CMTime cMTime, final OnCompositionUpdateListener onCompositionUpdateListener2) {
        AppMethodBeat.i(218577);
        if (this.released) {
            AppMethodBeat.o(218577);
        } else {
            this.currentItem = playerItem;
            this.asset = playerItem.getAsset();
            this.currentItem.updateDecoderTrack();
            this.mMainHandler.removeMessages(2);
            this.mPlayThread.removePendingUpdateCompositionMessage();
            this.mPlayThread.updatePositionRightAway(cMTime);
            this.mPlayThread.removeReadSampleMessage();
            this.mPlayThread.enableScheduleNext(false);
            this.mPlayThread.sendMessage(11, new UpdateCompositionMessage(playerItem, new OnCompositionUpdateListener() {
                /* class com.tencent.tav.player.Player.AnonymousClass1 */

                @Override // com.tencent.tav.player.OnCompositionUpdateListener
                public void onUpdated(Player player, boolean z) {
                    AppMethodBeat.i(218549);
                    if (onCompositionUpdateListener2 != null) {
                        onCompositionUpdateListener2.onUpdated(player, z);
                    }
                    if (Player.this.onCompositionUpdateListener != null) {
                        Player.this.onCompositionUpdateListener.onUpdated(player, z);
                    }
                    AppMethodBeat.o(218549);
                }
            }), "update clips");
            this.mLastSeekTargetTimeUs = CMTime.CMTimeZero;
            AppMethodBeat.o(218577);
        }
    }

    public void readSnapShootBitmap(OnReadSnapShootListener onReadSnapShootListener) {
        AppMethodBeat.i(218578);
        if (this.mPlayThread == null) {
            AppMethodBeat.o(218578);
            return;
        }
        this.mPlayThread.sendMessage(24, onReadSnapShootListener, "readSnapShootBitmap");
        AppMethodBeat.o(218578);
    }

    public void setViewportUpdateListener(OnViewportUpdateListener onViewportUpdateListener) {
        this.viewportUpdateListener = onViewportUpdateListener;
    }

    public void setGetTavExtraListener(OnGetTavExtraListener onGetTavExtraListener) {
        AppMethodBeat.i(218579);
        if (this.mPlayThread != null) {
            this.mPlayThread.sendMessage(25, onGetTavExtraListener, "setGetTavExtraListener");
        }
        AppMethodBeat.o(218579);
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized boolean isPlaying() {
        return this.mPlayerStatus == IPlayer.PlayerStatus.PLAYING;
    }

    public void prepare(PlayerPrepareListener playerPrepareListener) {
        IPlayer.PlayerStatus playerStatus = IPlayer.PlayerStatus.IDLE;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void play() {
        AppMethodBeat.i(218580);
        if (this.released) {
            AppMethodBeat.o(218580);
        } else {
            if (this.mPlayRange != null && !this.mPlayRange.containsTime(currentTime())) {
                seekToTime(this.mPlayRange.getStart());
            }
            this.mPlayThread.sendMessage(2, "main");
            if (this.mAudioFocuser != null) {
                this.mAudioFocuser.requestFocus();
            }
            AppMethodBeat.o(218580);
        }
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void setPlayRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218581);
        this.mPlayRange = cMTimeRange;
        if (cMTimeRange != null && !cMTimeRange.containsTime(currentTime()) && isPlaying()) {
            seekToTime(cMTimeRange.getStart());
        }
        this.mPlayThread.setPlayRange(cMTimeRange);
        AppMethodBeat.o(218581);
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void pause() {
        AppMethodBeat.i(218582);
        if (this.released) {
            AppMethodBeat.o(218582);
        } else {
            this.mPlayThread.removeReadSampleMessage();
            this.mPlayThread.enableScheduleNext(false);
            this.mPlayThread.sendMessage(3, "main");
            AppMethodBeat.o(218582);
        }
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void stop() {
        AppMethodBeat.i(218583);
        if (this.released) {
            AppMethodBeat.o(218583);
        } else {
            this.mPlayThread.sendMessage(4, Boolean.TRUE, "main");
            AppMethodBeat.o(218583);
        }
    }

    public synchronized void updateProperties() {
        AppMethodBeat.i(218584);
        if (this.released) {
            AppMethodBeat.o(218584);
        } else {
            this.mPlayThread.sendMessage(10, "main");
            AppMethodBeat.o(218584);
        }
    }

    public synchronized void updateAllProperties() {
        AppMethodBeat.i(218585);
        if (this.released) {
            AppMethodBeat.o(218585);
        } else {
            this.mPlayThread.sendMessage(20, "main");
            AppMethodBeat.o(218585);
        }
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void updateAudioClipsProperties() {
        AppMethodBeat.i(218586);
        if (this.released) {
            AppMethodBeat.o(218586);
        } else {
            this.mPlayThread.sendMessage(22, "main");
            AppMethodBeat.o(218586);
        }
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void updateAudioVolumeProperties() {
        AppMethodBeat.i(218587);
        if (this.released) {
            AppMethodBeat.o(218587);
        } else {
            this.mPlayThread.sendMessage(23, "main");
            AppMethodBeat.o(218587);
        }
    }

    public void updateViewport(int i2, int i3) {
        AppMethodBeat.i(218588);
        if (this.released) {
            AppMethodBeat.o(218588);
            return;
        }
        this.mPlayThread.sendMessage(21, new CGSize((float) i2, (float) i3), "main");
        AppMethodBeat.o(218588);
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void setVolume(float f2) {
        AppMethodBeat.i(218589);
        if (this.released) {
            AppMethodBeat.o(218589);
        } else {
            this.mPlayThread.sendMessage(7, Float.valueOf(f2), "main");
            AppMethodBeat.o(218589);
        }
    }

    private synchronized void checkAndReady() {
        AppMethodBeat.i(218590);
        if (this.mPlayerStatus == IPlayer.PlayerStatus.IDLE) {
            this.mPlayThread.sendMessage(1, "main");
        }
        AppMethodBeat.o(218590);
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void setLoop(boolean z) {
        this.loop = z;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void waitForRelease(long j2) {
    }

    public boolean handleMessage(Message message) {
        AppMethodBeat.i(218591);
        if (this.released) {
            AppMethodBeat.o(218591);
            return false;
        }
        switch (message.what) {
            case 1:
                IPlayer.PlayerStatus playerStatus = this.mPlayerStatus;
                PlayerStatusMsg playerStatusMsg = (PlayerStatusMsg) message.obj;
                this.mPlayerStatus = playerStatusMsg.getPlayerStatus();
                if (playerStatus != IPlayer.PlayerStatus.PLAYING || (!(this.mPlayerStatus == IPlayer.PlayerStatus.FINISHED || this.mPlayerStatus == IPlayer.PlayerStatus.ERROR) || !this.loop)) {
                    if (this.mPlayerListener != null) {
                        this.mPlayerListener.onStatusChanged(this.mPlayerStatus);
                    }
                    if (this.mPlayerStatus == IPlayer.PlayerStatus.ERROR) {
                        this.errMsg = new ErrorMsg(-1, playerStatusMsg.getErrorMsg());
                        break;
                    }
                } else {
                    synchronized (this) {
                        try {
                            if (!this.mPlayThread.hasMessage(3) && !this.mPlayThread.hasMessage(6) && !this.mPlayThread.hasMessage(4) && !this.mPlayThread.hasMessage(11) && !this.mMainHandler.hasMessages(1)) {
                                if (this.mPlayRange == null || this.mPlayRange.getDuration().getValue() <= 0) {
                                    seekToTime(CMTime.CMTimeZero);
                                } else {
                                    seekToTime(this.mPlayRange.getStart());
                                }
                                if (this.mPlayerListener != null) {
                                    this.mPlayerListener.onStatusChanged(IPlayer.PlayerStatus.REPLAY);
                                }
                                play();
                                break;
                            } else {
                                break;
                            }
                        } finally {
                            AppMethodBeat.o(218591);
                        }
                    }
                }
                break;
            case 2:
                this.mPosition = (CMTime) message.obj;
                if (this.mPlayerListener != null && !this.mMainHandler.hasMessages(2)) {
                    this.mPlayerListener.onPositionChanged(this.mPosition);
                }
                if (this.mPlayRange != null && !this.mPosition.smallThan(this.mPlayRange.getEnd()) && isPlaying()) {
                    if (!this.loop) {
                        pause();
                        break;
                    } else {
                        if (this.mPlayerListener != null) {
                            this.mPlayerListener.onStatusChanged(IPlayer.PlayerStatus.REPLAY);
                        }
                        seekToTime(this.mPlayRange.getStart());
                        break;
                    }
                }
            case 3:
                if (this.viewportUpdateListener != null && (message.obj instanceof CGRect)) {
                    this.viewportUpdateListener.onViewportUpdate(((CGRect) message.obj).clone());
                    break;
                }
            default:
                AppMethodBeat.o(218591);
                return false;
        }
        return true;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void release() {
        AppMethodBeat.i(218592);
        release(null);
        AppMethodBeat.o(218592);
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void release(Runnable runnable) {
        AppMethodBeat.i(218593);
        if (!this.released) {
            this.released = true;
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
            this.mPlayThread.sendMessage(4, "main");
            this.mPlayThread.sendMessage(6, runnable, "main");
            this.mPlayThread = null;
            if (this.mAudioFocuser != null) {
                this.mAudioFocuser.release();
            }
            if (this.currentItem != null) {
                this.currentItem.release();
            }
            this.currentItem = null;
        }
        AppMethodBeat.o(218593);
    }

    public synchronized boolean isReleased() {
        return this.released;
    }
}
