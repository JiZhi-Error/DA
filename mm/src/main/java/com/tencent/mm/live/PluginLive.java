package com.tencent.mm.live;

import android.content.Context;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.a;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.t;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.b.y;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0007\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00011B\u0005¢\u0006\u0002\u0010\u0005J$\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\nj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014`\rH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\"\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u000100H\u0016R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/live/PluginLive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/live/IPluginLive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appForegroundListener", "com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/live/PluginLive$appForegroundListener$1;", "liveStatusMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "liveSysMsgReceiver", "Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "logoutEvent", "Lcom/tencent/mm/sdk/event/IListener;", "revokeMsgListener", "collectDatabaseFactory", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "curLiveId", "execute", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "forceStopCurLive", "context", "Landroid/content/Context;", "getLiveTipsBarStorage", "Lcom/tencent/mm/live/model/storage/LiveTipsBarStorage;", "getLivingRoomId", "", "isAnchorLiving", "", "isFloatMode", "isVisitorLiving", "isVisitorMicing", "liveEntranceJumper", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "refreshLiveStatus", "liveId", "roomId", "callback", "Lcom/tencent/mm/live/IPluginLive$LiveStatusCallback;", "Companion", "plugin-logic_release"})
public final class PluginLive extends com.tencent.mm.kernel.b.f implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, a {
    public static final a hvH = new a((byte) 0);
    private final IListener<?> gnH = new f();
    private final t hvD = new t();
    private final HashMap<Long, Integer> hvE = new HashMap<>();
    private final IListener<?> hvF = new d(this);
    private final b hvG = new b();

    static {
        AppMethodBeat.i(207539);
        AppMethodBeat.o(207539);
    }

    public PluginLive() {
        AppMethodBeat.i(207538);
        AppMethodBeat.o(207538);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/PluginLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/PluginLive$logoutEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "callback", "", "event", "plugin-logic_release"})
    public static final class d extends IListener<ma> {
        final /* synthetic */ PluginLive hvJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(PluginLive pluginLive) {
            this.hvJ = pluginLive;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ma maVar) {
            AppMethodBeat.i(207521);
            StringBuilder sb = new StringBuilder("logoutEvent liveId:");
            x xVar = x.hJf;
            StringBuilder append = sb.append(x.aGr().hyH).append(" liveName:");
            x xVar2 = x.hJf;
            Log.i("MicroMsg.PluginLive", append.append(x.aGr().LpF).toString());
            if (this.hvJ.isVisitorLiving() || this.hvJ.isAnchorLiving()) {
                PluginLive pluginLive = this.hvJ;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                pluginLive.forceStopCurLive(context);
            }
            AppMethodBeat.o(207521);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "plugin-logic_release"})
    public static final class b implements o {
        b() {
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(207518);
            StringBuilder sb = new StringBuilder("onAppBackground liveId:");
            x xVar = x.hJf;
            StringBuilder append = sb.append(x.aGr().hyH).append(" liveName:");
            x xVar2 = x.hJf;
            Log.i("MicroMsg.PluginLive", append.append(x.aGr().LpF).toString());
            AppMethodBeat.o(207518);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            String str2;
            com.tencent.mm.live.core.core.b.b bVar;
            AppMethodBeat.i(207519);
            StringBuilder sb = new StringBuilder("onAppForeground liveId:");
            x xVar = x.hJf;
            StringBuilder append = sb.append(x.aGr().hyH).append(" liveName:");
            x xVar2 = x.hJf;
            StringBuilder append2 = append.append(x.aGr().LpF).append(" jumpName:");
            x xVar3 = x.hJf;
            com.tencent.mm.live.core.core.b.f aGv = x.aGv();
            if (aGv == null || (bVar = aGv.hzv) == null) {
                str2 = null;
            } else {
                str2 = bVar.name;
            }
            Log.i("MicroMsg.PluginLive", append2.append(str2).toString());
            AppMethodBeat.o(207519);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/PluginLive$revokeMsgListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RevokeMsgEvent;", "callback", "", "event", "plugin-logic_release"})
    public static final class f extends IListener<sw> {
        f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sw swVar) {
            AppMethodBeat.i(207525);
            sw swVar2 = swVar;
            p.h(swVar2, "event");
            if (swVar2.dZp.dZr.getType() == 855638065) {
                ca caVar = swVar2.dZp.dZr;
                p.g(caVar, "event.data.rawMsgInfo");
                String content = caVar.getContent();
                p.g(content, "event.data.rawMsgInfo.content");
                k.b bVar = null;
                if (content != null) {
                    bVar = k.b.aD(content, swVar2.dZp.dZr.ajQ());
                }
                if (bVar != null) {
                    com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().zF(Long.parseLong(((y) bVar.as(y.class)).hJs));
                }
            }
            AppMethodBeat.o(207525);
            return false;
        }
    }

    @Override // com.tencent.mm.live.a
    public final com.tencent.mm.live.api.a liveEntranceJumper() {
        return com.tencent.mm.live.b.p.hHC;
    }

    @Override // com.tencent.mm.live.a
    public final com.tencent.mm.live.b.c.c getLiveTipsBarStorage() {
        AppMethodBeat.i(207526);
        com.tencent.mm.live.b.c.c liveTipsBarStorage = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
        AppMethodBeat.o(207526);
        return liveTipsBarStorage;
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(207527);
        Log.i("MicroMsg.PluginLive", "onAccountInitialized");
        EventCenter.instance.addListener(this.hvF);
        com.tencent.mm.kernel.b.a ah = g.ah(s.class);
        p.g(ah, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah).getSysCmdMsgExtension().a("ApplyLiveMic", this.hvD);
        com.tencent.mm.kernel.b.a ah2 = g.ah(s.class);
        p.g(ah2, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah2).getSysCmdMsgExtension().a("AcceptLiveMic", this.hvD);
        com.tencent.mm.kernel.b.a ah3 = g.ah(s.class);
        p.g(ah3, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah3).getSysCmdMsgExtension().a("CloseLive", this.hvD);
        com.tencent.mm.kernel.b.a ah4 = g.ah(s.class);
        p.g(ah4, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah4).getSysCmdMsgExtension().a("CloseLiveMic", this.hvD);
        com.tencent.mm.kernel.b.a ah5 = g.ah(s.class);
        p.g(ah5, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah5).getSysCmdMsgExtension().a("CloseApplyLiveMic", this.hvD);
        com.tencent.mm.kernel.b.a ah6 = g.ah(s.class);
        p.g(ah6, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah6).getSysCmdMsgExtension().a("BanLiveComment", this.hvD);
        com.tencent.mm.kernel.b.a ah7 = g.ah(s.class);
        p.g(ah7, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah7).getSysCmdMsgExtension().a("LiveMicSucc", this.hvD);
        com.tencent.mm.kernel.b.a ah8 = g.ah(s.class);
        p.g(ah8, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah8).getSysCmdMsgExtension().a("OnlineLiveList", this.hvD);
        com.tencent.mm.kernel.b.a ah9 = g.ah(s.class);
        p.g(ah9, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah9).getSysCmdMsgExtension().a("mmfinderlive_apply_live_mic_sys_msg", this.hvD);
        com.tencent.mm.kernel.b.a ah10 = g.ah(s.class);
        p.g(ah10, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah10).getSysCmdMsgExtension().a("mmfinderlive_accept_live_mic_sys_msg", this.hvD);
        com.tencent.mm.kernel.b.a ah11 = g.ah(s.class);
        p.g(ah11, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah11).getSysCmdMsgExtension().a("mmfinderlive_close_live_mic_sys_msg", this.hvD);
        AppForegroundDelegate.INSTANCE.a(this.hvG);
        com.tencent.mm.live.core.d.a aVar = com.tencent.mm.live.core.d.a.hEN;
        com.tencent.mm.live.core.d.a.aEV();
        this.gnH.alive();
        AppMethodBeat.o(207527);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(207528);
        Log.i("MicroMsg.PluginLive", "onAccountRelease");
        EventCenter.instance.removeListener(this.hvF);
        com.tencent.mm.kernel.b.a ah = g.ah(s.class);
        p.g(ah, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah).getSysCmdMsgExtension().b("ApplyLiveMic", this.hvD);
        com.tencent.mm.kernel.b.a ah2 = g.ah(s.class);
        p.g(ah2, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah2).getSysCmdMsgExtension().b("AcceptLiveMic", this.hvD);
        com.tencent.mm.kernel.b.a ah3 = g.ah(s.class);
        p.g(ah3, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah3).getSysCmdMsgExtension().b("CloseLive", this.hvD);
        com.tencent.mm.kernel.b.a ah4 = g.ah(s.class);
        p.g(ah4, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah4).getSysCmdMsgExtension().b("CloseLiveMic", this.hvD);
        com.tencent.mm.kernel.b.a ah5 = g.ah(s.class);
        p.g(ah5, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah5).getSysCmdMsgExtension().b("CloseApplyLiveMic", this.hvD);
        com.tencent.mm.kernel.b.a ah6 = g.ah(s.class);
        p.g(ah6, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah6).getSysCmdMsgExtension().b("BanLiveComment", this.hvD);
        com.tencent.mm.kernel.b.a ah7 = g.ah(s.class);
        p.g(ah7, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah7).getSysCmdMsgExtension().b("LiveMicSucc", this.hvD);
        com.tencent.mm.kernel.b.a ah8 = g.ah(s.class);
        p.g(ah8, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah8).getSysCmdMsgExtension().b("OnlineLiveList", this.hvD);
        com.tencent.mm.kernel.b.a ah9 = g.ah(s.class);
        p.g(ah9, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah9).getSysCmdMsgExtension().b("mmfinderlive_apply_live_mic_sys_msg", this.hvD);
        com.tencent.mm.kernel.b.a ah10 = g.ah(s.class);
        p.g(ah10, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah10).getSysCmdMsgExtension().b("mmfinderlive_accept_live_mic_sys_msg", this.hvD);
        com.tencent.mm.kernel.b.a ah11 = g.ah(s.class);
        p.g(ah11, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah11).getSysCmdMsgExtension().b("mmfinderlive_close_live_mic_sys_msg", this.hvD);
        AppForegroundDelegate.INSTANCE.b(this.hvG);
        this.gnH.dead();
        AppMethodBeat.o(207528);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.live.a
    public final String getLivingRoomId() {
        AppMethodBeat.i(207529);
        x xVar = x.hJf;
        String aGm = x.aGm();
        AppMethodBeat.o(207529);
        return aGm;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    static final class c implements h.b {
        public static final c hvI = new c();

        static {
            AppMethodBeat.i(207520);
            AppMethodBeat.o(207520);
        }

        c() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            return com.tencent.mm.live.b.c.c.SQL_CREATE;
        }
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(207530);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("LiveTipsBar".hashCode()), c.hvI);
        AppMethodBeat.o(207530);
        return hashMap;
    }

    @Override // com.tencent.mm.live.a
    public final boolean isAnchorLiving() {
        AppMethodBeat.i(207531);
        x xVar = x.hJf;
        if (x.aGr().hyH != 0) {
            x xVar2 = x.hJf;
            if (!x.aGD().hJn) {
                x xVar3 = x.hJf;
                if (!x.aGD().hJp) {
                    b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
                    if (b.a.aDp()) {
                        AppMethodBeat.o(207531);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(207531);
        return false;
    }

    @Override // com.tencent.mm.live.a
    public final boolean isVisitorLiving() {
        AppMethodBeat.i(207532);
        x xVar = x.hJf;
        if (x.aGr().hyH != 0) {
            x xVar2 = x.hJf;
            if (!x.aGD().hJn) {
                x xVar3 = x.hJf;
                if (!x.aGD().hJp) {
                    b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
                    if (b.a.aDp()) {
                        AppMethodBeat.o(207532);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(207532);
        return false;
    }

    @Override // com.tencent.mm.live.a
    public final long curLiveId() {
        AppMethodBeat.i(207533);
        x xVar = x.hJf;
        long j2 = x.aGr().hyH;
        AppMethodBeat.o(207533);
        return j2;
    }

    public final boolean isVisitorMicing() {
        AppMethodBeat.i(207534);
        x xVar = x.hJf;
        if (x.aGr().hyH != 0) {
            b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
            if (b.a.aDp()) {
                b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
                MMApplicationContext.getContext();
                if (b.a.aEf().aDx()) {
                    AppMethodBeat.o(207534);
                    return true;
                }
            }
        }
        AppMethodBeat.o(207534);
        return false;
    }

    public final boolean isFloatMode() {
        AppMethodBeat.i(207535);
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        if (b.a.aDp()) {
            b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
            MMApplicationContext.getContext();
            boolean isFloatMode = b.a.aEf().hAz.isFloatMode();
            AppMethodBeat.o(207535);
            return isFloatMode;
        }
        b.a aVar3 = com.tencent.mm.live.core.core.a.b.hyv;
        if (b.a.aDp()) {
            b.a aVar4 = com.tencent.mm.live.core.core.a.b.hyv;
            MMApplicationContext.getContext();
            boolean isFloatMode2 = b.a.aDo().hAz.isFloatMode();
            AppMethodBeat.o(207535);
            return isFloatMode2;
        }
        AppMethodBeat.o(207535);
        return false;
    }

    @Override // com.tencent.mm.live.a
    public final void refreshLiveStatus(long j2, String str, a.AbstractC0368a aVar) {
        AppMethodBeat.i(207536);
        p.h(str, "roomId");
        Integer num = this.hvE.get(Long.valueOf(j2));
        if (num == null || num.intValue() != 1) {
            com.tencent.mm.ak.t azz = g.azz();
            p.g(azz, "MMKernel.getNetSceneQueue()");
            if (azz.azD() != null) {
                com.tencent.mm.live.b.a.b bVar = new com.tencent.mm.live.b.a.b(j2, str, true);
                com.tencent.mm.ak.t azz2 = g.azz();
                p.g(azz2, "MMKernel.getNetSceneQueue()");
                bVar.doScene(azz2.azD(), new e(this, j2, aVar));
                AppMethodBeat.o(207536);
            } else if (aVar != null) {
                aVar.c(j2, 0);
                AppMethodBeat.o(207536);
            } else {
                AppMethodBeat.o(207536);
            }
        } else if (aVar != null) {
            aVar.c(j2, num.intValue());
            AppMethodBeat.o(207536);
        } else {
            AppMethodBeat.o(207536);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
    static final class e implements i {
        final /* synthetic */ PluginLive hvJ;
        final /* synthetic */ long hvK;
        final /* synthetic */ a.AbstractC0368a hvL;

        e(PluginLive pluginLive, long j2, a.AbstractC0368a aVar) {
            this.hvJ = pluginLive;
            this.hvK = j2;
            this.hvL = aVar;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
            AppMethodBeat.i(207524);
            qVar.setHasCallbackToQueue(true);
            com.tencent.f.h.RTc.aX(new Runnable(this) {
                /* class com.tencent.mm.live.PluginLive.e.AnonymousClass1 */
                final /* synthetic */ e hvM;

                {
                    this.hvM = r1;
                }

                public final void run() {
                    AppMethodBeat.i(207523);
                    final z.d dVar = new z.d();
                    dVar.SYE = 0;
                    if (i2 == 0 && i3 == 0) {
                        q qVar = qVar;
                        if (qVar == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
                            AppMethodBeat.o(207523);
                            throw tVar;
                        }
                        civ aGr = ((com.tencent.mm.live.b.a.b) qVar).aGr();
                        if (aGr == null || aGr.pSb != 0) {
                            dVar.SYE = 1;
                            com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().zF(this.hvM.hvK);
                        }
                        this.hvM.hvJ.hvE.put(Long.valueOf(this.hvM.hvK), Integer.valueOf(dVar.SYE));
                    }
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                        /* class com.tencent.mm.live.PluginLive.e.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 hvO;

                        {
                            this.hvO = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ kotlin.x invoke() {
                            AppMethodBeat.i(207522);
                            a.AbstractC0368a aVar = this.hvO.hvM.hvL;
                            if (aVar != null) {
                                aVar.c(this.hvO.hvM.hvK, dVar.SYE);
                            }
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(207522);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(207523);
                }
            });
            AppMethodBeat.o(207524);
        }
    }

    @Override // com.tencent.mm.live.a
    public final void forceStopCurLive(Context context) {
        AppMethodBeat.i(207537);
        p.h(context, "context");
        Log.printInfoStack("MicroMsg.PluginLive", "forceStopCurLive", new Object[0]);
        b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
        if (b.a.aDp()) {
            r rVar = r.hIg;
            r.aGa();
            com.tencent.mm.live.b.c.a aVar2 = com.tencent.mm.live.b.c.a.hLc;
            com.tencent.mm.live.b.c.a.aHn();
            b.a aVar3 = com.tencent.mm.live.core.core.a.b.hyv;
            b.a.aDo();
        } else {
            b.a aVar4 = com.tencent.mm.live.core.core.d.b.hCo;
            if (b.a.aDp()) {
                b.a aVar5 = com.tencent.mm.live.core.core.d.b.hCo;
                b.a.aEf();
            }
        }
        x xVar = x.hJf;
        x.aHi();
        AppMethodBeat.o(207537);
    }
}
