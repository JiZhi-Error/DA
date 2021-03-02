package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class j extends dop {
    public String KBA;
    public String KBB;
    public String KBC;
    public long KBF;
    public String KBt;
    public LinkedList<l> KBx = new LinkedList<>();
    public bf KBy;
    public long KBz;
    public int scene;
    public String title;

    public j() {
        AppMethodBeat.i(91318);
        AppMethodBeat.o(91318);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91319);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            aVar.bb(3, this.KBF);
            aVar.e(5, 8, this.KBx);
            aVar.aM(7, this.scene);
            if (this.KBt != null) {
                aVar.e(8, this.KBt);
            }
            if (this.KBy != null) {
                aVar.ni(9, this.KBy.computeSize());
                this.KBy.writeFields(aVar);
            }
            aVar.bb(10, this.KBz);
            if (this.KBA != null) {
                aVar.e(11, this.KBA);
            }
            if (this.KBB != null) {
                aVar.e(12, this.KBB);
            }
            if (this.KBC != null) {
                aVar.e(13, this.KBC);
            }
            AppMethodBeat.o(91319);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.title != null) {
                nh += g.a.a.b.b.a.f(2, this.title);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.KBF) + g.a.a.a.c(5, 8, this.KBx) + g.a.a.b.b.a.bu(7, this.scene);
            if (this.KBt != null) {
                r += g.a.a.b.b.a.f(8, this.KBt);
            }
            if (this.KBy != null) {
                r += g.a.a.a.nh(9, this.KBy.computeSize());
            }
            int r2 = r + g.a.a.b.b.a.r(10, this.KBz);
            if (this.KBA != null) {
                r2 += g.a.a.b.b.a.f(11, this.KBA);
            }
            if (this.KBB != null) {
                r2 += g.a.a.b.b.a.f(12, this.KBB);
            }
            if (this.KBC != null) {
                r2 += g.a.a.b.b.a.f(13, this.KBC);
            }
            AppMethodBeat.o(91319);
            return r2;
        } else if (i2 == 2) {
            this.KBx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91319);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
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
                        jVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91319);
                    return 0;
                case 2:
                    jVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91319);
                    return 0;
                case 3:
                    jVar.KBF = aVar3.UbS.zl();
                    AppMethodBeat.o(91319);
                    return 0;
                case 4:
                case 6:
                default:
                    AppMethodBeat.o(91319);
                    return -1;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        l lVar = new l();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = lVar.populateBuilderWithField(aVar5, lVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        jVar.KBx.add(lVar);
                    }
                    AppMethodBeat.o(91319);
                    return 0;
                case 7:
                    jVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(91319);
                    return 0;
                case 8:
                    jVar.KBt = aVar3.UbS.readString();
                    AppMethodBeat.o(91319);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bf bfVar = new bf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bfVar.populateBuilderWithField(aVar6, bfVar, dop.getNextFieldNumber(aVar6))) {
                        }
                        jVar.KBy = bfVar;
                    }
                    AppMethodBeat.o(91319);
                    return 0;
                case 10:
                    jVar.KBz = aVar3.UbS.zl();
                    AppMethodBeat.o(91319);
                    return 0;
                case 11:
                    jVar.KBA = aVar3.UbS.readString();
                    AppMethodBeat.o(91319);
                    return 0;
                case 12:
                    jVar.KBB = aVar3.UbS.readString();
                    AppMethodBeat.o(91319);
                    return 0;
                case 13:
                    jVar.KBC = aVar3.UbS.readString();
                    AppMethodBeat.o(91319);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91319);
            return -1;
        }
    }
}
