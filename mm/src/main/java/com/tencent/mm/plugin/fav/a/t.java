package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public interface t extends IStorage {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(f.info, "FavEditInfo")};

    f DX(long j2);

    boolean a(f fVar);

    boolean a(f fVar, String... strArr);

    List<f> cUO();

    void y(long j2, int i2);
}
