package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k implements View.OnClickListener, AdapterView.OnItemClickListener {
    protected int xGR = 0;

    public final void setSourceScene(int i2) {
        this.xGR = i2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(42194);
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        a.b("com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        Object item = adapterView.getAdapter().getItem(i2);
        if (item == null || !(item instanceof c)) {
            a.a(this, "com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(42194);
            return;
        }
        c cVar = (c) item;
        if (Util.isNullOrNil(cVar.field_appId)) {
            a.a(this, "com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(42194);
            return;
        }
        a(view.getContext(), cVar);
        a.a(this, "com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(42194);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(42195);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null || !(view.getTag() instanceof c)) {
            a.a(this, "com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42195);
            return;
        }
        a(view.getContext(), (c) view.getTag());
        a.a(this, "com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42195);
    }

    private void a(Context context, c cVar) {
        AppMethodBeat.i(42196);
        int i2 = 0;
        if (cVar.type == 1) {
            i2 = com.tencent.mm.plugin.game.e.c.aQ(context, cVar.xDX);
        } else if (cVar.type == 0) {
            if (cVar.dUP() && !Util.isNullOrNil(cVar.xEo.xIy) && !h.a(context, cVar)) {
                i2 = com.tencent.mm.plugin.game.e.c.aQ(context, cVar.xEo.xIy);
            } else if (Util.isNullOrNil(cVar.fmK) || cVar.fmN != 4) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", cVar.field_appId);
                if (cVar.dYu == 1601) {
                    bundle.putInt("game_report_from_scene", this.xGR);
                } else {
                    bundle.putInt("game_report_from_scene", cVar.dYu);
                }
                i2 = com.tencent.mm.plugin.game.e.c.b(context, cVar.field_appId, cVar.xDX, bundle);
            } else {
                Log.i("MicroMsg.GameItemClickListener", "Download via Google Play");
                r.ck(context, cVar.fmK);
                i2 = 25;
            }
        }
        a(context, cVar, i2);
        AppMethodBeat.o(42196);
    }

    private void a(Context context, c cVar, int i2) {
        AppMethodBeat.i(42197);
        f.a(context, cVar.scene, cVar.dYu, cVar.position, i2, cVar.field_appId, this.xGR, cVar.dDJ, cVar.xEl);
        AppMethodBeat.o(42197);
    }
}
