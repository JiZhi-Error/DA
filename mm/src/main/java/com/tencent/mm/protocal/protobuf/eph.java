package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eph extends dop {
    public int LSk;
    public ccu LSo;
    public ccv LSp;
    public int dUT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72622);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LSk);
            aVar.aM(3, this.dUT);
            if (this.LSo != null) {
                aVar.ni(4, this.LSo.computeSize());
                this.LSo.writeFields(aVar);
            }
            if (this.LSp != null) {
                aVar.ni(5, this.LSp.computeSize());
                this.LSp.writeFields(aVar);
            }
            AppMethodBeat.o(72622);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LSk) + g.a.a.b.b.a.bu(3, this.dUT);
            if (this.LSo != null) {
                nh += g.a.a.a.nh(4, this.LSo.computeSize());
            }
            if (this.LSp != null) {
                nh += g.a.a.a.nh(5, this.LSp.computeSize());
            }
            AppMethodBeat.o(72622);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72622);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eph eph = (eph) objArr[1];
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
                        eph.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72622);
                    return 0;
                case 2:
                    eph.LSk = aVar3.UbS.zi();
                    AppMethodBeat.o(72622);
                    return 0;
                case 3:
                    eph.dUT = aVar3.UbS.zi();
                    AppMethodBeat.o(72622);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ccu ccu = new ccu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ccu.populateBuilderWithField(aVar5, ccu, dop.getNextFieldNumber(aVar5))) {
                        }
                        eph.LSo = ccu;
                    }
                    AppMethodBeat.o(72622);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ccv ccv = new ccv();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ccv.populateBuilderWithField(aVar6, ccv, dop.getNextFieldNumber(aVar6))) {
                        }
                        eph.LSp = ccv;
                    }
                    AppMethodBeat.o(72622);
                    return 0;
                default:
                    AppMethodBeat.o(72622);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72622);
            return -1;
        }
    }
}
