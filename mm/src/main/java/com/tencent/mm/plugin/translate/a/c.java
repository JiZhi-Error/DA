package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bp;
import com.tencent.mm.protocal.protobuf.eks;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class c implements a {
    public final d[] Gtl;
    public Queue<C1840c> Gtm;
    public HashMap<String, Integer> Gtn;
    public int gVP;
    public ArrayList<a> listeners;

    public interface a {
        void a(int i2, SparseArray<C1840c> sparseArray);
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public static final class b {
        public static final c Gto = new c((byte) 0);

        static {
            AppMethodBeat.i(29742);
            AppMethodBeat.o(29742);
        }
    }

    private c() {
        AppMethodBeat.i(29744);
        this.gVP = 0;
        this.listeners = new ArrayList<>(1);
        this.Gtm = new LinkedList();
        this.Gtn = new HashMap<>();
        this.Gtl = new d[1];
        AppMethodBeat.o(29744);
    }

    private void b(int i2, SparseArray<C1840c> sparseArray) {
        AppMethodBeat.i(29745);
        Iterator<a> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().a(i2, sparseArray);
        }
        AppMethodBeat.o(29745);
    }

    public final void fAo() {
        AppMethodBeat.i(29746);
        Log.d("MicroMsg.TranslateServiceManager", "current waitings : %s", Integer.valueOf(this.Gtm.size()));
        if (this.Gtm.size() == 0) {
            AppMethodBeat.o(29746);
            return;
        }
        if (this.gVP <= this.Gtl.length) {
            for (int i2 = 0; i2 < this.Gtl.length; i2++) {
                if (this.Gtl[i2] == null) {
                    this.Gtl[i2] = new d(i2, this);
                    this.Gtl[i2].init();
                }
                if (!this.Gtl[i2].Gtt && this.Gtl[i2].e(this.Gtm)) {
                    this.gVP++;
                }
            }
        }
        AppMethodBeat.o(29746);
    }

    public final boolean aTM(String str) {
        AppMethodBeat.i(29747);
        boolean containsKey = this.Gtn.containsKey(str);
        AppMethodBeat.o(29747);
        return containsKey;
    }

    @Override // com.tencent.mm.plugin.translate.a.a
    public final void a(int i2, SparseArray<C1840c> sparseArray, LinkedList<eks> linkedList) {
        HashMap hashMap;
        AppMethodBeat.i(29748);
        this.gVP--;
        if (linkedList == null || sparseArray.size() != linkedList.size()) {
            Log.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
            HashMap hashMap2 = new HashMap();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                hashMap2.put(sparseArray.valueAt(i3).id, Integer.valueOf(sparseArray.valueAt(i3).Gtp));
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        if (linkedList != null) {
            Iterator<eks> it = linkedList.iterator();
            while (it.hasNext()) {
                eks next = it.next();
                C1840c cVar = sparseArray.get(next.NjV);
                if (cVar == null) {
                    Log.w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", Integer.valueOf(next.NjV), Integer.valueOf(next.Ret), Util.secPrint(next.NjY));
                } else {
                    String str = next.NjY;
                    if (cVar.type == 1) {
                        str = bp.aP(str, cVar.Gtq);
                        cVar.eeq = bp.aP(cVar.eeq, cVar.Gtq);
                    }
                    cVar.eez = str;
                    cVar.ret = next.Ret;
                    cVar.ecu = next.Myy;
                    cVar.fRc = (next.LRE == null || next.LRE.getBuffer() == null) ? null : next.LRE.getBufferToBytes();
                    cVar.eeA = next.NjZ;
                    this.Gtn.remove(cVar.id);
                    if (hashMap != null) {
                        hashMap.remove(cVar.id);
                    }
                }
            }
        } else {
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                C1840c valueAt = sparseArray.valueAt(i4);
                if (valueAt.type == 1) {
                    valueAt.eeq = bp.aP(valueAt.eeq, valueAt.Gtq);
                }
            }
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry entry : hashMap.entrySet()) {
                this.Gtn.remove(entry.getKey());
                Log.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", entry.getKey(), entry.getValue());
            }
        }
        b(i2, sparseArray);
        fAo();
        AppMethodBeat.o(29748);
    }

    /* renamed from: com.tencent.mm.plugin.translate.a.c$c  reason: collision with other inner class name */
    public static class C1840c {
        private static int Gtr = 0;
        public int Gtp;
        public String Gtq;
        public String ecu;
        public int eeA;
        public String eeq;
        public String eez;
        public byte[] fRc;
        public String id;
        public int ret;
        public String source;
        public int type;

        public C1840c(String str, String str2, int i2, String str3, byte[] bArr) {
            int Kp;
            String trim;
            AppMethodBeat.i(29743);
            this.eeq = str;
            this.id = str2;
            this.type = i2;
            this.source = str3;
            this.fRc = bArr;
            if (Gtr == Integer.MAX_VALUE) {
                Gtr = 0;
            }
            int i3 = Gtr + 1;
            Gtr = i3;
            this.Gtp = i3;
            if (i2 == 1 && (Kp = bp.Kp(str)) != -1 && (trim = str.substring(0, Kp).trim()) != null && trim.length() > 0) {
                this.Gtq = trim;
                this.eeq = str.substring(Kp + 1).trim();
            }
            AppMethodBeat.o(29743);
        }
    }
}
