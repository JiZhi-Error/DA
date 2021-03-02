package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.f.g.e;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class g extends b {
    private final f bDK = new f();
    private final m bDL = new m();
    private final e.a bDM = new e.a();
    private final a bDN = new a();
    private final List<d> bDO = new ArrayList();

    public g() {
        super("WebvttDecoder");
        AppMethodBeat.i(92908);
        AppMethodBeat.o(92908);
    }

    private static int G(m mVar) {
        AppMethodBeat.i(92909);
        int i2 = 0;
        int i3 = -1;
        while (i3 == -1) {
            i2 = mVar.position;
            String readLine = mVar.readLine();
            if (readLine == null) {
                i3 = 0;
            } else if ("STYLE".equals(readLine)) {
                i3 = 2;
            } else if ("NOTE".startsWith(readLine)) {
                i3 = 1;
            } else {
                i3 = 3;
            }
        }
        mVar.setPosition(i2);
        AppMethodBeat.o(92909);
        return i3;
    }

    private static void H(m mVar) {
        AppMethodBeat.i(92910);
        do {
        } while (!TextUtils.isEmpty(mVar.readLine()));
        AppMethodBeat.o(92910);
    }

    @Override // com.google.android.exoplayer2.f.b
    public final /* synthetic */ d b(byte[] bArr, int i2, boolean z) {
        AppMethodBeat.i(92911);
        this.bDL.n(bArr, i2);
        this.bDM.reset();
        this.bDO.clear();
        h.I(this.bDL);
        do {
        } while (!TextUtils.isEmpty(this.bDL.readLine()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int G = G(this.bDL);
            if (G == 0) {
                i iVar = new i(arrayList);
                AppMethodBeat.o(92911);
                return iVar;
            } else if (G == 1) {
                H(this.bDL);
            } else if (G == 2) {
                if (!arrayList.isEmpty()) {
                    f fVar = new f("A style block was found after the first cue.");
                    AppMethodBeat.o(92911);
                    throw fVar;
                }
                this.bDL.readLine();
                d C = this.bDN.C(this.bDL);
                if (C != null) {
                    this.bDO.add(C);
                }
            } else if (G == 3 && this.bDK.a(this.bDL, this.bDM, this.bDO)) {
                arrayList.add(this.bDM.wv());
                this.bDM.reset();
            }
        }
    }
}
