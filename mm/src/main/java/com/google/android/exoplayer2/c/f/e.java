package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e implements v.c {
    private final List<Format> bqG;
    private final int flags;

    public e() {
        this(0);
    }

    public e(int i2) {
        this(i2, Collections.emptyList());
        AppMethodBeat.i(92220);
        AppMethodBeat.o(92220);
    }

    public e(int i2, List<Format> list) {
        AppMethodBeat.i(92221);
        this.flags = i2;
        if (!isSet(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.bc("application/cea-608"));
        }
        this.bqG = list;
        AppMethodBeat.o(92221);
    }

    @Override // com.google.android.exoplayer2.c.f.v.c
    public final SparseArray<v> uS() {
        AppMethodBeat.i(92222);
        SparseArray<v> sparseArray = new SparseArray<>();
        AppMethodBeat.o(92222);
        return sparseArray;
    }

    @Override // com.google.android.exoplayer2.c.f.v.c
    public final v a(int i2, v.b bVar) {
        AppMethodBeat.i(92223);
        switch (i2) {
            case 2:
                o oVar = new o(new i());
                AppMethodBeat.o(92223);
                return oVar;
            case 3:
            case 4:
                o oVar2 = new o(new m(bVar.language));
                AppMethodBeat.o(92223);
                return oVar2;
            case 15:
                if (isSet(2)) {
                    AppMethodBeat.o(92223);
                    return null;
                }
                o oVar3 = new o(new d(false, bVar.language));
                AppMethodBeat.o(92223);
                return oVar3;
            case 21:
                o oVar4 = new o(new l());
                AppMethodBeat.o(92223);
                return oVar4;
            case 27:
                if (isSet(4)) {
                    AppMethodBeat.o(92223);
                    return null;
                }
                o oVar5 = new o(new j(a(bVar), isSet(1), isSet(8)));
                AppMethodBeat.o(92223);
                return oVar5;
            case 36:
                o oVar6 = new o(new k(a(bVar)));
                AppMethodBeat.o(92223);
                return oVar6;
            case PlayerException.EXCEPTION_IN_CHECK_STATE /*{ENCODED_INT: 89}*/:
                o oVar7 = new o(new g(bVar.bsK));
                AppMethodBeat.o(92223);
                return oVar7;
            case 129:
            case c.CTRL_INDEX /*{ENCODED_INT: 135}*/:
                o oVar8 = new o(new b(bVar.language));
                AppMethodBeat.o(92223);
                return oVar8;
            case 130:
            case 138:
                o oVar9 = new o(new f(bVar.language));
                AppMethodBeat.o(92223);
                return oVar9;
            case g.CTRL_INDEX /*{ENCODED_INT: 134}*/:
                if (isSet(16)) {
                    AppMethodBeat.o(92223);
                    return null;
                }
                r rVar = new r(new t());
                AppMethodBeat.o(92223);
                return rVar;
            default:
                AppMethodBeat.o(92223);
                return null;
        }
    }

    private s a(v.b bVar) {
        String str;
        int i2;
        AppMethodBeat.i(92224);
        if (isSet(32)) {
            s sVar = new s(this.bqG);
            AppMethodBeat.o(92224);
            return sVar;
        }
        m mVar = new m(bVar.bsL);
        List<Format> list = this.bqG;
        while (mVar.xd() > 0) {
            int readUnsignedByte = mVar.readUnsignedByte();
            int readUnsignedByte2 = mVar.position + mVar.readUnsignedByte();
            if (readUnsignedByte == 134) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte3 = mVar.readUnsignedByte() & 31;
                for (int i3 = 0; i3 < readUnsignedByte3; i3++) {
                    String readString = mVar.readString(3);
                    int readUnsignedByte4 = mVar.readUnsignedByte();
                    if ((readUnsignedByte4 & 128) != 0) {
                        str = "application/cea-708";
                        i2 = readUnsignedByte4 & 63;
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    arrayList.add(Format.a((String) null, str, 0, readString, i2));
                    mVar.eZ(2);
                }
                list = arrayList;
            }
            mVar.setPosition(readUnsignedByte2);
        }
        s sVar2 = new s(list);
        AppMethodBeat.o(92224);
        return sVar2;
    }

    private boolean isSet(int i2) {
        return (this.flags & i2) != 0;
    }
}
