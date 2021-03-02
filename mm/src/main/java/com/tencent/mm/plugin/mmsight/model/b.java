package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.graphics.Point;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import org.json.JSONObject;

public final class b {
    static b ztc;
    public int dYT = 0;
    public long fileSize;
    public int gIQ;
    public int ilT;
    int ipW;
    int jtg;
    JSONObject lxS = null;
    String model = Build.MODEL;
    public int videoBitrate;
    public int ztA;
    public long ztB;
    public int ztC;
    String ztd = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
    String zte;
    int ztf;
    int ztg;
    public String zth;
    public String zti;
    public String ztj;
    public String ztk;
    public int ztl;
    public int ztm;
    public int ztn;
    public int zto;
    public int ztp;
    public int ztq;
    public int ztr;
    public int zts;
    public int ztt;
    public int ztu;
    public int ztv;
    public int ztw;
    int ztx;
    public int zty;
    public int ztz;

    public b() {
        AppMethodBeat.i(89348);
        AppMethodBeat.o(89348);
    }

    public static b ejt() {
        AppMethodBeat.i(89349);
        if (ztc == null) {
            reset();
        }
        b bVar = ztc;
        AppMethodBeat.o(89349);
        return bVar;
    }

    public static void reset() {
        AppMethodBeat.i(89350);
        b bVar = new b();
        ztc = bVar;
        bVar.jtg = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass();
        ztc.ipW = d.gy(MMApplicationContext.getContext());
        ztc.zte = m.aoo();
        Point gx = d.gx(MMApplicationContext.getContext());
        ztc.ztf = gx.x;
        ztc.ztg = gx.y;
        AppMethodBeat.o(89350);
    }

    public final String eju() {
        AppMethodBeat.i(89351);
        if (this.lxS == null) {
            try {
                this.lxS = new JSONObject();
                JSONObject jSONObject = new JSONObject();
                this.lxS.put("wxcamera", jSONObject);
                jSONObject.put("model", this.model);
                jSONObject.put("apiLevel", this.ztd);
                jSONObject.put("screen", String.format("%dx%d", Integer.valueOf(this.ztf), Integer.valueOf(this.ztg)));
                jSONObject.put("crop", String.format("%dx%d", Integer.valueOf(this.ztl), Integer.valueOf(this.ztm)));
                jSONObject.put("preview", String.format("%dx%d", Integer.valueOf(this.ztn), Integer.valueOf(this.zto)));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_ENCODER, String.format("%dx%d", Integer.valueOf(this.ztp), Integer.valueOf(this.ztq)));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, this.dYT);
                jSONObject.put("deviceoutfps", this.ztr);
                jSONObject.put("recordfps", this.zts);
                jSONObject.put("recordertype", this.ztt);
                jSONObject.put("needRotateEachFrame", this.gIQ);
                jSONObject.put("isNeedRealtimeScale", this.ztu);
                jSONObject.put("resolutionLimit", this.ilT);
                jSONObject.put("videoBitrate", this.videoBitrate);
                jSONObject.put("wait2playtime", this.ztB);
                jSONObject.put("useback", this.ztC);
                jSONObject.put("presetIndex", k.zuy != null ? k.zuy.zuK : -1);
                jSONObject.put("recorderOption", ae.gKA.gIW);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CaptureStatistics", e2, "buildJson error", new Object[0]);
            }
        }
        String jSONObject2 = this.lxS.toString();
        AppMethodBeat.o(89351);
        return jSONObject2;
    }
}
