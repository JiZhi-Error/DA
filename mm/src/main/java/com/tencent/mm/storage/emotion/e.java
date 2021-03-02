package com.tencent.mm.storage.emotion;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;

public final class e extends MAutoStorage<d> implements g.a {
    private static final String[] INDEX_CREATE = {"create index if not exists descGroupIdIndex on EmojiInfoDesc ( groupId )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(d.info, "EmojiInfoDesc")};
    public SharedPreferences OsE;
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(d dVar) {
        boolean z;
        AppMethodBeat.i(105056);
        d dVar2 = dVar;
        if (dVar2 != null) {
            if (dVar2.getMd5().length() == 32) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                dVar2.field_md5_lang = dVar2.field_md5 + dVar2.field_lang;
                long replace = this.db.replace("EmojiInfoDesc", "md5_lang", dVar2.convertTo());
                if (replace != -1) {
                    doNotify(dVar2.getMd5());
                }
                if (replace >= 0) {
                    AppMethodBeat.o(105056);
                    return true;
                }
                AppMethodBeat.o(105056);
                return false;
            }
        }
        AppMethodBeat.o(105056);
        return false;
    }

    static {
        AppMethodBeat.i(105057);
        AppMethodBeat.o(105057);
    }

    public e(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, d.info, "EmojiInfoDesc", INDEX_CREATE);
    }

    private e(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str, String[] strArr) {
        super(iSQLiteDatabase, mAutoDBInfo, str, strArr);
        AppMethodBeat.i(105050);
        this.db = iSQLiteDatabase;
        this.OsE = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext());
        AppMethodBeat.o(105050);
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final String amp(String str) {
        AppMethodBeat.i(105051);
        String str2 = null;
        String format = String.format("select %s from %s where %s=?", "desc", "EmojiInfoDesc", "md5_lang");
        Cursor rawQuery = this.db.rawQuery(format, new String[]{str + LocaleUtil.getApplicationLanguage().toLowerCase()}, 2);
        if (rawQuery.moveToFirst()) {
            str2 = rawQuery.getString(rawQuery.getColumnIndex("desc"));
        }
        rawQuery.close();
        if (!Util.isNullOrNil(str2)) {
            AppMethodBeat.o(105051);
        } else {
            Cursor rawQuery2 = this.db.rawQuery(format, new String[]{str + BuildConfig.KINDA_DEFAULT}, 2);
            if (rawQuery2.moveToFirst()) {
                str2 = rawQuery2.getString(rawQuery2.getColumnIndex("desc"));
            }
            rawQuery2.close();
            AppMethodBeat.o(105051);
        }
        return str2;
    }

    public final boolean blf(String str) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(105052);
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery(String.format("select %s from %s where %s=?", "click_flag", "EmojiInfoDesc", "groupId"), new String[]{str}, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                if ((rawQuery.getInt(rawQuery.getColumnIndex("click_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", e2.toString());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(105052);
            throw th;
        }
        AppMethodBeat.o(105052);
        return z2;
    }

    public final boolean blg(String str) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(105053);
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery(String.format("select %s from %s where %s=?", "download_flag", "EmojiInfoDesc", "groupId"), new String[]{str}, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                if ((rawQuery.getInt(rawQuery.getColumnIndex("download_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", e2.toString());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(105053);
            throw th;
        }
        AppMethodBeat.o(105053);
        return z2;
    }

    private boolean blh(String str) {
        boolean z = false;
        AppMethodBeat.i(105054);
        if (b.anh(str)) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = this.db.rawQuery(String.format("select %s from %s where %s=?", "desc", "EmojiInfoDesc", "groupId"), new String[]{str}, 2);
                if (rawQuery != null && rawQuery.moveToFirst()) {
                    z = true;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.emoji.EmojiInfoDescStorage", e2.toString());
                if (0 != 0) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                AppMethodBeat.o(105054);
                throw th;
            }
        }
        AppMethodBeat.o(105054);
        return z;
    }

    public final boolean bli(String str) {
        AppMethodBeat.i(199822);
        if (b.anh(str)) {
            long j2 = this.OsE.getLong("274544".concat(String.valueOf(str)), 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j2 >= Util.MILLSECONDS_OF_DAY) {
                AppMethodBeat.o(199822);
                return true;
            } else if (!blh(str) && currentTimeMillis - j2 >= Util.MILLSECONDS_OF_HOUR) {
                AppMethodBeat.o(199822);
                return true;
            }
        }
        AppMethodBeat.o(199822);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.tencent.mm.storage.emotion.d> blj(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.e.blj(java.lang.String):java.util.ArrayList");
    }
}
