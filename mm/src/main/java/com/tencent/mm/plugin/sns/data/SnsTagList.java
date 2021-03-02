package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public class SnsTagList implements Parcelable {
    public static final Parcelable.Creator<SnsTagList> CREATOR = new Parcelable.Creator<SnsTagList>() {
        /* class com.tencent.mm.plugin.sns.data.SnsTagList.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SnsTagList[] newArray(int i2) {
            return new SnsTagList[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SnsTagList createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95090);
            SnsTagList snsTagList = new SnsTagList();
            snsTagList.DEx = parcel.readInt();
            for (int i2 = 0; i2 < snsTagList.DEx; i2++) {
                snsTagList.DEy.add(Long.valueOf(parcel.readLong()));
            }
            AppMethodBeat.o(95090);
            return snsTagList;
        }
    };
    private int DEx = 0;
    private List<Long> DEy = new LinkedList();

    public SnsTagList() {
        AppMethodBeat.i(95091);
        AppMethodBeat.o(95091);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(95092);
        this.DEx = this.DEy.size();
        parcel.writeInt(this.DEx);
        for (Long l : this.DEy) {
            parcel.writeLong(l.longValue());
        }
        AppMethodBeat.o(95092);
    }

    static {
        AppMethodBeat.i(95093);
        AppMethodBeat.o(95093);
    }
}
