package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.finder.cgi.bd;
import com.tencent.mm.plugin.finder.cgi.cm;
import com.tencent.mm.plugin.finder.convert.cc;
import com.tencent.mm.plugin.finder.convert.cd;
import com.tencent.mm.plugin.finder.convert.ce;
import com.tencent.mm.plugin.finder.model.bi;
import com.tencent.mm.plugin.finder.model.bj;
import com.tencent.mm.plugin.finder.ui.FinderSelectActivityUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.k;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract;", "", "()V", "IS_MOCK_DATA", "", "SelectPresenter", "SelectViewCallback", "plugin-finder_release"})
public final class ae {
    public static final ae tQk = new ae();

    static {
        AppMethodBeat.i(244153);
        AppMethodBeat.o(244153);
    }

    private ae() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0016\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00019B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0005J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ2\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010'\u001a\u0004\u0018\u00010\u0012H\u0002J\u0006\u0010(\u001a\u00020\u001cJ\u001e\u0010)\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\u001cH\u0016J,\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u00010\u00072\b\u00102\u001a\u0004\u0018\u000103H\u0016J \u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u00020 H\u0002R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isUserActivityList", "", "posterUserName", "", "(ZLjava/lang/String;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoData;", "Lkotlin/collections/ArrayList;", "firstPage", "Lcom/tencent/mm/plugin/finder/storage/data/FinderActivityPage;", "isDown", "()Z", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "getPosterUserName", "()Ljava/lang/String;", "removeEvent", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1;", "startLoadingTime", "", "viewCallback", "doGetActivityScene", "", "fakeHasMore", "fakeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getData", "handleSceneEnd", "requestBuffer", "continueCount", "", "eventList", "lastResponseBuffer", "loadStart", "mergeData", "eventInfoList", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "optEventInfo", "eventName", "participantCount", "description", "optValidEventInfo", "Companion", "plugin-finder_release"})
    public static final class a implements i, com.tencent.mm.plugin.finder.presenter.base.a<b> {
        public static final C1124a tQs = new C1124a((byte) 0);
        ArrayList<com.tencent.mm.plugin.finder.model.l> kgc;
        private boolean tQl;
        private b tQm;
        private com.tencent.mm.plugin.finder.storage.data.c tQn;
        private long tQo;
        private final g tQp;
        private final boolean tQq;
        private final String tQr;
        private com.tencent.mm.bw.b tsO;

        static {
            AppMethodBeat.i(244133);
            AppMethodBeat.o(244133);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "invoke"})
        public static final class f extends q implements kotlin.g.a.b<LinkedList<aqk>, Object> {
            final /* synthetic */ a tQt;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(a aVar) {
                super(1);
                this.tQt = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Object invoke(LinkedList<aqk> linkedList) {
                AppMethodBeat.i(244121);
                LinkedList<aqk> linkedList2 = linkedList;
                com.tencent.mm.bw.b bVar = this.tQt.tsO;
                if (bVar == null) {
                    if (linkedList2 != null) {
                        if (this.tQt.kgc.isEmpty()) {
                            ArrayList arrayList = this.tQt.kgc;
                            LinkedList<aqk> linkedList3 = linkedList2;
                            ArrayList arrayList2 = new ArrayList(j.a(linkedList3, 10));
                            Iterator<T> it = linkedList3.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new com.tencent.mm.plugin.finder.model.l(it.next()));
                            }
                            arrayList.addAll(arrayList2);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(244121);
                        return xVar;
                    }
                    bVar = null;
                }
                AppMethodBeat.o(244121);
                return bVar;
            }
        }

        public /* synthetic */ a() {
            this(false, "");
            AppMethodBeat.i(244132);
            AppMethodBeat.o(244132);
        }

        public a(boolean z, String str) {
            AppMethodBeat.i(244131);
            this.tQq = z;
            this.tQr = str;
            this.kgc = new ArrayList<>();
            this.tQn = new com.tencent.mm.plugin.finder.storage.data.c("activityList.fp");
            this.tQo = SystemClock.uptimeMillis();
            this.tQp = new g(this);
            AppMethodBeat.o(244131);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(b bVar) {
            AppMethodBeat.i(244126);
            a(bVar);
            AppMethodBeat.o(244126);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "TAG", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.ae$a$a  reason: collision with other inner class name */
        public static final class C1124a {
            private C1124a() {
            }

            public /* synthetic */ C1124a(byte b2) {
                this();
            }
        }

        public final void a(b bVar) {
            AppMethodBeat.i(244125);
            p.h(bVar, "callback");
            this.tQm = bVar;
            com.tencent.mm.ac.d.b(com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), new e(this)), new f(this));
            na(false);
            if (this.tQq) {
                com.tencent.mm.kernel.g.azz().a(6833, this);
            } else {
                com.tencent.mm.kernel.g.azz().a(5839, this);
            }
            this.tQp.alive();
            AppMethodBeat.o(244125);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            AppMethodBeat.i(244127);
            if (this.tQq) {
                com.tencent.mm.kernel.g.azz().b(6833, this);
            } else {
                com.tencent.mm.kernel.g.azz().b(5839, this);
            }
            this.tQp.dead();
            this.tQm = null;
            AppMethodBeat.o(244127);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            b bVar;
            com.tencent.mm.bw.b bVar2 = null;
            AppMethodBeat.i(244128);
            if (i2 == 0 && i3 == 0) {
                if (qVar instanceof bd) {
                    com.tencent.mm.bw.a aYJ = ((bd) qVar).rr.aYJ();
                    if (!(aYJ instanceof bbb)) {
                        aYJ = null;
                    }
                    bbb bbb = (bbb) aYJ;
                    if (bbb != null) {
                        bVar2 = bbb.LDs;
                    }
                    com.tencent.mm.bw.a aYK = ((bd) qVar).rr.aYK();
                    if (aYK == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderRecommendEventResponse");
                        AppMethodBeat.o(244128);
                        throw tVar;
                    }
                    a(bVar2, ((bbc) aYK).tUC, ((bd) qVar).cYl(), ((bd) qVar).cYm());
                    AppMethodBeat.o(244128);
                    return;
                }
                if (qVar instanceof cm) {
                    com.tencent.mm.bw.a aYJ2 = ((cm) qVar).rr.aYJ();
                    if (!(aYJ2 instanceof aql)) {
                        aYJ2 = null;
                    }
                    aql aql = (aql) aYJ2;
                    if (aql != null) {
                        bVar2 = aql.lastBuffer;
                    }
                    com.tencent.mm.bw.a aYK2 = ((cm) qVar).rr.aYK();
                    if (aYK2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderEventUserPageResponse");
                        AppMethodBeat.o(244128);
                        throw tVar2;
                    }
                    a(bVar2, ((aqm) aYK2).continueFlag, ((cm) qVar).cYl(), ((cm) qVar).cYm());
                }
                AppMethodBeat.o(244128);
            } else if (this.tsO != null || (bVar = this.tQm) == null) {
                AppMethodBeat.o(244128);
            } else {
                ProgressBar progressBar = bVar.progressBar;
                if (progressBar == null) {
                    p.btv("progressBar");
                }
                progressBar.setVisibility(8);
                TextView textView = bVar.tQE;
                if (textView == null) {
                    p.btv("retryTextView");
                }
                textView.setVisibility(0);
                AppMethodBeat.o(244128);
            }
        }

        private final void a(com.tencent.mm.bw.b bVar, int i2, LinkedList<aqk> linkedList, com.tencent.mm.bw.b bVar2) {
            long j2;
            AppMethodBeat.i(244129);
            if (!p.j(this.tsO, bVar)) {
                Log.i("Finder.SelectPresenter", "not my buf, ignore!");
                AppMethodBeat.o(244129);
                return;
            }
            z.a aVar = new z.a();
            aVar.SYB = false;
            if (this.tsO == null) {
                aVar.SYB = true;
                com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), new b(this, aVar, linkedList));
            }
            this.tsO = bVar2;
            int size = this.kgc.size();
            long uptimeMillis = SystemClock.uptimeMillis() - this.tQo;
            if (!this.tQl) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (uptimeMillis < com.tencent.mm.plugin.finder.storage.c.dty().value().longValue()) {
                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    j2 = com.tencent.mm.plugin.finder.storage.c.dty().value().longValue() - uptimeMillis;
                    com.tencent.mm.ac.d.a(j2, new c(new d(this, aVar, linkedList, size, i2)));
                    AppMethodBeat.o(244129);
                }
            }
            j2 = 0;
            com.tencent.mm.ac.d.a(j2, new c(new d(this, aVar, linkedList, size, i2)));
            AppMethodBeat.o(244129);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class d implements Runnable {
            final /* synthetic */ a tQt;
            final /* synthetic */ z.a tQw;
            final /* synthetic */ LinkedList tQx;
            final /* synthetic */ int tQy;
            final /* synthetic */ int tQz;

            d(a aVar, z.a aVar2, LinkedList linkedList, int i2, int i3) {
                this.tQt = aVar;
                this.tQw = aVar2;
                this.tQx = linkedList;
                this.tQy = i2;
                this.tQz = i3;
            }

            public final void run() {
                boolean z;
                AppMethodBeat.i(244119);
                a.a(this.tQt, this.tQw.SYB, this.tQx);
                b bVar = this.tQt.tQm;
                if (bVar != null) {
                    boolean z2 = this.tQt.tQl;
                    int i2 = this.tQy;
                    int size = this.tQx.size();
                    if (this.tQz > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z3 = this.tQw.SYB;
                    bVar.hasMore = z;
                    FrameLayout frameLayout = bVar.tQF;
                    if (frameLayout == null) {
                        p.btv("progressContainer");
                    }
                    frameLayout.setVisibility(8);
                    ProgressBar progressBar = bVar.progressBar;
                    if (progressBar == null) {
                        p.btv("progressBar");
                    }
                    progressBar.setVisibility(8);
                    TextView textView = bVar.tQE;
                    if (textView == null) {
                        p.btv("retryTextView");
                    }
                    textView.setVisibility(8);
                    WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.l> wxRecyclerAdapter = bVar.tFp;
                    if (wxRecyclerAdapter != null) {
                        if (z3) {
                            wxRecyclerAdapter.notifyDataSetChanged();
                        } else {
                            wxRecyclerAdapter.as(i2 + 1, size);
                        }
                    }
                    if (z2) {
                        RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                        cVar.Rmj = bVar.hasMore;
                        cVar.Rmk = size;
                        if (cVar.Rmk > 0) {
                            cVar.jLE = false;
                        }
                        RefreshLoadMoreLayout refreshLoadMoreLayout = bVar.tLS;
                        if (refreshLoadMoreLayout == null) {
                            p.btv("rlLayout");
                        }
                        refreshLoadMoreLayout.onPreFinishLoadMoreSmooth(cVar);
                        AppMethodBeat.o(244119);
                        return;
                    }
                    RefreshLoadMoreLayout refreshLoadMoreLayout2 = bVar.tLS;
                    if (refreshLoadMoreLayout2 == null) {
                        p.btv("rlLayout");
                    }
                    refreshLoadMoreLayout2.apS(0);
                    if (!bVar.hasMore) {
                        RefreshLoadMoreLayout refreshLoadMoreLayout3 = bVar.tLS;
                        if (refreshLoadMoreLayout3 == null) {
                            p.btv("rlLayout");
                        }
                        RefreshLoadMoreLayout.e(refreshLoadMoreLayout3);
                    }
                    AppMethodBeat.o(244119);
                    return;
                }
                AppMethodBeat.o(244119);
            }
        }

        public final void na(boolean z) {
            AppMethodBeat.i(244130);
            this.tQl = z;
            this.tQo = SystemClock.uptimeMillis();
            if (this.tQq) {
                com.tencent.mm.kernel.g.azz().b(new cm(this.tsO, this.tQr));
                AppMethodBeat.o(244130);
                return;
            }
            com.tencent.mm.kernel.g.azz().b(new bd(this.tsO));
            AppMethodBeat.o(244130);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
        public static final class g extends IListener<com.tencent.mm.g.a.f> {
            final /* synthetic */ a tQt;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            g(a aVar) {
                this.tQt = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(com.tencent.mm.g.a.f fVar) {
                AppMethodBeat.i(244124);
                boolean a2 = a(fVar);
                AppMethodBeat.o(244124);
                return a2;
            }

            private boolean a(com.tencent.mm.g.a.f fVar) {
                AppMethodBeat.i(244123);
                if (fVar != null) {
                    z.d dVar = new z.d();
                    dVar.SYE = 0;
                    for (com.tencent.mm.plugin.finder.model.l lVar : this.tQt.kgc) {
                        if (lVar.tqo.twd != fVar.dBS.dBT || lVar.tqo.LCy <= 0) {
                            dVar.SYE++;
                        } else {
                            aqk aqk = lVar.tqo;
                            aqk.LCy--;
                            this.tQt.tQn.blr();
                            com.tencent.mm.ac.d.h(new C1125a(lVar, dVar, this, fVar));
                        }
                    }
                }
                AppMethodBeat.o(244123);
                return false;
            }

            /* access modifiers changed from: package-private */
            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1$callback$1$1$1", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1$$special$$inlined$forEach$lambda$1"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.ae$a$g$a  reason: collision with other inner class name */
            public static final class C1125a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ com.tencent.mm.plugin.finder.model.l tQA;
                final /* synthetic */ z.d tQB;
                final /* synthetic */ g tQC;
                final /* synthetic */ com.tencent.mm.g.a.f tQD;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1125a(com.tencent.mm.plugin.finder.model.l lVar, z.d dVar, g gVar, com.tencent.mm.g.a.f fVar) {
                    super(0);
                    this.tQA = lVar;
                    this.tQB = dVar;
                    this.tQC = gVar;
                    this.tQD = fVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.l> wxRecyclerAdapter;
                    AppMethodBeat.i(244122);
                    Log.i("Finder.SelectPresenter", "activity profile tab update count: " + this.tQA.tqo.LCy);
                    b bVar = this.tQC.tQt.tQm;
                    if (!(bVar == null || (wxRecyclerAdapter = bVar.tFp) == null)) {
                        wxRecyclerAdapter.ci(this.tQB.SYE);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(244122);
                    return xVar;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$handleSceneEnd$1$1"})
        public static final class b extends q implements kotlin.g.a.b<Void, x> {
            final /* synthetic */ a tQt;
            final /* synthetic */ z.a tQu;
            final /* synthetic */ LinkedList tQv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, z.a aVar2, LinkedList linkedList) {
                super(1);
                this.tQt = aVar;
                this.tQu = aVar2;
                this.tQv = linkedList;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Void r4) {
                AppMethodBeat.i(244117);
                this.tQt.tQn.blr();
                this.tQt.tQn.r(this.tQv);
                x xVar = x.SXb;
                AppMethodBeat.o(244117);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Runnable mGm;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(Runnable runnable) {
                super(0);
                this.mGm = runnable;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244118);
                this.mGm.run();
                x xVar = x.SXb;
                AppMethodBeat.o(244118);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
        public static final class e extends q implements kotlin.g.a.b<Void, LinkedList<aqk>> {
            final /* synthetic */ a tQt;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(a aVar) {
                super(1);
                this.tQt = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ LinkedList<aqk> invoke(Void r3) {
                AppMethodBeat.i(244120);
                LinkedList blq = this.tQt.tQn.blq();
                AppMethodBeat.o(244120);
                return blq;
            }
        }

        public static final /* synthetic */ void a(a aVar, boolean z, LinkedList linkedList) {
            AppMethodBeat.i(244134);
            Log.i("Finder.SelectPresenter", "firstPage " + z + ", get activity list " + linkedList.size());
            if (z) {
                aVar.kgc.clear();
            }
            ArrayList<com.tencent.mm.plugin.finder.model.l> arrayList = aVar.kgc;
            LinkedList<aqk> linkedList2 = linkedList;
            ArrayList arrayList2 = new ArrayList(j.a(linkedList2, 10));
            for (aqk aqk : linkedList2) {
                arrayList2.add(new com.tencent.mm.plugin.finder.model.l(aqk));
            }
            arrayList.addAll(arrayList2);
            AppMethodBeat.o(244134);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0016J*\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\b\u0002\u0010&\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0006\u0010'\u001a\u00020(H\u0002J\n\u0010)\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010*\u001a\u00020!J\u0010\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\rH\u0002J\u0006\u0010-\u001a\u00020!J.\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\tJ\u0018\u00104\u001a\u00020!2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\u0006\u00106\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "isHasHeader", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "firstPageExposeData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "hasMore", "progressBar", "Landroid/widget/ProgressBar;", "progressContainer", "Landroid/widget/FrameLayout;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTextView", "Landroid/widget/TextView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "dismissProgress", "", "getActivity", "getFinishLoadMoreReason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "isAnim", "remainSize", "", "getPresenter", "initView", "onSelectActivity", "item", "onUserVisibleFocused", "refreshAll", "isDown", "startIndex", "incrementSize", "isHasMore", "isFirstPage", "reportExpose", "exposeData", "showRetryView", "Companion", "plugin-finder_release"})
    public static final class b implements com.tencent.mm.plugin.finder.presenter.base.c<a> {
        public static final String TAG = ("Finder.SelectViewCallback." + tQJ.hashCode());
        public static final a tQJ = new a((byte) 0);
        private final MMActivity activity;
        private final View contentView;
        private RecyclerView hak;
        boolean hasMore;
        ProgressBar progressBar;
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.l> tFp;
        RefreshLoadMoreLayout tLS;
        TextView tQE;
        FrameLayout tQF;
        public LinkedList<k> tQG;
        private final a tQH;
        private final boolean tQI;

        public /* synthetic */ b(MMActivity mMActivity, View view, a aVar) {
            this(mMActivity, view, aVar, false);
        }

        public b(MMActivity mMActivity, View view, a aVar, boolean z) {
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(view, "contentView");
            p.h(aVar, "presenter");
            AppMethodBeat.i(244146);
            this.activity = mMActivity;
            this.contentView = view;
            this.tQH = aVar;
            this.tQI = z;
            AppMethodBeat.o(244146);
        }

        public static final /* synthetic */ void b(b bVar, LinkedList linkedList) {
            AppMethodBeat.i(244149);
            bVar.af(linkedList);
            AppMethodBeat.o(244149);
        }

        public static final /* synthetic */ RefreshLoadMoreLayout d(b bVar) {
            AppMethodBeat.i(244148);
            RefreshLoadMoreLayout refreshLoadMoreLayout = bVar.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            AppMethodBeat.o(244148);
            return refreshLoadMoreLayout;
        }

        public static final /* synthetic */ ProgressBar f(b bVar) {
            AppMethodBeat.i(244151);
            ProgressBar progressBar2 = bVar.progressBar;
            if (progressBar2 == null) {
                p.btv("progressBar");
            }
            AppMethodBeat.o(244151);
            return progressBar2;
        }

        public static final /* synthetic */ TextView g(b bVar) {
            AppMethodBeat.i(244152);
            TextView textView = bVar.tQE;
            if (textView == null) {
                p.btv("retryTextView");
            }
            AppMethodBeat.o(244152);
            return textView;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(244147);
            AppMethodBeat.o(244147);
        }

        public final void initView() {
            WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.l> wxRecyclerAdapter;
            AppMethodBeat.i(244143);
            View findViewById = this.contentView.findViewById(R.id.h7t);
            p.g(findViewById, "contentView.findViewById(R.id.rl_layout)");
            this.tLS = (RefreshLoadMoreLayout) findViewById;
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            refreshLoadMoreLayout.setLimitTopRequest(((int) context.getResources().getDimension(R.dimen.a5g)) - ((int) context2.getResources().getDimension(R.dimen.bx)));
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
            if (refreshLoadMoreLayout2 == null) {
                p.btv("rlLayout");
            }
            Context context3 = MMApplicationContext.getContext();
            p.g(context3, "MMApplicationContext.getContext()");
            Context context4 = MMApplicationContext.getContext();
            p.g(context4, "MMApplicationContext.getContext()");
            refreshLoadMoreLayout2.setRefreshTargetY(((int) context3.getResources().getDimension(R.dimen.cp)) - ((int) context4.getResources().getDimension(R.dimen.a5g)));
            RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.tLS;
            if (refreshLoadMoreLayout3 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout3.setDamping(1.85f);
            RefreshLoadMoreLayout refreshLoadMoreLayout4 = this.tLS;
            if (refreshLoadMoreLayout4 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout4.setEnablePullDownHeader(false);
            refreshLoadMoreLayout4.setActionCallback(new C1126b(refreshLoadMoreLayout4, this));
            if (!this.tQI) {
                RefreshLoadMoreLayout refreshLoadMoreLayout5 = this.tLS;
                if (refreshLoadMoreLayout5 == null) {
                    p.btv("rlLayout");
                }
                refreshLoadMoreLayout5.setSuperNestedScroll(true);
            }
            RefreshLoadMoreLayout refreshLoadMoreLayout6 = this.tLS;
            if (refreshLoadMoreLayout6 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout6.setEnablePullDownHeader(false);
            RefreshLoadMoreLayout refreshLoadMoreLayout7 = this.tLS;
            if (refreshLoadMoreLayout7 == null) {
                p.btv("rlLayout");
            }
            this.hak = refreshLoadMoreLayout7.getRecyclerView();
            RecyclerView recyclerView = this.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            recyclerView.setLayoutManager(new LinearLayoutManager());
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            recyclerView2.setHasFixedSize(true);
            RecyclerView recyclerView3 = this.hak;
            if (recyclerView3 == null) {
                p.btv("recyclerView");
            }
            recyclerView3.setItemViewCacheSize(5);
            this.tFp = new WxRecyclerAdapter<>(new c(), this.tQH.kgc, true);
            WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.l> wxRecyclerAdapter2 = this.tFp;
            if (wxRecyclerAdapter2 != null) {
                wxRecyclerAdapter2.RrA = new d(this);
            }
            if (this.tQI && (wxRecyclerAdapter = this.tFp) != null) {
                wxRecyclerAdapter.a((g) new bi(), (g.b) true);
            }
            RecyclerView recyclerView4 = this.hak;
            if (recyclerView4 == null) {
                p.btv("recyclerView");
            }
            recyclerView4.setAdapter(this.tFp);
            WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.l> wxRecyclerAdapter3 = this.tFp;
            if (wxRecyclerAdapter3 != null) {
                wxRecyclerAdapter3.RqP = new e(this);
            }
            View findViewById2 = this.contentView.findViewById(R.id.ip_);
            p.g(findViewById2, "contentView.findViewById(R.id.tips_loading)");
            this.progressBar = (ProgressBar) findViewById2;
            View findViewById3 = this.contentView.findViewById(R.id.ipc);
            p.g(findViewById3, "contentView.findViewById(R.id.tips_retry)");
            this.tQE = (TextView) findViewById3;
            View findViewById4 = this.contentView.findViewById(R.id.gjf);
            p.g(findViewById4, "contentView.findViewById…_loading_state_container)");
            this.tQF = (FrameLayout) findViewById4;
            TextView textView = this.tQE;
            if (textView == null) {
                p.btv("retryTextView");
            }
            textView.setOnClickListener(new f(this));
            AppMethodBeat.o(244143);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$1$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.ae$b$b  reason: collision with other inner class name */
        public static final class C1126b extends RefreshLoadMoreLayout.a {
            final /* synthetic */ RefreshLoadMoreLayout tQK;
            final /* synthetic */ b tQL;

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void ED(int i2) {
                AppMethodBeat.i(244137);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
                super.ED(i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
                AppMethodBeat.o(244137);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
                AppMethodBeat.i(244138);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                super.onRefreshEnd(cVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(244138);
            }

            C1126b(RefreshLoadMoreLayout refreshLoadMoreLayout, b bVar) {
                this.tQK = refreshLoadMoreLayout;
                this.tQL = bVar;
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void cxo() {
                AppMethodBeat.i(244135);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
                if (this.tQL.hasMore) {
                    this.tQL.tQH.na(true);
                } else {
                    this.tQK.onPreFinishLoadMoreSmooth(b.dcN());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
                AppMethodBeat.o(244135);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(244136);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                p.h(cVar, "reason");
                super.a(cVar);
                if (!this.tQL.hasMore) {
                    RefreshLoadMoreLayout.e(b.d(this.tQL));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(244136);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
        public static final class c implements com.tencent.mm.view.recyclerview.f {
            c() {
            }

            @Override // com.tencent.mm.view.recyclerview.f
            public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
                AppMethodBeat.i(244139);
                if (i2 == bi.class.getName().hashCode()) {
                    cc ccVar = new cc();
                    AppMethodBeat.o(244139);
                    return ccVar;
                } else if (i2 == bj.class.getName().hashCode()) {
                    ce ceVar = new ce();
                    AppMethodBeat.o(244139);
                    return ceVar;
                } else if (i2 == com.tencent.mm.plugin.finder.model.l.class.getName().hashCode()) {
                    cd cdVar = new cd();
                    AppMethodBeat.o(244139);
                    return cdVar;
                } else {
                    p.hyc();
                    AppMethodBeat.o(244139);
                    return null;
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
        public static final class d implements com.tencent.mm.view.recyclerview.l {
            final /* synthetic */ b tQL;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            d(b bVar) {
                this.tQL = bVar;
            }

            @Override // com.tencent.mm.view.recyclerview.l
            public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.j jVar) {
                AppMethodBeat.i(244140);
                p.h(recyclerView, "recyclerView");
                p.h(jVar, "data");
                if (this.tQL.tQG == null) {
                    this.tQL.tQG = jVar.Rrn;
                    AppMethodBeat.o(244140);
                    return;
                }
                b.b(this.tQL, jVar.Rrn);
                AppMethodBeat.o(244140);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
        public static final class e implements g.c<h> {
            final /* synthetic */ b tQL;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            e(b bVar) {
                this.tQL = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
            @Override // com.tencent.mm.view.recyclerview.g.c
            public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
                AppMethodBeat.i(244141);
                p.h(aVar, "adapter");
                p.h(view, "view");
                p.h(hVar, "holder");
                g gVar = (g) aVar;
                if (gVar.RqM.size() <= 0 || i2 != 0) {
                    com.tencent.mm.plugin.finder.model.l lVar = this.tQL.tQH.kgc.get(i2 - gVar.RqM.size());
                    p.g(lVar, "presenter.getData()[activityItemPos]");
                    b.a(this.tQL, lVar);
                }
                AppMethodBeat.o(244141);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class f implements View.OnClickListener {
            final /* synthetic */ b tQL;

            f(b bVar) {
                this.tQL = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(244142);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.f(this.tQL).setVisibility(0);
                b.g(this.tQL).setVisibility(8);
                this.tQL.tQH.na(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(244142);
            }
        }

        public final void af(LinkedList<k> linkedList) {
            AppMethodBeat.i(244144);
            if (linkedList != null) {
                for (T t : linkedList) {
                    if (t.Rrp instanceof com.tencent.mm.plugin.finder.model.l) {
                        com.tencent.mm.view.recyclerview.a aVar = t.Rrp;
                        if (aVar == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderActivityInfoData");
                            AppMethodBeat.o(244144);
                            throw tVar;
                        }
                        aqk aqk = ((com.tencent.mm.plugin.finder.model.l) aVar).tqo;
                        FinderContact finderContact = aqk.contact;
                        int i2 = p.j(finderContact != null ? finderContact.username : null, com.tencent.mm.model.z.aUg()) ? 1 : 0;
                        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                        long j2 = (long) i2;
                        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                        String Fg = com.tencent.mm.plugin.finder.report.k.Fg(aqk.twd);
                        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.activity);
                        com.tencent.mm.plugin.finder.report.k.a(j2, "1", 4, Fg, fH != null ? fH.dIx() : null);
                    }
                }
                AppMethodBeat.o(244144);
                return;
            }
            AppMethodBeat.o(244144);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.activity;
        }

        static /* synthetic */ RefreshLoadMoreLayout.c dcN() {
            AppMethodBeat.i(244145);
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmn);
            cVar.jLE = false;
            cVar.Rmj = false;
            cVar.Rmk = 0;
            AppMethodBeat.o(244145);
            return cVar;
        }

        public static final /* synthetic */ void a(b bVar, com.tencent.mm.plugin.finder.model.l lVar) {
            String str;
            AppMethodBeat.i(244150);
            aqk aqk = lVar.tqo;
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            String Fg = com.tencent.mm.plugin.finder.report.k.Fg(aqk.twd);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(bVar.activity);
            com.tencent.mm.plugin.finder.report.k.a(1, "2", 4, Fg, fH != null ? fH.dIx() : null);
            if (bVar.activity instanceof FinderSelectActivityUI) {
                Intent intent = new Intent();
                Log.i(TAG, "onSelectActivity: eventTopicId:" + aqk.twd + "  eventName:" + aqk.eventName + " description:" + aqk.description + " cover:" + aqk.coverImgUrl);
                intent.putExtra("key_topic_id", aqk.twd);
                intent.putExtra("key_activity_name", aqk.eventName);
                intent.putExtra("key_activity_desc", aqk.description);
                intent.putExtra("key_cover_url", aqk.coverImgUrl);
                intent.putExtra("key_activity_type", 102);
                bVar.activity.setResult(-1, intent);
                if (!bVar.activity.isFinishing()) {
                    bVar.activity.finish();
                    AppMethodBeat.o(244150);
                    return;
                }
            } else {
                Intent intent2 = new Intent();
                Log.i(TAG, "onSelectActivity: eventTopicId:" + aqk.twd + "  eventName:" + aqk.eventName + " description:" + aqk.description + " cover:" + aqk.coverImgUrl);
                intent2.putExtra("key_activity_id", aqk.twd);
                intent2.putExtra("key_activity_name", aqk.eventName);
                intent2.putExtra("key_activity_desc", aqk.description);
                intent2.putExtra("key_cover_url", aqk.coverImgUrl);
                FinderContact finderContact = aqk.contact;
                if (finderContact == null || (str = finderContact.headUrl) == null) {
                    str = "";
                }
                intent2.putExtra("key_avatar_url", str);
                intent2.putExtra("key_activity_participate_count", aqk.LCy);
                intent2.putExtra("key_feed_ref_id", aqk.LCz);
                intent2.putExtra("key_topic_type", 7);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.aa(bVar.activity, intent2);
            }
            AppMethodBeat.o(244150);
        }
    }
}
