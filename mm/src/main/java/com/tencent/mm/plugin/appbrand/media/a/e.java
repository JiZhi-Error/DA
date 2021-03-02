package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.RandomAccessFile;

public final class e implements com.tencent.mm.ai.e {
    private static LruCache<String, Integer> ncQ = new LruCache<>(50);
    private static LruCache<String, Integer> ncR = new LruCache<>(50);
    private static LruCache<String, Integer> ncS = new LruCache<>(50);
    private long currentPosition;
    private String filePath;
    private int kKJ = -1;
    private int ncT = -1;
    private String pkgPath;
    public RandomAccessFile randomAccessFile;

    static {
        AppMethodBeat.i(145799);
        AppMethodBeat.o(145799);
    }

    public e(String str, String str2) {
        AppMethodBeat.i(145792);
        this.filePath = str;
        this.pkgPath = str2;
        this.randomAccessFile = er(str, str2);
        if (ncQ.check(str) && ncR.check(str)) {
            this.ncT = ncQ.get(str).intValue();
            this.kKJ = ncR.get(str).intValue();
            AppMethodBeat.o(145792);
        } else if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
            AppMethodBeat.o(145792);
        } else {
            WxaPkg wxaPkg = new WxaPkg(str2);
            if (!wxaPkg.kKk) {
                wxaPkg.close();
                Log.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
                AppMethodBeat.o(145792);
            } else if (!wxaPkg.bvf()) {
                wxaPkg.close();
                Log.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
                AppMethodBeat.o(145792);
            } else {
                WxaPkg.Info openReadPartialInfo = wxaPkg.openReadPartialInfo(str);
                if (openReadPartialInfo == null) {
                    wxaPkg.close();
                    Log.e("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
                    AppMethodBeat.o(145792);
                } else if (openReadPartialInfo.kKK <= 0 || openReadPartialInfo.kKJ <= 0) {
                    wxaPkg.close();
                    Log.e("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
                    AppMethodBeat.o(145792);
                } else {
                    this.ncT = openReadPartialInfo.kKK;
                    this.kKJ = openReadPartialInfo.kKJ;
                    ncQ.put(str, Integer.valueOf(this.ncT));
                    ncR.put(str, Integer.valueOf(this.kKJ));
                    wxaPkg.close();
                    AppMethodBeat.o(145792);
                }
            }
        }
    }

    @Override // com.tencent.mm.ai.e
    public final boolean isOpen() {
        return this.randomAccessFile != null || this.ncT == -1 || this.kKJ == -1;
    }

    @Override // com.tencent.mm.ai.e
    public final void open() {
        AppMethodBeat.i(145793);
        Log.i("MicroMsg.WxaAudioDataSourceBelow19", "open %d", Integer.valueOf(hashCode()));
        if (this.randomAccessFile == null) {
            this.randomAccessFile = er(this.filePath, this.pkgPath);
        }
        this.currentPosition = 0;
        if (this.randomAccessFile != null) {
            this.randomAccessFile.seek((long) this.kKJ);
        }
        AppMethodBeat.o(145793);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007b, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", r1, "", new java.lang.Object[0]);
        com.tencent.matrix.trace.core.AppMethodBeat.o(145794);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x008b, code lost:
        r2 = r1;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007a A[ExcHandler: FileNotFoundException (r1v5 'e' java.io.FileNotFoundException A[CUSTOM_DECLARE]), Splitter:B:4:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009a A[SYNTHETIC, Splitter:B:19:0x009a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.RandomAccessFile er(java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.media.a.e.er(java.lang.String, java.lang.String):java.io.RandomAccessFile");
    }

    @Override // com.tencent.mm.ai.e
    public final int readAt(long j2, byte[] bArr, int i2, int i3) {
        int i4 = -1;
        AppMethodBeat.i(145795);
        if (this.randomAccessFile == null) {
            Log.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
            AppMethodBeat.o(145795);
        } else {
            if (this.currentPosition != j2) {
                this.randomAccessFile.seek(((long) this.kKJ) + j2);
                this.currentPosition = j2;
            }
            if (bArr == null || bArr.length <= 0) {
                Log.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
                AppMethodBeat.o(145795);
            } else if (j2 < 0 || i2 < 0 || i3 <= 0) {
                Log.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3));
                AppMethodBeat.o(145795);
            } else if (bArr != null && i2 + i3 > bArr.length) {
                Log.e("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length));
                AppMethodBeat.o(145795);
            } else if (j2 >= ((long) this.ncT)) {
                Log.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", Long.valueOf(j2), Integer.valueOf(this.ncT));
                AppMethodBeat.o(145795);
            } else {
                if (((long) i3) + j2 >= ((long) this.ncT)) {
                    Log.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(this.ncT));
                    i3 = (int) (((long) this.ncT) - j2);
                }
                i4 = this.randomAccessFile.read(bArr, i2, i3);
                if (i4 >= 0) {
                    this.currentPosition += (long) i4;
                } else {
                    Log.e("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", Integer.valueOf(i4));
                }
                AppMethodBeat.o(145795);
            }
        }
        return i4;
    }

    @Override // com.tencent.mm.ai.e
    public final long getSize() {
        AppMethodBeat.i(145796);
        if (this.randomAccessFile == null) {
            Log.e("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
            AppMethodBeat.o(145796);
            return 0;
        }
        long j2 = (long) this.ncT;
        AppMethodBeat.o(145796);
        return j2;
    }

    @Override // com.tencent.mm.ai.e
    public final int aYm() {
        String str;
        AppMethodBeat.i(145797);
        if (this.randomAccessFile == null) {
            this.randomAccessFile = er(this.filePath, this.pkgPath);
        }
        if (ncS.check(this.filePath)) {
            int intValue = ncS.get(this.filePath).intValue();
            AppMethodBeat.o(145797);
            return intValue;
        } else if (this.randomAccessFile == null) {
            Log.e("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] inputStream is null");
            AppMethodBeat.o(145797);
            return 0;
        } else if (this.filePath.toLowerCase().endsWith(".mp3")) {
            Log.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] mp3");
            AppMethodBeat.o(145797);
            return 2;
        } else if (this.filePath.toLowerCase().contains(".wav")) {
            Log.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] wav");
            AppMethodBeat.o(145797);
            return 3;
        } else if (this.filePath.toLowerCase().contains(".ogg")) {
            Log.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] ogg");
            AppMethodBeat.o(145797);
            return 4;
        } else {
            try {
                byte[] bArr = new byte[64];
                this.randomAccessFile.seek((long) this.kKJ);
                this.randomAccessFile.read(bArr);
                str = new String(bArr);
                this.randomAccessFile.seek((long) this.kKJ);
            } catch (Exception e2) {
                Log.e("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", e2);
                this.randomAccessFile.seek((long) this.kKJ);
                str = null;
            } catch (Throwable th) {
                this.randomAccessFile.seek((long) this.kKJ);
                AppMethodBeat.o(145797);
                throw th;
            }
            if (str == null || !str.contains("ftyp")) {
                AppMethodBeat.o(145797);
                return 0;
            }
            Log.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
            ncS.put(this.filePath, 1);
            AppMethodBeat.o(145797);
            return 1;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(145798);
        if (this.randomAccessFile != null) {
            Log.i("MicroMsg.WxaAudioDataSourceBelow19", "close %d", Integer.valueOf(hashCode()));
            this.randomAccessFile.close();
            this.randomAccessFile = null;
        }
        AppMethodBeat.o(145798);
    }
}
