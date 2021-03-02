package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ol extends dop {
    public LinkedList<String> KUr = new LinkedList<>();
    public String KUs;
    public double KUt;
    public double KUu;
    public String ProductID;
    public int Scene;

    public ol() {
        AppMethodBeat.i(124427);
        AppMethodBeat.o(124427);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124428);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ProductID != null) {
                aVar.e(2, this.ProductID);
            }
            aVar.e(3, 1, this.KUr);
            aVar.aM(4, this.Scene);
            if (this.KUs != null) {
                aVar.e(5, this.KUs);
            }
            aVar.e(6, this.KUt);
            aVar.e(7, this.KUu);
            AppMethodBeat.o(124428);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.ProductID != null) {
                nh += g.a.a.b.b.a.f(2, this.ProductID);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.KUr) + g.a.a.b.b.a.bu(4, this.Scene);
            if (this.KUs != null) {
                c2 += g.a.a.b.b.a.f(5, this.KUs);
            }
            int fS = c2 + g.a.a.b.b.a.fS(6) + 8 + g.a.a.b.b.a.fS(7) + 8;
            AppMethodBeat.o(124428);
            return fS;
        } else if (i2 == 2) {
            this.KUr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124428);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ol olVar = (ol) objArr[1];
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
                        olVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124428);
                    return 0;
                case 2:
                    olVar.ProductID = aVar3.UbS.readString();
                    AppMethodBeat.o(124428);
                    return 0;
                case 3:
                    olVar.KUr.add(aVar3.UbS.readString());
                    AppMethodBeat.o(124428);
                    return 0;
                case 4:
                    olVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(124428);
                    return 0;
                case 5:
                    olVar.KUs = aVar3.UbS.readString();
                    AppMethodBeat.o(124428);
                    return 0;
                case 6:
                    olVar.KUt = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(124428);
                    return 0;
                case 7:
                    olVar.KUu = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(124428);
                    return 0;
                default:
                    AppMethodBeat.o(124428);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124428);
            return -1;
        }
    }
}
