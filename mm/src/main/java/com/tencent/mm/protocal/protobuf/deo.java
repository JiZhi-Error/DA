package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class deo extends dop {
    public String LoB;
    public String MJG;
    public int Meb;
    public String request_id;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214320);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.request_id != null) {
                aVar.e(2, this.request_id);
            }
            if (this.MJG != null) {
                aVar.e(3, this.MJG);
            }
            aVar.aM(4, this.Meb);
            aVar.aM(100, this.scene);
            if (this.LoB != null) {
                aVar.e(101, this.LoB);
            }
            AppMethodBeat.o(214320);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.request_id != null) {
                nh += g.a.a.b.b.a.f(2, this.request_id);
            }
            if (this.MJG != null) {
                nh += g.a.a.b.b.a.f(3, this.MJG);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Meb) + g.a.a.b.b.a.bu(100, this.scene);
            if (this.LoB != null) {
                bu += g.a.a.b.b.a.f(101, this.LoB);
            }
            AppMethodBeat.o(214320);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214320);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            deo deo = (deo) objArr[1];
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
                        deo.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(214320);
                    return 0;
                case 2:
                    deo.request_id = aVar3.UbS.readString();
                    AppMethodBeat.o(214320);
                    return 0;
                case 3:
                    deo.MJG = aVar3.UbS.readString();
                    AppMethodBeat.o(214320);
                    return 0;
                case 4:
                    deo.Meb = aVar3.UbS.zi();
                    AppMethodBeat.o(214320);
                    return 0;
                case 100:
                    deo.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(214320);
                    return 0;
                case 101:
                    deo.LoB = aVar3.UbS.readString();
                    AppMethodBeat.o(214320);
                    return 0;
                default:
                    AppMethodBeat.o(214320);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214320);
            return -1;
        }
    }
}
