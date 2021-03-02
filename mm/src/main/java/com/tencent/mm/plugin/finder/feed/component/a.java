package com.tencent.mm.plugin.finder.feed.component;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bw;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010 \u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\u0014J,\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010*\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "closeActivitySheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "maxTopCount", "", "getMaxTopCount", "()I", "setMaxTopCount", "(I)V", "addTopPlaceMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "handleTopPlace", "isSticky", "", "objectId", "", "makeFeedSticky", "sticky", "onAttach", "onDetach", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFeed", "showRemoveFeedDialog", "Companion", "plugin-finder_release"})
public final class a implements i {
    public static final C1142a tUf = new C1142a((byte) 0);
    private Context context;
    public BaseFinderFeedLoader tFM;
    public int tUe;
    public com.tencent.mm.ui.widget.a.e tqs;

    static {
        AppMethodBeat.i(244523);
        AppMethodBeat.o(244523);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$Companion;", "", "()V", "ACTIVITY_STICK_EVENT_TYPE", "", "MENU_ID_REMOVE_FEED", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.feed.component.a$a  reason: collision with other inner class name */
    public static final class C1142a {
        private C1142a() {
        }

        public /* synthetic */ C1142a(byte b2) {
            this();
        }
    }

    public final void a(Context context2, boolean z, BaseFinderFeed baseFinderFeed) {
        azs azs;
        AppMethodBeat.i(244520);
        p.h(context2, "context");
        p.h(baseFinderFeed, "feed");
        this.context = context2;
        String aUg = z.aUg();
        long id = baseFinderFeed.feedObject.getId();
        FinderObjectDesc finderObjectDesc = baseFinderFeed.feedObject.getFeedObject().objectDesc;
        long j2 = (finderObjectDesc == null || (azs = finderObjectDesc.event) == null) ? 0 : azs.twd;
        int i2 = z ? 3 : 4;
        Long valueOf = Long.valueOf(j2);
        Long valueOf2 = Long.valueOf(id);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
        bw bwVar = new bw(i2, valueOf, aUg, valueOf2, fH != null ? fH.dIx() : null);
        bwVar.d(context2, context2.getResources().getString(R.string.dbf), 500);
        com.tencent.mm.kernel.g.azz().b(bwVar);
        AppMethodBeat.o(244520);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        String str2;
        DataBuffer dataListJustForAdapter;
        Object obj;
        boolean z2;
        AppMethodBeat.i(244521);
        switch (i3) {
            case -4061:
                String string = MMApplicationContext.getContext().getString(R.string.d_h);
                p.g(string, "MMApplicationContext.get…ed_failed_private_reason)");
                str2 = string;
                break;
            case -4060:
                String string2 = MMApplicationContext.getContext().getString(R.string.d_i);
                p.g(string2, "MMApplicationContext.get…icky_feed_failed_reason1)");
                str2 = string2;
                break;
            case -4057:
                String string3 = MMApplicationContext.getContext().getString(R.string.d_g, Integer.valueOf(this.tUe));
                p.g(string3, "MMApplicationContext.get…imit_reason, maxTopCount)");
                str2 = string3;
                break;
            case 0:
                if ((qVar instanceof bw) && (((bw) qVar).scene == 3 || ((bw) qVar).scene == 4)) {
                    if (((bw) qVar).scene == 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Long l = ((bw) qVar).tvJ;
                    long longValue = l != null ? l.longValue() : 0;
                    int aWB = z ? cl.aWB() : 0;
                    e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                    FinderItem Fy = e.a.Fy(longValue);
                    if (Fy != null) {
                        Fy.setStickyTime(aWB);
                    }
                    BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
                    if (!(baseFinderFeedLoader == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null)) {
                        Iterator it = dataListJustForAdapter.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object next = it.next();
                                bo boVar = (bo) next;
                                if (boVar == null) {
                                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                                    AppMethodBeat.o(244521);
                                    throw tVar;
                                }
                                if (((BaseFinderFeed) boVar).lT() == longValue) {
                                    z2 = true;
                                    continue;
                                } else {
                                    z2 = false;
                                    continue;
                                }
                                if (z2) {
                                    obj = next;
                                }
                            } else {
                                obj = null;
                            }
                        }
                        bo boVar2 = (bo) obj;
                        if (boVar2 != null) {
                            if (boVar2 == null) {
                                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                                AppMethodBeat.o(244521);
                                throw tVar2;
                            }
                            ((BaseFinderFeed) boVar2).feedObject.getFinderObject().stickyTime = aWB;
                        }
                    }
                    hm hmVar = new hm();
                    hmVar.dLV.type = 1001;
                    hmVar.dLV.id = longValue;
                    hmVar.dLV.stickyTime = aWB;
                    EventCenter.instance.publish(hmVar);
                    Context context2 = this.context;
                    if (context2 != null) {
                        if (!z) {
                            u.a(context2, context2.getString(R.string.civ), c.UIx);
                            str2 = "";
                            break;
                        } else {
                            u.a(context2, context2.getString(R.string.d_j), b.UIw);
                            str2 = "";
                            break;
                        }
                    }
                }
            default:
                str2 = "";
                break;
        }
        if (!Util.isNullOrNil(str2)) {
            u.a(MMApplicationContext.getContext(), str2, d.tUi);
        }
        AppMethodBeat.o(244521);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    static final class d implements u.b {
        public static final d tUi = new d();

        static {
            AppMethodBeat.i(244516);
            AppMethodBeat.o(244516);
        }

        d() {
        }

        @Override // com.tencent.mm.ui.base.u.b
        public final void dU(View view) {
            AppMethodBeat.i(244515);
            ((WeImageView) view.findViewById(R.id.irc)).setImageResource(R.raw.icons_filled_top_off);
            AppMethodBeat.o(244515);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    static final class b implements u.b {
        public static final b UIw = new b();

        static {
            AppMethodBeat.i(260242);
            AppMethodBeat.o(260242);
        }

        b() {
        }

        @Override // com.tencent.mm.ui.base.u.b
        public final void dU(View view) {
            AppMethodBeat.i(260241);
            ((WeImageView) view.findViewById(R.id.irc)).setImageResource(R.raw.icons_filled_done);
            AppMethodBeat.o(260241);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    static final class c implements u.b {
        public static final c UIx = new c();

        static {
            AppMethodBeat.i(260244);
            AppMethodBeat.o(260244);
        }

        c() {
        }

        @Override // com.tencent.mm.ui.base.u.b
        public final void dU(View view) {
            AppMethodBeat.i(260243);
            ((WeImageView) view.findViewById(R.id.irc)).setImageResource(R.raw.icons_filled_done);
            AppMethodBeat.o(260243);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$showRemoveFeedDialog$1$1"})
    public static final class f implements o.f {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ BaseFinderFeed $feed$inlined;
        final /* synthetic */ a UIA;

        public f(a aVar, Context context, BaseFinderFeed baseFinderFeed) {
            this.UIA = aVar;
            this.$context$inlined = context;
            this.$feed$inlined = baseFinderFeed;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(260246);
            p.g(mVar, "menu");
            if (mVar.gKQ()) {
                mVar.a(2000, this.$context$inlined.getResources().getColor(R.color.Red), this.$context$inlined.getResources().getString(R.string.j_4));
            }
            AppMethodBeat.o(260246);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$showRemoveFeedDialog$1$2"})
    public static final class g implements o.g {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ BaseFinderFeed $feed$inlined;
        final /* synthetic */ a UIA;

        public g(a aVar, Context context, BaseFinderFeed baseFinderFeed) {
            this.UIA = aVar;
            this.$context$inlined = context;
            this.$feed$inlined = baseFinderFeed;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(260247);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 2000:
                    a.a(this.$context$inlined, this.$feed$inlined);
                    break;
            }
            AppMethodBeat.o(260247);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$showRemoveFeedDialog$1$3"})
    public static final class h implements e.b {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ BaseFinderFeed $feed$inlined;
        final /* synthetic */ a UIA;

        public h(a aVar, Context context, BaseFinderFeed baseFinderFeed) {
            this.UIA = aVar;
            this.$context$inlined = context;
            this.$feed$inlined = baseFinderFeed;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(260248);
            this.UIA.tqs = null;
            AppMethodBeat.o(260248);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$removeFeed$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class e implements i {
        final /* synthetic */ Context $context;
        final /* synthetic */ bw UIy;
        final /* synthetic */ long UIz;
        final /* synthetic */ BaseFinderFeed tEM;

        e(bw bwVar, BaseFinderFeed baseFinderFeed, long j2, Context context) {
            this.UIy = bwVar;
            this.tEM = baseFinderFeed;
            this.UIz = j2;
            this.$context = context;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(260245);
            if (qVar instanceof bw) {
                com.tencent.mm.kernel.g.azz().b(this.UIy.getType(), this);
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.g.a.f fVar = new com.tencent.mm.g.a.f();
                    fVar.dBS.id = this.tEM.feedObject.getId();
                    fVar.dBS.localId = this.tEM.feedObject.getLocalId();
                    fVar.dBS.dBT = this.UIz;
                    EventCenter.instance.publish(fVar);
                    hn hnVar = new hn();
                    hnVar.dLW.id = this.tEM.feedObject.getId();
                    hnVar.dLW.dLY = 1;
                    hnVar.dLW.type = 12;
                    EventCenter.instance.publish(hnVar);
                    "NetSceneFinderModEvent onSceneEnd publish ActivityFeedRemoveEvent:".concat(String.valueOf(fVar));
                    com.tencent.e.f.h.hkS();
                    AppMethodBeat.o(260245);
                    return;
                }
                u.makeText(this.$context, (int) R.string.chc, 0).show();
            }
            AppMethodBeat.o(260245);
        }
    }

    public static void a(Context context2, BaseFinderFeed baseFinderFeed, m mVar) {
        AppMethodBeat.i(244519);
        p.h(context2, "context");
        p.h(baseFinderFeed, "feed");
        p.h(mVar, "menu");
        if (baseFinderFeed.feedObject.getStickyTime() > 0) {
            mVar.b(5003, context2.getString(R.string.ciu), R.raw.icons_outlined_top_off);
            AppMethodBeat.o(244519);
            return;
        }
        mVar.b(5002, context2.getString(R.string.d99), R.raw.icons_outlined_top);
        AppMethodBeat.o(244519);
    }

    public static final /* synthetic */ void a(Context context2, BaseFinderFeed baseFinderFeed) {
        azs azs;
        AppMethodBeat.i(244522);
        String aUg = z.aUg();
        long id = baseFinderFeed.feedObject.getId();
        FinderObjectDesc finderObjectDesc = baseFinderFeed.feedObject.getFeedObject().objectDesc;
        long j2 = (finderObjectDesc == null || (azs = finderObjectDesc.event) == null) ? 0 : azs.twd;
        Long valueOf = Long.valueOf(j2);
        Long valueOf2 = Long.valueOf(id);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
        bw bwVar = new bw(2, valueOf, aUg, valueOf2, fH != null ? fH.dIx() : null);
        bwVar.d(context2, context2.getResources().getString(R.string.dbf), 500);
        com.tencent.mm.kernel.g.azz().a(bwVar.getType(), new e(bwVar, baseFinderFeed, j2, context2));
        com.tencent.mm.kernel.g.azz().b(bwVar);
        AppMethodBeat.o(244522);
    }
}
