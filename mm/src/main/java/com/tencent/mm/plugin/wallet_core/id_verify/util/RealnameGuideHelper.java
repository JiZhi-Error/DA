package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;

public class RealnameGuideHelper implements Parcelable {
    public static final Parcelable.Creator<RealnameGuideHelper> CREATOR = new Parcelable.Creator<RealnameGuideHelper>() {
        /* class com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RealnameGuideHelper[] newArray(int i2) {
            return new RealnameGuideHelper[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RealnameGuideHelper createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70168);
            RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper(parcel);
            AppMethodBeat.o(70168);
            return realnameGuideHelper;
        }
    };
    private SetPwdInfo HUB;
    private boolean HUC = false;
    private String lHA = "";
    private String lHB = "";
    private int mEntryScene;
    private String yXI;
    private String yXJ;
    private String yXK = "";

    public RealnameGuideHelper() {
    }

    protected RealnameGuideHelper(Parcel parcel) {
        boolean z;
        AppMethodBeat.i(70169);
        this.HUB = (SetPwdInfo) parcel.readParcelable(SetPwdInfo.class.getClassLoader());
        this.yXI = parcel.readString();
        this.yXJ = parcel.readString();
        this.lHA = parcel.readString();
        this.lHB = parcel.readString();
        this.yXK = parcel.readString();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.HUC = z;
        this.mEntryScene = parcel.readInt();
        AppMethodBeat.o(70169);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70170);
        parcel.writeParcelable(this.HUB, i2);
        parcel.writeString(this.yXI);
        parcel.writeString(this.yXJ);
        parcel.writeString(this.lHA);
        parcel.writeString(this.lHB);
        parcel.writeString(this.yXK);
        parcel.writeByte((byte) (this.HUC ? 1 : 0));
        parcel.writeInt(this.mEntryScene);
        AppMethodBeat.o(70170);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(70175);
        AppMethodBeat.o(70175);
    }

    public final void a(String str, SetPwdInfo setPwdInfo, String str2, String str3, String str4, String str5, int i2) {
        this.HUB = setPwdInfo;
        this.yXI = str;
        this.yXJ = str2;
        this.lHA = str3;
        this.lHB = str4;
        this.yXK = str5;
        this.mEntryScene = i2;
    }

    public final void b(String str, String str2, String str3, String str4, String str5, int i2) {
        AppMethodBeat.i(70171);
        a(str, null, str2, str3, str4, str5, i2);
        AppMethodBeat.o(70171);
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        boolean z = false;
        AppMethodBeat.i(70172);
        Log.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", this.HUB, Integer.valueOf(this.mEntryScene), this.yXJ, this.yXK, this.lHA, this.lHB, Boolean.valueOf(this.HUC), this.yXI);
        if (this.HUC) {
            AppMethodBeat.o(70172);
        } else if (this.HUB == null || this.HUB.HUM != 1) {
            AppMethodBeat.o(70172);
        } else {
            z = a.a(mMActivity, bundle, this.mEntryScene, this.HUB.yXJ, this.HUB.lHA, this.HUB.lHB, onClickListener);
            if (z && !this.HUC) {
                this.HUC = true;
            }
            AppMethodBeat.o(70172);
        }
        return z;
    }

    public final boolean b(MMActivity mMActivity, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(70173);
        boolean a2 = a(mMActivity, bundle, onClickListener, null, false);
        AppMethodBeat.o(70173);
        return a2;
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, DialogInterface.OnClickListener onClickListener, d.a aVar, boolean z) {
        AppMethodBeat.i(70174);
        if (this.HUC) {
            AppMethodBeat.o(70174);
            return false;
        } else if ("1".equals(this.yXI)) {
            if (!this.HUC) {
                this.HUC = true;
            }
            boolean a2 = a.a(mMActivity, bundle, aVar, this.mEntryScene);
            AppMethodBeat.o(70174);
            return a2;
        } else if (!"2".equals(this.yXI) || Util.isNullOrNil(this.yXK)) {
            AppMethodBeat.o(70174);
            return false;
        } else {
            if (!this.HUC) {
                this.HUC = true;
            }
            boolean a3 = a.a(mMActivity, this.yXJ, this.yXK, this.lHA, this.lHB, z, onClickListener);
            AppMethodBeat.o(70174);
            return a3;
        }
    }
}
