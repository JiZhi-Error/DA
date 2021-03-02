package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord;
import com.tencent.liteav.audio.impl.Record.a;
import com.tencent.liteav.audio.impl.Record.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TXCAudioUGCRecorder implements c {
    private static final TXCAudioUGCRecorder INSTANCE = new TXCAudioUGCRecorder();
    private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
    private final int AAC_SAMPLE_NUM = 1024;
    protected int mAACFrameLength = (((this.mChannels * 1024) * this.mBits) / 8);
    protected int mAECType = 0;
    private a mBGMRecorder = null;
    protected int mBits = 16;
    protected int mChannels = 1;
    protected Context mContext;
    private boolean mCurBGMRecordFlag = false;
    private boolean mEnableBGMRecord = false;
    private final List<byte[]> mEncodedAudioList = new ArrayList();
    protected boolean mIsEarphoneOn = false;
    private boolean mIsMute = false;
    private boolean mIsPause = false;
    private boolean mIsRunning = false;
    private long mLastPTS = 0;
    protected int mReverbType = 0;
    protected AtomicInteger mSampleRate = new AtomicInteger(48000);
    private int mShouldClearAACDataCnt = 0;
    private AtomicReference<Float> mSpeedRate = new AtomicReference<>(Float.valueOf(1.0f));
    protected int mVoiceChangerType = 0;
    private float mVolume = 1.0f;
    private WeakReference<e> mWeakRecordListener;

    private native void nativeClassInit();

    private native void nativeEnableMixMode(boolean z);

    private native void nativeSetChangerType(int i2);

    private native void nativeSetReverbType(int i2);

    private native void nativeSetSpeedRate(float f2);

    private native void nativeSetVolume(float f2);

    private native void nativeStartAudioRecord(int i2, int i3, int i4);

    private native void nativeStopAudioRecord();

    static {
        AppMethodBeat.i(16329);
        f.f();
        AppMethodBeat.o(16329);
    }

    public static TXCAudioUGCRecorder getInstance() {
        return INSTANCE;
    }

    private TXCAudioUGCRecorder() {
        AppMethodBeat.i(222009);
        TXCAudioSysRecord.getInstance();
        nativeClassInit();
        AppMethodBeat.o(222009);
    }

    public int startRecord(Context context) {
        AppMethodBeat.i(16304);
        TXCLog.i(TAG, JsApiStartRecordVoice.NAME);
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        updateAudioEffector();
        TXCAudioSysRecord.getInstance().setAudioRecordListener(this);
        nativeStartAudioRecord(this.mSampleRate.get(), this.mChannels, this.mBits);
        this.mIsRunning = true;
        this.mLastPTS = 0;
        AppMethodBeat.o(16304);
        return 0;
    }

    public int stopRecord() {
        AppMethodBeat.i(16305);
        TXCLog.i(TAG, JsApiStopRecordVoice.NAME);
        TXCAudioSysRecord.getInstance().setAudioRecordListener(null);
        if (this.mBGMRecorder != null) {
            this.mBGMRecorder.a();
            this.mBGMRecorder = null;
        }
        nativeStopAudioRecord();
        nativeEnableMixMode(false);
        nativeSetVolume(1.0f);
        synchronized (this.mEncodedAudioList) {
            try {
                this.mEncodedAudioList.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(16305);
                throw th;
            }
        }
        this.mIsRunning = false;
        this.mLastPTS = 0;
        this.mIsPause = false;
        this.mIsMute = false;
        this.mShouldClearAACDataCnt = 0;
        AppMethodBeat.o(16305);
        return 0;
    }

    public void pause() {
        AppMethodBeat.i(16306);
        TXCLog.i(TAG, "pause");
        TXCAudioEngine.getInstance().pauseLocalAudio();
        synchronized (this.mEncodedAudioList) {
            try {
                this.mIsPause = true;
            } finally {
                AppMethodBeat.o(16306);
            }
        }
    }

    public void resume() {
        AppMethodBeat.i(16307);
        TXCLog.i(TAG, "resume");
        TXCAudioEngine.getInstance().resumeLocalAudio();
        synchronized (this.mEncodedAudioList) {
            try {
                this.mIsPause = false;
            } catch (Throwable th) {
                AppMethodBeat.o(16307);
                throw th;
            }
        }
        nativeEnableMixMode(this.mEnableBGMRecord);
        if (this.mIsMute || this.mEnableBGMRecord) {
            nativeSetVolume(0.0f);
            AppMethodBeat.o(16307);
            return;
        }
        nativeSetVolume(this.mVolume);
        AppMethodBeat.o(16307);
    }

    public synchronized void setListener(e eVar) {
        AppMethodBeat.i(16308);
        if (eVar == null) {
            this.mWeakRecordListener = null;
            AppMethodBeat.o(16308);
        } else {
            this.mWeakRecordListener = new WeakReference<>(eVar);
            AppMethodBeat.o(16308);
        }
    }

    public e getListener() {
        AppMethodBeat.i(16309);
        if (this.mWeakRecordListener != null) {
            e eVar = this.mWeakRecordListener.get();
            AppMethodBeat.o(16309);
            return eVar;
        }
        AppMethodBeat.o(16309);
        return null;
    }

    public void setChannels(int i2) {
        AppMethodBeat.i(16310);
        TXCLog.i(TAG, "setChannels: ".concat(String.valueOf(i2)));
        this.mChannels = i2;
        AppMethodBeat.o(16310);
    }

    public int getChannels() {
        return this.mChannels;
    }

    public void setSampleRate(int i2) {
        AppMethodBeat.i(16311);
        TXCLog.i(TAG, "setSampleRate: ".concat(String.valueOf(i2)));
        this.mSampleRate.set(i2);
        AppMethodBeat.o(16311);
    }

    public int getSampleRate() {
        AppMethodBeat.i(222010);
        int i2 = this.mSampleRate.get();
        AppMethodBeat.o(222010);
        return i2;
    }

    public synchronized void setReverbType(int i2) {
        AppMethodBeat.i(16312);
        TXCLog.i(TAG, "setReverbType: ".concat(String.valueOf(i2)));
        this.mReverbType = i2;
        nativeSetReverbType(i2);
        AppMethodBeat.o(16312);
    }

    public void setAECType(int i2, Context context) {
        AppMethodBeat.i(16313);
        TXCLog.i(TAG, "setAECType: ".concat(String.valueOf(i2)));
        this.mAECType = i2;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        AppMethodBeat.o(16313);
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(16314);
        TXCLog.i(TAG, "setMute: ".concat(String.valueOf(z)));
        this.mIsMute = z;
        if (z) {
            nativeSetVolume(0.0f);
            AppMethodBeat.o(16314);
            return;
        }
        nativeSetVolume(this.mVolume);
        AppMethodBeat.o(16314);
    }

    public void enableBGMRecord(boolean z) {
        AppMethodBeat.i(16315);
        TXCLog.i(TAG, "enableBGMRecord: ".concat(String.valueOf(z)));
        if (this.mEnableBGMRecord != z && !z) {
            this.mShouldClearAACDataCnt = 2;
        }
        this.mEnableBGMRecord = z;
        updateAudioEffector();
        AppMethodBeat.o(16315);
    }

    public boolean isRecording() {
        AppMethodBeat.i(16317);
        boolean z = this.mIsRunning;
        AppMethodBeat.o(16317);
        return z;
    }

    public boolean isPaused() {
        return this.mIsPause;
    }

    public void onEncodedData(byte[] bArr) {
        AppMethodBeat.i(222011);
        synchronized (this.mEncodedAudioList) {
            try {
                this.mEncodedAudioList.add(bArr);
            } finally {
                AppMethodBeat.o(222011);
            }
        }
    }

    public synchronized void setVolume(float f2) {
        AppMethodBeat.i(16319);
        TXCLog.i(TAG, "setVolume: ".concat(String.valueOf(f2)));
        this.mVolume = f2;
        if (this.mIsMute) {
            nativeSetVolume(0.0f);
            AppMethodBeat.o(16319);
        } else {
            nativeSetVolume(f2);
            AppMethodBeat.o(16319);
        }
    }

    public synchronized void setSpeedRate(float f2) {
        AppMethodBeat.i(16320);
        TXCLog.i(TAG, "setSpeedRate: ".concat(String.valueOf(f2)));
        this.mSpeedRate.set(Float.valueOf(f2));
        nativeSetSpeedRate(this.mSpeedRate.get().floatValue());
        AppMethodBeat.o(16320);
    }

    public synchronized void clearCache() {
        AppMethodBeat.i(16321);
        TXCLog.i(TAG, "clearCache");
        synchronized (this.mEncodedAudioList) {
            try {
                this.mEncodedAudioList.clear();
            } finally {
                AppMethodBeat.o(16321);
            }
        }
    }

    @Override // com.tencent.liteav.audio.impl.Record.c
    public void onAudioRecordStart() {
        AppMethodBeat.i(16322);
        TXCLog.i(TAG, "sys audio record start");
        AppMethodBeat.o(16322);
    }

    @Override // com.tencent.liteav.audio.impl.Record.c
    public void onAudioRecordStop() {
        AppMethodBeat.i(16323);
        TXCLog.i(TAG, "sys audio record stop");
        AppMethodBeat.o(16323);
    }

    @Override // com.tencent.liteav.audio.impl.Record.c
    public void onAudioRecordError(int i2, String str) {
        AppMethodBeat.i(16324);
        TXCLog.e(TAG, "sys audio record error: " + i2 + ", " + str);
        e listener = getListener();
        if (listener != null) {
            listener.onRecordError(i2, str);
        }
        AppMethodBeat.o(16324);
    }

    @Override // com.tencent.liteav.audio.impl.Record.c
    public void onAudioRecordPCM(byte[] bArr, int i2, long j2) {
        long j3;
        byte[] bArr2;
        AppMethodBeat.i(16325);
        if (this.mLastPTS >= j2) {
            j3 = 2 + this.mLastPTS;
        } else {
            j3 = j2;
        }
        do {
            synchronized (this.mEncodedAudioList) {
                try {
                    if (this.mEncodedAudioList.isEmpty() || this.mIsPause) {
                        bArr2 = null;
                    } else {
                        byte[] bArr3 = this.mEncodedAudioList.get(0);
                        this.mEncodedAudioList.remove(0);
                        if (this.mShouldClearAACDataCnt > 0) {
                            this.mShouldClearAACDataCnt--;
                            bArr2 = null;
                        } else {
                            bArr2 = bArr3;
                        }
                    }
                    if (bArr2 != null) {
                        this.mLastPTS = j3;
                        e listener = getListener();
                        if (listener != null) {
                            listener.onRecordEncData(bArr2, j3, this.mSampleRate.get(), this.mChannels, this.mBits);
                        } else {
                            TXCLog.e(TAG, "onAudioRecordPCM listener is null");
                        }
                        int i3 = this.mSampleRate.get();
                        if (i3 > 0) {
                            j3 += (long) ((this.mSpeedRate.get().floatValue() * 1024000.0f) / ((float) i3));
                        }
                    }
                } finally {
                    AppMethodBeat.o(16325);
                }
            }
        } while (bArr2 != null);
    }

    private synchronized void updateAudioEffector() {
        AppMethodBeat.i(222012);
        boolean z = false;
        if (this.mEnableBGMRecord || this.mAECType == 1) {
            z = true;
        }
        if (!z) {
            nativeSetReverbType(this.mReverbType);
            nativeSetChangerType(this.mVoiceChangerType);
            if (this.mIsMute) {
                nativeSetVolume(0.0f);
            } else {
                nativeSetVolume(this.mVolume);
            }
        }
        if (z) {
            nativeSetVolume(0.0f);
        }
        nativeEnableMixMode(z);
        nativeSetSpeedRate(this.mSpeedRate.get().floatValue());
        AppMethodBeat.o(222012);
    }

    public synchronized void setChangerType(int i2) {
        AppMethodBeat.i(222013);
        TXCLog.i(TAG, "setChangerType: ".concat(String.valueOf(i2)));
        this.mVoiceChangerType = i2;
        nativeSetChangerType(i2);
        AppMethodBeat.o(222013);
    }
}
