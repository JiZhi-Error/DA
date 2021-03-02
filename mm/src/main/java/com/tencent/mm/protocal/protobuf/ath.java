package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ath extends dop {
    public aov LBM;
    public String LEc;
    public long LEd;
    public long LEe;
    public String LEf;
    public int LEg;
    public String pPz;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209442);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.scene);
            if (this.pPz != null) {
                aVar.e(3, this.pPz);
            }
            if (this.LBM != null) {
                aVar.ni(4, this.LBM.computeSize());
                this.LBM.writeFields(aVar);
            }
            if (this.LEc != null) {
                aVar.e(5, this.LEc);
            }
            aVar.bb(6, this.LEd);
            aVar.bb(7, this.LEe);
            if (this.LEf != null) {
                aVar.e(8, this.LEf);
            }
            aVar.aM(9, this.LEg);
            AppMethodBeat.o(209442);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.scene);
            if (this.pPz != null) {
                nh += g.a.a.b.b.a.f(3, this.pPz);
            }
            if (this.LBM != null) {
                nh += g.a.a.a.nh(4, this.LBM.computeSize());
            }
            if (this.LEc != null) {
                nh += g.a.a.b.b.a.f(5, this.LEc);
            }
            int r = nh + g.a.a.b.b.a.r(6, this.LEd) + g.a.a.b.b.a.r(7, this.LEe);
            if (this.LEf != null) {
                r += g.a.a.b.b.a.f(8, this.LEf);
            }
            int bu = r + g.a.a.b.b.a.bu(9, this.LEg);
            AppMethodBeat.o(209442);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209442);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ath ath = (ath) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        ath.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209442);
                    return 0;
                case 2:
                    ath.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209442);
                    return 0;
                case 3:
                    ath.pPz = aVar3.UbS.readString();
                    AppMethodBeat.o(209442);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        ath.LBM = aov;
                    }
                    AppMethodBeat.o(209442);
                    return 0;
                case 5:
                    ath.LEc = aVar3.UbS.readString();
                    AppMethodBeat.o(209442);
                    return 0;
                case 6:
                    ath.LEd = aVar3.UbS.zl();
                    AppMethodBeat.o(209442);
                    return 0;
                case 7:
                    ath.LEe = aVar3.UbS.zl();
                    AppMethodBeat.o(209442);
                    return 0;
                case 8:
                    ath.LEf = aVar3.UbS.readString();
                    AppMethodBeat.o(209442);
                    return 0;
                case 9:
                    ath.LEg = aVar3.UbS.zi();
                    AppMethodBeat.o(209442);
                    return 0;
                default:
                    AppMethodBeat.o(209442);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209442);
            return -1;
        }
    }
}
