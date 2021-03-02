package com.tencent.mm.plugin.luckymoney.f2f;

import android.media.SoundPool;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public final class a {
    public volatile boolean stopped = false;
    Map<Integer, Boolean> yRA = new HashMap();
    public SoundPool yRy = new SoundPool(2, 3, 0);
    Hashtable<String, Integer> yRz = new Hashtable<>();

    public a() {
        AppMethodBeat.i(65033);
        AppMethodBeat.o(65033);
    }

    public final void Df(String str) {
        int intValue;
        AppMethodBeat.i(65034);
        if (this.yRz.containsKey(str) && (intValue = this.yRz.get(str).intValue()) >= 0 && this.yRA.containsKey(Integer.valueOf(intValue)) && this.yRA.get(Integer.valueOf(intValue)).booleanValue()) {
            this.yRy.play(intValue, 1.0f, 1.0f, 0, 0, 1.0f);
        }
        AppMethodBeat.o(65034);
    }
}
