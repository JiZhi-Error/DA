package com.tencent.mm.plugin.textstatus.b.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J@\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/album/AlbumItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/album/AlbumItem;", "longClickListener", "Landroid/view/View$OnLongClickListener;", "(Landroid/view/View$OnLongClickListener;)V", "getLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setLongClickListener", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class b extends e<com.tencent.mm.plugin.textstatus.f.a.a> {
    public static final a FXP = new a((byte) 0);
    private View.OnLongClickListener tib;

    static {
        AppMethodBeat.i(216101);
        AppMethodBeat.o(216101);
    }

    public b(View.OnLongClickListener onLongClickListener) {
        p.h(onLongClickListener, "longClickListener");
        AppMethodBeat.i(216100);
        this.tib = onLongClickListener;
        AppMethodBeat.o(216100);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.textstatus.f.a.a aVar, int i2, int i3, boolean z, List list) {
        boolean z2;
        AppMethodBeat.i(216099);
        com.tencent.mm.plugin.textstatus.f.a.a aVar2 = aVar;
        p.h(hVar, "holder");
        p.h(aVar2, "item");
        Log.i("MicroMsg.TxtStatus.AlbumItemConvert", "onBindViewHolder");
        Object tag = hVar.getTag();
        if (tag == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.api.IStatusCardView");
            AppMethodBeat.o(216099);
            throw tVar;
        }
        f fVar = (f) tag;
        fVar.getView().setTag(R.id.ess, aVar2);
        fVar.getView().setOnLongClickListener(this.tib);
        fVar.getView().setTag(R.id.ih4, Integer.valueOf(i2));
        if (fVar instanceof g) {
            String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
            p.g(ceA, "Account.username()");
            ((g) fVar).a(ceA, aVar2.FZq);
        }
        String str = aVar2.FZr;
        if (!(str == null || n.aL(str))) {
            TextView textView = (TextView) hVar.Mn(R.id.iz4);
            p.g(textView, LocaleUtil.ITALIAN);
            textView.setVisibility(0);
            textView.setText(aVar2.FZr);
        } else {
            View Mn = hVar.Mn(R.id.iz4);
            p.g(Mn, "holder.getView<TextView>(R.id.tv_year)");
            ((TextView) Mn).setVisibility(8);
        }
        String str2 = aVar2.FZs;
        if (str2 == null || n.aL(str2)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            TextView textView2 = (TextView) hVar.Mn(R.id.ixz);
            p.g(textView2, LocaleUtil.ITALIAN);
            textView2.setVisibility(0);
            textView2.setText(aVar2.FZs);
            AppMethodBeat.o(216099);
            return;
        }
        View Mn2 = hVar.Mn(R.id.ixz);
        p.g(Mn2, "holder.getView<TextView>(R.id.tv_month_day)");
        ((TextView) Mn2).setVisibility(8);
        AppMethodBeat.o(216099);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/album/AlbumItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.c28;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(216098);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        Log.i("MicroMsg.TxtStatus.AlbumItemConvert", "onCreateViewHolder");
        View view = hVar.aus;
        if (view == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout");
            AppMethodBeat.o(216098);
            throw tVar;
        }
        com.tencent.mm.plugin.textstatus.a.n fvA = com.tencent.mm.plugin.textstatus.a.n.FXs.fvA();
        p.g(fvA, "StatusShowParam.sDefaultShowParam.clone()");
        fvA.fvB().wq(false).axm(6);
        f statusCardView = ((c) com.tencent.mm.kernel.g.ah(c.class)).getStatusCardView(recyclerView.getContext(), fvA);
        p.g(statusCardView, "cardView");
        ((LinearLayout) view).addView(statusCardView.getView());
        hVar.setTag(statusCardView);
        View view2 = statusCardView.getView();
        p.g(view2, "cardView.view");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(216098);
            throw tVar2;
        }
        ((LinearLayout.LayoutParams) layoutParams).width = -1;
        AppMethodBeat.o(216098);
    }
}
