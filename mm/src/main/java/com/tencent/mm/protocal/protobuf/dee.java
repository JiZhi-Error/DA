package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dee extends dpc {
    public int KOt;
    public String KOu;
    public int LXb;
    public String Lca;
    public LinkedList<akg> MJk = new LinkedList<>();
    public LinkedList<bd> MJl = new LinkedList<>();
    public int MJm;

    public dee() {
        AppMethodBeat.i(91628);
        AppMethodBeat.o(91628);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91629);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LXb);
            aVar.e(3, 8, this.MJk);
            if (this.Lca != null) {
                aVar.e(4, this.Lca);
            }
            aVar.aM(5, this.KOt);
            if (this.KOu != null) {
                aVar.e(6, this.KOu);
            }
            aVar.e(7, 8, this.MJl);
            aVar.aM(8, this.MJm);
            AppMethodBeat.o(91629);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LXb) + g.a.a.a.c(3, 8, this.MJk);
            if (this.Lca != null) {
                nh += g.a.a.b.b.a.f(4, this.Lca);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KOt);
            if (this.KOu != null) {
                bu += g.a.a.b.b.a.f(6, this.KOu);
            }
            int c2 = bu + g.a.a.a.c(7, 8, this.MJl) + g.a.a.b.b.a.bu(8, this.MJm);
            AppMethodBeat.o(91629);
            return c2;
        } else if (i2 == 2) {
            this.MJk.clear();
            this.MJl.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91629);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dee dee = (dee) objArr[1];
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
                        dee.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91629);
                    return 0;
                case 2:
                    dee.LXb = aVar3.UbS.zi();
                    AppMethodBeat.o(91629);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        akg akg = new akg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = akg.populateBuilderWithField(aVar5, akg, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dee.MJk.add(akg);
                    }
                    AppMethodBeat.o(91629);
                    return 0;
                case 4:
                    dee.Lca = aVar3.UbS.readString();
                    AppMethodBeat.o(91629);
                    return 0;
                case 5:
                    dee.KOt = aVar3.UbS.zi();
                    AppMethodBeat.o(91629);
                    return 0;
                case 6:
                    dee.KOu = aVar3.UbS.readString();
                    AppMethodBeat.o(91629);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bd bdVar = new bd();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bdVar.populateBuilderWithField(aVar6, bdVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dee.MJl.add(bdVar);
                    }
                    AppMethodBeat.o(91629);
                    return 0;
                case 8:
                    dee.MJm = aVar3.UbS.zi();
                    AppMethodBeat.o(91629);
                    return 0;
                default:
                    AppMethodBeat.o(91629);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91629);
            return -1;
        }
    }
}
