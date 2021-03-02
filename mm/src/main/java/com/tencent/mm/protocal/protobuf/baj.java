package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class baj extends dop {
    public FinderObjectDesc LJZ;
    public int LKa;
    public String LKb;
    public int scene;
    public aov uli;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209633);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.uli != null) {
                aVar.ni(2, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(3, this.username);
            }
            if (this.LJZ != null) {
                aVar.ni(4, this.LJZ.computeSize());
                this.LJZ.writeFields(aVar);
            }
            aVar.aM(5, this.LKa);
            if (this.LKb != null) {
                aVar.e(6, this.LKb);
            }
            aVar.aM(7, this.scene);
            AppMethodBeat.o(209633);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.uli != null) {
                nh += g.a.a.a.nh(2, this.uli.computeSize());
            }
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(3, this.username);
            }
            if (this.LJZ != null) {
                nh += g.a.a.a.nh(4, this.LJZ.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.LKa);
            if (this.LKb != null) {
                bu += g.a.a.b.b.a.f(6, this.LKb);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.scene);
            AppMethodBeat.o(209633);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209633);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            baj baj = (baj) objArr[1];
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
                        baj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209633);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        baj.uli = aov;
                    }
                    AppMethodBeat.o(209633);
                    return 0;
                case 3:
                    baj.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209633);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderObjectDesc.populateBuilderWithField(aVar6, finderObjectDesc, dop.getNextFieldNumber(aVar6))) {
                        }
                        baj.LJZ = finderObjectDesc;
                    }
                    AppMethodBeat.o(209633);
                    return 0;
                case 5:
                    baj.LKa = aVar3.UbS.zi();
                    AppMethodBeat.o(209633);
                    return 0;
                case 6:
                    baj.LKb = aVar3.UbS.readString();
                    AppMethodBeat.o(209633);
                    return 0;
                case 7:
                    baj.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209633);
                    return 0;
                default:
                    AppMethodBeat.o(209633);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209633);
            return -1;
        }
    }
}
