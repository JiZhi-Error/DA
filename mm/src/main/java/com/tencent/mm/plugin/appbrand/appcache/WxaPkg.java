package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgBaseImpl;
import com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgMixedImpl;
import com.tencent.mm.plugin.appbrand.appcache.pkg.a;
import com.tencent.mm.plugin.appbrand.appcache.pkg.b;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class WxaPkg implements p, Closeable {
    public static final ByteOrder kMF = ByteOrder.BIG_ENDIAN;
    public volatile boolean kKk;
    private volatile Map<String, Info> kKq;
    private volatile RandomAccessFile kMG;
    private volatile FileChannel kMH;
    private volatile FileStructStat kMI;
    private volatile a kMJ;
    public final o mFile;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029 A[SYNTHETIC, Splitter:B:16:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int Vg(java.lang.String r5) {
        /*
            r4 = 182982(0x2cac6, float:2.56412E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.mm.plugin.appbrand.appcache.WxaPkg r3 = new com.tencent.mm.plugin.appbrand.appcache.WxaPkg
            r3.<init>(r5)
            r2 = 0
            boolean r0 = r3.kKk     // Catch:{ Throwable -> 0x001d, all -> 0x0039 }
            if (r0 == 0) goto L_0x001b
            int r0 = r3.version()     // Catch:{ Throwable -> 0x001d, all -> 0x0039 }
        L_0x0014:
            r3.close()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x001b:
            r0 = 0
            goto L_0x0014
        L_0x001d:
            r0 = move-exception
            r1 = 182982(0x2cac6, float:2.56412E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)     // Catch:{ all -> 0x0025 }
            throw r0     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r1 = move-exception
            r2 = r0
        L_0x0027:
            if (r2 == 0) goto L_0x0035
            r3.close()     // Catch:{ Throwable -> 0x0030 }
        L_0x002c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r1
        L_0x0030:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x002c
        L_0x0035:
            r3.close()
            goto L_0x002c
        L_0x0039:
            r0 = move-exception
            r1 = r0
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Vg(java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ct(java.lang.String r6, java.lang.String r7) {
        /*
            r1 = 0
            r5 = 196151(0x2fe37, float:2.74866E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.mm.plugin.appbrand.appcache.WxaPkg r4 = new com.tencent.mm.plugin.appbrand.appcache.WxaPkg     // Catch:{ Exception -> 0x0034 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0034 }
            r4.bvf()     // Catch:{ Throwable -> 0x001e, all -> 0x0043 }
            java.io.InputStream r0 = r4.UR(r7)     // Catch:{ Throwable -> 0x001e, all -> 0x0043 }
            java.lang.String r0 = com.tencent.mm.plugin.appbrand.ac.d.convertStreamToString(r0)     // Catch:{ Throwable -> 0x001e, all -> 0x0043 }
            r4.close()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x001d:
            return r0
        L_0x001e:
            r0 = move-exception
            r2 = 196151(0x2fe37, float:2.74866E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0026 }
            throw r0     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r2 = move-exception
            r3 = r0
        L_0x0028:
            if (r3 == 0) goto L_0x003f
            r4.close()     // Catch:{ Throwable -> 0x003a }
        L_0x002d:
            r0 = 196151(0x2fe37, float:2.74866E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)
            throw r2
        L_0x0034:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            r0 = r1
            goto L_0x001d
        L_0x003a:
            r0 = move-exception
            r3.addSuppressed(r0)
            goto L_0x002d
        L_0x003f:
            r4.close()
            goto L_0x002d
        L_0x0043:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.WxaPkg.ct(java.lang.String, java.lang.String):java.lang.String");
    }

    public WxaPkg(o oVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(175554);
        this.kMH = null;
        this.kKk = true;
        this.kKq = null;
        this.mFile = oVar;
        if (this.mFile == null || !this.mFile.exists()) {
            z = false;
        } else {
            z = this.mFile.length() > 14;
        }
        this.kKk = (!z || !bwk()) ? false : z2;
        AppMethodBeat.o(175554);
    }

    public WxaPkg(String str) {
        this(new o(str));
        AppMethodBeat.i(134276);
        AppMethodBeat.o(134276);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(134277);
        try {
            close();
            if (this.kMJ != null) {
                this.kMJ.close();
            }
        } finally {
            super.finalize();
            AppMethodBeat.o(134277);
        }
    }

    public final FileStructStat bwg() {
        AppMethodBeat.i(134278);
        FileStructStat fileStructStat = this.kMI;
        if (fileStructStat == null) {
            fileStructStat = new FileStructStat();
            FileStat.b(aa.z(this.mFile.her()), fileStructStat);
            this.kMI = fileStructStat;
        }
        AppMethodBeat.o(134278);
        return fileStructStat;
    }

    public final String bwh() {
        AppMethodBeat.i(259078);
        String z = aa.z(this.mFile.her());
        AppMethodBeat.o(259078);
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(134279);
        if (this.kMH != null) {
            try {
                this.kMH.close();
                this.kMH = null;
            } catch (IOException e2) {
            }
        }
        if (this.kMG != null) {
            try {
                this.kMG.close();
                this.kMG = null;
                AppMethodBeat.o(134279);
                return;
            } catch (IOException e3) {
            }
        }
        AppMethodBeat.o(134279);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.p
    public final int version() {
        AppMethodBeat.i(182984);
        if (this.kMJ == null) {
            AppMethodBeat.o(182984);
            return -1;
        }
        int version = this.kMJ.getVersion();
        AppMethodBeat.o(182984);
        return version;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.p
    public final Info openReadPartialInfo(String str) {
        int i2 = 0;
        AppMethodBeat.i(134280);
        if (this.kKq == null || Util.isNullOrNil(str)) {
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.kKq == null);
            if (this.kKq != null) {
                i2 = this.kKq.size();
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = str;
            Log.e("MicroMsg.AppBrandWxaPkg", "handleInterruptReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s", objArr);
            AppMethodBeat.o(134280);
            return null;
        }
        Info info = this.kKq.get(str);
        if (info == null) {
            info = this.kKq.get(n.We(str));
        }
        AppMethodBeat.o(134280);
        return info;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.p
    public final InputStream UR(String str) {
        AppMethodBeat.i(134281);
        Info openReadPartialInfo = openReadPartialInfo(str);
        if (this.kMJ == null || !this.kMJ.b(openReadPartialInfo)) {
            if (openReadPartialInfo == null) {
                Log.w("MicroMsg.AppBrandWxaPkg", "can't find info of file: %s", str);
                AppMethodBeat.o(134281);
                return null;
            } else if (Thread.currentThread().isInterrupted()) {
                InputStream a2 = a(openReadPartialInfo);
                AppMethodBeat.o(134281);
                return a2;
            } else {
                try {
                    MappedByteBuffer map = this.kMH.map(FileChannel.MapMode.READ_ONLY, (long) openReadPartialInfo.kKJ, (long) openReadPartialInfo.kKK);
                    map.order(kMF);
                    map.limit(openReadPartialInfo.kKK);
                    com.tencent.luggage.h.a aVar = new com.tencent.luggage.h.a(map);
                    AppMethodBeat.o(134281);
                    return aVar;
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandWxaPkg", "handleOpenReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", str, Integer.valueOf(openReadPartialInfo.kKJ), Integer.valueOf(openReadPartialInfo.kKK), Util.stackTraceToString(e2));
                    AppMethodBeat.o(134281);
                    return null;
                }
            }
        } else if (openReadPartialInfo != null) {
            a aVar2 = this.kMJ;
            AppMethodBeat.o(134281);
            return null;
        } else {
            Log.w("MicroMsg.AppBrandWxaPkg", "can't find info of file: %s", str);
            AppMethodBeat.o(134281);
            return null;
        }
    }

    private InputStream a(Info info) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        Exception e2;
        AppMethodBeat.i(134282);
        try {
            randomAccessFile = s.dB(aa.z(this.mFile.mUri), false);
            try {
                byte[] bArr = new byte[info.kKK];
                randomAccessFile.seek((long) info.kKJ);
                randomAccessFile.readFully(bArr);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                Util.qualityClose(randomAccessFile);
                AppMethodBeat.o(134282);
                return byteArrayInputStream;
            } catch (Exception e3) {
                e2 = e3;
                try {
                    Log.e("MicroMsg.AppBrandWxaPkg", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", aa.z(this.mFile.mUri), info.fileName, e2);
                    Util.qualityClose(randomAccessFile);
                    AppMethodBeat.o(134282);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(randomAccessFile);
                    AppMethodBeat.o(134282);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            randomAccessFile = null;
            Log.e("MicroMsg.AppBrandWxaPkg", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", aa.z(this.mFile.mUri), info.fileName, e2);
            Util.qualityClose(randomAccessFile);
            AppMethodBeat.o(134282);
            return null;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            Util.qualityClose(randomAccessFile);
            AppMethodBeat.o(134282);
            throw th;
        }
    }

    public final List<Info> bwi() {
        AppMethodBeat.i(134284);
        if (!bvf()) {
            Log.e("MicroMsg.AppBrandWxaPkg", "listInfos readInfo returns false");
        }
        if (this.kKq == null) {
            List<Info> emptyList = Collections.emptyList();
            AppMethodBeat.o(134284);
            return emptyList;
        }
        LinkedList linkedList = new LinkedList(this.kKq.values());
        AppMethodBeat.o(134284);
        return linkedList;
    }

    public final List<String> bwj() {
        AppMethodBeat.i(196153);
        LinkedList linkedList = new LinkedList(this.kKq.keySet());
        AppMethodBeat.o(196153);
        return linkedList;
    }

    private int bwl() {
        AppMethodBeat.i(175555);
        int i2 = -1;
        try {
            this.kMH.position(1L);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(kMF);
            this.kMH.read(allocate);
            i2 = WxaPkgBaseImpl.A(allocate.array(), 0, 4);
        } catch (IOException e2) {
            Log.e("MicroMsg.AppBrandWxaPkg", "getVersionFromHead, exp = %s", Util.stackTraceToString(e2));
        }
        AppMethodBeat.o(175555);
        return i2;
    }

    public static class Info implements Parcelable {
        public static final Parcelable.Creator<Info> CREATOR = new Parcelable.Creator<Info>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Info[] newArray(int i2) {
                return new Info[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Info createFromParcel(Parcel parcel) {
                AppMethodBeat.i(182978);
                Info info = new Info(parcel);
                AppMethodBeat.o(182978);
                return info;
            }
        };
        public final String fileName;
        public final int kKJ;
        public final int kKK;
        public final String kMK;

        public Info(String str, String str2, int i2, int i3) {
            this.kMK = str;
            this.fileName = str2;
            this.kKJ = i2;
            this.kKK = i3;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(182979);
            parcel.writeString(this.kMK);
            parcel.writeString(this.fileName);
            parcel.writeInt(this.kKJ);
            parcel.writeInt(this.kKK);
            AppMethodBeat.o(182979);
        }

        protected Info(Parcel parcel) {
            AppMethodBeat.i(182980);
            this.kMK = parcel.readString();
            this.fileName = parcel.readString();
            this.kKJ = parcel.readInt();
            this.kKK = parcel.readInt();
            AppMethodBeat.o(182980);
        }

        static {
            AppMethodBeat.i(182981);
            AppMethodBeat.o(182981);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.p
    public final boolean bvf() {
        AppMethodBeat.i(134283);
        if (!this.kKk || this.kMH == null || this.kMJ == null || this.kMJ.bwF() <= 4) {
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.kKk);
            objArr[1] = this.kMH;
            objArr[2] = Integer.valueOf(this.kMJ == null ? -1 : this.kMJ.bwF());
            Log.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", objArr);
            AppMethodBeat.o(134283);
            return false;
        } else if (this.kKq == null || this.kMJ.bwG() < 0 || this.kMJ.bwG() != this.kKq.size()) {
            try {
                this.kKq = this.kMJ.a(this.kMH, this.mFile);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", Util.stackTraceToString(e2));
            }
            if (this.kKq != null) {
                AppMethodBeat.o(134283);
                return true;
            }
            AppMethodBeat.o(134283);
            return false;
        } else {
            AppMethodBeat.o(134283);
            return true;
        }
    }

    private boolean bwk() {
        AppMethodBeat.i(134285);
        if (this.kMH == null) {
            try {
                RandomAccessFile dB = s.dB(aa.z(this.mFile.mUri), false);
                this.kMG = dB;
                this.kMH = dB.getChannel();
            } catch (FileNotFoundException e2) {
                Log.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", Util.stackTraceToString(e2));
            }
        }
        if (this.kMH == null) {
            AppMethodBeat.o(134285);
            return false;
        }
        int bwl = bwl();
        if (bwl < 0) {
            Log.e("MicroMsg.AppBrandWxaPkg", "parseHeader, version is %d", Integer.valueOf(bwl));
            AppMethodBeat.o(134285);
            return false;
        }
        Log.i("MicroMsg.AppBrandWxaPkg", "wxapkg version: %d", Integer.valueOf(bwl));
        a aVar = null;
        switch (bwl) {
            case 0:
                aVar = new b();
                break;
            case 1:
                aVar = new WxaPkgMixedImpl();
                break;
        }
        this.kMJ = aVar;
        if (this.kMJ == null) {
            Log.e("MicroMsg.AppBrandWxaPkg", "parseHeader, mIWxaPkgAction is null");
            AppMethodBeat.o(134285);
            return false;
        }
        try {
            boolean a2 = this.kMJ.a(this.kMH);
            AppMethodBeat.o(134285);
            return a2;
        } catch (IOException e3) {
            Log.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", Util.stackTraceToString(e3));
            AppMethodBeat.o(134285);
            return true;
        }
    }
}
