package com.tencent.mm.plugin.vlog.ui.plugin.read;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2encoder;

public final class c {
    public static byte[] ad(byte[] bArr, int i2) {
        AppMethodBeat.i(190449);
        byte[] bArr2 = new byte[(bArr.length + 44)];
        int length = bArr.length;
        long j2 = (long) (length + 36);
        long j3 = (long) (((44100 * i2) * 16) / 8);
        System.arraycopy(new byte[]{82, 73, 70, 70, (byte) ((int) (j2 & 255)), (byte) ((int) ((j2 >> 8) & 255)), (byte) ((int) ((j2 >> 16) & 255)), (byte) ((int) ((j2 >> 24) & 255)), 87, 65, 86, 69, 102, 109, 116, 32, v2encoder.enumCODEC_vcodec2, 0, 0, 0, 1, 0, (byte) i2, 0, 68, -84, 0, 0, (byte) ((int) (j3 & 255)), (byte) ((int) ((j3 >> 8) & 255)), (byte) ((int) ((j3 >> 16) & 255)), (byte) ((int) ((j3 >> 24) & 255)), (byte) ((i2 * 16) / 8), 0, v2encoder.enumCODEC_vcodec2, 0, 100, 97, 116, 97, (byte) (length & 255), (byte) ((length >> 8) & 255), (byte) ((length >> 16) & 255), (byte) ((length >> 24) & 255)}, 0, bArr2, 0, 44);
        System.arraycopy(bArr, 0, bArr2, 44, bArr.length);
        AppMethodBeat.o(190449);
        return bArr2;
    }
}
