package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedNoGamePlayTemplate extends LinearLayout implements View.OnClickListener {
    private ImageView lIM;
    GameDownloadView xOO;
    private d xOS;
    private GameRoundImageView xSg;
    private ImageView xSh;
    private GameFeedTitleDescView xSt;
    private FrameLayout xSu;
    private RelativeLayout xSv;
    private TextView xSw;

    public GameFeedNoGamePlayTemplate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        AppMethodBeat.i(42120);
        super.onFinishInflate();
        this.xSt = (GameFeedTitleDescView) findViewById(R.id.dfi);
        this.xSu = (FrameLayout) findViewById(R.id.dw_);
        this.xSg = (GameRoundImageView) findViewById(R.id.bh5);
        this.xSh = (ImageView) findViewById(R.id.j5m);
        this.xSv = (RelativeLayout) findViewById(R.id.ddo);
        this.lIM = (ImageView) findViewById(R.id.dg3);
        this.xSw = (TextView) findViewById(R.id.dhv);
        this.xOO = (GameDownloadView) findViewById(R.id.dfc);
        setOnClickListener(this);
        this.xSu.setOnClickListener(this);
        AppMethodBeat.o(42120);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(42121);
        Log.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
        if (dVar == null || dVar.xEq == null || dVar.xEq.xKu == null) {
            setVisibility(8);
            AppMethodBeat.o(42121);
            return;
        }
        Log.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
        this.xOS = dVar;
        ao aoVar = dVar.xEq;
        setVisibility(0);
        this.xSt.b(aoVar.xKu.Title, aoVar.xKu.Desc, aoVar.xKu.xMV);
        this.xSu.setVisibility(0);
        if (!Util.isNullOrNil(aoVar.xKu.xIx)) {
            e.dWR().a(this.xSg, aoVar.xKu.xIx, getResources().getDimensionPixelSize(R.dimen.gh), getResources().getDimensionPixelSize(R.dimen.gg), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
            if (!Util.isNullOrNil(aoVar.xKu.xLk)) {
                this.xSh.setVisibility(0);
            } else {
                this.xSh.setVisibility(8);
            }
        } else {
            this.xSu.setVisibility(8);
        }
        if (aoVar.xKu.xIz != null) {
            this.xSv.setVisibility(0);
            e.dWR().c(this.lIM, aoVar.xKu.xIz.hik, a.getDensity(getContext()));
            this.xSw.setText(aoVar.xKu.xIz.Name);
            com.tencent.mm.plugin.game.model.c a2 = x.a(aoVar.xKu.xIz);
            a2.scene = 10;
            a2.dYu = 1024;
            a2.position = this.xOS.position;
            this.xOO.setDownloadInfo(new l(a2));
        }
        if (!this.xOS.xEs) {
            com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
            this.xOS.xEs = true;
        }
        AppMethodBeat.o(42121);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42122);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xOS == null || this.xOS.xEq == null || this.xOS.xEq.xKu == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42122);
        } else if (view.getId() != R.id.dw_ || Util.isNullOrNil(this.xOS.xEq.xKu.xLk)) {
            if (!Util.isNullOrNil(this.xOS.xEq.xIy)) {
                f.a(getContext(), 10, 1024, this.xOS.position, c.aQ(getContext(), this.xOS.xEq.xIy), this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "card"));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42122);
        } else {
            f.a(getContext(), 10, 1024, this.xOS.position, c.aQ(getContext(), this.xOS.xEq.xKu.xLk), this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "middle"));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42122);
        }
    }
}
