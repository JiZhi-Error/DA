package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelOpenFeed {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.WXChannelOpenFeed.Req";
        public String feedID;
        public String nonceID;
        public boolean notGetReleatedList;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(258795);
            if (b.b(this.feedID)) {
                Log.e(TAG, "feedID is null");
                AppMethodBeat.o(258795);
                return false;
            } else if (b.b(this.nonceID)) {
                Log.e(TAG, "nonceID is null");
                AppMethodBeat.o(258795);
                return false;
            } else if (this.feedID.length() > 1024) {
                Log.e(TAG, "feedID.length too long!");
                AppMethodBeat.o(258795);
                return false;
            } else if (this.nonceID.length() > 1024) {
                Log.e(TAG, "nonceID.length too long!");
                AppMethodBeat.o(258795);
                return false;
            } else {
                AppMethodBeat.o(258795);
                return true;
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(258796);
            super.fromBundle(bundle);
            this.feedID = bundle.getString("_wxapi_finder_feedID");
            this.nonceID = bundle.getString("_wxapi_finder_nonceID");
            this.notGetReleatedList = bundle.getBoolean("_wxapi_finder_notGetReleatedList");
            AppMethodBeat.o(258796);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 36;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(258797);
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_feedID", this.feedID);
            bundle.putString("_wxapi_finder_nonceID", this.nonceID);
            bundle.putBoolean("_wxapi_finder_notGetReleatedList", this.notGetReleatedList);
            AppMethodBeat.o(258797);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(258792);
            fromBundle(bundle);
            AppMethodBeat.o(258792);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(258793);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_finder_extMsg");
            AppMethodBeat.o(258793);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 36;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(258794);
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_extMsg", this.extMsg);
            AppMethodBeat.o(258794);
        }
    }
}
