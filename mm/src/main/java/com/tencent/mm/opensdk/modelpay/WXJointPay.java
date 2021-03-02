package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WXJointPay {

    public static class JointPayReq extends PayReq {
        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(3830);
            boolean checkArgs = super.checkArgs();
            AppMethodBeat.o(3830);
            return checkArgs;
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3832);
            super.fromBundle(bundle);
            AppMethodBeat.o(3832);
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 27;
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3831);
            super.toBundle(bundle);
            AppMethodBeat.o(3831);
        }
    }

    public static class JointPayResp extends PayResp {
        public JointPayResp() {
        }

        public JointPayResp(Bundle bundle) {
            AppMethodBeat.i(3841);
            fromBundle(bundle);
            AppMethodBeat.o(3841);
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            AppMethodBeat.i(3844);
            boolean checkArgs = super.checkArgs();
            AppMethodBeat.o(3844);
            return checkArgs;
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3843);
            super.fromBundle(bundle);
            AppMethodBeat.o(3843);
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 27;
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3842);
            super.toBundle(bundle);
            AppMethodBeat.o(3842);
        }
    }
}
