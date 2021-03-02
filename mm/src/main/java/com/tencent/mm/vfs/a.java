package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.mm.vfs.FileSystem;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class a implements FileSystem.b {
    @Override // com.tencent.mm.vfs.FileSystem.b
    public ReadableByteChannel boI(String str) {
        return Channels.newChannel(openRead(str));
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public WritableByteChannel dv(String str, boolean z) {
        return Channels.newChannel(dw(str, z));
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public ByteChannel boJ(String str) {
        throw new FileNotFoundException("Not supported by the filesystem.");
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public ParcelFileDescriptor nr(String str, String str2) {
        throw new FileNotFoundException("Not supported by the filesystem.");
    }

    private static FileSystem.b a(FileSystem.b bVar, String str, int i2) {
        FileSystem.b bVar2 = bVar;
        while (bVar2 instanceof c) {
            bVar2 = ((c) bVar2).ho(str, i2);
        }
        return bVar2;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public boolean a(String str, FileSystem.b bVar, String str2) {
        FileSystem.b a2 = a(this, str, 2);
        FileSystem.b a3 = a(bVar, str2, 1);
        if (a2 == null || a3 == null) {
            throw new IOException("Cannot resolve delegate filesystem.");
        } else if (a2 instanceof a) {
            return ((a) a2).b(str, a3, str2);
        } else {
            return a2.a(str, a3, str2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(String str, FileSystem.b bVar, String str2) {
        return false;
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public long c(String str, FileSystem.b bVar, String str2) {
        FileSystem.b a2 = a(this, str, 2);
        FileSystem.b a3 = a(bVar, str2, 1);
        if (a2 == null || a3 == null) {
            throw new IOException("Cannot resolve delegate filesystem.");
        } else if (a2 instanceof a) {
            return ((a) a2).d(str, a3, str2);
        } else {
            return a2.c(str, a3, str2);
        }
    }

    /* access modifiers changed from: protected */
    public long d(String str, FileSystem.b bVar, String str2) {
        return aa.a(bVar, str2, this, str);
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public void a(CancellationSignal cancellationSignal) {
    }
}
