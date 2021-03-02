package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ceu extends dop {
    public int Lqj;
    public int MjY;
    public int MjZ;
    public fdg Mka;
    public String Mkp;
    public String jfi;
    public b oTm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123618);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            if (this.oTm != null) {
                aVar.c(3, this.oTm);
            }
            if (this.Mkp != null) {
                aVar.e(4, this.Mkp);
            }
            aVar.aM(5, this.MjY);
            aVar.aM(6, this.MjZ);
            if (this.Mka != null) {
                aVar.ni(7, this.Mka.computeSize());
                this.Mka.writeFields(aVar);
            }
            aVar.aM(8, this.Lqj);
            AppMethodBeat.o(123618);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            if (this.oTm != null) {
                nh += g.a.a.b.b.a.b(3, this.oTm);
            }
            if (this.Mkp != null) {
                nh += g.a.a.b.b.a.f(4, this.Mkp);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.MjY) + g.a.a.b.b.a.bu(6, this.MjZ);
            if (this.Mka != null) {
                bu += g.a.a.a.nh(7, this.Mka.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.Lqj);
            AppMethodBeat.o(123618);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123618);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ceu ceu = (ceu) objArr[1];
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
                        ceu.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123618);
                    return 0;
                case 2:
                    ceu.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(123618);
                    return 0;
                case 3:
                    ceu.oTm = aVar3.UbS.hPo();
                    AppMethodBeat.o(123618);
                    return 0;
                case 4:
                    ceu.Mkp = aVar3.UbS.readString();
                    AppMethodBeat.o(123618);
                    return 0;
                case 5:
                    ceu.MjY = aVar3.UbS.zi();
                    AppMethodBeat.o(123618);
                    return 0;
                case 6:
                    ceu.MjZ = aVar3.UbS.zi();
                    AppMethodBeat.o(123618);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fdg fdg = new fdg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fdg.populateBuilderWithField(aVar5, fdg, dop.getNextFieldNumber(aVar5))) {
                        }
                        ceu.Mka = fdg;
                    }
                    AppMethodBeat.o(123618);
                    return 0;
                case 8:
                    ceu.Lqj = aVar3.UbS.zi();
                    AppMethodBeat.o(123618);
                    return 0;
                default:
                    AppMethodBeat.o(123618);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123618);
            return -1;
        }
    }
}
