package com.tencent.thumbplayer.core.decoder;

import android.view.Surface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ITPMediaCodecDecoder {
    public static final int BOOL_ENABLE_ASYNC_MODE = 1;
    public static final int BOOL_ENABLE_MEDIACODEC_REUSE = 4;
    public static final int BOOL_ENABLE_SET_OUTPUT_SURFACE_API = 0;
    public static final int BOOL_SET_IS_ADTS = 2;
    public static final int BOOL_SET_IS_AUDIO_PASSTHROUGH = 3;
    public static final int BYTES_SET_CSD0_DATA = 200;
    public static final int BYTES_SET_CSD1_DATA = 201;
    public static final int BYTES_SET_CSD2_DATA = 202;
    public static final int OBJECT_SET_MEDIA_CRYPTO = 300;
    public static final int TP_CODEC_RETURN_CODE_EOS = 2;
    public static final int TP_CODEC_RETURN_CODE_ERROR = 3;
    public static final int TP_CODEC_RETURN_CODE_INTERNAL_RESET = 4;
    public static final int TP_CODEC_RETURN_CODE_OK = 0;
    public static final int TP_CODEC_RETURN_CODE_TRY_AGAIN = 1;
    public static final int TP_ERROR_DECODE_FAILED = 103;
    public static final int TP_ERROR_FLUSH_FAILED = 104;
    public static final int TP_ERROR_INVALID_CODECPAR = 100;
    public static final int TP_ERROR_NO_CODEC = 101;
    public static final int TP_ERROR_OPEN_FAILED = 102;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaCodecReturnCode {
    }

    int decode(byte[] bArr, boolean z, long j2, boolean z2);

    TPFrameInfo dequeueOutputBuffer();

    int flush();

    boolean initDecoder(String str, int i2, int i3, int i4, int i5);

    boolean initDecoder(String str, int i2, int i3, int i4, Surface surface, int i5, int i6, int i7);

    int release();

    int releaseOutputBuffer(int i2, boolean z);

    void setCryptoInfo(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3);

    int setOperateRate(float f2);

    int setOutputSurface(Surface surface);

    boolean setParamBool(int i2, boolean z);

    boolean setParamBytes(int i2, byte[] bArr);

    boolean setParamInt(int i2, int i3);

    boolean setParamLong(int i2, long j2);

    boolean setParamObject(int i2, Object obj);

    boolean setParamString(int i2, String str);

    int signalEndOfStream();

    boolean startDecoder();
}
