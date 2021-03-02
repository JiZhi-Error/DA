package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.si;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends IListener<si> {
    public o() {
        AppMethodBeat.i(161648);
        this.__eventId = si.class.getName().hashCode();
        AppMethodBeat.o(161648);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(si siVar) {
        boolean z;
        AppMethodBeat.i(103781);
        si siVar2 = siVar;
        if (siVar2 == null) {
            Log.e("MicroMsg.FaceStartManageListener", "hy: event is null");
            AppMethodBeat.o(103781);
            return false;
        }
        Context context = siVar2.dYX.context;
        si.b bVar = siVar2.dYY;
        f fVar = f.INSTANCE;
        Log.i("MicroMsg.FaceDetectManager", "hy: start face manage process");
        if (context == null) {
            Log.e("MicroMsg.FaceDetectManager", "hy: context is null. abort");
            z = false;
        } else if (!f.mt(true)) {
            Log.w("MicroMsg.FaceDetectManager", "hy: not support face detect. abort");
            z = false;
        } else {
            a bl = new a().bl(new Intent(context, SettingsFacePrintManagerUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/facedetect/model/FaceDetectManager", "startFaceManageProcess", "(Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/facedetect/model/FaceDetectManager", "startFaceManageProcess", "(Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            z = true;
        }
        bVar.dYN = z;
        AppMethodBeat.o(103781);
        return true;
    }
}
