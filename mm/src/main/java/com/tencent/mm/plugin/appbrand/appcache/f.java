package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.AssetManager;
import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

public final class f implements p, Closeable {
    private volatile int cR = -1;
    private volatile boolean kKk = true;
    private volatile AssetManager kKl;
    private volatile ByteArrayOutputStream kKm;
    private volatile int kKn = 0;
    private volatile int kKo = 0;
    private volatile int kKp = -1;
    private volatile Map<String, WxaPkg.Info> kKq = null;
    private volatile String mFilePath = null;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        if (r2 != false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(android.content.Context r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.f.<init>(android.content.Context, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(134262);
        try {
            close();
        } finally {
            super.finalize();
            AppMethodBeat.o(134262);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(134263);
        if (this.kKm != null && this.kKm.size() > 0) {
            try {
                this.kKm.close();
                this.kKm = null;
                AppMethodBeat.o(134263);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(134263);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.p
    public final int version() {
        return this.cR;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.p
    public final WxaPkg.Info openReadPartialInfo(String str) {
        int i2 = 0;
        AppMethodBeat.i(196149);
        if (this.kKq == null || Util.isNullOrNil(str)) {
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.kKq == null);
            if (this.kKq != null) {
                i2 = this.kKq.size();
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = str;
            Log.e("MicroMsg.AssetsWxaPkgReader", "openReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s", objArr);
            AppMethodBeat.o(196149);
            return null;
        }
        WxaPkg.Info info = this.kKq.get(n.We(str));
        AppMethodBeat.o(196149);
        return info;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.p
    public final InputStream UR(String str) {
        AppMethodBeat.i(134264);
        if (this.kKm == null || this.kKm.size() <= 0) {
            AppMethodBeat.o(134264);
            return null;
        }
        WxaPkg.Info openReadPartialInfo = openReadPartialInfo(str);
        if (openReadPartialInfo == null) {
            AppMethodBeat.o(134264);
            return null;
        } else if (Thread.currentThread().isInterrupted()) {
            InputStream a2 = a(openReadPartialInfo);
            AppMethodBeat.o(134264);
            return a2;
        } else {
            byte[] bArr = new byte[openReadPartialInfo.kKK];
            System.arraycopy(this.kKm.toByteArray(), openReadPartialInfo.kKJ, bArr, 0, openReadPartialInfo.kKK);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            AppMethodBeat.o(134264);
            return byteArrayInputStream;
        }
    }

    private InputStream a(WxaPkg.Info info) {
        InputStream inputStream;
        Throwable th;
        Exception e2;
        AppMethodBeat.i(134265);
        if (this.kKl == null) {
            AppMethodBeat.o(134265);
            return null;
        }
        try {
            byte[] bArr = new byte[info.kKK];
            inputStream = this.kKl.open(this.mFilePath);
            try {
                if (inputStream.read(bArr, info.kKJ, info.kKK) != info.kKK) {
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(134265);
                    return null;
                }
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                Util.qualityClose(inputStream);
                AppMethodBeat.o(134265);
                return byteArrayInputStream;
            } catch (Exception e3) {
                e2 = e3;
                try {
                    Log.e("MicroMsg.AssetsWxaPkgReader", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", this.mFilePath, info.fileName, e2);
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(134265);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(134265);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            inputStream = null;
            Log.e("MicroMsg.AssetsWxaPkgReader", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", this.mFilePath, info.fileName, e2);
            Util.qualityClose(inputStream);
            AppMethodBeat.o(134265);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            Util.qualityClose(inputStream);
            AppMethodBeat.o(134265);
            throw th;
        }
    }

    private void B(InputStream inputStream) {
        AppMethodBeat.i(134267);
        if (inputStream == null) {
            AppMethodBeat.o(134267);
            return;
        }
        this.kKm = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                this.kKm.write(bArr, 0, read);
            } else {
                this.kKm.flush();
                AppMethodBeat.o(134267);
                return;
            }
        }
    }

    private static int F(byte[] bArr, int i2) {
        AppMethodBeat.i(134268);
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i2, 4);
        wrap.order(ByteOrder.BIG_ENDIAN);
        int i3 = wrap.getInt();
        AppMethodBeat.o(134268);
        return i3;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.p
    public final boolean bvf() {
        AppMethodBeat.i(134266);
        if (!this.kKk || this.kKm == null || this.kKn <= 4) {
            Log.e("MicroMsg.AssetsWxaPkgReader", "readInfo, valid = %b, (null == mInputStream) = %b, mBodyInfoLength = %d, skip", Boolean.valueOf(this.kKk), this.kKm, Integer.valueOf(this.kKo));
            AppMethodBeat.o(134266);
            return false;
        } else if (this.kKq == null || this.kKp < 0 || this.kKp != this.kKq.size()) {
            byte[] bArr = new byte[this.kKn];
            System.arraycopy(this.kKm.toByteArray(), 14, bArr, 0, this.kKn);
            this.kKp = F(bArr, 0);
            a aVar = new a();
            WxaPkg.Info info = null;
            int i2 = 4;
            for (int i3 = 0; i3 < this.kKp; i3++) {
                int F = F(bArr, i2);
                int i4 = i2 + 4;
                String str = new String(bArr, i4, F);
                int i5 = i4 + F;
                int F2 = F(bArr, i5);
                int i6 = i5 + 4;
                int F3 = F(bArr, i6);
                i2 = i6 + 4;
                info = new WxaPkg.Info(this.mFilePath, str, F2, F3);
                aVar.put(str, info);
            }
            this.kKq = aVar;
            int size = this.kKm.size();
            if (info == null || info.kKJ + info.kKK <= size) {
                AppMethodBeat.o(134266);
                return true;
            }
            Log.e("MicroMsg.AssetsWxaPkgReader", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", Integer.valueOf(info.kKJ), Integer.valueOf(info.kKK), Integer.valueOf(size));
            AppMethodBeat.o(134266);
            return false;
        } else {
            AppMethodBeat.o(134266);
            return true;
        }
    }
}
