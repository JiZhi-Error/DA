package com.tencent.mm.plugin.facedetectaction.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI;
import com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends IListener<se> {
    public c() {
        AppMethodBeat.i(161649);
        this.__eventId = se.class.getName().hashCode();
        AppMethodBeat.o(161649);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(se seVar) {
        Intent intent;
        boolean z;
        AppMethodBeat.i(104210);
        se seVar2 = seVar;
        int i2 = seVar2.dYI.scene;
        String str = seVar2.dYI.packageName;
        String str2 = seVar2.dYI.dYK;
        String str3 = seVar2.dYI.dYL;
        String str4 = seVar2.dYI.dYM;
        Activity activity = seVar2.dYI.dKq;
        int i3 = seVar2.dYI.requestCode;
        Log.i("MicroMsg.FaceCheckActionEventListener", "receive face check action event, scene: %s, package: %s, sign: %s, title: %s", Integer.valueOf(i2), str, str2, str3);
        se.b bVar = seVar2.dYJ;
        d dVar = d.sXz;
        Log.i("MicroMsg.FaceCheckActionMgr", "startFaceCheckAction, scene: %s, packageName: %s, packageSign: %s, otherVerifyTitle: %s, needFrontPage : %s, requestCode: %s", Integer.valueOf(i2), str, str2, str3, str4, Integer.valueOf(i3));
        if (activity == null) {
            z = false;
        } else {
            dVar.sXA = new b();
            dVar.scene = i2;
            dVar.packageName = str;
            dVar.dYK = str2;
            dVar.dYL = str3;
            dVar.dYM = str4;
            dVar.requestCode = i3;
            dVar.sXI = false;
            if (Util.isNullOrNil(dVar.dYM)) {
                boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_face_action_front_page, false);
                Log.i("MicroMsg.FaceCheckActionMgr", "enableAgreementUI %s", Boolean.valueOf(a2));
                if (a2) {
                    intent = new Intent(activity, FaceAgreementUI.class);
                } else {
                    intent = new Intent(activity, FaceFlashPermissionUI.class);
                }
            } else if (dVar.dYM.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                intent = new Intent(activity, FaceAgreementUI.class);
            } else {
                intent = new Intent(activity, FaceFlashPermissionUI.class);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i2);
            bundle.putString("package", str);
            bundle.putString("packageSign", str2);
            bundle.putString("otherVerifyTitle", str3);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, i3);
            dVar.workerHandler = new MMHandler("FaceCheckActionMgr_worker");
            z = true;
        }
        bVar.dYN = z;
        if (!seVar2.dYJ.dYN) {
            seVar2.dYJ.extras = new Bundle();
            seVar2.dYJ.extras.putInt("err_code", 90001);
            seVar2.dYJ.extras.putString("err_msg", "face detect not support");
        }
        AppMethodBeat.o(104210);
        return false;
    }
}
