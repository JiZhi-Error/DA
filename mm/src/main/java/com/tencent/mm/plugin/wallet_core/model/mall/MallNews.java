package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallNews implements Parcelable {
    public static final Parcelable.Creator<MallNews> CREATOR = new Parcelable.Creator<MallNews>() {
        /* class com.tencent.mm.plugin.wallet_core.model.mall.MallNews.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MallNews[] newArray(int i2) {
            return new MallNews[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MallNews createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70547);
            MallNews mallNews = new MallNews(parcel);
            AppMethodBeat.o(70547);
            return mallNews;
        }
    };
    public int DrO;
    public String FJm;
    public String Icl = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public String Icm = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public String Icn;
    public String Ico;
    public String Icp;
    public String Icq;
    public int Icr;
    public String Ics;
    public String Ict;
    public int dDG;
    public String dHx;
    public String iLU;
    public int trD;
    public String type;

    public MallNews(String str) {
        this.iLU = str;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(70548);
        if (obj instanceof MallNews) {
            MallNews mallNews = (MallNews) obj;
            if (this.iLU == null || !this.iLU.equals(mallNews.iLU)) {
                AppMethodBeat.o(70548);
                return false;
            } else if (this.FJm == null || !this.FJm.equals(mallNews.FJm)) {
                AppMethodBeat.o(70548);
                return false;
            } else {
                AppMethodBeat.o(70548);
                return true;
            }
        } else {
            AppMethodBeat.o(70548);
            return false;
        }
    }

    public MallNews(Parcel parcel) {
        AppMethodBeat.i(70549);
        this.iLU = parcel.readString();
        this.FJm = parcel.readString();
        this.dHx = parcel.readString();
        this.Icn = parcel.readString();
        this.Ico = parcel.readString();
        this.Icp = parcel.readString();
        this.DrO = parcel.readInt();
        this.Icq = parcel.readString();
        this.Icl = parcel.readString();
        this.Icm = parcel.readString();
        this.dDG = parcel.readInt();
        this.Ics = parcel.readString();
        this.trD = parcel.readInt();
        this.Ict = parcel.readString();
        AppMethodBeat.o(70549);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70550);
        parcel.writeString(this.iLU);
        parcel.writeString(this.FJm);
        parcel.writeString(this.dHx);
        parcel.writeString(this.Icn);
        parcel.writeString(this.Ico);
        parcel.writeString(this.Icp);
        parcel.writeInt(this.DrO);
        parcel.writeString(this.Icq);
        parcel.writeString(this.Icl);
        parcel.writeString(this.Icm);
        parcel.writeInt(this.dDG);
        parcel.writeString(this.Ics);
        parcel.writeInt(this.trD);
        parcel.writeString(this.Ict);
        AppMethodBeat.o(70550);
    }

    static {
        AppMethodBeat.i(70552);
        AppMethodBeat.o(70552);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        AppMethodBeat.i(70551);
        String format = String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", this.iLU, this.FJm, this.dHx, this.Icn, this.Ico, this.Icp, this.Icl, this.Ics, this.Icq, Integer.valueOf(this.trD), this.Ict);
        AppMethodBeat.o(70551);
        return format;
    }
}
