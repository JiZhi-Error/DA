package com.bumptech.glide.load.c;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public interface n<Model, Data> {
    boolean X(Model model);

    a<Data> b(Model model, int i2, int i3, i iVar);

    public static class a<Data> {
        public final g aFO;
        public final List<g> aKg;
        public final d<Data> aKh;

        public a(g gVar, d<Data> dVar) {
            this(gVar, Collections.emptyList(), dVar);
            AppMethodBeat.i(77267);
            AppMethodBeat.o(77267);
        }

        private a(g gVar, List<g> list, d<Data> dVar) {
            AppMethodBeat.i(77268);
            this.aFO = (g) j.checkNotNull(gVar, "Argument must not be null");
            this.aKg = (List) j.checkNotNull(list, "Argument must not be null");
            this.aKh = (d) j.checkNotNull(dVar, "Argument must not be null");
            AppMethodBeat.o(77268);
        }
    }
}
