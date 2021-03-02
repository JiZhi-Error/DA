package com.tencent.mm.plugin.textstatus.b.d;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class a extends e<com.tencent.mm.plugin.textstatus.f.g.a> {
    public static final C1814a FXY = new C1814a((byte) 0);

    static {
        AppMethodBeat.i(216123);
        AppMethodBeat.o(216123);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.textstatus.f.g.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(216122);
        com.tencent.mm.plugin.textstatus.f.g.a aVar2 = aVar;
        p.h(hVar, "holder");
        p.h(aVar2, "item");
        Object tag = hVar.getTag();
        if (tag == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.api.IStatusCardView");
            AppMethodBeat.o(216122);
            throw tVar;
        }
        f fVar = (f) tag;
        fVar.getView().setTag(R.id.ih4, Integer.valueOf(i2));
        fVar.DV(aVar2.FYx.field_UserName);
        AppMethodBeat.o(216122);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.b.d.a$a  reason: collision with other inner class name */
    public static final class C1814a {
        private C1814a() {
        }

        public /* synthetic */ C1814a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.c2v;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(216121);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        View view = hVar.aus;
        if (view == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(216121);
            throw tVar;
        }
        n fvA = n.FXu.fvA();
        p.g(fvA, "StatusShowParam.sDefSameTopicCardParam.clone()");
        fvA.axm(2);
        f statusCardView = ((c) g.ah(c.class)).getStatusCardView(recyclerView.getContext(), fvA);
        p.g(statusCardView, "cardView");
        ((RelativeLayout) view).addView(statusCardView.getView());
        hVar.setTag(statusCardView);
        View view2 = statusCardView.getView();
        p.g(view2, "cardView.view");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(216121);
            throw tVar2;
        }
        ((RelativeLayout.LayoutParams) layoutParams).width = -1;
        AppMethodBeat.o(216121);
    }
}
