package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.b;

public class JoinChatroom {

    public static class Req extends BaseReq {
        public String chatroomNickName;
        public String extMsg;
        public String groupId = "";

        public Req() {
            AppMethodBeat.i(190385);
            AppMethodBeat.o(190385);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            AppMethodBeat.i(3867);
            if (b.b(this.groupId)) {
                AppMethodBeat.o(3867);
                return false;
            }
            AppMethodBeat.o(3867);
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 15;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3868);
            super.toBundle(bundle);
            bundle.putString("_wxapi_join_chatroom_group_id", this.groupId);
            bundle.putString("_wxapi_join_chatroom_chatroom_nickname", this.chatroomNickName);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
            bundle.putString("_wxapi_basereq_openid", this.openId);
            AppMethodBeat.o(3868);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            AppMethodBeat.i(3901);
            fromBundle(bundle);
            AppMethodBeat.o(3901);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(3902);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_join_chatroom_ext_msg");
            AppMethodBeat.o(3902);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 15;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(3903);
            super.toBundle(bundle);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
            AppMethodBeat.o(3903);
        }
    }

    private JoinChatroom() {
    }
}
