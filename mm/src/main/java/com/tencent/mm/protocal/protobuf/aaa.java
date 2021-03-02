package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aaa extends dop {
    public int Brl;
    public long Brn;
    public int BsF;
    public String KXr;
    public esg Llj;
    public int Scene;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32166);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KXr != null) {
                aVar.e(2, this.KXr);
            }
            aVar.aM(3, this.BsF);
            aVar.aM(4, this.Brl);
            if (this.Llj != null) {
                aVar.ni(5, this.Llj.computeSize());
                this.Llj.writeFields(aVar);
            }
            aVar.bb(6, this.Brn);
            aVar.aM(7, this.Scene);
            if (this.xNH != null) {
                aVar.e(8, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(9, this.xNG);
            }
            AppMethodBeat.o(32166);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KXr != null) {
                nh += g.a.a.b.b.a.f(2, this.KXr);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.BsF) + g.a.a.b.b.a.bu(4, this.Brl);
            if (this.Llj != null) {
                bu += g.a.a.a.nh(5, this.Llj.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(6, this.Brn) + g.a.a.b.b.a.bu(7, this.Scene);
            if (this.xNH != null) {
                r += g.a.a.b.b.a.f(8, this.xNH);
            }
            if (this.xNG != null) {
                r += g.a.a.b.b.a.f(9, this.xNG);
            }
            AppMethodBeat.o(32166);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32166);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aaa aaa = (aaa) objArr[1];
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
                        aaa.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32166);
                    return 0;
                case 2:
                    aaa.KXr = aVar3.UbS.readString();
                    AppMethodBeat.o(32166);
                    return 0;
                case 3:
                    aaa.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(32166);
                    return 0;
                case 4:
                    aaa.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(32166);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esg esg = new esg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esg.populateBuilderWithField(aVar5, esg, dop.getNextFieldNumber(aVar5))) {
                        }
                        aaa.Llj = esg;
                    }
                    AppMethodBeat.o(32166);
                    return 0;
                case 6:
                    aaa.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(32166);
                    return 0;
                case 7:
                    aaa.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32166);
                    return 0;
                case 8:
                    aaa.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(32166);
                    return 0;
                case 9:
                    aaa.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(32166);
                    return 0;
                default:
                    AppMethodBeat.o(32166);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32166);
            return -1;
        }
    }
}
