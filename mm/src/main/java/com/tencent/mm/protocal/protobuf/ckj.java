package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ckj extends a {
    public ckk MpS;
    public ckk MpT;
    public ckk MpU;
    public String dQx;
    public int style;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200214);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dQx != null) {
                aVar.e(1, this.dQx);
            }
            aVar.aM(2, this.style);
            if (this.MpS != null) {
                aVar.ni(3, this.MpS.computeSize());
                this.MpS.writeFields(aVar);
            }
            if (this.MpT != null) {
                aVar.ni(4, this.MpT.computeSize());
                this.MpT.writeFields(aVar);
            }
            if (this.MpU != null) {
                aVar.ni(5, this.MpU.computeSize());
                this.MpU.writeFields(aVar);
            }
            AppMethodBeat.o(200214);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dQx != null ? g.a.a.b.b.a.f(1, this.dQx) + 0 : 0) + g.a.a.b.b.a.bu(2, this.style);
            if (this.MpS != null) {
                f2 += g.a.a.a.nh(3, this.MpS.computeSize());
            }
            if (this.MpT != null) {
                f2 += g.a.a.a.nh(4, this.MpT.computeSize());
            }
            if (this.MpU != null) {
                f2 += g.a.a.a.nh(5, this.MpU.computeSize());
            }
            AppMethodBeat.o(200214);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200214);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ckj ckj = (ckj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ckj.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(200214);
                    return 0;
                case 2:
                    ckj.style = aVar3.UbS.zi();
                    AppMethodBeat.o(200214);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ckk ckk = new ckk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ckk.populateBuilderWithField(aVar4, ckk, a.getNextFieldNumber(aVar4))) {
                        }
                        ckj.MpS = ckk;
                    }
                    AppMethodBeat.o(200214);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ckk ckk2 = new ckk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ckk2.populateBuilderWithField(aVar5, ckk2, a.getNextFieldNumber(aVar5))) {
                        }
                        ckj.MpT = ckk2;
                    }
                    AppMethodBeat.o(200214);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ckk ckk3 = new ckk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ckk3.populateBuilderWithField(aVar6, ckk3, a.getNextFieldNumber(aVar6))) {
                        }
                        ckj.MpU = ckk3;
                    }
                    AppMethodBeat.o(200214);
                    return 0;
                default:
                    AppMethodBeat.o(200214);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200214);
            return -1;
        }
    }
}
