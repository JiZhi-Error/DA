package com.tencent.mm.plugin.music.b.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    static void M(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(62939);
        StringBuilder sb = new StringBuilder();
        sb.append("idkeyGroupStat:  id:971");
        Iterator<IDKey> it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey next = it.next();
            sb.append(", key:" + next.GetKey() + " value:" + next.GetValue());
        }
        b.d("MicroMsg.Audio.AudioMixReport", sb.toString());
        AppMethodBeat.o(62939);
    }
}
