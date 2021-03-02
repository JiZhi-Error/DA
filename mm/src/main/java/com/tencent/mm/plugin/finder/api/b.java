package com.tencent.mm.plugin.finder.api;

import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0004¨\u0006\u0007"}, hxF = {"info", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "toLocal", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", ImagesContract.LOCAL, "toServer", "plugin-finder_release"})
public final class b {
    public static final g a(FinderContact finderContact, g gVar) {
        int i2;
        AppMethodBeat.i(242182);
        p.h(finderContact, "$this$toLocal");
        if (!(!Util.isNullOrNil(finderContact.username))) {
            finderContact = null;
        }
        if (finderContact != null) {
            if (gVar == null) {
                gVar = new g();
            }
            String str = finderContact.username;
            if (str == null) {
                str = "";
            }
            gVar.setUsername(str);
            String str2 = finderContact.headUrl;
            if (str2 == null) {
                str2 = "";
            }
            gVar.asL(str2);
            String str3 = finderContact.nickname;
            if (str3 == null) {
                str3 = "";
            }
            gVar.setNickname(str3);
            gVar.field_version = finderContact.seq;
            String str4 = finderContact.signature;
            if (str4 == null) {
                str4 = "";
            }
            gVar.field_signature = str4;
            gVar.field_follow_Flag = finderContact.followFlag;
            String str5 = finderContact.nickname;
            if (str5 == null) {
                str5 = "";
            }
            gVar.field_pyInitial = f.Si(str5);
            gVar.field_followTime = finderContact.followTime;
            String str6 = finderContact.coverImgUrl;
            if (str6 == null) {
                str6 = "";
            }
            gVar.field_coverImg = str6;
            gVar.field_spamStatus = finderContact.spamStatus;
            gVar.field_authInfo = finderContact.authInfo;
            gVar.field_extInfo = finderContact.extInfo;
            gVar.field_originalFlag = finderContact.originalFlag;
            gVar.field_originalEntranceFlag = finderContact.originalEntranceFlag;
            gVar.field_originalInfo = finderContact.originalInfo;
            gVar.field_extFlag = finderContact.extFlag;
            gVar.field_liveCoverImg = finderContact.liveCoverImgUrl;
            gVar.field_liveStatus = finderContact.liveStatus;
            apr apr = finderContact.live_info;
            gVar.field_liveAnchorStatusFlag = apr != null ? apr.LBA : 0;
            gVar.field_friendFollowCount = finderContact.friend_follow_count;
            apr apr2 = finderContact.live_info;
            if (apr2 != null) {
                i2 = apr2.LBB;
            } else {
                i2 = 0;
            }
            gVar.field_liveSwitchFlag = (long) i2;
            String str7 = finderContact.wx_username_v5;
            if (str7 == null) {
                str7 = "";
            }
            gVar.field_v5username = str7;
            AppMethodBeat.o(242182);
            return gVar;
        }
        Log.e("Finder.FinderContactEx", "error FinderContact username is null " + Util.getStack());
        g gVar2 = new g();
        AppMethodBeat.o(242182);
        return gVar2;
    }

    public static final FinderContact a(g gVar) {
        AppMethodBeat.i(242183);
        p.h(gVar, "$this$toServer");
        FinderContact finderContact = new FinderContact();
        finderContact.username = gVar.getUsername();
        finderContact.headUrl = gVar.cXH();
        finderContact.nickname = gVar.getNickname();
        finderContact.seq = gVar.field_version;
        finderContact.signature = gVar.field_signature;
        finderContact.followFlag = gVar.field_follow_Flag;
        finderContact.followTime = gVar.field_followTime;
        finderContact.coverImgUrl = gVar.field_coverImg;
        finderContact.authInfo = gVar.field_authInfo;
        finderContact.coverImgUrl = gVar.field_coverImg;
        finderContact.spamStatus = gVar.field_spamStatus;
        finderContact.extInfo = gVar.field_extInfo;
        finderContact.originalFlag = gVar.field_originalFlag;
        finderContact.originalEntranceFlag = gVar.field_originalEntranceFlag;
        finderContact.originalInfo = gVar.field_originalInfo;
        finderContact.extFlag = gVar.field_extFlag;
        finderContact.liveCoverImgUrl = gVar.field_liveCoverImg;
        finderContact.liveStatus = gVar.field_liveStatus;
        apr apr = new apr();
        apr.LBA = gVar.field_liveAnchorStatusFlag;
        apr.LBB = (int) gVar.field_liveSwitchFlag;
        finderContact.live_info = apr;
        finderContact.friend_follow_count = gVar.field_friendFollowCount;
        String str = gVar.field_v5username;
        if (str == null) {
            str = "";
        }
        finderContact.wx_username_v5 = str;
        AppMethodBeat.o(242183);
        return finderContact;
    }
}
