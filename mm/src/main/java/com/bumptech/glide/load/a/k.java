package com.bumptech.glide.load.a;

import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.d.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class k implements e<InputStream> {
    private final n aFn;

    k(InputStream inputStream, b bVar) {
        AppMethodBeat.i(76895);
        this.aFn = new n(inputStream, bVar);
        this.aFn.mark(5242880);
        AppMethodBeat.o(76895);
    }

    @Override // com.bumptech.glide.load.a.e
    public final void cleanup() {
        AppMethodBeat.i(76896);
        this.aFn.release();
        AppMethodBeat.o(76896);
    }

    public static final class a implements e.a<InputStream> {
        private final b aFo;

        /* Return type fixed from 'com.bumptech.glide.load.a.e' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.bumptech.glide.load.a.e.a
        public final /* synthetic */ e<InputStream> T(InputStream inputStream) {
            AppMethodBeat.i(76894);
            k kVar = new k(inputStream, this.aFo);
            AppMethodBeat.o(76894);
            return kVar;
        }

        public a(b bVar) {
            this.aFo = bVar;
        }

        @Override // com.bumptech.glide.load.a.e.a
        public final Class<InputStream> os() {
            return InputStream.class;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.bumptech.glide.load.a.e
    public final /* synthetic */ InputStream ov() {
        AppMethodBeat.i(76897);
        this.aFn.reset();
        n nVar = this.aFn;
        AppMethodBeat.o(76897);
        return nVar;
    }
}
