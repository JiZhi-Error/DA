package com.tencent.thumbplayer.core.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Vector;

public class TPNativePlayerInitConfig {
    public static final int BOOL_ENABLE_ASYNC_MEDIA_CODEC = 206;
    public static final int BOOL_ENABLE_AUDIO_FRAME_CALLBACK = 402;
    public static final int BOOL_ENABLE_AUDIO_PASSTHROUGH = 210;
    public static final int BOOL_ENABLE_AUDIO_RENDERER_LATENCY_COMPENSATION = 401;
    public static final int BOOL_ENABLE_AV_SYNC = 400;
    public static final int BOOL_ENABLE_COLOR_MANAGEMENT = 407;
    public static final int BOOL_ENABLE_DROPFRAME_BY_REFRESHRATE = 406;
    public static final int BOOL_ENABLE_FORCE_FFMPEG_DEMUXER = 114;
    public static final int BOOL_ENABLE_HEVC_OPTIMIZATION = 115;
    public static final int BOOL_ENABLE_MEDIA_CODEC_REUSE = 213;
    public static final int BOOL_ENABLE_MEDIA_CODEC_SET_OPERATE_RATE = 212;
    public static final int BOOL_ENABLE_MULTI_RECEIVE_FRAMES = 209;
    public static final int BOOL_ENABLE_NATIVE_MEDIA_CODEC = 204;
    public static final int BOOL_ENABLE_SET_OUTPUT_SURFACE_API = 205;
    public static final int BOOL_ENABLE_VIDEO_FRAME_CALLBACK = 403;
    public static final int BOOL_HLS_HTTP_KEEP_ALIVE = 110;
    public static final int BOOL_HLS_SWITCH_BY_SEGMENT = 111;
    public static final int BOOL_KEEP_ORIGINAL_PTS = 112;
    public static final int BOOL_RELEASE_MEDIA_CODEC_WHEN_SET_SURFACE = 211;
    public static final int BOOL_RESET_DECODER_ON_PARAMETER_CHANGE = 201;
    public static final int BOOL_START_PLAYING_TIME_ACCURATE_SEEK = 101;
    public static final int BOOL_VIDEO_KEEP_MEDIA_CODEC_PTS = 215;
    public static final int FLOAT_REDUCE_LATENCY_SPEED_UP_RATE = 120;
    public static final int FLOAT_VIDEO_DROP_FRAME_DETECT_MIN_RATE = 208;
    public static final int INT_AUDIO_RENDERER_TYPE = 404;
    public static final int INT_DECODER_MAX_TOLERATED_ERROR_COUNT = 200;
    public static final int INT_FRAME_SIZE_BYTE = 303;
    public static final int INT_HEIGHT = 312;
    public static final int INT_PIXEL_FORMAT = 310;
    public static final int INT_REDUCE_LIVE_LATENCY_ACTION = 119;
    public static final int INT_ROTATION = 313;
    public static final int INT_SAMPLE_FORMAT = 300;
    public static final int INT_SAMPLE_RATE_HZ = 302;
    public static final int INT_STREAM_DEMUXER_FORMAT = 116;
    public static final int INT_TCP_RETRY_COUNT = 109;
    public static final int INT_VIDEO_RENDERER_TYPE = 405;
    public static final int INT_WIDTH = 311;
    public static final int LONG_AUDIO_NON_BLUETOOTH_MAX_LIMIT_LATENCY_MS = 409;
    public static final int LONG_BUFFERING_TIMEOUT_MS = 107;
    public static final int LONG_BUFFER_PACKET_MAX_TOTAL_DURATION_MS = 117;
    public static final int LONG_BUFFER_PACKET_MIN_TOTAL_DURATION_MS = 102;
    public static final int LONG_CHANNEL_LAYOUT = 301;
    public static final int LONG_MAX_ANALYZE_DURATION_MS = 121;
    public static final int LONG_MAX_BUFFERING_TIME_MS = 106;
    public static final int LONG_MIN_BUFFERING_PACKET_DURATION_MS = 104;
    public static final int LONG_MIN_BUFFERING_TIME_MS = 105;
    public static final int LONG_PRELOAD_PACKET_TOTAL_DURATION_MS = 103;
    public static final int LONG_PREPARE_TIMEOUT_MS = 118;
    public static final int LONG_START_PLAYING_TIME_MS = 100;
    public static final int LONG_TCP_TIMEOUT_MS = 108;
    public static final int LONG_VIDEO_DROP_FRAME_TIME_UNIT_MS = 207;
    public static final int QUEUE_INT_AUDIO_DECODER_TYPE = 202;
    public static final int QUEUE_INT_VIDEO_DECODER_TYPE = 203;
    public static final int QUEUE_STRING_HLS_TAG_CALLBACK = 113;
    private HashMap<Integer, Boolean> mBoolMap = new HashMap<>();
    private HashMap<Integer, Float> mFloatMap = new HashMap<>();
    private HashMap<Integer, Integer> mIntMap = new HashMap<>();
    private HashMap<Integer, Long> mLongMap = new HashMap<>();
    private HashMap<Integer, Vector<Integer>> mQueueIntMap = new HashMap<>();
    private HashMap<Integer, Vector<String>> mQueueStringMap = new HashMap<>();

    public TPNativePlayerInitConfig() {
        AppMethodBeat.i(189985);
        AppMethodBeat.o(189985);
    }

    public void addQueueInt(int i2, int i3) {
        AppMethodBeat.i(189986);
        Vector<Integer> vector = this.mQueueIntMap.get(Integer.valueOf(i2));
        if (vector == null) {
            vector = new Vector<>();
            this.mQueueIntMap.put(Integer.valueOf(i2), vector);
        }
        vector.add(Integer.valueOf(i3));
        AppMethodBeat.o(189986);
    }

    public void addQueueString(int i2, String str) {
        AppMethodBeat.i(189987);
        Vector<String> vector = this.mQueueStringMap.get(Integer.valueOf(i2));
        if (vector == null) {
            vector = new Vector<>();
            this.mQueueStringMap.put(Integer.valueOf(i2), vector);
        }
        vector.add(str);
        AppMethodBeat.o(189987);
    }

    public void setInt(int i2, int i3) {
        AppMethodBeat.i(189988);
        this.mIntMap.put(Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(189988);
    }

    public void setLong(int i2, long j2) {
        AppMethodBeat.i(189989);
        this.mLongMap.put(Integer.valueOf(i2), Long.valueOf(j2));
        AppMethodBeat.o(189989);
    }

    public void setFloat(int i2, float f2) {
        AppMethodBeat.i(189990);
        this.mFloatMap.put(Integer.valueOf(i2), Float.valueOf(f2));
        AppMethodBeat.o(189990);
    }

    public void setBool(int i2, boolean z) {
        AppMethodBeat.i(189991);
        this.mBoolMap.put(Integer.valueOf(i2), Boolean.valueOf(z));
        AppMethodBeat.o(189991);
    }

    public HashMap<Integer, Integer> getIntMap() {
        return this.mIntMap;
    }

    public HashMap<Integer, Long> getLongMap() {
        return this.mLongMap;
    }

    public HashMap<Integer, Float> getFloatMap() {
        return this.mFloatMap;
    }

    public HashMap<Integer, Boolean> getBoolMap() {
        return this.mBoolMap;
    }

    public HashMap<Integer, Vector<Integer>> getQueueIntMap() {
        return this.mQueueIntMap;
    }

    public HashMap<Integer, Vector<String>> getQueueStringMap() {
        return this.mQueueStringMap;
    }
}
