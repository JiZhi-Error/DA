package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bgr extends dop {
    public int KCx;
    public String KPJ;
    public String LQA;
    public String LQu;
    public String LQx;
    public String LQy;
    public int LQz;
    public bf Lcc;
    public String Ljk;
    public String Lkp;
    public String Lkq;
    public String Lkr;
    public String Lks;
    public int Scene;
    public String jfi;
    public String xNU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91473);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            if (this.Lkp != null) {
                aVar.e(3, this.Lkp);
            }
            if (this.KPJ != null) {
                aVar.e(4, this.KPJ);
            }
            if (this.Lkq != null) {
                aVar.e(5, this.Lkq);
            }
            if (this.Lkr != null) {
                aVar.e(6, this.Lkr);
            }
            if (this.Lks != null) {
                aVar.e(7, this.Lks);
            }
            if (this.Ljk != null) {
                aVar.e(8, this.Ljk);
            }
            if (this.LQu != null) {
                aVar.e(9, this.LQu);
            }
            aVar.aM(10, this.KCx);
            if (this.xNU != null) {
                aVar.e(11, this.xNU);
            }
            if (this.LQx != null) {
                aVar.e(12, this.LQx);
            }
            if (this.LQy != null) {
                aVar.e(13, this.LQy);
            }
            if (this.Lcc != null) {
                aVar.ni(14, this.Lcc.computeSize());
                this.Lcc.writeFields(aVar);
            }
            aVar.aM(15, this.Scene);
            aVar.aM(16, this.LQz);
            if (this.LQA != null) {
                aVar.e(17, this.LQA);
            }
            AppMethodBeat.o(91473);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            if (this.Lkp != null) {
                nh += g.a.a.b.b.a.f(3, this.Lkp);
            }
            if (this.KPJ != null) {
                nh += g.a.a.b.b.a.f(4, this.KPJ);
            }
            if (this.Lkq != null) {
                nh += g.a.a.b.b.a.f(5, this.Lkq);
            }
            if (this.Lkr != null) {
                nh += g.a.a.b.b.a.f(6, this.Lkr);
            }
            if (this.Lks != null) {
                nh += g.a.a.b.b.a.f(7, this.Lks);
            }
            if (this.Ljk != null) {
                nh += g.a.a.b.b.a.f(8, this.Ljk);
            }
            if (this.LQu != null) {
                nh += g.a.a.b.b.a.f(9, this.LQu);
            }
            int bu = nh + g.a.a.b.b.a.bu(10, this.KCx);
            if (this.xNU != null) {
                bu += g.a.a.b.b.a.f(11, this.xNU);
            }
            if (this.LQx != null) {
                bu += g.a.a.b.b.a.f(12, this.LQx);
            }
            if (this.LQy != null) {
                bu += g.a.a.b.b.a.f(13, this.LQy);
            }
            if (this.Lcc != null) {
                bu += g.a.a.a.nh(14, this.Lcc.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(15, this.Scene) + g.a.a.b.b.a.bu(16, this.LQz);
            if (this.LQA != null) {
                bu2 += g.a.a.b.b.a.f(17, this.LQA);
            }
            AppMethodBeat.o(91473);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91473);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgr bgr = (bgr) objArr[1];
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
                        bgr.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91473);
                    return 0;
                case 2:
                    bgr.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 3:
                    bgr.Lkp = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 4:
                    bgr.KPJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 5:
                    bgr.Lkq = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 6:
                    bgr.Lkr = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 7:
                    bgr.Lks = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 8:
                    bgr.Ljk = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 9:
                    bgr.LQu = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 10:
                    bgr.KCx = aVar3.UbS.zi();
                    AppMethodBeat.o(91473);
                    return 0;
                case 11:
                    bgr.xNU = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 12:
                    bgr.LQx = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 13:
                    bgr.LQy = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bf bfVar = new bf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bfVar.populateBuilderWithField(aVar5, bfVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        bgr.Lcc = bfVar;
                    }
                    AppMethodBeat.o(91473);
                    return 0;
                case 15:
                    bgr.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(91473);
                    return 0;
                case 16:
                    bgr.LQz = aVar3.UbS.zi();
                    AppMethodBeat.o(91473);
                    return 0;
                case 17:
                    bgr.LQA = aVar3.UbS.readString();
                    AppMethodBeat.o(91473);
                    return 0;
                default:
                    AppMethodBeat.o(91473);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91473);
            return -1;
        }
    }
}
