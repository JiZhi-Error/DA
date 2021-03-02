package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewStub;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.biz.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.dkp;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017J\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "TAG", "", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "hasProcessCrash", "", "item", "Landroid/view/View;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "inflate", "plugin-brandservice_release"})
public final class u extends ad {
    private final String TAG = "MicroMsg.BizTLRecCardCanvas";
    private final b psQ;
    private View puO;
    private BizTLRecCardCanvasView pvr;
    private boolean pvs;

    public u(b bVar) {
        p.h(bVar, "adapter");
        AppMethodBeat.i(195375);
        this.psQ = bVar;
        AppMethodBeat.o(195375);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    @SuppressLint({"ClickableViewAccessibility"})
    public final void a(z zVar, int i2, View view, View view2) {
        Object obj;
        dkp dkp;
        AppMethodBeat.i(195373);
        p.h(zVar, "info");
        p.h(view, "convertView");
        p.h(view2, "parent");
        ege gAD = zVar.gAD();
        StringBuilder sb = new StringBuilder("__rec_card_");
        if (gAD == null || (dkp = gAD.Ngc) == null || (obj = dkp.cardId) == null) {
            obj = Long.valueOf(zVar.field_msgId);
        }
        String sb2 = sb.append(obj).toString();
        com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(71);
        Log.i(this.TAG, "filling#" + sb2 + " msgId=" + zVar.field_msgId);
        r rVar = r.NPl;
        if (!r.gzM()) {
            view.setVisibility(8);
            AppMethodBeat.o(195373);
            return;
        }
        if (!this.pvs) {
            c cVar = c.pfv;
            if (!c.d(sb2, view)) {
                com.tencent.mm.plugin.webcanvas.l lVar2 = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(73);
                AppMethodBeat.o(195373);
                return;
            }
        }
        this.pvs = true;
        p.h(view2, "parent");
        if (this.puO == null) {
            View inflate = ((ViewStub) view2.findViewById(R.id.j7s)).inflate();
            this.pvr = (BizTLRecCardCanvasView) inflate.findViewById(R.id.gtt);
            this.puO = inflate;
        }
        View view3 = this.puO;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        ege gAD2 = zVar.gAD();
        BizTLRecCardCanvasView bizTLRecCardCanvasView = this.pvr;
        if (bizTLRecCardCanvasView != null) {
            bizTLRecCardCanvasView.setBizTimeLineInfo(zVar);
        }
        BizTLRecCardCanvasView bizTLRecCardCanvasView2 = this.pvr;
        if (bizTLRecCardCanvasView2 != null) {
            long j2 = zVar.field_msgId;
            String str = gAD2.Ngc.MOE;
            if (str == null) {
                str = "re";
            }
            String str2 = gAD2.Ngc.data;
            p.g(str2, "wrapper.exptInfo.data");
            bizTLRecCardCanvasView2.a(j2, sb2, str, str2);
        }
        com.tencent.mm.plugin.webcanvas.l lVar3 = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(72);
        c cVar2 = c.pfv;
        c.ahj(sb2);
        AppMethodBeat.o(195373);
    }

    public final void hide() {
        AppMethodBeat.i(195374);
        View view = this.puO;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195374);
            return;
        }
        AppMethodBeat.o(195374);
    }
}
