package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.model.a;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.storage.z;

public final class ap extends ai {
    public ImageView kc;
    public ImageView ptE;
    public View puc;

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai, com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void a(View view, b bVar) {
        AppMethodBeat.i(6047);
        super.a(view, bVar);
        if (this.puO != null) {
            AppMethodBeat.o(6047);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8d);
        if (viewStub == null) {
            AppMethodBeat.o(6047);
            return;
        }
        viewStub.inflate();
        this.puO = view.findViewById(R.id.a8b);
        this.ptQ = view.findViewById(R.id.avq);
        cmH();
        this.ptE = (ImageView) this.puO.findViewById(R.id.bgv);
        this.ptG = (ImageView) this.puO.findViewById(R.id.bh9);
        this.kc = (ImageView) this.puO.findViewById(R.id.gbm);
        this.puc = this.puO.findViewById(R.id.axw);
        this.ptS = (ImageView) this.puO.findViewById(R.id.ggb);
        AppMethodBeat.o(6047);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
    public final void a(int i2, v vVar, final z zVar, final int i3, u uVar, int i4) {
        boolean z;
        AppMethodBeat.i(6048);
        super.a(i2, vVar, zVar, i3, uVar, i4);
        dw(this.puc);
        this.ptG.setVisibility(8);
        this.ptY.setTextColor(this.mContext.getResources().getColor(R.color.wu));
        this.kc.setBackgroundResource(R.raw.chatting_item_biz_pic_loading_icon);
        d dVar = this.pxE.prc;
        long j2 = zVar.field_msgId;
        String str = vVar.iAo;
        ImageView imageView = this.ptE;
        int i5 = b.prq;
        AnonymousClass1 r11 = new m.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.ap.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(6046);
                ap.this.ptG.setVisibility(0);
                ap.this.ptY.setTextColor(ap.this.mContext.getResources().getColor(R.color.ag2));
                ap.this.kc.setBackgroundResource(R.raw.biz_time_line_pic_icon);
                ap.this.pxE.prc.m(zVar.field_msgId, i3);
                AppMethodBeat.o(6046);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
            }
        };
        if (i2 == 1) {
            z = true;
        } else {
            z = false;
        }
        imageView.setContentDescription(dVar.pro.getString(R.string.az3));
        String OO = d.OO(str);
        g gVar = g.Kev;
        if (g.aig(1)) {
            a aVar = a.JUl;
            a.n(j2, 0, vVar.url);
        }
        int i6 = z ? R.drawable.c05 : 0;
        int i7 = z ? R.drawable.hu : R.drawable.hy;
        float fromDPToPix = (float) com.tencent.mm.cb.a.fromDPToPix((Context) dVar.pro, 8);
        int contentWidth = dVar.getContentWidth();
        com.tencent.mm.pluginsdk.model.b bVar = com.tencent.mm.pluginsdk.model.b.JUJ;
        c.a aVar2 = new c.a();
        aVar2.jbt = i7;
        aVar2.jbf = true;
        c.a dr = aVar2.dr(contentWidth, i5);
        dr.jbv = String.valueOf(i6);
        dr.jaU = new n(1);
        dr.jbC = new e(1);
        dr.jbD = new l();
        dr.fullPath = s.bdu(OO);
        com.tencent.mm.pluginsdk.model.b.a(j2, 0, vVar, OO, imageView, i4, false, dr.bdv(), new m(1, contentWidth, i5, false, z, fromDPToPix, r11));
        a(this, zVar, vVar);
        this.pxE.a(vVar, zVar, i3, uVar, this.ptQ, i2 > 1, 0);
        if (i2 == 1) {
            this.ptS.setBackgroundResource(R.drawable.hx);
            this.ptG.setBackgroundResource(R.drawable.ih);
            AppMethodBeat.o(6048);
            return;
        }
        this.ptS.setBackgroundResource(R.drawable.hz);
        this.ptG.setBackgroundResource(R.drawable.ii);
        AppMethodBeat.o(6048);
    }
}
