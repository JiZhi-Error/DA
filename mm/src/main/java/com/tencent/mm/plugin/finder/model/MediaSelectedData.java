package com.tencent.mm.plugin.finder.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjx;

public class MediaSelectedData implements Parcelable {
    public static final Parcelable.Creator<MediaSelectedData> CREATOR = new Parcelable.Creator<MediaSelectedData>() {
        /* class com.tencent.mm.plugin.finder.model.MediaSelectedData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MediaSelectedData[] newArray(int i2) {
            return new MediaSelectedData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MediaSelectedData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(168631);
            MediaSelectedData mediaSelectedData = new MediaSelectedData(parcel);
            AppMethodBeat.o(168631);
            return mediaSelectedData;
        }
    };
    public String path;
    public String thumbPath;
    public int type;
    public cjx uOR = null;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(168632);
        parcel.writeString(this.path);
        parcel.writeString(this.thumbPath);
        parcel.writeInt(this.type);
        AppMethodBeat.o(168632);
    }

    public String toString() {
        AppMethodBeat.i(168633);
        String str = "MediaSelectedData{path='" + this.path + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", type=" + this.type + ", cropInfo=" + this.uOR + '}';
        AppMethodBeat.o(168633);
        return str;
    }

    public MediaSelectedData(int i2) {
        this.type = i2;
    }

    protected MediaSelectedData(Parcel parcel) {
        AppMethodBeat.i(168634);
        this.path = parcel.readString();
        this.thumbPath = parcel.readString();
        this.type = parcel.readInt();
        AppMethodBeat.o(168634);
    }

    static {
        AppMethodBeat.i(168635);
        AppMethodBeat.o(168635);
    }
}
