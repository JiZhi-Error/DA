package com.tencent.mm.model.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c.a;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.b;
import com.tencent.mm.storage.c;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Map;

public class d implements bd {
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, h.b> baseDBFactories;
    private com.tencent.mm.storage.d iHn;
    private b iHo;
    private cj.a iHp = new cj.a() {
        /* class com.tencent.mm.model.c.d.AnonymousClass1 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(153124);
            String a2 = z.a(aVar.heO.KHn);
            Log.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s".concat(String.valueOf(a2)));
            a.C0444a Ld = a.Ld(a2);
            if (Ld == null) {
                AppMethodBeat.o(153124);
                return;
            }
            d.aXu().H(Ld.iHf, 1);
            d.aXv().H(Ld.iHg, 2);
            AppMethodBeat.o(153124);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private IListener iHq = new IListener<com.tencent.mm.g.a.d>() {
        /* class com.tencent.mm.model.c.d.AnonymousClass2 */

        {
            AppMethodBeat.i(161762);
            this.__eventId = com.tencent.mm.g.a.d.class.getName().hashCode();
            AppMethodBeat.o(161762);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.d dVar) {
            AppMethodBeat.i(153125);
            if (dVar.dBP.dBQ) {
                b.aXm();
            }
            AppMethodBeat.o(153125);
            return true;
        }
    };
    private MStorage.IOnStorageChange iHr = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.model.c.d.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(153126);
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                c Fu = d.aXu().Fu("100205");
                if (Fu.isValid()) {
                    Map<String, String> gzz = Fu.gzz();
                    int i2 = Util.getInt(gzz.get("main_thread_watch_enable"), 65535);
                    int i3 = Util.getInt(gzz.get("main_thread_watch_timeout"), 5000);
                    int i4 = Util.getInt(gzz.get("main_thread_watch_log_loop"), 0);
                    int i5 = Util.getInt(gzz.get("main_thread_watch_report"), 0);
                    MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", g.aps()).edit().putInt("main_thread_watch_enable", i2).putInt("main_thread_watch_timeout", i3).putInt("main_thread_watch_log_loop", i4).putInt("main_thread_watch_report", i5).commit();
                    Log.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                }
                d.aXw();
            }
            AppMethodBeat.o(153126);
        }
    };
    private com.tencent.mm.vending.b.b iHs = null;
    private final com.tencent.mm.plugin.auth.a.b iHt = new com.tencent.mm.plugin.auth.a.b() {
        /* class com.tencent.mm.model.c.d.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.auth.a.b
        public final void a(j.h hVar, j.i iVar, boolean z) {
            AppMethodBeat.i(153127);
            if (z) {
                if (hVar != null && (hVar instanceof j.a) && hVar.getSceneStatus() == 12) {
                    b.aXn();
                    AppMethodBeat.o(153127);
                    return;
                }
            } else if (hVar != null && hVar.getSceneStatus() == 16) {
                b.aXn();
            }
            AppMethodBeat.o(153127);
        }

        @Override // com.tencent.mm.plugin.auth.a.b
        public final void a(x.b bVar, String str, int i2, String str2, String str3, int i3) {
        }
    };

    public d() {
        AppMethodBeat.i(153128);
        AppMethodBeat.o(153128);
    }

    private static synchronized d aXt() {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(153129);
            dVar = (d) y.at(d.class);
            AppMethodBeat.o(153129);
        }
        return dVar;
    }

    public static com.tencent.mm.storage.d aXu() {
        AppMethodBeat.i(153130);
        com.tencent.mm.kernel.g.aAf().azk();
        if (aXt().iHn == null) {
            aXt().iHn = new com.tencent.mm.storage.d(com.tencent.mm.kernel.g.aAh().hqK);
        }
        com.tencent.mm.storage.d dVar = aXt().iHn;
        AppMethodBeat.o(153130);
        return dVar;
    }

    public static b aXv() {
        AppMethodBeat.i(153131);
        com.tencent.mm.kernel.g.aAf().azk();
        if (aXt().iHo == null) {
            aXt().iHo = new b(com.tencent.mm.kernel.g.aAh().hqK);
        }
        b bVar = aXt().iHo;
        AppMethodBeat.o(153131);
        return bVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(153132);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("newabtest", this.iHp, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("newabtestinfo", this.iHp, true);
        EventCenter.instance.addListener(this.iHq);
        aXu().add(this.iHr);
        this.iHs = ((com.tencent.mm.plugin.auth.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(this.iHt);
        AppMethodBeat.o(153132);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(153133);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("newabtest", this.iHp, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("newabtestinfo", this.iHp, true);
        EventCenter.instance.removeListener(this.iHq);
        aXu().remove(this.iHr);
        if (this.iHs != null) {
            this.iHs.dead();
            this.iHs = null;
        }
        AppMethodBeat.o(153133);
    }

    static {
        AppMethodBeat.i(153135);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.model.c.d.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.storage.d.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.model.c.d.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(153135);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    static /* synthetic */ void aXw() {
        AppMethodBeat.i(153134);
        c Fu = aXu().Fu("100229");
        if (Fu.isValid()) {
            Map<String, String> gzz = Fu.gzz();
            int i2 = Util.getInt(gzz.get("UseSvrTime"), 0);
            int i3 = Util.getInt(gzz.get("MinDiffTime"), 0);
            MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", g.aps()).edit().putInt("client_server_diff_time_enable", i2).putInt("client_server_diff_time_interval", i3).commit();
            Log.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time enable[%d] diffTime[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(153134);
            return;
        }
        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", g.aps()).edit().remove("client_server_diff_time_enable").remove("client_server_diff_time_interval").commit();
        Log.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time abtest is not valid, then delete data");
        AppMethodBeat.o(153134);
    }
}
