package com.tencent.mm.plugin.notification.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class b {
    public ArrayList<Long> AHb;
    int currentIndex;

    public b() {
        AppMethodBeat.i(26736);
        this.currentIndex = 0;
        this.AHb = new ArrayList<>();
        this.currentIndex = 0;
        AppMethodBeat.o(26736);
    }

    public final void HC(long j2) {
        AppMethodBeat.i(26737);
        Log.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", Long.valueOf(j2), Integer.valueOf(this.currentIndex), Integer.valueOf(this.AHb.size()));
        this.AHb.add(Long.valueOf(j2));
        AppMethodBeat.o(26737);
    }

    public final long eyO() {
        AppMethodBeat.i(26738);
        long j2 = -1;
        if (this.AHb.size() > 0 && this.currentIndex < this.AHb.size()) {
            j2 = this.AHb.get(this.currentIndex).longValue();
        }
        Log.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", Long.valueOf(j2), Integer.valueOf(this.currentIndex), Integer.valueOf(this.AHb.size()));
        this.currentIndex++;
        AppMethodBeat.o(26738);
        return j2;
    }

    public final boolean contains(long j2) {
        AppMethodBeat.i(26739);
        boolean contains = this.AHb.contains(Long.valueOf(j2));
        AppMethodBeat.o(26739);
        return contains;
    }

    public final void clear() {
        AppMethodBeat.i(26740);
        this.AHb.clear();
        this.currentIndex = 0;
        AppMethodBeat.o(26740);
    }

    public final long get(int i2) {
        AppMethodBeat.i(26741);
        long longValue = this.AHb.get(i2).longValue();
        AppMethodBeat.o(26741);
        return longValue;
    }

    public final void remove(long j2) {
        AppMethodBeat.i(26742);
        this.AHb.remove(Long.valueOf(j2));
        AppMethodBeat.o(26742);
    }
}
