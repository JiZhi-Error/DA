package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.storage.IAutoStorage;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public interface h extends IAutoStorage<k>, IStorage {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(k.info, "RecordMessageInfo")};

    void Vu(int i2);

    k Vv(int i2);

    List<k> eIl();
}
