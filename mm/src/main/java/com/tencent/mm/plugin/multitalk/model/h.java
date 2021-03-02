package com.tencent.mm.plugin.multitalk.model;

import com.tencent.pb.common.b.a.a.a;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/IScreenCastEventHandler;", "", "close", "", "onSwitchVideoScreenSharingRsp", "rsp", "", "onVideoGroupMemberChange", "memberList", "", "Lcom/tencent/pb/common/network/protocol/nano/ProtocolContacts$VideoGroupMember;", "plugin-multitalk_release"})
public interface h {
    void Rd(int i2);

    void close();

    void fz(List<a.as> list);
}
