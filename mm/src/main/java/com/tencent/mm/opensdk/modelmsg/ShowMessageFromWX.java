package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public class ShowMessageFromWX {

    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public WXMediaMessage message;

        public Req() {
        }

        public Req(Bundle bundle) {
            AppMethodBeat.i(3973);
            fromBundle(bundle);
            AppMethodBeat.o(3973);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(3976);
            WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage == null) {
                AppMethodBeat.o(3976);
                return false;
            }
            boolean checkArgs = wXMediaMessage.checkArgs();
            AppMethodBeat.o(3976);
            return checkArgs;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3975);
            super.fromBundle(bundle);
            this.lang = bundle.getString("_wxapi_showmessage_req_lang");
            this.country = bundle.getString("_wxapi_showmessage_req_country");
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
            AppMethodBeat.o(3975);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 4;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3974);
            Bundle bundle2 = WXMediaMessage.Builder.toBundle(this.message);
            super.toBundle(bundle2);
            bundle.putString("_wxapi_showmessage_req_lang", this.lang);
            bundle.putString("_wxapi_showmessage_req_country", this.country);
            bundle.putAll(bundle2);
            AppMethodBeat.o(3974);
        }
    }

    public static class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(3957);
            fromBundle(bundle);
            AppMethodBeat.o(3957);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 4;
        }
    }

    private ShowMessageFromWX() {
    }
}
