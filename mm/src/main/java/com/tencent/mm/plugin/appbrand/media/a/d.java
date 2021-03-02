package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.vfs.o;
import java.io.InputStream;

public final class d implements e {
    private long currentPosition;
    private String filePath;
    public a ncP = null;
    private String pkgPath;

    public d(String str, String str2) {
        AppMethodBeat.i(145785);
        this.filePath = str;
        this.pkgPath = str2;
        this.ncP = eq(str, str2);
        AppMethodBeat.o(145785);
    }

    @Override // com.tencent.mm.ai.e
    public final boolean isOpen() {
        return this.ncP != null;
    }

    @Override // com.tencent.mm.ai.e
    public final void open() {
        AppMethodBeat.i(145786);
        Log.i("MicroMsg.WxaAudioDataSource", WeChatBrands.Business.GROUP_OPEN);
        if (this.ncP == null) {
            this.ncP = eq(this.filePath, this.pkgPath);
        }
        this.currentPosition = 0;
        if (this.ncP != null) {
            this.ncP.seek(0);
        }
        AppMethodBeat.o(145786);
    }

    private static a eq(String str, String str2) {
        AppMethodBeat.i(145787);
        long nanoTime = System.nanoTime();
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
            AppMethodBeat.o(145787);
            return null;
        }
        WxaPkg wxaPkg = new WxaPkg(new o(str2));
        if (!wxaPkg.kKk) {
            wxaPkg.close();
            Log.e("MicroMsg.WxaAudioDataSource", "pkg invalid");
            AppMethodBeat.o(145787);
            return null;
        } else if (!wxaPkg.bvf()) {
            wxaPkg.close();
            Log.e("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
            AppMethodBeat.o(145787);
            return null;
        } else {
            InputStream UR = wxaPkg.UR(str);
            if (UR == null) {
                wxaPkg.close();
                Log.e("MicroMsg.WxaAudioDataSource", "inputstream for %s is null", str);
                AppMethodBeat.o(145787);
                return null;
            }
            wxaPkg.close();
            Log.d("MicroMsg.WxaAudioDataSource", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
            a aVar = (a) UR;
            AppMethodBeat.o(145787);
            return aVar;
        }
    }

    @Override // com.tencent.mm.ai.e
    public final int readAt(long j2, byte[] bArr, int i2, int i3) {
        int i4 = -1;
        AppMethodBeat.i(145788);
        if (this.ncP == null) {
            Log.e("MicroMsg.WxaAudioDataSource", "[readAt]inputstream is null");
            AppMethodBeat.o(145788);
        } else if (bArr == null || bArr.length <= 0) {
            Log.e("MicroMsg.WxaAudioDataSource", "[readAt]bytes is null");
            AppMethodBeat.o(145788);
        } else if (j2 < 0 || i2 < 0 || i3 <= 0) {
            Log.e("MicroMsg.WxaAudioDataSource", "position:%d, offset:%d, size:%d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(145788);
        } else if (bArr == null || i2 + i3 <= bArr.length) {
            if (((long) i3) + j2 > getSize()) {
                Log.e("MicroMsg.WxaAudioDataSource", "position:%d, size:%d, getSize():%d", Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(getSize()));
            }
            if (this.currentPosition != j2) {
                this.ncP.seek((int) j2);
                this.currentPosition = j2;
            }
            i4 = this.ncP.read(bArr, i2, i3);
            if (i4 >= 0) {
                this.currentPosition += (long) i4;
            }
            AppMethodBeat.o(145788);
        } else {
            Log.e("MicroMsg.WxaAudioDataSource", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length));
            AppMethodBeat.o(145788);
        }
        return i4;
    }

    @Override // com.tencent.mm.ai.e
    public final long getSize() {
        AppMethodBeat.i(145789);
        if (this.ncP == null) {
            Log.e("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
            AppMethodBeat.o(145789);
            return 0;
        }
        long length = this.ncP.getLength();
        AppMethodBeat.o(145789);
        return length;
    }

    @Override // com.tencent.mm.ai.e
    public final int aYm() {
        String str;
        AppMethodBeat.i(145790);
        if (this.ncP == null) {
            this.ncP = eq(this.filePath, this.pkgPath);
        }
        if (this.ncP == null) {
            Log.e("MicroMsg.WxaAudioDataSource", "[getAudioType] inputStream is null");
            AppMethodBeat.o(145790);
            return 0;
        } else if (this.filePath.toLowerCase().endsWith(".mp3")) {
            Log.d("MicroMsg.WxaAudioDataSource", "[getAudioType] mp3");
            AppMethodBeat.o(145790);
            return 2;
        } else if (this.filePath.toLowerCase().contains(".wav")) {
            Log.d("MicroMsg.WxaAudioDataSource", "[getAudioType] wav");
            AppMethodBeat.o(145790);
            return 3;
        } else if (this.filePath.toLowerCase().contains(".ogg")) {
            Log.d("MicroMsg.WxaAudioDataSource", "[getAudioType] ogg");
            AppMethodBeat.o(145790);
            return 4;
        } else {
            try {
                byte[] bArr = new byte[64];
                this.ncP.seek(0);
                this.ncP.read(bArr);
                str = new String(bArr);
                this.ncP.seek(0);
            } catch (Exception e2) {
                Log.e("MicroMsg.WxaAudioDataSource", "getAudioType", e2);
                this.ncP.seek(0);
                str = null;
            } catch (Throwable th) {
                this.ncP.seek(0);
                AppMethodBeat.o(145790);
                throw th;
            }
            if (str == null || !str.contains("ftyp")) {
                AppMethodBeat.o(145790);
                return 0;
            }
            Log.d("MicroMsg.WxaAudioDataSource", "[getAudioType] aac");
            AppMethodBeat.o(145790);
            return 1;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(145791);
        a aVar = this.ncP;
        if (aVar != null) {
            Log.i("MicroMsg.WxaAudioDataSource", "close");
            aVar.close();
            this.ncP = null;
        }
        AppMethodBeat.o(145791);
    }
}
