package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.media.AudioRecord;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class TXCAudioSysRecord implements Runnable {
    private static final String TAG = ("AudioCenter:" + TXCAudioSysRecord.class.getSimpleName());
    private static TXCAudioSysRecord instance = null;
    private int mAECType = 0;
    private int mBits = 16;
    private int mChannels = 1;
    private Context mContext;
    private boolean mIsCapFirstFrame = false;
    private boolean mIsRunning = false;
    private AudioRecord mMic;
    private AtomicBoolean mPause = new AtomicBoolean(false);
    private byte[] mRecordBuffer = null;
    private Thread mRecordThread = null;
    private int mSampleRate = 48000;
    private boolean mSendMuteData = false;
    private WeakReference<c> mWeakRefListener;
    private Object threadMutex = new Object();

    private native void nativeClassInit();

    private native void nativeSendSysRecordAudioData(byte[] bArr, int i2, int i3, int i4, int i5);

    static {
        AppMethodBeat.i(221913);
        AppMethodBeat.o(221913);
    }

    public static TXCAudioSysRecord getInstance() {
        AppMethodBeat.i(221899);
        if (instance == null) {
            synchronized (TXCAudioSysRecord.class) {
                try {
                    if (instance == null) {
                        instance = new TXCAudioSysRecord();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(221899);
                    throw th;
                }
            }
        }
        TXCAudioSysRecord tXCAudioSysRecord = instance;
        AppMethodBeat.o(221899);
        return tXCAudioSysRecord;
    }

    private TXCAudioSysRecord() {
        AppMethodBeat.i(221900);
        nativeClassInit();
        AppMethodBeat.o(221900);
    }

    public synchronized void setAudioRecordListener(c cVar) {
        AppMethodBeat.i(221901);
        if (cVar == null) {
            this.mWeakRefListener = null;
            AppMethodBeat.o(221901);
        } else {
            this.mWeakRefListener = new WeakReference<>(cVar);
            AppMethodBeat.o(221901);
        }
    }

    public void start(int i2, int i3, int i4) {
        AppMethodBeat.i(221902);
        TXCLog.i(TAG, "start");
        synchronized (this.threadMutex) {
            try {
                stop();
                this.mSampleRate = i2;
                this.mChannels = i3;
                this.mBits = i4;
                this.mIsRunning = true;
                this.mRecordThread = new Thread(this, "AudioSysRecord Thread");
                this.mRecordThread.start();
            } catch (Throwable th) {
                AppMethodBeat.o(221902);
                throw th;
            }
        }
        TXCLog.i(TAG, "start ok");
        AppMethodBeat.o(221902);
    }

    public void stop() {
        AppMethodBeat.i(221903);
        TXCLog.i(TAG, "stop");
        synchronized (this.threadMutex) {
            try {
                this.mIsRunning = false;
                long currentTimeMillis = System.currentTimeMillis();
                if (!(this.mRecordThread == null || !this.mRecordThread.isAlive() || Thread.currentThread().getId() == this.mRecordThread.getId())) {
                    try {
                        this.mRecordThread.join();
                    } catch (Exception e2) {
                        TXCLog.e(TAG, "record stop Exception: " + e2.getMessage());
                    }
                }
                TXCLog.i(TAG, "stop ok,stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
                this.mRecordThread = null;
            } catch (Throwable th) {
                AppMethodBeat.o(221903);
                throw th;
            }
        }
        TXCLog.i(TAG, "stop ok");
        AppMethodBeat.o(221903);
    }

    public void pause(boolean z) {
        AppMethodBeat.i(221904);
        TXCLog.i(TAG, "system audio record pause");
        this.mPause.set(true);
        this.mSendMuteData = z;
        AppMethodBeat.o(221904);
    }

    public void resume() {
        AppMethodBeat.i(221905);
        TXCLog.i(TAG, "system audio record resume");
        this.mPause.set(false);
        AppMethodBeat.o(221905);
    }

    public synchronized boolean isRecording() {
        return this.mIsRunning;
    }

    private void init() {
        int i2;
        AppMethodBeat.i(221906);
        int i3 = this.mSampleRate;
        int i4 = this.mChannels;
        int i5 = this.mBits;
        TXCLog.i(TAG, String.format("audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(this.mAECType)));
        int i6 = 12;
        if (i4 == 1) {
            i6 = 16;
        }
        if (i5 == 8) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(i3, i6, i2);
        try {
            TXCLog.i(TAG, "audio record type: system normal");
            this.mMic = new AudioRecord(1, i3, i6, i2, minBufferSize * 2);
        } catch (IllegalArgumentException e2) {
            TXCLog.e(TAG, "create AudioRecord failed.", e2);
        }
        if (this.mMic == null || this.mMic.getState() != 1) {
            TXCLog.e(TAG, "audio record: initialize the mic failed.");
            uninit();
            onRecordError(-1, "microphone permission denied!");
            AppMethodBeat.o(221906);
            return;
        }
        int i7 = ((i4 * 1024) * i5) / 8;
        if (i7 > minBufferSize) {
            this.mRecordBuffer = new byte[minBufferSize];
        } else {
            this.mRecordBuffer = new byte[i7];
        }
        TXCLog.i(TAG, String.format("audio record: mic open rate=%dHZ, channels=%d, bits=%d, buffer=%d/%d, state=%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(minBufferSize), Integer.valueOf(this.mRecordBuffer.length), Integer.valueOf(this.mMic.getState())));
        if (this.mMic != null) {
            try {
                this.mMic.startRecording();
                AppMethodBeat.o(221906);
            } catch (Exception e3) {
                TXCLog.e(TAG, "mic startRecording failed.", e3);
                onRecordError(-1, "start recording failed!");
                AppMethodBeat.o(221906);
            }
        } else {
            AppMethodBeat.o(221906);
        }
    }

    private void uninit() {
        AppMethodBeat.i(221907);
        if (this.mMic != null) {
            TXCLog.i(TAG, "stop mic");
            try {
                this.mMic.setRecordPositionUpdateListener(null);
                this.mMic.stop();
                this.mMic.release();
            } catch (Exception e2) {
                TXCLog.e(TAG, "stop AudioRecord failed.", e2);
            }
        }
        this.mMic = null;
        this.mRecordBuffer = null;
        this.mIsCapFirstFrame = false;
        AppMethodBeat.o(221907);
    }

    private void onRecordPcmData(byte[] bArr, int i2, long j2) {
        AppMethodBeat.i(221908);
        c cVar = null;
        if (this.mWeakRefListener != null) {
            cVar = this.mWeakRefListener.get();
        }
        if (cVar != null) {
            cVar.onAudioRecordPCM(bArr, i2, j2);
            AppMethodBeat.o(221908);
            return;
        }
        TXCLog.e(TAG, "onRecordPcmData:no callback");
        AppMethodBeat.o(221908);
    }

    private void onRecordError(int i2, String str) {
        AppMethodBeat.i(221909);
        c cVar = null;
        synchronized (this) {
            try {
                if (this.mWeakRefListener != null) {
                    cVar = this.mWeakRefListener.get();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(221909);
                throw th;
            }
        }
        if (cVar != null) {
            cVar.onAudioRecordError(i2, str);
            AppMethodBeat.o(221909);
            return;
        }
        TXCLog.e(TAG, "onRecordError:no callback");
        AppMethodBeat.o(221909);
    }

    private void onRecordStart() {
        AppMethodBeat.i(221910);
        c cVar = null;
        synchronized (this) {
            try {
                if (this.mWeakRefListener != null) {
                    cVar = this.mWeakRefListener.get();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(221910);
                throw th;
            }
        }
        if (cVar != null) {
            cVar.onAudioRecordStart();
            AppMethodBeat.o(221910);
            return;
        }
        TXCLog.e(TAG, "onRecordStart:no callback");
        AppMethodBeat.o(221910);
    }

    private void onRecordStop() {
        AppMethodBeat.i(221911);
        c cVar = null;
        synchronized (this) {
            try {
                if (this.mWeakRefListener != null) {
                    cVar = this.mWeakRefListener.get();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(221911);
                throw th;
            }
        }
        if (cVar != null) {
            cVar.onAudioRecordStop();
            AppMethodBeat.o(221911);
            return;
        }
        TXCLog.e(TAG, "onRecordStop:no callback");
        AppMethodBeat.o(221911);
    }

    public void run() {
        AppMethodBeat.i(221912);
        if (!this.mIsRunning) {
            TXCLog.w(TAG, "audio record: abandom start audio sys record thread!");
            AppMethodBeat.o(221912);
            return;
        }
        onRecordStart();
        TXCLog.i(TAG, "start capture audio data ...,mIsRunning:" + this.mIsRunning + " Thread.interrupted:" + Thread.interrupted() + " mMic:" + this.mMic);
        init();
        int i2 = 0;
        int i3 = 0;
        while (this.mIsRunning && !Thread.interrupted() && this.mMic != null && i3 <= 5) {
            System.currentTimeMillis();
            int read = this.mMic.read(this.mRecordBuffer, i2, this.mRecordBuffer.length - i2);
            if (read == this.mRecordBuffer.length - i2) {
                if (!this.mIsCapFirstFrame) {
                    onRecordError(-6, "First frame captured#");
                    this.mIsCapFirstFrame = true;
                }
                if (this.mSendMuteData) {
                    Arrays.fill(this.mRecordBuffer, (byte) 0);
                }
                if (!this.mPause.get() || this.mSendMuteData) {
                    onRecordPcmData(this.mRecordBuffer, this.mRecordBuffer.length, TXCTimeUtil.getTimeTick());
                    nativeSendSysRecordAudioData(this.mRecordBuffer, this.mRecordBuffer.length, this.mSampleRate, this.mChannels, this.mBits);
                }
                i2 = 0;
                i3 = 0;
            } else if (read <= 0) {
                TXCLog.e(TAG, "read pcm error, len =".concat(String.valueOf(read)));
                i3++;
            } else {
                i2 += read;
            }
        }
        TXCLog.d(TAG, "stop capture audio data ...,mIsRunning:" + this.mIsRunning + " mMic:" + this.mMic + " nFailedCount:" + i3);
        uninit();
        if (i3 > 5) {
            onRecordError(-1, "read data failed!");
            AppMethodBeat.o(221912);
            return;
        }
        onRecordStop();
        AppMethodBeat.o(221912);
    }
}
