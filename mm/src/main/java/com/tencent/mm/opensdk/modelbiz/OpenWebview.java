package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

public class OpenWebview {

    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String url;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(3910);
            String str = this.url;
            if (str == null || str.length() < 0) {
                AppMethodBeat.o(3910);
                return false;
            } else if (this.url.length() > 10240) {
                AppMethodBeat.o(3910);
                return false;
            } else {
                AppMethodBeat.o(3910);
                return true;
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3911);
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_jump_to_webview_url");
            AppMethodBeat.o(3911);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 12;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3912);
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_webview_url", URLEncoder.encode(this.url));
            AppMethodBeat.o(3912);
        }
    }

    public static class Resp extends BaseResp {
        public String result;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(3859);
            fromBundle(bundle);
            AppMethodBeat.o(3859);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3860);
            super.fromBundle(bundle);
            this.result = bundle.getString("_wxapi_open_webview_result");
            AppMethodBeat.o(3860);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 12;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3861);
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_webview_result", this.result);
            AppMethodBeat.o(3861);
        }
    }
}
