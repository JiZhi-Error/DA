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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.protobuf.eg;
import com.tencent.mm.sdk.platformtools.Util;

public class GameNewClassifyView extends LinearLayout implements View.OnClickListener {
    private LayoutInflater kgB;
    private LinearLayout tmh;
    private int xGR;

    static class a {
        public String extInfo;
        public int position;
        public String url;

        public a(String str, int i2, String str2) {
            this.url = str;
            this.position = i2;
            this.extInfo = str2;
        }
    }

    public GameNewClassifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42314);
        super.onFinishInflate();
        this.kgB = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.tmh = (LinearLayout) findViewById(R.id.dh3);
        AppMethodBeat.o(42314);
    }

    public final void a(eg egVar, int i2, int i3) {
        AppMethodBeat.i(42315);
        if (egVar == null || Util.isNullOrNil(egVar.xKD)) {
            setVisibility(8);
            AppMethodBeat.o(42315);
            return;
        }
        this.xGR = i3;
        if (this.kgB == null) {
            this.kgB = (LayoutInflater) getContext().getSystemService("layout_inflater");
        }
        this.tmh.removeAllViews();
        while (this.tmh.getChildCount() < egVar.xKD.size()) {
            LinearLayout linearLayout = (LinearLayout) this.kgB.inflate(R.layout.as2, (ViewGroup) this, false);
            linearLayout.setOnClickListener(this);
            this.tmh.addView(linearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0f));
        }
        for (int i4 = 0; i4 < this.tmh.getChildCount(); i4++) {
            if (i4 < egVar.xKD.size()) {
                this.tmh.getChildAt(i4).setVisibility(0);
            } else {
                this.tmh.getChildAt(i4).setVisibility(8);
            }
        }
        for (int i5 = 0; i5 < egVar.xKD.size(); i5++) {
            LinearLayout linearLayout2 = (LinearLayout) this.tmh.getChildAt(i5);
            e.dWR().o((ImageView) linearLayout2.findViewById(R.id.ddi), egVar.xKD.get(i5).IconUrl);
            ((TextView) linearLayout2.findViewById(R.id.ddj)).setText(egVar.xKD.get(i5).Title);
            linearLayout2.setTag(new a(egVar.xKD.get(i5).xIy, i5 + 1, egVar.xKD.get(i5).xJt));
        }
        setVisibility(0);
        if (i2 == 2) {
            com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1019, 0, null, this.xGR, null);
        }
        AppMethodBeat.o(42315);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42316);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42316);
            return;
        }
        a aVar = (a) view.getTag();
        if (!Util.isNullOrNil(aVar.url)) {
            c.aQ(getContext(), aVar.url);
            f.a(getContext(), 10, 1019, aVar.position, 7, null, this.xGR, com.tencent.mm.plugin.game.d.a.Fh(aVar.extInfo));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42316);
    }
}
