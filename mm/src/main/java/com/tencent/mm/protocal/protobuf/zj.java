package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class zj extends dop {
    public String LkD;
    public LinkedList<dxm> LkE = new LinkedList<>();
    public LinkedList<dxo> LkF = new LinkedList<>();
    public LinkedList<dxl> LkG = new LinkedList<>();
    public LinkedList<dxk> LkH = new LinkedList<>();
    public LinkedList<dxn> LkI = new LinkedList<>();
    public int oUv;

    public zj() {
        AppMethodBeat.i(32163);
        AppMethodBeat.o(32163);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32164);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.oUv);
            if (this.LkD != null) {
                aVar.e(3, this.LkD);
            }
            aVar.e(4, 8, this.LkE);
            aVar.e(5, 8, this.LkF);
            aVar.e(6, 8, this.LkG);
            aVar.e(7, 8, this.LkH);
            aVar.e(8, 8, this.LkI);
            AppMethodBeat.o(32164);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUv);
            if (this.LkD != null) {
                nh += g.a.a.b.b.a.f(3, this.LkD);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.LkE) + g.a.a.a.c(5, 8, this.LkF) + g.a.a.a.c(6, 8, this.LkG) + g.a.a.a.c(7, 8, this.LkH) + g.a.a.a.c(8, 8, this.LkI);
            AppMethodBeat.o(32164);
            return c2;
        } else if (i2 == 2) {
            this.LkE.clear();
            this.LkF.clear();
            this.LkG.clear();
            this.LkH.clear();
            this.LkI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32164);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            zj zjVar = (zj) objArr[1];
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
                        zjVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32164);
                    return 0;
                case 2:
                    zjVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32164);
                    return 0;
                case 3:
                    zjVar.LkD = aVar3.UbS.readString();
                    AppMethodBeat.o(32164);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dxm dxm = new dxm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dxm.populateBuilderWithField(aVar5, dxm, dop.getNextFieldNumber(aVar5))) {
                        }
                        zjVar.LkE.add(dxm);
                    }
                    AppMethodBeat.o(32164);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dxo dxo = new dxo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dxo.populateBuilderWithField(aVar6, dxo, dop.getNextFieldNumber(aVar6))) {
                        }
                        zjVar.LkF.add(dxo);
                    }
                    AppMethodBeat.o(32164);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dxl dxl = new dxl();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dxl.populateBuilderWithField(aVar7, dxl, dop.getNextFieldNumber(aVar7))) {
                        }
                        zjVar.LkG.add(dxl);
                    }
                    AppMethodBeat.o(32164);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dxk dxk = new dxk();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dxk.populateBuilderWithField(aVar8, dxk, dop.getNextFieldNumber(aVar8))) {
                        }
                        zjVar.LkH.add(dxk);
                    }
                    AppMethodBeat.o(32164);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dxn dxn = new dxn();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dxn.populateBuilderWithField(aVar9, dxn, dop.getNextFieldNumber(aVar9))) {
                        }
                        zjVar.LkI.add(dxn);
                    }
                    AppMethodBeat.o(32164);
                    return 0;
                default:
                    AppMethodBeat.o(32164);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32164);
            return -1;
        }
    }
}
