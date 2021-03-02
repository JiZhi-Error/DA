package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.game.report.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.au;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;

public final class t implements View.OnClickListener, i {
    private Context mContext;
    private c xEP = null;
    int xGR;
    DialogInterface.OnClickListener xWJ = null;

    public static class a {
        public String message;
        public String url;
        public String xWL;
        public String xWM;
    }

    public static class b {
        public String content;
        public String title;
        public Boolean xWN;
        public a xWO;
    }

    public t(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(42412);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!(view.getTag() instanceof c)) {
            Log.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42412);
            return;
        }
        this.xEP = (c) view.getTag();
        Log.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.xEP.field_appId);
        g.azz().a(1219, this);
        g.azz().a(new au(this.xEP.field_appId, LocaleUtil.getApplicationLanguage(), this.xEP.dDJ, this.xEP.xEg), 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSubscriptionClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42412);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(42413);
        if (i2 == 0 && i3 == 0 && qVar.getType() == 1219) {
            g.azz().b(1219, this);
            ag agVar = new ag(((au) qVar).hhm.iLL.iLR);
            b bVar = new b();
            bVar.xWN = Boolean.valueOf(agVar.xHx.xIO);
            bVar.title = agVar.xHx.Title;
            bVar.content = agVar.xHx.xJz;
            if (agVar.xHx.xNp != null) {
                bVar.xWO = new a();
                bVar.xWO.message = agVar.xHx.xNp.xJz;
                bVar.xWO.xWL = agVar.xHx.xNp.xJA;
                bVar.xWO.xWM = agVar.xHx.xNp.xJB;
                bVar.xWO.url = agVar.xHx.xNp.Url;
            }
            this.xEP.jyX = bVar.xWN.booleanValue();
            if (Util.isNullOrNil(bVar.title)) {
                AppMethodBeat.o(42413);
            } else if (bVar.xWO != null) {
                final String str2 = bVar.xWO.url;
                d.a aVar = new d.a(this.mContext);
                aVar.bon(bVar.title);
                aVar.boo(bVar.xWO.message);
                aVar.Dk(false);
                aVar.bou(bVar.xWO.xWL).a(true, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.game.ui.t.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(42411);
                        com.tencent.mm.plugin.game.e.c.aQ(t.this.mContext, str2);
                        f.a(t.this.mContext, t.this.xEP.scene, t.this.xEP.dYu, t.this.xEP.position, 17, t.this.xEP.field_appId, t.this.xGR, t.this.xEP.dDJ, t.this.xEP.xEl);
                        AppMethodBeat.o(42411);
                    }
                });
                aVar.bov(bVar.xWO.xWM).d(this.xWJ);
                aVar.hbn().show();
                AppMethodBeat.o(42413);
            } else if (Util.isNullOrNil(bVar.content)) {
                AppMethodBeat.o(42413);
            } else {
                d.a aVar2 = new d.a(this.mContext);
                aVar2.bon(bVar.title);
                aVar2.boo(bVar.content);
                aVar2.Dk(false);
                aVar2.aoV(R.string.dss).c(this.xWJ);
                aVar2.hbn().show();
                AppMethodBeat.o(42413);
            }
        } else {
            d.a aVar3 = new d.a(this.mContext);
            aVar3.aoS(R.string.dst);
            aVar3.aoV(R.string.dss);
            aVar3.hbn().show();
            AppMethodBeat.o(42413);
        }
    }
}
