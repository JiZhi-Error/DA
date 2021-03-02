package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.feed.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract;", "", "()V", "Companion", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class aa {
    private static final String TAG = TAG;
    public static final a tPq = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(244053);
        AppMethodBeat.o(244053);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020!H\u0016J\u0018\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020!H\u0016J\b\u00100\u001a\u00020!H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10;", "isSelfFlag", "", ch.COL_USERNAME, "", "requestAtScene", "", "fromScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10;ZLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getActivity", "()Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFromScene", "()I", "()Z", "getRequestAtScene", "tipDialog", "Landroid/app/Dialog;", "getUsername", "()Ljava/lang/String;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealMenuClick", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "getCreateSecondMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
    public static final class b extends v.a {
        private final int fromScene;
        private final boolean tFN;
        private final int tLA;
        private final com.tencent.mm.plugin.finder.feed.model.d tLy = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderCommentPreloaderUIC.class)).tLy;
        final OccupyFinderUI10 tPr;
        Dialog tipDialog;
        private final bbn ttO;
        private final String username;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
        static final class d extends q implements kotlin.g.a.b<Integer, bo> {
            final /* synthetic */ b tPs;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(b bVar) {
                super(1);
                this.tPs = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ bo invoke(Integer num) {
                bo boVar;
                BaseFinderFeed baseFinderFeed;
                DataBuffer dataListJustForAdapter;
                AppMethodBeat.i(244041);
                int intValue = num.intValue();
                if (intValue >= 0) {
                    BaseFinderFeedLoader baseFinderFeedLoader = this.tPs.tFM;
                    if (intValue < ((baseFinderFeedLoader == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null) ? 0 : dataListJustForAdapter.size())) {
                        BaseFinderFeedLoader baseFinderFeedLoader2 = this.tPs.tFM;
                        if (baseFinderFeedLoader2 != null) {
                            boVar = (bo) baseFinderFeedLoader2.get(intValue);
                        } else {
                            boVar = null;
                        }
                        if (boVar instanceof BaseFinderFeed) {
                            baseFinderFeed = (BaseFinderFeed) boVar;
                        } else {
                            baseFinderFeed = null;
                        }
                        BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
                        AppMethodBeat.o(244041);
                        return baseFinderFeed2;
                    }
                }
                AppMethodBeat.o(244041);
                return null;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(OccupyFinderUI10 occupyFinderUI10, boolean z, String str, int i2, int i3, bbn bbn) {
            super(occupyFinderUI10);
            p.h(occupyFinderUI10, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(str, ch.COL_USERNAME);
            AppMethodBeat.i(244049);
            this.tPr = occupyFinderUI10;
            this.tFN = z;
            this.username = str;
            this.tLA = i2;
            this.fromScene = i3;
            this.ttO = bbn;
            this.dLS = Integer.MIN_VALUE;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            AppMethodBeat.o(244049);
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a
        public final void a(BaseFinderFeedLoader baseFinderFeedLoader, v.b bVar) {
            com.tencent.mm.plugin.finder.event.base.c a2;
            AppMethodBeat.i(244044);
            p.h(baseFinderFeedLoader, "model");
            p.h(bVar, "callback");
            super.a(baseFinderFeedLoader, bVar);
            this.tLy.a(this.tLA, this.tCE, new d(this));
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (fH == null || (a2 = FinderReporterUIC.a(fH)) == null) {
                AppMethodBeat.o(244044);
                return;
            }
            a2.a(this.tLy);
            AppMethodBeat.o(244044);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.feed.i
        public final o.f i(BaseFinderFeed baseFinderFeed) {
            AppMethodBeat.i(244045);
            p.h(baseFinderFeed, "feed");
            c cVar = new c(this, baseFinderFeed);
            AppMethodBeat.o(244045);
            return cVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
        static final class c implements o.f {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ b tPs;

            c(b bVar, BaseFinderFeed baseFinderFeed) {
                this.tPs = bVar;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                boolean z = false;
                AppMethodBeat.i(244040);
                if (this.tPs.tPr.udT) {
                    c.a aVar = com.tencent.mm.plugin.finder.upload.action.c.vUa;
                    if (!com.tencent.mm.plugin.finder.upload.action.c.vTZ.k(this.tEM.feedObject.getFeedObject())) {
                        mVar.b(this.tPs.tLK, this.tPs.gte.getString(R.string.c8z), R.raw.finder_icons_filled_star2);
                    } else {
                        mVar.b(this.tPs.tLL, this.tPs.gte.getString(R.string.cir), R.raw.finder_icons_filled_unstar2);
                    }
                }
                y yVar = y.vXH;
                if (y.C(this.tEM.feedObject)) {
                    int i2 = this.tPs.tLJ;
                    y yVar2 = y.vXH;
                    String x = y.x(this.tEM);
                    if (!this.tEM.feedObject.isPostFinish() || this.tEM.feedObject.isPostFailed()) {
                        z = true;
                    }
                    mVar.a(i2, x, R.raw.finder_bgm_gif_first_page, z);
                }
                y yVar3 = y.vXH;
                if (!y.h(this.tEM)) {
                    if (!(this.tPs.dLS == 3 || this.tPs.dLS == 1)) {
                        mVar.b(this.tPs.tLD, this.tPs.gte.getString(R.string.f3j), R.raw.finder_feed_dislike);
                    }
                    mVar.b(this.tPs.pMa, this.tPs.gte.getString(R.string.f3g), R.raw.icons_outlined_report_problem);
                    AppMethodBeat.o(244040);
                    return;
                }
                y yVar4 = y.vXH;
                if (!y.w(this.tEM)) {
                    mVar.aS(this.tPs.tLI, R.string.tf, R.raw.icons_outlined_delete);
                    if (this.tEM.feedObject.isCommentClose()) {
                        mVar.b(this.tPs.tLH, this.tPs.gte.getString(R.string.cnl), R.raw.icons_outlined_comment);
                    } else {
                        mVar.b(this.tPs.tLG, this.tPs.gte.getString(R.string.cmn), R.raw.finder_feed_discomment);
                    }
                    if (!this.tPs.tPr.udT) {
                        y yVar5 = y.vXH;
                        if (y.isAnyEnableFullScreenEnjoy() && (this.tEM.cxn() == 4 || this.tEM.cxn() == 2)) {
                            mVar.b(this.tPs.tLM, this.tPs.gte.getString(R.string.cno), R.raw.finder_icons_outlined_max_window);
                        }
                    }
                }
                AppMethodBeat.o(244040);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(BaseFinderFeed baseFinderFeed, MenuItem menuItem, int i2) {
            boolean z;
            AppMethodBeat.i(244046);
            p.h(baseFinderFeed, "feed");
            p.h(menuItem, "menuItem");
            super.a(baseFinderFeed, menuItem, i2);
            if (menuItem.getItemId() == this.tLI && baseFinderFeed.feedObject.isPostFinish()) {
                if (!baseFinderFeed.feedObject.getLongVideoMediaList().isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                h.a(this.gte, z ? R.string.cjq : R.string.d6h, 0, new DialogInterface$OnClickListenerC1119b(this, baseFinderFeed), (DialogInterface.OnClickListener) null);
            }
            AppMethodBeat.o(244046);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.aa$b$b  reason: collision with other inner class name */
        static final class DialogInterface$OnClickListenerC1119b implements DialogInterface.OnClickListener {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ b tPs;

            DialogInterface$OnClickListenerC1119b(b bVar, BaseFinderFeed baseFinderFeed) {
                this.tPs = bVar;
                this.tEM = baseFinderFeed;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(244039);
                String aUg = z.aUg();
                p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                final av avVar = new av(aUg, this.tEM.feedObject.getFeedObject());
                Dialog dialog = this.tPs.tipDialog;
                if (dialog != null) {
                    dialog.show();
                } else {
                    b bVar = this.tPs;
                    bVar.gte.getString(R.string.zb);
                    bVar.tipDialog = h.a((Context) bVar.gte, bVar.gte.getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.tPt);
                }
                g.azz().a(avVar.getType(), new i(this) {
                    /* class com.tencent.mm.plugin.finder.feed.aa.b.DialogInterface$OnClickListenerC1119b.AnonymousClass1 */
                    final /* synthetic */ DialogInterface$OnClickListenerC1119b tPu;

                    {
                        this.tPu = r1;
                    }

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(244038);
                        if ((qVar instanceof av) && ((av) qVar).hFK == avVar.hFK) {
                            g.azz().b(avVar.getType(), this);
                        }
                        Dialog dialog = this.tPu.tPs.tipDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        if (i2 == 0 && i3 == 0) {
                            this.tPu.tPs.tPr.finish();
                            AppMethodBeat.o(244038);
                            return;
                        }
                        u.makeText(this.tPu.tPs.gte, (int) R.string.d6k, 0).show();
                        AppMethodBeat.o(244038);
                    }
                });
                g.azz().b(avVar);
                AppMethodBeat.o(244039);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.aa$b$b$a */
            static final class a implements DialogInterface.OnCancelListener {
                public static final a tPt = new a();

                static {
                    AppMethodBeat.i(244037);
                    AppMethodBeat.o(244037);
                }

                a() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            com.tencent.mm.plugin.finder.event.base.c a2;
            AppMethodBeat.i(244047);
            this.tLy.onDetach();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (!(fH == null || (a2 = FinderReporterUIC.a(fH)) == null)) {
                a2.b(this.tLy);
            }
            super.onDetach();
            AppMethodBeat.o(244047);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
        public static final class a implements f {
            final /* synthetic */ b tPs;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(b bVar) {
                this.tPs = bVar;
            }

            @Override // com.tencent.mm.view.recyclerview.f
            public final e<?> EC(int i2) {
                AppMethodBeat.i(244036);
                switch (i2) {
                    case 2:
                        if (this.tPs.tPr.udT) {
                            com.tencent.mm.plugin.finder.convert.q qVar = new com.tencent.mm.plugin.finder.convert.q(this.tPs, this.tPs.dcG(), Integer.MIN_VALUE);
                            AppMethodBeat.o(244036);
                            return qVar;
                        }
                        com.tencent.mm.plugin.finder.convert.u uVar = new com.tencent.mm.plugin.finder.convert.u(this.tPs, this.tPs.dcG(), Integer.MAX_VALUE);
                        AppMethodBeat.o(244036);
                        return uVar;
                    case 3:
                    default:
                        com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                        AppMethodBeat.o(244036);
                        return fVar;
                    case 4:
                        if (this.tPs.tPr.udT) {
                            t tVar = new t(this.tPs.tCD, this.tPs, this.tPs.dcG(), Integer.MIN_VALUE);
                            AppMethodBeat.o(244036);
                            return tVar;
                        }
                        ak akVar = new ak(this.tPs.tCD, this.tPs, this.tPs.dcG(), Integer.MAX_VALUE);
                        AppMethodBeat.o(244036);
                        return akVar;
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.b.a
        public final f dce() {
            AppMethodBeat.i(244048);
            a aVar = new a(this);
            AppMethodBeat.o(244048);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void requestRefresh() {
            AppMethodBeat.i(244042);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestRefresh();
                AppMethodBeat.o(244042);
                return;
            }
            AppMethodBeat.o(244042);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void boE() {
            AppMethodBeat.i(244043);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestLoadMore();
                AppMethodBeat.o(244043);
                return;
            }
            AppMethodBeat.o(244043);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\f¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;", "scene", "", "commentScene", "isAutoRefresh", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;IIZ)V", "()Z", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
    public static final class c extends v.b {
        private final boolean tLC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MMActivity mMActivity, b bVar, int i2, int i3, boolean z) {
            super(mMActivity, bVar, i2, i3);
            p.h(mMActivity, "context");
            p.h(bVar, "presenter");
            AppMethodBeat.i(244052);
            this.tLC = z;
            AppMethodBeat.o(244052);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void aa(ArrayList<bo> arrayList) {
            AppMethodBeat.i(244051);
            p.h(arrayList, "data");
            super.aa(arrayList);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            View inflate = com.tencent.mm.ui.aa.jQ(this.gte).inflate(R.layout.b21, (ViewGroup) null);
            p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
            refreshLoadMoreLayout.setLoadMoreFooter(inflate);
            if (this.tLS.getRecyclerView().getItemDecorationCount() > 0) {
                this.tLS.getRecyclerView().kN();
            }
            AppMethodBeat.o(244051);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final View getEmptyView() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.b, com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void dbY() {
            AppMethodBeat.i(244050);
            b.a aVar = this.tLY;
            if (aVar == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.Presenter");
                AppMethodBeat.o(244050);
                throw tVar;
            }
            ((v.a) aVar).dcp();
            if (this.tLC) {
                b.a aVar2 = this.tLY;
                if (aVar2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.Presenter");
                    AppMethodBeat.o(244050);
                    throw tVar2;
                }
                ((v.a) aVar2).requestRefresh();
            }
            AppMethodBeat.o(244050);
        }
    }
}
