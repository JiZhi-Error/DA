package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;

public class SightParams implements Parcelable {
    public static final Parcelable.Creator<SightParams> CREATOR = new Parcelable.Creator<SightParams>() {
        /* class com.tencent.mm.plugin.mmsight.SightParams.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SightParams[] newArray(int i2) {
            return new SightParams[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SightParams createFromParcel(Parcel parcel) {
            AppMethodBeat.i(148783);
            SightParams sightParams = new SightParams(parcel);
            AppMethodBeat.o(148783);
            return sightParams;
        }
    };
    public VideoTransPara irT;
    public int mode = 0;
    public int scene = -1;
    public String vPa = "";
    public int zsH = 2;
    public String zsI = "";
    public String zsJ = "";
    public String zsK = "";
    public String zsL = "";
    public String zsM = "";
    public boolean zsN = true;
    public boolean zsO = true;
    public boolean zsP = true;
    public boolean zsQ = false;
    public int zsR;

    public SightParams(int i2, int i3) {
        AppMethodBeat.i(148784);
        if (i2 == 1) {
            this.irT = e.baZ().bba();
        } else if (i2 == 2 || i2 == 3 || i2 == 4) {
            this.irT = e.baZ().bbb();
        } else if (i2 == 7) {
            this.irT = e.baZ().bbh();
        } else {
            this.irT = e.baZ().bbb();
        }
        this.scene = i2;
        this.mode = i3;
        g.aAi();
        this.zsR = ((Integer) g.aAh().azQ().get(344066, (Object) 0)).intValue();
        AppMethodBeat.o(148784);
    }

    protected SightParams(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(148785);
        this.mode = parcel.readInt();
        this.irT = (VideoTransPara) parcel.readParcelable(VideoTransPara.class.getClassLoader());
        this.zsI = parcel.readString();
        this.zsJ = parcel.readString();
        this.zsK = parcel.readString();
        this.zsL = parcel.readString();
        this.zsR = parcel.readInt();
        this.zsH = parcel.readInt();
        this.zsN = parcel.readInt() > 0;
        this.scene = parcel.readInt();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.zsO = z;
        this.vPa = parcel.readString();
        if (parcel.readByte() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zsP = z2;
        this.zsQ = parcel.readByte() == 0 ? false : z3;
        AppMethodBeat.o(148785);
    }

    static {
        AppMethodBeat.i(148787);
        AppMethodBeat.o(148787);
    }

    public final SightParams v(String str, String str2, String str3, String str4) {
        this.zsK = str;
        this.zsI = str2;
        this.zsJ = str3;
        this.zsL = str4;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        int i3;
        int i4 = 1;
        AppMethodBeat.i(148786);
        parcel.writeInt(this.mode);
        parcel.writeParcelable(this.irT, i2);
        parcel.writeString(this.zsI);
        parcel.writeString(this.zsJ);
        parcel.writeString(this.zsK);
        parcel.writeString(this.zsL);
        parcel.writeInt(this.zsR);
        parcel.writeInt(this.zsH);
        parcel.writeInt(this.zsN ? 1 : 0);
        parcel.writeInt(this.scene);
        if (this.zsO) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        parcel.writeString(this.vPa);
        if (this.zsP) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        if (!this.zsQ) {
            i4 = 0;
        }
        parcel.writeByte((byte) i4);
        AppMethodBeat.o(148786);
    }
}
