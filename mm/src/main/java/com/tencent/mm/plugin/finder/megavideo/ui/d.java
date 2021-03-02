package com.tencent.mm.plugin.finder.megavideo.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class d {
    public static final d uLP = new d();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\rH\u0016R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "isSelf", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "onDetach", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "Companion", "plugin-finder_release"})
    public static final class a extends a.AbstractC1222a {
        public static final C1231a uLR = new C1231a((byte) 0);
        private final c uLQ;

        static {
            AppMethodBeat.i(248522);
            AppMethodBeat.o(248522);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.d$a$a  reason: collision with other inner class name */
        public static final class C1231a {
            private C1231a() {
            }

            public /* synthetic */ C1231a(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity, FinderMegaVideoProfileLoader finderMegaVideoProfileLoader) {
            super(mMActivity, finderMegaVideoProfileLoader);
            p.h(mMActivity, "context");
            p.h(finderMegaVideoProfileLoader, "feedLoader");
            AppMethodBeat.i(248521);
            this.uLQ = new c(finderMegaVideoProfileLoader);
            AppMethodBeat.o(248521);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a, com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(a.b bVar) {
            AppMethodBeat.i(248519);
            a(bVar);
            AppMethodBeat.o(248519);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
        public static final class b implements f {
            final /* synthetic */ a uLS;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            b(a aVar) {
                this.uLS = aVar;
            }

            @Override // com.tencent.mm.view.recyclerview.f
            public final e<?> EC(int i2) {
                AppMethodBeat.i(248509);
                com.tencent.mm.plugin.finder.megavideo.convert.d dVar = new com.tencent.mm.plugin.finder.megavideo.convert.d(this.uLS);
                AppMethodBeat.o(248509);
                return dVar;
            }
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final f dce() {
            AppMethodBeat.i(248516);
            b bVar = new b(this);
            AppMethodBeat.o(248516);
            return bVar;
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final void a(a.b bVar) {
            AppMethodBeat.i(248518);
            p.h(bVar, "callback");
            super.onAttach(bVar);
            this.uLQ.alive();
            AppMethodBeat.o(248518);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a, com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            AppMethodBeat.i(248520);
            super.onDetach();
            this.uLQ.dead();
            AppMethodBeat.o(248520);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
        public static final class c extends IListener<hk> {
            final /* synthetic */ FinderMegaVideoProfileLoader uLT;

            c(FinderMegaVideoProfileLoader finderMegaVideoProfileLoader) {
                this.uLT = finderMegaVideoProfileLoader;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(hk hkVar) {
                AppMethodBeat.i(248511);
                hk hkVar2 = hkVar;
                p.h(hkVar2, "event");
                Log.i("FinderMegaVideoProfileUIContract.Presenter", "feedProgressListener localId:" + hkVar2.dLT.localId + ", progress:" + hkVar2.dLT.progress);
                long j2 = hkVar2.dLT.localId;
                if (j2 <= 0) {
                    AppMethodBeat.o(248511);
                } else {
                    com.tencent.mm.ac.d.h(new C1232a(this, j2));
                    AppMethodBeat.o(248511);
                }
                return true;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.d$a$c$a  reason: collision with other inner class name */
            static final class C1232a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ long $localId;
                final /* synthetic */ c uLU;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1232a(c cVar, long j2) {
                    super(0);
                    this.uLU = cVar;
                    this.$localId = j2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(248510);
                    int i2 = 0;
                    for (Object obj : this.uLU.uLT.getDataList()) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            j.hxH();
                        }
                        bo boVar = (bo) obj;
                        if (boVar instanceof bm) {
                            FinderItem finderItem = ((bm) boVar).uOW;
                            if (finderItem == null) {
                                i2 = i3;
                            } else if (finderItem.getLocalId() == this.$localId) {
                                c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                                FinderItem FS = c.a.FS(this.$localId);
                                if (FS != null) {
                                    ((bm) boVar).uOW = FS;
                                }
                                StringBuilder sb = new StringBuilder("updateProgressByLoalId ");
                                FinderItem finderItem2 = ((bm) boVar).uOW;
                                Log.i("FinderMegaVideoProfileUIContract.Presenter", sb.append(finderItem2 != null ? finderItem2.getLocalId() : -1).toString());
                                this.uLU.uLT.dispatcher().onItemRangeChanged(i2, 1, new o(4, 1));
                            }
                        }
                        i2 = i3;
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(248510);
                    return xVar;
                }
            }
        }

        public final boolean isSelf() {
            AppMethodBeat.i(248512);
            BaseMegaVideoLoader baseMegaVideoLoader = this.uLF;
            if (baseMegaVideoLoader == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader");
                AppMethodBeat.o(248512);
                throw tVar;
            }
            boolean j2 = p.j(((FinderMegaVideoProfileLoader) baseMegaVideoLoader).tvp, z.aUg());
            AppMethodBeat.o(248512);
            return j2;
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final void requestRefresh() {
            AppMethodBeat.i(248513);
            this.uLF.requestRefresh();
            AppMethodBeat.o(248513);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final void boE() {
            AppMethodBeat.i(248514);
            this.uLF.requestLoadMore();
            AppMethodBeat.o(248514);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final void dcp() {
            AppMethodBeat.i(248515);
            BaseFeedLoader.requestInit$default(this.uLF, false, 1, null);
            AppMethodBeat.o(248515);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final void dcb() {
            AppMethodBeat.i(248517);
            a.b bVar = this.uLE;
            if (bVar != null) {
                bVar.ab(this.uLF.getDataListJustForAdapter());
                AppMethodBeat.o(248517);
                return;
            }
            AppMethodBeat.o(248517);
        }
    }

    static {
        AppMethodBeat.i(248530);
        AppMethodBeat.o(248530);
    }

    private d() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00050\u0005H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0006\u0010\u0019\u001a\u00020\u0011J\b\u0010\u001a\u001a\u00020\u0011H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "targetUsername", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Ljava/lang/String;)V", "getTargetUsername", "()Ljava/lang/String;", "getActivity", "getEmptyView", "kotlin.jvm.PlatformType", "getHeaderView", "", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "", "onItemDelete", "onViewPrepared", "requestLoadMore", "showEmptyView", "Companion", "plugin-finder_release"})
    public static final class b extends a.b {
        public static final a uLV = new a((byte) 0);
        private final String tvp;

        static {
            AppMethodBeat.i(248529);
            AppMethodBeat.o(248529);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity, View view, String str) {
            super(mMActivity, view);
            p.h(mMActivity, "context");
            p.h(view, "rootView");
            p.h(str, "targetUsername");
            AppMethodBeat.i(248528);
            this.tvp = str;
            AppMethodBeat.o(248528);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.b
        public final void dcv() {
            AppMethodBeat.i(248524);
            if (dkm().uLF.getSize() <= 9) {
                BaseMegaVideoLoader baseMegaVideoLoader = dkm().uLF;
                if (baseMegaVideoLoader == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader");
                    AppMethodBeat.o(248524);
                    throw tVar;
                } else if (((FinderMegaVideoProfileLoader) baseMegaVideoLoader).hasMore) {
                    RefreshLoadMoreLayout.c(this.tLS);
                }
            }
            AppMethodBeat.o(248524);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.b
        public final void b(RecyclerView.a<?> aVar, View view, int i2) {
            AppMethodBeat.i(248525);
            p.h(aVar, "adapter");
            p.h(view, "view");
            Log.i("FinderLikeMegaVideoUIContract.ViewCallback", "onItemClick: position=".concat(String.valueOf(i2)));
            int size = i2 - ((g) aVar).RqM.size();
            if (size >= 0 && size < dkn().uLF.getSize()) {
                bo boVar = (bo) dkn().uLF.getDataListJustForAdapter().get(size);
                if (!(boVar instanceof bm)) {
                    AppMethodBeat.o(248525);
                    return;
                }
                Log.i("FinderLikeMegaVideoUIContract.ViewCallback", "onItemClick " + size + " id:" + boVar.lT() + ", pos:" + size);
                if (((bm) boVar).uOW != null) {
                    FinderItem finderItem = ((bm) boVar).uOW;
                    if (finderItem == null) {
                        p.hyc();
                    }
                    if (!finderItem.isPostFinish()) {
                        cjk cjk = new cjk();
                        LinkedList<cjl> linkedList = cjk.mediaList;
                        FinderItem finderItem2 = ((bm) boVar).uOW;
                        if (finderItem2 == null) {
                            p.hyc();
                        }
                        linkedList.addAll(finderItem2.getLongVideoMediaList());
                        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        MMActivity mMActivity = this.gte;
                        if (mMActivity == null) {
                            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                            AppMethodBeat.o(248525);
                            throw tVar;
                        }
                        com.tencent.mm.plugin.finder.utils.a.a((Activity) mMActivity, (ViewAnimHelper.ViewInfo) null, cjk, (azy) null, true, 8);
                        AppMethodBeat.o(248525);
                        return;
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("KEY_ROUTER_UI", 3);
                intent.putExtra("finder_username", this.tvp);
                intent.putExtra("KEY_FINDER_SELF_FLAG", p.j(this.tvp, z.aUg()));
                BaseFeedLoader.saveCache$default(dkn().uLF, intent, size, null, 4, null);
                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(this.gte, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context = view.getContext();
                p.g(context, "view.context");
                com.tencent.mm.plugin.finder.utils.a.ag(context, intent);
            }
            AppMethodBeat.o(248525);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.b
        public final void bIo() {
            AppMethodBeat.i(248526);
            super.bIo();
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderProfileTabUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderProfileTabUIC.class)).nR(true);
            AppMethodBeat.o(248526);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.b
        public final void dbY() {
            AppMethodBeat.i(248523);
            this.tLS.setSuperNestedScroll(true);
            this.tLS.setEnableRefresh(false);
            super.dbY();
            AppMethodBeat.o(248523);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.b
        public final View getEmptyView() {
            AppMethodBeat.i(248527);
            View findViewById = this.lJI.findViewById(R.id.c3e);
            AppMethodBeat.o(248527);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }
    }
}
