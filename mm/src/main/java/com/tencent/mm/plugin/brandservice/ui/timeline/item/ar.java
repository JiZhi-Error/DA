package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ar extends ai {
    public ImageView ptE;
    public RelativeLayout pyv;

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai, com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void a(View view, b bVar) {
        AppMethodBeat.i(6057);
        super.a(view, bVar);
        if (this.puO != null) {
            AppMethodBeat.o(6057);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8f);
        if (viewStub == null) {
            AppMethodBeat.o(6057);
            return;
        }
        viewStub.inflate();
        this.puO = view.findViewById(R.id.a8d);
        this.ptQ = view.findViewById(R.id.isg);
        cmH();
        this.ptE = (ImageView) this.puO.findViewById(R.id.bh7);
        this.pyv = (RelativeLayout) this.puO.findViewById(R.id.bh8);
        this.ptR = (MMNeat7extView) this.puO.findViewById(R.id.ir3);
        this.ptG = (ImageView) this.puO.findViewById(R.id.bh9);
        this.ptS = (ImageView) this.puO.findViewById(R.id.ggb);
        this.ptT = (LinearLayout) this.puO.findViewById(R.id.a94);
        this.ptU = (LinearLayout) this.puO.findViewById(R.id.hse);
        this.ptV = (MMNeat7extView) this.puO.findViewById(R.id.hsc);
        this.ptW = (MMNeat7extView) this.puO.findViewById(R.id.hsa);
        this.pxz = this.puO.findViewById(R.id.i4s);
        this.pxA = (TextView) this.puO.findViewById(R.id.db0);
        d dVar = d.pMy;
        if (d.crj()) {
            d dVar2 = d.pMy;
            d.c(this.ptR);
        }
        d dVar3 = d.pMy;
        if (d.crj()) {
            d dVar4 = d.pMy;
            d.c(this.ptV);
        }
        AppMethodBeat.o(6057);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
    public final void a(int i2, final v vVar, final z zVar, final int i3, u uVar, int i4) {
        AppMethodBeat.i(6058);
        super.a(i2, vVar, zVar, i3, uVar, i4);
        this.mCount = i2;
        this.pxB = false;
        this.ptS.setVisibility(8);
        dw(this.pyv);
        dw(this.ptE);
        this.ptE.setVisibility(0);
        this.ptR.setTextColor(this.mContext.getResources().getColor(R.color.wu));
        this.ptT.setBackgroundResource(R.drawable.aij);
        this.ptY.setTextColor(this.mContext.getResources().getColor(R.color.wu));
        this.pxE.prc.a(zVar.field_msgId, 0, vVar, vVar.iAo, this.ptE, cnf(), b.prq, false, (m.a) new m.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.ar.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(6056);
                ar.this.pxB = true;
                ar.this.ptY.setTextColor(ar.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_9));
                if (ar.this.ptS != null) {
                    ar.this.ptS.setVisibility(0);
                }
                if (!ar.a(ar.this.mCount, vVar)) {
                    ar.this.ptR.setTextColor(ar.this.mContext.getResources().getColor(R.color.ag2));
                    if (ar.this.b(vVar)) {
                        ar.this.ptT.setBackgroundResource(R.drawable.im);
                    } else {
                        ar.this.ptT.setBackgroundResource(R.drawable.in);
                    }
                } else if (ar.this.pxC > 0) {
                    ar.this.ptT.setBackgroundResource(R.drawable.in);
                }
                ar.this.pxE.prc.m(zVar.field_msgId, i3);
                AppMethodBeat.o(6056);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
            }
        }, b(vVar), this.pxD);
        a(this.mCount, vVar, zVar);
        if (a(this.mCount, vVar)) {
            this.ptQ.setPadding(this.ptQ.getPaddingLeft(), 0, this.ptQ.getPaddingRight(), b.prv);
        } else {
            this.ptQ.setPadding(this.ptQ.getPaddingLeft(), 0, this.ptQ.getPaddingRight(), 0);
        }
        if (b(vVar)) {
            this.ptS.setBackgroundResource(R.drawable.hx);
            this.ptQ.setBackgroundResource(R.drawable.i1);
        } else {
            this.ptS.setBackgroundResource(R.drawable.hz);
            if (a(this.mCount, vVar)) {
                this.ptQ.setBackgroundResource(R.drawable.i1);
            } else {
                this.ptQ.setBackgroundResource(R.drawable.i7);
            }
        }
        if (!a(i2, vVar)) {
            a(this, zVar, vVar);
        }
        this.pxE.a(vVar, zVar, i3, uVar, this.ptQ, i2 > 1, 0);
        AppMethodBeat.o(6058);
    }
}
