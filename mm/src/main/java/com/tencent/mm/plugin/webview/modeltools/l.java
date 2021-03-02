package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;

public final class l {
    private HashSet<Integer> JbA = new HashSet<>();
    public HashMap<String, b> JbB = new HashMap<>();
    public HashMap<String, a> Jby = new HashMap<>();
    public HashMap<String, a> Jbz = new HashMap<>();

    public static class a {
        public String desc;
        public String link;
        public String title;
        public String twt;
    }

    public static class b {
        public boolean JbC;
        public boolean JbD;
        public int duration;
        public String gCv;
        public int iwc;
        public int iwf;
        public String userName;
        public String vid;
        public int videoHeight;
        public int videoWidth;
    }

    public l() {
        AppMethodBeat.i(79218);
        AppMethodBeat.o(79218);
    }

    public final boolean aZx(String str) {
        AppMethodBeat.i(79219);
        if (!this.JbB.containsKey(str) || this.JbB.get(str) == null) {
            AppMethodBeat.o(79219);
            return false;
        }
        AppMethodBeat.o(79219);
        return true;
    }

    public final b aZy(String str) {
        AppMethodBeat.i(79220);
        b bVar = this.JbB.get(str);
        AppMethodBeat.o(79220);
        return bVar;
    }

    public final void cW(int i2, String str) {
        AppMethodBeat.i(79221);
        if (Util.getBoolean(str, false)) {
            this.JbA.add(Integer.valueOf(i2));
            AppMethodBeat.o(79221);
            return;
        }
        this.JbA.remove(Integer.valueOf(i2));
        AppMethodBeat.o(79221);
    }

    public final boolean agd(int i2) {
        AppMethodBeat.i(79222);
        boolean remove = this.JbA.remove(Integer.valueOf(i2));
        AppMethodBeat.o(79222);
        return remove;
    }
}
