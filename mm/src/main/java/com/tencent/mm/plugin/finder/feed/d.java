package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.he;
import com.tencent.mm.plugin.finder.convert.g;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.data.f;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020%J\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0/H\u0002J\u0006\u00100\u001a\u00020-J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020\u0002H\u0016J\b\u00103\u001a\u00020-H\u0016J\u0006\u00104\u001a\u00020-R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getContext", "()Landroid/content/Context;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "downContinue", "", "Ljava/lang/Boolean;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "isLoading", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "loadCallbackListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "notLoadAnyMore", "scene", "", "getScene", "()I", "setScene", "(I)V", "tabType", "viewCallback", "bindData", "", "getCommentFromCache", "", "loadData", "onAttach", "callback", "onDetach", "releaseListener", "Companion", "plugin-finder_release"})
public final class d implements com.tencent.mm.plugin.finder.presenter.base.a<e> {
    public static final a tMv = new a((byte) 0);
    final Context context;
    private int dLS;
    ArrayList<s> data = new ArrayList<>();
    FeedData feed;
    private boolean isLoading;
    private com.tencent.mm.bw.b lastBuffer;
    private int scene = 2;
    private final WxRecyclerAdapter<s> tFp = new WxRecyclerAdapter<>(new b(this), this.data);
    private e tMr;
    private IListener<he> tMs;
    private Boolean tMt = Boolean.TRUE;
    private boolean tMu;

    static {
        AppMethodBeat.i(243719);
        AppMethodBeat.o(243719);
    }

    public d(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(243718);
        this.context = context2;
        AppMethodBeat.o(243718);
    }

    public static final /* synthetic */ List b(d dVar) {
        AppMethodBeat.i(243720);
        List<s> dcw = dVar.dcw();
        AppMethodBeat.o(243720);
        return dcw;
    }

    public static final /* synthetic */ e c(d dVar) {
        AppMethodBeat.i(243721);
        e eVar = dVar.tMr;
        if (eVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(243721);
        return eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(e eVar) {
        AppMethodBeat.i(243716);
        a(eVar);
        AppMethodBeat.o(243716);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$Companion;", "", "()V", "TAG", "", "initSwitch", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class b implements f {
        final /* synthetic */ d tMw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(d dVar) {
            this.tMw = dVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            AppMethodBeat.i(243707);
            s.a aVar = s.uOj;
            if (i2 == s.dky()) {
                g gVar = new g(this.tMw.context);
                AppMethodBeat.o(243707);
                return gVar;
            }
            s.a aVar2 = s.uOj;
            if (i2 == s.dkz()) {
                g gVar2 = new g(this.tMw.context);
                AppMethodBeat.o(243707);
                return gVar2;
            }
            y yVar = y.vXH;
            y.dQ("Finder.FinderBulletSubtitlePresenter", i2);
            com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
            AppMethodBeat.o(243707);
            return fVar;
        }
    }

    public final void a(FeedData feedData, int i2) {
        AppMethodBeat.i(243710);
        p.h(feedData, "feed");
        this.dLS = i2;
        this.isLoading = false;
        this.feed = feedData;
        com.tencent.mm.plugin.finder.report.c cVar = com.tencent.mm.plugin.finder.report.c.vdc;
        com.tencent.mm.plugin.finder.report.c.start(feedData.getId());
        this.data.clear();
        this.tFp.notifyDataSetChanged();
        dcx();
        this.tMu = false;
        AppMethodBeat.o(243710);
    }

    public final WxRecyclerAdapter<?> fm(Context context2) {
        AppMethodBeat.i(243711);
        p.h(context2, "context");
        WxRecyclerAdapter<s> wxRecyclerAdapter = this.tFp;
        AppMethodBeat.o(243711);
        return wxRecyclerAdapter;
    }

    public final void bqe() {
        AppMethodBeat.i(243712);
        if (this.feed != null && !this.tMu && !this.isLoading) {
            if (!(!this.data.isEmpty())) {
                this.isLoading = true;
                IListener<he> iListener = this.tMs;
                if (iListener != null) {
                    iListener.dead();
                }
                this.tMs = new c(this);
                IListener<he> iListener2 = this.tMs;
                if (iListener2 != null) {
                    iListener2.alive();
                }
                this.data.addAll(dcw());
                if (!this.data.isEmpty()) {
                    dcx();
                }
                StringBuilder append = new StringBuilder("refreshData: get comment from cache, size=").append(this.data.size()).append(", feedId=");
                FeedData feedData = this.feed;
                if (feedData == null) {
                    p.hyc();
                }
                Log.i("Finder.FinderBulletSubtitlePresenter", append.append(feedData.getId()).toString());
                this.tFp.notifyDataSetChanged();
                AppMethodBeat.o(243712);
                return;
            }
        }
        AppMethodBeat.o(243712);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$loadData$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class c extends IListener<he> {
        final /* synthetic */ d tMw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(d dVar) {
            this.tMw = dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(he heVar) {
            AppMethodBeat.i(243709);
            he heVar2 = heVar;
            if (heVar2 != null) {
                FeedData feedData = this.tMw.feed;
                if (feedData == null) {
                    p.hyc();
                }
                long id = feedData.getId();
                he.a aVar = heVar2.dLG;
                if (aVar == null || id != aVar.feedId) {
                    AppMethodBeat.o(243709);
                    return false;
                } else if (heVar2.dLG.dLH) {
                    StringBuilder sb = new StringBuilder("refreshData: callback data is empty, feedId=");
                    FeedData feedData2 = this.tMw.feed;
                    if (feedData2 == null) {
                        p.hyc();
                    }
                    Log.i("Finder.FinderBulletSubtitlePresenter", sb.append(feedData2.getId()).toString());
                    this.tMw.tMu = true;
                    this.tMw.dcx();
                } else {
                    com.tencent.mm.ac.d.h(new a(this));
                }
            }
            AppMethodBeat.o(243709);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$loadData$1$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ c tMx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar) {
                super(0);
                this.tMx = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(243708);
                List b2 = d.b(this.tMx.tMw);
                if (b2.size() != this.tMx.tMw.data.size()) {
                    this.tMx.tMw.data.clear();
                    this.tMx.tMw.data.addAll(b2);
                    StringBuilder append = new StringBuilder("refreshData: get comment from callback, size=").append(this.tMx.tMw.data.size()).append(", feedId=");
                    FeedData feedData = this.tMx.tMw.feed;
                    if (feedData == null) {
                        p.hyc();
                    }
                    Log.i("Finder.FinderBulletSubtitlePresenter", append.append(feedData.getId()).toString());
                    d.c(this.tMx.tMw).startLoop();
                    this.tMx.tMw.dcx();
                    this.tMx.tMw.isLoading = false;
                }
                x xVar = x.SXb;
                AppMethodBeat.o(243708);
                return xVar;
            }
        }
    }

    private final List<s> dcw() {
        com.tencent.mm.bw.b bVar;
        Boolean bool = null;
        AppMethodBeat.i(243713);
        ArrayList arrayList = new ArrayList();
        com.tencent.mm.plugin.finder.storage.data.f fVar = com.tencent.mm.plugin.finder.storage.data.f.vGd;
        FeedData feedData = this.feed;
        if (feedData == null) {
            p.hyc();
        }
        List<an> FG = fVar.FG(feedData.getId());
        if (FG != null) {
            com.tencent.mm.plugin.finder.storage.data.f fVar2 = com.tencent.mm.plugin.finder.storage.data.f.vGd;
            FeedData feedData2 = this.feed;
            if (feedData2 == null) {
                p.hyc();
            }
            f.b U = fVar2.U(feedData2.getId(), 0);
            if (U != null) {
                bVar = U.lastBuffer;
            } else {
                bVar = null;
            }
            this.lastBuffer = bVar;
            if (U != null) {
                bool = Boolean.valueOf(U.tMU);
            }
            this.tMt = bool;
            List<an> list = FG;
            ArrayList arrayList2 = new ArrayList(j.a(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new s(it.next()));
            }
            arrayList.addAll(arrayList2);
            this.isLoading = false;
            this.tFp.notifyDataSetChanged();
        }
        ArrayList arrayList3 = arrayList;
        AppMethodBeat.o(243713);
        return arrayList3;
    }

    public final void dcx() {
        AppMethodBeat.i(243714);
        IListener<he> iListener = this.tMs;
        if (iListener != null) {
            iListener.dead();
        }
        this.tMs = null;
        this.isLoading = false;
        AppMethodBeat.o(243714);
    }

    public final void a(e eVar) {
        AppMethodBeat.i(243715);
        p.h(eVar, "callback");
        this.tMr = eVar;
        e eVar2 = this.tMr;
        if (eVar2 == null) {
            p.btv("viewCallback");
        }
        eVar2.initView();
        AppMethodBeat.o(243715);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(243717);
        dcx();
        AppMethodBeat.o(243717);
    }
}
