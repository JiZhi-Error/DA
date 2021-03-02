package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPUnitendCodecUtils;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmediacodec.b;
import com.tencent.tmediacodec.b.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class TPBaseMediaCodecDecoder implements ITPMediaCodecDecoder {
    private static final int MEDIA_CODEC_ERROR_INDEX = -1000;
    private static long MEDIA_CODEC_INPUT_TIMEOUT_US = 2000;
    private static long MEDIA_CODEC_OUTPUT_TIMEOUT_US = 2000;
    private static final int MSG_FLUSH = 1002;
    private static final int MSG_RELEASE = 1003;
    private static final int MSG_RELEASE_OUTPUT_BUFFER = 1000;
    private static final int MSG_SET_OUTPUT_SURFACE = 1001;
    private b mCodec = null;
    protected int mCodecId;
    private MediaCodec.CryptoInfo mCryptoInfo = null;
    private HandlerThread mDecodeThread = null;
    private AsyncDecodeHandler mDecoderHandler = null;
    protected int mDolbyVisionLevel = 0;
    protected int mDolbyVisionProfile = 0;
    protected int mDrmType = -1;
    protected boolean mEnableAsyncMode = false;
    private boolean mEnableAudioPassThrough = false;
    protected boolean mEnableMediaCodecReuse = false;
    private boolean mEnableSetOutputSurfaceApi = false;
    private TPFrameInfo mFrameInfo = new TPFrameInfo();
    private int mHandlerResult = 0;
    private BlockingQueue<Integer> mInputQueue = new LinkedBlockingQueue();
    private BlockingQueue<TPFrameInfo> mOutputQueue = new LinkedBlockingQueue();
    private boolean mRestartCodecOnException = false;
    private boolean mStarted = false;
    protected Surface mSurface = null;
    private final Object mThreadLock = new Object();

    /* access modifiers changed from: package-private */
    public abstract void configCodec(b bVar);

    /* access modifiers changed from: package-private */
    public abstract String getLogTag();

    /* access modifiers changed from: package-private */
    public abstract String getMimeType();

    /* access modifiers changed from: package-private */
    public abstract void processMediaCodecException(Exception exc);

    /* access modifiers changed from: package-private */
    public abstract void processOutputBuffer(b bVar, int i2, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo);

    /* access modifiers changed from: package-private */
    public abstract void processOutputConfigData(b bVar, int i2, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo);

    /* access modifiers changed from: package-private */
    public abstract void processOutputFormatChanged(MediaFormat mediaFormat);

    public TPBaseMediaCodecDecoder(int i2) {
        this.mCodecId = i2;
    }

    private boolean initMediaCodecInternal() {
        String name;
        boolean z;
        MediaCodec hps;
        try {
            MediaCodecInfo selectCodec = selectCodec(getMimeType());
            if (selectCodec == null) {
                TPNativeLog.printLog(3, getLogTag(), "initMediaCodec failed! no such codec by mime type: " + getMimeType());
                return false;
            }
            if (getMimeType().equals("audio/vnd.dts")) {
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec current mime type:" + getMimeType() + " is audio dts, need set input timeout to 0!");
                MEDIA_CODEC_INPUT_TIMEOUT_US = 0;
                MEDIA_CODEC_OUTPUT_TIMEOUT_US = 0;
            }
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec mime:" + getMimeType() + " profile:" + this.mDolbyVisionProfile + " level:" + this.mDolbyVisionLevel + " mDrmType:" + this.mDrmType);
            if (this.mDolbyVisionProfile > 0) {
                String dolbyVisionDecoderName = TPUnitendCodecUtils.getDolbyVisionDecoderName(getMimeType(), this.mDolbyVisionProfile, this.mDolbyVisionLevel, 2 == this.mDrmType);
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec Dolby Vision codecName:".concat(String.valueOf(dolbyVisionDecoderName)));
                name = dolbyVisionDecoderName;
            } else if (2 == this.mDrmType) {
                name = TPUnitendCodecUtils.getSecureDecoderName(getMimeType());
            } else {
                name = selectCodec.getName();
            }
            if (name == null) {
                TPNativeLog.printLog(4, getLogTag(), "initMediaCodec failed, codecName is null.");
                return false;
            }
            this.mCodec = new b(name, b.EnumC2217b.CreateByName);
            b bVar = this.mCodec;
            if (!this.mEnableMediaCodecReuse || this.mEnableAsyncMode) {
                z = false;
            } else {
                z = true;
            }
            bVar.Slo = z;
            this.mCodec.Slm = new com.tencent.tmediacodec.a.b() {
                /* class com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder.AnonymousClass1 */

                @Override // com.tencent.tmediacodec.a.a, com.tencent.tmediacodec.a.b
                public void onStarted(Boolean bool, String str) {
                    AppMethodBeat.i(189882);
                    super.onStarted(bool, str);
                    TPMediaCodecManager.onMediaCodecReady(TPBaseMediaCodecDecoder.this.mCodecId, str);
                    AppMethodBeat.o(189882);
                }

                @Override // com.tencent.tmediacodec.a.a, com.tencent.tmediacodec.a.b
                public void onReuseCodecAPIException(String str, Throwable th) {
                    AppMethodBeat.i(189883);
                    super.onReuseCodecAPIException(str, th);
                    TPMediaCodecManager.onMediaCodecException(TPBaseMediaCodecDecoder.this.mCodecId, str);
                    AppMethodBeat.o(189883);
                }
            };
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec codec name: ".concat(String.valueOf(name)));
            if (this.mEnableAsyncMode && Build.VERSION.SDK_INT >= 23) {
                TPNativeLog.printLog(2, getLogTag(), "MediaCodec EnableAsyncMode！");
                this.mDecodeThread = new HandlerThread("MediaCodecThread");
                this.mDecodeThread.start();
                this.mDecoderHandler = new AsyncDecodeHandler(this.mDecodeThread.getLooper());
                b bVar2 = this.mCodec;
                BufferCallback bufferCallback = new BufferCallback();
                AsyncDecodeHandler asyncDecodeHandler = this.mDecoderHandler;
                if (Build.VERSION.SDK_INT < 23) {
                    com.tencent.tmediacodec.g.b.bqS("TMediaCodec");
                } else if (!(bVar2.Sll == null || (hps = bVar2.Sll.hps()) == null)) {
                    hps.setCallback(new b.c(bVar2, bufferCallback), asyncDecodeHandler);
                }
            }
            configCodec(this.mCodec);
            this.mCodec.start();
            this.mStarted = true;
            return true;
        } catch (Exception e2) {
            TPNativeLog.printLog(4, getLogTag(), getStackTrace(e2));
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean startDecoder() {
        return initMediaCodecInternal();
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int decode(byte[] bArr, boolean z, long j2, boolean z2) {
        if (!this.mStarted || this.mCodec == null) {
            return 101;
        }
        if (!this.mEnableAsyncMode || Build.VERSION.SDK_INT < 23) {
            return queueInputBuffer(bArr, j2, z2);
        }
        return decodeAsync(bArr, z, j2, z2);
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public void setCryptoInfo(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3) {
        if (this.mCryptoInfo == null) {
            this.mCryptoInfo = new MediaCodec.CryptoInfo();
        }
        this.mCryptoInfo.set(i2, iArr, iArr2, bArr, bArr2, i3);
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int setOutputSurface(Surface surface) {
        if (this.mEnableAsyncMode) {
            return setOutputSurfaceAsync(surface);
        }
        return handleSetOutputSurface(surface);
    }

    private int handleSetOutputSurface(Surface surface) {
        TPNativeLog.printLog(2, getLogTag(), "setOutputSurface: ".concat(String.valueOf(surface)));
        if (this.mSurface == surface) {
            TPNativeLog.printLog(3, getLogTag(), "setOutputSurface: set the same surface.");
            return 0;
        }
        Surface surface2 = this.mSurface;
        this.mSurface = surface;
        if (this.mCodec == null) {
            return 0;
        }
        if (!(surface2 == null || surface == null)) {
            try {
                if (surface.isValid() && Build.VERSION.SDK_INT >= 23 && this.mEnableSetOutputSurfaceApi) {
                    b bVar = this.mCodec;
                    if (bVar.Sll == null) {
                        return 0;
                    }
                    bVar.Sll.setOutputSurface(surface);
                    return 0;
                }
            } catch (Exception e2) {
                TPNativeLog.printLog(4, getLogTag(), "setOutputSurface onMediaCodecException:\n" + getStackTrace(e2));
                return 3;
            }
        }
        return 3;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int releaseOutputBuffer(int i2, boolean z) {
        if (this.mCodec == null || i2 < 0) {
            return 3;
        }
        if (this.mEnableAsyncMode) {
            return releaseOutputBufferAsync(i2, z);
        }
        return handleReleaseOutputBuffer(i2, z);
    }

    private int handleReleaseOutputBuffer(int i2, boolean z) {
        if (this.mCodec == null || i2 < 0) {
            return 3;
        }
        try {
            this.mCodec.releaseOutputBuffer(i2, z);
            return 0;
        } catch (Exception e2) {
            return onMediaCodecException(e2);
        }
    }

    private int queueInputBuffer(byte[] bArr, long j2, boolean z) {
        ByteBuffer[] byteBufferArr;
        MediaCodec hps;
        b bVar = this.mCodec;
        if (bVar.Sll == null || (hps = bVar.Sll.hps()) == null) {
            byteBufferArr = null;
        } else {
            byteBufferArr = hps.getInputBuffers();
        }
        try {
            int dequeueInputBuffer = this.mCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
            if (dequeueInputBuffer >= 0) {
                byteBufferArr[dequeueInputBuffer].put(bArr);
                if (!z || this.mCryptoInfo == null) {
                    this.mCodec.a(dequeueInputBuffer, bArr.length, j2, 0);
                } else {
                    this.mCodec.a(dequeueInputBuffer, this.mCryptoInfo, j2, 0);
                }
                return 0;
            } else if (dequeueInputBuffer == -1) {
                return 1;
            } else {
                return 103;
            }
        } catch (Exception e2) {
            return onMediaCodecException(e2);
        }
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public TPFrameInfo dequeueOutputBuffer() {
        int i2;
        MediaFormat mediaFormat;
        MediaCodec hps;
        if (this.mCodec == null) {
            return this.mFrameInfo;
        }
        resetFrameInfo();
        if (this.mEnableAsyncMode) {
            return dequeueOutputBufferAsync();
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        try {
            b bVar = this.mCodec;
            long j2 = MEDIA_CODEC_OUTPUT_TIMEOUT_US;
            if (bVar.Sll != null) {
                i2 = bVar.Sll.dequeueOutputBuffer(bufferInfo, j2);
            } else {
                i2 = -1000;
            }
            if (i2 >= 0) {
                if (bufferInfo.flags == 4) {
                    TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM");
                    this.mFrameInfo.errCode = 2;
                } else if (bufferInfo.flags != 2 || !this.mEnableAudioPassThrough) {
                    this.mFrameInfo.bufferIndex = i2;
                    this.mFrameInfo.ptsUs = bufferInfo.presentationTimeUs;
                    this.mFrameInfo.errCode = 0;
                    processOutputBuffer(this.mCodec, i2, bufferInfo, this.mFrameInfo);
                } else {
                    TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_CODEC_CONFIG, AudioPassThrough");
                    this.mFrameInfo.bufferIndex = i2;
                    this.mFrameInfo.ptsUs = bufferInfo.presentationTimeUs;
                    processOutputConfigData(this.mCodec, i2, bufferInfo, this.mFrameInfo);
                }
            } else if (i2 == -2) {
                b bVar2 = this.mCodec;
                if (bVar2.Sll == null || (hps = bVar2.Sll.hps()) == null) {
                    mediaFormat = null;
                } else {
                    mediaFormat = hps.getOutputFormat();
                }
                processOutputFormatChanged(mediaFormat);
                this.mFrameInfo.errCode = 1;
            } else if (i2 == -1) {
                this.mFrameInfo.errCode = 1;
            } else if (i2 == -3) {
                TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: INFO_OUTPUT_BUFFERS_CHANGED!");
                this.mFrameInfo.errCode = 1;
            } else if (bufferInfo.flags == 4) {
                TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM!");
                this.mFrameInfo.errCode = 2;
            } else {
                TPNativeLog.printLog(4, getLogTag(), "dequeueOutputBuffer: TP_ERROR_DECODE_FAILED! index = ".concat(String.valueOf(i2)));
                this.mFrameInfo.errCode = 103;
            }
            return this.mFrameInfo;
        } catch (Exception e2) {
            this.mFrameInfo.errCode = onMediaCodecException(e2);
            return this.mFrameInfo;
        }
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int signalEndOfStream() {
        TPNativeLog.printLog(2, getLogTag(), "signalEndOfStream: ");
        if (this.mCodec == null) {
            return 3;
        }
        if (this.mEnableAsyncMode) {
            return signalEndOfStreamAsync();
        }
        int dequeueInputBuffer = this.mCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
        if (dequeueInputBuffer >= 0) {
            return handleSignalEndOfStream(dequeueInputBuffer);
        }
        if (dequeueInputBuffer == -1) {
            return 1;
        }
        return 3;
    }

    private int handleSignalEndOfStream(int i2) {
        try {
            this.mCodec.a(i2, 0, 0, 4);
            return 0;
        } catch (Exception e2) {
            TPNativeLog.printLog(4, getLogTag(), "handleSignalEndOfStream: failed!" + getStackTrace(e2));
            return 3;
        }
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int flush() {
        TPNativeLog.printLog(2, getLogTag(), "flush: ");
        if (this.mCodec == null) {
            return 104;
        }
        if (this.mEnableAsyncMode) {
            return flushAsync();
        }
        return handleFlush();
    }

    private int handleFlush() {
        TPNativeLog.printLog(2, getLogTag(), "handleFlush: ");
        if (this.mCodec == null) {
            return 104;
        }
        try {
            b bVar = this.mCodec;
            if (bVar.Sll != null) {
                bVar.Sll.flush();
            }
            return 0;
        } catch (Exception e2) {
            return onMediaCodecException(e2);
        }
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int release() {
        if (this.mEnableAsyncMode) {
            return releaseAsync();
        }
        return handleRelease();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int handleRelease() {
        if (this.mCodec == null) {
            return 101;
        }
        this.mStarted = false;
        try {
            b bVar = this.mCodec;
            if (bVar.Sll != null) {
                bVar.Sll.stop();
            }
            b bVar2 = this.mCodec;
            if (bVar2.Sll != null) {
                bVar2.Sll.release();
            }
            this.mCodec = null;
            return 0;
        } catch (Exception e2) {
            TPNativeLog.printLog(4, getLogTag(), "release: failed!" + getStackTrace(e2));
            this.mCodec = null;
            return 3;
        } catch (Throwable th) {
            this.mCodec = null;
            throw th;
        }
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamBool(int i2, boolean z) {
        switch (i2) {
            case 0:
                this.mEnableSetOutputSurfaceApi = z;
                break;
            case 1:
                if (this.mStarted) {
                    TPNativeLog.printLog(3, getLogTag(), "BOOL_ENABLE_ASYNC_MODE must setup before started!");
                    break;
                } else {
                    this.mEnableAsyncMode = z;
                    break;
                }
            case 2:
            default:
                TPNativeLog.printLog(3, getLogTag(), "Unknown paramKey: ".concat(String.valueOf(i2)));
                return false;
            case 3:
                this.mEnableAudioPassThrough = z;
                TPNativeLog.printLog(2, getLogTag(), "BOOL_SET_IS_AUDIO_PASSTHROUGH mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
                break;
            case 4:
                this.mEnableMediaCodecReuse = z;
                break;
        }
        return true;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int setOperateRate(float f2) {
        MediaCodec hps;
        if (this.mCodec != null) {
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    TPNativeLog.printLog(2, getLogTag(), "setOperateRate: ".concat(String.valueOf(f2)));
                    Bundle bundle = new Bundle();
                    bundle.putShort(DownloadInfo.PRIORITY, 0);
                    bundle.putFloat("operating-rate", f2);
                    c cVar = this.mCodec.Sll;
                    if (!(cVar == null || (hps = cVar.hps()) == null)) {
                        hps.setParameters(bundle);
                    }
                }
            } catch (Exception e2) {
                TPNativeLog.printLog(3, getLogTag(), "setOperateRate: " + f2 + " failed.");
            }
        }
        return 0;
    }

    private int onMediaCodecException(Exception exc) {
        TPNativeLog.printLog(4, getLogTag(), "onMediaCodecException!\n" + getStackTrace(exc));
        resetFrameInfo();
        processMediaCodecException(exc);
        if (this.mRestartCodecOnException) {
            initMediaCodecInternal();
            return 4;
        }
        release();
        return 103;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamInt(int i2, int i3) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamLong(int i2, long j2) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamString(int i2, String str) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamBytes(int i2, byte[] bArr) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamObject(int i2, Object obj) {
        return false;
    }

    private void resetFrameInfo() {
        this.mFrameInfo.bufferIndex = -1000;
        this.mFrameInfo.ptsUs = -1;
        this.mFrameInfo.data = null;
        this.mFrameInfo.errCode = 103;
    }

    private int decodeAsync(byte[] bArr, boolean z, long j2, boolean z2) {
        ByteBuffer byteBuffer;
        int i2;
        Integer poll = this.mInputQueue.poll();
        if (poll == null) {
            return 1;
        }
        try {
            b bVar = this.mCodec;
            int intValue = poll.intValue();
            if (bVar.Sll != null) {
                byteBuffer = bVar.Sll.hps().getInputBuffer(intValue);
            } else {
                byteBuffer = null;
            }
            if (byteBuffer != null) {
                byteBuffer.put(bArr);
            }
            if (!z2 || this.mCryptoInfo == null) {
                b bVar2 = this.mCodec;
                int intValue2 = poll.intValue();
                int length = bArr.length;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                bVar2.a(intValue2, length, j2, i2);
            } else {
                this.mCodec.a(poll.intValue(), this.mCryptoInfo, j2, z ? 1 : 0);
            }
            return 0;
        } catch (Exception e2) {
            return onMediaCodecException(e2);
        }
    }

    private TPFrameInfo dequeueOutputBufferAsync() {
        this.mFrameInfo.errCode = 1;
        TPFrameInfo poll = this.mOutputQueue.poll();
        return poll == null ? this.mFrameInfo : poll;
    }

    private int signalEndOfStreamAsync() {
        Integer poll = this.mInputQueue.poll();
        if (poll == null) {
            return 1;
        }
        return handleSignalEndOfStream(poll.intValue());
    }

    private int releaseOutputBufferAsync(int i2, boolean z) {
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1000;
        obtainMessage.arg1 = i2;
        obtainMessage.arg2 = z ? 1 : 0;
        return waitingForHandleMessage(obtainMessage);
    }

    private int setOutputSurfaceAsync(Surface surface) {
        TPNativeLog.printLog(2, getLogTag(), "setOutputSurfaceAsync: ".concat(String.valueOf(surface)));
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1001;
        obtainMessage.obj = surface;
        return waitingForHandleMessage(obtainMessage);
    }

    private int flushAsync() {
        TPNativeLog.printLog(2, getLogTag(), "flushAsync: ");
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1002;
        return waitingForHandleMessage(obtainMessage);
    }

    private int releaseAsync() {
        TPNativeLog.printLog(2, getLogTag(), "releaseAsync: ");
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1003;
        int waitingForHandleMessage = waitingForHandleMessage(obtainMessage);
        exitDecodeThread();
        return waitingForHandleMessage;
    }

    private void exitDecodeThread() {
        if (this.mDecodeThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.mDecodeThread.quitSafely();
            } else {
                this.mDecodeThread.quit();
            }
            try {
                this.mDecodeThread.join();
            } catch (InterruptedException e2) {
            }
        }
    }

    private int waitingForHandleMessage(Message message) {
        synchronized (this.mThreadLock) {
            message.sendToTarget();
            try {
                this.mThreadLock.wait();
            } catch (InterruptedException e2) {
            }
        }
        return this.mHandlerResult;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleMessageComplete(int i2) {
        this.mHandlerResult = i2;
        this.mThreadLock.notify();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int onReleaseOutputBuffer(int i2, boolean z) {
        return handleReleaseOutputBuffer(i2, z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int onSetOutputSurface(Surface surface) {
        return handleSetOutputSurface(surface);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int onFlush() {
        this.mInputQueue.clear();
        this.mOutputQueue.clear();
        int handleFlush = handleFlush();
        this.mCodec.start();
        return handleFlush;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int onRelease() {
        this.mInputQueue.clear();
        this.mOutputQueue.clear();
        return handleRelease();
    }

    /* access modifiers changed from: package-private */
    public class BufferCallback extends b.a {
        private BufferCallback() {
        }

        @Override // com.tencent.tmediacodec.b.a
        public void onInputBufferAvailable(b bVar, int i2) {
            AppMethodBeat.i(189885);
            try {
                TPBaseMediaCodecDecoder.this.mInputQueue.put(Integer.valueOf(i2));
                AppMethodBeat.o(189885);
            } catch (Exception e2) {
                TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(e2));
                AppMethodBeat.o(189885);
            }
        }

        @Override // com.tencent.tmediacodec.b.a
        public void onOutputBufferAvailable(b bVar, int i2, MediaCodec.BufferInfo bufferInfo) {
            AppMethodBeat.i(189886);
            try {
                TPFrameInfo tPFrameInfo = new TPFrameInfo();
                tPFrameInfo.errCode = 0;
                tPFrameInfo.bufferIndex = i2;
                tPFrameInfo.ptsUs = bufferInfo.presentationTimeUs;
                TPBaseMediaCodecDecoder.this.processOutputBuffer(bVar, i2, bufferInfo, tPFrameInfo);
                TPBaseMediaCodecDecoder.this.mOutputQueue.put(tPFrameInfo);
                AppMethodBeat.o(189886);
            } catch (Exception e2) {
                TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(e2));
                AppMethodBeat.o(189886);
            }
        }

        @Override // com.tencent.tmediacodec.b.a
        public void onError(b bVar, MediaCodec.CodecException codecException) {
            AppMethodBeat.i(189887);
            TPNativeLog.printLog(4, TPBaseMediaCodecDecoder.this.getLogTag(), "onError: " + TPBaseMediaCodecDecoder.this.getStackTrace(codecException));
            TPBaseMediaCodecDecoder.this.handleRelease();
            AppMethodBeat.o(189887);
        }

        @Override // com.tencent.tmediacodec.b.a
        public void onOutputFormatChanged(b bVar, MediaFormat mediaFormat) {
            AppMethodBeat.i(189888);
            TPBaseMediaCodecDecoder.this.processOutputFormatChanged(mediaFormat);
            AppMethodBeat.o(189888);
        }
    }

    /* access modifiers changed from: package-private */
    public class AsyncDecodeHandler extends Handler {
        AsyncDecodeHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i2 = 0;
            boolean z = false;
            AppMethodBeat.i(189884);
            synchronized (TPBaseMediaCodecDecoder.this.mThreadLock) {
                try {
                    switch (message.what) {
                        case 1000:
                            TPBaseMediaCodecDecoder tPBaseMediaCodecDecoder = TPBaseMediaCodecDecoder.this;
                            int i3 = message.arg1;
                            if (message.arg2 == 1) {
                                z = true;
                            }
                            i2 = tPBaseMediaCodecDecoder.onReleaseOutputBuffer(i3, z);
                            break;
                        case 1001:
                            i2 = TPBaseMediaCodecDecoder.this.onSetOutputSurface((Surface) message.obj);
                            break;
                        case 1002:
                            i2 = TPBaseMediaCodecDecoder.this.onFlush();
                            break;
                        case 1003:
                            i2 = TPBaseMediaCodecDecoder.this.onRelease();
                            break;
                    }
                    TPBaseMediaCodecDecoder.this.handleMessageComplete(i2);
                } finally {
                    AppMethodBeat.o(189884);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (!codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }
}
