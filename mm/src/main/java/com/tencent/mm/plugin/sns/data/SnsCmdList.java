package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public class SnsCmdList implements Parcelable {
    public static final Parcelable.Creator<SnsCmdList> CREATOR = new Parcelable.Creator<SnsCmdList>() {
        /* class com.tencent.mm.plugin.sns.data.SnsCmdList.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SnsCmdList[] newArray(int i2) {
            return new SnsCmdList[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SnsCmdList createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95076);
            SnsCmdList snsCmdList = new SnsCmdList();
            snsCmdList.DEj = parcel.readInt();
            snsCmdList.DEl.clear();
            for (int i2 = 0; i2 < snsCmdList.DEj; i2++) {
                snsCmdList.DEl.add(Integer.valueOf(parcel.readInt()));
            }
            snsCmdList.DEk = parcel.readInt();
            snsCmdList.DEm.clear();
            for (int i3 = 0; i3 < snsCmdList.DEk; i3++) {
                snsCmdList.DEm.add(Integer.valueOf(parcel.readInt()));
            }
            AppMethodBeat.o(95076);
            return snsCmdList;
        }
    };
    private int DEj = 0;
    private int DEk = 0;
    public List<Integer> DEl = new LinkedList();
    public List<Integer> DEm = new LinkedList();

    public SnsCmdList() {
        AppMethodBeat.i(95077);
        AppMethodBeat.o(95077);
    }

    public final void Yj(int i2) {
        AppMethodBeat.i(95078);
        this.DEl.add(Integer.valueOf(i2));
        AppMethodBeat.o(95078);
    }

    public final void Yk(int i2) {
        AppMethodBeat.i(95079);
        this.DEm.add(Integer.valueOf(i2));
        AppMethodBeat.o(95079);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(95080);
        this.DEj = this.DEl.size();
        parcel.writeInt(this.DEj);
        for (int i3 = 0; i3 < this.DEj; i3++) {
            parcel.writeInt(this.DEl.get(i3).intValue());
        }
        this.DEk = this.DEm.size();
        parcel.writeInt(this.DEk);
        for (int i4 = 0; i4 < this.DEk; i4++) {
            parcel.writeInt(this.DEm.get(i4).intValue());
        }
        AppMethodBeat.o(95080);
    }

    static {
        AppMethodBeat.i(95081);
        AppMethodBeat.o(95081);
    }
}
