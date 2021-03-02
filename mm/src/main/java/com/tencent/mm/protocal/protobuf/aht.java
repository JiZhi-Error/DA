package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aht extends dop {
    public long Brn;
    public int BsF;
    public int BsG;
    public int BsH;
    public int KIy;
    public int LrA;
    public int LrB;
    public String Lrz;
    public String UserName;
    public String jfi;
    public String jfl;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(9590);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            aVar.aM(3, this.KIy);
            if (this.jfl != null) {
                aVar.e(4, this.jfl);
            }
            if (this.UserName != null) {
                aVar.e(5, this.UserName);
            }
            aVar.aM(6, this.BsF);
            aVar.aM(7, this.BsG);
            aVar.aM(8, this.BsH);
            if (this.Lrz != null) {
                aVar.e(9, this.Lrz);
            }
            aVar.aM(10, this.LrA);
            aVar.aM(11, this.oUv);
            aVar.aM(12, this.LrB);
            aVar.bb(13, this.Brn);
            AppMethodBeat.o(9590);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KIy);
            if (this.jfl != null) {
                bu += g.a.a.b.b.a.f(4, this.jfl);
            }
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(5, this.UserName);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.BsF) + g.a.a.b.b.a.bu(7, this.BsG) + g.a.a.b.b.a.bu(8, this.BsH);
            if (this.Lrz != null) {
                bu2 += g.a.a.b.b.a.f(9, this.Lrz);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.LrA) + g.a.a.b.b.a.bu(11, this.oUv) + g.a.a.b.b.a.bu(12, this.LrB) + g.a.a.b.b.a.r(13, this.Brn);
            AppMethodBeat.o(9590);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(9590);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aht aht = (aht) objArr[1];
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
                        aht.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(9590);
                    return 0;
                case 2:
                    aht.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(9590);
                    return 0;
                case 3:
                    aht.KIy = aVar3.UbS.zi();
                    AppMethodBeat.o(9590);
                    return 0;
                case 4:
                    aht.jfl = aVar3.UbS.readString();
                    AppMethodBeat.o(9590);
                    return 0;
                case 5:
                    aht.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(9590);
                    return 0;
                case 6:
                    aht.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(9590);
                    return 0;
                case 7:
                    aht.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(9590);
                    return 0;
                case 8:
                    aht.BsH = aVar3.UbS.zi();
                    AppMethodBeat.o(9590);
                    return 0;
                case 9:
                    aht.Lrz = aVar3.UbS.readString();
                    AppMethodBeat.o(9590);
                    return 0;
                case 10:
                    aht.LrA = aVar3.UbS.zi();
                    AppMethodBeat.o(9590);
                    return 0;
                case 11:
                    aht.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(9590);
                    return 0;
                case 12:
                    aht.LrB = aVar3.UbS.zi();
                    AppMethodBeat.o(9590);
                    return 0;
                case 13:
                    aht.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(9590);
                    return 0;
                default:
                    AppMethodBeat.o(9590);
                    return -1;
            }
        } else {
            AppMethodBeat.o(9590);
            return -1;
        }
    }
}
