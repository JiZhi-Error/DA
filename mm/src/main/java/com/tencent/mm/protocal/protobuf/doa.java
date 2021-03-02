package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class doa extends dop {
    public LinkedList<akf> MQT = new LinkedList<>();
    public int MQU;
    public int MQV;
    public LinkedList<aap> MQW = new LinkedList<>();
    public int MQX;
    public aat MaO;
    public long clK;

    public doa() {
        AppMethodBeat.i(50105);
        AppMethodBeat.o(50105);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50106);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.clK);
            aVar.e(3, 8, this.MQT);
            aVar.aM(5, this.MQU);
            aVar.aM(6, this.MQV);
            if (this.MaO != null) {
                aVar.ni(7, this.MaO.computeSize());
                this.MaO.writeFields(aVar);
            }
            aVar.e(8, 8, this.MQW);
            aVar.aM(9, this.MQX);
            AppMethodBeat.o(50106);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.clK) + g.a.a.a.c(3, 8, this.MQT) + g.a.a.b.b.a.bu(5, this.MQU) + g.a.a.b.b.a.bu(6, this.MQV);
            if (this.MaO != null) {
                nh += g.a.a.a.nh(7, this.MaO.computeSize());
            }
            int c2 = nh + g.a.a.a.c(8, 8, this.MQW) + g.a.a.b.b.a.bu(9, this.MQX);
            AppMethodBeat.o(50106);
            return c2;
        } else if (i2 == 2) {
            this.MQT.clear();
            this.MQW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50106);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            doa doa = (doa) objArr[1];
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
                        doa.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(50106);
                    return 0;
                case 2:
                    doa.clK = aVar3.UbS.zl();
                    AppMethodBeat.o(50106);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        akf akf = new akf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = akf.populateBuilderWithField(aVar5, akf, dop.getNextFieldNumber(aVar5))) {
                        }
                        doa.MQT.add(akf);
                    }
                    AppMethodBeat.o(50106);
                    return 0;
                case 4:
                default:
                    AppMethodBeat.o(50106);
                    return -1;
                case 5:
                    doa.MQU = aVar3.UbS.zi();
                    AppMethodBeat.o(50106);
                    return 0;
                case 6:
                    doa.MQV = aVar3.UbS.zi();
                    AppMethodBeat.o(50106);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aat aat = new aat();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aat.populateBuilderWithField(aVar6, aat, dop.getNextFieldNumber(aVar6))) {
                        }
                        doa.MaO = aat;
                    }
                    AppMethodBeat.o(50106);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aap aap = new aap();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aap.populateBuilderWithField(aVar7, aap, dop.getNextFieldNumber(aVar7))) {
                        }
                        doa.MQW.add(aap);
                    }
                    AppMethodBeat.o(50106);
                    return 0;
                case 9:
                    doa.MQX = aVar3.UbS.zi();
                    AppMethodBeat.o(50106);
                    return 0;
            }
        } else {
            AppMethodBeat.o(50106);
            return -1;
        }
    }
}
