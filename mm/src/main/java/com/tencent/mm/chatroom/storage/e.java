package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.dm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends dm {
    protected static IAutoDBItem.MAutoDBInfo info;
    public LinkedList<GroupToolItem> gtw = new LinkedList<>();
    public LinkedList<GroupToolItem> gtx = new LinkedList<>();

    public e() {
        AppMethodBeat.i(182154);
        this.field_queryState = 0;
        AppMethodBeat.o(182154);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.dm, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(182155);
        super.convertFrom(cursor);
        this.gtw.clear();
        if (!Util.isNullOrNil(this.field_stickToollist)) {
            try {
                JSONArray jSONArray = new JSONArray(this.field_stickToollist);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = new JSONObject(jSONArray.getString(i2));
                    GroupToolItem groupToolItem = new GroupToolItem();
                    groupToolItem.username = Util.nullAs(jSONObject.getString(ch.COL_USERNAME), "");
                    groupToolItem.path = Util.nullAs(jSONObject.getString("path"), "");
                    this.gtw.add(groupToolItem);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.roomtools.GroupTools", "parseStickTools() Exception:%s", e2.getMessage());
            }
        }
        this.gtx.clear();
        if (!Util.isNullOrNil(this.field_recentUseToolList)) {
            try {
                JSONArray jSONArray2 = new JSONArray(this.field_recentUseToolList);
                int length2 = jSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i3));
                    GroupToolItem groupToolItem2 = new GroupToolItem();
                    groupToolItem2.username = Util.nullAs(jSONObject2.getString(ch.COL_USERNAME), "");
                    groupToolItem2.path = Util.nullAs(jSONObject2.getString("path"), "");
                    groupToolItem2.crj = jSONObject2.getLong(ch.COL_UPDATETIME);
                    this.gtx.add(groupToolItem2);
                }
                AppMethodBeat.o(182155);
                return;
            } catch (Exception e3) {
                Log.e("MicroMsg.roomtools.GroupTools", "parseRecentUseTools() Exception:%s", e3.getMessage());
            }
        }
        AppMethodBeat.o(182155);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(182156);
        if (Util.isEqual(((e) obj).field_chatroomname, this.field_chatroomname)) {
            AppMethodBeat.o(182156);
            return true;
        }
        AppMethodBeat.o(182156);
        return false;
    }

    public final void a(GroupToolItem groupToolItem) {
        AppMethodBeat.i(194060);
        if (this.gtx.contains(groupToolItem)) {
            this.gtx.remove(groupToolItem);
        }
        this.gtx.add(groupToolItem);
        Collections.sort(this.gtx, new Comparator<GroupToolItem>() {
            /* class com.tencent.mm.chatroom.storage.e.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(GroupToolItem groupToolItem, GroupToolItem groupToolItem2) {
                AppMethodBeat.i(185973);
                int compare = Long.compare(groupToolItem2.crj, groupToolItem.crj);
                AppMethodBeat.o(185973);
                return compare;
            }
        });
        if (this.gtx.size() > 20) {
            this.gtx.remove(this.gtx.size() - 1);
        }
        this.field_recentUseToolList = W(this.gtx);
        AppMethodBeat.o(194060);
    }

    public final boolean amo() {
        AppMethodBeat.i(182157);
        if (this.gtw.size() >= 8) {
            AppMethodBeat.o(182157);
            return true;
        }
        AppMethodBeat.o(182157);
        return false;
    }

    public static String W(List<GroupToolItem> list) {
        AppMethodBeat.i(182158);
        JSONArray jSONArray = new JSONArray();
        try {
            for (GroupToolItem groupToolItem : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ch.COL_USERNAME, groupToolItem.username);
                jSONObject.put("path", groupToolItem.path);
                jSONObject.put(ch.COL_UPDATETIME, groupToolItem.crj);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.roomtools.GroupTools", "getToolsJsonStr() Exception:%s", e2.getMessage());
        }
        String jSONArray2 = jSONArray.toString();
        AppMethodBeat.o(182158);
        return jSONArray2;
    }

    static {
        AppMethodBeat.i(182159);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "chatroomname";
        mAutoDBInfo.colsMap.put("chatroomname", "TEXT PRIMARY KEY ");
        sb.append(" chatroomname TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "chatroomname";
        mAutoDBInfo.columns[1] = "stickToollist";
        mAutoDBInfo.colsMap.put("stickToollist", "TEXT");
        sb.append(" stickToollist TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "recentUseToolList";
        mAutoDBInfo.colsMap.put("recentUseToolList", "TEXT");
        sb.append(" recentUseToolList TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "queryState";
        mAutoDBInfo.colsMap.put("queryState", "INTEGER");
        sb.append(" queryState INTEGER");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(182159);
    }
}
