package com.tencent.tav.player;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;

public class PlayerThreadAudio implements Handler.Callback {
    private static final String TAG = "PlayerThreadAudio";
    private AudioCompositionDecoderTrack audioDecoderTrack;
    public volatile CMSampleState currentPlayingState = new CMSampleState();
    public volatile long lastSyncMessgeId = -1;
    private AudioTrackWrapper mAudioTrack;
    private boolean mLooper;
    private Handler mMainHandler;
    private Handler mPlayHandler;
    private int mStatus = 1;
    private HandlerThread mThread;
    private Handler mVideoHandler;
    private float rate = 1.0f;
    private float volume = 1.0f;

    public PlayerThreadAudio(AudioCompositionDecoderTrack audioCompositionDecoderTrack, Handler handler, Handler handler2) {
        AppMethodBeat.i(218675);
        this.audioDecoderTrack = audioCompositionDecoderTrack;
        this.mMainHandler = handler;
        this.mVideoHandler = handler2;
        initThread();
        AppMethodBeat.o(218675);
    }

    public void update(AudioCompositionDecoderTrack audioCompositionDecoderTrack) {
        this.audioDecoderTrack = audioCompositionDecoderTrack;
    }

    public void setRate(float f2) {
        AppMethodBeat.i(218676);
        this.rate = Math.abs(f2);
        AppMethodBeat.o(218676);
    }

    private void initThread() {
        AppMethodBeat.i(218677);
        this.mThread = new HandlerThread("PlayerAudioThread");
        this.mThread.start();
        this.mPlayHandler = new Handler(this.mThread.getLooper(), this);
        AppMethodBeat.o(218677);
    }

    @Deprecated
    public void updateComposition(AudioCompositionDecoderTrack audioCompositionDecoderTrack) {
        AppMethodBeat.i(218678);
        sendMessage(4, "updateComposition", System.currentTimeMillis());
        sendMessage(1, audioCompositionDecoderTrack, "updateComposition", System.currentTimeMillis());
        AppMethodBeat.o(218678);
    }

    public void sendMessage(int i2, Object obj, String str, long j2) {
        AppMethodBeat.i(218679);
        v(TAG, "sendMessage() called with: what = [" + catLog(i2) + "], obj = [" + obj + "], from = [" + str + "]");
        if (!(this.mPlayHandler == null || this.mThread == null)) {
            if ((i2 == 3 || i2 == -1 || i2 == 5 || i2 == 6) && this.mPlayHandler.hasMessages(12)) {
                this.mPlayHandler.removeMessages(12);
                sendMessage(12, "schedule next", System.currentTimeMillis());
            }
            this.mPlayHandler.obtainMessage(i2, new PlayerMessage(obj, str, j2)).sendToTarget();
        }
        AppMethodBeat.o(218679);
    }

    public void sendMessage(int i2, String str, long j2) {
        AppMethodBeat.i(218680);
        v(TAG, "sendMessage() called with: what = [" + catLog(i2) + "], from = [" + str + "]");
        if (!(this.mPlayHandler == null || this.mThread == null)) {
            this.mPlayHandler.obtainMessage(i2, new PlayerMessage(null, str, j2)).sendToTarget();
        }
        AppMethodBeat.o(218680);
    }

    public void sendMessageDelay(int i2, long j2, String str, long j3) {
        AppMethodBeat.i(218681);
        v(TAG, "sendMessageDelay() called with: what = [" + catLog(i2) + "], delay = [" + j2 + "], from = [" + str + "]");
        if (this.mPlayHandler != null) {
            Message message = new Message();
            message.what = i2;
            message.obj = new PlayerMessage(null, str, j3);
            this.mPlayHandler.sendMessageDelayed(message, j2);
        }
        AppMethodBeat.o(218681);
    }

    public boolean handleMessage(Message message) {
        Object obj;
        PlayerMessage playerMessage = null;
        AppMethodBeat.i(218682);
        PlayerMessage playerMessage2 = message.obj == null ? null : (PlayerMessage) message.obj;
        if (playerMessage2 != null) {
            obj = playerMessage2.bizMsg1;
        } else {
            obj = null;
        }
        StringBuilder append = new StringBuilder("handleMessage() called with: msg = [").append(catLog(message.what)).append(message.what).append("]--status-->").append(this.mStatus).append("--from-->");
        if (playerMessage2 != null) {
            playerMessage = playerMessage2;
        }
        v(TAG, append.append(playerMessage).append(" targetObj = ").append(obj).toString());
        try {
            switch (message.what) {
                case -1:
                    playerFinish();
                    break;
                case 1:
                    actionPrepare();
                    break;
                case 2:
                    play(obj);
                    break;
                case 3:
                    pause();
                    break;
                case 4:
                    stop(false);
                    break;
                case 5:
                    seekTo(obj);
                    break;
                case 6:
                    release();
                    break;
                case 7:
                    setVolume(obj);
                    break;
                case 12:
                    readSample();
                    break;
            }
            if (playerMessage2 != null && !TextUtils.isEmpty(playerMessage2.form) && playerMessage2.form.startsWith("syncAudioStatus")) {
                Logger.d(TAG, "handleMessage:  SyncMessageId = " + playerMessage2.msgId + ", what = " + message.what);
                this.lastSyncMessgeId = playerMessage2.msgId;
            }
            AppMethodBeat.o(218682);
            return true;
        } catch (Exception e2) {
            Logger.e(TAG, "handleMessage: error", e2);
            if (playerMessage2 != null && !TextUtils.isEmpty(playerMessage2.form) && playerMessage2.form.startsWith("syncAudioStatus")) {
                Logger.d(TAG, "handleMessage:  SyncMessageId = " + playerMessage2.msgId + ", what = " + message.what);
                this.lastSyncMessgeId = playerMessage2.msgId;
            }
            AppMethodBeat.o(218682);
            return false;
        } catch (Throwable th) {
            if (playerMessage2 != null && !TextUtils.isEmpty(playerMessage2.form) && playerMessage2.form.startsWith("syncAudioStatus")) {
                Logger.d(TAG, "handleMessage:  SyncMessageId = " + playerMessage2.msgId + ", what = " + message.what);
                this.lastSyncMessgeId = playerMessage2.msgId;
            }
            AppMethodBeat.o(218682);
            throw th;
        }
    }

    private void seekTo(Object obj) {
        Object obj2;
        AppMethodBeat.i(218683);
        if (obj instanceof PlayerMessage) {
            obj2 = ((PlayerMessage) obj).bizMsg1;
        } else {
            obj2 = obj;
        }
        if (obj2 instanceof CMTime) {
            this.currentPlayingState = new CMSampleState((CMTime) obj2);
            this.audioDecoderTrack.seekTo((CMTime) obj2, false, true);
        }
        if (this.mAudioTrack != null) {
            this.mAudioTrack.flush();
        }
        AppMethodBeat.o(218683);
    }

    private void setVolume(Object obj) {
        float floatValue;
        AppMethodBeat.i(218684);
        if (obj instanceof PlayerMessage) {
            floatValue = ((Float) ((PlayerMessage) obj).bizMsg1).floatValue();
        } else {
            floatValue = obj instanceof Float ? ((Float) obj).floatValue() : 1.0f;
        }
        if (floatValue >= 0.0f && floatValue <= 1.0f) {
            setVolumeToAudioTrack(floatValue);
        }
        AppMethodBeat.o(218684);
    }

    private void setVolumeToAudioTrack(float f2) {
        AppMethodBeat.i(218685);
        this.volume = f2;
        if (this.mAudioTrack != null) {
            this.mAudioTrack.setVolume(f2);
        }
        AppMethodBeat.o(218685);
    }

    private void actionPrepare() {
        AppMethodBeat.i(218686);
        if (this.audioDecoderTrack != null) {
            updateStatus(2);
            releaseAudioTrack();
        }
        AppMethodBeat.o(218686);
    }

    private void stop(boolean z) {
        AppMethodBeat.i(218687);
        if (z) {
            removePendingMessage(12);
            this.mLooper = false;
            this.currentPlayingState = new CMSampleState();
        }
        updateStatus(1);
        releaseAudioTrack();
        AppMethodBeat.o(218687);
    }

    private void releaseAudioTrack() {
        AppMethodBeat.i(218688);
        if (this.mAudioTrack != null) {
            this.mAudioTrack.stop();
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
        AppMethodBeat.o(218688);
    }

    private void pause() {
        AppMethodBeat.i(218689);
        if (this.mStatus == 2) {
            this.mLooper = false;
            this.currentPlayingState = new CMSampleState();
            removePendingMessage(12);
        }
        AppMethodBeat.o(218689);
    }

    private void play(Object obj) {
        AppMethodBeat.i(218690);
        if (this.mStatus == 1) {
            AppMethodBeat.o(218690);
            return;
        }
        this.mLooper = true;
        if ((obj instanceof CMTime) && Math.abs(((CMTime) obj).getTimeUs() - this.currentPlayingState.getTime().getTimeUs()) > 100000) {
            seekTo(obj);
        }
        if (this.mStatus == 3) {
            updateStatus(2);
        }
        sendMessage(12, AssetExtension.SCENE_PLAY, System.currentTimeMillis());
        AppMethodBeat.o(218690);
    }

    private void playerFinish() {
        AppMethodBeat.i(218691);
        this.currentPlayingState = new CMSampleState();
        this.audioDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
        this.mLooper = false;
        updateStatus(3);
        removePendingMessage(12);
        AppMethodBeat.o(218691);
    }

    public boolean isFinished() {
        AppMethodBeat.i(218692);
        if (3 != this.mStatus || !this.currentPlayingState.isInvalid()) {
            AppMethodBeat.o(218692);
            return false;
        }
        AppMethodBeat.o(218692);
        return true;
    }

    private void removePendingMessage(int... iArr) {
        AppMethodBeat.i(218693);
        if (iArr == null || iArr.length == 0) {
            this.mPlayHandler.removeCallbacksAndMessages(null);
            AppMethodBeat.o(218693);
            return;
        }
        for (int i2 : iArr) {
            this.mPlayHandler.removeMessages(i2);
        }
        AppMethodBeat.o(218693);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x015b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readSample() {
        /*
        // Method dump skipped, instructions count: 392
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.player.PlayerThreadAudio.readSample():void");
    }

    private void scheduleNextWork() {
        AppMethodBeat.i(218695);
        sendMessage(12, "schedule next", System.currentTimeMillis());
        AppMethodBeat.o(218695);
    }

    private void release() {
        AppMethodBeat.i(218696);
        releaseAudioTrack();
        removePendingMessage(new int[0]);
        updateStatus(1);
        try {
            Logger.e(TAG, "quit: PlayerThreadAudio ".concat(String.valueOf(this)));
            this.mThread.quit();
            this.mThread = null;
            synchronized (this.mVideoHandler) {
                try {
                    this.mVideoHandler.sendEmptyMessage(850);
                } catch (Throwable th) {
                    AppMethodBeat.o(218696);
                    throw th;
                }
            }
            this.mPlayHandler = null;
            this.mVideoHandler = null;
            AppMethodBeat.o(218696);
        } catch (Exception e2) {
            Logger.e(TAG, "release error-->", e2);
            synchronized (this.mVideoHandler) {
                this.mVideoHandler.sendEmptyMessage(850);
                this.mPlayHandler = null;
                this.mVideoHandler = null;
                AppMethodBeat.o(218696);
            }
        } catch (Throwable th2) {
            AppMethodBeat.o(218696);
            throw th2;
        }
    }

    private void updateStatus(int i2) {
        this.mStatus = i2;
    }

    private String catLog(int i2) {
        AppMethodBeat.i(218697);
        String str = PlayerThread.map.get(i2, null);
        AppMethodBeat.o(218697);
        return str;
    }

    private void v(String str, String str2) {
        AppMethodBeat.i(218698);
        Logger.v(str, str2);
        AppMethodBeat.o(218698);
    }

    public CMTime getCurrentPlayingState() {
        AppMethodBeat.i(218699);
        CMTime time = this.currentPlayingState.getTime();
        AppMethodBeat.o(218699);
        return time;
    }
}
