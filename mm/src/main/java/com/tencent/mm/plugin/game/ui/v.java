package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v implements View.OnClickListener {
    private Context mContext;
    private int mPosition;
    private int mScene = 13;
    private int xGR;
    private int xWQ;

    public v(Context context) {
        this.mContext = context;
    }

    public final void gL(int i2, int i3) {
        this.xGR = i2;
        this.xWQ = 1301;
        this.mPosition = i3;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(42415);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null) {
            a.a(this, "com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42415);
            return;
        }
        if (view.getTag() instanceof o) {
            o oVar = (o) view.getTag();
            if (!Util.isNullOrNil(oVar.xFe)) {
                String str = oVar.xFe.get(0).xGq;
                if (!Util.isNullOrNil(str)) {
                    f.a(this.mContext, this.mScene, this.xWQ, this.mPosition, c.aQ(this.mContext, str), 0, oVar.field_appId, this.xGR, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, f.a(null, null, oVar.xFX, null));
                } else {
                    Log.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
                }
            }
        } else if (view.getTag() instanceof String) {
            String str2 = (String) view.getTag();
            if (Util.isNullOrNil(str2)) {
                a.a(this, "com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42415);
                return;
            }
            f.a(this.mContext, this.mScene, this.xWQ, this.mPosition, c.aQ(this.mContext, str2), this.xGR, null);
        }
        a.a(this, "com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42415);
    }
}
