package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedAddTopicView extends LinearLayout implements View.OnClickListener {
    private d xOS;
    private GameFeedTitleDescView xSc;
    private TextView xSd;

    public GameFeedAddTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42094);
        super.onFinishInflate();
        this.xSc = (GameFeedTitleDescView) findViewById(R.id.dfi);
        this.xSd = (TextView) findViewById(R.id.gy);
        setOnClickListener(this);
        AppMethodBeat.o(42094);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(42095);
        if (dVar == null || dVar.xEq == null || dVar.xEq.xKw == null) {
            setVisibility(8);
            AppMethodBeat.o(42095);
            return;
        }
        this.xOS = dVar;
        setVisibility(0);
        this.xSc.b(dVar.xEq.xKw.Title, dVar.xEq.xKw.Desc, null);
        this.xSd.setText(dVar.xEq.xKw.xJG);
        if (!this.xOS.xEs) {
            a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), a.Fh(this.xOS.xEq.xJt));
            this.xOS.xEs = true;
        }
        AppMethodBeat.o(42095);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42096);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xOS == null || this.xOS.xEq == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42096);
            return;
        }
        if (!Util.isNullOrNil(this.xOS.xEq.xIy)) {
            f.a(getContext(), 10, 1024, this.xOS.position, c.aQ(getContext(), this.xOS.xEq.xIy), this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), a.as(this.xOS.xEq.xJt, "clickType", "card"));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42096);
    }
}
