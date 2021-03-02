package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI13;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J?\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J6\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ4\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001eJ8\u0010!\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001eH\u0002J8\u0010\"\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker;", "", "()V", "TAG", "", "checkAppBrand", "errorCallback", "Lkotlin/Function0;", "", "checkIsUsePhone", "checkLiveAnchorCore", "context", "Landroid/content/Context;", "checkLiveInfo", "gotoAnchor", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAnchor", "checkLiveVisitorCore", "checkNetwork", "checkRoomLive", "checkVoip", "goAnchorUIWithCheck", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "contextId", "clickTabContextId", "intent", "Landroid/content/Intent;", "goVisitorUIWithCheck", "i", "gotoAnchorLive", "gotoVisitLive", "plugin-finder_release"})
public final class h {
    public static final h uiL = new h();

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "isAnchor", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ String tpB;
        final /* synthetic */ FinderLiveConfig uiN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLiveConfig finderLiveConfig, Context context, String str, Intent intent) {
            super(1);
            this.uiN = finderLiveConfig;
            this.$context = context;
            this.tpB = str;
            this.$intent = intent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            awe awe;
            AppMethodBeat.i(246115);
            bool.booleanValue();
            LiveConfig dfu = this.uiN.dfu();
            if (dfu != null) {
                if (dfu.getLiveId() != 0) {
                    long liveId = dfu.getLiveId();
                    o oVar = o.ujN;
                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
                    if (!(dfZ == null || (awe = dfZ.liveInfo) == null || liveId != awe.liveId)) {
                        h hVar = h.uiL;
                        h.a(this.$context, this.uiN, this.tpB, this.$intent);
                    }
                }
                u.makeText(this.$context, this.$context.getResources().getString(R.string.cru), 0).show();
                Log.i("Finder.LiveJumpChecker", String.valueOf(this.$context.getResources().getString(R.string.cru)));
            } else {
                Log.w("Finder.LiveJumpChecker", "jumpAnchorLiveUI Fail! liveConfig == null !!!");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246115);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "isAnchor", "", "invoke"})
    public static final class j extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String tpB;
        final /* synthetic */ FinderLiveConfig uiN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(FinderLiveConfig finderLiveConfig, Context context, String str) {
            super(1);
            this.uiN = finderLiveConfig;
            this.$context = context;
            this.tpB = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            awe awe;
            AppMethodBeat.i(246122);
            boolean booleanValue = bool.booleanValue();
            LiveConfig dfu = this.uiN.dfu();
            if (dfu != null) {
                if (dfu.getLiveId() != 0) {
                    long liveId = dfu.getLiveId();
                    o oVar = o.ujN;
                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
                    if (!(dfZ == null || (awe = dfZ.liveInfo) == null || liveId != awe.liveId)) {
                        h hVar = h.uiL;
                        h.a(this.$context, this.uiN, this.tpB);
                    }
                }
                if (dfu.getLiveId() == 0 || booleanValue) {
                    u.makeText(this.$context, this.$context.getResources().getString(R.string.cru), 0).show();
                    Log.i("Finder.LiveJumpChecker", String.valueOf(this.$context.getResources().getString(R.string.cru)));
                } else {
                    o.a(o.ujN);
                    h hVar2 = h.uiL;
                    h.a(this.$context, this.uiN, this.tpB);
                    m.vli.a(s.at.CloseTypeOtherRoom);
                }
            } else {
                Log.w("Finder.LiveJumpChecker", "jumpVisitorLiveUI Fail! liveConfig == null !!!");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246122);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(246138);
        AppMethodBeat.o(246138);
    }

    private h() {
    }

    static /* synthetic */ void a(Context context, FinderLiveConfig finderLiveConfig, String str) {
        AppMethodBeat.i(246126);
        a(context, finderLiveConfig, str, "", (Intent) null);
        AppMethodBeat.o(246126);
    }

    public static void a(Context context, FinderLiveConfig finderLiveConfig, String str, String str2, Intent intent) {
        AppMethodBeat.i(246125);
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ != null) {
            long j2 = dfZ.liveInfo.liveId;
            LiveConfig liveConfig = (LiveConfig) kotlin.a.j.L(finderLiveConfig.uiu, finderLiveConfig.uis);
            if (liveConfig == null || j2 != liveConfig.getLiveId()) {
                o.a(o.ujN);
            }
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.addFlags(335544320);
        intent.putExtra("key_click_tab_context_id", str2);
        intent.putExtra("KEY_PARAMS_CONFIG", finderLiveConfig);
        if (!Util.isNullOrNil(str)) {
            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).fillContextIdToIntent(str, intent);
        }
        intent.setClass(context, FinderLiveVisitorWithoutAffinityUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoVisitLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoVisitLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(246125);
    }

    public static /* synthetic */ void a(h hVar, Context context, FinderLiveConfig finderLiveConfig, String str, Intent intent) {
        h M;
        h K;
        h b2;
        h a2;
        AppMethodBeat.i(260450);
        p.h(context, "context");
        p.h(finderLiveConfig, "config");
        p.h(str, "contextId");
        p.h("", "clickTabContextId");
        ((com.tencent.mm.plugin.festival.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.festival.a.a.class)).dqm();
        z.f fVar = new z.f();
        T t = (T) context.getResources().getString(R.string.w0);
        p.g(t, "context.resources.getString(R.string.app_i_know)");
        fVar.SYG = t;
        h J = hVar.J(new a(context, fVar));
        if (J == null || (M = J.M(new b(context))) == null || (K = M.K(new c(context))) == null || (b2 = K.b(true, new d(finderLiveConfig, context, str, intent))) == null || (a2 = b2.a(context, new e(context))) == null || a2.L(new f(context)) == null) {
            AppMethodBeat.o(260450);
            return;
        }
        c(context, finderLiveConfig, str, "", intent);
        AppMethodBeat.o(260450);
    }

    static /* synthetic */ void a(Context context, FinderLiveConfig finderLiveConfig, String str, Intent intent) {
        AppMethodBeat.i(260452);
        c(context, finderLiveConfig, str, "", intent);
        AppMethodBeat.o(260452);
    }

    private static void c(Context context, FinderLiveConfig finderLiveConfig, String str, String str2, Intent intent) {
        ArrayList arrayList;
        Intent intent2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Intent intent3;
        ArrayList arrayList4;
        int i2;
        awe liveInfo;
        AppMethodBeat.i(260451);
        if (intent == null) {
            intent = new Intent();
        }
        intent.addFlags(268435456);
        intent.putExtra("KEY_PARAMS_CONFIG", finderLiveConfig);
        awt awt = finderLiveConfig.uiv;
        intent.putExtra("KEY_PARAMS_NOTICE", awt != null ? awt.toByteArray() : null);
        if (!Util.isNullOrNil(str)) {
            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).fillContextIdToIntent(str, intent);
        }
        LinkedList<axk> linkedList = finderLiveConfig.uiw;
        if (linkedList != null) {
            LinkedList<axk> linkedList2 = linkedList;
            ArrayList arrayList5 = new ArrayList(kotlin.a.j.a(linkedList2, 10));
            Iterator<T> it = linkedList2.iterator();
            while (it.hasNext()) {
                arrayList5.add(it.next().toByteArray());
            }
            arrayList = arrayList5;
            intent2 = intent;
        } else {
            arrayList = null;
            intent2 = intent;
        }
        if (!(arrayList instanceof Serializable)) {
            arrayList2 = null;
        } else {
            arrayList2 = arrayList;
        }
        intent2.putExtra("KEY_PARAMS_TAGIFNOS", arrayList2);
        axk axk = finderLiveConfig.uix;
        intent.putExtra("KEY_PARAMS_CHOSEN_TAG", axk != null ? axk.toByteArray() : null);
        intent.putExtra("key_click_tab_context_id", str2);
        LinkedList<avh> linkedList3 = finderLiveConfig.ueu;
        if (linkedList3 != null) {
            LinkedList<avh> linkedList4 = linkedList3;
            ArrayList arrayList6 = new ArrayList(kotlin.a.j.a(linkedList4, 10));
            Iterator<T> it2 = linkedList4.iterator();
            while (it2.hasNext()) {
                arrayList6.add(it2.next().toByteArray());
            }
            arrayList3 = arrayList6;
            intent3 = intent;
        } else {
            arrayList3 = null;
            intent3 = intent;
        }
        if (!(arrayList3 instanceof Serializable)) {
            arrayList4 = null;
        } else {
            arrayList4 = arrayList3;
        }
        intent3.putExtra("KEY_PARAMS_VISITOR_WHITE_LIST", arrayList4);
        intent.putExtra("KEY_PARAMS_VISIBLE_ROOM_MAX_COUNT", finderLiveConfig.UKm);
        intent.putExtra("KEY_PARAMS_VISIBLE_USER_MAX_COUNT", finderLiveConfig.UKn);
        intent.putExtra("KEY_PARAMS_LUCKY_MONEY_CONFIG", finderLiveConfig.UKo);
        Log.i("Finder.LiveJumpChecker", "[gotoAnchorLive] config.sourceType" + finderLiveConfig.sourceType);
        if (finderLiveConfig.sourceType == 0) {
            intent.setClass(context, FinderLiveAnchorWithoutAffinityUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(260451);
        } else if (finderLiveConfig.sourceType == 1 || finderLiveConfig.sourceType == 2 || finderLiveConfig.sourceType == 3) {
            intent.setClass(context, OccupyFinderUI13.class);
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(260451);
        } else {
            if (finderLiveConfig.sourceType == -1) {
                try {
                    LiveConfig liveConfig = finderLiveConfig.uiu.get(0);
                    if (liveConfig != null) {
                        if (finderLiveConfig.sourceType == -1) {
                            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                            p.g(liveConfig, LocaleUtil.ITALIAN);
                            FinderItem Fy = e.a.Fy(liveConfig.aBH());
                            if (Fy == null || (liveInfo = Fy.getLiveInfo()) == null) {
                                i2 = 0;
                            } else {
                                i2 = liveInfo.LEg;
                            }
                            finderLiveConfig.sourceType = i2;
                        }
                        Context context2 = MMApplicationContext.getContext();
                        p.g(liveConfig, LocaleUtil.ITALIAN);
                        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderLiveVisitorUI(context2, liveConfig.aBH(), Long.valueOf(liveConfig.getLiveId()), "", liveConfig.aBI(), liveConfig.getDesc(), str, liveConfig.getSessionBuffer(), "", 0);
                        AppMethodBeat.o(260451);
                        return;
                    }
                    AppMethodBeat.o(260451);
                    return;
                } catch (NumberFormatException e2) {
                }
            }
            AppMethodBeat.o(260451);
        }
    }

    public final h J(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(246130);
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            aVar.invoke();
            AppMethodBeat.o(246130);
            return null;
        }
        AppMethodBeat.o(246130);
        return this;
    }

    public final h a(Context context, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(246131);
        if (com.tencent.mm.q.a.o(context, false) || com.tencent.mm.q.a.atv() || com.tencent.mm.q.a.att()) {
            aVar.invoke();
            AppMethodBeat.o(246131);
            return null;
        }
        AppMethodBeat.o(246131);
        return this;
    }

    public final h K(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(246132);
        if (com.tencent.mm.q.a.atu()) {
            aVar.invoke();
            AppMethodBeat.o(246132);
            return null;
        }
        AppMethodBeat.o(246132);
        return this;
    }

    public final h L(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(246133);
        if (com.tencent.mm.q.a.atw() || com.tencent.mm.q.a.atx()) {
            aVar.invoke();
            AppMethodBeat.o(246133);
            return null;
        }
        AppMethodBeat.o(246133);
        return this;
    }

    public final h b(boolean z, kotlin.g.a.b<? super Boolean, x> bVar) {
        String str;
        AppMethodBeat.i(246134);
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if ((dfZ == null || dfZ.liveInfo.liveId == 0 || dfZ.djl()) ? false : true) {
            String aUg = com.tencent.mm.model.z.aUg();
            if (dfZ != null) {
                str = dfZ.hwd;
            } else {
                str = null;
            }
            bVar.invoke(Boolean.valueOf(Util.isEqual(aUg, str)));
            AppMethodBeat.o(246134);
            return null;
        }
        if (z) {
            dfG();
        } else {
            dfH();
        }
        AppMethodBeat.o(246134);
        return this;
    }

    private static void dfG() {
        AppMethodBeat.i(246135);
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        if (b.a.aDp()) {
            o.a(o.ujN);
        }
        AppMethodBeat.o(246135);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
        if (com.tencent.mm.live.core.core.c.a.C0381a.aDp() != false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void dfH() {
        /*
            r1 = 246136(0x3c178, float:3.4491E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            com.tencent.mm.live.core.core.a.b$a r0 = com.tencent.mm.live.core.core.a.b.hyv
            boolean r0 = com.tencent.mm.live.core.core.a.b.a.aDp()
            if (r0 != 0) goto L_0x0016
            com.tencent.mm.live.core.core.c.a$a r0 = com.tencent.mm.live.core.core.c.a.hAj
            boolean r0 = com.tencent.mm.live.core.core.c.a.C0381a.aDp()
            if (r0 == 0) goto L_0x001b
        L_0x0016:
            com.tencent.mm.plugin.finder.live.model.o r0 = com.tencent.mm.plugin.finder.live.model.o.ujN
            com.tencent.mm.plugin.finder.live.model.o.a(r0)
        L_0x001b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.model.h.dfH():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.finder.live.model.h M(kotlin.g.a.a<kotlin.x> r10) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.model.h.M(kotlin.g.a.a):com.tencent.mm.plugin.finder.live.model.h");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f hHE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Context context, z.f fVar) {
            super(0);
            this.$context = context;
            this.hHE = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246119);
            new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.cta)).boA(this.hHE.SYG).b(AnonymousClass1.uiO).show();
            Log.i("Finder.LiveJumpChecker", String.valueOf(this.$context.getResources().getString(R.string.cta)));
            x xVar = x.SXb;
            AppMethodBeat.o(246119);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.live.model.h$h  reason: collision with other inner class name */
    public static final class C1185h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1185h(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246120);
            u.makeText(this.$context, this.$context.getResources().getString(R.string.crt), 0).show();
            Log.i("Finder.LiveJumpChecker", String.valueOf(this.$context.getResources().getString(R.string.crt)));
            x xVar = x.SXb;
            AppMethodBeat.o(246120);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246121);
            u.makeText(this.$context, this.$context.getResources().getString(R.string.crv), 0).show();
            Log.i("Finder.LiveJumpChecker", "checkVoip:" + this.$context.getResources().getString(R.string.crv));
            x xVar = x.SXb;
            AppMethodBeat.o(246121);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246123);
            u.makeText(this.$context, this.$context.getResources().getString(R.string.crw), 0).show();
            Log.i("Finder.LiveJumpChecker", "checkVoip:" + this.$context.getResources().getString(R.string.crw));
            x xVar = x.SXb;
            AppMethodBeat.o(246123);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class l extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246124);
            u.makeText(this.$context, this.$context.getResources().getString(R.string.crw), 0).show();
            Log.i("Finder.LiveJumpChecker", "checkAppBrand:" + this.$context.getResources().getString(R.string.crw));
            x xVar = x.SXb;
            AppMethodBeat.o(246124);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f hHE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, z.f fVar) {
            super(0);
            this.$context = context;
            this.hHE = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246112);
            new f.a(this.$context).hbu().bow(this.$context.getResources().getString(R.string.ct_)).boA(this.hHE.SYG).b(AnonymousClass1.uiM).show();
            Log.i("Finder.LiveJumpChecker", String.valueOf(this.$context.getResources().getString(R.string.ct_)));
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_BTN_CLICK.hlf, String.valueOf(s.ap.LIVE_START_NETWORK_ERROR.type));
            x xVar = x.SXb;
            AppMethodBeat.o(246112);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246113);
            u.makeText(this.$context, this.$context.getResources().getString(R.string.crt), 0).show();
            Log.i("Finder.LiveJumpChecker", String.valueOf(this.$context.getResources().getString(R.string.crt)));
            x xVar = x.SXb;
            AppMethodBeat.o(246113);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246114);
            u.makeText(this.$context, this.$context.getResources().getString(R.string.crv), 0).show();
            Log.i("Finder.LiveJumpChecker", "checkVoip:" + this.$context.getResources().getString(R.string.crv));
            x xVar = x.SXb;
            AppMethodBeat.o(246114);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246116);
            u.makeText(this.$context, this.$context.getResources().getString(R.string.crw), 0).show();
            Log.i("Finder.LiveJumpChecker", "checkVoip:" + this.$context.getResources().getString(R.string.crw));
            x xVar = x.SXb;
            AppMethodBeat.o(246116);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246117);
            u.makeText(this.$context, this.$context.getResources().getString(R.string.crw), 0).show();
            Log.i("Finder.LiveJumpChecker", "checkAppBrand:" + this.$context.getResources().getString(R.string.crw));
            x xVar = x.SXb;
            AppMethodBeat.o(246117);
            return xVar;
        }
    }
}
