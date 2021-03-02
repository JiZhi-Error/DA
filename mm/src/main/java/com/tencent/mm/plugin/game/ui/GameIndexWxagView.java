package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.game.protobuf.eq;
import com.tencent.mm.sdk.platformtools.Log;

public class GameIndexWxagView extends LinearLayout implements View.OnClickListener {
    ViewGroup mContainer = this;
    LayoutInflater mInflater = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    int xGR;

    public GameIndexWxagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42174);
        setOrientation(1);
        AppMethodBeat.o(42174);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42175);
        super.onFinishInflate();
        Log.i("MicroMsg.GameIndexWxagView", "initView finished");
        AppMethodBeat.o(42175);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42176);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameIndexWxagView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameIndexWxagView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42176);
            return;
        }
        a aVar = (a) view.getTag();
        if (aVar.xTe == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameIndexWxagView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42176);
            return;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1079;
        ((r) g.af(r.class)).a(getContext(), aVar.xTe.UserName, aVar.xTe.jfi, aVar.xTe.xNR, 0, aVar.xTe.xut, appBrandStatObject);
        f.a(getContext(), 10, TXLiteAVCode.EVT_CAMERA_CLOSE, aVar.xHK, 30, aVar.xTe.jfi, this.xGR, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameIndexWxagView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42176);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public int xHK;
        public eq xTe;

        public a(int i2, eq eqVar) {
            this.xHK = i2;
            this.xTe = eqVar;
        }
    }
}
