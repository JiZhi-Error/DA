package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bng extends dop {
    public String KRe;
    public czu LUV;
    public int LVP;
    public String LVQ;
    public b LVR;
    public boolean LVS;
    public String LjH;
    public String action_data;
    public String person_id;
    public String qGp;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104371);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.person_id != null) {
                aVar.e(2, this.person_id);
            }
            if (this.action_data != null) {
                aVar.e(3, this.action_data);
            }
            aVar.aM(4, this.LVP);
            if (this.LVQ != null) {
                aVar.e(5, this.LVQ);
            }
            if (this.KRe != null) {
                aVar.e(6, this.KRe);
            }
            aVar.aM(7, this.scene);
            if (this.LjH != null) {
                aVar.e(8, this.LjH);
            }
            if (this.qGp != null) {
                aVar.e(9, this.qGp);
            }
            if (this.LUV != null) {
                aVar.ni(10, this.LUV.computeSize());
                this.LUV.writeFields(aVar);
            }
            if (this.LVR != null) {
                aVar.c(11, this.LVR);
            }
            aVar.cc(12, this.LVS);
            AppMethodBeat.o(104371);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.person_id != null) {
                nh += g.a.a.b.b.a.f(2, this.person_id);
            }
            if (this.action_data != null) {
                nh += g.a.a.b.b.a.f(3, this.action_data);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.LVP);
            if (this.LVQ != null) {
                bu += g.a.a.b.b.a.f(5, this.LVQ);
            }
            if (this.KRe != null) {
                bu += g.a.a.b.b.a.f(6, this.KRe);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.scene);
            if (this.LjH != null) {
                bu2 += g.a.a.b.b.a.f(8, this.LjH);
            }
            if (this.qGp != null) {
                bu2 += g.a.a.b.b.a.f(9, this.qGp);
            }
            if (this.LUV != null) {
                bu2 += g.a.a.a.nh(10, this.LUV.computeSize());
            }
            if (this.LVR != null) {
                bu2 += g.a.a.b.b.a.b(11, this.LVR);
            }
            int fS = bu2 + g.a.a.b.b.a.fS(12) + 1;
            AppMethodBeat.o(104371);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104371);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bng bng = (bng) objArr[1];
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
                        bng.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(104371);
                    return 0;
                case 2:
                    bng.person_id = aVar3.UbS.readString();
                    AppMethodBeat.o(104371);
                    return 0;
                case 3:
                    bng.action_data = aVar3.UbS.readString();
                    AppMethodBeat.o(104371);
                    return 0;
                case 4:
                    bng.LVP = aVar3.UbS.zi();
                    AppMethodBeat.o(104371);
                    return 0;
                case 5:
                    bng.LVQ = aVar3.UbS.readString();
                    AppMethodBeat.o(104371);
                    return 0;
                case 6:
                    bng.KRe = aVar3.UbS.readString();
                    AppMethodBeat.o(104371);
                    return 0;
                case 7:
                    bng.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(104371);
                    return 0;
                case 8:
                    bng.LjH = aVar3.UbS.readString();
                    AppMethodBeat.o(104371);
                    return 0;
                case 9:
                    bng.qGp = aVar3.UbS.readString();
                    AppMethodBeat.o(104371);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        czu czu = new czu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = czu.populateBuilderWithField(aVar5, czu, dop.getNextFieldNumber(aVar5))) {
                        }
                        bng.LUV = czu;
                    }
                    AppMethodBeat.o(104371);
                    return 0;
                case 11:
                    bng.LVR = aVar3.UbS.hPo();
                    AppMethodBeat.o(104371);
                    return 0;
                case 12:
                    bng.LVS = aVar3.UbS.yZ();
                    AppMethodBeat.o(104371);
                    return 0;
                default:
                    AppMethodBeat.o(104371);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104371);
            return -1;
        }
    }
}
