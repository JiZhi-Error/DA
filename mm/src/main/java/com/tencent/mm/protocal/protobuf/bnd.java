package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bnd extends dpc {
    public LinkedList<ey> KKx = new LinkedList<>();
    public int LVG;
    public int LVH;
    public LinkedList<Integer> LVI = new LinkedList<>();
    public LinkedList<akl> LVJ = new LinkedList<>();
    public int LVL;

    public bnd() {
        AppMethodBeat.i(122505);
        AppMethodBeat.o(122505);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122506);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(122506);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LVG);
            aVar.aM(3, this.LVH);
            aVar.e(4, 2, this.LVI);
            aVar.e(5, 8, this.LVJ);
            aVar.aM(6, this.LVL);
            aVar.e(7, 8, this.KKx);
            AppMethodBeat.o(122506);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LVG) + g.a.a.b.b.a.bu(3, this.LVH) + g.a.a.a.c(4, 2, this.LVI) + g.a.a.a.c(5, 8, this.LVJ) + g.a.a.b.b.a.bu(6, this.LVL) + g.a.a.a.c(7, 8, this.KKx);
            AppMethodBeat.o(122506);
            return nh;
        } else if (i2 == 2) {
            this.LVI.clear();
            this.LVJ.clear();
            this.KKx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(122506);
                throw bVar2;
            }
            AppMethodBeat.o(122506);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bnd bnd = (bnd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        bnd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(122506);
                    return 0;
                case 2:
                    bnd.LVG = aVar3.UbS.zi();
                    AppMethodBeat.o(122506);
                    return 0;
                case 3:
                    bnd.LVH = aVar3.UbS.zi();
                    AppMethodBeat.o(122506);
                    return 0;
                case 4:
                    bnd.LVI.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(122506);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        akl akl = new akl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = akl.populateBuilderWithField(aVar5, akl, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bnd.LVJ.add(akl);
                    }
                    AppMethodBeat.o(122506);
                    return 0;
                case 6:
                    bnd.LVL = aVar3.UbS.zi();
                    AppMethodBeat.o(122506);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ey eyVar = new ey();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eyVar.populateBuilderWithField(aVar6, eyVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bnd.KKx.add(eyVar);
                    }
                    AppMethodBeat.o(122506);
                    return 0;
                default:
                    AppMethodBeat.o(122506);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122506);
            return -1;
        }
    }
}
