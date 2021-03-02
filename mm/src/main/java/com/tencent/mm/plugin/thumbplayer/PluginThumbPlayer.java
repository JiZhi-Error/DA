package com.tencent.mm.plugin.thumbplayer;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a;
import com.tencent.mm.i.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.thumbplayer.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/PluginThumbPlayer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/thumbplayer/api/IPluginThumbPlayer;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "TAG", "", "cdnTaskController", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "getCdnTaskController", "()Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "cdnTaskController$delegate", "Lkotlin/Lazy;", "isOpenTPFlowControl", "", "Ljava/lang/Boolean;", "isOpenTPPlayer", "log", "Lcom/tencent/mm/sdk/platformtools/Log$LogInstance;", "openXlogMulti", "", "execute", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "initThumbPlayer", "isEnableMultiXLog", "isOpenTPPlayerBgPrepare", "isOpenTPPlayerScroll", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "plugin-thumbplayer_release"})
public final class PluginThumbPlayer extends f implements com.tencent.mm.kernel.a.b.b, c, com.tencent.mm.plugin.thumbplayer.a.a {
    private Log.LogInstance Ggm;
    private int Ggn;
    private final kotlin.f Ggo = g.ah(a.Ggr);
    private Boolean Ggp;
    private Boolean Ggq;
    private final String TAG = "MicroMsg.TP.PluginThumbPlayer";

    public final com.tencent.mm.plugin.thumbplayer.b.a getCdnTaskController() {
        AppMethodBeat.i(238604);
        com.tencent.mm.plugin.thumbplayer.b.a aVar = (com.tencent.mm.plugin.thumbplayer.b.a) this.Ggo.getValue();
        AppMethodBeat.o(238604);
        return aVar;
    }

    public PluginThumbPlayer() {
        AppMethodBeat.i(238610);
        AppMethodBeat.o(238610);
    }

    public static final /* synthetic */ Log.LogInstance access$getLog$p(PluginThumbPlayer pluginThumbPlayer) {
        AppMethodBeat.i(238611);
        Log.LogInstance logInstance = pluginThumbPlayer.Ggm;
        if (logInstance == null) {
            p.btv("log");
        }
        AppMethodBeat.o(238611);
        return logInstance;
    }

    public static final /* synthetic */ boolean access$isEnableMultiXLog(PluginThumbPlayer pluginThumbPlayer, int i2) {
        AppMethodBeat.i(238612);
        boolean isEnableMultiXLog = pluginThumbPlayer.isEnableMultiXLog(i2);
        AppMethodBeat.o(238612);
        return isEnableMultiXLog;
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(238605);
        initThumbPlayer();
        AppMethodBeat.o(238605);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(238606);
        com.tencent.mm.plugin.thumbplayer.b.a cdnTaskController = getCdnTaskController();
        Log.i(cdnTaskController.TAG, "release cdn task controller");
        cdnTaskController.Ggw.clear();
        cdnTaskController.Ggx.clear();
        cdnTaskController.Ggu.clear();
        cdnTaskController.Ggv.clear();
        com.tencent.mm.an.f.baR().a((a.AbstractC0257a) null);
        com.tencent.mm.an.f.baR().a((b.a) null);
        AppMethodBeat.o(238606);
    }

    private final void initThumbPlayer() {
        AppMethodBeat.i(238607);
        this.Ggn = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_xlog_open_multi, 0);
        if (this.Ggn == 0 && this.Ggm == null) {
            Log.LogInstance openLogInstance = Log.openLogInstance(2, 0, XLogSetup.cachePath, XLogSetup.logPath, "TP", 0);
            p.g(openLogInstance, "Log.openLogInstance(Xlog…ogSetup.logPath, \"TP\", 0)");
            this.Ggm = openLogInstance;
        }
        TPPlayerMgr.setOnLogListener(new b(this));
        TPPlayerMgr.initSdk(MMApplicationContext.getContext(), "60303", 1);
        TPPlayerMgr.setProxyEnable(true);
        TPPlayerMgr.setProxyServiceType(100);
        AppMethodBeat.o(238607);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/thumbplayer/PluginThumbPlayer$initThumbPlayer$2", "Lcom/tencent/thumbplayer/api/TPPlayerMgr$OnLogListener;", "TAG", "", "getTAG", "()Ljava/lang/String;", "d", "", "tag", "msg", "e", "i", "v", "w", "plugin-thumbplayer_release"})
    public static final class b implements TPPlayerMgr.OnLogListener {
        final /* synthetic */ PluginThumbPlayer Ggs;
        private final String TAG = "Finder.TPPlayerMgr";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(PluginThumbPlayer pluginThumbPlayer) {
            this.Ggs = pluginThumbPlayer;
        }

        @Override // com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener
        public final int d(String str, String str2) {
            AppMethodBeat.i(238599);
            if (PluginThumbPlayer.access$isEnableMultiXLog(this.Ggs, this.Ggs.Ggn)) {
                PluginThumbPlayer.access$getLog$p(this.Ggs).d(this.TAG, str + ':' + str2, new Object[0]);
            } else {
                Log.d(this.TAG, str + ':' + str2);
            }
            AppMethodBeat.o(238599);
            return 0;
        }

        @Override // com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener
        public final int i(String str, String str2) {
            AppMethodBeat.i(238600);
            if (PluginThumbPlayer.access$isEnableMultiXLog(this.Ggs, this.Ggs.Ggn)) {
                PluginThumbPlayer.access$getLog$p(this.Ggs).i(this.TAG, str + ':' + str2, new Object[0]);
            } else {
                Log.i(this.TAG, str + ':' + str2);
            }
            AppMethodBeat.o(238600);
            return 0;
        }

        @Override // com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener
        public final int w(String str, String str2) {
            AppMethodBeat.i(238601);
            if (PluginThumbPlayer.access$isEnableMultiXLog(this.Ggs, this.Ggs.Ggn)) {
                PluginThumbPlayer.access$getLog$p(this.Ggs).w(this.TAG, str + ':' + str2, new Object[0]);
            } else {
                Log.w(this.TAG, str + ':' + str2);
            }
            AppMethodBeat.o(238601);
            return 0;
        }

        @Override // com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener
        public final int e(String str, String str2) {
            AppMethodBeat.i(238602);
            if (PluginThumbPlayer.access$isEnableMultiXLog(this.Ggs, this.Ggs.Ggn)) {
                PluginThumbPlayer.access$getLog$p(this.Ggs).e(this.TAG, str + ':' + str2, new Object[0]);
            } else {
                Log.e(this.TAG, str + ':' + str2);
            }
            AppMethodBeat.o(238602);
            return 0;
        }

        @Override // com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener
        public final int v(String str, String str2) {
            AppMethodBeat.i(238603);
            if (PluginThumbPlayer.access$isEnableMultiXLog(this.Ggs, this.Ggs.Ggn)) {
                PluginThumbPlayer.access$getLog$p(this.Ggs).v(this.TAG, str + ':' + str2, new Object[0]);
            } else {
                Log.v(this.TAG, str + ':' + str2);
            }
            AppMethodBeat.o(238603);
            return 0;
        }
    }

    private final boolean isEnableMultiXLog(int i2) {
        return !BuildInfo.DEBUG && i2 == 0 && this.Ggm != null;
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.plugin.thumbplayer.a.a
    public final boolean isOpenTPPlayer() {
        AppMethodBeat.i(238608);
        if (this.Ggp == null) {
            this.Ggp = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_tp_play_flag, 1) == 1);
        }
        Boolean bool = this.Ggp;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(238608);
            return booleanValue;
        }
        AppMethodBeat.o(238608);
        return true;
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public final void parallelsDependency() {
    }

    public final boolean isOpenTPPlayerBgPrepare() {
        return true;
    }

    @Override // com.tencent.mm.plugin.thumbplayer.a.a
    public final boolean isOpenTPPlayerScroll() {
        return true;
    }

    public final boolean isOpenTPFlowControl() {
        boolean z;
        AppMethodBeat.i(238609);
        if (this.Ggq == null) {
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_tp_flow_control_flag, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.Ggq = Boolean.valueOf(z);
        }
        Boolean bool = this.Ggq;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(238609);
            return booleanValue;
        }
        AppMethodBeat.o(238609);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<com.tencent.mm.plugin.thumbplayer.b.a> {
        public static final a Ggr = new a();

        static {
            AppMethodBeat.i(238598);
            AppMethodBeat.o(238598);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.thumbplayer.b.a invoke() {
            AppMethodBeat.i(238597);
            com.tencent.mm.plugin.thumbplayer.b.a aVar = new com.tencent.mm.plugin.thumbplayer.b.a();
            Log.i(aVar.TAG, "init cdn task controller");
            aVar.Ggw.clear();
            aVar.Ggx.clear();
            aVar.Ggu.clear();
            aVar.Ggv.clear();
            com.tencent.mm.an.f.baR().a(new a.b());
            com.tencent.mm.an.f.baR().a(new a.C1830a());
            AppMethodBeat.o(238597);
            return aVar;
        }
    }
}
