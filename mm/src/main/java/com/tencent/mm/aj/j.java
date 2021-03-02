package com.tencent.mm.aj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import java.util.List;
import junit.framework.Assert;

public final class j extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )"};
    h iFy;
    final f<String, i> iLa = new c(800);

    public j(h hVar) {
        AppMethodBeat.i(150287);
        this.iFy = hVar;
        AppMethodBeat.o(150287);
    }

    public final i Mx(String str) {
        i iVar;
        AppMethodBeat.i(150288);
        i aT = this.iLa.aT(str);
        if (aT == null || !aT.getUsername().equals(str)) {
            Cursor rawQuery = this.iFy.rawQuery("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + Util.escapeSqlValue(str) + "\"", null, 2);
            if (rawQuery == null) {
                AppMethodBeat.o(150288);
                return null;
            }
            if (rawQuery.moveToFirst()) {
                iVar = new i();
                iVar.convertFrom(rawQuery);
            } else {
                iVar = null;
            }
            rawQuery.close();
            this.iLa.x(str, iVar);
            AppMethodBeat.o(150288);
            return iVar;
        }
        AppMethodBeat.o(150288);
        return aT;
    }

    public final boolean b(i iVar) {
        AppMethodBeat.i(150289);
        Log.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", iVar.aYu(), iVar.aYt());
        i Mx = Mx(iVar.getUsername());
        if (Mx == null) {
            this.iLa.x(iVar.getUsername(), iVar);
            boolean c2 = c(iVar);
            AppMethodBeat.o(150289);
            return c2;
        }
        Log.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", Mx.aYu(), Mx.aYt());
        this.iLa.remove(iVar.getUsername());
        boolean d2 = d(iVar);
        AppMethodBeat.o(150289);
        return d2;
    }

    public final boolean av(List<i> list) {
        boolean z;
        AppMethodBeat.i(150290);
        if (list.size() == 0) {
            AppMethodBeat.o(150290);
            return false;
        }
        long beginTransaction = this.iFy.beginTransaction(Thread.currentThread().getId());
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                b(list.get(i2));
            } catch (Exception e2) {
                Log.e("MicroMsg.ImgFlagStorage", e2.getMessage());
                z = false;
            }
        }
        z = true;
        this.iFy.endTransaction(beginTransaction);
        AppMethodBeat.o(150290);
        return z;
    }

    private boolean c(i iVar) {
        boolean z = true;
        AppMethodBeat.i(150291);
        Assert.assertTrue((iVar == null || iVar.getUsername() == null) ? false : true);
        iVar.iKV = (int) (System.currentTimeMillis() / 1000);
        iVar.aYv();
        iVar.cSx = -1;
        if (((int) this.iFy.insert("img_flag", ch.COL_USERNAME, iVar.aYq())) < 0) {
            z = false;
        }
        if (z) {
            doNotify(iVar.getUsername(), 2, iVar.getUsername());
        }
        AppMethodBeat.o(150291);
        return z;
    }

    private boolean d(i iVar) {
        boolean z = true;
        AppMethodBeat.i(150292);
        Assert.assertTrue((iVar == null || iVar.getUsername() == null) ? false : true);
        iVar.iKV = (int) (System.currentTimeMillis() / 1000);
        iVar.cSx |= 4;
        if (this.iFy.update("img_flag", iVar.aYq(), "username=?", new String[]{iVar.getUsername()}) <= 0) {
            z = false;
        }
        if (z) {
            doNotify(iVar.getUsername(), 3, iVar.getUsername());
        }
        AppMethodBeat.o(150292);
        return z;
    }

    public final void My(String str) {
        AppMethodBeat.i(150293);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150293);
            return;
        }
        this.iLa.remove(str);
        this.iFy.delete("img_flag", "username=?", new String[]{String.valueOf(str)});
        AppMethodBeat.o(150293);
    }
}
