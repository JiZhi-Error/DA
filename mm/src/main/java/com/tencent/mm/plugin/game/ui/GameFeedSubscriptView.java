package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedSubscriptView extends LinearLayout implements View.OnClickListener {
    private ImageView qyu;
    private TextView rMV;
    private ao xSA;
    private TextView xSF;
    private TextView xSG;
    private LinearLayout xSH;
    private TextView xSI;
    private TextView xSJ;

    public GameFeedSubscriptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42131);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.aqf, (ViewGroup) this, true);
        this.xSF = (TextView) inflate.findViewById(R.id.eaf);
        this.xSG = (TextView) inflate.findViewById(R.id.eag);
        this.xSH = (LinearLayout) inflate.findViewById(R.id.xa);
        this.qyu = (ImageView) inflate.findViewById(R.id.wm);
        this.rMV = (TextView) inflate.findViewById(R.id.fz8);
        this.xSI = (TextView) inflate.findViewById(R.id.j19);
        this.xSJ = (TextView) inflate.findViewById(R.id.h7l);
        this.xSF.setOnClickListener(this);
        this.xSG.setOnClickListener(this);
        this.xSH.setOnClickListener(this);
        this.xSJ.setOnClickListener(this);
        AppMethodBeat.o(42131);
    }

    public void setData(ao aoVar) {
        AppMethodBeat.i(42132);
        if (aoVar == null || (aoVar.xKz == null && aoVar.xKA == null)) {
            setVisibility(8);
            AppMethodBeat.o(42132);
            return;
        }
        this.xSA = aoVar;
        setVisibility(0);
        this.xSF.setVisibility(8);
        this.xSG.setVisibility(8);
        this.xSH.setVisibility(8);
        if (aoVar.xKz != null) {
            switch (aoVar.xKz.xJF) {
                case 1:
                    this.xSG.setVisibility(0);
                    this.xSG.setText(aoVar.xKz.Desc);
                    break;
                case 2:
                    this.xSF.setVisibility(0);
                    this.xSF.setText(aoVar.xKz.Desc);
                    break;
                case 3:
                    this.xSH.setVisibility(0);
                    if (!Util.isNullOrNil(aoVar.xKz.xJE)) {
                        e.a.C1397a aVar = new e.a.C1397a();
                        aVar.iaT = true;
                        e.dWR().a(this.qyu, aoVar.xKz.xJE, aVar.dWS());
                        this.qyu.setVisibility(0);
                    }
                    this.rMV.setText(aoVar.xKz.Name);
                    this.xSI.setText(aoVar.xKz.Desc);
                    break;
            }
        }
        if (aoVar.xKA != null) {
            this.xSJ.setText(aoVar.xKA.Desc);
            this.xSJ.setVisibility(0);
            AppMethodBeat.o(42132);
            return;
        }
        this.xSJ.setVisibility(8);
        AppMethodBeat.o(42132);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42133);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xSA == null) {
            a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42133);
            return;
        }
        if (view.getId() == R.id.eaf || view.getId() == R.id.eag || view.getId() == R.id.xa) {
            if (this.xSA.xKz != null && !Util.isNullOrNil(this.xSA.xKz.xIy)) {
                c.aQ(getContext(), this.xSA.xKz.xIy);
                Ow(1);
            }
        } else if (view.getId() == R.id.h7l && this.xSA.xKA != null && !Util.isNullOrNil(this.xSA.xKA.xIy)) {
            c.aQ(getContext(), this.xSA.xKA.xIy);
            Ow(2);
        }
        a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42133);
    }

    private void Ow(int i2) {
        String as;
        AppMethodBeat.i(42134);
        if (i2 == 1) {
            as = com.tencent.mm.plugin.game.d.a.as(this.xSA.xJt, "clickType", "leftCorner");
        } else {
            as = com.tencent.mm.plugin.game.d.a.as(this.xSA.xJt, "clickType", "rightCorner");
        }
        f.a(getContext(), 10, 1024, this.xSA.xJv, 7, this.xSA.jfi, GameIndexListView.getSourceScene(), as);
        AppMethodBeat.o(42134);
    }
}
