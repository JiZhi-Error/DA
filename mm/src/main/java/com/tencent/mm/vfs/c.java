package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.a.a;
import com.tencent.mm.vfs.a.c;
import com.tencent.mm.vfs.a.e;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class c extends a {
    public abstract List<FileSystem.b> hdS();

    public abstract FileSystem.b ho(String str, int i2);

    @Override // com.tencent.mm.vfs.FileSystem.b
    public int hdR() {
        return ho("", 0).hdR();
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public FileSystem.a boK(String str) {
        FileSystem.b ho = ho(str, 0);
        if (ho != null) {
            return ho.boK(str);
        }
        throw new RuntimeException("Cannot delegate path to filesystem: ".concat(String.valueOf(str)));
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public InputStream openRead(String str) {
        FileSystem.b ho = ho(str, 1);
        if (ho != null) {
            return ho.openRead(str);
        }
        throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(str)));
    }

    @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
    public ReadableByteChannel boI(String str) {
        FileSystem.b ho = ho(str, 1);
        if (ho != null) {
            return ho.boI(str);
        }
        throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(str)));
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public OutputStream dw(String str, boolean z) {
        FileSystem.b ho = ho(str, z ? 3 : 2);
        if (ho != null) {
            return ho.dw(str, z);
        }
        throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(str)));
    }

    @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
    public WritableByteChannel dv(String str, boolean z) {
        FileSystem.b ho = ho(str, z ? 3 : 2);
        if (ho != null) {
            return ho.dv(str, z);
        }
        throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(str)));
    }

    @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
    public ByteChannel boJ(String str) {
        FileSystem.b ho = ho(str, 3);
        if (ho != null) {
            return ho.boJ(str);
        }
        throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(str)));
    }

    @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
    public ParcelFileDescriptor nr(String str, String str2) {
        int i2;
        if (str2.contains("rw")) {
            i2 = 3;
        } else if (str2.contains("w")) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        FileSystem.b ho = ho(str, i2);
        if (ho != null) {
            return ho.nr(str, str2);
        }
        throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(str)));
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public boolean boL(String str) {
        FileSystem.b ho = ho(str, 1);
        if (ho == null || !ho.boL(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public e boM(String str) {
        FileSystem.b ho = ho(str, 1);
        if (ho == null) {
            return null;
        }
        return ho.boM(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean ck(String str, long j2) {
        FileSystem.b ho = ho(str, 3);
        return ho != null && ho.ck(str, j2);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean gC(String str) {
        boolean z = false;
        for (FileSystem.b bVar : hdS()) {
            z = bVar.gC(str) | z;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public static final class b implements a.AbstractC2153a<FileSystem.b, e> {
        private final String mPrefix;

        /* Return type fixed from 'java.lang.Iterable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vfs.a.a.AbstractC2153a
        public final /* synthetic */ Iterable<? extends e> eq(FileSystem.b bVar) {
            AppMethodBeat.i(187635);
            Iterable<e> dx = bVar.dx(this.mPrefix, false);
            AppMethodBeat.o(187635);
            return dx;
        }

        b(String str) {
            this.mPrefix = str;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.vfs.c$c  reason: collision with other inner class name */
    public static final class C2154c implements c.a<e> {
        private final HashSet<String> Rbn;

        private C2154c() {
            AppMethodBeat.i(187636);
            this.Rbn = new HashSet<>();
            AppMethodBeat.o(187636);
        }

        /* synthetic */ C2154c(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vfs.a.c.a
        public final /* synthetic */ boolean dm(e eVar) {
            AppMethodBeat.i(187637);
            if (!this.Rbn.add(eVar.NGP)) {
                AppMethodBeat.o(187637);
                return true;
            }
            AppMethodBeat.o(187637);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements a.AbstractC2153a<e, e> {
        private final Iterable<FileSystem.b> Rbm;

        /* Return type fixed from 'java.lang.Iterable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vfs.a.a.AbstractC2153a
        public final /* synthetic */ Iterable<? extends e> eq(e eVar) {
            AppMethodBeat.i(187634);
            e eVar2 = eVar;
            Set singleton = Collections.singleton(eVar2);
            if (!eVar2.RbJ) {
                AppMethodBeat.o(187634);
                return singleton;
            }
            e eVar3 = new e(singleton, new com.tencent.mm.vfs.a.a(new com.tencent.mm.vfs.a.c(new com.tencent.mm.vfs.a.a(this.Rbm, new b(eVar2.NGP)), new C2154c((byte) 0)), this));
            AppMethodBeat.o(187634);
            return eVar3;
        }

        a(Iterable<FileSystem.b> iterable) {
            this.Rbm = iterable;
        }
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public Iterable<e> dx(String str, boolean z) {
        List<FileSystem.b> hdS = hdS();
        int size = hdS.size();
        if (size == 1) {
            return hdS.get(0).dx(str, z);
        }
        if (size == 0) {
            return null;
        }
        com.tencent.mm.vfs.a.c cVar = new com.tencent.mm.vfs.a.c(new com.tencent.mm.vfs.a.a(hdS(), new b(str)), new C2154c((byte) 0));
        if (z) {
            return new com.tencent.mm.vfs.a.a(cVar, new a(hdS()));
        }
        return cVar;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public boolean boN(String str) {
        FileSystem.b ho = ho(str, 2);
        return ho != null && ho.boN(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean dy(String str, boolean z) {
        boolean z2 = false;
        for (FileSystem.b bVar : hdS()) {
            z2 = bVar.dy(str, z) | z2;
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.a
    public final boolean b(String str, FileSystem.b bVar, String str2) {
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.a
    public final long d(String str, FileSystem.b bVar, String str2) {
        throw new AssertionError();
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final String dz(String str, boolean z) {
        FileSystem.b ho = ho(str, z ? 2 : 1);
        if (ho == null) {
            return null;
        }
        return ho.dz(str, z);
    }

    @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
    public void a(CancellationSignal cancellationSignal) {
        for (FileSystem.b bVar : hdS()) {
            cancellationSignal.throwIfCanceled();
            bVar.a(cancellationSignal);
        }
    }
}
