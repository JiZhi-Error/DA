package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.v;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.model.d;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.e;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f*\u00016\u0018\u0000 c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001cB\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J \u0010=\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?H\u0002J\u0010\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020\u0006H\u0002J0\u0010C\u001a\u00020D2\u0006\u0010:\u001a\u00020;2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010F\u001a\u00020\u0006H\u0002J\u0010\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020\u0002H\u0002J\u000e\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LJ\b\u0010M\u001a\u00020\u0006H\u0016J\b\u0010N\u001a\u00020\tH\u0002J.\u0010O\u001a\u0002092\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010F\u001a\u00020\u00062\u0006\u0010:\u001a\u00020;J\u0018\u0010P\u001a\u0002002\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?H\u0002J\u0018\u0010Q\u001a\u0002002\u0006\u0010R\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0006H\u0002J\u001c\u0010S\u001a\u0002092\u0006\u0010T\u001a\u00020U2\n\u0010V\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J@\u0010W\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010H\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u0002002\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?H\u0016J \u0010Z\u001a\u0002092\u0006\u0010T\u001a\u00020U2\u0006\u0010:\u001a\u00020;2\u0006\u0010X\u001a\u00020\u0006H\u0016J\u0010\u0010[\u001a\u0002092\u0006\u0010T\u001a\u00020UH\u0016J(\u0010\\\u001a\u0002092\u0016\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010^\u001a\u00020\u0002H\u0002J\u0018\u0010_\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010H\u001a\u00020\u0002H\u0002J\u0010\u0010`\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010a\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J \u0010b\u001a\u0002002\u0006\u0010:\u001a\u00020;2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?H\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00105\u001a\u000206X\u0004¢\u0006\u0004\n\u0002\u00107¨\u0006d"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fragmentTabType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "TAG", "", "adapterData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "getAdapterData", "()Ljava/util/ArrayList;", "setAdapterData", "(Ljava/util/ArrayList;)V", "globalData", "getGlobalData", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "setGlobalData", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;)V", "innderAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getInnderAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setInnderAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "innderRvScrollListener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "getInnderRvScrollListener", "()Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "setInnderRvScrollListener", "(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V", "innerLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getInnerLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setInnerLayoutManager", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvertFactory", "()Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "setItemConvertFactory", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;)V", "loading", "", "getLoading", "()Z", "setLoading", "(Z)V", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1;", "adjustLayout", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "bindAdapter", "bindToTargetAdapter", "payloads", "", "", "checkLoadMore", "lastPos", "convertToVisitorData", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "dataList", "position", "filterList", "item", "getEmptyView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getLayoutId", "getScene", "gotoLive", "isLoadMoreUpdate", "needToLoadMore", "feedData", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "onBindViewHolder", "type", "isHotPatch", "onCreateViewHolder", "onDetachedFromRecyclerView", "onLoadMoreFinish", "incrementList", "liveList", "refreshFooterTips", "refreshHeadTips", "reportExposed", "updatePayload", "Companion", "plugin-finder_release"})
public final class y extends com.tencent.mm.view.recyclerview.e<x> {
    public static final a tDp = new a((byte) 0);
    private final String TAG = "FinderFeedLiveListConvert";
    boolean aWP;
    ArrayList<com.tencent.mm.plugin.finder.model.y> tDh = new ArrayList<>();
    x tDi = new x();
    private WxRecyclerAdapter<?> tDj;
    private LinearLayoutManager tDk;
    private RecyclerView.l tDl;
    private com.tencent.mm.view.recyclerview.f tDm = new e(this);
    private final f tDn = new f(this);
    private final int tDo;
    private final bbn ttO;

    static {
        AppMethodBeat.i(243067);
        AppMethodBeat.o(243067);
    }

    public y(bbn bbn, int i2) {
        AppMethodBeat.i(243066);
        this.ttO = bbn;
        this.tDo = i2;
        AppMethodBeat.o(243066);
    }

    public static final /* synthetic */ String b(y yVar) {
        AppMethodBeat.i(243069);
        String scene = yVar.getScene();
        AppMethodBeat.o(243069);
        return scene;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, x xVar, int i2, int i3, boolean z, List list) {
        View Mn;
        RecyclerView recyclerView;
        AppMethodBeat.i(243059);
        x xVar2 = xVar;
        p.h(hVar, "holder");
        p.h(xVar2, "item");
        Log.i(this.TAG, "[updateLiveList]onBindViewHolder holder" + hVar + ",position:" + i2 + ", tabType:" + this.tDo + ",data:" + xVar2 + ",payloads:" + list);
        if (!a(hVar, list)) {
            a(xVar2);
            this.tDh.clear();
            this.tDh.addAll(xVar2.dtS);
            RecyclerView recyclerView2 = (RecyclerView) hVar.Mn(R.id.ek3);
            RecyclerView.a adapter = recyclerView2 != null ? recyclerView2.getAdapter() : null;
            boolean dU = dU(list);
            Log.i(this.TAG, "[bindToTargetAdapter] tabType:" + this.tDo + ",holderAdapter:" + adapter + ",innderAdapter:" + this.tDj + ",same adapter:" + p.j(adapter, this.tDj) + ",isLoadMore:" + dU);
            if (p.j(adapter, this.tDj)) {
                WxRecyclerAdapter<?> wxRecyclerAdapter = this.tDj;
                if (wxRecyclerAdapter != null) {
                    wxRecyclerAdapter.notifyDataSetChanged();
                }
                if (!dU && (recyclerView = (RecyclerView) hVar.Mn(R.id.ek3)) != null) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert", "bindToTargetAdapter", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert", "bindToTargetAdapter", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
                }
            } else {
                j(hVar);
            }
            TextView textView = (TextView) hVar.Mn(R.id.em2);
            ArrayList<com.tencent.mm.plugin.finder.model.y> arrayList = this.tDh;
            if (!(arrayList == null || arrayList.isEmpty())) {
                p.g(textView, "tipsTv");
                ao.a(textView.getPaint(), 0.8f);
                switch (this.tDo) {
                    case 1:
                        Context context = MMApplicationContext.getContext();
                        p.g(context, "MMApplicationContext.getContext()");
                        textView.setText(context.getResources().getString(R.string.csl));
                        textView.setVisibility(0);
                        break;
                    case 2:
                        Context context2 = MMApplicationContext.getContext();
                        p.g(context2, "MMApplicationContext.getContext()");
                        textView.setText(context2.getResources().getString(R.string.ctc));
                        textView.setVisibility(0);
                        break;
                    case 3:
                        Context context3 = MMApplicationContext.getContext();
                        p.g(context3, "MMApplicationContext.getContext()");
                        textView.setText(context3.getResources().getString(R.string.csh));
                        textView.setVisibility(0);
                        break;
                    default:
                        textView.setVisibility(8);
                        break;
                }
            } else {
                p.g(textView, "tipsTv");
                textView.setVisibility(8);
            }
            k(hVar);
            this.tDi = xVar2;
            RecyclerView recyclerView3 = hVar.getRecyclerView();
            if (recyclerView3 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
                AppMethodBeat.o(243059);
                throw tVar;
            }
            RecyclerView.v ch = ((WxRecyclerView) recyclerView3).ch(0);
            if (ch != null) {
                if (ch instanceof h) {
                    Object hgv = ((h) ch).hgv();
                    if ((hgv instanceof ah) && (Mn = hVar.Mn(R.id.ei2)) != null) {
                        if (((ah) hgv).isEmpty()) {
                            Context context4 = hVar.getContext();
                            p.g(context4, "holder.context");
                            Mn.setPadding(Mn.getPaddingLeft(), ((int) context4.getResources().getDimension(R.dimen.cb)) + au.getStatusBarHeight(hVar.getContext()) + au.eu(hVar.getContext()), Mn.getPaddingRight(), Mn.getPaddingBottom());
                            AppMethodBeat.o(243059);
                            return;
                        }
                        Mn.setPadding(Mn.getPaddingLeft(), 0, Mn.getPaddingRight(), Mn.getPaddingBottom());
                        AppMethodBeat.o(243059);
                        return;
                    }
                }
                AppMethodBeat.o(243059);
                return;
            }
        }
        AppMethodBeat.o(243059);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$Companion;", "", "()V", "EMPTY_FOOTER", "", "EMPTY_HEADER", "payloadsListScroll", "payloadsLoadMore", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$itemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class e implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ y tDr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(y yVar) {
            this.tDr = yVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(243048);
            switch (i2) {
                case 2004:
                    z zVar = new z(this.tDr.tDo);
                    AppMethodBeat.o(243048);
                    return zVar;
                default:
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    com.tencent.mm.plugin.finder.utils.y.dQ(this.tDr.TAG, i2);
                    f fVar = new f();
                    AppMethodBeat.o(243048);
                    return fVar;
            }
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        AppMethodBeat.i(243054);
        if (com.tencent.mm.plugin.finder.utils.y.a(com.tencent.mm.plugin.finder.utils.y.vXH, this.tDo, 0, 2)) {
            AppMethodBeat.o(243054);
            return R.layout.q;
        }
        AppMethodBeat.o(243054);
        return R.layout.v;
    }

    private final void j(h hVar) {
        AppMethodBeat.i(243055);
        WxRecyclerView wxRecyclerView = (WxRecyclerView) hVar.Mn(R.id.ek3);
        this.tDj = new WxRecyclerAdapter<>(this.tDm, this.tDh, false);
        WxRecyclerAdapter<?> wxRecyclerAdapter = this.tDj;
        if (wxRecyclerAdapter != null) {
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            g.b unused = wxRecyclerAdapter.f(fl(context), 1, true);
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            g.b unused2 = wxRecyclerAdapter.g(fl(context2), 2, true);
            wxRecyclerAdapter.RqP = new b(wxRecyclerAdapter, this, hVar);
        }
        this.tDk = new LinearLayoutManager(0, false);
        this.tDl = new c(this, hVar);
        p.g(wxRecyclerView, "this");
        wxRecyclerView.setAdapter(this.tDj);
        wxRecyclerView.setLayoutManager(this.tDk);
        if (this.tDl instanceof RecyclerView.l) {
            RecyclerView.l lVar = this.tDl;
            if (lVar == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.OnScrollListener");
                AppMethodBeat.o(243055);
                throw tVar;
            }
            wxRecyclerView.a(lVar);
        }
        Log.i(this.TAG, "[bindAdapter] tabType:" + this.tDo + ",innderAdapter:" + this.tDj);
        AppMethodBeat.o(243055);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f¸\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release", "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$$special$$inlined$let$lambda$1"})
    public static final class b implements g.c<h> {
        final /* synthetic */ WxRecyclerAdapter tDq;
        final /* synthetic */ y tDr;
        final /* synthetic */ h tzq;

        b(WxRecyclerAdapter wxRecyclerAdapter, y yVar, h hVar) {
            this.tDq = wxRecyclerAdapter;
            this.tDr = yVar;
            this.tzq = hVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
            Object obj;
            AppMethodBeat.i(243043);
            h hVar2 = hVar;
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar2, "holder");
            int size = i2 - this.tDq.RqM.size();
            String str = this.tDr.TAG;
            StringBuilder sb = new StringBuilder("click item ");
            if (size < 0 || size >= this.tDr.tDh.size()) {
                obj = "";
            } else {
                obj = this.tDr.tDh.get(size);
                p.g(obj, "adapterData[clickPos]");
            }
            Log.i(str, sb.append(obj).append(" pos:").append(size).toString());
            this.tDr.a(this.tDr.tDh, size, hVar2);
            AppMethodBeat.o(243043);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
    public static final class c extends RecyclerView.l {
        final /* synthetic */ y tDr;
        final /* synthetic */ h tzq;

        c(y yVar, h hVar) {
            this.tDr = yVar;
            this.tzq = hVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(243044);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                y.a(this.tDr, linearLayoutManager.kv());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(243044);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(243045);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            k kVar = k.vkd;
            k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, y.b(this.tDr), com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL_HORIZONTAL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(243045);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243056);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        j(hVar);
        recyclerView.a(this.tDn);
        WxRecyclerView wxRecyclerView = (WxRecyclerView) hVar.Mn(R.id.ek3);
        p.g(wxRecyclerView, "this");
        com.tencent.mm.view.f.a(wxRecyclerView, new g(this));
        AppMethodBeat.o(243056);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$reportExposed$1$1", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
    public static final class g extends e.a {
        final /* synthetic */ y tDr;
        private final HashSet<Long> tDu = new HashSet<>();

        g(y yVar) {
            this.tDr = yVar;
            AppMethodBeat.i(243052);
            AppMethodBeat.o(243052);
        }

        @Override // com.tencent.mm.view.e.a
        public final void b(View view, List<? extends RecyclerView.v> list) {
            AppMethodBeat.i(243053);
            p.h(view, "parent");
            p.h(list, "exposedHolders");
            final LinkedList linkedList = new LinkedList();
            for (T t : list) {
                if (t instanceof h) {
                    Object hgv = t.hgv();
                    if ((hgv instanceof com.tencent.mm.plugin.finder.model.y) && !this.tDu.contains(Long.valueOf(((com.tencent.mm.plugin.finder.model.y) hgv).uOo.id))) {
                        this.tDu.add(Long.valueOf(((com.tencent.mm.plugin.finder.model.y) hgv).uOo.id));
                        linkedList.add(hgv);
                    }
                }
            }
            String str = this.tDr.TAG;
            StringBuilder sb = new StringBuilder("[onChildExposeChanged] exposed=");
            LinkedList<com.tencent.mm.plugin.finder.model.y> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
            for (com.tencent.mm.plugin.finder.model.y yVar : linkedList2) {
                arrayList.add(com.tencent.mm.ac.d.zs(yVar.uOo.id));
            }
            Log.i(str, sb.append(arrayList).toString());
            if (!linkedList.isEmpty()) {
                com.tencent.mm.ac.d.c("FinderFeedLiveListExpose", new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.convert.y.g.AnonymousClass1 */
                    final /* synthetic */ g tDv;

                    {
                        this.tDv = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(243051);
                        LinkedList<com.tencent.mm.plugin.finder.model.y> linkedList = linkedList;
                        ArrayList arrayList = new ArrayList(j.a(linkedList, 10));
                        for (com.tencent.mm.plugin.finder.model.y yVar : linkedList) {
                            com.tencent.mm.plugin.finder.report.s sVar = com.tencent.mm.plugin.finder.report.s.vhF;
                            long j2 = yVar.uOo.id;
                            String str = yVar.uOo.sessionBuffer;
                            bbn bbn = this.tDv.tDr.ttO;
                            arrayList.add(com.tencent.mm.plugin.finder.report.s.a(j2, str, bbn != null ? bbn.tCE : 0));
                        }
                        com.tencent.mm.plugin.finder.report.s sVar2 = com.tencent.mm.plugin.finder.report.s.vhF;
                        com.tencent.mm.plugin.finder.report.s.a(arrayList, this.tDv.tDr.ttO, 0);
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(243051);
                        return xVar;
                    }
                });
            }
            AppMethodBeat.o(243053);
        }
    }

    private final void a(x xVar) {
        AppMethodBeat.i(243057);
        if (this.tDo == 1) {
            boolean z = false;
            ArrayList arrayList = new ArrayList();
            ArrayList<com.tencent.mm.plugin.finder.model.y> arrayList2 = xVar.dtS;
            if (arrayList2 != null) {
                for (T t : arrayList2) {
                    if (t == null || t.uOo.friendLikeCount <= 0) {
                        Log.i(this.TAG, "drop item:".concat(String.valueOf(t)));
                        z = true;
                    } else {
                        arrayList.add(t);
                    }
                }
            }
            if (z) {
                p.h(arrayList, "newList");
                xVar.dtS.clear();
                xVar.dtS.addAll(arrayList);
                xVar.dkB();
                Log.i(this.TAG, "after filter list:".concat(String.valueOf(xVar)));
            }
        }
        AppMethodBeat.o(243057);
    }

    private final boolean a(h hVar, List<Object> list) {
        AppMethodBeat.i(243058);
        List<Object> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            for (T t : list) {
                if (t instanceof Integer) {
                    if (p.j(t, 1)) {
                        RecyclerView recyclerView = (RecyclerView) hVar.Mn(R.id.ek3);
                        if (p.j(recyclerView != null ? recyclerView.getAdapter() : null, this.tDj)) {
                            Log.i(this.TAG, "scrollToPosition 0");
                            RecyclerView recyclerView2 = (RecyclerView) hVar.Mn(R.id.ek3);
                            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                            com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a2.axQ(), "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert", "updatePayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Ljava/util/List;)Z", "Undefined", "scrollToPosition", "(I)V");
                            recyclerView2.scrollToPosition(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert", "updatePayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Ljava/util/List;)Z", "Undefined", "scrollToPosition", "(I)V");
                            AppMethodBeat.o(243058);
                            return true;
                        }
                        AppMethodBeat.o(243058);
                        return false;
                    }
                    AppMethodBeat.o(243058);
                    return false;
                }
            }
        }
        AppMethodBeat.o(243058);
        return false;
    }

    private final void k(h hVar) {
        AppMethodBeat.i(243060);
        if (this.tDo == 2) {
            ArrayList<com.tencent.mm.plugin.finder.model.y> arrayList = this.tDh;
            if (!(arrayList == null || arrayList.isEmpty())) {
                RecyclerView.a adapter = hVar.getAdapter();
                if (adapter instanceof WxRecyclerAdapter) {
                    for (D d2 : ((WxRecyclerAdapter) adapter).data) {
                        if (!(d2 instanceof x)) {
                            View Mn = hVar.Mn(R.id.d8b);
                            p.g(Mn, "holder.getView<View>(R.id.footer)");
                            Mn.setVisibility(0);
                            TextView textView = (TextView) hVar.Mn(R.id.d8z);
                            p.g(textView, "footTv");
                            ao.a(textView.getPaint(), 0.8f);
                            Context context = MMApplicationContext.getContext();
                            p.g(context, "MMApplicationContext.getContext()");
                            textView.setText(context.getResources().getString(R.string.ctd));
                            Log.i(this.TAG, "show footer!");
                            AppMethodBeat.o(243060);
                            return;
                        }
                    }
                    View Mn2 = hVar.Mn(R.id.d8b);
                    p.g(Mn2, "holder.getView<View>(R.id.footer)");
                    Mn2.setVisibility(8);
                }
                AppMethodBeat.o(243060);
            }
        }
        Log.i(this.TAG, "refreshFooterTips,fragmentTabType:" + this.tDo);
        View Mn22 = hVar.Mn(R.id.d8b);
        p.g(Mn22, "holder.getView<View>(R.id.footer)");
        Mn22.setVisibility(8);
        AppMethodBeat.o(243060);
    }

    private static boolean dU(List<Object> list) {
        boolean z;
        AppMethodBeat.i(243061);
        List<Object> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            z = false;
            for (T t : list) {
                if (t instanceof Integer) {
                    z = p.j(t, 2);
                }
            }
        } else {
            z = false;
        }
        AppMethodBeat.o(243061);
        return z;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        AppMethodBeat.i(243062);
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
        Log.i(this.TAG, "[onAttachedToRecyclerView]");
        AppMethodBeat.o(243062);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void c(RecyclerView recyclerView) {
        AppMethodBeat.i(243063);
        p.h(recyclerView, "recyclerView");
        super.c(recyclerView);
        Log.i(this.TAG, "[onDetachedFromRecyclerView]");
        recyclerView.b(this.tDn);
        AppMethodBeat.o(243063);
    }

    private static View fl(Context context) {
        AppMethodBeat.i(243064);
        p.h(context, "context");
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.mm.view.d.e(context, 10.0f), 1));
        AppMethodBeat.o(243064);
        return view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if ((r3 == null || r3.length() == 0) == true) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ArrayList<com.tencent.mm.plugin.finder.model.y> r19, int r20, com.tencent.mm.view.recyclerview.h r21) {
        /*
        // Method dump skipped, instructions count: 515
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.y.a(java.util.ArrayList, int, com.tencent.mm.view.recyclerview.h):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$checkLoadMore$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveStream$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "plugin-finder_release"})
    public static final class d implements v.a {
        final /* synthetic */ y tDr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(y yVar) {
            this.tDr = yVar;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.v.a
        public final void a(int i2, int i3, String str, axi axi) {
            AppMethodBeat.i(243047);
            p.h(axi, "resp");
            this.tDr.aWP = false;
            if (i2 == 0 && i3 == 0) {
                Log.i(this.tDr.TAG, "before merge live list:" + this.tDr.tDi);
                ArrayList<com.tencent.mm.plugin.finder.model.y> a2 = this.tDr.tDi.a(axi);
                ArrayList<com.tencent.mm.plugin.finder.model.y> arrayList = a2;
                if (!(arrayList == null || arrayList.isEmpty())) {
                    com.tencent.mm.ac.d.h(new a(this, a2));
                }
                Log.i(this.tDr.TAG, "after merge live list:" + this.tDr.tDi);
                AppMethodBeat.o(243047);
                return;
            }
            Log.i(this.tDr.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + '}');
            AppMethodBeat.o(243047);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ d tDs;
            final /* synthetic */ ArrayList tDt;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, ArrayList arrayList) {
                super(0);
                this.tDs = dVar;
                this.tDt = arrayList;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(243046);
                y.a(this.tDt, this.tDs.tDr.tDi);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(243046);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class f extends RecyclerView.l {
        final /* synthetic */ y tDr;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(243050);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(243050);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(y yVar) {
            this.tDr = yVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(243049);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            k kVar = k.vkd;
            k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, y.b(this.tDr), com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(243049);
        }
    }

    private final String getScene() {
        if (this.tDo == 1) {
            return s.j.COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW.scene;
        }
        if (this.tDo == 3 || this.tDo != 2) {
            return s.j.COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW.scene;
        }
        return s.j.COMMENT_SCENE_LBS_TOP_LIVE_CARD.scene;
    }

    public static final /* synthetic */ void a(y yVar, int i2) {
        boolean z;
        int size;
        int size2;
        AppMethodBeat.i(243068);
        x xVar = yVar.tDi;
        if (!xVar.uOm || (size2 = (size = xVar.dtS.size()) - i2) > 5 || yVar.aWP) {
            z = false;
        } else {
            Log.i(yVar.TAG, "[needToLoadMore] size:" + size + ", lastPos:" + i2 + ", leftSize:" + size2 + ", loading:" + yVar.aWP);
            z = true;
        }
        if (z) {
            yVar.aWP = true;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
            o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
            new v(yVar.tDi.tVe, yVar.tDo, dHP.first.floatValue(), dHP.second.floatValue(), new d(yVar)).aYI();
        }
        AppMethodBeat.o(243068);
    }

    public static final /* synthetic */ void a(ArrayList arrayList, x xVar) {
        int i2;
        FinderObject finderObject;
        FinderContact finderContact;
        AppMethodBeat.i(243070);
        hn hnVar = new hn();
        hnVar.dLW.id = xVar.uOl;
        hnVar.dLW.dLY = 1;
        hn.a aVar = hnVar.dLW;
        com.tencent.mm.plugin.finder.model.y yVar = (com.tencent.mm.plugin.finder.model.y) j.kt(arrayList);
        if (yVar == null || (finderObject = yVar.uOo) == null || (finderContact = finderObject.contact) == null) {
            i2 = 1;
        } else {
            i2 = finderContact.liveStatus;
        }
        aVar.liveStatus = i2;
        hn.a aVar2 = hnVar.dLW;
        d.a aVar3 = com.tencent.mm.plugin.finder.model.d.uNN;
        aVar2.username = d.a.ag(arrayList);
        hnVar.dLW.type = 9;
        EventCenter.instance.publish(hnVar);
        AppMethodBeat.o(243070);
    }
}
