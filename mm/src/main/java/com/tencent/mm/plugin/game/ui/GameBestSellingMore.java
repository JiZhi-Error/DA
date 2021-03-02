package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.Util;

public class GameBestSellingMore extends LinearLayout implements View.OnClickListener {
    private d xOS;
    private TextView xOT;
    private ImageView xOU;

    public GameBestSellingMore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(41894);
        super.onFinishInflate();
        this.xOT = (TextView) findViewById(R.id.fkc);
        this.xOU = (ImageView) findViewById(R.id.fkb);
        setOnClickListener(this);
        AppMethodBeat.o(41894);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(41895);
        this.xOS = dVar;
        if (dVar == null || dVar.xEq == null || dVar.xEq.xKv == null || Util.isNullOrNil(dVar.xEq.xKv.xKE)) {
            this.xOT.setVisibility(8);
            this.xOU.setVisibility(8);
            setPadding(0, 0, 0, 0);
            AppMethodBeat.o(41895);
            return;
        }
        setPadding(getResources().getDimensionPixelSize(R.dimen.g_), 0, getResources().getDimensionPixelSize(R.dimen.g_), getResources().getDimensionPixelSize(R.dimen.g_));
        this.xOT.setVisibility(0);
        this.xOU.setVisibility(0);
        this.xOT.setText(dVar.xEq.xKv.xKE);
        AppMethodBeat.o(41895);
    }

    public void onClick(View view) {
        AppMethodBeat.i(41896);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xOS == null || this.xOS.xEq == null || this.xOS.xEq.xKv == null || Util.isNullOrNil(this.xOS.xEq.xKv.xLg)) {
            a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41896);
            return;
        }
        f.a(getContext(), 10, 1022, 999, c.aQ(getContext(), this.xOS.xEq.xKv.xLg), null, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
        a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41896);
    }
}
