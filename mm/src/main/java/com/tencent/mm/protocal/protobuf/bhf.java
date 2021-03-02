package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bhf extends dop {
    public int KJS;
    public int KMd;
    public int KOL;
    public int LRd;
    public String LRe;
    public LinkedList<bhe> LRf = new LinkedList<>();
    public LinkedList<b> LRg = new LinkedList<>();
    public int Scene;
    public String pLm;

    public bhf() {
        AppMethodBeat.i(152547);
        AppMethodBeat.o(152547);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152548);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.KOL);
            aVar.aM(3, this.Scene);
            aVar.aM(4, this.KMd);
            aVar.aM(5, this.LRd);
            if (this.pLm != null) {
                aVar.e(6, this.pLm);
            }
            if (this.LRe != null) {
                aVar.e(7, this.LRe);
            }
            aVar.aM(8, this.KJS);
            aVar.e(9, 8, this.LRf);
            aVar.e(10, 6, this.LRg);
            AppMethodBeat.o(152548);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KOL) + g.a.a.b.b.a.bu(3, this.Scene) + g.a.a.b.b.a.bu(4, this.KMd) + g.a.a.b.b.a.bu(5, this.LRd);
            if (this.pLm != null) {
                nh += g.a.a.b.b.a.f(6, this.pLm);
            }
            if (this.LRe != null) {
                nh += g.a.a.b.b.a.f(7, this.LRe);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.KJS) + g.a.a.a.c(9, 8, this.LRf) + g.a.a.a.c(10, 6, this.LRg);
            AppMethodBeat.o(152548);
            return bu;
        } else if (i2 == 2) {
            this.LRf.clear();
            this.LRg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152548);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhf bhf = (bhf) objArr[1];
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
                        bhf.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152548);
                    return 0;
                case 2:
                    bhf.KOL = aVar3.UbS.zi();
                    AppMethodBeat.o(152548);
                    return 0;
                case 3:
                    bhf.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152548);
                    return 0;
                case 4:
                    bhf.KMd = aVar3.UbS.zi();
                    AppMethodBeat.o(152548);
                    return 0;
                case 5:
                    bhf.LRd = aVar3.UbS.zi();
                    AppMethodBeat.o(152548);
                    return 0;
                case 6:
                    bhf.pLm = aVar3.UbS.readString();
                    AppMethodBeat.o(152548);
                    return 0;
                case 7:
                    bhf.LRe = aVar3.UbS.readString();
                    AppMethodBeat.o(152548);
                    return 0;
                case 8:
                    bhf.KJS = aVar3.UbS.zi();
                    AppMethodBeat.o(152548);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bhe bhe = new bhe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bhe.populateBuilderWithField(aVar5, bhe, dop.getNextFieldNumber(aVar5))) {
                        }
                        bhf.LRf.add(bhe);
                    }
                    AppMethodBeat.o(152548);
                    return 0;
                case 10:
                    bhf.LRg.add(aVar3.UbS.hPo());
                    AppMethodBeat.o(152548);
                    return 0;
                default:
                    AppMethodBeat.o(152548);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152548);
            return -1;
        }
    }
}
