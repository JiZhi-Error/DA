package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;

public final class b extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS bottleinfo1 ( parentclientid text  , childcount int  , bottleid text  PRIMARY KEY , bottletype int  , msgtype int  , voicelen int  , content text  , createtime long  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    public h iFy;

    public b(h hVar) {
        this.iFy = hVar;
    }
}
