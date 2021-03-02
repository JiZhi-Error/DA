package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

public final class h {
    private static final int[] bgt = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] bgu = {-1, TXRecordCommon.AUDIO_SAMPLERATE_8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] bgv = {64, 112, 128, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 384, FileUtils.S_IRWXU, 512, 640, 768, e.CTRL_INDEX, 1024, 1152, TAVExporter.VIDEO_EXPORT_HEIGHT, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, LVBuffer.MAX_STRING_LENGTH, 3840, 4096, 6144, 7680};

    public static Format a(byte[] bArr, String str, String str2) {
        AppMethodBeat.i(91805);
        l lVar = new l(bArr);
        lVar.en(60);
        int i2 = bgt[lVar.em(6)];
        int i3 = bgu[lVar.em(4)];
        int em = lVar.em(5);
        int i4 = em >= bgv.length ? -1 : (bgv[em] * 1000) / 2;
        lVar.en(10);
        Format a2 = Format.a(str, "audio/vnd.dts", i4, -1, i2 + (lVar.em(2) > 0 ? 1 : 0), i3, null, null, str2);
        AppMethodBeat.o(91805);
        return a2;
    }

    public static int o(byte[] bArr) {
        return ((((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2)) + 1) * 32;
    }

    public static int g(ByteBuffer byteBuffer) {
        AppMethodBeat.i(91806);
        int position = byteBuffer.position();
        int i2 = ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
        AppMethodBeat.o(91806);
        return i2;
    }

    public static int p(byte[] bArr) {
        return (((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4) | ((bArr[7] & 240) >> 4)) + 1;
    }
}
