package com.tencent.mm.plugin.appbrand.ab;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoDBFieldAnnotation;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a extends MAutoStorage<C0532a> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(C0532a.kLR, "AppBrandCommonKVBinaryData")};

    static {
        AppMethodBeat.i(48359);
        AppMethodBeat.o(48359);
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, C0532a.kLR, "AppBrandCommonKVBinaryData", null);
    }

    public final void clear(String str) {
        AppMethodBeat.i(48355);
        C0532a aVar = new C0532a();
        aVar.field_key = str;
        aVar.field_value = new byte[0];
        super.replace(aVar);
        AppMethodBeat.o(48355);
    }

    public final void l(String str, byte[] bArr) {
        AppMethodBeat.i(48356);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(48356);
            return;
        }
        C0532a aVar = new C0532a();
        aVar.field_key = str;
        aVar.field_value = bArr;
        super.replace(aVar);
        AppMethodBeat.o(48356);
    }

    public final byte[] get(String str) {
        AppMethodBeat.i(48357);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(48357);
            return null;
        }
        C0532a aVar = new C0532a();
        aVar.field_key = str;
        if (super.get(aVar, new String[0])) {
            byte[] bArr = aVar.field_value;
            AppMethodBeat.o(48357);
            return bArr;
        }
        AppMethodBeat.o(48357);
        return null;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ab.a$a  reason: collision with other inner class name */
    static final class C0532a extends IAutoDBItem {
        static final IAutoDBItem.MAutoDBInfo kLR = initAutoDBInfo(C0532a.class);
        @MAutoDBFieldAnnotation(defValue = "$$invalid", primaryKey = 1)
        public String field_key;
        public byte[] field_value;

        C0532a() {
        }

        @Override // com.tencent.mm.sdk.storage.IAutoDBItem
        public final IAutoDBItem.MAutoDBInfo getDBInfo() {
            return kLR;
        }

        @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
        public final void convertFrom(Cursor cursor) {
            AppMethodBeat.i(48352);
            this.field_key = cursor.getString(0);
            this.field_value = cursor.getBlob(1);
            AppMethodBeat.o(48352);
        }

        @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
        public final ContentValues convertTo() {
            AppMethodBeat.i(48353);
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("key", this.field_key);
            contentValues.put("value", this.field_value);
            AppMethodBeat.o(48353);
            return contentValues;
        }

        static {
            AppMethodBeat.i(48354);
            AppMethodBeat.o(48354);
        }
    }
}
