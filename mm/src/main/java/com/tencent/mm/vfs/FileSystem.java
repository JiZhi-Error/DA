package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;

public interface FileSystem extends Parcelable {

    public static class a {
        public long RbL;
        public long availableBlocks;
        public long bGI;
        public long blockSize;
        public long totalBlocks;
    }

    public interface b {
        void a(CancellationSignal cancellationSignal);

        boolean a(String str, b bVar, String str2);

        ReadableByteChannel boI(String str);

        ByteChannel boJ(String str);

        a boK(String str);

        boolean boL(String str);

        e boM(String str);

        boolean boN(String str);

        long c(String str, b bVar, String str2);

        boolean ck(String str, long j2);

        WritableByteChannel dv(String str, boolean z);

        OutputStream dw(String str, boolean z);

        Iterable<e> dx(String str, boolean z);

        boolean dy(String str, boolean z);

        String dz(String str, boolean z);

        boolean gC(String str);

        FileSystem hdQ();

        int hdR();

        ParcelFileDescriptor nr(String str, String str2);

        InputStream openRead(String str);
    }

    b cj(Map<String, String> map);
}
