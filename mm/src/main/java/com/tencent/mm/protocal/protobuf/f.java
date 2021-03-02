package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class f extends dop {
    public String KBA;
    public String KBB;
    public String KBC;
    public String KBt;
    public int KBv;
    public long KBw;
    public LinkedList<String> KBx = new LinkedList<>();
    public bf KBy;
    public long KBz;
    public int scene;
    public String title;

    public f() {
        AppMethodBeat.i(91315);
        AppMethodBeat.o(91315);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91316);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.KBv);
            aVar.bb(3, this.KBw);
            if (this.title != null) {
                aVar.e(4, this.title);
            }
            aVar.e(5, 1, this.KBx);
            aVar.aM(6, this.scene);
            if (this.KBt != null) {
                aVar.e(7, this.KBt);
            }
            if (this.KBy != null) {
                aVar.ni(8, this.KBy.computeSize());
                this.KBy.writeFields(aVar);
            }
            aVar.bb(9, this.KBz);
            if (this.KBA != null) {
                aVar.e(10, this.KBA);
            }
            if (this.KBB != null) {
                aVar.e(11, this.KBB);
            }
            if (this.KBC != null) {
                aVar.e(12, this.KBC);
            }
            AppMethodBeat.o(91316);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KBv) + g.a.a.b.b.a.r(3, this.KBw);
            if (this.title != null) {
                nh += g.a.a.b.b.a.f(4, this.title);
            }
            int c2 = nh + g.a.a.a.c(5, 1, this.KBx) + g.a.a.b.b.a.bu(6, this.scene);
            if (this.KBt != null) {
                c2 += g.a.a.b.b.a.f(7, this.KBt);
            }
            if (this.KBy != null) {
                c2 += g.a.a.a.nh(8, this.KBy.computeSize());
            }
            int r = c2 + g.a.a.b.b.a.r(9, this.KBz);
            if (this.KBA != null) {
                r += g.a.a.b.b.a.f(10, this.KBA);
            }
            if (this.KBB != null) {
                r += g.a.a.b.b.a.f(11, this.KBB);
            }
            if (this.KBC != null) {
                r += g.a.a.b.b.a.f(12, this.KBC);
            }
            AppMethodBeat.o(91316);
            return r;
        } else if (i2 == 2) {
            this.KBx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91316);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
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
                        fVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91316);
                    return 0;
                case 2:
                    fVar.KBv = aVar3.UbS.zi();
                    AppMethodBeat.o(91316);
                    return 0;
                case 3:
                    fVar.KBw = aVar3.UbS.zl();
                    AppMethodBeat.o(91316);
                    return 0;
                case 4:
                    fVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91316);
                    return 0;
                case 5:
                    fVar.KBx.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91316);
                    return 0;
                case 6:
                    fVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(91316);
                    return 0;
                case 7:
                    fVar.KBt = aVar3.UbS.readString();
                    AppMethodBeat.o(91316);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bf bfVar = new bf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bfVar.populateBuilderWithField(aVar5, bfVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        fVar.KBy = bfVar;
                    }
                    AppMethodBeat.o(91316);
                    return 0;
                case 9:
                    fVar.KBz = aVar3.UbS.zl();
                    AppMethodBeat.o(91316);
                    return 0;
                case 10:
                    fVar.KBA = aVar3.UbS.readString();
                    AppMethodBeat.o(91316);
                    return 0;
                case 11:
                    fVar.KBB = aVar3.UbS.readString();
                    AppMethodBeat.o(91316);
                    return 0;
                case 12:
                    fVar.KBC = aVar3.UbS.readString();
                    AppMethodBeat.o(91316);
                    return 0;
                default:
                    AppMethodBeat.o(91316);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91316);
            return -1;
        }
    }
}
