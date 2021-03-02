package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.storage.IAutoStorage;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public interface e extends IAutoStorage<j>, IStorage {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(j.info, "RecordCDNInfo")};

    List<j> Vt(int i2);

    void a(d dVar);

    boolean a(j jVar);

    boolean a(j jVar, String... strArr);

    j aKX(String str);

    void b(d dVar);

    boolean b(j jVar);

    boolean b(j jVar, String... strArr);

    List<j> eIk();
}
