package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class j extends a {
    public static float JKY = Resources.getSystem().getDisplayMetrics().density;
    public static int qOF = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static int qOG = ((int) ((40.0f * JKY) + 0.5f));
    public WXRTEditText JKW;
    public WXRTEditText JKX;
    public ImageView dKU;
    public LinearLayout kmg;
    public LinearLayout qOA;
    public LinearLayout qOB;
    public LinearLayout qOC;
    public LinearLayout qOD;
    public View.OnClickListener qOH = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.j.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(30869);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (j.this.JJu.JIH == 2) {
                j.this.JJu.JIy.gkf().cCA();
                j.this.JJu.gjT();
            }
            int lR = ((RecyclerView.v) view.getTag()).lR();
            oc ocVar = new oc();
            if (c.gjL().ahp(lR) == null) {
                Log.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", Integer.valueOf(lR), Integer.valueOf(c.gjL().size()));
                a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30869);
            } else if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL == null) {
                Log.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
                a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30869);
            } else {
                Log.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", Integer.valueOf(c.gjL().ahp(lR).getType()));
                ocVar.dUe.dUg = ((o) c.gjL().ahp(lR)).qPN;
                ocVar.dUe.context = view.getContext();
                ocVar.dUe.type = 1;
                com.tencent.mm.plugin.wenote.model.c.gjz().JGL.b(ocVar);
                a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30869);
            }
        }
    };
    public LinearLayout qOs;
    public TextView qOt;
    public TextView qOu;
    public ImageView qOv;
    public View qOw;
    public LinearLayout qOx;
    public LinearLayout qOy;
    public LinearLayout qOz;

    public j(View view, k kVar) {
        super(view, kVar);
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
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.j.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(30866);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.gjW().cDY();
                a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30866);
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
        this.JKX = (WXRTEditText) view.findViewById(R.id.aed);
        this.JKW = (WXRTEditText) view.findViewById(R.id.aef);
        ((LinearLayout) view.findViewById(R.id.aee)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.j.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(30867);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                j.this.JKX.cDF();
                j.this.JKX.requestFocus();
                a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30867);
            }
        });
        ((LinearLayout) view.findViewById(R.id.aeg)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.j.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(30868);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                j.this.JKW.cDF();
                j.this.JKW.requestFocus();
                a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30868);
            }
        });
        this.JKX.setEditTextType(2);
        this.JKW.setEditTextType(1);
        this.JKW.qRh = this;
        this.JKX.qRh = this;
        if (kVar.JIH != 2 || !this.JJu.JII) {
            this.JKX.setKeyListener(null);
            this.JKX.setEnabled(false);
            this.JKX.setFocusable(false);
            this.JKW.setKeyListener(null);
            this.JKW.setEnabled(false);
            this.JKW.setFocusable(false);
        }
        this.JJu.q(this.JKW);
        this.JJu.q(this.JKX);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public void a(com.tencent.mm.plugin.wenote.model.a.c cVar, int i2, int i3) {
        Log.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + lQ());
        this.JKW.setPosInDataList(i2);
        this.JKX.setPosInDataList(i2);
        if (e.isEnabled()) {
            e.gjW().a(this.qOB, this.qOC, this.qOD, i2);
        }
        cVar.JHJ = this.JKW;
        cVar.JHK = this.JKX;
        cVar.JHL = null;
        if (!cVar.qPA) {
            if (this.JKW.hasFocus()) {
                this.JKW.clearFocus();
            }
            if (this.JKX.hasFocus()) {
                this.JKX.clearFocus();
            }
        } else if (cVar.qPG) {
            this.JKW.requestFocus();
        } else {
            this.JKX.requestFocus();
        }
        if (this.qOs.getVisibility() != 0) {
            return;
        }
        if (cVar.qPH) {
            this.qOs.setBackgroundResource(R.drawable.b5h);
        } else {
            this.qOs.setBackgroundResource(R.drawable.b5g);
        }
    }
}
