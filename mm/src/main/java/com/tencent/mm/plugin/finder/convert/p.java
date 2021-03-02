package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ae;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0002J@\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFoldedFeed;", "()V", "foldedController", "com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1;", "getLayoutId", "", "jumpFoldedUI", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpPos", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class p extends com.tencent.mm.view.recyclerview.e<ae> {
    public static final a tCs = new a((byte) 0);
    private final b tCr = new b(this);

    static {
        AppMethodBeat.i(242955);
        AppMethodBeat.o(242955);
    }

    public p() {
        AppMethodBeat.i(242954);
        AppMethodBeat.o(242954);
    }

    public static final /* synthetic */ void b(Context context, FinderItem finderItem, int i2) {
        AppMethodBeat.i(242956);
        a(context, finderItem, i2);
        AppMethodBeat.o(242956);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, ae aeVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(242951);
        ae aeVar2 = aeVar;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(aeVar2, "item");
        WxRecyclerView wxRecyclerView = (WxRecyclerView) hVar.Mn(R.id.dbo);
        kotlin.g.b.p.g(wxRecyclerView, "ry");
        Object tag = wxRecyclerView.getTag();
        if (tag == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mm.plugin.finder.model.BaseFinderFeed> /* = java.util.ArrayList<com.tencent.mm.plugin.finder.model.BaseFinderFeed> */");
            AppMethodBeat.o(242951);
            throw tVar;
        }
        ArrayList arrayList = (ArrayList) tag;
        arrayList.clear();
        arrayList.addAll(aeVar2.feedObject.getFoldedFeedList().subList(0, Math.min(9, aeVar2.feedObject.getFoldedFeedList().size())));
        wxRecyclerView.setTag(R.id.dbo, aeVar2.feedObject);
        RecyclerView.a adapter = wxRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), hVar.getContext().getString(R.string.co8, aeVar2.feedObject.getNickName(), String.valueOf(aeVar2.feedObject.getFoldedFeedList().size())));
        View Mn = hVar.Mn(R.id.iqq);
        kotlin.g.b.p.g(Mn, "holder.getView<TextView>(R.id.title_more_feed)");
        ((TextView) Mn).setText(c2);
        hVar.Mn(R.id.iqm).setOnClickListener(new c(this, hVar, aeVar2));
        AppMethodBeat.o(242951);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.ac0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "isShowLikeInfo", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
    public static final class b implements FinderFoldedScrollLayout.b {
        final /* synthetic */ p tCt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(p pVar) {
            this.tCt = pVar;
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b
        public final void h(h hVar) {
            AppMethodBeat.i(242945);
            kotlin.g.b.p.h(hVar, "holder");
            Object tag = hVar.getRecyclerView().getTag(R.id.dbo);
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.storage.FinderItem");
                AppMethodBeat.o(242945);
                throw tVar;
            }
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            p.b(context, (FinderItem) tag, hVar.lR());
            AppMethodBeat.o(242945);
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b
        public final ConstraintLayout.LayoutParams cZE() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b
        public final boolean cZF() {
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b
        public final int cZG() {
            return 0;
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(242950);
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        kotlin.g.b.p.h(hVar, "holder");
        recyclerView.getContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(3);
        WxRecyclerView wxRecyclerView = (WxRecyclerView) hVar.Mn(R.id.dbo);
        kotlin.g.b.p.g(wxRecyclerView, "ry");
        wxRecyclerView.setLayoutManager(gridLayoutManager);
        wxRecyclerView.b(new d());
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Context context = recyclerView.getContext();
        kotlin.g.b.p.g(context, "recyclerView.context");
        wxRecyclerView.setRecycledViewPool(((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.ko(context).get(FinderRecyclerViewPool.class)).wuB);
        ArrayList arrayList = new ArrayList();
        wxRecyclerView.setTag(arrayList);
        wxRecyclerView.setAdapter(new WxRecyclerAdapter(new e(this), arrayList, true));
        int statusBarHeight = au.getStatusBarHeight(hVar.getContext());
        int eu = au.eu(hVar.getContext());
        View Mn = hVar.Mn(R.id.iqm);
        kotlin.g.b.p.g(Mn, "holder.getView<View>(R.id.title_layout)");
        ViewGroup.LayoutParams layoutParams = Mn.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(242950);
            throw tVar;
        }
        ((LinearLayout.LayoutParams) layoutParams).topMargin = statusBarHeight + eu;
        AppMethodBeat.o(242950);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "getSpace", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class d extends RecyclerView.h {
        private final int tCv = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8.0f);

        d() {
            AppMethodBeat.i(242948);
            AppMethodBeat.o(242948);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(242947);
            kotlin.g.b.p.h(rect, "outRect");
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(recyclerView, "parent");
            kotlin.g.b.p.h(sVar, "state");
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager.LayoutParams");
                AppMethodBeat.o(242947);
                throw tVar;
            }
            GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) layoutParams;
            int bw = RecyclerView.bw(view);
            if (gridLayoutManager == null) {
                kotlin.g.b.p.hyc();
            }
            int ki = gridLayoutManager.ki();
            if (gridLayoutManager.kf().ac(bw, ki) == 0) {
                rect.top = this.tCv;
            }
            rect.bottom = this.tCv;
            if (layoutParams2.kk() == ki) {
                rect.left = this.tCv;
                rect.right = this.tCv;
                AppMethodBeat.o(242947);
                return;
            }
            rect.left = (int) ((((float) (ki - layoutParams2.kj())) / ((float) ki)) * ((float) this.tCv));
            rect.right = (int) ((((1.0f * ((float) this.tCv)) * ((float) (ki + 1))) / ((float) ki)) - ((float) rect.left));
            AppMethodBeat.o(242947);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onCreateViewHolder$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class e implements f {
        final /* synthetic */ p tCt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(p pVar) {
            this.tCt = pVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(242949);
            an anVar = new an(this.tCt.tCr);
            AppMethodBeat.o(242949);
            return anVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ p tCt;
        final /* synthetic */ ae tCu;

        c(p pVar, h hVar, ae aeVar) {
            this.tCt = pVar;
            this.qhp = hVar;
            this.tCu = aeVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242946);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            p.a(context, this.tCu.feedObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242946);
        }
    }

    static /* synthetic */ void a(Context context, FinderItem finderItem) {
        AppMethodBeat.i(242953);
        a(context, finderItem, 0);
        AppMethodBeat.o(242953);
    }

    private static void a(Context context, FinderItem finderItem, int i2) {
        int i3;
        AppMethodBeat.i(242952);
        List<BaseFinderFeed> foldedFeedList = finderItem.getFoldedFeedList();
        if (!Util.isNullOrNil(foldedFeedList)) {
            int clamp = android.support.v4.b.a.clamp(i2, 0, foldedFeedList.size() - 1);
            Log.i("Finder.FeedFullFoldedConvert", "[jumpFoldedUI] item " + finderItem + " jumpPos " + i2);
            FinderFoldedScrollLayout.a aVar = FinderFoldedScrollLayout.wmQ;
            FinderFoldedScrollLayout.wmO = foldedFeedList.get(clamp).lT();
            FinderFoldedScrollLayout.a aVar2 = FinderFoldedScrollLayout.wmQ;
            FinderFoldedScrollLayout.wmP = cl.aWA();
            Intent intent = new Intent();
            intent.putExtra("FEED_ID", finderItem.getId());
            intent.putExtra("FEED_NONCE_ID", finderItem.getObjectNonceId());
            intent.putExtra("NICKNAME", finderItem.getNickName());
            intent.putExtra("FOLED_TYPE", 2);
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                i3 = fH.tCE;
            } else {
                i3 = 0;
            }
            intent.putExtra("IS_FULL_SCREEN", y.a(y.vXH, 0, i3, 1));
            y yVar = y.vXH;
            y.a(clamp, foldedFeedList, (com.tencent.mm.bw.b) null, intent);
            com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.V(context, intent);
        }
        AppMethodBeat.o(242952);
    }
}
