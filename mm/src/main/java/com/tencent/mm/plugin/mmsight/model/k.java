package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ck;
import com.tencent.mm.ui.base.u;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public final class k {
    static int jtg;
    public static boolean zuv = true;
    public static boolean zuw = false;
    public static boolean zux = false;
    public static p zuy;
    static double zuz;

    public static boolean i(Point point) {
        AppMethodBeat.i(89425);
        if (zuw) {
            Context context = MMApplicationContext.getContext();
            Resources resources = MMApplicationContext.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = zuy == null ? "" : Integer.valueOf(zuy.zuK);
            u.makeText(context, resources.getString(R.string.e2v, objArr), 1).show();
            AppMethodBeat.o(89425);
            return false;
        }
        Log.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", Integer.valueOf(ae.gKA.gIP), Integer.valueOf(ae.gKA.gIW), Boolean.valueOf(zux));
        if (zux) {
            AppMethodBeat.o(89425);
            return false;
        } else if (ae.gKA.gIP != -1) {
            AppMethodBeat.o(89425);
            return true;
        } else if (zuy != null && 1 == zuy.gIP) {
            AppMethodBeat.o(89425);
            return true;
        } else if (point == null) {
            AppMethodBeat.o(89425);
            return false;
        } else if (!d.QI(point.x) || !d.QI(point.y)) {
            if (zuy != null) {
                Log.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", point.toString());
                zuy.gIP = 1;
            }
            AppMethodBeat.o(89425);
            return false;
        } else {
            AppMethodBeat.o(89425);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0217  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.hardware.Camera.Parameters r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 550
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.model.k.a(android.hardware.Camera$Parameters, boolean):void");
    }

    public static void d(VideoTransPara videoTransPara) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(89427);
        a aVar = a.MMSightCameraConfig;
        zuw = false;
        zux = false;
        jtg = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass();
        zuz = (double) d.gy(MMApplicationContext.getContext());
        String fingerprint = ck.getFingerprint();
        if (CaptureMMProxy.getInstance() == null || MMApplicationContext.isMMProcess()) {
            i2 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("SightMediaCodecMinApiLevel"), 19);
        } else {
            i2 = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
        }
        Log.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", Integer.valueOf(i2));
        if (CaptureMMProxy.getInstance() == null || MMApplicationContext.isMMProcess()) {
            g.aAi();
            ae.DV(g.aAh().azR().gEu());
        } else {
            ae.DV(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        Log.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", Integer.valueOf(jtg), Double.valueOf(zuz), fingerprint, ae.gKA);
        if (CaptureMMProxy.getInstance() == null || MMApplicationContext.isMMProcess()) {
            g.aAi();
            i3 = g.aAh().azQ().getInt(ar.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, -1);
            g.aAi();
            i4 = g.aAh().azQ().getInt(ar.a.USERINFO_LOCAL_SIGHT_FOCUS_INT_SYNC, 1);
            g.aAi();
            i5 = g.aAh().azQ().getInt(ar.a.USERINFO_LOCAL_SIGHT_CAPTURE_TYPE_INT_SYNC, 1);
            g.aAi();
            i6 = g.aAh().azQ().getInt(ar.a.USERINFO_LOCAL_SIGHT_CAMERA_API_INT_SYNC, 2);
        } else {
            i3 = CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, -1);
            i4 = CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_FOCUS_INT_SYNC, 1);
            i5 = CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_CAPTURE_TYPE_INT_SYNC, 1);
            i6 = CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_CAMERA_API_INT_SYNC, 2);
        }
        p a2 = p.a(i3, videoTransPara);
        zuy = a2;
        if (a2 != null) {
            p pVar = zuy;
            if (i4 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            pVar.zuM = z2;
            zuw = true;
            Context context = MMApplicationContext.getContext();
            Resources resources = MMApplicationContext.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = zuy == null ? "" : Integer.valueOf(zuy.zuK);
            u.makeText(context, resources.getString(R.string.e2v, objArr), 1).show();
            AppMethodBeat.o(89427);
            return;
        }
        switch (aVar) {
            case MMStoryCameraConfig:
                x xVar = ae.gKB;
                i7 = 12;
                break;
            default:
                i7 = ae.gKA.gIW;
                break;
        }
        Log.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", Integer.valueOf(i7));
        if (i7 != -1) {
            zuy = p.a(i7, videoTransPara);
        }
        if (zuy != null) {
            if (i4 == 1) {
                zuy.zuM = true;
            } else {
                zuy.zuM = false;
            }
            zux = true;
            AppMethodBeat.o(89427);
            return;
        }
        zuy = p.a(1, videoTransPara);
        if (i4 == 1) {
            zuy.zuM = true;
        } else {
            zuy.zuM = false;
        }
        zuy.zuJ = i5;
        p pVar2 = zuy;
        if (i6 == 2) {
            z = true;
        } else {
            z = false;
        }
        pVar2.roc = z;
        if (ae.gKA.gIP != -1) {
            zuy.gIP = ae.gKA.gIP;
        } else if (com.tencent.mm.compatible.util.d.oD(i2)) {
            zuy.gIP = 2;
        } else {
            zuy.gIP = 1;
        }
        if (ae.gKA.gIS != -1) {
            zuv = ae.gKA.gIS == 1;
        }
        if (ae.gKA.gIQ != -1) {
            p pVar3 = zuy;
            if (ae.gKA.gIQ != 1) {
                z3 = false;
            }
            pVar3.isQ = z3;
            AppMethodBeat.o(89427);
            return;
        }
        zuy.isQ = false;
        AppMethodBeat.o(89427);
    }

    public static boolean ejH() {
        AppMethodBeat.i(89428);
        if (CaptureMMProxy.getInstance() == null || MMApplicationContext.isMMProcess()) {
            g.aAi();
            if (g.aAh().azQ().getInt(ar.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, -1) != -1) {
                AppMethodBeat.o(89428);
                return true;
            }
            AppMethodBeat.o(89428);
            return false;
        } else if (CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, -1) != -1) {
            AppMethodBeat.o(89428);
            return true;
        } else {
            AppMethodBeat.o(89428);
            return false;
        }
    }

    public static void a(h.c cVar) {
        AppMethodBeat.i(89429);
        if (cVar.zum == null) {
            Log.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", cVar.toString());
            cVar.zum = cVar.zup;
            cVar.zun = cVar.zuq;
            cVar.zuo = cVar.zur;
            if (Math.min(cVar.zun.y, cVar.zun.x) >= zuy.irT.width + 16) {
                zuy.ejP();
                zuy.zuL = false;
                zuy.isQ = false;
                Log.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", cVar.toString());
            }
        }
        AppMethodBeat.o(89429);
    }

    public static void ejI() {
        AppMethodBeat.i(89430);
        Log.i("MicroMsg.MMSightRecorderConfig", "initSimple");
        p pVar = new p();
        zuy = pVar;
        pVar.isQ = false;
        zuy.zuL = false;
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            zuy.gIP = 2;
            AppMethodBeat.o(89430);
            return;
        }
        zuy.gIP = 1;
        AppMethodBeat.o(89430);
    }

    public enum a {
        MMSightCameraConfig,
        MMStoryCameraConfig;

        public static a valueOf(String str) {
            AppMethodBeat.i(89423);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(89423);
            return aVar;
        }

        static {
            AppMethodBeat.i(89424);
            AppMethodBeat.o(89424);
        }
    }
}
