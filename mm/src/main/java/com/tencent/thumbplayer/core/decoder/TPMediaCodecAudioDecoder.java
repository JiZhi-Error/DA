package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.tmediacodec.b;
import java.nio.ByteBuffer;

public class TPMediaCodecAudioDecoder extends TPBaseMediaCodecDecoder {
    private static final String TAG = "TPMediaCodecAudioDecoder";
    private int mAudioFormat = 0;
    private int mChannelCount = 0;
    private byte[] mCsd0Data = null;
    private boolean mEnableAudioPassThrough = false;
    private boolean mIsAdts = false;
    private MediaCrypto mMediaCrypto = null;
    private String mMimeType = null;
    private int mSampleRate = 0;

    public TPMediaCodecAudioDecoder(int i2) {
        super(i2);
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean initDecoder(String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(189889);
        TPNativeLog.printLog(2, TAG, "initDecoder, mimeType:" + str + " sampleRate:" + i2 + " channelCount:" + i3 + " drmType:" + i4 + " audioFormat:" + i5);
        this.mMimeType = str;
        this.mSampleRate = i2;
        this.mChannelCount = i3;
        this.mDrmType = i4;
        this.mAudioFormat = i5;
        AppMethodBeat.o(189889);
        return true;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean initDecoder(String str, int i2, int i3, int i4, Surface surface, int i5, int i6, int i7) {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public String getMimeType() {
        return this.mMimeType;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public void configCodec(b bVar) {
        AppMethodBeat.i(189890);
        TPNativeLog.printLog(2, TAG, "configCodec: ");
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannelCount);
        if (this.mCsd0Data != null) {
            createAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(this.mCsd0Data));
        }
        if (this.mIsAdts) {
            TPNativeLog.printLog(2, TAG, "configCodec: set is adts");
            createAudioFormat.setInteger("is-adts", 1);
        }
        bVar.a(createAudioFormat, null, this.mMediaCrypto);
        AppMethodBeat.o(189890);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public void processOutputConfigData(b bVar, int i2, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        AppMethodBeat.i(189891);
        bVar.releaseOutputBuffer(i2, false);
        tPFrameInfo.errCode = 1;
        AppMethodBeat.o(189891);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public void processOutputFormatChanged(MediaFormat mediaFormat) {
        Exception e2;
        int i2;
        AppMethodBeat.i(189892);
        try {
            if (mediaFormat.containsKey("sample-rate")) {
                this.mSampleRate = mediaFormat.getInteger("sample-rate");
            }
            if (mediaFormat.containsKey("channel-count")) {
                this.mChannelCount = mediaFormat.getInteger("channel-count");
            }
            if (Build.VERSION.SDK_INT < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                i2 = 2;
                TPNativeLog.printLog(2, TAG, "processOutputFormatChanged, mEnableAudioPassThrough:" + this.mEnableAudioPassThrough + ", mSampleRate: " + this.mSampleRate + ", mChannelCount: " + this.mChannelCount + " mAudioFormat: " + this.mAudioFormat + " pcmFormat:" + i2);
                AppMethodBeat.o(189892);
            }
            i2 = mediaFormat.getInteger("pcm-encoding");
            try {
                TPNativeLog.printLog(2, TAG, "processOutputFormatChanged: MediaFormat.KEY_PCM_ENCODING: ".concat(String.valueOf(i2)));
            } catch (Exception e3) {
                e2 = e3;
                TPNativeLog.printLog(4, TAG, "processOutputFormatChanged got one exception: " + getStackTrace(e2));
                TPNativeLog.printLog(2, TAG, "processOutputFormatChanged, mEnableAudioPassThrough:" + this.mEnableAudioPassThrough + ", mSampleRate: " + this.mSampleRate + ", mChannelCount: " + this.mChannelCount + " mAudioFormat: " + this.mAudioFormat + " pcmFormat:" + i2);
                AppMethodBeat.o(189892);
            }
            TPNativeLog.printLog(2, TAG, "processOutputFormatChanged, mEnableAudioPassThrough:" + this.mEnableAudioPassThrough + ", mSampleRate: " + this.mSampleRate + ", mChannelCount: " + this.mChannelCount + " mAudioFormat: " + this.mAudioFormat + " pcmFormat:" + i2);
            AppMethodBeat.o(189892);
        } catch (Exception e4) {
            e2 = e4;
            i2 = 2;
            TPNativeLog.printLog(4, TAG, "processOutputFormatChanged got one exception: " + getStackTrace(e2));
            TPNativeLog.printLog(2, TAG, "processOutputFormatChanged, mEnableAudioPassThrough:" + this.mEnableAudioPassThrough + ", mSampleRate: " + this.mSampleRate + ", mChannelCount: " + this.mChannelCount + " mAudioFormat: " + this.mAudioFormat + " pcmFormat:" + i2);
            AppMethodBeat.o(189892);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public void processOutputBuffer(b bVar, int i2, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        ByteBuffer[] byteBufferArr;
        ByteBuffer byteBuffer;
        MediaCodec hps;
        MediaCodec hps2;
        byte[] bArr = null;
        AppMethodBeat.i(189893);
        tPFrameInfo.sampleRate = this.mSampleRate;
        tPFrameInfo.channelCount = this.mChannelCount;
        tPFrameInfo.format = this.mAudioFormat;
        if (Build.VERSION.SDK_INT < 21) {
            if (bVar.Sll == null || (hps = bVar.Sll.hps()) == null) {
                byteBufferArr = null;
            } else {
                byteBufferArr = hps.getOutputBuffers();
            }
            byteBuffer = byteBufferArr[i2];
        } else if (bVar.Sll == null || (hps2 = bVar.Sll.hps()) == null) {
            byteBuffer = null;
        } else {
            byteBuffer = hps2.getOutputBuffer(i2);
        }
        if (byteBuffer != null) {
            bArr = new byte[bufferInfo.size];
            byteBuffer.get(bArr, bufferInfo.offset, bufferInfo.size);
        }
        tPFrameInfo.data = bArr;
        if (bufferInfo.flags == 4 && bufferInfo.size <= 0) {
            TPNativeLog.printLog(2, TAG, "processOutputBuffer: bufferInfo.flags is BUFFER_FLAG_END_OF_STREAM, return EOS!");
            tPFrameInfo.errCode = 2;
        }
        bVar.releaseOutputBuffer(i2, false);
        AppMethodBeat.o(189893);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public void processMediaCodecException(Exception exc) {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public boolean setParamBool(int i2, boolean z) {
        AppMethodBeat.i(189894);
        if (i2 == 2) {
            this.mIsAdts = z;
            AppMethodBeat.o(189894);
            return true;
        } else if (i2 == 3) {
            this.mEnableAudioPassThrough = z;
            TPNativeLog.printLog(2, getLogTag(), "setParamBool mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
            AppMethodBeat.o(189894);
            return true;
        } else {
            boolean paramBool = super.setParamBool(i2, z);
            AppMethodBeat.o(189894);
            return paramBool;
        }
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public boolean setParamBytes(int i2, byte[] bArr) {
        AppMethodBeat.i(189895);
        if (i2 == 200) {
            this.mCsd0Data = bArr;
        }
        boolean paramBytes = super.setParamBytes(i2, bArr);
        AppMethodBeat.o(189895);
        return paramBytes;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public boolean setParamObject(int i2, Object obj) {
        AppMethodBeat.i(189896);
        if (i2 == 300) {
            this.mMediaCrypto = (MediaCrypto) obj;
            AppMethodBeat.o(189896);
            return true;
        }
        boolean paramObject = super.setParamObject(i2, obj);
        AppMethodBeat.o(189896);
        return paramObject;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public int setOperateRate(float f2) {
        AppMethodBeat.i(189897);
        int operateRate = super.setOperateRate(f2);
        AppMethodBeat.o(189897);
        return operateRate;
    }
}
