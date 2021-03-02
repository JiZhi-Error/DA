package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    int colorFormat;
    int dYT;
    int srcHeight;
    int srcWidth;
    int targetHeight;
    int targetWidth;
    long tick = Util.currentTicks();
    boolean whs;
    byte[] zvl;
    byte[] zvm;
    int zvn = 0;
    int zvo = 0;
    int zvp;
    boolean zvq;

    public interface a {
        void a(b bVar);
    }

    public b(int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, int i7, byte[] bArr) {
        AppMethodBeat.i(89471);
        this.colorFormat = i4;
        this.targetWidth = i5;
        this.targetHeight = i6;
        this.srcWidth = i2;
        this.srcHeight = i3;
        this.zvq = z2;
        this.whs = z;
        this.dYT = i7;
        this.zvl = bArr;
        this.zvn = bArr.length;
        this.zvm = k.zwi.h(Integer.valueOf(((i5 * i6) * 3) / 2));
        AppMethodBeat.o(89471);
    }
}
