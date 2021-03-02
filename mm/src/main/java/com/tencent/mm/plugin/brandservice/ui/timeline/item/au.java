package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class au extends ai {
    public MMNeat7extView ptR;
    public MMNeat7extView puy;
    public ImageView pxu;
    public TextView pyD;

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai, com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void a(View view, b bVar) {
        AppMethodBeat.i(6066);
        super.a(view, bVar);
        if (this.puO != null) {
            AppMethodBeat.o(6066);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8i);
        if (viewStub == null) {
            AppMethodBeat.o(6066);
            return;
        }
        viewStub.inflate();
        this.puO = view.findViewById(R.id.a8g);
        this.ptQ = view.findViewById(R.id.avw);
        cmH();
        this.ptR = (MMNeat7extView) this.puO.findViewById(R.id.ir3);
        this.pyD = (TextView) this.puO.findViewById(R.id.gcj);
        this.pxu = (ImageView) this.puO.findViewById(R.id.a3i);
        this.puy = (MMNeat7extView) this.puO.findViewById(R.id.a8f);
        d dVar = d.pMy;
        if (d.crj()) {
            d dVar2 = d.pMy;
            d.c(this.ptR);
        }
        AppMethodBeat.o(6066);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
    public final void a(int i2, v vVar, z zVar, int i3, u uVar, int i4) {
        AppMethodBeat.i(6067);
        super.a(i2, vVar, zVar, i3, uVar, i4);
        this.mCount = i2;
        this.pxB = true;
        if (Util.isNullOrNil(vVar.title)) {
            this.ptR.aw(this.mContext.getResources().getString(R.string.aif));
        } else {
            this.ptR.setVisibility(0);
            this.ptR.aw(vVar.title);
        }
        if (Util.isNullOrNil(vVar.iAq) || this.mCount != 1) {
            this.puy.setVisibility(8);
        } else {
            String aiW = c.aiW(vVar.iAq);
            this.puy.setVisibility(0);
            this.puy.setMaxLines(2);
            this.puy.setEllipsize(TextUtils.TruncateAt.END);
            this.puy.aw(aiW);
        }
        String rJ = m.rJ(vVar.iAs);
        if (!TextUtils.isEmpty(rJ)) {
            this.pyD.setVisibility(0);
            this.pyD.setText(rJ);
        } else {
            this.pyD.setVisibility(8);
        }
        Drawable drawable = this.pxu.getDrawable();
        if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
            ((AnimationDrawable) drawable).stop();
        }
        if ((zVar.field_msgId + "_0").equals(c.crh())) {
            this.pxu.setImageResource(R.drawable.ie);
            if (this.pxu.getDrawable() instanceof AnimationDrawable) {
                ((AnimationDrawable) this.pxu.getDrawable()).start();
            }
        } else {
            this.pxu.setImageResource(R.drawable.id);
        }
        a(this.pxu, zVar, 0, vVar.iAo);
        a(this, zVar, vVar);
        this.pxE.a(vVar, zVar, i3, uVar, this.ptQ, this.mCount > 1, 0);
        if (this.mCount == 1) {
            this.ptQ.setBackgroundResource(R.drawable.i1);
        } else {
            this.ptQ.setBackgroundResource(R.drawable.i7);
        }
        if (Util.isNullOrNil(vVar.iAq)) {
            this.ptQ.setPadding(this.ptQ.getPaddingLeft(), 0, this.ptQ.getPaddingRight(), 0);
            AppMethodBeat.o(6067);
            return;
        }
        this.ptQ.setPadding(this.ptQ.getPaddingLeft(), b.pry, this.ptQ.getPaddingRight(), b.prv);
        AppMethodBeat.o(6067);
    }
}
