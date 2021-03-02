package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;

public interface s extends IStorage {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(e.info, "FavConfigInfo")};

    void bE(byte[] bArr);

    byte[] cUN();
}
