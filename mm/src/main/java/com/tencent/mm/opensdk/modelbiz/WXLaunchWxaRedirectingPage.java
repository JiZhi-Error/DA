package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class WXLaunchWxaRedirectingPage {
    public static final String URI_PATH = "launchWxaOpenApiRedirectingPage";

    interface ConstantsWxaRedirectingPage {
        public static final String KEY_CALLBACK_ACTIVITY = "_launch_wx_wxa_redirecting_page_callback_activity";
        public static final String KEY_CALLBACK_MSG = "_launch_wx_wxa_redirecting_page_callback_msg";
        public static final String KEY_INVOKE_TICKET = "_launch_wx_wxa_redirecting_page_invoke_ticket";
    }

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXLaunchWxaRedirectingPage.Req";
        public String callbackActivity;
        public String invokeTicket;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final boolean checkArgs() {
            AppMethodBeat.i(190360);
            boolean z = !TextUtils.isEmpty(this.invokeTicket);
            AppMethodBeat.o(190360);
            return z;
        }

        public final void fromArray(String[] strArr) {
            this.invokeTicket = strArr[0];
            this.callbackActivity = strArr[1];
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(190361);
            super.fromBundle(bundle);
            this.invokeTicket = bundle.getString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET);
            this.callbackActivity = bundle.getString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY);
            AppMethodBeat.o(190361);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final int getType() {
            return 30;
        }

        public final String[] toArray() {
            return new String[]{this.invokeTicket, this.callbackActivity};
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(190362);
            super.toBundle(bundle);
            bundle.putString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET, this.invokeTicket);
            bundle.putString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY, this.callbackActivity);
            AppMethodBeat.o(190362);
        }
    }

    public static final class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.WXLaunchWxaFRedirectingPage.Resp";
        public String callbackActivity;
        public String invokeTicket;

        public Resp(Bundle bundle) {
            AppMethodBeat.i(190418);
            fromBundle(bundle);
            AppMethodBeat.o(190418);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(190420);
            super.fromBundle(bundle);
            this.invokeTicket = bundle.getString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET);
            this.callbackActivity = bundle.getString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY);
            AppMethodBeat.o(190420);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final int getType() {
            return 30;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(190419);
            super.toBundle(bundle);
            bundle.putString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET, this.invokeTicket);
            bundle.putString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY, this.callbackActivity);
            AppMethodBeat.o(190419);
        }
    }
}
