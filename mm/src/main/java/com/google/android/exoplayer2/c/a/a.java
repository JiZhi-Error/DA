package com.google.android.exoplayer2.c.a;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.a.d;
import com.google.android.exoplayer2.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.ugc.TXRecordCommon;
import java.util.Collections;

final class a extends d {
    private static final int[] bii = {5512, 11025, 22050, 44100};
    private int audioFormat;
    private boolean bij;
    private boolean bik;

    public a(m mVar) {
        super(mVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.a.d
    public final boolean a(com.google.android.exoplayer2.i.m mVar) {
        int i2 = 2;
        AppMethodBeat.i(91976);
        if (!this.bij) {
            int readUnsignedByte = mVar.readUnsignedByte();
            this.audioFormat = (readUnsignedByte >> 4) & 15;
            if (this.audioFormat == 2) {
                this.biA.f(Format.a(null, "audio/mpeg", -1, -1, 1, bii[(readUnsignedByte >> 2) & 3], null, null, null));
                this.bik = true;
            } else if (this.audioFormat == 7 || this.audioFormat == 8) {
                String str = this.audioFormat == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                if ((readUnsignedByte & 1) != 1) {
                    i2 = 3;
                }
                this.biA.f(Format.a(null, str, -1, -1, 1, TXRecordCommon.AUDIO_SAMPLERATE_8000, i2, null, null, 0, null));
                this.bik = true;
            } else if (this.audioFormat != 10) {
                d.a aVar = new d.a("Audio format not supported: " + this.audioFormat);
                AppMethodBeat.o(91976);
                throw aVar;
            }
            this.bij = true;
        } else {
            mVar.eZ(1);
        }
        AppMethodBeat.o(91976);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.a.d
    public final void a(com.google.android.exoplayer2.i.m mVar, long j2) {
        AppMethodBeat.i(91977);
        if (this.audioFormat == 2) {
            int xd = mVar.xd();
            this.biA.a(mVar, xd);
            this.biA.a(j2, 1, xd, 0, null);
            AppMethodBeat.o(91977);
            return;
        }
        int readUnsignedByte = mVar.readUnsignedByte();
        if (readUnsignedByte != 0 || this.bik) {
            if (this.audioFormat != 10 || readUnsignedByte == 1) {
                int xd2 = mVar.xd();
                this.biA.a(mVar, xd2);
                this.biA.a(j2, 1, xd2, 0, null);
            }
            AppMethodBeat.o(91977);
            return;
        }
        byte[] bArr = new byte[mVar.xd()];
        mVar.readBytes(bArr, 0, bArr.length);
        Pair<Integer, Integer> u = com.google.android.exoplayer2.i.d.u(bArr);
        this.biA.f(Format.a(null, EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, -1, -1, ((Integer) u.second).intValue(), ((Integer) u.first).intValue(), Collections.singletonList(bArr), null, null));
        this.bik = true;
        AppMethodBeat.o(91977);
    }
}
