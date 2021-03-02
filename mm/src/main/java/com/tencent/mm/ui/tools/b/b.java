package com.tencent.mm.ui.tools.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends a {
    private String QxF;
    public int QxG = 0;
    public int QxH = 0;
    public int QxI = 0;
    private a QxJ;
    private int mHeight = 2048;
    public int mSize = 104857600;
    private int mWidth = 2048;

    public interface a {
        void a(b bVar);

        void cHf();
    }

    private b(String str) {
        this.QxF = str;
    }

    public static b bnW(String str) {
        AppMethodBeat.i(143300);
        b bVar = new b(str);
        AppMethodBeat.o(143300);
        return bVar;
    }

    public final b aop(int i2) {
        this.mWidth = i2;
        this.mHeight = i2;
        return this;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(143301);
        this.QxJ = aVar;
        dSw();
        AppMethodBeat.o(143301);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0091  */
    @Override // com.tencent.mm.ui.tools.b.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int bCj() {
        /*
        // Method dump skipped, instructions count: 152
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.b.b.bCj():int");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.tools.b.a
    public final void dSw() {
        AppMethodBeat.i(143303);
        if (this.QxJ == null) {
            Log.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
            AppMethodBeat.o(143303);
            return;
        }
        switch (bCj()) {
            case 0:
                this.QxJ.a(this);
                AppMethodBeat.o(143303);
                return;
            case 1:
                this.QxJ.cHf();
                break;
        }
        AppMethodBeat.o(143303);
    }
}
