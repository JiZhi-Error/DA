package com.tencent.mm.plugin.festival.model;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.il;
import com.tencent.mm.plugin.festival.b.c;
import com.tencent.mm.plugin.festival.c.e;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class ai extends il {
    protected static final IAutoDBItem.MAutoDBInfo iBg;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    public final void c(c cVar) {
        AppMethodBeat.i(261962);
        this.field_wishId = cVar.UAv;
        this.field_x = cVar.x;
        this.field_y = cVar.y;
        this.field_wishText = cVar.text;
        this.field_nickName = cVar.nickname;
        this.field_headImgUrl = cVar.gzC;
        this.field_createTime = e.awJ(cVar.createtime);
        if (!TextUtils.isEmpty(cVar.username)) {
            this.field_userName = cVar.username;
        }
        if (!TextUtils.isEmpty(cVar.UAz)) {
            this.field_liveEncUsername = cVar.UAz;
        }
        if (!TextUtils.isEmpty(cVar.UAB)) {
            this.field_hashUsername = cVar.UAB;
        }
        this.field_delFlag = cVar.UAu;
        this.field_country = cVar.country;
        this.field_province = cVar.fuJ;
        this.field_city = cVar.fuK;
        AppMethodBeat.o(261962);
    }

    static {
        AppMethodBeat.i(261963);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[15];
        mAutoDBInfo.columns = new String[16];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "wishId";
        mAutoDBInfo.colsMap.put("wishId", "TEXT PRIMARY KEY ");
        sb.append(" wishId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "wishId";
        mAutoDBInfo.columns[1] = "x";
        mAutoDBInfo.colsMap.put("x", "INTEGER");
        sb.append(" x INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "y";
        mAutoDBInfo.colsMap.put("y", "INTEGER");
        sb.append(" y INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "wishText";
        mAutoDBInfo.colsMap.put("wishText", "TEXT");
        sb.append(" wishText TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "nickName";
        mAutoDBInfo.colsMap.put("nickName", "TEXT");
        sb.append(" nickName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "headImgUrl";
        mAutoDBInfo.colsMap.put("headImgUrl", "TEXT");
        sb.append(" headImgUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "userName";
        mAutoDBInfo.colsMap.put("userName", "TEXT");
        sb.append(" userName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "liveEncUsername";
        mAutoDBInfo.colsMap.put("liveEncUsername", "TEXT");
        sb.append(" liveEncUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "delFlag";
        mAutoDBInfo.colsMap.put("delFlag", "INTEGER");
        sb.append(" delFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = UserDataStore.COUNTRY;
        mAutoDBInfo.colsMap.put(UserDataStore.COUNTRY, "TEXT");
        sb.append(" country TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "province";
        mAutoDBInfo.colsMap.put("province", "TEXT");
        sb.append(" province TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "city";
        mAutoDBInfo.colsMap.put("city", "TEXT");
        sb.append(" city TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "likeCount";
        mAutoDBInfo.colsMap.put("likeCount", "LONG");
        sb.append(" likeCount LONG");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "hashUsername";
        mAutoDBInfo.colsMap.put("hashUsername", "TEXT");
        sb.append(" hashUsername TEXT");
        mAutoDBInfo.columns[15] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        AppMethodBeat.o(261963);
    }
}
