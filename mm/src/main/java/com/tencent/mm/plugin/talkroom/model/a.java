package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.ugc.TXRecordCommon;

public final class a {
    public static final int FPn;
    private static int cpuFlag0;

    static {
        AppMethodBeat.i(29436);
        int aon = m.aon();
        cpuFlag0 = aon;
        FPn = (aon & 1024) != 0 ? 16000 : TXRecordCommon.AUDIO_SAMPLERATE_8000;
        AppMethodBeat.o(29436);
    }
}
