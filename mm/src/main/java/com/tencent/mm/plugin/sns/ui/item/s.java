package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.item.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/sns/ui/item/Festival2021TimeLineItem;", "Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem;", "()V", "onClickListener", "Landroid/view/View$OnClickListener;", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "tlObj", "Lcom/tencent/mm/protocal/protobuf/TimeLineObject;", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "getOnClickListener", "adapter", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter;", "updateLiveStatus", "finderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "plugin-sns_release"})
public final class s extends c {
    private final View.OnClickListener ko = a.Vbd;

    public s() {
        AppMethodBeat.i(259420);
        AppMethodBeat.o(259420);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.item.c
    public final void f(axf axf) {
        int i2;
        AppMethodBeat.i(259417);
        p.h(axf, "finderShareObject");
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.festival.a.a.class);
        p.g(af, "MMKernel.service(IFestiv…xportService::class.java)");
        if (((com.tencent.mm.plugin.festival.a.a) af).dml()) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        axf.liveStatus = i2;
        AppMethodBeat.o(259417);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.item.c
    public final void a(c.a aVar, TimeLineObject timeLineObject, SnsInfo snsInfo) {
        AppMethodBeat.i(259418);
        p.h(aVar, "holder");
        p.h(timeLineObject, "tlObj");
        AppMethodBeat.o(259418);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        public static final a Vbd = new a();

        static {
            AppMethodBeat.i(259416);
            AppMethodBeat.o(259416);
        }

        a() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(259415);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/Festival2021TimeLineItem$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.g(view, LocaleUtil.ITALIAN);
            ((com.tencent.mm.plugin.festival.a.a) g.af(com.tencent.mm.plugin.festival.a.a.class)).ba(view.getContext(), 11);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/Festival2021TimeLineItem$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(259415);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.item.c
    public final View.OnClickListener c(bk bkVar) {
        AppMethodBeat.i(259419);
        p.h(bkVar, "adapter");
        View.OnClickListener onClickListener = this.ko;
        AppMethodBeat.o(259419);
        return onClickListener;
    }
}
