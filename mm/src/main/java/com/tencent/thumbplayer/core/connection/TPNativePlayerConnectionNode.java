package com.tencent.thumbplayer.core.connection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TPNativePlayerConnectionNode {
    private HashMap<Integer, HashMap<Integer, Long>> mLongMap;

    public TPNativePlayerConnectionNode() {
        AppMethodBeat.i(189878);
        this.mLongMap = null;
        this.mLongMap = new HashMap<>();
        AppMethodBeat.o(189878);
    }

    public boolean addAction(int i2) {
        AppMethodBeat.i(189879);
        if (this.mLongMap.containsKey(Integer.valueOf(i2))) {
            AppMethodBeat.o(189879);
            return false;
        }
        this.mLongMap.put(Integer.valueOf(i2), new HashMap<>());
        AppMethodBeat.o(189879);
        return true;
    }

    public void removeAction(int i2) {
        AppMethodBeat.i(189880);
        if (this.mLongMap.containsKey(Integer.valueOf(i2))) {
            this.mLongMap.remove(Integer.valueOf(i2));
        }
        AppMethodBeat.o(189880);
    }

    public boolean setLongActionConfig(int i2, int i3, long j2) {
        AppMethodBeat.i(189881);
        if (!this.mLongMap.containsKey(Integer.valueOf(i2))) {
            AppMethodBeat.o(189881);
            return false;
        }
        this.mLongMap.get(Integer.valueOf(i2)).put(Integer.valueOf(i3), Long.valueOf(j2));
        AppMethodBeat.o(189881);
        return true;
    }
}
