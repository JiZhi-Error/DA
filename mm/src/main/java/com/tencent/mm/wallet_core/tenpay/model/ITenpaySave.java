package com.tencent.mm.wallet_core.tenpay.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import org.json.JSONObject;

public interface ITenpaySave {
    RetryPayInfo getRetryPayInfo();

    public static class RetryPayInfo implements Parcelable {
        public static final Parcelable.Creator<RetryPayInfo> CREATOR = new Parcelable.Creator<RetryPayInfo>() {
            /* class com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ RetryPayInfo[] newArray(int i2) {
                return new RetryPayInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RetryPayInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(72886);
                RetryPayInfo retryPayInfo = new RetryPayInfo(parcel);
                AppMethodBeat.o(72886);
                return retryPayInfo;
            }
        };
        public int MSD;
        public int RuH;
        public String RuI;

        public RetryPayInfo() {
            this.RuH = -1;
            this.MSD = -1;
            this.RuI = "";
        }

        protected RetryPayInfo(Parcel parcel) {
            AppMethodBeat.i(72887);
            this.RuH = parcel.readInt();
            this.MSD = parcel.readInt();
            this.RuI = parcel.readString();
            AppMethodBeat.o(72887);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(72888);
            parcel.writeInt(this.RuH);
            parcel.writeInt(this.MSD);
            parcel.writeString(this.RuI);
            AppMethodBeat.o(72888);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(72890);
            AppMethodBeat.o(72890);
        }

        public final boolean exv() {
            if (this.RuH == -1 || this.MSD == -1) {
                return false;
            }
            return true;
        }

        public final void bK(JSONObject jSONObject) {
            AppMethodBeat.i(72889);
            if (jSONObject == null) {
                AppMethodBeat.o(72889);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("retry_pay_info");
            if (optJSONObject == null) {
                AppMethodBeat.o(72889);
                return;
            }
            this.RuH = optJSONObject.optInt(TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, -1);
            this.MSD = optJSONObject.optInt("max_retry_count", -1);
            this.RuI = optJSONObject.optString("retry_fail_wording", "");
            AppMethodBeat.o(72889);
        }
    }
}
