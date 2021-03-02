package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class e {
    ArrayList<d> tkt;
    boolean tku;
    ArrayList<b> tkv;

    public interface b {
        void cWO();
    }

    /* synthetic */ e(byte b2) {
        this();
    }

    static final class a {
        private static final e tkw = new e((byte) 0);

        static {
            AppMethodBeat.i(107391);
            AppMethodBeat.o(107391);
        }
    }

    private e() {
        AppMethodBeat.i(107392);
        this.tkt = new ArrayList<>();
        this.tku = false;
        this.tkv = new ArrayList<>();
        AppMethodBeat.o(107392);
    }

    public final d asv(String str) {
        AppMethodBeat.i(107393);
        Iterator<d> it = this.tkt.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.dLo.dLl.equals(str)) {
                AppMethodBeat.o(107393);
                return next;
            }
        }
        AppMethodBeat.o(107393);
        return null;
    }

    public final void clear() {
        AppMethodBeat.i(107394);
        Log.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.tkt.clear();
        Iterator<b> it = this.tkv.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(107394);
    }

    public final void cWM() {
        AppMethodBeat.i(107395);
        Iterator<b> it = this.tkv.iterator();
        while (it.hasNext()) {
            it.next().cWO();
        }
        AppMethodBeat.o(107395);
    }
}
