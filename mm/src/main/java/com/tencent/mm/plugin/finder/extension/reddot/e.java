package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.Observer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u001a\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "checkDoSync", "", "source", "", "delayed", "", "checkExpired", "clearCheckDoSync", "getExpiredInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCheckExpireInfo;", "innerCheckDoSync", "onAppBackground", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "onAppForeground", "setup", "Companion", "plugin-finder_release"})
public final class e implements o {
    public static final a tJs = new a((byte) 0);
    private final MMHandler handler = new MMHandler("FinderRedDotExpired");
    final C1113e tJr = new C1113e(this);
    final f toy;

    static {
        AppMethodBeat.i(243524);
        AppMethodBeat.o(243524);
    }

    public e(f fVar) {
        p.h(fVar, "redDotManager");
        AppMethodBeat.i(243523);
        this.toy = fVar;
        AppMethodBeat.o(243523);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.extension.reddot.e$e  reason: collision with other inner class name */
    public static final class C1113e extends IListener<kt> {
        final /* synthetic */ e tJt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1113e(e eVar) {
            this.tJt = eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kt ktVar) {
            AppMethodBeat.i(243516);
            kt ktVar2 = ktVar;
            p.h(ktVar2, "event");
            if (ktVar2.dPO.currentIndex == 2) {
                e.b(this.tJt, "findMoreFriend");
                e.a(this.tJt, "findMoreFriend");
            }
            AppMethodBeat.o(243516);
            return false;
        }
    }

    @Override // com.tencent.mm.app.o
    public final void onAppForeground(String str) {
    }

    @Override // com.tencent.mm.app.o
    public final void onAppBackground(String str) {
        AppMethodBeat.i(243519);
        asU("onAppBackground");
        AppMethodBeat.o(243519);
    }

    static /* synthetic */ void a(e eVar, String str) {
        AppMethodBeat.i(243521);
        eVar.asU(str);
        AppMethodBeat.o(243521);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ e tJt;
        final /* synthetic */ String tJu;
        final /* synthetic */ long tJv = 0;

        c(e eVar, String str, long j2) {
            this.tJt = eVar;
            this.tJu = str;
        }

        public final void run() {
            AppMethodBeat.i(243513);
            Log.i("Finder.RedDotExpiredHandler", "[checkExpired] source=" + this.tJu + " delayed=" + this.tJv);
            final HashSet hashSet = new HashSet();
            for (T t : this.tJt.toy.daG()) {
                if (((k) t).field_expiredTime > 0 && (((k) t).field_expiredTime * 1000) + ((k) t).field_time <= cl.aWA()) {
                    hashSet.add(t);
                    k kVar = k.vfA;
                    int i2 = ((k) t).field_ctrInfo.type;
                    String str = ((k) t).field_tipsId;
                    if (str == null) {
                        str = "";
                    }
                    String str2 = ((k) t).field_revokeId;
                    if (str2 == null) {
                        str2 = "";
                    }
                    k.f(i2, str, str2, 2);
                    Log.w("Finder.RedDotExpiredHandler", "[checkExpired] source=" + this.tJu + " ctrlInfo has expired! " + ((k) t).field_ctrInfo.type);
                }
            }
            if (!hashSet.isEmpty()) {
                this.tJt.toy.a(Integer.MIN_VALUE, new kotlin.g.a.b<k, Boolean>(this) {
                    /* class com.tencent.mm.plugin.finder.extension.reddot.e.c.AnonymousClass1 */
                    final /* synthetic */ c tJw;

                    {
                        this.tJw = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ Boolean invoke(k kVar) {
                        boolean z;
                        bdo atl;
                        AppMethodBeat.i(243512);
                        k kVar2 = kVar;
                        p.h(kVar2, LocaleUtil.ITALIAN);
                        boolean contains = hashSet.contains(kVar2);
                        if (contains) {
                            p.h("FinderEntrance", "path");
                            if (kVar2.tLk.get("FinderEntrance") != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (atl = kVar2.atl("FinderEntrance")) != null) {
                                j jVar = j.vft;
                                j.a(kVar2, atl, 7, 0, (String) null, (String) null, 56);
                            }
                            this.tJw.tJt.toy.b(kVar2.field_ctrInfo, "Expired");
                            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                            ((FinderStreamTabPreloadCore) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).c(kVar2);
                        }
                        Boolean valueOf = Boolean.valueOf(contains);
                        AppMethodBeat.o(243512);
                        return valueOf;
                    }
                });
            }
            AppMethodBeat.o(243513);
        }
    }

    private final void asU(String str) {
        AppMethodBeat.i(243520);
        this.handler.post(new c(this, str, 0));
        AppMethodBeat.o(243520);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ e tJt;

        b(e eVar) {
            this.tJt = eVar;
        }

        public final void run() {
            AppMethodBeat.i(243511);
            apb day = e.day();
            k asX = this.tJt.toy.asX("FinderEntrance");
            Log.i("Finder.RedDotExpiredHandler", "[checkDoSync] hasEntranceRedDot=" + (asX != null) + " checkInfo=" + cj.a(day));
            if (asX != null && day.LBb == 1) {
                com.tencent.mm.kernel.e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_RED_DOT_EXPIRED_COUNT_INT_SYNC, 0);
                com.tencent.mm.kernel.e aAh2 = g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                long a2 = aAh2.azQ().a(ar.a.USERINFO_FINDER_RED_DOT_EXPIRED_LAST_TIME_LONG_SYNC, 0);
                if (a2 <= 0) {
                    a2 = asX.field_time;
                    if (a2 <= 0) {
                        a2 = cl.aWA();
                    }
                }
                long aWA = cl.aWA() - a2;
                Log.i("Finder.RedDotExpiredHandler", "[checkDoSync] diffTime=" + aWA + "ms checkCount=" + i2 + ", checkInfo=" + cj.a(day));
                if (i2 < day.LBd && aWA >= ((long) (day.LBc * 1000))) {
                    e.daz();
                    com.tencent.mm.kernel.e aAh3 = g.aAh();
                    p.g(aAh3, "MMKernel.storage()");
                    aAh3.azQ().set(ar.a.USERINFO_FINDER_RED_DOT_EXPIRED_COUNT_INT_SYNC, Integer.valueOf(i2 + 1));
                    com.tencent.mm.kernel.e aAh4 = g.aAh();
                    p.g(aAh4, "MMKernel.storage()");
                    aAh4.azQ().set(ar.a.USERINFO_FINDER_RED_DOT_EXPIRED_LAST_TIME_LONG_SYNC, Long.valueOf(cl.aWA()));
                }
            }
            AppMethodBeat.o(243511);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        public static final d tJy = new d();

        static {
            AppMethodBeat.i(243515);
            AppMethodBeat.o(243515);
        }

        d() {
        }

        public final void run() {
            AppMethodBeat.i(243514);
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_RED_DOT_EXPIRED_COUNT_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_RED_DOT_EXPIRED_LAST_TIME_LONG_SYNC, (Object) 0L);
            AppMethodBeat.o(243514);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e tJt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(e eVar) {
            super(0);
            this.tJt = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(243518);
            h hVar = h.tKR;
            h.daK().observeForever(new Observer<h.a>(this) {
                /* class com.tencent.mm.plugin.finder.extension.reddot.e.f.AnonymousClass1 */
                final /* synthetic */ f tJz;

                {
                    this.tJz = r1;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.arch.lifecycle.Observer
                public final /* synthetic */ void onChanged(h.a aVar) {
                    AppMethodBeat.i(243517);
                    h.a aVar2 = aVar;
                    if (aVar2 != null) {
                        if (!aVar2.dEF) {
                            e.a(this.tJz.tJt);
                        }
                        AppMethodBeat.o(243517);
                        return;
                    }
                    AppMethodBeat.o(243517);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(243518);
            return xVar;
        }
    }

    static /* synthetic */ void b(e eVar, String str) {
        AppMethodBeat.i(243522);
        Log.i("Finder.RedDotExpiredHandler", "[checkDoSync] source=" + str + " delayed=0");
        eVar.handler.postDelayed(new b(eVar), 0);
        AppMethodBeat.o(243522);
    }

    public static final /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(243525);
        Log.i("Finder.RedDotExpiredHandler", "clearCheckDoSync");
        eVar.handler.post(d.tJy);
        AppMethodBeat.o(243525);
    }

    public static final /* synthetic */ apb day() {
        AppMethodBeat.i(243526);
        apb apb = new apb();
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String a2 = aAh.azQ().a(ar.a.USERINFO_FINDER_RED_DOT_EXPIRED_INFO_STRING_SYNC, "");
        p.g(a2, "value");
        if (a2.length() > 0) {
            apb.parseFrom(Util.decodeHexString(a2));
        }
        AppMethodBeat.o(243526);
        return apb;
    }

    public static final /* synthetic */ void daz() {
        AppMethodBeat.i(243527);
        Log.i("Finder.RedDotExpiredHandler", "innerCheckDoSync...");
        ((PluginFinder) g.ah(PluginFinder.class)).getFinderSyncExtension().fX(47613, 8);
        AppMethodBeat.o(243527);
    }
}
