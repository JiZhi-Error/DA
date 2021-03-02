package com.tencent.mm.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BindWordingContent implements Parcelable {
    public static final Parcelable.Creator<BindWordingContent> CREATOR = new Parcelable.Creator<BindWordingContent>() {
        /* class com.tencent.mm.modelsimple.BindWordingContent.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BindWordingContent[] newArray(int i2) {
            return new BindWordingContent[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BindWordingContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134143);
            BindWordingContent bindWordingContent = new BindWordingContent(parcel);
            AppMethodBeat.o(134143);
            return bindWordingContent;
        }
    };
    public String content = "";
    public Integer jiW = 0;
    public String title = "";

    public BindWordingContent(String str, String str2) {
        AppMethodBeat.i(134144);
        this.title = str;
        this.content = str2;
        AppMethodBeat.o(134144);
    }

    public BindWordingContent(Parcel parcel) {
        AppMethodBeat.i(134145);
        String[] strArr = new String[2];
        parcel.readStringArray(strArr);
        this.title = strArr[0];
        this.content = strArr[1];
        this.jiW = Integer.valueOf(parcel.readInt());
        AppMethodBeat.o(134145);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134146);
        parcel.writeStringArray(new String[]{this.title, this.content});
        parcel.writeInt(this.jiW.intValue());
        AppMethodBeat.o(134146);
    }

    static {
        AppMethodBeat.i(134147);
        AppMethodBeat.o(134147);
    }
}
