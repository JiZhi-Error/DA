package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Looper;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.v;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import java.util.List;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0014J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0006\u0010\u001e\u001a\u00020\u0014J \u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager;", "", "()V", "OFFLINE_SCAN_ENABLE", "", "TAG", "", "currentNetworkStatus", "", "onNetworkChange", "com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1;", "canUseOfflineScan", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFromScanUI", "checkNeedProcessOffline", "errType", "errCode", "clearOfflineScanMessage", "", "handleNetworkUnconnected", "context", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "showMsg", "needNotifyMessage", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "insertOfflineScanMessage", "content", "notifyMessage", "release", "showNetworkAlert", "Landroid/app/Activity;", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "plugin-scan_release"})
public final class b {
    private static int CTg = -1;
    private static final BinderC1679b CTh = new BinderC1679b();
    public static final b CTi = new b();

    static {
        AppMethodBeat.i(52487);
        AppMethodBeat.o(52487);
    }

    private b() {
    }

    public static final /* synthetic */ void aMP(String str) {
        AppMethodBeat.i(52488);
        aMO(str);
        AppMethodBeat.o(52488);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", UserDataStore.STATE, "", "plugin-scan_release"})
    /* renamed from: com.tencent.mm.plugin.scanner.util.b$b  reason: collision with other inner class name */
    public static final class BinderC1679b extends p.a {
        BinderC1679b() {
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.scanner.util.b$b$a */
        static final class a implements Runnable {
            public static final a CTk = new a();

            static {
                AppMethodBeat.i(52478);
                AppMethodBeat.o(52478);
            }

            a() {
            }

            public final void run() {
                AppMethodBeat.i(52477);
                t azz = g.azz();
                kotlin.g.b.p.g(azz, "MMKernel.getNetSceneQueue()");
                b bVar = b.CTi;
                Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan onNetworkChange netWorkStatus: %d, current: %d", Integer.valueOf(azz.aYS()), Integer.valueOf(b.CTg));
                t azz2 = g.azz();
                kotlin.g.b.p.g(azz2, "MMKernel.getNetSceneQueue()");
                if (azz2.aYS() != 6) {
                    t azz3 = g.azz();
                    kotlin.g.b.p.g(azz3, "MMKernel.getNetSceneQueue()");
                    if (azz3.aYS() != 4) {
                        b bVar2 = b.CTi;
                        t azz4 = g.azz();
                        kotlin.g.b.p.g(azz4, "MMKernel.getNetSceneQueue()");
                        b.CTg = azz4.aYS();
                        AppMethodBeat.o(52477);
                        return;
                    }
                }
                b bVar3 = b.CTi;
                int i2 = b.CTg;
                t azz5 = g.azz();
                kotlin.g.b.p.g(azz5, "MMKernel.getNetSceneQueue()");
                if (i2 == azz5.aYS()) {
                    AppMethodBeat.o(52477);
                    return;
                }
                b bVar4 = b.CTi;
                t azz6 = g.azz();
                kotlin.g.b.p.g(azz6, "MMKernel.getNetSceneQueue()");
                b.CTg = azz6.aYS();
                b bVar5 = b.CTi;
                b.eRQ();
                AppMethodBeat.o(52477);
            }
        }

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(52479);
            new MMHandler(Looper.getMainLooper()).post(a.CTk);
            AppMethodBeat.o(52479);
        }
    }

    public static void init() {
        AppMethodBeat.i(52480);
        Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager init enableOfflineScan: %b", Boolean.TRUE);
        g.aAg().a(CTh);
        AppMethodBeat.o(52480);
    }

    public static void release() {
        AppMethodBeat.i(52481);
        Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager release");
        g.aAg().a(CTh);
        AppMethodBeat.o(52481);
    }

    public static boolean uk(boolean z) {
        return z;
    }

    public static boolean o(q qVar) {
        AppMethodBeat.i(52482);
        kotlin.g.b.p.h(qVar, "scene");
        if (qVar.getType() == 233 || qVar.getType() == 106 || qVar.getType() == 1061) {
            AppMethodBeat.o(52482);
            return true;
        }
        AppMethodBeat.o(52482);
        return false;
    }

    public static void a(OfflineScanContext offlineScanContext, String str, boolean z) {
        String str2;
        AppMethodBeat.i(52483);
        kotlin.g.b.p.h(offlineScanContext, "context");
        kotlin.g.b.p.h(str, "showMsg");
        Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan handleNetworkUnconnected needNotifyMessage: %b, context: %s, time: %d", Boolean.valueOf(z), offlineScanContext, Long.valueOf(offlineScanContext.timestamp));
        OfflineScanContext.a aVar = OfflineScanContext.CREATOR;
        String a2 = OfflineScanContext.a.a(offlineScanContext);
        if (z) {
            aMO(a2);
            AppMethodBeat.o(52483);
            return;
        }
        e aAh = g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_OFFLINE_SCAN_LOCAL_STORAGE_STRING_SYNC, "");
        if (obj == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(52483);
            throw tVar;
        }
        String str3 = (String) obj;
        if (str3.length() > 0) {
            str2 = str3 + "," + a2;
        } else {
            str2 = a2;
        }
        Log.i("MicroMsg.OfflineScanManager", "alvinluo handleNetworkUnconnected toSave string length: %d", Integer.valueOf(str2.length()));
        e aAh2 = g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_OFFLINE_SCAN_LOCAL_STORAGE_STRING_SYNC, str2);
        AppMethodBeat.o(52483);
    }

    public static void k(Activity activity, String str) {
        AppMethodBeat.i(52484);
        kotlin.g.b.p.h(activity, "context");
        kotlin.g.b.p.h(str, "showMsg");
        h.a(activity, str, "", activity.getString(R.string.w1), (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(52484);
    }

    public static boolean b(int i2, q qVar) {
        AppMethodBeat.i(52485);
        kotlin.g.b.p.h(qVar, "scene");
        if ((qVar.getType() == 233 || qVar.getType() == 106 || qVar.getType() == 1061) && (i2 == 1 || i2 == 2 || i2 == 7 || i2 == 8 || i2 == 3 || i2 == 9)) {
            AppMethodBeat.o(52485);
            return true;
        }
        AppMethodBeat.o(52485);
        return false;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ Object CTj;

        a(Object obj) {
            this.CTj = obj;
        }

        public final void run() {
            AppMethodBeat.i(52476);
            Object obj = this.CTj;
            if (obj == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(52476);
                throw tVar;
            }
            List<String> a2 = n.a((String) obj, new String[]{","});
            Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyMessage localStr: %d, context size: %d", Integer.valueOf(((String) this.CTj).length()), Integer.valueOf(a2.size()));
            for (T t : a2) {
                if (t.length() > 0) {
                    b bVar = b.CTi;
                    b.aMP(t);
                } else {
                    Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyOfflineScanMessage context is empty, ignore");
                }
            }
            b bVar2 = b.CTi;
            b.eRO();
            AppMethodBeat.o(52476);
        }
    }

    private static void aMO(String str) {
        AppMethodBeat.i(52486);
        Log.i("MicroMsg.OfflineScanManager", "alvinluo insertOfflineScanMessage");
        ca caVar = new ca();
        caVar.Cy("notifymessage");
        caVar.nv(0);
        caVar.setStatus(3);
        caVar.setType(721420337);
        caVar.setCreateTime(bp.aVP());
        caVar.setContent(str);
        bp.x(caVar);
        v vVar = new v();
        vVar.dCL.dCM = caVar;
        EventCenter.instance.publish(vVar);
        AppMethodBeat.o(52486);
    }

    public static final /* synthetic */ void eRO() {
        AppMethodBeat.i(52489);
        Log.i("MicroMsg.OfflineScanManager", "alvinluo clearOfflineScanMessage");
        e aAh = g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_OFFLINE_SCAN_LOCAL_STORAGE_STRING_SYNC, (Object) null);
        AppMethodBeat.o(52489);
    }

    public static final /* synthetic */ void eRQ() {
        AppMethodBeat.i(52490);
        Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyMessage");
        if (!g.aAc()) {
            Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyMessage account not ready and ignore");
            AppMethodBeat.o(52490);
            return;
        }
        e aAh = g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        Object i2 = aAh.azQ().i(ar.a.USERINFO_OFFLINE_SCAN_LOCAL_STORAGE_STRING_SYNC);
        if (i2 == null) {
            Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyOfflineScanMessage no message, ignore");
            AppMethodBeat.o(52490);
            return;
        }
        com.tencent.f.h.RTc.aX(new a(i2));
        AppMethodBeat.o(52490);
    }
}
