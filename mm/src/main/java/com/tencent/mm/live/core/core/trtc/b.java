package com.tencent.mm.live.core.core.trtc;

import android.content.Context;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class b extends TRTCCloudImpl {
    private static b hAO;
    public static final a hAP = new a((byte) 0);

    static {
        AppMethodBeat.i(196512);
        AppMethodBeat.o(196512);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        p.h(context, "var0");
        AppMethodBeat.i(196511);
        AppMethodBeat.o(196511);
    }

    public static final /* synthetic */ void a(b bVar, Runnable runnable) {
        AppMethodBeat.i(196513);
        bVar.runOnSDKThread(runnable);
        AppMethodBeat.o(196513);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* renamed from: com.tencent.mm.live.core.core.trtc.b$a$a */
        public static final class RunnableC0386a implements Runnable {
            public static final RunnableC0386a hAQ = new RunnableC0386a();

            static {
                AppMethodBeat.i(196508);
                AppMethodBeat.o(196508);
            }

            RunnableC0386a() {
            }

            public final void run() {
                AppMethodBeat.i(196507);
                b bVar = b.hAO;
                if (bVar != null) {
                    bVar.finalize();
                    AppMethodBeat.o(196507);
                    return;
                }
                AppMethodBeat.o(196507);
            }
        }
    }

    public final CharSequence aDA() {
        AppMethodBeat.i(196509);
        CharSequence uploadStreamInfo = getUploadStreamInfo();
        p.g(uploadStreamInfo, "uploadStreamInfo");
        AppMethodBeat.o(196509);
        return uploadStreamInfo;
    }

    public static CharSequence Gq(String str) {
        AppMethodBeat.i(196510);
        p.h(str, "sdkuid");
        AppMethodBeat.o(196510);
        return null;
    }
}
