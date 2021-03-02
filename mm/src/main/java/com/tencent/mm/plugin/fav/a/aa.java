package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public interface aa extends IStorage {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(j.info, "FavSearchInfo")};

    void Ea(long j2);

    j Eb(long j2);

    boolean a(j jVar);

    boolean a(j jVar, String... strArr);

    boolean asc(String str);

    ArrayList<Long> b(List<String> list, List<String> list2, List<Integer> list3);
}
