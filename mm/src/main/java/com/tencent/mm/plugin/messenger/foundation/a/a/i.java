package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.e;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public interface i extends IStorage {

    public interface a {
        void a(i iVar, c cVar);
    }

    Cursor B(String str, long j2, long j3);

    Cursor C(String str, long j2, long j3);

    int D(String str, long j2, long j3);

    int E(String str, long j2, long j3);

    Cursor F(String str, long j2, long j3);

    int G(String str, long j2, long j3);

    Cursor G(String str, int i2, long j2);

    int H(String str, long j2, long j3);

    Cursor H(String str, int i2, long j2);

    ca Hb(long j2);

    int Hc(long j2);

    boolean Hd(long j2);

    boolean He(long j2);

    void Hf(long j2);

    Cursor I(String str, long j2, long j3);

    List<ca> J(String str, long j2, long j3);

    int Ku(String str);

    boolean Kv(String str);

    ca Qo(int i2);

    List<ca> Qp(int i2);

    Cursor a(String str, long j2, long j3, boolean z);

    void a(long j2, ca caVar);

    void a(a aVar);

    void a(a aVar, Looper looper);

    void a(b bVar);

    void a(c cVar);

    void a(e eVar);

    int aB(ca caVar);

    long aC(ca caVar);

    void aD(ca caVar);

    int aE(ca caVar);

    ca aEA(String str);

    List<ca> aEB(String str);

    Cursor aEC(String str);

    void aED(String str);

    int aEE(String str);

    int aEF(String str);

    Cursor aEG(String str);

    Cursor aEH(String str);

    ca.c aEI(String str);

    ca.d aEJ(String str);

    ca.a aEK(String str);

    ca.b aEL(String str);

    int aEM(String str);

    int aEN(String str);

    String aEO(String str);

    long aEP(String str);

    long aEQ(String str);

    long aER(String str);

    ca aES(String str);

    int aET(String str);

    List<ca> aEU(String str);

    long aEV(String str);

    Cursor aEW(String str);

    long aEX(String str);

    void aEs(String str);

    void aEt(String str);

    void aEu(String str);

    Cursor aEv(String str);

    ca aEw(String str);

    ca aEx(String str);

    ca aEy(String str);

    ca aEz(String str);

    void aI(String str, long j2);

    ca aJ(String str, long j2);

    ca aK(String str, long j2);

    ca aL(String str, long j2);

    ca aM(String str, long j2);

    ca aN(String str, long j2);

    boolean aO(String str, long j2);

    ca aP(String str, long j2);

    Cursor aQ(String str, long j2);

    long aR(String str, long j2);

    int aS(String str, long j2);

    int aT(String str, long j2);

    int aU(String str, long j2);

    int aV(String str, long j2);

    void aVO();

    String aW(String str, long j2);

    ca aX(String str, long j2);

    Cursor aY(String str, long j2);

    ca aZ(String str, long j2);

    Cursor ae(String str, String str2, int i2);

    List<ca> as(String str, int i2, int i3);

    Cursor at(String str, int i2, int i3);

    void ay(ArrayList<Long> arrayList);

    Cursor b(String str, long j2, long j3, int i2);

    void b(long j2, ca caVar);

    long c(ca caVar, boolean z);

    Cursor c(String str, long j2, long j3, int i2);

    void c(String str, String str2, String[] strArr);

    Cursor d(String str, long j2, long j3, int i2);

    void e(h hVar, String str);

    Cursor eA(String str, int i2);

    Cursor eB(String str, int i2);

    int eC(String str, int i2);

    Cursor eD(String str, int i2);

    Cursor eE(String str, int i2);

    int eF(String str, int i2);

    Cursor eG(String str, int i2);

    ca[] eH(String str, int i2);

    Cursor eI(String str, int i2);

    void eiH();

    void eiI();

    void eiJ();

    ArrayList<ca> eiK();

    List<ca> eiL();

    Cursor eiM();

    String eiN();

    String eiO();

    int eiP();

    List<ca> eiQ();

    List<ca> ew(String str, int i2);

    List<ca> ex(String str, int i2);

    List<ca> ey(String str, int i2);

    Cursor ez(String str, int i2);

    List<ca> f(String str, long j2, int i2);

    List<ca> f(String str, long j2, boolean z);

    List<ca> fw(List<String> list);

    List<ca> g(String str, long j2, int i2);

    h getDB();

    int h(String str, long j2, int i2);

    long i(String str, long j2, int i2);

    ca iG(String str, String str2);

    Cursor iH(String str, String str2);

    int iI(String str, String str2);

    LinkedList<ca> iJ(String str, String str2);

    long j(String str, long j2, int i2);

    Cursor k(String str, long j2, int i2);

    List<ca> k(String str, ArrayList<Long> arrayList);

    public static class c {
        public ArrayList<ca> hIs;
        public long ppv;
        public int tYD;
        public String talker;
        public String zqn;
        public int zqo;
        public int zqp;
        public long zqq;

        public c(String str, String str2, ca caVar) {
            this(str, str2, caVar, 0);
        }

        public c(String str, String str2, ca caVar, int i2) {
            long j2 = -1;
            AppMethodBeat.i(43080);
            this.hIs = new ArrayList<>();
            this.zqo = 0;
            this.zqp = 0;
            this.zqq = 0;
            this.ppv = -1;
            this.talker = str;
            this.zqn = str2;
            this.tYD = i2;
            this.ppv = caVar != null ? caVar.field_bizChatId : j2;
            if (caVar != null) {
                this.hIs.add(caVar);
            }
            AppMethodBeat.o(43080);
        }

        public c(String str, String str2, ca caVar, int i2, byte b2) {
            this(str, str2, caVar, 0);
            this.zqp = i2;
        }

        public static boolean aG(ca caVar) {
            return caVar != null && caVar.field_isSend == 0 && caVar.field_status == 3;
        }
    }

    public static class b {
        public long iXv;
        public String name;
        private a[] zqj;
        public int zqk;

        public static class a {
            long zql;
            long zqm;

            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public b(int i2, String str, a[] aVarArr) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(43076);
            Assert.assertTrue(str.length() > 0);
            this.name = str;
            Assert.assertTrue(aVarArr.length == 2);
            if (aVarArr[0].zqm >= aVarArr[0].zql) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (aVarArr[1].zqm >= aVarArr[1].zql) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(z2);
            Assert.assertTrue(aVarArr[1].zql < aVarArr[0].zqm ? false : z3);
            this.zqj = aVarArr;
            this.zqk = i2;
            this.iXv = aVarArr[0].zql;
            AppMethodBeat.o(43076);
        }

        public final void Qq(int i2) {
            AppMethodBeat.i(43077);
            Log.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", Long.valueOf(this.iXv), Integer.valueOf(i2), Long.valueOf(this.zqj[0].zqm), Long.valueOf(this.zqj[1].zql), Util.getStack());
            if (((long) i2) <= this.zqj[0].zqm || ((long) i2) >= this.zqj[1].zql) {
                this.iXv = (long) i2;
                AppMethodBeat.o(43077);
                return;
            }
            Log.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", Long.valueOf(this.zqj[1].zql));
            this.iXv = this.zqj[1].zql;
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(111, 169, 1, false);
            AppMethodBeat.o(43077);
        }

        public final synchronized void aF(ca caVar) {
            AppMethodBeat.i(43078);
            if (this.iXv == this.zqj[0].zqm) {
                this.iXv = this.zqj[1].zql;
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(111, 251, 1, false);
            } else {
                this.iXv++;
            }
            if (!CrashReportFactory.isBackupMerge()) {
                Log.i("MicroMsg.MsgTable", "incMsgLocalId %d  ", Long.valueOf(this.iXv));
            }
            caVar.setMsgId(this.iXv);
            AppMethodBeat.o(43078);
        }

        public final boolean Hg(long j2) {
            a[] aVarArr = this.zqj;
            for (a aVar : aVarArr) {
                if (j2 >= aVar.zql && j2 <= aVar.zqm) {
                    return true;
                }
            }
            return false;
        }

        public static a[] a(long j2, long j3, long j4, long j5) {
            AppMethodBeat.i(43079);
            a aVar = new a((byte) 0);
            aVar.zql = j2;
            aVar.zqm = j3;
            a aVar2 = new a((byte) 0);
            aVar2.zql = j4;
            aVar2.zqm = j5;
            a[] aVarArr = {aVar, aVar2};
            AppMethodBeat.o(43079);
            return aVarArr;
        }
    }
}
