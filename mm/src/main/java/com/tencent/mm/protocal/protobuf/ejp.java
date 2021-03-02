package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ejp extends dop {
    public String KLO;
    public String Lox;
    public cce NiV;
    public int NiW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32471);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Lox != null) {
                aVar.e(2, this.Lox);
            }
            if (this.KLO != null) {
                aVar.e(3, this.KLO);
            }
            if (this.NiV != null) {
                aVar.ni(4, this.NiV.computeSize());
                this.NiV.writeFields(aVar);
            }
            aVar.aM(5, this.NiW);
            AppMethodBeat.o(32471);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Lox != null) {
                nh += g.a.a.b.b.a.f(2, this.Lox);
            }
            if (this.KLO != null) {
                nh += g.a.a.b.b.a.f(3, this.KLO);
            }
            if (this.NiV != null) {
                nh += g.a.a.a.nh(4, this.NiV.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.NiW);
            AppMethodBeat.o(32471);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32471);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ejp ejp = (ejp) objArr[1];
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
                        ejp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32471);
                    return 0;
                case 2:
                    ejp.Lox = aVar3.UbS.readString();
                    AppMethodBeat.o(32471);
                    return 0;
                case 3:
                    ejp.KLO = aVar3.UbS.readString();
                    AppMethodBeat.o(32471);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cce cce = new cce();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cce.populateBuilderWithField(aVar5, cce, dop.getNextFieldNumber(aVar5))) {
                        }
                        ejp.NiV = cce;
                    }
                    AppMethodBeat.o(32471);
                    return 0;
                case 5:
                    ejp.NiW = aVar3.UbS.zi();
                    AppMethodBeat.o(32471);
                    return 0;
                default:
                    AppMethodBeat.o(32471);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32471);
            return -1;
        }
    }
}
