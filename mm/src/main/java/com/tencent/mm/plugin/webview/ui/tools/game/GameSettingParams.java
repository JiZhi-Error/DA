package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameSettingParams implements Parcelable {
    public static final Parcelable.Creator<GameSettingParams> CREATOR = new Parcelable.Creator<GameSettingParams>() {
        /* class com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GameSettingParams[] newArray(int i2) {
            return new GameSettingParams[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GameSettingParams createFromParcel(Parcel parcel) {
            AppMethodBeat.i(80861);
            GameSettingParams gameSettingParams = new GameSettingParams(parcel, (byte) 0);
            AppMethodBeat.o(80861);
            return gameSettingParams;
        }
    };
    public String Jqj;
    public String Jqk;
    public String Jql;

    /* synthetic */ GameSettingParams(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(80862);
        parcel.writeString(this.Jqj);
        parcel.writeString(this.Jqk);
        parcel.writeString(this.Jql);
        AppMethodBeat.o(80862);
    }

    public GameSettingParams() {
    }

    private GameSettingParams(Parcel parcel) {
        AppMethodBeat.i(80863);
        this.Jqj = parcel.readString();
        this.Jqk = parcel.readString();
        this.Jql = parcel.readString();
        AppMethodBeat.o(80863);
    }

    static {
        AppMethodBeat.i(80864);
        AppMethodBeat.o(80864);
    }
}
