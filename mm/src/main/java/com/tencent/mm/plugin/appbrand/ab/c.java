package com.tencent.mm.plugin.appbrand.ab;

import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public abstract class c<_Model extends IAutoDBItem & b> extends MAutoStorage<_Model> {
    public c(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str, String[] strArr) {
        super(iSQLiteDatabase, mAutoDBInfo, str, strArr);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public boolean insertNotify(_Model _model, boolean z) {
        super.insertNotify(_model, z);
        return get(_model, new String[0]);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public boolean delete(_Model _model, boolean z, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = _model.getKeys();
        }
        return super.delete(_model, z, strArr);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public boolean updateNotify(_Model _model, boolean z, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = _model.getKeys();
        }
        return super.updateNotify(_model, z, strArr);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public boolean get(_Model _model, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = _model.getKeys();
        }
        return super.get(_model, strArr);
    }
}
