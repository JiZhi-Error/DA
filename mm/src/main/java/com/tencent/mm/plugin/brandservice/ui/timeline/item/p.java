package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.layout.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\u000e¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedText;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "MAX_LINE_NUM", "", "getMAX_LINE_NUM", "()I", "itemShowType", "getItemShowType", "setItemShowType", "(I)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "plugin-brandservice_release"})
public final class p extends n {
    private int iwc = 10;
    private final int puE = 4;
    private int viewId = R.id.j8g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(Context context, b bVar) {
        super(context, bVar);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(bVar, "adapter");
        AppMethodBeat.i(195313);
        AppMethodBeat.o(195313);
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
        a aVar;
        ViewGroup.LayoutParams layoutParams;
        Float f2;
        int i3 = 0;
        AppMethodBeat.i(195311);
        kotlin.g.b.p.h(zVar, "info");
        kotlin.g.b.p.h(view, "convertView");
        kotlin.g.b.p.h(view2, "parent");
        super.a(zVar, i2, view, view2);
        cdu cdu = zVar.NQr.MOG.get(0).MOY;
        MMNeat7extView mMNeat7extView = this.ptR;
        if (mMNeat7extView != null) {
            Context context = this.context;
            String str = cdu.Title;
            MMNeat7extView mMNeat7extView2 = this.ptR;
            if (mMNeat7extView2 != null) {
                f2 = Float.valueOf(mMNeat7extView2.getTextSize());
            } else {
                f2 = null;
            }
            if (f2 == null) {
                kotlin.g.b.p.hyc();
            }
            mMNeat7extView.aw(com.tencent.mm.pluginsdk.ui.span.l.j(context, str, (int) f2.floatValue()));
        }
        MMNeat7extView mMNeat7extView3 = this.ptR;
        if (mMNeat7extView3 != null) {
            aVar = mMNeat7extView3.mq(this.width, Integer.MAX_VALUE);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            i3 = aVar.hiG();
        }
        MMNeat7extView mMNeat7extView4 = this.ptR;
        if (mMNeat7extView4 != null) {
            layoutParams = mMNeat7extView4.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            layoutParams = null;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (i3 < this.puE) {
            if (layoutParams2 != null) {
                layoutParams2.gravity = 17;
            }
        } else if (layoutParams2 != null) {
            layoutParams2.gravity = 8388627;
        }
        MMNeat7extView mMNeat7extView5 = this.ptR;
        if (mMNeat7extView5 != null) {
            mMNeat7extView5.setLayoutParams(layoutParams2);
            AppMethodBeat.o(195311);
            return;
        }
        AppMethodBeat.o(195311);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.n
    public final void cmO() {
        AppMethodBeat.i(195312);
        View view = this.aus;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195312);
            return;
        }
        AppMethodBeat.o(195312);
    }
}
