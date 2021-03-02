package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;

public final class at extends ai {
    public ImageView kc;
    public ImageView ptE;
    public TextView pub;
    public View puc;
    public View pud;
    private String pyB = "";

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai, com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void a(View view, b bVar) {
        AppMethodBeat.i(6063);
        super.a(view, bVar);
        if (this.puO != null) {
            AppMethodBeat.o(6063);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8h);
        if (viewStub == null) {
            AppMethodBeat.o(6063);
            return;
        }
        viewStub.inflate();
        this.puO = view.findViewById(R.id.a8e);
        this.ptQ = view.findViewById(R.id.avu);
        cmH();
        this.ptE = (ImageView) this.puO.findViewById(R.id.bgv);
        this.kc = (ImageView) this.puO.findViewById(R.id.j51);
        this.ptR = (MMNeat7extView) this.puO.findViewById(R.id.ir3);
        this.pub = (TextView) this.puO.findViewById(R.id.gcj);
        this.puc = this.puO.findViewById(R.id.ayp);
        this.ptS = (ImageView) this.puO.findViewById(R.id.ggb);
        this.pud = this.puO.findViewById(R.id.j52);
        this.ptT = (LinearLayout) this.puO.findViewById(R.id.a94);
        this.ptU = (LinearLayout) this.puO.findViewById(R.id.hsf);
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
        AppMethodBeat.o(6063);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
    public final void a(int i2, v vVar, final z zVar, final int i3, u uVar, int i4) {
        int i5;
        AppMethodBeat.i(6064);
        super.a(i2, vVar, zVar, i3, uVar, i4);
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.q(zVar);
        MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
        String str = this.pyB;
        String str2 = vVar.vid;
        if (MPVideoPreviewMgr.pJj && !Util.isNullOrNil(MPVideoPreviewMgr.pJs) && !Util.isNullOrNil(str)) {
            boolean z = !p.j(str, str2);
            boolean j2 = p.j(MPVideoPreviewMgr.pJs, str);
            if (z && j2) {
                Log.i("MicroMsg.MPVideoPreviewMgr", "checkSameTopVideo true");
                MPVideoPreviewMgr.pJr = false;
                MPVideoPreviewMgr.cqK();
            }
        }
        this.pyB = vVar.vid;
        this.mCount = i2;
        this.pxB = false;
        this.ptS.setVisibility(8);
        zVar.NQk = f.ahR(zVar.field_talker);
        W(this.puc, b.prs);
        String rJ = m.rJ(vVar.iAs);
        if (!TextUtils.isEmpty(rJ)) {
            this.pub.setVisibility(0);
            this.pub.setText(rJ);
            this.pub.setTextColor(this.mContext.getResources().getColor(R.color.wu));
        } else {
            this.pub.setVisibility(8);
        }
        this.pub.setShadowLayer(10.0f, 0.0f, 0.0f, this.mContext.getResources().getColor(R.color.BW_0_Alpha_0_5));
        this.ptE.setVisibility(0);
        this.ptR.setTextColor(this.mContext.getResources().getColor(R.color.wu));
        this.ptT.setBackgroundResource(R.drawable.aij);
        this.ptY.setTextColor(this.mContext.getResources().getColor(R.color.wu));
        this.pxE.prc.a(zVar.field_msgId, 0, vVar, vVar.iAo, this.ptE, cnf(), b.prs, false, (m.a) new m.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.at.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(6062);
                at.this.pxB = true;
                at.this.ptY.setTextColor(at.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_9));
                if (at.this.ptS != null) {
                    at.this.ptS.setVisibility(0);
                }
                if (at.this.mCount > 1) {
                    at.this.ptR.setTextColor(at.this.mContext.getResources().getColor(R.color.ag2));
                }
                if (at.this.pxC > 0) {
                    at.this.ptT.setBackgroundResource(R.drawable.in);
                }
                at.this.pub.setTextColor(at.this.mContext.getResources().getColor(R.color.ag2));
                at.this.pxE.prc.m(zVar.field_msgId, i3);
                AppMethodBeat.o(6062);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
            }
        }, false, this.pxD);
        a(this.mCount, vVar, zVar);
        float f2 = 0.5f;
        if (this.ptR.getVisibility() == 0) {
            this.ptR.measure(a.jn(((ai) this).mContext) - a.fromDPToPix(((ai) this).mContext, 48), 0);
            f2 = 0.56f;
            i5 = (this.puc.getLayoutParams().height - this.ptR.getMeasuredHeight()) - b.prC;
        } else {
            i5 = this.puc.getLayoutParams().height;
        }
        if (this.pud != null) {
            ((RelativeLayout.LayoutParams) this.pud.getLayoutParams()).topMargin = (int) ((((float) i5) * f2) - ((float) (a.fromDPToPix(this.mContext, 48) / 2)));
        }
        e eVar = e.pAN;
        e.F(vVar.url, vVar.type, "");
        if (!a(i2, vVar)) {
            a(this, zVar, vVar);
        }
        this.pxE.a(vVar, zVar, i3, uVar, this.ptQ, this.mCount > 1, 0);
        if (this.mCount == 1) {
            this.ptQ.setBackgroundResource(R.drawable.i1);
            this.ptQ.setPadding(this.ptQ.getPaddingLeft(), 0, this.ptQ.getPaddingRight(), b.prv);
        } else {
            this.ptQ.setBackgroundResource(R.drawable.i7);
            this.ptQ.setPadding(this.ptQ.getPaddingLeft(), 0, this.ptQ.getPaddingRight(), 0);
        }
        this.ptS.setBackgroundResource(R.drawable.hz);
        AppMethodBeat.o(6064);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
    public final void a(int i2, v vVar, z zVar) {
        AppMethodBeat.i(194976);
        super.a(i2, vVar, zVar);
        if (this.ptR != null && this.ptR.getVisibility() == 0) {
            if (a.ez(this.mContext) >= 1.125f) {
                this.ptR.setMaxLines(1);
                AppMethodBeat.o(194976);
                return;
            }
            this.ptR.setMaxLines(2);
        }
        AppMethodBeat.o(194976);
    }
}
