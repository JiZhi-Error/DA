package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.ab.c;
import com.tencent.mm.plugin.ab.f;
import com.tencent.mm.plugin.ab.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016JP\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext;", "Lcom/tencent/mm/plugin/webjsapi/WxPopupAPIContext;", "popupTarget", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;", "logicJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "(Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;)V", "TAG", "", "popupWindow", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup;", "close", "", "popupId", "popup", "width", "", "height", "left", "top", "mode", "color", "onDismissCallback", "onOuterClickCallback", "precreate", "CanvasPopup", "Companion", "webview-sdk_release"})
public final class i implements o {
    private static final int IAa = 2;
    public static final b IAb = new b((byte) 0);
    private static final int IzZ = 1;
    private a IzV;
    private final j IzW;
    private final c IzX;
    private final k IzY;
    private final String TAG = "MicroMsg.WebCanvasPopupContext";

    public i(j jVar, c cVar, k kVar) {
        p.h(jVar, "popupTarget");
        p.h(cVar, "logicJsEngine");
        p.h(kVar, "renderJsEngine");
        AppMethodBeat.i(224652);
        this.IzW = jVar;
        this.IzX = cVar;
        this.IzY = kVar;
        AppMethodBeat.o(224652);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B[\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0006\u0010\u001b\u001a\u00020\u0016R\u000e\u0010\u0012\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "Landroid/view/View$OnAttachStateChangeListener;", "popupId", "", "popupWidth", "", "popupHeight", "left", "top", "mode", "color", "onDismissCallback", "onOuterClickCallback", "context", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext;", "(Ljava/lang/String;IIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "TAG", "getPopupId", "()Ljava/lang/String;", "dismiss", "", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "show", "webview-sdk_release"})
    public static final class a extends com.tencent.mm.ui.base.p implements View.OnAttachStateChangeListener {
        final int IAc;
        final int IAd;
        private final String IAe;
        private final String IAf;
        final String IzJ;
        final String TAG;
        final int color;
        final WeakReference<i> lAM;
        final int left;
        final int mode;
        final int top;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.String r3, int r4, int r5, int r6, int r7, int r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.ref.WeakReference<com.tencent.mm.plugin.webcanvas.i> r12) {
            /*
                r2 = this;
                r1 = 224648(0x36d88, float:3.14799E-40)
                java.lang.String r0 = "popupId"
                kotlin.g.b.p.h(r3, r0)
                java.lang.String r0 = "onDismissCallback"
                kotlin.g.b.p.h(r10, r0)
                java.lang.String r0 = "onOuterClickCallback"
                kotlin.g.b.p.h(r11, r0)
                java.lang.String r0 = "context"
                kotlin.g.b.p.h(r12, r0)
                java.lang.Object r0 = r12.get()
                com.tencent.mm.plugin.webcanvas.i r0 = (com.tencent.mm.plugin.webcanvas.i) r0
                if (r0 == 0) goto L_0x005b
                com.tencent.mm.plugin.webcanvas.j r0 = com.tencent.mm.plugin.webcanvas.i.a(r0)
                if (r0 == 0) goto L_0x005b
                android.view.View r0 = r0.getView()
                if (r0 == 0) goto L_0x005b
                android.content.Context r0 = r0.getContext()
            L_0x0033:
                if (r0 != 0) goto L_0x0038
                kotlin.g.b.p.hyc()
            L_0x0038:
                r2.<init>(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
                r2.IzJ = r3
                r2.IAc = r4
                r2.IAd = r5
                r2.left = r6
                r2.top = r7
                r2.mode = r8
                r2.color = r9
                r2.IAe = r10
                r2.IAf = r11
                r2.lAM = r12
                java.lang.String r0 = "MicroMsg.CanvasPopup"
                r2.TAG = r0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
                return
            L_0x005b:
                r0 = 0
                goto L_0x0033
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webcanvas.i.a.<init>(java.lang.String, int, int, int, int, int, int, java.lang.String, java.lang.String, java.lang.ref.WeakReference):void");
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            AppMethodBeat.i(224646);
            dismiss();
            AppMethodBeat.o(224646);
        }

        @Override // com.tencent.mm.ui.base.p
        public final void dismiss() {
            AppMethodBeat.i(224647);
            Log.i(this.TAG, "popup on dismiss:" + this.IzJ);
            i iVar = this.lAM.get();
            if (iVar != null) {
                View view = iVar.IzW.getView();
                if (view != null) {
                    view.removeOnAttachStateChangeListener(this);
                }
                c.a.a(iVar.IzX, this.IAe, null, null, 6);
                iVar.IzX.aWw("none");
                iVar.IzV = null;
            }
            super.dismiss();
            AppMethodBeat.o(224647);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup$show$2$2"})
        /* renamed from: com.tencent.mm.plugin.webcanvas.i$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1936a implements View.OnClickListener {
            final /* synthetic */ a IAg;
            final /* synthetic */ MagicBrushView IAh;
            final /* synthetic */ int IAi;
            final /* synthetic */ int IAj;
            final /* synthetic */ boolean IAk;
            final /* synthetic */ c IAl;

            View$OnClickListenerC1936a(a aVar, MagicBrushView magicBrushView, int i2, int i3, boolean z, c cVar) {
                this.IAg = aVar;
                this.IAh = magicBrushView;
                this.IAi = i2;
                this.IAj = i3;
                this.IAk = z;
                this.IAl = cVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(224645);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup$show$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.IAk) {
                    c.a.a(this.IAl, this.IAg.IAf, null, null, 6);
                } else {
                    this.IAg.dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$CanvasPopup$show$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(224645);
            }
        }
    }

    @Override // com.tencent.mm.plugin.ab.o
    public final void aWy(String str) {
        AppMethodBeat.i(224649);
        p.h(str, "popupId");
        Log.i(this.TAG, "precreate:".concat(String.valueOf(str)));
        k kVar = this.IzY;
        f.a aVar = f.IBd;
        kVar.a(f.a.getAppContext(), str, false, false);
        AppMethodBeat.o(224649);
    }

    @Override // com.tencent.mm.plugin.ab.o
    public final void a(String str, int i2, int i3, int i4, int i5, int i6, int i7, String str2, String str3) {
        k kVar;
        c cVar;
        Context context;
        RelativeLayout relativeLayout;
        a aVar;
        j jVar;
        AppMethodBeat.i(224650);
        p.h(str, "popupId");
        p.h(str2, "onDismissCallback");
        p.h(str3, "onOuterClickCallback");
        View view = this.IzW.getView();
        if (view == null || !view.isAttachedToWindow()) {
            Log.w(this.TAG, "skip popup when canvasView detached:".concat(String.valueOf(str)));
            c.a.a(this.IzX, str2, null, null, 6);
            AppMethodBeat.o(224650);
            return;
        }
        a aVar2 = this.IzV;
        if (aVar2 != null) {
            aVar2.dismiss();
        }
        a aVar3 = new a(str, i2, i3, i4, i5, i6, i7, str2, str3, new WeakReference(this));
        i iVar = aVar3.lAM.get();
        View view2 = (iVar == null || (jVar = iVar.IzW) == null) ? null : jVar.getView();
        if (view2 == null) {
            p.hyc();
        }
        int[] cm = d.cm(view2);
        cm[0] = cm[0] + aVar3.left;
        cm[1] = cm[1] + aVar3.top;
        int i8 = cm[0];
        int i9 = cm[1];
        Log.d(aVar3.TAG, "popup:" + aVar3.IzJ + " start locate:[" + aVar3.left + ", " + aVar3.top + "] offset:[" + i8 + ", " + i9 + "] size:[" + aVar3.IAc + ", " + aVar3.IAd + "] mode:" + aVar3.mode);
        boolean z = (aVar3.mode & IzZ) != 0;
        boolean z2 = (aVar3.mode & IAa) != 0;
        Integer[] numArr = z ? new Integer[]{0, 0, -1, -1} : new Integer[]{Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(aVar3.IAc), Integer.valueOf(aVar3.IAd)};
        int intValue = numArr[0].intValue();
        int intValue2 = numArr[1].intValue();
        int intValue3 = numArr[2].intValue();
        int intValue4 = numArr[3].intValue();
        Log.i(aVar3.TAG, "popup:" + aVar3.IzJ + " compute locate:[" + intValue + ", " + intValue2 + "] size:[" + intValue3 + ", " + intValue4 + ']');
        i iVar2 = aVar3.lAM.get();
        if (iVar2 != null) {
            kVar = iVar2.IzY;
        } else {
            kVar = null;
        }
        if (kVar == null) {
            p.hyc();
        }
        i iVar3 = aVar3.lAM.get();
        if (iVar3 != null) {
            cVar = iVar3.IzX;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            p.hyc();
        }
        Context context2 = view2.getContext();
        if (context2 instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) context2).getBaseContext();
        } else {
            context = context2;
        }
        p.g(context, "viewContext");
        a a2 = kVar.a(context, aVar3.IzJ, false, false);
        p.h(context, "context");
        if (a2.IyU == null) {
            a2.IyU = new n(a2, new MutableContextWrapper(context));
            n nVar = a2.IyU;
            if (nVar != null) {
                nVar.cYb();
            }
        }
        MagicBrushView MQ = a2.MQ();
        if (MQ == null) {
            p.hyc();
        }
        ViewParent parent = MQ.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(MQ);
        }
        if (z) {
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(aVar3.IAc, aVar3.IAd);
            layoutParams.setMargins(i8, i9 + 0, 0, 0);
            MQ.setLayoutParams(layoutParams);
            relativeLayout2.setOnClickListener(new a.View$OnClickListenerC1936a(aVar3, MQ, i8, i9, z2, cVar));
            relativeLayout2.setBackground(new ColorDrawable(aVar3.color));
            relativeLayout2.setSystemUiVisibility(1284);
            relativeLayout2.addView(MQ);
            relativeLayout = relativeLayout2;
            aVar = aVar3;
        } else {
            relativeLayout = MQ;
            aVar = aVar3;
        }
        aVar.setContentView(relativeLayout);
        aVar3.setWidth(intValue3);
        aVar3.setHeight(intValue4);
        if (!z) {
            aVar3.setTouchable(true);
        }
        aVar3.setClippingEnabled(false);
        view2.addOnAttachStateChangeListener(aVar3);
        aVar3.showAtLocation(view2, 0, intValue, intValue2);
        this.IzV = aVar3;
        this.IzX.aWw(str);
        AppMethodBeat.o(224650);
    }

    @Override // com.tencent.mm.plugin.ab.o
    public final void close(String str) {
        AppMethodBeat.i(224651);
        p.h(str, "popupId");
        a aVar = this.IzV;
        if (aVar != null) {
            if (!p.j(aVar.IzJ, str)) {
                aVar = null;
            }
            if (aVar != null) {
                aVar.dismiss();
                AppMethodBeat.o(224651);
                return;
            }
        }
        AppMethodBeat.o(224651);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupContext$Companion;", "", "()V", "MODE_MASK", "", "MODE_MASK_PERSIST", "webview-sdk_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(224653);
        AppMethodBeat.o(224653);
    }
}
