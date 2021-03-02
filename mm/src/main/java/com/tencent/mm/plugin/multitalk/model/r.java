package com.tencent.mm.plugin.multitalk.model;

import android.util.Base64;
import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.bh.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r {
    private Map<String, Long> zNu = new ConcurrentHashMap();

    public r() {
        AppMethodBeat.i(114536);
        AppMethodBeat.o(114536);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, h.a aVar) {
        AppMethodBeat.i(114537);
        String a2 = z.a(aVar.heO.KHn);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + a2 + " buffer len " + decode.length);
        try {
            a.bh bhVar = (a.bh) e.a(new a.bh(), decode, decode.length);
            if (bhVar == null) {
                Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:".concat(String.valueOf(a2)));
                AppMethodBeat.o(114537);
            } else if (this.zNu.get(bhVar.groupId) == null || this.zNu.get(bhVar.groupId).longValue() < bhVar.RGN) {
                this.zNu.put(bhVar.groupId, Long.valueOf(bhVar.RGN));
                de deVar = aVar.heO;
                String a3 = z.a(deVar.KHl);
                String a4 = z.a(deVar.KHm);
                String str2 = (String) g.aAh().azQ().get(2, (Object) null);
                if (str2 == null) {
                    Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
                    AppMethodBeat.o(114537);
                    return;
                }
                String str3 = str2.equals(a3) ? a4 : a3;
                String str4 = bhVar.RGL;
                ac.eom().eM(str3, 1);
                if (bhVar.RGK == 1) {
                    Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
                    String[] strArr = bhVar.RGM;
                    a.bb[] bbVarArr = bhVar.REK;
                    boolean z = false;
                    String str5 = "";
                    for (a.bb bbVar : bbVarArr) {
                        str5 = str5 + bbVar.dLN + ",";
                        if (bbVar.dLN != null && bbVar.dLN.equals(str2)) {
                            Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            z = true;
                        }
                    }
                    Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(str5)));
                    boolean z2 = false;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        String str6 = strArr[i2];
                        if (str6 != null && str6.equals(str2)) {
                            Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z) {
                        ac.eop().aGf(str3);
                        ac.eop().enT().remove(str3);
                    } else if (!ac.eop().enT().contains(str3) && z2) {
                        ac.eop().enT().add(str3);
                    }
                    if (str2.equals(str4)) {
                        ac.eom().d(str3, str4, false, false);
                    } else if (z && !z2) {
                        ac.eom().d(str3, str4, false, false);
                    } else if (!z || !z2) {
                        ac.eom().d(str3, str4, true, false);
                    } else {
                        ac.eom().d(str3, str4, true, true);
                    }
                    ac.eop().a(str3, bhVar);
                    ac.eol().zMd.dr(Util.nullAsNil((Integer) g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
                    AppMethodBeat.o(114537);
                } else if (bhVar.RGK == 2) {
                    Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + bhVar.REK.length);
                    String[] strArr2 = bhVar.RGM;
                    a.bb[] bbVarArr2 = bhVar.REK;
                    boolean z3 = false;
                    String str7 = "";
                    for (a.bb bbVar2 : bbVarArr2) {
                        str7 = str7 + bbVar2.dLN + ",";
                        if (bbVar2.dLN != null && bbVar2.dLN.equals(str2)) {
                            Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            z3 = true;
                        }
                    }
                    Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(str7)));
                    boolean z4 = false;
                    int length2 = strArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            break;
                        }
                        String str8 = strArr2[i3];
                        if (str8 != null && str8.equals(str2)) {
                            Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            z4 = true;
                            break;
                        }
                        i3++;
                    }
                    if (!z3) {
                        if (!ac.eop().aGg(str3) && ac.eop().enT().contains(str3) && ac.eop().iL(str3, str2)) {
                            ac.eom();
                            q.aGd(str3);
                        }
                        ac.eop().aGf(str3);
                        ac.eop().enT().remove(str3);
                    } else if (!ac.eop().enT().contains(str3) && z4) {
                        ac.eop().enT().add(str3);
                    }
                    ac.eol().zMd.dr(Util.nullAsNil((Integer) g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
                    Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
                    s eop = ac.eop();
                    Log.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", str3);
                    f aFI = ac.eoi().aFI(str3);
                    if (aFI == null) {
                        Log.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
                        eop.a(str3, bhVar);
                        AppMethodBeat.o(114537);
                    } else if (aFI.field_roomId != bhVar.GXO) {
                        Log.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + aFI.field_roomId + ", bannerinfo.roomid:" + bhVar.GXO);
                        AppMethodBeat.o(114537);
                    } else if (!s.d(str3, bhVar)) {
                        Log.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
                        AppMethodBeat.o(114537);
                    } else {
                        eop.aGh(str3);
                        AppMethodBeat.o(114537);
                    }
                } else if (bhVar.RGK == 0) {
                    Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
                    if (!ac.eop().aGg(str3) && ac.eop().enT().contains(str3) && ac.eop().iL(str3, str2)) {
                        ac.eom();
                        q.aGd(str3);
                    }
                    ac.eom().aGc(str3);
                    ac.eom().aFX(str3);
                    ac.eop().aFO(str3);
                    ac.eop().aGf(str3);
                    ac.eop().enT().remove(str3);
                    AppMethodBeat.o(114537);
                } else if (bhVar.RGK == 3) {
                    a.bb[] bbVarArr3 = bhVar.REK;
                    for (a.bb bbVar3 : bbVarArr3) {
                        if (bbVar3.dLN != null && bbVar3.dLN.equals(str2)) {
                            Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
                        }
                    }
                    AppMethodBeat.o(114537);
                } else {
                    Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + bhVar.RGK);
                    AppMethodBeat.o(114537);
                }
            } else {
                Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + bhVar.groupId + " is early than last msg, so we do not process,now return.");
                AppMethodBeat.o(114537);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:".concat(String.valueOf(a2)), e2.getMessage());
            AppMethodBeat.o(114537);
        }
    }
}
