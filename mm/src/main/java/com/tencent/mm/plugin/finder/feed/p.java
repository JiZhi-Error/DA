package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.cgi.r;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.af;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onDetach", "showBottomSheet", "FriendLikeShowInfo", "plugin-finder_release"})
public final class p extends t {
    final Context context;
    private IListener<hh> tOh;

    public p(Context context2) {
        kotlin.g.b.p.h(context2, "context");
        AppMethodBeat.i(243874);
        this.context = context2;
        AppMethodBeat.o(243874);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw, com.tencent.mm.plugin.finder.feed.t
    public final WxRecyclerAdapter<?> fm(Context context2) {
        AppMethodBeat.i(243865);
        kotlin.g.b.p.h(context2, "context");
        WxRecyclerAdapter<?> wxRecyclerAdapter = new WxRecyclerAdapter<>(dcK(), this.data);
        AppMethodBeat.o(243865);
        return wxRecyclerAdapter;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class b implements f {
        final /* synthetic */ p tOi;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<aul, x> {
            final /* synthetic */ b tOj;
            final /* synthetic */ bfp tOk;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, bfp bfp) {
                super(1);
                this.tOj = bVar;
                this.tOk = bfp;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(aul aul) {
                int i2 = 1;
                AppMethodBeat.i(243857);
                aul aul2 = aul;
                kotlin.g.b.p.h(aul2, LocaleUtil.ITALIAN);
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tOj.tOi.context);
                if (fH != null) {
                    k kVar = k.vfA;
                    bbn dIx = fH.dIx();
                    long id = this.tOj.tOi.getFeedObj().getId();
                    if (aul2.likeFlag != 1) {
                        i2 = 2;
                    }
                    k.a(dIx, id, i2, aul2.dMW);
                }
                new r(this.tOk, aul2, this.tOk.ttO).aYI();
                x xVar = x.SXb;
                AppMethodBeat.o(243857);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.p$b$b  reason: collision with other inner class name */
        static final class C1162b extends q implements kotlin.g.a.b<aul, x> {
            final /* synthetic */ b tOj;
            final /* synthetic */ bfp tOk;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1162b(b bVar, bfp bfp) {
                super(1);
                this.tOj = bVar;
                this.tOk = bfp;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(aul aul) {
                ay ayVar;
                AppMethodBeat.i(243858);
                aul aul2 = aul;
                kotlin.g.b.p.h(aul2, "likeInfo");
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tOj.tOi.context);
                if (fH != null) {
                    k kVar = k.vfA;
                    k.a(fH.dIx(), this.tOj.tOi.getFeedObj().getId(), aul2.LFn == 1 ? 3 : 4, aul2.dMW);
                }
                if (aul2.LFn == 1) {
                    String str = aul2.dMW;
                    ay.a aVar2 = ay.tuW;
                    ayVar = new ay(str, ay.tuU, this.tOk.scene);
                } else {
                    String str2 = aul2.dMW;
                    ay.a aVar3 = ay.tuW;
                    ayVar = new ay(str2, ay.tuV, this.tOk.scene);
                }
                ayVar.ttq = aul2;
                g.azz().b(ayVar);
                p.a(this.tOj.tOi);
                x xVar = x.SXb;
                AppMethodBeat.o(243858);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(p pVar) {
            this.tOi = pVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(243859);
            n nVar = new n(this.tOi.getFeedObj().getId());
            bfp bfp = new bfp();
            bfp.feedId = this.tOi.getFeedObj().field_id;
            bfp.objectNonceId = this.tOi.getFeedObj().getFeedObject().objectNonceId;
            bfp.scene = 2;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tOi.context);
            bfp.ttO = fH != null ? fH.dIx() : null;
            nVar.tBx = new a(this, bfp);
            nVar.tBy = new C1162b(this, bfp);
            n nVar2 = nVar;
            AppMethodBeat.o(243859);
            return nVar2;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.t
    public final f dcK() {
        AppMethodBeat.i(243866);
        b bVar = new b(this);
        AppMethodBeat.o(243866);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class c extends RecyclerView.h {
        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(243860);
            kotlin.g.b.p.h(rect, "outRect");
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(recyclerView, "parent");
            kotlin.g.b.p.h(sVar, "state");
            rect.set(0, 0, 0, 0);
            AppMethodBeat.o(243860);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw, com.tencent.mm.plugin.finder.feed.t
    public final RecyclerView.h fi(Context context2) {
        AppMethodBeat.i(243867);
        kotlin.g.b.p.h(context2, "context");
        c cVar = new c();
        AppMethodBeat.o(243867);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw, com.tencent.mm.plugin.finder.feed.t
    public final int getScene() {
        AppMethodBeat.i(243868);
        FinderLikeDrawer.a aVar = FinderLikeDrawer.wnm;
        int i2 = FinderLikeDrawer.tvl;
        AppMethodBeat.o(243868);
        return i2;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw, com.tencent.mm.plugin.finder.feed.t
    public final RecyclerView.LayoutManager eS(Context context2) {
        AppMethodBeat.i(243869);
        kotlin.g.b.p.h(context2, "context");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1, false);
        AppMethodBeat.o(243869);
        return linearLayoutManager;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class d extends IListener<hh> {
        final /* synthetic */ p tOi;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(p pVar) {
            this.tOi = pVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hh hhVar) {
            AppMethodBeat.i(243863);
            if (hhVar != null) {
                com.tencent.mm.ac.d.h(new a(this));
            }
            AppMethodBeat.o(243863);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$onAttach$1$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d tOl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.tOl = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(243862);
                final HashMap hashMap = new HashMap();
                int size = this.tOl.tOi.data.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.tOl.tOi.data.get(i2).uOk.LFn = 1;
                    String str = this.tOl.tOi.data.get(i2).uOk.dMW;
                    if (str == null) {
                        str = "";
                    }
                    hashMap.put(str, new o(this.tOl.tOi.data.get(i2).uOk, Integer.valueOf(i2)));
                }
                this.tOl.tOi.A(new kotlin.g.a.b<LinkedList<aul>, LinkedList<aul>>(this) {
                    /* class com.tencent.mm.plugin.finder.feed.p.d.a.AnonymousClass1 */
                    final /* synthetic */ a tOm;

                    {
                        this.tOm = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ LinkedList<aul> invoke(LinkedList<aul> linkedList) {
                        AppMethodBeat.i(243861);
                        LinkedList<aul> linkedList2 = linkedList;
                        this.tOm.tOl.tOi.data.clear();
                        if (linkedList2 != null) {
                            Iterator<T> it = linkedList2.iterator();
                            while (it.hasNext()) {
                                HashMap hashMap = hashMap;
                                String str = it.next().dMW;
                                if (hashMap == null) {
                                    t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                                    AppMethodBeat.o(243861);
                                    throw tVar;
                                }
                                af.fd(hashMap).remove(str);
                            }
                        }
                        for (Map.Entry entry : hashMap.entrySet()) {
                            if (linkedList2 != null) {
                                int intValue = ((o) entry.getValue()).second.intValue();
                                if (intValue > linkedList2.size()) {
                                    intValue = linkedList2.size();
                                }
                                Log.d("Finder.DrawerPresenter", "unlikeInfo " + ((o) entry.getValue()).first.nickName);
                                linkedList2.add(intValue, ((o) entry.getValue()).first);
                            }
                        }
                        AppMethodBeat.o(243861);
                        return linkedList2;
                    }
                });
                x xVar = x.SXb;
                AppMethodBeat.o(243862);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw, com.tencent.mm.plugin.finder.feed.t
    public final void a(com.tencent.mm.plugin.finder.view.builder.a aVar, FinderItem finderItem, com.tencent.mm.bw.b bVar) {
        AppMethodBeat.i(243870);
        kotlin.g.b.p.h(aVar, "builder");
        kotlin.g.b.p.h(finderItem, "feedObj");
        super.a(aVar, finderItem, bVar);
        this.tOh = new d(this);
        EventCenter.instance.add(this.tOh);
        d.a aVar2 = com.tencent.mm.plugin.finder.storage.data.d.vFS;
        d.a.dyw().onAlive();
        d.a aVar3 = com.tencent.mm.plugin.finder.storage.data.d.vFS;
        d.a.dyw();
        com.tencent.mm.plugin.finder.storage.data.d.dyu();
        AppMethodBeat.o(243870);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$1$1"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tOn;

        e(com.tencent.mm.plugin.finder.view.d dVar) {
            this.tOn = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243864);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tOn.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243864);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw, com.tencent.mm.plugin.finder.feed.t
    public final void dV(View view) {
        AppMethodBeat.i(243872);
        kotlin.g.b.p.h(view, "view");
        AppMethodBeat.o(243872);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw, com.tencent.mm.plugin.finder.feed.t
    public final void a(Context context2, FrameLayout frameLayout) {
        AppMethodBeat.i(243873);
        kotlin.g.b.p.h(context2, "context");
        kotlin.g.b.p.h(frameLayout, "headerLayout");
        View findViewById = frameLayout.findViewById(R.id.bv4);
        kotlin.g.b.p.g(findViewById, "headerLayout.findViewByI…iew>(R.id.drawer_more_op)");
        findViewById.setVisibility(0);
        frameLayout.findViewById(R.id.bv4).setOnClickListener(new a(this, context2));
        AppMethodBeat.o(243873);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ Context $context;
        final /* synthetic */ p tOi;

        a(p pVar, Context context) {
            this.tOi = pVar;
            this.$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243856);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$doExtraTitleChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.$context, intent, this.tOi.getFeedObj().getId(), 0, false, 120);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fx(this.$context);
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.$context);
            if (fH != null) {
                k kVar = k.vfA;
                k.a(fH.dIx(), this.tOi.getFeedObj().getId(), 5, "");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFriendLikeListDrawerPresenter$doExtraTitleChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243856);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw, com.tencent.mm.plugin.finder.feed.t
    public final void onDetach() {
        AppMethodBeat.i(243871);
        if (!this.iuM) {
            Log.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
            AppMethodBeat.o(243871);
            return;
        }
        ArrayList<v> arrayList = new ArrayList();
        for (T t : this.data) {
            if (t.uOk.LFn == 1) {
                arrayList.add(t);
            }
        }
        for (v vVar : arrayList) {
            ii iiVar = new ii();
            iiVar.dMV.dMW = vVar.uOk.dMW;
            ii.a aVar = iiVar.dMV;
            aVar.dMX = vVar.uOb ? 1 : 0;
            EventCenter.instance.publish(iiVar);
        }
        super.onDetach();
        d.a aVar2 = com.tencent.mm.plugin.finder.storage.data.d.vFS;
        d.a.dyw().onDetach();
        EventCenter.instance.removeListener(this.tOh);
        AppMethodBeat.o(243871);
    }

    public static final /* synthetic */ void a(p pVar) {
        AppMethodBeat.i(243875);
        com.tencent.mm.kernel.e aAh = g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_HAS_SHOWN_BLACK_LIST_TIPS_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(243875);
            throw tVar;
        }
        if (!((Boolean) obj).booleanValue()) {
            com.tencent.mm.kernel.e aAh2 = g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_HAS_SHOWN_BLACK_LIST_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.plugin.finder.view.builder.a aVar = pVar.tOx;
            Context context2 = aVar != null ? aVar.getContext() : null;
            if (context2 == null) {
                kotlin.g.b.p.hyc();
            }
            com.tencent.mm.plugin.finder.view.d dVar = new com.tencent.mm.plugin.finder.view.d(context2);
            dVar.Ml(R.layout.aky);
            TextView textView = (TextView) dVar.lJI.findViewById(R.id.j03);
            textView.setOnClickListener(new e(dVar));
            kotlin.g.b.p.g(textView, "cancel");
            ao.a(textView.getPaint(), 0.8f);
            ((ImageView) dVar.lJI.findViewById(R.id.j05)).setImageResource(ao.isDarkMode() ? R.drawable.ct8 : R.drawable.ct7);
            dVar.dGm();
        }
        AppMethodBeat.o(243875);
    }
}
