package com.tencent.mm.plugin.gallery.model;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SelectedItem implements Parcelable {
    public static final Parcelable.Creator<SelectedItem> CREATOR = new Parcelable.Creator<SelectedItem>() {
        /* class com.tencent.mm.plugin.gallery.model.SelectedItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SelectedItem[] newArray(int i2) {
            return new SelectedItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SelectedItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(164769);
            SelectedItem selectedItem = new SelectedItem(parcel);
            AppMethodBeat.o(164769);
            return selectedItem;
        }
    };
    public Matrix gT;
    public String path;
    public int type;
    public long xjE;

    public int hashCode() {
        return this.type;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(164770);
        if (!(obj instanceof SelectedItem)) {
            boolean equals = super.equals(obj);
            AppMethodBeat.o(164770);
            return equals;
        } else if (((SelectedItem) obj).xjE == this.xjE) {
            AppMethodBeat.o(164770);
            return true;
        } else {
            AppMethodBeat.o(164770);
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(164771);
        parcel.writeString(this.path);
        parcel.writeLong(this.xjE);
        float[] fArr = new float[9];
        this.gT.getValues(fArr);
        parcel.writeFloatArray(fArr);
        parcel.writeInt(this.type);
        AppMethodBeat.o(164771);
    }

    public SelectedItem() {
    }

    protected SelectedItem(Parcel parcel) {
        AppMethodBeat.i(164772);
        this.path = parcel.readString();
        this.xjE = parcel.readLong();
        this.gT.setValues(parcel.createFloatArray());
        this.type = parcel.readInt();
        AppMethodBeat.o(164772);
    }

    static {
        AppMethodBeat.i(164773);
        AppMethodBeat.o(164773);
    }
}
