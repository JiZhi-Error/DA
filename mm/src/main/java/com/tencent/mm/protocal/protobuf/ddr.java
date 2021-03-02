package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ddr extends dpc {
    public String KDq;
    public String KDr;
    public String LFY;
    public String MIE;
    public String MIF;
    public String MIG;
    public String MIH;
    public String content;
    public String pTK;
    public boolean pUu;
    public int status;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114055);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.KDq != null) {
                aVar.e(2, this.KDq);
            }
            if (this.KDr != null) {
                aVar.e(3, this.KDr);
            }
            aVar.aM(4, this.status);
            if (this.content != null) {
                aVar.e(5, this.content);
            }
            if (this.pTK != null) {
                aVar.e(6, this.pTK);
            }
            if (this.LFY != null) {
                aVar.e(7, this.LFY);
            }
            aVar.cc(8, this.pUu);
            if (this.MIE != null) {
                aVar.e(9, this.MIE);
            }
            if (this.MIF != null) {
                aVar.e(10, this.MIF);
            }
            if (this.MIG != null) {
                aVar.e(11, this.MIG);
            }
            if (this.MIH != null) {
                aVar.e(12, this.MIH);
            }
            AppMethodBeat.o(114055);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KDq != null) {
                nh += g.a.a.b.b.a.f(2, this.KDq);
            }
            if (this.KDr != null) {
                nh += g.a.a.b.b.a.f(3, this.KDr);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.status);
            if (this.content != null) {
                bu += g.a.a.b.b.a.f(5, this.content);
            }
            if (this.pTK != null) {
                bu += g.a.a.b.b.a.f(6, this.pTK);
            }
            if (this.LFY != null) {
                bu += g.a.a.b.b.a.f(7, this.LFY);
            }
            int fS = bu + g.a.a.b.b.a.fS(8) + 1;
            if (this.MIE != null) {
                fS += g.a.a.b.b.a.f(9, this.MIE);
            }
            if (this.MIF != null) {
                fS += g.a.a.b.b.a.f(10, this.MIF);
            }
            if (this.MIG != null) {
                fS += g.a.a.b.b.a.f(11, this.MIG);
            }
            if (this.MIH != null) {
                fS += g.a.a.b.b.a.f(12, this.MIH);
            }
            AppMethodBeat.o(114055);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114055);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddr ddr = (ddr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        ddr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114055);
                    return 0;
                case 2:
                    ddr.KDq = aVar3.UbS.readString();
                    AppMethodBeat.o(114055);
                    return 0;
                case 3:
                    ddr.KDr = aVar3.UbS.readString();
                    AppMethodBeat.o(114055);
                    return 0;
                case 4:
                    ddr.status = aVar3.UbS.zi();
                    AppMethodBeat.o(114055);
                    return 0;
                case 5:
                    ddr.content = aVar3.UbS.readString();
                    AppMethodBeat.o(114055);
                    return 0;
                case 6:
                    ddr.pTK = aVar3.UbS.readString();
                    AppMethodBeat.o(114055);
                    return 0;
                case 7:
                    ddr.LFY = aVar3.UbS.readString();
                    AppMethodBeat.o(114055);
                    return 0;
                case 8:
                    ddr.pUu = aVar3.UbS.yZ();
                    AppMethodBeat.o(114055);
                    return 0;
                case 9:
                    ddr.MIE = aVar3.UbS.readString();
                    AppMethodBeat.o(114055);
                    return 0;
                case 10:
                    ddr.MIF = aVar3.UbS.readString();
                    AppMethodBeat.o(114055);
                    return 0;
                case 11:
                    ddr.MIG = aVar3.UbS.readString();
                    AppMethodBeat.o(114055);
                    return 0;
                case 12:
                    ddr.MIH = aVar3.UbS.readString();
                    AppMethodBeat.o(114055);
                    return 0;
                default:
                    AppMethodBeat.o(114055);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114055);
            return -1;
        }
    }
}
