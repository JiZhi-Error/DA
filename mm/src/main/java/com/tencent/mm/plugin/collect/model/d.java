package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public enum d {
    INSTANCE;
    
    public List<a> pQG = new LinkedList();

    public interface a {
        void a(u uVar);
    }

    private d(String str) {
        AppMethodBeat.i(63778);
        AppMethodBeat.o(63778);
    }

    public static d valueOf(String str) {
        AppMethodBeat.i(63777);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(63777);
        return dVar;
    }

    static {
        AppMethodBeat.i(63779);
        AppMethodBeat.o(63779);
    }
}
