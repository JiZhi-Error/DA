package com.tencent.tav.player;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.MessageQueue;
import android.support.v4.e.o;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tav.Utils;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.core.CGMathFunctions;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.IPlayer;
import com.tencent.tav.report.PreviewReportSession;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayerThread implements Handler.Callback {
    static final int ACTION_FINISH = -1;
    static final int ACTION_GET_TAV_EXTRA_INFO = 25;
    static final int ACTION_PAUSE = 3;
    static final int ACTION_PLAY = 2;
    static final int ACTION_PREPARE = 1;
    static final int ACTION_QUIT = 850;
    static final int ACTION_READ_SAMPLE = 12;
    static final int ACTION_READ_SNAP_SHOOT_BITMAP = 24;
    static final int ACTION_REFRESH_SURFACE = 26;
    static final int ACTION_RELEASE = 6;
    static final int ACTION_SEEK = 5;
    static final int ACTION_SEEK_PRE_SAMPLE = 9;
    static final int ACTION_SET_VOLUME = 7;
    static final int ACTION_STOP = 4;
    static final int ACTION_UPDATE_ALLPROPERTIES = 20;
    static final int ACTION_UPDATE_AUDIOCLIP_PROPERTIES = 22;
    static final int ACTION_UPDATE_AUDIOVOLUME_PROPERTIES = 23;
    static final int ACTION_UPDATE_COMPOSITION = 11;
    static final int ACTION_UPDATE_PROPERTIES = 10;
    static final int ACTION_UPDATE_SIZE = 21;
    static final int STATUS_FINISH = 3;
    static final int STATUS_INIT_CODEC = 2;
    static final int STATUS_NONE = 1;
    public static final String TAG = "PlayerThreadMain";
    private static final long UNIT_TIME = 1000;
    public static o<String> map;
    private AudioCompositionDecoderTrack aDecoderTrack;
    private long decoderConsumerTimeUs = 0;
    private Filter filter;
    private CMTime frameDuration = new CMTime(1, 30);
    private CGRect glViewportRect;
    private volatile long lastSyncMessageId = 0;
    private VideoComposition.RenderLayoutMode layoutMode;
    private PlayerThreadAudio mAudioThread;
    private Surface mDisplayTarget;
    private volatile boolean mEnableScheduleNext = false;
    private boolean mLooper;
    private Handler mMainHandler;
    private boolean mPause;
    private Handler mPlayHandler;
    private CMTimeRange mPlayRange;
    private Player mPlayer;
    private PlayerItem mPlayerItem;
    private CMTime mPosition = CMTime.CMTimeZero;
    private long mStartTime;
    private int mStatus = 1;
    private HandlerThread mThread;
    private OnGetTavExtraListener onGetTavExtraListener;
    private OnReadSnapShootListener onReadSnapShootListener;
    private float rate = 1.0f;
    private RenderContext renderContext;
    private RenderContextParams renderContextParams;
    private CGSize renderSize;
    private PreviewReportSession reportSession;
    private long startTimeUsMark = getCurrentUsTime();
    private CGSize surfaceSize;
    private IDecoderTrack vDecoderTrack;

    static /* synthetic */ void access$100(PlayerThread playerThread, int i2, Object obj) {
        AppMethodBeat.i(218673);
        playerThread.syncAudioOtherMsg(i2, obj);
        AppMethodBeat.o(218673);
    }

    static {
        AppMethodBeat.i(218674);
        o<String> oVar = new o<>(10);
        map = oVar;
        oVar.put(1, "初始化");
        map.put(2, "播放");
        map.put(3, "暂停");
        map.put(4, "停止");
        map.put(5, "拖动");
        map.put(12, "读取下一帧");
        map.put(6, "结束线程");
        map.put(26, "刷新渲染");
        AppMethodBeat.o(218674);
    }

    PlayerThread(IDecoderTrack iDecoderTrack, AudioCompositionDecoderTrack audioCompositionDecoderTrack, CGSize cGSize, Surface surface, Handler handler, Player player) {
        AppMethodBeat.i(218624);
        this.vDecoderTrack = iDecoderTrack;
        this.aDecoderTrack = audioCompositionDecoderTrack;
        this.mDisplayTarget = surface;
        this.mMainHandler = handler;
        this.renderSize = cGSize;
        if (iDecoderTrack != null) {
            this.frameDuration = iDecoderTrack.getFrameDuration();
        }
        this.mPlayer = player;
        this.mPlayerItem = player.getCurrentItem();
        initThread();
        AppMethodBeat.o(218624);
    }

    /* access modifiers changed from: package-private */
    public void setFrameDuration(CMTime cMTime) {
        this.frameDuration = cMTime;
    }

    public void setRate(float f2) {
        AppMethodBeat.i(218625);
        this.rate = f2;
        this.mAudioThread.setRate(f2);
        AppMethodBeat.o(218625);
    }

    /* access modifiers changed from: package-private */
    public RenderContextParams getRenderContextParams() {
        return this.renderContextParams;
    }

    /* access modifiers changed from: package-private */
    public void setRenderContextParams(RenderContextParams renderContextParams2) {
        AppMethodBeat.i(218626);
        this.renderContextParams = renderContextParams2;
        if (this.renderContext != null) {
            this.renderContext.setParams(renderContextParams2);
        }
        AppMethodBeat.o(218626);
    }

    public void updatePositionRightAway(CMTime cMTime) {
        this.mPosition = cMTime;
    }

    /* access modifiers changed from: package-private */
    public Handler getPlayHandler() {
        return this.mPlayHandler;
    }

    private void initThread() {
        AppMethodBeat.i(218627);
        this.mThread = new HandlerThread("PlayerVideoThread");
        this.mThread.start();
        this.mPlayHandler = new Handler(this.mThread.getLooper(), this);
        this.mAudioThread = new PlayerThreadAudio(this.aDecoderTrack, this.mMainHandler, getPlayHandler());
        AppMethodBeat.o(218627);
    }

    /* access modifiers changed from: package-private */
    public void bindSurface(IDecoderTrack iDecoderTrack, PlayerLayer playerLayer) {
        AppMethodBeat.i(218628);
        this.mDisplayTarget = playerLayer.surface;
        this.vDecoderTrack = iDecoderTrack;
        this.surfaceSize = new CGSize((float) playerLayer.surfaceWidth, (float) playerLayer.surfaceHeight);
        sendMessage(1, "bind surface");
        AppMethodBeat.o(218628);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initDecoderTrack(java.lang.Object r9) {
        /*
        // Method dump skipped, instructions count: 318
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.player.PlayerThread.initDecoderTrack(java.lang.Object):void");
    }

    private void initViewport() {
        AppMethodBeat.i(218630);
        CGSize cGSize = this.renderSize != null ? this.renderSize : this.surfaceSize;
        if (this.layoutMode == null) {
            this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, cGSize);
        } else {
            initViewportByLayoutMode(cGSize);
        }
        applyViewport();
        this.mMainHandler.obtainMessage(3, this.glViewportRect).sendToTarget();
        AppMethodBeat.o(218630);
    }

    private void initViewportByLayoutMode(CGSize cGSize) {
        AppMethodBeat.i(218631);
        switch (this.layoutMode) {
            case aspectFit:
                this.glViewportRect = CGMathFunctions.initGLViewportFit(this.surfaceSize, cGSize);
                AppMethodBeat.o(218631);
                return;
            case aspectFill:
                this.glViewportRect = CGMathFunctions.initGLViewportFill(this.surfaceSize, cGSize);
                AppMethodBeat.o(218631);
                return;
            default:
                this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, cGSize);
                AppMethodBeat.o(218631);
                return;
        }
    }

    private void onCompositionUpdate(Object obj, boolean z) {
        AppMethodBeat.i(218632);
        if (obj instanceof OnCompositionUpdateListener) {
            ((OnCompositionUpdateListener) obj).onUpdated(this.mPlayer, z);
        }
        AppMethodBeat.o(218632);
    }

    public void sendMessage(int i2, Object obj, String str, Callback callback) {
        AppMethodBeat.i(218633);
        Logger.d("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(i2) + "], obj = [" + obj + "], from = [" + str + "]");
        if (!(this.mPlayHandler == null || this.mThread == null)) {
            this.mPlayHandler.obtainMessage(i2, new PlayerMessage(obj, str, System.currentTimeMillis(), callback)).sendToTarget();
        }
        AppMethodBeat.o(218633);
    }

    public void sendMessage(int i2, Object obj, String str) {
        AppMethodBeat.i(218634);
        Logger.v("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(i2) + "], obj = [" + obj + "], from = [" + str + "]");
        if (!(this.mPlayHandler == null || this.mThread == null)) {
            this.mPlayHandler.obtainMessage(i2, new PlayerMessage(obj, str, System.currentTimeMillis())).sendToTarget();
        }
        AppMethodBeat.o(218634);
    }

    public void sendMessage(int i2, String str) {
        AppMethodBeat.i(218635);
        Logger.v("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(i2) + "], from = [" + str + "]");
        if (!(this.mPlayHandler == null || this.mThread == null)) {
            this.mPlayHandler.obtainMessage(i2, new PlayerMessage(null, str, System.currentTimeMillis())).sendToTarget();
        }
        AppMethodBeat.o(218635);
    }

    public void sendMessageDelay(int i2, long j2, String str) {
        AppMethodBeat.i(218636);
        Logger.v("PlayerThreadMain", "sendMessageDelay() called with: what = [" + catLog(i2) + "], delay = [" + j2 + "], from = [" + str + "]");
        if (this.mPlayHandler != null) {
            Message message = new Message();
            message.what = i2;
            message.obj = new PlayerMessage(null, str, System.currentTimeMillis());
            this.mPlayHandler.sendMessageDelayed(message, j2);
        }
        AppMethodBeat.o(218636);
    }

    public CMTime getPosition() {
        return this.mPosition;
    }

    public CGRect getGlViewportRect() {
        return this.glViewportRect;
    }

    public void setPlayRange(CMTimeRange cMTimeRange) {
        this.mPlayRange = cMTimeRange;
    }

    public boolean handleMessage(Message message) {
        PlayerMessage playerMessage;
        Callback callback;
        Object obj;
        String str = null;
        AppMethodBeat.i(218637);
        if (message.obj == null) {
            playerMessage = null;
        } else {
            playerMessage = (PlayerMessage) message.obj;
        }
        if (playerMessage != null) {
            obj = playerMessage.bizMsg1;
            callback = playerMessage.callback;
        } else {
            callback = null;
            obj = null;
        }
        if (message.what != 2) {
            syncAudioOtherMsg(message.what, message.obj);
        }
        StringBuilder append = new StringBuilder("handleMessage() called with: msg = [").append(catLog(message.what)).append("]--obj-->").append(obj).append("--from-->");
        if (playerMessage != null) {
            str = playerMessage.form;
        }
        Logger.v("PlayerThreadMain", append.append(str).toString());
        if (this.mThread == null) {
            AppMethodBeat.o(218637);
            return false;
        }
        try {
            switch (message.what) {
                case 1:
                    prepare(obj);
                    break;
                case 2:
                    play();
                    break;
                case 3:
                    pause();
                    break;
                case 4:
                    stop(obj == null ? false : ((Boolean) obj).booleanValue());
                    break;
                case 5:
                    seek((CMTime) obj);
                    break;
                case 6:
                    release(message);
                    break;
                case 9:
                    seekPreSample();
                    break;
                case 10:
                    updateProperties();
                    break;
                case 11:
                    UpdateCompositionMessage updateCompositionMessage = (UpdateCompositionMessage) obj;
                    stop(true);
                    releaseComposition();
                    if (updateCompositionMessage != null) {
                        updateComposition(updateCompositionMessage.playerItem);
                        prepare(updateCompositionMessage.updateListener);
                        break;
                    }
                    break;
                case 12:
                    if (this.mPlayRange == null || this.mPosition.add(this.frameDuration).smallThan(this.mPlayRange.getEnd())) {
                        if (this.mEnableScheduleNext) {
                            readSample(obj == null ? 0 : ((Integer) obj).intValue());
                            break;
                        }
                    } else {
                        seek(this.mPlayRange.getStart());
                        break;
                    }
                    break;
                case 20:
                    updateAllProperties();
                    break;
                case 21:
                    if (obj instanceof CGSize) {
                        this.surfaceSize = (CGSize) obj;
                        initViewport();
                        break;
                    }
                    break;
                case 22:
                    updateAudioClipsProperties();
                    break;
                case 23:
                    udpateAudioVolumeProperties();
                    break;
                case 24:
                    if (obj instanceof OnReadSnapShootListener) {
                        this.onReadSnapShootListener = (OnReadSnapShootListener) obj;
                        break;
                    }
                    break;
                case 25:
                    if (obj instanceof OnGetTavExtraListener) {
                        this.onGetTavExtraListener = (OnGetTavExtraListener) obj;
                        break;
                    }
                    break;
                case 26:
                    refreshSurface((Callback) obj);
                    break;
                case ACTION_QUIT /*{ENCODED_INT: 850}*/:
                    Logger.i("PlayerThreadMain", "quit: PlayerThreadMain ".concat(String.valueOf(this)));
                    removePendingMessage(new int[0]);
                    this.mThread.quit();
                    this.mThread = null;
                    this.vDecoderTrack.release();
                    this.aDecoderTrack.release();
                    this.renderContext.release();
                    this.renderContext = null;
                    this.vDecoderTrack = null;
                    this.aDecoderTrack = null;
                    this.mPlayHandler.removeCallbacksAndMessages(null);
                    break;
            }
            if (callback != null) {
                callback.call();
            }
            AppMethodBeat.o(218637);
            return true;
        } catch (Exception e2) {
            Logger.v("PlayerThreadMain", "player error:" + Log.getStackTraceString(e2));
            AppMethodBeat.o(218637);
            return false;
        }
    }

    private void updateProperties() {
    }

    private void updateAllProperties() {
    }

    private void updateAudioClipsProperties() {
        AppMethodBeat.i(218638);
        if (this.aDecoderTrack != null) {
            this.aDecoderTrack.release();
        }
        this.aDecoderTrack = this.mPlayerItem.initAudioCompositionDecoderTrack();
        this.aDecoderTrack.start();
        this.mAudioThread.update(this.aDecoderTrack);
        if (this.mLooper) {
            syncAudioOtherMsg(2, this.mPosition);
        }
        AppMethodBeat.o(218638);
    }

    private void udpateAudioVolumeProperties() {
    }

    private void release(Message message) {
        AppMethodBeat.i(218639);
        Logger.d("PlayerThreadMain", "release player - ".concat(String.valueOf(this)));
        this.renderContext.makeCurrent();
        if (message.obj instanceof PlayerMessage) {
            Object obj = ((PlayerMessage) message.obj).bizMsg1;
            if (obj instanceof Runnable) {
                ((Runnable) obj).run();
            }
        }
        removePendingMessage(new int[0]);
        releaseAudioThread(message.what, message.obj);
        updateStatus(1);
        if (this.reportSession != null) {
            this.reportSession.flush();
            this.reportSession = null;
        }
        AppMethodBeat.o(218639);
    }

    private void seek(CMTime cMTime) {
        AppMethodBeat.i(218640);
        if (this.mStatus == 1) {
            AppMethodBeat.o(218640);
            return;
        }
        CMTime cMTime2 = CMTime.CMTimeInvalid;
        try {
            cMTime2 = getLastSeekPosAndRemoveOther();
        } catch (Exception e2) {
            Logger.e("PlayerThreadMain", "getLastSeekPosAndRemoveOther", e2);
        }
        if (cMTime2.getValue() <= -1) {
            cMTime2 = cMTime;
        }
        if (this.vDecoderTrack != null) {
            removePendingMessage(12);
            this.mPosition = cMTime2;
            notifyProgressChange();
            syncAudioOtherMsg(3, cMTime2);
            syncAudioOtherMsg(5, cMTime2);
            readSample(5, cMTime2);
            this.mPlayHandler.postDelayed(new Runnable() {
                /* class com.tencent.tav.player.PlayerThread.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(218622);
                    if (PlayerThread.this.mLooper) {
                        PlayerThread.access$100(PlayerThread.this, 2, null);
                    }
                    AppMethodBeat.o(218622);
                }
            }, 10);
            AppMethodBeat.o(218640);
            return;
        }
        syncAudioOtherMsg(5, cMTime2);
        AppMethodBeat.o(218640);
    }

    private void refreshSurface(Callback callback) {
        AppMethodBeat.i(218641);
        if (this.mStatus == 1) {
            AppMethodBeat.o(218641);
            return;
        }
        if (this.vDecoderTrack != null) {
            removePendingMessage(12, 26);
            renderSampleBuffer(this.vDecoderTrack.readSample(this.vDecoderTrack.getCurrentSampleTime()));
        }
        if (callback != null) {
            callback.call();
        }
        AppMethodBeat.o(218641);
    }

    /* access modifiers changed from: package-private */
    public void removeReadSampleMessage() {
        AppMethodBeat.i(218642);
        if (this.mStatus == 1) {
            AppMethodBeat.o(218642);
            return;
        }
        if (this.vDecoderTrack != null) {
            removePendingMessage(12, 26);
        }
        AppMethodBeat.o(218642);
    }

    private boolean needNotifyProgressChange() {
        MessageQueue messageQueue;
        AppMethodBeat.i(218643);
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                messageQueue = this.mPlayHandler.getLooper().getQueue();
            } else {
                Field declaredField = Handler.class.getDeclaredField("mQueue");
                declaredField.setAccessible(true);
                messageQueue = (MessageQueue) declaredField.get(this.mPlayHandler);
            }
            Field declaredField2 = MessageQueue.class.getDeclaredField("mMessages");
            declaredField2.setAccessible(true);
            Message message = (Message) declaredField2.get(messageQueue);
            if (message == null || !(message.what == 3 || message.what == 4 || message.what == 1 || message.what == ACTION_QUIT || message.what == 6)) {
                AppMethodBeat.o(218643);
                return true;
            }
        } catch (Exception e2) {
            Logger.e("PlayerThreadMain", "needNotifyProgressChange", e2);
        }
        AppMethodBeat.o(218643);
        return false;
    }

    private CMTime getLastSeekPosAndRemoveOther() {
        MessageQueue messageQueue;
        AppMethodBeat.i(218644);
        CMTime cMTime = CMTime.CMTimeInvalid;
        if (Build.VERSION.SDK_INT >= 23) {
            messageQueue = this.mPlayHandler.getLooper().getQueue();
        } else {
            Field declaredField = Handler.class.getDeclaredField("mQueue");
            declaredField.setAccessible(true);
            messageQueue = (MessageQueue) declaredField.get(this.mPlayHandler);
        }
        Field declaredField2 = MessageQueue.class.getDeclaredField("mMessages");
        declaredField2.setAccessible(true);
        ArrayList arrayList = new ArrayList();
        Message message = (Message) declaredField2.get(messageQueue);
        while (message != null) {
            if (message.what == 5 && (message.obj instanceof PlayerMessage)) {
                arrayList.add(message);
                cMTime = (CMTime) ((PlayerMessage) message.obj).bizMsg1;
            } else if (message.getTarget() == this.mPlayHandler) {
                break;
            }
            Field declaredField3 = Message.class.getDeclaredField("next");
            declaredField3.setAccessible(true);
            message = (Message) declaredField3.get(message);
        }
        if (cMTime != CMTime.CMTimeInvalid) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Message message2 = (Message) it.next();
                this.mPlayHandler.removeMessages(message2.what, message2.obj);
            }
        }
        AppMethodBeat.o(218644);
        return cMTime;
    }

    private void stop(boolean z) {
        AppMethodBeat.i(218645);
        releaseComposition();
        if (this.filter != null) {
            this.filter.release();
            this.filter = null;
        }
        this.mStartTime = 0;
        enableScheduleNext(false);
        updateStatus(1);
        if (z) {
            notifyStatus(IPlayer.PlayerStatus.STOPPED, "");
            removePendingMessage(new int[0]);
            this.mLooper = false;
        }
        AppMethodBeat.o(218645);
    }

    /* access modifiers changed from: package-private */
    public void removePendingUpdateCompositionMessage() {
        AppMethodBeat.i(218646);
        removePendingMessage(11);
        AppMethodBeat.o(218646);
    }

    private void updateComposition(Object obj) {
        AppMethodBeat.i(218647);
        if (obj instanceof PlayerItem) {
            PlayerItem playerItem = (PlayerItem) obj;
            this.vDecoderTrack = playerItem.getRealDecoderTrack();
            this.aDecoderTrack = playerItem.getAudioCompositionDecoderTrack();
            this.mPlayerItem = playerItem;
        }
        if (this.vDecoderTrack != null) {
            this.frameDuration = this.vDecoderTrack.getFrameDuration();
        }
        this.mAudioThread.update(this.aDecoderTrack);
        AppMethodBeat.o(218647);
    }

    private void pause() {
        AppMethodBeat.i(218648);
        this.mLooper = false;
        this.mPause = true;
        enableScheduleNext(false);
        removePendingMessage(12);
        notifyStatus(IPlayer.PlayerStatus.PAUSED, "");
        AppMethodBeat.o(218648);
    }

    private void play() {
        AppMethodBeat.i(218649);
        if (this.mStatus == 1) {
            if (!(this.vDecoderTrack == null && this.aDecoderTrack == null)) {
                sendMessage(1, "not can play");
                sendMessage(2, "not can play");
            }
            AppMethodBeat.o(218649);
            return;
        }
        if (this.mStatus == 3) {
            if (this.vDecoderTrack != null) {
                if (this.mPosition.smallThan(this.vDecoderTrack.getDuration())) {
                    this.vDecoderTrack.seekTo(this.mPosition, false, true);
                } else {
                    this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
                }
            }
            updateStatus(2);
        }
        removePendingMessage(12);
        this.mLooper = true;
        enableScheduleNext(true);
        sendMessage(12, 2, AssetExtension.SCENE_PLAY);
        notifyStatus(IPlayer.PlayerStatus.PLAYING, "");
        Logger.v("PlayerThreadMain", "playm() called start play-->" + this.mStatus);
        AppMethodBeat.o(218649);
    }

    private void removePendingMessage(int... iArr) {
        AppMethodBeat.i(218650);
        Logger.v("PlayerThreadMain", "handleMessage() called with: removeInt = [" + (iArr.length == 0 ? BuildConfig.COMMAND : Integer.valueOf(iArr[0])) + "]");
        if (iArr.length == 0) {
            synchronized (this.mPlayHandler) {
                try {
                    if (!this.mPlayHandler.hasMessages(ACTION_QUIT)) {
                        this.mPlayHandler.removeCallbacksAndMessages(null);
                    } else {
                        this.mPlayHandler.removeCallbacksAndMessages(null);
                        this.mPlayHandler.sendEmptyMessage(ACTION_QUIT);
                    }
                } finally {
                    AppMethodBeat.o(218650);
                }
            }
            return;
        }
        for (int i2 : iArr) {
            this.mPlayHandler.removeMessages(i2);
        }
        AppMethodBeat.o(218650);
    }

    private void readSample(int i2) {
        AppMethodBeat.i(218651);
        readSample(i2, (this.mAudioThread.lastSyncMessgeId > this.lastSyncMessageId ? 1 : (this.mAudioThread.lastSyncMessgeId == this.lastSyncMessageId ? 0 : -1)) == 0 ? this.mAudioThread.getCurrentPlayingState() : CMTime.CMTimeInvalid);
        AppMethodBeat.o(218651);
    }

    private void readSample(int i2, CMTime cMTime) {
        AppMethodBeat.i(218652);
        if (this.vDecoderTrack == null) {
            syncAudioProgress();
            AppMethodBeat.o(218652);
            return;
        }
        if (this.reportSession == null) {
            this.reportSession = new PreviewReportSession();
        }
        long currentUsTime = getCurrentUsTime() - this.startTimeUsMark;
        try {
            long timeUs = this.frameDuration.divide(this.rate).getTimeUs();
            if (timeUs - currentUsTime > 0) {
                Thread.sleep((timeUs - currentUsTime) / 1000);
            }
        } catch (Throwable th) {
            Logger.e("PlayerThreadMain", "readSample", th);
        }
        this.startTimeUsMark = getCurrentUsTime();
        isNeedEnsureLooper(i2);
        CMSampleState cMSampleState = new CMSampleState();
        CMTime currentSampleTime = this.vDecoderTrack.getCurrentSampleTime();
        Logger.v("PlayerThreadMain", "readSample[" + i2 + "] lastPosition = " + currentSampleTime + " syncPlayingTime = " + cMTime);
        if (i2 == 2) {
            syncAudioOtherMsg(2, currentSampleTime);
        }
        if (i2 == 5 || this.mEnableScheduleNext) {
            try {
                this.renderContext.makeCurrent();
                long nanoTime = System.nanoTime();
                CMSampleBuffer readSampleBuffer = readSampleBuffer(i2, cMTime, currentSampleTime);
                long nanoTime2 = System.nanoTime() - nanoTime;
                if (i2 == 5 || this.mEnableScheduleNext) {
                    long nanoTime3 = System.nanoTime();
                    renderSampleBuffer(readSampleBuffer);
                    this.reportSession.tickPreview(nanoTime2, System.nanoTime() - nanoTime3);
                    cMSampleState = readSampleBuffer.getState();
                    this.vDecoderTrack.asyncReadNextSample(cMSampleState.getTime().add(new CMTime(1, cMSampleState.getTime().timeScale)));
                    this.decoderConsumerTimeUs = getCurrentUsTime() - this.startTimeUsMark;
                    Logger.v("PlayerThreadMain", "readSample() called with: messageId = [" + i2 + "]--currentSampleState-->" + cMSampleState + "--looper-->" + this.mLooper + " consumer = " + (System.currentTimeMillis() - this.startTimeUsMark));
                    if (cMSampleState.stateMatchingTo(-1, -3)) {
                        Logger.v("PlayerThreadMain", "readSample() called with: finish");
                        playerFinish();
                        AppMethodBeat.o(218652);
                        return;
                    }
                    boolean z = 5 == i2;
                    if (cMSampleState.getStateCode() >= 0) {
                        this.mPosition = cMSampleState.getTime();
                        if (!z && !this.mPlayHandler.hasMessages(5)) {
                            notifyProgressChange();
                        }
                    } else {
                        if (cMSampleState.stateMatchingTo(-100)) {
                            this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
                        }
                        cMSampleState = new CMSampleState(currentSampleTime);
                    }
                    if (this.mLooper) {
                        boolean z2 = this.mPause;
                        this.decoderConsumerTimeUs = (getCurrentUsTime() - this.startTimeUsMark) + 5000;
                        scheduleNextWork(getWaitTime(cMSampleState.getTime(), z, z2));
                        this.mPause = false;
                    }
                    Logger.v("PlayerThreadMain", "readSample end [" + i2 + "]--looper-->" + this.mLooper + " consumer = " + (getCurrentUsTime() - this.startTimeUsMark));
                    AppMethodBeat.o(218652);
                    return;
                }
                Logger.i("PlayerThreadMain", "disable schedule next, ignore this render");
                AppMethodBeat.o(218652);
            } catch (Exception e2) {
                Logger.e("PlayerThreadMain", "readSample", e2);
                if (e2 instanceof IllegalStateException) {
                    notifyStatus(IPlayer.PlayerStatus.ERROR, "解码异常");
                    AppMethodBeat.o(218652);
                }
            }
        } else {
            Logger.i("PlayerThreadMain", "disable schedule next, ignore this readSample");
            AppMethodBeat.o(218652);
        }
    }

    private long getCurrentUsTime() {
        AppMethodBeat.i(218653);
        long nanoTime = System.nanoTime() / 1000;
        AppMethodBeat.o(218653);
        return nanoTime;
    }

    private CMSampleBuffer readSampleBuffer(int i2, CMTime cMTime, CMTime cMTime2) {
        AppMethodBeat.i(218654);
        if (i2 == 5) {
            CMSampleBuffer seekTo = this.vDecoderTrack.seekTo(cMTime, true, true);
            AppMethodBeat.o(218654);
            return seekTo;
        }
        CMTime multi = this.frameDuration.multi(this.rate);
        if (cMTime2.smallThan(cMTime.sub(multi.multi(3.0f)))) {
            Logger.v("PlayerThreadMain", "readSampleBuffer: sampleTime = // " + cMTime2.add(this.frameDuration));
            CMSampleBuffer readSample = this.vDecoderTrack.readSample(cMTime.divide(multi).multi(multi));
            AppMethodBeat.o(218654);
            return readSample;
        } else if (!cMTime2.bigThan(cMTime.add(multi)) || !cMTime.bigThan(CMTime.CMTimeZero) || !this.mAudioThread.isFinished()) {
            Logger.v("PlayerThreadMain", "readSampleBuffer: sampleTime = " + cMTime2.add(multi));
            CMSampleBuffer readSample2 = this.vDecoderTrack.readSample(cMTime2.add(multi));
            AppMethodBeat.o(218654);
            return readSample2;
        } else {
            syncAudioOtherMsg(2, cMTime2);
            Logger.v("PlayerThreadMain", "readSampleBuffer: sampleTime = /// " + cMTime2.add(multi));
            CMSampleBuffer readSample3 = this.vDecoderTrack.readSample(multi);
            AppMethodBeat.o(218654);
            return readSample3;
        }
    }

    private void renderSampleBuffer(CMSampleBuffer cMSampleBuffer) {
        AppMethodBeat.i(218655);
        Logger.v("PlayerThreadMain", "renderSampleBuffer() called with: sampleBuffer = [" + cMSampleBuffer + "]");
        if (cMSampleBuffer.getTextureInfo() != null) {
            if (this.filter == null) {
                this.filter = new Filter();
                this.filter.setRendererWidth(this.renderContext.width());
                this.filter.setRendererHeight(this.renderContext.height());
            }
            this.renderContext.makeCurrent();
            TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
            if (this.onGetTavExtraListener != null) {
                this.onGetTavExtraListener.getTextureInfo(textureInfo);
                AppMethodBeat.o(218655);
                return;
            }
            applyViewport();
            this.filter.setBgColor(this.mPlayer.getBgColor());
            this.filter.applyFilter(textureInfo, null, textureInfo.getTextureMatrix());
            checkCopyPixelBuffer(cMSampleBuffer.getTime());
            this.renderContext.setPresentationTime(cMSampleBuffer.getTime().getTimeUs());
            this.renderContext.swapBuffers();
        }
        AppMethodBeat.o(218655);
    }

    private void applyViewport() {
        AppMethodBeat.i(218656);
        if (this.renderContext == null) {
            AppMethodBeat.o(218656);
        } else if (this.glViewportRect == null || this.glViewportRect.origin == null || this.glViewportRect.size == null) {
            AppMethodBeat.o(218656);
        } else {
            this.renderContext.updateViewport(this.glViewportRect);
            AppMethodBeat.o(218656);
        }
    }

    private void checkCopyPixelBuffer(CMTime cMTime) {
        AppMethodBeat.i(218657);
        if (this.onReadSnapShootListener != null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.renderContext.width() * this.renderContext.height() * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.rewind();
            GLES20.glReadPixels(0, 0, this.renderContext.width(), this.renderContext.height(), NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
            Bitmap createBitmap = Bitmap.createBitmap(this.renderContext.width(), this.renderContext.height(), Bitmap.Config.ARGB_4444);
            allocateDirect.rewind();
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            this.onReadSnapShootListener.onSuccess(Utils.flipYBitmap(createBitmap), cMTime);
            this.onReadSnapShootListener = null;
        }
        AppMethodBeat.o(218657);
    }

    private void syncAudioProgress() {
        AppMethodBeat.i(218658);
        if (this.aDecoderTrack != null) {
            if (!this.mPosition.equalsTo(this.aDecoderTrack.getCurrentSampleTime())) {
                this.mPosition = this.aDecoderTrack.getCurrentSampleTime();
                notifyProgressChange();
            }
            if (this.mAudioThread.isFinished()) {
                Logger.v("PlayerThreadMain", "processFrame() called with: finish");
                playerFinish();
                AppMethodBeat.o(218658);
                return;
            } else if (this.mLooper) {
                scheduleNextWork(30);
                this.mPause = false;
            }
        }
        AppMethodBeat.o(218658);
    }

    private void seekPreSample() {
        AppMethodBeat.i(218659);
        CMTime currentSampleTime = this.vDecoderTrack.getCurrentSampleTime();
        if (currentSampleTime != CMTime.CMTimeInvalid) {
            seek(currentSampleTime);
        }
        AppMethodBeat.o(218659);
    }

    private void isNeedEnsureLooper(int i2) {
        if (i2 == 2) {
            this.mLooper = true;
        }
    }

    private void playerFinish() {
        AppMethodBeat.i(218660);
        Logger.d("PlayerThreadMain", "playFinish");
        updateProgressPreNextAction(this.vDecoderTrack != null ? this.vDecoderTrack.getDuration() : this.mPlayer.duration());
        notifyProgressChange();
        updateStatus(3);
        syncAudioOtherMsg(-1, null);
        if (this.vDecoderTrack != null) {
            this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
        }
        this.mStartTime = 0;
        this.mLooper = false;
        notifyStatus(IPlayer.PlayerStatus.FINISHED, "");
        AppMethodBeat.o(218660);
    }

    private void updateProgressPreNextAction(CMTime cMTime) {
        this.mPosition = cMTime;
    }

    private long getWaitTime(CMTime cMTime, boolean z, boolean z2) {
        AppMethodBeat.i(218661);
        long timeUs = this.frameDuration.getTimeUs();
        long timeUs2 = cMTime.getTimeUs();
        if (z || z2) {
            Logger.d("PlayerThreadMain", "getWaitTime - 0 " + z + "  |  " + z2);
            AppMethodBeat.o(218661);
            return 0;
        }
        long abs = (long) (((float) timeUs) / Math.abs(this.rate));
        long j2 = abs - this.decoderConsumerTimeUs;
        Logger.v("PlayerThreadMain", "getWaitTime--position-->" + timeUs2 + " rate = " + this.rate + "--decoderConsumerTimeUs-->" + this.decoderConsumerTimeUs + "--frameDurationMs-->" + timeUs + "--realTime-->" + abs + "--nextFrameTime-->" + (timeUs2 + abs) + "--sleepTime-->" + j2 + "  mStartTime = " + this.mStartTime);
        AppMethodBeat.o(218661);
        return j2;
    }

    /* access modifiers changed from: package-private */
    public void enableScheduleNext(boolean z) {
        this.mEnableScheduleNext = z;
    }

    private void scheduleNextWork(long j2) {
        AppMethodBeat.i(218662);
        if (!this.mEnableScheduleNext) {
            Logger.i("PlayerThreadMain", "disable scheduleNextWork ignore");
            AppMethodBeat.o(218662);
            return;
        }
        long j3 = j2 / 1000;
        if (j3 > 0) {
            Logger.v("scheduleNextWork", "waitTime".concat(String.valueOf(j3)));
            sendMessageDelay(12, j3, "schedule next");
            AppMethodBeat.o(218662);
            return;
        }
        sendMessage(12, "schedule next");
        AppMethodBeat.o(218662);
    }

    private void notifyStatus(IPlayer.PlayerStatus playerStatus, String str) {
        AppMethodBeat.i(218663);
        this.mMainHandler.obtainMessage(1, new PlayerStatusMsg(playerStatus, str)).sendToTarget();
        AppMethodBeat.o(218663);
    }

    private void notifyProgressChange() {
        AppMethodBeat.i(218664);
        if (needNotifyProgressChange()) {
            this.mMainHandler.obtainMessage(2, this.mPosition).sendToTarget();
        }
        AppMethodBeat.o(218664);
    }

    private void prepare(Object obj) {
        AppMethodBeat.i(218665);
        if (this.mStatus == 1) {
            initDecoderTrack(obj);
            enableScheduleNext(true);
            AppMethodBeat.o(218665);
            return;
        }
        sendMessage(4, Boolean.FALSE, "prepare");
        sendMessage(1, obj, "prepare");
        AppMethodBeat.o(218665);
    }

    private void updateStatus(int i2) {
        this.mStatus = i2;
    }

    private void syncAudioOtherMsg(int i2, Object obj) {
        AppMethodBeat.i(218666);
        if (i2 == 3 || i2 == 2 || i2 == 4 || i2 == 6 || i2 == 7 || i2 == -1 || i2 == 5) {
            this.lastSyncMessageId = System.currentTimeMillis();
            Logger.d("PlayerThreadMain", "syncAudioOtherMsg SyncMessageId = " + this.lastSyncMessageId + "  action = " + i2 + "  obj = " + obj);
            this.mAudioThread.sendMessage(i2, obj, "syncAudioStatus", this.lastSyncMessageId);
        }
        AppMethodBeat.o(218666);
    }

    private void releaseAudioThread(int i2, Object obj) {
        AppMethodBeat.i(218667);
        if (i2 == 6) {
            this.lastSyncMessageId = System.currentTimeMillis();
            Logger.d("PlayerThreadMain", "releaseAudioThread SyncMessageId = " + this.lastSyncMessageId + "  action = " + i2 + "  obj =  " + obj);
            this.mAudioThread.sendMessage(i2, obj, "syncAudioStatus", this.lastSyncMessageId);
        }
        AppMethodBeat.o(218667);
    }

    private void synAudioComposition() {
        AppMethodBeat.i(218668);
        if (this.aDecoderTrack != null) {
            this.lastSyncMessageId = System.currentTimeMillis();
            Logger.d("PlayerThreadMain", "synAudioComposition SyncMessageId = " + this.lastSyncMessageId);
            this.mAudioThread.sendMessage(1, null, "syncAudioStatus composition", this.lastSyncMessageId);
        }
        AppMethodBeat.o(218668);
    }

    private void releaseComposition() {
        AppMethodBeat.i(218669);
        if (this.vDecoderTrack == null) {
            AppMethodBeat.o(218669);
            return;
        }
        if (this.mPlayerItem.getCustomVideoCompositor() != null) {
            this.mPlayerItem.getCustomVideoCompositor().release();
        }
        this.vDecoderTrack.release();
        this.aDecoderTrack.release();
        AppMethodBeat.o(218669);
    }

    private String catLog(int i2) {
        AppMethodBeat.i(218670);
        String str = map.get(i2, null);
        if (TextUtils.isEmpty(str)) {
            String valueOf = String.valueOf(i2);
            AppMethodBeat.o(218670);
            return valueOf;
        }
        AppMethodBeat.o(218670);
        return str;
    }

    public boolean hasMessage(int i2) {
        AppMethodBeat.i(218671);
        if (this.mPlayHandler == null || this.mThread == null) {
            AppMethodBeat.o(218671);
            return false;
        }
        boolean hasMessages = this.mPlayHandler.hasMessages(i2);
        AppMethodBeat.o(218671);
        return hasMessages;
    }

    public void cancelAllPendingSeeks() {
        AppMethodBeat.i(218672);
        removePendingMessage(5);
        AppMethodBeat.o(218672);
    }
}
