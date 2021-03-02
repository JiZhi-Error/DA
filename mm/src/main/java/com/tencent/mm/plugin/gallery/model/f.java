package com.tencent.mm.plugin.gallery.model;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

public final class f {
    private int xit = 5;
    private o xiu;
    private SparseArray<RandomAccessFile> xiv;
    private SparseArray<cdc> xiw;
    int xix;

    f() {
        o oVar;
        AppMethodBeat.i(111278);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext());
        if (defaultSharedPreferences.getInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 0) == 0) {
            defaultSharedPreferences.edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 1).apply();
            String dRa = dRa();
            Log.i("MicroMsg.DiskCache", dRa);
            s.dy(dRa, true);
        }
        long j2 = 0;
        try {
            StatFs statFs = new StatFs(b.aKD());
            j2 = statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        } catch (Exception e2) {
        }
        int i2 = (int) (((((float) j2) / 1024.0f) / 1024.0f) / 1024.0f);
        Log.d("MicroMsg.DiskCache", "adjustCacheFileNum: %s gb: %s.", Long.valueOf(j2), Integer.valueOf(i2));
        if (i2 < 64) {
            this.xit = 5;
        } else if (i2 < 128) {
            this.xit = 10;
        } else if (i2 < 256) {
            this.xit = 20;
        } else {
            this.xit = 25;
        }
        int i3 = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).getInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", 0);
        if (i3 == 0 || i3 != this.xit) {
            String dRb = dRb();
            if (dRb != null) {
                Log.i("MicroMsg.DiskCache", "cache path: %s.", dRb);
                s.dy(dRb, true);
            } else {
                Log.e("MicroMsg.DiskCache", "wtf!!! shared storage is not currently available.");
            }
        }
        PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", this.xit).apply();
        String dRb2 = dRb();
        if (dRb2 == null) {
            Log.i("MicroMsg.DiskCache", "wtf!!! use old dir!!!");
            dRb2 = dRa();
        }
        if (!Util.isNullOrNil(dRb2)) {
            oVar = new o(dRb2);
        } else {
            oVar = null;
        }
        if (oVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("save dir is null");
            AppMethodBeat.o(111278);
            throw illegalArgumentException;
        }
        if (!oVar.isDirectory()) {
            Log.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", aa.z(oVar.her()), Boolean.valueOf(oVar.mkdirs()));
        }
        this.xiu = oVar;
        this.xiw = new SparseArray<>();
        AppMethodBeat.o(111278);
    }

    /* access modifiers changed from: package-private */
    public final void dQU() {
        AppMethodBeat.i(111279);
        o oVar = new o(this.xiu, "cache.idx");
        cdb cdb = new cdb();
        String z = aa.z(oVar.her());
        Log.d("MicroMsg.DiskCache", "pennqin debug disk cache path: %s.", z);
        if (!Util.isNullOrNil(z)) {
            try {
                byte[] readFromFile = Util.readFromFile(z);
                if (readFromFile != null) {
                    cdb.parseFrom(readFromFile);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.DiskCache", "load index file error");
                Log.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                NC(-1);
                cdb = new cdb();
            } catch (OutOfMemoryError e3) {
                Log.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", Long.valueOf(oVar.length()));
                Log.printErrStackTrace("MicroMsg.DiskCache", e3, "", new Object[0]);
                NC(-1);
                cdb = new cdb();
            }
        }
        this.xiw.clear();
        Iterator<cdc> it = cdb.MiR.iterator();
        while (it.hasNext()) {
            cdc next = it.next();
            this.xiw.put(next.key, next);
        }
        AppMethodBeat.o(111279);
    }

    /* access modifiers changed from: package-private */
    public final void NB(int i2) {
        AppMethodBeat.i(111280);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Boolean.valueOf(this.xiv == null);
        Log.d("MicroMsg.DiskCache", "pennqin debug disk cache fileSuffix: %s, mDataFileMap == null? [%s].", objArr);
        try {
            if (this.xiv == null) {
                this.xiv = new SparseArray<>();
                for (int i3 = 0; i3 < this.xit; i3++) {
                    this.xiv.put(i3, s.dB(this.xiu + FilePathGenerator.ANDROID_DIR_SEP + NF(i3), true));
                }
                AppMethodBeat.o(111280);
            } else if (i2 < 0) {
                dQW();
                for (int i4 = 0; i4 < this.xit; i4++) {
                    this.xiv.put(i4, s.dB(this.xiu + FilePathGenerator.ANDROID_DIR_SEP + NF(i4), true));
                }
                AppMethodBeat.o(111280);
            } else {
                RandomAccessFile dB = s.dB(this.xiu + FilePathGenerator.ANDROID_DIR_SEP + NF(i2), true);
                close(this.xiv.get(i2));
                this.xiv.put(i2, dB);
                AppMethodBeat.o(111280);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.DiskCache", "load data file error: %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
            this.xiv = null;
            AppMethodBeat.o(111280);
        }
    }

    private void NC(int i2) {
        AppMethodBeat.i(111281);
        Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex: %s.", Integer.valueOf(i2));
        if (this.xiv == null || this.xiv.size() <= 0) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.xiv == null);
            Log.w("MicroMsg.DiskCache", "file map is invalid, is null? [%s]", objArr);
            AppMethodBeat.o(111281);
            return;
        }
        if (i2 < 0) {
            Log.d("MicroMsg.DiskCache", "pennqin debug disk cache delete res: %s.", Boolean.valueOf(new o(this.xiu, "cache.idx").delete()));
            this.xiw.clear();
        } else {
            SparseArray<cdc> sparseArray = new SparseArray<>();
            for (int i3 = 0; i3 < this.xiw.size(); i3++) {
                cdc valueAt = this.xiw.valueAt(i3);
                if (valueAt.MiT != i2) {
                    sparseArray.put(this.xiw.keyAt(i3), valueAt);
                }
                Log.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", Integer.valueOf(valueAt.key), Long.valueOf(valueAt.MiS), Integer.valueOf(valueAt.length));
            }
            this.xiw = sparseArray;
            dQV();
        }
        if (i2 < 0) {
            dQW();
            dQX();
            AppMethodBeat.o(111281);
            return;
        }
        close(this.xiv.get(i2));
        Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", Boolean.valueOf(new o(this.xiu, NF(i2)).delete()));
        AppMethodBeat.o(111281);
    }

    private void ND(int i2) {
        AppMethodBeat.i(111282);
        Log.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", Integer.valueOf(i2));
        NC(i2);
        NB(i2);
        AppMethodBeat.o(111282);
    }

    private static void close(Closeable closeable) {
        AppMethodBeat.i(111283);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(111283);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.DiskCache", "want close %s fail: %s", closeable.getClass().getName(), e2.getMessage());
                Log.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(111283);
    }

    /* access modifiers changed from: package-private */
    public final void dQV() {
        cdc cdc;
        AppMethodBeat.i(111284);
        cdb cdb = new cdb();
        for (int i2 = 0; i2 < this.xiw.size(); i2++) {
            try {
                cdc = this.xiw.valueAt(i2);
            } catch (ClassCastException e2) {
                Log.printErrStackTrace("MicroMsg.DiskCache", e2, "saveIndex ClassCastException.", new Object[0]);
                cdc = null;
            }
            if (cdc != null) {
                cdb.MiR.add(cdc);
                Log.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", Integer.valueOf(cdc.key), Long.valueOf(cdc.MiS), Integer.valueOf(cdc.length), Integer.valueOf(cdc.MiT));
            }
        }
        try {
            Util.writeToFile(aa.z(new o(this.xiu, "cache.idx").her()), cdb.toByteArray());
            AppMethodBeat.o(111284);
        } catch (Exception e3) {
            Log.e("MicroMsg.DiskCache", "save index data error: %s", e3.getMessage());
            Log.printErrStackTrace("MicroMsg.DiskCache", e3, "", new Object[0]);
            AppMethodBeat.o(111284);
        }
    }

    /* access modifiers changed from: package-private */
    public final void dQW() {
        AppMethodBeat.i(111285);
        if (this.xiv == null || this.xiv.size() <= 0) {
            AppMethodBeat.o(111285);
            return;
        }
        for (int i2 = 0; i2 < this.xiv.size(); i2++) {
            close(this.xiv.valueAt(i2));
        }
        this.xiv.clear();
        AppMethodBeat.o(111285);
    }

    private void dQX() {
        AppMethodBeat.i(111286);
        Log.d("MicroMsg.DiskCache", "pennqin debug disk cache !!!delete all cache file!!!");
        for (int i2 = 0; i2 < this.xit; i2++) {
            Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", Boolean.valueOf(new o(this.xiu, NF(this.xit)).delete()));
        }
        AppMethodBeat.o(111286);
    }

    public final void a(int i2, Bitmap bitmap) {
        cdc cdc;
        boolean z = true;
        AppMethodBeat.i(111287);
        if (this.xiv == null || this.xiv.size() <= 0) {
            Object[] objArr = new Object[1];
            if (this.xiv != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.e("MicroMsg.DiskCache", "want to put bitmap, but data file is invalid, is null?[%s]", objArr);
            AppMethodBeat.o(111287);
        } else if (bitmap == null || bitmap.isRecycled()) {
            Object[] objArr2 = new Object[1];
            if (bitmap != null) {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            Log.e("MicroMsg.DiskCache", "put bmp, value error, bmp is null? [%s]", objArr2);
            AppMethodBeat.o(111287);
        } else {
            Log.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", Integer.valueOf(i2), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            int dQY = dQY();
            if (dQY < 0) {
                Log.e("MicroMsg.DiskCache", "impossible!!! put bmp, file suffix < 0");
                AppMethodBeat.o(111287);
                return;
            }
            cdc cdc2 = this.xiw.get(i2);
            if (cdc2 == null) {
                cdc cdc3 = new cdc();
                cdc3.key = i2;
                cdc = cdc3;
            } else {
                cdc = cdc2;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                long currentTimeMillis = System.currentTimeMillis();
                RandomAccessFile randomAccessFile = this.xiv.get(dQY);
                cdc.MiS = randomAccessFile.length();
                cdc.MiT = dQY;
                cdc.length = byteArrayOutputStream.size();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                randomAccessFile.seek(cdc.MiS);
                randomAccessFile.write(byteArray);
                this.xix = dQY;
                Log.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(cdc.key), Long.valueOf(cdc.MiS), Integer.valueOf(cdc.length), Integer.valueOf(cdc.MiT));
                this.xiw.put(i2, cdc);
            } catch (Throwable th) {
                Log.e("MicroMsg.DiskCache", "error:%s", th.getMessage());
                Log.printErrStackTrace("MicroMsg.DiskCache", th, "", new Object[0]);
            } finally {
                close(byteArrayOutputStream);
                AppMethodBeat.o(111287);
            }
        }
    }

    public final Bitmap NE(int i2) {
        AppMethodBeat.i(111288);
        if (this.xiv == null || this.xiv.size() <= 0) {
            Log.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
            AppMethodBeat.o(111288);
            return null;
        }
        cdc cdc = this.xiw.get(i2);
        if (cdc != null) {
            try {
                byte[] bArr = new byte[cdc.length];
                Log.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", Long.valueOf(cdc.MiS), Integer.valueOf(cdc.length));
                RandomAccessFile randomAccessFile = this.xiv.get(cdc.MiT);
                randomAccessFile.seek(cdc.MiS);
                randomAccessFile.read(bArr, 0, cdc.length);
                Bitmap decodeByteArray = BitmapUtil.decodeByteArray(bArr);
                if (decodeByteArray != null) {
                    Log.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(decodeByteArray.getHeight()));
                } else {
                    this.xiw.remove(i2);
                }
                AppMethodBeat.o(111288);
                return decodeByteArray;
            } catch (Throwable th) {
                Log.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", Integer.valueOf(i2), th.getMessage());
                Log.printErrStackTrace("MicroMsg.DiskCache", th, "", new Object[0]);
                this.xiw.remove(i2);
                AppMethodBeat.o(111288);
                return null;
            }
        } else {
            Log.w("MicroMsg.DiskCache", "oh!!! indexNode is null!!!");
            AppMethodBeat.o(111288);
            return null;
        }
    }

    private static String NF(int i2) {
        AppMethodBeat.i(111289);
        String str = "cache.data" + (i2 == 0 ? "" : String.valueOf(i2));
        AppMethodBeat.o(111289);
        return str;
    }

    private int dQY() {
        int i2 = 0;
        AppMethodBeat.i(111290);
        if (this.xiv == null || this.xiv.size() <= 0) {
            Log.d("MicroMsg.DiskCache", "checkDataSize, cache file invalid.");
            AppMethodBeat.o(111290);
            return -1;
        }
        int dQZ = dQZ();
        if (dQZ < 0) {
            Log.d("MicroMsg.DiskCache", "jacks checkDataSize currentSuffix: %d", Integer.valueOf(this.xix));
            if (this.xix + 1 < this.xit) {
                i2 = this.xix + 1;
            }
            ND(i2);
        } else {
            i2 = dQZ;
        }
        AppMethodBeat.o(111290);
        return i2;
    }

    private int dQZ() {
        AppMethodBeat.i(111291);
        if (this.xiv == null || this.xiv.size() <= 0) {
            AppMethodBeat.o(111291);
            return -1;
        }
        for (int i2 = 0; i2 < this.xiv.size(); i2++) {
            try {
                RandomAccessFile valueAt = this.xiv.valueAt(i2);
                Log.d("MicroMsg.DiskCache", "pennqin debug disk cache r.length[%s] MAX_CACHE_FILE_SIZE[%s]", Long.valueOf(valueAt.length()), 52428800);
                if (valueAt.length() < 52428800) {
                    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache getUsedSuffix, %s.", Integer.valueOf(i2));
                    AppMethodBeat.o(111291);
                    return i2;
                }
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(111291);
        return -1;
    }

    private static String dRa() {
        AppMethodBeat.i(111292);
        String str = b.aKJ() + "diskcache";
        AppMethodBeat.o(111292);
        return str;
    }

    private static String dRb() {
        AppMethodBeat.i(111293);
        try {
            String str = aa.z(o.X(MMApplicationContext.getContext().getExternalCacheDir()).her()) + "/imgcache";
            AppMethodBeat.o(111293);
            return str;
        } catch (Exception e2) {
            AppMethodBeat.o(111293);
            return null;
        }
    }
}
