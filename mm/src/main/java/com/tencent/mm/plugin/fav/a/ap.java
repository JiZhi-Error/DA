package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;

public final class ap implements n.a {
    private static n tbL = null;
    private static ap tbM = null;
    public int dLt;
    public int duration;
    public String path;

    public static ap cVm() {
        AppMethodBeat.i(103489);
        if (tbM == null) {
            tbM = new ap();
        }
        ap apVar = tbM;
        AppMethodBeat.o(103489);
        return apVar;
    }

    public static n cVo() {
        return tbL;
    }

    @Override // com.tencent.mm.plugin.fav.a.n.a
    public final void dt(String str, int i2) {
        AppMethodBeat.i(103491);
        Log.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 1);
        if (!Util.nullAs(str, "").equals(this.path)) {
            bundle.putBoolean("result", true);
        } else {
            bundle.putBoolean("result", false);
        }
        bundle.putInt("position", i2);
        od odVar = new od();
        odVar.dUq.dUl = bundle;
        odVar.dUq.type = 4;
        EventCenter.instance.publish(odVar);
        AppMethodBeat.o(103491);
    }

    @Override // com.tencent.mm.plugin.fav.a.n.a
    public final void onFinish() {
        AppMethodBeat.i(103492);
        tbL.stopPlay();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 2);
        od odVar = new od();
        odVar.dUq.dUl = bundle;
        odVar.dUq.type = 4;
        EventCenter.instance.publish(odVar);
        AppMethodBeat.o(103492);
    }

    @Override // com.tencent.mm.plugin.fav.a.n.a
    public final void onPause() {
        AppMethodBeat.i(103493);
        tbL.cUJ();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 3);
        od odVar = new od();
        odVar.dUq.dUl = bundle;
        odVar.dUq.type = 4;
        EventCenter.instance.publish(odVar);
        AppMethodBeat.o(103493);
    }

    public final void cVn() {
        AppMethodBeat.i(103490);
        if (tbL == null) {
            tbL = new n();
        }
        tbL.a(this);
        tbL.tbh = true;
        n nVar = tbL;
        if (n.qUq == null) {
            n.qUq = new SensorController(MMApplicationContext.getContext());
        }
        if (nVar.qUp == null) {
            nVar.qUp = new ShakeManager(MMApplicationContext.getContext());
        }
        AppMethodBeat.o(103490);
    }
}
