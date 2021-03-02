package com.tencent.mm.plugin.sport.model;

import android.database.MatrixCursor;
import android.os.Bundle;

public final class h extends MatrixCursor {
    private Bundle dQL;

    public h(String[] strArr, Bundle bundle) {
        super(strArr);
        this.dQL = bundle;
    }

    public final Bundle getExtras() {
        return this.dQL;
    }
}
