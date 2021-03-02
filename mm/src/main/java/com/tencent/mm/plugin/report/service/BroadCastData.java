package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public class BroadCastData implements Parcelable {
    public static final Parcelable.Creator<BroadCastData> CREATOR = new Parcelable.Creator<BroadCastData>() {
        /* class com.tencent.mm.plugin.report.service.BroadCastData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BroadCastData[] newArray(int i2) {
            return new BroadCastData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BroadCastData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(143805);
            BroadCastData broadCastData = new BroadCastData(parcel);
            AppMethodBeat.o(143805);
            return broadCastData;
        }
    };
    ArrayList<KVReportDataInfo> CxU = new ArrayList<>();
    ArrayList<StIDKeyDataInfo> CxV = new ArrayList<>();
    ArrayList<GroupIDKeyDataInfo> CxW = new ArrayList<>();

    public BroadCastData() {
        AppMethodBeat.i(143806);
        AppMethodBeat.o(143806);
    }

    public BroadCastData(BroadCastData broadCastData) {
        AppMethodBeat.i(143807);
        if (broadCastData == null) {
            AppMethodBeat.o(143807);
            return;
        }
        this.CxU = new ArrayList<>(broadCastData.CxU);
        this.CxV = new ArrayList<>(broadCastData.CxV);
        this.CxW = new ArrayList<>(broadCastData.CxW);
        AppMethodBeat.o(143807);
    }

    protected BroadCastData(Parcel parcel) {
        AppMethodBeat.i(143808);
        parcel.readTypedList(this.CxU, KVReportDataInfo.CREATOR);
        parcel.readTypedList(this.CxV, StIDKeyDataInfo.CREATOR);
        parcel.readTypedList(this.CxW, GroupIDKeyDataInfo.CREATOR);
        AppMethodBeat.o(143808);
    }

    static {
        AppMethodBeat.i(143810);
        AppMethodBeat.o(143810);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(143809);
        parcel.writeTypedList(this.CxU);
        parcel.writeTypedList(this.CxV);
        parcel.writeTypedList(this.CxW);
        AppMethodBeat.o(143809);
    }
}
