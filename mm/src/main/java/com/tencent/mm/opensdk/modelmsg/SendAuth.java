package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public final class SendAuth {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
        public String extData;
        public String scope;
        public String state;

        public Req() {
        }

        public Req(Bundle bundle) {
            AppMethodBeat.i(3949);
            fromBundle(bundle);
            AppMethodBeat.o(3949);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(3952);
            String str = this.scope;
            if (str == null || str.length() == 0 || this.scope.length() > 1024) {
                Log.e(TAG, "checkArgs fail, scope is invalid");
                AppMethodBeat.o(3952);
                return false;
            }
            String str2 = this.state;
            if (str2 == null || str2.length() <= 1024) {
                AppMethodBeat.o(3952);
                return true;
            }
            Log.e(TAG, "checkArgs fail, state is invalid");
            AppMethodBeat.o(3952);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3950);
            super.fromBundle(bundle);
            this.scope = bundle.getString("_wxapi_sendauth_req_scope");
            this.state = bundle.getString("_wxapi_sendauth_req_state");
            this.extData = bundle.getString("_wxapi_sendauth_req_ext_data");
            AppMethodBeat.o(3950);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3951);
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_req_scope", this.scope);
            bundle.putString("_wxapi_sendauth_req_state", this.state);
            bundle.putString("_wxapi_sendauth_req_ext_data", this.extData);
            AppMethodBeat.o(3951);
        }
    }

    public static class Resp extends BaseResp {
        public static final int ERR_SCOPE_SNSAPI_WXAAPP_INFO_CAN_ONLY_AUTHORIZED_SEPARATELY = -1000;
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
        public boolean authResult = false;
        public String code;
        public String country;
        public String lang;
        public String state;
        public String url;

        public Resp() {
            AppMethodBeat.i(190395);
            AppMethodBeat.o(190395);
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(3963);
            fromBundle(bundle);
            AppMethodBeat.o(3963);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            AppMethodBeat.i(3966);
            String str = this.state;
            if (str == null || str.length() <= 1024) {
                AppMethodBeat.o(3966);
                return true;
            }
            Log.e(TAG, "checkArgs fail, state is invalid");
            AppMethodBeat.o(3966);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3964);
            super.fromBundle(bundle);
            this.code = bundle.getString("_wxapi_sendauth_resp_token");
            this.state = bundle.getString("_wxapi_sendauth_resp_state");
            this.url = bundle.getString("_wxapi_sendauth_resp_url");
            this.lang = bundle.getString("_wxapi_sendauth_resp_lang");
            this.country = bundle.getString("_wxapi_sendauth_resp_country");
            this.authResult = bundle.getBoolean("_wxapi_sendauth_resp_auth_result");
            AppMethodBeat.o(3964);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3965);
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_resp_token", this.code);
            bundle.putString("_wxapi_sendauth_resp_state", this.state);
            bundle.putString("_wxapi_sendauth_resp_url", this.url);
            bundle.putString("_wxapi_sendauth_resp_lang", this.lang);
            bundle.putString("_wxapi_sendauth_resp_country", this.country);
            bundle.putBoolean("_wxapi_sendauth_resp_auth_result", this.authResult);
            AppMethodBeat.o(3965);
        }
    }

    private SendAuth() {
    }
}
