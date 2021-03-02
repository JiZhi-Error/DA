package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class t {
    public final SparseArray<List<b>> kEp;
    final SparseIntArray kEq;

    public interface b {
        void btg();
    }

    /* synthetic */ t(byte b2) {
        this();
    }

    public static class a {
        public static t kEr = new t((byte) 0);

        static {
            AppMethodBeat.i(134600);
            AppMethodBeat.o(134600);
        }
    }

    private t() {
        AppMethodBeat.i(134601);
        this.kEp = new SparseArray<>();
        this.kEq = new SparseIntArray();
        AppMethodBeat.o(134601);
    }

    public final void e(int i2, List<b> list) {
        AppMethodBeat.i(134605);
        if (this.kEq.size() <= 0) {
            AppMethodBeat.o(134605);
            return;
        }
        Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify pending : %d", Integer.valueOf(i2));
        if (this.kEq.indexOfKey(i2) < 0) {
            Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "not in pending notify");
            AppMethodBeat.o(134605);
            return;
        }
        this.kEq.delete(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            list.get(i3).btg();
        }
        AppMethodBeat.o(134605);
    }
}
