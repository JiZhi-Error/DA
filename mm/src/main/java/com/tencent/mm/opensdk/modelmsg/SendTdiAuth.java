package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

public class SendTdiAuth {

    public static final class Resp extends SendAuth.Resp {
        private static final String KEY_AUTH_BUFFER = "_wxapi_sendauth_resp_tdi_buffer";
        private static final String TAG = "MicroMsg.SDK.SendTdiAuth.Resp";
        public byte[] tdiAuthBuffer;

        public Resp(Bundle bundle) {
            super(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(190432);
            super.fromBundle(bundle);
            this.tdiAuthBuffer = bundle.getByteArray(KEY_AUTH_BUFFER);
            AppMethodBeat.o(190432);
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public final int getType() {
            return 31;
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(190433);
            super.toBundle(bundle);
            bundle.putByteArray(KEY_AUTH_BUFFER, this.tdiAuthBuffer);
            AppMethodBeat.o(190433);
        }
    }

    private SendTdiAuth() {
    }
}
