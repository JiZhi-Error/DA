package com.tencent.mm.plugin.card.b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class m implements i, b.a {
    private MMHandler handler;
    public Map<String, Set<a>> pRR = new HashMap();
    public HashMap<String, String> pRS = new HashMap<>();
    private String pRT;
    public v pRU;

    public interface a {
        void a(boolean z, ArrayList<us> arrayList);
    }

    public m() {
        AppMethodBeat.i(112704);
        g.aAg().hqi.a(1058, this);
        this.handler = new MMHandler(Looper.getMainLooper());
        AppMethodBeat.o(112704);
    }

    public final void a(String str, a aVar) {
        AppMethodBeat.i(112705);
        synchronized (this.pRR) {
            try {
                if (this.pRR.get(str) != null) {
                    this.pRR.get(str).remove(aVar);
                }
            } catch (Exception e2) {
            }
            try {
            } finally {
                AppMethodBeat.o(112705);
            }
        }
        synchronized (this.pRS) {
            try {
                this.pRS.remove(str);
            } finally {
                AppMethodBeat.o(112705);
            }
        }
    }

    private void a(final String str, final boolean z, final ArrayList<us> arrayList) {
        AppMethodBeat.i(112706);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.card.b.m.AnonymousClass1 */

            public final void run() {
                Set<a> set;
                AppMethodBeat.i(112703);
                synchronized (m.this.pRR) {
                    try {
                        set = m.this.pRR.get(str);
                    } finally {
                        AppMethodBeat.o(112703);
                    }
                }
                if (set != null && set.size() > 0) {
                    HashSet<a> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (a aVar : hashSet) {
                        if (aVar != null) {
                            aVar.a(z, arrayList);
                        }
                    }
                }
            }
        });
        AppMethodBeat.o(112706);
    }

    public final boolean a(String str, String str2, a aVar) {
        boolean z;
        AppMethodBeat.i(112707);
        Log.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", str, str2);
        this.pRT = str;
        synchronized (this.pRR) {
            try {
                if (!this.pRR.containsKey(str)) {
                    this.pRR.put(str, new HashSet());
                }
                if (!this.pRR.get(str).contains(aVar)) {
                    this.pRR.get(str).add(aVar);
                }
            } finally {
                AppMethodBeat.o(112707);
            }
        }
        synchronized (this.pRS) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.pRS.put(str, str2);
                }
            } finally {
                AppMethodBeat.o(112707);
            }
        }
        d bca = d.bca();
        if (bca == null) {
            Log.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            z = false;
        } else {
            bca.b(this);
            z = true;
        }
        if (!z) {
            Log.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            AppMethodBeat.o(112707);
            return false;
        }
        if (this.pRU != null) {
            g.aAg().hqi.a(this.pRU);
        }
        return true;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112708);
        this.pRU = null;
        String str2 = ((v) qVar).pUf;
        Log.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", str2, Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ArrayList<us> arrayList = ((v) qVar).pUg;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            Log.d("MicroMsg.CardShopLBSManager", "onSceneEnd, respShopList size = %d", objArr);
            a(str2, true, arrayList);
            AppMethodBeat.o(112708);
            return;
        }
        Log.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
        a(str2, false, (ArrayList<us>) null);
        AppMethodBeat.o(112708);
    }

    @Override // com.tencent.mm.modelgeo.b.a
    public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
        Set<a> set;
        String str;
        AppMethodBeat.i(112709);
        if (!z) {
            AppMethodBeat.o(112709);
            return true;
        }
        d bca = d.bca();
        if (bca != null) {
            bca.c(this);
        }
        Log.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(d3));
        synchronized (this.pRR) {
            try {
                set = this.pRR.get(this.pRT);
            } finally {
                AppMethodBeat.o(112709);
            }
        }
        if (set == null || set.size() == 0) {
            Log.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
            AppMethodBeat.o(112709);
            return false;
        }
        synchronized (this.pRS) {
            try {
                str = this.pRS.get(this.pRT);
            } catch (Throwable th) {
                throw th;
            }
        }
        v vVar = new v(this.pRT, f2, f3, str);
        if (g.aAg().hqi.a(vVar, 0)) {
            this.pRU = vVar;
        } else {
            Log.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
            a(this.pRT, false, (ArrayList<us>) null);
        }
        AppMethodBeat.o(112709);
        return true;
    }
}
