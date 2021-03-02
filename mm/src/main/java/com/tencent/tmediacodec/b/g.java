package com.tencent.tmediacodec.b;

import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.e.a;
import com.tencent.tmediacodec.g.d;

public final class g extends f {
    public g(MediaCodec mediaCodec, e eVar) {
        super(mediaCodec, eVar);
    }

    @Override // com.tencent.tmediacodec.b.f
    public final boolean hpw() {
        AppMethodBeat.i(190131);
        if (!super.hpw() || this.mSurface == null || this.SlB.bdv != 0) {
            AppMethodBeat.o(190131);
            return false;
        }
        AppMethodBeat.o(190131);
        return true;
    }

    @Override // com.tencent.tmediacodec.b.f
    public final String toString() {
        AppMethodBeat.i(190132);
        String str = "VideoCodecWrapper[" + hashCode() + ']';
        AppMethodBeat.o(190132);
        return str;
    }

    @Override // com.tencent.tmediacodec.b.f
    public final a.b a(e eVar) {
        boolean z = false;
        AppMethodBeat.i(190130);
        if (!a.a(this, eVar) || eVar.width > this.SlC.width || eVar.height > this.SlC.height || d.b(this, eVar) > this.SlC.bIC) {
            a.b bVar = a.b.KEEP_CODEC_RESULT_NO;
            AppMethodBeat.o(190130);
            return bVar;
        }
        e eVar2 = this.SlB;
        if (eVar.Slz.size() == eVar2.Slz.size()) {
            int i2 = 0;
            while (true) {
                if (i2 < eVar.Slz.size()) {
                    if (!eVar.Slz.get(i2).equals(eVar2.Slz.get(i2))) {
                        break;
                    }
                    i2++;
                } else {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            a.b bVar2 = a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
            AppMethodBeat.o(190130);
            return bVar2;
        }
        a.b bVar3 = a.b.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION;
        AppMethodBeat.o(190130);
        return bVar3;
    }
}
