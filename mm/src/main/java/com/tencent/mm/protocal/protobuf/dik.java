package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dik extends dop {
    public jl LjV;
    public int Llf;
    public int Llg;
    public int MMR;
    public b MMS;
    public b MMT;
    public b MMU;
    public int MMV;
    public dil MMW;
    public long timestamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91653);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LjV != null) {
                aVar.ni(2, this.LjV.computeSize());
                this.LjV.writeFields(aVar);
            }
            aVar.aM(3, this.MMR);
            if (this.MMS != null) {
                aVar.c(4, this.MMS);
            }
            if (this.MMT != null) {
                aVar.c(5, this.MMT);
            }
            if (this.MMU != null) {
                aVar.c(6, this.MMU);
            }
            aVar.aM(7, this.Llg);
            aVar.aM(8, this.Llf);
            aVar.aM(9, this.MMV);
            aVar.bb(10, this.timestamp);
            if (this.MMW != null) {
                aVar.ni(11, this.MMW.computeSize());
                this.MMW.writeFields(aVar);
            }
            AppMethodBeat.o(91653);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LjV != null) {
                nh += g.a.a.a.nh(2, this.LjV.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MMR);
            if (this.MMS != null) {
                bu += g.a.a.b.b.a.b(4, this.MMS);
            }
            if (this.MMT != null) {
                bu += g.a.a.b.b.a.b(5, this.MMT);
            }
            if (this.MMU != null) {
                bu += g.a.a.b.b.a.b(6, this.MMU);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Llg) + g.a.a.b.b.a.bu(8, this.Llf) + g.a.a.b.b.a.bu(9, this.MMV) + g.a.a.b.b.a.r(10, this.timestamp);
            if (this.MMW != null) {
                bu2 += g.a.a.a.nh(11, this.MMW.computeSize());
            }
            AppMethodBeat.o(91653);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91653);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dik dik = (dik) objArr[1];
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
                        dik.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91653);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        jl jlVar = new jl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jlVar.populateBuilderWithField(aVar5, jlVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        dik.LjV = jlVar;
                    }
                    AppMethodBeat.o(91653);
                    return 0;
                case 3:
                    dik.MMR = aVar3.UbS.zi();
                    AppMethodBeat.o(91653);
                    return 0;
                case 4:
                    dik.MMS = aVar3.UbS.hPo();
                    AppMethodBeat.o(91653);
                    return 0;
                case 5:
                    dik.MMT = aVar3.UbS.hPo();
                    AppMethodBeat.o(91653);
                    return 0;
                case 6:
                    dik.MMU = aVar3.UbS.hPo();
                    AppMethodBeat.o(91653);
                    return 0;
                case 7:
                    dik.Llg = aVar3.UbS.zi();
                    AppMethodBeat.o(91653);
                    return 0;
                case 8:
                    dik.Llf = aVar3.UbS.zi();
                    AppMethodBeat.o(91653);
                    return 0;
                case 9:
                    dik.MMV = aVar3.UbS.zi();
                    AppMethodBeat.o(91653);
                    return 0;
                case 10:
                    dik.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(91653);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dil dil = new dil();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dil.populateBuilderWithField(aVar6, dil, dop.getNextFieldNumber(aVar6))) {
                        }
                        dik.MMW = dil;
                    }
                    AppMethodBeat.o(91653);
                    return 0;
                default:
                    AppMethodBeat.o(91653);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91653);
            return -1;
        }
    }
}
