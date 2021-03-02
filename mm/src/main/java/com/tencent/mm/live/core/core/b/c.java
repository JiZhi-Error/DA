package com.tencent.mm.live.core.core.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\by\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bå\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010%\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020\u0003¢\u0006\u0002\u0010)J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\t\u0010z\u001a\u00020\u0005HÆ\u0003J\t\u0010{\u001a\u00020\u0005HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020#HÆ\u0003J\n\u0010\u0001\u001a\u00020#HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003Jê\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u0003HÆ\u0001J\u0016\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010 \u0001\u001a\u00020 HÖ\u0001R\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\u001a\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\u001a\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010+\"\u0004\b5\u0010-R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010!\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010+\"\u0004\b;\u0010-R\u001a\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010+\"\u0004\b=\u0010-R\u001a\u0010$\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010?\"\u0004\bC\u0010AR\u001a\u0010&\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010+\"\u0004\bE\u0010-R\u001a\u0010\u001b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010+\"\u0004\bG\u0010-R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010+\"\u0004\bI\u0010-R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010+\"\u0004\bO\u0010-R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010+\"\u0004\bQ\u0010-R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010+\"\u0004\bS\u0010-R\u001a\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010+\"\u0004\bU\u0010-R\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010+\"\u0004\bW\u0010-R\u001a\u0010\u001e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010+\"\u0004\bY\u0010-R\u001a\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010+\"\u0004\b[\u0010-R\u001a\u0010(\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010K\"\u0004\b]\u0010MR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010+\"\u0004\b_\u0010-R\u001a\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010+\"\u0004\ba\u0010-R\u001a\u0010'\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010K\"\u0004\bc\u0010MR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010K\"\u0004\be\u0010MR\u001a\u0010\u0018\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010K\"\u0004\bg\u0010MR\u001a\u0010\u0019\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010K\"\u0004\bi\u0010MR\u001a\u0010%\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010+\"\u0004\bk\u0010-R\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010+\"\u0004\bm\u0010-R\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010+\"\u0004\bo\u0010-R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010+\"\u0004\bq\u0010-R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010+\"\u0004\bs\u0010-R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010+\"\u0004\bu\u0010-R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010+\"\u0004\bw\u0010-¨\u0006¡\u0001"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "", "live_id", "", "role", "", "mode", "timestamps", DownloadInfo.NETTYPE, "width", "height", "video_fps", "video_gop", "video_bitrate", "audio_bitrate", "net_speed", "video_cache", "audio_cache", "video_sum_cache_size", "audio_video_play_interval", "audio_video_recv_interval", "audio_cache_threshold", "net_jitter", "quality_level", "total_play_time_ms", "total_wait_time_ms", "live_start_play_time_sec", "first_frame_time_ms", "connect_ms", "rtt_ms", "network_id", "cdn_svr_ip", "", "cdn_svr_port", "cpu_usage_process", "", "cpu_usage_device", "upLoss", "downLoss", "sendBytes", "receiveBytes", "(JIIJIIIIIIIIIIIIIIIIJJIIIIILjava/lang/String;IFFIIJJ)V", "getAudio_bitrate", "()I", "setAudio_bitrate", "(I)V", "getAudio_cache", "setAudio_cache", "getAudio_cache_threshold", "setAudio_cache_threshold", "getAudio_video_play_interval", "setAudio_video_play_interval", "getAudio_video_recv_interval", "setAudio_video_recv_interval", "getCdn_svr_ip", "()Ljava/lang/String;", "setCdn_svr_ip", "(Ljava/lang/String;)V", "getCdn_svr_port", "setCdn_svr_port", "getConnect_ms", "setConnect_ms", "getCpu_usage_device", "()F", "setCpu_usage_device", "(F)V", "getCpu_usage_process", "setCpu_usage_process", "getDownLoss", "setDownLoss", "getFirst_frame_time_ms", "setFirst_frame_time_ms", "getHeight", "setHeight", "getLive_id", "()J", "setLive_id", "(J)V", "getLive_start_play_time_sec", "setLive_start_play_time_sec", "getMode", "setMode", "getNetType", "setNetType", "getNet_jitter", "setNet_jitter", "getNet_speed", "setNet_speed", "getNetwork_id", "setNetwork_id", "getQuality_level", "setQuality_level", "getReceiveBytes", "setReceiveBytes", "getRole", "setRole", "getRtt_ms", "setRtt_ms", "getSendBytes", "setSendBytes", "getTimestamps", "setTimestamps", "getTotal_play_time_ms", "setTotal_play_time_ms", "getTotal_wait_time_ms", "setTotal_wait_time_ms", "getUpLoss", "setUpLoss", "getVideo_bitrate", "setVideo_bitrate", "getVideo_cache", "setVideo_cache", "getVideo_fps", "setVideo_fps", "getVideo_gop", "setVideo_gop", "getVideo_sum_cache_size", "setVideo_sum_cache_size", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-core_release"})
public final class c {
    public int downLoss;
    public int height;
    public long hyH;
    public int hyI;
    public int hyJ;
    public int hyK;
    public int hyL;
    public int hyM;
    public int hyN;
    public int hyO;
    public int hyP;
    public int hyQ;
    public int hyR;
    public int hyS;
    public int hyT;
    public int hyU;
    public long hyV;
    public long hyW;
    public int hyX;
    public int hyY;
    public int hyZ;
    public int hza;
    public int hzb;
    public String hzc;
    public int hzd;
    public float hze;
    public float hzf;
    public int mode;
    public int netType;
    public long receiveBytes;
    public int role;
    public long sendBytes;
    public long timestamps;
    public int upLoss;
    public int width;

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f6, code lost:
        if (r5.receiveBytes == r6.receiveBytes) goto L_0x00f8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.core.core.b.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(196452);
        long j2 = this.hyH;
        long j3 = this.timestamps;
        long j4 = this.hyV;
        long j5 = this.hyW;
        int i2 = ((((((((((((((((((((((((((((((((((((((((((((((((((((((int) (j2 ^ (j2 >>> 32))) * 31) + this.role) * 31) + this.mode) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.netType) * 31) + this.width) * 31) + this.height) * 31) + this.hyI) * 31) + this.hyJ) * 31) + this.hyK) * 31) + this.hyL) * 31) + this.hyM) * 31) + this.hyN) * 31) + this.hyO) * 31) + this.hyP) * 31) + this.hyQ) * 31) + this.hyR) * 31) + this.hyS) * 31) + this.hyT) * 31) + this.hyU) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.hyX) * 31) + this.hyY) * 31) + this.hyZ) * 31) + this.hza) * 31) + this.hzb) * 31;
        String str = this.hzc;
        int hashCode = str != null ? str.hashCode() : 0;
        long j6 = this.sendBytes;
        long j7 = this.receiveBytes;
        int floatToIntBits = ((((((((((((((hashCode + i2) * 31) + this.hzd) * 31) + Float.floatToIntBits(this.hze)) * 31) + Float.floatToIntBits(this.hzf)) * 31) + this.upLoss) * 31) + this.downLoss) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)));
        AppMethodBeat.o(196452);
        return floatToIntBits;
    }

    public final String toString() {
        AppMethodBeat.i(196451);
        String str = "LiveQosInfo(live_id=" + this.hyH + ", role=" + this.role + ", mode=" + this.mode + ", timestamps=" + this.timestamps + ", netType=" + this.netType + ", width=" + this.width + ", height=" + this.height + ", video_fps=" + this.hyI + ", video_gop=" + this.hyJ + ", video_bitrate=" + this.hyK + ", audio_bitrate=" + this.hyL + ", net_speed=" + this.hyM + ", video_cache=" + this.hyN + ", audio_cache=" + this.hyO + ", video_sum_cache_size=" + this.hyP + ", audio_video_play_interval=" + this.hyQ + ", audio_video_recv_interval=" + this.hyR + ", audio_cache_threshold=" + this.hyS + ", net_jitter=" + this.hyT + ", quality_level=" + this.hyU + ", total_play_time_ms=" + this.hyV + ", total_wait_time_ms=" + this.hyW + ", live_start_play_time_sec=" + this.hyX + ", first_frame_time_ms=" + this.hyY + ", connect_ms=" + this.hyZ + ", rtt_ms=" + this.hza + ", network_id=" + this.hzb + ", cdn_svr_ip=" + this.hzc + ", cdn_svr_port=" + this.hzd + ", cpu_usage_process=" + this.hze + ", cpu_usage_device=" + this.hzf + ", upLoss=" + this.upLoss + ", downLoss=" + this.downLoss + ", sendBytes=" + this.sendBytes + ", receiveBytes=" + this.receiveBytes + ")";
        AppMethodBeat.o(196451);
        return str;
    }

    private c() {
        this.hyH = 0;
        this.role = 0;
        this.mode = 0;
        this.timestamps = 0;
        this.netType = 0;
        this.width = 0;
        this.height = 0;
        this.hyI = 0;
        this.hyJ = 0;
        this.hyK = 0;
        this.hyL = 0;
        this.hyM = 0;
        this.hyN = 0;
        this.hyO = 0;
        this.hyP = 0;
        this.hyQ = 0;
        this.hyR = 0;
        this.hyS = 0;
        this.hyT = 0;
        this.hyU = 0;
        this.hyV = 0;
        this.hyW = 0;
        this.hyX = 0;
        this.hyY = 0;
        this.hyZ = 0;
        this.hza = 0;
        this.hzb = 0;
        this.hzc = null;
        this.hzd = 0;
        this.hze = 0.0f;
        this.hzf = 0.0f;
        this.upLoss = 0;
        this.downLoss = 0;
        this.sendBytes = 0;
        this.receiveBytes = 0;
    }

    public /* synthetic */ c(byte b2) {
        this();
    }
}
