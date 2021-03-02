package com.tencent.mm.plugin.finder.profile;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.convert.ck;
import com.tencent.mm.plugin.finder.model.bl;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u001eR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initView", "", "refresh", "plugin-finder_release"})
public final class FinderTopicFilterView extends FrameLayout {
    private final String TAG = "Finder.FinderTopicFilterView";
    public b uZq;
    public WxRecyclerView ufR;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTopicFilterView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(249998);
        AppMethodBeat.o(249998);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTopicFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(249999);
        AppMethodBeat.o(249999);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTopicFilterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(250000);
        AppMethodBeat.o(250000);
    }

    public final b getPresenter() {
        return this.uZq;
    }

    public final void setPresenter(b bVar) {
        this.uZq = bVar;
    }

    public final WxRecyclerView getRecyclerView() {
        return this.ufR;
    }

    public final void setRecyclerView(WxRecyclerView wxRecyclerView) {
        this.ufR = wxRecyclerView;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$initView$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class c implements g.c<h> {
        final /* synthetic */ WxRecyclerAdapter tDq;
        final /* synthetic */ FinderTopicFilterView uZr;
        final /* synthetic */ b uZs;

        public c(WxRecyclerAdapter wxRecyclerAdapter, FinderTopicFilterView finderTopicFilterView, b bVar) {
            this.tDq = wxRecyclerAdapter;
            this.uZr = finderTopicFilterView;
            this.uZs = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
            Object obj;
            o oVar;
            RecyclerView.a adapter;
            AppMethodBeat.i(249995);
            h hVar2 = hVar;
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar2, "holder");
            int size = i2 - this.tDq.RqM.size();
            String str = this.uZr.TAG;
            StringBuilder sb = new StringBuilder("click item ");
            if (size < 0 || size >= this.uZs.kgc.size()) {
                obj = "";
            } else {
                obj = this.uZs.kgc.get(size);
                p.g(obj, "presenter.dataList[clickPos]");
            }
            Log.i(str, sb.append(obj).append(" pos:").append(size).toString());
            bl blVar = (bl) hVar2.hgv();
            if (blVar != null) {
                long j2 = blVar.dMU.twp;
                if (blVar.uOQ) {
                    blVar.uOQ = false;
                    oVar = new o(blVar.dMU, Boolean.FALSE);
                } else {
                    blVar.uOQ = true;
                    oVar = new o(blVar.dMU, Boolean.TRUE);
                }
                A a2 = oVar.first;
                boolean booleanValue = oVar.second.booleanValue();
                Log.i(this.uZr.TAG, "select item hash:" + blVar.hashCode() + ", topic:" + blVar.dMU.dST + ", selected:" + blVar.uOQ);
                for (T t : this.uZs.kgc) {
                    if (t.dMU.twp != j2) {
                        t.uOQ = false;
                    }
                }
                WxRecyclerView recyclerView = this.uZr.getRecyclerView();
                if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
                    adapter.e(0, adapter.getItemCount(), 1);
                    Log.i(this.uZr.TAG, "refresh itemCount:" + adapter.getItemCount());
                }
                m<? super bds, ? super Boolean, x> mVar = this.uZs.uZo;
                if (mVar != null) {
                    mVar.invoke(a2, Boolean.valueOf(booleanValue));
                    AppMethodBeat.o(249995);
                    return;
                }
            }
            AppMethodBeat.o(249995);
        }
    }

    public final void refresh() {
        RecyclerView.a adapter;
        AppMethodBeat.i(249996);
        Log.i(this.TAG, "refresh");
        WxRecyclerView wxRecyclerView = this.ufR;
        if (wxRecyclerView == null || (adapter = wxRecyclerView.getAdapter()) == null) {
            AppMethodBeat.o(249996);
            return;
        }
        adapter.notifyDataSetChanged();
        AppMethodBeat.o(249996);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class b extends RecyclerView.h {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(249994);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            Context context = view.getContext();
            p.g(context, "view.context");
            int dimension = (int) context.getResources().getDimension(R.dimen.bt);
            rect.left = dimension;
            rect.right = dimension;
            rect.bottom = dimension;
            rect.top = dimension;
            AppMethodBeat.o(249994);
        }
    }

    public final RecyclerView.h getItemDecoration() {
        AppMethodBeat.i(249997);
        b bVar = new b();
        AppMethodBeat.o(249997);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class a implements f {
        final /* synthetic */ FinderTopicFilterView uZr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(FinderTopicFilterView finderTopicFilterView) {
            this.uZr = finderTopicFilterView;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            AppMethodBeat.i(249993);
            switch (i2) {
                case 1:
                    ck ckVar = new ck();
                    AppMethodBeat.o(249993);
                    return ckVar;
                default:
                    if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                        RuntimeException runtimeException = new RuntimeException("type invalid");
                        AppMethodBeat.o(249993);
                        throw runtimeException;
                    }
                    Log.printInfoStack(this.uZr.TAG, "type invalid", new Object[0]);
                    com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                    AppMethodBeat.o(249993);
                    return fVar;
            }
        }
    }
}
