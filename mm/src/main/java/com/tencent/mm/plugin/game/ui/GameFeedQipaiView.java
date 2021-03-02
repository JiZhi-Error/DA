package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.ay;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public class GameFeedQipaiView extends LinearLayout implements View.OnClickListener {
    private TextView mPa;
    private ao xSA;
    private TextView xSx;
    private ImageView xSy;
    private LinearLayout xSz;

    public GameFeedQipaiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42124);
        super.onFinishInflate();
        this.mPa = (TextView) findViewById(R.id.ipm);
        this.xSx = (TextView) findViewById(R.id.fk8);
        this.xSy = (ImageView) findViewById(R.id.fjt);
        this.xSz = (LinearLayout) findViewById(R.id.dgf);
        this.xSx.setOnClickListener(this);
        AppMethodBeat.o(42124);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(42125);
        if (dVar == null || dVar.xEq == null || dVar.xEq.xKy == null) {
            setVisibility(8);
            AppMethodBeat.o(42125);
            return;
        }
        ao aoVar = dVar.xEq;
        setVisibility(0);
        this.xSA = aoVar;
        if (!Util.isNullOrNil(aoVar.xKy.Title)) {
            this.mPa.setText(aoVar.xKy.Title);
            this.mPa.setVisibility(0);
        } else {
            this.mPa.setVisibility(8);
        }
        if (!Util.isNullOrNil(aoVar.xKy.xKE)) {
            this.xSy.setVisibility(0);
            this.xSx.setVisibility(0);
            this.xSx.setText(aoVar.xKy.xKE);
        } else {
            this.xSx.setVisibility(8);
            this.xSy.setVisibility(8);
        }
        this.xSz.removeAllViews();
        if (!Util.isNullOrNil(aoVar.xKy.xJs)) {
            Iterator<ay> it = aoVar.xKy.xJs.iterator();
            while (it.hasNext()) {
                ay next = it.next();
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.aoz, (ViewGroup) this, false);
                inflate.setOnClickListener(this);
                inflate.setTag(Integer.valueOf(aoVar.xKy.xJs.indexOf(next)));
                this.xSz.addView(inflate, new LinearLayout.LayoutParams(-1, -2, 1.0f));
                ((TextView) inflate.findViewById(R.id.gvg)).setVisibility(8);
                e.dWR().o((ImageView) inflate.findViewById(R.id.gvd), next.xKV);
                ((TextView) inflate.findViewById(R.id.gvf)).setText(next.Title);
                ((TextView) inflate.findViewById(R.id.gvc)).setText(next.Desc);
            }
        }
        if (!dVar.xEs) {
            a.b(getContext(), 10, TXLiteAVCode.EVT_CAMERA_REMOVED, dVar.position, dVar.xEq.jfi, GameIndexListView.getSourceScene(), a.Fh(dVar.xEq.xJt));
            dVar.xEs = true;
        }
        AppMethodBeat.o(42125);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42126);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xSA == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42126);
        } else if (view.getId() == R.id.fk8) {
            if (!Util.isNullOrNil(this.xSA.xKy.xLg)) {
                f.a(getContext(), 10, TXLiteAVCode.EVT_CAMERA_REMOVED, 999, c.aQ(getContext(), this.xSA.xKy.xLg), null, GameIndexListView.getSourceScene(), a.Fh(this.xSA.xJt));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42126);
        } else {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue < 0 || intValue > this.xSA.xKy.xJs.size() - 1) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42126);
                return;
            }
            ay ayVar = this.xSA.xKy.xJs.get(intValue);
            if (!Util.isNullOrNil(ayVar.xIy)) {
                f.a(getContext(), 10, TXLiteAVCode.EVT_CAMERA_REMOVED, intValue + 1, c.aQ(getContext(), ayVar.xIy), ayVar.jfi, GameIndexListView.getSourceScene(), a.Fh(this.xSA.xJt));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42126);
        }
    }
}
