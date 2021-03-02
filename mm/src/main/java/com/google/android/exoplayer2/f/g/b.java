package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.f.g.e;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public final class b extends com.google.android.exoplayer2.f.b {
    private static final int bDw = x.bJ("payl");
    private static final int bDx = x.bJ("sttg");
    private static final int bDy = x.bJ("vttc");
    private final e.a bDz = new e.a();
    private final m bqm = new m();

    static {
        AppMethodBeat.i(92887);
        AppMethodBeat.o(92887);
    }

    public b() {
        super("Mp4WebvttDecoder");
        AppMethodBeat.i(92884);
        AppMethodBeat.o(92884);
    }

    private static a a(m mVar, e.a aVar, int i2) {
        AppMethodBeat.i(92885);
        aVar.reset();
        while (i2 > 0) {
            if (i2 < 8) {
                f fVar = new f("Incomplete vtt cue box header found.");
                AppMethodBeat.o(92885);
                throw fVar;
            }
            int readInt = mVar.readInt();
            int readInt2 = mVar.readInt();
            int i3 = readInt - 8;
            String str = new String(mVar.data, mVar.position, i3);
            mVar.eZ(i3);
            i2 = (i2 - 8) - i3;
            if (readInt2 == bDx) {
                f.a(str, aVar);
            } else if (readInt2 == bDw) {
                f.a((String) null, str.trim(), aVar, Collections.emptyList());
            }
        }
        e wv = aVar.wv();
        AppMethodBeat.o(92885);
        return wv;
    }

    @Override // com.google.android.exoplayer2.f.b
    public final /* synthetic */ d b(byte[] bArr, int i2, boolean z) {
        AppMethodBeat.i(92886);
        this.bqm.n(bArr, i2);
        ArrayList arrayList = new ArrayList();
        while (this.bqm.xd() > 0) {
            if (this.bqm.xd() < 8) {
                f fVar = new f("Incomplete Mp4Webvtt Top Level box header found.");
                AppMethodBeat.o(92886);
                throw fVar;
            }
            int readInt = this.bqm.readInt();
            if (this.bqm.readInt() == bDy) {
                arrayList.add(a(this.bqm, this.bDz, readInt - 8));
            } else {
                this.bqm.eZ(readInt - 8);
            }
        }
        c cVar = new c(arrayList);
        AppMethodBeat.o(92886);
        return cVar;
    }
}
