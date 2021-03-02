package com.tencent.thumbplayer.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TPCommonEnum {
    public static final int MEDIA_TYPE_ATTACHMENT = 4;
    public static final int MEDIA_TYPE_AUDIO = 1;
    public static final int MEDIA_TYPE_DATA = 2;
    public static final int MEDIA_TYPE_SUBTITLE = 3;
    public static final int MEDIA_TYPE_UNKNOWN = -1;
    public static final int MEDIA_TYPE_VIDEO = 0;
    public static final int PLAYER_DESC_ID_ANDROIDPLAYER = 1;
    public static final int PLAYER_DESC_ID_THUMBPLAYER = 2;
    public static final int PLAYER_DESC_ID_THUMBPLAYER_SOFT = 3;
    public static final int PLAYER_DESC_ID_UNKNOWN = 0;
    public static final int TP_AUDIO_DECODER_FFMPEG = 1;
    public static final int TP_AUDIO_DECODER_MEDIACODEC = 2;
    public static final int TP_AUDIO_RENDERER_TYPE_AAUDIO = 2;
    public static final int TP_AUDIO_RENDERER_TYPE_AUDIOTRACK = 1;
    public static final int TP_AUDIO_RENDERER_TYPE_OBOE = 3;
    public static final int TP_AUDIO_RENDERER_TYPE_OPENAL = 5;
    public static final int TP_AUDIO_RENDERER_TYPE_OPENSL = 4;
    public static final int TP_AUDIO_SAMPLE_FORMAT_DBL = 4;
    public static final int TP_AUDIO_SAMPLE_FORMAT_DBLP = 9;
    public static final int TP_AUDIO_SAMPLE_FORMAT_FLT = 3;
    public static final int TP_AUDIO_SAMPLE_FORMAT_FLTP = 8;
    public static final int TP_AUDIO_SAMPLE_FORMAT_NONE = -1;
    public static final int TP_AUDIO_SAMPLE_FORMAT_S16 = 1;
    public static final int TP_AUDIO_SAMPLE_FORMAT_S16P = 6;
    public static final int TP_AUDIO_SAMPLE_FORMAT_S32 = 2;
    public static final int TP_AUDIO_SAMPLE_FORMAT_S32P = 7;
    public static final int TP_AUDIO_SAMPLE_FORMAT_S64 = 10;
    public static final int TP_AUDIO_SAMPLE_FORMAT_S64P = 11;
    public static final int TP_AUDIO_SAMPLE_FORMAT_U8 = 0;
    public static final int TP_AUDIO_SAMPLE_FORMAT_U8P = 5;
    public static final int TP_DECODER_UNKNOWN = -1;
    public static final int TP_DRM_TYPE_CHINADRM_HW = 2;
    public static final int TP_DRM_TYPE_SELF_CHINADRM = 3;
    public static final int TP_DRM_TYPE_WIDEVINE_HW = 0;
    public static final int TP_DRM_TYPE_WIDEVINE_SW = 1;
    public static final int TP_HDR_TYPE_HDR10 = 0;
    public static final int TP_HDR_TYPE_HDR10PLUS = 1;
    public static final int TP_HDR_TYPE_HDRDOLBYVISION = 2;
    public static final int TP_HDR_TYPE_HDRHLG = 3;
    public static final int TP_RENDERER_TYPE_NONE = -1;
    public static final int TP_VCODEC_TYPE_AVS3 = 192;
    public static final int TP_VCODEC_TYPE_H264 = 26;
    public static final int TP_VCODEC_TYPE_HEVC = 172;
    public static final int TP_VCODEC_TYPE_UKNOW = 0;
    public static final int TP_VIDEO_DECODER_FFMPEG = 101;
    public static final int TP_VIDEO_DECODER_MEDIACODEC = 102;
    public static final int TP_VIDEO_OUTPUT_FORMAT_NONE = -1;
    public static final int TP_VIDEO_OUTPUT_FORMAT_RGB565 = 37;
    public static final int TP_VIDEO_OUTPUT_FORMAT_RGBA = 26;
    public static final int TP_VIDEO_OUTPUT_FORMAT_YUV420P = 0;
    public static final int TP_VIDEO_OUTPUT_FORMAT_YUVJ420P = 12;
    public static final int TP_VIDEO_RENDERER_TYPE_OPENGL = 101;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MEDIA_TYPE {
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NativeConnectionAction {
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NativeConnectionConfig {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NativeErrorType {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NativeInitConfig {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NativeMsgInfo {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NativeOptionalId {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NativePropertyId {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NativeSeekMode {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NativeSwitchDefMode {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OptionalIdType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerType {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TPErrorType {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TPMsgInfo {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TPOptionalId {
    }

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TPSeekMode {
    }

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TPSwitchDefMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TP_AUDIO_DECODER_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TP_AUDIO_SAMPLE_FORMAT {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TP_DRM_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TP_HDR_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TP_VIDEO_CODEC_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TP_VIDEO_DECODER_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TP_VIDEO_PIXEL_FORMAT {
    }
}
