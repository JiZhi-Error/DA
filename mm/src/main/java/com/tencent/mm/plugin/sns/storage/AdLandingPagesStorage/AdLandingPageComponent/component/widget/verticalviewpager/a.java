package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.plugin.appbrand.jsapi.p.p;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a implements b {
    b.a qWn;
    String xCU = "";

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a$a  reason: collision with other inner class name */
    class C1725a implements h.a {
        private C1725a() {
        }

        /* synthetic */ C1725a(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(final String str, final long j2, final long j3, final String str2) {
            AppMethodBeat.i(203122);
            if (a.this.qWn != null && a.this.xCU.equals(str)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.C1725a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96954);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 27);
                        a.this.qWn.AI(j2);
                        AppMethodBeat.o(96954);
                    }
                });
            }
            AppMethodBeat.o(203122);
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(final String str, final long j2, final long j3) {
            AppMethodBeat.i(96959);
            if (a.this.qWn != null && a.this.xCU.equals(str)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.C1725a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(96955);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 29);
                        a.this.qWn.onDataAvailable(str, j2, j3);
                        AppMethodBeat.o(96955);
                    }
                });
            }
            AppMethodBeat.o(96959);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(final String str, final long j2, final long j3) {
            AppMethodBeat.i(96960);
            if (a.this.qWn != null && a.this.xCU.equals(str)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.C1725a.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(96956);
                        a.this.qWn.i(str, j2, j3);
                        AppMethodBeat.o(96956);
                    }
                });
            }
            AppMethodBeat.o(96960);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(final String str, final int i2, d dVar) {
            AppMethodBeat.i(96961);
            if (a.this.qWn != null && a.this.xCU.equals(str)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.C1725a.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(96957);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 31);
                        a.this.qWn.ax(str, i2);
                        AppMethodBeat.o(96957);
                    }
                });
            }
            AppMethodBeat.o(96961);
        }
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void p(String str, String str2, String str3) {
        AppMethodBeat.i(96962);
        this.xCU = str;
        Log.i("MicroMsg.AdLandingOnlineVideoProxy", "%s start http stream[%s, %s, %s]", Integer.valueOf(hashCode()), str, str3, str2);
        AdLandingPagesProxy.getInstance().downloadLandingPageVideo(str, str3, str2, new C1725a(this, (byte) 0));
        AppMethodBeat.o(96962);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void he(String str) {
        AppMethodBeat.i(96963);
        Log.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, stop stream[%s]", Integer.valueOf(hashCode()), str);
        if (this.xCU.equals(str)) {
            AdLandingPagesProxy.getInstance().stopDownloadLandingPageVideo(str);
        }
        AppMethodBeat.o(96963);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void requestVideoData(String str, int i2, int i3) {
        AppMethodBeat.i(96964);
        Log.d("MicroMsg.AdLandingOnlineVideoProxy", "%s, request video data[%s, %s, %s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.xCU.equals(str)) {
            AdLandingPagesProxy.getInstance().requestVideoData(str, i2, i3);
        }
        AppMethodBeat.o(96964);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final boolean isVideoDataAvailable(String str, int i2, int i3) {
        AppMethodBeat.i(96965);
        Log.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.xCU.equals(str)) {
            boolean isVideoDataAvailable = AdLandingPagesProxy.getInstance().isVideoDataAvailable(str, i2, i3);
            AppMethodBeat.o(96965);
            return isVideoDataAvailable;
        }
        AppMethodBeat.o(96965);
        return false;
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void a(b.a aVar) {
        this.qWn = aVar;
    }
}
