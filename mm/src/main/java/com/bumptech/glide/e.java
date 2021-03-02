package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import com.bumptech.glide.e.a.b;
import com.bumptech.glide.e.f;
import com.bumptech.glide.load.b.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public final class e extends ContextWrapper {
    static final k<?, ?> aCF = new b();
    final List<com.bumptech.glide.e.e<Object>> aCD;
    public final boolean aCE;
    private final b aCG;
    final k aCi;
    public final h aCn;
    public final com.bumptech.glide.load.b.a.b aCo;
    final Map<Class<?>, k<?, ?>> aCt;
    public final int aCy;
    final f aCz;

    static {
        AppMethodBeat.i(76783);
        AppMethodBeat.o(76783);
    }

    public e(Context context, com.bumptech.glide.load.b.a.b bVar, h hVar, b bVar2, f fVar, Map<Class<?>, k<?, ?>> map, List<com.bumptech.glide.e.e<Object>> list, k kVar, boolean z, int i2) {
        super(context.getApplicationContext());
        AppMethodBeat.i(204441);
        this.aCo = bVar;
        this.aCn = hVar;
        this.aCG = bVar2;
        this.aCz = fVar;
        this.aCD = list;
        this.aCt = map;
        this.aCi = kVar;
        this.aCE = z;
        this.aCy = i2;
        AppMethodBeat.o(204441);
    }
}
