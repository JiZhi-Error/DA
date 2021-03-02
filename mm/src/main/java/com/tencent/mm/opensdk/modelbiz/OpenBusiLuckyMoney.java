package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class OpenBusiLuckyMoney {

    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String appId;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String timeStamp;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(3850);
            String str = this.appId;
            if (str == null || str.length() <= 0) {
                AppMethodBeat.o(3850);
                return false;
            }
            String str2 = this.timeStamp;
            if (str2 == null || str2.length() <= 0) {
                AppMethodBeat.o(3850);
                return false;
            }
            String str3 = this.nonceStr;
            if (str3 == null || str3.length() <= 0) {
                AppMethodBeat.o(3850);
                return false;
            }
            String str4 = this.signType;
            if (str4 == null || str4.length() <= 0) {
                AppMethodBeat.o(3850);
                return false;
            }
            String str5 = this.signature;
            if (str5 == null || str5.length() <= 0) {
                AppMethodBeat.o(3850);
                return false;
            }
            AppMethodBeat.o(3850);
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 13;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3851);
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
            bundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
            bundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
            bundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
            bundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
            bundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
            AppMethodBeat.o(3851);
        }
    }
}
