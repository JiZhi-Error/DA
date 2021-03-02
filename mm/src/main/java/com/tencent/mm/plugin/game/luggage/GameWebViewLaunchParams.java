package com.tencent.mm.plugin.game.luggage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameWebViewLaunchParams implements Parcelable {
    public static final Parcelable.Creator<GameWebViewLaunchParams> CREATOR = new Parcelable.Creator<GameWebViewLaunchParams>() {
        /* class com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GameWebViewLaunchParams[] newArray(int i2) {
            return new GameWebViewLaunchParams[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GameWebViewLaunchParams createFromParcel(Parcel parcel) {
            AppMethodBeat.i(82982);
            GameWebViewLaunchParams gameWebViewLaunchParams = new GameWebViewLaunchParams(parcel, (byte) 0);
            AppMethodBeat.o(82982);
            return gameWebViewLaunchParams;
        }
    };
    public GameFloatLayerInfo xvZ;

    /* synthetic */ GameWebViewLaunchParams(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(82983);
        parcel.writeParcelable(this.xvZ, i2);
        AppMethodBeat.o(82983);
    }

    public GameWebViewLaunchParams() {
    }

    private GameWebViewLaunchParams(Parcel parcel) {
        AppMethodBeat.i(82984);
        this.xvZ = (GameFloatLayerInfo) parcel.readParcelable(GameFloatLayerInfo.class.getClassLoader());
        AppMethodBeat.o(82984);
    }

    static {
        AppMethodBeat.i(82985);
        AppMethodBeat.o(82985);
    }
}
