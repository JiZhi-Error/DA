package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dfl extends dop {
    public int Llx;
    public long MKf;
    public int MKg;
    public String MKh;
    public int MKo;
    public int MKp;
    public int MKq;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32378);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xNH != null) {
                aVar.e(2, this.xNH);
            }
            if (this.MKh != null) {
                aVar.e(3, this.MKh);
            }
            aVar.aM(4, this.Llx);
            aVar.bb(5, this.MKf);
            aVar.aM(6, this.MKg);
            if (this.xNG != null) {
                aVar.e(7, this.xNG);
            }
            aVar.aM(8, this.MKp);
            aVar.aM(9, this.MKo);
            aVar.aM(10, this.MKq);
            AppMethodBeat.o(32378);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.xNH != null) {
                nh += g.a.a.b.b.a.f(2, this.xNH);
            }
            if (this.MKh != null) {
                nh += g.a.a.b.b.a.f(3, this.MKh);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Llx) + g.a.a.b.b.a.r(5, this.MKf) + g.a.a.b.b.a.bu(6, this.MKg);
            if (this.xNG != null) {
                bu += g.a.a.b.b.a.f(7, this.xNG);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.MKp) + g.a.a.b.b.a.bu(9, this.MKo) + g.a.a.b.b.a.bu(10, this.MKq);
            AppMethodBeat.o(32378);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32378);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfl dfl = (dfl) objArr[1];
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
                        dfl.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32378);
                    return 0;
                case 2:
                    dfl.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(32378);
                    return 0;
                case 3:
                    dfl.MKh = aVar3.UbS.readString();
                    AppMethodBeat.o(32378);
                    return 0;
                case 4:
                    dfl.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(32378);
                    return 0;
                case 5:
                    dfl.MKf = aVar3.UbS.zl();
                    AppMethodBeat.o(32378);
                    return 0;
                case 6:
                    dfl.MKg = aVar3.UbS.zi();
                    AppMethodBeat.o(32378);
                    return 0;
                case 7:
                    dfl.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(32378);
                    return 0;
                case 8:
                    dfl.MKp = aVar3.UbS.zi();
                    AppMethodBeat.o(32378);
                    return 0;
                case 9:
                    dfl.MKo = aVar3.UbS.zi();
                    AppMethodBeat.o(32378);
                    return 0;
                case 10:
                    dfl.MKq = aVar3.UbS.zi();
                    AppMethodBeat.o(32378);
                    return 0;
                default:
                    AppMethodBeat.o(32378);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32378);
            return -1;
        }
    }
}
