package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class clv extends a {
    public int MaY;
    public chl MlQ;
    public aah MlR;
    public long Mri;
    public String Mrj;
    public int Scene;
    public String SessionId;
    public String rBI;
    public int xMB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117878);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Scene);
            aVar.aM(2, this.MaY);
            if (this.MlQ != null) {
                aVar.ni(3, this.MlQ.computeSize());
                this.MlQ.writeFields(aVar);
            }
            aVar.aM(4, this.xMB);
            if (this.rBI != null) {
                aVar.e(5, this.rBI);
            }
            aVar.bb(6, this.Mri);
            if (this.SessionId != null) {
                aVar.e(7, this.SessionId);
            }
            if (this.Mrj != null) {
                aVar.e(8, this.Mrj);
            }
            if (this.MlR != null) {
                aVar.ni(9, this.MlR.computeSize());
                this.MlR.writeFields(aVar);
            }
            AppMethodBeat.o(117878);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Scene) + 0 + g.a.a.b.b.a.bu(2, this.MaY);
            if (this.MlQ != null) {
                bu += g.a.a.a.nh(3, this.MlQ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.xMB);
            if (this.rBI != null) {
                bu2 += g.a.a.b.b.a.f(5, this.rBI);
            }
            int r = bu2 + g.a.a.b.b.a.r(6, this.Mri);
            if (this.SessionId != null) {
                r += g.a.a.b.b.a.f(7, this.SessionId);
            }
            if (this.Mrj != null) {
                r += g.a.a.b.b.a.f(8, this.Mrj);
            }
            if (this.MlR != null) {
                r += g.a.a.a.nh(9, this.MlR.computeSize());
            }
            AppMethodBeat.o(117878);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117878);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            clv clv = (clv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    clv.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117878);
                    return 0;
                case 2:
                    clv.MaY = aVar3.UbS.zi();
                    AppMethodBeat.o(117878);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        chl chl = new chl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = chl.populateBuilderWithField(aVar4, chl, a.getNextFieldNumber(aVar4))) {
                        }
                        clv.MlQ = chl;
                    }
                    AppMethodBeat.o(117878);
                    return 0;
                case 4:
                    clv.xMB = aVar3.UbS.zi();
                    AppMethodBeat.o(117878);
                    return 0;
                case 5:
                    clv.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(117878);
                    return 0;
                case 6:
                    clv.Mri = aVar3.UbS.zl();
                    AppMethodBeat.o(117878);
                    return 0;
                case 7:
                    clv.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(117878);
                    return 0;
                case 8:
                    clv.Mrj = aVar3.UbS.readString();
                    AppMethodBeat.o(117878);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aah aah = new aah();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aah.populateBuilderWithField(aVar5, aah, a.getNextFieldNumber(aVar5))) {
                        }
                        clv.MlR = aah;
                    }
                    AppMethodBeat.o(117878);
                    return 0;
                default:
                    AppMethodBeat.o(117878);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117878);
            return -1;
        }
    }
}
