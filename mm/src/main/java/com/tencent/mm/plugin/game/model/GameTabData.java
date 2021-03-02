package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.protobuf.aw;
import com.tencent.mm.plugin.game.protobuf.dv;
import com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameTabData implements Parcelable {
    public static final Parcelable.Creator<GameTabData> CREATOR = new Parcelable.Creator<GameTabData>() {
        /* class com.tencent.mm.plugin.game.model.GameTabData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GameTabData[] newArray(int i2) {
            return new GameTabData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GameTabData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(41555);
            GameTabData gameTabData = new GameTabData(parcel, (byte) 0);
            AppMethodBeat.o(41555);
            return gameTabData;
        }
    };
    public LinkedHashMap<String, TabItem> xHy;
    public StatusBar xHz;

    /* synthetic */ GameTabData(Parcel parcel, byte b2) {
        this(parcel);
    }

    public final List<TabItem> avn() {
        AppMethodBeat.i(41564);
        ArrayList arrayList = new ArrayList();
        if (this.xHy != null) {
            arrayList.addAll(this.xHy.values());
        }
        AppMethodBeat.o(41564);
        return arrayList;
    }

    public GameTabData() {
        AppMethodBeat.i(41565);
        this.xHy = new LinkedHashMap<>();
        this.xHz = new StatusBar();
        AppMethodBeat.o(41565);
    }

    private GameTabData(Parcel parcel) {
        AppMethodBeat.i(41566);
        f(parcel);
        AppMethodBeat.o(41566);
    }

    public int describeContents() {
        return 0;
    }

    private void f(Parcel parcel) {
        AppMethodBeat.i(41567);
        int readInt = parcel.readInt();
        if (this.xHy == null) {
            this.xHy = new LinkedHashMap<>();
        }
        for (int i2 = 0; i2 < readInt; i2++) {
            TabItem tabItem = (TabItem) parcel.readParcelable(TabItem.class.getClassLoader());
            if (tabItem != null) {
                this.xHy.put(tabItem.xHB, tabItem);
            }
        }
        this.xHz = (StatusBar) parcel.readParcelable(StatusBar.class.getClassLoader());
        AppMethodBeat.o(41567);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(41568);
        parcel.writeInt(this.xHy.size());
        for (Map.Entry<String, TabItem> entry : this.xHy.entrySet()) {
            parcel.writeParcelable(entry.getValue(), i2);
        }
        parcel.writeParcelable(this.xHz, i2);
        AppMethodBeat.o(41568);
    }

    static {
        AppMethodBeat.i(41570);
        AppMethodBeat.o(41570);
    }

    public static class StatusBar implements Parcelable {
        public static final Parcelable.Creator<StatusBar> CREATOR = new Parcelable.Creator<StatusBar>() {
            /* class com.tencent.mm.plugin.game.model.GameTabData.StatusBar.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StatusBar[] newArray(int i2) {
                return new StatusBar[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StatusBar createFromParcel(Parcel parcel) {
                AppMethodBeat.i(41556);
                StatusBar statusBar = new StatusBar(parcel);
                AppMethodBeat.o(41556);
                return statusBar;
            }
        };
        public int color = 0;
        public String xHA = null;

        public StatusBar() {
        }

        public StatusBar(Parcel parcel) {
            AppMethodBeat.i(41557);
            this.xHA = parcel.readString();
            this.color = parcel.readInt();
            AppMethodBeat.o(41557);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(41558);
            parcel.writeString(this.xHA);
            parcel.writeInt(this.color);
            AppMethodBeat.o(41558);
        }

        static {
            AppMethodBeat.i(41559);
            AppMethodBeat.o(41559);
        }
    }

    public static class TabItem implements Parcelable {
        public static final Parcelable.Creator<TabItem> CREATOR = new Parcelable.Creator<TabItem>() {
            /* class com.tencent.mm.plugin.game.model.GameTabData.TabItem.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ TabItem[] newArray(int i2) {
                return new TabItem[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TabItem createFromParcel(Parcel parcel) {
                AppMethodBeat.i(41560);
                TabItem tabItem = new TabItem(parcel);
                AppMethodBeat.o(41560);
                return tabItem;
            }
        };
        public int dYu;
        public String jumpUrl;
        public String title;
        public String xEl;
        public String xHB;
        public boolean xHC;
        public boolean xHD;
        public int xHE;
        public int xHF;
        public String xHG;
        public String xHH;
        public String xHI;
        public boolean xHJ;
        public int xHK;

        public TabItem() {
        }

        public TabItem(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(41561);
            this.xHB = parcel.readString();
            this.title = parcel.readString();
            this.jumpUrl = parcel.readString();
            this.xHC = parcel.readByte() != 0;
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.xHD = z;
            this.xHE = parcel.readInt();
            this.xHF = parcel.readInt();
            this.xHG = parcel.readString();
            this.xHH = parcel.readString();
            this.xHI = parcel.readString();
            this.xHJ = parcel.readByte() == 0 ? false : z2;
            this.dYu = parcel.readInt();
            this.xHK = parcel.readInt();
            this.xEl = parcel.readString();
            AppMethodBeat.o(41561);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int i3;
            int i4 = 1;
            AppMethodBeat.i(41562);
            parcel.writeString(this.xHB);
            parcel.writeString(this.title);
            parcel.writeString(this.jumpUrl);
            parcel.writeByte((byte) (this.xHC ? 1 : 0));
            if (this.xHD) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            parcel.writeInt(this.xHE);
            parcel.writeInt(this.xHF);
            parcel.writeString(this.xHG);
            parcel.writeString(this.xHH);
            parcel.writeString(this.xHI);
            if (!this.xHJ) {
                i4 = 0;
            }
            parcel.writeByte((byte) i4);
            parcel.writeInt(this.dYu);
            parcel.writeInt(this.xHK);
            parcel.writeString(this.xEl);
            AppMethodBeat.o(41562);
        }

        static {
            AppMethodBeat.i(41563);
            AppMethodBeat.o(41563);
        }
    }

    public static GameTabData fb(List<aw> list) {
        AppMethodBeat.i(41569);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(41569);
            return null;
        }
        GameTabData gameTabData = new GameTabData();
        dv dSU = a.dSU();
        if (dSU != null) {
            gameTabData.xHz.xHA = dSU.xHA;
            gameTabData.xHz.color = c.parseColor(dSU.ixw);
        }
        int i2 = 0;
        for (aw awVar : list) {
            if (awVar != null && !Util.isNullOrNil(awVar.xKM)) {
                TabItem tabItem = new TabItem();
                tabItem.xHB = awVar.xKM;
                tabItem.title = awVar.Title;
                tabItem.xHC = awVar.xKN;
                tabItem.xHD = awVar.xKO;
                tabItem.jumpUrl = awVar.xIy;
                tabItem.xHG = awVar.xKP;
                tabItem.xHH = awVar.xKQ;
                if (tabItem.xHD) {
                    tabItem.xHI = GameTabHomeUI.class.getName();
                } else {
                    int i3 = i2 + 1;
                    int i4 = i2 % 3;
                    tabItem.xHI = "com.tencent.mm.plugin.game.ui.tab.GameTabWebUI" + (i4 != 0 ? String.valueOf(i4) : "");
                    i2 = i3;
                }
                tabItem.xHJ = false;
                tabItem.dYu = awVar.xKR;
                tabItem.xHK = awVar.xJv;
                tabItem.xEl = awVar.xJt;
                gameTabData.xHy.put(tabItem.xHB, tabItem);
            }
        }
        AppMethodBeat.o(41569);
        return gameTabData;
    }
}
