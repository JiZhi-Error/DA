package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.flash.FaceFlashUI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;

public enum f {
    INSTANCE;
    
    private static MMHandler sQO = new MMHandler("face_process");
    public FaceDetectProcessService sQN = null;

    private f(String str) {
    }

    public static f valueOf(String str) {
        AppMethodBeat.i(103726);
        f fVar = (f) Enum.valueOf(f.class, str);
        AppMethodBeat.o(103726);
        return fVar;
    }

    static {
        AppMethodBeat.i(103738);
        AppMethodBeat.o(103738);
    }

    public static void ao(Runnable runnable) {
        AppMethodBeat.i(103727);
        sQO.postToWorker(runnable);
        AppMethodBeat.o(103727);
    }

    public static void cSU() {
        AppMethodBeat.i(103728);
        sQO.removeCallbacksAndMessages(null);
        AppMethodBeat.o(103728);
    }

    public static MMHandler cSV() {
        AppMethodBeat.i(103729);
        MMHandler mMHandler = sQO;
        AppMethodBeat.o(103729);
        return mMHandler;
    }

    public static boolean mt(boolean z) {
        boolean z2;
        AppMethodBeat.i(103730);
        Log.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", Boolean.valueOf(z));
        boolean fg = fg(MMApplicationContext.getContext());
        boolean cTg = p.cTg();
        boolean isEnabled = PluginFace.isEnabled();
        boolean cSW = cSW();
        if (z) {
            if (Util.getInt(((a) g.af(a.class)).aqJ().getValue("BioSigFaceEntry"), 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Log.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b, isPluginFaceEnabled: %b", Boolean.valueOf(z2), Boolean.valueOf(fg), Boolean.valueOf(cTg), Boolean.valueOf(isEnabled));
            if (!z2 || (!fg || !cTg) || !isEnabled || !cSW) {
                AppMethodBeat.o(103730);
                return false;
            }
            AppMethodBeat.o(103730);
            return true;
        }
        Log.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b, isPluginFaceEnabled: %b", Boolean.valueOf(fg), Boolean.valueOf(cTg), Boolean.valueOf(isEnabled));
        if (!cTg || !fg || !isEnabled || !cSW) {
            AppMethodBeat.o(103730);
            return false;
        }
        AppMethodBeat.o(103730);
        return true;
    }

    public static boolean cSW() {
        AppMethodBeat.i(186366);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_face_flash_enable_pad, false);
        if (!ao.gJH() || a2) {
            AppMethodBeat.o(186366);
            return true;
        }
        AppMethodBeat.o(186366);
        return false;
    }

    public static boolean cSX() {
        AppMethodBeat.i(258251);
        boolean cTg = p.cTg();
        AppMethodBeat.o(258251);
        return cTg;
    }

    static boolean fg(Context context) {
        AppMethodBeat.i(103732);
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.front");
        AppMethodBeat.o(103732);
        return hasSystemFeature;
    }

    public static boolean a(Context context, Bundle bundle, int i2) {
        AppMethodBeat.i(103733);
        Log.i("MicroMsg.FaceDetectManager", "start wx internal face verify");
        if (context == null || bundle == null) {
            AppMethodBeat.o(103733);
            return false;
        }
        FaceFlashUI.a((Activity) context, bundle, i2);
        AppMethodBeat.o(103733);
        return true;
    }

    public final int cSY() {
        AppMethodBeat.i(103734);
        g gVar = this.sQN.sSO;
        if (gVar.sQQ == null) {
            Log.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
            AppMethodBeat.o(103734);
            return -3;
        }
        int engineReleaseCurrMotion = gVar.sQQ.engineReleaseCurrMotion();
        AppMethodBeat.o(103734);
        return engineReleaseCurrMotion;
    }

    public final int cSZ() {
        AppMethodBeat.i(103735);
        g gVar = this.sQN.sSO;
        if (gVar.sQQ == null) {
            Log.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
            AppMethodBeat.o(103735);
            return -1;
        }
        int engineGetCurrMotion = gVar.sQQ.engineGetCurrMotion();
        AppMethodBeat.o(103735);
        return engineGetCurrMotion;
    }

    public final int cTa() {
        AppMethodBeat.i(103737);
        g gVar = this.sQN.sSO;
        if (gVar.sQQ == null) {
            Log.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            AppMethodBeat.o(103737);
            return -1;
        }
        int engineGroupChange = gVar.sQQ.engineGroupChange();
        AppMethodBeat.o(103737);
        return engineGroupChange;
    }
}
