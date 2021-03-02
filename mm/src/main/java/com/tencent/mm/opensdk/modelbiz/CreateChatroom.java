package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.b;

public class CreateChatroom {

    public static class Req extends BaseReq {
        public String chatroomName;
        public String chatroomNickName;
        public String extMsg;
        public String groupId = "";

        public Req() {
            AppMethodBeat.i(190368);
            AppMethodBeat.o(190368);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(3857);
            if (b.b(this.groupId)) {
                AppMethodBeat.o(3857);
                return false;
            }
            AppMethodBeat.o(3857);
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 14;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3858);
            super.toBundle(bundle);
            bundle.putString("_wxapi_create_chatroom_group_id", this.groupId);
            bundle.putString("_wxapi_create_chatroom_chatroom_name", this.chatroomName);
            bundle.putString("_wxapi_create_chatroom_chatroom_nickname", this.chatroomNickName);
            bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
            bundle.putString("_wxapi_basereq_openid", this.openId);
            AppMethodBeat.o(3858);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(3864);
            fromBundle(bundle);
            AppMethodBeat.o(3864);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3865);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_create_chatroom_ext_msg");
            AppMethodBeat.o(3865);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 14;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3866);
            super.toBundle(bundle);
            bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
            AppMethodBeat.o(3866);
        }
    }

    private CreateChatroom() {
    }
}
