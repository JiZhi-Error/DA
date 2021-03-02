package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.live.b.c.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "onNewXmlReceived", "", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-logic_release"})
public final class t implements q {
    public static final a hIm = new a((byte) 0);

    static {
        AppMethodBeat.i(207691);
        AppMethodBeat.o(207691);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/model/LiveSysMsgReceiver$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.q
    public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        de deVar;
        de deVar2;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        String str52;
        String str53;
        String str54;
        String str55;
        String str56;
        String str57;
        String str58;
        String str59;
        String str60;
        String str61;
        String str62;
        String str63;
        AppMethodBeat.i(207690);
        if (p.j(str, "ApplyLiveMic")) {
            long j2 = Util.getLong(map != null ? map.get(".sysmsg.mmlive.live_id") : null, 0);
            if (map == null || (str63 = map.get(".sysmsg.mmlive.live_mic_id")) == null) {
                str56 = "";
            } else {
                str56 = str63;
            }
            if (map == null || (str62 = map.get(".sysmsg.mmlive.identity_id")) == null) {
                str57 = "";
            } else {
                str57 = str62;
            }
            if (map == null || (str61 = map.get(".sysmsg.mmlive.roomid")) == null) {
                str58 = "";
            } else {
                str58 = str61;
            }
            if (map == null || (str60 = map.get(".sysmsg.mmlive.mic_sdk_user_id")) == null) {
                str59 = "";
            } else {
                str59 = str60;
            }
            s sVar = s.hIl;
            j aGe = s.aGe();
            if (aGe != null) {
                aGe.onApplyLiveMic(new b(j2, str56, str57, str58, str59));
                x xVar = x.SXb;
            }
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive apply live mic newxml. liveId:" + j2 + " micId:" + str56 + " uid:" + str57 + " roomId:" + str58 + " sdkUid:" + str59);
            x xVar2 = x.SXb;
            AppMethodBeat.o(207690);
        } else if (p.j(str, "AcceptLiveMic")) {
            long j3 = Util.getLong(map != null ? map.get(".sysmsg.mmlive.live_id") : null, 0);
            if (map == null || (str55 = map.get(".sysmsg.mmlive.live_mic_id")) == null) {
                str46 = "";
            } else {
                str46 = str55;
            }
            int i2 = Util.getInt(map != null ? map.get(".sysmsg.mmlive.live_sdk_info.sdk_appid") : null, 0);
            if (map == null || (str54 = map.get(".sysmsg.mmlive.live_sdk_info.sdk_user_id")) == null) {
                str47 = "";
            } else {
                str47 = str54;
            }
            int i3 = Util.getInt(map != null ? map.get(".sysmsg.mmlive.live_sdk_info.sdk_live_id") : null, 0);
            int i4 = Util.getInt(map != null ? map.get(".sysmsg.mmlive.live_sdk_info.sdk_role_id") : null, 0);
            if (map == null || (str53 = map.get(".sysmsg.mmlive.live_sdk_info.sdk_user_sig")) == null) {
                str48 = "";
            } else {
                str48 = str53;
            }
            if (map == null || (str52 = map.get(".sysmsg.mmlive.live_sdk_info.sdk_private_map_key")) == null) {
                str49 = "";
            } else {
                str49 = str52;
            }
            long j4 = Util.getLong(map != null ? map.get(".sysmsg.mmlive.live_sdk_info.expire_for_pmk") : null, 300);
            if (map == null || (str51 = map.get(".sysmsg.mmlive.live_sdk_info.sdk_params")) == null) {
                str50 = "";
            } else {
                str50 = str51;
            }
            s sVar2 = s.hIl;
            j aGe2 = s.aGe();
            if (aGe2 != null) {
                aGe2.onAcceptLiveMic(new a(j3, str46, str47, i2, i4, i3, str48, str49, j4, str50, null, 0, 15360));
                x xVar3 = x.SXb;
            }
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive accept live mic newxml. liveId:" + j3 + " micId:" + str46);
            x xVar4 = x.SXb;
            AppMethodBeat.o(207690);
        } else if (p.j(str, "CloseLive")) {
            long j5 = Util.getLong(map != null ? map.get(".sysmsg.mmlive.live_id") : null, 0);
            c.getLiveTipsBarStorage().zF(j5);
            com.tencent.mm.live.b.c.a aVar2 = com.tencent.mm.live.b.c.a.hLc;
            com.tencent.mm.live.b.c.a.zE(j5);
            s sVar3 = s.hIl;
            j aGe3 = s.aGe();
            if (aGe3 != null) {
                aGe3.onCloseLive(new e(j5));
                x xVar5 = x.SXb;
            }
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive close live newxml liveId:".concat(String.valueOf(j5)));
            x xVar6 = x.SXb;
            AppMethodBeat.o(207690);
        } else if (p.j(str, "CloseLiveMic")) {
            long j6 = Util.getLong(map != null ? map.get(".sysmsg.mmlive.live_id") : null, 0);
            if (map == null || (str45 = map.get(".sysmsg.mmlive.audience")) == null) {
                str43 = "";
            } else {
                str43 = str45;
            }
            if (map == null || (str44 = map.get(".sysmsg.mmlive.live_mic_id")) == null) {
                str44 = "";
            }
            s sVar4 = s.hIl;
            j aGe4 = s.aGe();
            if (aGe4 != null) {
                aGe4.onCloseLiveMic(new f(j6, str43, str44));
                x xVar7 = x.SXb;
            }
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive close mic newxml liveid:" + j6 + " audience:" + str43 + ", micId:" + str44);
            x xVar8 = x.SXb;
            AppMethodBeat.o(207690);
        } else if (p.j(str, "CloseApplyLiveMic")) {
            long j7 = Util.getLong(map != null ? map.get(".sysmsg.mmlive.live_id") : null, 0);
            boolean z = Util.getInt(map != null ? map.get(".sysmsg.mmlive.enable_apply_live_mic") : null, 0) == 1;
            s sVar5 = s.hIl;
            j aGe5 = s.aGe();
            if (aGe5 != null) {
                aGe5.onCloseApplyLiveMic(new d(j7, z));
                x xVar9 = x.SXb;
            }
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive CloseApplyLiveMic newxml liveId:" + j7 + ", " + z);
            x xVar10 = x.SXb;
            AppMethodBeat.o(207690);
        } else if (p.j(str, "BanLiveComment")) {
            long j8 = Util.getLong(map != null ? map.get(".sysmsg.mmlive.live_id") : null, 0);
            int i5 = Util.getInt(map != null ? map.get(".sysmsg.mmlive.enable_comment") : null, 0);
            String nullAsNil = Util.nullAsNil(map != null ? map.get(".sysmsg.mmlive.wording") : null);
            s sVar6 = s.hIl;
            j aGe6 = s.aGe();
            if (aGe6 != null) {
                aGe6.onBanLiveComment(new c(j8, i5, nullAsNil));
                x xVar11 = x.SXb;
            }
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive ban comment newxml liveId:" + j8 + " enableComment:" + i5 + " wording:" + nullAsNil);
            x xVar12 = x.SXb;
            AppMethodBeat.o(207690);
        } else if (p.j(str, "LiveMicSucc")) {
            long j9 = Util.getLong(map != null ? map.get(".sysmsg.mmlive.live_id") : null, 0);
            if (map == null || (str42 = map.get(".sysmsg.mmlive.identity_id")) == null) {
                str33 = "";
            } else {
                str33 = str42;
            }
            if (map == null || (str41 = map.get(".sysmsg.mmlive.headimg")) == null) {
                str34 = "";
            } else {
                str34 = str41;
            }
            if (map == null || (str40 = map.get(".sysmsg.mmlive.nickName")) == null) {
                str35 = "";
            } else {
                str35 = str40;
            }
            if (map == null || (str39 = map.get(".sysmsg.mmlive.mic_sdk_user_id")) == null) {
                str36 = "";
            } else {
                str36 = str39;
            }
            if (map == null || (str38 = map.get(".sysmsg.mmlive.live_mic_id")) == null) {
                str37 = "";
            } else {
                str37 = str38;
            }
            s sVar7 = s.hIl;
            j aGe7 = s.aGe();
            if (aGe7 != null) {
                aGe7.onLiveMicSucc(new q(j9, str33, str34, str35, str36, str37));
                x xVar13 = x.SXb;
            }
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive live mic success. liveId:" + j9 + " audience:" + str33 + " nickName:" + str35 + " sdkUid:" + str36 + " micId:" + str37);
            x xVar14 = x.SXb;
            AppMethodBeat.o(207690);
        } else if (p.j(str, "OnlineLiveList")) {
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive online livelist mmlive.");
            if (map == null || (str32 = map.get(".sysmsg.mmlive.live_info_list")) == null) {
                str30 = "";
            } else {
                str30 = str32;
            }
            String a2 = z.a((aVar == null || (deVar2 = aVar.heO) == null) ? null : deVar2.KHn);
            if (a2 == null) {
                str31 = "";
            } else {
                str31 = a2;
            }
            String a3 = z.a((aVar == null || (deVar = aVar.heO) == null) ? null : deVar.KHm);
            if (a3 == null) {
                a3 = "";
            }
            s sVar8 = s.hIl;
            j aGe8 = s.aGe();
            if (aGe8 != null) {
                aGe8.onOnlineLiveList(new v(str30, str31, a3));
                x xVar15 = x.SXb;
                AppMethodBeat.o(207690);
                return;
            }
            AppMethodBeat.o(207690);
        } else if (p.j(str, "mmfinderlive_apply_live_mic_sys_msg")) {
            long j10 = Util.getLong(map != null ? map.get(".sysmsg.live_id") : null, 0);
            long j11 = Util.getLong(map != null ? map.get(".sysmsg.object_id") : null, 0);
            if (map == null || (str29 = map.get(".sysmsg.apply_mic_sdk_user_id")) == null) {
                str16 = "";
            } else {
                str16 = str29;
            }
            if (map == null || (str28 = map.get(".sysmsg.apply_sdk_live_id")) == null) {
                str17 = "";
            } else {
                str17 = str28;
            }
            if (map == null || (str27 = map.get(".sysmsg.apply_finder_username")) == null) {
                str18 = "";
            } else {
                str18 = str27;
            }
            if (map == null || (str26 = map.get(".sysmsg.live_mic_id")) == null) {
                str19 = "";
            } else {
                str19 = str26;
            }
            if (map == null || (str25 = map.get(".sysmsg.seq")) == null) {
                str20 = "";
            } else {
                str20 = str25;
            }
            int i6 = Util.getInt(map != null ? map.get(".sysmsg.scene") : null, 0);
            int i7 = Util.getInt(map != null ? map.get(".sysmsg.business_type") : null, 0);
            if (map == null || (str24 = map.get(".sysmsg.apply_nickname")) == null) {
                str21 = "";
            } else {
                str21 = str24;
            }
            if (map == null || (str23 = map.get(".sysmsg.apply_head_img_url")) == null) {
                str22 = "";
            } else {
                str22 = str23;
            }
            s sVar9 = s.hIl;
            j aGe9 = s.aGe();
            if (aGe9 != null) {
                aGe9.onFinderLiveApplyLiveMic(new h(j10, j11, str16, str17, str18, str19, str20, i6, i7, str21, str22));
                x xVar16 = x.SXb;
            }
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive apply live mic newxml liveId:" + j10 + " objectId:" + j11 + " applyMicSdkUserId:" + str16 + " applyMicSdkLiveId:" + str17 + " applyMicFinderUsername:" + str18 + " liveMicId:" + str19 + " seq:" + str20 + " scene:" + i6 + " businessType:" + i7 + " applyNickname:" + str21 + " applyAvatarUrl:" + str22);
            x xVar17 = x.SXb;
            AppMethodBeat.o(207690);
        } else if (p.j(str, "mmfinderlive_accept_live_mic_sys_msg")) {
            long j12 = Util.getLong(map != null ? map.get(".sysmsg.live_id") : null, 0);
            long j13 = Util.getLong(map != null ? map.get(".sysmsg.object_id") : null, 0);
            if (map == null || (str15 = map.get(".sysmsg.accept_mic_sdk_user_id")) == null) {
                str6 = "";
            } else {
                str6 = str15;
            }
            if (map == null || (str14 = map.get(".sysmsg.accept_finder_username")) == null) {
                str7 = "";
            } else {
                str7 = str14;
            }
            if (map == null || (str13 = map.get(".sysmsg.accept_sdk_live_id")) == null) {
                str8 = "";
            } else {
                str8 = str13;
            }
            if (map == null || (str12 = map.get(".sysmsg.live_mic_id")) == null) {
                str9 = "";
            } else {
                str9 = str12;
            }
            int i8 = Util.getInt(map != null ? map.get(".sysmsg.scene") : null, 0);
            int i9 = Util.getInt(map != null ? map.get(".sysmsg.business_type") : null, 0);
            if (map == null || (str11 = map.get(".sysmsg.sdk_pk_sign")) == null) {
                str10 = "";
            } else {
                str10 = str11;
            }
            s sVar10 = s.hIl;
            j aGe10 = s.aGe();
            if (aGe10 != null) {
                aGe10.onFinderLiveAcceptLiveMic(new g(j12, j13, str6, str8, str7, str9, i8, i9, str10));
                x xVar18 = x.SXb;
            }
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive accept live mic newxml liveId:" + j12 + " objectId:" + j13 + " acceptMicSdkUserId:" + str6 + " acceptMicSdkLiveId:" + str8 + " acceptMicFinderUsername:" + str7 + " liveMicId:" + str9 + " scene:" + i8 + " businessType:" + i9 + " sdkPkSign:" + str10);
            x xVar19 = x.SXb;
            AppMethodBeat.o(207690);
        } else {
            if (p.j(str, "mmfinderlive_close_live_mic_sys_msg")) {
                long j14 = Util.getLong(map != null ? map.get(".sysmsg.live_id") : null, 0);
                long j15 = Util.getLong(map != null ? map.get(".sysmsg.object_id") : null, 0);
                if (map == null || (str5 = map.get(".sysmsg.live_mic_id")) == null) {
                    str2 = "";
                } else {
                    str2 = str5;
                }
                if (map == null || (str4 = map.get(".sysmsg.seq")) == null) {
                    str3 = "";
                } else {
                    str3 = str4;
                }
                int i10 = Util.getInt(map != null ? map.get(".sysmsg.business_type") : null, 0);
                s sVar11 = s.hIl;
                j aGe11 = s.aGe();
                if (aGe11 != null) {
                    aGe11.onFinderLiveCloseLiveMic(new i(j14, j15, str2, str3, i10));
                    x xVar20 = x.SXb;
                }
                Log.i("MicroMsg.LiveSysMsgReceiver", "receive close live mic newxml liveId:" + j14 + " objectId:" + j15 + " liveMicId:" + str2 + " seq:" + str3 + " businessType:" + i10);
                x xVar21 = x.SXb;
            }
            AppMethodBeat.o(207690);
        }
    }
}
