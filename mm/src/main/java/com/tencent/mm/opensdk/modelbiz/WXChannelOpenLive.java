package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelOpenLive {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.WXChannelOpenLive.Req";
        public String feedID;
        public String nonceID;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(258782);
            if (b.b(this.feedID)) {
                Log.e(TAG, "feedID is null");
                AppMethodBeat.o(258782);
                return false;
            } else if (b.b(this.nonceID)) {
                Log.e(TAG, "nonceID is null");
                AppMethodBeat.o(258782);
                return false;
            } else if (this.feedID.length() > 1024) {
                Log.e(TAG, "feedID.length too long!");
                AppMethodBeat.o(258782);
                return false;
            } else if (this.nonceID.length() > 1024) {
                Log.e(TAG, "nonceID.length too long!");
                AppMethodBeat.o(258782);
                return false;
            } else {
                AppMethodBeat.o(258782);
                return true;
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(258783);
            super.fromBundle(bundle);
            this.feedID = bundle.getString("_wxapi_finder_feedID");
            this.nonceID = bundle.getString("_wxapi_finder_nonceID");
            AppMethodBeat.o(258783);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 35;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(258784);
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_feedID", this.feedID);
            bundle.putString("_wxapi_finder_nonceID", this.nonceID);
            AppMethodBeat.o(258784);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(258804);
            fromBundle(bundle);
            AppMethodBeat.o(258804);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(258805);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_finder_extMsg");
            AppMethodBeat.o(258805);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 35;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(258806);
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_extMsg", this.extMsg);
            AppMethodBeat.o(258806);
        }
    }
}
