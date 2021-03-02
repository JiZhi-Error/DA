package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class SendMessageToWX {

    public static class Req extends BaseReq {
        private static final int FAV_CONTENT_LENGTH_LIMIT = 26214400;
        private static final String TAG = "MicroMsg.SDK.SendMessageToWX.Req";
        public static final int WXSceneFavorite = 2;
        public static final int WXSceneSession = 0;
        public static final int WXSceneSpecifiedContact = 3;
        public static final int WXSceneTimeline = 1;
        public WXMediaMessage message;
        public int scene;
        public String userOpenId;

        public Req() {
        }

        public Req(Bundle bundle) {
            AppMethodBeat.i(4000);
            fromBundle(bundle);
            AppMethodBeat.o(4000);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
            WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage == null) {
                Log.e(TAG, "checkArgs fail ,message is null");
                AppMethodBeat.o(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
                return false;
            }
            if (wXMediaMessage.mediaObject.type() == 6 && this.scene == 2) {
                ((WXFileObject) this.message.mediaObject).setContentLengthLimit(FAV_CONTENT_LENGTH_LIMIT);
            }
            if (this.scene == 3 && this.userOpenId == null) {
                Log.e(TAG, "Send specifiedContact userOpenId can not be null.");
                AppMethodBeat.o(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
                return false;
            } else if (this.scene == 3 && this.openId == null) {
                Log.e(TAG, "Send specifiedContact openid can not be null.");
                AppMethodBeat.o(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
                return false;
            } else {
                boolean checkArgs = this.message.checkArgs();
                AppMethodBeat.o(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
                return checkArgs;
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(4001);
            super.fromBundle(bundle);
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
            this.scene = bundle.getInt("_wxapi_sendmessagetowx_req_scene");
            this.userOpenId = bundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
            AppMethodBeat.o(4001);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 2;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(4002);
            super.toBundle(bundle);
            bundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
            bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
            bundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.message.getType());
            bundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.userOpenId);
            AppMethodBeat.o(4002);
        }
    }

    public static class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(4011);
            fromBundle(bundle);
            AppMethodBeat.o(4011);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(4012);
            super.fromBundle(bundle);
            AppMethodBeat.o(4012);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 2;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(4013);
            super.toBundle(bundle);
            AppMethodBeat.o(4013);
        }
    }

    private SendMessageToWX() {
    }
}
