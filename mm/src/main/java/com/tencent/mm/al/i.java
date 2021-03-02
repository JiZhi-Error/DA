package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.fbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i implements com.tencent.mm.ak.i {
    Object duI = new Object();
    public a iOj = new a((byte) 0);
    private boolean iOk = false;
    Set<String> iOl = new HashSet();
    public LinkedList<b> iOm = new LinkedList<>();

    public interface b {
        String aZT();

        void e(LinkedList<fbw> linkedList);
    }

    public i() {
        AppMethodBeat.i(124070);
        AppMethodBeat.o(124070);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(124071);
        synchronized (this.duI) {
            try {
                if (!this.iOm.contains(bVar)) {
                    Iterator<b> it = this.iOm.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (next != null && Util.nullAsNil(bVar.aZT()).equals(Util.nullAsNil(next.aZT()))) {
                            Log.i("MicroMsg.BizKFService", "the same callbacker %s, return", bVar.aZT());
                            return;
                        }
                    }
                    this.iOm.add(bVar);
                }
                AppMethodBeat.o(124071);
            } finally {
                AppMethodBeat.o(124071);
            }
        }
    }

    public final void b(b bVar) {
        AppMethodBeat.i(124072);
        synchronized (this.duI) {
            try {
                if (this.iOm.contains(bVar)) {
                    this.iOm.remove(bVar);
                }
            } finally {
                AppMethodBeat.o(124072);
            }
        }
    }

    public final void be(String str, String str2) {
        AppMethodBeat.i(124073);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
            AppMethodBeat.o(124073);
            return;
        }
        g.aAg().hqi.a(new ab(str, str2), 0);
        Log.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", str, Integer.valueOf(this.iOm.size()));
        AppMethodBeat.o(124073);
    }

    public final void j(String str, String str2, int i2) {
        AppMethodBeat.i(212167);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", str, str2);
            AppMethodBeat.o(212167);
        } else if (this.iOl.contains(str2)) {
            Log.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", str2);
            AppMethodBeat.o(212167);
        } else {
            this.iOl.add(str2);
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(i2));
            ad adVar = new ad(str, linkedList, linkedList2);
            adVar.tag = str2;
            g.aAg().hqi.a(adVar, 0);
            Log.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d, kfType: %d", str, str2, Integer.valueOf(this.iOm.size()), Integer.valueOf(i2));
            AppMethodBeat.o(212167);
        }
    }

    public final boolean sP(int i2) {
        if (i2 != 2) {
            return false;
        }
        return this.iOj.iOn;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(124075);
        Log.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar == null) {
            Log.e("MicroMsg.BizKFService", "scene == null");
            d(null);
            AppMethodBeat.o(124075);
        } else if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(qVar.getType()));
            j aYB = p.aYB();
            LinkedList<h> linkedList = new LinkedList<>();
            LinkedList<fbw> linkedList2 = null;
            long currentTimeMillis = System.currentTimeMillis();
            if (qVar.getType() == 672) {
                if (((ac) qVar).bad() == null) {
                    Log.e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(qVar.getType()));
                    d(null);
                    AppMethodBeat.o(124075);
                    return;
                }
                LinkedList<fbw> linkedList3 = ((ac) qVar).bad().MlC;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    Log.e("MicroMsg.BizKFService", "empty workers");
                    d(null);
                    AppMethodBeat.o(124075);
                    return;
                }
                Iterator<fbw> it = linkedList3.iterator();
                while (it.hasNext()) {
                    fbw next = it.next();
                    linkedList.add(new h(next.NxV, ((ac) qVar).brandUsername, next.xJE, next.Nickname, next.NxW, currentTimeMillis));
                    if (aYB != null) {
                        com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                        iVar.username = next.NxV;
                        iVar.iKW = next.xJE;
                        iVar.fv(false);
                        iVar.fuz = 3;
                        aYB.b(iVar);
                        p.aYD().Mh(next.NxV);
                    }
                }
                linkedList2 = linkedList3;
            } else if (qVar.getType() == 675) {
                this.iOl.remove(((ad) qVar).tag);
                if (((ad) qVar).bae() == null) {
                    Log.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", Integer.valueOf(qVar.getType()));
                    d(null);
                    AppMethodBeat.o(124075);
                    return;
                }
                LinkedList<fbw> linkedList4 = ((ad) qVar).bae().MlC;
                if (linkedList4 == null || linkedList4.size() <= 0) {
                    Log.e("MicroMsg.BizKFService", "empty workers");
                    d(null);
                    AppMethodBeat.o(124075);
                    return;
                }
                Iterator<fbw> it2 = linkedList4.iterator();
                while (it2.hasNext()) {
                    fbw next2 = it2.next();
                    Log.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s, kfType: %d, headUrl: %s", next2.NxV, ((ad) qVar).tag, Integer.valueOf(next2.NxW), next2.xJE);
                    linkedList.add(new h(next2.NxV, ((ad) qVar).brandUsername, next2.xJE, next2.Nickname, next2.NxW, currentTimeMillis));
                    if (aYB != null) {
                        com.tencent.mm.aj.i iVar2 = new com.tencent.mm.aj.i();
                        iVar2.username = next2.NxV;
                        iVar2.iKW = next2.xJE;
                        iVar2.fv(false);
                        iVar2.fuz = 3;
                        aYB.b(iVar2);
                        p.aYD().Mh(next2.NxV);
                    }
                }
                linkedList2 = linkedList4;
            } else if (qVar.getType() == 674) {
                if (((ab) qVar).bac() == null) {
                    Log.e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(qVar.getType()));
                    d(null);
                    AppMethodBeat.o(124075);
                    return;
                }
                LinkedList<fbw> linkedList5 = ((ab) qVar).bac().MlC;
                if (linkedList5 == null || linkedList5.size() <= 0) {
                    Log.e("MicroMsg.BizKFService", "empty workers");
                    d(null);
                    AppMethodBeat.o(124075);
                    return;
                }
                Iterator<fbw> it3 = linkedList5.iterator();
                while (it3.hasNext()) {
                    fbw next3 = it3.next();
                    linkedList.add(new h(next3.NxV, ((ab) qVar).brandUsername, next3.xJE, next3.Nickname, next3.NxW, currentTimeMillis));
                    if (aYB != null) {
                        com.tencent.mm.aj.i iVar3 = new com.tencent.mm.aj.i();
                        iVar3.username = next3.NxV;
                        iVar3.iKW = next3.xJE;
                        iVar3.fv(false);
                        iVar3.fuz = 3;
                        aYB.b(iVar3);
                        p.aYD().Mh(next3.NxV);
                    }
                }
                linkedList2 = linkedList5;
            }
            Log.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", Integer.valueOf(ag.bag().f(linkedList)));
            d(linkedList2);
            AppMethodBeat.o(124075);
        } else {
            Log.e("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(qVar.getType()));
            d(null);
            if (qVar.getType() == 675) {
                this.iOl.remove(((ad) qVar).tag);
            }
            AppMethodBeat.o(124075);
        }
    }

    private void d(LinkedList<fbw> linkedList) {
        AppMethodBeat.i(124076);
        synchronized (this.duI) {
            try {
                ArrayList arrayList = new ArrayList(this.iOm);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    b bVar = (b) arrayList.get(i2);
                    if (bVar != null) {
                        bVar.e(linkedList);
                    }
                }
            } finally {
                AppMethodBeat.o(124076);
            }
        }
    }

    public final void aZS() {
        AppMethodBeat.i(212168);
        if (!this.iOk && g.af(f.class) != null) {
            Log.i("MicroMsg.BizKFService", "alvinluo checkAndPreloadKFGuideAppBrand");
            this.iOk = true;
            ((f) g.af(f.class)).a(z.KF_GUIDE);
        }
        AppMethodBeat.o(212168);
    }

    public static class a {
        public String appId;
        boolean iOn;
        public int iOo;
        public String path;

        private a() {
            this.iOn = false;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(212166);
            String str = "BizKFGuideAppBrandInfo{" + this.appId + ", " + this.path + ", " + this.iOo + ", " + this.iOn + "}";
            AppMethodBeat.o(212166);
            return str;
        }
    }
}
