package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.media.AudioTrack;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class TXCMultAudioTrackPlayer {
    private static final String TAG = ("AudioCenter:" + TXCMultAudioTrackPlayer.class.getSimpleName());
    private int mAudioMode;
    private AudioTrackThread mAudioThread;
    private volatile boolean mAudioTrackStarted;
    private int mBits;
    private int mChannel;
    private Context mContext;
    private volatile boolean mIsStarted;
    private boolean mMute;
    private int mSampleRate;

    private native void nativeClassInit();

    private native byte[] nativeGetMixedTracksDataToAudioTrack();

    static /* synthetic */ byte[] access$800(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer) {
        AppMethodBeat.i(221875);
        byte[] nativeGetMixedTracksDataToAudioTrack = tXCMultAudioTrackPlayer.nativeGetMixedTracksDataToAudioTrack();
        AppMethodBeat.o(221875);
        return nativeGetMixedTracksDataToAudioTrack;
    }

    static {
        AppMethodBeat.i(16456);
        AppMethodBeat.o(16456);
    }

    class AudioTrackThread extends Thread {
        volatile boolean mIsLooping = false;

        public AudioTrackThread(String str) {
            super(str);
        }

        public void startLoop() {
            this.mIsLooping = true;
        }

        public void stopLoop() {
            this.mIsLooping = false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class TXCMultAudioTrackPlayerHolder {
        private static TXCMultAudioTrackPlayer instance = new TXCMultAudioTrackPlayer();

        private TXCMultAudioTrackPlayerHolder() {
        }

        static {
            AppMethodBeat.i(221876);
            AppMethodBeat.o(221876);
        }

        public static TXCMultAudioTrackPlayer getInstance() {
            return instance;
        }
    }

    public static TXCMultAudioTrackPlayer getInstance() {
        AppMethodBeat.i(221870);
        TXCMultAudioTrackPlayer instance = TXCMultAudioTrackPlayerHolder.getInstance();
        AppMethodBeat.o(221870);
        return instance;
    }

    private TXCMultAudioTrackPlayer() {
        AppMethodBeat.i(221871);
        this.mAudioThread = null;
        this.mMute = false;
        this.mIsStarted = false;
        this.mAudioTrackStarted = false;
        this.mContext = null;
        this.mAudioMode = 0;
        this.mSampleRate = 48000;
        this.mChannel = 2;
        this.mBits = 16;
        nativeClassInit();
        AppMethodBeat.o(221871);
    }

    public void start() {
        AppMethodBeat.i(221872);
        TXCLog.w(TAG, "mult-track-player start!");
        if (this.mIsStarted) {
            TXCLog.e(TAG, "mult-track-player can not start because of has started!");
            AppMethodBeat.o(221872);
        } else if (this.mSampleRate == 0 || this.mChannel == 0) {
            TXCLog.e(TAG, "strat mult-track-player failed with invalid audio info , samplerate:" + this.mSampleRate + ", channels:" + this.mChannel);
            AppMethodBeat.o(221872);
        } else {
            this.mIsStarted = true;
            if (this.mAudioThread == null) {
                this.mAudioThread = new AudioTrackThread("AUDIO_TRACK") {
                    /* class com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer.AnonymousClass1 */

                    public void run() {
                        int i2 = 3;
                        AppMethodBeat.i(16457);
                        try {
                            int i3 = TXCMultAudioTrackPlayer.this.mChannel == 1 ? 2 : 3;
                            if (TXCMultAudioTrackPlayer.this.mBits != 8) {
                                i2 = 2;
                            }
                            int minBufferSize = AudioTrack.getMinBufferSize(TXCMultAudioTrackPlayer.this.mSampleRate, i3, i2);
                            AudioTrack audioTrack = new AudioTrack(3, TXCMultAudioTrackPlayer.this.mSampleRate, i3, i2, minBufferSize, 1);
                            TXCLog.i(TXCMultAudioTrackPlayer.TAG, "create audio track, samplerate:" + TXCMultAudioTrackPlayer.this.mSampleRate + ", channels:" + TXCMultAudioTrackPlayer.this.mChannel + ", bits:" + TXCMultAudioTrackPlayer.this.mBits + " mMinBufferLength:" + minBufferSize);
                            try {
                                audioTrack.play();
                                TXCMultAudioTrackPlayer.this.mAudioTrackStarted = true;
                                TXCMultAudioTrackPlayer.this.setAudioMode(TXCMultAudioTrackPlayer.this.mContext, TXCMultAudioTrackPlayer.this.mAudioMode);
                                int i4 = 100;
                                int i5 = 0;
                                while (this.mIsLooping) {
                                    byte[] access$800 = TXCMultAudioTrackPlayer.access$800(TXCMultAudioTrackPlayer.this);
                                    if (access$800 == null || access$800.length <= 0) {
                                        try {
                                            sleep(5);
                                        } catch (InterruptedException e2) {
                                        }
                                    } else {
                                        TXCAudioEngine.onCorePlayPcmData(access$800, 0, TXCMultAudioTrackPlayer.this.mSampleRate, TXCMultAudioTrackPlayer.this.mChannel);
                                        if (TXCMultAudioTrackPlayer.this.mMute) {
                                            Arrays.fill(access$800, (byte) 0);
                                        }
                                        if (i4 != 0 && i5 < 800) {
                                            short[] sArr = new short[(access$800.length / 2)];
                                            ByteBuffer.wrap(access$800).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
                                            for (int i6 = 0; i6 < sArr.length; i6++) {
                                                sArr[i6] = (short) (sArr[i6] / i4);
                                            }
                                            ByteBuffer.wrap(access$800).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(sArr);
                                            i5 += access$800.length / ((TXCMultAudioTrackPlayer.this.mSampleRate * 2) / 1000);
                                            i4 = (i4 * (800 - i5)) / 800;
                                        }
                                        audioTrack.write(access$800, 0, access$800.length);
                                    }
                                }
                                try {
                                    audioTrack.pause();
                                    audioTrack.flush();
                                    audioTrack.stop();
                                    audioTrack.release();
                                } catch (Exception e3) {
                                    TXCLog.e(TXCMultAudioTrackPlayer.TAG, "stop AudioTrack failed.", e3);
                                }
                                TXCLog.e(TXCMultAudioTrackPlayer.TAG, "mult-player thread stop finish!");
                                AppMethodBeat.o(16457);
                            } catch (Exception e4) {
                                TXCLog.e(TXCMultAudioTrackPlayer.TAG, "start play failed.", e4);
                                AppMethodBeat.o(16457);
                            }
                        } catch (Exception e5) {
                            TXCLog.e(TXCMultAudioTrackPlayer.TAG, "create AudioTrack failed.", e5);
                            AppMethodBeat.o(16457);
                        }
                    }
                };
                this.mAudioThread.startLoop();
                this.mAudioThread.start();
            }
            TXCLog.w(TAG, "mult-track-player thread start finish!");
            AppMethodBeat.o(221872);
        }
    }

    public void stop() {
        AppMethodBeat.i(221873);
        TXCLog.w(TAG, "mult-track-player stop!");
        if (!this.mIsStarted) {
            TXCLog.w(TAG, "mult-track-player can not stop because of not started yet!");
            AppMethodBeat.o(221873);
            return;
        }
        if (this.mAudioThread != null) {
            this.mAudioThread.stopLoop();
            this.mAudioThread = null;
        }
        this.mAudioMode = 0;
        this.mContext = null;
        this.mAudioTrackStarted = false;
        this.mIsStarted = false;
        TXCLog.w(TAG, "mult-track-player stop finish!");
        AppMethodBeat.o(221873);
    }

    public synchronized void setAudioMode(Context context, int i2) {
        AppMethodBeat.i(221874);
        this.mContext = context;
        this.mAudioMode = i2;
        if (this.mAudioTrackStarted) {
            TXCLog.w(TAG, "mult-track-player setAudioRoute~");
            AppMethodBeat.o(221874);
        } else {
            TXCLog.w(TAG, "mult-track-player do'not setAudioRoute~");
            AppMethodBeat.o(221874);
        }
    }

    public boolean isPlaying() {
        return this.mIsStarted;
    }

    public void setMute(boolean z) {
        this.mMute = z;
    }
}
