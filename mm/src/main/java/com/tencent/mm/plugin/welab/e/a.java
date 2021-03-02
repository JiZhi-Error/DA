package com.tencent.mm.plugin.welab.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.sdk.event.EventCenter;

public final class a implements b {
    @Override // com.tencent.mm.plugin.welab.a.a.b
    public final void m(Activity activity, String str) {
        AppMethodBeat.i(30255);
        ec bbA = ((d) g.af(d.class)).bbA(str);
        wq wqVar = new wq();
        wqVar.ecI.userName = bbA.field_WeAppUser;
        wqVar.ecI.ecK = bbA.field_WeAppPath;
        wqVar.ecI.scene = 1051;
        wqVar.ecI.ecL = bbA.field_WeAppDebugMode;
        wqVar.ecI.dCw = String.format("%s:%s:%s:%s", (String) g.aAh().azQ().get(2, (Object) null), bbA.field_expId, bbA.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000));
        EventCenter.instance.publish(wqVar);
        AppMethodBeat.o(30255);
    }

    @Override // com.tencent.mm.plugin.welab.a.a.b
    public final String gjl() {
        return null;
    }

    @Override // com.tencent.mm.plugin.welab.a.a.b
    public final String gjm() {
        return null;
    }
}
