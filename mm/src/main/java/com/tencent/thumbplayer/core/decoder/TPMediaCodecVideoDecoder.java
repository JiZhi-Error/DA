package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.tmediacodec.b;
import java.nio.ByteBuffer;

public class TPMediaCodecVideoDecoder extends TPBaseMediaCodecDecoder {
    private static final String DEVICE_NAME_VIVO_X5L = "vivo X5L";
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final String TAG = "TPMediaCodecVideoDecode";
    private int mCropBottom = 0;
    private int mCropLeft = 0;
    private int mCropRight = 0;
    private int mCropTop = 0;
    private byte[] mCsd0Data = null;
    private byte[] mCsd1Data = null;
    private byte[] mCsd2Data = null;
    private MediaCrypto mMediaCrypto = null;
    private String mMimeType = null;
    private int mRotation = 0;
    private int mVideoHeight = 0;
    private int mVideoWidth = 0;

    public TPMediaCodecVideoDecoder(int i2) {
        super(i2);
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean initDecoder(String str, int i2, int i3, int i4, Surface surface, int i5, int i6, int i7) {
        this.mMimeType = str;
        this.mVideoWidth = i2;
        this.mVideoHeight = i3;
        this.mRotation = i4;
        this.mSurface = surface;
        this.mDrmType = i5;
        this.mDolbyVisionProfile = i6;
        this.mDolbyVisionLevel = i7;
        return true;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean initDecoder(String str, int i2, int i3, int i4, int i5) {
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
        MediaCodec hps;
        AppMethodBeat.i(189922);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.mMimeType, this.mVideoWidth, this.mVideoHeight);
        if (Build.VERSION.SDK_INT > 22) {
            createVideoFormat.setInteger("rotation-degrees", this.mRotation);
        }
        if (TPSystemInfo.getDeviceName().equalsIgnoreCase(DEVICE_NAME_VIVO_X5L)) {
            createVideoFormat.setInteger("max-input-size", this.mVideoWidth * this.mVideoHeight);
        }
        if (this.mCsd0Data != null) {
            createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(this.mCsd0Data));
        }
        if (this.mCsd1Data != null) {
            createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(this.mCsd1Data));
        }
        if (this.mCsd2Data != null) {
            createVideoFormat.setByteBuffer("csd-2", ByteBuffer.wrap(this.mCsd2Data));
        }
        bVar.a(createVideoFormat, this.mSurface, this.mMediaCrypto);
        if (!(bVar.Sll == null || (hps = bVar.Sll.hps()) == null)) {
            hps.setVideoScalingMode(1);
        }
        AppMethodBeat.o(189922);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public void processOutputConfigData(b bVar, int i2, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        AppMethodBeat.i(189923);
        tPFrameInfo.errCode = 0;
        processOutputBuffer(bVar, i2, bufferInfo, tPFrameInfo);
        AppMethodBeat.o(189923);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public void processOutputFormatChanged(MediaFormat mediaFormat) {
        AppMethodBeat.i(189924);
        boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
        this.mVideoWidth = mediaFormat.getInteger("width");
        this.mVideoHeight = mediaFormat.getInteger("height");
        if (z) {
            this.mCropLeft = mediaFormat.getInteger(KEY_CROP_LEFT);
            this.mCropRight = mediaFormat.getInteger(KEY_CROP_RIGHT);
            this.mCropTop = mediaFormat.getInteger(KEY_CROP_TOP);
            this.mCropBottom = mediaFormat.getInteger(KEY_CROP_BOTTOM);
        }
        TPNativeLog.printLog(2, TAG, "processOutputFormatChanged: mVideoWidth: " + this.mVideoWidth + ", mVideoHeight: " + this.mVideoHeight + ", mCropLeft: " + this.mCropLeft + ", mCropRight: " + this.mCropRight + ", mCropTop: " + this.mCropTop + ", mCropBottom: " + this.mCropBottom);
        AppMethodBeat.o(189924);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public void processOutputBuffer(b bVar, int i2, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        tPFrameInfo.width = this.mVideoWidth;
        tPFrameInfo.height = this.mVideoHeight;
        tPFrameInfo.cropLeft = this.mCropLeft;
        tPFrameInfo.cropRight = this.mCropRight;
        tPFrameInfo.cropTop = this.mCropTop;
        tPFrameInfo.cropBottom = this.mCropBottom;
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
    public int setOutputSurface(Surface surface) {
        AppMethodBeat.i(189925);
        int outputSurface = super.setOutputSurface(surface);
        AppMethodBeat.o(189925);
        return outputSurface;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public boolean setParamBytes(int i2, byte[] bArr) {
        AppMethodBeat.i(189926);
        if (i2 == 200) {
            this.mCsd0Data = bArr;
        } else if (i2 == 201) {
            this.mCsd1Data = bArr;
        } else if (i2 == 202) {
            this.mCsd2Data = bArr;
        }
        boolean paramBytes = super.setParamBytes(i2, bArr);
        AppMethodBeat.o(189926);
        return paramBytes;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public boolean setParamObject(int i2, Object obj) {
        AppMethodBeat.i(189927);
        if (i2 == 300) {
            this.mMediaCrypto = (MediaCrypto) obj;
            AppMethodBeat.o(189927);
            return true;
        }
        boolean paramObject = super.setParamObject(i2, obj);
        AppMethodBeat.o(189927);
        return paramObject;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public int setOperateRate(float f2) {
        AppMethodBeat.i(189928);
        int operateRate = super.setOperateRate(f2);
        AppMethodBeat.o(189928);
        return operateRate;
    }
}
