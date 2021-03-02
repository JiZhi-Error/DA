package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class br extends a {
    public String KFq;
    public String KFr;
    public String KFs;
    public String KFt;
    public String KFu;
    public String KFv;
    public ffi KFw;
    public String KFx;
    public String hik;
    public String xJM;
    public String xMq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152478);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hik != null) {
                aVar.e(1, this.hik);
            }
            if (this.KFq != null) {
                aVar.e(2, this.KFq);
            }
            if (this.KFr != null) {
                aVar.e(3, this.KFr);
            }
            if (this.xJM != null) {
                aVar.e(4, this.xJM);
            }
            if (this.xMq != null) {
                aVar.e(5, this.xMq);
            }
            if (this.KFs != null) {
                aVar.e(6, this.KFs);
            }
            if (this.KFt != null) {
                aVar.e(7, this.KFt);
            }
            if (this.KFu != null) {
                aVar.e(8, this.KFu);
            }
            if (this.KFv != null) {
                aVar.e(9, this.KFv);
            }
            if (this.KFw != null) {
                aVar.ni(10, this.KFw.computeSize());
                this.KFw.writeFields(aVar);
            }
            if (this.KFx != null) {
                aVar.e(11, this.KFx);
            }
            AppMethodBeat.o(152478);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.hik != null ? g.a.a.b.b.a.f(1, this.hik) + 0 : 0;
            if (this.KFq != null) {
                f2 += g.a.a.b.b.a.f(2, this.KFq);
            }
            if (this.KFr != null) {
                f2 += g.a.a.b.b.a.f(3, this.KFr);
            }
            if (this.xJM != null) {
                f2 += g.a.a.b.b.a.f(4, this.xJM);
            }
            if (this.xMq != null) {
                f2 += g.a.a.b.b.a.f(5, this.xMq);
            }
            if (this.KFs != null) {
                f2 += g.a.a.b.b.a.f(6, this.KFs);
            }
            if (this.KFt != null) {
                f2 += g.a.a.b.b.a.f(7, this.KFt);
            }
            if (this.KFu != null) {
                f2 += g.a.a.b.b.a.f(8, this.KFu);
            }
            if (this.KFv != null) {
                f2 += g.a.a.b.b.a.f(9, this.KFv);
            }
            if (this.KFw != null) {
                f2 += g.a.a.a.nh(10, this.KFw.computeSize());
            }
            if (this.KFx != null) {
                f2 += g.a.a.b.b.a.f(11, this.KFx);
            }
            AppMethodBeat.o(152478);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152478);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            br brVar = (br) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    brVar.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(152478);
                    return 0;
                case 2:
                    brVar.KFq = aVar3.UbS.readString();
                    AppMethodBeat.o(152478);
                    return 0;
                case 3:
                    brVar.KFr = aVar3.UbS.readString();
                    AppMethodBeat.o(152478);
                    return 0;
                case 4:
                    brVar.xJM = aVar3.UbS.readString();
                    AppMethodBeat.o(152478);
                    return 0;
                case 5:
                    brVar.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(152478);
                    return 0;
                case 6:
                    brVar.KFs = aVar3.UbS.readString();
                    AppMethodBeat.o(152478);
                    return 0;
                case 7:
                    brVar.KFt = aVar3.UbS.readString();
                    AppMethodBeat.o(152478);
                    return 0;
                case 8:
                    brVar.KFu = aVar3.UbS.readString();
                    AppMethodBeat.o(152478);
                    return 0;
                case 9:
                    brVar.KFv = aVar3.UbS.readString();
                    AppMethodBeat.o(152478);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ffi ffi = new ffi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ffi.populateBuilderWithField(aVar4, ffi, a.getNextFieldNumber(aVar4))) {
                        }
                        brVar.KFw = ffi;
                    }
                    AppMethodBeat.o(152478);
                    return 0;
                case 11:
                    brVar.KFx = aVar3.UbS.readString();
                    AppMethodBeat.o(152478);
                    return 0;
                default:
                    AppMethodBeat.o(152478);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152478);
            return -1;
        }
    }
}
