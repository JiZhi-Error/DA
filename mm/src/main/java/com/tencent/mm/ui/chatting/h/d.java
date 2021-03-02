package com.tencent.mm.ui.chatting.h;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.n.f;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public interface d {

    public interface b {
        void next();
    }

    public interface c<T> {
        f b(C2097d<T> dVar);

        void c(C2097d<T> dVar);
    }

    void a(a aVar, boolean z, c cVar);

    void cancel();

    /* renamed from: com.tencent.mm.ui.chatting.h.d$d  reason: collision with other inner class name */
    public static class C2097d<T> {
        public Bundle PDK;
        public a PDL;
        public List<T> PDM;
        public int PDN;
        public SparseArray<T> PDO;
        public int gAZ;
        public AtomicBoolean iLz;
        public int selection = -1;

        C2097d(a aVar, AtomicBoolean atomicBoolean) {
            AppMethodBeat.i(179939);
            this.iLz = atomicBoolean;
            this.PDL = aVar;
            this.PDM = new LinkedList();
            AppMethodBeat.o(179939);
        }

        public final String toString() {
            AppMethodBeat.i(36425);
            String str = "LoadedResult{sourceArgs=" + this.PDK + ", mode=" + this.PDL + ", selection=" + this.selection + ", count=" + this.PDN + ", totalCount=" + this.gAZ + '}';
            AppMethodBeat.o(36425);
            return str;
        }
    }

    public enum a {
        ACTION_TOP,
        ACTION_BOTTOM,
        ACTION_UPDATE,
        ACTION_ENTER,
        ACTION_POSITION,
        ACTION_UN_KNOW;

        public static a valueOf(String str) {
            AppMethodBeat.i(36422);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(36422);
            return aVar;
        }

        static {
            AppMethodBeat.i(36423);
            AppMethodBeat.o(36423);
        }
    }
}
