package com.tencent.mm.plugin.handoff.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.protocal.protobuf.ecr;
import com.tencent.mm.protocal.protobuf.ecs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0012\u0018\u0000 =2\u00020\u0001:\u0001=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bJ\u0014\u0010\"\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0$J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020 H\u0002J\b\u0010)\u001a\u00020 H\u0002J\u000e\u0010*\u001a\u00020 2\u0006\u0010!\u001a\u00020\bJ\u0014\u0010*\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0$J\b\u0010+\u001a\u00020 H\u0002J\u0014\u0010,\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0$J\b\u0010-\u001a\u00020 H\u0002J\u000e\u0010.\u001a\u00020 2\u0006\u0010!\u001a\u00020\bJ*\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u00162\b\u00102\u001a\u0004\u0018\u00010\u00072\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020 H\u0002J\u001e\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0$H\u0002J\u0010\u00106\u001a\u00020 2\u0006\u00108\u001a\u00020\u0007H\u0002J\u0014\u00109\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0$J\u000e\u0010:\u001a\u00020 2\u0006\u0010!\u001a\u00020\bJ\u000e\u0010:\u001a\u00020 2\u0006\u00108\u001a\u00020\u0007J\u000e\u0010;\u001a\u00020 2\u0006\u0010!\u001a\u00020\bJ\u000e\u0010<\u001a\u00020 2\u0006\u0010!\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handOffEnable", "getHandOffEnable", "()Z", "handOffSeq", "", "handler", "com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/plugin/handoff/service/StatusManager$handler$1;", "ids", "maxRetryCount", "", "modList", "msgQueue", "Ljava/util/LinkedList;", "networkAvailable", "networkStatus", "nextSeq", "queueWorking", "retryCount", "add", "", "handOff", "allList", "handOffList", "", "apply", "checkMsgQueue", "checkNetworkAvailableMM", "clearStatus", "commit", "del", "incSeq", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "launchSendTask", "mod", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "retry", "sendHandOff", "opCode", "msg", "sendOpenRequest", "uploadFail", "uploadSuccess", "uploading", "Companion", "plugin-handoff_release"})
public final class h implements i {
    public static final a yiX = new a((byte) 0);
    private int retryCount;
    private final Map<String, HandOff> yhU = new LinkedHashMap();
    private final Map<String, HandOff> yhV = new LinkedHashMap();
    private final Map<String, Boolean> yhW = new LinkedHashMap();
    private boolean yiN;
    final LinkedList<String> yiO = new LinkedList<>();
    private boolean yiP = true;
    private String yiQ = "4G";
    private final int yiR = 3;
    private final Map<String, HandOff> yiS = new LinkedHashMap();
    private final Map<String, String> yiT = new LinkedHashMap();
    private long yiU;
    private long yiV;
    private final b yiW;

    static {
        AppMethodBeat.i(10447);
        AppMethodBeat.o(10447);
    }

    public h(Looper looper) {
        p.h(looper, "looper");
        AppMethodBeat.i(199227);
        this.yiW = new b(this, looper, looper);
        AppMethodBeat.o(199227);
    }

    public static final /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(10449);
        hVar.dYH();
        AppMethodBeat.o(10449);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/StatusManager$Companion;", "", "()V", "FUNC_NAME", "", "MSG_COMMIT", "", "MSG_RETRY", "SEQ_PLACEHOLDER", "SYNC_INTERVAL", "", "TAG", "plugin-handoff_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static boolean dYD() {
        AppMethodBeat.i(199225);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_handoff_enable, false);
        AppMethodBeat.o(199225);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
    public static final class b extends MMHandler {
        final /* synthetic */ h yiY;
        final /* synthetic */ Looper yib;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar, Looper looper, Looper looper2) {
            super(looper2);
            this.yiY = hVar;
            this.yib = looper;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(10429);
            p.h(message, "msg");
            switch (message.what) {
                case 1:
                    Log.d("HandOff.StatusManager", "handle commit message");
                    e.yim.dYk();
                    AppMethodBeat.o(10429);
                    return;
                case 2:
                    Log.d("HandOff.StatusManager", "handle retry message");
                    h.a(this.yiY);
                    break;
            }
            AppMethodBeat.o(10429);
        }
    }

    public final void l(Collection<? extends HandOff> collection) {
        AppMethodBeat.i(10430);
        p.h(collection, "handOffList");
        try {
            String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            p.g(formatedNetType, "NetStatusUtil.getFormatedNetType(getContext())");
            this.yiQ = formatedNetType;
            e aAh = g.aAh();
            p.g(aAh, "storage()");
            this.yiU = aAh.azQ().a(ar.a.USERINFO_HANDOFF_SEQ_LONG_SYNC, 0);
        } catch (Exception e2) {
            Log.printErrStackTrace("HandOff.StatusManager", e2, "restoreFromBallInfoList fail, exp:%s", e2);
            this.yiU = 0;
        }
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "network()");
        aAg.azz().a(251, this);
        a(4, collection);
        AppMethodBeat.o(10430);
    }

    public final void n(HandOff handOff) {
        AppMethodBeat.i(10434);
        p.h(handOff, "handOff");
        apply();
        AppMethodBeat.o(10434);
    }

    public final void m(Collection<? extends HandOff> collection) {
        AppMethodBeat.i(10435);
        p.h(collection, "handOffList");
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            n((HandOff) it.next());
        }
        AppMethodBeat.o(10435);
    }

    private final void dYE() {
        AppMethodBeat.i(10436);
        this.yhU.clear();
        this.yiS.clear();
        this.yhV.clear();
        this.yhW.clear();
        this.yiT.clear();
        AppMethodBeat.o(10436);
    }

    public final void n(Collection<? extends HandOff> collection) {
        AppMethodBeat.i(10437);
        p.h(collection, "handOffList");
        this.yiW.removeMessages(1);
        dYE();
        a(4, collection);
        AppMethodBeat.o(10437);
    }

    private final void aBC(String str) {
        AppMethodBeat.i(10438);
        com.tencent.mm.kernel.a aAf = g.aAf();
        p.g(aAf, "account()");
        if (!aAf.azn()) {
            Log.i("HandOff.StatusManager", "device offline, don't send handoff: ".concat(String.valueOf(str)));
            this.yiO.poll();
            dYF();
        } else if (WeChatEnvironment.hasDebugger() || dYD()) {
            this.yiV = this.yiU;
            String str2 = str;
            while (n.a((CharSequence) str2, (CharSequence) "<![CSEQ]>", false)) {
                str2 = n.by(str2, "<![CSEQ]>", String.valueOf(this.yiV));
                if (this.yiV == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                    this.yiV = 0;
                }
                this.yiV++;
            }
            Log.i("HandOff.StatusManager", "send handoff: ".concat(String.valueOf(str2)));
            if (!ab.bz(str2, "HandOffMaster")) {
                dYH();
                AppMethodBeat.o(10438);
                return;
            }
        } else {
            Log.i("HandOff.StatusManager", "debugger: " + WeChatEnvironment.hasDebugger() + ", handoff enabled: " + dYD() + ", don't send handoff: " + str);
            this.yiO.poll();
            dYF();
            AppMethodBeat.o(10438);
            return;
        }
        AppMethodBeat.o(10438);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Collection<? extends HandOff> collection) {
        AppMethodBeat.i(10439);
        com.tencent.mm.plugin.handoff.model.b bVar = new com.tencent.mm.plugin.handoff.model.b(i2, collection, 0, 4);
        String aoG = q.aoG();
        p.g(aoG, "DeviceInfo.getMMGUID()");
        this.yiO.add(bVar.V(aoG, this.yiQ, a.dYp()));
        dYG();
        AppMethodBeat.o(10439);
    }

    public final void o(HandOff handOff) {
        AppMethodBeat.i(10440);
        p.h(handOff, "handOff");
        a(3, j.listOf(handOff));
        AppMethodBeat.o(10440);
    }

    private final void dYF() {
        AppMethodBeat.i(10441);
        if (this.yiO.isEmpty()) {
            Log.i("HandOff.StatusManager", "message queue is empty, set queueWorking = false");
            this.yiN = false;
            AppMethodBeat.o(10441);
            return;
        }
        try {
            String first = this.yiO.getFirst();
            p.g(first, "msg");
            aBC(first);
            AppMethodBeat.o(10441);
        } catch (Exception e2) {
            Log.printErrStackTrace("HandOff.StatusManager", e2, "", new Object[0]);
            this.yiN = false;
            AppMethodBeat.o(10441);
        }
    }

    /* access modifiers changed from: package-private */
    public final void dYG() {
        AppMethodBeat.i(10442);
        if (!this.yiN) {
            Log.i("HandOff.StatusManager", "launch queue, set queueWorking = true");
            this.yiN = true;
            dYF();
        }
        AppMethodBeat.o(10442);
    }

    /* access modifiers changed from: package-private */
    public final void apply() {
        AppMethodBeat.i(10443);
        if (!this.yiW.hasMessages(1)) {
            Log.d("HandOff.StatusManager", "plan commit task");
            this.yiW.sendEmptyMessageDelayed(1, 2000);
        }
        AppMethodBeat.o(10443);
    }

    private static boolean dPY() {
        AppMethodBeat.i(199226);
        t azz = g.azz();
        p.g(azz, "MMKernel.getNetSceneQueue()");
        int aYS = azz.aYS();
        if (aYS == 4 || aYS == 6) {
            AppMethodBeat.o(199226);
            return true;
        }
        AppMethodBeat.o(199226);
        return false;
    }

    private final void dYH() {
        AppMethodBeat.i(10444);
        this.retryCount++;
        if (this.retryCount >= this.yiR) {
            this.yiO.poll();
            this.retryCount = 0;
        }
        Log.i("HandOff.StatusManager", "send handoff failed, retry: " + this.retryCount);
        boolean dPY = dPY();
        if (!dPY) {
            Log.i("HandOff.StatusManager", "network unavailable, clear message queue and retry after 30s");
            this.yiO.clear();
            this.yiW.sendEmptyMessageDelayed(2, 30000);
        } else {
            if (!this.yiP) {
                Log.i("HandOff.StatusManager", "network become available, send all list");
                String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
                p.g(formatedNetType, "NetStatusUtil.getFormatedNetType(getContext())");
                this.yiQ = formatedNetType;
                e.yim.dYk();
            }
            dYF();
        }
        this.yiP = dPY;
        AppMethodBeat.o(10444);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(10445);
        p.h(qVar, "scene");
        if (qVar.getReqResp() instanceof d) {
            s reqResp = qVar.getReqResp();
            if (reqResp == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                AppMethodBeat.o(10445);
                throw tVar;
            } else if (((d) reqResp).aYJ() instanceof ecs) {
                s reqResp2 = qVar.getReqResp();
                if (reqResp2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.o(10445);
                    throw tVar2;
                }
                com.tencent.mm.bw.a aYJ = ((d) reqResp2).aYJ();
                if (aYJ == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StatusNotifyRequest");
                    AppMethodBeat.o(10445);
                    throw tVar3;
                }
                ecr ecr = ((ecs) aYJ).Ndb;
                if (ecr != null) {
                    if (p.j(ecr.Name, "HandOffMaster")) {
                        if (i2 == 0 && i3 == 0) {
                            this.yiO.poll();
                            this.retryCount = 0;
                            this.yiU = this.yiV;
                            e aAh = g.aAh();
                            p.g(aAh, "storage()");
                            aAh.azQ().set(ar.a.USERINFO_HANDOFF_SEQ_LONG_SYNC, Long.valueOf(this.yiU));
                            Log.i("HandOff.StatusManager", "send handoff succeed, check next message");
                            dYF();
                            AppMethodBeat.o(10445);
                            return;
                        }
                        Log.e("HandOff.StatusManager", "send handoff fail, errType:" + i2 + ", errCode:" + i3);
                        dYH();
                    }
                    AppMethodBeat.o(10445);
                    return;
                }
            }
        }
        AppMethodBeat.o(10445);
    }
}
