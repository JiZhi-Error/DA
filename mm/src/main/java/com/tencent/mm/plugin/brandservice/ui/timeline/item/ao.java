package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ao extends ai {
    public ImageView ptE;
    public MMNeat7extView ptR;
    public ImageView pxu;
    public TextView pyj;
    public ImageView pyk;

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai, com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void a(View view, b bVar) {
        AppMethodBeat.i(6044);
        super.a(view, bVar);
        if (this.puO != null) {
            AppMethodBeat.o(6044);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8c);
        if (viewStub == null) {
            AppMethodBeat.o(6044);
            return;
        }
        viewStub.inflate();
        this.puO = view.findViewById(R.id.a8_);
        this.ptQ = view.findViewById(R.id.avo);
        cmH();
        this.ptE = (ImageView) this.puO.findViewById(R.id.bgv);
        this.ptR = (MMNeat7extView) this.puO.findViewById(R.id.ir3);
        this.pyj = (TextView) this.puO.findViewById(R.id.gd2);
        this.pxu = (ImageView) this.puO.findViewById(R.id.gcf);
        this.pyk = (ImageView) this.puO.findViewById(R.id.jja);
        this.ptG = (ImageView) this.puO.findViewById(R.id.bh9);
        d dVar = d.pMy;
        if (d.crj()) {
            d dVar2 = d.pMy;
            d.c(this.ptR);
        }
        AppMethodBeat.o(6044);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
    public final void a(int i2, v vVar, final z zVar, final int i3, u uVar, int i4) {
        AppMethodBeat.i(6045);
        super.a(i2, vVar, zVar, i3, uVar, i4);
        if (Util.isNullOrNil(vVar.title)) {
            this.ptR.setVisibility(8);
        } else {
            this.ptR.setVisibility(0);
            this.ptR.aw(vVar.title);
        }
        if (!TextUtils.isEmpty(vVar.iAA)) {
            this.pyj.setVisibility(0);
            this.pyj.setText(vVar.iAA);
        } else {
            this.pyj.setVisibility(8);
        }
        if (vVar.iAB == 2) {
            this.pyk.setImageResource(R.raw.chatting_item_biz_kugou_music_watermark);
        } else {
            this.pyk.setImageResource(R.raw.chatting_item_biz_qq_music_watermark);
        }
        a(this.pxu, zVar, 0, vVar.iAo);
        a(this, zVar, vVar);
        this.pxE.a(vVar, zVar, i3, uVar, this.ptQ, i2 > 1, 0);
        if ((zVar.field_msgId + "_0").equals(c.crh())) {
            this.pxu.setImageResource(R.raw.chatting_item_biz_music_pause_loading_icon);
        } else {
            this.pxu.setImageResource(R.raw.chatting_item_biz_music_play_loading_icon);
        }
        this.ptG.setVisibility(8);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.d dVar = this.pxE.prc;
        long j2 = zVar.field_msgId;
        String str = vVar.iAo;
        ImageView imageView = this.ptE;
        int i5 = b.pru;
        dVar.a(j2, 0, vVar, str, imageView, i5, i5, false, (m.a) new m.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.ao.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(6043);
                ao.this.ptG.setVisibility(0);
                if ((zVar.field_msgId + "_0").equals(c.crh())) {
                    ao.this.pxu.setImageResource(R.drawable.nm);
                } else {
                    ao.this.pxu.setImageResource(R.drawable.nn);
                }
                ao.this.pxE.prc.m(zVar.field_msgId, i3);
                AppMethodBeat.o(6043);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
            }
        }, i4, 2.0f);
        if (i2 == 1) {
            this.ptQ.setBackgroundResource(R.drawable.o4);
        } else {
            this.ptQ.setBackgroundResource(R.drawable.o5);
        }
        View view = this.ptQ;
        if (i2 > 1) {
            int i6 = b.prw;
            int i7 = b.prw;
            view.setPadding(i6, i6, i7, i7);
            AppMethodBeat.o(6045);
            return;
        }
        int i8 = b.prw;
        view.setPadding(i8, i8, b.prw, b.prv);
        AppMethodBeat.o(6045);
    }
}
