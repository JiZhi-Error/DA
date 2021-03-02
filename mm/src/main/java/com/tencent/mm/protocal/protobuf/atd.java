package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class atd extends dop {
    public int LEa;
    public int scene;
    public b tsO;
    public int tvu;
    public aov uli;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168988);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LEa);
            if (this.tsO != null) {
                aVar.c(3, this.tsO);
            }
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            aVar.aM(5, this.scene);
            if (this.uli != null) {
                aVar.ni(6, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            aVar.aM(7, this.tvu);
            AppMethodBeat.o(168988);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LEa);
            if (this.tsO != null) {
                nh += g.a.a.b.b.a.b(3, this.tsO);
            }
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(4, this.username);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.scene);
            if (this.uli != null) {
                bu += g.a.a.a.nh(6, this.uli.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.tvu);
            AppMethodBeat.o(168988);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168988);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            atd atd = (atd) objArr[1];
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
                        atd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(168988);
                    return 0;
                case 2:
                    atd.LEa = aVar3.UbS.zi();
                    AppMethodBeat.o(168988);
                    return 0;
                case 3:
                    atd.tsO = aVar3.UbS.hPo();
                    AppMethodBeat.o(168988);
                    return 0;
                case 4:
                    atd.username = aVar3.UbS.readString();
                    AppMethodBeat.o(168988);
                    return 0;
                case 5:
                    atd.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(168988);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        atd.uli = aov;
                    }
                    AppMethodBeat.o(168988);
                    return 0;
                case 7:
                    atd.tvu = aVar3.UbS.zi();
                    AppMethodBeat.o(168988);
                    return 0;
                default:
                    AppMethodBeat.o(168988);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168988);
            return -1;
        }
    }
}
