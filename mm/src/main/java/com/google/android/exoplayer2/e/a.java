package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(16)
public final class a {
    public final boolean bfX;
    public final boolean bsX;
    public final boolean bsY;
    public final MediaCodecInfo.CodecCapabilities bsZ;
    public final String mimeType;
    public final String name;

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        AppMethodBeat.i(92352);
        a aVar = new a(str, str2, codecCapabilities, z, z2);
        AppMethodBeat.o(92352);
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0059, code lost:
        if (r0 != false) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    a(java.lang.String r7, java.lang.String r8, android.media.MediaCodecInfo.CodecCapabilities r9, boolean r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.a.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public final MediaCodecInfo.CodecProfileLevel[] uZ() {
        return (this.bsZ == null || this.bsZ.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.bsZ.profileLevels;
    }

    @TargetApi(21)
    public final boolean a(int i2, int i3, double d2) {
        AppMethodBeat.i(92354);
        if (this.bsZ == null) {
            bh("sizeAndRate.caps");
            AppMethodBeat.o(92354);
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.bsZ.getVideoCapabilities();
        if (videoCapabilities == null) {
            bh("sizeAndRate.vCaps");
            AppMethodBeat.o(92354);
            return false;
        }
        if (!a(videoCapabilities, i2, i3, d2)) {
            if (i2 >= i3 || !a(videoCapabilities, i3, i2, d2)) {
                bh("sizeAndRate.support, " + i2 + "x" + i3 + "x" + d2);
                AppMethodBeat.o(92354);
                return false;
            }
            new StringBuilder("AssumedSupport [").append("sizeAndRate.rotated, " + i2 + "x" + i3 + "x" + d2).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(x.bHH).append("]");
        }
        AppMethodBeat.o(92354);
        return true;
    }

    public final void bh(String str) {
        AppMethodBeat.i(92355);
        new StringBuilder("NoSupport [").append(str).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(x.bHH).append("]");
        AppMethodBeat.o(92355);
    }

    @TargetApi(21)
    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        AppMethodBeat.i(92356);
        if (d2 == -1.0d || d2 <= 0.0d) {
            boolean isSizeSupported = videoCapabilities.isSizeSupported(i2, i3);
            AppMethodBeat.o(92356);
            return isSizeSupported;
        }
        boolean areSizeAndRateSupported = videoCapabilities.areSizeAndRateSupported(i2, i3, d2);
        AppMethodBeat.o(92356);
        return areSizeAndRateSupported;
    }
}
