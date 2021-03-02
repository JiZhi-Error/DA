package com.tencent.mm.storage;

import com.tencent.mm.plugin.messenger.foundation.a.a.p;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;

public final class ct extends MStorage implements p {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS verifycontact ( id INTEGER PRIMARY KEY, username varchar(40), nickname varchar(40), fullpy varchar(60), shortpy varchar(40), imgflag int, scene int, content text, status int, reserved1 int,reserved2 int,reserved3 text,reserved4 text)", "CREATE UNIQUE INDEX IF NOT EXISTS verifyContactIndex  ON verifycontact ( username )"};
    private h iFy;

    public ct(h hVar) {
        this.iFy = hVar;
    }
}
