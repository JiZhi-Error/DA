package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import com.tencent.wxmm.v2encoder;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class g extends f {
    private int mSampleRate;
    private int nen;

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.f, com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final boolean i(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(146354);
        this.mSampleRate = i2;
        this.nen = i3;
        boolean i5 = super.i(str, i2, i3, i4);
        AppMethodBeat.o(146354);
        return i5;
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.f, com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final void close() {
        AppMethodBeat.i(146355);
        super.close();
        try {
            RandomAccessFile dB = s.dB(aa.z(this.mFile.her()), true);
            dB.seek(0);
            int i2 = this.mSampleRate;
            int i3 = this.nen;
            long length = this.mFile.length();
            long j2 = 36 + length;
            long j3 = (long) i2;
            long j4 = (long) (((i2 * 16) * i3) / 8);
            dB.write(new byte[]{82, 73, 70, 70, (byte) ((int) (255 & j2)), (byte) ((int) ((j2 >> 8) & 255)), (byte) ((int) ((j2 >> 16) & 255)), (byte) ((int) ((j2 >> 24) & 255)), 87, 65, 86, 69, 102, 109, 116, 32, v2encoder.enumCODEC_vcodec2, 0, 0, 0, 1, 0, (byte) i3, 0, (byte) ((int) (255 & j3)), (byte) ((int) ((j3 >> 8) & 255)), (byte) ((int) ((j3 >> 16) & 255)), (byte) ((int) ((j3 >> 24) & 255)), (byte) ((int) (255 & j4)), (byte) ((int) ((j4 >> 8) & 255)), (byte) ((int) ((j4 >> 16) & 255)), (byte) ((int) ((j4 >> 24) & 255)), (byte) (i3 * 2), 0, v2encoder.enumCODEC_vcodec2, 0, 100, 97, 116, 97, (byte) ((int) (255 & length)), (byte) ((int) ((length >> 8) & 255)), (byte) ((int) ((length >> 16) & 255)), (byte) ((int) ((length >> 24) & 255))});
            dB.close();
            AppMethodBeat.o(146355);
        } catch (IOException e2) {
            Log.printInfoStack("Luggage.PCMAudioEncoder", "", e2);
            AppMethodBeat.o(146355);
        }
    }
}
