package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;

public final class d extends MAutoStorage<c> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "IPCallAddressItem")};
    private static final String[] ysF = {"*", "rowid"};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(25547);
        AppMethodBeat.o(25547);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "IPCallAddressItem", null);
        this.db = iSQLiteDatabase;
    }

    public final c aBV(String str) {
        AppMethodBeat.i(25538);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(25538);
            return null;
        }
        Cursor query = this.db.query("IPCallAddressItem", ysF, "contactId=?", new String[]{str}, null, null, null, 2);
        try {
            if (query.moveToFirst()) {
                c cVar = new c();
                cVar.convertFrom(query);
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(25538);
                return cVar;
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(25538);
            return null;
        } catch (Exception e2) {
            Log.e("MicroMsg.IPCallAddressStorage", "getByContactId error: %s", e2.getMessage());
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(25538);
            throw th;
        }
    }

    public final c aBW(String str) {
        AppMethodBeat.i(25539);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(25539);
            return null;
        }
        Cursor query = this.db.query("IPCallAddressItem", ysF, "systemAddressBookUsername=?", new String[]{str}, null, null, null, 2);
        try {
            if (query.moveToFirst()) {
                c cVar = new c();
                cVar.convertFrom(query);
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(25539);
                return cVar;
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(25539);
            return null;
        } catch (Exception e2) {
            Log.d("MicroMsg.IPCallAddressStorage", "getByContactName error: %s", e2.getMessage());
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(25539);
            throw th;
        }
    }

    public final c GR(long j2) {
        AppMethodBeat.i(25540);
        Cursor query = this.db.query("IPCallAddressItem", ysF, "rowid=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
        try {
            if (query.moveToFirst()) {
                c cVar = new c();
                cVar.convertFrom(query);
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(25540);
                return cVar;
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(25540);
            return null;
        } catch (Exception e2) {
            Log.d("MicroMsg.IPCallAddressStorage", "getByLocalId error: %s", e2.getMessage());
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(25540);
            throw th;
        }
    }

    public final ArrayList<c> eaY() {
        AppMethodBeat.i(25541);
        Cursor query = this.db.query("IPCallAddressItem", ysF, null, null, null, null, null, 2);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    ArrayList<c> arrayList = new ArrayList<>();
                    do {
                        c cVar = new c();
                        cVar.convertFrom(query);
                        arrayList.add(cVar);
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.o(25541);
                    return arrayList;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.IPCallAddressStorage", "getAllAddress, error: %s", e2.getMessage());
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(25541);
                return null;
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(25541);
                throw th;
            }
        }
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(25541);
        return null;
    }

    public final Cursor eaZ() {
        AppMethodBeat.i(25542);
        Cursor query = this.db.query("IPCallAddressItem", ysF, null, null, null, null, "upper(sortKey) asc");
        AppMethodBeat.o(25542);
        return query;
    }

    public final Cursor aBX(String str) {
        boolean z;
        String str2;
        Cursor query;
        AppMethodBeat.i(25543);
        System.currentTimeMillis();
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                z = true;
                break;
            } else if (!Character.isDigit(str.charAt(i2))) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            query = aBY(str);
        } else {
            ArrayList<String> aCC = a.aCC(str);
            Cursor aBY = aBY(str);
            try {
                if (aBY.moveToFirst()) {
                    while (!aBY.isAfterLast()) {
                        aCC.add(aBY.getString(aBY.getColumnIndex("contactId")));
                        aBY.moveToNext();
                    }
                }
                if (aBY != null) {
                    aBY.close();
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.IPCallAddressStorage", "getContactIdList error: %s", e2.getMessage());
                if (aBY != null) {
                    aBY.close();
                }
            } catch (Throwable th) {
                if (aBY != null) {
                    aBY.close();
                }
                AppMethodBeat.o(25543);
                throw th;
            }
            String str3 = "";
            Iterator<String> it = aCC.iterator();
            while (true) {
                str2 = str3;
                if (!it.hasNext()) {
                    break;
                }
                str3 = str2 + it.next() + ",";
            }
            if (str2.lastIndexOf(",") >= 0) {
                str2 = str2.substring(0, str2.lastIndexOf(","));
            }
            query = this.db.query("IPCallAddressItem", ysF, "contactId IN ".concat(String.valueOf("(" + str2 + ")")), null, null, null, "upper(sortKey) asc");
        }
        System.currentTimeMillis();
        AppMethodBeat.o(25543);
        return query;
    }

    private Cursor aBY(String str) {
        AppMethodBeat.i(25544);
        Cursor query = this.db.query("IPCallAddressItem", ysF, "systemAddressBookUsername LIKE ? or sortKey LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null, null, "upper(sortKey) asc");
        AppMethodBeat.o(25544);
        return query;
    }

    public final long beginTransaction(long j2) {
        AppMethodBeat.i(25545);
        if (this.db instanceof h) {
            long beginTransaction = ((h) this.db).beginTransaction(j2);
            AppMethodBeat.o(25545);
            return beginTransaction;
        }
        AppMethodBeat.o(25545);
        return -1;
    }

    public final void GS(long j2) {
        AppMethodBeat.i(25546);
        if ((this.db instanceof h) && j2 != -1) {
            ((h) this.db).endTransaction(j2);
        }
        AppMethodBeat.o(25546);
    }
}
