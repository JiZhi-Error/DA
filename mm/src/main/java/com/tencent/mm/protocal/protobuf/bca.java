package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bca extends dop {
    public b LLg;
    public String dPI;
    public int offset;
    public String query;
    public int scene;
    public b tVM;
    public aov uli;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169048);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.query != null) {
                aVar.e(2, this.query);
            }
            aVar.aM(3, this.offset);
            if (this.tVM != null) {
                aVar.c(4, this.tVM);
            }
            aVar.aM(5, this.scene);
            if (this.dPI != null) {
                aVar.e(6, this.dPI);
            }
            if (this.uli != null) {
                aVar.ni(7, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            if (this.LLg != null) {
                aVar.c(8, this.LLg);
            }
            AppMethodBeat.o(169048);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.query != null) {
                nh += g.a.a.b.b.a.f(2, this.query);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.offset);
            if (this.tVM != null) {
                bu += g.a.a.b.b.a.b(4, this.tVM);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.scene);
            if (this.dPI != null) {
                bu2 += g.a.a.b.b.a.f(6, this.dPI);
            }
            if (this.uli != null) {
                bu2 += g.a.a.a.nh(7, this.uli.computeSize());
            }
            if (this.LLg != null) {
                bu2 += g.a.a.b.b.a.b(8, this.LLg);
            }
            AppMethodBeat.o(169048);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169048);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bca bca = (bca) objArr[1];
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
                        bca.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(169048);
                    return 0;
                case 2:
                    bca.query = aVar3.UbS.readString();
                    AppMethodBeat.o(169048);
                    return 0;
                case 3:
                    bca.offset = aVar3.UbS.zi();
                    AppMethodBeat.o(169048);
                    return 0;
                case 4:
                    bca.tVM = aVar3.UbS.hPo();
                    AppMethodBeat.o(169048);
                    return 0;
                case 5:
                    bca.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(169048);
                    return 0;
                case 6:
                    bca.dPI = aVar3.UbS.readString();
                    AppMethodBeat.o(169048);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        bca.uli = aov;
                    }
                    AppMethodBeat.o(169048);
                    return 0;
                case 8:
                    bca.LLg = aVar3.UbS.hPo();
                    AppMethodBeat.o(169048);
                    return 0;
                default:
                    AppMethodBeat.o(169048);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169048);
            return -1;
        }
    }
}
