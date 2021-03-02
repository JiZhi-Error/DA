package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class euo extends dop {
    public double KUt;
    public double KUu;
    public LinkedList<eby> LWv = new LinkedList<>();
    public int Llx;
    public int LsZ;
    public long Lta;
    public long NsG;
    public dqi NsH;
    public dqi NsI;
    public int NsJ;

    public euo() {
        AppMethodBeat.i(115913);
        AppMethodBeat.o(115913);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115914);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.NsH == null) {
                b bVar = new b("Not all required fields were included: NetName");
                AppMethodBeat.o(115914);
                throw bVar;
            } else if (this.NsI == null) {
                b bVar2 = new b("Not all required fields were included: WifiName");
                AppMethodBeat.o(115914);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                aVar.bb(2, this.NsG);
                aVar.bb(3, this.Lta);
                aVar.aM(4, this.Llx);
                if (this.NsH != null) {
                    aVar.ni(5, this.NsH.computeSize());
                    this.NsH.writeFields(aVar);
                }
                if (this.NsI != null) {
                    aVar.ni(6, this.NsI.computeSize());
                    this.NsI.writeFields(aVar);
                }
                aVar.e(7, this.KUt);
                aVar.e(8, this.KUu);
                aVar.aM(9, this.LsZ);
                aVar.aM(10, this.NsJ);
                aVar.e(11, 8, this.LWv);
                AppMethodBeat.o(115914);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.NsG) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.Llx);
            if (this.NsH != null) {
                nh += g.a.a.a.nh(5, this.NsH.computeSize());
            }
            if (this.NsI != null) {
                nh += g.a.a.a.nh(6, this.NsI.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(7) + 8 + g.a.a.b.b.a.fS(8) + 8 + g.a.a.b.b.a.bu(9, this.LsZ) + g.a.a.b.b.a.bu(10, this.NsJ) + g.a.a.a.c(11, 8, this.LWv);
            AppMethodBeat.o(115914);
            return fS;
        } else if (i2 == 2) {
            this.LWv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NsH == null) {
                b bVar3 = new b("Not all required fields were included: NetName");
                AppMethodBeat.o(115914);
                throw bVar3;
            } else if (this.NsI == null) {
                b bVar4 = new b("Not all required fields were included: WifiName");
                AppMethodBeat.o(115914);
                throw bVar4;
            } else {
                AppMethodBeat.o(115914);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            euo euo = (euo) objArr[1];
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
                        euo.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115914);
                    return 0;
                case 2:
                    euo.NsG = aVar3.UbS.zl();
                    AppMethodBeat.o(115914);
                    return 0;
                case 3:
                    euo.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115914);
                    return 0;
                case 4:
                    euo.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(115914);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        euo.NsH = dqi;
                    }
                    AppMethodBeat.o(115914);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dop.getNextFieldNumber(aVar6))) {
                        }
                        euo.NsI = dqi2;
                    }
                    AppMethodBeat.o(115914);
                    return 0;
                case 7:
                    euo.KUt = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(115914);
                    return 0;
                case 8:
                    euo.KUu = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(115914);
                    return 0;
                case 9:
                    euo.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115914);
                    return 0;
                case 10:
                    euo.NsJ = aVar3.UbS.zi();
                    AppMethodBeat.o(115914);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eby eby = new eby();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eby.populateBuilderWithField(aVar7, eby, dop.getNextFieldNumber(aVar7))) {
                        }
                        euo.LWv.add(eby);
                    }
                    AppMethodBeat.o(115914);
                    return 0;
                default:
                    AppMethodBeat.o(115914);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115914);
            return -1;
        }
    }
}
