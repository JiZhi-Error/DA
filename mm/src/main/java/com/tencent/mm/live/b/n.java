package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.live.core.core.trtc.a.a.d;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0006¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/live/model/LiveCgiUtil;", "", "()V", "checkCookiesDeprecated", "", "errType", "", "errCode", "parseAnchorStatusJson", "Lcom/tencent/mm/json/JSONObject;", "status", "Lcom/tencent/mm/protobuf/ByteString;", "processLiveCgiSDKResponse", "", "name", "", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "setupAnchorStatusJson", "plugin-logic_release"})
public final class n {
    public static final n hGh = new n();

    static {
        AppMethodBeat.i(207594);
        AppMethodBeat.o(207594);
    }

    private n() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r5, com.tencent.mm.protocal.protobuf.cjb r6, com.tencent.mm.protocal.protobuf.civ r7, com.tencent.trtc.TRTCCloudDef.TRTCParams r8, com.tencent.mm.live.core.core.b.e r9) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.n.a(java.lang.String, com.tencent.mm.protocal.protobuf.cjb, com.tencent.mm.protocal.protobuf.civ, com.tencent.trtc.TRTCCloudDef$TRTCParams, com.tencent.mm.live.core.core.b.e):void");
    }

    public static void a(cjc cjc, TRTCCloudDef.TRTCParams tRTCParams, e eVar) {
        AppMethodBeat.i(207593);
        p.h(cjc, "liveSdkParam");
        p.h(eVar, "liveRoomInfo");
        cjd cjd = cjc.Mot;
        cja cja = cjc.Mov;
        if (cjd != null) {
            if (cjd.Mow > 0) {
                a aDC = a.aDC();
                p.g(aDC, "ConfigHelper.getInstance()");
                d aDD = aDC.aDD();
                p.g(aDD, "ConfigHelper.getInstance().videoConfig");
                aDD.setVideoResolution(cjd.Mow);
            }
            if (cjd.Moy > 0) {
                a aDC2 = a.aDC();
                p.g(aDC2, "ConfigHelper.getInstance()");
                d aDD2 = aDC2.aDD();
                p.g(aDD2, "ConfigHelper.getInstance().videoConfig");
                aDD2.qu(cjd.Moy);
            }
            if (cjd.Moz > 0) {
                a aDC3 = a.aDC();
                p.g(aDC3, "ConfigHelper.getInstance()");
                d aDD3 = aDC3.aDD();
                p.g(aDD3, "ConfigHelper.getInstance().videoConfig");
                aDD3.setVideoBitrate(cjd.Moz);
            }
            if (cjd.VjP > 0) {
                a aDC4 = a.aDC();
                p.g(aDC4, "ConfigHelper.getInstance()");
                d aDD4 = aDC4.aDD();
                p.g(aDD4, "ConfigHelper.getInstance().videoConfig");
                aDD4.setMinVideoBitrate(cjd.VjP);
            }
            if (cjd.VjR > 0) {
                a aDC5 = a.aDC();
                p.g(aDC5, "ConfigHelper.getInstance()");
                d aDD5 = aDC5.aDD();
                p.g(aDD5, "ConfigHelper.getInstance().videoConfig");
                aDD5.aws(cjd.VjR);
            }
            if (cjd.VjS > 0) {
                a aDC6 = a.aDC();
                p.g(aDC6, "ConfigHelper.getInstance()");
                d aDD6 = aDC6.aDD();
                p.g(aDD6, "ConfigHelper.getInstance().videoConfig");
                aDD6.awt(cjd.VjS);
            }
            if (cjd.VjT > 0) {
                a aDC7 = a.aDC();
                p.g(aDC7, "ConfigHelper.getInstance()");
                d aDD7 = aDC7.aDD();
                p.g(aDD7, "ConfigHelper.getInstance().videoConfig");
                aDD7.awu(cjd.VjT);
            }
            if (cjd.VjU > 0) {
                a aDC8 = a.aDC();
                p.g(aDC8, "ConfigHelper.getInstance()");
                d aDD8 = aDC8.aDD();
                p.g(aDD8, "ConfigHelper.getInstance().videoConfig");
                aDD8.awv(cjd.VjU);
            }
            if (cjd.MoB > 0) {
                a aDC9 = a.aDC();
                p.g(aDC9, "ConfigHelper.getInstance()");
                d aDD9 = aDC9.aDD();
                p.g(aDD9, "ConfigHelper.getInstance().videoConfig");
                aDD9.qv(cjd.MoB);
            }
            int i2 = cjd.MoC;
            if (i2 >= 0 && 1 >= i2) {
                a aDC10 = a.aDC();
                p.g(aDC10, "ConfigHelper.getInstance()");
                d aDD10 = aDC10.aDD();
                p.g(aDD10, "ConfigHelper.getInstance().videoConfig");
                aDD10.qt(cjd.MoC);
            }
        }
        if (!(cja == null || tRTCParams == null)) {
            Log.i("MicroMsg.LiveCoreSdk", "userDefineRecordId:" + cja.MnU);
            String str = cja.MnV;
            String str2 = cja.MnU;
            int i3 = cja.Moe;
            if (!com.tencent.mm.modelcontrol.e.sX(5) && i3 == com.tencent.mm.live.core.core.a.CDN_QUALITY_HEVC.value) {
                i3 = cja.Mof;
            }
            eVar.hzr = cja.Mof;
            if (i3 < 100) {
                eVar.a(com.tencent.mm.live.core.core.b.a.MMLiveStreamSwitchMode_Fixed);
                eVar.hzq = i3;
            } else if (i3 == com.tencent.mm.live.core.core.a.CDN_QUALITY_AUTO_CLIQOS.value) {
                eVar.a(com.tencent.mm.live.core.core.b.a.MMLiveStreamSwitchMode_Auto);
            } else if (i3 == com.tencent.mm.live.core.core.a.CDN_QUALITY_AUTO_SVRML.value) {
                eVar.a(com.tencent.mm.live.core.core.b.a.MMLiveStreamSwitchMode_ML);
            }
            LinkedList<vh> linkedList = cja.Moa;
            if (!(linkedList == null || linkedList.isEmpty())) {
                LinkedList<vh> linkedList2 = cja.Moa;
                p.g(linkedList2, "channelParams.cdn_trans_info");
                for (T t : linkedList2) {
                    Integer valueOf = Integer.valueOf(t.LfB);
                    String str3 = t.url;
                    p.g(str3, "it.url");
                    eVar.hzs.put(valueOf, str3);
                }
            }
            if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
                i iVar = new i();
                if (!Util.isNullOrNil(str)) {
                    iVar.h("userdefine_streamid_main", str);
                }
                if (!Util.isNullOrNil(str2)) {
                    iVar.h("userdefine_record_id", str2);
                }
                i iVar2 = new i();
                iVar2.h("Str_uc_params", iVar);
                tRTCParams.businessInfo = iVar2.toString();
            }
        }
        AppMethodBeat.o(207593);
    }

    public static boolean da(int i2, int i3) {
        return i2 == 4 && i3 == -100020;
    }
}
