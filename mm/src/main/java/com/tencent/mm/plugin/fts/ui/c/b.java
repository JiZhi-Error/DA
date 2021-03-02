package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public int favCount;
    public String query;
    public long xaI;
    public int xeA;
    public int xeB;
    public String xeC = "";
    public boolean xeD = false;
    public int xeE = 0;
    public List<Integer> xeF = new ArrayList();
    public List<c> xeG = new ArrayList();
    public long xeh;
    public long xej = 0;
    public int xek;
    public int xel;
    public int xem;
    public int xen;
    public int xeo;
    public int xep;
    public int xeq;
    public int xer;
    public int xes;
    public int xet;
    public int xeu;
    public int xev;
    public int xew;
    public int xex;
    public int xey;
    public int xez;

    public b() {
        AppMethodBeat.i(112145);
        AppMethodBeat.o(112145);
    }

    public final void reset() {
        AppMethodBeat.i(112146);
        this.query = "";
        this.xeh = 0;
        this.xek = 0;
        this.xel = 0;
        this.xem = 0;
        this.xen = 0;
        this.xeo = 0;
        this.xep = 0;
        this.favCount = 0;
        this.xeq = 0;
        this.xer = 0;
        this.xej = 0;
        this.xes = 0;
        this.xet = 0;
        this.xeu = 0;
        this.xew = 0;
        this.xex = 0;
        this.xev = 0;
        this.xey = 0;
        this.xez = 0;
        this.xeA = 0;
        this.xeG.clear();
        this.xeF.clear();
        AppMethodBeat.o(112146);
    }

    public final int dPA() {
        int i2 = this.xeB;
        this.xeB = 2;
        return i2;
    }

    public final void gF(int i2, int i3) {
        this.xeu = i2;
        this.xev = i3;
    }

    public final void gG(int i2, int i3) {
        this.xez = i2;
        this.xey = i3;
    }

    public final void dPB() {
        AppMethodBeat.i(112147);
        c cVar = new c();
        if (this.xew > 0 || this.xex > 0) {
            cVar.position = this.xeA + 2;
        } else {
            cVar.position = this.xeA + 1;
        }
        cVar.dUb = "SOSBar";
        cVar.wVZ = System.currentTimeMillis() - this.xaI;
        cVar.dUm = 18;
        if (!this.xeG.contains(cVar)) {
            this.xeG.add(cVar);
        }
        AppMethodBeat.o(112147);
    }

    public final void eS(List<efk> list) {
        int i2;
        AppMethodBeat.i(235409);
        if (this.xew > 0 || this.xex > 0) {
            i2 = this.xeA + 3;
        } else {
            i2 = this.xeA + 2;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            c cVar = new c();
            cVar.index = i3;
            cVar.position = i2;
            cVar.dUb = "SOSRelevant-" + list.get(i3).MEq;
            cVar.wVZ = System.currentTimeMillis() - this.xaI;
            cVar.dUm = 23;
            if (!this.xeG.contains(cVar)) {
                this.xeG.add(cVar);
            }
        }
        AppMethodBeat.o(235409);
    }

    public final void t(long j2, String str) {
        AppMethodBeat.i(176914);
        c cVar = new c();
        cVar.position = 1;
        cVar.dUm = 28;
        cVar.wVY = System.currentTimeMillis() - this.xaI;
        cVar.wVZ = j2 - this.xaI;
        cVar.dUb = str;
        if (!this.xeG.contains(cVar)) {
            this.xeG.add(cVar);
        }
        AppMethodBeat.o(176914);
    }

    public final void a(int i2, long j2, String str, int i3, String str2) {
        AppMethodBeat.i(112149);
        c cVar = new c();
        cVar.position = i2;
        cVar.dUm = 27;
        cVar.wVY = System.currentTimeMillis() - this.xaI;
        cVar.wVZ = j2 - this.xaI;
        cVar.wWa = i3;
        cVar.wWb = str2;
        cVar.dUb = str;
        if (!this.xeG.contains(cVar)) {
            this.xeG.add(cVar);
        }
        AppMethodBeat.o(112149);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(112150);
        Nv(l.a(aVar));
        AppMethodBeat.o(112150);
    }

    public final void Nv(int i2) {
        AppMethodBeat.i(112151);
        Log.i("MicroMsg.FTS.FTSSearchStaticsObj", "addClickItemType %s", Integer.valueOf(i2));
        this.xeF.add(Integer.valueOf(i2));
        AppMethodBeat.o(112151);
    }

    public final String dPC() {
        AppMethodBeat.i(112152);
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer num : this.xeF) {
            stringBuffer.append(num.intValue());
            stringBuffer.append("#");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(112152);
        return stringBuffer2;
    }

    public final String dPD() {
        AppMethodBeat.i(112153);
        StringBuffer stringBuffer = new StringBuffer();
        for (c cVar : this.xeG) {
            if (cVar.dUm != 0) {
                stringBuffer.append(cVar.position + cVar.index);
                stringBuffer.append("#");
                stringBuffer.append(cVar.dUm);
                stringBuffer.append("#");
                stringBuffer.append(cVar.wVY);
                stringBuffer.append("#");
                stringBuffer.append(cVar.wVZ);
                stringBuffer.append("|");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(112153);
        return stringBuffer2;
    }

    public final String dPE() {
        AppMethodBeat.i(112154);
        StringBuffer stringBuffer = new StringBuffer();
        for (c cVar : this.xeG) {
            if (!(cVar.dUm == 0 || cVar.wWa == 0)) {
                stringBuffer.append(cVar.position);
                stringBuffer.append("#");
                stringBuffer.append(cVar.dUm);
                stringBuffer.append("#");
                stringBuffer.append(cVar.wWa);
                stringBuffer.append("|");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(112154);
        return stringBuffer2;
    }

    public final String dPF() {
        AppMethodBeat.i(112155);
        for (c cVar : this.xeG) {
            if (cVar.dUm == 27) {
                String str = cVar.wWb;
                AppMethodBeat.o(112155);
                return str;
            }
        }
        AppMethodBeat.o(112155);
        return "";
    }

    public final String dPG() {
        AppMethodBeat.i(112156);
        StringBuffer stringBuffer = new StringBuffer();
        if (this.xek > 0) {
            stringBuffer.append(2);
            stringBuffer.append("#");
            stringBuffer.append(this.xek);
            stringBuffer.append("|");
        }
        if (this.xel > 0) {
            stringBuffer.append(3);
            stringBuffer.append("#");
            stringBuffer.append(this.xel);
            stringBuffer.append("|");
        }
        if (this.xem > 0) {
            stringBuffer.append(4);
            stringBuffer.append("#");
            stringBuffer.append(this.xem);
            stringBuffer.append("|");
        }
        if (this.xen > 0) {
            stringBuffer.append(5);
            stringBuffer.append("#");
            stringBuffer.append(this.xen);
            stringBuffer.append("|");
        }
        if (this.xeo > 0) {
            stringBuffer.append(11);
            stringBuffer.append("#");
            stringBuffer.append(this.xeo);
            stringBuffer.append("|");
        }
        if (this.xep > 0) {
            stringBuffer.append(10);
            stringBuffer.append("#");
            stringBuffer.append(this.xep);
            stringBuffer.append("|");
        }
        if (this.xer > 0) {
            stringBuffer.append(19);
            stringBuffer.append("#");
            stringBuffer.append(this.xer);
            stringBuffer.append("|");
        }
        if (this.favCount > 0) {
            stringBuffer.append(12);
            stringBuffer.append("#");
            stringBuffer.append(this.favCount);
            stringBuffer.append("|");
        }
        if (this.xes > 0) {
            stringBuffer.append(25);
            stringBuffer.append("#");
            stringBuffer.append(this.xes);
            stringBuffer.append("|");
        }
        if (this.xet > 0) {
            stringBuffer.append(26);
            stringBuffer.append("#");
            stringBuffer.append(this.xet);
            stringBuffer.append("|");
        }
        if (this.xeu > 0) {
            stringBuffer.append(28);
            stringBuffer.append("#");
            stringBuffer.append(this.xeu);
            stringBuffer.append("|");
        }
        if (this.xev > 0) {
            stringBuffer.append(27);
            stringBuffer.append("#");
            stringBuffer.append(this.xev);
            stringBuffer.append("|");
        }
        if (this.xez > 0) {
            stringBuffer.append(23);
            stringBuffer.append("#");
            stringBuffer.append(this.xez);
            stringBuffer.append("|");
        }
        if (this.xey > 0) {
            stringBuffer.append(18);
            stringBuffer.append("#");
            stringBuffer.append(this.xey);
            stringBuffer.append("|");
        }
        if (this.xew > 0) {
            stringBuffer.append(8);
            stringBuffer.append("#");
            stringBuffer.append(this.xew);
            stringBuffer.append("|");
        }
        if (this.xex > 0) {
            stringBuffer.append(9);
            stringBuffer.append("#");
            stringBuffer.append(this.xex);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(112156);
        return stringBuffer2;
    }
}
