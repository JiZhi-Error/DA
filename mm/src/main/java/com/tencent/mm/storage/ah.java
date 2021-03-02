package com.tencent.mm.storage;

import android.database.Cursor;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.k.a.a.a;
import com.tencent.mm.k.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ah extends au {
    protected static IAutoDBItem.MAutoDBInfo info;
    private a NRC = new a();
    public a NRD = this.NRC;
    private List<String> NRE = new LinkedList();
    private Map<String, b> iPG = new ConcurrentHashMap();

    public ah() {
        AppMethodBeat.i(43135);
        AppMethodBeat.o(43135);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.au, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(225980);
        super.convertFrom(cursor);
        if (this.field_roomInfoDetailResByte != null && this.field_roomInfoDetailResByte.length > 0) {
            Log.i("MicroMsg.ChatRoomMember", "handleGetRoomInfoResUnKnownField saveByteVersion:%s handleByteVersion:%s byte:%s", this.field_saveByteVersion, this.field_handleByteVersion, Integer.valueOf(this.field_roomInfoDetailResByte.length));
        }
        AppMethodBeat.o(225980);
    }

    public final a gBr() {
        AppMethodBeat.i(43136);
        if (b(this.NRD)) {
            gBs();
        }
        a aVar = this.NRD;
        AppMethodBeat.o(43136);
        return aVar;
    }

    public final List<String> bax() {
        AppMethodBeat.i(43137);
        if (this.NRE == null || this.NRE.size() == 0) {
            this.NRE = bji(this.field_memberlist);
        }
        List<String> list = this.NRE;
        AppMethodBeat.o(43137);
        return list;
    }

    private void a(a aVar) {
        AppMethodBeat.i(43138);
        if (this.field_roomdata == null) {
            aVar = new a();
        }
        Iterator<b> it = aVar.gCs.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!(next == null || next.userName == null)) {
                this.iPG.put(next.userName, next);
            }
        }
        AppMethodBeat.o(43138);
    }

    public final void gBs() {
        AppMethodBeat.i(43139);
        if (Util.isNullOrNil(this.field_roomdata)) {
            AppMethodBeat.o(43139);
            return;
        }
        try {
            this.NRD = (a) new a().parseFrom(this.field_roomdata);
        } catch (Exception e2) {
            this.NRD = new a();
        }
        a(this.NRD);
        AppMethodBeat.o(43139);
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(43140);
        if (this.NRC.computeSize() == aVar.computeSize()) {
            AppMethodBeat.o(43140);
            return true;
        }
        AppMethodBeat.o(43140);
        return false;
    }

    public final b bje(String str) {
        AppMethodBeat.i(43141);
        if (this.iPG == null) {
            Log.e("MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!");
            AppMethodBeat.o(43141);
            return null;
        }
        if (this.iPG.size() <= 0) {
            gBs();
        }
        b bVar = this.iPG.get(str);
        AppMethodBeat.o(43141);
        return bVar;
    }

    public final int gBt() {
        AppMethodBeat.i(43142);
        if (b(this.NRD)) {
            gBs();
        }
        int i2 = this.NRD.dTg;
        AppMethodBeat.o(43142);
        return i2;
    }

    public final void akd(int i2) {
        AppMethodBeat.i(43143);
        if (b(this.NRD)) {
            gBs();
        }
        this.NRD.dTg = i2;
        try {
            this.field_roomdata = this.NRD.toByteArray();
            AppMethodBeat.o(43143);
        } catch (Exception e2) {
            Log.e("MicroMsg.ChatRoomMember", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(43143);
        }
    }

    public final boolean gBu() {
        AppMethodBeat.i(43144);
        if (b(this.NRD)) {
            gBs();
        }
        if (this.NRD.dTg < this.NRD.gCu) {
            AppMethodBeat.o(43144);
            return true;
        }
        AppMethodBeat.o(43144);
        return false;
    }

    public final void oS(int i2) {
        AppMethodBeat.i(43145);
        if (b(this.NRD)) {
            gBs();
        }
        this.field_chatroomdataflag = (this.NRD.cSx & -3) | (i2 & 2);
        AppMethodBeat.o(43145);
    }

    public final int gBv() {
        AppMethodBeat.i(43146);
        if (b(this.NRD)) {
            gBs();
        }
        int i2 = this.NRD.type;
        AppMethodBeat.o(43146);
        return i2;
    }

    public final boolean bjf(String str) {
        AppMethodBeat.i(43147);
        b bje = bje(str);
        if (bje == null) {
            AppMethodBeat.o(43147);
            return false;
        } else if ((bje.gCw & 2048) != 0) {
            AppMethodBeat.o(43147);
            return true;
        } else {
            AppMethodBeat.o(43147);
            return false;
        }
    }

    public final int gBw() {
        AppMethodBeat.i(43148);
        if (b(this.NRD)) {
            gBs();
        }
        int i2 = this.NRD.maxCount;
        AppMethodBeat.o(43148);
        return i2;
    }

    public final String bjg(String str) {
        AppMethodBeat.i(43149);
        b bje = bje(str);
        if (bje == null) {
            AppMethodBeat.o(43149);
            return "";
        }
        String nullAs = Util.nullAs(bje.gCx, "");
        AppMethodBeat.o(43149);
        return nullAs;
    }

    public final String getDisplayName(String str) {
        AppMethodBeat.i(43150);
        b bje = bje(str);
        if (bje == null) {
            AppMethodBeat.o(43150);
            return "";
        }
        String nullAs = Util.nullAs(bje.gCv, "");
        AppMethodBeat.o(43150);
        return nullAs;
    }

    public final ah AL(boolean z) {
        this.field_isShowname = z ? 1 : 0;
        return this;
    }

    public final boolean gBx() {
        return this.field_isShowname > 0;
    }

    private static int aPN(String str) {
        int i2 = 0;
        AppMethodBeat.i(43151);
        try {
            i2 = Util.getInt(str, 0);
        } catch (Exception e2) {
            if (str != null) {
                Log.e("MicroMsg.ChatRoomMember", "parserInt error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(43151);
        return i2;
    }

    private static a bjh(String str) {
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(43152);
        a aVar = new a();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43152);
            return aVar;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "RoomData", null);
        if (parseXml == null) {
            Log.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
            AppMethodBeat.o(43152);
            return null;
        }
        int i2 = 0;
        while (true) {
            try {
                b bVar = new b();
                if (i2 == 0) {
                    str4 = ".RoomData.Member.$UserName";
                    str3 = ".RoomData.Member.DisplayName";
                    str2 = ".RoomData.Member.Flag";
                } else if (i2 != 0) {
                    str4 = ".RoomData.Member" + i2 + ".$UserName";
                    str3 = ".RoomData.Member" + i2 + ".DisplayName";
                    str2 = ".RoomData.Member" + i2 + ".Flag";
                } else {
                    str2 = null;
                    str3 = null;
                    str4 = null;
                }
                String nullAs = Util.nullAs(parseXml.get(str4), "");
                if (!Util.isNullOrNil(nullAs)) {
                    bVar.userName = nullAs;
                    bVar.gCv = Util.nullAs(parseXml.get(str3), "");
                    bVar.gCw = aPN(parseXml.get(str2));
                    aVar.gCs.add(bVar);
                    i2++;
                } else {
                    aVar.type = aPN(parseXml.get(".RoomData.Type"));
                    aVar.status = aPN(parseXml.get(".RoomData.Status"));
                    aVar.maxCount = aPN(parseXml.get(".RoomData.MaxCount"));
                    aVar.gCt = Util.nullAs(parseXml.get(".RoomData.ExtInfo.Upgrader"), "");
                    AppMethodBeat.o(43152);
                    return aVar;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(43152);
                return aVar;
            }
        }
    }

    private static String gP(List<String> list) {
        AppMethodBeat.i(43153);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(43153);
            return "";
        }
        String str = "";
        int i2 = 0;
        while (i2 < list.size()) {
            String str2 = str + list.get(i2);
            if (i2 < list.size() - 1) {
                str2 = str2 + ";";
            }
            i2++;
            str = str2;
        }
        AppMethodBeat.o(43153);
        return str;
    }

    public static List<String> bji(String str) {
        String[] split;
        AppMethodBeat.i(43154);
        LinkedList linkedList = new LinkedList();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43154);
            return linkedList;
        }
        for (String str2 : str.split(";")) {
            linkedList.add(str2);
        }
        AppMethodBeat.o(43154);
        return linkedList;
    }

    public final ah iE(List<String> list) {
        AppMethodBeat.i(43155);
        this.field_memberlist = gP(list);
        AppMethodBeat.o(43155);
        return this;
    }

    public final void c(a aVar) {
        AppMethodBeat.i(43156);
        try {
            this.field_roomdata = aVar.toByteArray();
            AppMethodBeat.o(43156);
        } catch (Exception e2) {
            Log.e("MicroMsg.ChatRoomMember", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(43156);
        }
    }

    public final ah mQ(String str, String str2) {
        AppMethodBeat.i(43157);
        ah a2 = a(str, bjh(str2), false);
        AppMethodBeat.o(43157);
        return a2;
    }

    public final ah a(String str, a aVar, boolean z) {
        int i2;
        AppMethodBeat.i(43158);
        this.field_modifytime = System.currentTimeMillis();
        if (!z) {
            b bVar = null;
            Iterator<b> it = aVar.gCs.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.userName == null || !next.userName.equals(str)) {
                    next = bVar;
                }
                bVar = next;
            }
            if (bVar != null) {
                this.field_selfDisplayName = bVar.gCv;
                this.field_isShowname = bVar.gCw & 1;
                i2 = bVar.gCw;
            } else {
                i2 = 0;
            }
            Log.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i2));
            aVar.cSx = (i2 & 2) | (aVar.cSx & -3);
            this.field_chatroomdataflag = aVar.cSx;
        }
        try {
            this.field_roomdata = aVar.toByteArray();
            this.NRD = aVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.ChatRoomMember", "exception:%s", Util.stackTraceToString(e2));
        }
        a(aVar);
        AppMethodBeat.o(43158);
        return this;
    }

    public final void I(String str, List<xh> list) {
        AppMethodBeat.i(43159);
        if (b(this.NRD)) {
            gBs();
        }
        for (xh xhVar : list) {
            if (this.iPG.containsKey(xhVar.UserName)) {
                b bVar = this.iPG.get(xhVar.UserName);
                bVar.gCv = xhVar.Liq;
                bVar.gCw = xhVar.Lit;
                bVar.gCx = xhVar.Liu;
            }
        }
        this.NRD.gCs.clear();
        for (String str2 : this.iPG.keySet()) {
            this.NRD.gCs.add(this.iPG.get(str2));
        }
        a(str, this.NRD, false);
        AppMethodBeat.o(43159);
    }

    public final a gBy() {
        AppMethodBeat.i(43160);
        if (b(this.NRD)) {
            gBs();
        }
        a aVar = this.NRD;
        AppMethodBeat.o(43160);
        return aVar;
    }

    public final boolean amD() {
        boolean z;
        AppMethodBeat.i(43161);
        if (Util.isNullOrNil(this.field_roomowner)) {
            AppMethodBeat.o(43161);
            return false;
        }
        String aTY = z.aTY();
        if (((c) g.af(c.class)) == null) {
            Log.e("MicroMsg.ChatRoomMember", "service is null");
            AppMethodBeat.o(43161);
            return false;
        }
        if (!((c) g.af(c.class)).akx(this.field_chatroomname) || !bjf(aTY)) {
            z = false;
        } else {
            z = true;
        }
        boolean equals = this.field_roomowner.equals(aTY);
        if (z || equals) {
            AppMethodBeat.o(43161);
            return true;
        }
        AppMethodBeat.o(43161);
        return false;
    }

    public final boolean JO(String str) {
        AppMethodBeat.i(43162);
        if (Util.isNullOrNil(this.field_roomowner) || !this.field_roomowner.equals(str)) {
            AppMethodBeat.o(43162);
            return false;
        }
        AppMethodBeat.o(43162);
        return true;
    }

    public final boolean gBA() {
        if (this.field_openIMRoomMigrateStatus == 1) {
            return true;
        }
        return false;
    }

    public final boolean gBB() {
        if (this.field_openIMRoomMigrateStatus == 2) {
            return true;
        }
        return false;
    }

    public final boolean gBC() {
        return this.field_openIMRoomMigrateStatus == 3 || this.field_openIMRoomMigrateStatus == 4;
    }

    public final boolean gBz() {
        AppMethodBeat.i(225981);
        if ((((long) this.field_chatroomStatus) & 2097152) != 2097152 || !Util.isNullOrNil(this.field_associateOpenIMRoomName)) {
            AppMethodBeat.o(225981);
            return false;
        }
        AppMethodBeat.o(225981);
        return true;
    }

    static {
        AppMethodBeat.i(43163);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[27];
        mAutoDBInfo.columns = new String[28];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "chatroomname";
        mAutoDBInfo.colsMap.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
        sb.append(" chatroomname TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "chatroomname";
        mAutoDBInfo.columns[1] = "addtime";
        mAutoDBInfo.colsMap.put("addtime", "LONG");
        sb.append(" addtime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "memberlist";
        mAutoDBInfo.colsMap.put("memberlist", "TEXT");
        sb.append(" memberlist TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "displayname";
        mAutoDBInfo.colsMap.put("displayname", "TEXT");
        sb.append(" displayname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "chatroomnick";
        mAutoDBInfo.colsMap.put("chatroomnick", "TEXT");
        sb.append(" chatroomnick TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "roomflag";
        mAutoDBInfo.colsMap.put("roomflag", "INTEGER");
        sb.append(" roomflag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "roomowner";
        mAutoDBInfo.colsMap.put("roomowner", "TEXT");
        sb.append(" roomowner TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "roomdata";
        mAutoDBInfo.colsMap.put("roomdata", "BLOB");
        sb.append(" roomdata BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "isShowname";
        mAutoDBInfo.colsMap.put("isShowname", "INTEGER");
        sb.append(" isShowname INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "selfDisplayName";
        mAutoDBInfo.colsMap.put("selfDisplayName", "TEXT");
        sb.append(" selfDisplayName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE;
        mAutoDBInfo.colsMap.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "INTEGER");
        sb.append(" style INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "chatroomdataflag";
        mAutoDBInfo.colsMap.put("chatroomdataflag", "INTEGER");
        sb.append(" chatroomdataflag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "modifytime";
        mAutoDBInfo.colsMap.put("modifytime", "LONG");
        sb.append(" modifytime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "chatroomnotice";
        mAutoDBInfo.colsMap.put("chatroomnotice", "TEXT");
        sb.append(" chatroomnotice TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "chatroomVersion";
        mAutoDBInfo.colsMap.put("chatroomVersion", "INTEGER");
        sb.append(" chatroomVersion INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "chatroomnoticeEditor";
        mAutoDBInfo.colsMap.put("chatroomnoticeEditor", "TEXT");
        sb.append(" chatroomnoticeEditor TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "chatroomnoticePublishTime";
        mAutoDBInfo.colsMap.put("chatroomnoticePublishTime", "LONG");
        sb.append(" chatroomnoticePublishTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "chatroomLocalVersion";
        mAutoDBInfo.colsMap.put("chatroomLocalVersion", "LONG");
        sb.append(" chatroomLocalVersion LONG");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "chatroomStatus";
        mAutoDBInfo.colsMap.put("chatroomStatus", "INTEGER default '0' ");
        sb.append(" chatroomStatus INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "memberCount";
        mAutoDBInfo.colsMap.put("memberCount", "INTEGER default '-1' ");
        sb.append(" memberCount INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "chatroomfamilystatusmodifytime";
        mAutoDBInfo.colsMap.put("chatroomfamilystatusmodifytime", "LONG default '0' ");
        sb.append(" chatroomfamilystatusmodifytime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "associateOpenIMRoomName";
        mAutoDBInfo.colsMap.put("associateOpenIMRoomName", "TEXT");
        sb.append(" associateOpenIMRoomName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "openIMRoomMigrateStatus";
        mAutoDBInfo.colsMap.put("openIMRoomMigrateStatus", "INTEGER default '0' ");
        sb.append(" openIMRoomMigrateStatus INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "saveByteVersion";
        mAutoDBInfo.colsMap.put("saveByteVersion", "TEXT");
        sb.append(" saveByteVersion TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "handleByteVersion";
        mAutoDBInfo.colsMap.put("handleByteVersion", "TEXT");
        sb.append(" handleByteVersion TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "roomInfoDetailResByte";
        mAutoDBInfo.colsMap.put("roomInfoDetailResByte", "BLOB");
        sb.append(" roomInfoDetailResByte BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "oldChatroomVersion";
        mAutoDBInfo.colsMap.put("oldChatroomVersion", "INTEGER");
        sb.append(" oldChatroomVersion INTEGER");
        mAutoDBInfo.columns[27] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(43163);
    }
}
