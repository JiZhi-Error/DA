package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class t {
    private static AtomicLong jsC = new AtomicLong(1);
    public h iFy;
    MStorageEvent<a, a.C0460a> iKx = new MStorageEvent<a, a.C0460a>() {
        /* class com.tencent.mm.modelvideo.t.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(a aVar, a.C0460a aVar2) {
            AppMethodBeat.i(126957);
            aVar.a(aVar2);
            AppMethodBeat.o(126957);
        }
    };

    public static class b {
        public byte[] buf = null;
        public int dAc = 0;
        public int jsR = 0;
        public int ret = 0;
    }

    private static String KD(String str) {
        AppMethodBeat.i(240878);
        String str2 = "select " + str + ".filename," + str + ".clientid," + str + ".msgsvrid," + str + ".netoffset," + str + ".filenowsize," + str + ".totallen," + str + ".thumbnetoffset," + str + ".thumblen," + str + ".status," + str + ".createtime," + str + ".lastmodifytime," + str + ".downloadtime," + str + ".videolength," + str + ".msglocalid," + str + ".nettimes," + str + ".cameratype," + str + ".user," + str + ".human," + str + ".reserved1," + str + ".reserved2," + str + ".reserved3," + str + ".reserved4," + str + ".videofuncflag," + str + ".masssendid," + str + ".masssendlist," + str + ".videomd5," + str + ".streamvideo," + str + ".statextstr," + str + ".downloadscene," + str + ".mmsightextinfo," + str + ".preloadsize," + str + ".videoformat," + str + ".forward_msg_local_id," + str + ".msg_uuid from " + str + "  ";
        AppMethodBeat.o(240878);
        return str2;
    }

    private static String Qp(String str) {
        AppMethodBeat.i(240879);
        String str2 = "select " + str + ".filename,downloadtime from " + str + "  ";
        AppMethodBeat.o(240879);
        return str2;
    }

    public interface a {
        void a(C0460a aVar);

        public enum b {
            INSERT,
            DELETE,
            UPDATE;

            public static b valueOf(String str) {
                AppMethodBeat.i(126960);
                b bVar = (b) Enum.valueOf(b.class, str);
                AppMethodBeat.o(126960);
                return bVar;
            }

            static {
                AppMethodBeat.i(126961);
                AppMethodBeat.o(126961);
            }
        }

        public enum c {
            NORMAL,
            UPLOAD,
            DOWNLOAD;

            public static c valueOf(String str) {
                AppMethodBeat.i(126963);
                c cVar = (c) Enum.valueOf(c.class, str);
                AppMethodBeat.o(126963);
                return cVar;
            }

            static {
                AppMethodBeat.i(126964);
                AppMethodBeat.o(126964);
            }
        }

        /* renamed from: com.tencent.mm.modelvideo.t$a$a  reason: collision with other inner class name */
        public static final class C0460a {
            public final String fileName;
            public final long jqz;
            public final b jsH;
            public final c jsI;
            public final int jsu;

            public C0460a(String str, b bVar, c cVar, int i2, long j2) {
                this.fileName = str;
                this.jsH = bVar;
                this.jsI = cVar;
                this.jsu = i2;
                this.jqz = j2;
            }
        }
    }

    public static final class c {
        String iYq;
        String[] iYr;
        String table;

        public c(String str, String str2, String[] strArr) {
            this.table = str2;
            this.iYq = str;
            this.iYr = strArr;
        }
    }

    public static final class d {
        public static final ArrayList<c> iYu = new ArrayList<>(3);

        static {
            AppMethodBeat.i(240877);
            a("", "videoinfo2", t.QA("videoinfo2"));
            a("findermsg", "findervideoinfo", t.QB("findervideoinfo"));
            a("gamelifesess", "gamelifevideoinfo", t.QB("gamelifevideoinfo"));
            AppMethodBeat.o(240877);
        }

        private static void a(String str, String str2, String[] strArr) {
            AppMethodBeat.i(240875);
            iYu.add(new c(str.toLowerCase(), str2, strArr));
            AppMethodBeat.o(240875);
        }

        public static String QC(String str) {
            AppMethodBeat.i(240876);
            if (str == null) {
                Log.e("MicroMsg.VideoInfoStorage", "[getTable] fileName is null. %s", Util.getStack());
                AppMethodBeat.o(240876);
                return "videoinfo2";
            }
            Iterator<c> it = iYu.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (!next.iYq.isEmpty() && str.toLowerCase().endsWith(next.iYq)) {
                    String str2 = next.table;
                    AppMethodBeat.o(240876);
                    return str2;
                }
            }
            AppMethodBeat.o(240876);
            return "videoinfo2";
        }
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(126965);
        this.iKx.add(aVar, looper);
        AppMethodBeat.o(126965);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(126966);
        this.iKx.remove(aVar);
        AppMethodBeat.o(126966);
    }

    public t(h hVar) {
        AppMethodBeat.i(126967);
        this.iFy = hVar;
        AppMethodBeat.o(126967);
    }

    public final boolean b(s sVar) {
        AppMethodBeat.i(126968);
        if (sVar == null) {
            AppMethodBeat.o(126968);
            return false;
        }
        sVar.cSx = -1;
        if (((int) this.iFy.insert(d.QC(sVar.getFileName()), "filename", sVar.convertTo())) != -1) {
            this.iKx.event(new a.C0460a(sVar.getFileName(), a.b.INSERT, a.c.NORMAL, sVar.jsu, sVar.jqz));
            this.iKx.doNotify();
            AppMethodBeat.o(126968);
            return true;
        }
        AppMethodBeat.o(126968);
        return false;
    }

    public final s Qq(String str) {
        s sVar;
        AppMethodBeat.i(126969);
        try {
            Cursor rawQuery = this.iFy.rawQuery(KD(d.QC(str)) + " where " + d.QC(str) + ".filename = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
            if (rawQuery == null) {
                AppMethodBeat.o(126969);
                return null;
            }
            if (rawQuery.moveToFirst()) {
                sVar = new s();
                sVar.convertFrom(rawQuery);
            } else {
                sVar = null;
            }
            rawQuery.close();
            AppMethodBeat.o(126969);
            return sVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VideoInfoStorage", e2, "getByFileName error[%s]", e2.toString());
            AppMethodBeat.o(126969);
            return null;
        }
    }

    public final List<s> AK(long j2) {
        ArrayList arrayList = null;
        AppMethodBeat.i(126970);
        Cursor rawQuery = this.iFy.rawQuery(KD("videoinfo2") + " where videoinfo2.masssendid = " + j2, null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(126970);
        } else {
            arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                s sVar = new s();
                sVar.convertFrom(rawQuery);
                arrayList.add(sVar);
            }
            rawQuery.close();
            AppMethodBeat.o(126970);
        }
        return arrayList;
    }

    public final List<s> bhA() {
        AppMethodBeat.i(126971);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.iFy.rawQuery(KD("videoinfo2") + " WHERE status=200 order by masssendid desc", null, 2);
        int i2 = 0;
        while (rawQuery.moveToNext()) {
            s sVar = new s();
            sVar.convertFrom(rawQuery);
            arrayList.add(sVar);
            i2++;
        }
        rawQuery.close();
        Log.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:".concat(String.valueOf(i2)));
        AppMethodBeat.o(126971);
        return arrayList;
    }

    public final List<s> bhB() {
        AppMethodBeat.i(126972);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.iFy.rawQuery(KD("videoinfo2") + " WHERE status=198 AND masssendid > 0 order by masssendid desc", null, 2);
        while (rawQuery.moveToNext()) {
            s sVar = new s();
            sVar.convertFrom(rawQuery);
            arrayList.add(sVar);
        }
        rawQuery.close();
        AppMethodBeat.o(126972);
        return arrayList;
    }

    public final boolean c(s sVar) {
        boolean z;
        AppMethodBeat.i(126973);
        Assert.assertTrue(sVar != null);
        if (sVar.getFileName().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues convertTo = sVar.convertTo();
        if (convertTo.size() <= 0) {
            Log.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
        } else {
            if (this.iFy.update(d.QC(sVar.getFileName()), convertTo, "filename= ?", new String[]{sVar.getFileName()}) > 0) {
                a.c cVar = a.c.NORMAL;
                if (sVar.status == 112) {
                    cVar = a.c.DOWNLOAD;
                } else if (sVar.status == 103 || sVar.status == 104) {
                    cVar = a.c.UPLOAD;
                }
                this.iKx.event(new a.C0460a(sVar.getFileName(), a.b.UPDATE, cVar, sVar.jsu, sVar.jqz));
                this.iKx.doNotify();
                AppMethodBeat.o(126973);
                return true;
            }
        }
        AppMethodBeat.o(126973);
        return false;
    }

    public final List<String> bhC() {
        AppMethodBeat.i(126974);
        LinkedList linkedList = new LinkedList();
        Iterator<c> it = d.iYu.iterator();
        while (it.hasNext()) {
            linkedList.addAll(Qr(it.next().table));
        }
        AppMethodBeat.o(126974);
        return linkedList;
    }

    private List<String> Qr(String str) {
        Cursor cursor = null;
        AppMethodBeat.i(240880);
        String str2 = Qp(str) + " WHERE status=112 ORDER BY downloadtime DESC " + " LIMIT 10";
        LinkedList linkedList = new LinkedList();
        try {
            cursor = this.iFy.rawQuery(str2, null, 2);
            if (cursor.moveToFirst()) {
                do {
                    linkedList.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
            return linkedList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(240880);
        }
    }

    public final List<String> bhD() {
        AppMethodBeat.i(126975);
        LinkedList linkedList = new LinkedList();
        Iterator<c> it = d.iYu.iterator();
        while (it.hasNext()) {
            linkedList.addAll(Qs(it.next().table));
        }
        AppMethodBeat.o(126975);
        return linkedList;
    }

    private List<String> Qs(String str) {
        Cursor cursor = null;
        AppMethodBeat.i(240881);
        String sb = new StringBuilder(" LIMIT 10 )").toString();
        String str2 = (((" SELECT * FROM ( " + Qp(str) + " WHERE status=122" + sb) + " UNION SELECT * FROM ( ") + Qp(str) + " WHERE status=120" + sb) + " ORDER BY downloadtime DESC";
        LinkedList linkedList = new LinkedList();
        try {
            cursor = this.iFy.rawQuery(str2, null, 2);
            if (cursor.moveToFirst()) {
                do {
                    linkedList.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
            return linkedList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(240881);
        }
    }

    public final List<s> e(int i2, int i3, long j2) {
        AppMethodBeat.i(240882);
        LinkedList linkedList = new LinkedList();
        Iterator<c> it = d.iYu.iterator();
        while (it.hasNext()) {
            linkedList.addAll(a(it.next().table, i2, 1, j2));
        }
        AppMethodBeat.o(240882);
        return linkedList;
    }

    private List<s> a(String str, int i2, int i3, long j2) {
        Cursor cursor = null;
        AppMethodBeat.i(240883);
        String str2 = KD(str) + " where status=" + i2 + " AND preloadsize > 0 AND lastmodifytime <= " + j2 + " ORDER BY createtime LIMIT " + i3;
        LinkedList linkedList = new LinkedList();
        try {
            Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
            if (rawQuery.moveToFirst()) {
                do {
                    s sVar = new s();
                    sVar.convertFrom(rawQuery);
                    linkedList.add(sVar);
                } while (rawQuery.moveToNext());
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VideoInfoStorage", e2, "getNeedDeletePreloadVideo error", new Object[0]);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(240883);
            throw th;
        }
        AppMethodBeat.o(240883);
        return linkedList;
    }

    public final List<String> Qt(String str) {
        Cursor cursor = null;
        AppMethodBeat.i(240884);
        String sb = new StringBuilder(" LIMIT 10 )").toString();
        String str2 = (((" SELECT * FROM ( " + Qp(str) + " WHERE status=103" + sb) + " UNION SELECT * FROM ( ") + Qp(str) + " WHERE status=104" + sb) + " ORDER BY downloadtime DESC";
        LinkedList linkedList = new LinkedList();
        try {
            cursor = this.iFy.rawQuery(str2, null, 2);
            if (cursor.moveToFirst()) {
                do {
                    linkedList.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
            return linkedList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(240884);
        }
    }

    static {
        AppMethodBeat.i(240889);
        AppMethodBeat.o(240889);
    }

    @Deprecated
    public static String Qu(String str) {
        AppMethodBeat.i(240885);
        String Qv = Qv(str);
        AppMethodBeat.o(240885);
        return Qv;
    }

    public static String Qv(String str) {
        int lastIndexOf;
        AppMethodBeat.i(126978);
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        sb.append(new SimpleDateFormat("yyMMddHHmmss", Locale.ENGLISH).format(new Date(currentTimeMillis)));
        String valueOf = String.valueOf(currentTimeMillis);
        sb.append(valueOf.substring(valueOf.length() - 3));
        sb.append(jsC.getAndIncrement());
        if (str != null && (lastIndexOf = str.lastIndexOf("@")) >= 0) {
            sb.append(str.substring(lastIndexOf + 1));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(126978);
        return sb2;
    }

    private static String getVideoPath() {
        AppMethodBeat.i(126979);
        String str = g.aAh().hqG + "video/";
        AppMethodBeat.o(126979);
        return str;
    }

    public static String Qw(String str) {
        AppMethodBeat.i(126980);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126980);
            return null;
        }
        String str2 = getVideoPath() + str;
        if (s.YS(str2)) {
            AppMethodBeat.o(126980);
            return str2;
        }
        String str3 = str2 + ".mp4";
        AppMethodBeat.o(126980);
        return str3;
    }

    public static String Qx(String str) {
        AppMethodBeat.i(126981);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126981);
            return null;
        }
        String str2 = getVideoPath() + str + ".jpg";
        AppMethodBeat.o(126981);
        return str2;
    }

    public static int a(String str, int i2, byte[] bArr) {
        AppMethodBeat.i(126982);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.VideoInfoStorage", "ERR:" + f.apq() + " invalid fileName");
            int line = 0 - f.getLine();
            AppMethodBeat.o(126982);
            return line;
        } else if (i2 < 0) {
            Log.e("MicroMsg.VideoInfoStorage", "ERR:" + f.apq() + "[" + str + "]  invalid startOffset:" + i2);
            int line2 = 0 - f.getLine();
            AppMethodBeat.o(126982);
            return line2;
        } else if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.VideoInfoStorage", "ERR:" + f.apq() + "[" + str + "]  invalid writeBuf");
            int line3 = 0 - f.getLine();
            AppMethodBeat.o(126982);
            return line3;
        } else {
            f.a aVar = new f.a();
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = s.dB(str, true);
                long apr = aVar.apr();
                randomAccessFile.seek((long) i2);
                long apr2 = aVar.apr();
                randomAccessFile.write(bArr, 0, bArr.length);
                long apr3 = aVar.apr();
                int filePointer = (int) randomAccessFile.getFilePointer();
                long apr4 = aVar.apr();
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                }
                Log.d("MicroMsg.VideoInfoStorage", "FIN:" + f.apq() + "[" + str + "]  Offset:" + i2 + " buf:" + bArr.length);
                Log.d("MicroMsg.VideoInfoStorage", "FIN:" + f.apq() + "[" + str + "] open:" + apr + " seek:" + apr2 + " write:" + apr3 + " close:" + apr4);
                AppMethodBeat.o(126982);
                return filePointer;
            } catch (Exception e3) {
                Log.e("MicroMsg.VideoInfoStorage", "ERR:" + f.apq() + "[" + str + "] \t\tOffset:" + i2 + " failed:[" + e3.getMessage() + "]");
                int line4 = 0 - f.getLine();
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e4) {
                    }
                }
                AppMethodBeat.o(126982);
                return line4;
            } catch (Throwable th) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e5) {
                    }
                }
                AppMethodBeat.o(126982);
                throw th;
            }
        }
    }

    public static b t(String str, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(126983);
        b bVar = new b();
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.VideoInfoStorage", "ERR:" + f.apq() + " invalid fileName");
            bVar.ret = 0 - f.getLine();
            AppMethodBeat.o(126983);
        } else if (i2 < 0) {
            Log.e("MicroMsg.VideoInfoStorage", "ERR:" + f.apq() + "[" + str + "]  invalid readOffset:" + i2);
            bVar.ret = 0 - f.getLine();
            AppMethodBeat.o(126983);
        } else if (i3 <= 0) {
            Log.e("MicroMsg.VideoInfoStorage", "ERR:" + f.apq() + "[" + str + "]  invalid readLen");
            bVar.ret = 0 - f.getLine();
            AppMethodBeat.o(126983);
        } else {
            f.a aVar = new f.a();
            RandomAccessFile randomAccessFile = null;
            bVar.buf = new byte[i3];
            try {
                RandomAccessFile dB = s.dB(str, false);
                long apr = aVar.apr();
                dB.seek((long) i2);
                long apr2 = aVar.apr();
                int read = dB.read(bVar.buf, 0, i3);
                long apr3 = aVar.apr();
                long apr4 = aVar.apr();
                if (read >= 0) {
                    i4 = read;
                }
                bVar.dAc = i4;
                bVar.jsR = i4 + i2;
                if (dB != null) {
                    try {
                        dB.close();
                    } catch (Exception e2) {
                    }
                }
                Log.d("MicroMsg.VideoInfoStorage", "FIN:" + f.apq() + "[" + str + "]  Offset:" + i2 + " readlen:" + i3);
                Log.d("MicroMsg.VideoInfoStorage", "FIN:" + f.apq() + "[" + str + "] open:" + apr + " seek:" + apr2 + " write:" + apr3 + " close:" + apr4);
                AppMethodBeat.o(126983);
            } catch (Exception e3) {
                Log.e("MicroMsg.VideoInfoStorage", "ERR:" + f.apq() + "[" + str + "] \t\tOffset:" + bVar.jsR + " failed:[" + e3.getMessage() + "]");
                bVar.ret = 0 - f.getLine();
                if (0 != 0) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e4) {
                    }
                }
                AppMethodBeat.o(126983);
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e5) {
                    }
                }
                AppMethodBeat.o(126983);
                throw th;
            }
        }
        return bVar;
    }

    public static int Qy(String str) {
        AppMethodBeat.i(126984);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126984);
            return -1;
        }
        o oVar = new o(str);
        if (!oVar.exists()) {
            AppMethodBeat.o(126984);
            return 0;
        }
        int length = (int) oVar.length();
        if (length <= 0) {
            AppMethodBeat.o(126984);
            return 0;
        }
        AppMethodBeat.o(126984);
        return length;
    }

    public final void bhE() {
        char c2;
        AppMethodBeat.i(240886);
        int[] iArr = {0, 0, 0, 0, 0, 0};
        try {
            String concat = "select status, videofuncflag, human from videoinfo2 where lastmodifytime > ".concat(String.valueOf(Util.nowSecond() - 21600));
            Log.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", concat);
            Cursor rawQuery = this.iFy.rawQuery(concat, null, 2);
            while (rawQuery.moveToNext()) {
                int i2 = rawQuery.getInt(0);
                int i3 = rawQuery.getInt(1);
                String string = rawQuery.getString(2);
                if (111 == i2) {
                    if (i3 == 3) {
                        c2 = 0;
                    } else {
                        c2 = 3;
                    }
                    iArr[c2] = iArr[c2] + 1;
                } else if (199 == i2) {
                    if (z.aTY().equals(string)) {
                        char c3 = i3 == 3 ? (char) 1 : 4;
                        iArr[c3] = iArr[c3] + 1;
                    } else {
                        char c4 = i3 == 3 ? (char) 2 : 5;
                        iArr[c4] = iArr[c4] + 1;
                    }
                }
            }
            rawQuery.close();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12696, 10010, Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]), Integer.valueOf(iArr[4]), Integer.valueOf(iArr[5]));
            AppMethodBeat.o(240886);
        } catch (Exception e2) {
            AppMethodBeat.o(240886);
        }
    }

    public final boolean q(String str, String str2, String str3) {
        AppMethodBeat.i(126985);
        boolean bC = bC(str, str2 + "##" + str3);
        AppMethodBeat.o(126985);
        return bC;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1 A[SYNTHETIC, Splitter:B:28:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00de A[SYNTHETIC, Splitter:B:34:0x00de] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int[] Qz(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 239
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.t.Qz(java.lang.String):int[]");
    }

    private boolean bC(String str, String str2) {
        AppMethodBeat.i(126987);
        Log.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", str, str2, Util.getStack());
        long nowMilliSecond = Util.nowMilliSecond();
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", str, str2);
            AppMethodBeat.o(126987);
            return false;
        }
        int[] Qz = Qz(str);
        if (Qz == null || Qz.length < 33) {
            Log.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", str);
            AppMethodBeat.o(126987);
            return false;
        }
        int i2 = Qz[32];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < 32; i3++) {
            stringBuffer.append(Integer.toHexString(Qz[i3]));
        }
        Cursor rawQuery = this.iFy.rawQuery("select cdnxml from VideoHash where size = " + i2 + " and hash = \"" + stringBuffer.toString() + "\"", null, 2);
        Vector vector = new Vector();
        while (rawQuery.moveToNext()) {
            vector.add(rawQuery.getString(0));
            Log.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", Integer.valueOf(vector.size()), vector.get(vector.size() - 1));
        }
        rawQuery.close();
        if (vector.size() != 1 || !str2.equals(vector.get(0))) {
            if (vector.size() > 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12696, 102, Integer.valueOf(i2), "", "", Integer.valueOf(vector.size()));
                Log.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", Integer.valueOf(vector.size()), Integer.valueOf(i2));
                this.iFy.execSQL("VideoHash", "delete from VideoHash where size = " + i2 + " and hash = \"" + stringBuffer.toString() + "\"");
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("size", Integer.valueOf(i2));
            contentValues.put("CreateTime", Long.valueOf(Util.nowSecond()));
            contentValues.put("hash", stringBuffer.toString());
            contentValues.put("cdnxml", str2);
            contentValues.put("orgpath", str);
            long insert = this.iFy.insert("VideoHash", "", contentValues);
            Log.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Long.valueOf(insert), str, stringBuffer, str2);
            if (insert < 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12696, 103, Integer.valueOf(i2));
                Log.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", Long.valueOf(insert), str);
            }
            AppMethodBeat.o(126987);
            return true;
        }
        Log.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), str, str2);
        AppMethodBeat.o(126987);
        return true;
    }

    static /* synthetic */ String[] QA(String str) {
        AppMethodBeat.i(240887);
        String[] strArr = {"CREATE TABLE IF NOT EXISTS " + str + " ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset" + " int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen" + " int  , status int  , createtime long  , lastmodifytime long  , downloadtime" + " long  , videolength int  , msglocalid int  , nettimes int  , cameratype" + " int  , user text  , human text  , reserved1 int  , reserved2" + " int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid" + " long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr" + " text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat" + " int, forward_msg_local_id int,msg_uuid text )", "CREATE INDEX IF NOT EXISTS  video_status_index ON " + str + " ( status,downloadtime )", "CREATE TABLE IF NOT EXISTS videoinfo ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int, forward_msg_local_id int, msg_uuid text )", "alter table " + str + " add videofuncflag int ;", "alter table " + str + " add masssendid long default 0;", "alter table " + str + " add masssendlist text ;", "alter table " + str + " add videomd5 text ;", "alter table " + str + " add streamvideo byte[] ;", "alter table " + str + " add statextstr text ;", "alter table " + str + " add downloadscene int ;", "alter table " + str + " add mmsightextinfo byte[] ;", "alter table " + str + " add preloadsize int ;", "alter table " + str + " add videoformat int ;", "alter table " + str + " add forward_msg_local_id int ;", "alter table " + str + " add msg_uuid text ;", "alter table videoinfo add videofuncflag int ;", "alter table videoinfo add masssendid long default 0;", "alter table videoinfo add masssendlist text ;", "alter table videoinfo add videomd5 text ;", "alter table videoinfo add streamvideo byte[] ;", "alter table videoinfo add statextstr text ;", "alter table videoinfo add downloadscene int ;", "alter table videoinfo add mmsightextinfo byte[] ;", "alter table videoinfo add preloadsize int ;", "alter table videoinfo add videoformat int ;", "alter table videoinfo add forward_msg_local_id int ;", "alter table videoinfo add msg_uuid text ;", "insert into " + str + " select * from videoinfo ;", "delete from videoinfo ;", "CREATE INDEX IF NOT EXISTS  massSendIdIndex ON " + str + " ( masssendid )", "CREATE INDEX IF NOT EXISTS  LastModifyTimeIndex ON " + str + " ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS  VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS  VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS  VideoHashTimeIndex ON VideoHash ( CreateTime  )"};
        AppMethodBeat.o(240887);
        return strArr;
    }

    static /* synthetic */ String[] QB(String str) {
        AppMethodBeat.i(240888);
        String[] strArr = {"CREATE TABLE IF NOT EXISTS " + str + " ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset" + " int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen" + " int  , status int  , createtime long  , lastmodifytime long  , downloadtime" + " long  , videolength int  , msglocalid int  , nettimes int  , cameratype" + " int  , user text  , human text  , reserved1 int  , reserved2" + " int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid" + " long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr" + " text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat" + " int, forward_msg_local_id int,msg_uuid text )", "CREATE INDEX IF NOT EXISTS " + str + "video_status_index ON " + str + " ( status,downloadtime )", "CREATE INDEX IF NOT EXISTS " + str + "massSendIdIndex ON " + str + " ( masssendid )", "CREATE INDEX IF NOT EXISTS " + str + "LastModifyTimeIndex ON " + str + " ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS " + str + "VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS " + str + "VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS " + str + "VideoHashTimeIndex ON VideoHash ( CreateTime  )"};
        AppMethodBeat.o(240888);
        return strArr;
    }
}
