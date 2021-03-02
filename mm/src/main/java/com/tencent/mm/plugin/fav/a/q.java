package com.tencent.mm.plugin.fav.a;

import android.database.Cursor;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;

public interface q extends IStorage {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "FavCdnInfo")};

    List<c> DT(long j2);

    List<c> DU(long j2);

    void DV(long j2);

    boolean DW(long j2);

    void a(p pVar);

    boolean a(c cVar, String... strArr);

    c asa(String str);

    void b(p pVar);

    boolean b(c cVar, String... strArr);

    LinkedList<c> cUK();

    Cursor cUL();

    Cursor cUM();

    boolean f(c cVar);

    void startAll();

    int x(long j2, int i2);

    void y(g gVar);
}
