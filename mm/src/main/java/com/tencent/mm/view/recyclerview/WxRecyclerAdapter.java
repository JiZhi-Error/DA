package com.tencent.mm.view.recyclerview;

import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001PB/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020(2\u0006\u0010+\u001a\u00020(H\u0016J \u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0016J \u00102\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00103\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020(H\u0016J&\u00103\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020(2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0016J\"\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0016J\"\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0016J\u0018\u0010<\u001a\u00020\u00042\u0006\u00108\u001a\u0002092\u0006\u0010=\u001a\u00020(H\u0016J\u0006\u0010>\u001a\u00020.J\u0006\u0010?\u001a\u00020.J\f\u0010@\u001a\b\u0012\u0004\u0012\u00028\u000005J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u0002010\u000f2\u0006\u0010=\u001a\u00020(H\u0002J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u0002010\u000f2\u0006\u0010=\u001a\u00020(H\u0002J\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010=\u001a\u00020(H\u0002J\u0010\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020.2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010H\u001a\u00020.2\u0006\u0010E\u001a\u00020FH\u0016J\u0006\u0010I\u001a\u00020.J\u0006\u0010J\u001a\u00020.J\u0010\u0010K\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0004H\u0016J\u0010\u0010L\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0004H\u0016J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020OH\u0016R\u0018\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0018\u00010\u0013R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006Q"}, hxF = {"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "convertTypeMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "dataChangeListener", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "dataScrollListener", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener;", "isFirstViewHolder", "sessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getSessionExposeMap", "()Landroid/util/LongSparseArray;", "totalExposeMap", "getTotalExposeMap", "visibleExposeMap", "getVisibleExposeMap", "wxItemShowInfoMap", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getWxItemShowInfoMap", "wxRVListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getWxRVListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "setWxRVListener", "(Lcom/tencent/mm/view/recyclerview/WxRVListener;)V", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "_onBindHeaderHolder", "_onBindViewHolder", "payloads", "", "", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "_onCreateHeaderHolder", "_onCreateViewHolder", "viewType", "clearConverter", "clearReportData", "getData", "getFooterConvert", "getHeaderConvert", "getItemConvert", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindFirstBodyViewHolder", "onDetachedFromRecyclerView", "onPause", "onResume", "onViewAttachedToWindow", "onViewRecycled", "wrapViewHolder", "view", "Landroid/view/View;", "WxRecyclerOnScrollListener", "libmmui_release"})
public class WxRecyclerAdapter<D extends a> extends g<h> {
    public l RrA;
    public WxRecyclerAdapter<D>.a RrB;
    private RecyclerView.c RrC;
    private final boolean RrD;
    public final SparseArray<e<?>> Rru;
    public final LongSparseArray<i> Rrv;
    public boolean Rrw;
    public final LongSparseArray<k> Rrx;
    public final LongSparseArray<k> Rry;
    public final LongSparseArray<k> Rrz;
    public final ArrayList<D> data;
    private final f tDm;

    public /* synthetic */ WxRecyclerAdapter(f fVar, ArrayList arrayList) {
        this(fVar, arrayList, false);
        AppMethodBeat.i(164735);
        AppMethodBeat.o(164735);
    }

    public WxRecyclerAdapter(f fVar, ArrayList<D> arrayList, boolean z) {
        p.h(fVar, "itemConvertFactory");
        p.h(arrayList, "data");
        AppMethodBeat.i(205080);
        this.tDm = fVar;
        this.data = arrayList;
        this.RrD = z;
        this.Rru = new SparseArray<>();
        this.Rrv = new LongSparseArray<>();
        this.Rrw = true;
        this.Rrx = new LongSparseArray<>();
        this.Rry = new LongSparseArray<>();
        this.Rrz = new LongSparseArray<>();
        AppMethodBeat.o(205080);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // com.tencent.mm.view.recyclerview.g
    public final /* synthetic */ h a(ViewGroup viewGroup, int i2, g.b bVar) {
        AppMethodBeat.i(164725);
        p.h(viewGroup, "parent");
        p.h(bVar, "info");
        e<g.b> aqf = aqf(i2);
        long uptimeMillis = SystemClock.uptimeMillis();
        View inflate = aa.jQ(viewGroup.getContext()).inflate(aqf.getLayoutId(), viewGroup, false);
        Log.i("RecyclerViewAdapterEx", "CreateView Cost=" + (SystemClock.uptimeMillis() - uptimeMillis) + "ms viewType=" + i2);
        h hVar = new h(inflate);
        hVar.setRecyclerView(getRecyclerView());
        RecyclerView recyclerView = (RecyclerView) viewGroup;
        aqf.a(recyclerView, hVar, i2);
        hVar.b(recyclerView.getAdapter());
        h hVar2 = hVar;
        AppMethodBeat.o(164725);
        return hVar2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(RecyclerView.v vVar) {
        e<?> eVar;
        AppMethodBeat.i(205074);
        h hVar = (h) vVar;
        p.h(hVar, "holder");
        if (hVar.lR() >= 0 && (eVar = this.Rru.get(hVar.lU())) != null) {
            eVar.b(hVar);
        }
        super.a(hVar);
        AppMethodBeat.o(205074);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, com.tencent.mm.view.recyclerview.g$b] */
    @Override // com.tencent.mm.view.recyclerview.g
    public final /* synthetic */ void a(h hVar, int i2, g.b bVar) {
        AppMethodBeat.i(164729);
        h hVar2 = hVar;
        p.h(hVar2, "holder");
        p.h(bVar, "info");
        super.a(hVar2, i2, bVar);
        int itemViewType = getItemViewType(i2);
        hVar2.setRecyclerView(getRecyclerView());
        hVar2.et(bVar);
        aqf(itemViewType).a(hVar2, bVar, i2, itemViewType, false, null);
        AppMethodBeat.o(164729);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // com.tencent.mm.view.recyclerview.g
    public final /* synthetic */ h b(ViewGroup viewGroup, int i2, g.b bVar) {
        AppMethodBeat.i(164726);
        p.h(viewGroup, "parent");
        p.h(bVar, "info");
        e<g.b> aqg = aqg(i2);
        long uptimeMillis = SystemClock.uptimeMillis();
        View inflate = aa.jQ(viewGroup.getContext()).inflate(aqg.getLayoutId(), viewGroup, false);
        Log.d("RecyclerViewAdapterEx", "CreateView Cost=" + (SystemClock.uptimeMillis() - uptimeMillis) + "ms viewType=" + i2);
        h hVar = new h(inflate);
        hVar.setRecyclerView(getRecyclerView());
        RecyclerView recyclerView = (RecyclerView) viewGroup;
        aqg.a(recyclerView, hVar, i2);
        hVar.b(recyclerView.getAdapter());
        h hVar2 = hVar;
        AppMethodBeat.o(164726);
        return hVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, com.tencent.mm.view.recyclerview.g$b] */
    @Override // com.tencent.mm.view.recyclerview.g
    public final /* synthetic */ void b(h hVar, int i2, g.b bVar) {
        AppMethodBeat.i(164730);
        h hVar2 = hVar;
        p.h(hVar2, "holder");
        p.h(bVar, "info");
        super.b(hVar2, i2, bVar);
        int itemViewType = getItemViewType(i2);
        hVar2.setRecyclerView(getRecyclerView());
        hVar2.et(bVar);
        aqg(itemViewType).a(hVar2, bVar, i2, itemViewType, false, null);
        AppMethodBeat.o(164730);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.g
    public final /* synthetic */ void b(h hVar, int i2, List list) {
        AppMethodBeat.i(164728);
        h hVar2 = hVar;
        p.h(hVar2, "holder");
        p.h(list, "payloads");
        int itemViewType = getItemViewType(this.RqM.size() + i2);
        D d2 = this.data.get(i2);
        p.g(d2, "data[position]");
        D d3 = d2;
        hVar2.setRecyclerView(getRecyclerView());
        hVar2.et(d3);
        EC(itemViewType).a(hVar2, d3, i2, itemViewType, true, list);
        AppMethodBeat.o(164728);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // com.tencent.mm.view.recyclerview.g
    public /* synthetic */ void h(h hVar, int i2) {
        AppMethodBeat.i(164727);
        a(hVar, i2);
        AppMethodBeat.o(164727);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // com.tencent.mm.view.recyclerview.g
    public final /* synthetic */ h hJ(View view) {
        AppMethodBeat.i(164731);
        p.h(view, "view");
        h hVar = new h(view);
        AppMethodBeat.o(164731);
        return hVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public /* synthetic */ void k(RecyclerView.v vVar) {
        AppMethodBeat.i(205076);
        n((h) vVar);
        AppMethodBeat.o(205076);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // com.tencent.mm.view.recyclerview.g
    public final /* synthetic */ h p(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(164724);
        p.h(viewGroup, "parent");
        e<D> EC = EC(i2);
        long uptimeMillis = SystemClock.uptimeMillis();
        View inflate = aa.jQ(viewGroup.getContext()).inflate(EC.getLayoutId(), viewGroup, false);
        Log.i("RecyclerViewAdapterEx", "CreateView Cost=" + (SystemClock.uptimeMillis() - uptimeMillis) + "ms viewType=" + i2 + " hashCode=" + inflate.hashCode());
        h hVar = new h(inflate);
        hVar.setRecyclerView(getRecyclerView());
        EC.a(getRecyclerView(), hVar, i2);
        hVar.b(getRecyclerView().getAdapter());
        h hVar2 = hVar;
        AppMethodBeat.o(164724);
        return hVar2;
    }

    @Override // com.tencent.mm.view.recyclerview.g, android.support.v7.widget.RecyclerView.a
    public final void b(RecyclerView recyclerView) {
        AppMethodBeat.i(182557);
        p.h(recyclerView, "recyclerView");
        super.b(recyclerView);
        int size = this.Rru.size();
        for (int i2 = 0; i2 < size; i2++) {
            e<?> eVar = this.Rru.get(this.Rru.keyAt(i2));
            p.g(eVar, "convertTypeMap.get(key)");
            e<?> eVar2 = eVar;
            if (!eVar2.RqG) {
                eVar2.a(recyclerView, this);
            }
        }
        if (this.RrD) {
            WxRecyclerAdapter<D>.a aVar = new a();
            recyclerView.a(aVar);
            this.RrB = aVar;
            c cVar = new c(this, recyclerView);
            a(cVar);
            this.RrC = cVar;
        }
        AppMethodBeat.o(182557);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$2", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "notifyChangeEvent", "", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
    public static final class c extends RecyclerView.c {
        final /* synthetic */ WxRecyclerAdapter RrF;
        final /* synthetic */ RecyclerView tDJ;

        c(WxRecyclerAdapter wxRecyclerAdapter, RecyclerView recyclerView) {
            this.RrF = wxRecyclerAdapter;
            this.tDJ = recyclerView;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
        public static final class a implements Runnable {
            final /* synthetic */ c RrK;

            a(c cVar) {
                this.RrK = cVar;
            }

            public final void run() {
                AppMethodBeat.i(205063);
                a aVar = this.RrK.RrF.RrB;
                if (aVar != null) {
                    aVar.onScrollStateChanged(this.RrK.tDJ, 8);
                    AppMethodBeat.o(205063);
                    return;
                }
                AppMethodBeat.o(205063);
            }
        }

        private void hgx() {
            AppMethodBeat.i(205064);
            this.tDJ.post(new a(this));
            AppMethodBeat.o(205064);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            AppMethodBeat.i(205065);
            super.onChanged();
            hgx();
            AppMethodBeat.o(205065);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(205066);
            super.onItemRangeChanged(i2, i3, obj);
            hgx();
            AppMethodBeat.o(205066);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(205067);
            super.onItemRangeInserted(i2, i3);
            hgx();
            AppMethodBeat.o(205067);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            AppMethodBeat.i(205068);
            super.onItemRangeMoved(i2, i3, i4);
            hgx();
            AppMethodBeat.o(205068);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(205069);
            super.onItemRangeRemoved(i2, i3);
            hgx();
            AppMethodBeat.o(205069);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.g, android.support.v7.widget.RecyclerView.a
    public final void c(RecyclerView recyclerView) {
        AppMethodBeat.i(182558);
        p.h(recyclerView, "recyclerView");
        super.c(recyclerView);
        int size = this.Rru.size();
        for (int i2 = 0; i2 < size; i2++) {
            e<?> eVar = this.Rru.get(this.Rru.keyAt(i2));
            p.g(eVar, "convertTypeMap.get(key)");
            e<?> eVar2 = eVar;
            if (eVar2.RqG) {
                eVar2.c(recyclerView);
            }
        }
        RecyclerView.c cVar = this.RrC;
        if (cVar != null) {
            b(cVar);
            AppMethodBeat.o(182558);
            return;
        }
        AppMethodBeat.o(182558);
    }

    public void n(h hVar) {
        AppMethodBeat.i(205075);
        p.h(hVar, "holder");
        super.k(hVar);
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            a aVar = (a) hVar.hgv();
            if (aVar == null) {
                AppMethodBeat.o(205075);
            } else if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                int kj = ((StaggeredGridLayoutManager.LayoutParams) layoutParams).kj();
                View view2 = hVar.aus;
                p.g(view2, "holder.itemView");
                int measuredWidth = view2.getMeasuredWidth();
                View view3 = hVar.aus;
                p.g(view3, "holder.itemView");
                i iVar = new i(kj, measuredWidth, view3.getMeasuredHeight());
                if (iVar.width == 0 || iVar.height == 0) {
                    hVar.aus.post(new f(iVar, aVar, layoutParams, this, hVar));
                }
                this.Rrv.put(aVar.lT(), iVar);
                AppMethodBeat.o(205075);
            } else {
                View view4 = hVar.aus;
                p.g(view4, "holder.itemView");
                int measuredWidth2 = view4.getMeasuredWidth();
                View view5 = hVar.aus;
                p.g(view5, "holder.itemView");
                i iVar2 = new i(0, measuredWidth2, view5.getMeasuredHeight());
                if (iVar2.width == 0 || iVar2.height == 0) {
                    hVar.aus.post(new g(iVar2, aVar, layoutParams, this, hVar));
                }
                this.Rrv.put(aVar.lT(), iVar2);
                AppMethodBeat.o(205075);
            }
        } else {
            AppMethodBeat.o(205075);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0007"}, hxF = {"<anonymous>", "", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$1$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$1"})
    public static final class f implements Runnable {
        final /* synthetic */ WxRecyclerAdapter RrF;
        final /* synthetic */ i RrL;
        final /* synthetic */ a RrM;
        final /* synthetic */ ViewGroup.LayoutParams RrN;
        final /* synthetic */ h tzq;

        f(i iVar, a aVar, ViewGroup.LayoutParams layoutParams, WxRecyclerAdapter wxRecyclerAdapter, h hVar) {
            this.RrL = iVar;
            this.RrM = aVar;
            this.RrN = layoutParams;
            this.RrF = wxRecyclerAdapter;
            this.tzq = hVar;
        }

        public final void run() {
            AppMethodBeat.i(205072);
            i iVar = this.RrL;
            View view = this.tzq.aus;
            p.g(view, "holder.itemView");
            iVar.width = view.getMeasuredWidth();
            i iVar2 = this.RrL;
            View view2 = this.tzq.aus;
            p.g(view2, "holder.itemView");
            iVar2.height = view2.getMeasuredHeight();
            AppMethodBeat.o(205072);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0007"}, hxF = {"<anonymous>", "", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$2$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$2", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$2"})
    public static final class g implements Runnable {
        final /* synthetic */ WxRecyclerAdapter RrF;
        final /* synthetic */ i RrL;
        final /* synthetic */ a RrM;
        final /* synthetic */ ViewGroup.LayoutParams RrN;
        final /* synthetic */ h tzq;

        g(i iVar, a aVar, ViewGroup.LayoutParams layoutParams, WxRecyclerAdapter wxRecyclerAdapter, h hVar) {
            this.RrL = iVar;
            this.RrM = aVar;
            this.RrN = layoutParams;
            this.RrF = wxRecyclerAdapter;
            this.tzq = hVar;
        }

        public final void run() {
            AppMethodBeat.i(205073);
            i iVar = this.RrL;
            View view = this.tzq.aus;
            p.g(view, "holder.itemView");
            iVar.width = view.getMeasuredWidth();
            i iVar2 = this.RrL;
            View view2 = this.tzq.aus;
            p.g(view2, "holder.itemView");
            iVar2.height = view2.getMeasuredHeight();
            AppMethodBeat.o(205073);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.g
    public final int apZ(int i2) {
        AppMethodBeat.i(164721);
        int cxn = this.data.get(i2).cxn();
        AppMethodBeat.o(164721);
        return cxn;
    }

    @Override // com.tencent.mm.view.recyclerview.g
    public final long aqa(int i2) {
        AppMethodBeat.i(164722);
        long lT = this.data.get(i2).lT();
        AppMethodBeat.o(164722);
        return lT;
    }

    @Override // com.tencent.mm.view.recyclerview.g
    public final int hgt() {
        AppMethodBeat.i(164723);
        int size = this.data.size();
        AppMethodBeat.o(164723);
        return size;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ WxRecyclerAdapter RrF;

        b(WxRecyclerAdapter wxRecyclerAdapter) {
            this.RrF = wxRecyclerAdapter;
        }

        public final void run() {
            AppMethodBeat.i(205062);
            this.RrF.n(this.RrF.getRecyclerView());
            AppMethodBeat.o(205062);
        }
    }

    public void n(RecyclerView recyclerView) {
        AppMethodBeat.i(205077);
        p.h(recyclerView, "recyclerView");
        WxRecyclerAdapter<D>.a aVar = this.RrB;
        if (aVar != null) {
            aVar.onScrollStateChanged(recyclerView, 5);
            AppMethodBeat.o(205077);
            return;
        }
        AppMethodBeat.o(205077);
    }

    private final e<D> EC(int i2) {
        AppMethodBeat.i(164732);
        e<D> eVar = (e<D>) this.Rru.get(i2);
        if (eVar == null) {
            eVar = (e<D>) this.tDm.EC(i2);
            if (eVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D>");
                AppMethodBeat.o(164732);
                throw tVar;
            }
            this.Rru.put(i2, eVar);
            if (!eVar.RqG) {
                eVar.a(getRecyclerView(), this);
            }
        }
        if (eVar == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D>");
            AppMethodBeat.o(164732);
            throw tVar2;
        }
        AppMethodBeat.o(164732);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.tencent.mm.view.recyclerview.e<com.tencent.mm.view.recyclerview.g$b> */
    private final e<g.b> aqf(int i2) {
        AppMethodBeat.i(164733);
        e eVar = this.Rru.get(i2);
        e eVar2 = eVar;
        if (eVar == null) {
            e EC = this.tDm.EC(i2);
            this.Rru.put(i2, EC);
            boolean z = EC.RqG;
            eVar2 = EC;
            if (!z) {
                EC.a(getRecyclerView(), this);
                eVar2 = EC;
            }
        }
        if (eVar2 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
            AppMethodBeat.o(164733);
            throw tVar;
        }
        AppMethodBeat.o(164733);
        return eVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.tencent.mm.view.recyclerview.e<com.tencent.mm.view.recyclerview.g$b> */
    private final e<g.b> aqg(int i2) {
        AppMethodBeat.i(164734);
        e eVar = this.Rru.get(i2);
        e eVar2 = eVar;
        if (eVar == null) {
            e EC = this.tDm.EC(i2);
            if (EC == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
                AppMethodBeat.o(164734);
                throw tVar;
            }
            this.Rru.put(i2, EC);
            boolean z = EC.RqG;
            eVar2 = EC;
            if (!z) {
                EC.a(getRecyclerView(), this);
                eVar2 = EC;
            }
        }
        if (eVar2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
            AppMethodBeat.o(164734);
            throw tVar2;
        }
        AppMethodBeat.o(164734);
        return eVar2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ WxRecyclerAdapter RrF;

        e(WxRecyclerAdapter wxRecyclerAdapter) {
            this.RrF = wxRecyclerAdapter;
        }

        public final void run() {
            AppMethodBeat.i(205071);
            a aVar = this.RrF.RrB;
            if (aVar != null) {
                aVar.onScrollStateChanged(this.RrF.getRecyclerView(), 7);
                AppMethodBeat.o(205071);
                return;
            }
            AppMethodBeat.o(205071);
        }
    }

    public final void onResume() {
        AppMethodBeat.i(205078);
        getRecyclerView().post(new e(this));
        AppMethodBeat.o(205078);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    static final class d implements Runnable {
        final /* synthetic */ WxRecyclerAdapter RrF;

        d(WxRecyclerAdapter wxRecyclerAdapter) {
            this.RrF = wxRecyclerAdapter;
        }

        public final void run() {
            AppMethodBeat.i(205070);
            Log.i("RecyclerViewAdapterEx", "onPause visibleExposeMap.size:" + this.RrF.Rrz.size() + " sessionExposeMap.size:" + this.RrF.Rry.size());
            this.RrF.Rrz.clear();
            this.RrF.Rry.clear();
            AppMethodBeat.o(205070);
        }
    }

    public final void onPause() {
        AppMethodBeat.i(205079);
        getRecyclerView().post(new d(this));
        AppMethodBeat.o(205079);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J \u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0006\u0010\u001f\u001a\u00020\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006 "}, hxF = {"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "currentState", "", "getCurrentState", "()I", "setCurrentState", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "scaledTouchSlop", "getScaledTouchSlop", "sumOffset", "getSumOffset", "setSumOffset", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "reset", "libmmui_release"})
    public final class a extends RecyclerView.l {
        public int RrE;
        public int currentState;
        public int ptb = -1;
        public int ptc = -1;
        private final int tIg;
        public int tIj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            AppMethodBeat.i(205061);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(WxRecyclerAdapter.this.getRecyclerView().getContext());
            p.g(viewConfiguration, "ViewConfiguration.get(recyclerView.context)");
            this.tIg = viewConfiguration.getScaledTouchSlop();
            AppMethodBeat.o(205061);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
        /* renamed from: com.tencent.mm.view.recyclerview.WxRecyclerAdapter$a$a  reason: collision with other inner class name */
        public static final class RunnableC2163a implements Runnable {
            final /* synthetic */ a RrG;
            final /* synthetic */ int RrH;
            final /* synthetic */ RecyclerView tDJ;

            RunnableC2163a(a aVar, int i2, RecyclerView recyclerView) {
                this.RrG = aVar;
                this.RrH = i2;
                this.tDJ = recyclerView;
            }

            /* JADX WARNING: Removed duplicated region for block: B:73:0x01f9  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 1251
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.view.recyclerview.WxRecyclerAdapter.a.RunnableC2163a.run():void");
            }
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(205059);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            recyclerView.post(new RunnableC2163a(this, i2, recyclerView));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(205059);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(205060);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            if (this.currentState == 2) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(205060);
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                p.hyc();
            }
            p.g(layoutManager, "recyclerView.layoutManager!!");
            if (!layoutManager.canScrollHorizontally()) {
                i2 = i3;
            }
            this.RrE += i2;
            if (Math.abs(this.RrE) > this.tIg * 5 || (this.tIj == 2 && this.currentState == 1)) {
                onScrollStateChanged(recyclerView, 3);
                this.RrE = 0;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(205060);
        }
    }

    public void a(h hVar, int i2) {
        AppMethodBeat.i(182559);
        p.h(hVar, "holder");
        int itemViewType = getItemViewType(this.RqM.size() + i2);
        D d2 = this.data.get(i2);
        p.g(d2, "data[position]");
        D d3 = d2;
        hVar.et(d3);
        hVar.setRecyclerView(getRecyclerView());
        Log.i("RecyclerViewAdapterEx", "_onBindViewHolder pos:" + i2 + ", item:" + d3.hashCode() + " ry=" + hVar.getRecyclerView().hashCode());
        EC(itemViewType).a(hVar, d3, i2, itemViewType, false, null);
        if (this.Rrw) {
            this.Rrw = false;
            getRecyclerView().post(new b(this));
        }
        AppMethodBeat.o(182559);
    }
}
