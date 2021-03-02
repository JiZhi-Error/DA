package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.vfs.s;

public final class bz extends MStorageEx {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS  MediaDuplication  (md5 text , size int , path text , createtime long, remuxing text, duration int, status int);", "DROP INDEX IF EXISTS MediaDuplicationMD5Index ", "CREATE INDEX IF NOT EXISTS MD5Index ON MediaDuplication ( md5 )"};
    public ISQLiteDatabase db;

    @Override // com.tencent.mm.sdk.storage.MStorageEx
    public final boolean shouldProcessEvent() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0185, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0186, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0199, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x019a, code lost:
        r7 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e3 A[Catch:{ Exception -> 0x0192 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ef A[SYNTHETIC, Splitter:B:40:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0185 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:30:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bz(com.tencent.mm.storagebase.h r14) {
        /*
        // Method dump skipped, instructions count: 421
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.bz.<init>(com.tencent.mm.storagebase.h):void");
    }

    public final boolean P(String str, int i2, String str2) {
        AppMethodBeat.i(152801);
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.MediaCheckDuplicationStorage", "insert path is null");
            AppMethodBeat.o(152801);
            return false;
        }
        long j2 = (long) i2;
        if (i2 <= 0) {
            j2 = (long) ((int) s.boW(str2));
            if (j2 <= 0) {
                Log.e("MicroMsg.MediaCheckDuplicationStorage", "insert path insize:%d size:%d  path:%s", Integer.valueOf(i2), Long.valueOf(j2), str2);
                AppMethodBeat.o(152801);
                return false;
            }
        }
        if (Util.isNullOrNil(str)) {
            str = s.bhK(str2);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.MediaCheckDuplicationStorage", "insert path read md5 failed  path:%s", str2);
                AppMethodBeat.o(152801);
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", str);
        contentValues.put("size", Long.valueOf(j2));
        contentValues.put("path", str2);
        contentValues.put("createtime", Long.valueOf(Util.nowMilliSecond()));
        contentValues.put("status", (Integer) 101);
        long insert = this.db.insert("MediaDuplication", "", contentValues);
        Log.i("MicroMsg.MediaCheckDuplicationStorage", "insert Ret:%d size:%d md5:%s path:%s", Long.valueOf(insert), Long.valueOf(j2), str, str2);
        if (insert > 0) {
            AppMethodBeat.o(152801);
            return true;
        }
        AppMethodBeat.o(152801);
        return false;
    }

    public final String gS(String str, int i2) {
        int boW;
        AppMethodBeat.i(152802);
        if (Util.isNullOrNil(str) || i2 <= 0) {
            Log.e("MicroMsg.MediaCheckDuplicationStorage", "check  md5:%s size:%d", str, Integer.valueOf(i2));
            AppMethodBeat.o(152802);
            return "";
        }
        String str2 = "select path from MediaDuplication where md5 = '" + str + "' and  size = " + i2 + " and status != 100";
        Cursor rawQuery = this.db.rawQuery(str2, null, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.MediaCheckDuplicationStorage", "check query return null sql:%s", str2);
            AppMethodBeat.o(152802);
            return null;
        }
        String str3 = "";
        if (rawQuery.moveToNext()) {
            str3 = rawQuery.getString(0);
        }
        rawQuery.close();
        if (!Util.isNullOrNil(str3) && (boW = (int) s.boW(str3)) <= 0) {
            Log.w("MicroMsg.MediaCheckDuplicationStorage", "check file size is zero, delete db record now. path[%s], fileSize[%d], size[%d]", str3, Integer.valueOf(boW), Integer.valueOf(i2));
            this.db.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str, String.valueOf(i2), "100"});
            str3 = "";
        }
        AppMethodBeat.o(152802);
        return str3;
    }

    public final boolean ar(String str, String str2, int i2) {
        AppMethodBeat.i(152803);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but path is null. [%s, %s] ", str, str2);
            AppMethodBeat.o(152803);
            return false;
        }
        int boW = (int) s.boW(str);
        int boW2 = (int) s.boW(str2);
        if (boW <= 0 || boW2 <= 0) {
            Log.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but file size is zero.[%d, %d]", Integer.valueOf(boW), Integer.valueOf(boW2));
            AppMethodBeat.o(152803);
            return false;
        }
        String bhK = s.bhK(str);
        if (Util.isNullOrNil(bhK)) {
            Log.w("MicroMsg.MediaCheckDuplicationStorage", "import file is not null, but md5 is null, path " + str + " size : " + boW);
            AppMethodBeat.o(152803);
            return false;
        }
        long currentTicks = Util.currentTicks();
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", bhK);
        contentValues.put("size", Integer.valueOf(boW));
        contentValues.put("createtime", Long.valueOf(Util.nowMilliSecond()));
        contentValues.put("remuxing", str2);
        contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i2));
        contentValues.put("status", (Integer) 100);
        long insert = this.db.insert("MediaDuplication", "", contentValues);
        Log.i("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing ret[%d], size[%d], md5[%s], remuxingPath[%s], importPath[%s], duration[%d], cost time[%d]", Long.valueOf(insert), Integer.valueOf(boW), bhK, str2, str, Integer.valueOf(i2), Long.valueOf(Util.ticksToNow(currentTicks)));
        if (insert > 0) {
            AppMethodBeat.o(152803);
            return true;
        }
        AppMethodBeat.o(152803);
        return false;
    }

    public final boolean a(String str, PString pString, PInt pInt) {
        AppMethodBeat.i(152804);
        if (Util.isNullOrNil(str)) {
            Log.d("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but import path is null.");
            AppMethodBeat.o(152804);
            return false;
        }
        int boW = (int) s.boW(str);
        if (boW <= 0) {
            Log.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but file size is zero. path : ".concat(String.valueOf(str)));
            AppMethodBeat.o(152804);
            return false;
        }
        String bhK = s.bhK(str);
        if (Util.isNullOrNil(bhK)) {
            Log.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but md5 is null. path : ".concat(String.valueOf(str)));
            AppMethodBeat.o(152804);
            return false;
        }
        String str2 = "select remuxing, duration from MediaDuplication  where md5 = '" + bhK + "' AND  size = " + boW + " AND status = 100";
        long currentTicks = Util.currentTicks();
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery(str2, null, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                pString.value = rawQuery.getString(0);
                pInt.value = rawQuery.getInt(1);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e2, "", new Object[0]);
            Log.e("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing error: " + e2.toString());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(152804);
            throw th;
        }
        if (Util.isNullOrNil(pString.value)) {
            Log.d("MicroMsg.MediaCheckDuplicationStorage", "it has no remuxing path.");
            AppMethodBeat.o(152804);
            return false;
        } else if (((int) s.boW(pString.value)) <= 0) {
            Log.w("MicroMsg.MediaCheckDuplicationStorage", "remuxing file size is zero, delete db record now. remuxing path : " + pString.value);
            this.db.delete("MediaDuplication", "md5=? AND size=? AND status=?", new String[]{bhK, String.valueOf(boW), "100"});
            pString.value = null;
            AppMethodBeat.o(152804);
            return false;
        } else {
            Log.i("MicroMsg.MediaCheckDuplicationStorage", "check remuxing file success. remuxing path[%s], duration [%d], cost time[%d]", pString.value, Integer.valueOf(pInt.value), Long.valueOf(Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(152804);
            return true;
        }
    }
}
