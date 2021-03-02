package com.tencent.mm.live.core.d;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u0016\u0010\f\u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/live/core/util/LiveStatisticUtil;", "", "()V", "parseCdnLiveStatistics", "", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "parseLocalStatistics", "Lorg/json/JSONArray;", "localArray", "Ljava/util/ArrayList;", "Lcom/tencent/trtc/TRTCStatistics$TRTCLocalStatistics;", "parseRemoteStatistics", "remoteArray", "Lcom/tencent/trtc/TRTCStatistics$TRTCRemoteStatistics;", "parseTRTCLiveStatistics", "statistics", "Lcom/tencent/trtc/TRTCStatistics;", "plugin-core_release"})
public final class b {
    public static final b hEQ = new b();

    static {
        AppMethodBeat.i(196750);
        AppMethodBeat.o(196750);
    }

    private b() {
    }

    public static String x(Bundle bundle) {
        AppMethodBeat.i(196746);
        if (bundle != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH));
            jSONObject.put("height", bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT));
            jSONObject.put("video_fps", bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS));
            jSONObject.put("video_gop", bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP));
            jSONObject.put("video_bitrate", bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE));
            jSONObject.put("audio_bitrate", bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE));
            jSONObject.put("net_speed", bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED));
            jSONObject.put("video_cache", bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE));
            jSONObject.put("audio_cache", bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE));
            jSONObject.put("video_sum_cache_size", bundle.getInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE));
            jSONObject.put("audio_video_play_interval", bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL));
            jSONObject.put("audio_video_recv_interval", bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL));
            jSONObject.put("audio_cache_threshold", Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_CACHE_THRESHOLD)));
            jSONObject.put("net_jitter", bundle.getInt(TXLiveConstants.NET_STATUS_NET_JITTER));
            jSONObject.put("quality_level", bundle.getInt(TXLiveConstants.NET_STATUS_QUALITY_LEVEL));
            jSONObject.put("cdn_svr_ip", bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP));
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(196746);
            return jSONObject2;
        }
        AppMethodBeat.o(196746);
        return null;
    }

    public static String a(TRTCStatistics tRTCStatistics) {
        AppMethodBeat.i(196747);
        if (tRTCStatistics != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appCpu", tRTCStatistics.appCpu);
            jSONObject.put("systemCpu", tRTCStatistics.systemCpu);
            jSONObject.put("rtt", tRTCStatistics.rtt);
            jSONObject.put("upLoss", tRTCStatistics.upLoss);
            jSONObject.put("downLoss", tRTCStatistics.downLoss);
            jSONObject.put("sendBytes", tRTCStatistics.sendBytes);
            jSONObject.put("receiveBytes", tRTCStatistics.receiveBytes);
            jSONObject.put("LocalStatistics", k(tRTCStatistics.localArray));
            jSONObject.put("remoteStatistics", l(tRTCStatistics.remoteArray));
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(196747);
            return jSONObject2;
        }
        AppMethodBeat.o(196747);
        return null;
    }

    private static JSONArray k(ArrayList<TRTCStatistics.TRTCLocalStatistics> arrayList) {
        AppMethodBeat.i(196748);
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            for (T t : arrayList) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("width", t.width);
                jSONObject.put("height", t.height);
                jSONObject.put("frameRate", t.frameRate);
                jSONObject.put("videoBitrate", t.videoBitrate);
                jSONObject.put("audioSampleRate", t.audioSampleRate);
                jSONObject.put("audioBitrate", t.audioBitrate);
                jSONObject.put("streamType", t.streamType);
                jSONArray.put(jSONObject);
            }
        }
        AppMethodBeat.o(196748);
        return jSONArray;
    }

    private static JSONArray l(ArrayList<TRTCStatistics.TRTCRemoteStatistics> arrayList) {
        AppMethodBeat.i(196749);
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            for (T t : arrayList) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("userId", t.userId);
                jSONObject.put("finalLoss", t.finalLoss);
                jSONObject.put("width", t.width);
                jSONObject.put("height", t.height);
                jSONObject.put("frameRate", t.frameRate);
                jSONObject.put("videoBitrate", t.videoBitrate);
                jSONObject.put("audioSampleRate", t.audioSampleRate);
                jSONObject.put("audioBitrate", t.audioBitrate);
                jSONObject.put("streamType", t.streamType);
                jSONArray.put(jSONObject);
            }
        }
        AppMethodBeat.o(196749);
        return jSONArray;
    }
}
