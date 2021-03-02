package com.tencent.mm.plugin.forcenotify.b;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.forcenotify.c.f;
import com.tencent.mm.plugin.forcenotify.d.a;
import com.tencent.mm.plugin.forcenotify.f.b;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI;
import com.tencent.mm.plugin.forcenotify.ui.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\f\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\tH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\tH\u0016J\"\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u001bH\u0016J\b\u00105\u001a\u00020\u0011H\u0016J\u0018\u00106\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\tH\u0016J\u0012\u00109\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016J\u000e\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\tJ\u000e\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\tJ\b\u0010>\u001a\u00020\u0011H\u0016J\u0010\u0010?\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010?\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010@\u001a\u00020AH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "()V", "ForceNotifyLiveTag", "", "ForceNotifyMiniAppTag", "ForceNotifyMsgTag", "isSound", "", "()Z", "setSound", "(Z)V", "isTestError", "isVibrate", "setVibrate", "delete", "", "forcePushId", "scene", "", "getCount", "getExpireTime", "", ch.COL_USERNAME, "getForceNotifyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getForceNotifyStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "hasError", "isMsgNeedNotify", "isNeedNotify", "isNeedShowBanner", "isPhoneLocking", "isSilentMode", "context", "Landroid/content/Context;", "isVibrateMode", "modifyForceNotify", "info", "isAdd", "onOpLogResult", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onReceiveLiveForcePush", "item", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "onReceiveMsgForcePush", "notifyInfo", "release", "setCanSoundAndVibrate", "setForTest", "isTest", "setting", "showNotifyActivity", "force", "showNotifyWindow", "update", "start", "startForceNotifyShowUI", "intent", "Landroid/content/Intent;", "plugin-force-notify_release"})
public final class c extends a implements h.a {
    private static boolean wLP;
    private static boolean wLQ = true;
    private static boolean wLR = true;
    public static final c wLS = new c();

    static {
        AppMethodBeat.i(149175);
        AppMethodBeat.o(149175);
    }

    private c() {
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.b
    public final void ps(boolean z) {
        wLP = z;
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.b
    public final MAutoStorage<?> dMm() {
        return a.wLU;
    }

    public final boolean fR(Context context) {
        AppMethodBeat.i(149159);
        p.h(context, "context");
        Object systemService = context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(149159);
            throw tVar;
        }
        AudioManager audioManager = (AudioManager) systemService;
        Log.i(this.TAG, "isSilentMode ringMode=" + audioManager.getRingerMode() + " RING_MODE_NORMAL=2");
        if (audioManager.getRingerMode() != 2) {
            AppMethodBeat.o(149159);
            return true;
        }
        AppMethodBeat.o(149159);
        return false;
    }

    public final boolean fS(Context context) {
        AppMethodBeat.i(149160);
        p.h(context, "context");
        Object systemService = context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(149160);
            throw tVar;
        }
        AudioManager audioManager = (AudioManager) systemService;
        Log.i(this.TAG, "isVibrateMode ringMode=" + audioManager.getRingerMode() + " RINGER_MODE_SILENT=0");
        if (audioManager.getRingerMode() > 0) {
            AppMethodBeat.o(149160);
            return true;
        }
        AppMethodBeat.o(149160);
        return false;
    }

    @Override // com.tencent.mm.plugin.forcenotify.b.a
    public final void start() {
        AppMethodBeat.i(149161);
        super.start();
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eis().a(213, this);
        com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af2, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).eis().a(214, this);
        a aVar = a.wLU;
        Log.i("MicroMsg.ForceNotifyStorage", "deleteGameLife()");
        if (a.iFy.delete("ForceNotifyData", "UserName like ? ", new String[]{"%@gamelifesess"}) >= 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, d> entry : a.wLT.entrySet()) {
                String str = entry.getValue().field_UserName;
                p.g(str, "it.value.field_UserName");
                if (n.nm(str, "@gamelifesess")) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                a.wLT.remove(((d) entry2.getValue()).field_ForcePushId);
            }
            aVar.doNotify();
        }
        AppMethodBeat.o(149161);
    }

    @Override // com.tencent.mm.plugin.forcenotify.b.a
    public final void release() {
        AppMethodBeat.i(149162);
        super.release();
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eis().b(213, this);
        com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af2, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).eis().b(214, this);
        AppMethodBeat.o(149162);
    }

    public static ArrayList<d> dMo() {
        AppMethodBeat.i(149163);
        a aVar = a.wLU;
        ArrayList<d> dMq = a.dMq();
        AppMethodBeat.o(149163);
        return dMq;
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.b
    public final long axB(String str) {
        AppMethodBeat.i(149164);
        p.h(str, ch.COL_USERNAME);
        a aVar = a.wLU;
        String str2 = str + "@wxcontact";
        p.h(str2, "forcePushId");
        Log.i("MicroMsg.ForceNotifyStorage", "getExpiredTime(" + str2 + ')');
        d dVar = new d();
        dVar.field_ForcePushId = str2;
        if (aVar.get(dVar, new String[0])) {
            long j2 = dVar.field_ExpiredTime;
            AppMethodBeat.o(149164);
            return j2;
        }
        AppMethodBeat.o(149164);
        return 0;
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.b
    public final void axA(String str) {
        boolean z;
        AppMethodBeat.i(149165);
        if (str == null) {
            AppMethodBeat.o(149165);
        } else if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
            a.wLU.doNotify();
            AppMethodBeat.o(149165);
        } else {
            dd ddVar = new dd();
            ddVar.KHi = str + "@wxcontact";
            ddVar.KHj = 10800;
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service<IMessen…engerStorage::class.java)");
            ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eis().b(new k.a(213, ddVar));
            a aVar = a.wLU;
            String str2 = ddVar.KHi;
            p.g(str2, "opLog.ForcePushId");
            p.h(str, "userName");
            p.h(str2, "forcePushId");
            Log.i("MicroMsg.ForceNotifyStorage", "set(" + str + ", " + str2 + ')');
            d dVar = new d();
            dVar.field_UserName = str;
            dVar.field_ForcePushId = str2;
            dVar.field_CreateTime = cl.aWz();
            dVar.field_ExpiredTime = dVar.field_CreateTime + 10800000;
            dVar.field_Status = 1;
            if (a.iFy.replace("ForceNotifyData", "UserName", dVar.convertTo()) >= 0) {
                String str3 = dVar.field_ForcePushId;
                p.g(str3, "info.field_ForcePushId");
                a.wLT.put(str3, dVar);
                aVar.doNotify();
                z = true;
            } else {
                z = false;
            }
            Log.i(this.TAG, "[setting] " + str + " ret:%s", Boolean.valueOf(z));
            AppMethodBeat.o(149165);
        }
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.b
    public final void aS(String str, int i2) {
        AppMethodBeat.i(149166);
        if (str == null) {
            AppMethodBeat.o(149166);
        } else if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
            a.wLU.doNotify();
            AppMethodBeat.o(149166);
        } else {
            afo afo = new afo();
            afo.KHi = str;
            afo.scene = i2;
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service<IMessen…engerStorage::class.java)");
            ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eis().b(new k.a(214, afo));
            Log.i(this.TAG, "[delete] ".concat(String.valueOf(str)));
            AppMethodBeat.o(149166);
        }
    }

    @Override // com.tencent.mm.plugin.forcenotify.b.a
    public final void a(d dVar) {
        AppMethodBeat.i(261743);
        p.h(dVar, "notifyInfo");
        f.a aVar = f.UVX;
        f hVE = f.a.hVE();
        p.h(dVar, "info");
        if (!hVE.UVW.contains(dVar.field_ForcePushId)) {
            switch (dVar.field_Type) {
                case 0:
                    b bVar = b.UWP;
                    b.a(dVar, new f.c(hVE));
                    break;
            }
        } else {
            Log.i("ForceNotifyItemMgr", "add info failed, historyIdSet contains " + dVar.field_ForcePushId);
        }
        if (hVC()) {
            FC(false);
            AppMethodBeat.o(261743);
            return;
        }
        hVB();
        AppMethodBeat.o(261743);
    }

    @Override // com.tencent.mm.plugin.forcenotify.b.a
    public final void a(com.tencent.mm.plugin.forcenotify.c.g gVar) {
        AppMethodBeat.i(261744);
        p.h(gVar, "item");
        f.a aVar = f.UVX;
        f hVE = f.a.hVE();
        com.tencent.mm.plugin.forcenotify.c.g gVar2 = gVar;
        p.h(gVar2, "item");
        if (hVE.UVW.contains(gVar2.wMn)) {
            Log.i("ForceNotifyItemMgr", "add info failed, historyIdSet contains " + gVar2.wMn);
        } else {
            hVE.UVV.offer(gVar2);
            hVE.UVW.add(gVar2.wMn);
        }
        if (hVC()) {
            FC(false);
            AppMethodBeat.o(261744);
            return;
        }
        hVB();
        AppMethodBeat.o(261744);
    }

    @Override // com.tencent.mm.plugin.forcenotify.b.a
    public final void a(d dVar, boolean z) {
        boolean gC;
        AppMethodBeat.i(149169);
        p.h(dVar, "info");
        if (z) {
            a aVar = a.wLU;
            p.h(dVar, "info");
            Log.i("MicroMsg.ForceNotifyStorage", "set(" + dVar.field_ForcePushId + ')');
            if (a.iFy.replace("ForceNotifyData", "UserName", dVar.convertTo()) >= 0) {
                String str = dVar.field_ForcePushId;
                p.g(str, "info.field_ForcePushId");
                a.wLT.put(str, dVar);
                aVar.doNotify();
                gC = true;
            } else {
                gC = false;
            }
        } else {
            a aVar2 = a.wLU;
            String str2 = dVar.field_ForcePushId;
            p.g(str2, "info.field_ForcePushId");
            gC = aVar2.gC(str2);
        }
        Log.i(this.TAG, "[onNewXmlReceived] ret:%s isAdd:%s info:%s", Boolean.valueOf(gC), Boolean.valueOf(z), dVar);
        AppMethodBeat.o(149169);
    }

    private static void hVB() {
        AppMethodBeat.i(261745);
        b.a aVar = com.tencent.mm.plugin.forcenotify.ui.b.UWB;
        b.a.hVK().fkZ();
        AppMethodBeat.o(261745);
    }

    public final void FC(boolean z) {
        AppMethodBeat.i(261746);
        String topActivityName2 = Util.getTopActivityName2(MMApplicationContext.getContext());
        String simpleName = ForceNotifyShowUI.class.getSimpleName();
        p.g(simpleName, "ForceNotifyShowUI::class.java.simpleName");
        Log.i(this.TAG, "clazzName:" + simpleName + " topActivityName:" + topActivityName2);
        if (z || (!p.j(simpleName, topActivityName2))) {
            Log.i(this.TAG, "showNotifyActivity first show");
            Intent intent = new Intent(MMApplicationContext.getContext(), ForceNotifyShowUI.class);
            intent.addFlags(268435456);
            Log.i(this.TAG, "[notifyShow]");
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "showNotifyActivity", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "showNotifyActivity", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(261746);
            return;
        }
        Log.i(this.TAG, "showNotifyActivity add to pendingQueue");
        AppMethodBeat.o(261746);
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.b
    public final boolean byf(String str) {
        AppMethodBeat.i(261747);
        p.h(str, ch.COL_USERNAME);
        boolean axC = axC(str + "@wxcontact");
        AppMethodBeat.o(261747);
        return axC;
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.b
    public final boolean axC(String str) {
        AppMethodBeat.i(149174);
        p.h(str, "forcePushId");
        a aVar = a.wLU;
        boolean axC = a.axC(str);
        AppMethodBeat.o(149174);
        return axC;
    }

    private static boolean hVC() {
        AppMethodBeat.i(261748);
        Object systemService = MMApplicationContext.getContext().getSystemService("keyguard");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.KeyguardManager");
            AppMethodBeat.o(261748);
            throw tVar;
        }
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) systemService).inKeyguardRestrictedInputMode();
        AppMethodBeat.o(261748);
        return inKeyguardRestrictedInputMode;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.h.a
    public final void a(int i2, cxl cxl, k.b bVar) {
        AppMethodBeat.i(199475);
        p.h(bVar, "option");
        Log.i(this.TAG, "[onOpLogResult] ret:%s %s", Integer.valueOf(i2), bVar);
        if (bVar.getCmdId() == 213) {
            com.tencent.mm.bw.a eiR = bVar.eiR();
            if (eiR == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddForcePush");
                AppMethodBeat.o(199475);
                throw tVar;
            }
            dd ddVar = (dd) eiR;
            Log.i(this.TAG, "[onOpLogResult] AddForcePush ForcePushId:%s", ddVar.KHi);
            if (i2 != 0 || wLP) {
                a aVar = a.wLU;
                String str = ddVar.KHi;
                p.g(str, "oplog.ForcePushId");
                aVar.dc(str, -1);
                ((com.tencent.mm.plugin.forcenotify.a.a) g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).C(ddVar.KHi, 6, cl.aWz() / 1000);
                AppMethodBeat.o(199475);
                return;
            }
            a aVar2 = a.wLU;
            String str2 = ddVar.KHi;
            p.g(str2, "oplog.ForcePushId");
            aVar2.dc(str2, 1);
            ((com.tencent.mm.plugin.forcenotify.a.a) g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).C(ddVar.KHi, 1, cl.aWz() / 1000);
            AppMethodBeat.o(199475);
            return;
        }
        if (bVar.getCmdId() == 214) {
            com.tencent.mm.bw.a eiR2 = bVar.eiR();
            if (eiR2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.DelForcePush");
                AppMethodBeat.o(199475);
                throw tVar2;
            }
            afo afo = (afo) eiR2;
            int i3 = afo.scene;
            boolean z = false;
            if (i2 == 0) {
                ((com.tencent.mm.plugin.forcenotify.a.a) g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).C(afo.KHi, i3, cl.aWz() / 1000);
                a aVar3 = a.wLU;
                String str3 = afo.KHi;
                p.g(str3, "oplog.ForcePushId");
                z = aVar3.gC(str3);
            }
            Log.i(this.TAG, "[onOpLogResult] DelForcePush id:%s ret:%s isDeleteLocal:%s", afo.KHi, Integer.valueOf(i2), Boolean.valueOf(z));
        }
        AppMethodBeat.o(199475);
    }
}
