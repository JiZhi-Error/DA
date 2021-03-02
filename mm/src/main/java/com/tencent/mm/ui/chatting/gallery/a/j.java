package com.tencent.mm.ui.chatting.gallery.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0003\u0011\u0014\u0017\u0018\u0000 F2\u00020\u0001:\u0003FGHB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\u001a\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010(\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u001cH\u0002J,\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010&\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010/\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001eH\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\"2\u0006\u00102\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\"2\u0006\u00102\u001a\u000207H\u0002J\u0006\u00108\u001a\u00020\"J\b\u00109\u001a\u00020\"H\u0002J\b\u0010:\u001a\u00020\"H\u0002J\u0010\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\tH\u0002J>\u0010=\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010<\u001a\u0004\u0018\u00010\t2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020B2\b\u0010'\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020\t2\u0006\u00102\u001a\u000205H\u0002J\"\u0010E\u001a\u00020\"2\u0006\u0010D\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u00102\u001a\u000207H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000RR\u0010\u0007\u001aF\u0012\u0004\u0012\u00020\t\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\f0\bj\"\u0012\u0004\u0012\u00020\t\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\f`\rX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f`\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018RR\u0010\u0019\u001aF\u0012\u0004\u0012\u00020\t\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a`\f0\bj\"\u0012\u0004\u0012\u00020\t\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a`\f`\rX\u000e¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001c0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001c`\rX\u000e¢\u0006\u0002\n\u0000R*\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e`\rX\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager;", "", "context", "Landroid/app/Activity;", "enableScan", "", "(Landroid/app/Activity;Z)V", "handleCodeCallbackListMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeHandleCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "handleCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "mNotifyDealQBarStrResultListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1;", "mScanQRCodeFailEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1;", "mScanQRCodeResultEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1;", "scanCodeCallbackListMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeCallback;", "scanCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "scanCodeResultCache", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "canUseCache", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "cancelHandleCode", "", "cancelScanCode", "clearScanCodeResult", "doHandleCode", "codeResult", "callback", "doScanCode", "getScanCodeResultFromCache", "handleCode", "currentImageView", "Landroid/view/View;", "viewModel", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeViewModel;", "isCacheValid", "result", "onHandleCodeNotifyEvent", "event", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "onScanCodeFailedWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "onScanCodeSuccessWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "release", "releaseHandleCode", "releaseScanCode", "removeScanCodeCache", "imagePath", JsApiScanCode.NAME, "bitmap", "Landroid/graphics/Bitmap;", "getCodePosition", "recognizeType", "", "updateFailedResultCache", "key", "updateSuccessResultCache", "Companion", "ScanCodeRequest", "ScanCodeResultWrapper", "app_release"})
public final class j {
    public static final a PCB = new a((byte) 0);
    public final e PCA = new e(this);
    public boolean PCs = true;
    public HashMap<String, b> PCt = new HashMap<>();
    public HashMap<String, ArrayList<h>> PCu = new HashMap<>();
    public HashMap<String, c> PCv = new HashMap<>();
    public HashMap<String, n> PCw = new HashMap<>();
    public HashMap<String, ArrayList<i>> PCx = new HashMap<>();
    public final g PCy = new g(this);
    public final f PCz = new f(this);
    public Activity dKq;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "", "()V", "failedResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "getFailedResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "setFailedResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;)V", "isVerticalLong", "", "()Z", "setVerticalLong", "(Z)V", "success", "getSuccess", "setSuccess", "successResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "getSuccessResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "setSuccessResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;)V", "app_release"})
    public static final class c {
        boolean PCD;
        qz PCE;
        qy PCF;
        boolean success;
    }

    static {
        AppMethodBeat.i(231272);
        AppMethodBeat.o(231272);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public j(Activity activity, boolean z) {
        p.h(activity, "context");
        AppMethodBeat.i(231271);
        this.dKq = activity;
        this.PCs = z;
        Log.i("MicroMsg.ImageScanCodeManager", "scanCode enableScan: %b", Boolean.valueOf(z));
        if (z) {
            this.PCy.alive();
            this.PCz.alive();
            this.PCA.alive();
        }
        AppMethodBeat.o(231271);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "callback", "", "event", "app_release"})
    public static final class g extends IListener<qz> {
        final /* synthetic */ j PCG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(j jVar) {
            this.PCG = jVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(231265);
            qz qzVar2 = qzVar;
            if (qzVar2 != null) {
                j.a(this.PCG, qzVar2);
            }
            AppMethodBeat.o(231265);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "callback", "", "event", "app_release"})
    public static final class f extends IListener<qy> {
        final /* synthetic */ j PCG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(j jVar) {
            this.PCG = jVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qy qyVar) {
            AppMethodBeat.i(231264);
            qy qyVar2 = qyVar;
            if (qyVar2 != null) {
                j.a(this.PCG, qyVar2);
            }
            AppMethodBeat.o(231264);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "callback", "", "event", "app_release"})
    public static final class e extends IListener<np> {
        final /* synthetic */ j PCG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(j jVar) {
            this.PCG = jVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(np npVar) {
            AppMethodBeat.i(231263);
            np npVar2 = npVar;
            if (npVar2 != null) {
                j.a(this.PCG, npVar2);
            }
            AppMethodBeat.o(231263);
            return false;
        }
    }

    public final void a(View view, String str, Bitmap bitmap, boolean z, int i2, h hVar) {
        boolean z2;
        AppMethodBeat.i(231266);
        if (!this.PCs) {
            AppMethodBeat.o(231266);
            return;
        }
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(231266);
            return;
        }
        b bVar = new b();
        bVar.dDZ = System.currentTimeMillis();
        bVar.setImagePath(str);
        bVar.bitmap = bitmap;
        bVar.PCC = z;
        bVar.dXx = i2;
        bVar.PCD = false;
        Log.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode session: %d, imagePath: %s, bitmap: %s, getCodePosition: %b", Long.valueOf(bVar.dDZ), str, bitmap, Boolean.valueOf(z));
        if (view instanceof com.tencent.mm.ui.base.g) {
            int imageWidth = ((com.tencent.mm.ui.base.g) view).getImageWidth();
            int imageHeight = ((com.tencent.mm.ui.base.g) view).getImageHeight();
            int jn = com.tencent.mm.cb.a.jn(this.dKq);
            int jo = com.tencent.mm.cb.a.jo(this.dKq);
            if ((1.0f * ((float) imageHeight)) / ((float) imageWidth) >= (2.0f * ((float) jo)) / ((float) jn)) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.PCD = z2;
            Log.d("MicroMsg.ImageScanCodeManager", "alvinluo scanCode imageSize: %d, %d, screen: %d, %d, current: %s, verticalLong: %s", Integer.valueOf(imageWidth), Integer.valueOf(imageHeight), Integer.valueOf(jn), Integer.valueOf(jo), view, Boolean.valueOf(bVar.PCD));
        }
        if (bitmap == null || !(view instanceof com.tencent.mm.ui.base.g) || !bVar.PCD) {
            bVar.bitmap = null;
            a(bVar, hVar);
            AppMethodBeat.o(231266);
            return;
        }
        bVar.bitmap = o.j(bitmap, view.getMeasuredWidth(), view.getMeasuredHeight());
        a(bVar, hVar);
        AppMethodBeat.o(231266);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$handleCode$codeHandler$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/IImageScanCodeHandler;", "handleCode", "", "codeResult", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "app_release"})
    public static final class d implements d {
        final /* synthetic */ j PCG;
        final /* synthetic */ i PCH;

        public d(j jVar, i iVar) {
            this.PCG = jVar;
            this.PCH = iVar;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.d
        public final void a(n nVar) {
            AppMethodBeat.i(231262);
            p.h(nVar, "codeResult");
            j.a(this.PCG, nVar, this.PCH);
            AppMethodBeat.o(231262);
        }
    }

    private static boolean a(b bVar, c cVar) {
        AppMethodBeat.i(231268);
        Log.d("MicroMsg.ImageScanCodeManager", "alvinluo isCacheValid request.getCodePosition: " + bVar.PCC + ", request.isVerticalLong: " + bVar.PCD + ", request.bitmap: " + bVar.bitmap + ", result.isVerticalLong: " + cVar.PCD);
        if (!bVar.PCC || !bVar.PCD || bVar.bitmap == null) {
            boolean z = bVar.PCC;
            AppMethodBeat.o(231268);
            return z;
        }
        boolean z2 = cVar.PCD;
        AppMethodBeat.o(231268);
        return z2;
    }

    private final c a(b bVar) {
        AppMethodBeat.i(231269);
        c cVar = this.PCv.get(bVar.imagePath);
        AppMethodBeat.o(231269);
        return cVar;
    }

    private final void bnd(String str) {
        AppMethodBeat.i(231270);
        this.PCv.remove(str);
        AppMethodBeat.o(231270);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getCodePosition", "", "getGetCodePosition", "()Z", "setGetCodePosition", "(Z)V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "isVerticalLong", "setVerticalLong", "recognizeType", "", "getRecognizeType", "()I", "setRecognizeType", "(I)V", "session", "", "getSession", "()J", "setSession", "(J)V", "app_release"})
    public static final class b {
        boolean PCC;
        boolean PCD;
        Bitmap bitmap;
        public long dDZ;
        int dXx;
        String imagePath = "";

        public final void setImagePath(String str) {
            AppMethodBeat.i(231261);
            p.h(str, "<set-?>");
            this.imagePath = str;
            AppMethodBeat.o(231261);
        }
    }

    private final void a(b bVar, h hVar) {
        c a2;
        AppMethodBeat.i(231267);
        if (bVar.PCC && (a2 = a(bVar)) != null && a(bVar, a2)) {
            Log.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode get result from cache %s", bVar.imagePath);
            if (!a2.success || a2.PCE == null) {
                if (a2.success || a2.PCF == null) {
                    bnd(bVar.imagePath);
                } else if (hVar != null) {
                    qy qyVar = a2.PCF;
                    if (qyVar == null) {
                        p.hyc();
                    }
                    hVar.b(qyVar);
                    AppMethodBeat.o(231267);
                    return;
                } else {
                    AppMethodBeat.o(231267);
                    return;
                }
            } else if (hVar != null) {
                qz qzVar = a2.PCE;
                if (qzVar == null) {
                    p.hyc();
                }
                hVar.b(qzVar);
                AppMethodBeat.o(231267);
                return;
            } else {
                AppMethodBeat.o(231267);
                return;
            }
        }
        if (!Util.isNullOrNil(bVar.imagePath)) {
            String str = bVar.imagePath;
            if (!this.PCu.containsKey(str)) {
                this.PCu.put(str, new ArrayList<>());
            }
            ArrayList<h> arrayList = this.PCu.get(str);
            if (arrayList == null) {
                p.hyc();
            }
            if (!arrayList.contains(hVar)) {
                ArrayList<h> arrayList2 = this.PCu.get(str);
                if (arrayList2 == null) {
                    p.hyc();
                }
                arrayList2.add(hVar);
            }
            if (this.PCt.containsKey(str)) {
                Log.w("MicroMsg.ImageScanCodeManager", "alvinluo scanCode image %s is already decoding and ignore", bVar.imagePath);
                AppMethodBeat.o(231267);
                return;
            }
            this.PCt.put(str, bVar);
            qx qxVar = new qx();
            qxVar.dXu.dDZ = bVar.dDZ;
            qxVar.dXu.filePath = bVar.imagePath;
            qxVar.dXu.bitmap = bVar.bitmap;
            qxVar.dXu.dXw = bVar.PCC;
            qxVar.dXu.dXx = bVar.dXx;
            EventCenter.instance.publish(qxVar);
        }
        AppMethodBeat.o(231267);
    }

    public static final /* synthetic */ void a(j jVar, n nVar, i iVar) {
        String str;
        AppMethodBeat.i(231273);
        String str2 = nVar.CFJ;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        if (!jVar.PCx.containsKey(str)) {
            jVar.PCx.put(str, new ArrayList<>());
        }
        ArrayList<i> arrayList = jVar.PCx.get(str);
        if (arrayList == null) {
            p.hyc();
        }
        if (!arrayList.contains(iVar)) {
            ArrayList<i> arrayList2 = jVar.PCx.get(str);
            if (arrayList2 == null) {
                p.hyc();
            }
            arrayList2.add(iVar);
        }
        jVar.PCw.put(str, nVar);
        cr crVar = new cr();
        crVar.dFK.activity = jVar.dKq;
        crVar.dFK.dDX = nVar.CFJ;
        crVar.dFK.dFL = nVar.dFL;
        crVar.dFK.dFM = nVar.dFM;
        crVar.dFK.scene = 37;
        crVar.dFK.source = nVar.source;
        crVar.dFK.sourceType = nVar.sourceType;
        crVar.dFK.dFO = nVar.dFO;
        crVar.dFK.imagePath = nVar.imagePath;
        crVar.dFK.dFP = nVar.dFP;
        EventCenter.instance.publish(crVar);
        AppMethodBeat.o(231273);
    }

    public static final /* synthetic */ void a(j jVar, qz qzVar) {
        String str;
        boolean z = false;
        AppMethodBeat.i(231274);
        String str2 = qzVar.dXz.filePath;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        Log.v("MicroMsg.ImageScanCodeManager", "onScanCodeSuccessWrapper key: %s", str);
        ArrayList<h> arrayList = jVar.PCu.get(str);
        if (arrayList != null) {
            for (T t : arrayList) {
                if (t != null) {
                    t.b(qzVar);
                }
            }
        }
        b remove = jVar.PCt.remove(str);
        jVar.PCu.remove(str);
        if (remove == null || remove.PCC) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = remove != null ? Boolean.valueOf(remove.PCD) : null;
            Log.v("MicroMsg.ImageScanCodeManager", "alvinluo updateSuccessResultCache key: %s, isVerticalLong: %s", objArr);
            c cVar = jVar.PCv.get(str);
            if (cVar == null) {
                HashMap<String, c> hashMap = jVar.PCv;
                c cVar2 = new c();
                cVar2.PCE = qzVar;
                cVar2.PCF = null;
                cVar2.success = true;
                cVar2.PCD = remove != null ? remove.PCD : false;
                hashMap.put(str, cVar2);
                AppMethodBeat.o(231274);
                return;
            }
            cVar.PCE = qzVar;
            cVar.PCF = null;
            cVar.success = true;
            if (remove != null) {
                z = remove.PCD;
            }
            cVar.PCD = z;
        }
        AppMethodBeat.o(231274);
    }

    public static final /* synthetic */ void a(j jVar, qy qyVar) {
        String str;
        AppMethodBeat.i(231275);
        String str2 = qyVar.dXy.filePath;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        ArrayList<h> arrayList = jVar.PCu.get(str);
        if (arrayList != null) {
            for (T t : arrayList) {
                if (t != null) {
                    t.b(qyVar);
                }
            }
        }
        b remove = jVar.PCt.remove(str);
        jVar.PCu.remove(str);
        if (remove == null || remove.PCC) {
            c cVar = jVar.PCv.get(str);
            if (cVar == null) {
                c cVar2 = new c();
                cVar2.PCF = qyVar;
                cVar2.PCE = null;
                cVar2.success = false;
                jVar.PCv.put(str, cVar2);
                AppMethodBeat.o(231275);
                return;
            }
            cVar.PCF = qyVar;
            cVar.PCE = null;
            cVar.success = false;
        }
        AppMethodBeat.o(231275);
    }

    public static final /* synthetic */ void a(j jVar, np npVar) {
        String str;
        AppMethodBeat.i(231276);
        String str2 = npVar.dTL.dDX;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        ArrayList<i> arrayList = jVar.PCx.get(str);
        if (arrayList != null) {
            for (T t : arrayList) {
                if (t != null) {
                    t.a(npVar);
                }
            }
        }
        jVar.PCw.remove(str);
        AppMethodBeat.o(231276);
    }
}
