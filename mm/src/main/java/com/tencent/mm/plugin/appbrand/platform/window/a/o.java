package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.b;
import android.support.v4.view.u;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.a.k;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ap;
import com.tencent.smtt.sdk.WebView;

public class o implements c {
    public Context mContext = new MutableContextWrapper(MMApplicationContext.getContext());
    private k nFv;
    protected c nFw;
    private WindowInsets nFx;
    private final SparseArray<Rect> nFy = new SparseArray<>(4);

    public o() {
        AppMethodBeat.i(176759);
        AppMethodBeat.o(176759);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(c cVar) {
        AppMethodBeat.i(219588);
        c cVar2 = cVar;
        if (cVar2 != null) {
            if (this == cVar2) {
                AppMethodBeat.o(219588);
                return 0;
            } else if (cVar2 instanceof o) {
                if (AndroidContextUtil.castActivityOrNull(this.mContext) == AndroidContextUtil.castActivityOrNull(((o) cVar2).mContext)) {
                    AppMethodBeat.o(219588);
                    return 0;
                }
                AppMethodBeat.o(219588);
                return -1;
            }
        }
        AppMethodBeat.o(219588);
        return -1;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public /* synthetic */ e getOrientationHandler() {
        AppMethodBeat.i(176772);
        c bTY = bTY();
        AppMethodBeat.o(176772);
        return bTY;
    }

    public final void aG(Context context) {
        k mVar;
        AppMethodBeat.i(176760);
        if (this.mContext == context) {
            AppMethodBeat.o(176760);
            return;
        }
        if (bsa()) {
            Log.i("Luggage.WXA.WindowAndroidActivityImpl", "resetContext, this:%s, new:%s, old:%s, stack:%s", getClass().getName(), context, this.mContext, android.util.Log.getStackTraceString(new Throwable()));
        }
        this.mContext = context;
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
        if (castActivityOrNull == null) {
            k.a.AnonymousClass1 r0 = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: CONSTRUCTOR  (r0v7 'r0' com.tencent.mm.plugin.appbrand.platform.window.a.k$a$1) =  call: com.tencent.mm.plugin.appbrand.platform.window.a.k.a.1.<init>():void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.platform.window.a.o.aG(android.content.Context):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.platform.window.a.k, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 23 more
                */
            /*
            // Method dump skipped, instructions count: 126
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.platform.window.a.o.aG(android.content.Context):void");
        }

        /* access modifiers changed from: protected */
        public boolean bsa() {
            return false;
        }

        public final WindowManager bTX() {
            AppMethodBeat.i(177597);
            WindowManager windowManager = (WindowManager) b.a(this.mContext, WindowManager.class);
            AppMethodBeat.o(177597);
            return windowManager;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c
        public final Context getContext() {
            return this.mContext;
        }

        public final Activity getActivity() {
            AppMethodBeat.i(259549);
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
            AppMethodBeat.o(259549);
            return castActivityOrNull;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c
        public boolean bsc() {
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
        public DisplayMetrics getVDisplayMetrics() {
            AppMethodBeat.i(178635);
            Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            AppMethodBeat.o(178635);
            return displayMetrics;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c
        public final boolean bsj() {
            AppMethodBeat.i(176763);
            boolean et = ai.et(getContext());
            AppMethodBeat.o(176763);
            return et;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c
        public final boolean isInMultiWindowMode() {
            AppMethodBeat.i(219584);
            if (Build.VERSION.SDK_INT >= 24) {
                boolean isInMultiWindowMode = AndroidContextUtil.castActivityOrNull(this.mContext).isInMultiWindowMode();
                AppMethodBeat.o(219584);
                return isInMultiWindowMode;
            }
            AppMethodBeat.o(219584);
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
        public final d a(d.b bVar) {
            AppMethodBeat.i(219585);
            b bVar2 = new b(this, bVar);
            AppMethodBeat.o(219585);
            return bVar2;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.g
        public float getScale() {
            return 1.0f;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
        public void setSoftOrientation(String str) {
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
        public final boolean OD() {
            AppMethodBeat.i(178636);
            AppMethodBeat.o(178636);
            return false;
        }

        public final c bTY() {
            AppMethodBeat.i(176765);
            if (this.nFw == null || ((this.nFw instanceof d) && ((d) this.nFw).activity != AndroidContextUtil.castActivityOrNull(this.mContext))) {
                if (this.nFw != null) {
                    this.nFw.release();
                }
                this.nFw = new d(this);
            }
            c cVar = this.nFw;
            AppMethodBeat.o(176765);
            return cVar;
        }

        public final void dispatchConfigurationChanged(Configuration configuration) {
            AppMethodBeat.i(176766);
            if (n.a(getContext().getResources().getConfiguration(), configuration)) {
                synchronized (this.nFy) {
                    try {
                        this.nFy.clear();
                    } catch (Throwable th) {
                        AppMethodBeat.o(176766);
                        throw th;
                    }
                }
            }
            getContext().getResources().getConfiguration().updateFrom(configuration);
            bTY().onConfigurationChanged(configuration);
            this.nFv.c(configuration);
            onConfigurationChanged(configuration);
            AppMethodBeat.o(176766);
        }

        /* access modifiers changed from: protected */
        public void onConfigurationChanged(Configuration configuration) {
        }

        public final void b(WindowManager.LayoutParams layoutParams) {
            AppMethodBeat.i(176767);
            a(layoutParams);
            AppMethodBeat.o(176767);
        }

        /* access modifiers changed from: protected */
        public void a(WindowManager.LayoutParams layoutParams) {
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.g
        public c.C0789c getStatusBar() {
            int aR;
            AppMethodBeat.i(176768);
            if (Build.VERSION.SDK_INT >= 21) {
                WindowInsets bTZ = bTZ();
                if (bTZ != null) {
                    aR = bTZ.getStableInsetTop();
                } else {
                    aR = j.cDv.aR(getContext());
                }
                c.C0789c cVar = new c.C0789c();
                cVar.height = aR;
                if (AndroidContextUtil.castActivityOrNull(this.mContext) != null) {
                    cVar.visibility = y.eq(AndroidContextUtil.castActivityOrNull(this.mContext)) ? 8 : 0;
                }
                AppMethodBeat.o(176768);
                return cVar;
            }
            AppMethodBeat.o(176768);
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c
        public void setWindowDescription(c.a aVar) {
            AppMethodBeat.i(176771);
            if (Build.VERSION.SDK_INT < 21) {
                AppMethodBeat.o(176771);
            } else if (AndroidContextUtil.castActivityOrNull(this.mContext) == null || aVar == null) {
                AppMethodBeat.o(176771);
            } else {
                try {
                    AndroidContextUtil.castActivityOrNull(this.mContext).setTaskDescription(n.a(aVar));
                    AppMethodBeat.o(176771);
                } catch (Exception e2) {
                    Log.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try1 e=%s", e2);
                    try {
                        AndroidContextUtil.castActivityOrNull(this.mContext).setTaskDescription(n.a(new c.a(aVar.label, aVar.nEk, WebView.NIGHT_MODE_COLOR)));
                        AppMethodBeat.o(176771);
                    } catch (Exception e3) {
                        Log.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try2 e=%s", e3);
                        AppMethodBeat.o(176771);
                    }
                }
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c
        public void a(int i2, AppBrandRuntime appBrandRuntime) {
            boolean z;
            AppMethodBeat.i(219587);
            if (i2 == 0 || (i2 >> 24) != 0) {
                z = true;
            } else {
                z = false;
            }
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
            if (castActivityOrNull == null) {
                AppMethodBeat.o(219587);
                return;
            }
            castActivityOrNull.getWindow().setBackgroundDrawable(z ? new ColorDrawable(0) : new ColorDrawable(i2));
            AppMethodBeat.o(219587);
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.g
        public final boolean OG() {
            return false;
        }

        private WindowInsets bTZ() {
            AppMethodBeat.i(178639);
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
            if (castActivityOrNull != null) {
                WindowInsets bo = ap.bo(castActivityOrNull);
                this.nFx = bo;
                AppMethodBeat.o(178639);
                return bo;
            } else if (this.nFx != null) {
                WindowInsets windowInsets = this.nFx;
                AppMethodBeat.o(178639);
                return windowInsets;
            } else {
                AppMethodBeat.o(178639);
                return null;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c
        public Rect getSafeAreaInsets() {
            int i2;
            int i3;
            WindowInsets za;
            Rect rect = null;
            AppMethodBeat.i(176769);
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
            if (castActivityOrNull == null) {
                Log.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets with NULL activity");
                AppMethodBeat.o(176769);
            } else if (castActivityOrNull.getWindow() == null) {
                Log.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets will NULL window");
                AppMethodBeat.o(176769);
            } else {
                int rotation = castActivityOrNull.getWindowManager().getDefaultDisplay().getRotation();
                synchronized (this.nFy) {
                    try {
                        rect = this.nFy.get(rotation);
                        if (rect == null) {
                            if (u.az(castActivityOrNull.getWindow().getDecorView())) {
                                View decorView = castActivityOrNull.getWindow().getDecorView();
                                i2 = decorView.getWidth();
                                i3 = decorView.getHeight();
                            } else {
                                i2 = getVDisplayMetrics().widthPixels;
                                i3 = getVDisplayMetrics().heightPixels;
                            }
                            if (!this.nFv.cz()) {
                                rect = new Rect(0, 0, i2, i3);
                            } else if (this.nFv.cz()) {
                                if (Build.VERSION.SDK_INT >= 28 && (za = ((l) this.nFv).za(rotation)) != null) {
                                    DisplayCutout displayCutout = za.getDisplayCutout();
                                    if (displayCutout != null) {
                                        rect = new Rect(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), i2 - displayCutout.getSafeInsetRight(), i3 - displayCutout.getSafeInsetBottom());
                                    } else {
                                        Log.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaGuarded api28 NULL getDisplayCutout, fallback impl");
                                    }
                                }
                                int bTW = this.nFv.bTW();
                                switch (rotation) {
                                    case 0:
                                        rect = new Rect(0, bTW, i2, i3);
                                        break;
                                    case 1:
                                        rect = new Rect(bTW, 0, i2, i3);
                                        break;
                                    case 2:
                                        rect = new Rect(0, 0, i2, i3 - bTW);
                                        break;
                                    case 3:
                                        rect = new Rect(0, 0, i2 - bTW, i3);
                                        break;
                                    default:
                                        rect = new Rect(0, 0, i2, i3);
                                        break;
                                }
                            } else {
                                rect = new Rect(0, 0, i2, i3);
                            }
                            this.nFy.put(rotation, rect);
                        }
                    } finally {
                        AppMethodBeat.o(176769);
                    }
                }
            }
            return rect;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.c
        public final void a(WxaWindowLayoutParams wxaWindowLayoutParams, AppBrandRuntime appBrandRuntime) {
            AppMethodBeat.i(219586);
            appBrandRuntime.kAt.setLayoutParams(wxaWindowLayoutParams);
            appBrandRuntime.kAt.setScaleX(wxaWindowLayoutParams.scale);
            appBrandRuntime.kAt.setScaleY(wxaWindowLayoutParams.scale);
            AppMethodBeat.o(219586);
        }
    }
