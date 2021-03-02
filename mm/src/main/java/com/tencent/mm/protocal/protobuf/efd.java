package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class efd extends dop {
    public b Buffer;
    public String KSV;
    public int KTf;
    public int KWb;
    public int NeZ;
    public int Nfe;
    public String Nff;
    public ddg Nfg;
    public int Nfh;
    public String Nfi;
    public int Scene;
    public String SessionId;
    public String jfi;
    public LinkedList<efc> xKD = new LinkedList<>();

    public efd() {
        AppMethodBeat.i(152704);
        AppMethodBeat.o(152704);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152705);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KSV != null) {
                aVar.e(2, this.KSV);
            }
            aVar.aM(3, this.KWb);
            aVar.e(4, 8, this.xKD);
            aVar.aM(5, this.Nfe);
            if (this.jfi != null) {
                aVar.e(6, this.jfi);
            }
            aVar.aM(7, this.KTf);
            aVar.aM(8, this.NeZ);
            if (this.Nff != null) {
                aVar.e(9, this.Nff);
            }
            if (this.Buffer != null) {
                aVar.c(10, this.Buffer);
            }
            if (this.Nfg != null) {
                aVar.ni(11, this.Nfg.computeSize());
                this.Nfg.writeFields(aVar);
            }
            aVar.aM(12, this.Scene);
            aVar.aM(13, this.Nfh);
            if (this.SessionId != null) {
                aVar.e(14, this.SessionId);
            }
            if (this.Nfi != null) {
                aVar.e(15, this.Nfi);
            }
            AppMethodBeat.o(152705);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KSV != null) {
                nh += g.a.a.b.b.a.f(2, this.KSV);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KWb) + g.a.a.a.c(4, 8, this.xKD) + g.a.a.b.b.a.bu(5, this.Nfe);
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(6, this.jfi);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.KTf) + g.a.a.b.b.a.bu(8, this.NeZ);
            if (this.Nff != null) {
                bu2 += g.a.a.b.b.a.f(9, this.Nff);
            }
            if (this.Buffer != null) {
                bu2 += g.a.a.b.b.a.b(10, this.Buffer);
            }
            if (this.Nfg != null) {
                bu2 += g.a.a.a.nh(11, this.Nfg.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.Scene) + g.a.a.b.b.a.bu(13, this.Nfh);
            if (this.SessionId != null) {
                bu3 += g.a.a.b.b.a.f(14, this.SessionId);
            }
            if (this.Nfi != null) {
                bu3 += g.a.a.b.b.a.f(15, this.Nfi);
            }
            AppMethodBeat.o(152705);
            return bu3;
        } else if (i2 == 2) {
            this.xKD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152705);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efd efd = (efd) objArr[1];
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
                        efd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152705);
                    return 0;
                case 2:
                    efd.KSV = aVar3.UbS.readString();
                    AppMethodBeat.o(152705);
                    return 0;
                case 3:
                    efd.KWb = aVar3.UbS.zi();
                    AppMethodBeat.o(152705);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        efc efc = new efc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = efc.populateBuilderWithField(aVar5, efc, dop.getNextFieldNumber(aVar5))) {
                        }
                        efd.xKD.add(efc);
                    }
                    AppMethodBeat.o(152705);
                    return 0;
                case 5:
                    efd.Nfe = aVar3.UbS.zi();
                    AppMethodBeat.o(152705);
                    return 0;
                case 6:
                    efd.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(152705);
                    return 0;
                case 7:
                    efd.KTf = aVar3.UbS.zi();
                    AppMethodBeat.o(152705);
                    return 0;
                case 8:
                    efd.NeZ = aVar3.UbS.zi();
                    AppMethodBeat.o(152705);
                    return 0;
                case 9:
                    efd.Nff = aVar3.UbS.readString();
                    AppMethodBeat.o(152705);
                    return 0;
                case 10:
                    efd.Buffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(152705);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ddg ddg = new ddg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ddg.populateBuilderWithField(aVar6, ddg, dop.getNextFieldNumber(aVar6))) {
                        }
                        efd.Nfg = ddg;
                    }
                    AppMethodBeat.o(152705);
                    return 0;
                case 12:
                    efd.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152705);
                    return 0;
                case 13:
                    efd.Nfh = aVar3.UbS.zi();
                    AppMethodBeat.o(152705);
                    return 0;
                case 14:
                    efd.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(152705);
                    return 0;
                case 15:
                    efd.Nfi = aVar3.UbS.readString();
                    AppMethodBeat.o(152705);
                    return 0;
                default:
                    AppMethodBeat.o(152705);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152705);
            return -1;
        }
    }
}
