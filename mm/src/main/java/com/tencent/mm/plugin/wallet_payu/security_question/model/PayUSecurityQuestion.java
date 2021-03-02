package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PayUSecurityQuestion implements Parcelable {
    public static final Parcelable.Creator<PayUSecurityQuestion> CREATOR = new Parcelable.Creator<PayUSecurityQuestion>() {
        /* class com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PayUSecurityQuestion[] newArray(int i2) {
            return new PayUSecurityQuestion[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PayUSecurityQuestion createFromParcel(Parcel parcel) {
            AppMethodBeat.i(72215);
            PayUSecurityQuestion payUSecurityQuestion = new PayUSecurityQuestion(parcel);
            AppMethodBeat.o(72215);
            return payUSecurityQuestion;
        }
    };
    public String desc;
    public String id;

    public PayUSecurityQuestion(String str, String str2) {
        this.id = str;
        this.desc = str2;
    }

    public PayUSecurityQuestion(Parcel parcel) {
        AppMethodBeat.i(72216);
        this.id = parcel.readString();
        this.desc = parcel.readString();
        AppMethodBeat.o(72216);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(72217);
        parcel.writeString(this.id);
        parcel.writeString(this.desc);
        AppMethodBeat.o(72217);
    }

    static {
        AppMethodBeat.i(72218);
        AppMethodBeat.o(72218);
    }
}
