package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.e.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.emoji.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.image.b;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.k.d;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public final class r extends MStorage {
    private static int DuA = 0;
    private static int Dvt = 0;
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )"};
    private static Point imX = new Point();
    public h iFy;

    static {
        AppMethodBeat.i(97620);
        AppMethodBeat.o(97620);
    }

    public r(h hVar) {
        this.iFy = hVar;
    }

    public static int getScreenWidth() {
        return Dvt > DuA ? DuA : Dvt;
    }

    public static void iI(int i2, int i3) {
        AppMethodBeat.i(97597);
        Dvt = i2;
        DuA = i3;
        Log.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(97597);
    }

    private static String aQD(String str) {
        AppMethodBeat.i(97598);
        if (str == null) {
            AppMethodBeat.o(97598);
            return "";
        }
        String messageDigest = g.getMessageDigest(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (messageDigest.length() > 0) {
            str2 = messageDigest.charAt(0) + FilePathGenerator.ANDROID_DIR_SEP;
        }
        if (messageDigest.length() >= 2) {
            str3 = messageDigest.charAt(1) + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str4 = aj.getAccSnsPath() + str2 + str3;
        AppMethodBeat.o(97598);
        return str4;
    }

    private boolean a(q qVar) {
        AppMethodBeat.i(97599);
        Log.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
        if (qVar == null) {
            AppMethodBeat.o(97599);
            return false;
        }
        if (((int) this.iFy.insert("SnsMedia", "local_id", qVar.feY())) != -1) {
            AppMethodBeat.o(97599);
            return true;
        }
        AppMethodBeat.o(97599);
        return false;
    }

    public final boolean a(String str, q qVar) {
        AppMethodBeat.i(97600);
        Log.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList ".concat(String.valueOf(str)));
        Cursor query = this.iFy.query("SnsMedia", null, "StrId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (query.moveToFirst()) {
            query.close();
            boolean a2 = a(qVar);
            AppMethodBeat.o(97600);
            return a2;
        }
        query.close();
        boolean b2 = b(str, qVar);
        AppMethodBeat.o(97600);
        return b2;
    }

    private boolean b(String str, q qVar) {
        AppMethodBeat.i(97601);
        ContentValues feY = qVar.feY();
        if (this.iFy.update("SnsMedia", feY, "StrId=?", new String[]{String.valueOf(str)}) > 0) {
            AppMethodBeat.o(97601);
            return true;
        }
        AppMethodBeat.o(97601);
        return false;
    }

    public final int a(int i2, q qVar) {
        AppMethodBeat.i(97602);
        ContentValues feY = qVar.feY();
        int update = this.iFy.update("SnsMedia", feY, "local_id=?", new String[]{String.valueOf(i2)});
        AppMethodBeat.o(97602);
        return update;
    }

    public final q aQE(String str) {
        AppMethodBeat.i(97603);
        q qVar = new q();
        Cursor query = this.iFy.query("SnsMedia", null, "StrId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (query.moveToFirst()) {
            qVar.convertFrom(query);
            query.close();
            AppMethodBeat.o(97603);
            return qVar;
        }
        query.close();
        AppMethodBeat.o(97603);
        return null;
    }

    public final q JK(long j2) {
        AppMethodBeat.i(97604);
        q qVar = new q();
        Cursor query = this.iFy.query("SnsMedia", null, "local_id=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
        if (!query.moveToFirst()) {
            query.close();
            AppMethodBeat.o(97604);
            return null;
        }
        qVar.convertFrom(query);
        query.close();
        AppMethodBeat.o(97604);
        return qVar;
    }

    public final List<q> gW(List<q> list) {
        AppMethodBeat.i(97605);
        LinkedList linkedList = new LinkedList();
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(97605);
            return null;
        }
        for (q qVar : list) {
            int a2 = a(qVar);
            if (a2 == -1) {
                AppMethodBeat.o(97605);
                return null;
            }
            q qVar2 = new q(a2, qVar.type);
            qVar2.height = qVar.height;
            qVar2.width = qVar.width;
            qVar2.fileSize = qVar.fileSize;
            linkedList.add(qVar2);
        }
        AppMethodBeat.o(97605);
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A[SYNTHETIC, Splitter:B:24:0x0074] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.plugin.sns.data.q a(com.tencent.mm.plugin.sns.data.q r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.r.a(com.tencent.mm.plugin.sns.data.q, java.lang.String):com.tencent.mm.plugin.sns.data.q");
    }

    private int a(q qVar) {
        String aBP;
        String yUVType;
        AppMethodBeat.i(97607);
        String accSnsPath = aj.getAccSnsPath();
        String accSnsTmpPath = aj.getAccSnsTmpPath();
        Log.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", accSnsPath, accSnsTmpPath);
        long currentTimeMillis = System.currentTimeMillis();
        String str = qVar.path;
        int i2 = qVar.type;
        if (!s.YS(str)) {
            AppMethodBeat.o(97607);
            return -1;
        }
        String messageDigest = g.getMessageDigest((str + System.currentTimeMillis()).getBytes());
        String aOj = com.tencent.mm.plugin.sns.data.r.aOj(messageDigest);
        Log.d("MicroMsg.snsMediaStorage", "insert : original img path = ".concat(String.valueOf(str)));
        if (!s.YS(accSnsTmpPath)) {
            Log.i("MicroMsg.snsMediaStorage", "create snstmp path ".concat(String.valueOf(accSnsTmpPath)));
            s.boN(accSnsTmpPath);
        }
        if (!s.YS(accSnsPath)) {
            Log.i("MicroMsg.snsMediaStorage", "create snsPath ".concat(String.valueOf(accSnsPath)));
            s.boN(accSnsPath);
        }
        b bVar = new b();
        q a2 = a(qVar, str);
        int i3 = a2.width;
        int i4 = a2.height;
        int i5 = a2.fileSize;
        bVar.ynE = str;
        bVar.ynG = i3;
        bVar.ynH = i4;
        bVar.ynI = i5;
        if (!f(accSnsTmpPath, str, aOj, true)) {
            AppMethodBeat.o(97607);
            return -1;
        }
        Log.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - currentTimeMillis));
        Log.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = ".concat(String.valueOf(aOj)));
        String str2 = accSnsTmpPath + aOj;
        int boW = (int) s.boW(str2);
        if (com.tencent.mm.plugin.sns.data.r.aBO(str2) == 2 && (yUVType = BitmapUtil.getYUVType(s.aW(str2, 0, boW))) != null) {
            Log.i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", yUVType);
            try {
                String k = s.k(str2, false);
                if (k == null) {
                    k = str2;
                }
                a aVar = new a(k);
                aVar.setAttribute(a.TAG_USER_COMMENT, yUVType);
                aVar.saveAttributes();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.snsMediaStorage", e2, "", new Object[0]);
            }
        }
        int boW2 = (int) s.boW(accSnsTmpPath + aOj);
        q a3 = a(a2, accSnsTmpPath + aOj);
        int i6 = a3.width;
        int i7 = a3.height;
        bVar.ynJ = i6;
        bVar.ynK = i7;
        bVar.ynL = boW2;
        q qVar2 = new q();
        qVar2.EmN = messageDigest;
        qVar2.createTime = (long) ((int) Util.nowSecond());
        qVar2.type = i2;
        cne cne = new cne();
        cne.Privated = a3.DEB;
        cne.MsV = a3.DEA;
        cne.token = a3.DEC;
        cne.Mte = a3.DED;
        cne.Mts = 0;
        cne.Mtr = new cmw();
        cne.ibG = 0;
        cne.Desc = a3.desc;
        Log.d("MicroMsg.snsMediaStorage", "upload.filterId " + a3.DEz);
        cne.MsU = a3.DEz;
        cne.Mpa = 2;
        cne.md5 = s.bhK(accSnsTmpPath + aOj);
        try {
            qVar2.EmR = cne.toByteArray();
        } catch (Exception e3) {
            Log.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        qVar2.feZ();
        qVar2.EmM = boW2;
        Log.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + boW2 + " filepath: " + accSnsTmpPath + aOj);
        int insert = (int) this.iFy.insert("SnsMedia", "local_id", qVar2.feY());
        Log.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(insert)));
        String concat = "Locall_path".concat(String.valueOf(insert));
        bVar.ynF = String.valueOf(insert);
        bVar.md5 = cne.md5;
        Exif fromFile = Exif.fromFile(bVar.ynE);
        int aBO = b.aBO(bVar.ynE);
        String str3 = fromFile.dateTimeOriginal;
        String str4 = bVar.ynE;
        if (!Util.isNullOrNil(str3)) {
            aBP = b.aBP(str3);
        } else {
            aBP = b.aBP(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(new o(str4).lastModified())));
        }
        m mVar = new m();
        mVar.n("20 localID", bVar.ynF + ",");
        mVar.n("21 MediaType", aBO + ",");
        mVar.n("22 OriginWidth", bVar.ynG + ",");
        mVar.n("23 OriginHeight", bVar.ynH + ",");
        mVar.n("24 CompressedWidth", bVar.ynJ + ",");
        mVar.n("25 CompressedHeight", bVar.ynK + ",");
        mVar.n("26 OriginSize", bVar.ynI + ",");
        mVar.n("27 CompressedSize", bVar.ynL + ",");
        mVar.n("28 FNumber", fromFile.fNumber + ",");
        mVar.n("29 ExposureTime", fromFile.exposureTime + ",");
        mVar.n("30 ISO", ((int) fromFile.isoSpeedRatings) + ",");
        mVar.n("31 Flash", ((int) fromFile.flash) + ",");
        mVar.n("32 LensModel", b.aBP(fromFile.model) + ",");
        mVar.n("33 CreatTime", aBP + ",");
        mVar.n("34 IsFromWeChat", "0,");
        mVar.n("35 Scene", ",");
        mVar.n("36 sceneType", fromFile.sceneType + ",");
        mVar.n("37 fileSource", fromFile.fileSource + ",");
        mVar.n("38 make", fromFile.make + ",");
        mVar.n("39 software", fromFile.software + ",");
        mVar.n("40 fileExt", b.akC(bVar.ynE) + ",");
        mVar.n("41 faceCount", "0,");
        mVar.n("42 YCbCrSubSampling", fromFile.yCbCrSubSampling + ",");
        mVar.n("43 md5", bVar.md5 + ',');
        Log.v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", mVar.abW(), bVar.ynE);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14525, mVar);
        String mVar2 = mVar.toString();
        d fcs = d.fcs();
        fcs.DUL.put(Integer.valueOf(insert), new d.a(b.aBO(str2), mVar2));
        String aOj2 = com.tencent.mm.plugin.sns.data.r.aOj(concat);
        String aQD = aQD(concat);
        s.boN(aQD);
        Log.i("MicroMsg.snsMediaStorage", "checkcntpath ".concat(String.valueOf(aQD)));
        s.nw(accSnsTmpPath + aOj, aQD + aOj2);
        String str5 = aQD + com.tencent.mm.plugin.sns.data.r.aOf(concat);
        String str6 = aQD + com.tencent.mm.plugin.sns.data.r.aOg(concat);
        s.deleteFile(str5);
        s.deleteFile(str6);
        Log.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - currentTimeMillis) + " targetPath : " + aQD + aOj2 + " totalLen:" + s.boW(aQD + aOj2) + "  now delete...:" + str5 + " & " + str6);
        qVar2.EmN = concat;
        a(insert, qVar2);
        AppMethodBeat.o(97607);
        return insert;
    }

    public final q a(q qVar, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(97608);
        q qVar2 = new q();
        qVar2.createTime = (long) ((int) Util.nowSecond());
        qVar2.type = qVar.type;
        cne cne = new cne();
        cne.Privated = qVar.DEB;
        cne.MsV = qVar.DEA;
        cne.token = qVar.DEC;
        cne.Mte = qVar.DED;
        cne.Mts = 0;
        cne.Mtr = new cmw();
        cne.ibG = 0;
        cne.Desc = qVar.desc;
        Log.d("MicroMsg.snsMediaStorage", "upload.filterId " + qVar.DEz);
        cne.MsU = qVar.DEz;
        cne.Mpa = 2;
        cne.videoPath = str;
        cne.Mtv = str2;
        cne.md5 = qVar.DEE;
        try {
            qVar2.EmR = cne.toByteArray();
        } catch (Exception e2) {
            Log.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        qVar2.feZ();
        int insert = (int) this.iFy.insert("SnsMedia", "local_id", qVar2.feY());
        String concat = "Locall_path".concat(String.valueOf(insert));
        Log.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(insert)));
        String aOj = com.tencent.mm.plugin.sns.data.r.aOj(concat);
        String aOk = com.tencent.mm.plugin.sns.data.r.aOk(concat);
        String aOi = com.tencent.mm.plugin.sns.data.r.aOi(concat);
        String aOl = com.tencent.mm.plugin.sns.data.r.aOl(concat);
        String aQD = aQD(concat);
        s.boN(aQD);
        s.nw(str2, aQD + aOj);
        s.nw(str2, aQD + aOk);
        s.nw(str2, aQD + aOi);
        s.nw(str, aQD + aOl);
        cne.videoPath = aQD + aOl;
        cne.Mtv = aQD + aOk;
        cne.md5 = qVar.DEE;
        try {
            qVar2.EmR = cne.toByteArray();
        } catch (Exception e3) {
            Log.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        qVar2.EmN = concat;
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            cmw cmw = new cmw();
            cmw.oUv = 1;
            cmw.Url = str3;
            cne.Mtr = cmw;
            cne.Mpa = 0;
            f.baR();
            cne.MsS = com.tencent.mm.an.a.NX(str);
            if (!Util.isNullOrNil(str4)) {
                cmw cmw2 = new cmw();
                cmw2.oUv = 1;
                cmw2.Url = str4;
                cne.Mtt.add(cmw2);
            }
            try {
                qVar2.EmR = cne.toByteArray();
            } catch (Exception e4) {
                Log.printErrStackTrace("MicroMsg.snsMediaStorage", e4, "", new Object[0]);
            }
            qVar2.ffa();
        }
        a(insert, qVar2);
        q a2 = a(qVar, cne.Mtv);
        a2.ecf = insert;
        AppMethodBeat.o(97608);
        return a2;
    }

    public static boolean ffc() {
        AppMethodBeat.i(97609);
        if ("hevc".equals(ac.jPu)) {
            AppMethodBeat.o(97609);
            return true;
        }
        boolean fbd = aj.fbd();
        AppMethodBeat.o(97609);
        return fbd;
    }

    public static boolean ffd() {
        AppMethodBeat.i(203208);
        if ("wxam".equals(ac.jPu)) {
            AppMethodBeat.o(203208);
            return true;
        }
        boolean fbf = aj.fbf();
        AppMethodBeat.o(203208);
        return fbf;
    }

    private static byte[] aB(Bitmap bitmap) {
        AppMethodBeat.i(203209);
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        byte[] array = allocate.array();
        AppMethodBeat.o(203209);
        return array;
    }

    private static boolean kM(String str, String str2) {
        AppMethodBeat.i(203210);
        try {
            Bitmap k = com.tencent.mm.plugin.sns.d.a.k(str, 0.0f);
            byte[] aB = aB(k);
            k.recycle();
            e.cEM();
            if (e.a(aB, str, str2, k.getWidth(), k.getHeight(), k.getWidth(), k.getHeight()) == 0) {
                AppMethodBeat.o(203210);
                return true;
            }
            AppMethodBeat.o(203210);
            return false;
        } catch (OutOfMemoryError e2) {
            Log.w("MicroMsg.snsMediaStorage", "convertImg2WxamWithoutZip origPath:%s OutOfMemoryError! rollback", str);
            AppMethodBeat.o(203210);
            return false;
        }
    }

    private static boolean b(Bitmap bitmap, String str, String str2) {
        AppMethodBeat.i(203211);
        try {
            byte[] aB = aB(bitmap);
            e.cEM();
            if (e.a(aB, str, str2, bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth(), bitmap.getHeight()) == 0) {
                AppMethodBeat.o(203211);
                return true;
            }
            AppMethodBeat.o(203211);
            return false;
        } catch (OutOfMemoryError e2) {
            Log.w("MicroMsg.snsMediaStorage", "convertImg2WxamWithoutZip bmp OutOfMemoryError! rollback");
            AppMethodBeat.o(203211);
            return false;
        }
    }

    private static boolean a(Bitmap bitmap, String str, String str2, int i2, int i3) {
        AppMethodBeat.i(203212);
        try {
            byte[] aB = aB(bitmap);
            e.cEM();
            if (e.a(aB, str, str2, bitmap.getWidth(), bitmap.getHeight(), i2, i3) == 0) {
                AppMethodBeat.o(203212);
                return true;
            }
            AppMethodBeat.o(203212);
            return false;
        } catch (OutOfMemoryError e2) {
            Log.w("MicroMsg.snsMediaStorage", "convertImg2WxamZip bmp OutOfMemoryError! rollback");
            AppMethodBeat.o(203212);
            return false;
        }
    }

    public static boolean ffe() {
        AppMethodBeat.i(97610);
        if ("wxpc".equals(ac.jPu)) {
            AppMethodBeat.o(97610);
            return true;
        }
        boolean fbg = aj.fbg();
        AppMethodBeat.o(97610);
        return fbg;
    }

    public static boolean aR(String str, String str2, String str3) {
        AppMethodBeat.i(259447);
        boolean f2 = f(str, str2, str3, true);
        AppMethodBeat.o(259447);
        return f2;
    }

    public static boolean fff() {
        return DuA >= 1080 && Dvt >= 1080;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x040a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x04f6  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0521  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b A[SYNTHETIC, Splitter:B:19:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0765  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x015d A[SYNTHETIC, Splitter:B:50:0x015d] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01c8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x021a A[SYNTHETIC, Splitter:B:69:0x021a] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(java.lang.String r21, java.lang.String r22, java.lang.String r23, boolean r24) {
        /*
        // Method dump skipped, instructions count: 3131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.r.f(java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    private static boolean a(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, String str3, boolean z) {
        AppMethodBeat.i(97613);
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
        if (imageOptions == null || imageOptions.outWidth <= 0 || imageOptions.outHeight <= 0) {
            AppMethodBeat.o(97613);
            return false;
        }
        boolean a2 = a(imageOptions, str, imageOptions.outWidth, imageOptions.outHeight, i2, i3, compressFormat, i4, str2, str3, z);
        AppMethodBeat.o(97613);
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x027c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x027d, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.snsMediaStorage", r2, "create thumbnail from orig failed: %s", r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x028c, code lost:
        if (r3 != null) goto L_0x028e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x029f, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02a0, code lost:
        r10 = r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d8 A[SYNTHETIC, Splitter:B:33:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x027c A[ExcHandler: IOException (r2v2 'e' java.io.IOException A[CUSTOM_DECLARE]), PHI: r3 
      PHI: (r3v1 java.io.OutputStream) = (r3v0 java.io.OutputStream), (r3v9 java.io.OutputStream), (r3v9 java.io.OutputStream) binds: [B:1:0x000e, B:52:0x01f3, B:53:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x000e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.graphics.BitmapFactory.Options r13, java.lang.String r14, int r15, int r16, int r17, android.graphics.Bitmap.CompressFormat r18, int r19, java.lang.String r20, java.lang.String r21, boolean r22) {
        /*
        // Method dump skipped, instructions count: 682
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.r.a(android.graphics.BitmapFactory$Options, java.lang.String, int, int, int, android.graphics.Bitmap$CompressFormat, int, java.lang.String, java.lang.String, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (0 != 0) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050 A[SYNTHETIC, Splitter:B:17:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean aQF(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.r.aQF(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ed A[SYNTHETIC, Splitter:B:47:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r22, java.lang.String r23, java.lang.String r24, float r25) {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.r.a(java.lang.String, java.lang.String, java.lang.String, float):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0123 A[SYNTHETIC, Splitter:B:52:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x029a A[SYNTHETIC, Splitter:B:91:0x029a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.graphics.BitmapFactory.Options r14, java.lang.String r15, int r16, int r17, int r18, int r19, android.graphics.Bitmap.CompressFormat r20, int r21, java.lang.String r22, java.lang.String r23, boolean r24) {
        /*
        // Method dump skipped, instructions count: 753
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.r.a(android.graphics.BitmapFactory$Options, java.lang.String, int, int, int, int, android.graphics.Bitmap$CompressFormat, int, java.lang.String, java.lang.String, boolean):boolean");
    }

    public static boolean b(String str, String str2, String str3, float f2) {
        int ceil;
        int i2;
        Bitmap bitmap;
        AppMethodBeat.i(97618);
        try {
            s.deleteFile(str + str3);
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str + str2);
            if (imageOptions == null) {
                Log.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
                AppMethodBeat.o(97618);
                return false;
            }
            if (Build.VERSION.SDK_INT > 26 && imageOptions != null && (imageOptions.outColorSpace == ColorSpace.get(ColorSpace.Named.DCI_P3) || imageOptions.outColorSpace == ColorSpace.get(ColorSpace.Named.DISPLAY_P3))) {
                imageOptions.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            if (imageOptions.outMimeType == null || (!imageOptions.outMimeType.toLowerCase().endsWith("png") && !imageOptions.outMimeType.toLowerCase().endsWith("vcodec") && !imageOptions.outMimeType.toLowerCase().endsWith("wxam"))) {
                int i3 = imageOptions.outWidth;
                int i4 = imageOptions.outHeight;
                int i5 = (int) f2;
                int i6 = (int) f2;
                imageOptions.inJustDecodeBounds = false;
                Log.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                if (i3 == i5 && i4 == i6) {
                    bitmap = com.tencent.mm.plugin.sns.d.a.b(str + str2, imageOptions);
                } else {
                    if ((((double) i4) * 1.0d) / ((double) i6) > (((double) i3) * 1.0d) / ((double) i5)) {
                        ceil = i5;
                        i2 = (int) Math.ceil(((((double) i5) * 1.0d) * ((double) i4)) / ((double) i3));
                    } else {
                        ceil = (int) Math.ceil(((((double) i6) * 1.0d) * ((double) i3)) / ((double) i4));
                        i2 = i6;
                    }
                    Log.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", Integer.valueOf(ceil), Integer.valueOf(i2));
                    imageOptions.inSampleSize = 1;
                    if (i4 > i2 || i3 > ceil) {
                        imageOptions.inSampleSize = 1;
                        if (i4 > i2 || i3 > ceil) {
                            double d2 = (((double) i4) * 1.0d) / ((double) i2);
                            double d3 = (((double) i3) * 1.0d) / ((double) ceil);
                            if (d2 >= d3) {
                                d3 = d2;
                            }
                            imageOptions.inSampleSize = (int) d3;
                            if (imageOptions.inSampleSize <= 1) {
                                imageOptions.inSampleSize = 1;
                            }
                        }
                        long a2 = (long) ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_max_decode_pic_size, 10240000);
                        while (((long) (((i4 * i3) / imageOptions.inSampleSize) / imageOptions.inSampleSize)) > a2) {
                            imageOptions.inSampleSize++;
                        }
                    }
                    Log.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", Integer.valueOf(imageOptions.inSampleSize));
                    if (((float) i4) / ((float) i3) == ((float) i6) / ((float) i5)) {
                        Bitmap b2 = com.tencent.mm.plugin.sns.d.a.b(str + str2, imageOptions);
                        Log.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
                        bitmap = b2;
                    } else {
                        float max = Math.max(((float) ceil) / ((float) i3), ((float) i2) / ((float) i4));
                        int min = Math.min(i3, (int) (((float) i5) / max));
                        int min2 = Math.min(i4, (int) (((float) i6) / max));
                        int max2 = Math.max(0, (i3 - min) >> 1);
                        int max3 = Math.max(0, (i4 - min2) >> 1);
                        Rect rect = new Rect();
                        rect.left = max2;
                        rect.right = max2 + min;
                        rect.top = max3;
                        rect.bottom = max3 + min2;
                        String str4 = str + str2;
                        long currentTimeMillis = System.currentTimeMillis();
                        Bitmap a3 = l.aRY().a(str4, rect, imageOptions);
                        if (a3 != null) {
                            a3 = com.tencent.mm.plugin.sns.data.r.t(str4, a3);
                        }
                        Log.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        Log.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", Integer.valueOf(min), Integer.valueOf(min2), Integer.valueOf(max2), Integer.valueOf(max3), Float.valueOf(max));
                        bitmap = a3;
                    }
                }
            } else {
                bitmap = BitmapUtil.extractThumbNail(str + str2, (int) f2, (int) f2, true);
            }
            if (bitmap == null) {
                Log.i("MicroMsg.snsMediaStorage", "bitmap error " + str + str2);
                s.deleteFile(str + str2);
                AppMethodBeat.o(97618);
                return false;
            }
            Log.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            boolean z = true;
            if (bitmap.getHeight() > 120 || bitmap.getWidth() > 120) {
                z = false;
            }
            BitmapUtil.saveBitmapToImage(bitmap, 100, z ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, str + str3, false);
            l.aRY().x(bitmap);
            AppMethodBeat.o(97618);
            return true;
        } catch (OutOfMemoryError e2) {
            Log.printErrStackTrace("MicroMsg.snsMediaStorage", e2, "create thumbnail from orig failed: %s", str3);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1487, 2, 1);
            AppMethodBeat.o(97618);
            return false;
        } catch (Exception e3) {
            Log.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", e3.getMessage());
            Log.printErrStackTrace("MicroMsg.snsMediaStorage", e3, "", new Object[0]);
        }
    }

    public static Bitmap aQG(String str) {
        int i2 = 640;
        AppMethodBeat.i(97619);
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
        int i3 = imageOptions.outWidth >= imageOptions.outHeight ? 960 : 640;
        if (imageOptions.outWidth < imageOptions.outHeight) {
            i2 = 960;
        }
        Bitmap extractThumbNail = BitmapUtil.extractThumbNail(str, i2, i3, false);
        if (extractThumbNail == null) {
            AppMethodBeat.o(97619);
            return null;
        }
        Bitmap rotate = BitmapUtil.rotate(extractThumbNail, (float) Exif.fromFile(str).getOrientationInDegree());
        AppMethodBeat.o(97619);
        return rotate;
    }
}
