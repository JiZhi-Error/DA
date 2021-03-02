package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class enc extends dop {
    public String MTQ;
    public int NkT;
    public int NkU;
    public String NkV;
    public int NkW;
    public String NkX;
    public LinkedList<ece> NkY = new LinkedList<>();
    public int NkZ;
    public int Nla;
    public int cmD;
    public String dGL;
    public String dGP;
    public String ixZ;

    public enc() {
        AppMethodBeat.i(116818);
        AppMethodBeat.o(116818);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116819);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dGL != null) {
                aVar.e(2, this.dGL);
            }
            if (this.dGP != null) {
                aVar.e(3, this.dGP);
            }
            aVar.aM(4, this.NkT);
            aVar.aM(5, this.NkU);
            aVar.aM(6, this.cmD);
            if (this.NkV != null) {
                aVar.e(7, this.NkV);
            }
            if (this.MTQ != null) {
                aVar.e(8, this.MTQ);
            }
            if (this.ixZ != null) {
                aVar.e(9, this.ixZ);
            }
            aVar.aM(10, this.NkW);
            if (this.NkX != null) {
                aVar.e(11, this.NkX);
            }
            aVar.e(12, 8, this.NkY);
            aVar.aM(13, this.NkZ);
            aVar.aM(14, this.Nla);
            AppMethodBeat.o(116819);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dGL != null) {
                nh += g.a.a.b.b.a.f(2, this.dGL);
            }
            if (this.dGP != null) {
                nh += g.a.a.b.b.a.f(3, this.dGP);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.NkT) + g.a.a.b.b.a.bu(5, this.NkU) + g.a.a.b.b.a.bu(6, this.cmD);
            if (this.NkV != null) {
                bu += g.a.a.b.b.a.f(7, this.NkV);
            }
            if (this.MTQ != null) {
                bu += g.a.a.b.b.a.f(8, this.MTQ);
            }
            if (this.ixZ != null) {
                bu += g.a.a.b.b.a.f(9, this.ixZ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.NkW);
            if (this.NkX != null) {
                bu2 += g.a.a.b.b.a.f(11, this.NkX);
            }
            int c2 = bu2 + g.a.a.a.c(12, 8, this.NkY) + g.a.a.b.b.a.bu(13, this.NkZ) + g.a.a.b.b.a.bu(14, this.Nla);
            AppMethodBeat.o(116819);
            return c2;
        } else if (i2 == 2) {
            this.NkY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116819);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            enc enc = (enc) objArr[1];
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
                        enc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(116819);
                    return 0;
                case 2:
                    enc.dGL = aVar3.UbS.readString();
                    AppMethodBeat.o(116819);
                    return 0;
                case 3:
                    enc.dGP = aVar3.UbS.readString();
                    AppMethodBeat.o(116819);
                    return 0;
                case 4:
                    enc.NkT = aVar3.UbS.zi();
                    AppMethodBeat.o(116819);
                    return 0;
                case 5:
                    enc.NkU = aVar3.UbS.zi();
                    AppMethodBeat.o(116819);
                    return 0;
                case 6:
                    enc.cmD = aVar3.UbS.zi();
                    AppMethodBeat.o(116819);
                    return 0;
                case 7:
                    enc.NkV = aVar3.UbS.readString();
                    AppMethodBeat.o(116819);
                    return 0;
                case 8:
                    enc.MTQ = aVar3.UbS.readString();
                    AppMethodBeat.o(116819);
                    return 0;
                case 9:
                    enc.ixZ = aVar3.UbS.readString();
                    AppMethodBeat.o(116819);
                    return 0;
                case 10:
                    enc.NkW = aVar3.UbS.zi();
                    AppMethodBeat.o(116819);
                    return 0;
                case 11:
                    enc.NkX = aVar3.UbS.readString();
                    AppMethodBeat.o(116819);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ece ece = new ece();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ece.populateBuilderWithField(aVar5, ece, dop.getNextFieldNumber(aVar5))) {
                        }
                        enc.NkY.add(ece);
                    }
                    AppMethodBeat.o(116819);
                    return 0;
                case 13:
                    enc.NkZ = aVar3.UbS.zi();
                    AppMethodBeat.o(116819);
                    return 0;
                case 14:
                    enc.Nla = aVar3.UbS.zi();
                    AppMethodBeat.o(116819);
                    return 0;
                default:
                    AppMethodBeat.o(116819);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116819);
            return -1;
        }
    }
}
