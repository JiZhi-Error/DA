package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.j;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.protocal.protobuf.esg;
import com.tencent.ugc.TXRecordCommon;

public final class d {
    public static esg cz(int i2, String str) {
        int SilkGetEncSampleRate;
        AppMethodBeat.i(29280);
        esg esg = new esg();
        switch (i2) {
            case 0:
                esg.KKC = TXRecordCommon.AUDIO_SAMPLERATE_8000;
                esg.KKD = 16;
                esg.KKA = 5;
                esg.KKB = 5;
                break;
            case 1:
                esg.KKC = 16000;
                esg.KKD = 16;
                esg.KKA = 4;
                esg.KKB = 4;
                break;
            case 2:
            case 3:
            default:
                esg.KKC = 0;
                esg.KKD = 0;
                esg.KKA = 0;
                esg.KKB = 0;
                break;
            case 4:
                esg.KKC = 16000;
                b bVar = null;
                try {
                    b Rf = s.Rf(str);
                    if (Rf != null && (Rf instanceof j) && (SilkGetEncSampleRate = MediaRecorder.SilkGetEncSampleRate(((j) Rf).dB(0, 1).buf, MediaRecorder.juf)) >= 8000) {
                        esg.KKC = SilkGetEncSampleRate;
                    }
                    if (Rf != null) {
                        try {
                            Rf.bhP();
                        } catch (Throwable th) {
                        }
                    }
                } catch (Throwable th2) {
                    break;
                }
                esg.KKD = 16;
                esg.KKA = 6;
                esg.KKB = 6;
                break;
        }
        AppMethodBeat.o(29280);
        return esg;
        AppMethodBeat.o(29280);
        throw th;
    }
}
