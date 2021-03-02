package com.tencent.mm.plugin.game.media.preview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class a implements b {
    boolean edF;
    MMVideoView xCT;
    private String xCU;
    C1402a xCV = new C1402a(this, (byte) 0);

    public a(MMVideoView mMVideoView) {
        AppMethodBeat.i(41228);
        this.xCT = mMVideoView;
        AppMethodBeat.o(41228);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void p(final String str, final String str2, final String str3) {
        AppMethodBeat.i(41229);
        Log.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s start http stream[%s, %s, %s]", Integer.valueOf(hashCode()), str, str3, str2);
        this.xCU = str;
        if (this.edF) {
            this.edF = false;
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.preview.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(41219);
                    o.bhk().a(a.a(str, str3, str2, a.this.xCV), false);
                    AppMethodBeat.o(41219);
                }
            }, 1000);
            AppMethodBeat.o(41229);
            return;
        }
        o.bhk().a(a(str, str3, str2, this.xCV), false);
        AppMethodBeat.o(41229);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void he(String str) {
        AppMethodBeat.i(41230);
        Log.i("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, stop stream[%s]", Integer.valueOf(hashCode()), str);
        if (Util.nullAsNil(this.xCU).equals(str)) {
            o.bhk().m(str, null);
        }
        AppMethodBeat.o(41230);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void requestVideoData(String str, int i2, int i3) {
        AppMethodBeat.i(41231);
        Log.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, request video data[%s, %s, %s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (Util.nullAsNil(this.xCU).equals(str)) {
            o.bhk();
            e.r(str, i2, i3);
        }
        AppMethodBeat.o(41231);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final boolean isVideoDataAvailable(String str, int i2, int i3) {
        boolean z = false;
        AppMethodBeat.i(41232);
        Log.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (Util.nullAsNil(this.xCU).equals(str)) {
            z = o.bhk().isVideoDataAvailable(str, i2, i3);
        }
        AppMethodBeat.o(41232);
        return z;
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void a(b.a aVar) {
    }

    static h a(String str, String str2, String str3, C1402a aVar) {
        AppMethodBeat.i(41233);
        h hVar = new h();
        hVar.taskName = "task_GameOnlineVideoProxy";
        hVar.field_mediaId = str;
        hVar.url = str2;
        hVar.gqU = 1;
        hVar.gqP = 3;
        hVar.concurrentCount = 4;
        hVar.field_fullpath = str3;
        hVar.gre = aVar;
        AppMethodBeat.o(41233);
        return hVar;
    }

    /* renamed from: com.tencent.mm.plugin.game.media.preview.a$a  reason: collision with other inner class name */
    class C1402a implements h.a {
        private C1402a() {
        }

        /* synthetic */ C1402a(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(final String str, final long j2, final long j3, final String str2) {
            AppMethodBeat.i(204141);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.preview.a.C1402a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(41220);
                    if (a.this.xCT != null) {
                        a.this.xCT.AI(j2);
                    }
                    AppMethodBeat.o(41220);
                }
            });
            AppMethodBeat.o(204141);
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(final String str, final long j2, final long j3) {
            AppMethodBeat.i(41225);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.preview.a.C1402a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(41221);
                    if (a.this.xCT != null) {
                        a.this.xCT.onDataAvailable(str, j2, j3);
                    }
                    AppMethodBeat.o(41221);
                }
            });
            AppMethodBeat.o(41225);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(final String str, final long j2, final long j3) {
            AppMethodBeat.i(41226);
            Log.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, onProgress[mediaId:%s, offset:%d, total:%d]", Integer.valueOf(a.this.hashCode()), str, Long.valueOf(j2), Long.valueOf(j3));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.preview.a.C1402a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(41222);
                    if (a.this.xCT != null) {
                        a.this.xCT.i(str, j2, j3);
                    }
                    AppMethodBeat.o(41222);
                }
            });
            AppMethodBeat.o(41226);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(final String str, final int i2, d dVar) {
            AppMethodBeat.i(41227);
            Log.d("MicroMsg.Haowan.GameOnlineVideoProxy", "%s, onFinish[mediaId:%s, ret:%d]", Integer.valueOf(a.this.hashCode()), str, Integer.valueOf(i2));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.preview.a.C1402a.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(41223);
                    if (a.this.xCT != null) {
                        a.this.xCT.ax(str, i2);
                    }
                    AppMethodBeat.o(41223);
                }
            });
            AppMethodBeat.o(41227);
        }
    }
}
