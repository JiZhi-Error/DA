package com.bumptech.glide.load.c;

import android.util.Base64;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e<Model, Data> implements n<Model, Data> {
    private final a<Data> aJK;

    public interface a<Data> {
        Data R(String str);

        void R(Data data);

        Class<Data> os();
    }

    public e(a<Data> aVar) {
        this.aJK = aVar;
    }

    @Override // com.bumptech.glide.load.c.n
    public final n.a<Data> b(Model model, int i2, int i3, i iVar) {
        AppMethodBeat.i(77224);
        n.a<Data> aVar = new n.a<>(new com.bumptech.glide.f.b(model), new b(model.toString(), this.aJK));
        AppMethodBeat.o(77224);
        return aVar;
    }

    @Override // com.bumptech.glide.load.c.n
    public final boolean X(Model model) {
        AppMethodBeat.i(77225);
        boolean startsWith = model.toString().startsWith("data:image");
        AppMethodBeat.o(77225);
        return startsWith;
    }

    static final class b<Data> implements d<Data> {
        private final String aJL;
        private final a<Data> aJM;
        private Data data;

        b(String str, a<Data> aVar) {
            this.aJL = str;
            this.aJM = aVar;
        }

        @Override // com.bumptech.glide.load.a.d
        public final void a(g gVar, d.a<? super Data> aVar) {
            AppMethodBeat.i(77217);
            try {
                this.data = this.aJM.R(this.aJL);
                aVar.S(this.data);
                AppMethodBeat.o(77217);
            } catch (IllegalArgumentException e2) {
                aVar.e(e2);
                AppMethodBeat.o(77217);
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cleanup() {
            AppMethodBeat.i(77218);
            try {
                this.aJM.R((Object) this.data);
                AppMethodBeat.o(77218);
            } catch (IOException e2) {
                AppMethodBeat.o(77218);
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.a.d
        public final Class<Data> os() {
            AppMethodBeat.i(77219);
            Class<Data> os = this.aJM.os();
            AppMethodBeat.o(77219);
            return os;
        }

        @Override // com.bumptech.glide.load.a.d
        public final com.bumptech.glide.load.a ot() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {
        private final a<InputStream> aJN = new a<InputStream>() {
            /* class com.bumptech.glide.load.c.e.c.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.bumptech.glide.load.c.e.a
            public final /* synthetic */ void R(InputStream inputStream) {
                AppMethodBeat.i(77220);
                inputStream.close();
                AppMethodBeat.o(77220);
            }

            @Override // com.bumptech.glide.load.c.e.a
            public final Class<InputStream> os() {
                return InputStream.class;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.bumptech.glide.load.c.e.a
            public final /* synthetic */ InputStream R(String str) {
                AppMethodBeat.i(77221);
                if (!str.startsWith("data:image")) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Not a valid image data URL.");
                    AppMethodBeat.o(77221);
                    throw illegalArgumentException;
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Missing comma in data URL.");
                    AppMethodBeat.o(77221);
                    throw illegalArgumentException2;
                } else if (!str.substring(0, indexOf).endsWith(";base64")) {
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Not a base64 image data URL.");
                    AppMethodBeat.o(77221);
                    throw illegalArgumentException3;
                } else {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    AppMethodBeat.o(77221);
                    return byteArrayInputStream;
                }
            }
        };

        public c() {
            AppMethodBeat.i(77222);
            AppMethodBeat.o(77222);
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Model, InputStream> a(r rVar) {
            AppMethodBeat.i(77223);
            e eVar = new e(this.aJN);
            AppMethodBeat.o(77223);
            return eVar;
        }
    }
}
