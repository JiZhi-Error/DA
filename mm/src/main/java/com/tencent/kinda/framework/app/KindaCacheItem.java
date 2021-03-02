package com.tencent.kinda.framework.app;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dz;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public class KindaCacheItem extends dz {
    private static final String TAG = "MicroMsg.KindaCacheItem";
    public static IAutoDBItem.MAutoDBInfo info = dz.initAutoDBInfo(dz.class);

    static {
        AppMethodBeat.i(18386);
        AppMethodBeat.o(18386);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.dz, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        AppMethodBeat.i(18384);
        ContentValues convertTo = super.convertTo();
        AppMethodBeat.o(18384);
        return convertTo;
    }

    @Override // com.tencent.mm.g.c.dz, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        AppMethodBeat.i(18385);
        super.convertFrom(cursor);
        AppMethodBeat.o(18385);
    }
}
