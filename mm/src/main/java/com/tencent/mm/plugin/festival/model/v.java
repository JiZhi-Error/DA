package com.tencent.mm.plugin.festival.model;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.festival.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.x;

public final class v {
    public static final v UyU = new v();

    static {
        AppMethodBeat.i(263062);
        AppMethodBeat.o(263062);
    }

    private v() {
    }

    public static /* synthetic */ void b(d.a aVar, com.tencent.mm.bw.a aVar2, com.tencent.mm.bw.a aVar3, r rVar) {
        AppMethodBeat.i(263061);
        a(aVar, aVar2, aVar3, rVar);
        AppMethodBeat.o(263061);
    }

    public static <REQ extends com.tencent.mm.bw.a, RESP extends com.tencent.mm.bw.a> void a(d.a aVar, REQ req, RESP resp, r<? super Integer, ? super Integer, ? super String, ? super RESP, x> rVar) {
        AppMethodBeat.i(263060);
        p.h(aVar, "config");
        p.h(req, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        p.h(resp, "response");
        d.a aVar2 = new d.a();
        aVar2.MB(aVar.uri);
        aVar2.sG(aVar.cmdId);
        aVar2.c(req);
        aVar2.d(resp);
        aa.a(aVar2.aXF(), new a(aVar, rVar), true);
        AppMethodBeat.o(263060);
    }

    public static final class a implements aa.a {
        final /* synthetic */ r Hmv;
        final /* synthetic */ d.a UyV;

        a(d.a aVar, r rVar) {
            this.UyV = aVar;
            this.Hmv = rVar;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final /* synthetic */ int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            String str2;
            com.tencent.mm.bw.a aVar;
            com.tencent.mm.bw.a aVar2 = null;
            AppMethodBeat.i(263059);
            StringBuilder append = new StringBuilder("runCgi, config:(").append(this.UyV.uri).append(", ").append(this.UyV.cmdId).append("), errType:").append(i2).append(", errCode:").append(i3).append(", errMsg:");
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            Log.i("MicroMsg.FestivalRunCgi", append.append(str2).append(", sceneHash:").append(qVar != null ? qVar.hashCode() : 0).toString());
            r rVar = this.Hmv;
            if (rVar != null) {
                Integer valueOf = Integer.valueOf(i2);
                Integer valueOf2 = Integer.valueOf(i3);
                if (dVar != null) {
                    aVar = dVar.aYK();
                } else {
                    aVar = null;
                }
                if (aVar instanceof com.tencent.mm.bw.a) {
                    aVar2 = aVar;
                }
                rVar.invoke(valueOf, valueOf2, str, aVar2);
            }
            AppMethodBeat.o(263059);
            return 0;
        }
    }
}
