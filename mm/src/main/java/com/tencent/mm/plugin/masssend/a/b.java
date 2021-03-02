package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;

public final class b extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )"};
    public h iFy;

    public b(h hVar) {
        this.iFy = hVar;
    }

    public final Cursor Pf(int i2) {
        AppMethodBeat.i(26345);
        String str = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + i2 + " offset (SELECT count(*) FROM massendinfo ) -" + i2;
        Log.v("MicroMsg.MasSendInfoStorage", "getCursor sql:".concat(String.valueOf(str)));
        Cursor rawQuery = this.iFy.rawQuery(str, null);
        AppMethodBeat.o(26345);
        return rawQuery;
    }

    public final int ehA() {
        int i2 = 0;
        AppMethodBeat.i(26346);
        Cursor rawQuery = this.iFy.rawQuery("SELECT count(*) FROM massendinfo", null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(26346);
        return i2;
    }

    public static Bitmap h(String str, float f2) {
        AppMethodBeat.i(26347);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(26347);
            return null;
        }
        String trim = str.trim();
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        Bitmap decodeFile = BackwardSupportUtil.BitmapFactory.decodeFile(sb.append(c.aSY()).append(trim).toString(), f2);
        if (decodeFile != null) {
            decodeFile = Bitmap.createScaledBitmap(decodeFile, (int) (((float) decodeFile.getWidth()) * f2), (int) (((float) decodeFile.getHeight()) * f2), true);
        }
        AppMethodBeat.o(26347);
        return decodeFile;
    }

    public static Bitmap aDK(String str) {
        AppMethodBeat.i(26348);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(26348);
            return null;
        }
        String trim = str.trim();
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.aSY()).append(trim).toString();
        int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(sb2);
        Bitmap Sq = u.Sq(sb2);
        if (exifOrientation != 0) {
            Sq = BitmapUtil.rotate(Sq, (float) exifOrientation);
        }
        AppMethodBeat.o(26348);
        return Sq;
    }

    public static a l(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(26349);
        if (!s.YS(str)) {
            AppMethodBeat.o(26349);
            return null;
        }
        bg.aVF();
        String aSY = c.aSY();
        int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
        String messageDigest = g.getMessageDigest((str + System.currentTimeMillis()).getBytes());
        Log.d("MicroMsg.MasSendInfoStorage", "insert : original img path = ".concat(String.valueOf(str)));
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
        if (i3 != 0 || (s.boW(str) <= 204800 && (imageOptions == null || (imageOptions.outHeight <= 960 && imageOptions.outWidth <= 960)))) {
            byte[] aW = s.aW(str, 0, -1);
            s.e(aSY + messageDigest + ".jpg", aW, aW.length);
        } else if (!BitmapUtil.createThumbNail(str, 960, 960, Bitmap.CompressFormat.JPEG, 70, aSY, messageDigest)) {
            AppMethodBeat.o(26349);
            return null;
        } else {
            s.bo(aSY, messageDigest, messageDigest + ".jpg");
        }
        String str3 = messageDigest + ".jpg";
        Log.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = ".concat(String.valueOf(str3)));
        if (i3 != 0 || exifOrientation == 0 || BitmapUtil.rotate(aSY + str3, exifOrientation, Bitmap.CompressFormat.JPEG, 90, aSY, messageDigest + ".jpg")) {
            String messageDigest2 = g.getMessageDigest((str3 + System.currentTimeMillis()).getBytes());
            if (!BitmapUtil.createThumbNail(aSY + str3, 120, 120, Bitmap.CompressFormat.JPEG, 90, aSY, messageDigest2)) {
                AppMethodBeat.o(26349);
                return null;
            }
            Log.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = ".concat(String.valueOf(messageDigest2)));
            a aVar = new a();
            aVar.msgType = 3;
            aVar.znm = str2;
            aVar.znn = i2;
            aVar.znl = messageDigest2;
            aVar.filename = str3;
            AppMethodBeat.o(26349);
            return aVar;
        }
        AppMethodBeat.o(26349);
        return null;
    }

    public final a aDL(String str) {
        a aVar = null;
        AppMethodBeat.i(26351);
        Cursor rawQuery = this.iFy.rawQuery("select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(26351);
        } else {
            if (rawQuery.moveToFirst()) {
                aVar = new a();
                aVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(26351);
        }
        return aVar;
    }

    public static String a(a aVar) {
        AppMethodBeat.i(26350);
        switch (aVar.msgType) {
            case 1:
                String ehx = aVar.ehx();
                AppMethodBeat.o(26350);
                return ehx;
            case 3:
                String string = MMApplicationContext.getContext().getResources().getString(R.string.xr);
                AppMethodBeat.o(26350);
                return string;
            case 34:
                String string2 = MMApplicationContext.getContext().getResources().getString(R.string.zz);
                AppMethodBeat.o(26350);
                return string2;
            case 43:
                String string3 = MMApplicationContext.getContext().getResources().getString(R.string.zv);
                AppMethodBeat.o(26350);
                return string3;
            default:
                String string4 = MMApplicationContext.getContext().getResources().getString(R.string.bcm);
                AppMethodBeat.o(26350);
                return string4;
        }
    }
}
