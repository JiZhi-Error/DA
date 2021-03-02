package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "initReaderItem", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/ItemMsg;", "plugin-brandservice_release"})
public final class m extends n {
    private int iwc;
    private int viewId = R.id.j8b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Context context, b bVar) {
        super(context, bVar);
        p.h(context, "context");
        p.h(bVar, "adapter");
        AppMethodBeat.i(195305);
        AppMethodBeat.o(195305);
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
        boolean z;
        String str;
        AppMethodBeat.i(195302);
        p.h(zVar, "info");
        p.h(view, "convertView");
        p.h(view2, "parent");
        super.a(zVar, i2, view, view2);
        cdu cdu = zVar.NQr.MOG.get(0).MOY;
        MMNeat7extView mMNeat7extView = this.ptR;
        if (mMNeat7extView != null) {
            mMNeat7extView.aw(cdu.Title);
        }
        int i3 = b.prr;
        V(this.puc, i3);
        V(this.ptS, i3);
        String str2 = cdu.KSn;
        if (str2 == null || n.aL(str2)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = cdu.KSl;
        } else {
            str = cdu.KSn;
        }
        this.psQ.prc.a(zVar.field_msgId, 0, this.ptH, str, this.puw, this.width, i3, false, (m.a) new a(), false, zVar.pxD);
        AppMethodBeat.o(195302);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
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
    public final void a(cdu cdu) {
        AppMethodBeat.i(195303);
        p.h(cdu, "itemInfo");
        super.a(cdu);
        String str = cdu.KSn;
        if (str != null) {
            this.ptH.iAo = str;
            AppMethodBeat.o(195303);
            return;
        }
        AppMethodBeat.o(195303);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.n
    public final void cmO() {
        AppMethodBeat.i(195304);
        View view = this.aus;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195304);
            return;
        }
        AppMethodBeat.o(195304);
    }
}
