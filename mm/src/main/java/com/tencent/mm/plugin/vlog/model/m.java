package com.tencent.mm.plugin.vlog.model;

import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010.\u001a\u00020\tH\u0002J\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u000203H\u0002J\u0006\u00104\u001a\u000200J\u0006\u00105\u001a\u000200J\u0006\u00106\u001a\u000200J\u0016\u00107\u001a\u0002002\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020-J\u0006\u0010:\u001a\u000200J\u0006\u0010;\u001a\u000200J\u0006\u0010<\u001a\u000200J\u0010\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020\u0004H\u0002J\u0006\u0010?\u001a\u000200J\u0006\u0010@\u001a\u000200J\u0006\u0010A\u001a\u000200R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u00020\u00118FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010(R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/FinderVideoShell;", "", "()V", "KEY_CONFIG_PATH", "", "KEY_REPORT_DATA_PATH", "KEY_TARGET_VIDEO_PATH", "TAG", "configVideoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getConfigVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setConfigVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "crop60sTick", "", "<set-?>", "", "enableSoftEncodeFallback", "getEnableSoftEncodeFallback", "()I", "exitAlbumTick", "firstFrameTick", "hevcEncodeOption", "getHevcEncodeOption", "isInVideoTest", "", "()Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "com/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1", "Lcom/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1;", "postUIShowTick", "pressEditFinishTick", "remuxFinishTick", "reportDataPath", "startPostTick", "targetVideoPath", "useNormalRemux", "getUseNormalRemux", "setUseNormalRemux", "(I)V", "useTavkitRemux", "getUseTavkitRemux", "setUseTavkitRemux", "videoQualityScore", "", "createFinderDefaultConfig", "destroy", "", "exec", "intent", "Landroid/content/Intent;", "markExitAlbum", "markFirstFrameShow", "markPressEditFinish", "markRemuxFinish", "path", "qualityScore", "markShowCrop60s", "markShowPostUI", "markStartPost", "parseTestConfig", "config", "reportVideoResult", "reset", "setup", "plugin-vlog_release"})
public final class m {
    private static String GxS = "";
    private static String GxT = "";
    private static VideoTransPara GxU;
    private static int GxV;
    private static int GxW = 1;
    private static long GxX;
    private static long GxY;
    private static long GxZ;
    private static long Gya;
    private static long Gyb;
    private static long Gyc;
    private static long Gyd;
    private static float Gye;
    private static int Gyf;
    private static int Gyg;
    private static final a Gyh = new a();
    public static final m Gyi = new m();

    static {
        AppMethodBeat.i(190579);
        AppMethodBeat.o(190579);
    }

    private m() {
    }

    public static boolean fAU() {
        AppMethodBeat.i(190567);
        if (WeChatEnvironment.hasDebugger() && GxU != null) {
            if (GxS.length() > 0) {
                AppMethodBeat.o(190567);
                return true;
            }
        }
        AppMethodBeat.o(190567);
        return false;
    }

    public static VideoTransPara fAV() {
        return GxU;
    }

    public static int fAW() {
        return GxV == 1 ? 0 : 1;
    }

    public static int fAX() {
        return Gyf;
    }

    public static int fAY() {
        return Gyg;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ShellExecEvent;", "callback", "", "event", "plugin-vlog_release"})
    public static final class a extends IListener<uq> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uq uqVar) {
            AppMethodBeat.i(190566);
            uq uqVar2 = uqVar;
            p.h(uqVar2, "event");
            if (WeChatEnvironment.hasDebugger() && p.j(uqVar2.eaT.action, "wechat.shell.FINDER_VIDEO_TEST")) {
                m mVar = m.Gyi;
                Intent intent = uqVar2.eaT.intent;
                p.g(intent, "event.data.intent");
                m.bd(intent);
            }
            AppMethodBeat.o(190566);
            return true;
        }
    }

    public static void setup() {
        AppMethodBeat.i(190568);
        if (WeChatEnvironment.hasDebugger()) {
            Log.i("MicroMsg.FinderVideoShell", "setup");
            Gyh.alive();
        }
        AppMethodBeat.o(190568);
    }

    public static void destroy() {
        AppMethodBeat.i(190569);
        Log.i("MicroMsg.FinderVideoShell", "destroy");
        Gyh.dead();
        AppMethodBeat.o(190569);
    }

    public static void fAZ() {
        AppMethodBeat.i(190570);
        Log.i("MicroMsg.FinderVideoShell", "markExitAlbum");
        if (GxX <= 0) {
            GxX = Util.currentTicks();
        }
        AppMethodBeat.o(190570);
    }

    public static void fBa() {
        AppMethodBeat.i(190571);
        Log.i("MicroMsg.FinderVideoShell", "markShowCrop60s");
        if (GxY <= 0) {
            GxY = Util.currentTicks();
        }
        AppMethodBeat.o(190571);
    }

    public static void fBb() {
        AppMethodBeat.i(190572);
        Log.i("MicroMsg.FinderVideoShell", "markFirstFrameShow");
        if (GxZ <= 0) {
            GxZ = Util.currentTicks();
        }
        AppMethodBeat.o(190572);
    }

    public static void fBc() {
        AppMethodBeat.i(190573);
        Log.i("MicroMsg.FinderVideoShell", "markPressEditFinish");
        if (Gya <= 0) {
            Gya = Util.currentTicks();
        }
        AppMethodBeat.o(190573);
    }

    public static void fBd() {
        AppMethodBeat.i(190574);
        Log.i("MicroMsg.FinderVideoShell", "markShowPostUI");
        if (Gyb <= 0) {
            Gyb = Util.currentTicks();
        }
        AppMethodBeat.o(190574);
    }

    public static void fBe() {
        AppMethodBeat.i(190575);
        Log.i("MicroMsg.FinderVideoShell", "markStartPost");
        if (Gyc <= 0) {
            Gyc = Util.currentTicks();
        }
        AppMethodBeat.o(190575);
    }

    public static void l(String str, float f2) {
        AppMethodBeat.i(190576);
        p.h(str, "path");
        Log.i("MicroMsg.FinderVideoShell", "markRemuxFinish, qualityScore:" + f2 + ", path:" + str);
        Gyd = Util.currentTicks();
        s.nw(str, GxS);
        Gye = f2;
        AppMethodBeat.o(190576);
    }

    public static void fBf() {
        boolean z;
        boolean z2;
        long j2 = 0;
        AppMethodBeat.i(190577);
        if (!fAU()) {
            reset();
            AppMethodBeat.o(190577);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("stage_1", GxY > 0 ? GxY - GxX : 0);
        jSONObject2.put("stage_2", GxZ - GxX);
        if (Gyb > 0 && Gya > 0) {
            j2 = Gyb - Gya;
        }
        jSONObject2.put("stage_3", j2);
        jSONObject2.put("stage_4", Gyd - Gyc);
        jSONObject.put("time_cost", jSONObject2);
        jSONObject.put("quality_score", Float.valueOf(Gye));
        Log.i("MicroMsg.FinderVideoShell", "reportVideoResult:" + jSONObject + ", path:" + GxT);
        if (GxT.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            File parentFile = new File(GxT).getParentFile();
            p.g(parentFile, "File(reportDataPath).parentFile");
            s.boN(parentFile.getAbsolutePath());
            String str = GxT;
            String jSONObject3 = jSONObject.toString();
            p.g(jSONObject3, "json.toString()");
            Charset charset = d.UTF_8;
            if (jSONObject3 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(190577);
                throw tVar;
            }
            byte[] bytes = jSONObject3.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            s.C(str, bytes);
            z2 = true;
        } else {
            z2 = false;
        }
        Intent intent = new Intent("wechat.shell.FINDER_VIDEO_TEST_FINISH");
        intent.putExtra("success", z2);
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(190577);
    }

    public static void reset() {
        AppMethodBeat.i(190578);
        Log.i("MicroMsg.FinderVideoShell", "reset");
        GxX = 0;
        GxY = 0;
        GxZ = 0;
        Gya = 0;
        Gyb = 0;
        Gyc = 0;
        Gyd = 0;
        AppMethodBeat.o(190578);
    }

    public static final /* synthetic */ void bd(Intent intent) {
        AppMethodBeat.i(190580);
        String stringExtra = intent.getStringExtra("config_path");
        String stringExtra2 = intent.getStringExtra("target_video_path");
        String stringExtra3 = intent.getStringExtra("report_data_path");
        p.g(stringExtra3, "intent.getStringExtra(KEY_REPORT_DATA_PATH)");
        GxT = stringExtra3;
        if (s.YS(stringExtra)) {
            String str = stringExtra2;
            if (!(str == null || str.length() == 0)) {
                String boY = s.boY(stringExtra);
                Log.i("MicroMsg.FinderVideoShell", "receive test config in path:" + stringExtra + ", config:" + boY);
                p.g(boY, "config");
                try {
                    JSONObject jSONObject = new JSONObject(boY);
                    e baZ = e.baZ();
                    p.g(baZ, "SubCoreVideoControl.getCore()");
                    VideoTransPara bbf = baZ.bbf();
                    p.g(bbf, "SubCoreVideoControl.getCore().finderAlbumVideoPara");
                    bbf.audioBitrate = jSONObject.optInt("abr", bbf.audioBitrate / 1000) * 1000;
                    bbf.iSU = jSONObject.optInt("prof", 0);
                    bbf.iSV = jSONObject.optInt("preset", 0);
                    bbf.audioChannelCount = jSONObject.optInt("audioChannelCount", bbf.audioChannelCount);
                    bbf.audioSampleRate = jSONObject.optInt("audioSampleRate", bbf.audioSampleRate);
                    JSONArray optJSONArray = jSONObject.optJSONArray("conf");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                        String optString = jSONObject2.optString("wh");
                        bbf.fps = jSONObject2.optInt("fps", bbf.fps);
                        bbf.videoBitrate = jSONObject2.optInt("vbr", bbf.videoBitrate / 1000) * 1000;
                        String str2 = optString;
                        if (!(str2 == null || str2.length() == 0)) {
                            List b2 = n.b(optString, new String[]{"x"});
                            bbf.width = Util.getInt((String) b2.get(0), bbf.width);
                            bbf.height = Util.getInt((String) b2.get(1), bbf.height);
                        }
                    }
                    int optInt = jSONObject.optInt("intval", 0);
                    if (optInt > 0) {
                        bbf.iiH = optInt / bbf.fps;
                    }
                    Log.i("MicroMsg.FinderVideoShell", "parseTestConfig finish, final config:".concat(String.valueOf(bbf)));
                    GxU = bbf;
                    GxV = jSONObject.optInt("use_tavkit_remux", 0);
                    Gyf = jSONObject.optInt("hevc_encode", 0);
                    Gyg = jSONObject.optInt("soft_encode_fallback", 0);
                    Log.i("MicroMsg.FinderVideoShell", "config use useTavkitRemux:" + GxV + ", reportDataPath:" + GxT + ", hevcEncodeOption:" + Gyf + ", enableSoftEncodeFallback:" + Gyg);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FinderVideoShell", e2, "parse config error", new Object[0]);
                }
                GxS = stringExtra2;
                reset();
                Log.i("MicroMsg.FinderVideoShell", "config target video path:" + GxS);
            }
        }
        AppMethodBeat.o(190580);
    }
}
