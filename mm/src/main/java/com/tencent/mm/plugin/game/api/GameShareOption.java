package com.tencent.mm.plugin.game.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameShareOption implements Parcelable {
    public static final Parcelable.Creator<GameShareOption> CREATOR = new Parcelable.Creator<GameShareOption>() {
        /* class com.tencent.mm.plugin.game.api.GameShareOption.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GameShareOption[] newArray(int i2) {
            return new GameShareOption[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GameShareOption createFromParcel(Parcel parcel) {
            AppMethodBeat.i(89656);
            GameShareOption gameShareOption = new GameShareOption(parcel);
            AppMethodBeat.o(89656);
            return gameShareOption;
        }
    };
    public int id;
    public String title;
    public boolean xtX = false;

    public GameShareOption(int i2, String str, boolean z) {
        this.id = i2;
        this.title = str;
        this.xtX = z;
    }

    protected GameShareOption(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(89657);
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.xtX = parcel.readInt() != 1 ? false : z;
        AppMethodBeat.o(89657);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(89658);
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeInt(this.xtX ? 1 : 0);
        AppMethodBeat.o(89658);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(89659);
        AppMethodBeat.o(89659);
    }
}
