package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gv;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class cn extends gv {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public cn(String str) {
        this();
        AppMethodBeat.i(43302);
        this.field_conRemark = "";
        this.field_encryptUsername = str == null ? "" : str;
        AppMethodBeat.o(43302);
    }

    public cn(String str, String str2) {
        this();
        AppMethodBeat.i(43303);
        this.field_encryptUsername = str == null ? "" : str;
        this.field_conRemark = str2 == null ? "" : str2;
        AppMethodBeat.o(43303);
    }

    public cn() {
        AppMethodBeat.i(43304);
        this.field_encryptUsername = "";
        this.field_conRemark = "";
        AppMethodBeat.o(43304);
    }

    public final String ajB() {
        return this.field_encryptUsername;
    }

    public final String ajy() {
        return this.field_conRemark;
    }

    /* access modifiers changed from: protected */
    public final Object clone() {
        AppMethodBeat.i(43305);
        Object clone = super.clone();
        AppMethodBeat.o(43305);
        return clone;
    }

    static {
        AppMethodBeat.i(43306);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "encryptUsername";
        mAutoDBInfo.colsMap.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
        sb.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "encryptUsername";
        mAutoDBInfo.columns[1] = "conRemark";
        mAutoDBInfo.colsMap.put("conRemark", "TEXT default '' ");
        sb.append(" conRemark TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "contactLabels";
        mAutoDBInfo.colsMap.put("contactLabels", "TEXT default '' ");
        sb.append(" contactLabels TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "conDescription";
        mAutoDBInfo.colsMap.put("conDescription", "TEXT default '' ");
        sb.append(" conDescription TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "conPhone";
        mAutoDBInfo.colsMap.put("conPhone", "TEXT default '' ");
        sb.append(" conPhone TEXT default '' ");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(43306);
    }
}
