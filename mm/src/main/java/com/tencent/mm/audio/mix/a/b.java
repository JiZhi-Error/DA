package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class b {
    public int channels = 0;
    public int dtP = 2;
    public byte[] dtQ;
    public volatile LinkedList<String> dtR = new LinkedList<>();
    public int sampleRate = 0;

    public b() {
        AppMethodBeat.i(136708);
        AppMethodBeat.o(136708);
    }
}
