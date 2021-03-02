package com.tencent.mm.modelvoice;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class t implements h {
    private static Set<c> jvC = new HashSet();

    static {
        AppMethodBeat.i(148498);
        AppMethodBeat.o(148498);
    }

    public static void c(c cVar) {
        AppMethodBeat.i(148494);
        if (!jvC.contains(cVar)) {
            jvC.add(cVar);
        }
        AppMethodBeat.o(148494);
    }

    public static void b(c cVar) {
        AppMethodBeat.i(148495);
        jvC.remove(cVar);
        AppMethodBeat.o(148495);
    }

    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        String str;
        String str2;
        ca caVar;
        az bjY;
        AppMethodBeat.i(148496);
        de deVar = aVar.heO;
        if (deVar == null) {
            Log.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            AppMethodBeat.o(148496);
            return null;
        }
        Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + deVar.Brn);
        String a2 = z.a(deVar.KHl);
        if (a2.equals(com.tencent.mm.model.z.aTY())) {
            str = z.a(deVar.KHm);
        } else {
            str = a2;
        }
        ca aJ = ((l) g.af(l.class)).eiy().aJ(str, deVar.Brn);
        if (aJ.field_msgId != 0 && aJ.field_createTime + 604800000 < bp.C(str, (long) deVar.CreateTime)) {
            Log.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", Long.valueOf(deVar.Brn));
            bp.D(str, deVar.Brn);
            r AP = o.bib().AP(deVar.Brn);
            if (AP != null && !Util.isNullOrNil(AP.fileName)) {
                s.Rl(AP.fileName);
            }
        }
        final r rVar = new r();
        rVar.dWq = str;
        rVar.createTime = (long) deVar.CreateTime;
        rVar.dTS = deVar.Brn;
        rVar.fqK = deVar.KHq;
        Log.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", deVar.KHq);
        String a3 = z.a(deVar.KHn);
        if (ab.Eq(a2)) {
            str2 = bp.Kt(a3);
            Log.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(str2)));
        } else {
            str2 = a3;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str2, "msg", null);
        if (parseXml == null) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 227, 1, false);
            AppMethodBeat.o(148496);
            return null;
        }
        try {
            rVar.jqP = Integer.valueOf(parseXml.get(".msg.voicemsg.$length")).intValue();
            rVar.clientId = parseXml.get(".msg.voicemsg.$clientmsgid");
            int intValue = Integer.valueOf(parseXml.get(".msg.voicemsg.$endflag")).intValue();
            int intValue2 = Integer.valueOf(parseXml.get(".msg.voicemsg.$cancelflag")).intValue();
            rVar.jvt = Integer.valueOf(parseXml.get(".msg.voicemsg.$voicelength")).intValue();
            rVar.jsh = parseXml.get(".msg.voicemsg.$fromusername");
            String str3 = parseXml.get(".msg.commenturl");
            rVar.jup = Integer.valueOf(Util.nullAs(parseXml.get(".msg.voicemsg.$forwardflag"), AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
            rVar.jui = parseXml.get(".msg.voicemsg.$voiceformat");
            rVar.jvv = Util.getLong(parseXml.get(".msg.voicemsg.$bufid"), 0);
            if (intValue2 == 1) {
                Log.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + deVar.Brn);
                r AP2 = o.bib().AP(rVar.dTS);
                if (AP2 != null) {
                    s.Rj(AP2.fileName);
                }
                AppMethodBeat.o(148496);
                return null;
            }
            if (intValue == 1) {
                Log.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + deVar.Brn);
                rVar.iKP = rVar.jqP;
            }
            rVar.cSx = 284334;
            byte[] a4 = z.a(deVar.KHp);
            if (a4 != null) {
                Log.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + a4.length + " srvId:" + deVar.Brn);
            }
            int a5 = s.a(rVar, a4, deVar.oTW, str3, deVar.KHq, aVar);
            if (a5 > 0) {
                Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", Integer.valueOf(a5), Long.valueOf(deVar.Brn), Integer.valueOf(deVar.KHs));
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 228, 1, false);
                caVar = ((l) g.af(l.class)).eiy().aJ(rVar.dWq, rVar.dTS);
                caVar.akm(0);
                for (final c cVar : jvC) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.modelvoice.t.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(148493);
                            cVar.ah(((l) g.af(l.class)).eiy().aJ(rVar.dWq, rVar.dTS));
                            AppMethodBeat.o(148493);
                        }
                    });
                }
            } else {
                Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", Integer.valueOf(a5), Long.valueOf(deVar.Brn), Integer.valueOf(deVar.KHs), Util.getStack());
                caVar = null;
            }
            if (!(caVar == null || (bjY = ((l) g.af(l.class)).aST().bjY(str)) == null)) {
                bjY.oU(TPMediaCodecProfileLevel.HEVCMainTierLevel62);
                ((l) g.af(l.class)).aST().a(bjY, str);
            }
            h.b bVar = new h.b(caVar, caVar != null && caVar.field_msgId > 0);
            AppMethodBeat.o(148496);
            return bVar;
        } catch (Exception e2) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 227, 1, false);
            Log.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
            Log.e("MicroMsg.VoiceMsgExtension", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(148496);
            return null;
        }
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
        AppMethodBeat.i(148497);
        ca caVar = cVar.dTX;
        Log.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + caVar.field_imgPath + " " + caVar.field_talker);
        if (!ab.Jp(caVar.field_talker)) {
            s.Rl(caVar.field_imgPath);
        }
        AppMethodBeat.o(148497);
    }
}
