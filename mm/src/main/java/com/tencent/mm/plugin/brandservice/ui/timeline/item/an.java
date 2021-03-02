package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.layout.a;

public final class an extends ag {
    public View clickArea;
    public MMNeat7extView ptR;
    public TextView pyh;

    public final View b(Context context, b bVar) {
        AppMethodBeat.i(6042);
        super.a(context, bVar);
        if (this.puO != null) {
            View view = this.puO;
            AppMethodBeat.o(6042);
            return view;
        }
        this.puO = View.inflate(context, R.layout.kt, null);
        cne();
        this.ptR = (MMNeat7extView) this.puO.findViewById(R.id.a8y);
        this.pyh = (TextView) this.puO.findViewById(R.id.a8z);
        this.ptR.setOnTouchListener(new h(this.ptR, new o(this.ptR.getContext())));
        this.clickArea = this.puO.findViewById(R.id.a89);
        View view2 = this.puO;
        AppMethodBeat.o(6042);
        return view2;
    }

    public final View b(final z zVar, int i2, View view) {
        String str;
        int i3;
        AppMethodBeat.i(194974);
        Context context = this.mContext;
        String str2 = zVar.field_content;
        int textSize = (int) this.ptR.getTextSize();
        if (zVar != null) {
            str = ad.JX(new StringBuilder().append(zVar.field_msgSvrId).toString());
            ad.b G = ad.aVe().G(str, true);
            G.l("prePublishId", "msg_" + zVar.field_msgSvrId);
            G.l("preUsername", zVar.field_talker);
        } else {
            str = null;
        }
        SpannableString a2 = l.a(context, str2, textSize, 1, (Object) null, str);
        this.ptR.setMaxLines(Integer.MAX_VALUE);
        this.ptR.aw(a2);
        if (zVar.field_isExpand) {
            this.pyh.setText(this.mContext.getString(R.string.aia));
        } else {
            this.pyh.setText(this.mContext.getString(R.string.aib));
        }
        a mq = this.ptR.mq(com.tencent.mm.cb.a.jn(this.mContext) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 72), Integer.MAX_VALUE);
        if (mq != null) {
            i3 = mq.hiG();
        } else {
            i3 = 0;
        }
        if (i3 > 4) {
            if (!zVar.field_isExpand) {
                this.ptR.setMaxLines(4);
            }
            this.pyh.setVisibility(0);
            if (zVar.field_isExpand) {
                this.pyh.setText(R.string.aia);
            } else {
                this.pyh.setText(R.string.aib);
            }
            this.pyh.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.an.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(6041);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTextItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!zVar.field_isExpand) {
                        an.this.ptR.setMaxLines(Integer.MAX_VALUE);
                        zVar.field_isExpand = true;
                        an.this.pyh.setText(R.string.aia);
                    } else {
                        an.this.ptR.setMaxLines(4);
                        zVar.field_isExpand = false;
                        an.this.pyh.setText(R.string.aib);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTextItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(6041);
                }
            });
        } else {
            this.ptR.setMaxLines(Integer.MAX_VALUE);
            this.pyh.setVisibility(8);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ptR.getLayoutParams();
        if (i3 <= 4) {
            layoutParams.gravity = 17;
        } else {
            layoutParams.gravity = 19;
        }
        this.ptR.setLayoutParams(layoutParams);
        this.pxE.a(this, zVar);
        this.pxE.a(i2, zVar, this.pwA, this.pwz);
        AppMethodBeat.o(194974);
        return view;
    }
}
