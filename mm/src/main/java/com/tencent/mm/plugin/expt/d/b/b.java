package com.tencent.mm.plugin.expt.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.d.f.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.g;

public class b implements c, com.tencent.mm.kernel.b.c {
    private static volatile b sxL;
    private Map<String, com.tencent.mm.plugin.expt.d.e.a.b> sxM = new HashMap();
    public Map<String, com.tencent.mm.plugin.expt.d.e.a.c> sxN = new HashMap();
    private MMHandler sxO = new MMHandler("EdgeComputingConfigService#mParseConfigHandler");
    private a sxP = new a();
    public c sxQ;
    private final IListener sxR = new IListener<ue>() {
        /* class com.tencent.mm.plugin.expt.d.b.b.AnonymousClass1 */

        {
            AppMethodBeat.i(220298);
            this.__eventId = ue.class.getName().hashCode();
            AppMethodBeat.o(220298);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ue ueVar) {
            AppMethodBeat.i(220299);
            final ue ueVar2 = ueVar;
            b.this.sxO.post(new Runnable() {
                /* class com.tencent.mm.plugin.expt.d.b.b.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(220297);
                    if (ueVar2 == null || ueVar2.eaA == null || ueVar2.eaA.eaB == 0) {
                        AppMethodBeat.o(220297);
                        return;
                    }
                    String valueOf = String.valueOf(ueVar2.eaA.eaB);
                    Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] mSessionPageConfigChangeEvent configID : " + valueOf + ", isDel : " + ueVar2.eaA.eaz);
                    if (ueVar2.eaA.eaz.booleanValue()) {
                        a.k(valueOf, 2, 0);
                    } else {
                        a.k(valueOf, 1, 0);
                    }
                    synchronized (b.this.sxM) {
                        try {
                            if (ueVar2.eaA.eaz.booleanValue()) {
                                if (b.this.sxM.containsKey(valueOf)) {
                                    com.tencent.mm.plugin.expt.d.e.a.b bVar = (com.tencent.mm.plugin.expt.d.e.a.b) b.this.sxM.remove(valueOf);
                                    if (!(bVar == null || b.this.sxQ == null)) {
                                        b.this.sxQ.b(bVar);
                                    }
                                } else {
                                    return;
                                }
                            } else if (g.eP(ueVar2.eaA.dNA)) {
                                AppMethodBeat.o(220297);
                                return;
                            } else {
                                com.tencent.mm.plugin.expt.d.e.a.b bVar2 = (com.tencent.mm.plugin.expt.d.e.a.b) b.this.sxM.get(valueOf);
                                if (bVar2 == null || !g.equals(bVar2.syr, ueVar2.eaA.dNA)) {
                                    com.tencent.mm.plugin.expt.d.e.a.b gl = b.this.sxP.gl(valueOf, ueVar2.eaA.dNA);
                                    if (gl == null) {
                                        AppMethodBeat.o(220297);
                                        return;
                                    }
                                    b.this.sxM.put(gl.syg, gl);
                                    if (b.this.sxQ != null) {
                                        b.this.sxQ.a(gl);
                                    }
                                } else {
                                    b.this.sxQ.c(bVar2);
                                    AppMethodBeat.o(220297);
                                    return;
                                }
                            }
                            b.d(b.this);
                            AppMethodBeat.o(220297);
                        } finally {
                            AppMethodBeat.o(220297);
                        }
                    }
                }
            });
            AppMethodBeat.o(220299);
            return false;
        }
    };
    private final IListener sxS = new IListener<uf>() {
        /* class com.tencent.mm.plugin.expt.d.b.b.AnonymousClass2 */

        {
            AppMethodBeat.i(220301);
            this.__eventId = uf.class.getName().hashCode();
            AppMethodBeat.o(220301);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uf ufVar) {
            AppMethodBeat.i(220302);
            final uf ufVar2 = ufVar;
            b.this.sxO.post(new Runnable() {
                /* class com.tencent.mm.plugin.expt.d.b.b.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(220300);
                    if (ufVar2 == null || ufVar2.eaC == null || ufVar2.eaC.eaB == 0) {
                        AppMethodBeat.o(220300);
                        return;
                    }
                    String valueOf = String.valueOf(ufVar2.eaC.eaB);
                    Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] mSessionEdgeSqlChangeEvent configID : " + valueOf + ", isDel : " + ufVar2.eaC.eaz);
                    if (ufVar2.eaC.eaz.booleanValue()) {
                        a.k(valueOf, 9, 0);
                    } else {
                        a.k(valueOf, 8, 0);
                    }
                    synchronized (b.this.sxN) {
                        try {
                            if (ufVar2.eaC.eaz.booleanValue()) {
                                if (b.this.sxN.containsKey(valueOf)) {
                                    com.tencent.mm.plugin.expt.d.e.a.c cVar = (com.tencent.mm.plugin.expt.d.e.a.c) b.this.sxN.remove(valueOf);
                                    if (!(cVar == null || b.this.sxQ == null)) {
                                        b.this.sxQ.b(cVar);
                                    }
                                } else {
                                    return;
                                }
                            } else if (g.eP(ufVar2.eaC.dNA)) {
                                AppMethodBeat.o(220300);
                                return;
                            } else {
                                com.tencent.mm.plugin.expt.d.e.a.c cVar2 = (com.tencent.mm.plugin.expt.d.e.a.c) b.this.sxN.get(valueOf);
                                if (cVar2 == null || !g.equals(cVar2.syr, ufVar2.eaC.dNA)) {
                                    a unused = b.this.sxP;
                                    com.tencent.mm.plugin.expt.d.e.a.c gm = a.gm(valueOf, ufVar2.eaC.dNA);
                                    if (gm == null) {
                                        AppMethodBeat.o(220300);
                                        return;
                                    }
                                    b.this.sxN.put(gm.syg, gm);
                                    if (b.this.sxQ != null) {
                                        b.this.sxQ.a(gm);
                                    }
                                } else {
                                    b.this.sxQ.c(cVar2);
                                    AppMethodBeat.o(220300);
                                    return;
                                }
                            }
                            b.g(b.this);
                            AppMethodBeat.o(220300);
                        } finally {
                            AppMethodBeat.o(220300);
                        }
                    }
                }
            });
            AppMethodBeat.o(220302);
            return false;
        }
    };

    static /* synthetic */ void g(b bVar) {
        AppMethodBeat.i(220312);
        bVar.cMW();
        AppMethodBeat.o(220312);
    }

    public static b cMS() {
        AppMethodBeat.i(220303);
        if (sxL == null) {
            synchronized (b.class) {
                try {
                    if (sxL == null) {
                        sxL = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(220303);
                    throw th;
                }
            }
        }
        b bVar = sxL;
        AppMethodBeat.o(220303);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(220304);
        cMT();
        EventCenter.instance.add(this.sxR);
        EventCenter.instance.add(this.sxS);
        AppMethodBeat.o(220304);
    }

    private void cMT() {
        AppMethodBeat.i(220305);
        StringBuilder sb = new StringBuilder("[EdgeComputingConfigService] initConfig, uin : ");
        d.cRY();
        Log.i("EdgeComputingConfigService", sb.append(d.getUin()).toString());
        MultiProcessMMKV cMP = com.tencent.mm.plugin.expt.d.b.cMP();
        if (cMP == null) {
            AppMethodBeat.o(220305);
            return;
        }
        byte[] decodeBytes = cMP.decodeBytes("mmkv_key_script_config_container");
        if (decodeBytes != null && decodeBytes.length > 0) {
            aik aik = new aik();
            try {
                aik.parseFrom(decodeBytes);
                Map<String, com.tencent.mm.plugin.expt.d.e.a.b> a2 = com.tencent.mm.plugin.expt.d.e.c.a(aik);
                if (a2 != null) {
                    Iterator<com.tencent.mm.plugin.expt.d.e.a.b> it = a2.values().iterator();
                    while (it.hasNext()) {
                        Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] initConfig, scriptConfigModel configID : " + it.next().syg);
                    }
                    this.sxM = a2;
                }
            } catch (Exception e2) {
                Log.e("EdgeComputingConfigService", "[EdgeComputingConfigService] initConfig parse script config throw Exception : " + e2.getMessage());
            }
        }
        byte[] decodeBytes2 = cMP.decodeBytes("mmkv_key_sql_config_container");
        if (decodeBytes2 != null && decodeBytes2.length > 0) {
            aim aim = new aim();
            try {
                aim.parseFrom(decodeBytes2);
                Map<String, com.tencent.mm.plugin.expt.d.e.a.c> a3 = com.tencent.mm.plugin.expt.d.e.c.a(aim);
                if (a3 != null) {
                    Iterator<com.tencent.mm.plugin.expt.d.e.a.c> it2 = a3.values().iterator();
                    while (it2.hasNext()) {
                        Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] initConfig, sqlConfigModel configID : " + it2.next().syg);
                    }
                    this.sxN = a3;
                }
                AppMethodBeat.o(220305);
                return;
            } catch (Exception e3) {
                Log.e("EdgeComputingConfigService", "[EdgeComputingConfigService] initConfig parse sql config throw Exception : " + e3.getMessage());
            }
        }
        AppMethodBeat.o(220305);
    }

    public final List<com.tencent.mm.plugin.expt.d.e.a.b> cMU() {
        AppMethodBeat.i(220306);
        ArrayList arrayList = new ArrayList();
        synchronized (this.sxM) {
            try {
                for (com.tencent.mm.plugin.expt.d.e.a.b bVar : this.sxM.values()) {
                    arrayList.add(bVar);
                }
            } finally {
                AppMethodBeat.o(220306);
            }
        }
        return arrayList;
    }

    public final List<com.tencent.mm.plugin.expt.d.e.a.c> cMV() {
        AppMethodBeat.i(220307);
        ArrayList arrayList = new ArrayList();
        synchronized (this.sxN) {
            try {
                for (com.tencent.mm.plugin.expt.d.e.a.c cVar : this.sxN.values()) {
                    arrayList.add(cVar);
                }
            } finally {
                AppMethodBeat.o(220307);
            }
        }
        return arrayList;
    }

    public final void cMW() {
        MultiProcessMMKV cMP;
        AppMethodBeat.i(220308);
        aim ae = com.tencent.mm.plugin.expt.d.e.c.ae(this.sxN);
        if (!(ae == null || (cMP = com.tencent.mm.plugin.expt.d.b.cMP()) == null)) {
            try {
                Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] mSessionEdgeSqlChangeEvent encode mmkvEncode : ".concat(String.valueOf(cMP.encode("mmkv_key_sql_config_container", ae.toByteArray()))));
                AppMethodBeat.o(220308);
                return;
            } catch (IOException e2) {
                Log.e("EdgeComputingConfigService", "[EdgeComputingConfigService] mSessionEdgeSqlChangeEvent encode throw IOException : " + e2.getMessage());
            }
        }
        AppMethodBeat.o(220308);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(220309);
        StringBuilder sb = new StringBuilder("[EdgeComputingConfigService] onAccountInitialized, uin : ");
        d.cRY();
        Log.i("EdgeComputingConfigService", sb.append(d.getUin()).toString());
        this.sxM = new HashMap();
        this.sxN = new HashMap();
        cMT();
        AppMethodBeat.o(220309);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(220310);
        StringBuilder sb = new StringBuilder("[EdgeComputingConfigService] onAccountRåelease, uin : ");
        d.cRY();
        Log.i("EdgeComputingConfigService", sb.append(d.getUin()).toString());
        this.sxM = new HashMap();
        this.sxN = new HashMap();
        AppMethodBeat.o(220310);
    }

    static /* synthetic */ void d(b bVar) {
        aik aik;
        MultiProcessMMKV cMP;
        AppMethodBeat.i(220311);
        Map<String, com.tencent.mm.plugin.expt.d.e.a.b> map = bVar.sxM;
        if (map == null || map.size() <= 0) {
            aik = null;
        } else {
            aik aik2 = new aik();
            for (com.tencent.mm.plugin.expt.d.e.a.b bVar2 : map.values()) {
                aij aij = new aij();
                aij.syg = bVar2.syg;
                aij.syj = bVar2.syj;
                aij.syk = bVar2.syk;
                aij.syl = bVar2.syl;
                aij.syn = bVar2.syn;
                aij.syo = bVar2.syo;
                aij.syp = bVar2.syp;
                aij.syq = bVar2.syq;
                aij.script = bVar2.script;
                aij.sys = bVar2.sys;
                aij.syr = bVar2.syr;
                for (com.tencent.mm.plugin.expt.d.e.a.a aVar : bVar2.sym) {
                    aii aii = new aii();
                    aii.index = aVar.index;
                    aii.name = aVar.name;
                    aii.type = aVar.type;
                    aij.LrQ.add(aii);
                }
                aik2.LrR.add(aij);
            }
            aik = aik2;
        }
        if (!(aik == null || (cMP = com.tencent.mm.plugin.expt.d.b.cMP()) == null)) {
            try {
                Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] mSessionPageConfigChangeEvent encode mmkvEncode : ".concat(String.valueOf(cMP.encode("mmkv_key_script_config_container", aik.toByteArray()))));
                AppMethodBeat.o(220311);
                return;
            } catch (IOException e2) {
                Log.e("EdgeComputingConfigService", "[EdgeComputingConfigService] mSessionPageConfigChangeEvent encode throw IOException : " + e2.getMessage());
            }
        }
        AppMethodBeat.o(220311);
    }
}
