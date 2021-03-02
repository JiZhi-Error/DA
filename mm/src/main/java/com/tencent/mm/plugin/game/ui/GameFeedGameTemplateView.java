package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;

public class GameFeedGameTemplateView extends LinearLayout implements View.OnClickListener {
    private TextView jVn;
    private int xOQ;
    private d xOS;
    private ImageView xQM;
    private TextView xQN;
    private GameTagListView xSe;
    private FrameLayout xSf;
    private GameRoundImageView xSg;
    private ImageView xSh;
    private GameFeedSubscriptView xSi;
    private GameDownloadView xSj;

    public GameFeedGameTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42098);
        super.onFinishInflate();
        this.xQM = (ImageView) findViewById(R.id.dg3);
        this.xQN = (TextView) findViewById(R.id.dhv);
        this.xSe = (GameTagListView) findViewById(R.id.dis);
        this.jVn = (TextView) findViewById(R.id.bmr);
        this.xSf = (FrameLayout) findViewById(R.id.j5a);
        this.xSg = (GameRoundImageView) findViewById(R.id.dup);
        this.xSh = (ImageView) findViewById(R.id.j5m);
        this.xSi = (GameFeedSubscriptView) findViewById(R.id.ids);
        this.xSj = (GameDownloadView) findViewById(R.id.dfc);
        setOnClickListener(this);
        this.xOQ = c.getScreenWidth(getContext()) - a.fromDPToPix(getContext(), (int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5);
        AppMethodBeat.o(42098);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(42099);
        super.onDetachedFromWindow();
        AppMethodBeat.o(42099);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(42100);
        super.onAttachedToWindow();
        AppMethodBeat.o(42100);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(42101);
        if (dVar == null || dVar.xEq == null || dVar.xEq.xKt == null) {
            setVisibility(8);
            AppMethodBeat.o(42101);
            return;
        }
        this.xOS = dVar;
        ao aoVar = dVar.xEq;
        setVisibility(0);
        e.dWR().c(this.xQM, aoVar.xKt.xIz.hik, a.getDensity(getContext()));
        this.xQN.setText(aoVar.xKt.xIz.Name);
        this.xSe.h(aoVar.xKt.xIz.xIX, this.xOQ);
        if (!Util.isNullOrNil(aoVar.xKt.xLi)) {
            this.jVn.setText(aoVar.xKt.xLi);
            this.jVn.setVisibility(0);
        } else {
            this.jVn.setVisibility(8);
        }
        this.xSf.setVisibility(0);
        if (!Util.isNullOrNil(aoVar.xKt.xLk)) {
            j(this.xSg, aoVar.xKt.xIx);
            this.xSh.setVisibility(0);
        } else if (!Util.isNullOrNil(aoVar.xKt.xIx)) {
            j(this.xSg, aoVar.xKt.xIx);
            this.xSh.setVisibility(8);
        } else {
            this.xSf.setVisibility(8);
        }
        this.xSf.setOnClickListener(this);
        this.xSi.setData(aoVar);
        com.tencent.mm.plugin.game.model.c a2 = x.a(this.xOS.xEq.xKt.xIz);
        a2.scene = 10;
        a2.dYu = 1024;
        a2.position = this.xOS.position;
        this.xSj.setDownloadInfo(new l(a2));
        if (!this.xOS.xEs) {
            com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
            this.xOS.xEs = true;
        }
        AppMethodBeat.o(42101);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42102);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xOS == null || this.xOS.xEq == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42102);
        } else if (view.getId() != R.id.j5a || Util.isNullOrNil(this.xOS.xEq.xKt.xLj)) {
            if (!Util.isNullOrNil(this.xOS.xEq.xIy)) {
                f.a(getContext(), 10, 1024, this.xOS.position, c.aQ(getContext(), this.xOS.xEq.xIy), this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "card"));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42102);
        } else {
            f.a(getContext(), 10, 1024, this.xOS.position, c.aQ(getContext(), this.xOS.xEq.xKt.xLj), this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "middle"));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42102);
        }
    }

    private void j(ImageView imageView, String str) {
        AppMethodBeat.i(42103);
        e.dWR().a(imageView, str, getResources().getDimensionPixelSize(R.dimen.gh), getResources().getDimensionPixelSize(R.dimen.gg), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        AppMethodBeat.o(42103);
    }
}
