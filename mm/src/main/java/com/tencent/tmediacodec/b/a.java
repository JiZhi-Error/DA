package com.tencent.tmediacodec.b;

import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.e.a;

public final class a extends f {
    @Override // com.tencent.tmediacodec.b.f
    public final String toString() {
        AppMethodBeat.i(190100);
        String str = "AudioCodecWrapper[" + hashCode() + ']';
        AppMethodBeat.o(190100);
        return str;
    }

    public a(MediaCodec mediaCodec, e eVar) {
        super(mediaCodec, eVar);
    }

    @Override // com.tencent.tmediacodec.b.f
    public final a.b a(e eVar) {
        AppMethodBeat.i(190099);
        if (com.tencent.tmediacodec.e.a.a(this, eVar)) {
            a.b bVar = a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
            AppMethodBeat.o(190099);
            return bVar;
        }
        a.b bVar2 = a.b.KEEP_CODEC_RESULT_NO;
        AppMethodBeat.o(190099);
        return bVar2;
    }
}
