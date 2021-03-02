package com.tencent.mm.plugin.appbrand.game.cgipkg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.protocal.protobuf.bnw;

public class GameMenuParcel implements Parcelable {
    public static final Parcelable.Creator<GameMenuParcel> CREATOR = new Parcelable.Creator<GameMenuParcel>() {
        /* class com.tencent.mm.plugin.appbrand.game.cgipkg.GameMenuParcel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GameMenuParcel[] newArray(int i2) {
            return new GameMenuParcel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GameMenuParcel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(45091);
            GameMenuParcel gameMenuParcel = new GameMenuParcel(parcel, (byte) 0);
            AppMethodBeat.o(45091);
            return gameMenuParcel;
        }
    };
    public String appId;
    public bnw lro;

    /* synthetic */ GameMenuParcel(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(45092);
        parcel.writeString(this.appId);
        c.a(this.lro, parcel);
        AppMethodBeat.o(45092);
    }

    public GameMenuParcel() {
    }

    private GameMenuParcel(Parcel parcel) {
        AppMethodBeat.i(45093);
        this.appId = parcel.readString();
        this.lro = (bnw) c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
        AppMethodBeat.o(45093);
    }

    static {
        AppMethodBeat.i(45094);
        AppMethodBeat.o(45094);
    }
}
