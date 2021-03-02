package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.yx;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

public final class ak {
    public static void bG(ca caVar) {
        AppMethodBeat.i(34859);
        Log.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", Long.valueOf(caVar.field_msgId));
        if (ab.Jp(caVar.field_talker)) {
            sp spVar = new sp();
            spVar.dZg.dCM = caVar;
            EventCenter.instance.publish(spVar);
            AppMethodBeat.o(34859);
            return;
        }
        so soVar = new so();
        soVar.dZf.dCM = caVar;
        EventCenter.instance.publish(soVar);
        AppMethodBeat.o(34859);
    }

    public static void bH(ca caVar) {
        AppMethodBeat.i(34860);
        tv tvVar = new tv();
        long Kw = bp.Kw(caVar.field_talker);
        Log.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_createTime), Long.valueOf(Kw));
        if (Kw == caVar.field_createTime) {
            Kw++;
        }
        caVar.setCreateTime(Kw);
        bg.aVF();
        c.aSQ().a(caVar.field_msgId, caVar);
        tvVar.eap.dCM = caVar;
        EventCenter.instance.publish(tvVar);
        AppMethodBeat.o(34860);
    }

    public static void bI(ca caVar) {
        AppMethodBeat.i(34861);
        Log.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", Long.valueOf(caVar.field_msgId));
        yx yxVar = new yx();
        yxVar.efh.dCM = caVar;
        EventCenter.instance.publish(yxVar);
        AppMethodBeat.o(34861);
    }

    public static void bJ(ca caVar) {
        AppMethodBeat.i(34862);
        Log.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", Long.valueOf(caVar.field_msgId));
        long Kw = bp.Kw(caVar.field_talker);
        if (Kw == caVar.field_createTime) {
            Kw++;
        }
        caVar.setCreateTime(Kw);
        bg.aVF();
        c.aSQ().a(caVar.field_msgId, caVar);
        com.tencent.mm.pluginsdk.model.app.c Mp = ao.cgO().Mp(caVar.field_msgId);
        if (Mp == null || Mp.field_msgInfoId != caVar.field_msgId) {
            Log.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
            ao.gnh();
            an.a.HR(caVar.field_msgId);
            AppMethodBeat.o(34862);
            return;
        }
        Log.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
        Mp.field_status = 101;
        Mp.field_offset = 0;
        Mp.field_lastModifyTime = System.currentTimeMillis() / 1000;
        ao.cgO().a(Mp, new String[0]);
        ao.gnh().run();
        AppMethodBeat.o(34862);
    }

    public static void bK(ca caVar) {
        AppMethodBeat.i(34863);
        Log.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", Long.valueOf(caVar.field_msgId));
        bN(caVar);
        AppMethodBeat.o(34863);
    }

    public static void bL(ca caVar) {
        AppMethodBeat.i(34864);
        Log.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", Long.valueOf(caVar.field_msgId));
        bN(caVar);
        AppMethodBeat.o(34864);
    }

    public static void bM(ca caVar) {
        AppMethodBeat.i(34865);
        Log.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", Long.valueOf(caVar.field_msgId));
        bN(caVar);
        AppMethodBeat.o(34865);
    }

    private static void bN(ca caVar) {
        AppMethodBeat.i(34866);
        long j2 = caVar.field_msgId;
        if (j2 == -1) {
            Log.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(j2)));
            AppMethodBeat.o(34866);
        } else if (!caVar.field_talker.equals("medianote") || (z.aUc() & 16384) != 0) {
            Log.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", Long.valueOf(j2));
            o.e a2 = o.a(o.d.TEXT);
            a2.msgId = j2;
            a2.content = caVar.field_content;
            a2.toUser = caVar.field_talker;
            a2.cSx = 0;
            a2.jdR = 2;
            if (!a2.bdQ().execute()) {
                Log.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
                caVar.setStatus(5);
                bg.aVF();
                c.aSQ().a(caVar.field_msgId, caVar);
                tx txVar = new tx();
                txVar.ear.dCM = caVar;
                EventCenter.instance.publish(txVar);
                AppMethodBeat.o(34866);
                return;
            }
            long Kw = bp.Kw(caVar.field_talker);
            if (Kw == caVar.field_createTime) {
                Kw++;
            }
            caVar.setCreateTime(Kw);
            bg.aVF();
            c.aSQ().a(caVar.field_msgId, caVar);
            AppMethodBeat.o(34866);
        } else {
            AppMethodBeat.o(34866);
        }
    }
}
