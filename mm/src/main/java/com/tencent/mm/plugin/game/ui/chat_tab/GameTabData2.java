package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.protobuf.ai;
import com.tencent.mm.plugin.game.protobuf.dy;
import com.tencent.mm.plugin.game.protobuf.ea;
import com.tencent.mm.plugin.game.protobuf.eb;
import com.tencent.mm.plugin.game.protobuf.ec;
import com.tencent.mm.plugin.game.protobuf.ed;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameTabData2 implements Parcelable {
    public static final Parcelable.Creator<GameTabData2> CREATOR = new Parcelable.Creator<GameTabData2>() {
        /* class com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GameTabData2[] newArray(int i2) {
            return new GameTabData2[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GameTabData2 createFromParcel(Parcel parcel) {
            AppMethodBeat.i(204209);
            GameTabData2 gameTabData2 = new GameTabData2(parcel, (byte) 0);
            AppMethodBeat.o(204209);
            return gameTabData2;
        }
    };
    private static final String xXa = ("{\n        \"TabList\": [\n            {\n                \"Key\": \"home\",\n                \"Title\": \"首页\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/4f72b9a4850edcba7ff71688b17233b8224fcc357e2357c9c09f74efc5fbb32c\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/b18f15fb59987306a116b4c04929e10cfe08da24ba2d3467043ae3b0a68cc598\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/contentcenter/feeds.html?wechat_pkgid=contentcenter_feeds&abt=59&ssid=901\"\n            },\n            {\n                \"Key\": \"gameindex\",\n                \"Title\": \"游戏\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/3379a7e14dacfc6c9eea1cc3bce1abc681634348b2d10cb741402f0a7afe1b99\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/e257a6c0d7dd13a2ec717ec5d370871f8624fed7fcf8bd0c9d3a29dee6d01d97\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/contentcenter/game.html?wechat_pkgid=contentcenter_game&ssid=901\"\n            },\n            {\n                \"Key\": \"community\",\n                \"Title\": \"游戏圈\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/090cb63e719dd5dee494f493d4dc7c767293046c8c37c3d620f3c426a4292806\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/3eea6be7fecf862137602860126a710860466bcb39f19a51d89664147c71aa3d\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/appcenter/community.html?wechat_pkgid=appcenter_community&ssid=901\"\n            },\n            {\n                \"Key\": \"chat\",\n                \"Title\": \"消息\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/70b7e084e27150c4e606618d72b3afd1c474039fead8dadabf5a3438159d3cd5\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/6c4e9abf2c66d9b10e7a8a446a7285c89d0e577a6183eb222708d0cb9fc33bf3\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"Type\": 1\n            }\n        ],\n        \"DefaultTab\": {\n            \"Key\": \"home\"\n        }\n    }");
    public String lco;
    public a xWX;
    public String xWY;
    public String xWZ;

    /* synthetic */ GameTabData2(Parcel parcel, byte b2) {
        this(parcel);
    }

    public GameTabData2() {
        AppMethodBeat.i(204231);
        this.xWX = new a();
        AppMethodBeat.o(204231);
    }

    private GameTabData2(Parcel parcel) {
        AppMethodBeat.i(204232);
        f(parcel);
        AppMethodBeat.o(204232);
    }

    public final List<TabItem> avn() {
        AppMethodBeat.i(204233);
        ArrayList arrayList = new ArrayList();
        if (this.xWX != null) {
            arrayList.addAll(this.xWX.values());
        }
        AppMethodBeat.o(204233);
        return arrayList;
    }

    public final String dWA() {
        AppMethodBeat.i(204234);
        for (TabItem tabItem : this.xWX.values()) {
            if (tabItem.dLS == 1) {
                String str = tabItem.xHB;
                AppMethodBeat.o(204234);
                return str;
            }
        }
        AppMethodBeat.o(204234);
        return "";
    }

    public final String toJson() {
        AppMethodBeat.i(204235);
        JSONArray jSONArray = new JSONArray();
        for (TabItem tabItem : this.xWX.values()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("Key", tabItem.xHB);
                jSONObject.put("Title", tabItem.title);
                jSONObject.put("JumpUrl", tabItem.jumpUrl);
                if (Util.nullAsNil(this.xWY).equalsIgnoreCase(tabItem.xHB)) {
                    jSONObject.put("isDefaultTab", 1);
                } else {
                    jSONObject.put("isDefaultTab", 0);
                }
            } catch (JSONException e2) {
            }
            jSONArray.put(jSONObject);
        }
        String jSONArray2 = jSONArray.toString();
        AppMethodBeat.o(204235);
        return jSONArray2;
    }

    public int describeContents() {
        return 0;
    }

    private void f(Parcel parcel) {
        AppMethodBeat.i(204236);
        int readInt = parcel.readInt();
        if (this.xWX == null) {
            this.xWX = new a();
        }
        for (int i2 = 0; i2 < readInt; i2++) {
            TabItem tabItem = (TabItem) parcel.readParcelable(TabItem.class.getClassLoader());
            if (tabItem != null) {
                this.xWX.a(tabItem.xHB, tabItem);
            }
        }
        this.xWY = parcel.readString();
        this.lco = parcel.readString();
        this.xWZ = parcel.readString();
        AppMethodBeat.o(204236);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(204237);
        parcel.writeInt(this.xWX.size());
        for (Map.Entry entry : this.xWX.entrySet()) {
            parcel.writeParcelable((Parcelable) entry.getValue(), i2);
        }
        parcel.writeString(this.xWY);
        parcel.writeString(this.lco);
        parcel.writeString(this.xWZ);
        AppMethodBeat.o(204237);
    }

    static {
        AppMethodBeat.i(204242);
        AppMethodBeat.o(204242);
    }

    public static class TabItem implements Parcelable {
        public static final Parcelable.Creator<TabItem> CREATOR = new Parcelable.Creator<TabItem>() {
            /* class com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItem.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ TabItem[] newArray(int i2) {
                return new TabItem[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TabItem createFromParcel(Parcel parcel) {
                AppMethodBeat.i(204212);
                TabItem tabItem = new TabItem(parcel, (byte) 0);
                AppMethodBeat.o(204212);
                return tabItem;
            }
        };
        public int dLS;
        public String iconUrl;
        public String iyd;
        public String jumpUrl;
        public int position;
        public String title;
        public String xHB;
        public String xHI;
        public String xXc;
        public String xXd;
        public String xXe;
        public String xXf;
        public String xXg;
        public String xXh;
        public TabItemWeapp xXi;
        public TabItemReport xXj;
        public boolean xXk;
        public int xXl;
        public int xXm;

        /* synthetic */ TabItem(Parcel parcel, byte b2) {
            this(parcel);
        }

        public TabItem(ec ecVar) {
            AppMethodBeat.i(204213);
            if (ecVar == null) {
                AppMethodBeat.o(204213);
                return;
            }
            this.xHB = ecVar.xMX;
            this.title = ecVar.Title;
            this.iyd = ecVar.xNv;
            this.xXc = ecVar.xNw;
            this.xXd = ecVar.xNx;
            this.xXe = ecVar.xNy;
            this.iconUrl = ecVar.IconUrl;
            this.xXf = ecVar.xNz;
            this.xXg = ecVar.xJd;
            this.xXh = ecVar.xNA;
            this.dLS = ecVar.oUv;
            this.jumpUrl = ecVar.xIy;
            this.xXi = new TabItemWeapp(ecVar.xNB);
            this.xXj = new TabItemReport(ecVar.xNC);
            this.xXk = ecVar.xND;
            this.xXl = ecVar.xNE;
            dWD();
            AppMethodBeat.o(204213);
        }

        public TabItem(JSONObject jSONObject) {
            AppMethodBeat.i(204214);
            if (jSONObject == null) {
                AppMethodBeat.o(204214);
                return;
            }
            this.xHB = jSONObject.optString("Key");
            this.title = jSONObject.optString("Title");
            this.iconUrl = jSONObject.optString("IconUrl");
            this.xXf = jSONObject.optString("SelectedIconUrl");
            this.xXg = jSONObject.optString("DarkModeIconUrl");
            this.xXh = jSONObject.optString("DarkModeSelectedIconUrl");
            this.dLS = jSONObject.optInt("Type");
            this.jumpUrl = jSONObject.optString("JumpUrl");
            this.xXi = new TabItemWeapp(jSONObject.optJSONObject("JumpWeapp"));
            this.xXj = new TabItemReport(jSONObject.optJSONObject("Report"));
            this.xXk = false;
            this.xXl = 2;
            dWD();
            AppMethodBeat.o(204214);
        }

        public final boolean dWC() {
            if (this.dLS == 1) {
                return true;
            }
            return false;
        }

        private void dWD() {
            AppMethodBeat.i(204215);
            switch (this.dLS) {
                case 1:
                    this.xHI = GameChatTabUI.class.getName();
                    AppMethodBeat.o(204215);
                    return;
                case 2:
                    this.xHI = GameWebTabUI.class.getName();
                    AppMethodBeat.o(204215);
                    return;
                default:
                    this.xHI = "";
                    AppMethodBeat.o(204215);
                    return;
            }
        }

        private TabItem(Parcel parcel) {
            AppMethodBeat.i(204216);
            this.xHB = parcel.readString();
            this.title = parcel.readString();
            this.iyd = parcel.readString();
            this.xXc = parcel.readString();
            this.xXd = parcel.readString();
            this.xXe = parcel.readString();
            this.iconUrl = parcel.readString();
            this.xXf = parcel.readString();
            this.xXg = parcel.readString();
            this.xXh = parcel.readString();
            this.dLS = parcel.readInt();
            this.jumpUrl = parcel.readString();
            this.xXi = (TabItemWeapp) parcel.readParcelable(TabItemWeapp.class.getClassLoader());
            this.xXj = (TabItemReport) parcel.readParcelable(TabItemReport.class.getClassLoader());
            this.xXk = parcel.readByte() != 0;
            this.xXl = parcel.readInt();
            this.xHI = parcel.readString();
            this.position = parcel.readInt();
            AppMethodBeat.o(204216);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(204217);
            parcel.writeString(this.xHB);
            parcel.writeString(this.title);
            parcel.writeString(this.iyd);
            parcel.writeString(this.xXc);
            parcel.writeString(this.xXd);
            parcel.writeString(this.xXe);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.xXf);
            parcel.writeString(this.xXg);
            parcel.writeString(this.xXh);
            parcel.writeInt(this.dLS);
            parcel.writeString(this.jumpUrl);
            parcel.writeParcelable(this.xXi, i2);
            parcel.writeParcelable(this.xXj, i2);
            parcel.writeByte((byte) (this.xXk ? 1 : 0));
            parcel.writeInt(this.xXl);
            parcel.writeString(this.xHI);
            parcel.writeInt(this.position);
            AppMethodBeat.o(204217);
        }

        static {
            AppMethodBeat.i(204218);
            AppMethodBeat.o(204218);
        }
    }

    public static class TabItemWeapp implements Parcelable {
        public static final Parcelable.Creator<TabItemWeapp> CREATOR = new Parcelable.Creator<TabItemWeapp>() {
            /* class com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItemWeapp.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ TabItemWeapp[] newArray(int i2) {
                return new TabItemWeapp[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TabItemWeapp createFromParcel(Parcel parcel) {
                AppMethodBeat.i(204225);
                TabItemWeapp tabItemWeapp = new TabItemWeapp(parcel, (byte) 0);
                AppMethodBeat.o(204225);
                return tabItemWeapp;
            }
        };
        public String jfi;
        public String xut;

        /* synthetic */ TabItemWeapp(Parcel parcel, byte b2) {
            this(parcel);
        }

        public TabItemWeapp(ea eaVar) {
            AppMethodBeat.i(204226);
            if (eaVar == null) {
                AppMethodBeat.o(204226);
                return;
            }
            this.jfi = eaVar.jfi;
            this.xut = eaVar.xut;
            AppMethodBeat.o(204226);
        }

        public TabItemWeapp(JSONObject jSONObject) {
            AppMethodBeat.i(204227);
            if (jSONObject == null) {
                AppMethodBeat.o(204227);
                return;
            }
            this.jfi = jSONObject.optString("AppId");
            this.xut = jSONObject.optString("Path");
            AppMethodBeat.o(204227);
        }

        private TabItemWeapp(Parcel parcel) {
            AppMethodBeat.i(204228);
            this.jfi = parcel.readString();
            this.xut = parcel.readString();
            AppMethodBeat.o(204228);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(204229);
            parcel.writeString(this.jfi);
            parcel.writeString(this.xut);
            AppMethodBeat.o(204229);
        }

        static {
            AppMethodBeat.i(204230);
            AppMethodBeat.o(204230);
        }
    }

    public static class TabItemReport implements Parcelable {
        public static final Parcelable.Creator<TabItemReport> CREATOR = new Parcelable.Creator<TabItemReport>() {
            /* class com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItemReport.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ TabItemReport[] newArray(int i2) {
                return new TabItemReport[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TabItemReport createFromParcel(Parcel parcel) {
                AppMethodBeat.i(204219);
                TabItemReport tabItemReport = new TabItemReport(parcel, (byte) 0);
                AppMethodBeat.o(204219);
                return tabItemReport;
            }
        };
        public String xEl;
        public int xHK;
        public int xXn;

        /* synthetic */ TabItemReport(Parcel parcel, byte b2) {
            this(parcel);
        }

        public TabItemReport(eb ebVar) {
            AppMethodBeat.i(204220);
            if (ebVar == null) {
                AppMethodBeat.o(204220);
                return;
            }
            this.xXn = ebVar.xNu;
            this.xHK = ebVar.xJv;
            this.xEl = ebVar.xJt;
            AppMethodBeat.o(204220);
        }

        public TabItemReport(JSONObject jSONObject) {
            AppMethodBeat.i(204221);
            if (jSONObject == null) {
                AppMethodBeat.o(204221);
                return;
            }
            this.xXn = jSONObject.optInt("AreaId");
            this.xHK = jSONObject.optInt("PositionId");
            this.xEl = jSONObject.optString("ExternInfo");
            AppMethodBeat.o(204221);
        }

        private TabItemReport(Parcel parcel) {
            AppMethodBeat.i(204222);
            this.xXn = parcel.readInt();
            this.xHK = parcel.readInt();
            this.xEl = parcel.readString();
            AppMethodBeat.o(204222);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(204223);
            parcel.writeInt(this.xXn);
            parcel.writeInt(this.xHK);
            parcel.writeString(this.xEl);
            AppMethodBeat.o(204223);
        }

        static {
            AppMethodBeat.i(204224);
            AppMethodBeat.o(204224);
        }
    }

    public static GameTabData2 dWB() {
        ai aiVar;
        AppMethodBeat.i(204238);
        GameTabData2 gameTabData2 = new GameTabData2();
        if (com.tencent.mm.plugin.game.commlib.a.xvl != null) {
            if (com.tencent.mm.plugin.game.commlib.a.xvl.GameCenterTabSetting != null) {
                aiVar = com.tencent.mm.plugin.game.commlib.a.xvl.GameCenterTabSetting;
            }
            aiVar = null;
        } else {
            com.tencent.mm.plugin.game.commlib.a.dSS();
            aiVar = null;
        }
        if (aiVar != null && !Util.isNullOrNil(aiVar.xKh)) {
            Iterator<ed> it = aiVar.xKh.iterator();
            while (it.hasNext()) {
                ed next = it.next();
                long j2 = next.oUG;
                long j3 = next.oUH == 0 ? MAlarmHandler.NEXT_FIRE_INTERVAL : next.oUH;
                if (Util.nowSecond() >= j2 && Util.nowSecond() <= j3 && a(gameTabData2, next.xKg)) {
                    Log.i("MicroMsg.GameTabData2", "Get GameTabData from TabStyleList");
                    AppMethodBeat.o(204238);
                    return gameTabData2;
                }
            }
        }
        if (aiVar == null || !a(gameTabData2, aiVar.xKg)) {
            try {
                if (a(gameTabData2, new JSONObject(xXa))) {
                    Log.i("MicroMsg.GameTabData2", "Get GameTabData from local");
                    AppMethodBeat.o(204238);
                    return gameTabData2;
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.GameTabData2", e2.getMessage());
            }
            AppMethodBeat.o(204238);
            return null;
        }
        Log.i("MicroMsg.GameTabData2", "Get GameTabData from globalConfig");
        AppMethodBeat.o(204238);
        return gameTabData2;
    }

    private static boolean a(GameTabData2 gameTabData2, dy dyVar) {
        AppMethodBeat.i(204239);
        if (dyVar == null || Util.isNullOrNil(dyVar.xNq)) {
            AppMethodBeat.o(204239);
            return false;
        }
        gameTabData2.lco = dyVar.xNs;
        gameTabData2.xWZ = dyVar.xNt;
        Iterator<ec> it = dyVar.xNq.iterator();
        while (it.hasNext()) {
            TabItem tabItem = new TabItem(it.next());
            if (!Util.isNullOrNil(tabItem.xHB)) {
                gameTabData2.xWX.a(tabItem.xHB, tabItem);
            }
        }
        if (gameTabData2.xWX.size() == 0) {
            AppMethodBeat.o(204239);
            return false;
        }
        String str = "";
        if (dyVar.xNr != null) {
            str = Util.nullAsNil(dyVar.xNr.xMX);
        }
        if (gameTabData2.xWX.containsKey(str)) {
            gameTabData2.xWY = str;
        } else {
            gameTabData2.xWY = an(gameTabData2.xWX);
        }
        AppMethodBeat.o(204239);
        return true;
    }

    private static boolean a(GameTabData2 gameTabData2, JSONObject jSONObject) {
        AppMethodBeat.i(204240);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("TabList");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                TabItem tabItem = new TabItem(jSONArray.optJSONObject(i2));
                if (!Util.isNullOrNil(tabItem.xHB)) {
                    gameTabData2.xWX.a(tabItem.xHB, tabItem);
                }
            }
            if (gameTabData2.xWX.size() != 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("DefaultTab");
                String str = "";
                if (optJSONObject != null) {
                    str = optJSONObject.optString("Key");
                }
                if (gameTabData2.xWX.containsKey(str)) {
                    gameTabData2.xWY = str;
                } else {
                    gameTabData2.xWY = an(gameTabData2.xWX);
                }
                AppMethodBeat.o(204240);
                return true;
            }
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(204240);
        return false;
    }

    private static String an(Map<String, TabItem> map) {
        AppMethodBeat.i(204241);
        try {
            String key = map.entrySet().iterator().next().getKey();
            AppMethodBeat.o(204241);
            return key;
        } catch (Exception e2) {
            AppMethodBeat.o(204241);
            return "";
        }
    }

    public class a extends LinkedHashMap<String, TabItem> {
        public a() {
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* synthetic */ Object put(Object obj, Object obj2) {
            AppMethodBeat.i(204211);
            TabItem a2 = a((String) obj, (TabItem) obj2);
            AppMethodBeat.o(204211);
            return a2;
        }

        public final TabItem a(String str, TabItem tabItem) {
            AppMethodBeat.i(204210);
            tabItem.position = size() + 1;
            TabItem tabItem2 = (TabItem) super.put(str, tabItem);
            AppMethodBeat.o(204210);
            return tabItem2;
        }
    }
}
