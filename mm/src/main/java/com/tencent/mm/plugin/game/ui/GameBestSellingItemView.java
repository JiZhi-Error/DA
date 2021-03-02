package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.protobuf.ah;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.Util;

public class GameBestSellingItemView extends LinearLayout implements View.OnClickListener {
    AutoResizeTextView xOK;
    ImageView xOL;
    TextView xOM;
    GameTagListView xON;
    GameDownloadView xOO;
    View xOP;
    private int xOQ;
    private ah xOR;
    private d xOS;

    public GameBestSellingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(41890);
        super.onFinishInflate();
        this.xOK = (AutoResizeTextView) findViewById(R.id.di_);
        this.xOL = (ImageView) findViewById(R.id.dg3);
        this.xOM = (TextView) findViewById(R.id.dhv);
        this.xON = (GameTagListView) findViewById(R.id.ih7);
        this.xOO = (GameDownloadView) findViewById(R.id.dd5);
        this.xOP = findViewById(R.id.i22);
        this.xOQ = c.getScreenWidth(getContext()) - a.fromDPToPix(getContext(), (int) FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        setOnClickListener(this);
        AppMethodBeat.o(41890);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(41891);
        if (dVar == null || dVar.xEq == null || dVar.xEq.xKv == null || Util.isNullOrNil(dVar.xEq.xKv.xJs)) {
            setVisibility(8);
            AppMethodBeat.o(41891);
            return;
        }
        this.xOS = dVar;
        ah ahVar = dVar.xEq.xKv.xJs.get(dVar.xEr);
        int i2 = dVar.xEr + 1;
        if (ahVar == null || ahVar.xIz == null) {
            setVisibility(8);
        } else {
            this.xOR = ahVar;
            com.tencent.mm.plugin.game.model.c a2 = x.a(this.xOR.xIz);
            a2.scene = 10;
            a2.dYu = 1022;
            a2.position = this.xOS.xEr + 1;
            this.xOO.setDownloadInfo(new l(a2));
            setVisibility(0);
            this.xOK.setText(String.valueOf(i2));
            if (i2 == 1) {
                this.xOK.setTextColor(c.parseColor("#EED157"));
            } else if (i2 == 2) {
                this.xOK.setTextColor(c.parseColor("#BDC5CB"));
            } else if (i2 == 3) {
                this.xOK.setTextColor(c.parseColor("#D4B897"));
            } else {
                this.xOK.setTextColor(c.parseColor("#B2B2B2"));
            }
            e.dWR().c(this.xOL, ahVar.xIz.hik, a.getDensity(getContext()));
            this.xOM.setText(ahVar.xIz.Name);
            this.xON.h(ahVar.xIz.xIX, this.xOQ);
            if (Util.isNullOrNil(ahVar.xKe) && ahVar.xKf == null && ahVar.Desc == null) {
                this.xOP.setVisibility(8);
            } else {
                if (this.xOP instanceof ViewStub) {
                    this.xOP = ((ViewStub) this.xOP).inflate();
                }
                ((GameFeedSocialInfoView) this.xOP.findViewById(R.id.dip)).setData(ahVar);
            }
        }
        if (!dVar.xEs) {
            com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1022, dVar.xEr + 1, ahVar.xIz.hik, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(dVar.xEq.xJt));
            dVar.xEs = true;
        }
        AppMethodBeat.o(41891);
    }

    public void onClick(View view) {
        AppMethodBeat.i(41892);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xOR == null || Util.isNullOrNil(this.xOR.xIz.xIB)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41892);
            return;
        }
        f.a(getContext(), 10, 1022, this.xOS.xEr + 1, c.aQ(getContext(), this.xOR.xIz.xIB), this.xOR.xIz.hik, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41892);
    }
}
