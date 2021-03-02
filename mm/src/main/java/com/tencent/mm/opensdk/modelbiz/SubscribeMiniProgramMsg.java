package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public final class SubscribeMiniProgramMsg {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
        public String miniProgramAppId;

        public Req() {
        }

        public Req(Bundle bundle) {
            AppMethodBeat.i(3936);
            fromBundle(bundle);
            AppMethodBeat.o(3936);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(3939);
            String str = this.miniProgramAppId;
            if (str == null || str.length() == 0) {
                Log.e(TAG, "checkArgs fail, miniProgramAppId is null");
                AppMethodBeat.o(3939);
                return false;
            }
            AppMethodBeat.o(3939);
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3937);
            super.fromBundle(bundle);
            this.miniProgramAppId = bundle.getString("_wxapi_subscribeminiprogram_req_miniprogramappid");
            AppMethodBeat.o(3937);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 23;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3938);
            super.toBundle(bundle);
            bundle.putString("_wxapi_subscribeminiprogram_req_miniprogramappid", this.miniProgramAppId);
            AppMethodBeat.o(3938);
        }
    }

    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
        public String nickname;
        public String unionId;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(3904);
            fromBundle(bundle);
            AppMethodBeat.o(3904);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3905);
            super.fromBundle(bundle);
            this.unionId = bundle.getString("_wxapi_subscribeminiprogram_resp_unionId");
            this.nickname = bundle.getString("_wxapi_subscribeminiprogram_resp_nickname");
            AppMethodBeat.o(3905);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 23;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3906);
            super.toBundle(bundle);
            bundle.putString("_wxapi_subscribeminiprogram_resp_unionId", this.unionId);
            bundle.putString("_wxapi_subscribeminiprogram_resp_nickname", this.nickname);
            AppMethodBeat.o(3906);
        }
    }

    private SubscribeMiniProgramMsg() {
    }
}
