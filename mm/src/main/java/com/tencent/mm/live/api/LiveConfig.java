package com.tencent.mm.live.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;

public class LiveConfig implements Parcelable {
    public static final Parcelable.Creator<LiveConfig> CREATOR = new Parcelable.Creator<LiveConfig>() {
        /* class com.tencent.mm.live.api.LiveConfig.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LiveConfig[] newArray(int i2) {
            return new LiveConfig[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LiveConfig createFromParcel(Parcel parcel) {
            AppMethodBeat.i(224091);
            LiveConfig liveConfig = new LiveConfig(parcel);
            AppMethodBeat.o(224091);
            return liveConfig;
        }
    };
    public static int hvQ = 0;
    public static int hvR = 1;
    public static int hvS = 2;
    public static int hvT = 0;
    public static int hvU = 1;
    public static int hvV = 2;
    public static int hvW = 1;
    public static int hvX = 2;
    public static int hvY = 0;
    private static boolean hwf = false;
    private String desc;
    private int fromScene;
    private int hvZ;
    private String hwa;
    private String hwb;
    public HashMap hwc;
    private String hwd;
    private long hwe;
    private String hwg;
    private String hwh;
    private String hwi;
    private String hwj;
    private long hwk;
    private long hwl;
    private long liveId;
    private int scene;
    private String sessionBuffer;
    private String thumbUrl;
    private String uBU;

    /* synthetic */ LiveConfig(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(224100);
        AppMethodBeat.o(224100);
    }

    private LiveConfig() {
        AppMethodBeat.i(224093);
        this.hvZ = hvT;
        this.liveId = 0;
        this.hwa = "";
        this.hwb = "";
        this.hwc = new HashMap();
        this.thumbUrl = "";
        this.hwd = "";
        this.scene = hvQ;
        this.fromScene = hvY;
        this.hwe = 0;
        this.desc = "";
        this.hwg = "";
        this.hwh = "";
        this.hwi = "";
        this.hwj = "";
        this.hwk = 0;
        this.hwl = 0;
        this.sessionBuffer = "";
        this.uBU = "";
        AppMethodBeat.o(224093);
    }

    public static LiveConfig V(String str, int i2) {
        AppMethodBeat.i(224094);
        a aVar = new a();
        aVar.hvZ = hvT;
        aVar.hwa = str;
        aVar.hwd = z.aTY();
        aVar.scene = i2;
        LiveConfig aBR = aVar.aBR();
        AppMethodBeat.o(224094);
        return aBR;
    }

    public static LiveConfig b(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(224095);
        a aVar = new a();
        aVar.hvZ = hvU;
        aVar.thumbUrl = str2;
        aVar.hwa = str3;
        aVar.liveId = 0;
        aVar.hwb = str;
        aVar.hwd = str4;
        LiveConfig aBR = aVar.aBR();
        AppMethodBeat.o(224095);
        return aBR;
    }

    public final int aBC() {
        return this.hvZ;
    }

    public final String aBD() {
        return this.hwa;
    }

    public final String aBE() {
        return this.thumbUrl;
    }

    public final long getLiveId() {
        return this.liveId;
    }

    public final String aBF() {
        return this.hwb;
    }

    public final String aBG() {
        return this.hwd;
    }

    public final int getScene() {
        return this.scene;
    }

    public final int getFromScene() {
        return this.fromScene;
    }

    public final void F(int i2, String str) {
        AppMethodBeat.i(224096);
        this.hwc.put(Integer.valueOf(i2), str);
        AppMethodBeat.o(224096);
    }

    public final long aBH() {
        return this.hwe;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String aBI() {
        return this.hwg;
    }

    public final String aBJ() {
        return this.hwh;
    }

    public final String aBK() {
        return this.hwi;
    }

    public final String aBL() {
        return this.hwj;
    }

    public final long aBM() {
        return this.hwk;
    }

    public final long aBN() {
        return this.hwl;
    }

    public final String getSessionBuffer() {
        return this.sessionBuffer;
    }

    public final String aFR() {
        return this.uBU;
    }

    public final void bxe(String str) {
        this.uBU = str;
    }

    public int describeContents() {
        return 0;
    }

    public static void eu(boolean z) {
        hwf = z;
    }

    public static boolean aBO() {
        if (BuildInfo.DEBUG) {
            return false;
        }
        return hwf;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(224097);
        parcel.writeInt(this.hvZ);
        parcel.writeSerializable(this.hwc);
        parcel.writeString(this.hwa);
        parcel.writeLong(this.liveId);
        parcel.writeString(this.hwb);
        parcel.writeString(this.hwd);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.fromScene);
        parcel.writeLong(this.hwe);
        parcel.writeString(this.hwg);
        parcel.writeString(this.hwh);
        parcel.writeString(this.hwi);
        parcel.writeString(this.hwj);
        parcel.writeLong(this.hwk);
        parcel.writeLong(this.hwl);
        parcel.writeString(this.desc);
        parcel.writeString(this.sessionBuffer);
        parcel.writeString(this.uBU);
        AppMethodBeat.o(224097);
    }

    protected LiveConfig(Parcel parcel) {
        AppMethodBeat.i(224098);
        this.hvZ = hvT;
        this.liveId = 0;
        this.hwa = "";
        this.hwb = "";
        this.hwc = new HashMap();
        this.thumbUrl = "";
        this.hwd = "";
        this.scene = hvQ;
        this.fromScene = hvY;
        this.hwe = 0;
        this.desc = "";
        this.hwg = "";
        this.hwh = "";
        this.hwi = "";
        this.hwj = "";
        this.hwk = 0;
        this.hwl = 0;
        this.sessionBuffer = "";
        this.uBU = "";
        this.hvZ = parcel.readInt();
        this.hwc = (HashMap) parcel.readSerializable();
        this.hwa = parcel.readString();
        this.liveId = parcel.readLong();
        this.hwb = parcel.readString();
        this.hwd = parcel.readString();
        this.scene = parcel.readInt();
        this.fromScene = parcel.readInt();
        this.hwe = parcel.readLong();
        this.hwg = parcel.readString();
        this.hwh = parcel.readString();
        this.hwi = parcel.readString();
        this.hwj = parcel.readString();
        this.hwk = parcel.readLong();
        this.hwl = parcel.readLong();
        this.desc = parcel.readString();
        this.sessionBuffer = parcel.readString();
        this.uBU = parcel.readString();
        AppMethodBeat.o(224098);
    }

    public final String info() {
        AppMethodBeat.i(224099);
        String format = String.format("toWhere:%s,hostRoomId:%s,liveId:%s,liveName:%s,anchorUsername:%s,scene:%s,fromScene:%s, finderObjectId:%s, linkAnchorUsername:%s, linkAnchorNickname:%s,linkFinderObjectId:%s, linkFinderLiveId:%s, desc:%s, sessionBuffer:%s", Integer.valueOf(this.hvZ), this.hwa, Long.valueOf(this.liveId), this.hwb, this.hwd, Integer.valueOf(this.scene), Integer.valueOf(this.fromScene), Long.valueOf(this.hwe), this.hwh, this.hwi, Long.valueOf(this.hwk), Long.valueOf(this.hwl), this.desc, this.sessionBuffer);
        AppMethodBeat.o(224099);
        return format;
    }

    public static class a {
        private String desc = "";
        public int fromScene = LiveConfig.hvY;
        public int hvZ = LiveConfig.hvT;
        public String hwa = "";
        public String hwb = "";
        public String hwd = "";
        private long hwe = 0;
        private String hwg = "";
        private String hwh = "";
        private String hwi = "";
        private String hwj = "";
        private long hwk = 0;
        private long hwl = 0;
        public long liveId = 0;
        public int scene = LiveConfig.hvQ;
        private String sessionBuffer = "";
        public String thumbUrl = "";
        private String uBW = "";

        public final a qo(int i2) {
            this.hvZ = i2;
            return this;
        }

        public final a Gc(String str) {
            this.hwa = str;
            return this;
        }

        public final a zt(long j2) {
            this.liveId = j2;
            return this;
        }

        public final a Gd(String str) {
            this.hwg = str;
            return this;
        }

        public final a Ge(String str) {
            this.hwb = str;
            return this;
        }

        public final a Gf(String str) {
            this.thumbUrl = str;
            return this;
        }

        public final a Gg(String str) {
            this.hwd = str;
            return this;
        }

        public final a zu(long j2) {
            this.hwe = j2;
            return this;
        }

        public final a Gh(String str) {
            this.desc = str;
            return this;
        }

        public final a Gi(String str) {
            this.hwh = str;
            return this;
        }

        public final a Gj(String str) {
            this.hwi = str;
            return this;
        }

        public final a Gk(String str) {
            this.hwj = str;
            return this;
        }

        public final a aBP() {
            this.hwk = 0;
            return this;
        }

        public final a aBQ() {
            this.hwl = 0;
            return this;
        }

        public final a Gl(String str) {
            this.sessionBuffer = str;
            return this;
        }

        public final a bxf(String str) {
            this.uBW = str;
            return this;
        }

        public final LiveConfig aBR() {
            AppMethodBeat.i(224092);
            LiveConfig liveConfig = new LiveConfig((byte) 0);
            liveConfig.hvZ = this.hvZ;
            liveConfig.hwa = this.hwa;
            liveConfig.liveId = this.liveId;
            liveConfig.hwb = this.hwb;
            liveConfig.thumbUrl = this.thumbUrl;
            liveConfig.hwd = this.hwd;
            liveConfig.scene = this.scene;
            liveConfig.fromScene = this.fromScene;
            liveConfig.hwe = this.hwe;
            liveConfig.desc = this.desc;
            liveConfig.hwg = this.hwg;
            liveConfig.hwh = this.hwh;
            liveConfig.hwk = this.hwk;
            liveConfig.hwl = this.hwl;
            liveConfig.hwi = this.hwi;
            liveConfig.hwj = this.hwj;
            liveConfig.sessionBuffer = this.sessionBuffer;
            liveConfig.uBU = this.uBW;
            AppMethodBeat.o(224092);
            return liveConfig;
        }
    }
}
