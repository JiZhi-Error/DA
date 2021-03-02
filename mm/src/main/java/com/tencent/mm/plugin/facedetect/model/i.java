package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI;
import com.tencent.mm.plugin.flash.FaceFlashUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends IListener<sh> {
    public i() {
        AppMethodBeat.i(161644);
        this.__eventId = sh.class.getName().hashCode();
        AppMethodBeat.o(161644);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(sh shVar) {
        boolean z;
        AppMethodBeat.i(103768);
        sh shVar2 = shVar;
        if (shVar2 == null) {
            AppMethodBeat.o(103768);
            return false;
        }
        sh.b bVar = shVar2.dYW;
        f fVar = f.INSTANCE;
        Context context = shVar2.dYV.context;
        Bundle bundle = shVar2.dYV.extras;
        int i2 = shVar2.dYV.dYQ;
        if (bundle == null || bundle.getBoolean("key_is_need_confirm_page", true)) {
            Log.i("MicroMsg.FaceDetectManager", "start face detect process");
            FaceDetectReporter.cTe().cTf();
            FaceDetectReporter cTe = FaceDetectReporter.cTe();
            Log.v("MicroMsg.FaceDetectReporter", "create interface called session");
            cTe.sRz = System.currentTimeMillis();
            cTe.sRC = 0;
            cTe.sRD = false;
            cTe.sRA = -1;
            cTe.sRB = -1;
            FaceDetectReporter.cTe().sRA = System.currentTimeMillis();
            if (context == null) {
                z = false;
            } else if (bundle != null) {
                int i3 = bundle.getInt("scene", 2);
                FaceDetectReporter.cTe().appId = bundle.getString("appId", "");
                if (!f.mt(bundle.getBoolean("is_check_dyncfg", false))) {
                    Log.w("MicroMsg.FaceDetectManager", "alvinluo: not support face detect");
                    FaceDetectReporter cTe2 = FaceDetectReporter.cTe();
                    int HK = FaceDetectReporter.HK(i3);
                    Log.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", Integer.valueOf(HK), Boolean.FALSE);
                    h.INSTANCE.a(14005, Integer.valueOf(HK), Long.valueOf(cTe2.sessionId), 0);
                    cTe2.ad(FaceDetectReporter.HK(i3), 4, 90001);
                    z = false;
                } else if (i3 == 2 || i3 == 5) {
                    Log.w("MicroMsg.FaceDetectManager", "carson: serverScene == FACE_DETECT_SERVER_SCENE_MP | FACE_DETECT_SERVER_SCENE_SUBAPP");
                    Intent intent = new Intent(context, FaceDetectConfirmUI.class);
                    intent.putExtras(bundle);
                    ((Activity) context).startActivityForResult(intent, i2);
                    z = true;
                } else {
                    FaceFlashUI.a((Activity) context, bundle, i2);
                    z = true;
                }
            } else {
                Log.e("MicroMsg.FaceDetectManager", "hy: extras is null! should not happen");
                z = false;
            }
        } else {
            z = f.a(context, bundle, i2);
        }
        bVar.dYN = z;
        if (!shVar2.dYW.dYN) {
            shVar2.dYW.extras = new Bundle();
            shVar2.dYW.extras.putInt("err_code", 90001);
            shVar2.dYW.extras.putString("err_msg", "face detect not support");
        }
        AppMethodBeat.o(103768);
        return true;
    }
}
