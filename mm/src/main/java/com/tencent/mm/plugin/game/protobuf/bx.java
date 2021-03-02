package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bx extends dop {
    public String keh;
    public int xLV;
    public int xLW;
    public String xLl;
    public int xMd;
    public int xMe;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41781);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.xLl == null) {
                b bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(41781);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.xLV);
            aVar.aM(3, this.xLW);
            if (this.xLl != null) {
                aVar.e(4, this.xLl);
            }
            aVar.aM(5, this.xMd);
            aVar.aM(6, this.xMe);
            if (this.keh != null) {
                aVar.e(7, this.keh);
            }
            AppMethodBeat.o(41781);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xLV) + g.a.a.b.b.a.bu(3, this.xLW);
            if (this.xLl != null) {
                nh += g.a.a.b.b.a.f(4, this.xLl);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.xMd) + g.a.a.b.b.a.bu(6, this.xMe);
            if (this.keh != null) {
                bu += g.a.a.b.b.a.f(7, this.keh);
            }
            AppMethodBeat.o(41781);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xLl == null) {
                b bVar2 = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(41781);
                throw bVar2;
            }
            AppMethodBeat.o(41781);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bx bxVar = (bx) objArr[1];
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
                        bxVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(41781);
                    return 0;
                case 2:
                    bxVar.xLV = aVar3.UbS.zi();
                    AppMethodBeat.o(41781);
                    return 0;
                case 3:
                    bxVar.xLW = aVar3.UbS.zi();
                    AppMethodBeat.o(41781);
                    return 0;
                case 4:
                    bxVar.xLl = aVar3.UbS.readString();
                    AppMethodBeat.o(41781);
                    return 0;
                case 5:
                    bxVar.xMd = aVar3.UbS.zi();
                    AppMethodBeat.o(41781);
                    return 0;
                case 6:
                    bxVar.xMe = aVar3.UbS.zi();
                    AppMethodBeat.o(41781);
                    return 0;
                case 7:
                    bxVar.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(41781);
                    return 0;
                default:
                    AppMethodBeat.o(41781);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41781);
            return -1;
        }
    }
}
