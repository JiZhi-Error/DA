package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.support.v4.view.u;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.p;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.g;
import java.lang.ref.WeakReference;
import java.util.Locale;
import junit.framework.Assert;

public abstract class i implements aa<y> {
    private final c.a JtS = new p.a() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass13 */

        @Override // com.tencent.mm.ui.tools.b.c.a, com.tencent.mm.plugin.appbrand.widget.input.p.a
        public final void dv(String str) {
            AppMethodBeat.i(168763);
            if (i.this.Juh != null) {
                try {
                    i.this.Juo.a(i.this.Juh.getEditableText(), false);
                    AppMethodBeat.o(168763);
                    return;
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(168763);
        }
    };
    public volatile c JtW;
    private volatile a JtY;
    public volatile b JtZ;
    final View.OnFocusChangeListener Jua = new View.OnFocusChangeListener() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass12 */

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(136369);
            if (z) {
                o.b(i.this.Jug.get(), i.this);
            }
            i.a(i.this, z);
            if (!(!(z && (!i.this.Juf.oxG || y.cI(i.this.Juh))) || i.this.Juh == null || i.this.Jui == null)) {
                i.this.Juh.requestFocus();
                i.this.Jui.a(i.this.Juu);
                i.this.Jui.show();
            }
            AppMethodBeat.o(136369);
        }
    };
    private int Jub = -1;
    private int Jud = -1;
    d Jue = null;
    public e Juf;
    protected WeakReference<ac> Jug;
    public y Juh;
    w Jui;
    private v Juj;
    long Juk;
    private final Runnable Jul = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass14 */

        public final void run() {
            AppMethodBeat.i(136371);
            i.this.wp(false);
            AppMethodBeat.o(136371);
        }
    };
    int Jum;
    int Jun;
    public final com.tencent.mm.plugin.appbrand.widget.input.c.a Juo = new com.tencent.mm.plugin.appbrand.widget.input.c.a();
    boolean Jup = false;
    final Runnable Juq = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass15 */

        public final void run() {
            AppMethodBeat.i(136372);
            i.this.Jup = false;
            AppMethodBeat.o(136372);
        }
    };
    private final w.e Jur = new w.e() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.e
        public final boolean afZ(String str) {
            AppMethodBeat.i(136364);
            if (i.this.Juh != null) {
                if ("[DELETE_EMOTION]".equalsIgnoreCase(str)) {
                    y yVar = i.this.Juh;
                    if (yVar.otU == null) {
                        yVar.dispatchKeyEvent(new KeyEvent(0, 67));
                        yVar.dispatchKeyEvent(new KeyEvent(1, 67));
                    } else if (!Util.isNullOrNil(yVar.getEditableText())) {
                        yVar.otU.deleteSurroundingText(yVar.getEditableText().length(), yVar.getEditableText().length() - 1);
                    }
                } else {
                    y yVar2 = i.this.Juh;
                    f.cbc();
                    if (yVar2.getEditableText() == null) {
                        yVar2.setText(str, TextView.BufferType.EDITABLE);
                    } else {
                        yVar2.getEditableText().append((CharSequence) str);
                    }
                    yVar2.setSelection(yVar2.getEditableText().length());
                }
            }
            AppMethodBeat.o(136364);
            return true;
        }
    };
    private final w.c Jus = new w.c() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.c
        public final void cm(boolean z) {
            AppMethodBeat.i(136365);
            if (z) {
                i.this.Jue = d.CONFIRM_BAR_CLICKED;
            }
            i.f(i.this);
            i.this.Jue = null;
            AppMethodBeat.o(136365);
        }
    };
    private final w.f Jut = new w.f() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass8 */

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.f
        public final void hJ(int i2) {
            AppMethodBeat.i(136366);
            Log.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", Integer.valueOf(i2));
            if (i2 != 2) {
                if (i2 == 0 && i.this.Juh != null) {
                    i.this.Juh.requestFocus();
                }
                i.this.dgU();
                if (!(i.this.Jug == null || i.this.Jug.get() == null)) {
                    o.a(i.this.Jug.get(), i.this.Juh);
                    AppMethodBeat.o(136366);
                    return;
                }
            } else {
                i.this.Jue = d.PANEL_HIDDEN;
                i.f(i.this);
                i.this.Jue = null;
            }
            AppMethodBeat.o(136366);
        }
    };
    final w.d Juu = new w.d() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass9 */

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.d
        public final void ig(int i2) {
            AppMethodBeat.i(230573);
            if (Util.ticksToNow(i.this.Juk) > 50) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(230572);
                        if (i.this.Jug == null) {
                            Log.e("MicroMsg.AppBrandInputInvokeHandler", "postDelayed scroll up found page is null");
                            AppMethodBeat.o(230572);
                            return;
                        }
                        k.a(i.this.Jug).c(i.this.osn, false, false);
                        i.this.Juk = Util.currentTicks();
                        AppMethodBeat.o(230572);
                    }
                }, 50);
            }
            AppMethodBeat.o(230573);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.d
        public final EditText getEditText() {
            return i.this.Juh;
        }
    };
    final MMHandler mQp = new MMHandler(Looper.getMainLooper());
    public int osn;

    public interface a {
    }

    public interface b {
        void a(aa aaVar, int i2);
    }

    public interface c {
        void ed(int i2, int i3);
    }

    public abstract void ZN(String str);

    public abstract void a(String str, int i2, boolean z, boolean z2);

    public abstract void bGC();

    public abstract void bGD();

    static /* synthetic */ void a(i iVar, boolean z) {
        if (iVar.Jui == null) {
            iVar.Jui = iVar.dgT();
        }
        if (z) {
            iVar.dba();
            if (iVar.Juf.oya.booleanValue()) {
                MMHandlerThread.postToMainThreadDelayed(iVar.Jul, 100);
            }
        } else if (iVar.Juh != null) {
            if (!iVar.Juf.oxG) {
                if (iVar.Jue == null) {
                    iVar.CC(false);
                }
                iVar.Juh.setFocusable(false);
                iVar.Juh.setFocusableInTouchMode(false);
                iVar.Jui.b(iVar.Juh);
            } else {
                iVar.CC(false);
                iVar.dbb();
            }
        }
        if (iVar.JtY != null) {
            a aVar = iVar.JtY;
        }
    }

    static /* synthetic */ void f(i iVar) {
        boolean z = iVar.Jue == d.CONFIRM_KEYBOARD_CLICKED && aj.i(iVar.Juf.oyg);
        if (!z) {
            if (iVar.dgT() != null) {
                iVar.Jui.b(iVar.Juu);
                iVar.Jui.hide();
            } else if (iVar.Jug != null) {
                ac acVar = iVar.Jug.get();
                if (acVar != null) {
                    ad bRf = acVar.bRf();
                    if (bRf != null) {
                        bRf.hideVKB();
                    }
                }
            }
            k.a(iVar.Jug).Ad(iVar.osn);
        }
        if (iVar.Juh != null) {
            if (iVar.Juh.hasFocus()) {
                iVar.CC(z);
            }
            if (!z) {
                iVar.Juh.b(iVar.Jua);
                if (iVar.Jui != null && iVar.Jui.b(iVar.Juh)) {
                    iVar.Jui.b(iVar.Juu);
                    iVar.Jui.hide();
                }
                iVar.Juh.setFocusable(false);
                iVar.Juh.setFocusableInTouchMode(false);
                if (iVar.Juf.oxG) {
                    iVar.dbb();
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final boolean A(ac acVar) {
        return (acVar == null || this.Jug == null || acVar != this.Jug.get()) ? false : true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final boolean cba() {
        boolean z;
        boolean z2;
        if (this.Juh == null || (!this.Juh.isFocused() && (dgT() == null || dgT().getAttachedEditText() != this.Juh))) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (this.Jug == null || this.Jug.get() == null) {
                z2 = false;
            } else {
                Context context = this.Jug.get().getContext();
                z2 = context instanceof Activity ? ((Activity) context).getCurrentFocus() != null : false;
            }
            if (z2) {
                Log.d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
                return true;
            }
        }
        w dgT = dgT();
        if (dgT != null) {
            dgT.setVisibility(8);
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final void a(String str, Integer num) {
        if (this.Juh != null) {
            this.Juh.G(str);
            Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
            eK(valueOf.intValue(), valueOf.intValue());
            cEK();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final boolean caU() {
        boolean z;
        if (this.Juh == null || this.Jug == null || this.Jug.get() == null) {
            z = false;
        } else {
            this.Juh.destroy();
            g gVar = (g) this.Jug.get().bRe();
            if (gVar == null) {
                z = false;
            } else {
                if (this.Juh.hasFocus()) {
                    if (this.Juj != null) {
                        this.Juj.setVisibility(8);
                    }
                    dgT();
                    if (this.Jui != null) {
                        this.Jui.setVisibility(8);
                    }
                }
                gVar.cV(this.Juh);
                z = true;
            }
        }
        if (!z) {
            return false;
        }
        onDestroy();
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final <P extends View & ac> P getInputPanel() {
        return this.Jui;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final boolean caY() {
        return this.Juf != null && aj.i(this.Juf.oyh);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final int caZ() {
        if (this.Juf != null && this.Juf.oye != null) {
            return this.Juf.oye.intValue();
        }
        if (this.Juh == null || !this.Juh.cbx()) {
            return 0;
        }
        return 5;
    }

    private void onDestroy() {
        this.Juh = null;
        f.bs(this);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final int getInputId() {
        return this.osn;
    }

    /* access modifiers changed from: package-private */
    public enum d {
        PANEL_HIDDEN,
        CONFIRM_KEYBOARD_CLICKED,
        CONFIRM_BAR_CLICKED;

        public static d valueOf(String str) {
            AppMethodBeat.i(136378);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(136378);
            return dVar;
        }

        static {
            AppMethodBeat.i(136379);
            AppMethodBeat.o(136379);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final void zZ(int i2) {
        b bVar = this.JtZ;
        if (bVar != null) {
            bVar.a(this, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cbo() {
        if (this.Juh != null && aj.i(this.Juf.oyc) && aj.i(this.Juf.oya)) {
            ((q) this.Juh).setAutoHeight(true);
            int lineHeight = this.Juh.getLineHeight();
            int cbP = this.Juh.cbP();
            int intValue = (this.Juf.oxO == null || this.Juf.oxO.intValue() <= 0) ? lineHeight : this.Juf.oxO.intValue();
            int max = (this.Juf.oxP == null || this.Juf.oxP.intValue() <= 0) ? Integer.MAX_VALUE : Math.max(this.Juf.oxP.intValue(), lineHeight);
            this.Juh.setMinHeight(intValue);
            this.Juh.setMaxHeight(max);
            this.Juf.oxL = Integer.valueOf(Math.max(intValue, Math.min(cbP, max)));
            b(this.Juh, this.Juf);
        }
    }

    public final void ccw() {
        b.a(this.Juh, this.Juf);
        if (this.Juf.oxT == null) {
            this.Juf.oxT = 140;
        } else if (this.Juf.oxT.intValue() <= 0) {
            this.Juf.oxT = Integer.MAX_VALUE;
        }
        p.a(this.Juh).aoq(this.Juf.oxT.intValue()).CN(false).a(f.a.MODE_CHINESE_AS_1).a(this.JtS);
        this.Juh.setPasswordMode(this.Juf.cKr);
        if (aj.i(this.Juf.oxY)) {
            this.Juh.setEnabled(false);
            this.Juh.setFocusable(false);
            this.Juh.setFocusableInTouchMode(false);
            this.Juh.setClickable(false);
        } else {
            this.Juh.setEnabled(true);
            this.Juh.setClickable(true);
        }
        if (this.Juh instanceof q) {
            if (this.Juf.oyi != null) {
                ((q) this.Juh).setLineSpace((float) this.Juf.oyi.intValue());
            }
            if (this.Juf.oyj != null) {
                ((q) this.Juh).setLineHeight((float) this.Juf.oyj.intValue());
            }
        }
    }

    private void eK(int i2, int i3) {
        b.a(this.Juh, i2, i3);
        wp(false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void cEK() {
        if (this.Juh != null) {
            if (this.Juh.getLineCount() != this.Jub || this.Juh.cbP() != this.Jud) {
                boolean z = this.Jub == -1;
                this.Jub = this.Juh.getLineCount();
                this.Jud = this.Juh.cbP();
                if (this.JtW != null) {
                    this.JtW.ed(this.Jub, this.Jud);
                }
                if (this.Juf.oya.booleanValue() && !z) {
                    this.Jum = aj.j(this.Juf.oxM) + aj.j(this.Juf.oxL);
                    cbo();
                    this.Jun = aj.j(this.Juf.oxM) + aj.j(this.Juf.oxL);
                    wp(true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void wp(boolean z) {
        int i2;
        if (this.Juf.oya.booleanValue() && this.Jui != null && this.Jui.isShown() && this.Juh != null && this.Juh == this.Jui.getAttachedEditText()) {
            if (z) {
                if (this.Jug == null || this.Jug.get() == null || this.Jug.get().bRe() == null) {
                    i2 = 0;
                } else {
                    i2 = this.Jug.get().bRe().getScrollY() + this.Jug.get().bRe().getMeasuredHeight();
                }
                if ((this.Jun > this.Jum && this.Jun - this.Juh.getLineHeight() <= i2) || ((this.Jun <= this.Jum && this.Jun + this.Juh.getLineHeight() <= i2) || this.Juh.cbP() >= i2)) {
                    k.a(this.Jug).Ac(this.osn);
                    return;
                }
                return;
            }
            k.a(this.Jug).Ac(this.osn);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dba() {
        if (this.Juf.oya.booleanValue()) {
            dgT();
        }
        if (this.Jui != null && this.Juh != null) {
            this.Jui.oum = this.Juh;
            this.Jui.setComponentView(this.Juf.oyq.booleanValue());
            this.Jui.cbN();
            this.Jui.setShowDoneButton(aj.i(this.Juf.oyb));
            deF();
            if (y.cI(this.Juh) && this.Juh.hasFocus()) {
                this.Jui.a(this.Juu);
                this.Jui.show();
            }
        }
    }

    private void dbb() {
        this.Jui.b(this.Juh);
        a(this.Juh);
        this.Juh.destroy();
        onDestroy();
    }

    public final void ht(int i2, int i3) {
        y tVar;
        this.Jug = this.Juf.orG;
        ac acVar = this.Jug == null ? null : this.Jug.get();
        if (acVar == null || acVar.nmX == null) {
            Log.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
            bGD();
            return;
        }
        if (aj.i(this.Juf.oya)) {
            tVar = new q(acVar.getContext());
        } else {
            tVar = new t(acVar.getContext());
        }
        this.Juh = tVar;
        this.osn = this.Juf.orE;
        this.Juh.setInputId(this.osn);
        o.b(acVar, this);
        ccw();
        this.Juh.setText(Util.nullAsNil(this.Juf.oxJ));
        if (aj.i(this.Juf.oyc)) {
            cEK();
        }
        this.Juh.addTextChangedListener(new g() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass16 */

            @Override // com.tencent.mm.ui.widget.g
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(136373);
                if (i.this.Jug == null || i.this.Jug.get() == null || i.this.Juh == null) {
                    AppMethodBeat.o(136373);
                    return;
                }
                i.this.cEK();
                if (aj.I(editable)) {
                    Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", editable);
                    AppMethodBeat.o(136373);
                    return;
                }
                Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", editable);
                i.this.Juo.a(i.this.Juh.getEditableText(), i.this.Jup);
                AppMethodBeat.o(136373);
            }
        });
        this.Juh.setOnComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass17 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.c.b
            public final void ML() {
                AppMethodBeat.i(136374);
                if (i.this.Juh == null) {
                    AppMethodBeat.o(136374);
                    return;
                }
                Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", i.this.Juh.getEditableText());
                i.this.Juo.a(i.this.Juh.getEditableText(), false);
                AppMethodBeat.o(136374);
            }
        });
        this.Juh.setOnKeyUpPostImeListener(new ab.b() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass18 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.ab.b
            public final boolean Aa(int i2) {
                AppMethodBeat.i(136375);
                if (i2 != 67) {
                    AppMethodBeat.o(136375);
                    return false;
                } else if (aj.I(i.this.Juh.getText())) {
                    AppMethodBeat.o(136375);
                    return false;
                } else {
                    i.this.ZN(i.this.Juh.getText().toString());
                    AppMethodBeat.o(136375);
                    return true;
                }
            }
        });
        if (!a(this.Juh, this.Juf)) {
            Log.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
            bGD();
            return;
        }
        if (this.Juf.oxI != null && !Util.isNullOrNil(this.Juf.oxI.oxt)) {
            com.tencent.mm.plugin.appbrand.widget.input.autofill.d.a(acVar, this.Juh, this.Juf.oxI);
        }
        if (!aj.i(this.Juf.oya)) {
            b.a(this.Juh, i2, i3);
        }
        if (aj.i(this.Juf.oya)) {
            this.Juh.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass19 */

                public final void run() {
                    AppMethodBeat.i(136376);
                    i.this.cEK();
                    AppMethodBeat.o(136376);
                }
            });
        }
        if ("text".equalsIgnoreCase(this.Juf.cKo) || "emoji".equalsIgnoreCase(this.Juf.cKo)) {
            dgS();
        } else {
            Assert.assertTrue(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", this.Juf.cKo), true);
            dgS();
        }
        this.Juh.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(136360);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (i.this.Juh == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(136360);
                } else if (i.this.Juh.hasFocus()) {
                    i.this.dba();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(136360);
                } else {
                    if (i.this.Juh == view) {
                        i.this.deE();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(136360);
                }
            }
        });
        bGC();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void deE() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        ac acVar = this.Jug == null ? null : this.Jug.get();
        if (this.Jui == null) {
            dgT();
        }
        Object[] objArr = new Object[3];
        if (this.Juh == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        if (acVar == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[1] = Boolean.valueOf(z2);
        if (this.Jui != null) {
            z3 = false;
        }
        objArr[2] = Boolean.valueOf(z3);
        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", objArr);
        if (acVar != null && this.Juh != null && this.Jui != null) {
            o.a(acVar, this.Juh);
            final PBool pBool = new PBool();
            pBool.value = false;
            final AnonymousClass3 r2 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(136361);
                    Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
                    pBool.value = true;
                    ac acVar = i.this.Jug == null ? null : i.this.Jug.get();
                    if (acVar == null || i.this.Juh == null) {
                        AppMethodBeat.o(136361);
                    } else if (o.F(acVar) != i.this) {
                        AppMethodBeat.o(136361);
                    } else {
                        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
                        h.cbe().d(acVar.nmX);
                        aj.dh(i.this.Juh);
                        if (i.this.Jui != null && i.this.Jui.b((EditText) null)) {
                            i.this.Jui.b(i.this.Juu);
                            i.this.Jui.hide();
                        }
                        i.this.Juh.a(i.this.Jua);
                        i.this.Juh.setFocusable(true);
                        i.this.Juh.setFocusableInTouchMode(true);
                        i.this.Jui.oum = i.this.Juh;
                        i.this.Juh.requestFocus();
                        aj.dh(i.this.Juh);
                        if (i.this.Jui != null) {
                            i.this.Jui.a(i.this.Juu);
                            i.this.Jui.show();
                        }
                        AppMethodBeat.o(136361);
                    }
                }
            };
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(acVar.getContext());
            if (!(castActivityOrNull == null || castActivityOrNull.getCurrentFocus() == null)) {
                View currentFocus = castActivityOrNull.getCurrentFocus();
                boolean isActive = aj.dg(currentFocus).isActive(currentFocus);
                boolean i2 = aj.i(acVar.nmX.getWrapperView(), currentFocus);
                if (isActive && i2) {
                    Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
                    this.Jui.setOnVisibilityChangedListener(new w.f() {
                        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass4 */

                        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.f
                        public final void hJ(int i2) {
                            AppMethodBeat.i(136362);
                            if (pBool.value || i2 != 2) {
                                AppMethodBeat.o(136362);
                                return;
                            }
                            r2.run();
                            AppMethodBeat.o(136362);
                        }
                    });
                    h.RTc.n(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(136363);
                            if (pBool.value) {
                                AppMethodBeat.o(136363);
                                return;
                            }
                            r2.run();
                            AppMethodBeat.o(136363);
                        }
                    }, 100);
                    return;
                }
            }
            r2.run();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(y yVar, e eVar) {
        if (yVar == null || this.Jug == null || this.Jug.get() == null) {
            return false;
        }
        g gVar = (g) this.Jug.get().bRe();
        if (gVar == null || !gVar.a(this.Jug.get().nmX, yVar, eVar.oxK.intValue(), eVar.oxL.intValue(), eVar.oxN.intValue(), eVar.oxM.intValue())) {
            return false;
        }
        return true;
    }

    public boolean b(y yVar, e eVar) {
        if (yVar == null || this.Jug == null || this.Jug.get() == null) {
            return false;
        }
        g gVar = (g) this.Jug.get().bRe();
        if (gVar == null || !gVar.c(this.Jug.get().nmX, yVar, eVar.oxK.intValue(), eVar.oxL.intValue(), eVar.oxN.intValue(), eVar.oxM.intValue())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(y yVar) {
        g gVar;
        if (yVar != null) {
            yVar.b(this.Jua);
            ac acVar = this.Jug == null ? null : this.Jug.get();
            if (acVar != null && (gVar = (g) acVar.bRe()) != null) {
                gVar.cV(yVar);
            }
        }
    }

    private void deF() {
        if (this.Jui != null) {
            this.Jui.setOnSmileyChosenListener(this.Jur);
            this.Jui.setOnDoneListener(this.Jus);
            this.Jui.setOnVisibilityChangedListener(this.Jut);
        }
    }

    private void dgS() {
        final int i2;
        ac acVar = this.Jug.get();
        if (u.aD(acVar.getContentView())) {
            this.Jui = w.b(acVar.getContentView(), acVar.bRo());
            this.Jui.setComponentView(this.Juf.oyq.booleanValue());
            this.Jui.cbN();
            if (this.Juf.oxG) {
                deF();
                dgU();
            }
            this.Juh.a(this.Jua);
            this.Juh.setOnKeyListener(new View.OnKeyListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass10 */

                public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    boolean z;
                    AppMethodBeat.i(230574);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.bm(keyEvent);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                    i iVar = i.this;
                    if (67 == i2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    iVar.Jup = z;
                    if (i.this.Jup) {
                        i.this.mQp.removeCallbacks(i.this.Juq);
                        i.this.mQp.postDelayed(i.this.Juq, 1000);
                    } else {
                        i.this.Juq.run();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(230574);
                    return false;
                }
            });
            if (this.Juf.oxG) {
                o.a(this.Jug.get(), this.Juh);
            }
            this.Jui.setCanSmileyInput(!this.Juf.cKr && "emoji".equals(this.Juf.cKo));
            if (this.Juf.oyf == null) {
                i2 = com.tencent.mm.plugin.appbrand.widget.input.d.b.jk(this.Juf.oya.booleanValue()).oxA;
            } else {
                if (!this.Juf.oya.booleanValue() && com.tencent.mm.plugin.appbrand.widget.input.d.b.RETURN == this.Juf.oyf) {
                    this.Juf.oyf = com.tencent.mm.plugin.appbrand.widget.input.d.b.jk(false);
                }
                i2 = this.Juf.oyf.oxA;
            }
            Log.d("MicroMsg.AppBrandInputInvokeHandler", "initSmileyPanelAndShow, myImeOption: ".concat(String.valueOf(i2)));
            AnonymousClass11 r2 = null;
            if (!this.Juf.oya.booleanValue() || i2 != 0) {
                r2 = new TextView.OnEditorActionListener() {
                    /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass11 */

                    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                        AppMethodBeat.i(230575);
                        if (i2 == i2) {
                            i.this.Jue = d.CONFIRM_KEYBOARD_CLICKED;
                            i.f(i.this);
                            i.this.Jue = null;
                            AppMethodBeat.o(230575);
                            return true;
                        }
                        AppMethodBeat.o(230575);
                        return false;
                    }
                };
            }
            this.Juh.setImeOptions(i2);
            this.Juh.setOnEditorActionListener(r2);
            this.Jui.setShowDoneButton(this.Juf.oyb.booleanValue());
            this.Jui.oum = this.Juh;
            if (this.Juf.oxG) {
                deE();
            } else {
                this.Juh.setFocusable(false);
                this.Juh.setFocusableInTouchMode(false);
                this.Jui.b(this.Juu);
                this.Jui.hide();
            }
            if (this.Juf.oxG) {
                k.a(this.Jug).Ac(this.osn);
            }
        }
    }

    private void CC(boolean z) {
        if (this.Juh != null) {
            a(this.Juh.getText().toString(), this.Juh.getSelectionEnd(), d.CONFIRM_KEYBOARD_CLICKED == this.Jue || d.CONFIRM_BAR_CLICKED == this.Jue, z);
        }
    }

    private w dgT() {
        ac acVar;
        if (this.Jui != null) {
            return this.Jui;
        }
        if (this.Jug == null || (acVar = this.Jug.get()) == null) {
            return null;
        }
        w dc = w.dc(acVar.getContentView());
        this.Jui = dc;
        return dc;
    }

    private v cbb() {
        ac acVar;
        if (this.Juj != null) {
            return this.Juj;
        }
        if (this.Jug == null || (acVar = this.Jug.get()) == null) {
            return null;
        }
        if (acVar.getContentView() == null || !u.aD(acVar.getContentView())) {
            return null;
        }
        v da = v.da(acVar.getContentView());
        this.Juj = da;
        return da;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dgU() {
        if (cbb() != null) {
            this.Juj.setVisibility(8);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final boolean q(int i2, int i3, boolean z) {
        if (!(this.Juh == null || this.Jug == null || this.Jug.get() == null)) {
            this.Juh.performClick();
        }
        eK(i2, i3);
        return true;
    }

    /* Return type fixed from 'android.widget.EditText' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final /* bridge */ /* synthetic */ y caV() {
        return this.Juh;
    }
}
