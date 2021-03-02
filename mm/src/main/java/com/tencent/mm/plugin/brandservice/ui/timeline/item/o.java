package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "picNumTv", "Landroid/widget/TextView;", "getPicNumTv", "()Landroid/widget/TextView;", "setPicNumTv", "(Landroid/widget/TextView;)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "onInflate", "plugin-brandservice_release"})
public final class o extends n {
    private int iwc = 8;
    private TextView puD;
    private int viewId = R.id.j8d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(Context context, b bVar) {
        super(context, bVar);
        p.h(context, "context");
        p.h(bVar, "adapter");
        AppMethodBeat.i(195310);
        AppMethodBeat.o(195310);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.n
    public final int getItemShowType() {
        return this.iwc;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.n
    public final int getViewId() {
        return this.viewId;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.n
    public final void a(z zVar, int i2, View view, View view2) {
        AppMethodBeat.i(195307);
        p.h(zVar, "info");
        p.h(view, "convertView");
        p.h(view2, "parent");
        super.a(zVar, i2, view, view2);
        cdu cdu = zVar.NQr.MOG.get(0).MOY;
        dbp dbp = cdu.Mjo;
        if ((dbp != null ? dbp.gqw : 0) > 0) {
            TextView textView = this.puD;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.puD;
            if (textView2 != null) {
                dbp dbp2 = cdu.Mjo;
                textView2.setText(String.valueOf(dbp2 != null ? Integer.valueOf(dbp2.gqw) : null));
            }
        } else {
            TextView textView3 = this.puD;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        int i3 = b.prt;
        V(this.puc, i3);
        V(this.ptS, i3);
        this.psQ.prc.a(zVar.field_msgId, 0, this.ptH, cdu.KSl, this.puw, this.width, i3, false, (m.a) new a(), false, zVar.pxD);
        AppMethodBeat.o(195307);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class a implements m.a {
        a() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
        public final void onFinish() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
        public final void onStart() {
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.n
    public final void cmP() {
        AppMethodBeat.i(195308);
        View view = this.aus;
        this.puD = view != null ? (TextView) view.findViewById(R.id.gbu) : null;
        AppMethodBeat.o(195308);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.n
    public final void cmO() {
        AppMethodBeat.i(195309);
        View view = this.aus;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195309);
            return;
        }
        AppMethodBeat.o(195309);
    }
}
