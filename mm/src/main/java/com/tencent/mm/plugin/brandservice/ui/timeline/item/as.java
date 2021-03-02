package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.layout.a;

public final class as extends ai {
    TextView pyh;
    MMNeat7extView pyy;
    private LinearLayout pyz;

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai, com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void a(View view, b bVar) {
        AppMethodBeat.i(6060);
        super.a(view, bVar);
        if (this.puO != null) {
            AppMethodBeat.o(6060);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.j8g);
        if (viewStub == null) {
            AppMethodBeat.o(6060);
            return;
        }
        viewStub.inflate();
        this.puO = view.findViewById(R.id.avr);
        this.ptQ = view.findViewById(R.id.avs);
        cmH();
        this.pyy = (MMNeat7extView) view.findViewById(R.id.a8y);
        this.pyy.setOnTouchListener(new h(this.pyy, new o(this.pyy.getContext())));
        this.pyh = (TextView) view.findViewById(R.id.a8z);
        this.pyz = (LinearLayout) view.findViewById(R.id.ikc);
        AppMethodBeat.o(6060);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
    public final void a(int i2, final v vVar, z zVar, int i3, u uVar, int i4) {
        int i5;
        boolean z = true;
        AppMethodBeat.i(6061);
        super.a(i2, vVar, zVar, i3, uVar, i4);
        zVar.NQk = f.ahR(zVar.field_talker);
        if (Util.isNullOrNil(vVar.title)) {
            this.pyy.setVisibility(8);
        } else {
            this.pyy.setVisibility(0);
            this.pyy.aw(l.j(this.mContext, vVar.title, (int) this.pyy.getTextSize()));
        }
        a mq = this.pyy.mq(com.tencent.mm.cb.a.jn(this.mContext) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 72), Integer.MAX_VALUE);
        if (mq != null) {
            i5 = mq.hiG();
        } else {
            i5 = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.pyy.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.pyz.getLayoutParams();
        if (i5 <= 3) {
            this.pyh.setVisibility(8);
            layoutParams2.gravity = 16;
            this.pyz.setLayoutParams(layoutParams2);
            layoutParams.topMargin = 0;
            layoutParams.gravity = 17;
            this.pyy.setMaxLines(3);
        } else {
            boolean contains = this.pxE.prh.contains(vVar);
            this.pyh.setVisibility(0);
            layoutParams2.gravity = 48;
            this.pyz.setLayoutParams(layoutParams2);
            layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
            layoutParams.gravity = 8388627;
            if (contains) {
                this.pyy.setMaxLines(Integer.MAX_VALUE);
                this.pyh.setText(R.string.aia);
            } else {
                this.pyy.setMaxLines(3);
                this.pyh.setText(R.string.aib);
            }
            this.pyh.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.as.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(6059);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (as.this.pxE.prh.contains(vVar)) {
                        as.this.pyy.setMaxLines(3);
                        as.this.pyh.setText(R.string.aib);
                        as.this.pxE.prh.remove(vVar);
                    } else {
                        as.this.pyy.setMaxLines(Integer.MAX_VALUE);
                        as.this.pyh.setText(R.string.aia);
                        as.this.pxE.prh.add(vVar);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(6059);
                }
            });
        }
        this.pyy.setLayoutParams(layoutParams);
        this.ptQ.setBackgroundResource(R.drawable.i1);
        a(this, zVar, vVar);
        b bVar = this.pxE;
        View view = this.ptQ;
        if (i2 <= 1) {
            z = false;
        }
        bVar.a(vVar, zVar, i3, uVar, view, z, 0);
        AppMethodBeat.o(6061);
    }
}
