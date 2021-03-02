package com.tencent.kinda.framework.app;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ea;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public class KindaConfigCacheItem extends ea {
    private static final String TAG = "MicroMsg.KindaConfigCacheItem";
    public static final int TYPE_BOOLEAN = 4;
    public static final int TYPE_BYTE = 7;
    public static final int TYPE_DOUBLE = 6;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_INT = 1;
    public static final int TYPE_LONG = 2;
    public static final int TYPE_STRING = 3;
    public static IAutoDBItem.MAutoDBInfo info = ea.initAutoDBInfo(ea.class);

    static {
        AppMethodBeat.i(18392);
        AppMethodBeat.o(18392);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.ea, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        AppMethodBeat.i(18390);
        ContentValues convertTo = super.convertTo();
        AppMethodBeat.o(18390);
        return convertTo;
    }

    @Override // com.tencent.mm.g.c.ea, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        AppMethodBeat.i(18391);
        super.convertFrom(cursor);
        AppMethodBeat.o(18391);
    }
}
