package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dns extends dop {
    public LinkedList<String> EmotionList = new LinkedList<>();
    public String KTg;
    public dnm MQN;
    public doi MQO;
    public int oUv;

    public dns() {
        AppMethodBeat.i(115964);
        AppMethodBeat.o(115964);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115965);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.oUv);
            if (this.MQN != null) {
                aVar.ni(3, this.MQN.computeSize());
                this.MQN.writeFields(aVar);
            }
            if (this.MQO != null) {
                aVar.ni(4, this.MQO.computeSize());
                this.MQO.writeFields(aVar);
            }
            if (this.KTg != null) {
                aVar.e(5, this.KTg);
            }
            aVar.e(6, 1, this.EmotionList);
            AppMethodBeat.o(115965);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUv);
            if (this.MQN != null) {
                nh += g.a.a.a.nh(3, this.MQN.computeSize());
            }
            if (this.MQO != null) {
                nh += g.a.a.a.nh(4, this.MQO.computeSize());
            }
            if (this.KTg != null) {
                nh += g.a.a.b.b.a.f(5, this.KTg);
            }
            int c2 = nh + g.a.a.a.c(6, 1, this.EmotionList);
            AppMethodBeat.o(115965);
            return c2;
        } else if (i2 == 2) {
            this.EmotionList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115965);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dns dns = (dns) objArr[1];
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
                        dns.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115965);
                    return 0;
                case 2:
                    dns.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(115965);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dnm dnm = new dnm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dnm.populateBuilderWithField(aVar5, dnm, dop.getNextFieldNumber(aVar5))) {
                        }
                        dns.MQN = dnm;
                    }
                    AppMethodBeat.o(115965);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        doi doi = new doi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = doi.populateBuilderWithField(aVar6, doi, dop.getNextFieldNumber(aVar6))) {
                        }
                        dns.MQO = doi;
                    }
                    AppMethodBeat.o(115965);
                    return 0;
                case 5:
                    dns.KTg = aVar3.UbS.readString();
                    AppMethodBeat.o(115965);
                    return 0;
                case 6:
                    dns.EmotionList.add(aVar3.UbS.readString());
                    AppMethodBeat.o(115965);
                    return 0;
                default:
                    AppMethodBeat.o(115965);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115965);
            return -1;
        }
    }
}
