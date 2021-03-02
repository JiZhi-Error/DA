package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.graphics.Point;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aq extends ai {
    public View puc;
    public TextView pyn;
    View pyo;
    public ImageView pyp;
    public ImageView[] pyq = new ImageView[4];
    public View[] pyr = new View[4];

    public aq() {
        AppMethodBeat.i(6050);
        AppMethodBeat.o(6050);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai, com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void a(View view, b bVar) {
        AppMethodBeat.i(6051);
        super.a(view, bVar);
        if (this.puO != null) {
            AppMethodBeat.o(6051);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8e);
        if (viewStub == null) {
            AppMethodBeat.o(6051);
            return;
        }
        viewStub.inflate();
        this.puO = view.findViewById(R.id.a8a);
        this.ptQ = view.findViewById(R.id.avq);
        this.pyr[0] = this.puO.findViewById(R.id.gbq);
        this.pyr[1] = this.puO.findViewById(R.id.gbs);
        this.pyr[2] = this.puO.findViewById(R.id.gbr);
        this.pyr[3] = this.puO.findViewById(R.id.gbp);
        cmH();
        this.pyn = (TextView) this.puO.findViewById(R.id.gbt);
        this.pyp = (ImageView) this.puO.findViewById(R.id.gbm);
        this.ptS = (ImageView) this.puO.findViewById(R.id.ggb);
        this.puc = this.puO.findViewById(R.id.axw);
        this.pyo = this.puO.findViewById(R.id.a8t);
        this.ptU = (LinearLayout) this.puO.findViewById(R.id.hsd);
        this.ptW = (MMNeat7extView) this.puO.findViewById(R.id.hsa);
        AppMethodBeat.o(6051);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
    public final void a(int i2, v vVar, final z zVar, final int i3, u uVar, int i4) {
        AppMethodBeat.i(6052);
        super.a(i2, vVar, zVar, i3, uVar, i4);
        this.mCount = i2;
        this.pxB = false;
        this.ptS.setVisibility(8);
        ai.W(this.puc, b.prs);
        for (int i5 = 0; i5 < this.pyr.length; i5++) {
            View view = this.pyr[i5];
            if (view != null) {
                if (i5 != 0) {
                    if (i5 == this.pyr.length - 1) {
                    }
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                    this.pyq[0] = (ImageView) view.findViewById(R.id.a90);
                    this.pyq[1] = (ImageView) view.findViewById(R.id.a91);
                    this.pyq[2] = (ImageView) view.findViewById(R.id.a92);
                    this.pyq[3] = (ImageView) view.findViewById(R.id.a93);
                }
            }
        }
        this.pyo.setBackgroundResource(R.drawable.aij);
        this.ptU.setVisibility(8);
        final boolean cng = cng();
        if (this.pyq.length > 0) {
            ImageView imageView = this.pyq[0];
            String str = vVar.iAo;
            if (imageView != null && !Util.isNullOrNil(str)) {
                int i6 = b.prs;
                a.jn(this.mContext);
                a.getDensity(this.mContext);
                Point point = new Point((int) (((float) i6) * 1.7777778f), i6);
                imageView.getLayoutParams().width = point.x;
                imageView.getLayoutParams().height = point.y;
                int i7 = point.x;
                int i8 = point.y;
                imageView.setVisibility(0);
                this.pyp.setImageResource(R.raw.biz_time_line_loading_pic_icon);
                this.pxE.prc.a(zVar.field_msgId, 0, vVar, str, imageView, i7, i8, false, (m.a) new m.a() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.aq.AnonymousClass1 */
                    final /* synthetic */ int pyt = 0;

                    @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
                    public final void onFinish() {
                        AppMethodBeat.i(6049);
                        aq.this.pxB = true;
                        if (aq.this.pyp != null) {
                            aq.this.pyp.setImageResource(R.raw.biz_time_line_pic_icon);
                        }
                        if (aq.this.ptS != null) {
                            aq.this.ptS.setVisibility(0);
                        }
                        if (aq.this.pyo != null) {
                            aq.this.pyo.setBackgroundResource(cng ? R.drawable.im : R.drawable.in);
                        }
                        if (this.pyt == 0) {
                            aq.this.ptY.setTextColor(aq.this.mContext.getResources().getColor(R.color.ag2));
                            aq.this.pxE.prc.m(zVar.field_msgId, i3);
                        }
                        AppMethodBeat.o(6049);
                    }

                    @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
                    public final void onStart() {
                    }
                }, cng, this.pxD);
            }
        }
        if (vVar.iAC > 1) {
            this.pyn.setVisibility(0);
            this.pyn.setText(String.valueOf(vVar.iAC));
        } else {
            this.pyn.setVisibility(8);
        }
        if (this.mCount != 1) {
            this.ptQ.setBackgroundResource(R.drawable.i7);
            this.ptQ.setPadding(0, 0, 0, 0);
        } else if (cng) {
            this.ptQ.setBackgroundResource(R.drawable.aij);
            this.ptQ.setPadding(0, 0, 0, 0);
        } else {
            this.ptQ.setBackgroundResource(R.drawable.i1);
            this.ptQ.setPadding(0, 0, 0, b.prv);
        }
        if (cng()) {
            this.ptS.setBackgroundResource(R.drawable.hx);
        } else {
            this.ptS.setBackgroundResource(R.drawable.hz);
        }
        a(this, zVar, vVar);
        this.pxE.a(vVar, zVar, i3, uVar, this.ptQ, this.mCount > 1, 0);
        AppMethodBeat.o(6052);
    }

    private boolean cng() {
        return this.mCount == 1;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai, com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void a(z zVar, v vVar, View view, TextView textView, int i2) {
        AppMethodBeat.i(6054);
        super.a(zVar, vVar, view, textView, i2);
        textView.setTextColor(this.mContext.getResources().getColor(R.color.ag2));
        AppMethodBeat.o(6054);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void dw(View view) {
        AppMethodBeat.i(259584);
        ai.W(view, b.prs);
        AppMethodBeat.o(259584);
    }
}
