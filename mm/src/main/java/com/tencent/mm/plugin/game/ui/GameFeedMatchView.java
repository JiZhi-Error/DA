package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedMatchView extends LinearLayout implements View.OnClickListener {
    private d xOS;
    private GameFeedTitleDescView xSc;
    private GameFeedSubscriptView xSp;
    private GameRoundImageView xSs;

    public GameFeedMatchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42109);
        super.onFinishInflate();
        this.xSc = (GameFeedTitleDescView) findViewById(R.id.dfi);
        this.xSs = (GameRoundImageView) findViewById(R.id.a3g);
        this.xSp = (GameFeedSubscriptView) findViewById(R.id.ids);
        setOnClickListener(this);
        AppMethodBeat.o(42109);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(42110);
        if (dVar == null || dVar.xEq == null || dVar.xEq.xKs == null) {
            setVisibility(8);
            AppMethodBeat.o(42110);
            return;
        }
        this.xOS = dVar;
        ao aoVar = dVar.xEq;
        setVisibility(0);
        this.xSc.b(aoVar.xKs.Title, aoVar.xKs.Desc, null);
        if (!Util.isNullOrNil(aoVar.xKs.xIx)) {
            this.xSs.setVisibility(0);
            e.dWR().a(this.xSs, aoVar.xKs.xIx, getResources().getDimensionPixelSize(R.dimen.gh), getResources().getDimensionPixelSize(R.dimen.gg), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        } else {
            setVisibility(8);
        }
        this.xSp.setData(aoVar);
        if (!this.xOS.xEs) {
            a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), a.Fh(this.xOS.xEq.xJt));
            this.xOS.xEs = true;
        }
        AppMethodBeat.o(42110);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42111);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xOS == null || this.xOS.xEq == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42111);
            return;
        }
        if (!Util.isNullOrNil(this.xOS.xEq.xIy)) {
            f.a(getContext(), 10, 1024, this.xOS.position, c.aQ(getContext(), this.xOS.xEq.xIy), this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), a.as(this.xOS.xEq.xJt, "clickType", "card"));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42111);
    }
}
