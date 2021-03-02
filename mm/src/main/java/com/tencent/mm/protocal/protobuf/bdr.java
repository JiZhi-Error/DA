package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bdr extends a {
    public String audioTrackUrl;
    public FinderContact contact;
    public String groupId;
    public azk musicInfo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209703);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.contact != null) {
                aVar.ni(1, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            if (this.musicInfo != null) {
                aVar.ni(2, this.musicInfo.computeSize());
                this.musicInfo.writeFields(aVar);
            }
            if (this.audioTrackUrl != null) {
                aVar.e(3, this.audioTrackUrl);
            }
            if (this.groupId != null) {
                aVar.e(4, this.groupId);
            }
            AppMethodBeat.o(209703);
            return 0;
        } else if (i2 == 1) {
            int nh = this.contact != null ? g.a.a.a.nh(1, this.contact.computeSize()) + 0 : 0;
            if (this.musicInfo != null) {
                nh += g.a.a.a.nh(2, this.musicInfo.computeSize());
            }
            if (this.audioTrackUrl != null) {
                nh += g.a.a.b.b.a.f(3, this.audioTrackUrl);
            }
            if (this.groupId != null) {
                nh += g.a.a.b.b.a.f(4, this.groupId);
            }
            AppMethodBeat.o(209703);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209703);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bdr bdr = (bdr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderContact.populateBuilderWithField(aVar4, finderContact, a.getNextFieldNumber(aVar4))) {
                        }
                        bdr.contact = finderContact;
                    }
                    AppMethodBeat.o(209703);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        azk azk = new azk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = azk.populateBuilderWithField(aVar5, azk, a.getNextFieldNumber(aVar5))) {
                        }
                        bdr.musicInfo = azk;
                    }
                    AppMethodBeat.o(209703);
                    return 0;
                case 3:
                    bdr.audioTrackUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209703);
                    return 0;
                case 4:
                    bdr.groupId = aVar3.UbS.readString();
                    AppMethodBeat.o(209703);
                    return 0;
                default:
                    AppMethodBeat.o(209703);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209703);
            return -1;
        }
    }
}
