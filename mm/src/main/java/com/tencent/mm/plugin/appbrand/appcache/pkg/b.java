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

public final class b extends WxaPkgBaseImpl {
    private static final ByteOrder kMF = ByteOrder.BIG_ENDIAN;
    private volatile int cR = -1;
    private volatile int kKn = 0;
    private volatile int kKo = 0;
    private volatile int kKp = -1;

    @Override // com.tencent.mm.plugin.appbrand.appcache.pkg.a
    public final boolean a(FileChannel fileChannel) {
        AppMethodBeat.i(175558);
        if (fileChannel == null) {
            AppMethodBeat.o(175558);
            return false;
        }
        fileChannel.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(14);
        allocate.order(kMF);
        fileChannel.read(allocate);
        if (-66 == allocate.get(0) && -19 == allocate.get(13)) {
            byte[] array = allocate.array();
            this.cR = A(array, 1, 4);
            this.kKn = A(array, 5, 4);
            this.kKo = A(array, 9, 4);
            AppMethodBeat.o(175558);
            return true;
        }
        AppMethodBeat.o(175558);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.pkg.a
    public final Map<String, WxaPkg.Info> a(FileChannel fileChannel, o oVar) {
        WxaPkgBaseImpl.Info info = null;
        AppMethodBeat.i(175559);
        if (fileChannel == null) {
            Log.e("MicroMsg.WxaPkgNormalImpl", "fileChannel is null");
            AppMethodBeat.o(175559);
            return null;
        } else if (oVar == null) {
            Log.e("MicroMsg.WxaPkgNormalImpl", "file is null");
            AppMethodBeat.o(175559);
            return null;
        } else {
            fileChannel.position(14L);
            ByteBuffer allocate = ByteBuffer.allocate(this.kKn);
            allocate.order(kMF);
            fileChannel.read(allocate);
            byte[] array = allocate.array();
            this.kKp = A(array, 0, 4);
            a aVar = new a();
            int i2 = 4;
            for (int i3 = 0; i3 < this.kKp; i3++) {
                int A = A(array, i2, 4);
                int i4 = i2 + 4;
                String str = new String(array, i4, A);
                int i5 = i4 + A;
                int A2 = A(array, i5, 4);
                int i6 = i5 + 4;
                int A3 = A(array, i6, 4);
                i2 = i6 + 4;
                info = new WxaPkgBaseImpl.Info(aa.z(oVar.her()), str, A2, A3);
                aVar.put(str, info);
            }
            if (info != null && ((long) (info.kKJ + info.kKK)) > oVar.length()) {
                Log.e("MicroMsg.WxaPkgNormalImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d), infoMap.size(%d), filesCount(%d)", Integer.valueOf(info.kKJ), Integer.valueOf(info.kKK), Long.valueOf(oVar.length()), Integer.valueOf(aVar.size()), Integer.valueOf(this.kKp));
            }
            AppMethodBeat.o(175559);
            return aVar;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.cR = -1;
        this.kKn = 0;
        this.kKo = 0;
        this.kKp = -1;
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
        return false;
    }
}
