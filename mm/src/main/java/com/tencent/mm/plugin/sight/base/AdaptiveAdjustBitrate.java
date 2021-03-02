package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;

public class AdaptiveAdjustBitrate {
    public int BNp;
    public int BNq;
    public int DlY;
    public int DlZ;
    public int iTg;
    public int iTh;
    public int iTi;
    public int iTj;
    public int iTk;
    public int iTl;
    public int iTn;
    public int iTo;
    public int iTp;
    public int iTq;
    public int idF;
    public int idG;
    public String iqd;
    public int targetHeight;
    public int targetWidth;

    public static native float GetAuQaLevel(String str, float f2, float f3, int i2, boolean z, boolean z2);

    private static native int[] GetBitrate(String str, int i2, int i3, int i4, int i5, float f2, float f3, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, boolean z);

    public static native int getOrignalImageQuality(int i2, int i3, int i4, int i5, float f2);

    public static native int getVideoImageQuality(int i2, int i3, int i4, int i5, float f2);

    private static native int[] getVideoQuality(String str, int i2, int i3, int i4, int i5, float f2, float f3, int i6, int i7, int i8, int i9, int i10);

    public final void eVq() {
        this.iTg = 0;
        this.iTh = 0;
        this.iTi = 0;
        this.iTj = 0;
        this.iTk = 0;
        this.iTl = 0;
        this.DlZ = 0;
        this.iTn = 0;
        this.iTo = 0;
        this.idF = 0;
        this.idG = 0;
        this.iTp = 0;
        this.iTq = 0;
    }

    public static int[] a(String str, int i2, int i3, int i4, int i5, float f2, float f3, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, boolean z) {
        AppMethodBeat.i(201782);
        int[] GetBitrate = GetBitrate(q.k(str, false), i2, i3, i4, i5, f2, f3, i6, i7, i8, i9, i10, i11, i12, i13, z);
        AppMethodBeat.o(201782);
        return GetBitrate;
    }

    public static float a(String str, float f2, float f3, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(201783);
        float GetAuQaLevel = GetAuQaLevel(q.k(str, false), f2, f3, i2, z, z2);
        AppMethodBeat.o(201783);
        return GetAuQaLevel;
    }

    public static int[] a(String str, int i2, int i3, int i4, int i5, float f2, int i6, int i7, int i8, int i9) {
        AppMethodBeat.i(201784);
        int[] videoQuality = getVideoQuality(q.k(str, false), i2, i3, i4, i5, f2, 0.0f, 4, i6, i7, i8, i9);
        AppMethodBeat.o(201784);
        return videoQuality;
    }

    public String toString() {
        AppMethodBeat.i(133593);
        String str = "[ sourceVideoPath " + this.iqd + " targetHeight " + this.targetHeight + " targetWidth " + this.targetWidth + " targetvideoBitrate " + this.DlY + " reMuxStartTimeMs " + this.BNp + " reMuxEndTimeMs " + this.BNq + " remuxScene " + this.iTq + " abaSwitch " + this.iTg + " qpSwitch " + this.iTh + " abaUpgear " + this.iTi + " abaDowngear " + this.iTj + " ceilingVideoBR " + this.iTk + " flooringVideoBR " + this.iTl + " isEnableHEVC " + this.DlZ + " isEnable720p " + this.iTn + " minQP " + this.idF + " maxQP " + this.idG + " takePhotosVideoBR " + this.iTp + " remuxScene " + this.iTq + "]";
        AppMethodBeat.o(133593);
        return str;
    }
}
