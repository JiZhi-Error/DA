package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class axb extends dop {
    public String LAt;
    public aov LBM;
    public String LFM;
    public String LFP;
    public int LFQ;
    public int LFR;
    public b LFp;
    public boolean Vjp;
    public String Vjq;
    public long hyH;
    public long object_id;
    public String request_id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209554);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LBM != null) {
                aVar.ni(2, this.LBM.computeSize());
                this.LBM.writeFields(aVar);
            }
            if (this.LAt != null) {
                aVar.e(3, this.LAt);
            }
            aVar.bb(4, this.object_id);
            aVar.bb(5, this.hyH);
            if (this.LFM != null) {
                aVar.e(6, this.LFM);
            }
            aVar.aM(7, this.LFQ);
            aVar.aM(8, this.LFR);
            if (this.request_id != null) {
                aVar.e(9, this.request_id);
            }
            if (this.LFP != null) {
                aVar.e(10, this.LFP);
            }
            if (this.LFp != null) {
                aVar.c(11, this.LFp);
            }
            aVar.cc(12, this.Vjp);
            if (this.Vjq != null) {
                aVar.e(13, this.Vjq);
            }
            AppMethodBeat.o(209554);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LBM != null) {
                nh += g.a.a.a.nh(2, this.LBM.computeSize());
            }
            if (this.LAt != null) {
                nh += g.a.a.b.b.a.f(3, this.LAt);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.object_id) + g.a.a.b.b.a.r(5, this.hyH);
            if (this.LFM != null) {
                r += g.a.a.b.b.a.f(6, this.LFM);
            }
            int bu = r + g.a.a.b.b.a.bu(7, this.LFQ) + g.a.a.b.b.a.bu(8, this.LFR);
            if (this.request_id != null) {
                bu += g.a.a.b.b.a.f(9, this.request_id);
            }
            if (this.LFP != null) {
                bu += g.a.a.b.b.a.f(10, this.LFP);
            }
            if (this.LFp != null) {
                bu += g.a.a.b.b.a.b(11, this.LFp);
            }
            int fS = bu + g.a.a.b.b.a.fS(12) + 1;
            if (this.Vjq != null) {
                fS += g.a.a.b.b.a.f(13, this.Vjq);
            }
            AppMethodBeat.o(209554);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209554);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axb axb = (axb) objArr[1];
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
                        axb.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209554);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        axb.LBM = aov;
                    }
                    AppMethodBeat.o(209554);
                    return 0;
                case 3:
                    axb.LAt = aVar3.UbS.readString();
                    AppMethodBeat.o(209554);
                    return 0;
                case 4:
                    axb.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(209554);
                    return 0;
                case 5:
                    axb.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(209554);
                    return 0;
                case 6:
                    axb.LFM = aVar3.UbS.readString();
                    AppMethodBeat.o(209554);
                    return 0;
                case 7:
                    axb.LFQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209554);
                    return 0;
                case 8:
                    axb.LFR = aVar3.UbS.zi();
                    AppMethodBeat.o(209554);
                    return 0;
                case 9:
                    axb.request_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209554);
                    return 0;
                case 10:
                    axb.LFP = aVar3.UbS.readString();
                    AppMethodBeat.o(209554);
                    return 0;
                case 11:
                    axb.LFp = aVar3.UbS.hPo();
                    AppMethodBeat.o(209554);
                    return 0;
                case 12:
                    axb.Vjp = aVar3.UbS.yZ();
                    AppMethodBeat.o(209554);
                    return 0;
                case 13:
                    axb.Vjq = aVar3.UbS.readString();
                    AppMethodBeat.o(209554);
                    return 0;
                default:
                    AppMethodBeat.o(209554);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209554);
            return -1;
        }
    }
}
