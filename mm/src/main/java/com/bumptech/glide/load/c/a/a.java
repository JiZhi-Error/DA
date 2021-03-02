package com.bumptech.glide.load.c.a;

import com.bumptech.glide.load.a.j;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a implements n<g, InputStream> {
    public static final h<Integer> aKF = h.c("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    private final m<g, g> aKG;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean X(g gVar) {
        return true;
    }

    /* Return type fixed from 'com.bumptech.glide.load.c.n$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a<InputStream> b(g gVar, int i2, int i3, i iVar) {
        AppMethodBeat.i(77329);
        g gVar2 = gVar;
        if (this.aKG != null) {
            g Y = this.aKG.Y(gVar2);
            if (Y == null) {
                m<g, g> mVar = this.aKG;
                mVar.aKd.put(m.a.Z(gVar2), gVar2);
            } else {
                gVar2 = Y;
            }
        }
        n.a aVar = new n.a(gVar2, new j(gVar2, ((Integer) iVar.a(aKF)).intValue()));
        AppMethodBeat.o(77329);
        return aVar;
    }

    static {
        AppMethodBeat.i(77330);
        AppMethodBeat.o(77330);
    }

    public a() {
        this(null);
    }

    public a(m<g, g> mVar) {
        this.aKG = mVar;
    }

    /* renamed from: com.bumptech.glide.load.c.a.a$a  reason: collision with other inner class name */
    public static class C0071a implements o<g, InputStream> {
        private final m<g, g> aKG = new m<>(500);

        public C0071a() {
            AppMethodBeat.i(77327);
            AppMethodBeat.o(77327);
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<g, InputStream> a(r rVar) {
            AppMethodBeat.i(77328);
            a aVar = new a(this.aKG);
            AppMethodBeat.o(77328);
            return aVar;
        }
    }
}
