package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedImageTextView extends LinearLayout implements View.OnClickListener {
    private int mEX = 0;
    private d xOS;
    private GameFeedTitleDescView xSc;
    private GameRoundImageView xSg;
    private LinearLayout xSk;
    private GameRoundImageView xSl;
    private GameRoundImageView xSm;
    private GameRoundImageView xSn;
    private TextView xSo;
    private GameFeedSubscriptView xSp;
    private int xSq = 0;
    private int xSr;

    public GameFeedImageTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42105);
        super.onFinishInflate();
        this.xSc = (GameFeedTitleDescView) findViewById(R.id.dfi);
        this.xSg = (GameRoundImageView) findViewById(R.id.a3g);
        this.xSk = (LinearLayout) findViewById(R.id.ht1);
        this.xSl = (GameRoundImageView) findViewById(R.id.d5b);
        this.xSm = (GameRoundImageView) findViewById(R.id.hfe);
        this.xSn = (GameRoundImageView) findViewById(R.id.ilj);
        this.xSo = (TextView) findViewById(R.id.fkd);
        this.xSp = (GameFeedSubscriptView) findViewById(R.id.ids);
        setOnClickListener(this);
        this.mEX = (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight();
        this.xSq = (this.mEX - (a.fromDPToPix(getContext(), 10) * 2)) / 3;
        this.xSr = a.fromDPToPix(getContext(), 105);
        if (this.xSq < this.xSr) {
            this.xSr = this.xSq;
        }
        ViewGroup.LayoutParams layoutParams = this.xSl.getLayoutParams();
        layoutParams.width = this.xSr;
        layoutParams.height = this.xSr;
        this.xSl.setLayoutParams(layoutParams);
        this.xSm.setLayoutParams(layoutParams);
        this.xSn.setLayoutParams(layoutParams);
        AppMethodBeat.o(42105);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(42106);
        if (dVar == null || dVar.xEq == null || dVar.xEq.xKp == null) {
            setVisibility(8);
            AppMethodBeat.o(42106);
            return;
        }
        this.xOS = dVar;
        ao aoVar = dVar.xEq;
        setVisibility(0);
        this.xSc.b(aoVar.xKp.Title, aoVar.xKp.iAc, null);
        if (!Util.isNullOrNil(aoVar.xKp.xMw)) {
            int size = aoVar.xKp.xMw.size();
            if (size == 1) {
                this.xSk.setVisibility(8);
                this.xSg.setVisibility(0);
                e.dWR().a(this.xSg, aoVar.xKp.xMw.get(0), getResources().getDimensionPixelSize(R.dimen.g5), getResources().getDimensionPixelSize(R.dimen.g4), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
            } else {
                this.xSg.setVisibility(8);
                this.xSk.setVisibility(0);
                this.xSo.setVisibility(8);
                e.a.C1397a aVar = new e.a.C1397a();
                aVar.xZt = true;
                e.a dWS = aVar.dWS();
                e.dWR().a(this.xSl, aoVar.xKp.xMw.get(0), dWS);
                e.dWR().a(this.xSm, aoVar.xKp.xMw.get(1), dWS);
                if (size > 2) {
                    e.dWR().a(this.xSn, aoVar.xKp.xMw.get(2), dWS);
                    this.xSn.setVisibility(0);
                    if (size > 3) {
                        this.xSo.setVisibility(0);
                        this.xSo.setText(String.format("共%d张", Integer.valueOf(size)));
                    }
                } else {
                    this.xSn.setVisibility(4);
                }
            }
        } else {
            this.xSg.setVisibility(8);
            this.xSk.setVisibility(8);
        }
        this.xSp.setData(aoVar);
        if (!this.xOS.xEs) {
            com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
            this.xOS.xEs = true;
        }
        AppMethodBeat.o(42106);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42107);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xOS == null || this.xOS.xEq == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42107);
            return;
        }
        if (!Util.isNullOrNil(this.xOS.xEq.xIy)) {
            f.a(getContext(), 10, 1024, this.xOS.position, c.aQ(getContext(), this.xOS.xEq.xIy), this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "card"));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42107);
    }
}
