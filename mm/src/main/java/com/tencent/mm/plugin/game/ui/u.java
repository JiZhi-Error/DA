package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u implements View.OnClickListener {
    private Context mContext;
    int xGR = 0;
    private c xGY;
    String xOl = null;
    private int xWP;

    public u(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        int a2;
        int i2;
        AppMethodBeat.i(42414);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!(view.getTag() instanceof c)) {
            Log.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
            a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42414);
            return;
        }
        this.xGY = (c) view.getTag();
        Log.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.xGY.field_appId);
        if (h.s(this.mContext, this.xGY.field_appId)) {
            Log.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.xGY.field_appId + ", pkg = " + this.xGY.field_packageName + ", openId = " + this.xGY.field_openId);
            f.a(this.mContext, this.xGY.scene, this.xGY.dYu, this.xGY.position, 3, this.xGY.field_appId, this.xGR, this.xOl);
            e.at(this.mContext, this.xGY.field_appId);
            a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42414);
            return;
        }
        aw.dVY();
        String str = this.xGY.fmP;
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
            a2 = -1;
        } else {
            a2 = aw.a(new aw.a((byte) 0).aAp(str));
        }
        this.xWP = a2;
        String str2 = this.xGY.fmP;
        if (!Util.isNullOrNil(str2)) {
            str2 = str2.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
        }
        if (this.xGY.status == 3) {
            aw.dVY();
            aw.startToAuthorized(this.mContext, str2);
        } else {
            aw.dVY();
            aw.aP(this.mContext, str2);
        }
        int i3 = 5;
        if (this.xGY.status == 3) {
            i3 = 10;
        }
        if (this.xWP == 4) {
            i2 = 8;
        } else {
            i2 = i3;
        }
        f.a(this.mContext, this.xGY.scene, this.xGY.dYu, this.xGY.position, i2, this.xGY.field_appId, this.xGR, this.xGY.dDJ, this.xOl);
        a.a(this, "com/tencent/mm/plugin/game/ui/GameTMAssistClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42414);
    }
}
