package com.tencent.mm.plugin.game.luggage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameFloatLayerInfo implements Parcelable {
    public static final Parcelable.Creator<GameFloatLayerInfo> CREATOR = new Parcelable.Creator<GameFloatLayerInfo>() {
        /* class com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GameFloatLayerInfo[] newArray(int i2) {
            return new GameFloatLayerInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GameFloatLayerInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(82972);
            GameFloatLayerInfo gameFloatLayerInfo = new GameFloatLayerInfo(parcel, (byte) 0);
            AppMethodBeat.o(82972);
            return gameFloatLayerInfo;
        }
    };
    public int orientation;
    public String url;
    public boolean xvW;

    /* synthetic */ GameFloatLayerInfo(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(82973);
        parcel.writeString(this.url);
        parcel.writeInt(this.xvW ? 1 : 0);
        parcel.writeInt(this.orientation);
        AppMethodBeat.o(82973);
    }

    public GameFloatLayerInfo() {
        this.xvW = false;
        this.orientation = -1;
    }

    private GameFloatLayerInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(82974);
        this.xvW = false;
        this.orientation = -1;
        this.url = parcel.readString();
        this.xvW = parcel.readInt() != 1 ? false : z;
        this.orientation = parcel.readInt();
        AppMethodBeat.o(82974);
    }

    static {
        AppMethodBeat.i(82975);
        AppMethodBeat.o(82975);
    }
}
