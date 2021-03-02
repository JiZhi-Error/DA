package com.tencent.mm.plugin.finder.live.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axk;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 T2\u00020\u0001:\u0001TB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010K\u001a\u0004\u0018\u00010&J\b\u0010L\u001a\u00020\rH\u0016J\b\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020NH\u0016J\u001a\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u00032\u0006\u0010S\u001a\u00020\rH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R\u001a\u00105\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000f\"\u0004\b7\u0010\u0011R\u001a\u00108\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000f\"\u0004\b:\u0010\u0011R\u001a\u0010;\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011R\u001a\u0010>\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010\u0011R\"\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010D\"\u0004\bJ\u0010F¨\u0006U"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "bindShop", "", "getBindShop", "()Z", "setBindShop", "(Z)V", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "curPos", "getCurPos", "setCurPos", "extFlag", "getExtFlag", "setExtFlag", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getFinderLiveNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setFinderLiveNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "lastChosenTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLastChosenTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setLastChosenTagInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "liveConfigList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/api/LiveConfig;", "Lkotlin/collections/ArrayList;", "getLiveConfigList", "()Ljava/util/ArrayList;", "setLiveConfigList", "(Ljava/util/ArrayList;)V", "luckyMoneyConfig", "", "getLuckyMoneyConfig", "()[B", "setLuckyMoneyConfig", "([B)V", "maxVisibleRoomCount", "getMaxVisibleRoomCount", "setMaxVisibleRoomCount", "maxVisibleUserCount", "getMaxVisibleUserCount", "setMaxVisibleUserCount", "pullMoreType", "getPullMoreType", "setPullMoreType", "sourceType", "getSourceType", "setSourceType", "tabType", "getTabType", "setTabType", "tagInfo", "Ljava/util/LinkedList;", "getTagInfo", "()Ljava/util/LinkedList;", "setTagInfo", "(Ljava/util/LinkedList;)V", "visitorWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getVisitorWhiteList", "setVisitorWhiteList", "curLiveConfig", "describeContents", "getLiveIdList", "", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-finder_release"})
public final class FinderLiveConfig implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    public int UKm;
    public int UKn;
    public byte[] UKo;
    public int dLS;
    public int extFlag;
    public int sourceType;
    public int tCE;
    public LinkedList<avh> ueu;
    public int uis;
    public boolean uit;
    public ArrayList<LiveConfig> uiu;
    public awt uiv;
    public LinkedList<axk> uiw;
    public axk uix;
    public int uiy;

    static {
        AppMethodBeat.i(246084);
        AppMethodBeat.o(246084);
    }

    public FinderLiveConfig() {
        AppMethodBeat.i(246082);
        this.dLS = -1;
        this.uiu = new ArrayList<>();
        this.sourceType = -1;
        this.uiy = -1;
        AppMethodBeat.o(246082);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "()V", "PULL_MORE_TYPE_SIMILAR", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "plugin-finder_release"})
    public static final class a implements Parcelable.Creator<FinderLiveConfig> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FinderLiveConfig createFromParcel(Parcel parcel) {
            AppMethodBeat.i(246076);
            p.h(parcel, "parcel");
            FinderLiveConfig finderLiveConfig = new FinderLiveConfig(parcel);
            AppMethodBeat.o(246076);
            return finderLiveConfig;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FinderLiveConfig[] newArray(int i2) {
            return new FinderLiveConfig[i2];
        }
    }

    public final void ac(ArrayList<LiveConfig> arrayList) {
        AppMethodBeat.i(246077);
        p.h(arrayList, "<set-?>");
        this.uiu = arrayList;
        AppMethodBeat.o(246077);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveConfig(Parcel parcel) {
        this();
        boolean z = true;
        p.h(parcel, "parcel");
        AppMethodBeat.i(246083);
        this.uis = parcel.readInt();
        this.uit = parcel.readInt() != 1 ? false : z;
        this.dLS = parcel.readInt();
        this.tCE = parcel.readInt();
        parcel.readTypedList(this.uiu, LiveConfig.CREATOR);
        this.sourceType = parcel.readInt();
        this.uiy = parcel.readInt();
        this.UKm = parcel.readInt();
        this.UKn = parcel.readInt();
        AppMethodBeat.o(246083);
    }

    public final LiveConfig dfu() {
        AppMethodBeat.i(246078);
        LiveConfig liveConfig = (LiveConfig) j.L(this.uiu, this.uis);
        AppMethodBeat.o(246078);
        return liveConfig;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(246079);
        if (parcel != null) {
            parcel.writeInt(this.uis);
        }
        if (parcel != null) {
            parcel.writeInt(this.uit ? 1 : 0);
        }
        if (parcel != null) {
            parcel.writeInt(this.dLS);
        }
        if (parcel != null) {
            parcel.writeInt(this.tCE);
        }
        if (parcel != null) {
            parcel.writeTypedList(this.uiu);
        }
        if (parcel != null) {
            parcel.writeInt(this.sourceType);
        }
        if (parcel != null) {
            parcel.writeInt(this.uiy);
        }
        if (parcel != null) {
            parcel.writeInt(this.UKm);
        }
        if (parcel != null) {
            parcel.writeInt(this.UKn);
            AppMethodBeat.o(246079);
            return;
        }
        AppMethodBeat.o(246079);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(246080);
        StringBuilder append = new StringBuilder("FinderLiveConfig:").append("[tabType:" + this.dLS + ",commentScene:" + this.tCE + ",curPos:" + this.uis + ",bindShop:" + this.uit + ",data:" + dfv() + ']');
        p.g(append, "StringBuilder(\"FinderLiv…ata:${getLiveIdList()}]\")");
        String sb = append.toString();
        p.g(sb, "sb.toString()");
        AppMethodBeat.o(246080);
        return sb;
    }

    private final String dfv() {
        AppMethodBeat.i(246081);
        int size = this.uiu.size();
        if (size <= 0) {
            AppMethodBeat.o(246081);
            return "empty";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            StringBuilder append = new StringBuilder("live_").append(i2).append(":username:");
            LiveConfig liveConfig = this.uiu.get(i2);
            p.g(liveConfig, "liveConfigList[index]");
            StringBuilder append2 = append.append(liveConfig.aBG()).append(",liveId:");
            LiveConfig liveConfig2 = this.uiu.get(i2);
            p.g(liveConfig2, "liveConfigList[index]");
            StringBuilder append3 = append2.append(liveConfig2.getLiveId()).append(",sessionBuffer:");
            LiveConfig liveConfig3 = this.uiu.get(i2);
            sb.append(append3.append(liveConfig3 != null ? liveConfig3.getSessionBuffer() : null).append(';').toString());
        }
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(246081);
        return sb2;
    }
}
