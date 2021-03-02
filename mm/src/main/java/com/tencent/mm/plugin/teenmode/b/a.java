package com.tencent.mm.plugin.teenmode.b;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a extends p {
    private long yAz = -1;

    public abstract void ebS();

    public a() {
        super(1, (u) null);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public void onClick(View view) {
        if (Util.ticksToNow(this.yAz) > 1000) {
            super.onClick(view);
            ebS();
        } else {
            Log.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
            setIsPressed(false);
        }
        this.yAz = Util.currentTicks();
    }
}
