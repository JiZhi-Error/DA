package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.HashSet;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016JH\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002J@\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J \u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "()V", "feedCommentFailedNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert;", "feedMsgNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "feedMsgNotifyHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "privateMsgNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert;", "privateMsgNotifyHolder", "getLayoutId", "", "handleCommentFailed", "", "parent", "Landroid/view/ViewGroup;", "item", "holder", "position", "type", "isHotPatch", "", "payloads", "", "", "onBindViewHolder", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class s extends e<ah> {
    public static final a tCO = new a((byte) 0);
    private final ab tCJ = new ab();
    private final bx tCK = new bx();
    private final i tCL = new i();
    private h tCM;
    private h tCN;

    static {
        AppMethodBeat.i(242996);
        AppMethodBeat.o(242996);
    }

    public s() {
        AppMethodBeat.i(242995);
        AppMethodBeat.o(242995);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* bridge */ /* synthetic */ void a(h hVar, ah ahVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(242994);
        a(hVar, ahVar, i2);
        AppMethodBeat.o(242994);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.f3115e;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(242992);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        LayoutInflater jQ = aa.jQ(hVar.getContext());
        View view = hVar.aus;
        if (view == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(242992);
            throw tVar;
        }
        View inflate = jQ.inflate(R.layout.f3119i, (ViewGroup) view, false);
        LayoutInflater jQ2 = aa.jQ(hVar.getContext());
        View view2 = hVar.aus;
        if (view2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(242992);
            throw tVar2;
        }
        View inflate2 = jQ2.inflate(R.layout.f3120j, (ViewGroup) view2, false);
        int e2 = d.e(recyclerView.getContext(), 6.0f);
        View findViewById = inflate2.findViewById(R.id.fmk);
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(242992);
                throw tVar3;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = e2 * 2;
            layoutParams2.bottomMargin = e2;
            findViewById.setBackgroundResource(R.drawable.vz);
        }
        View findViewById2 = inflate2.findViewById(R.id.fmk);
        if (findViewById2 != null) {
            ViewGroup.LayoutParams layoutParams3 = findViewById2.getLayoutParams();
            if (layoutParams3 == null) {
                t tVar4 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(242992);
                throw tVar4;
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.topMargin = e2;
            layoutParams4.bottomMargin = e2;
            findViewById2.setBackgroundResource(R.drawable.vz);
        }
        View view3 = hVar.aus;
        if (view3 == null) {
            t tVar5 = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(242992);
            throw tVar5;
        }
        ((ViewGroup) view3).addView(inflate);
        View view4 = hVar.aus;
        if (view4 == null) {
            t tVar6 = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(242992);
            throw tVar6;
        }
        ((ViewGroup) view4).addView(inflate2);
        h hVar2 = new h(inflate);
        hVar2.setRecyclerView(recyclerView);
        this.tCM = hVar2;
        h hVar3 = new h(inflate2);
        hVar3.setRecyclerView(recyclerView);
        this.tCN = hVar3;
        ab abVar = this.tCJ;
        h hVar4 = this.tCM;
        if (hVar4 == null) {
            p.btv("feedMsgNotifyHolder");
        }
        abVar.a(recyclerView, hVar4, -5);
        bx bxVar = this.tCK;
        h hVar5 = this.tCN;
        if (hVar5 == null) {
            p.btv("privateMsgNotifyHolder");
        }
        bxVar.a(recyclerView, hVar5, -6);
        AppMethodBeat.o(242992);
    }

    public final void a(h hVar, ah ahVar, int i2) {
        AppMethodBeat.i(242993);
        p.h(hVar, "holder");
        p.h(ahVar, "item");
        h hVar2 = this.tCM;
        if (hVar2 == null) {
            p.btv("feedMsgNotifyHolder");
        }
        hVar2.et(ahVar.msgNotifyData);
        h hVar3 = this.tCN;
        if (hVar3 == null) {
            p.btv("privateMsgNotifyHolder");
        }
        hVar3.et(ahVar.tSf);
        h hVar4 = this.tCM;
        if (hVar4 == null) {
            p.btv("feedMsgNotifyHolder");
        }
        ab.a(hVar4, ahVar.msgNotifyData);
        bx bxVar = this.tCK;
        h hVar5 = this.tCN;
        if (hVar5 == null) {
            p.btv("privateMsgNotifyHolder");
        }
        bxVar.a(hVar5, ahVar.tSf, i2);
        View view = hVar.aus;
        if (view == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(242993);
            throw tVar;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        HashSet<View> hashSet = new HashSet();
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            p.g(childAt, "child");
            if (childAt.getId() == R.id.b8v) {
                hashSet.add(childAt);
            }
        }
        for (View view2 : hashSet) {
            viewGroup.removeView(view2);
        }
        int e2 = d.e(viewGroup.getContext(), 6.0f);
        for (T t : ahVar.tSj) {
            if (t.uNO != 1) {
                View inflate = aa.jQ(hVar.getContext()).inflate(R.layout.f3116f, viewGroup, false);
                View findViewById = inflate.findViewById(R.id.fmk);
                if (findViewById != null) {
                    ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        AppMethodBeat.o(242993);
                        throw tVar2;
                    }
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = e2;
                    layoutParams2.bottomMargin = e2;
                    findViewById.setBackgroundResource(R.drawable.vz);
                }
                View view3 = hVar.aus;
                if (view3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(242993);
                    throw tVar3;
                }
                ((ViewGroup) view3).addView(inflate);
                h hVar6 = new h(inflate);
                hVar6.setRecyclerView(hVar.getRecyclerView());
                hVar6.et(t);
                i iVar = this.tCL;
                RecyclerView recyclerView = hVar6.getRecyclerView();
                p.g(recyclerView, "h.recyclerView");
                iVar.a(recyclerView, hVar6, -4);
                i iVar2 = this.tCL;
                p.g(t, "data");
                iVar2.a(hVar6, t);
            }
        }
        AppMethodBeat.o(242993);
    }
}
