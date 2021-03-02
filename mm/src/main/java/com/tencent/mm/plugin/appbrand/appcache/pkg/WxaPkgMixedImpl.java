package com.tencent.mm.plugin.appbrand.appcache.pkg;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgBaseImpl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Map;

public final class WxaPkgMixedImpl extends WxaPkgBaseImpl {
    private static final ByteOrder kMF = ByteOrder.BIG_ENDIAN;
    private volatile int cR = -1;
    private volatile int kKn = 0;
    private volatile int kKo = 0;
    private volatile int kKp = -1;
    private volatile int kOL = 0;

    @Override // com.tencent.mm.plugin.appbrand.appcache.pkg.a
    public final boolean a(FileChannel fileChannel) {
        AppMethodBeat.i(175556);
        if (fileChannel == null) {
            AppMethodBeat.o(175556);
            return false;
        }
        fileChannel.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(18);
        allocate.order(kMF);
        fileChannel.read(allocate);
        if (-66 == allocate.get(0) && -19 == allocate.get(17)) {
            byte[] array = allocate.array();
            this.cR = A(array, 1, 4);
            this.kKn = A(array, 5, 4);
            this.kOL = A(array, 9, 4);
            this.kKo = A(array, 13, 4);
            AppMethodBeat.o(175556);
            return true;
        }
        AppMethodBeat.o(175556);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.pkg.a
    public final Map<String, WxaPkg.Info> a(FileChannel fileChannel, o oVar) {
        AppMethodBeat.i(175557);
        if (fileChannel == null) {
            Log.e("MicroMsg.WxaPkgMixedImpl", "fileChannel is null");
            AppMethodBeat.o(175557);
            return null;
        } else if (oVar == null) {
            Log.e("MicroMsg.WxaPkgMixedImpl", "file is null");
            AppMethodBeat.o(175557);
            return null;
        } else {
            fileChannel.position(18L);
            ByteBuffer allocate = ByteBuffer.allocate(this.kKn);
            allocate.order(kMF);
            fileChannel.read(allocate);
            byte[] array = allocate.array();
            this.kKp = A(array, 0, 4);
            a aVar = new a();
            Info info = null;
            int i2 = 0;
            int i3 = 4;
            while (i2 < this.kKp) {
                int A = A(array, i3, 4);
                int i4 = i3 + 4;
                String str = new String(array, i4, A);
                int i5 = A + i4;
                int A2 = A(array, i5, 1);
                int i6 = i5 + 1;
                int A3 = A(array, i6, 4);
                int i7 = i6 + 4;
                int A4 = A(array, i7, 4);
                int i8 = i7 + 4;
                int i9 = 0;
                if (A2 == 0) {
                    i9 = this.kKn + 18 + this.kOL + A3;
                } else if (A2 == 1) {
                    i9 = this.kKn + 18 + A3;
                } else {
                    Log.e("MicroMsg.WxaPkgMixedImpl", "encType error: %d", Integer.valueOf(A2));
                }
                Info info2 = new Info(aa.z(oVar.her()), str, i9, A4, A2);
                aVar.put(str, info2);
                i2++;
                i3 = i8;
                info = info2;
            }
            if (info != null && ((long) (((WxaPkgBaseImpl.Info) info).kKJ + ((WxaPkgBaseImpl.Info) info).kKK)) > oVar.length()) {
                Log.e("MicroMsg.WxaPkgMixedImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d), infoMap.size(%d), filesCount(%d)", Integer.valueOf(((WxaPkgBaseImpl.Info) info).kKJ), Integer.valueOf(((WxaPkgBaseImpl.Info) info).kKK), Long.valueOf(oVar.length()), Integer.valueOf(aVar.size()), Integer.valueOf(this.kKp));
            }
            AppMethodBeat.o(175557);
            return aVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.pkg.a
    public final int getVersion() {
        return this.cR;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.pkg.a
    public final int bwF() {
        return this.kKn;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.pkg.a
    public final int bwG() {
        return this.kKp;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.pkg.a
    public final boolean b(WxaPkg.Info info) {
        return (info instanceof Info) && info.fileName != null && ((Info) info).kOM == 1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public static class Info extends WxaPkgBaseImpl.Info {
        public final int kOM;

        public Info(String str, String str2, int i2, int i3, int i4) {
            super(str, str2, i2, i3);
            this.kOM = i4;
        }
    }
}