package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001fJ\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020'H\u0002J\u0006\u0010+\u001a\u00020\u001fJ\b\u0010,\u001a\u00020#H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardNew;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "empty", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getEmpty", "()Landroid/widget/LinearLayout;", "newTipsLayout", "getNewTipsLayout", "topLayout", "getTopLayout", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "viewBizContentUnfollow", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "viewBizMultiAccount", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "viewCanvas", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "viewFinder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "viewOld", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld;", "viewParent", "Landroid/view/View;", "viewSubscribe", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "getClientShowType", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "getView", "showEmpty", "Companion", "plugin-brandservice_release"})
public final class z extends a {
    public static final a pwC = new a((byte) 0);
    public final b psQ;
    public final LinearLayout pwA;
    private final LinearLayout pwB;
    public final s pwr;
    public final v pws;
    public final aa pwt;
    public final t pwu;
    public final u pwv = new u(this.psQ);
    public final y pww;
    public final ac pwx;
    public final View pwy;
    public final LinearLayout pwz;

    static {
        AppMethodBeat.i(195444);
        AppMethodBeat.o(195444);
    }

    public z(Context context, b bVar) {
        p.h(context, "context");
        p.h(bVar, "adapter");
        AppMethodBeat.i(195443);
        this.psQ = bVar;
        this.pwr = new s(this.psQ, context);
        this.pws = new v(this.psQ, context);
        this.pwt = new aa(context, this.psQ);
        this.pwu = new t(this.psQ, context);
        this.pww = new y(this.psQ, context);
        this.pwx = new ac(this.psQ, context);
        View inflate = View.inflate(context, R.layout.ke, null);
        p.g(inflate, "View.inflate(context, R.…_line_rec_card_new, null)");
        this.pwy = inflate;
        this.pwz = (LinearLayout) this.pwy.findViewById(R.id.a8m);
        this.pwA = (LinearLayout) this.pwy.findViewById(R.id.a8c);
        this.pwB = (LinearLayout) this.pwy.findViewById(R.id.a6k);
        AppMethodBeat.o(195443);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardNew$Companion;", "", "()V", "BIZCONTENT", "", "BIZCONTENT_MULTIACC", "BIZCONTENT_UNFOLLOW", "CANVAS", "FINDER", "OLD", "SUBSCRIBE", "TAG", "", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static int Di(int i2) {
        switch (i2) {
            case 3:
                return 2;
            case 5:
                return 3;
            case 101:
                return 4;
            case 102:
                return 6;
            case 103:
                return 7;
            case 1001:
                return 5;
            default:
                return 1;
        }
    }

    public final void cnd() {
        AppMethodBeat.i(195442);
        LinearLayout linearLayout = this.pwz;
        p.g(linearLayout, "newTipsLayout");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.pwA;
        p.g(linearLayout2, "topLayout");
        linearLayout2.setVisibility(8);
        this.pwr.hide();
        this.pws.hide();
        this.pwt.hide();
        this.pwu.hide();
        this.pwv.hide();
        this.pww.hide();
        this.pwx.hide();
        LinearLayout linearLayout3 = this.pwB;
        p.g(linearLayout3, "empty");
        linearLayout3.setVisibility(0);
        AppMethodBeat.o(195442);
    }
}
