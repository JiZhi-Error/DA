package com.tencent.mm.plugin.textstatus.b.c;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetHeaderCardConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetHeaderItem;", "onItemClickListener", "Landroid/view/View$OnClickListener;", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "(Landroid/view/View$OnClickListener;Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
public final class a extends e<com.tencent.mm.plugin.textstatus.f.d.a> {
    private final View.OnClickListener FXS;
    private final f.a FXT;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.textstatus.f.d.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(216111);
        com.tencent.mm.plugin.textstatus.f.d.a aVar2 = aVar;
        p.h(hVar, "holder");
        p.h(aVar2, "item");
        if (hVar.getTag() != null) {
            Object tag = hVar.getTag();
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.api.IStatusCardView");
                AppMethodBeat.o(216111);
                throw tVar;
            }
            ((f) tag).DV(aVar2.username);
            Object tag2 = hVar.getTag();
            if (tag2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.api.IStatusCardView");
                AppMethodBeat.o(216111);
                throw tVar2;
            }
            ((f) tag2).f(this.FXS);
            Object tag3 = hVar.getTag();
            if (tag3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.api.IStatusCardView");
                AppMethodBeat.o(216111);
                throw tVar3;
            }
            ((f) tag3).a(this.FXT);
        }
        AppMethodBeat.o(216111);
    }

    public a(View.OnClickListener onClickListener, f.a aVar) {
        p.h(onClickListener, "onItemClickListener");
        p.h(aVar, "eventListener");
        AppMethodBeat.i(216112);
        this.FXS = onClickListener;
        this.FXT = aVar;
        AppMethodBeat.o(216112);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.c2p;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(216110);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        Context context = recyclerView.getContext();
        p.g(context, "recyclerView.context");
        com.tencent.mm.plugin.textstatus.ui.f fVar = new com.tencent.mm.plugin.textstatus.ui.f(context);
        hVar.setTag(fVar);
        View view = hVar.aus;
        if (view == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(216110);
            throw tVar;
        }
        ((RelativeLayout) view).addView(fVar.tlx);
        ViewGroup.LayoutParams layoutParams = fVar.tlx.getLayoutParams();
        if (layoutParams == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(216110);
            throw tVar2;
        }
        ((RelativeLayout.LayoutParams) layoutParams).width = -1;
        AppMethodBeat.o(216110);
    }
}
