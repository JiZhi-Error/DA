package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectConfig implements Parcelable {
    public static final Parcelable.Creator<XEffectConfig> CREATOR = new Parcelable.Creator<XEffectConfig>() {
        /* class com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ XEffectConfig[] newArray(int i2) {
            return new XEffectConfig[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ XEffectConfig createFromParcel(Parcel parcel) {
            AppMethodBeat.i(182590);
            XEffectConfig xEffectConfig = new XEffectConfig(parcel);
            AppMethodBeat.o(182590);
            return xEffectConfig;
        }
    };
    public boolean BOM = false;
    public boolean BON = false;
    public int hDb = -1;
    public int hDc = -1;
    public int hDd = -1;
    public int hDe = -1;
    public int hDf = -1;

    public XEffectConfig() {
    }

    protected XEffectConfig(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(182591);
        this.BOM = parcel.readByte() != 0;
        this.BON = parcel.readByte() == 0 ? false : z;
        this.hDb = parcel.readInt();
        this.hDc = parcel.readInt();
        this.hDd = parcel.readInt();
        this.hDe = parcel.readInt();
        this.hDf = parcel.readInt();
        AppMethodBeat.o(182591);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        byte b2 = 1;
        AppMethodBeat.i(182592);
        parcel.writeByte(this.BOM ? (byte) 1 : 0);
        if (!this.BON) {
            b2 = 0;
        }
        parcel.writeByte(b2);
        parcel.writeInt(this.hDb);
        parcel.writeInt(this.hDc);
        parcel.writeInt(this.hDd);
        parcel.writeInt(this.hDe);
        parcel.writeInt(this.hDf);
        AppMethodBeat.o(182592);
    }

    static {
        AppMethodBeat.i(182593);
        AppMethodBeat.o(182593);
    }
}
