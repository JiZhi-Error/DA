package com.tencent.mm.plugin.appbrand.keylogger.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public interface IKeyStepAnalyser {

    public interface a {
        void bM(List<b> list);
    }

    public static final class b {
        public ArrayList<StepLogInfo> mPu = new ArrayList<>();
        public StringBuilder mPv = new StringBuilder();

        public b() {
            AppMethodBeat.i(221320);
            AppMethodBeat.o(221320);
        }
    }

    public static final class StepLogInfo implements Parcelable {
        public static final Parcelable.Creator<StepLogInfo> CREATOR = new Parcelable.Creator<StepLogInfo>() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StepLogInfo[] newArray(int i2) {
                return new StepLogInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StepLogInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(221321);
                StepLogInfo stepLogInfo = new StepLogInfo(parcel);
                AppMethodBeat.o(221321);
                return stepLogInfo;
            }
        };
        public long cCv = -1;
        public String errMsg;
        public String mPw;
        public boolean mPx;
        public String mPy;
        public String sessionId;
        public long time;

        public StepLogInfo() {
        }

        public StepLogInfo(Parcel parcel) {
            AppMethodBeat.i(221322);
            this.time = parcel.readLong();
            this.sessionId = parcel.readString();
            this.mPw = parcel.readString();
            this.mPx = parcel.readByte() != 0;
            this.errMsg = parcel.readString();
            this.mPy = parcel.readString();
            this.cCv = parcel.readLong();
            AppMethodBeat.o(221322);
        }

        static {
            AppMethodBeat.i(221325);
            AppMethodBeat.o(221325);
        }

        public final boolean bMX() {
            AppMethodBeat.i(221323);
            boolean equals = "END".equals(this.mPw);
            AppMethodBeat.o(221323);
            return equals;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(221324);
            parcel.writeLong(this.time);
            parcel.writeString(this.sessionId);
            parcel.writeString(this.mPw);
            parcel.writeByte((byte) (this.mPx ? 1 : 0));
            parcel.writeString(this.errMsg);
            parcel.writeString(this.mPy);
            parcel.writeLong(this.cCv);
            AppMethodBeat.o(221324);
        }
    }
}
