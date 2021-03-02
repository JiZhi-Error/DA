package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelOpenProfile {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.WXChannelOpenProfile.Req";
        public String userName;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(258798);
            if (b.b(this.userName)) {
                Log.e(TAG, "userName is null");
                AppMethodBeat.o(258798);
                return false;
            } else if (this.userName.length() > 1024) {
                Log.e(TAG, "userName.length too long");
                AppMethodBeat.o(258798);
                return false;
            } else {
                AppMethodBeat.o(258798);
                return true;
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(258799);
            super.fromBundle(bundle);
            this.userName = bundle.getString("_wxapi_finder_userName");
            AppMethodBeat.o(258799);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 34;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(258800);
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_userName", this.userName);
            AppMethodBeat.o(258800);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(258807);
            fromBundle(bundle);
            AppMethodBeat.o(258807);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(258808);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_finder_extMsg");
            AppMethodBeat.o(258808);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 34;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(258809);
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_extMsg", this.extMsg);
            AppMethodBeat.o(258809);
        }
    }
}
