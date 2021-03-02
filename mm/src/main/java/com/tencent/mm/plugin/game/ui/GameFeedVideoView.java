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
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedVideoView extends LinearLayout implements View.OnClickListener {
    private d xOS;
    private GameRoundImageView xSL;
    private LinearLayout xSM;
    private ImageView xSN;
    private TextView xSO;
    private GameFeedTitleDescView xSc;
    private FrameLayout xSf;
    private GameFeedSubscriptView xSp;

    public GameFeedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42140);
        super.onFinishInflate();
        this.xSc = (GameFeedTitleDescView) findViewById(R.id.dfi);
        this.xSf = (FrameLayout) findViewById(R.id.j5a);
        this.xSL = (GameRoundImageView) findViewById(R.id.j49);
        this.xSM = (LinearLayout) findViewById(R.id.j4d);
        this.xSN = (ImageView) findViewById(R.id.j6c);
        this.xSO = (TextView) findViewById(R.id.j4e);
        this.xSp = (GameFeedSubscriptView) findViewById(R.id.ids);
        setOnClickListener(this);
        AppMethodBeat.o(42140);
    }

    public void setVideoData(d dVar) {
        AppMethodBeat.i(42141);
        if (dVar == null || dVar.xEq == null || dVar.xEq.xKq == null || Util.isNullOrNil(dVar.xEq.xKq.xIx)) {
            setVisibility(8);
            AppMethodBeat.o(42141);
            return;
        }
        this.xOS = dVar;
        ao aoVar = dVar.xEq;
        setVisibility(0);
        this.xSc.b(aoVar.xKq.Title, aoVar.xKq.Desc, null);
        e.dWR().a(this.xSL, aoVar.xKq.xIx, getResources().getDimensionPixelSize(R.dimen.g5), getResources().getDimensionPixelSize(R.dimen.g4), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        if (!Util.isNullOrNil(aoVar.xKq.xNI)) {
            this.xSM.setVisibility(0);
            this.xSN.setVisibility(8);
            this.xSO.setText(aoVar.xKq.xNI);
        } else {
            this.xSM.setVisibility(8);
        }
        this.xSp.setData(aoVar);
        AppMethodBeat.o(42141);
    }

    public void setLiveData(d dVar) {
        AppMethodBeat.i(42142);
        if (dVar == null || dVar.xEq == null || dVar.xEq.xKr == null) {
            setVisibility(8);
            AppMethodBeat.o(42142);
            return;
        }
        this.xOS = dVar;
        ao aoVar = dVar.xEq;
        setVisibility(0);
        this.xSc.b(aoVar.xKr.Title, aoVar.xKr.Desc, null);
        if (!Util.isNullOrNil(aoVar.xKr.xIx)) {
            this.xSf.setVisibility(0);
            e.dWR().a(this.xSL, aoVar.xKr.xIx, getResources().getDimensionPixelSize(R.dimen.g5), getResources().getDimensionPixelSize(R.dimen.g4), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        } else {
            this.xSf.setVisibility(8);
        }
        if (!Util.isNullOrNil(aoVar.xKr.xMJ)) {
            this.xSM.setVisibility(0);
            this.xSN.setVisibility(0);
            this.xSO.setText(aoVar.xKr.xMJ);
        } else {
            this.xSM.setVisibility(8);
        }
        this.xSp.setData(aoVar);
        if (!this.xOS.xEs) {
            a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), a.Fh(this.xOS.xEq.xJt));
            this.xOS.xEs = true;
        }
        AppMethodBeat.o(42142);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42143);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xOS == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42143);
            return;
        }
        if (!Util.isNullOrNil(this.xOS.xEq.xIy)) {
            f.a(getContext(), 10, 1024, this.xOS.position, c.aQ(getContext(), this.xOS.xEq.xIy), this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), a.as(this.xOS.xEq.xJt, "clickType", "card"));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42143);
    }
}
