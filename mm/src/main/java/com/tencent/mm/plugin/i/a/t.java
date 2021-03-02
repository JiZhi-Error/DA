package com.tencent.mm.plugin.i.a;

import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.ayt;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&J*\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyBlackList;", "Lcom/tencent/mm/kernel/service/IService;", "modifyCommentBlackList", "", "commentId", "", "feedId", "feedNonceId", "", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "modifyFansBlackList", "fansId", "modifyLiveBlackList", ch.COL_USERNAME, "finder-sdk_release"})
public interface t extends a {
    void a(long j2, long j3, String str, ai<ayt> aiVar);

    void b(String str, ai<ayt> aiVar);

    void b(String str, boolean z, ai<ayt> aiVar);
}
