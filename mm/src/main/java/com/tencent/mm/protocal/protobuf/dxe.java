package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dxe extends dop {
    public eck KDj;
    public String LTz;
    public int MXj;
    public dxy MXk;
    public int eaQ;
    public String gTT;
    public LinkedList<dxg> iAd = new LinkedList<>();

    public dxe() {
        AppMethodBeat.i(114070);
        AppMethodBeat.o(114070);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114071);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MXj);
            aVar.e(3, 8, this.iAd);
            if (this.gTT != null) {
                aVar.e(4, this.gTT);
            }
            if (this.LTz != null) {
                aVar.e(5, this.LTz);
            }
            if (this.MXk != null) {
                aVar.ni(6, this.MXk.computeSize());
                this.MXk.writeFields(aVar);
            }
            aVar.aM(7, this.eaQ);
            if (this.KDj != null) {
                aVar.ni(8, this.KDj.computeSize());
                this.KDj.writeFields(aVar);
            }
            AppMethodBeat.o(114071);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MXj) + g.a.a.a.c(3, 8, this.iAd);
            if (this.gTT != null) {
                nh += g.a.a.b.b.a.f(4, this.gTT);
            }
            if (this.LTz != null) {
                nh += g.a.a.b.b.a.f(5, this.LTz);
            }
            if (this.MXk != null) {
                nh += g.a.a.a.nh(6, this.MXk.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.eaQ);
            if (this.KDj != null) {
                bu += g.a.a.a.nh(8, this.KDj.computeSize());
            }
            AppMethodBeat.o(114071);
            return bu;
        } else if (i2 == 2) {
            this.iAd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114071);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dxe dxe = (dxe) objArr[1];
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
                        dxe.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(114071);
                    return 0;
                case 2:
                    dxe.MXj = aVar3.UbS.zi();
                    AppMethodBeat.o(114071);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dxg dxg = new dxg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dxg.populateBuilderWithField(aVar5, dxg, dop.getNextFieldNumber(aVar5))) {
                        }
                        dxe.iAd.add(dxg);
                    }
                    AppMethodBeat.o(114071);
                    return 0;
                case 4:
                    dxe.gTT = aVar3.UbS.readString();
                    AppMethodBeat.o(114071);
                    return 0;
                case 5:
                    dxe.LTz = aVar3.UbS.readString();
                    AppMethodBeat.o(114071);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dxy dxy = new dxy();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dxy.populateBuilderWithField(aVar6, dxy, dop.getNextFieldNumber(aVar6))) {
                        }
                        dxe.MXk = dxy;
                    }
                    AppMethodBeat.o(114071);
                    return 0;
                case 7:
                    dxe.eaQ = aVar3.UbS.zi();
                    AppMethodBeat.o(114071);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eck eck = new eck();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eck.populateBuilderWithField(aVar7, eck, dop.getNextFieldNumber(aVar7))) {
                        }
                        dxe.KDj = eck;
                    }
                    AppMethodBeat.o(114071);
                    return 0;
                default:
                    AppMethodBeat.o(114071);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114071);
            return -1;
        }
    }
}
