package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class del extends dop {
    public int APa;
    public String MJA;
    public int MJB;
    public String MJz;
    public String ProductID;
    public String xNU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91630);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ProductID != null) {
                aVar.e(2, this.ProductID);
            }
            if (this.MJz != null) {
                aVar.e(3, this.MJz);
            }
            if (this.MJA != null) {
                aVar.e(4, this.MJA);
            }
            aVar.aM(5, this.APa);
            if (this.xNU != null) {
                aVar.e(7, this.xNU);
            }
            aVar.aM(8, this.MJB);
            AppMethodBeat.o(91630);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.ProductID != null) {
                nh += g.a.a.b.b.a.f(2, this.ProductID);
            }
            if (this.MJz != null) {
                nh += g.a.a.b.b.a.f(3, this.MJz);
            }
            if (this.MJA != null) {
                nh += g.a.a.b.b.a.f(4, this.MJA);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.APa);
            if (this.xNU != null) {
                bu += g.a.a.b.b.a.f(7, this.xNU);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.MJB);
            AppMethodBeat.o(91630);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91630);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            del del = (del) objArr[1];
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
                        del.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91630);
                    return 0;
                case 2:
                    del.ProductID = aVar3.UbS.readString();
                    AppMethodBeat.o(91630);
                    return 0;
                case 3:
                    del.MJz = aVar3.UbS.readString();
                    AppMethodBeat.o(91630);
                    return 0;
                case 4:
                    del.MJA = aVar3.UbS.readString();
                    AppMethodBeat.o(91630);
                    return 0;
                case 5:
                    del.APa = aVar3.UbS.zi();
                    AppMethodBeat.o(91630);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(91630);
                    return -1;
                case 7:
                    del.xNU = aVar3.UbS.readString();
                    AppMethodBeat.o(91630);
                    return 0;
                case 8:
                    del.MJB = aVar3.UbS.zi();
                    AppMethodBeat.o(91630);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91630);
            return -1;
        }
    }
}
