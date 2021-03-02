package com.tencent.tavkit.component;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.IPlayer;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;

public class TAVPlayer {
    public static final int VIDEO_PLAYER_HEIGHT = 960;
    public static final int VIDEO_PLAYER_WIDTH = 540;
    private final String TAG = ("GameTemplatePlayer@" + Integer.toHexString(hashCode()));
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        /* class com.tencent.tavkit.component.TAVPlayer.AnonymousClass4 */

        public void onAudioFocusChange(int i2) {
            AppMethodBeat.i(197372);
            switch (i2) {
                case -2:
                case -1:
                    if (!TAVPlayer.this.isAllowInterrupt) {
                        AppMethodBeat.o(197372);
                        return;
                    } else if (TAVPlayer.this.player != null) {
                        TAVPlayer.this.player.pause();
                        AppMethodBeat.o(197372);
                        return;
                    }
                    break;
                case 1:
                    if (TAVPlayer.this.player != null) {
                        TAVPlayer.this.player.play();
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(197372);
        }
    };
    private AudioManager audioManager;
    private boolean audioTracksMerge = true;
    private int bgColor = WebView.NIGHT_MODE_COLOR;
    private OnCompositionUpdateListener compositionUpdateListener;
    private Context context;
    private boolean isAllowInterrupt = true;
    private boolean isAutoPlay = true;
    private boolean isResetting = false;
    private boolean loopPlay = false;
    private FrameLayout mPlayerLayout;
    private CMTimeRange playRange;
    private Player player;
    private IPlayer.PlayerListener playerListener;
    private CMTime position = CMTime.CMTimeZero;
    private PostUpdateThread postUpdateThread;
    private float rate = 1.0f;
    private Surface surface;
    private int surfaceHeight;
    private int surfaceWidth;
    private TAVComposition tavComposition;
    private boolean videoTracksMerge = true;
    private float volume = 1.0f;

    public interface ICompositionBuilder extends OnCompositionUpdateListener {
        TAVComposition buildComposition();
    }

    public interface PlayerListener {
        void onPositionChanged(CMTime cMTime, CMTime cMTime2);

        void onStatusChanged(IPlayer.PlayerStatus playerStatus, Player player);
    }

    public TAVPlayer() {
        AppMethodBeat.i(197385);
        AppMethodBeat.o(197385);
    }

    public TAVPlayer(Surface surface2, int i2, int i3) {
        AppMethodBeat.i(197386);
        onSurfaceCreate(surface2, i3, i2);
        AppMethodBeat.o(197386);
    }

    public TAVPlayer(FrameLayout frameLayout) {
        AppMethodBeat.i(197387);
        this.context = frameLayout.getContext();
        this.mPlayerLayout = frameLayout;
        initContentView();
        AppMethodBeat.o(197387);
    }

    private void initContentView() {
        AppMethodBeat.i(197388);
        if (this.mPlayerLayout == null) {
            AppMethodBeat.o(197388);
            return;
        }
        this.mPlayerLayout.removeAllViews();
        TextureView textureView = new TextureView(this.context);
        textureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mPlayerLayout.addView(textureView);
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            /* class com.tencent.tavkit.component.TAVPlayer.AnonymousClass1 */
            private final String TAG = ("GameTextureView@" + Integer.toHexString(hashCode()));

            {
                AppMethodBeat.i(197365);
                AppMethodBeat.o(197365);
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(197366);
                TAVPlayer.this.onSurfaceCreate(new Surface(surfaceTexture), i3, i2);
                AppMethodBeat.o(197366);
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(197367);
                TAVPlayer.this.onSurfaceSizeChanged(i2, i3);
                AppMethodBeat.o(197367);
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(197368);
                TAVPlayer.this.onSurfaceDestory();
                AppMethodBeat.o(197368);
                return false;
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        AppMethodBeat.o(197388);
    }

    public void onSurfaceCreate(Surface surface2, int i2, int i3) {
        AppMethodBeat.i(197389);
        this.surfaceWidth = i3;
        this.surfaceHeight = i2;
        this.surface = surface2;
        updateComposition(this.tavComposition, this.position, this.isAutoPlay, this.compositionUpdateListener);
        AppMethodBeat.o(197389);
    }

    public void onSurfaceSizeChanged(int i2, int i3) {
        AppMethodBeat.i(197390);
        if (this.player != null) {
            this.player.updateViewport(i2, i3);
        }
        AppMethodBeat.o(197390);
    }

    public void onSurfaceDestory() {
        AppMethodBeat.i(197391);
        if (this.player != null && !this.player.isReleased()) {
            this.position = this.player.position();
            this.player.release();
        }
        this.surface = null;
        AppMethodBeat.o(197391);
    }

    public void setPlayerListener(final PlayerListener playerListener2) {
        AppMethodBeat.i(197392);
        Logger.d(this.TAG, "setPlayerListener() called with: playerListener = [" + playerListener2 + "],player = " + this.player);
        setPlayerListener(new IPlayer.PlayerListener() {
            /* class com.tencent.tavkit.component.TAVPlayer.AnonymousClass2 */

            @Override // com.tencent.tav.player.IPlayer.PlayerListener
            public void onPositionChanged(CMTime cMTime) {
                AppMethodBeat.i(197369);
                if (!(playerListener2 == null || TAVPlayer.this.player == null)) {
                    playerListener2.onPositionChanged(cMTime, TAVPlayer.this.player.duration());
                }
                AppMethodBeat.o(197369);
            }

            @Override // com.tencent.tav.player.IPlayer.PlayerListener
            public void onStatusChanged(IPlayer.PlayerStatus playerStatus) {
                AppMethodBeat.i(197370);
                if (!(playerListener2 == null || TAVPlayer.this.player == null)) {
                    playerListener2.onStatusChanged(playerStatus, TAVPlayer.this.player);
                }
                AppMethodBeat.o(197370);
            }
        });
        AppMethodBeat.o(197392);
    }

    private void setPlayerListener(IPlayer.PlayerListener playerListener2) {
        AppMethodBeat.i(197393);
        Logger.d(this.TAG, "setPlayerListener() called with: playerListener = [" + playerListener2 + "],player = " + this.player);
        this.playerListener = playerListener2;
        if (this.player != null) {
            this.player.setPlayerListener(playerListener2);
        }
        AppMethodBeat.o(197393);
    }

    public synchronized void setLoopPlay(boolean z) {
        AppMethodBeat.i(197394);
        Logger.d(this.TAG, "setLoopPlay() called with: loopPlay = [" + z + "],player = " + this.player);
        this.loopPlay = z;
        if (this.player != null) {
            this.player.setLoop(z);
        }
        AppMethodBeat.o(197394);
    }

    public synchronized void setRate(float f2) {
        AppMethodBeat.i(197395);
        Logger.d(this.TAG, "setLoopPlay() called with: loopPlay = [" + this.loopPlay + "],player = " + this.player);
        this.rate = f2;
        if (this.player != null) {
            this.player.setRate(f2);
        }
        AppMethodBeat.o(197395);
    }

    public void setBgColor(int i2) {
        AppMethodBeat.i(197396);
        this.bgColor = i2;
        if (this.player != null) {
            this.player.setBgColor(i2);
        }
        AppMethodBeat.o(197396);
    }

    public synchronized void setPlayRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(197397);
        Logger.d(this.TAG, "setPlayRange() called with: playRange = [" + cMTimeRange + "],player = " + this.player);
        this.playRange = cMTimeRange;
        if (this.player != null) {
            this.player.setPlayRange(cMTimeRange);
        }
        AppMethodBeat.o(197397);
    }

    public synchronized void setVolume(float f2) {
        AppMethodBeat.i(197398);
        Logger.d(this.TAG, "setVolume() called with: volume = [" + f2 + "],player = " + this.player);
        this.volume = f2;
        if (this.player != null) {
            this.player.setVolume(f2);
        }
        AppMethodBeat.o(197398);
    }

    public synchronized float getVolume() {
        return this.volume;
    }

    public void seekToTime(CMTime cMTime) {
        AppMethodBeat.i(197399);
        Logger.d(this.TAG, "seekToTime() called with: cmTime = [" + cMTime + "],player = " + this.player);
        if (this.player != null) {
            this.player.seekToTime(cMTime);
        }
        AppMethodBeat.o(197399);
    }

    public void setVideoTracksMerge(boolean z) {
        this.videoTracksMerge = z;
    }

    public void setAudioTracksMerge(boolean z) {
        this.audioTracksMerge = z;
    }

    public synchronized boolean isPlaying() {
        boolean z;
        AppMethodBeat.i(197400);
        if (this.player != null) {
            z = this.player.isPlaying();
            AppMethodBeat.o(197400);
        } else {
            z = false;
            AppMethodBeat.o(197400);
        }
        return z;
    }

    public synchronized void pause() {
        AppMethodBeat.i(197401);
        Logger.d(this.TAG, "pause: player = " + this.player);
        if (this.player != null) {
            abandonAudioFocus();
            this.player.pause();
            AppMethodBeat.o(197401);
        } else {
            this.isAutoPlay = false;
            AppMethodBeat.o(197401);
        }
    }

    public synchronized void play() {
        AppMethodBeat.i(197402);
        Logger.d(this.TAG, "play: player = " + this.player);
        if (this.player != null) {
            if (requestAudioFocus()) {
                this.player.play();
                AppMethodBeat.o(197402);
            }
            AppMethodBeat.o(197402);
        } else {
            this.isAutoPlay = true;
            AppMethodBeat.o(197402);
        }
    }

    public boolean isResetting() {
        return this.isResetting;
    }

    public synchronized CMTime getPosition() {
        CMTime cMTime;
        AppMethodBeat.i(197403);
        if (this.player != null) {
            cMTime = this.player.position();
            AppMethodBeat.o(197403);
        } else {
            cMTime = CMTime.CMTimeInvalid;
            AppMethodBeat.o(197403);
        }
        return cMTime;
    }

    public synchronized CMTime getDuration() {
        CMTime cMTime;
        AppMethodBeat.i(197404);
        if (this.player != null) {
            cMTime = this.player.duration();
            AppMethodBeat.o(197404);
        } else {
            cMTime = CMTime.CMTimeZero;
            AppMethodBeat.o(197404);
        }
        return cMTime;
    }

    public synchronized IPlayer.PlayerStatus getCurrentStatus() {
        IPlayer.PlayerStatus currentStatus;
        AppMethodBeat.i(197405);
        if (this.player == null) {
            currentStatus = IPlayer.PlayerStatus.ERROR;
            AppMethodBeat.o(197405);
        } else {
            currentStatus = this.player.currentStatus();
            AppMethodBeat.o(197405);
        }
        return currentStatus;
    }

    public synchronized void reset() {
        AppMethodBeat.i(197406);
        this.isResetting = true;
        initContentView();
        AppMethodBeat.o(197406);
    }

    public synchronized void release() {
        AppMethodBeat.i(197407);
        Logger.d(this.TAG, "release: player = " + this.player);
        if (this.player != null) {
            this.position = this.player.position();
            abandonAudioFocus();
            this.player.release();
            this.player = null;
        }
        if (this.postUpdateThread != null) {
            this.postUpdateThread.quit();
            this.postUpdateThread = null;
        }
        this.isResetting = false;
        AppMethodBeat.o(197407);
    }

    public synchronized void setAutoPlay(boolean z) {
        this.isAutoPlay = z;
    }

    public void updateComposition(TAVComposition tAVComposition, boolean z) {
        AppMethodBeat.i(197408);
        updateComposition(tAVComposition, CMTime.CMTimeZero, z);
        AppMethodBeat.o(197408);
    }

    public void updateComposition(TAVComposition tAVComposition, CMTime cMTime, boolean z) {
        AppMethodBeat.i(197409);
        updateComposition(tAVComposition, cMTime, z, null);
        AppMethodBeat.o(197409);
    }

    public void updateComposition(TAVComposition tAVComposition, final CMTime cMTime, final boolean z, OnCompositionUpdateListener onCompositionUpdateListener) {
        AppMethodBeat.i(197410);
        Logger.d(this.TAG, "updateComposition() called with: tavComposition = [" + tAVComposition + "], position = [" + cMTime + "], autoPlay = [" + z + "]");
        this.tavComposition = tAVComposition;
        this.position = cMTime;
        this.compositionUpdateListener = onCompositionUpdateListener;
        if (tAVComposition == null) {
            this.isResetting = false;
            AppMethodBeat.o(197410);
        } else if (this.surface == null) {
            this.isAutoPlay = z;
            this.isResetting = false;
            AppMethodBeat.o(197410);
        } else {
            PlayerItem buildPlayerItem = buildPlayerItem(tAVComposition);
            if (this.player == null || this.player.isReleased()) {
                this.player = newPlayer(buildPlayerItem, cMTime, z);
                AppMethodBeat.o(197410);
                return;
            }
            Player player2 = this.player;
            if (onCompositionUpdateListener == null) {
                onCompositionUpdateListener = new OnCompositionUpdateListener() {
                    /* class com.tencent.tavkit.component.TAVPlayer.AnonymousClass3 */

                    @Override // com.tencent.tav.player.OnCompositionUpdateListener
                    public void onUpdated(Player player, boolean z) {
                        AppMethodBeat.i(197371);
                        TAVPlayer.this.seekToTime(cMTime);
                        if (z && z) {
                            TAVPlayer.this.play();
                        }
                        TAVPlayer.this.isResetting = false;
                        AppMethodBeat.o(197371);
                    }
                };
            }
            player2.update(buildPlayerItem, cMTime, onCompositionUpdateListener);
            this.compositionUpdateListener = null;
            AppMethodBeat.o(197410);
        }
    }

    private PlayerItem buildPlayerItem(TAVComposition tAVComposition) {
        AppMethodBeat.i(197411);
        Logger.d(this.TAG, "buildPlayerItem() called with: tavComposition = [" + tAVComposition + "]");
        TAVCompositionBuilder tAVCompositionBuilder = new TAVCompositionBuilder(tAVComposition);
        tAVCompositionBuilder.setVideoTracksMerge(this.videoTracksMerge);
        tAVCompositionBuilder.setAudioTracksMerge(this.audioTracksMerge);
        TAVSource buildSource = tAVCompositionBuilder.buildSource();
        PlayerItem playerItem = new PlayerItem(buildSource.getAsset());
        playerItem.setVideoComposition(buildSource.getVideoComposition());
        playerItem.setAudioMix(buildSource.getAudioMix());
        AppMethodBeat.o(197411);
        return playerItem;
    }

    private Player newPlayer(PlayerItem playerItem, CMTime cMTime, boolean z) {
        AppMethodBeat.i(197412);
        Logger.d(this.TAG, "newPlayer() called with: playerItem = [" + playerItem + "], position = [" + cMTime + "], autoPlay = [" + z + "]");
        Player player2 = new Player(playerItem);
        player2.setPlayerListener(this.playerListener);
        player2.setLoop(this.loopPlay);
        player2.setRate(this.rate);
        player2.setBgColor(this.bgColor);
        player2.setPlayRange(this.playRange);
        player2.setVolume(this.volume);
        player2.seekToTime(cMTime);
        new PlayerLayer(this.surface, this.surfaceWidth, this.surfaceHeight).setPlayer(player2);
        if (z && requestAudioFocus()) {
            player2.play();
        }
        if (this.compositionUpdateListener != null) {
            this.compositionUpdateListener.onUpdated(player2, false);
        }
        this.isResetting = false;
        AppMethodBeat.o(197412);
        return player2;
    }

    private boolean requestAudioFocus() {
        AppMethodBeat.i(197413);
        if (this.context == null) {
            AppMethodBeat.o(197413);
            return true;
        }
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 1) == 1) {
            AppMethodBeat.o(197413);
            return true;
        }
        AppMethodBeat.o(197413);
        return false;
    }

    private void abandonAudioFocus() {
        AppMethodBeat.i(197414);
        if (this.audioManager == null) {
            AppMethodBeat.o(197414);
            return;
        }
        this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
        AppMethodBeat.o(197414);
    }

    public void setAllowInterrupt(boolean z) {
        this.isAllowInterrupt = z;
    }

    public synchronized void postUpdate(final TAVComposition tAVComposition, boolean z) {
        AppMethodBeat.i(197415);
        postUpdate(new ICompositionBuilder() {
            /* class com.tencent.tavkit.component.TAVPlayer.AnonymousClass5 */

            @Override // com.tencent.tavkit.component.TAVPlayer.ICompositionBuilder
            public TAVComposition buildComposition() {
                return tAVComposition;
            }

            @Override // com.tencent.tav.player.OnCompositionUpdateListener
            public void onUpdated(Player player, boolean z) {
            }
        }, z);
        AppMethodBeat.o(197415);
    }

    public synchronized void postUpdate(ICompositionBuilder iCompositionBuilder, boolean z) {
        AppMethodBeat.i(197416);
        if (this.postUpdateThread == null) {
            this.postUpdateThread = new PostUpdateThread("PostUpdateThread");
            this.postUpdateThread.start();
        }
        PostUpdateThread.access$400(this.postUpdateThread, iCompositionBuilder, z);
        AppMethodBeat.o(197416);
    }

    /* access modifiers changed from: package-private */
    public class PostUpdateThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_UNLOCK = 95;
        private static final int MSG_UPDATE = 223;
        private boolean autoPlay;
        private Handler handler;
        private volatile boolean msgLock;
        private ICompositionBuilder templateSource;

        static /* synthetic */ void access$400(PostUpdateThread postUpdateThread, ICompositionBuilder iCompositionBuilder, boolean z) {
            AppMethodBeat.i(197383);
            postUpdateThread.update(iCompositionBuilder, z);
            AppMethodBeat.o(197383);
        }

        static /* synthetic */ void access$600(PostUpdateThread postUpdateThread, int i2) {
            AppMethodBeat.i(197384);
            postUpdateThread.unlockMsg(i2);
            AppMethodBeat.o(197384);
        }

        private PostUpdateThread(String str) {
            super(str);
            this.msgLock = false;
        }

        /* access modifiers changed from: protected */
        public void onLooperPrepared() {
            AppMethodBeat.i(197374);
            super.onLooperPrepared();
            AppMethodBeat.o(197374);
        }

        public synchronized void start() {
            AppMethodBeat.i(197375);
            super.start();
            this.handler = new Handler(getLooper(), this);
            AppMethodBeat.o(197375);
        }

        private synchronized void update(ICompositionBuilder iCompositionBuilder, boolean z) {
            AppMethodBeat.i(197376);
            Logger.d(TAVPlayer.this.TAG, "update() called with: thread = " + Thread.currentThread().getName() + ", templateSource = [" + iCompositionBuilder + "], autoPlay = [" + z + "]");
            this.templateSource = iCompositionBuilder;
            this.autoPlay = z;
            this.handler.removeMessages(223);
            this.handler.sendEmptyMessage(223);
            AppMethodBeat.o(197376);
        }

        private synchronized void unlockMsg(int i2) {
            AppMethodBeat.i(197377);
            Logger.d(TAVPlayer.this.TAG, "unlockMsg() called thread = " + Thread.currentThread().getName());
            this.handler.removeMessages(95);
            this.handler.sendEmptyMessageDelayed(95, (long) i2);
            AppMethodBeat.o(197377);
        }

        public boolean handleMessage(Message message) {
            AppMethodBeat.i(197378);
            Logger.d(TAVPlayer.this.TAG, "handleMessage() called with: msg = [" + message + "] msgLock = " + this.msgLock + ",templateSource = " + this.templateSource);
            switch (message.what) {
                case 95:
                    doUnlockMsg();
                    break;
                case 223:
                    doUpdateMsg();
                    break;
            }
            AppMethodBeat.o(197378);
            return true;
        }

        private void doUpdateMsg() {
            AppMethodBeat.i(197379);
            if (!this.msgLock && this.templateSource != null) {
                String unused = TAVPlayer.this.TAG;
                this.msgLock = true;
                doUpdateComposition(this.templateSource, this.autoPlay);
                this.templateSource = null;
                this.autoPlay = false;
            }
            AppMethodBeat.o(197379);
        }

        private void doUnlockMsg() {
            AppMethodBeat.i(197380);
            if (this.msgLock) {
                this.msgLock = false;
                if (this.templateSource != null) {
                    update(this.templateSource, this.autoPlay);
                }
            }
            AppMethodBeat.o(197380);
        }

        private void doUpdateComposition(final ICompositionBuilder iCompositionBuilder, boolean z) {
            AppMethodBeat.i(197381);
            unlockMsg(1000);
            TAVPlayer.this.updateComposition(iCompositionBuilder.buildComposition(), CMTime.CMTimeZero, z, new OnCompositionUpdateListener() {
                /* class com.tencent.tavkit.component.TAVPlayer.PostUpdateThread.AnonymousClass1 */

                @Override // com.tencent.tav.player.OnCompositionUpdateListener
                public void onUpdated(Player player, boolean z) {
                    AppMethodBeat.i(197373);
                    iCompositionBuilder.onUpdated(player, z);
                    PostUpdateThread.access$600(PostUpdateThread.this, 0);
                    AppMethodBeat.o(197373);
                }
            });
            AppMethodBeat.o(197381);
        }

        public void release() {
            AppMethodBeat.i(197382);
            this.templateSource = null;
            if (this.handler != null) {
                this.handler.removeCallbacksAndMessages(null);
                this.handler = null;
            }
            quit();
            AppMethodBeat.o(197382);
        }
    }
}
