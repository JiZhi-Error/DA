package com.tencent.mm.plugin.festival.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.festival.PluginFestival;
import com.tencent.mm.plugin.festival.a.a;
import com.tencent.mm.plugin.festival.c.f;
import com.tencent.mm.plugin.festival.c.i;
import com.tencent.mm.plugin.festival.finder.FestivalFinderLiveEndUI;
import com.tencent.mm.plugin.festival.model.z;
import com.tencent.mm.plugin.festival.ui.FestivalWaitForHeartbeatLoadingProxyUIC;
import com.tencent.mm.plugin.festival.ui.bak.FestivalBakUI;
import com.tencent.mm.plugin.festival.ui.bak.FestivalSecondBakUI;
import com.tencent.mm.plugin.festival.ui.bak.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import kotlin.g.a.r;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalExportService;", "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService;", "()V", "enterFestivalFinderLiveUI", "", "context", "Landroid/content/Context;", "fromScene", "", "forceCloseFestivalLiveFloatBall", "getFestivalLiveInfo", "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService$FestivalLiveInfo;", "infoUpdateCallback", "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService$LiveInfoUpdateCallback;", "getMultiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isFestivalLiveOpen", "", "showDebugMenu", "Companion", "plugin-festival_release"})
public final class e implements com.tencent.mm.plugin.festival.a.a {
    private static final p UxJ = new p(new byte[0], f.a.LastMultiTaskBytes);
    private static final p UxK = new p((Object) 0L, f.a.LastEnterTime);
    public static final a UxL = new a((byte) 0);
    private static long taC;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "objectId", "", "liveId", "anchorUserName", "", "nonceId", "invoke"})
    /* renamed from: com.tencent.mm.plugin.festival.model.e$e  reason: collision with other inner class name */
    public static final class C1069e extends q implements r<Long, Long, String, String, x> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1069e(Context context) {
            super(4);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Long l, Long l2, String str, String str2) {
            long j2;
            AppMethodBeat.i(262912);
            LiveConfig aBR = new LiveConfig.a().qo(LiveConfig.hvU).zt(l2.longValue()).Gd(str2).zu(l.longValue()).Gg(str).Gh(null).aBR();
            p.g(aBR, "builder.toWhere(LiveConf…\n                .build()");
            FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
            finderLiveConfig.uiu.add(aBR);
            aj ajVar = (aj) com.tencent.mm.kernel.g.ah(aj.class);
            LiveConfig dfu = finderLiveConfig.dfu();
            if (dfu != null) {
                j2 = Long.valueOf(dfu.getLiveId());
            } else {
                j2 = 0L;
            }
            ajVar.cleatLiveStatusCache(j2);
            Intent intent = new Intent();
            intent.addFlags(335544320);
            intent.putExtra("KEY_PARAMS_CONFIG", finderLiveConfig);
            intent.setClass(this.$context, FestivalFinderLiveEndUI.class);
            Context context = this.$context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/festival/model/FestivalExportService$enterFestivalFinderLiveUI$5", "invoke", "(JJLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/festival/model/FestivalExportService$enterFestivalFinderLiveUI$5", "invoke", "(JJLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            e.taC = MMSlotKt.now();
            x xVar = x.SXb;
            AppMethodBeat.o(262912);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8B@BX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\nR\u0014\u0010\u001e\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\n¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalExportService$Companion;", "", "()V", "EndTimeDefaultValue", "", "StartTimeDefaultValue", "TAG", "", "endTime", "getEndTime", "()I", "lastEnterTime", "", "<set-?>", "", "lastMultiTaskInfoBytes", "getLastMultiTaskInfoBytes", "()[B", "setLastMultiTaskInfoBytes", "([B)V", "lastMultiTaskInfoBytes$delegate", "Lcom/tencent/mm/plugin/festival/model/FestivalMmkvProperty;", "lastVisitTime", "getLastVisitTime", "()J", "setLastVisitTime", "(J)V", "lastVisitTime$delegate", "liveStatus", "getLiveStatus", "startTime", "getStartTime", "onCloseFestival", "", "onCloseFestival$plugin_festival_release", "saveMultiTaskInfo", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "saveMultiTaskInfo$plugin_festival_release", "plugin-festival_release"})
    public static final class a {
        static final /* synthetic */ k[] cLI = {aa.a(new v(aa.bp(a.class), "lastMultiTaskInfoBytes", "getLastMultiTaskInfoBytes()[B")), aa.a(new v(aa.bp(a.class), "lastVisitTime", "getLastVisitTime()J"))};

        static {
            AppMethodBeat.i(262897);
            AppMethodBeat.o(262897);
        }

        private static void RG(long j2) {
            AppMethodBeat.i(262898);
            e.UxK.a(e.UxL, cLI[1], Long.valueOf(j2));
            AppMethodBeat.o(262898);
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static final /* synthetic */ void gIh() {
            AppMethodBeat.i(262905);
            RG(0);
            AppMethodBeat.o(262905);
        }

        public static final /* synthetic */ int gIi() {
            AppMethodBeat.i(262906);
            int startTime = getStartTime();
            AppMethodBeat.o(262906);
            return startTime;
        }

        public static final /* synthetic */ int gIj() {
            AppMethodBeat.i(262907);
            int endTime = getEndTime();
            AppMethodBeat.o(262907);
            return endTime;
        }

        private static int getStartTime() {
            AppMethodBeat.i(262899);
            int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_festival_start_time, Integer.MAX_VALUE);
            AppMethodBeat.o(262899);
            return a2;
        }

        private static int getEndTime() {
            AppMethodBeat.i(262900);
            int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_festival_end_time, Integer.MIN_VALUE);
            AppMethodBeat.o(262900);
            return a2;
        }

        public static int getLiveStatus() {
            AppMethodBeat.i(262901);
            int aWB = cl.aWB();
            a aVar = e.UxL;
            int startTime = getStartTime();
            a aVar2 = e.UxL;
            int endTime = getEndTime();
            if (startTime <= aWB && endTime >= aWB) {
                AppMethodBeat.o(262901);
                return 1;
            }
            AppMethodBeat.o(262901);
            return 2;
        }

        public static void gFm() {
            AppMethodBeat.i(262902);
            Log.i("MicroMsg.FestivalExportService", "onCloseFestival");
            if (e.taC != 0 && MMSlotKt.isExpire(e.taC, 15)) {
                Log.i("MicroMsg.FestivalExportService", "onCloseFestival should save multitask");
                RG(MMSlotKt.now());
                ((com.tencent.mm.plugin.taskbar.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).hWP();
            }
            e.taC = 0;
            AppMethodBeat.o(262902);
        }

        public static void j(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            awe awe;
            AppMethodBeat.i(262903);
            p.h(gVar, "liveData");
            Log.i("MicroMsg.FestivalExportService", "saveMultiTaskInfo");
            aws aws = new aws();
            aws.tuO = gVar.uDz;
            FinderObject finderObject = aws.tuO;
            if (!(finderObject == null || (awe = finderObject.liveInfo) == null)) {
                awe.liveStatus = 1;
            }
            a aVar = e.UxL;
            byte[] byteArray = aws.toByteArray();
            p.g(byteArray, "toByteArray()");
            e.UxJ.a(e.UxL, cLI[0], byteArray);
            AppMethodBeat.o(262903);
        }

        public static final /* synthetic */ long gHH() {
            AppMethodBeat.i(262904);
            long longValue = ((Number) e.UxK.a(e.UxL, cLI[1])).longValue();
            AppMethodBeat.o(262904);
            return longValue;
        }

        public static final /* synthetic */ byte[] gIL() {
            AppMethodBeat.i(262908);
            byte[] bArr = (byte[]) e.UxJ.a(e.UxL, cLI[0]);
            AppMethodBeat.o(262908);
            return bArr;
        }
    }

    static {
        AppMethodBeat.i(262927);
        AppMethodBeat.o(262927);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/festival/model/FestivalExportService$init$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "taskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-festival_release"})
    public static final class f implements c.a {
        final /* synthetic */ e UxP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(e eVar) {
            this.UxP = eVar;
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void a(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(262913);
            p.h(multiTaskInfo, "taskInfo");
            AppMethodBeat.o(262913);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void b(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(262914);
            p.h(multiTaskInfo, "taskInfo");
            Object[] objArr = new Object[1];
            MultiTaskInfo dqr = this.UxP.dqr();
            objArr[0] = dqr != null ? dqr.field_id : null;
            Log.i("MicroMsg.FestivalExportService", "onTaskBarItemClicked field_id:%s", objArr);
            if (!p.j(multiTaskInfo.field_id, "wedraw")) {
                AppMethodBeat.o(262914);
                return;
            }
            e eVar = this.UxP;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            eVar.ba(context, 13);
            AppMethodBeat.o(262914);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void c(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(262915);
            p.h(multiTaskInfo, "taskInfo");
            Object[] objArr = new Object[1];
            MultiTaskInfo dqr = this.UxP.dqr();
            objArr[0] = dqr != null ? dqr.field_id : null;
            Log.i("MicroMsg.FestivalExportService", "onTaskBarItemRemoved field_id:%s", objArr);
            if (!p.j(multiTaskInfo.field_id, "wedraw")) {
                AppMethodBeat.o(262915);
                return;
            }
            a aVar = e.UxL;
            a.gIh();
            AppMethodBeat.o(262915);
        }
    }

    @Override // com.tencent.mm.plugin.festival.a.a
    public final void init() {
        AppMethodBeat.i(262920);
        ((com.tencent.mm.plugin.taskbar.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).a(21, new f(this));
        AppMethodBeat.o(262920);
    }

    @Override // com.tencent.mm.plugin.festival.a.a
    public final void ba(Context context, int i2) {
        String string;
        boolean z = true;
        AppMethodBeat.i(262921);
        p.h(context, "context");
        i iVar = i.Uyl;
        i.log("enter fromScene:" + i2 + ", isTablet:" + ao.hYD());
        if (ao.hYD()) {
            new f.a(context).hbu().bow(context.getString(R.string.j8k)).boA(context.getString(R.string.w0)).b(b.UxM).show();
            AppMethodBeat.o(262921);
        } else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            new f.a(context).hbu().bow(context.getString(R.string.cta)).boA(context.getString(R.string.w0)).b(c.UxN).show();
            AppMethodBeat.o(262921);
        } else {
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
            p.g(af, "MMKernel.service(ITeenModeService::class.java)");
            if (((com.tencent.mm.plugin.teenmode.a.b) af).Vt()) {
                com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(ad.class);
                p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
                if (!((ad) af2).dxY()) {
                    ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(context);
                    AppMethodBeat.o(262921);
                    return;
                }
            }
            i iVar2 = i.UGI;
            p.h(context, "context");
            if (i.bZp()) {
                string = context.getString(R.string.e3e);
            } else if (com.tencent.mm.q.a.atx()) {
                string = context.getString(R.string.e3g);
            } else if (m.isVoipStarted() || m.fKH() || com.tencent.mm.bh.e.att() || com.tencent.mm.q.a.atw()) {
                string = context.getString(R.string.e3h);
            } else if (m.fKI()) {
                string = context.getString(R.string.e3g);
            } else {
                string = null;
            }
            String str = string;
            if (!(str == null || str.length() == 0)) {
                Log.i("MicroMsg.FestivalExportService", "enterFestivalFinderLiveUI ".concat(String.valueOf(string)));
                new f.a(context).hbu().bow(string).boA(context.getString(R.string.w0)).b(d.UxO).show();
                AppMethodBeat.o(262921);
                return;
            }
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
            p.g(ah, "plugin(IPluginFinder::class.java)");
            if (((aj) ah).isAnchorLiving()) {
                Log.i("MicroMsg.FestivalExportService", "isAnchorLiving");
                u.cE(context, context.getString(R.string.cy8));
                AppMethodBeat.o(262921);
                return;
            }
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(aj.class);
            p.g(ah2, "plugin(IPluginFinder::class.java)");
            if (((aj) ah2).isVisitorLiving()) {
                Log.i("MicroMsg.FestivalExportService", "isAnchorLiving");
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).forcestopCurLive();
            }
            int aWB = cl.aWB();
            if (aWB < a.gIi() || aWB > a.gIj()) {
                Log.i("MicroMsg.FestivalExportService", "enterFestivalFinderLiveUI status error now:" + aWB + " start:" + a.gIi() + " end:" + a.gIj());
                Intent intent = new Intent();
                int i3 = aWB < a.gIi() ? 2 : 1;
                intent.setClass(context, FestivalSecondBakUI.class);
                intent.putExtra("IntentKeyAnchorUsrName", z.Uzb.hRC().UAE);
                intent.putExtra("IntentKeyStatusErrorType", i3);
                if (!(context instanceof Activity)) {
                    intent.addFlags(335544320);
                }
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/festival/model/FestivalExportService", "enterFestivalFinderLiveUI", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/festival/model/FestivalExportService", "enterFestivalFinderLiveUI", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(262921);
                return;
            }
            com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
            com.tencent.mm.plugin.festival.model.a.b.awF(i2);
            z zVar = z.Uzb;
            C1069e eVar = new C1069e(context);
            p.h(context, "context");
            p.h(eVar, "startLiveRoomDelegate");
            z.d dVar = new z.d(eVar);
            com.tencent.mm.plugin.festival.b.e hRC = zVar.hRC();
            String str2 = hRC.UAD;
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = hRC.UAF;
                if (!(str3 == null || str3.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    dVar.invoke(hRC);
                    g.UxZ.awB(i2);
                    AppMethodBeat.o(262921);
                    return;
                }
            }
            FestivalWaitForHeartbeatLoadingProxyUIC.a aVar = FestivalWaitForHeartbeatLoadingProxyUIC.UBG;
            p.h(context, "context");
            FestivalWaitForHeartbeatLoadingProxyUIC.c cVar = new FestivalWaitForHeartbeatLoadingProxyUIC.c();
            Intent intent2 = new Intent(context, FestivalBakUI.class);
            intent2.putExtra("INTENT_KEY_REQUEST_ID", cVar.dPI);
            a.EnumC1072a aVar2 = a.EnumC1072a.WaitForHeartbeatLoading;
            p.h(intent2, "intent");
            intent2.putExtra("FESTIVAL_INTENT_KEY_UICOMPONENT_TYPE", aVar2.ordinal());
            if (!(context instanceof Activity)) {
                intent2.addFlags(335544320);
            }
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/festival/ui/FestivalWaitForHeartbeatLoadingProxyUIC$Companion", "showLoading", "(Landroid/content/Context;)Lcom/tencent/mm/plugin/festival/ui/FestivalWaitForHeartbeatLoadingProxyUIC$LoadingPresenter;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/festival/ui/FestivalWaitForHeartbeatLoadingProxyUIC$Companion", "showLoading", "(Landroid/content/Context;)Lcom/tencent/mm/plugin/festival/ui/FestivalWaitForHeartbeatLoadingProxyUIC$LoadingPresenter;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            FestivalWaitForHeartbeatLoadingProxyUIC.hSg().put(cVar.dPI, cVar);
            FestivalWaitForHeartbeatLoadingProxyUIC.c cVar2 = cVar;
            z.a(new z.b(cVar2, context, dVar, i2));
            new z.c(cVar2).alive();
            g.UxZ.awB(i2);
            AppMethodBeat.o(262921);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class b implements f.c {
        public static final b UxM = new b();

        static {
            AppMethodBeat.i(262909);
            AppMethodBeat.o(262909);
        }

        b() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class c implements f.c {
        public static final c UxN = new c();

        static {
            AppMethodBeat.i(262910);
            AppMethodBeat.o(262910);
        }

        c() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class d implements f.c {
        public static final d UxO = new d();

        static {
            AppMethodBeat.i(262911);
            AppMethodBeat.o(262911);
        }

        d() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    @Override // com.tencent.mm.plugin.festival.a.a
    public final boolean fQ(Context context) {
        AppMethodBeat.i(262922);
        p.h(context, "context");
        if (BuildInfo.DEBUG || WeChatEnvironment.hasDebugger()) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(context, 1, false);
            eVar.a(g.UxQ);
            eVar.a(h.UxR);
            eVar.dGm();
            AppMethodBeat.o(262922);
            return true;
        }
        AppMethodBeat.o(262922);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class g implements o.f {
        public static final g UxQ = new g();

        static {
            AppMethodBeat.i(262917);
            AppMethodBeat.o(262917);
        }

        g() {
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(262916);
            mVar.d(0, "清除直播间缓存");
            AppMethodBeat.o(262916);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class h implements o.g {
        public static final h UxR = new h();

        static {
            AppMethodBeat.i(262919);
            AppMethodBeat.o(262919);
        }

        h() {
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(262918);
            p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == 0) {
                af[] afVarArr = {z.Uzb, l.Uyp, g.UxZ, (af) com.tencent.mm.kernel.g.ah(PluginFestival.class)};
                for (int i3 = 0; i3 < 4; i3++) {
                    afVarArr[i3].debugClearCacheData();
                }
                ab.UzG.Fm(true);
                ab.UzG.Fn(false);
            }
            AppMethodBeat.o(262918);
        }
    }

    @Override // com.tencent.mm.plugin.festival.a.a
    public final boolean dml() {
        AppMethodBeat.i(262923);
        if (a.getLiveStatus() == 1) {
            AppMethodBeat.o(262923);
            return true;
        }
        AppMethodBeat.o(262923);
        return false;
    }

    @Override // com.tencent.mm.plugin.festival.a.a
    public final a.C1051a dnB() {
        AppMethodBeat.i(262924);
        a.C1051a aVar = new a.C1051a();
        aVar.VC = dml();
        aVar.UpZ = -1;
        aVar.Uqa = -1;
        aVar.title = MMApplicationContext.getContext().getString(R.string.j9o);
        aVar.liveStatus = a.getLiveStatus();
        AppMethodBeat.o(262924);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.festival.a.a
    public final MultiTaskInfo dqr() {
        MultiTaskInfo multiTaskInfo = null;
        boolean z = true;
        AppMethodBeat.i(262925);
        if (a.getLiveStatus() != 1) {
            Log.i("MicroMsg.FestivalExportService", "getMultiTaskInfo: festival end");
            AppMethodBeat.o(262925);
        } else if (a.gHH() == 0) {
            Log.i("MicroMsg.FestivalExportService", "getMultiTaskInfo: festival not enter");
            AppMethodBeat.o(262925);
        } else {
            if (!(a.gIL().length == 0)) {
                multiTaskInfo = new MultiTaskInfo();
                multiTaskInfo.field_data = a.gIL();
                multiTaskInfo.field_id = "wedraw";
                multiTaskInfo.field_type = 21;
                multiTaskInfo.field_updateTime = a.gHH();
                multiTaskInfo.field_createTime = multiTaskInfo.field_updateTime;
            }
            StringBuilder sb = new StringBuilder("getMultiTaskInfo: return info ");
            if (multiTaskInfo == null) {
                z = false;
            }
            Log.i("MicroMsg.FestivalExportService", sb.append(z).toString());
            AppMethodBeat.o(262925);
        }
        return multiTaskInfo;
    }

    @Override // com.tencent.mm.plugin.festival.a.a
    public final void dqm() {
        AppMethodBeat.i(262926);
        h.Uye.dqm();
        AppMethodBeat.o(262926);
    }
}
