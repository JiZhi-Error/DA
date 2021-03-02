package com.bumptech.glide.load.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class f<Data> implements n<File, Data> {
    private final d<Data> aJP;

    public interface d<Data> {
        void R(Data data);

        Class<Data> os();

        Data u(File file);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean X(File file) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a b(File file, int i2, int i3, i iVar) {
        AppMethodBeat.i(77236);
        File file2 = file;
        n.a aVar = new n.a(new com.bumptech.glide.f.b(file2), new c(file2, this.aJP));
        AppMethodBeat.o(77236);
        return aVar;
    }

    public f(d<Data> dVar) {
        this.aJP = dVar;
    }

    static final class c<Data> implements com.bumptech.glide.load.a.d<Data> {
        private final d<Data> aJQ;
        private Data data;
        private final File file;

        c(File file2, d<Data> dVar) {
            this.file = file2;
            this.aJQ = dVar;
        }

        @Override // com.bumptech.glide.load.a.d
        public final void a(g gVar, d.a<? super Data> aVar) {
            AppMethodBeat.i(77230);
            try {
                this.data = this.aJQ.u(this.file);
                aVar.S(this.data);
                AppMethodBeat.o(77230);
            } catch (FileNotFoundException e2) {
                Log.isLoggable("FileLoader", 3);
                aVar.e(e2);
                AppMethodBeat.o(77230);
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cleanup() {
            AppMethodBeat.i(77231);
            if (this.data != null) {
                try {
                    this.aJQ.R(this.data);
                    AppMethodBeat.o(77231);
                    return;
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(77231);
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.a.d
        public final Class<Data> os() {
            AppMethodBeat.i(77232);
            Class<Data> os = this.aJQ.os();
            AppMethodBeat.o(77232);
            return os;
        }

        @Override // com.bumptech.glide.load.a.d
        public final com.bumptech.glide.load.a ot() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static class a<Data> implements o<File, Data> {
        private final d<Data> aJQ;

        public a(d<Data> dVar) {
            this.aJQ = dVar;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<File, Data> a(r rVar) {
            AppMethodBeat.i(77226);
            f fVar = new f(this.aJQ);
            AppMethodBeat.o(77226);
            return fVar;
        }
    }

    public static class e extends a<InputStream> {
        public e() {
            super(new d<InputStream>() {
                /* class com.bumptech.glide.load.c.f.e.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.bumptech.glide.load.c.f.d
                public final /* synthetic */ void R(InputStream inputStream) {
                    AppMethodBeat.i(77233);
                    inputStream.close();
                    AppMethodBeat.o(77233);
                }

                @Override // com.bumptech.glide.load.c.f.d
                public final Class<InputStream> os() {
                    return InputStream.class;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.bumptech.glide.load.c.f.d
                public final /* synthetic */ InputStream u(File file) {
                    AppMethodBeat.i(77234);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    AppMethodBeat.o(77234);
                    return fileInputStream;
                }
            });
            AppMethodBeat.i(77235);
            AppMethodBeat.o(77235);
        }
    }

    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new d<ParcelFileDescriptor>() {
                /* class com.bumptech.glide.load.c.f.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.bumptech.glide.load.c.f.d
                public final /* synthetic */ void R(ParcelFileDescriptor parcelFileDescriptor) {
                    AppMethodBeat.i(77227);
                    parcelFileDescriptor.close();
                    AppMethodBeat.o(77227);
                }

                @Override // com.bumptech.glide.load.c.f.d
                public final Class<ParcelFileDescriptor> os() {
                    return ParcelFileDescriptor.class;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.bumptech.glide.load.c.f.d
                public final /* synthetic */ ParcelFileDescriptor u(File file) {
                    AppMethodBeat.i(77228);
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
                    AppMethodBeat.o(77228);
                    return open;
                }
            });
            AppMethodBeat.i(77229);
            AppMethodBeat.o(77229);
        }
    }
}
