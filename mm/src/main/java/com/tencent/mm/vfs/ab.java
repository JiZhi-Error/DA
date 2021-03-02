package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.mm.vfs.FileSystem;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class ab extends a {
    protected final FileSystem.b Rbp;

    protected ab(FileSystem.b bVar) {
        this.Rbp = bVar;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public int hdR() {
        return this.Rbp.hdR();
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final FileSystem.a boK(String str) {
        return this.Rbp.boK(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public InputStream openRead(String str) {
        return this.Rbp.openRead(str);
    }

    @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
    public final ReadableByteChannel boI(String str) {
        return this.Rbp.boJ(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public OutputStream dw(String str, boolean z) {
        return this.Rbp.dw(str, z);
    }

    @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
    public final WritableByteChannel dv(String str, boolean z) {
        return this.Rbp.dv(str, z);
    }

    @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
    public final ByteChannel boJ(String str) {
        return this.Rbp.boJ(str);
    }

    @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
    public final ParcelFileDescriptor nr(String str, String str2) {
        return this.Rbp.nr(str, str2);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean boL(String str) {
        return this.Rbp.boL(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final e boM(String str) {
        return this.Rbp.boM(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean ck(String str, long j2) {
        return this.Rbp.ck(str, j2);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean gC(String str) {
        return this.Rbp.gC(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final Iterable<e> dx(String str, boolean z) {
        return this.Rbp.dx(str, z);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean boN(String str) {
        return this.Rbp.boN(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean dy(String str, boolean z) {
        return this.Rbp.dy(str, z);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final String dz(String str, boolean z) {
        return this.Rbp.dz(str, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.a
    public boolean b(String str, FileSystem.b bVar, String str2) {
        if (this.Rbp instanceof a) {
            return ((a) this.Rbp).b(str, bVar, str2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.a
    public long d(String str, FileSystem.b bVar, String str2) {
        if (this.Rbp instanceof a) {
            return ((a) this.Rbp).d(str, bVar, str2);
        }
        return this.Rbp.c(str, bVar, str2);
    }

    @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
    public final void a(CancellationSignal cancellationSignal) {
        this.Rbp.a(cancellationSignal);
    }
}
