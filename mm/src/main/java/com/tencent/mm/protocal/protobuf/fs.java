package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fs extends dop {
    public int KIK;
    public int KIL;
    public int KJl;
    public int KJm;
    public long KJn;
    public long KJo;
    public ql KJp;
    public int KJq;
    public int KJr;
    public int KJs;
    public String KJt;
    public int nettype;
    public int scene;
    public String session_id;
    public String url;
    public String vid;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103194);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.vid != null) {
                aVar.e(3, this.vid);
            }
            aVar.aM(4, this.scene);
            aVar.aM(5, this.KIL);
            aVar.aM(6, this.nettype);
            if (this.session_id != null) {
                aVar.e(7, this.session_id);
            }
            aVar.aM(8, this.KIK);
            aVar.aM(9, this.KJl);
            aVar.aM(10, this.KJm);
            aVar.bb(11, this.KJn);
            aVar.bb(12, this.KJo);
            if (this.KJp != null) {
                aVar.ni(13, this.KJp.computeSize());
                this.KJp.writeFields(aVar);
            }
            aVar.aM(14, this.KJq);
            aVar.aM(15, this.KJr);
            aVar.aM(16, this.KJs);
            if (this.KJt != null) {
                aVar.e(17, this.KJt);
            }
            AppMethodBeat.o(103194);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.vid != null) {
                nh += g.a.a.b.b.a.f(3, this.vid);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.scene) + g.a.a.b.b.a.bu(5, this.KIL) + g.a.a.b.b.a.bu(6, this.nettype);
            if (this.session_id != null) {
                bu += g.a.a.b.b.a.f(7, this.session_id);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.KIK) + g.a.a.b.b.a.bu(9, this.KJl) + g.a.a.b.b.a.bu(10, this.KJm) + g.a.a.b.b.a.r(11, this.KJn) + g.a.a.b.b.a.r(12, this.KJo);
            if (this.KJp != null) {
                bu2 += g.a.a.a.nh(13, this.KJp.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.KJq) + g.a.a.b.b.a.bu(15, this.KJr) + g.a.a.b.b.a.bu(16, this.KJs);
            if (this.KJt != null) {
                bu3 += g.a.a.b.b.a.f(17, this.KJt);
            }
            AppMethodBeat.o(103194);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103194);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fs fsVar = (fs) objArr[1];
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
                        fsVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(103194);
                    return 0;
                case 2:
                    fsVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(103194);
                    return 0;
                case 3:
                    fsVar.vid = aVar3.UbS.readString();
                    AppMethodBeat.o(103194);
                    return 0;
                case 4:
                    fsVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(103194);
                    return 0;
                case 5:
                    fsVar.KIL = aVar3.UbS.zi();
                    AppMethodBeat.o(103194);
                    return 0;
                case 6:
                    fsVar.nettype = aVar3.UbS.zi();
                    AppMethodBeat.o(103194);
                    return 0;
                case 7:
                    fsVar.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(103194);
                    return 0;
                case 8:
                    fsVar.KIK = aVar3.UbS.zi();
                    AppMethodBeat.o(103194);
                    return 0;
                case 9:
                    fsVar.KJl = aVar3.UbS.zi();
                    AppMethodBeat.o(103194);
                    return 0;
                case 10:
                    fsVar.KJm = aVar3.UbS.zi();
                    AppMethodBeat.o(103194);
                    return 0;
                case 11:
                    fsVar.KJn = aVar3.UbS.zl();
                    AppMethodBeat.o(103194);
                    return 0;
                case 12:
                    fsVar.KJo = aVar3.UbS.zl();
                    AppMethodBeat.o(103194);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ql qlVar = new ql();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = qlVar.populateBuilderWithField(aVar5, qlVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        fsVar.KJp = qlVar;
                    }
                    AppMethodBeat.o(103194);
                    return 0;
                case 14:
                    fsVar.KJq = aVar3.UbS.zi();
                    AppMethodBeat.o(103194);
                    return 0;
                case 15:
                    fsVar.KJr = aVar3.UbS.zi();
                    AppMethodBeat.o(103194);
                    return 0;
                case 16:
                    fsVar.KJs = aVar3.UbS.zi();
                    AppMethodBeat.o(103194);
                    return 0;
                case 17:
                    fsVar.KJt = aVar3.UbS.readString();
                    AppMethodBeat.o(103194);
                    return 0;
                default:
                    AppMethodBeat.o(103194);
                    return -1;
            }
        } else {
            AppMethodBeat.o(103194);
            return -1;
        }
    }
}
