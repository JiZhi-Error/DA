package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelShareVideo {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.WXChannelShareVideo.Req";
        public String extData;
        public String title;
        public String url;
        public String videoPath;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(258785);
            if (b.b(this.videoPath)) {
                Log.e(TAG, "videoPath is null");
                AppMethodBeat.o(258785);
                return false;
            } else if (this.title.length() > 1024) {
                Log.e(TAG, "title.length too long");
                AppMethodBeat.o(258785);
                return false;
            } else if (this.url.length() > 1024) {
                Log.e(TAG, "url.length too long");
                AppMethodBeat.o(258785);
                return false;
            } else {
                AppMethodBeat.o(258785);
                return true;
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(258786);
            super.fromBundle(bundle);
            this.videoPath = bundle.getString("_wxapi_finder_share_video_path");
            this.title = bundle.getString("_wxapi_finder_share_video_title");
            this.url = bundle.getString("_wxapi_finder_share_video_url");
            this.extData = bundle.getString("_wxapi_finder_share_video_extData");
            AppMethodBeat.o(258786);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 33;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(258787);
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_share_video_path", this.videoPath);
            bundle.putString("_wxapi_finder_share_video_title", this.title);
            bundle.putString("_wxapi_finder_share_video_url", this.url);
            bundle.putString("_wxapi_finder_share_video_extData", this.extData);
            AppMethodBeat.o(258787);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(258801);
            fromBundle(bundle);
            AppMethodBeat.o(258801);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(258802);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_finder_extMsg");
            AppMethodBeat.o(258802);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 33;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(258803);
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_extMsg", this.extMsg);
            AppMethodBeat.o(258803);
        }
    }
}
