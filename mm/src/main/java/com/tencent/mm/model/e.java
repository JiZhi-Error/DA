package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.co.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class e implements h {
    private static final a iBD = new a();

    public static final class a extends com.tencent.mm.co.a<com.tencent.mm.plugin.messenger.foundation.a.a> implements com.tencent.mm.plugin.messenger.foundation.a.a {
        @Override // com.tencent.mm.plugin.messenger.foundation.a.a
        public final void a(final h.a aVar, final ca caVar, final String str, final String str2, final boolean z) {
            AppMethodBeat.i(42766);
            a(new a.AbstractC0297a<com.tencent.mm.plugin.messenger.foundation.a.a>() {
                /* class com.tencent.mm.model.e.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.plugin.messenger.foundation.a.a aVar) {
                    AppMethodBeat.i(42764);
                    aVar.a(aVar, caVar, str, str2, z);
                    AppMethodBeat.o(42764);
                }
            });
            AppMethodBeat.o(42766);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a
        public final void b(final h.a aVar, final ca caVar, final String str, final String str2, final boolean z) {
            AppMethodBeat.i(42767);
            a(new a.AbstractC0297a<com.tencent.mm.plugin.messenger.foundation.a.a>() {
                /* class com.tencent.mm.model.e.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.plugin.messenger.foundation.a.a aVar) {
                    AppMethodBeat.i(42765);
                    aVar.b(aVar, caVar, str, str2, z);
                    AppMethodBeat.o(42765);
                }
            });
            AppMethodBeat.o(42767);
        }
    }

    static {
        AppMethodBeat.i(42771);
        AppMethodBeat.o(42771);
    }

    public static void a(com.tencent.mm.plugin.messenger.foundation.a.a aVar) {
        AppMethodBeat.i(42768);
        iBD.add(aVar);
        AppMethodBeat.o(42768);
    }

    @Override // com.tencent.mm.ak.h
    public h.b b(h.a aVar) {
        h.b bVar;
        String str;
        String str2;
        String str3;
        az bjY;
        int i2;
        ca caVar;
        AppMethodBeat.i(42769);
        de deVar = aVar.heO;
        String str4 = (String) g.aAh().azQ().get(2, "");
        if (str4.length() <= 0) {
            AppMethodBeat.o(42769);
            return null;
        }
        String a2 = z.a(deVar.KHl);
        String a3 = z.a(deVar.KHm);
        if (Util.nullAsNil(a2).length() <= 0 || Util.nullAsNil(a3).length() <= 0) {
            Log.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
            AppMethodBeat.o(42769);
            return null;
        }
        ca a4 = a(aVar, a2, a3, str4);
        if (a4 == null) {
            AppMethodBeat.o(42769);
            return null;
        }
        if (!a4.ZA) {
            if (((l) g.af(l.class)).aSW().has(a2) || str4.equals(a2)) {
                a4.nv(1);
                a4.Cy(a3);
                i2 = deVar.oTW;
                caVar = a4;
            } else {
                a4.nv(0);
                a4.Cy(a2);
                if (deVar.oTW > 3) {
                    i2 = deVar.oTW;
                    caVar = a4;
                } else {
                    i2 = 3;
                    caVar = a4;
                }
            }
            caVar.setStatus(i2);
        }
        if (deVar.xKb == 10000) {
            a4.setStatus(4);
        }
        boolean z = a4.field_isSend == 1;
        a4.BB(deVar.KHq);
        if (a4.bkz(z.aTY()) && (bjY = ((l) g.af(l.class)).aST().bjY(a4.field_talker)) != null) {
            bjY.oU(TPMediaCodecProfileLevel.HEVCMainTierLevel62);
            ((l) g.af(l.class)).aST().a(bjY, a4.field_talker);
        }
        iBD.a(aVar, a4, a2, a3, z);
        if (a4.field_msgId == 0) {
            a4.setFlag(2);
            bp.a(a4, aVar);
            a4.setMsgId(bp.x(a4));
            bVar = new h.b(a4, true);
        } else {
            ((l) g.af(l.class)).eiy().b(deVar.Brn, a4);
            bVar = new h.b(a4, false);
        }
        if (!Util.isNullOrNil(a4.field_content)) {
            if (z) {
                str = a3;
            } else {
                str = a2;
            }
            if (!aVar.iLV && ((j) g.af(j.class)).aBf(str)) {
                if (z) {
                    str2 = a4.field_content;
                    str3 = a2;
                } else {
                    str2 = a4.field_content;
                    int Kp = bp.Kp(a4.field_content);
                    if (Kp != -1) {
                        String trim = str2.substring(0, Kp).trim();
                        if (trim == null || trim.length() <= 0) {
                            trim = "";
                        }
                        str2 = str2.substring(Kp + 1).trim();
                        str3 = trim;
                    } else {
                        str3 = "";
                    }
                }
                if (BuildInfo.DEBUG) {
                    Log.d("MicroMsg.BaseMsgExtension", "onPreAddMessage() isSender:%s fromUser:%s creator:%s content:%s", Boolean.valueOf(z), a2, str3, Util.nullAs(str2, BuildConfig.COMMAND));
                }
                ((j) g.af(j.class)).a(str, str3, str2, a4.field_msgId, a4.field_createTime / 1000);
            }
            if (a4.gDV() && ab.Ix(a4.field_talker) && ((t) g.af(t.class)).ama()) {
                g.aAi();
                as Kn = ((l) g.af(l.class)).aSN().Kn(a4.field_talker);
                long j2 = Kn.fve;
                Kn.yz(a4.field_msgId);
                g.aAi();
                ((l) g.af(l.class)).aSN().ao(Kn);
                if (j2 != 0) {
                    ((t) g.af(t.class)).r(a4.field_talker, j2);
                }
            }
        }
        iBD.b(aVar, a4, a2, a3, z);
        AppMethodBeat.o(42769);
        return bVar;
    }

    /* access modifiers changed from: protected */
    public ca a(h.a aVar, String str, String str2, String str3) {
        AppMethodBeat.i(225913);
        de deVar = aVar.heO;
        String str4 = str3.equals(str) ? str2 : str;
        ca aJ = ((l) g.af(l.class)).eiy().aJ(str4, deVar.Brn);
        Log.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", Long.valueOf(deVar.Brn), Long.valueOf(aJ.field_msgId), str, str2, str4);
        if (aJ.field_msgId != 0 && aJ.field_createTime + 604800000 < bp.C(str4, (long) deVar.CreateTime)) {
            Log.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(deVar.Brn), Long.valueOf(aJ.field_msgId));
            bp.Ad(aJ.field_msgId);
            aJ.setMsgId(0);
        }
        if (aJ.field_msgId == 0) {
            aJ = new ca();
            aJ.Cy(str4);
            aJ.yF(deVar.Brn);
            aJ.setCreateTime(bp.C(str4, (long) deVar.CreateTime));
            aJ.setType(deVar.xKb);
            aJ.setContent(Util.escapeStringForUCC(Util.nullAsNil(z.a(deVar.KHn))));
        }
        AppMethodBeat.o(225913);
        return aJ;
    }

    @Override // com.tencent.mm.ak.h
    public void b(h.c cVar) {
    }
}
