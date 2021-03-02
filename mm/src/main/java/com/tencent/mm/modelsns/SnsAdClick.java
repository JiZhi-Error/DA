package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdClick implements Parcelable {
    public static final Parcelable.Creator<SnsAdClick> CREATOR = new Parcelable.Creator<SnsAdClick>() {
        /* class com.tencent.mm.modelsns.SnsAdClick.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SnsAdClick[] newArray(int i2) {
            return new SnsAdClick[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SnsAdClick createFromParcel(Parcel parcel) {
            AppMethodBeat.i(125652);
            SnsAdClick snsAdClick = new SnsAdClick();
            snsAdClick.source = parcel.readInt();
            snsAdClick.jkT = parcel.readInt();
            snsAdClick.ece = parcel.readLong();
            snsAdClick.jkU = parcel.readInt();
            snsAdClick.jkV = parcel.readInt();
            snsAdClick.jkW = parcel.readInt();
            snsAdClick.jkX = parcel.readInt();
            snsAdClick.startTime = parcel.readLong();
            snsAdClick.jkZ = parcel.readLong();
            snsAdClick.jlb = parcel.readLong();
            snsAdClick.jlc = parcel.readLong();
            AppMethodBeat.o(125652);
            return snsAdClick;
        }
    };
    public long ece;
    public int jkT;
    public int jkU;
    public int jkV;
    public int jkW;
    public int jkX;
    public long jkY;
    public long jkZ;
    public int jla;
    public long jlb;
    public long jlc;
    public int source;
    public long startTime;

    public SnsAdClick() {
        this.jkT = 0;
        this.jkU = 0;
        this.jkV = 0;
        this.startTime = 0;
        this.jkW = 0;
        this.jkX = 0;
        this.jkY = 0;
        this.jkZ = 0;
        this.jla = 0;
        this.jlb = 0;
        this.jlc = 0;
    }

    public SnsAdClick(int i2, long j2) {
        this(i2, 7, j2, 0, 0, 0);
    }

    public SnsAdClick(int i2, int i3, long j2, int i4, int i5) {
        this(i2, i3, j2, i4, i5, 0);
    }

    public SnsAdClick(int i2, int i3, long j2, int i4, int i5, byte b2) {
        this(i2, i3, j2, 22, i4, i5);
    }

    private SnsAdClick(int i2, int i3, long j2, int i4, int i5, int i6) {
        AppMethodBeat.i(125653);
        this.jkT = 0;
        this.jkU = 0;
        this.jkV = 0;
        this.startTime = 0;
        this.jkW = 0;
        this.jkX = 0;
        this.jkY = 0;
        this.jkZ = 0;
        this.jla = 0;
        this.jlb = 0;
        this.jlc = 0;
        this.source = i2;
        this.jkT = i3;
        this.ece = j2;
        this.jkU = i4;
        this.jkV = i5;
        this.jkW = 0;
        this.jkX = 0;
        this.jla = i6;
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.o(125653);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(125654);
        parcel.writeInt(this.source);
        parcel.writeInt(this.jkT);
        parcel.writeLong(this.ece);
        parcel.writeInt(this.jkU);
        parcel.writeInt(this.jkV);
        parcel.writeInt(this.jkW);
        parcel.writeInt(this.jkX);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.jkZ);
        parcel.writeLong(this.jlb);
        parcel.writeLong(this.jlc);
        AppMethodBeat.o(125654);
    }

    static {
        AppMethodBeat.i(125655);
        AppMethodBeat.o(125655);
    }
}
