package com.tencent.tmediacodec.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tmediacodec.b.e;
import com.tencent.tmediacodec.b.f;
import com.tencent.tmediacodec.b.g;

public final class a {
    public static boolean a(f fVar, e eVar) {
        AppMethodBeat.i(190171);
        e eVar2 = fVar.SlB;
        if (fVar instanceof g) {
            if (!TextUtils.equals(eVar2.bdq, eVar.bdq) || eVar2.bdv != eVar.bdv || (!fVar.bsX && !(eVar2.width == eVar.width && eVar2.height == eVar.height))) {
                AppMethodBeat.o(190171);
                return false;
            }
            AppMethodBeat.o(190171);
            return true;
        } else if (!(fVar instanceof com.tencent.tmediacodec.b.a)) {
            AppMethodBeat.o(190171);
            return true;
        } else if (!TextUtils.equals(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, eVar2.bdq) || !TextUtils.equals(eVar2.bdq, eVar.bdq) || eVar2.channelCount != eVar.channelCount || eVar2.sampleRate != eVar.sampleRate) {
            AppMethodBeat.o(190171);
            return false;
        } else {
            AppMethodBeat.o(190171);
            return false;
        }
    }

    public enum b {
        KEEP_CODEC_RESULT_NO,
        KEEP_CODEC_RESULT_YES_WITH_FLUSH,
        KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION,
        KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;

        public static b valueOf(String str) {
            AppMethodBeat.i(190169);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(190169);
            return bVar;
        }

        static {
            AppMethodBeat.i(190170);
            AppMethodBeat.o(190170);
        }
    }

    /* renamed from: com.tencent.tmediacodec.e.a$a  reason: collision with other inner class name */
    public enum EnumC2218a {
        ADAPTATION_WORKAROUND_MODE_NEVER,
        ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION,
        ADAPTATION_WORKAROUND_MODE_ALWAYS;

        public static EnumC2218a valueOf(String str) {
            AppMethodBeat.i(190166);
            EnumC2218a aVar = (EnumC2218a) Enum.valueOf(EnumC2218a.class, str);
            AppMethodBeat.o(190166);
            return aVar;
        }

        static {
            AppMethodBeat.i(190167);
            AppMethodBeat.o(190167);
        }
    }
}
