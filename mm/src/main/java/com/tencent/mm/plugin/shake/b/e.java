package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tenpay.android.wechat.PayuSecureEncrypt;

public final class e extends MAutoStorage<d> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(d.info, "shakeitem1")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(d dVar) {
        AppMethodBeat.i(28126);
        boolean a2 = a(dVar, false);
        AppMethodBeat.o(28126);
        return a2;
    }

    static {
        AppMethodBeat.i(28127);
        AppMethodBeat.o(28127);
    }

    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, d.info, "shakeitem1", null);
        AppMethodBeat.i(28109);
        this.db = iSQLiteDatabase;
        Log.d("MicroMsg.NewShakeItemStorage", "ShakeItemStorage");
        iSQLiteDatabase.execSQL("shakeitem1", "DROP INDEX IF EXISTS shakeItemUsernameIndex ");
        iSQLiteDatabase.execSQL("shakeitem1", "CREATE INDEX IF NOT EXISTS shakeItemNewUsernameIndex ON shakeitem1 ( username )");
        AppMethodBeat.o(28109);
    }

    public final Cursor eTS() {
        AppMethodBeat.i(28110);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]);
        AppMethodBeat.o(28110);
        return rawQuery;
    }

    public final Cursor eTT() {
        AppMethodBeat.i(28111);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", AppEventsConstants.EVENT_PARAM_VALUE_NO, "2");
        AppMethodBeat.o(28111);
        return rawQuery;
    }

    public final Cursor eTU() {
        AppMethodBeat.i(28112);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(28112);
        return rawQuery;
    }

    public final Cursor eTV() {
        AppMethodBeat.i(28113);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by shakeItemID desc ", "4");
        AppMethodBeat.o(28113);
        return rawQuery;
    }

    public final Cursor eTW() {
        AppMethodBeat.i(28114);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", "4", "2");
        AppMethodBeat.o(28114);
        return rawQuery;
    }

    public final Cursor eTX() {
        AppMethodBeat.i(28115);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", "7", "6", "8", "9", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "12");
        AppMethodBeat.o(28115);
        return rawQuery;
    }

    public final Cursor eTY() {
        AppMethodBeat.i(28116);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", "8", "2");
        AppMethodBeat.o(28116);
        return rawQuery;
    }

    public final Cursor Xt(int i2) {
        AppMethodBeat.i(28117);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", "11", String.valueOf(i2));
        AppMethodBeat.o(28117);
        return rawQuery;
    }

    public final Cursor eTZ() {
        AppMethodBeat.i(28118);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", "11");
        AppMethodBeat.o(28118);
        return rawQuery;
    }

    public final d eUa() {
        AppMethodBeat.i(28119);
        d dVar = new d();
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc limit 1", new String[0]);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            dVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(28119);
        return dVar;
    }

    public final boolean a(d dVar, boolean z) {
        AppMethodBeat.i(28120);
        if (dVar == null) {
            AppMethodBeat.o(28120);
            return false;
        }
        if (!z && !Util.isNullOrNil(dVar.field_username)) {
            aNj(dVar.field_username);
        }
        dVar.cSx = -1;
        boolean insert = super.insert(dVar);
        AppMethodBeat.o(28120);
        return insert;
    }

    public final int Xu(int i2) {
        AppMethodBeat.i(28121);
        int delete = this.db.delete("shakeitem1", "shakeItemID=?", new String[]{String.valueOf(i2)});
        doNotify();
        Log.i("MicroMsg.NewShakeItemStorage", "delById id:" + i2 + " result:" + delete);
        AppMethodBeat.o(28121);
        return delete;
    }

    public final int aNj(String str) {
        AppMethodBeat.i(28122);
        int delete = this.db.delete("shakeitem1", "(username=?)", new String[]{String.valueOf(str)});
        if (delete > 0) {
            doNotify();
        }
        Log.i("MicroMsg.NewShakeItemStorage", "delByusername:" + str + " result:" + delete);
        AppMethodBeat.o(28122);
        return delete;
    }

    public final boolean Xv(int i2) {
        boolean execSQL;
        AppMethodBeat.i(28123);
        if (i2 == 0) {
            execSQL = this.db.execSQL("shakeitem1", "delete from shakeitem1 where type = " + i2 + " or type is null");
        } else {
            execSQL = this.db.execSQL("shakeitem1", "delete from shakeitem1 where type = ".concat(String.valueOf(i2)));
        }
        doNotify();
        AppMethodBeat.o(28123);
        return execSQL;
    }

    public final boolean eUb() {
        AppMethodBeat.i(28124);
        boolean execSQL = this.db.execSQL("shakeitem1", "delete from shakeitem1");
        doNotify();
        AppMethodBeat.o(28124);
        return execSQL;
    }

    public final void eUc() {
        AppMethodBeat.i(28125);
        Log.i("MicroMsg.NewShakeItemStorage", "setAllOld");
        d dVar = new d();
        dVar.field_insertBatch = 0;
        dVar.cSx = 1024;
        if (-1 != this.db.update("shakeitem1", dVar.convertTo(), "insertBatch!=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO})) {
            doNotify();
        }
        AppMethodBeat.o(28125);
    }
}
