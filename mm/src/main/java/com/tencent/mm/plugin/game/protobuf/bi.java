package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bi extends dop {
    public int Scene;
    public String keh;
    public String xLl;
    public int xLm;
    public f xLn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(149415);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.xLl == null) {
                b bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(149415);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xLl != null) {
                aVar.e(2, this.xLl);
            }
            if (this.keh != null) {
                aVar.e(3, this.keh);
            }
            aVar.aM(4, this.xLm);
            if (this.xLn != null) {
                aVar.ni(5, this.xLn.computeSize());
                this.xLn.writeFields(aVar);
            }
            aVar.aM(7, this.Scene);
            AppMethodBeat.o(149415);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.xLl != null) {
                nh += g.a.a.b.b.a.f(2, this.xLl);
            }
            if (this.keh != null) {
                nh += g.a.a.b.b.a.f(3, this.keh);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.xLm);
            if (this.xLn != null) {
                bu += g.a.a.a.nh(5, this.xLn.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Scene);
            AppMethodBeat.o(149415);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xLl == null) {
                b bVar2 = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(149415);
                throw bVar2;
            }
            AppMethodBeat.o(149415);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bi biVar = (bi) objArr[1];
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
                        biVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(149415);
                    return 0;
                case 2:
                    biVar.xLl = aVar3.UbS.readString();
                    AppMethodBeat.o(149415);
                    return 0;
                case 3:
                    biVar.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(149415);
                    return 0;
                case 4:
                    biVar.xLm = aVar3.UbS.zi();
                    AppMethodBeat.o(149415);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        f fVar = new f();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fVar.populateBuilderWithField(aVar5, fVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        biVar.xLn = fVar;
                    }
                    AppMethodBeat.o(149415);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(149415);
                    return -1;
                case 7:
                    biVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(149415);
                    return 0;
            }
        } else {
            AppMethodBeat.o(149415);
            return -1;
        }
    }
}
