package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.support.v4.view.u;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.lang.ref.Reference;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class k implements i.c {
    private static final k osR = new k() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.k.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.widget.input.k
        public final void Ac(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.k
        public final void Ad(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c, com.tencent.mm.plugin.appbrand.widget.input.k
        public final void onDestroy() {
        }

        public final String toString() {
            AppMethodBeat.i(136386);
            String str = super.toString() + "|DUMMY";
            AppMethodBeat.o(136386);
            return str;
        }
    };
    private static final android.support.v4.e.a<ac, k> ota = new android.support.v4.e.a<>();
    private final ac cxr;
    final Map<a, k> osQ;
    private final int osS;
    private final int osT;
    private int osU;
    private boolean osV;
    private boolean osW;
    private int osX;
    private Queue<b> osY;
    private int osZ;
    private final Runnable otb;
    private final Runnable otc;

    public interface a {
        void cbs();

        void cbt();
    }

    /* synthetic */ k(byte b2) {
        this();
    }

    static /* synthetic */ void e(k kVar) {
        AppMethodBeat.i(230578);
        kVar.cbq();
        AppMethodBeat.o(230578);
    }

    static /* synthetic */ int g(k kVar) {
        AppMethodBeat.i(136405);
        int i2 = kVar.osU;
        AppMethodBeat.o(136405);
        return i2;
    }

    static /* synthetic */ int h(k kVar) {
        int i2 = kVar.osU + 1;
        kVar.osU = i2;
        return i2;
    }

    static /* synthetic */ void i(k kVar) {
        AppMethodBeat.i(230579);
        kVar.jj(false);
        AppMethodBeat.o(230579);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(136393);
        if (aVar == null) {
            AppMethodBeat.o(136393);
            return;
        }
        this.osQ.remove(aVar);
        AppMethodBeat.o(136393);
    }

    static {
        AppMethodBeat.i(136407);
        AppMethodBeat.o(136407);
    }

    private k() {
        AppMethodBeat.i(136394);
        this.osQ = new android.support.v4.e.a();
        this.osT = 5;
        this.osU = 0;
        this.osV = false;
        this.osW = true;
        this.osX = -1;
        this.osY = new LinkedList();
        this.osZ = 0;
        this.otb = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.k.AnonymousClass2 */

            public final void run() {
                bb bbVar;
                View contentView;
                AppMethodBeat.i(136387);
                if (!k.this.cxr.isRunning()) {
                    AppMethodBeat.o(136387);
                    return;
                }
                View b2 = k.b(k.this);
                if (b2 != null) {
                    b2.scrollTo(0, 0);
                    if (!(k.this.osZ == 0 || (bbVar = k.this.cxr.nmX) == null || (contentView = bbVar.getContentView()) == null)) {
                        contentView.scrollBy(contentView.getScrollX(), -k.this.osZ);
                    }
                    k.d(k.this);
                }
                AppMethodBeat.o(136387);
            }
        };
        this.otc = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.k.AnonymousClass3 */

            public final void run() {
                boolean z;
                int i2;
                int i3;
                View contentView;
                View contentView2;
                Activity castActivityOrNull;
                AppMethodBeat.i(136389);
                Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
                aa F = o.F(k.this.cxr);
                if (F == null) {
                    k.e(k.this);
                    AppMethodBeat.o(136389);
                } else if (!k.this.cxr.isRunning()) {
                    k.e(k.this);
                    AppMethodBeat.o(136389);
                } else {
                    k.this.osZ = 0;
                    if (F.getInputPanel() == null || F.caV() == null) {
                        k.e(k.this);
                        AppMethodBeat.o(136389);
                        return;
                    }
                    EditText caV = F.caV();
                    View inputPanel = F.getInputPanel();
                    if (Build.VERSION.SDK_INT < 24 || caV == null || (castActivityOrNull = AndroidContextUtil.castActivityOrNull(caV.getContext())) == null || !castActivityOrNull.isInMultiWindowMode()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        b(F, 0);
                    } else {
                        if (!((ac) inputPanel).cbD()) {
                            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", Integer.valueOf(inputPanel.getHeight()), Integer.valueOf(k.g(k.this)));
                            if (k.h(k.this) < 5) {
                                k.i(k.this);
                                AppMethodBeat.o(136389);
                                return;
                            }
                        } else {
                            k.this.osU = 0;
                            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", Integer.valueOf(inputPanel.getHeight()));
                        }
                        b(F, inputPanel.getHeight());
                        if (!F.caY()) {
                            Log.i("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", Integer.valueOf(inputPanel.getHeight()));
                        } else if (!(k.this.cxr.kEb instanceof o) || !k.this.cxr.btO()) {
                            int[] iArr = new int[2];
                            caV.getLocationOnScreen(iArr);
                            int i4 = iArr[1];
                            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", Integer.valueOf(caV.getHeight()), Integer.valueOf(i4), Boolean.valueOf(u.aD(caV)));
                            k.k(k.this);
                            int height = caV.getHeight() + i4;
                            inputPanel.getLocationOnScreen(iArr);
                            int i5 = iArr[1];
                            if (!((ab) caV).cbx() || caV.getLayout() == null) {
                                i2 = height;
                                i3 = i4;
                            } else {
                                int Ak = i4 + ((ab) caV).Ak(caV.getLayout().getLineForOffset(caV.getSelectionStart()));
                                int Ak2 = i4 + ((ab) caV).Ak(caV.getLayout().getLineForOffset(caV.getSelectionStart()) + 1);
                                if (Ak - i4 >= caV.getHeight()) {
                                    i3 = height - caV.getLineHeight();
                                } else {
                                    i3 = Ak;
                                }
                                i2 = Ak2 - i4 >= caV.getHeight() ? height : Ak2;
                            }
                            if (!k.this.cxr.btO()) {
                                i2 += F.caZ();
                            }
                            if (i5 != i2) {
                                if (i3 < k.this.osS) {
                                    bb bbVar = k.this.cxr.nmX;
                                    if (!(bbVar == null || (contentView2 = bbVar.getContentView()) == null || caV == null)) {
                                        contentView2.scrollBy(contentView2.getScrollX(), -(bbVar.getWebScrollY() - caV.getTop()));
                                    }
                                    k.e(k.this);
                                    AppMethodBeat.o(136389);
                                    return;
                                }
                                int max = Math.max(-cbr(), Math.min(i2 - i5, i3 - k.this.osS));
                                bb bbVar2 = k.this.cxr.nmX;
                                if (!(bbVar2 == null || (contentView = bbVar2.getContentView()) == null || caV == null)) {
                                    if (((ab) caV).cbB()) {
                                        Ae(cbr() + max);
                                    } else {
                                        int height2 = bbVar2.getHeight();
                                        int webScrollY = bbVar2.getWebScrollY();
                                        int zD = g.zD(bbVar2.getContentHeight());
                                        int height3 = caV.getHeight();
                                        caV.getTop();
                                        if (((ab) caV).cbx() || (caV.getTop() + height3) - webScrollY > height2) {
                                            int max2 = Math.max(0, Math.min((zD - webScrollY) - height2, max));
                                            contentView.scrollBy(contentView.getScrollX(), max2);
                                            k.this.osZ = max2;
                                            Ae((max - max2) + cbr());
                                        } else {
                                            Ae(cbr() + max);
                                        }
                                    }
                                }
                            }
                        } else {
                            Log.i("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, in landscape skip adjust position, notify height %d", Integer.valueOf(inputPanel.getHeight()));
                        }
                    }
                    k.e(k.this);
                    AppMethodBeat.o(136389);
                }
            }

            private void b(final aa aaVar, final int i2) {
                AppMethodBeat.i(136390);
                Log.e("MicroMsg.AppBrandInputPageOffsetHelper", "sendKeyboardEvent: %b", Boolean.valueOf(k.this.osW));
                if (!k.this.osW) {
                    AppMethodBeat.o(136390);
                    return;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.widget.input.k.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(136388);
                        aaVar.zZ(i2);
                        AppMethodBeat.o(136388);
                    }
                });
                AppMethodBeat.o(136390);
            }

            private int cbr() {
                AppMethodBeat.i(136391);
                View b2 = k.b(k.this);
                if (b2 != null) {
                    int scrollY = b2.getScrollY();
                    AppMethodBeat.o(136391);
                    return scrollY;
                }
                AppMethodBeat.o(136391);
                return 0;
            }

            private void Ae(int i2) {
                AppMethodBeat.i(136392);
                Log.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", Integer.valueOf(i2));
                View b2 = k.b(k.this);
                if (b2 != null) {
                    b2.scrollTo(0, i2);
                    k.m(k.this);
                }
                AppMethodBeat.o(136392);
            }
        };
        this.cxr = null;
        this.osS = 0;
        AppMethodBeat.o(136394);
    }

    private k(ac acVar) {
        AppMethodBeat.i(136395);
        this.osQ = new android.support.v4.e.a();
        this.osT = 5;
        this.osU = 0;
        this.osV = false;
        this.osW = true;
        this.osX = -1;
        this.osY = new LinkedList();
        this.osZ = 0;
        this.otb = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.k.AnonymousClass2 */

            public final void run() {
                bb bbVar;
                View contentView;
                AppMethodBeat.i(136387);
                if (!k.this.cxr.isRunning()) {
                    AppMethodBeat.o(136387);
                    return;
                }
                View b2 = k.b(k.this);
                if (b2 != null) {
                    b2.scrollTo(0, 0);
                    if (!(k.this.osZ == 0 || (bbVar = k.this.cxr.nmX) == null || (contentView = bbVar.getContentView()) == null)) {
                        contentView.scrollBy(contentView.getScrollX(), -k.this.osZ);
                    }
                    k.d(k.this);
                }
                AppMethodBeat.o(136387);
            }
        };
        this.otc = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.k.AnonymousClass3 */

            public final void run() {
                boolean z;
                int i2;
                int i3;
                View contentView;
                View contentView2;
                Activity castActivityOrNull;
                AppMethodBeat.i(136389);
                Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
                aa F = o.F(k.this.cxr);
                if (F == null) {
                    k.e(k.this);
                    AppMethodBeat.o(136389);
                } else if (!k.this.cxr.isRunning()) {
                    k.e(k.this);
                    AppMethodBeat.o(136389);
                } else {
                    k.this.osZ = 0;
                    if (F.getInputPanel() == null || F.caV() == null) {
                        k.e(k.this);
                        AppMethodBeat.o(136389);
                        return;
                    }
                    EditText caV = F.caV();
                    View inputPanel = F.getInputPanel();
                    if (Build.VERSION.SDK_INT < 24 || caV == null || (castActivityOrNull = AndroidContextUtil.castActivityOrNull(caV.getContext())) == null || !castActivityOrNull.isInMultiWindowMode()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        b(F, 0);
                    } else {
                        if (!((ac) inputPanel).cbD()) {
                            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", Integer.valueOf(inputPanel.getHeight()), Integer.valueOf(k.g(k.this)));
                            if (k.h(k.this) < 5) {
                                k.i(k.this);
                                AppMethodBeat.o(136389);
                                return;
                            }
                        } else {
                            k.this.osU = 0;
                            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", Integer.valueOf(inputPanel.getHeight()));
                        }
                        b(F, inputPanel.getHeight());
                        if (!F.caY()) {
                            Log.i("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", Integer.valueOf(inputPanel.getHeight()));
                        } else if (!(k.this.cxr.kEb instanceof o) || !k.this.cxr.btO()) {
                            int[] iArr = new int[2];
                            caV.getLocationOnScreen(iArr);
                            int i4 = iArr[1];
                            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", Integer.valueOf(caV.getHeight()), Integer.valueOf(i4), Boolean.valueOf(u.aD(caV)));
                            k.k(k.this);
                            int height = caV.getHeight() + i4;
                            inputPanel.getLocationOnScreen(iArr);
                            int i5 = iArr[1];
                            if (!((ab) caV).cbx() || caV.getLayout() == null) {
                                i2 = height;
                                i3 = i4;
                            } else {
                                int Ak = i4 + ((ab) caV).Ak(caV.getLayout().getLineForOffset(caV.getSelectionStart()));
                                int Ak2 = i4 + ((ab) caV).Ak(caV.getLayout().getLineForOffset(caV.getSelectionStart()) + 1);
                                if (Ak - i4 >= caV.getHeight()) {
                                    i3 = height - caV.getLineHeight();
                                } else {
                                    i3 = Ak;
                                }
                                i2 = Ak2 - i4 >= caV.getHeight() ? height : Ak2;
                            }
                            if (!k.this.cxr.btO()) {
                                i2 += F.caZ();
                            }
                            if (i5 != i2) {
                                if (i3 < k.this.osS) {
                                    bb bbVar = k.this.cxr.nmX;
                                    if (!(bbVar == null || (contentView2 = bbVar.getContentView()) == null || caV == null)) {
                                        contentView2.scrollBy(contentView2.getScrollX(), -(bbVar.getWebScrollY() - caV.getTop()));
                                    }
                                    k.e(k.this);
                                    AppMethodBeat.o(136389);
                                    return;
                                }
                                int max = Math.max(-cbr(), Math.min(i2 - i5, i3 - k.this.osS));
                                bb bbVar2 = k.this.cxr.nmX;
                                if (!(bbVar2 == null || (contentView = bbVar2.getContentView()) == null || caV == null)) {
                                    if (((ab) caV).cbB()) {
                                        Ae(cbr() + max);
                                    } else {
                                        int height2 = bbVar2.getHeight();
                                        int webScrollY = bbVar2.getWebScrollY();
                                        int zD = g.zD(bbVar2.getContentHeight());
                                        int height3 = caV.getHeight();
                                        caV.getTop();
                                        if (((ab) caV).cbx() || (caV.getTop() + height3) - webScrollY > height2) {
                                            int max2 = Math.max(0, Math.min((zD - webScrollY) - height2, max));
                                            contentView.scrollBy(contentView.getScrollX(), max2);
                                            k.this.osZ = max2;
                                            Ae((max - max2) + cbr());
                                        } else {
                                            Ae(cbr() + max);
                                        }
                                    }
                                }
                            }
                        } else {
                            Log.i("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, in landscape skip adjust position, notify height %d", Integer.valueOf(inputPanel.getHeight()));
                        }
                    }
                    k.e(k.this);
                    AppMethodBeat.o(136389);
                }
            }

            private void b(final aa aaVar, final int i2) {
                AppMethodBeat.i(136390);
                Log.e("MicroMsg.AppBrandInputPageOffsetHelper", "sendKeyboardEvent: %b", Boolean.valueOf(k.this.osW));
                if (!k.this.osW) {
                    AppMethodBeat.o(136390);
                    return;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.widget.input.k.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(136388);
                        aaVar.zZ(i2);
                        AppMethodBeat.o(136388);
                    }
                });
                AppMethodBeat.o(136390);
            }

            private int cbr() {
                AppMethodBeat.i(136391);
                View b2 = k.b(k.this);
                if (b2 != null) {
                    int scrollY = b2.getScrollY();
                    AppMethodBeat.o(136391);
                    return scrollY;
                }
                AppMethodBeat.o(136391);
                return 0;
            }

            private void Ae(int i2) {
                AppMethodBeat.i(136392);
                Log.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", Integer.valueOf(i2));
                View b2 = k.b(k.this);
                if (b2 != null) {
                    b2.scrollTo(0, i2);
                    k.m(k.this);
                }
                AppMethodBeat.o(136392);
            }
        };
        this.cxr = acVar;
        this.cxr.a(this);
        this.osS = com.tencent.mm.ui.statusbar.a.bF(acVar.getActivity());
        AppMethodBeat.o(136395);
    }

    public static k a(Reference<ac> reference) {
        AppMethodBeat.i(136396);
        k C = C(reference == null ? null : reference.get());
        AppMethodBeat.o(136396);
        return C;
    }

    public static k C(ac acVar) {
        AppMethodBeat.i(136397);
        if (acVar == null || !acVar.isRunning()) {
            Log.printDebugStack("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page ".concat(String.valueOf(acVar)), new Object[0]);
            k kVar = osR;
            AppMethodBeat.o(136397);
            return kVar;
        }
        k kVar2 = ota.get(acVar);
        if (kVar2 == null) {
            kVar2 = new k(acVar);
            ota.put(acVar, kVar2);
        }
        AppMethodBeat.o(136397);
        return kVar2;
    }

    private void cbq() {
        AppMethodBeat.i(230576);
        if (!this.osY.isEmpty()) {
            this.osY.poll();
            if (!this.osY.isEmpty()) {
                b peek = this.osY.peek();
                c(peek.otg, peek.oth, true);
            }
        }
        AppMethodBeat.o(230576);
    }

    private void jj(boolean z) {
        AppMethodBeat.i(136398);
        if (z) {
            this.osU = 0;
            this.osV = false;
        }
        if (this.cxr == null || !this.cxr.isRunning()) {
            cbq();
            AppMethodBeat.o(136398);
        } else if (this.osV) {
            this.osU = 0;
            cbq();
            AppMethodBeat.o(136398);
        } else if (this.osU == 0) {
            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", Boolean.valueOf(u.aD(this.cxr.getContentView())));
            this.cxr.getContentView().post(this.otc);
            AppMethodBeat.o(136398);
        } else {
            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", Boolean.valueOf(u.aD(this.cxr.getContentView())));
            this.cxr.getContentView().postOnAnimationDelayed(this.otc, 100);
            AppMethodBeat.o(136398);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(230577);
        if (!z2) {
            this.osY.offer(new b(i2, z));
        }
        if (this.osY.size() <= 1 || z2) {
            this.osX = i2;
            this.osW = z;
            jj(true);
        }
        AppMethodBeat.o(230577);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
    public void onDestroy() {
        AppMethodBeat.i(136401);
        this.cxr.b(this);
        ota.remove(this.cxr);
        AppMethodBeat.o(136401);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public int otg;
        public boolean oth;

        public b(int i2, boolean z) {
            this.otg = i2;
            this.oth = z;
        }
    }

    public void Ac(int i2) {
        AppMethodBeat.i(136399);
        c(i2, true, false);
        AppMethodBeat.o(136399);
    }

    public void Ad(int i2) {
        AppMethodBeat.i(136400);
        if (this.cxr.isRunning()) {
            if (i2 != this.osX) {
                Log.w("MicroMsg.AppBrandInputPageOffsetHelper", "requestScrollDown, skip last-ticket %d, pass-in-ticket %d", Integer.valueOf(this.osX), Integer.valueOf(i2));
                AppMethodBeat.o(136400);
                return;
            }
            this.osV = true;
            this.osW = true;
            this.cxr.getContentView().post(this.otb);
        }
        AppMethodBeat.o(136400);
    }

    static /* synthetic */ View b(k kVar) {
        AppMethodBeat.i(136402);
        if (!kVar.cxr.isRunning()) {
            AppMethodBeat.o(136402);
            return null;
        }
        FrameLayout frameLayout = kVar.cxr.noq;
        AppMethodBeat.o(136402);
        return frameLayout;
    }

    static /* synthetic */ void d(k kVar) {
        AppMethodBeat.i(136403);
        if (kVar.osQ.size() > 0) {
            for (a aVar : (a[]) kVar.osQ.keySet().toArray(new a[kVar.osQ.size()])) {
                aVar.cbt();
            }
        }
        AppMethodBeat.o(136403);
    }

    static /* synthetic */ int k(k kVar) {
        AppMethodBeat.i(230580);
        Display defaultDisplay = ((WindowManager) kVar.cxr.getContentView().getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i2 = point.y;
        AppMethodBeat.o(230580);
        return i2;
    }

    static /* synthetic */ void m(k kVar) {
        AppMethodBeat.i(230581);
        if (kVar.osQ.size() > 0) {
            for (a aVar : (a[]) kVar.osQ.keySet().toArray(new a[kVar.osQ.size()])) {
                aVar.cbs();
            }
        }
        AppMethodBeat.o(230581);
    }
}
