package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;

public final class a implements i {
    C1950a INq = new C1950a(this, (byte) 0);
    private IListener INr = new IListener<pt>() {
        /* class com.tencent.mm.plugin.webview.emojistore.a.AnonymousClass1 */

        {
            AppMethodBeat.i(160411);
            this.__eventId = pt.class.getName().hashCode();
            AppMethodBeat.o(160411);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pt ptVar) {
            AppMethodBeat.i(77860);
            pt ptVar2 = ptVar;
            if (ptVar2 instanceof pt) {
                a.this.INq.b(ptVar2.dVJ.type, ptVar2.dVJ.query, ptVar2.dVJ.dVK, ptVar2.dVJ.dVL, ptVar2.dVJ.dVM);
                AppMethodBeat.o(77860);
                return true;
            }
            AppMethodBeat.o(77860);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(77863);
        EventCenter.instance.addListener(this.INr);
        AppMethodBeat.o(77863);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.webview.emojistore.a$a  reason: collision with other inner class name */
    public class C1950a {
        private b INt;
        private String INu;
        private long INv;
        boolean isRunning;
        boolean isSuccess;

        private C1950a() {
        }

        /* synthetic */ C1950a(a aVar, byte b2) {
            this();
        }

        private static String gg(String str, int i2) {
            AppMethodBeat.i(77861);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(i2);
            String messageDigest = g.getMessageDigest(stringBuffer.toString().getBytes());
            AppMethodBeat.o(77861);
            return messageDigest;
        }

        public final void b(int i2, String str, String str2, int i3, long j2) {
            AppMethodBeat.i(77862);
            if (Util.isNullOrNil(str)) {
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = str2 == null ? "" : str2.toString();
                Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "error query:%s type:%d pagebuf:%s ", objArr);
                AppMethodBeat.o(77862);
                return;
            }
            String gg = gg(str, i2);
            if (!Util.isNullOrNil(this.INu) && this.INu.equals(gg) && System.currentTimeMillis() - this.INv <= 8000 && Util.isNullOrNil(str2)) {
                if (this.isSuccess) {
                    Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", str);
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i3).a(this.INt.gap().MUB, true, z.b(this.INt.gap().LUY), this.INt.gap().LVb);
                    AppMethodBeat.o(77862);
                    return;
                } else if (this.isRunning) {
                    if (this.INt != null) {
                        this.INt.INw = i3;
                    }
                    Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
                    AppMethodBeat.o(77862);
                    return;
                } else {
                    Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
                }
            }
            Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", str, gg, Integer.valueOf(i3));
            if (this.INt != null) {
                com.tencent.mm.kernel.g.azz().a(this.INt);
            }
            this.INu = gg;
            this.INv = System.currentTimeMillis();
            this.isRunning = true;
            this.isSuccess = false;
            com.tencent.mm.kernel.g.azz().a(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS, a.this);
            this.INt = new b(i2, str, str2.getBytes(), i3, j2);
            com.tencent.mm.kernel.g.azz().a(this.INt, 0);
            AppMethodBeat.o(77862);
        }
    }

    public final boolean bk(Map<String, Object> map) {
        long longValue;
        AppMethodBeat.i(77864);
        Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", map.toString());
        String N = N(map, "keyword");
        String N2 = N(map, "nextPageBuffer");
        int P = P(map, "type");
        int P2 = P(map, "webview_instance_id");
        String N3 = N(map, "searchID");
        if (Util.isNullOrNil(N3)) {
            longValue = 0;
        } else {
            longValue = Long.valueOf(N3).longValue();
        }
        this.INq.b(P, N, N2, P2, longValue);
        AppMethodBeat.o(77864);
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(77865);
        if (qVar instanceof b) {
            com.tencent.mm.kernel.g.azz().b(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS, this);
            this.INq.isRunning = false;
            b bVar = (b) qVar;
            if (i2 == 0 && i3 == 0) {
                this.INq.isSuccess = true;
            } else {
                this.INq.isSuccess = false;
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(bVar.INw).a("{}", bVar.INx, "", 0);
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(bVar.INw).a(bVar.gap().MUB, bVar.INx, z.b(bVar.gap().LUY), bVar.gap().LVb);
        }
        AppMethodBeat.o(77865);
    }

    public static String N(Map<String, Object> map, String str) {
        AppMethodBeat.i(77866);
        if (!map.containsKey(str)) {
            AppMethodBeat.o(77866);
            return "";
        } else if (map.get(str) != null) {
            String obj = map.get(str).toString();
            AppMethodBeat.o(77866);
            return obj;
        } else {
            AppMethodBeat.o(77866);
            return "";
        }
    }

    public static int P(Map<String, Object> map, String str) {
        AppMethodBeat.i(77867);
        String N = N(map, str);
        if (Util.isNullOrNil(N)) {
            AppMethodBeat.o(77867);
            return 0;
        }
        int i2 = Util.getInt(N, 0);
        AppMethodBeat.o(77867);
        return i2;
    }
}
