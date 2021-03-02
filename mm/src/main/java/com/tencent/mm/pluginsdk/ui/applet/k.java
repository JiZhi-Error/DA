package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\u0012\u0010$\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0003H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\u001c\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\u00142\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListenerImpl;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "scene", "", "(I)V", "afterCloseStream", "", "afterGetResponseCode", "afterOpenConnection", "afterReadStreamData", "beforeCloseStream", "beforeGetResponseCode", "beforeOpenConnection", "beforeReadStreamData", "canReport", "", "downloadEnd", "downloadStart", "forceNormal", "id", "", "requestImageType", "startDownload", "url", "urlKey", "onAfterCloseStream", "", "onAfterGetResponseCode", "onAfterOpenConnection", "connection", "Ljava/net/HttpURLConnection;", "onAfterReadStreamData", "onBeforeCloseStream", "onBeforeGetResponseCode", "onBeforeOpenConnection", "onBeforeReadStreamData", "onDisconnect", "onRequest", "imageType", "onResult", "success", "onResultError", "responseCode", "onResultSuccess", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onRetry", "onStart", "key", "requestUrl", "Companion", "plugin-biz_release"})
public final class k implements j {
    public static final a KeM = new a((byte) 0);
    private String JYs;
    private int KeA;
    private long KeC;
    private long KeD;
    private long KeE;
    private long KeF;
    private long KeG;
    private long KeH;
    private long KeI;
    private long KeJ;
    private long KeK;
    private long KeL;
    private boolean Kez;
    private long dUG;
    private boolean hkH;
    private final String id = String.valueOf(hashCode());
    private int scene;
    private String url;

    static {
        AppMethodBeat.i(124893);
        AppMethodBeat.o(124893);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListenerImpl$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public k(int i2) {
        AppMethodBeat.i(124892);
        this.scene = i2;
        g gVar = g.Kev;
        this.hkH = g.aif(i2);
        AppMethodBeat.o(124892);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void ey(String str, String str2) {
        AppMethodBeat.i(124877);
        this.JYs = str;
        this.url = str2;
        this.dUG = System.currentTimeMillis();
        g gVar = g.Kev;
        if (g.aig(this.scene)) {
            com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
            com.tencent.mm.pluginsdk.model.a.dd(3, this.JYs);
        }
        Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onStart id: %s", this.id);
        AppMethodBeat.o(124877);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void gpk() {
        AppMethodBeat.i(124878);
        g gVar = g.Kev;
        if (g.aig(this.scene)) {
            com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
            String str = this.JYs;
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                Log.d("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload id: %s, url: %s", com.tencent.mm.pluginsdk.model.a.bdl(str), str);
                com.tencent.mm.pluginsdk.model.a.v(new a.i(str, System.currentTimeMillis()));
            }
        }
        AppMethodBeat.o(124878);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void bz(int i2, boolean z) {
        AppMethodBeat.i(124879);
        Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onRequest id: %s, imageType: %d, forceNormal: %b, url: %s", this.id, Integer.valueOf(i2), Boolean.valueOf(z), this.url);
        this.KeA = i2;
        this.Kez = z;
        this.KeK = System.currentTimeMillis();
        if (this.hkH) {
            f fVar = f.Ket;
            f.gph();
            f fVar2 = f.Ket;
            f.aid(this.KeA);
            if (this.Kez) {
                f fVar3 = f.Ket;
                f.aie(this.KeA);
            }
        }
        AppMethodBeat.o(124879);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void gpl() {
        AppMethodBeat.i(124880);
        this.KeC = System.currentTimeMillis();
        AppMethodBeat.o(124880);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void gpm() {
        AppMethodBeat.i(124881);
        this.KeD = System.currentTimeMillis();
        Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onAfterOpenConnection id: %s, cost: %d", this.id, Long.valueOf(this.KeD - this.KeC));
        AppMethodBeat.o(124881);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void gpn() {
        AppMethodBeat.i(124882);
        this.KeE = System.currentTimeMillis();
        AppMethodBeat.o(124882);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void gpo() {
        AppMethodBeat.i(124883);
        this.KeF = System.currentTimeMillis();
        Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo getResponseCode id: %s, cost: %d", this.id, Long.valueOf(this.KeF - this.KeE));
        AppMethodBeat.o(124883);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void gpp() {
        AppMethodBeat.i(124884);
        this.KeG = System.currentTimeMillis();
        AppMethodBeat.o(124884);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void gpq() {
        AppMethodBeat.i(124885);
        this.KeH = System.currentTimeMillis();
        Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo readStreamData id: %s, cost: %d", this.id, Long.valueOf(this.KeH - this.KeG));
        AppMethodBeat.o(124885);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void gpr() {
        AppMethodBeat.i(124886);
        this.KeI = System.currentTimeMillis();
        AppMethodBeat.o(124886);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void gps() {
        AppMethodBeat.i(124887);
        this.KeJ = System.currentTimeMillis();
        Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo closeStream id: %s, cost: %d", this.id, Long.valueOf(this.KeJ - this.KeI));
        AppMethodBeat.o(124887);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void gpt() {
        AppMethodBeat.i(124888);
        Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onDisconnect id: %s", this.id);
        AppMethodBeat.o(124888);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void b(b bVar) {
        AppMethodBeat.i(124889);
        p.h(bVar, "response");
        Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultSuccess id: %s, contentType: %s, cost: %d", this.id, bVar.contentType, Long.valueOf(System.currentTimeMillis() - this.dUG));
        this.KeL = System.currentTimeMillis();
        if (this.hkH) {
            f fVar = f.Ket;
            f.bw(this.KeA, true);
            f fVar2 = f.Ket;
            int i2 = this.KeA;
            String str = bVar.contentType;
            Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType requestImageType: %d, responseContentType: %s", Integer.valueOf(i2), str);
            if (i2 == 1) {
                g gVar = g.Kev;
                switch (g.beL(str)) {
                    case 0:
                        h.INSTANCE.n(1111, 7, 1);
                        break;
                    case 1:
                        h.INSTANCE.n(1111, 8, 1);
                        break;
                }
            }
            Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType responseContentType: %s", str);
            g gVar2 = g.Kev;
            switch (g.beL(str)) {
                case 0:
                    h.INSTANCE.n(1111, 17, 1);
                    break;
                case 1:
                    h.INSTANCE.n(1111, 19, 1);
                    break;
                case 2:
                    h.INSTANCE.n(1111, 36, 1);
                    break;
            }
            f fVar3 = f.Ket;
            f.bR(bVar.contentType, this.KeL - this.KeK);
            if (this.Kez && bVar.data != null) {
                f fVar4 = f.Ket;
                f.bx(this.KeA, true);
            }
        }
        bES();
        AppMethodBeat.o(124889);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.j
    public final void aih(int i2) {
        AppMethodBeat.i(124890);
        Log.e("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultError id: %s, requestImageType: %d, responseCode: %d", this.id, Integer.valueOf(this.KeA), Integer.valueOf(i2));
        this.KeL = System.currentTimeMillis();
        if (this.hkH) {
            f fVar = f.Ket;
            f.bw(this.KeA, false);
            if (this.Kez) {
                f fVar2 = f.Ket;
                f.bx(this.KeA, false);
            }
        }
        bES();
        AppMethodBeat.o(124890);
    }

    private final void bES() {
        AppMethodBeat.i(124891);
        g gVar = g.Kev;
        if (g.aig(this.scene)) {
            com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
            com.tencent.mm.pluginsdk.model.a.de(3, this.JYs);
        }
        AppMethodBeat.o(124891);
    }
}
