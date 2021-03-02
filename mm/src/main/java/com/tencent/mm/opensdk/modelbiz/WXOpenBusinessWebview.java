package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.util.HashMap;

public class WXOpenBusinessWebview {

    public static class Req extends BaseReq {
        public int businessType;
        public HashMap<String, String> queryInfo;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3918);
            super.fromBundle(bundle);
            this.queryInfo = (HashMap) bundle.getSerializable("_wxapi_open_business_webview_query_info");
            this.businessType = bundle.getInt("_wxapi_open_business_webview_query_type", 0);
            AppMethodBeat.o(3918);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 25;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3919);
            super.toBundle(bundle);
            bundle.putSerializable("_wxapi_open_business_webview_query_info", this.queryInfo);
            bundle.putInt("_wxapi_open_business_webview_query_type", this.businessType);
            AppMethodBeat.o(3919);
        }
    }

    public static class Resp extends BaseResp {
        public int businessType;
        public String resultInfo;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(3895);
            fromBundle(bundle);
            AppMethodBeat.o(3895);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3896);
            super.fromBundle(bundle);
            this.resultInfo = bundle.getString("_wxapi_open_business_webview_result");
            this.businessType = bundle.getInt("_wxapi_open_business_webview_query_type", 0);
            AppMethodBeat.o(3896);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 25;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3897);
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_business_webview_result", this.resultInfo);
            bundle.putInt("_wxapi_open_business_webview_query_type", this.businessType);
            AppMethodBeat.o(3897);
        }
    }
}
