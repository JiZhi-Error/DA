package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.a;
import com.tencent.mm.ag.aa;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.v;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class m {
    public static void b(String str, k.b bVar, String str2) {
        Bitmap bitmap = null;
        AppMethodBeat.i(34457);
        try {
            byte[] bArr = new byte[0];
            if (!Util.isNullOrNil(str2) && (str2.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || str2.startsWith(HttpWrapperBase.PROTOCAL_HTTPS))) {
                bitmap = b.aXY().a(str2, (b.f) null);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                Log.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
            } else {
                Log.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            int i2 = ab.Eq(str) ? 1 : 0;
            com.tencent.mm.pluginsdk.model.app.m.a(bVar, bVar.izj, bVar.title, str, (String) null, bArr);
            h.INSTANCE.a(14127, bVar.izj, bVar.izi, bVar.izh, bVar.title, bVar.description, "", bVar.url, 0, 1, 2, Integer.valueOf(i2), str, 1, bVar.izn, "");
            AppMethodBeat.o(34457);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", e2, "", new Object[0]);
            Log.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", e2.getLocalizedMessage());
            AppMethodBeat.o(34457);
        }
    }

    public static k.b a(String str, v vVar) {
        i Mx;
        AppMethodBeat.i(34458);
        k.b bVar = new k.b();
        bVar.title = vVar.title;
        bVar.description = vVar.iAq;
        bVar.type = 33;
        bVar.izi = vVar.iAt;
        bVar.izh = vVar.weappPath;
        bVar.izj = vVar.iAv;
        bVar.izz = vVar.iAu;
        bVar.izA = vVar.weappVersion;
        bVar.izl = "";
        bVar.izk = 2;
        bVar.url = vVar.url;
        bVar.izB = vVar.iAx;
        bVar.eam = "wxapp_" + vVar.iAv + vVar.weappPath;
        bVar.eag = vVar.iAt;
        bVar.eah = vVar.iAy;
        a aVar = new a();
        aVar.iuQ = false;
        aVar.iuR = "";
        bVar.a(aVar);
        if (Util.isNullOrNil(bVar.thumburl) && (Mx = p.aYB().Mx(str)) != null) {
            bVar.thumburl = Mx.aYt();
        }
        AppMethodBeat.o(34458);
        return bVar;
    }

    public static boolean f(ca caVar, int i2) {
        AppMethodBeat.i(34459);
        if (caVar == null) {
            AppMethodBeat.o(34459);
            return false;
        } else if (!caVar.gAt()) {
            AppMethodBeat.o(34459);
            return false;
        } else {
            LinkedList linkedList = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(caVar.field_msgId, caVar.field_content).iAd;
            if (!Util.isNullOrNil(linkedList)) {
                if (i2 < 0 || i2 >= linkedList.size()) {
                    i2 = 0;
                }
                if (com.tencent.mm.ag.m.HF(((v) linkedList.get(i2)).iAt)) {
                    AppMethodBeat.o(34459);
                    return true;
                }
            }
            AppMethodBeat.o(34459);
            return false;
        }
    }

    static void jl(final List<ca> list) {
        AppMethodBeat.i(34460);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.ui.chatting.m.AnonymousClass1 */

            public final void run() {
                LinkedList<v> linkedList;
                k.b HD;
                AppMethodBeat.i(34454);
                List<ca> list = list;
                if (!Util.isNullOrNil(list)) {
                    for (ca caVar : list) {
                        if (!(!caVar.dOQ() || (HD = k.b.HD(caVar.field_content)) == null || HD.as(a.class) == null)) {
                            aa aaVar = new aa();
                            aaVar.iAX = HD;
                            EventCenter.instance.publish(aaVar);
                        }
                        if (caVar.gAt() && (linkedList = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(caVar.field_msgId, caVar.field_content).iAd) != null) {
                            for (v vVar : linkedList) {
                                if (!Util.isNullOrNil(vVar.iAw) && com.tencent.mm.ag.m.HF(vVar.iAt)) {
                                    b.aXY().a(new b.k(vVar) {
                                        /* class com.tencent.mm.ui.chatting.m.AnonymousClass2 */
                                        final /* synthetic */ v pxW;

                                        {
                                            this.pxW = r1;
                                        }

                                        @Override // com.tencent.mm.modelappbrand.a.b.k
                                        public final void aYg() {
                                        }

                                        @Override // com.tencent.mm.modelappbrand.a.b.k
                                        public final void I(Bitmap bitmap) {
                                            AppMethodBeat.i(34455);
                                            Log.d("MicroMsg.ChattingEditModeSendToAppBrand", "onBitmapLoaded %s", this.pxW.iAw);
                                            AppMethodBeat.o(34455);
                                        }

                                        @Override // com.tencent.mm.modelappbrand.a.b.k
                                        public final void oD() {
                                        }

                                        @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                                        public final String Lb() {
                                            AppMethodBeat.i(34456);
                                            String format = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", 112, 90);
                                            AppMethodBeat.o(34456);
                                            return format;
                                        }
                                    }, vVar.iAw, (b.h) null, ((com.tencent.mm.modelappbrand.k) g.af(com.tencent.mm.modelappbrand.k.class)).m10do(112, 90));
                                }
                            }
                        }
                    }
                }
                AppMethodBeat.o(34454);
            }
        }, "MicroMsg.ChattingEditModeSendToAppBrand$prepareAppBrandMsgToSend");
        AppMethodBeat.o(34460);
    }
}
