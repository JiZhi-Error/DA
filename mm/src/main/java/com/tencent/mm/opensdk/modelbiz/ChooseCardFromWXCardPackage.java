package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class ChooseCardFromWXCardPackage {
    private static final String TAG = "MicroMsg.ChooseCardFromWXCardPackage";

    public static class Req extends BaseReq {
        public String appId;
        public String canMultiSelect;
        public String cardId;
        public String cardSign;
        public String cardType;
        public String locationId;
        public String nonceStr;
        public String signType;
        public String timeStamp;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(3873);
            String str = this.appId;
            if (str == null || str.length() <= 0) {
                AppMethodBeat.o(3873);
                return false;
            }
            String str2 = this.signType;
            if (str2 == null || str2.length() <= 0) {
                AppMethodBeat.o(3873);
                return false;
            }
            String str3 = this.cardSign;
            if (str3 == null || str3.length() <= 0) {
                AppMethodBeat.o(3873);
                return false;
            }
            AppMethodBeat.o(3873);
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 16;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3874);
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
            bundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
            bundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
            bundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
            bundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
            bundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
            AppMethodBeat.o(3874);
        }
    }

    public static class Resp extends BaseResp {
        public String cardItemList;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(3888);
            fromBundle(bundle);
            AppMethodBeat.o(3888);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            AppMethodBeat.i(3889);
            String str = this.cardItemList;
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(3889);
                return false;
            }
            AppMethodBeat.o(3889);
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3891);
            super.fromBundle(bundle);
            String string = bundle.getString("_wxapi_choose_card_from_wx_card_list");
            if (string == null || string.length() <= 0) {
                Log.i(ChooseCardFromWXCardPackage.TAG, "cardItemList is empty!");
                AppMethodBeat.o(3891);
                return;
            }
            this.cardItemList = string;
            AppMethodBeat.o(3891);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 16;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3890);
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
            AppMethodBeat.o(3890);
        }
    }
}
