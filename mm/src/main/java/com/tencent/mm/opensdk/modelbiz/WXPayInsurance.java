package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXPayInsurance {

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXPayInsurance.Req";
        private static final int URL_LENGTH_LIMIT = 10240;
        public String url;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final boolean checkArgs() {
            AppMethodBeat.i(3892);
            if (b.b(this.url)) {
                Log.i(TAG, "url should not be empty");
                AppMethodBeat.o(3892);
                return false;
            } else if (this.url.length() > 10240) {
                Log.e(TAG, "url must be in 10k");
                AppMethodBeat.o(3892);
                return false;
            } else {
                AppMethodBeat.o(3892);
                return true;
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3894);
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_pay_insourance_req_url");
            AppMethodBeat.o(3894);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final int getType() {
            return 22;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(3893);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_pay_insourance_req_url", this.url);
            AppMethodBeat.o(3893);
        }
    }

    public static final class Resp extends BaseResp {
        public String wxOrderId;

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3863);
            super.fromBundle(bundle);
            this.wxOrderId = bundle.getString("_wxapi_pay_insourance_order_id");
            AppMethodBeat.o(3863);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final int getType() {
            return 22;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(3862);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_pay_insourance_order_id", this.wxOrderId);
            AppMethodBeat.o(3862);
        }
    }
}
