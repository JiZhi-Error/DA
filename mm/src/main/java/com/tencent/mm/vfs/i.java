package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.mm.vfs.FileSystem;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class i implements FileSystem.b {
    @Override // com.tencent.mm.vfs.FileSystem.b
    public final int hdR() {
        return 28;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final FileSystem.a boK(String str) {
        return null;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final InputStream openRead(String str) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final ReadableByteChannel boI(String str) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final OutputStream dw(String str, boolean z) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final WritableByteChannel dv(String str, boolean z) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final ByteChannel boJ(String str) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final ParcelFileDescriptor nr(String str, String str2) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean boL(String str) {
        return false;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final e boM(String str) {
        return null;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean ck(String str, long j2) {
        return false;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean gC(String str) {
        return false;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final Iterable<e> dx(String str, boolean z) {
        return null;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean boN(String str) {
        return false;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean dy(String str, boolean z) {
        return false;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final boolean a(String str, FileSystem.b bVar, String str2) {
        return false;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final long c(String str, FileSystem.b bVar, String str2) {
        throw new FileNotFoundException("Path '" + str + "' not found on NullFileSystem");
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final String dz(String str, boolean z) {
        return null;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public void a(CancellationSignal cancellationSignal) {
    }
}
