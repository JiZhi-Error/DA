package com.tencent.mm.av;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.p;
import com.tencent.mm.b.f;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.ImageOptimLib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class i extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) "};
    public static int iXV = 0;
    public static int iYg = 150;
    public static long iYh = 0;
    private MMHandler hAk = new MMHandler(Looper.getMainLooper());
    public h iFy = null;
    f<String, Bitmap> iXW = new com.tencent.mm.memory.a.b(40, new f.b<String, Bitmap>() {
        /* class com.tencent.mm.av.i.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.b.f.b
        public final /* synthetic */ void c(String str, Bitmap bitmap, Bitmap bitmap2) {
            AppMethodBeat.i(150560);
            String str2 = str;
            Bitmap bitmap3 = bitmap;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                Log.i("MicroMsg.ImgInfoStorage", "[preRemoveCallback] key:%s remove bitmap without recycle! :%s size:%s", str2, bitmap3.toString(), Integer.valueOf(bitmap3.getByteCount()));
            }
            AppMethodBeat.o(150560);
        }
    }, getClass());
    private f<String, String> iXX = new com.tencent.mm.memory.a.c(40);
    private List<b> iXY = new ArrayList();
    private Map<Integer, WeakReference<ImageView>> iXZ = new HashMap();
    private Map<Integer, WeakReference<ImageView>> iYa = new HashMap();
    private Map<Integer, WeakReference<View>> iYb = new HashMap();
    private Set<Integer> iYc = new HashSet();
    private Map<String, String> iYd = new HashMap();
    private FrameLayout.LayoutParams iYe = new FrameLayout.LayoutParams(-2, -2);
    private SoftReference<ColorDrawable> iYf;

    public static String[] Ox(String str) {
        AppMethodBeat.i(223581);
        String[] strArr = {"CREATE TABLE IF NOT EXISTS " + str + " ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen" + " INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid" + " INT, status INT, nettimes INT, reserved1 int  , reserved2" + " int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete" + " INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType" + " INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS " + str + "serverImgInfoIndex ON " + str + " ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS " + str + "serverImgInfoHdIndex ON " + str + " ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS " + str + "msgLocalIdIndex ON " + str + " ( msglocalid ) ", "CREATE INDEX IF NOT EXISTS " + str + "iscomplete_index ON " + str + " ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS " + str + "origImgMD5_index ON " + str + " ( origImgMD5 ) "};
        AppMethodBeat.o(223581);
        return strArr;
    }

    public static final class c {
        String iYq;
        String[] iYr;
        long[] iYs = new long[2];
        AtomicLong iYt = new AtomicLong(0);
        String table;

        public c(String str, String str2, String[] strArr, long j2, long j3) {
            AppMethodBeat.i(223575);
            this.table = str2;
            this.iYq = str;
            this.iYr = strArr;
            this.iYs[0] = j2;
            this.iYs[1] = j3;
            this.iYt.set(j2);
            AppMethodBeat.o(223575);
        }
    }

    public static final class d {
        public static final ArrayList<c> iYu = new ArrayList<>(3);

        static {
            AppMethodBeat.i(223580);
            a("", "ImgInfo2", i.SQL_CREATE, 1, 1000000000);
            a("@findermsg", "finder_img_info_table", i.Ox("finder_img_info_table"), 1000000001, 1001000001);
            a("@gamelifesess", "gamelife_img_info_table", i.Ox("gamelife_img_info_table"), 1001000002, 1002000002);
            AppMethodBeat.o(223580);
        }

        private static void a(String str, String str2, String[] strArr, long j2, long j3) {
            AppMethodBeat.i(223576);
            iYu.add(new c(str.toLowerCase(), str2, strArr, j2, j3));
            AppMethodBeat.o(223576);
        }

        public static AtomicLong OG(String str) {
            AppMethodBeat.i(223577);
            if (str == null) {
                Log.e("MicroMsg.ImgInfoStorage", "[getIdCreator] talker is null %s", Util.getStack());
                AtomicLong atomicLong = iYu.get(0).iYt;
                AppMethodBeat.o(223577);
                return atomicLong;
            }
            Iterator<c> it = iYu.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (!next.iYq.isEmpty() && str.toLowerCase().endsWith(next.iYq)) {
                    Log.i("MicroMsg.ImgInfoStorage", "[getIdCreator] table=%s talker=%s", next.table, str);
                    AtomicLong atomicLong2 = next.iYt;
                    AppMethodBeat.o(223577);
                    return atomicLong2;
                }
            }
            Log.i("MicroMsg.ImgInfoStorage", "[getIdCreator] table=%s talker=%s", iYu.get(0).table, str);
            AtomicLong atomicLong3 = iYu.get(0).iYt;
            AppMethodBeat.o(223577);
            return atomicLong3;
        }

        public static String OH(String str) {
            AppMethodBeat.i(223578);
            if (str == null) {
                Log.e("MicroMsg.ImgInfoStorage", "[getTableByTalker] talker is null %s", Util.getStack());
                String str2 = iYu.get(0).table;
                AppMethodBeat.o(223578);
                return str2;
            }
            Iterator<c> it = iYu.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (!next.iYq.isEmpty() && str.toLowerCase().endsWith(next.iYq)) {
                    String str3 = next.table;
                    AppMethodBeat.o(223578);
                    return str3;
                }
            }
            Log.i("MicroMsg.ImgInfoStorage", "[getTableByTalker] table=%s talker=%s", iYu.get(0).table, str);
            String str4 = iYu.get(0).table;
            AppMethodBeat.o(223578);
            return str4;
        }

        public static String Ay(long j2) {
            AppMethodBeat.i(223579);
            Iterator<c> it = iYu.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.iYs[0] <= j2 && j2 <= next.iYs[1]) {
                    String str = next.table;
                    AppMethodBeat.o(223579);
                    return str;
                }
            }
            Log.i("MicroMsg.ImgInfoStorage", "[getTableById] table=%s id=%s", iYu.get(0).table, Long.valueOf(j2));
            String str2 = iYu.get(0).table;
            AppMethodBeat.o(223579);
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        int iYn;
        int iYo;
        int iYp;
        String url;

        b(int i2, String str, int i3, int i4) {
            this.iYn = i2;
            this.url = str;
            this.iYo = i3;
            this.iYp = i4;
        }
    }

    public i(h hVar) {
        AppMethodBeat.i(150566);
        Iterator<c> it = d.iYu.iterator();
        while (it.hasNext()) {
            a(hVar, it.next().table);
        }
        this.iFy = hVar;
        bcy();
        AppMethodBeat.o(150566);
    }

    public final void bcy() {
        AppMethodBeat.i(150567);
        Iterator<c> it = d.iYu.iterator();
        while (it.hasNext()) {
            c next = it.next();
            Cursor rawQuery = this.iFy.rawQuery("SELECT max(id) FROM " + next.table, null, 2);
            AtomicLong atomicLong = next.iYt;
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                synchronized (this) {
                    try {
                        if (j2 > atomicLong.get()) {
                            atomicLong.set(j2);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(150567);
                        throw th;
                    }
                }
            }
            rawQuery.close();
            Log.i("MicroMsg.ImgInfoStorage", "[updateLatestImgID] table=%s, loading new img id=%s", next.table, Long.valueOf(atomicLong.get()));
        }
        AppMethodBeat.o(150567);
    }

    public static long Oy(String str) {
        AppMethodBeat.i(223582);
        long incrementAndGet = d.OG(str).incrementAndGet();
        AppMethodBeat.o(223582);
        return incrementAndGet;
    }

    private static void a(h hVar, String str) {
        boolean z;
        AppMethodBeat.i(223583);
        Cursor rawQuery = hVar.rawQuery("PRAGMA table_info(" + str + ")", null, 2);
        int columnIndex = rawQuery.getColumnIndex("name");
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (rawQuery.moveToNext()) {
            if (columnIndex >= 0) {
                String string = rawQuery.getString(columnIndex);
                if ("hashdthumb".equals(string)) {
                    z9 = true;
                }
                if ("iscomplete".equals(string)) {
                    z8 = true;
                }
                if ("origImgMD5".equals(string)) {
                    z7 = true;
                }
                if ("compressType".equals(string)) {
                    z6 = true;
                }
                if ("midImgPath".equals(string)) {
                    z5 = true;
                }
                if ("forwardType".equals(string)) {
                    z4 = true;
                }
                if ("hevcPath".equals(string)) {
                    z = true;
                } else {
                    z = z3;
                }
                if ("sendImgType".endsWith("colName")) {
                    z2 = true;
                }
                z3 = z;
            }
        }
        rawQuery.close();
        long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
        if (!z9) {
            hVar.execSQL(str, "Alter table " + str + " add hashdthumb INT DEFAULT 0");
        }
        if (!z8) {
            hVar.execSQL(str, "Alter table " + str + " add iscomplete INT DEFAULT 1");
        }
        if (!z7) {
            hVar.execSQL(str, "Alter table " + str + " add origImgMD5 TEXT");
        }
        if (!z6) {
            hVar.execSQL(str, "Alter table " + str + " add compressType INT DEFAULT 0");
        }
        if (!z5) {
            hVar.execSQL(str, "Alter table " + str + " add midImgPath TEXT");
        }
        if (!z4) {
            hVar.execSQL(str, "Alter table " + str + " add forwardType INT DEFAULT 0");
        }
        if (!z3) {
            hVar.execSQL(str, "Alter table " + str + " add hevcPath TEXT");
        }
        if (!z2) {
            hVar.execSQL(str, "Alter table " + str + " add sendImgType INT DEFAULT 0");
        }
        if (beginTransaction > 0) {
            g.aAh().hqK.endTransaction(beginTransaction);
        }
        AppMethodBeat.o(223583);
    }

    public final String a(String str, String str2, String str3, boolean z) {
        String str4;
        String str5;
        AppMethodBeat.i(150570);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150570);
            return null;
        }
        if (str.startsWith("SERVERID://")) {
            try {
                str4 = Ax(Long.valueOf(str.substring(11)).longValue()).iXm;
            } catch (NumberFormatException e2) {
                Log.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e2.getMessage());
                AppMethodBeat.o(150570);
                return null;
            }
        } else {
            str4 = "";
        }
        if (str.startsWith("THUMBNAIL_DIRPATH://")) {
            str = str.substring(23);
            str5 = "th_";
        } else {
            str5 = str2;
        }
        String aSY = com.tencent.mm.plugin.image.d.aSY();
        String aSZ = com.tencent.mm.plugin.image.d.aSZ();
        if (Util.isNullOrNil(str4)) {
            str4 = str;
        }
        String defGenPathWithOld = FilePathGenerator.defGenPathWithOld(aSY, aSZ, str5, str4, str3, 1, z);
        AppMethodBeat.o(150570);
        return defGenPathWithOld;
    }

    public final String o(String str, String str2, String str3) {
        AppMethodBeat.i(150571);
        String a2 = a(str, str2, str3, true);
        AppMethodBeat.o(150571);
        return a2;
    }

    public final String getFullPath(String str) {
        String str2;
        AppMethodBeat.i(150572);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150572);
            return null;
        }
        if (str.startsWith("SERVERID://")) {
            try {
                str2 = Ax(Long.valueOf(str.substring(11)).longValue()).iXm;
            } catch (NumberFormatException e2) {
                Log.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e2.getMessage());
                AppMethodBeat.o(150572);
                return null;
            }
        } else {
            str2 = "";
        }
        String aSY = com.tencent.mm.plugin.image.d.aSY();
        String aSZ = com.tencent.mm.plugin.image.d.aSZ();
        if (Util.isNullOrNil(str2)) {
            str2 = str;
        }
        String defGenPathWithOld = FilePathGenerator.defGenPathWithOld(aSY, aSZ, "th_", str2, "", 1);
        AppMethodBeat.o(150572);
        return defGenPathWithOld;
    }

    public static String EX(String str) {
        AppMethodBeat.i(150573);
        String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str));
        AppMethodBeat.o(150573);
        return concat;
    }

    public final String Oz(String str) {
        AppMethodBeat.i(150574);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(150574);
            return null;
        }
        String str2 = "";
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = tl(Integer.valueOf(trim.substring(12)).intValue()).iXo;
            } catch (NumberFormatException e2) {
                Log.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e2.getMessage());
                AppMethodBeat.o(150574);
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            trim = trim.substring(23);
            str2 = "th_";
        }
        String o = o(trim, str2, "");
        AppMethodBeat.o(150574);
        return o;
    }

    public final String a(byte[] bArr, boolean z, Bitmap.CompressFormat compressFormat) {
        AppMethodBeat.i(150575);
        String a2 = a(bArr, z, compressFormat, false);
        AppMethodBeat.o(150575);
        return a2;
    }

    public final String a(byte[] bArr, Bitmap.CompressFormat compressFormat) {
        AppMethodBeat.i(150576);
        if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.o(150576);
            return null;
        }
        String bcA = bcA();
        String o = o(bcA, "th_", "");
        Log.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", o);
        try {
            BitmapUtil.saveBitmapToImage(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), 100, compressFormat, o, true);
            String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(bcA));
            AppMethodBeat.o(150576);
            return concat;
        } catch (IOException e2) {
            Log.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e2);
            String a2 = a(bArr, true, compressFormat);
            AppMethodBeat.o(150576);
            return a2;
        } catch (Exception e3) {
            Log.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e3);
            String a3 = a(bArr, true, compressFormat);
            AppMethodBeat.o(150576);
            return a3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02c2, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01ef, code lost:
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0218, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0219, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x023a, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
        com.tencent.mm.vfs.s.deleteFile(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0278, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
        com.tencent.mm.vfs.s.deleteFile(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02a7 A[SYNTHETIC, Splitter:B:100:0x02a7] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01d8 A[SYNTHETIC, Splitter:B:48:0x01d8] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0201 A[SYNTHETIC, Splitter:B:59:0x0201] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x020e A[SYNTHETIC, Splitter:B:65:0x020e] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0218 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:12:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0248 A[SYNTHETIC, Splitter:B:78:0x0248] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0286 A[SYNTHETIC, Splitter:B:91:0x0286] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0299  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(byte[] r20, android.graphics.Bitmap.CompressFormat r21, java.lang.String r22, boolean r23) {
        /*
        // Method dump skipped, instructions count: 723
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.i.a(byte[], android.graphics.Bitmap$CompressFormat, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x018c, code lost:
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b5, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b6, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d7, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
        com.tencent.mm.vfs.s.deleteFile(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01f5, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0216, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
        com.tencent.mm.vfs.s.deleteFile(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0175 A[SYNTHETIC, Splitter:B:35:0x0175] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x019e A[SYNTHETIC, Splitter:B:46:0x019e] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ab A[SYNTHETIC, Splitter:B:52:0x01ab] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01b5 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:7:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e5 A[SYNTHETIC, Splitter:B:65:0x01e5] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0224 A[SYNTHETIC, Splitter:B:77:0x0224] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0245 A[SYNTHETIC, Splitter:B:86:0x0245] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(byte[] r20, android.graphics.Bitmap.CompressFormat r21, int r22, int r23, java.lang.String r24, boolean r25) {
        /*
        // Method dump skipped, instructions count: 626
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.i.a(byte[], android.graphics.Bitmap$CompressFormat, int, int, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0104 A[SYNTHETIC, Splitter:B:34:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0126 A[SYNTHETIC, Splitter:B:43:0x0126] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(byte[] r13, boolean r14, android.graphics.Bitmap.CompressFormat r15, boolean r16) {
        /*
        // Method dump skipped, instructions count: 319
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.i.a(byte[], boolean, android.graphics.Bitmap$CompressFormat, boolean):java.lang.String");
    }

    public final String ap(byte[] bArr) {
        AppMethodBeat.i(150580);
        if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.o(150580);
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (options.outWidth < 0 || options.outHeight < 0) {
            Log.e("MicroMsg.ImgInfoStorage", "Bad thumbBuf, perhaps it's not complete or damaged ??");
            AppMethodBeat.o(150580);
            return null;
        }
        String bcA = bcA();
        String o = o(bcA, "th_", "");
        Log.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(o)));
        s.deleteFile(o);
        s.f(o, bArr, bArr.length);
        String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(bcA));
        AppMethodBeat.o(150580);
        return concat;
    }

    public final String OA(String str) {
        AppMethodBeat.i(223584);
        String R = R(str, true);
        AppMethodBeat.o(223584);
        return R;
    }

    public final String R(String str, boolean z) {
        AppMethodBeat.i(150581);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(150581);
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = tl(Integer.valueOf(trim.substring(12)).intValue()).iXo;
            } catch (NumberFormatException e2) {
                Log.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e2.getMessage());
                AppMethodBeat.o(150581);
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            String a2 = a(trim.substring(20).substring(3), "th_", "", z);
            AppMethodBeat.o(150581);
            return a2;
        }
        String a3 = a(trim, "", "", z);
        AppMethodBeat.o(150581);
        return a3;
    }

    public final Bitmap a(String str, float f2, boolean z) {
        AppMethodBeat.i(150583);
        Bitmap a2 = a(str, false, f2, z, false, false, -1);
        AppMethodBeat.o(150583);
        return a2;
    }

    public final boolean a(ImageView imageView, String str, float f2, int i2, int i3, ImageView imageView2, int i4, int i5, View view) {
        AppMethodBeat.i(150584);
        boolean a2 = a(imageView, str, false, f2, i2, i3, imageView2, i4, i5, view);
        AppMethodBeat.o(150584);
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x028d, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(150585);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0296, code lost:
        r2 = 160.0f / ((float) r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x029e, code lost:
        r3 = 120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02a2, code lost:
        r2 = 75;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02a6, code lost:
        if (r17 <= 0) goto L_0x02be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02a8, code lost:
        r3 = (int) ((((float) r17) * r16) * 1.25f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02b1, code lost:
        if (r18 <= 0) goto L_0x02c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02b3, code lost:
        r2 = (int) ((((float) r18) * r16) * 1.25f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02be, code lost:
        r17 = 120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02c1, code lost:
        r18 = 75;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02c7, code lost:
        if (r21 != 1) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02c9, code lost:
        r3.gravity = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02cf, code lost:
        if (r12.iYf == null) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02d7, code lost:
        if (r12.iYf.get() != null) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02d9, code lost:
        r12.iYf = new java.lang.ref.SoftReference<>(new android.graphics.drawable.ColorDrawable(-1118482));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02e8, code lost:
        r13.setImageDrawable((android.graphics.drawable.ColorDrawable) r12.iYf.get());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02f5, code lost:
        if (r17 <= 0) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02f7, code lost:
        r3 = (int) ((((float) r17) * r16) * 1.25f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0300, code lost:
        if (r18 <= 0) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0302, code lost:
        r2 = new android.widget.FrameLayout.LayoutParams(r3, (int) ((((float) r18) * r16) * 1.25f));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0310, code lost:
        r17 = 120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0313, code lost:
        r18 = 75;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0316, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0319, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x031c, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x031f, code lost:
        r5 = false;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00af, code lost:
        if (r6.endsWith("hd") == false) goto L_0x031f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b1, code lost:
        r10 = r12.iXW.aT(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ba, code lost:
        if (r10 != null) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00bc, code lost:
        a(r13, r19, r22, r6, r16, true, com.tencent.mm.R.drawable.c3h);
        r6 = r6.substring(0, r6.length() - 2);
        r5 = true;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d9, code lost:
        if (r2 != null) goto L_0x031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00db, code lost:
        r4 = r12.iXW.aT(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e4, code lost:
        if (r4 == null) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ea, code lost:
        if (r4.isRecycled() != false) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ec, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", java.lang.Integer.valueOf(r4.getWidth()), java.lang.Integer.valueOf(r4.getHeight()));
        r13.setBackgroundDrawable(null);
        com.tencent.mm.av.i.a.a(r4, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x011c, code lost:
        if (r13.getLayoutParams().width == -2) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x011e, code lost:
        r2 = r12.iYe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0120, code lost:
        if (r21 != 0) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0122, code lost:
        r2.gravity = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0125, code lost:
        r13.setLayoutParams(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0137, code lost:
        if (((double) r4.getWidth()) < (((double) r4.getHeight()) * 2.5d)) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0139, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0149, code lost:
        if (((double) r4.getHeight()) < (((double) r4.getWidth()) * 2.5d)) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x014b, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x014c, code lost:
        if (r2 != false) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014e, code lost:
        if (r3 == false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0150, code lost:
        r13.setScaleType(android.widget.ImageView.ScaleType.CENTER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0155, code lost:
        if (r19 == null) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0157, code lost:
        r2 = new android.widget.FrameLayout.LayoutParams(r4.getWidth(), r4.getHeight());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0164, code lost:
        if (r21 != 0) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0166, code lost:
        r2.gravity = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0169, code lost:
        r19.setLayoutParams(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x016e, code lost:
        if (r22 == null) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0170, code lost:
        r2 = new android.widget.FrameLayout.LayoutParams(r4.getWidth(), r4.getHeight());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x017d, code lost:
        if (r21 != 0) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x017f, code lost:
        r2.gravity = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0182, code lost:
        r22.setLayoutParams(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0187, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(150585);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01aa, code lost:
        if (r12.iXW.remove(r6.substring(0, r6.length() - 2)) == null) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ac, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: ".concat(java.lang.String.valueOf(r6)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01bd, code lost:
        r5 = false;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01c1, code lost:
        r2 = (android.widget.FrameLayout.LayoutParams) r13.getLayoutParams();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01cc, code lost:
        if (r21 != 1) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01ce, code lost:
        r2.gravity = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01d3, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01d6, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01dc, code lost:
        if (r21 != 1) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01de, code lost:
        r2.gravity = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e5, code lost:
        if (r21 != 1) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01e7, code lost:
        r2.gravity = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01eb, code lost:
        if (r20 <= 0) goto L_0x02cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ed, code lost:
        r13.setBackgroundResource(r20);
        r13.setImageDrawable(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01fa, code lost:
        if (r17 >= 160) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0200, code lost:
        if (r18 < 160) goto L_0x02a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0206, code lost:
        if (r18 <= r17) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0208, code lost:
        r2 = 160.0f / ((float) r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x020e, code lost:
        r3 = (int) (((float) r17) * r2);
        r2 = (int) (r2 * ((float) r18));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0218, code lost:
        if (r3 <= 0) goto L_0x029e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x021a, code lost:
        r3 = (int) (((float) r3) * r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x021e, code lost:
        if (r2 <= 0) goto L_0x02a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0220, code lost:
        r2 = (int) (((float) r2) * r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x022b, code lost:
        if (((float) r3) >= (60.0f * r16)) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x022d, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", java.lang.Integer.valueOf(r3));
        r4 = (int) (60.0f * r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x024d, code lost:
        if (((float) r2) >= (60.0f * r16)) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x024f, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", java.lang.Integer.valueOf(r2));
        r2 = (int) (60.0f * r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0267, code lost:
        r3 = new android.widget.FrameLayout.LayoutParams(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x026c, code lost:
        if (r21 != 0) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x026e, code lost:
        r3.gravity = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0271, code lost:
        if (r22 == null) goto L_0x0316;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0273, code lost:
        r22.setLayoutParams(r3);
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0279, code lost:
        r13.setLayoutParams(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x027c, code lost:
        if (r5 != false) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x027e, code lost:
        a(r13, r19, r22, r6, r16, true, com.tencent.mm.R.drawable.c3h);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.widget.ImageView r13, java.lang.String r14, boolean r15, float r16, int r17, int r18, android.widget.ImageView r19, int r20, int r21, android.view.View r22) {
        /*
        // Method dump skipped, instructions count: 803
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.i.a(android.widget.ImageView, java.lang.String, boolean, float, int, int, android.widget.ImageView, int, int, android.view.View):boolean");
    }

    private void a(ImageView imageView, ImageView imageView2, View view, String str, float f2, boolean z, int i2) {
        AppMethodBeat.i(223586);
        int hashCode = str.hashCode();
        int hashCode2 = imageView.hashCode();
        for (b bVar : this.iXY) {
            if (hashCode2 == bVar.iYn) {
                Log.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", Integer.valueOf(bVar.iYn), bVar.url);
                bVar.url = str;
                if (!this.iYc.contains(Integer.valueOf(hashCode))) {
                    this.iYc.add(Integer.valueOf(hashCode));
                    a(str, f2, true, R.drawable.c3h);
                }
                AppMethodBeat.o(223586);
                return;
            }
        }
        this.iXZ.put(Integer.valueOf(hashCode2), new WeakReference<>(imageView));
        int i3 = 0;
        if (imageView2 != null) {
            i3 = imageView2.hashCode();
            this.iYa.put(Integer.valueOf(i3), new WeakReference<>(imageView2));
        }
        int i4 = 0;
        if (view != null) {
            i4 = view.hashCode();
            this.iYb.put(Integer.valueOf(i4), new WeakReference<>(view));
        }
        this.iXY.add(new b(hashCode2, str, i3, i4));
        if (!this.iYc.contains(Integer.valueOf(hashCode))) {
            this.iYc.add(Integer.valueOf(hashCode));
            a(str, f2, true, R.drawable.c3h);
        }
        AppMethodBeat.o(223586);
    }

    private void a(final String str, final float f2, final boolean z, final int i2) {
        AppMethodBeat.i(223587);
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.av.i.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(150562);
                i.this.a(str, true, f2, true, false, z, i2);
                i.this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.av.i.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(150561);
                        i.a(i.this, str);
                        AppMethodBeat.o(150561);
                    }
                });
                AppMethodBeat.o(150562);
            }

            public final String toString() {
                AppMethodBeat.i(150563);
                String str = super.toString() + "|loadImginBackground";
                AppMethodBeat.o(150563);
                return str;
            }
        });
        AppMethodBeat.o(223587);
    }

    public final Bitmap b(String str, float f2, boolean z) {
        AppMethodBeat.i(150588);
        Bitmap a2 = a(str, true, f2, z, true, false, 0);
        AppMethodBeat.o(150588);
        return a2;
    }

    public final Bitmap a(String str, boolean z, float f2, boolean z2, boolean z3, boolean z4, int i2) {
        AppMethodBeat.i(150589);
        Bitmap a2 = a(str, z, f2, z2, z3, z4, i2, true);
        AppMethodBeat.o(150589);
        return a2;
    }

    private Bitmap a(String str, boolean z, float f2, boolean z2, boolean z3, boolean z4, int i2, boolean z5) {
        AppMethodBeat.i(150590);
        Bitmap a2 = a(str, z, f2, z2, z3, z4, i2, z5, (Bitmap) null);
        AppMethodBeat.o(150590);
        return a2;
    }

    private Bitmap a(String str, boolean z, float f2, boolean z2, boolean z3, boolean z4, int i2, boolean z5, Bitmap bitmap) {
        Bitmap bitmapNative;
        Bitmap bitmap2;
        int i3;
        int i4;
        int round;
        int i5;
        float f3;
        AppMethodBeat.i(150591);
        if (!z) {
            str = d(str, false, true);
        }
        if (str == null) {
            AppMethodBeat.o(150591);
            return null;
        }
        Bitmap bitmap3 = null;
        boolean z6 = bitmap != null && !bitmap.isRecycled();
        if (z5 && (bitmap3 = this.iXW.aT(str)) == null) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(bitmap3 == null);
            objArr[1] = str;
            Log.printDebugStack("MicroMsg.ImgInfoStorage", "bm is null:%b,  url:%s", objArr);
        }
        if (bitmap3 == null || bitmap3.isRecycled() || z6) {
            Util.nowMilliSecond();
            if (z6) {
                bitmapNative = bitmap;
            } else {
                bitmapNative = BitmapUtil.getBitmapNative(str, f2);
            }
            if (bitmapNative == null) {
                bitmapNative = u.Sq(str);
            }
            if (bitmapNative != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int width = bitmapNative.getWidth();
                int height = bitmapNative.getHeight();
                if (z3) {
                    if (iXV == 0) {
                        iXV = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a3i);
                    }
                    if (width > iXV || height > iXV) {
                        if (width > height) {
                            height = (height * iXV) / width;
                            width = iXV;
                        } else if (width == height) {
                            height = iXV;
                            width = iXV;
                        } else {
                            width = (width * iXV) / height;
                            height = iXV;
                        }
                    }
                }
                if (z4) {
                    if (!str.endsWith("hd")) {
                        width = (int) (((float) bitmapNative.getWidth()) * f2 * 1.25f);
                        i3 = (int) (((float) bitmapNative.getHeight()) * f2 * 1.25f);
                    } else {
                        i3 = height;
                    }
                    if (((float) width) >= 160.0f * f2 || ((float) i3) >= 160.0f * f2) {
                        if (i3 > width) {
                            f3 = (160.0f * f2) / ((float) i3);
                        } else {
                            f3 = (160.0f * f2) / ((float) width);
                        }
                        width = (int) (((float) width) * f3);
                        i4 = (int) (f3 * ((float) i3));
                    } else {
                        i4 = i3;
                    }
                    if (((float) width) < 60.0f * f2) {
                        Log.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", Integer.valueOf(width));
                        width = (int) (60.0f * f2);
                    }
                    if (((float) i4) < 60.0f * f2) {
                        Log.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", Integer.valueOf(i4));
                        i4 = (int) (60.0f * f2);
                    }
                    MMApplicationContext.getContext();
                    int[] iArr = new int[2];
                    if (i4 >= width) {
                        float f4 = ((float) i4) / ((float) width);
                        if (f4 <= 2.0f) {
                            round = Math.round(150.0f * f2);
                            i5 = (int) (((float) round) / f4);
                        } else {
                            i5 = Math.round(75.0f * f2);
                            round = (int) (((float) i5) * f4);
                        }
                    } else {
                        float f5 = ((float) width) / ((float) i4);
                        if (f5 <= 2.0f) {
                            i5 = Math.round(150.0f * f2);
                            round = (int) (((float) i5) / f5);
                        } else {
                            round = Math.round(75.0f * f2);
                            i5 = (int) (((float) round) * f5);
                        }
                    }
                    iArr[0] = i5;
                    iArr[1] = round;
                    width = iArr[0];
                    height = iArr[1];
                }
                try {
                    bitmap2 = Bitmap.createScaledBitmap(bitmapNative, width, height, true);
                } catch (OutOfMemoryError e2) {
                    bitmap2 = bitmapNative;
                } catch (IllegalArgumentException e3) {
                    bitmap2 = bitmapNative;
                }
                if (bitmapNative != bitmap2 && !z6) {
                    Log.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", bitmapNative.toString());
                    bitmapNative.recycle();
                }
                if (z4) {
                    bitmap3 = BitmapUtil.createChattingImage(bitmap2, i2);
                } else if (z2) {
                    bitmap3 = BitmapUtil.getRoundedCornerBitmap(bitmap2, true, (float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 3));
                    Log.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", bitmap2.toString());
                    bitmap2.recycle();
                } else {
                    bitmap3 = bitmap2;
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = str;
                objArr2[1] = new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis).toString();
                objArr2[2] = bitmap3 == null ? "" : bitmap3.toString();
                Log.i("MicroMsg.ImgInfoStorage", "cached file :%s bitmap time:%s bitmap:%s", objArr2);
                if (bitmap3 != null && !z6) {
                    this.iXW.x(str, bitmap3);
                }
            } else {
                Log.e("MicroMsg.ImgInfoStorage", "img maybe delete, %s, %s", str, Boolean.valueOf(s.YS(str)));
            }
        }
        AppMethodBeat.o(150591);
        return bitmap3;
    }

    public final Bitmap OB(String str) {
        AppMethodBeat.i(150592);
        Bitmap bitmapNative = BitmapUtil.getBitmapNative(d(str, false, true), com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext()));
        AppMethodBeat.o(150592);
        return bitmapNative;
    }

    public final Bitmap a(String str, float f2, int i2) {
        int round;
        int i3;
        AppMethodBeat.i(223588);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(223588);
            return null;
        }
        String trim = str.trim();
        Bitmap aT = this.iXW.aT(trim);
        if (aT == null || aT.isRecycled()) {
            Bitmap decodeFile = BackwardSupportUtil.BitmapFactory.decodeFile(trim, f2);
            if (decodeFile != null) {
                int width = decodeFile.getWidth();
                int height = decodeFile.getHeight();
                if (width >= height) {
                    i3 = Math.round(((float) iYg) * f2);
                    round = (int) ((((float) height) / ((float) width)) * ((float) i3));
                } else {
                    round = Math.round(((float) iYg) * f2);
                    i3 = (int) ((((float) width) / ((float) height)) * ((float) round));
                }
                if (i3 <= 0 || round <= 0 || i3 > 2048 || round > 2048) {
                    Log.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", Integer.valueOf(i3), Integer.valueOf(round));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 188, 1, false);
                    aT = null;
                } else {
                    try {
                        aT = Bitmap.createScaledBitmap(decodeFile, i3, round, true);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", e2.getMessage());
                        aT = null;
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 188, 1, false);
                    }
                }
                if (i2 != -1) {
                    aT = BitmapUtil.createChattingImage(aT, i2);
                }
                if (decodeFile != aT) {
                    Log.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", decodeFile.toString());
                    decodeFile.recycle();
                }
                Log.d("MicroMsg.ImgInfoStorage", "cached file ".concat(String.valueOf(trim)));
                this.iXW.x(trim, aT);
            } else {
                aT = decodeFile;
            }
        }
        AppMethodBeat.o(223588);
        return aT;
    }

    public final g c(Long l) {
        AppMethodBeat.i(150596);
        g gVar = new g();
        Cursor a2 = a(d.Ay(l.longValue()), (String[]) null, "id=?", new String[]{String.valueOf(l)});
        if (a2 != null && a2.moveToFirst()) {
            gVar.convertFrom(a2);
        }
        a2.close();
        AppMethodBeat.o(150596);
        return gVar;
    }

    private g l(String str, String str2, int i2) {
        AppMethodBeat.i(223589);
        g gVar = new g();
        Cursor a2 = a(d.OH(str), (String[]) null, "origImgMD5=? AND compressType=?", new String[]{String.valueOf(str2), String.valueOf(i2)});
        if (a2.moveToFirst()) {
            gVar.convertFrom(a2);
        }
        a2.close();
        AppMethodBeat.o(223589);
        return gVar;
    }

    public final List<g> bcz() {
        AppMethodBeat.i(150598);
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = d.iYu.iterator();
        while (it.hasNext()) {
            Cursor rawQuery = this.iFy.rawQuery(("select * " + " FROM " + it.next().table) + " WHERE iscomplete= 0 AND totalLen != 0 ", null);
            if (!rawQuery.moveToFirst()) {
                rawQuery.close();
            } else {
                do {
                    g gVar = new g();
                    gVar.convertFrom(rawQuery);
                    g tm = tm((int) gVar.localId);
                    if (tm != null) {
                        if (!(tm.dTS == 0 && tm.iXv == 0)) {
                            arrayList.add(gVar);
                        }
                    } else if (!(gVar.dTS == 0 && gVar.iXv == 0)) {
                        arrayList.add(gVar);
                    }
                } while (rawQuery.moveToNext());
                rawQuery.close();
            }
        }
        AppMethodBeat.o(150598);
        return arrayList;
    }

    public final void V(ca caVar) {
        AppMethodBeat.i(150599);
        g U = U(caVar);
        if (U == null || U.localId == 0) {
            Log.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
            AppMethodBeat.o(150599);
            return;
        }
        s.deleteFile(o(U.iXm, "", ""));
        s.deleteFile(o(U.iXr, "", ""));
        s.deleteFile(o(U.iXo, "", ""));
        s.deleteFile(o(U.iXo, "", "") + "hd");
        this.iFy.delete(d.OH(caVar.field_talker), "id=?", new String[]{new StringBuilder().append(U.localId).toString()});
        if (U.bcv()) {
            g tl = tl(U.iXx);
            if (tl == null) {
                AppMethodBeat.o(150599);
                return;
            }
            s.deleteFile(o(tl.iXm, "", ""));
            s.deleteFile(o(tl.iXr, "", ""));
            s.deleteFile(o(tl.iXo, "", ""));
            s.deleteFile(o(tl.iXo, "", "") + "hd");
            this.iFy.delete(d.OH(caVar.field_talker), "id=?", new String[]{new StringBuilder().append(tl.localId).toString()});
        }
        AppMethodBeat.o(150599);
    }

    public final String a(String str, g gVar) {
        String str2 = null;
        AppMethodBeat.i(223590);
        if (gVar == null) {
            AppMethodBeat.o(223590);
        } else if (gVar.bcv()) {
            Cursor b2 = b(d.OH(str), new String[]{"bigImgPath"}, "id=? and totalLen = offset", new String[]{new StringBuilder().append(gVar.iXx).toString()});
            if (b2.moveToFirst()) {
                str2 = b2.getString(0);
            }
            b2.close();
            AppMethodBeat.o(223590);
        } else {
            AppMethodBeat.o(223590);
        }
        return str2;
    }

    public final HashMap<Long, g> a(Long... lArr) {
        AppMethodBeat.i(150601);
        String str = "(";
        int length = lArr.length;
        int i2 = 0;
        boolean z = true;
        while (i2 < length) {
            long longValue = lArr[i2].longValue();
            str = str + (z ? Long.valueOf(longValue) : ",".concat(String.valueOf(longValue)));
            i2++;
            z = false;
        }
        Cursor b2 = b("ImgInfo2", null, "msgSvrId in ".concat(String.valueOf(str + ")")), null);
        HashMap<Long, g> hashMap = new HashMap<>();
        while (b2.moveToNext()) {
            g gVar = new g();
            gVar.convertFrom(b2);
            hashMap.put(Long.valueOf(gVar.dTS), gVar);
        }
        b2.close();
        AppMethodBeat.o(150601);
        return hashMap;
    }

    public final HashMap<Long, g> b(Long... lArr) {
        AppMethodBeat.i(150602);
        String str = "(";
        int length = lArr.length;
        int i2 = 0;
        boolean z = true;
        while (i2 < length) {
            long longValue = lArr[i2].longValue();
            str = str + (z ? Long.valueOf(longValue) : ",".concat(String.valueOf(longValue)));
            i2++;
            z = false;
        }
        Cursor b2 = b("ImgInfo2", null, "msglocalid in ".concat(String.valueOf(str + ")")), null);
        HashMap<Long, g> hashMap = new HashMap<>();
        while (b2.moveToNext()) {
            g gVar = new g();
            gVar.convertFrom(b2);
            hashMap.put(Long.valueOf(gVar.dTS), gVar);
        }
        b2.close();
        AppMethodBeat.o(150602);
        return hashMap;
    }

    public final g tl(int i2) {
        AppMethodBeat.i(150603);
        g c2 = c(Long.valueOf((long) i2));
        AppMethodBeat.o(150603);
        return c2;
    }

    private g Ax(long j2) {
        AppMethodBeat.i(150604);
        g gVar = new g();
        Cursor b2 = b("ImgInfo2", null, "msgSvrId=?", new String[]{String.valueOf(j2)});
        if (b2.moveToFirst()) {
            gVar.convertFrom(b2);
        }
        b2.close();
        AppMethodBeat.o(150604);
        return gVar;
    }

    public final g G(String str, long j2) {
        AppMethodBeat.i(223591);
        g gVar = new g();
        Cursor b2 = b(d.OH(str), null, "msgSvrId=?", new String[]{String.valueOf(j2)});
        if (b2.moveToFirst()) {
            gVar.convertFrom(b2);
        }
        b2.close();
        AppMethodBeat.o(223591);
        return gVar;
    }

    public final g H(String str, long j2) {
        AppMethodBeat.i(223592);
        g gVar = new g();
        Cursor b2 = b(d.OH(str), null, "msglocalid=?", new String[]{String.valueOf(j2)});
        if (b2.moveToLast()) {
            gVar.convertFrom(b2);
        }
        b2.close();
        AppMethodBeat.o(223592);
        return gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.av.g tm(int r9) {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.i.tm(int):com.tencent.mm.av.g");
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2) {
        AppMethodBeat.i(150607);
        Cursor query = this.iFy.query(str, strArr, str2, strArr2, null, null, null);
        AppMethodBeat.o(150607);
        return query;
    }

    private Cursor b(String str, String[] strArr, String str2, String[] strArr2) {
        AppMethodBeat.i(150608);
        Cursor a2 = a(str, strArr, str2, strArr2);
        AppMethodBeat.o(150608);
        return a2;
    }

    public final long a(String str, String str2, String str3, int i2, int i3, int i4, PString pString, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(223593);
        long a2 = a(str, str2, str3, i2, i3, i4, pString, pInt, pInt2, "", "", -1, null, null, null, true, 0);
        AppMethodBeat.o(223593);
        return a2;
    }

    public final long a(String str, String str2, int i2, int i3, PString pString, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(223594);
        long a2 = a(str, str2, i2, i3, 0, pString, pInt, pInt2, "", "", -1, null, null, null, 0);
        AppMethodBeat.o(223594);
        return a2;
    }

    public final long a(String str, String str2, int i2, int i3, int i4, PString pString, PInt pInt, PInt pInt2, String str3, String str4, long j2, com.tencent.mm.b.b bVar, com.tencent.mm.b.b bVar2, p.a aVar, int i5) {
        AppMethodBeat.i(223595);
        long a2 = a(str, str2, null, i2, i3, i4, pString, pInt, pInt2, str3, str4, j2, bVar, bVar2, aVar, false, i5);
        AppMethodBeat.o(223595);
        return a2;
    }

    private long a(String str, String str2, String str3, int i2, int i3, int i4, PString pString, PInt pInt, PInt pInt2, String str4, String str5, long j2, com.tencent.mm.b.b bVar, com.tencent.mm.b.b bVar2, p.a aVar, boolean z, int i5) {
        long a2;
        AppMethodBeat.i(223596);
        if (i2 == 0) {
            g a3 = a(str, str2, 0, true, i3, i4, pInt, pInt2, pString.value, j2, str4, str5, bVar2, bVar, aVar, i5);
            if (a3 == null) {
                AppMethodBeat.o(223596);
                return -1;
            }
            pString.value = a3.iXo;
            if (s.YS(str3)) {
                String alX = ((com.tencent.mm.plugin.emoji.b.c) g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(a3.iXm);
                s.nw(str3, o(alX, "", ""));
                a3.Ou(alX);
            }
            long b2 = z ? b(str, a3) : a(str, "id", a3);
            if (b2 != -1) {
                doNotify();
            }
            AppMethodBeat.o(223596);
            return b2;
        } else if (i2 == 1) {
            g a4 = a(str, str2, 1, true, i3, i4, pInt, pInt2, pString.value, j2, str4, str5, bVar2, bVar, aVar, i5);
            if (a4 == null) {
                AppMethodBeat.o(223596);
                return -1;
            }
            pString.value = a4.iXo;
            a4.Aw(0);
            a4.yF(0);
            a4.tf((int) s.boW(o(a4.iXm, "", "")));
            g a5 = a(str, str2, 0, false, i3, i4, new PInt(), new PInt(), "", j2, str4, str5, bVar2, bVar, aVar, i5);
            if (a5 == null) {
                AppMethodBeat.o(223596);
                return 0;
            }
            a5.Oq(a4.iXm);
            a5.Os(a4.iXo);
            a5.Or(a4.iXn);
            a5.tf(0);
            long beginTransaction = this.iFy.beginTransaction(Thread.currentThread().getId());
            a5.tg((int) a(str, "id", a4));
            if (z) {
                a2 = b(str, a5);
            } else {
                a2 = a(str, "id", a5);
            }
            Log.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", Long.valueOf(a2), Long.valueOf(a5.localId), Long.valueOf(a5.iXv), a5.iXm, a5.iXn, Integer.valueOf(a5.iKP));
            if (beginTransaction > 0) {
                g.aAh().hqK.endTransaction(beginTransaction);
            }
            if (a2 != -1) {
                doNotify();
            }
            AppMethodBeat.o(223596);
            return a2;
        } else {
            Assert.assertTrue(false);
            AppMethodBeat.o(223596);
            return 0;
        }
    }

    public final long a(String str, String str2, g gVar) {
        AppMethodBeat.i(223597);
        String OH = d.OH(str);
        long insert = this.iFy.insert(OH, str2, gVar.convertTo());
        if (insert != -1) {
            gVar.bcx();
        }
        Log.i("MicroMsg.ImgInfoStorage", "insert img,table:%s result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", OH, Long.valueOf(insert), Long.valueOf(gVar.localId), Long.valueOf(gVar.iXv), Long.valueOf(gVar.dTS), Integer.valueOf(gVar.iXx));
        AppMethodBeat.o(223597);
        return insert;
    }

    private long b(String str, g gVar) {
        AppMethodBeat.i(223598);
        String OH = d.OH(str);
        long insertOrThrow = this.iFy.gFH().insertOrThrow(OH, "id", gVar.convertTo());
        if (insertOrThrow != -1) {
            gVar.bcx();
        }
        Log.i("MicroMsg.ImgInfoStorage", "insert img, table:%s result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", OH, Long.valueOf(insertOrThrow), Long.valueOf(gVar.localId), Long.valueOf(gVar.iXv), Long.valueOf(gVar.dTS), Integer.valueOf(gVar.iXx));
        AppMethodBeat.o(223598);
        return insertOrThrow;
    }

    public final String OC(String str) {
        AppMethodBeat.i(150615);
        String a2 = a("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str)), "th_", "", false);
        AppMethodBeat.o(150615);
        return a2;
    }

    public final String OD(String str) {
        AppMethodBeat.i(150616);
        String a2 = a(str, "", ".jpg", false);
        AppMethodBeat.o(150616);
        return a2;
    }

    private String m(String str, String str2, int i2) {
        AppMethodBeat.i(223599);
        g l = l(str, h.Ow(str2), i2);
        if (!Util.isNullOrNil(l.iXo)) {
            String R = R(l.iXo, true);
            if (s.YS(R)) {
                AppMethodBeat.o(223599);
                return R;
            }
        }
        AppMethodBeat.o(223599);
        return null;
    }

    private Bitmap a(String str, String str2, int i2, int i3, PInt pInt, PInt pInt2, boolean z, String str3, com.tencent.mm.b.b bVar, int i4) {
        String str4;
        AppMethodBeat.i(223600);
        Log.i("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap talker[%s] origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", str, str2, Integer.valueOf(i2), Boolean.valueOf(z), Util.getStack(), str3);
        Bitmap aT = this.iXW.aT(h.Ow(str2));
        String str5 = null;
        if (aT == null || aT.isRecycled()) {
            String m = m(str, str2, i2);
            if (Util.isNullOrNil(m)) {
                str4 = str2;
            } else if (m.endsWith("hd")) {
                str4 = m;
            } else {
                aT = BitmapUtil.getBitmapNative(m);
                str4 = str2;
            }
            if (aT == null || aT.isRecycled()) {
                int isLongPicture = LongBitmapHandler.isLongPicture(str4);
                int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str4) + (i3 * 90);
                if (isLongPicture > 0) {
                    aT = BitmapUtil.drawBackgroundInNeed(LongBitmapHandler.createLongPictureBitmap(str4, isLongPicture, exifOrientation), str4, i4);
                    str5 = m;
                } else {
                    aT = BitmapUtil.createThumbBitmap(str4, 120, 120, true, false, i4);
                    str5 = m;
                }
            } else {
                str5 = m;
            }
        }
        if (aT != null) {
            this.iXW.x(h.Ow(str2), aT);
            pInt.value = aT.getWidth();
            pInt2.value = aT.getHeight();
            if (z) {
                if (str5 == null) {
                    str5 = m(str, str2, i2);
                }
                if (!Util.isNullOrNil(str5) && str5.endsWith("hd")) {
                    str5 = str5.substring(0, str5.length() - 2);
                }
                if (bVar != null) {
                    bVar.Ur();
                }
                if (Util.isNullOrNil(str5) || !s.YS(str5) || s.boW(str5) <= 0) {
                    if (!Util.isNullOrNil(str5) && s.YS(str5)) {
                        Log.i("MicroMsg.ImgInfoStorage", "oldThumbFile Length %s", Long.valueOf(s.boW(str5)));
                    }
                    try {
                        BitmapUtil.saveBitmapToImage(aT, !Util.isNullOrNil(str5) && str5.endsWith("hd") ? 80 : 90, Bitmap.CompressFormat.JPEG, str3, false);
                        Log.i("MicroMsg.ImgInfoStorage", "saveBitmapToImage thumbPath %s", str3);
                    } catch (IOException e2) {
                    }
                } else {
                    s.nw(str5, str3);
                    Log.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s %s", str5, str3);
                }
            }
        }
        AppMethodBeat.o(223600);
        return aT;
    }

    public final String a(String str, String str2, int i2, PString pString, PInt pInt, PInt pInt2, int i3, int i4, String str3) {
        Bitmap bitmap;
        AppMethodBeat.i(223601);
        if (!s.YS(str2)) {
            Log.e("MicroMsg.ImgInfoStorage", "file not exit:%s", str2);
            AppMethodBeat.o(223601);
            return null;
        }
        if (Util.isNullOrNil(str3)) {
            str3 = bcA();
        }
        String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str3));
        String a2 = a(concat, "th_", "", false);
        pString.value = concat;
        long currentTicks = Util.currentTicks();
        Bitmap a3 = a(str, str2, i2, i3, pInt, pInt2, false, (String) null, (com.tencent.mm.b.b) null, -1);
        String str4 = this.iXX.get(str2);
        if (str4 != null) {
            bitmap = this.iXW.get(str4);
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = a(str2, true, com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext()), false, false, true, R.drawable.c3h, true, a3);
            this.iXX.put(str2, a2);
        }
        if (bitmap != null) {
            this.iXW.x(a2, bitmap);
        }
        Log.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(223601);
        return str3;
    }

    public static synchronized String bcA() {
        String OE;
        synchronized (i.class) {
            AppMethodBeat.i(150620);
            OE = OE("");
            AppMethodBeat.o(150620);
        }
        return OE;
    }

    private static synchronized String OE(String str) {
        String messageDigest;
        synchronized (i.class) {
            AppMethodBeat.i(150621);
            long currentTimeMillis = System.currentTimeMillis();
            if (iYh == currentTimeMillis) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e2) {
                }
                currentTimeMillis = System.currentTimeMillis();
            }
            iYh = currentTimeMillis;
            messageDigest = com.tencent.mm.b.g.getMessageDigest((str + currentTimeMillis).getBytes());
            Log.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", messageDigest, Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(150621);
        }
        return messageDigest;
    }

    private String a(String str, String str2, int i2, boolean z, int i3, PInt pInt, PInt pInt2, String str3, String str4, com.tencent.mm.b.b bVar, int i4) {
        AppMethodBeat.i(223602);
        Log.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", str2);
        if (!s.YS(str2)) {
            Log.e("MicroMsg.ImgInfoStorage", "file not exit:%s", str2);
            AppMethodBeat.o(223602);
            return null;
        }
        if (Util.isNullOrNil(str4)) {
            str4 = bcA();
        }
        String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str4));
        String a2 = a(concat, "th_", "", false);
        if (bVar == null) {
            a2 = o(concat, "th_", "");
        }
        if (z) {
            if (Util.isNullOrNil(str3) || !s.YS(str3)) {
                long currentTicks = Util.currentTicks();
                a(str, str2, i2, i3, pInt, pInt2, true, a2, bVar, i4);
                if (s.YS(a2)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10921, Long.valueOf(s.boW(a2)), Long.valueOf(s.boW(str2)), 90, Long.valueOf(Util.ticksToNow(currentTicks)));
                } else {
                    Log.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
                }
            } else {
                s.nw(str3, a2);
            }
            Log.d("MicroMsg.ImgInfoStorage", "insert: thumbName = ".concat(String.valueOf(concat)));
        }
        AppMethodBeat.o(223602);
        return concat;
    }

    public final String a(String str, String str2, String str3, int i2, boolean z, PString pString, PString pString2, PString pString3, PString pString4, String str4, com.tencent.mm.b.b bVar, int i3) {
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z4;
        long j2;
        int i12;
        boolean z5;
        int i13;
        int i14;
        boolean convertToProgressive;
        int i15;
        int i16;
        int i17;
        int i18;
        String str5;
        Uri O;
        boolean z6;
        String value;
        int i19;
        AppMethodBeat.i(223603);
        if (Util.isNullOrNil(str4)) {
            str4 = OE(str2);
            Log.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", str4, str2);
        }
        String a2 = a(str4, "", ".jpg", false);
        if (bVar == null) {
            a2 = a(str4, "", ".jpg", true);
        }
        Log.i("MicroMsg.ImgInfoStorage", "fullPath is %s", a2);
        if (s.boW(a2) > 0) {
            Log.i("MicroMsg.ImgInfoStorage", "genBigImg file already exist!");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(944, 8);
        }
        pString.value = str4;
        pString2.value = a2;
        if (z && !Util.isNullOrNil(str3) && i2 == 0) {
            g l = l(str, str3, i2);
            if (!Util.isNullOrNil(l.iXm)) {
                String o = o(l.iXm, "", "");
                if (bVar != null) {
                    bVar.Ur();
                }
                s.nw(o, a2);
                if (s.boW(o) <= 0) {
                    Log.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", str2, a2);
                } else if (!Util.isNullOrNil(l.iXy)) {
                    String str6 = l.iXy;
                    AppMethodBeat.o(223603);
                    return str6;
                } else {
                    AppMethodBeat.o(223603);
                    return null;
                }
            }
        }
        try {
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                i4 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressPicLevelForWifi"), 60);
            } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                i4 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressPicLevelFor2G"), 40);
            } else {
                i4 = NetStatusUtil.is3G(MMApplicationContext.getContext()) ? Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressPicLevelFor3G"), 40) : Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressPicLevelFor4G"), 60);
            }
        } catch (Exception e2) {
            i4 = 0;
        }
        Log.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", Integer.valueOf(i4));
        if (i4 <= 10 || i4 > 100) {
            i5 = 70;
        } else {
            i5 = i4;
        }
        int i20 = 0;
        int i21 = 1080;
        try {
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressResolutionForWifi");
            } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressResolutionFor2G");
            } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressResolutionFor3G");
            } else {
                value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressResolutionFor4G");
            }
            int indexOf = value.indexOf("*");
            if (-1 != indexOf) {
                i20 = Integer.valueOf(value.substring(0, indexOf)).intValue();
                i19 = Integer.valueOf(value.substring(indexOf + 1)).intValue();
            } else {
                i19 = 1080;
            }
            i21 = i19;
        } catch (Exception e3) {
        }
        try {
            int i22 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("UseOptImage"), 0);
            g.aAf();
            com.tencent.mm.b.p pVar = new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin());
            if ((((int) (pVar.longValue() / 100)) % 100) + 1 <= i22) {
                z2 = true;
            } else {
                z2 = false;
            }
            Log.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", Boolean.valueOf(z2), Integer.valueOf(i22), Long.valueOf(pVar.longValue()), Long.valueOf(pVar.longValue() / 100), Boolean.valueOf(CrashReportFactory.hasDebuger()), Integer.valueOf(Build.VERSION.SDK_INT));
        } catch (Exception e4) {
            Log.e("MicroMsg.ImgInfoStorage", "get useopt :%s", Util.stackTraceToString(e4));
            z2 = false;
        }
        if (CrashReportFactory.hasDebuger()) {
            z2 = true;
        }
        if (com.tencent.mm.compatible.util.d.oE(16)) {
            z3 = false;
        } else {
            z3 = z2;
        }
        Log.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", Integer.valueOf(i20), Integer.valueOf(i21));
        if (i20 <= 0 && i21 <= 0) {
            i20 = 0;
            i21 = 1080;
        } else if (i21 >= 2160) {
            i20 = 0;
            i21 = 1080;
        } else if (i21 <= 0 && i20 > 3240) {
            i20 = 1620;
            i21 = 0;
        }
        int i23 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i23 <= 0) {
            i23 = 100;
        }
        int i24 = i23 * 1024;
        int i25 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (i25 <= 0 || i25 >= 100) {
            i6 = 10;
        } else {
            i6 = i25;
        }
        int queryQuality = MMNativeJpeg.queryQuality(str2);
        boolean z7 = true;
        if (queryQuality != 0 && queryQuality <= i5) {
            z7 = false;
        }
        Log.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", str2, a2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i24), Integer.valueOf(i6));
        if (z) {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str2);
            if (imageOptions == null || imageOptions.outWidth == 0 || imageOptions.outHeight == 0) {
                Object[] objArr = new Object[2];
                objArr[0] = str2;
                objArr[1] = Boolean.valueOf(imageOptions == null);
                Log.w("MicroMsg.ImgInfoStorage", "genBigImg getImageOptions error:%s, origOptions_null:%b", objArr);
                AppMethodBeat.o(223603);
                return null;
            }
            int i26 = imageOptions.outWidth;
            int i27 = imageOptions.outHeight;
            int i28 = imageOptions.outWidth > imageOptions.outHeight ? imageOptions.outWidth : imageOptions.outHeight;
            int i29 = imageOptions.outWidth < imageOptions.outHeight ? imageOptions.outWidth : imageOptions.outHeight;
            if (i21 > 0) {
                i7 = i29 / i21;
                int i30 = imageOptions.outHeight > i21 ? (imageOptions.outHeight * i21) / i29 : imageOptions.outHeight;
                int i31 = imageOptions.outWidth > i21 ? (i21 * imageOptions.outWidth) / i29 : imageOptions.outWidth;
                i9 = i30;
                i10 = i31;
            } else {
                i7 = i28 / i20;
                int i32 = imageOptions.outHeight > i20 ? (imageOptions.outHeight * i20) / i28 : imageOptions.outHeight;
                if (imageOptions.outWidth > i20) {
                    i8 = (i20 * imageOptions.outWidth) / i28;
                } else {
                    i8 = imageOptions.outWidth;
                }
                i9 = i32;
                i10 = i8;
            }
            if (i9 * i10 > 10240000) {
                double sqrt = Math.sqrt(((double) (i9 * i10)) / 1.024E7d);
                i11 = (int) (((double) i9) / sqrt);
                i10 = (int) (((double) i10) / sqrt);
            } else {
                i11 = i9;
            }
            Log.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", Integer.valueOf(imageOptions.outHeight), Integer.valueOf(imageOptions.outWidth), Integer.valueOf(i11), Integer.valueOf(i10));
            String str7 = imageOptions != null ? imageOptions.outMimeType : "";
            long boW = s.boW(str2);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str2);
            if (str7 == null || (!str7.endsWith("jpeg") && !str7.endsWith("jpg") && !str7.endsWith("bmp") && !str7.endsWith("png") && !str7.endsWith("gif"))) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (i2 != 0 || ((!z7 && boW <= 204800 && (imageOptions == null || i7 <= 0)) || boW <= ((long) i24))) {
                Log.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", Integer.valueOf(queryQuality), Long.valueOf(boW), Integer.valueOf(i26), Integer.valueOf(i27));
                if (z4) {
                    if (Build.VERSION.SDK_INT < 30 || (O = p.b.O(MMApplicationContext.getContext(), str2)) == null) {
                        str5 = str2;
                    } else {
                        str5 = O.toString();
                    }
                    s.nw(str5, a2);
                } else if (BitmapUtil.createThumbNailMayUseOpt(false, str2, i26, i27, Bitmap.CompressFormat.JPEG, 100, a2, bVar, i3) != 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 187, 1, false);
                    Log.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", str2);
                    AppMethodBeat.o(223603);
                    return null;
                }
                com.tencent.mm.an.f.baQ();
                if (!com.tencent.mm.an.b.sS(256)) {
                    Log.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
                } else if (i2 == 1) {
                    int i33 = 0;
                    try {
                        i33 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressMidPicLevel")).intValue();
                    } catch (Exception e5) {
                    }
                    try {
                        i15 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressMidPicSize")).intValue();
                    } catch (Exception e6) {
                        i15 = 0;
                    }
                    Log.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", Integer.valueOf(i33), Integer.valueOf(i15));
                    if (i33 <= 10 || i33 > 100) {
                        i33 = 52;
                    }
                    if (i15 <= 0 || i15 > 800) {
                        i16 = 800;
                    } else {
                        i16 = i15;
                    }
                    if (i10 > i16) {
                        i17 = i16;
                    } else {
                        i17 = i10;
                    }
                    if (i11 > i16) {
                        i18 = i16;
                    } else {
                        i18 = i11;
                    }
                    boolean z8 = true;
                    if (queryQuality != 0 && queryQuality <= i33) {
                        z8 = false;
                    }
                    if (z8 || boW > 800 || (imageOptions != null && (i27 > i16 || i26 > i16))) {
                        pString3.value = OE(str2);
                        pString4.value = a(pString3.value, "", ".jpg", false);
                        i13 = BitmapUtil.createThumbNailMayUseOpt(false, str2, i18, i17, Bitmap.CompressFormat.JPEG, i33, pString4.value, bVar, i3);
                        Log.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", pString3.value, pString4.value, Boolean.FALSE, Integer.valueOf(i13), Integer.valueOf(i18), Integer.valueOf(i17));
                        j2 = 0;
                        i12 = 38;
                        z5 = false;
                    } else {
                        pString3.value = pString.value;
                        pString4.value = pString2.value;
                        Log.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", Boolean.valueOf(z8), Integer.valueOf(i27), Integer.valueOf(i26), Integer.valueOf(i18), Integer.valueOf(i17), pString3.value, pString4.value);
                        j2 = 0;
                        i13 = 1;
                        i12 = 38;
                        z5 = false;
                    }
                }
                j2 = 0;
                i13 = 1;
                i12 = 38;
                z5 = false;
            } else {
                if (queryQuality < 55 || !IsJpegFile) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (z6) {
                    i12 = 18;
                } else {
                    i12 = 8;
                }
                long nowMilliSecond = Util.nowMilliSecond();
                i13 = BitmapUtil.createThumbNailMayUseOpt(z6, str2, i11, i10, Bitmap.CompressFormat.JPEG, i5, a2, bVar, i3);
                if (i13 == 1 || !z6) {
                    z5 = z6;
                } else {
                    i12 = 28;
                    i13 = BitmapUtil.createThumbNailMayUseOpt(false, str2, i11, i10, Bitmap.CompressFormat.JPEG, i5, a2, bVar, i3);
                    z5 = false;
                }
                long boW2 = s.boW(a2);
                Log.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", Long.valueOf(boW), Long.valueOf(boW2), Long.valueOf((100 * boW2) / boW), Integer.valueOf(i6), a2);
                if (z4 && (boW - boW2) * 100 < ((long) i6) * boW) {
                    s.nw(str2, a2);
                    z5 = false;
                    i12 = 48;
                    i13 = 1;
                }
                j2 = Util.nowMilliSecond() - nowMilliSecond;
                if (i13 != 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 187, 1, false);
                    Log.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", str2);
                    AppMethodBeat.o(223603);
                    return null;
                }
            }
            BitmapFactory.Options imageOptions2 = BitmapUtil.getImageOptions(a2);
            int i34 = imageOptions2 != null ? imageOptions2.outWidth : -1;
            int i35 = imageOptions2 != null ? imageOptions2.outHeight : -1;
            long boW3 = s.boW(a2);
            int queryQuality2 = MMNativeJpeg.queryQuality(a2);
            boolean IsJpegFile2 = MMNativeJpeg.IsJpegFile(a2);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr2 = new Object[13];
            objArr2[0] = Integer.valueOf(i13);
            objArr2[1] = Long.valueOf(j2);
            objArr2[2] = Integer.valueOf(i12);
            objArr2[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
            objArr2[4] = Long.valueOf(boW);
            objArr2[5] = Integer.valueOf(i26);
            objArr2[6] = Integer.valueOf(i27);
            objArr2[7] = Integer.valueOf(i2);
            objArr2[8] = Long.valueOf(boW3);
            objArr2[9] = Integer.valueOf(i34);
            objArr2[10] = Integer.valueOf(i35);
            objArr2[11] = Integer.valueOf(queryQuality);
            objArr2[12] = Integer.valueOf(queryQuality2);
            hVar.a(11713, objArr2);
            Log.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", Integer.valueOf(i13), Boolean.valueOf(z5), Integer.valueOf(i12), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(queryQuality), Long.valueOf(boW), Boolean.valueOf(IsJpegFile), Integer.valueOf(i34), Integer.valueOf(i35), Integer.valueOf(queryQuality2), Long.valueOf(boW3), Boolean.valueOf(IsJpegFile2), str2, a2);
            if (i2 == 0 && boW3 >= 40960 && IsJpegFile2 && !MMNativeJpeg.isProgressive(a2)) {
                String value2 = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableCDNUploadImg");
                if (!Util.isNullOrNil(value2) && value2.equals("1")) {
                    long nowMilliSecond2 = Util.nowMilliSecond();
                    if (z5) {
                        i14 = 19;
                        String str8 = a2 + ".prog";
                        s.nw(a2, str8);
                        convertToProgressive = ImageOptimLib.convertToProgressive(str8, a2, i5);
                        s.deleteFile(str8);
                        if (!convertToProgressive) {
                            i14 = 29;
                            convertToProgressive = MMNativeJpeg.convertToProgressive(a2, i5);
                        }
                    } else {
                        i14 = 9;
                        convertToProgressive = MMNativeJpeg.convertToProgressive(a2, i5);
                    }
                    long nowMilliSecond3 = Util.nowMilliSecond() - nowMilliSecond2;
                    long boW4 = s.boW(a2);
                    com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    Object[] objArr3 = new Object[14];
                    objArr3[0] = Integer.valueOf(convertToProgressive ? 1 : -1);
                    objArr3[1] = Long.valueOf(nowMilliSecond3);
                    objArr3[2] = Integer.valueOf(i14);
                    objArr3[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
                    objArr3[4] = Long.valueOf(boW);
                    objArr3[5] = Integer.valueOf(i26);
                    objArr3[6] = Integer.valueOf(i27);
                    objArr3[7] = Integer.valueOf(i2);
                    objArr3[8] = Long.valueOf(boW3);
                    objArr3[9] = Integer.valueOf(i34);
                    objArr3[10] = Integer.valueOf(i35);
                    objArr3[11] = Integer.valueOf(queryQuality);
                    objArr3[12] = Integer.valueOf(queryQuality2);
                    objArr3[13] = Long.valueOf(boW4);
                    hVar2.a(11713, objArr3);
                    Log.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", Integer.valueOf(i13), Boolean.valueOf(convertToProgressive), Long.valueOf(boW4), Boolean.valueOf(z5), Integer.valueOf(i14), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(queryQuality), Long.valueOf(boW), Boolean.valueOf(IsJpegFile), Integer.valueOf(i34), Integer.valueOf(i35), Integer.valueOf(queryQuality2), Long.valueOf(boW3), Boolean.valueOf(IsJpegFile2), str2, a2);
                    if (!convertToProgressive) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 186, 1, false);
                        Log.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", a2);
                    }
                }
            }
        }
        AppMethodBeat.o(223603);
        return null;
    }

    private g a(String str, String str2, int i2, boolean z, int i3, int i4, PInt pInt, PInt pInt2, String str3, long j2, String str4, String str5, com.tencent.mm.b.b bVar, com.tencent.mm.b.b bVar2, p.a aVar, int i5) {
        com.tencent.mm.b.b bVar3;
        String str6;
        PString pString;
        PString pString2;
        PString pString3;
        String a2;
        AppMethodBeat.i(223604);
        if (!s.YS(str2)) {
            AppMethodBeat.o(223604);
            return null;
        }
        String Ow = h.Ow(str2);
        String a3 = a(str, str2, i2, z, i4, pInt, pInt2, str3, str4, bVar, i5);
        if (aVar == null || aVar.iXp != i2) {
            if (aVar == null || aVar.iXp == i2) {
                bVar3 = bVar2;
                str6 = str5;
            } else {
                bVar3 = null;
                str6 = null;
            }
            pString = new PString();
            pString2 = new PString();
            pString3 = new PString();
            PString pString4 = new PString();
            a2 = a(str, str2, Ow, i2, z, pString, pString2, pString3, pString4, str6, bVar3, i5);
            Log.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", str2, Integer.valueOf(i3), Integer.valueOf(i2), pString3.value, pString4.value);
        } else {
            p.a.C0275a bcI = aVar.bcI();
            pString = bcI.iZP;
            pString2 = bcI.iZQ;
            a2 = bcI.iXy;
            pString3 = bcI.iZR;
            Log.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", str2, Integer.valueOf(i3), Integer.valueOf(i2), pString3.value, bcI.iZS.value);
        }
        g gVar = new g();
        gVar.cSx = -1;
        gVar.setLocalId(d.OG(str).incrementAndGet());
        gVar.Aw(j2);
        if (!Util.isNullOrNil(a2)) {
            gVar.Ot(a2);
        }
        gVar.tj(0);
        gVar.setSource(i3);
        if (i3 != 4) {
            gVar.th(1);
        } else if (str2.startsWith(ap.aTc())) {
            gVar.th(3);
        } else {
            gVar.th(2);
        }
        if (z) {
            gVar.Oq(pString.value + ".jpg");
            if (!Util.isNullOrNil(pString3.value)) {
                gVar.Or(pString3.value + ".jpg");
            }
            if (Util.isNullOrNil(gVar.iXo)) {
                gVar.Os(a3);
            }
            gVar.tf((int) s.boW(pString2.value));
            if (gVar.iKP == 0) {
                Log.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", pString2.value);
            }
            gVar.Op(Ow);
        }
        gVar.setCreateTime((int) Util.nowSecond());
        gVar.tk(i2);
        Log.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + gVar.iKP);
        AppMethodBeat.o(223604);
        return gVar;
    }

    public final long a(String str, byte[] bArr, long j2, boolean z, String str2, PString pString, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(223605);
        long a2 = a(str, bArr, j2, z, "", 0, str2, pString, pInt, pInt2);
        AppMethodBeat.o(223605);
        return a2;
    }

    public final long a(String str, byte[] bArr, long j2, boolean z, String str2, int i2, String str3, PString pString, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(223606);
        String concat = "SERVERID://".concat(String.valueOf(j2));
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(concat.getBytes());
        String o = o(messageDigest, "th_", "");
        if (bArr != null && bArr.length >= 0) {
            Bitmap decodeByteArray = BitmapUtil.decodeByteArray(bArr);
            if (decodeByteArray == null) {
                Log.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(bArr));
            }
            if (!z && decodeByteArray != null) {
                try {
                    Bitmap extractThumeNail = BitmapUtil.extractThumeNail(decodeByteArray, 120, 120, false);
                    pInt.value = extractThumeNail.getWidth();
                    pInt2.value = extractThumeNail.getHeight();
                    BitmapUtil.saveBitmapToImage(extractThumeNail, 90, Bitmap.CompressFormat.JPEG, o, true);
                } catch (IOException e2) {
                    Log.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + messageDigest + " " + new String(bArr));
                }
            }
        }
        g gVar = new g();
        if (!Util.isNullOrNil(str2)) {
            gVar.setOffset(i2);
            gVar.tf(i2);
        } else {
            str2 = concat;
        }
        gVar.cSx = -1;
        gVar.setLocalId(d.OG(str).incrementAndGet());
        gVar.Oq(str2);
        gVar.Os("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(messageDigest)));
        pString.value = gVar.iXo;
        if (z) {
            gVar.yF(0);
            gVar.tk(1);
        } else {
            gVar.yF(j2);
            gVar.tk(0);
        }
        gVar.Ot(str3);
        gVar.setCreateTime((int) Util.nowSecond());
        long a2 = a(str, "id", gVar);
        if (a2 != -1) {
            doNotify();
        }
        AppMethodBeat.o(223606);
        return a2;
    }

    public final int a(int i2, g gVar) {
        AppMethodBeat.i(150627);
        int a2 = a(Long.valueOf((long) i2), gVar);
        AppMethodBeat.o(150627);
        return a2;
    }

    public final int a(Long l, g gVar) {
        int update;
        AppMethodBeat.i(150628);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        ContentValues convertTo = gVar.convertTo();
        if (convertTo.size() == 0) {
            update = 1;
        } else {
            update = this.iFy.update(d.Ay(l.longValue()), convertTo, "id=?", new String[]{String.valueOf(l)});
        }
        Log.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s %s", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()), convertTo.toString(), Integer.valueOf(update));
        if (update != -1) {
            gVar.bcx();
            doNotify();
        }
        AppMethodBeat.o(150628);
        return update;
    }

    public final Bitmap m(int i2, int i3, boolean z) {
        String str;
        AppMethodBeat.i(150629);
        if (z) {
            str = "location_backgroup_key_from";
        } else {
            str = "location_backgroup_key_tor";
        }
        Bitmap aT = this.iXW.aT(str);
        if (aT == null || aT.isRecycled()) {
            aT = BitmapUtil.createLocation((int) R.drawable.bgr, (int) R.drawable.cg5, i2, i3);
            this.iXW.x(str, aT);
        }
        AppMethodBeat.o(150629);
        return aT;
    }

    public final Bitmap a(long j2, String str, int i2, int i3, int i4, boolean z) {
        String concat;
        AppMethodBeat.i(150630);
        if (z) {
            concat = "location_backgroup_key_from".concat(String.valueOf(j2));
        } else {
            concat = "location_backgroup_key_tor".concat(String.valueOf(j2));
        }
        Bitmap aT = this.iXW.aT(concat);
        if (aT == null || aT.isRecycled()) {
            aT = BitmapUtil.createLocation(str, i2, i3, i4);
            this.iXW.x(concat, aT);
        }
        AppMethodBeat.o(150630);
        return aT;
    }

    public final boolean a(ca caVar, int i2, int i3) {
        AppMethodBeat.i(223607);
        String W = W(caVar);
        if (!Util.isNullOrNil(W)) {
            boolean a2 = a(W, caVar.field_imgPath, i2, i3, 0, 0);
            AppMethodBeat.o(223607);
            return a2;
        }
        AppMethodBeat.o(223607);
        return false;
    }

    public final boolean a(String str, String str2, int i2, int i3, int i4, int i5) {
        String str3;
        String substring;
        boolean createThumbNail;
        float f2;
        AppMethodBeat.i(223608);
        Log.d("MicroMsg.ImgInfoStorage", "createHDThumbNail bigPicPath:%s thumbPath:%s maskResId:%d, compressType:%d, stack[%s]", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Util.getStack());
        long currentTimeMillis = System.currentTimeMillis();
        float density = com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext());
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(223608);
            return false;
        }
        String d2 = d(str2, false, true);
        if (Util.isNullOrNil(d2)) {
            AppMethodBeat.o(223608);
            return false;
        }
        if (!d2.endsWith("hd")) {
            str3 = d2 + "hd";
            substring = d2;
        } else {
            str3 = d2;
            substring = d2.substring(0, d2.length() - 2);
        }
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(substring);
        if (imageOptions == null || imageOptions.outWidth <= 0 || imageOptions.outHeight <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 185, 1, false);
            if (s.boW(substring) > 0) {
                AppMethodBeat.o(223608);
                return false;
            }
            imageOptions = new BitmapFactory.Options();
            BitmapUtil.bindlowMemeryOption(imageOptions);
            Log.i("MicroMsg.ImgInfoStorage", "createHDThumbNail old op is invaild but len is 0 need recreate[%s, %d, %d]", imageOptions, Integer.valueOf(imageOptions.outWidth), Integer.valueOf(imageOptions.outHeight));
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 183, 1, false);
        }
        if (imageOptions.outWidth == 0) {
            imageOptions.outWidth = i4;
        }
        if (imageOptions.outHeight == 0) {
            imageOptions.outHeight = i5;
        }
        int i6 = (int) (((float) imageOptions.outWidth) * density * 1.25f);
        int i7 = (int) (((float) imageOptions.outHeight) * density * 1.25f);
        if (((float) i6) >= 160.0f * density || ((float) i7) >= 160.0f * density) {
            if (i7 > i6) {
                f2 = (160.0f * density) / ((float) i7);
            } else {
                f2 = (160.0f * density) / ((float) i6);
            }
            i6 = (int) (((float) i6) * f2);
            i7 = (int) (f2 * ((float) i7));
        }
        if (i3 == 0) {
            try {
                createThumbNail = BitmapUtil.createThumbNail(str, i7, i6, Bitmap.CompressFormat.JPEG, 80, str3, true, new PInt(), new PInt(), true, -1);
            } catch (Exception e2) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 184, 1, false);
                Log.e("MicroMsg.ImgInfoStorage", "create hd thumbnail failed. %s", e2.toString());
                AppMethodBeat.o(223608);
                return false;
            }
        } else {
            createThumbNail = BitmapUtil.createThumbNail(str, i7, i6, Bitmap.CompressFormat.JPEG, 80, str3, true, new PInt(), new PInt(), true, true, -1);
        }
        Log.d("MicroMsg.ImgInfoStorage", "createHDThumbNail user time %s, height %d, width %d, hasHDThumb:%b", new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis).toString(), Integer.valueOf(i7), Integer.valueOf(i6), Boolean.valueOf(createThumbNail));
        a(substring, true, com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext()), true, false, true, i2, false);
        if (createThumbNail) {
            synchronized (this.iYd) {
                try {
                    if (this.iYd.containsKey(str2) && !this.iYd.get(str2).endsWith("hd")) {
                        this.iYd.put(str2, str3);
                    }
                } finally {
                    AppMethodBeat.o(223608);
                }
            }
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 184, 1, false);
        }
        return createThumbNail;
    }

    public final String d(String str, boolean z, boolean z2) {
        String R;
        AppMethodBeat.i(150633);
        if (str == null || !this.iYd.containsKey(str)) {
            if (z) {
                R = str;
            } else {
                R = R(str, z2);
            }
            if (!Util.isNullOrNil(R)) {
                this.iYd.put(str, R);
            }
        } else {
            R = this.iYd.get(str);
        }
        AppMethodBeat.o(150633);
        return R;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0032, code lost:
        if (r0.localId == 0) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String W(com.tencent.mm.storage.ca r14) {
        /*
        // Method dump skipped, instructions count: 251
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.i.W(com.tencent.mm.storage.ca):java.lang.String");
    }

    public static class a extends BitmapDrawable {
        public static void a(Bitmap bitmap, ImageView imageView) {
            AppMethodBeat.i(150564);
            if (imageView == null || imageView.getResources() == null) {
                AppMethodBeat.o(150564);
                return;
            }
            a aVar = new a(imageView.getResources(), bitmap);
            if (imageView.getLayerType() == 1) {
                imageView.destroyDrawingCache();
                imageView.setLayerType(0, null);
            }
            imageView.setImageDrawable(aVar);
            AppMethodBeat.o(150564);
        }

        private a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(150565);
            if (getBitmap() == null || getBitmap().isRecycled()) {
                if (getBitmap() != null) {
                    Log.e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", getBitmap().toString());
                }
                AppMethodBeat.o(150565);
                return;
            }
            super.draw(canvas);
            AppMethodBeat.o(150565);
        }
    }

    public final Bitmap c(String str, float f2) {
        AppMethodBeat.i(223585);
        Bitmap a2 = a(str, f2, true);
        AppMethodBeat.o(223585);
        return a2;
    }

    public final Bitmap d(String str, float f2) {
        AppMethodBeat.i(150582);
        Bitmap a2 = a(str, f2, false);
        AppMethodBeat.o(150582);
        return a2;
    }

    public final g U(ca caVar) {
        AppMethodBeat.i(150595);
        g H = H(caVar.field_talker, caVar.field_msgId);
        if (H.localId == 0) {
            H = G(caVar.field_talker, caVar.field_msgSvrId);
            if (H.localId == 0) {
                Log.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
                AppMethodBeat.o(150595);
                return null;
            }
        }
        AppMethodBeat.o(150595);
        return H;
    }

    public final String OF(String str) {
        AppMethodBeat.i(263518);
        String d2 = d(str, false, true);
        AppMethodBeat.o(263518);
        return d2;
    }

    static /* synthetic */ void a(i iVar, String str) {
        Bitmap aT;
        ImageView imageView;
        View view;
        ImageView imageView2;
        AppMethodBeat.i(150636);
        Log.d("MicroMsg.ImgInfoStorage", "checkrefresh load done, uri: %s", str);
        iVar.iYc.remove(Integer.valueOf(str.hashCode()));
        for (b bVar : iVar.iXY) {
            if (str.equals(bVar.url) && (aT = iVar.iXW.aT(str)) != null && !aT.isRecycled() && (imageView = iVar.iXZ.get(Integer.valueOf(bVar.iYn)).get()) != null) {
                Log.i("MicroMsg.ImgInfoStorage", "[checkrefresh] bitmap width %d,height %d", Integer.valueOf(aT.getWidth()), Integer.valueOf(aT.getHeight()));
                a.a(aT, imageView);
                imageView.setLayoutParams(iVar.iYe);
                boolean z = aT.getWidth() >= aT.getHeight() * 2;
                boolean z2 = aT.getHeight() >= aT.getWidth() * 2;
                if (z || z2) {
                    Log.d("MicroMsg.ImgInfoStorage", "bm: w:%d, h:%d ", Integer.valueOf(aT.getWidth()), Integer.valueOf(aT.getHeight()));
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                }
                if (!(iVar.iYa.get(Integer.valueOf(bVar.iYo)) == null || (imageView2 = iVar.iYa.get(Integer.valueOf(bVar.iYo)).get()) == null)) {
                    imageView2.setLayoutParams(new FrameLayout.LayoutParams(aT.getWidth(), aT.getHeight()));
                }
                if (!(iVar.iYb.get(Integer.valueOf(bVar.iYp)) == null || (view = iVar.iYb.get(Integer.valueOf(bVar.iYp)).get()) == null)) {
                    view.setLayoutParams(new FrameLayout.LayoutParams(aT.getWidth(), aT.getHeight()));
                }
            }
        }
        AppMethodBeat.o(150636);
    }
}
