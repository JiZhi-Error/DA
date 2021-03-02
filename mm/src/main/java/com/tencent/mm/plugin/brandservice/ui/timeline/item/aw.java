package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u0012J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTlRecFeedCard;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "viewBizTag", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "viewItemList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "viewParent", "Landroid/view/View;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "getView", "hideAll", "isSupportStyle", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Companion", "plugin-brandservice_release"})
public final class aw extends a {
    public static final a pyH = new a((byte) 0);
    private final b psQ;
    public final View pwy;
    private final ae pyE;
    private final af pyF;
    private final ad[] pyG = {this.pyE, this.pyF};

    static {
        AppMethodBeat.i(195503);
        AppMethodBeat.o(195503);
    }

    public aw(Context context, b bVar) {
        p.h(context, "context");
        p.h(bVar, "adapter");
        AppMethodBeat.i(195502);
        this.psQ = bVar;
        this.pyE = new ae(this.psQ, context);
        this.pyF = new af(this.psQ, context);
        View inflate = View.inflate(context, R.layout.kn, null);
        p.g(inflate, "View.inflate(context, R.…ne_rec_feed_layout, null)");
        this.pwy = inflate;
        AppMethodBeat.o(195502);
    }

    public final void c(z zVar, int i2, View view) {
        boolean z = true;
        AppMethodBeat.i(195500);
        p.h(zVar, "info");
        p.h(view, "convertView");
        if (zVar.NQr == null) {
            Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] recFeed is null");
            cnh();
            AppMethodBeat.o(195500);
            return;
        }
        switch (zVar.NQr.KUh) {
            case 2001:
            case 2002:
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] style = " + zVar.NQr.KUh + " not support");
            cnh();
            AppMethodBeat.o(195500);
            return;
        }
        dkr dkr = zVar.NQr;
        p.g(dkr, "info.recFeed");
        if (!af.b(dkr)) {
            Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] recFeed is illegal");
            cnh();
            AppMethodBeat.o(195500);
            return;
        }
        o oVar = o.iBV;
        o.Aa(20);
        ad[] adVarArr = this.pyG;
        for (ad adVar : adVarArr) {
            if (zVar.gAJ() != adVar.getStyle()) {
                adVar.cmO();
            } else {
                adVar.show();
                adVar.a(zVar, i2, view, this.pwy);
            }
        }
        AppMethodBeat.o(195500);
    }

    private final void cnh() {
        AppMethodBeat.i(195501);
        for (ad adVar : this.pyG) {
            adVar.cmO();
        }
        AppMethodBeat.o(195501);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTlRecFeedCard$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
