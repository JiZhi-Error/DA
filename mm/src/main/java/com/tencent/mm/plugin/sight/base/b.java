package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;

public final class b {
    public static int hWK() {
        AppMethodBeat.i(258771);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remuxer_vfr_max_process_frame_count, 3660);
        AppMethodBeat.o(258771);
        return a2;
    }

    public static boolean aj(boolean z, boolean z2) {
        int intValue;
        AppMethodBeat.i(133596);
        try {
            if (g.aAi().hrr && g.aAf().azp() && (intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LOCAL_SIGHT_RECORD_USE_FFMPEG_INT_SYNC, (Object) -1)).intValue()) > 0) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(intValue);
                objArr[1] = Boolean.valueOf(intValue == 2);
                Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", objArr);
                if (intValue == 2) {
                    AppMethodBeat.o(133596);
                    return true;
                }
                AppMethodBeat.o(133596);
                return false;
            }
        } catch (Error e2) {
            Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", e2, "load isIsUseFFmpeg local config fail", new Object[0]);
        }
        boolean z3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_is_use_ffmpeg_muxer, 0) == 1;
        if (!z3 && z2) {
            Log.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", Boolean.FALSE, Boolean.valueOf(z2));
            z3 = true;
        }
        Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", Boolean.valueOf(z3), Boolean.valueOf(z), Boolean.valueOf(z2));
        AppMethodBeat.o(133596);
        return z3;
    }

    public static boolean eVr() {
        boolean z;
        int intValue;
        AppMethodBeat.i(201785);
        try {
            if (g.aAi().hrr && g.aAf().azp() && (intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LOCAL_SIGHT_RECORD_USE_FFMPEG_INT_SYNC, (Object) -1)).intValue()) > 0) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(intValue);
                objArr[1] = Boolean.valueOf(intValue == 2);
                Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", objArr);
                if (intValue == 2) {
                    AppMethodBeat.o(201785);
                    return true;
                }
                AppMethodBeat.o(201785);
                return false;
            }
        } catch (Error e2) {
            Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", e2, "load isIsUseFFmpeg local config fail", new Object[0]);
        }
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sight_video_jni_remuxing_is_use_ffmpeg_muxer, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b", Boolean.valueOf(z));
        AppMethodBeat.o(201785);
        return z;
    }

    public static boolean ak(boolean z, boolean z2) {
        int intValue;
        AppMethodBeat.i(201786);
        try {
            if (g.aAi().hrr && g.aAf().azp() && (intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LOCAL_SIGHT_CAPTURE_USE_FFMPEG_INT_SYNC, (Object) -1)).intValue()) > 0) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(intValue);
                objArr[1] = Boolean.valueOf(intValue == 2);
                Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", objArr);
                if (intValue == 2) {
                    AppMethodBeat.o(201786);
                    return true;
                }
                AppMethodBeat.o(201786);
                return false;
            }
        } catch (Error e2) {
            Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", e2, "load isIsUseFFmpeg local config fail", new Object[0]);
        }
        boolean z3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_is_use_ffmpeg_muxer_for_capture, 0) == 1;
        if (!z3 && z2) {
            Log.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", Boolean.FALSE, Boolean.valueOf(z2));
            z3 = true;
        }
        Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", Boolean.valueOf(z3), Boolean.valueOf(z), Boolean.valueOf(z2));
        AppMethodBeat.o(201786);
        return z3;
    }

    public static boolean al(boolean z, boolean z2) {
        int intValue;
        AppMethodBeat.i(201787);
        try {
            if (g.aAi().hrr && g.aAf().azp() && (intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LOCAL_SIGHT_RECORD_USE_FFMPEG_INT_SYNC, (Object) -1)).intValue()) > 0) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(intValue);
                objArr[1] = Boolean.valueOf(intValue == 2);
                Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", objArr);
                if (intValue == 2) {
                    AppMethodBeat.o(201787);
                    return true;
                }
                AppMethodBeat.o(201787);
                return false;
            }
        } catch (Error e2) {
            Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", e2, "load isIsUseFFmpeg local config fail", new Object[0]);
        }
        boolean z3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_is_use_ffmpeg_muxer, 0) == 1;
        if (!z3 && z2) {
            Log.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", Boolean.FALSE, Boolean.valueOf(z2));
            z3 = true;
        }
        Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", Boolean.valueOf(z3), Boolean.valueOf(z), Boolean.valueOf(z2));
        AppMethodBeat.o(201787);
        return z3;
    }

    public static boolean eVs() {
        boolean z;
        int intValue;
        AppMethodBeat.i(176222);
        try {
            if (g.aAi().hrr && g.aAf().azp() && (intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LOCAL_SIGHT_RECORD_USE_FFMPEG_CODEC_PTS_INT_SYNC, (Object) -1)).intValue()) > 0) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(intValue);
                objArr[1] = Boolean.valueOf(intValue == 1);
                Log.d("MicroMsg.WechatSight.PacketMuxerController", "WechatSight useCodecPts localConfig: %d, useCodecPts: %b", objArr);
                if (intValue == 1) {
                    AppMethodBeat.o(176222);
                    return true;
                }
                AppMethodBeat.o(176222);
                return false;
            }
        } catch (Error e2) {
            Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", e2, "load useCodecPts local config fail", new Object[0]);
        }
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ffmpeg_muxer_use_codec_pts, 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight useCodecPts: %b", Boolean.valueOf(z));
        AppMethodBeat.o(176222);
        return z;
    }

    public static String eVt() {
        AppMethodBeat.i(133597);
        if (MMApplicationContext.getContext() == null || MMApplicationContext.getContext().getCacheDir() == null) {
            Log.e("MicroMsg.WechatSight.PacketMuxerController", "path is empty, MMApplicationContext.getContext() == null");
            AppMethodBeat.o(133597);
            return "";
        }
        String str = MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + "/mux";
        o oVar = new o(str);
        if (!oVar.exists()) {
            oVar.mkdirs();
            Log.i("MicroMsg.WechatSight.PacketMuxerController", "path is not exists, mkdir path: %s", str);
        }
        Log.d("MicroMsg.WechatSight.PacketMuxerController", "WechatSight ffmpegMuxerPath path is %s", str);
        AppMethodBeat.o(133597);
        return str;
    }

    public static void am(long j2, long j3) {
        AppMethodBeat.i(176223);
        try {
            e.INSTANCE.idkeyStat(1280, j2, j3, false);
            Log.d("MicroMsg.WechatSight.PacketMuxerController", "reportIDKey muxer called: %d, %d", Long.valueOf(j2), Long.valueOf(j3));
            AppMethodBeat.o(176223);
        } catch (Error e2) {
            Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", e2, "reportIDKey muxer called error", new Object[0]);
            AppMethodBeat.o(176223);
        }
    }
}
