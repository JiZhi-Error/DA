package com.tencent.mm.plugin.editor.adapter.a;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.editor.model.nativenote.c.e;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d extends a {
    public static float qOE = Resources.getSystem().getDisplayMetrics().density;
    public static int qOF = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static int qOG = ((int) ((40.0f * qOE) + 0.5f));
    public ImageView dKU;
    public LinearLayout kmg;
    public LinearLayout qOA;
    public LinearLayout qOB;
    public LinearLayout qOC;
    public LinearLayout qOD;
    public View.OnClickListener qOH = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.editor.adapter.a.d.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(181651);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d.this.qNG.qRL.cCK().cCA();
            a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(181651);
        }
    };
    public WXRTEditText qOq;
    public WXRTEditText qOr;
    public LinearLayout qOs;
    public TextView qOt;
    public TextView qOu;
    public ImageView qOv;
    public View qOw;
    public LinearLayout qOx;
    public LinearLayout qOy;
    public LinearLayout qOz;

    public d(View view, j jVar) {
        super(view, jVar);
        this.dKU = (ImageView) view.findViewById(R.id.bvs);
        this.qOw = view.findViewById(R.id.j42);
        this.qOs = (LinearLayout) view.findViewById(R.id.g17);
        this.kmg = (LinearLayout) view.findViewById(R.id.g1w);
        this.qOt = (TextView) view.findViewById(R.id.g18);
        this.qOu = (TextView) view.findViewById(R.id.g15);
        this.qOv = (ImageView) view.findViewById(R.id.g16);
        this.qOt.setTextSize(16.0f);
        this.qOu.setTextSize(12.0f);
        this.qOx = (LinearLayout) view.findViewById(R.id.g1u);
        this.qOx.setVisibility(8);
        this.qOz = (LinearLayout) view.findViewById(R.id.g1p);
        this.qOz.setVisibility(8);
        this.qOA = (LinearLayout) view.findViewById(R.id.g14);
        this.qOA.setVisibility(8);
        this.qOB = (LinearLayout) view.findViewById(R.id.g7d);
        this.qOB.setBackgroundColor(1347529272);
        this.qOB.setVisibility(8);
        this.qOB.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.adapter.a.d.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(181648);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.cDT().cDY();
                a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181648);
            }
        });
        this.qOC = (LinearLayout) view.findViewById(R.id.g7l);
        this.qOC.setBackgroundColor(1347529272);
        this.qOC.setVisibility(4);
        this.qOD = (LinearLayout) view.findViewById(R.id.g7g);
        this.qOD.setBackgroundColor(1347529272);
        this.qOD.setVisibility(4);
        this.qOy = (LinearLayout) view.findViewById(R.id.bwc);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.qOy.getLayoutParams();
        layoutParams.width = qOF - qOG;
        layoutParams.height = -2;
        this.qOy.setLayoutParams(layoutParams);
        this.qOr = (WXRTEditText) view.findViewById(R.id.aed);
        this.qOq = (WXRTEditText) view.findViewById(R.id.aef);
        ((LinearLayout) view.findViewById(R.id.aee)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.adapter.a.d.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(181649);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.this.qOr.cDF();
                d.this.qOr.requestFocus();
                a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181649);
            }
        });
        ((LinearLayout) view.findViewById(R.id.aeg)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.adapter.a.d.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(181650);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.this.qOq.cDF();
                d.this.qOq.requestFocus();
                a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181650);
            }
        });
        this.qOr.setEditTextType(2);
        this.qOq.setEditTextType(1);
        this.qOq.qRh = this;
        this.qOr.qRh = this;
        if (!this.qNG.qRR) {
            this.qOr.setKeyListener(null);
            this.qOr.setEnabled(false);
            this.qOr.setFocusable(false);
            this.qOq.setKeyListener(null);
            this.qOq.setEnabled(false);
            this.qOq.setFocusable(false);
        }
        this.qNG.q(this.qOq);
        this.qNG.q(this.qOr);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.a
    public void a(com.tencent.mm.plugin.editor.model.a.a aVar, int i2, int i3) {
        Log.i("MicroMsg.EditorOtherItemHolder", "ImageItemHolder position is " + lQ());
        this.qOq.setPosInDataList(i2);
        this.qOr.setPosInDataList(i2);
        if (e.isEnabled()) {
            e.cDT().a(this.qOB, this.qOC, this.qOD, i2);
        }
        aVar.qPD = this.qOq;
        aVar.qPE = this.qOr;
        aVar.qPF = null;
        if (!aVar.qPA) {
            if (this.qOq.hasFocus()) {
                this.qOq.clearFocus();
            }
            if (this.qOr.hasFocus()) {
                this.qOr.clearFocus();
            }
        } else if (aVar.qPG) {
            this.qOq.requestFocus();
        } else {
            this.qOr.requestFocus();
        }
        if (this.qOs.getVisibility() != 0) {
            return;
        }
        if (aVar.qPH) {
            this.qOs.setBackgroundResource(R.drawable.sl);
        } else {
            this.qOs.setBackgroundResource(R.drawable.sk);
        }
    }
}
