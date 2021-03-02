package com.tencent.mm.plugin.vlog.ui.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.f;

public final class ad implements t {
    public static final a GIA = new a((byte) 0);
    private int GIz = -1;
    private final Context context = this.tiQ.getContext();
    private q nUq;
    public ImageView tiQ;
    private com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;

    static {
        AppMethodBeat.i(191498);
        AppMethodBeat.o(191498);
    }

    public ad(ImageView imageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(imageView, "thumbView");
        p.h(dVar, "status");
        AppMethodBeat.i(191497);
        this.tiQ = imageView;
        this.wgr = dVar;
        AppMethodBeat.o(191497);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191499);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191499);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static /* synthetic */ void a(ad adVar, GalleryItem.MediaItem mediaItem, int i2, boolean z, int i3) {
        boolean z2;
        AppMethodBeat.i(191493);
        int i4 = (i3 & 2) != 0 ? -1 : i2;
        if ((i3 & 4) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        p.h(mediaItem, "mediaItem");
        Log.i("MicroMsg.ThumbLoadingPlugin", "showThumbLoading  path:" + mediaItem.dRh());
        f.b(bn.TUK, ba.hMV(), new d(adVar, mediaItem, i4, z2, null), 2);
        AppMethodBeat.o(191493);
    }

    public static /* synthetic */ void a(ad adVar) {
        AppMethodBeat.i(191495);
        adVar.be(R.string.hyh, false);
        AppMethodBeat.o(191495);
    }

    public final void be(int i2, boolean z) {
        String string;
        AppMethodBeat.i(191494);
        Log.i("MicroMsg.ThumbLoadingPlugin", "showDialog, fromThumbLoading:".concat(String.valueOf(z)));
        if (!z || this.GIz == 1) {
            if (i2 < 0) {
                string = this.context.getString(R.string.ekc);
            } else {
                string = this.context.getString(i2);
            }
            p.g(string, "if (strRes < 0) {\n      …tString(strRes)\n        }");
            this.GIz = 2;
            Context context2 = this.context;
            if (context2 == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(191494);
                throw tVar;
            }
            ((Activity) context2).runOnUiThread(new c(this, string));
            AppMethodBeat.o(191494);
            return;
        }
        Log.i("MicroMsg.ThumbLoadingPlugin", "showDialog state error ignore");
        AppMethodBeat.o(191494);
    }

    public static final class c implements Runnable {
        final /* synthetic */ ad GIB;
        final /* synthetic */ String hRn;

        c(ad adVar, String str) {
            this.GIB = adVar;
            this.hRn = str;
        }

        public final void run() {
            AppMethodBeat.i(191480);
            this.GIB.nUq = h.a(this.GIB.context, this.hRn, false, (DialogInterface.OnCancelListener) null);
            AppMethodBeat.o(191480);
        }
    }

    public final void hideLoading() {
        AppMethodBeat.i(191496);
        Log.i("MicroMsg.ThumbLoadingPlugin", "hideLoading");
        f.b(bn.TUK, ba.hMV(), new b(this, null), 2);
        AppMethodBeat.o(191496);
    }

    public static final class d extends j implements m<ai, kotlin.d.d<? super x>, Object> {
        float CED;
        final /* synthetic */ ad GIB;
        final /* synthetic */ GalleryItem.MediaItem GIC;
        final /* synthetic */ int GID;
        final /* synthetic */ boolean GIE;
        Object L$0;
        int label;
        private ai p$;
        Object pED;
        Object pEE;
        Object pEF;
        int pEQ;
        int pER;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ad adVar, GalleryItem.MediaItem mediaItem, int i2, boolean z, kotlin.d.d dVar) {
            super(2, dVar);
            this.GIB = adVar;
            this.GIC = mediaItem;
            this.GID = i2;
            this.GIE = z;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(191491);
            p.h(dVar, "completion");
            d dVar2 = new d(this.GIB, this.GIC, this.GID, this.GIE, dVar);
            dVar2.p$ = (ai) obj;
            AppMethodBeat.o(191491);
            return dVar2;
        }

        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(191492);
            Object invokeSuspend = ((d) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(191492);
            return invokeSuspend;
        }

        public static final class a extends j implements m<ai, kotlin.d.d<? super Bitmap>, Object> {
            final /* synthetic */ d GIG;
            int label;
            private ai p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, kotlin.d.d dVar2) {
                super(2, dVar2);
                this.GIG = dVar;
            }

            @Override // kotlin.d.b.a.a
            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                AppMethodBeat.i(191488);
                p.h(dVar, "completion");
                a aVar = new a(this.GIG, dVar);
                aVar.p$ = (ai) obj;
                AppMethodBeat.o(191488);
                return aVar;
            }

            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, kotlin.d.d<? super Bitmap> dVar) {
                AppMethodBeat.i(191489);
                Object invokeSuspend = ((a) create(aiVar, dVar)).invokeSuspend(x.SXb);
                AppMethodBeat.o(191489);
                return invokeSuspend;
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                AppMethodBeat.i(191487);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        Bitmap a2 = e.dQJ().a(this.GIG.GIC.dRh(), this.GIG.GIC.dRh(), null, this.GIG.GIC.xja);
                        AppMethodBeat.o(191487);
                        return a2;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(191487);
                        throw illegalStateException;
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x00b9  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00d0  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0178  */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
            // Method dump skipped, instructions count: 436
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.plugin.ad.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class b extends j implements m<ai, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ ad GIB;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ad adVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.GIB = adVar;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(191478);
            p.h(dVar, "completion");
            b bVar = new b(this.GIB, dVar);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(191478);
            return bVar;
        }

        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(191479);
            Object invokeSuspend = ((b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(191479);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(191477);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.GIB.GIz = 3;
                    this.GIB.tiQ.setVisibility(8);
                    q qVar = this.GIB.nUq;
                    if (qVar != null) {
                        qVar.dismiss();
                    }
                    this.GIB.nUq = null;
                    x xVar = x.SXb;
                    AppMethodBeat.o(191477);
                    return xVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(191477);
                    throw illegalStateException;
            }
        }
    }

    public static final /* synthetic */ float a(ad adVar, int i2, int i3, boolean z) {
        AppMethodBeat.i(191500);
        Point az = ao.az(adVar.context);
        float f2 = ((float) az.y) / ((float) az.x);
        float f3 = (((float) i3) * 1.0f) / ((float) i2);
        float f4 = z ? f2 : 0.5625f;
        if (f3 < f4) {
            float f5 = (1.0f * (f4 * ((float) az.x))) / ((float) i3);
            AppMethodBeat.o(191500);
            return f5;
        } else if (f3 > f2) {
            float f6 = (1.0f * ((float) az.x)) / ((float) i2);
            AppMethodBeat.o(191500);
            return f6;
        } else {
            AppMethodBeat.o(191500);
            return 1.0f;
        }
    }

    public static final /* synthetic */ int a(ad adVar, int i2, float f2) {
        AppMethodBeat.i(191501);
        if (((float) i2) * f2 > ((float) av.az(adVar.context).x)) {
            int i3 = (int) (((float) av.az(adVar.context).x) / f2);
            AppMethodBeat.o(191501);
            return i3;
        }
        AppMethodBeat.o(191501);
        return i2;
    }

    public static final /* synthetic */ int b(ad adVar, int i2, float f2) {
        AppMethodBeat.i(191502);
        if (((float) i2) * f2 > ((float) av.az(adVar.context).y)) {
            int i3 = (int) (((float) av.az(adVar.context).y) / f2);
            AppMethodBeat.o(191502);
            return i3;
        }
        AppMethodBeat.o(191502);
        return i2;
    }
}
