package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class k implements i, bd {
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    ConcurrentHashMap<Integer, z> zjD = new ConcurrentHashMap<>();
    private boolean zjE = false;
    private cj.a zjF = new cj.a() {
        /* class com.tencent.mm.plugin.mall.a.k.AnonymousClass1 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(66013);
            final String a2 = com.tencent.mm.platformtools.z.a(aVar.heO.KHn);
            Log.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(a2)));
            k.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.mall.a.k.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(66012);
                    c fSg = c.fSg();
                    String str = a2;
                    MallNews aVw = c.aVw(str);
                    if (aVw != null) {
                        if (!"2".equals(aVw.type)) {
                            fSg.Icv.put(aVw.iLU, aVw);
                            Log.i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(str)));
                            fSg.eDw();
                            if (c.a(aVw)) {
                                Log.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                                AppMethodBeat.o(66012);
                                return;
                            }
                            if (aVw.dDG == 0) {
                                Log.d("MicroMsg.MallNewsManager", "showType New");
                                com.tencent.mm.y.c.axV().A(262156, true);
                                g.aAi();
                                g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                            } else if (aVw.dDG == 1) {
                                Log.d("MicroMsg.MallNewsManager", "showType Dot");
                                com.tencent.mm.y.c.axV().B(262156, true);
                                g.aAi();
                                g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                            }
                            c.fSi();
                            AppMethodBeat.o(66012);
                            return;
                        }
                        Log.d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(aVw)));
                        MallNews mallNews = fSg.Icv.get(aVw.iLU);
                        if (mallNews == null || !mallNews.FJm.equals(aVw.FJm) || !mallNews.dHx.equals(aVw.dHx)) {
                            Log.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
                        } else {
                            Log.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + aVw.iLU);
                            fSg.Icv.remove(aVw.iLU);
                            AppMethodBeat.o(66012);
                            return;
                        }
                    }
                    AppMethodBeat.o(66012);
                }
            });
            AppMethodBeat.o(66013);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private cj.a zjG = new cj.a() {
        /* class com.tencent.mm.plugin.mall.a.k.AnonymousClass2 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(66015);
            final String a2 = com.tencent.mm.platformtools.z.a(aVar.heO.KHn);
            Log.d("MicroMsg.SubCoreMall", "receive pay msg: %s", a2);
            k.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.mall.a.k.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(66014);
                    c.fSg();
                    c.aVt(a2);
                    AppMethodBeat.o(66014);
                }
            });
            AppMethodBeat.o(66015);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };

    public k() {
        AppMethodBeat.i(66016);
        AppMethodBeat.o(66016);
    }

    public static k egL() {
        AppMethodBeat.i(66017);
        k kVar = (k) y.at(k.class);
        AppMethodBeat.o(66017);
        return kVar;
    }

    public final ArrayList<MallFunction> Qe(int i2) {
        AppMethodBeat.i(66019);
        ArrayList<MallFunction> arrayList = Qd(i2).zjo;
        AppMethodBeat.o(66019);
        return arrayList;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(66020);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("mallactivity", this.zjF, true);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.zjG, true);
        c.fSg().amZ();
        d.fSk().amZ();
        if (!com.tencent.mm.model.z.aUo() || !com.tencent.mm.model.z.aUj()) {
            b.aeM(b.Icj);
        } else {
            b.aeM(b.Ick);
        }
        g.aAi();
        g.aAg().hqi.a(302, this);
        AppMethodBeat.o(66020);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(66021);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("mallactivity", this.zjF, true);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.zjG, true);
        g.aAi();
        g.aAg().hqi.b(302, this);
        AppMethodBeat.o(66021);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(66022);
        if (i3 == 0 && i2 == 0 && !this.zjE && com.tencent.mm.model.z.aUo()) {
            this.zjE = true;
            b.aeM(b.Ick);
        }
        AppMethodBeat.o(66022);
    }

    public final z Qd(int i2) {
        z zVar = null;
        AppMethodBeat.i(66018);
        if (!this.zjD.contains(Integer.valueOf(i2))) {
            f fQN = t.fQN();
            String concat = "select * from WalletFunciontList where wallet_region = ".concat(String.valueOf(i2));
            Cursor rawQuery = fQN.db.rawQuery(concat, null, 2);
            Log.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo ".concat(String.valueOf(concat)));
            if (rawQuery != null) {
                if (rawQuery.moveToNext()) {
                    zVar = new z();
                    zVar.convertFrom(rawQuery);
                }
                rawQuery.close();
            }
            if (zVar != null) {
                this.zjD.put(Integer.valueOf(i2), zVar);
            }
        }
        z zVar2 = this.zjD.get(Integer.valueOf(i2));
        if (zVar2 == null) {
            z zVar3 = new z();
            AppMethodBeat.o(66018);
            return zVar3;
        }
        AppMethodBeat.o(66018);
        return zVar2;
    }
}
