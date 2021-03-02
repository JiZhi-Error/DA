package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class cj extends MStorage implements l, g.a {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )"};
    private ISQLiteDatabase db = null;

    public cj(h hVar) {
        this.db = hVar;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final String getTableName() {
        return "role_info";
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.l
    public final ci aEY(String str) {
        ci ciVar = null;
        AppMethodBeat.i(117321);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(117321);
        } else {
            ci ciVar2 = new ci();
            Cursor query = this.db.query("role_info", null, "name LIKE ?", new String[]{"%".concat(String.valueOf(str))}, null, null, null, 2);
            if (query.moveToFirst()) {
                ciVar2.convertFrom(query);
                ciVar = ciVar2;
            }
            query.close();
            AppMethodBeat.o(117321);
        }
        return ciVar;
    }

    private ci bkS(String str) {
        ci ciVar = null;
        AppMethodBeat.i(117322);
        Assert.assertTrue(str != null && str.length() > 0);
        ci ciVar2 = new ci();
        Cursor query = this.db.query("role_info", null, "name= ?", new String[]{str}, null, null, null, 2);
        if (query.moveToFirst()) {
            ciVar2.convertFrom(query);
            ciVar = ciVar2;
        }
        query.close();
        AppMethodBeat.o(117322);
        return ciVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.l
    public final List<ci> eiS() {
        AppMethodBeat.i(117323);
        LinkedList linkedList = new LinkedList();
        Cursor query = this.db.query("role_info", null, "int_reserved1=1", null, null, null, null, 2);
        while (query.moveToNext()) {
            ci ciVar = new ci();
            ciVar.convertFrom(query);
            linkedList.add(ciVar);
        }
        query.close();
        AppMethodBeat.o(117323);
        return linkedList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (r2 != false) goto L_0x001e;
     */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.l
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean has(java.lang.String r7) {
        /*
            r6 = this;
            r1 = 0
            r5 = 117325(0x1ca4d, float:1.64407E-40)
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.mm.storage.ci r3 = r6.bkS(r7)
            if (r3 == 0) goto L_0x0026
            int r2 = r3.OrB
            r4 = 4
            if (r2 != r4) goto L_0x0022
            r2 = r0
        L_0x0014:
            if (r2 != 0) goto L_0x001e
            int r2 = r3.OrB
            r3 = 5
            if (r2 != r3) goto L_0x0024
            r2 = r0
        L_0x001c:
            if (r2 == 0) goto L_0x0026
        L_0x001e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0021:
            return r0
        L_0x0022:
            r2 = r1
            goto L_0x0014
        L_0x0024:
            r2 = r1
            goto L_0x001c
        L_0x0026:
            com.tencent.mm.storage.ci$a r2 = new com.tencent.mm.storage.ci$a
            r2.<init>(r7)
            java.lang.String r3 = ""
            java.lang.String r2 = r2.bkR(r3)
            com.tencent.mm.storage.ci r2 = r6.aEY(r2)
            if (r2 == 0) goto L_0x0044
            java.lang.String r2 = r2.name
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0044
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0021
        L_0x0044:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            r0 = r1
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.cj.has(java.lang.String):boolean");
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.l
    public final void eJ(String str, int i2) {
        AppMethodBeat.i(117326);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            AppMethodBeat.o(117326);
            return;
        }
        if (bkS(str) == null) {
            a(new ci(str, true, i2));
            Log.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(117326);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.l
    public final void bO(String str, boolean z) {
        AppMethodBeat.i(117327);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            AppMethodBeat.o(117327);
            return;
        }
        ci bkS = bkS(str);
        if (bkS == null) {
            a(new ci(str, z, 2));
            Log.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(str)));
            AppMethodBeat.o(117327);
            return;
        }
        bkS.setEnable(z);
        bkS.cSx = 4;
        b(bkS);
        AppMethodBeat.o(117327);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.l
    public final void i(String str, boolean z, boolean z2) {
        int i2 = 2;
        AppMethodBeat.i(117328);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            AppMethodBeat.o(117328);
            return;
        }
        ci bkS = bkS(str);
        if (bkS == null) {
            a(new ci(str, z, 2));
            Log.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(str)));
            AppMethodBeat.o(117328);
            return;
        }
        bkS.setEnable(z);
        if (z2) {
            int i3 = bkS.status;
            if (!z2) {
                i2 = 0;
            }
            bkS.status = i2 | i3;
        } else {
            bkS.status &= -3;
        }
        bkS.cSx = 4;
        b(bkS);
        AppMethodBeat.o(117328);
    }

    private void b(ci ciVar) {
        AppMethodBeat.i(117329);
        ContentValues convertTo = ciVar.convertTo();
        if (convertTo.size() > 0) {
            int update = this.db.update("role_info", convertTo, "name like ?", new String[]{ciVar.name});
            Log.d("MicroMsg.RoleStorage", "update role info, name=" + ciVar.name + ", res:" + update);
            if (update > 0) {
                doNotify();
            }
        }
        AppMethodBeat.o(117329);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.l
    public final void delete(String str) {
        AppMethodBeat.i(117330);
        Assert.assertTrue(str.length() > 0);
        int delete = this.db.delete("role_info", "name=?", new String[]{String.valueOf(str)});
        Log.d("MicroMsg.RoleStorage", "delete name name :" + str + ", res:" + delete);
        if (delete > 0) {
            doNotify();
        }
        AppMethodBeat.o(117330);
    }

    private void a(ci ciVar) {
        AppMethodBeat.i(117324);
        ciVar.cSx = c.CTRL_INDEX;
        ContentValues convertTo = ciVar.convertTo();
        if (convertTo.size() > 0 && this.db.insert("role_info", "id", convertTo) != 0) {
            doNotify();
        }
        AppMethodBeat.o(117324);
    }
}
