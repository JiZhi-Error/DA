package com.tencent.mm.plugin.account.security.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fv;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class d extends fv {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public d() {
        this.field_uid = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.field_name = "";
        this.field_devicetype = "";
        this.field_createtime = 0;
    }

    public d(ckf ckf) {
        AppMethodBeat.i(125519);
        this.field_uid = ckf.uuid;
        this.field_devicetype = ckf.devicetype;
        this.field_name = ckf.devicename;
        this.field_createtime = (long) ckf.MpC;
        AppMethodBeat.o(125519);
    }

    static {
        AppMethodBeat.i(125520);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "uid";
        mAutoDBInfo.colsMap.put("uid", "TEXT default ''  PRIMARY KEY ");
        sb.append(" uid TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "uid";
        mAutoDBInfo.columns[1] = "name";
        mAutoDBInfo.colsMap.put("name", "TEXT default '' ");
        sb.append(" name TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "devicetype";
        mAutoDBInfo.colsMap.put("devicetype", "TEXT default '' ");
        sb.append(" devicetype TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "createtime";
        mAutoDBInfo.colsMap.put("createtime", "LONG default '0' ");
        sb.append(" createtime LONG default '0' ");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(125520);
    }
}
