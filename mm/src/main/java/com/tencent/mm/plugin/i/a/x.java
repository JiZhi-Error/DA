package com.tencent.mm.plugin.i.a;

import com.facebook.appevents.UserDataStore;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.azg;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J8\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000e2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J(\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000e2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyUserInfo;", "Lcom/tencent/mm/kernel/service/IService;", "modifyFeedMvReproduce", "", "show", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "modifyUserAtShowTab", "private", "", "modifyUserAvatar", "avatarPath", "", "modifyUserDistrict", UserDataStore.COUNTRY, "province", "city", "unshowSwitch", "modifyUserNickname", "nickname", "modifyUserPrivate", "modifyUserSex", "sex", "modifyUserSignature", "signature", "modifyUserWxProfile", "finder-sdk_release"})
public interface x extends a {
    void a(int i2, ai<azg> aiVar);

    void a(String str, String str2, String str3, int i2, ai<azg> aiVar);

    void a(boolean z, ai<azg> aiVar);

    void b(int i2, ai<azg> aiVar);

    void c(int i2, ai<azg> aiVar);

    void c(String str, ai<azg> aiVar);

    void d(String str, ai<azg> aiVar);

    void e(String str, ai<azg> aiVar);

    void mR(boolean z);
}
