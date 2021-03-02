package com.tencent.mm.media.widget.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.a.d;
import com.tencent.mm.media.widget.camerarecordview.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.x;

public final class a extends MMHandler {
    private static final int imT = imT;
    public static final C0425a imU = new C0425a((byte) 0);
    private final String TAG = "MicroMsg.BaseCameraHandler";
    public float gZZ;
    private d hAt;
    public float haa;
    public Handler imK;
    public HandlerThread imL;
    public kotlin.g.a.b<? super Bitmap, x> imM;
    public com.tencent.mm.media.widget.b.d imN;
    public int imO;
    public int imP;
    public boolean imQ = true;
    public String imR;
    public final ImageReader.OnImageAvailableListener imS;
    private Context mContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Looper looper, Context context, d dVar) {
        super(looper);
        p.h(looper, "looper");
        p.h(context, "mContext");
        p.h(dVar, "camera");
        AppMethodBeat.i(218844);
        this.mContext = context;
        this.hAt = dVar;
        b.C0437b bVar = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
        this.imR = b.C0437b.aQC();
        Log.i(this.TAG, "init camera handler");
        this.imL = new HandlerThread("CameraHandler");
        HandlerThread handlerThread = this.imL;
        if (handlerThread == null) {
            p.hyc();
        }
        handlerThread.start();
        HandlerThread handlerThread2 = this.imL;
        if (handlerThread2 == null) {
            p.hyc();
        }
        this.imK = new Handler(handlerThread2.getLooper());
        if (com.tencent.mm.media.widget.d.b.aRH()) {
            this.imN = new com.tencent.mm.media.widget.b.d(this.mContext);
        }
        this.imS = new b(this);
        AppMethodBeat.o(218844);
    }

    private Rect a(float f2, float f3, float f4, int i2, int i3) {
        AppMethodBeat.i(218842);
        Rect a2 = this.hAt.a(f2, f3, f4, i2, i3);
        AppMethodBeat.o(218842);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public static final class b implements ImageReader.OnImageAvailableListener {
        final /* synthetic */ a imV;

        b(a aVar) {
            this.imV = aVar;
        }

        public final void onImageAvailable(ImageReader imageReader) {
            boolean z;
            AppMethodBeat.i(218841);
            com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
            com.tencent.mm.media.widget.d.a.aRl();
            a aVar2 = this.imV;
            com.tencent.mm.media.widget.b.d dVar = this.imV.imN;
            com.tencent.mm.media.widget.b.b bVar = com.tencent.mm.media.widget.b.b.inE;
            Point aPE = com.tencent.mm.media.widget.b.b.aPE();
            if (aPE == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.b.b bVar2 = com.tencent.mm.media.widget.b.b.inE;
            if (!com.tencent.mm.media.widget.b.b.aPB()) {
                z = true;
            } else {
                z = false;
            }
            Image acquireLatestImage = imageReader.acquireLatestImage();
            p.g(acquireLatestImage, "it.acquireLatestImage()");
            aVar2.post(new com.tencent.mm.media.widget.b.a(dVar, aPE, z, acquireLatestImage, new kotlin.g.a.b<Bitmap, x>(this) {
                /* class com.tencent.mm.media.widget.a.a.a.b.AnonymousClass1 */
                final /* synthetic */ b imW;

                {
                    this.imW = r2;
                }

                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Bitmap bitmap) {
                    AppMethodBeat.i(218840);
                    Bitmap bitmap2 = bitmap;
                    p.h(bitmap2, "image");
                    Log.i(this.imW.imV.TAG, "onImageAvailableListener, image:" + bitmap2 + ", width:" + bitmap2.getWidth() + ", height:" + bitmap2.getHeight());
                    kotlin.g.a.b<? super Bitmap, x> bVar = this.imW.imV.imM;
                    if (bVar != null) {
                        bVar.invoke(bitmap2);
                    }
                    com.tencent.mm.media.widget.b.b bVar2 = com.tencent.mm.media.widget.b.b.inE;
                    if (com.tencent.mm.media.widget.b.b.aPB()) {
                        com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
                        com.tencent.mm.media.widget.d.a.aRm();
                    } else {
                        com.tencent.mm.media.widget.d.a aVar2 = com.tencent.mm.media.widget.d.a.itg;
                        com.tencent.mm.media.widget.d.a.aRn();
                    }
                    com.tencent.mm.media.widget.d.a aVar3 = com.tencent.mm.media.widget.d.a.itg;
                    com.tencent.mm.media.widget.d.a.aRo();
                    com.tencent.mm.media.widget.b.d dVar = this.imW.imV.imN;
                    if (dVar != null) {
                        dVar.release();
                    }
                    this.imW.imV.imN = null;
                    x xVar = x.SXb;
                    AppMethodBeat.o(218840);
                    return xVar;
                }
            }));
            AppMethodBeat.o(218841);
        }
    }

    @Override // com.tencent.mm.sdk.platformtools.MMHandler
    public final void handleMessage(Message message) {
        boolean z = true;
        AppMethodBeat.i(218843);
        p.h(message, "msg");
        if (message.what == imT) {
            if (this.imO == 0 || this.imP == 0 || com.tencent.mm.compatible.util.d.oE(14)) {
                this.imQ = false;
                this.imR = this.hAt.aPw();
                this.imQ = !this.hAt.aPx();
                Log.i(this.TAG, "triggerAutoFocus ret " + this.imQ);
                AppMethodBeat.o(218843);
                return;
            }
            float f2 = this.gZZ;
            float f3 = this.haa;
            int i2 = this.imO;
            int i3 = this.imP;
            if (this.hAt == null) {
                Log.w(this.TAG, "want to auto focus, but camera is null, do nothing");
                AppMethodBeat.o(218843);
                return;
            } else if (!this.imQ) {
                Log.w(this.TAG, "auto focus not back");
                AppMethodBeat.o(218843);
                return;
            } else {
                this.imQ = false;
                this.imR = this.hAt.aPw();
                if (this.hAt.b(a(f2, f3, 1.0f, i2, i3), a(f2, f3, 1.5f, i2, i3))) {
                    z = false;
                }
                this.imQ = z;
            }
        }
        AppMethodBeat.o(218843);
    }

    /* renamed from: com.tencent.mm.media.widget.a.a.a$a */
    public static final class C0425a {
        private C0425a() {
        }

        public /* synthetic */ C0425a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(218845);
        AppMethodBeat.o(218845);
    }
}
