package com.tencent.mm.plugin.finder.feed;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.feed.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class j {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u001c\u00108\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u000109j\n\u0012\u0004\u0012\u00020:\u0018\u0001`;H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\u0014\u0010>\u001a\u00020,2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020,0@J\b\u0010A\u001a\u00020,H\u0016J\u0010\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020,H\u0016J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0003H\u0016J\b\u0010H\u001a\u00020,H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R0\u0010*\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020,\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "tabType", "(ILcom/tencent/mm/ui/MMActivity;ZZI)V", "encryptedObjectId", "", "getEncryptedObjectId", "()Ljava/lang/String;", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "isPostingScene", "()Z", "setPostingScene", "(Z)V", "needRelatedList", "getNeedRelatedList", "setNeedRelatedList", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "getSafeMode", "getScene", "()I", "showErrUi", "Lkotlin/Function2;", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "ifSafeMode", "isFinderSelfScene", "loadFirstFeed", "next", "Lkotlin/Function0;", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", FirebaseAnalytics.b.INDEX, "requestRefresh", "plugin-finder_release"})
    public static class a extends v.a {
        private final boolean dJM;
        public long hFK;
        public String objectNonceId;
        private final int scene;
        public final boolean tAj;
        public String tNK;
        public boolean tNL;
        public m<? super Integer, ? super String, x> tNM;
        public kotlin.g.a.b<? super FinderObject, x> tNN;
        public BaseFinderFeed tNO;
        public boolean tNP;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
        static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ a tNQ;
            final /* synthetic */ kotlin.g.a.a tNR;

            b(a aVar, kotlin.g.a.a aVar2) {
                this.tNQ = aVar;
                this.tNR = aVar2;
            }

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                String str;
                String str2;
                FinderAuthInfo finderAuthInfo;
                app app;
                DataBuffer dataList;
                bo boVar;
                RecyclerView recyclerView;
                RecyclerView.a adapter;
                Long l;
                String str3;
                FinderItem finderItem;
                LinkedList<cjl> mediaList;
                cjl cjl;
                FinderItem finderItem2;
                RecyclerView recyclerView2;
                RecyclerView.a adapter2;
                DataBuffer dataList2;
                DataBuffer dataList3;
                boolean z = true;
                String str4 = null;
                AppMethodBeat.i(243782);
                c.a aVar = (c.a) obj;
                h.c(h.veu, this.tNQ.dLS);
                if (!(aVar.errType == 0 && aVar.errCode == 0)) {
                    y yVar = y.vXH;
                    if (!y.gp(aVar.errType, aVar.errCode)) {
                        if (aVar.errCode == -4011 || aVar.errCode == -4033 || aVar.errCode == -4036) {
                            e.a aVar2 = e.vFX;
                            e.a.BX(this.tNQ.hFK);
                            m<? super Integer, ? super String, x> mVar = this.tNQ.tNM;
                            if (mVar != null) {
                                mVar.invoke(Integer.valueOf(aVar.errCode), aVar.errMsg);
                            }
                            h.a(h.veu, this.tNQ.dLS, false, null, 12);
                            x xVar = x.SXb;
                            AppMethodBeat.o(243782);
                            return xVar;
                        }
                        m<? super Integer, ? super String, x> mVar2 = this.tNQ.tNM;
                        if (mVar2 != null) {
                            mVar2.invoke(Integer.valueOf(aVar.errCode), aVar.errMsg);
                        }
                        h.e(h.veu, this.tNQ.dLS);
                        x xVar2 = x.SXb;
                        AppMethodBeat.o(243782);
                        return xVar2;
                    }
                }
                FinderObject finderObject = ((ars) aVar.iLC).feedObject;
                if (finderObject != null) {
                    Log.i(this.tNQ.getTAG(), "get feed detail success");
                    FinderContact finderContact = new FinderContact();
                    FinderContact finderContact2 = finderObject.contact;
                    finderContact.username = finderContact2 != null ? finderContact2.username : null;
                    FinderContact finderContact3 = finderObject.contact;
                    if (finderContact3 != null) {
                        str = finderContact3.nickname;
                    } else {
                        str = null;
                    }
                    finderContact.nickname = str;
                    FinderContact finderContact4 = finderObject.contact;
                    if (finderContact4 != null) {
                        str2 = finderContact4.headUrl;
                    } else {
                        str2 = null;
                    }
                    finderContact.headUrl = str2;
                    FinderContact finderContact5 = finderObject.contact;
                    if (finderContact5 != null) {
                        finderAuthInfo = finderContact5.authInfo;
                    } else {
                        finderAuthInfo = null;
                    }
                    finderContact.authInfo = finderAuthInfo;
                    FinderContact finderContact6 = finderObject.contact;
                    if (finderContact6 != null) {
                        app = finderContact6.extInfo;
                    } else {
                        app = null;
                    }
                    finderContact.extInfo = app;
                    c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                    c.a.b(finderContact);
                    FinderItem.a aVar4 = FinderItem.Companion;
                    p.g(finderObject, "newFeed");
                    FinderItem a2 = FinderItem.a.a(finderObject, 1);
                    c.a aVar5 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    BaseFinderFeed s = c.a.s(a2);
                    kotlin.g.a.b<? super FinderObject, x> bVar = this.tNQ.tNN;
                    if (bVar != null) {
                        bVar.invoke(finderObject);
                    }
                    this.tNQ.hFK = finderObject.id;
                    e.a aVar6 = e.vFX;
                    e.a.n(a2);
                    if (this.tNQ.tNO == null) {
                        BaseFinderFeedLoader baseFinderFeedLoader = this.tNQ.tFM;
                        if (!(baseFinderFeedLoader == null || (dataList3 = baseFinderFeedLoader.getDataList()) == null)) {
                            dataList3.clear();
                        }
                        BaseFinderFeedLoader baseFinderFeedLoader2 = this.tNQ.tFM;
                        if (!(baseFinderFeedLoader2 == null || (dataList2 = baseFinderFeedLoader2.getDataList()) == null)) {
                            dataList2.add(s);
                        }
                        b.AbstractC1134b bVar2 = this.tNQ.tLN;
                        if (!(bVar2 == null || (recyclerView2 = bVar2.tLS.getRecyclerView()) == null || (adapter2 = recyclerView2.getAdapter()) == null)) {
                            adapter2.notifyDataSetChanged();
                        }
                        h hVar = h.veu;
                        h.a Kd = h.Kd(this.tNQ.dLS);
                        if (Kd != null) {
                            if (!Kd.ZA || Kd.vev) {
                                z = false;
                            }
                            if (!z) {
                                Kd = null;
                            }
                            if (Kd != null) {
                                Kd.veL = cl.aWA();
                            }
                        }
                    } else {
                        BaseFinderFeedLoader baseFinderFeedLoader3 = this.tNQ.tFM;
                        if (!(baseFinderFeedLoader3 == null || (dataList = baseFinderFeedLoader3.getDataList()) == null || (boVar = (bo) kotlin.a.j.L(dataList, 0)) == null)) {
                            if (!(boVar instanceof BaseFinderFeed)) {
                                boVar = null;
                            }
                            if (boVar != null) {
                                if (boVar == null) {
                                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                                    AppMethodBeat.o(243782);
                                    throw tVar;
                                }
                                BaseFinderFeed baseFinderFeed = (BaseFinderFeed) boVar;
                                baseFinderFeed.feedObject.setCommentCount(s.feedObject.getCommentCount());
                                baseFinderFeed.feedObject.setLikeCount(s.feedObject.getLikeCount());
                                baseFinderFeed.feedObject.setForwardCount(s.feedObject.getForwardCount());
                                b.AbstractC1134b bVar3 = this.tNQ.tLN;
                                if (!(bVar3 == null || (recyclerView = bVar3.tLS.getRecyclerView()) == null || (adapter = recyclerView.getAdapter()) == null)) {
                                    adapter.b(0, new o(12, null));
                                }
                                Log.d(this.tNQ.getTAG(), "cache exit,refresh apart");
                            }
                        }
                    }
                    String tag = this.tNQ.getTAG();
                    StringBuilder sb = new StringBuilder("[loadFirstFeed] feed=");
                    BaseFinderFeed baseFinderFeed2 = this.tNQ.tNO;
                    if (baseFinderFeed2 == null || (finderItem2 = baseFinderFeed2.feedObject) == null) {
                        l = null;
                    } else {
                        l = Long.valueOf(finderItem2.getId());
                    }
                    StringBuilder append = sb.append(l).append(" => ");
                    BaseFinderFeed baseFinderFeed3 = this.tNQ.tNO;
                    if (baseFinderFeed3 == null || (finderItem = baseFinderFeed3.feedObject) == null || (mediaList = finderItem.getMediaList()) == null || (cjl = (cjl) kotlin.a.j.kt(mediaList)) == null) {
                        str3 = null;
                    } else {
                        str3 = cjl.url;
                    }
                    StringBuilder append2 = append.append(str3).append(' ').append("updateFeed=").append(s.feedObject.getId()).append(" => ");
                    cjl cjl2 = (cjl) kotlin.a.j.kt(s.feedObject.getMediaList());
                    if (cjl2 != null) {
                        str4 = cjl2.url;
                    }
                    Log.i(tag, append2.append(str4).toString());
                    this.tNR.invoke();
                    x xVar3 = x.SXb;
                    AppMethodBeat.o(243782);
                    return xVar3;
                }
                AppMethodBeat.o(243782);
                return null;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
        public /* synthetic */ void onAttach(b.AbstractC1134b bVar) {
            AppMethodBeat.i(243788);
            a(bVar);
            AppMethodBeat.o(243788);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private a(int i2, MMActivity mMActivity, boolean z, int i3) {
            super(mMActivity);
            p.h(mMActivity, "context");
            AppMethodBeat.i(243790);
            this.scene = i2;
            this.tAj = z;
            this.dJM = false;
            this.dLS = i3;
            this.objectNonceId = "";
            this.tNK = "";
            this.tNL = true;
            AppMethodBeat.o(243790);
        }

        public /* synthetic */ a(int i2, MMActivity mMActivity, boolean z, int i3, byte b2) {
            this(i2, mMActivity, z, i3);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.feed.i
        public final boolean dbZ() {
            return this.dJM;
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a
        public final boolean dcG() {
            return this.tAj;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void requestRefresh() {
            FinderItem finderItem;
            AppMethodBeat.i(243784);
            h hVar = h.veu;
            int i2 = this.dLS;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            h.a(i2, 0, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx(), 4);
            h.a(h.veu, this.dLS, true, null, 12);
            c cVar = new c(this);
            p.h(cVar, "next");
            if (this.tNP) {
                String tag = getTAG();
                StringBuilder sb = new StringBuilder("loadFirstFeed objectId = 0, localId = ");
                BaseFinderFeed baseFinderFeed = this.tNO;
                Log.i(tag, sb.append((baseFinderFeed == null || (finderItem = baseFinderFeed.feedObject) == null) ? null : Long.valueOf(finderItem.getLocalId())).toString());
                if (this.tNO == null) {
                    d.h(new C1148a(this));
                }
                AppMethodBeat.o(243784);
                return;
            }
            long j2 = this.hFK;
            String str = this.objectNonceId;
            int i3 = this.tCE;
            int i4 = this.scene;
            String str2 = this.tNK;
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            af afVar = new af(j2, str, i3, i4, "", true, null, null, 0, null, false, false, str2, fH != null ? fH.dIx() : null, 0, 20416);
            h hVar2 = h.veu;
            h.b(this.dLS, true, this.hFK != 0, this.tNK.length() > 0);
            afVar.aYI().a(this.gte).b(new b(this, cVar));
            AppMethodBeat.o(243784);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void boE() {
            AppMethodBeat.i(243785);
            if (this.tNL) {
                h hVar = h.veu;
                int i2 = this.dLS;
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                h.a(i2, 2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx(), 4);
                h.a(h.veu, this.dLS, true, null, 12);
                BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
                if (baseFinderFeedLoader != null) {
                    baseFinderFeedLoader.requestLoadMore();
                    AppMethodBeat.o(243785);
                    return;
                }
            }
            AppMethodBeat.o(243785);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(b.AbstractC1134b bVar) {
            AppMethodBeat.i(243787);
            p.h(bVar, "callback");
            super.onAttach(bVar);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderFeedMegaVideoBtnAnimUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(bVar.tLS.getRecyclerView());
            AppMethodBeat.o(243787);
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
        public void onDetach() {
            AppMethodBeat.i(243789);
            super.onDetach();
            AppMethodBeat.o(243789);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.j$a$a  reason: collision with other inner class name */
        static final class C1148a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a tNQ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1148a(a aVar) {
                super(0);
                this.tNQ = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(243781);
                m<? super Integer, ? super String, x> mVar = this.tNQ.tNM;
                if (mVar != null) {
                    mVar.invoke(-4011, null);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(243781);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a tNQ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar) {
                super(0);
                this.tNQ = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                AppMethodBeat.i(243783);
                if (this.tNQ.tNL) {
                    BaseFinderFeedLoader baseFinderFeedLoader = this.tNQ.tFM;
                    if (baseFinderFeedLoader == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader");
                        AppMethodBeat.o(243783);
                        throw tVar;
                    }
                    ((FinderFeedShareRelativeListLoader) baseFinderFeedLoader).feedId = this.tNQ.hFK;
                    BaseFinderFeedLoader baseFinderFeedLoader2 = this.tNQ.tFM;
                    if (baseFinderFeedLoader2 != null) {
                        baseFinderFeedLoader2.requestRefresh();
                    }
                } else {
                    h.a(h.veu, this.tNQ.dLS, false, null, 12);
                    b.AbstractC1134b bVar = this.tNQ.tLN;
                    if (!(bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null)) {
                        refreshLoadMoreLayout.setEnableLoadMore(false);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(243783);
                return xVar;
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.ab.a
        public final ArrayList<bo> dcH() {
            AppMethodBeat.i(243786);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            DataBuffer dataListJustForAdapter = baseFinderFeedLoader != null ? baseFinderFeedLoader.getDataListJustForAdapter() : null;
            AppMethodBeat.o(243786);
            return dataListJustForAdapter;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001#B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;II)V", "myActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getMyActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setMyActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getViewActionCallback", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "Companion", "plugin-finder_release"})
    public static class b extends v.b {
        private static final String TAG = TAG;
        public static final a tNT = new a((byte) 0);
        private com.tencent.mm.view.j tNS = new C1149b(this);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity, a aVar, int i2, int i3) {
            super(mMActivity, aVar, i2, i3);
            p.h(mMActivity, "context");
            p.h(aVar, "presenter");
            AppMethodBeat.i(243802);
            AppMethodBeat.o(243802);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(243803);
            AppMethodBeat.o(243803);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0017\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0001J\u0017\u0010\u0012\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0001J\u0017\u0010\u0013\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0001¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$myActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.j$b$b  reason: collision with other inner class name */
        public static final class C1149b implements com.tencent.mm.view.j {
            private final /* synthetic */ RefreshLoadMoreLayout tNU;
            final /* synthetic */ b tNV;

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(243795);
                p.h(cVar, "reason");
                this.tNU.onPreFinishLoadMore(cVar);
                AppMethodBeat.o(243795);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(243796);
                p.h(cVar, "reason");
                this.tNU.onPreFinishLoadMoreSmooth(cVar);
                AppMethodBeat.o(243796);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(243797);
                p.h(cVar, "reason");
                this.tNU.onPreFinishRefresh(cVar);
                AppMethodBeat.o(243797);
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1149b(b bVar) {
                this.tNV = bVar;
                this.tNU = bVar.tLS;
            }

            @Override // com.tencent.mm.view.j
            public final void onChanged() {
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3) {
                AppMethodBeat.i(243791);
                this.tNV.tLS.onItemRangeChanged(this.tNV.sHN + i2, i3);
                AppMethodBeat.o(243791);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3, Object obj) {
                AppMethodBeat.i(243792);
                this.tNV.tLS.onItemRangeChanged(this.tNV.sHN + i2, i3, obj);
                AppMethodBeat.o(243792);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeInserted(int i2, int i3) {
                AppMethodBeat.i(243793);
                this.tNV.tLS.onItemRangeInserted(this.tNV.sHN + i2, i3);
                AppMethodBeat.o(243793);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeRemoved(int i2, int i3) {
                AppMethodBeat.i(243794);
                this.tNV.tLS.onItemRangeRemoved(this.tNV.sHN + i2, i3);
                AppMethodBeat.o(243794);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.b
        public final com.tencent.mm.view.j dcI() {
            return this.tNS;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void aa(ArrayList<bo> arrayList) {
            AppMethodBeat.i(243798);
            p.h(arrayList, "data");
            super.aa(arrayList);
            if (dck()) {
                RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
                View inflate = aa.jQ(this.gte).inflate(R.layout.auy, (ViewGroup) null);
                p.g(inflate, "MMLayoutInflater.getInfl…b_load_more_footer, null)");
                refreshLoadMoreLayout.setLoadMoreFooter(inflate);
            }
            AppMethodBeat.o(243798);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final RecyclerView.h getItemDecoration() {
            AppMethodBeat.i(243800);
            com.tencent.mm.plugin.finder.view.decoration.b bVar = new com.tencent.mm.plugin.finder.view.decoration.b(new ColorDrawable(c.a.a(this).getColor(R.color.f3043a)), 0);
            AppMethodBeat.o(243800);
            return bVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void IF(int i2) {
            AppMethodBeat.i(243801);
            super.IF(i2);
            MMActivity mMActivity = this.gte;
            if (mMActivity instanceof FinderShareFeedRelUI) {
                ((FinderShareFeedRelUI) mMActivity).dAl();
            }
            AppMethodBeat.o(243801);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final View getEmptyView() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.b, com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void dbY() {
            AppMethodBeat.i(243799);
            RecyclerView recyclerView = this.tLS.getRecyclerView();
            recyclerView.setItemAnimator(new com.tencent.mm.plugin.finder.view.animation.e());
            recyclerView.setHasFixedSize(true);
            if (!dck()) {
                recyclerView.b(new com.tencent.mm.plugin.finder.view.decoration.b(new ColorDrawable(recyclerView.getResources().getColor(R.color.BW_93)), (int) recyclerView.getResources().getDimension(R.dimen.a4f)));
                recyclerView.setItemViewCacheSize(4);
            } else {
                recyclerView.setItemViewCacheSize(1);
            }
            b.a aVar = this.tLY;
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderFeedDetailRelUIContract.Presenter");
                AppMethodBeat.o(243799);
                throw tVar;
            }
            a aVar2 = (a) aVar;
            if (aVar2.tNO != null) {
                Log.i(TAG, "cache exit!,show cache first");
                ArrayList<bo> dcH = aVar2.dcH();
                if (dcH != null) {
                    dcH.clear();
                }
                ArrayList<bo> dcH2 = aVar2.dcH();
                if (dcH2 != null) {
                    BaseFinderFeed baseFinderFeed = aVar2.tNO;
                    if (baseFinderFeed == null) {
                        p.hyc();
                    }
                    dcH2.add(baseFinderFeed);
                }
                getAdapter().notifyDataSetChanged();
            }
            super.dbY();
            AppMethodBeat.o(243799);
        }
    }
}
