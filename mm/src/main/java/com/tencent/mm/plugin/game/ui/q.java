package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q implements View.OnClickListener {
    int gwE;
    protected Context mContext;
    private c xEP;
    String xVz = null;

    public q(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(42340);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!(view.getTag() instanceof c)) {
            Log.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
            a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42340);
            return;
        }
        this.xEP = (c) view.getTag();
        Log.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.xEP.field_appId);
        if (h.s(this.mContext, this.xEP.field_appId)) {
            Log.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.xEP.field_appId + ", pkg = " + this.xEP.field_packageName + ", openId = " + this.xEP.field_openId);
            e.at(this.mContext, this.xEP.field_appId);
            f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 3, this.xEP.field_appId, this.gwE, this.xEP.dDJ, this.xEP.xEl);
            a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42340);
            return;
        }
        Log.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", this.xVz);
        if (!Util.isNullOrNil(this.xVz)) {
            com.tencent.mm.plugin.game.e.c.aQ(this.mContext, this.xVz);
            f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 11, this.xEP.field_appId, this.gwE, this.xEP.dDJ, this.xEP.xEl);
        } else {
            Log.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
        }
        a.a(this, "com/tencent/mm/plugin/game/ui/GamePreemptiveCliclListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42340);
    }
}
