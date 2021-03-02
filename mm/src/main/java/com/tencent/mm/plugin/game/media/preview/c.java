package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.media.CycleProgressView;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.f;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import junit.framework.Assert;

public final class c {
    private static final String xDI = (com.tencent.mm.plugin.game.commlib.util.b.c(b.a.ONE_WEEK) + "haowan/");
    private Context context;
    private View hSw;
    private boolean ifz = false;
    private long startTime;
    private f.b xBY = new f.b() {
        /* class com.tencent.mm.plugin.game.media.preview.c.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.webview.model.f.b
        public final void a(boolean z, int i2, String str, String str2, String str3, String str4) {
            AppMethodBeat.i(41334);
            if (!c.this.xDK.equals(str)) {
                AppMethodBeat.o(41334);
                return;
            }
            c.this.hSw.setVisibility(8);
            Log.i("MicroMsg.Haowan.VideoShareWrapper", "success : %b, errCode: %d, localId : %s, mediaId : %s, mediaUrl : %s, costTime: %d", Boolean.valueOf(z), Integer.valueOf(i2), str, str2, str3, Long.valueOf(System.currentTimeMillis() - c.this.startTime));
            if (c.this.xDM != null) {
                c.this.xDM.a(new b(c.this.xDL, str3, str4));
            }
            AppMethodBeat.o(41334);
        }
    };
    private f.a xBZ = new f.a() {
        /* class com.tencent.mm.plugin.game.media.preview.c.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.webview.model.f.a
        public final void a(boolean z, int i2, final int i3, String str, String str2) {
            AppMethodBeat.i(41336);
            if (!c.this.xDK.equals(str)) {
                AppMethodBeat.o(41336);
                return;
            }
            Log.d("MicroMsg.Haowan.VideoShareWrapper", "localId:%s, upload video percent:%d", str, Integer.valueOf(i3));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.preview.c.AnonymousClass6.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(41335);
                    c.this.xDJ.setProgress(i3);
                    AppMethodBeat.o(41335);
                }
            });
            AppMethodBeat.o(41336);
        }
    };
    private CycleProgressView xDJ;
    private String xDK;
    private e xDL;
    private a xDM;

    /* access modifiers changed from: package-private */
    public interface a {
        void a(b bVar);
    }

    static {
        AppMethodBeat.i(41345);
        AppMethodBeat.o(41345);
    }

    public c(Context context2, View view) {
        AppMethodBeat.i(41339);
        this.context = context2;
        this.hSw = view;
        this.xDJ = (CycleProgressView) view.findViewById(R.id.bk8);
        AppMethodBeat.o(41339);
    }

    /* access modifiers changed from: package-private */
    public final void a(final e eVar, a aVar) {
        AppMethodBeat.i(41340);
        if (eVar == null) {
            AppMethodBeat.o(41340);
            return;
        }
        this.ifz = false;
        this.xDL = eVar;
        this.xDM = aVar;
        if (eVar.dLQ) {
            this.hSw.setVisibility(0);
            com.tencent.mm.plugin.game.e.c.cyh().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.preview.c.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(41332);
                    c.a(c.this, eVar.videoUrl, c.xDI + "thumb_" + System.currentTimeMillis() + ".jpg");
                    AppMethodBeat.o(41332);
                }
            });
            AppMethodBeat.o(41340);
            return;
        }
        aVar.a(new b(eVar));
        AppMethodBeat.o(41340);
    }

    public final void dUK() {
        AppMethodBeat.i(41341);
        this.ifz = true;
        this.hSw.setVisibility(8);
        g.gdu();
        boolean WG = an.WG(this.xDK);
        g.gdu().b(this.xBY);
        g.gdu().b(this.xBZ);
        Log.i("MicroMsg.Haowan.VideoShareWrapper", "cancel share task ret:%b, localId:%s", Boolean.valueOf(WG), this.xDK);
        AppMethodBeat.o(41341);
    }

    /* access modifiers changed from: package-private */
    public class b {
        String imageUrl;
        String msN;
        String videoUrl;
        String xDQ;
        String xDR;

        public b(e eVar) {
            AppMethodBeat.i(41337);
            Assert.assertTrue("need net video", eVar.dLQ);
            this.msN = eVar.appName;
            this.xDQ = eVar.title;
            this.imageUrl = eVar.xuM;
            this.xDR = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/appcenter/index.html?v_d=eY1maoA1&no_cache=1";
            this.videoUrl = eVar.videoUrl;
            AppMethodBeat.o(41337);
        }

        public b(e eVar, String str, String str2) {
            AppMethodBeat.i(41338);
            Assert.assertTrue("need local video", !eVar.dLQ);
            this.msN = eVar.appName;
            this.xDQ = eVar.title;
            this.imageUrl = str2;
            this.xDR = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/appcenter/index.html?v_d=eY1maoA1&no_cache=1";
            this.videoUrl = str;
            AppMethodBeat.o(41338);
        }
    }

    static /* synthetic */ void a(c cVar, b bVar, int i2) {
        AppMethodBeat.i(41342);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", bVar.msN);
        intent.putExtra("Ksnsupload_imgurl", bVar.imageUrl);
        intent.putExtra("Ksnsupload_link", bVar.xDR);
        intent.putExtra("KContentObjDesc", Util.isNullOrNil(bVar.xDQ) ? cVar.context.getString(R.string.dsj) : bVar.xDQ);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        intent.putExtra("src_username", cVar.context.getString(R.string.dsj));
        intent.putExtra("src_displayname", cVar.context.getString(R.string.dsj));
        com.tencent.mm.br.c.b(cVar.context, "sns", ".ui.SnsUploadUI", intent, i2);
        AppMethodBeat.o(41342);
    }

    static /* synthetic */ void b(c cVar, b bVar, int i2) {
        AppMethodBeat.i(41343);
        k.b bVar2 = new k.b();
        bVar2.type = 5;
        bVar2.title = bVar.msN;
        bVar2.description = Util.isNullOrNil(bVar.xDQ) ? cVar.context.getString(R.string.dsj) : bVar.xDQ;
        bVar2.url = bVar.xDR;
        bVar2.thumburl = bVar.imageUrl;
        String a2 = k.b.a(bVar2, null, null);
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_Type", 2);
        intent.putExtra("Retr_Msg_content", a2);
        intent.putExtra("Multi_Retr", true);
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        intent.putExtra("src_username", cVar.context.getString(R.string.dsj));
        intent.putExtra("src_displayname", cVar.context.getString(R.string.dsj));
        com.tencent.mm.br.c.c(cVar.context, ".ui.transmit.MsgRetransmitUI", intent, i2);
        AppMethodBeat.o(41343);
    }

    static /* synthetic */ void a(c cVar, String str, String str2) {
        AppMethodBeat.i(41344);
        final WebViewJSSDKVideoItem hI = com.tencent.mm.plugin.game.media.background.a.hI(str, str2);
        if (hI == null || hI.dJX == null) {
            AppMethodBeat.o(41344);
            return;
        }
        cVar.xDK = hI.dJX;
        g.gdu().a(cVar.xBY);
        g.gdu().a(cVar.xBZ);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.game.media.preview.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(41333);
                if (!c.this.ifz) {
                    g.gdu().a("", hI.dJX, com.tencent.mm.i.a.gpV, 214, 2, c.this.xBY);
                    c.this.startTime = System.currentTimeMillis();
                }
                AppMethodBeat.o(41333);
            }
        });
        AppMethodBeat.o(41344);
    }
}
