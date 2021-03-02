package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ck;
import com.tencent.mm.plugin.finder.model.bk;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.data.m;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract;", "", "()V", "FollowTopicPresenter", "FollowTopicViewCallback", "plugin-finder_release"})
public final class FinderFollowTopicListContract {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001,B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ\u0006\u0010\u001d\u001a\u00020\u0018J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J,\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J$\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\u0006\u0010\u0011\u001a\u00020\fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicFollowData;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderTopicFollowListPage;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isDown", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "viewCallback", "doGetFollowScene", "", "fakeTopicInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getData", "loadStart", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "", "Companion", "plugin-finder_release"})
    public static final class FollowTopicPresenter implements i, a<FollowTopicViewCallback> {
        private static final String uWR = uWR;
        public static final Companion uWS = new Companion((byte) 0);
        boolean hasMore = true;
        public final ArrayList<bk> kgc = new ArrayList<>();
        private boolean tQl;
        private long tQo = SystemClock.uptimeMillis();
        private b tsO;
        FollowTopicViewCallback uWP;
        private final m uWQ = new m(uWR);

        public FollowTopicPresenter() {
            AppMethodBeat.i(249762);
            AppMethodBeat.o(249762);
        }

        public static final /* synthetic */ FollowTopicViewCallback d(FollowTopicPresenter followTopicPresenter) {
            AppMethodBeat.i(249764);
            FollowTopicViewCallback followTopicViewCallback = followTopicPresenter.uWP;
            if (followTopicViewCallback == null) {
                p.btv("viewCallback");
            }
            AppMethodBeat.o(249764);
            return followTopicViewCallback;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(FollowTopicViewCallback followTopicViewCallback) {
            AppMethodBeat.i(249758);
            a(followTopicViewCallback);
            AppMethodBeat.o(249758);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "TAG", "plugin-finder_release"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(249763);
            AppMethodBeat.o(249763);
        }

        public final void a(FollowTopicViewCallback followTopicViewCallback) {
            AppMethodBeat.i(249757);
            p.h(followTopicViewCallback, "callback");
            this.uWP = followTopicViewCallback;
            g.azz().a(712, this);
            g.azz().a(3844, this);
            AppMethodBeat.o(249757);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            AppMethodBeat.i(249759);
            g.azz().b(712, this);
            g.azz().b(3844, this);
            AppMethodBeat.o(249759);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            Integer num;
            long j2;
            b bVar;
            boolean z;
            b bVar2 = null;
            AppMethodBeat.i(249760);
            Log.i("Finder.FollowTopicPresenter", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str + " scene type " + (qVar != null ? Integer.valueOf(qVar.getType()) : null));
            if (qVar != null) {
                num = Integer.valueOf(qVar.getType());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 712) {
                z.f fVar = new z.f();
                fVar.SYG = null;
                if (i2 == 0 && i3 == 0) {
                    z.a aVar = new z.a();
                    aVar.SYB = false;
                    if (qVar == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowTopicList");
                        AppMethodBeat.o(249760);
                        throw tVar;
                    }
                    com.tencent.mm.bw.a aYJ = ((com.tencent.mm.plugin.finder.cgi.bk) qVar).rr.aYJ();
                    if (!(aYJ instanceof ash)) {
                        aYJ = null;
                    }
                    ash ash = (ash) aYJ;
                    if (ash != null) {
                        bVar = ash.LDs;
                    } else {
                        bVar = null;
                    }
                    if (!p.j(this.tsO, bVar)) {
                        Log.i("Finder.FollowTopicPresenter", "not my buf, ignore!");
                        AppMethodBeat.o(249760);
                        return;
                    }
                    if (this.tsO == null) {
                        aVar.SYB = true;
                        d.a(d.aBx(), new FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$$inlined$let$lambda$1(this, aVar, qVar));
                    }
                    e aAh = g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    aAh.azQ().set(ar.a.USERINFO_FINDER_TOPIC_FOLLOW_COUNT_INT_SYNC, Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.bk) qVar).cYv()));
                    FollowTopicViewCallback followTopicViewCallback = this.uWP;
                    if (followTopicViewCallback == null) {
                        p.btv("viewCallback");
                    }
                    followTopicViewCallback.JT(((com.tencent.mm.plugin.finder.cgi.bk) qVar).cYv());
                    FollowTopicViewCallback followTopicViewCallback2 = this.uWP;
                    if (followTopicViewCallback2 == null) {
                        p.btv("viewCallback");
                    }
                    followTopicViewCallback2.dlT();
                    com.tencent.mm.bw.a aYK = ((com.tencent.mm.plugin.finder.cgi.bk) qVar).rr.aYK();
                    if (aYK == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowTopicListResponse");
                        AppMethodBeat.o(249760);
                        throw tVar2;
                    }
                    if (((asi) aYK).tUC != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.hasMore = z;
                    com.tencent.mm.bw.a aYK2 = ((com.tencent.mm.plugin.finder.cgi.bk) qVar).rr.aYK();
                    if (!(aYK2 instanceof asi)) {
                        aYK2 = null;
                    }
                    asi asi = (asi) aYK2;
                    if (asi != null) {
                        bVar2 = asi.LDs;
                    }
                    this.tsO = bVar2;
                    fVar.SYG = (T) new FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$2(this, aVar, qVar);
                }
                long uptimeMillis = SystemClock.uptimeMillis() - this.tQo;
                if (!this.tQl) {
                    c cVar = c.vCb;
                    if (uptimeMillis < c.dty().value().longValue()) {
                        c cVar2 = c.vCb;
                        j2 = c.dty().value().longValue() - uptimeMillis;
                        d.a(j2, new FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$3(fVar));
                        AppMethodBeat.o(249760);
                    }
                }
                j2 = 0;
                d.a(j2, new FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$3(fVar));
                AppMethodBeat.o(249760);
            } else if (num == null) {
                AppMethodBeat.o(249760);
            } else {
                if (num.intValue() == 3844 && i2 == 0 && i3 == 0) {
                    if (qVar == null) {
                        t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderTopicFollow");
                        AppMethodBeat.o(249760);
                        throw tVar3;
                    }
                    ck ckVar = (ck) qVar;
                    int i4 = ckVar.opType;
                    ck.a aVar2 = ck.twr;
                    if (i4 == ck.tvc) {
                        j.c((List) this.kgc, (kotlin.g.a.b) new FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$4$1(ckVar));
                    }
                    FollowTopicViewCallback followTopicViewCallback3 = this.uWP;
                    if (followTopicViewCallback3 == null) {
                        p.btv("viewCallback");
                    }
                    FollowTopicViewCallback.b(followTopicViewCallback3);
                    e aAh2 = g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    int i5 = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_TOPIC_FOLLOW_COUNT_INT_SYNC, 0);
                    if (i5 > 0) {
                        e aAh3 = g.aAh();
                        p.g(aAh3, "MMKernel.storage()");
                        aAh3.azQ().set(ar.a.USERINFO_FINDER_TOPIC_FOLLOW_COUNT_INT_SYNC, Integer.valueOf(i5 - 1));
                        FollowTopicViewCallback followTopicViewCallback4 = this.uWP;
                        if (followTopicViewCallback4 == null) {
                            p.btv("viewCallback");
                        }
                        followTopicViewCallback4.JT(i5 - 1);
                        FollowTopicViewCallback followTopicViewCallback5 = this.uWP;
                        if (followTopicViewCallback5 == null) {
                            p.btv("viewCallback");
                        }
                        followTopicViewCallback5.dlT();
                        AppMethodBeat.o(249760);
                        return;
                    }
                    FollowTopicViewCallback followTopicViewCallback6 = this.uWP;
                    if (followTopicViewCallback6 == null) {
                        p.btv("viewCallback");
                    }
                    followTopicViewCallback6.JT(0);
                    FollowTopicViewCallback followTopicViewCallback7 = this.uWP;
                    if (followTopicViewCallback7 == null) {
                        p.btv("viewCallback");
                    }
                    followTopicViewCallback7.dlT();
                }
                AppMethodBeat.o(249760);
            }
        }

        public final void nO(boolean z) {
            AppMethodBeat.i(249761);
            this.tQo = SystemClock.uptimeMillis();
            this.tQl = z;
            b bVar = this.tsO;
            String aUg = com.tencent.mm.model.z.aUg();
            p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            g.azz().b(new com.tencent.mm.plugin.finder.cgi.bk(bVar, aUg));
            AppMethodBeat.o(249761);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00017B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0002\u0010\tJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0005H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010#\u001a\u00020 J0\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020%H\u0016J0\u0010+\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020%H\u0016J\u0010\u0010,\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000bH\u0016J\"\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020%2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000bJ\u000e\u00101\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u00102\u001a\u00020 J\u0018\u00103\u001a\u00020 2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;)V", "MENU_ID_UNFOLLOW", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicFollowData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "emptyTip", "Landroid/widget/TextView;", "footerView", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "topicFollowCount", "addFooterView", "", "getActivity", "getPresenter", "initView", "onOverEnd", "", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refreshList", "isDown", "startIndex", "increaseCount", "refreshTitle", "setFooterViewText", "showPopupMenu", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "anchor", "Companion", "plugin-finder_release"})
    public static final class FollowTopicViewCallback implements com.tencent.mm.plugin.finder.presenter.base.c<FollowTopicPresenter>, HeadFooterLayout.b {
        public static final Companion uWX = new Companion((byte) 0);
        public final MMActivity activity;
        public final View contentView;
        public TextView hRM;
        public RecyclerView hak;
        public com.tencent.mm.ui.widget.b.a pqr;
        private View psf;
        public WxRecyclerAdapter<bk> tFp;
        public RefreshLoadMoreLayout tLS;
        private final int tzW = 1002;
        private int uWV;
        public final FollowTopicPresenter uWW;

        static {
            AppMethodBeat.i(249780);
            AppMethodBeat.o(249780);
        }

        public FollowTopicViewCallback(MMActivity mMActivity, View view, FollowTopicPresenter followTopicPresenter) {
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(view, "contentView");
            p.h(followTopicPresenter, "presenter");
            AppMethodBeat.i(249779);
            this.activity = mMActivity;
            this.contentView = view;
            this.uWW = followTopicPresenter;
            AppMethodBeat.o(249779);
        }

        public static final /* synthetic */ RefreshLoadMoreLayout e(FollowTopicViewCallback followTopicViewCallback) {
            AppMethodBeat.i(249782);
            RefreshLoadMoreLayout refreshLoadMoreLayout = followTopicViewCallback.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            AppMethodBeat.o(249782);
            return refreshLoadMoreLayout;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(byte b2) {
                this();
            }
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final void ddr() {
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final boolean u(int i2, int i3, boolean z) {
            return false;
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final boolean IJ(int i2) {
            return false;
        }

        public static /* synthetic */ void b(FollowTopicViewCallback followTopicViewCallback) {
            AppMethodBeat.i(249775);
            followTopicViewCallback.f(false, -1, -1);
            AppMethodBeat.o(249775);
        }

        public final void f(boolean z, int i2, int i3) {
            AppMethodBeat.i(249774);
            if (i3 > 0) {
                dlS();
            }
            if (i2 < 0 || i3 <= 0) {
                WxRecyclerAdapter<bk> wxRecyclerAdapter = this.tFp;
                if (wxRecyclerAdapter == null) {
                    p.btv("adapter");
                }
                wxRecyclerAdapter.notifyDataSetChanged();
            } else {
                WxRecyclerAdapter<bk> wxRecyclerAdapter2 = this.tFp;
                if (wxRecyclerAdapter2 == null) {
                    p.btv("adapter");
                }
                wxRecyclerAdapter2.as(i2, i3);
            }
            if (z) {
                RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                cVar.Rmj = this.uWW.hasMore;
                cVar.Rmk = i3;
                if (cVar.Rmk > 0) {
                    cVar.jLE = false;
                }
                RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
                if (refreshLoadMoreLayout == null) {
                    p.btv("rlLayout");
                }
                refreshLoadMoreLayout.onPreFinishLoadMoreSmooth(cVar);
                AppMethodBeat.o(249774);
                return;
            }
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
            if (refreshLoadMoreLayout2 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout2.apS(0);
            if (!this.uWW.hasMore) {
                RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.tLS;
                if (refreshLoadMoreLayout3 == null) {
                    p.btv("rlLayout");
                }
                RefreshLoadMoreLayout.e(refreshLoadMoreLayout3);
            }
            AppMethodBeat.o(249774);
        }

        private void dlS() {
            AppMethodBeat.i(249776);
            Log.i("Finder.FollowTopicViewCallback", "addFooterView");
            if (this.psf == null) {
                LayoutInflater from = LayoutInflater.from(this.contentView.getContext());
                RecyclerView recyclerView = this.hak;
                if (recyclerView == null) {
                    p.btv("recyclerView");
                }
                this.psf = from.inflate(R.layout.abi, (ViewGroup) recyclerView, false);
                dlT();
                WxRecyclerAdapter<bk> wxRecyclerAdapter = this.tFp;
                if (wxRecyclerAdapter == null) {
                    p.btv("adapter");
                }
                View view = this.psf;
                if (view == null) {
                    p.hyc();
                }
                wxRecyclerAdapter.g(view, 0, false);
            }
            AppMethodBeat.o(249776);
        }

        public final void dlT() {
            AppMethodBeat.i(249777);
            View view = this.psf;
            if (view != null) {
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_TOPIC_FOLLOW_COUNT_INT_SYNC, 0);
                if (i2 == 0) {
                    TextView textView = (TextView) view.findViewById(R.id.d84);
                    if (textView != null) {
                        textView.setText(view.getResources().getString(R.string.cop));
                        AppMethodBeat.o(249777);
                        return;
                    }
                    AppMethodBeat.o(249777);
                    return;
                }
                TextView textView2 = (TextView) view.findViewById(R.id.d84);
                if (textView2 != null) {
                    textView2.setText(view.getResources().getString(R.string.d2w, Integer.valueOf(i2)));
                    AppMethodBeat.o(249777);
                    return;
                }
                AppMethodBeat.o(249777);
                return;
            }
            AppMethodBeat.o(249777);
        }

        public final void JT(int i2) {
            AppMethodBeat.i(249778);
            this.uWV = i2;
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            int i3 = i2 + aAh.azQ().getInt(ar.a.USERINFO_FINDER_FOLLOW_COUNT_INT_SYNC, 0);
            if (i3 == 0) {
                TextView textView = this.hRM;
                if (textView == null) {
                    p.btv("emptyTip");
                }
                textView.setVisibility(0);
                TextView textView2 = this.hRM;
                if (textView2 == null) {
                    p.btv("emptyTip");
                }
                textView2.setText(this.activity.getString(R.string.coe));
            } else {
                TextView textView3 = this.hRM;
                if (textView3 == null) {
                    p.btv("emptyTip");
                }
                textView3.setVisibility(8);
            }
            this.activity.setMMTitle(c.a.a(this).getString(R.string.d2v, Integer.valueOf(i3)));
            AppMethodBeat.o(249778);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.activity;
        }

        public static final /* synthetic */ void a(FollowTopicViewCallback followTopicViewCallback, bds bds, View view) {
            AppMethodBeat.i(249781);
            com.tencent.mm.ui.widget.b.a aVar = followTopicViewCallback.pqr;
            if (aVar == null) {
                p.btv("popupMenu");
            }
            aVar.gNq();
            com.tencent.mm.ui.widget.b.a aVar2 = followTopicViewCallback.pqr;
            if (aVar2 == null) {
                p.btv("popupMenu");
            }
            TouchableLayout.a aVar3 = TouchableLayout.Rni;
            int i2 = TouchableLayout.kuv;
            TouchableLayout.a aVar4 = TouchableLayout.Rni;
            aVar2.a(view, new FinderFollowTopicListContract$FollowTopicViewCallback$showPopupMenu$1(followTopicViewCallback), new FinderFollowTopicListContract$FollowTopicViewCallback$showPopupMenu$2(followTopicViewCallback, bds), i2, TouchableLayout.kuw);
            AppMethodBeat.o(249781);
        }
    }
}
