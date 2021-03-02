package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class fax extends a {
    public int Dzt = -1;
    public String NhM;
    public String Nxj;
    public String Nxk;
    public String Nxl;
    public String Nxm;
    public String Nxn;
    public int Nxo;
    public float Nxp;
    public int dLt;
    public String domain;
    public String dtX;
    public int duration = -1;
    public int idx;
    public long msgId;
    public int pHw;
    public long prZ;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212148);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.duration);
            aVar.aM(2, this.Dzt);
            if (this.dtX != null) {
                aVar.e(3, this.dtX);
            }
            if (this.Nxj != null) {
                aVar.e(4, this.Nxj);
            }
            aVar.aM(5, this.dLt);
            if (this.NhM != null) {
                aVar.e(6, this.NhM);
            }
            aVar.bb(7, this.msgId);
            aVar.aM(8, this.idx);
            if (this.Nxk != null) {
                aVar.e(9, this.Nxk);
            }
            if (this.Nxl != null) {
                aVar.e(10, this.Nxl);
            }
            if (this.Nxm != null) {
                aVar.e(11, this.Nxm);
            }
            if (this.Nxn != null) {
                aVar.e(12, this.Nxn);
            }
            aVar.bb(13, this.prZ);
            aVar.aM(14, this.scene);
            aVar.aM(15, this.pHw);
            aVar.aM(16, this.Nxo);
            if (this.domain != null) {
                aVar.e(17, this.domain);
            }
            aVar.E(18, this.Nxp);
            AppMethodBeat.o(212148);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.duration) + 0 + g.a.a.b.b.a.bu(2, this.Dzt);
            if (this.dtX != null) {
                bu += g.a.a.b.b.a.f(3, this.dtX);
            }
            if (this.Nxj != null) {
                bu += g.a.a.b.b.a.f(4, this.Nxj);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.dLt);
            if (this.NhM != null) {
                bu2 += g.a.a.b.b.a.f(6, this.NhM);
            }
            int r = bu2 + g.a.a.b.b.a.r(7, this.msgId) + g.a.a.b.b.a.bu(8, this.idx);
            if (this.Nxk != null) {
                r += g.a.a.b.b.a.f(9, this.Nxk);
            }
            if (this.Nxl != null) {
                r += g.a.a.b.b.a.f(10, this.Nxl);
            }
            if (this.Nxm != null) {
                r += g.a.a.b.b.a.f(11, this.Nxm);
            }
            if (this.Nxn != null) {
                r += g.a.a.b.b.a.f(12, this.Nxn);
            }
            int r2 = r + g.a.a.b.b.a.r(13, this.prZ) + g.a.a.b.b.a.bu(14, this.scene) + g.a.a.b.b.a.bu(15, this.pHw) + g.a.a.b.b.a.bu(16, this.Nxo);
            if (this.domain != null) {
                r2 += g.a.a.b.b.a.f(17, this.domain);
            }
            int fS = r2 + g.a.a.b.b.a.fS(18) + 4;
            AppMethodBeat.o(212148);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212148);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fax fax = (fax) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fax.duration = aVar3.UbS.zi();
                    AppMethodBeat.o(212148);
                    return 0;
                case 2:
                    fax.Dzt = aVar3.UbS.zi();
                    AppMethodBeat.o(212148);
                    return 0;
                case 3:
                    fax.dtX = aVar3.UbS.readString();
                    AppMethodBeat.o(212148);
                    return 0;
                case 4:
                    fax.Nxj = aVar3.UbS.readString();
                    AppMethodBeat.o(212148);
                    return 0;
                case 5:
                    fax.dLt = aVar3.UbS.zi();
                    AppMethodBeat.o(212148);
                    return 0;
                case 6:
                    fax.NhM = aVar3.UbS.readString();
                    AppMethodBeat.o(212148);
                    return 0;
                case 7:
                    fax.msgId = aVar3.UbS.zl();
                    AppMethodBeat.o(212148);
                    return 0;
                case 8:
                    fax.idx = aVar3.UbS.zi();
                    AppMethodBeat.o(212148);
                    return 0;
                case 9:
                    fax.Nxk = aVar3.UbS.readString();
                    AppMethodBeat.o(212148);
                    return 0;
                case 10:
                    fax.Nxl = aVar3.UbS.readString();
                    AppMethodBeat.o(212148);
                    return 0;
                case 11:
                    fax.Nxm = aVar3.UbS.readString();
                    AppMethodBeat.o(212148);
                    return 0;
                case 12:
                    fax.Nxn = aVar3.UbS.readString();
                    AppMethodBeat.o(212148);
                    return 0;
                case 13:
                    fax.prZ = aVar3.UbS.zl();
                    AppMethodBeat.o(212148);
                    return 0;
                case 14:
                    fax.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(212148);
                    return 0;
                case 15:
                    fax.pHw = aVar3.UbS.zi();
                    AppMethodBeat.o(212148);
                    return 0;
                case 16:
                    fax.Nxo = aVar3.UbS.zi();
                    AppMethodBeat.o(212148);
                    return 0;
                case 17:
                    fax.domain = aVar3.UbS.readString();
                    AppMethodBeat.o(212148);
                    return 0;
                case 18:
                    fax.Nxp = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(212148);
                    return 0;
                default:
                    AppMethodBeat.o(212148);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212148);
            return -1;
        }
    }
}
