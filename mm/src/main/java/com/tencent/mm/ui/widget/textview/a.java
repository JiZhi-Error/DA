package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private ViewTreeObserver.OnPreDrawListener Bl;
    private int DfR = 0;
    View.OnTouchListener HeV;
    int[] PhV = new int[2];
    private Spannable QGC;
    private ViewTreeObserver.OnScrollChangedListener QPc;
    private int QPi;
    int QPj;
    int QPk;
    boolean QPl = false;
    int QPm;
    int QPp;
    int QPq;
    final Runnable QPv = new Runnable() {
        /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(159850);
            if (a.this.QXV) {
                as.d("SelectableTextHelper", "isReInit, return.", new Object[0]);
                AppMethodBeat.o(159850);
                return;
            }
            as.d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", Boolean.valueOf(a.this.QXY), Boolean.valueOf(a.this.QXZ));
            if (a.this.QXQ == null) {
                if (!a.this.QXW) {
                    a.this.hcV();
                }
                if (!a.this.QXX) {
                    a.this.hcQ();
                }
            } else if (!a.this.QXY) {
                a.this.QXY = true;
                if (a.this.QXZ) {
                    as.d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", Boolean.valueOf(a.this.QXW), Boolean.valueOf(a.this.QXX));
                    if (!a.this.QXW) {
                        a.this.hcV();
                    }
                    if (!a.this.QXX) {
                        a.this.hcQ();
                        a.this.lE(a.this.QXN.avh, a.this.QXN.Pc);
                    }
                    if (a.this.QXQ != null && a.this.QXW && !a.this.QXX) {
                        a.this.QXQ.gL(a.this.QXP);
                    }
                }
                a.this.QXZ = false;
                AppMethodBeat.o(159850);
                return;
            } else if (a.this.QYa) {
                a.this.QYa = false;
                as.d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
                if (a.this.QYc != null) {
                    a.this.QYc.gUe();
                    AppMethodBeat.o(159850);
                    return;
                }
            } else {
                as.d("SelectableTextHelper", "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
                AppMethodBeat.o(159850);
                return;
            }
            AppMethodBeat.o(159850);
        }
    };
    b QXL;
    private b QXM;
    g QXN = new g();
    public d QXO;
    View QXP;
    public f QXQ;
    View.OnTouchListener QXR;
    private com.tencent.mm.ui.widget.b.a QXS;
    private com.tencent.mm.ui.base.c QXT;
    public int QXU;
    boolean QXV = false;
    public boolean QXW = true;
    public boolean QXX = true;
    boolean QXY = true;
    boolean QXZ = false;
    boolean QYa = false;
    final Runnable QYb = new Runnable() {
        /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass5 */

        public final void run() {
            AppMethodBeat.i(159854);
            as.d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
            if (a.this.QYc != null) {
                a.this.QYc.gUe();
            }
            AppMethodBeat.o(159854);
        }
    };
    public e QYc;
    ArrayList<c> QYd;
    private boolean aMn = true;
    private View.OnAttachStateChangeListener afw;
    private ViewTreeObserver.OnGlobalLayoutListener ajG;
    View.OnClickListener hEZ;
    Context mContext;
    int[] wrA = new int[2];

    public interface d {
        void as(CharSequence charSequence);
    }

    public interface e {
        void gUe();
    }

    static /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(198543);
        aVar.lP(0, i2);
        AppMethodBeat.o(198543);
    }

    public a(C2147a aVar) {
        float f2;
        AppMethodBeat.i(159878);
        this.QXP = aVar.QXP;
        this.QXQ = aVar.QXQ;
        this.hEZ = aVar.hEZ;
        this.QXR = aVar.QXR;
        this.QXS = aVar.QYf;
        this.DfR = aVar.QYh;
        this.mContext = this.QXP.getContext();
        this.QPi = aVar.QPi;
        this.QPj = aVar.QPj;
        this.QPm = b.hD(this.QXP);
        if (this.QPk == 0) {
            View view = this.QXP;
            if (view instanceof NeatTextView) {
                f2 = ((NeatTextView) view).getTextSize();
            } else if (view instanceof TextView) {
                f2 = ((TextView) view).getTextSize();
            } else {
                f2 = 0.0f;
            }
            this.QPk = (int) f2;
        } else {
            this.QPk = at.fromDPToPix(this.mContext, aVar.QYg);
        }
        this.afw = new View.OnAttachStateChangeListener() {
            /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass6 */

            public final void onViewAttachedToWindow(View view) {
                AppMethodBeat.i(159855);
                as.d("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
                AppMethodBeat.o(159855);
            }

            public final void onViewDetachedFromWindow(View view) {
                AppMethodBeat.i(159856);
                as.d("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
                a.this.destroy();
                AppMethodBeat.o(159856);
            }
        };
        this.Bl = new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass7 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(159857);
                if (a.this.QPl) {
                    a.this.QPl = false;
                    a aVar = a.this;
                    aVar.QXP.removeCallbacks(aVar.QPv);
                    aVar.QXP.postDelayed(aVar.QPv, 100);
                }
                AppMethodBeat.o(159857);
                return true;
            }
        };
        this.QPc = new ViewTreeObserver.OnScrollChangedListener() {
            /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass8 */

            public final void onScrollChanged() {
                AppMethodBeat.i(159858);
                if (a.this.QXQ != null) {
                    a.this.QXP.removeCallbacks(a.this.QYb);
                    a.this.QXP.getLocationInWindow(a.this.PhV);
                    as.d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", Integer.valueOf(a.this.wrA[1]), Integer.valueOf(a.this.PhV[1]));
                    if (a.this.QXY) {
                        if (a.this.QXZ || a.this.QYa) {
                            if (a.this.QYa) {
                                a.this.QYa = false;
                                a.this.QXY = false;
                                if (a.this.wrA[1] != a.this.PhV[1]) {
                                    a.this.QXZ = true;
                                    as.d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
                                } else {
                                    a.this.QXZ = false;
                                    as.d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
                                }
                            }
                        } else if (a.this.wrA[1] != a.this.PhV[1]) {
                            a.this.QXZ = true;
                            a.this.QXY = false;
                            as.d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
                        } else {
                            a.this.QYa = true;
                            as.d("SelectableTextHelper", "need delay judge.", new Object[0]);
                        }
                    }
                    a.this.wrA[1] = a.this.PhV[1];
                }
                if (!a.this.QPl && (!a.this.QXW || !a.this.QXX)) {
                    a.this.QPl = true;
                    a.this.hbz();
                }
                AppMethodBeat.o(159858);
            }
        };
        this.ajG = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass9 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(159859);
                as.d("SelectableTextHelper", "onGlobalLayout", new Object[0]);
                AppMethodBeat.o(159859);
            }
        };
        this.HeV = new View.OnTouchListener() {
            /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass10 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(159860);
                as.d("SelectableTextHelper", "event pointer count: %d.", Integer.valueOf(motionEvent.getPointerCount()));
                if (a.this.QXR != null) {
                    a.this.QXR.onTouch(view, motionEvent);
                }
                a.this.QPp = (int) motionEvent.getX();
                a.this.QPq = (int) motionEvent.getY();
                AppMethodBeat.o(159860);
                return false;
            }
        };
        if (!this.aMn) {
            as.d("SelectableTextHelper", "not destroy, isReInit: %s.", Boolean.valueOf(this.QXV));
            this.QXV = true;
            AppMethodBeat.o(159878);
            return;
        }
        as.d("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
        this.QXV = false;
        this.aMn = false;
        this.QPl = false;
        if (this.QXQ == null) {
            View view2 = this.QXP;
            CharSequence hB = b.hB(this.QXP);
            TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
            if (view2 instanceof NeatTextView) {
                ((NeatTextView) view2).a(hB, bufferType);
            } else if (view2 instanceof TextView) {
                ((TextView) view2).setText(hB, bufferType);
            }
        }
        this.QXL = new b(true);
        if (this.QXQ != null) {
            this.QXL.mPopupWindow.setOutsideTouchable(true);
            b bVar = this.QXL;
            bVar.mPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass11 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(159861);
                    as.d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (motionEvent.getAction() == 0 && (x < 0 || x >= a.this.QXL.getWidth() || y < 0 || y >= a.this.QXL.getHeight())) {
                        as.d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
                        a.this.QXP.postDelayed(a.this.QYb, 100);
                        AppMethodBeat.o(159861);
                        return true;
                    } else if (motionEvent.getAction() == 4) {
                        as.d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
                        a.this.QXP.postDelayed(a.this.QYb, 100);
                        AppMethodBeat.o(159861);
                        return true;
                    } else {
                        AppMethodBeat.o(159861);
                        return false;
                    }
                }
            });
            b bVar2 = this.QXL;
            bVar2.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass12 */

                public final void onDismiss() {
                    AppMethodBeat.i(159862);
                    a.this.QXP.setOnTouchListener(a.this.HeV);
                    AppMethodBeat.o(159862);
                }
            });
        }
        this.QXM = new b(false);
        this.QXP.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                int i2;
                AppMethodBeat.i(159851);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                as.d("SelectableTextHelper", "onLongClick.", new Object[0]);
                a.this.QXV = false;
                if (a.this.QXQ != null) {
                    a.this.QXY = true;
                    a.this.QXZ = false;
                    a.this.QYa = false;
                    CharSequence hB = b.hB(a.this.QXP);
                    if (hB instanceof SpannableString) {
                        a aVar = a.this;
                        SpannableString spannableString = (SpannableString) hB;
                        aVar.QYd = new ArrayList<>();
                        int i3 = 0;
                        while (i3 < spannableString.length()) {
                            int nextSpanTransition = spannableString.nextSpanTransition(i3, spannableString.length(), ImageSpan.class);
                            ImageSpan[] imageSpanArr = (ImageSpan[]) spannableString.getSpans(i3, nextSpanTransition, ImageSpan.class);
                            if (1 == imageSpanArr.length) {
                                c cVar = new c();
                                cVar.start = i3;
                                cVar.end = nextSpanTransition;
                                aVar.QYd.add(cVar);
                            } else {
                                as.e("SelectableTextHelper", "other situation occur! length: %d.", Integer.valueOf(imageSpanArr.length));
                            }
                            as.d("SelectableTextHelper", "spans from %d to %d.", Integer.valueOf(i3), Integer.valueOf(nextSpanTransition));
                            i3 = nextSpanTransition;
                        }
                        as.d("SelectableTextHelper", aVar.QYd.toString(), new Object[0]);
                    }
                    a.this.hbz();
                    if (a.this.QXU <= 0 || a.this.QXU >= b.hB(a.this.QXP).length()) {
                        a.a(a.this, b.hB(a.this.QXP).length());
                        a.this.QXW = true;
                        a.this.QXX = false;
                        a.this.hcQ();
                        a.this.QXQ.ea(view);
                    } else {
                        a.a(a.this, a.this.QXU);
                        a.this.QXW = false;
                        a.this.QXX = false;
                        a.this.hcV();
                        a.this.hcQ();
                    }
                } else {
                    a.this.QXY = false;
                    a aVar2 = a.this;
                    int i4 = a.this.QPp;
                    int i5 = a.this.QPq;
                    View view2 = aVar2.QXP;
                    if (view2 instanceof NeatTextView) {
                        com.tencent.neattextview.textview.layout.a layout = ((NeatTextView) view2).getLayout();
                        if (layout != null) {
                            i2 = layout.mn(i4, i5);
                        }
                        i2 = 0;
                    } else {
                        if (view2 instanceof TextView) {
                            Layout layout2 = ((TextView) view2).getLayout();
                            if (layout2 != null) {
                                i2 = layout2.getOffsetForHorizontal(layout2.getLineForVertical(i5), (float) i4);
                                if (((int) layout2.getPrimaryHorizontal(i2)) > i4) {
                                    i2 = layout2.getOffsetToLeftOf(i2);
                                }
                            } else {
                                i2 = -1;
                            }
                        }
                        i2 = 0;
                    }
                    aVar2.lP(i2, i2 + 1);
                    a.this.hbz();
                    a.this.QXW = false;
                    a.this.QXX = false;
                    a.this.hcV();
                    a.this.hcQ();
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(159851);
                return true;
            }
        });
        this.QXP.setOnTouchListener(this.HeV);
        this.QXP.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(159852);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                as.d("SelectableTextHelper", "onClick", new Object[0]);
                if (a.this.hEZ != null) {
                    a.this.hEZ.onClick(view);
                }
                a.this.QXW = true;
                a.this.QXX = true;
                a.this.hbz();
                a.this.hbA();
                if (a.this.QXQ != null) {
                    a.this.QXQ.dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159852);
            }
        });
        this.QXP.addOnAttachStateChangeListener(this.afw);
        this.QXP.getViewTreeObserver().addOnPreDrawListener(this.Bl);
        this.QXP.getViewTreeObserver().addOnScrollChangedListener(this.QPc);
        this.QXP.getViewTreeObserver().addOnGlobalLayoutListener(this.ajG);
        this.QXP.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.widget.textview.a.AnonymousClass4 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(159853);
                a.this.QXP.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (a.this.QXQ != null) {
                    a.this.QXP.getLocationInWindow(a.this.wrA);
                    as.d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", Integer.valueOf(a.this.wrA[0]), Integer.valueOf(a.this.wrA[1]));
                }
                AppMethodBeat.o(159853);
            }
        });
        AppMethodBeat.o(159878);
    }

    public final void destroy() {
        AppMethodBeat.i(159880);
        this.QXV = false;
        this.aMn = true;
        this.QPl = false;
        this.QXP.removeCallbacks(this.QPv);
        this.QXP.getViewTreeObserver().removeOnScrollChangedListener(this.QPc);
        this.QXP.getViewTreeObserver().removeOnPreDrawListener(this.Bl);
        this.QXP.getViewTreeObserver().removeOnGlobalLayoutListener(this.ajG);
        this.QXP.removeOnAttachStateChangeListener(this.afw);
        this.QXW = true;
        this.QXX = true;
        hbz();
        hbA();
        this.QXL = null;
        this.QXM = null;
        if (this.QXQ != null) {
            this.QXQ.dismiss();
        }
        AppMethodBeat.o(159880);
    }

    public final void hbz() {
        AppMethodBeat.i(159881);
        hcR();
        hcS();
        if (this.QXQ != null) {
            this.QXQ.dismiss();
        }
        AppMethodBeat.o(159881);
    }

    public final void hbA() {
        AppMethodBeat.i(159882);
        this.QXN.QPK = null;
        if (!(this.QGC == null || this.QXT == null)) {
            this.QGC.removeSpan(this.QXT);
            this.QXT = null;
        }
        AppMethodBeat.o(159882);
    }

    /* access modifiers changed from: package-private */
    public final void lP(int i2, int i3) {
        AppMethodBeat.i(159883);
        hbA();
        if (b.hB(this.QXP) instanceof Spannable) {
            this.QGC = (Spannable) b.hB(this.QXP);
        }
        if (this.QGC == null || i2 >= b.hB(this.QXP).length()) {
            this.QXN.avh = 0;
            this.QXN.Pc = 0;
            AppMethodBeat.o(159883);
            return;
        }
        lE(i2, i3);
        AppMethodBeat.o(159883);
    }

    private void a(b bVar) {
        int i2;
        int i3;
        AppMethodBeat.i(159884);
        if (bVar == null) {
            AppMethodBeat.o(159884);
            return;
        }
        int i4 = bVar.QPA ? this.QXN.avh : this.QXN.Pc;
        if (i4 < 0 || i4 > b.hB(this.QXP).length()) {
            AppMethodBeat.o(159884);
            return;
        }
        TextPaint hC = b.hC(this.QXP);
        if (hC != null) {
            i3 = ((int) hC.getFontMetrics().descent) + b.aP(this.QXP, b.aQ(this.QXP, i4));
            i2 = (int) b.aR(this.QXP, i4);
        } else {
            i2 = 0;
            i3 = 0;
        }
        a.this.QXP.getLocationInWindow(bVar.QLE);
        int i5 = bVar.QPA ? bVar.mWidth : 0;
        if (!bVar.QPA) {
            int[] lQ = bVar.lQ(i2, i3);
            i2 = lQ[0];
            i3 = lQ[1];
        }
        try {
            bVar.mPopupWindow.showAtLocation(a.this.QXP, 0, (i2 - i5) + bVar.hbD(), i3 + bVar.hbE());
            AppMethodBeat.o(159884);
        } catch (Exception e2) {
            as.e("SelectableTextHelper", "error! message: %s.", e2.getMessage());
            AppMethodBeat.o(159884);
        }
    }

    private boolean hcP() {
        AppMethodBeat.i(159885);
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            AppMethodBeat.o(159885);
            return false;
        }
        AppMethodBeat.o(159885);
        return true;
    }

    public final void hcQ() {
        AppMethodBeat.i(159886);
        if (!hcP()) {
            a(this.QXL);
            a(this.QXM);
        }
        AppMethodBeat.o(159886);
    }

    public final void hcR() {
        AppMethodBeat.i(159887);
        if (this.QXL != null) {
            this.QXL.mPopupWindow.dismiss();
        }
        if (this.QXM != null) {
            this.QXM.mPopupWindow.dismiss();
        }
        AppMethodBeat.o(159887);
    }

    public final void hcS() {
        AppMethodBeat.i(159888);
        if (this.QXS != null) {
            this.QXS.gNq();
        }
        AppMethodBeat.o(159888);
    }

    public final void hcT() {
        AppMethodBeat.i(159889);
        if (this.QXQ != null) {
            this.QXQ.gL(this.QXP);
        }
        AppMethodBeat.o(159889);
    }

    public final void hcU() {
        AppMethodBeat.i(159890);
        if (this.QXQ != null) {
            this.QXQ.dismiss();
        }
        AppMethodBeat.o(159890);
    }

    public final void hcV() {
        int i2;
        AppMethodBeat.i(159891);
        if (this.QXS != null) {
            int[] iArr = new int[2];
            this.QXP.getLocationInWindow(iArr);
            float aR = b.aR(this.QXP, this.QXN.avh);
            float aR2 = b.aR(this.QXP, this.QXN.Pc);
            if (b.aQ(this.QXP, this.QXN.Pc) > b.aQ(this.QXP, this.QXN.avh) || aR2 <= aR) {
                aR2 = b.aU(this.QXP, b.aQ(this.QXP, this.QXN.avh));
            }
            int i3 = this.DfR + ((int) ((aR2 + aR) / 2.0f));
            int aS = b.aS(this.QXP, b.aQ(this.QXP, this.QXN.avh)) + iArr[1] + this.mContext.getResources().getDimensionPixelSize(R.dimen.a0t);
            as.d("SelectableTextHelper", "dancy test posX:%s, startline:%s, endline:%s, leftpadding:%s", Integer.valueOf(i3), Integer.valueOf(b.aQ(this.QXP, this.QXN.avh)), Integer.valueOf(b.aQ(this.QXP, this.QXN.Pc)), Integer.valueOf(this.DfR));
            if (i3 <= 0) {
                i3 = 16;
            }
            if (aS < 0) {
                aS = 16;
            }
            if (i3 > b.getScreenWidth(this.mContext)) {
                i2 = b.getScreenWidth(this.mContext) - 16;
            } else {
                i2 = i3;
            }
            this.QXS.ez(i2, aS);
        }
        if (this.QXQ != null) {
            this.QXQ.gUa();
        }
        AppMethodBeat.o(159891);
    }

    public final void lE(int i2, int i3) {
        AppMethodBeat.i(159892);
        if (i2 != -1) {
            this.QXN.avh = bU(i2, true);
        }
        if (i3 != -1) {
            this.QXN.Pc = bU(i3, false);
        }
        if (this.QXN.avh < 0 || this.QXN.avh > b.hB(this.QXP).length()) {
            AppMethodBeat.o(159892);
        } else if (this.QXN.Pc < 0 || this.QXN.Pc > b.hB(this.QXP).length()) {
            AppMethodBeat.o(159892);
        } else {
            if (this.QXN.avh > this.QXN.Pc) {
                int i4 = this.QXN.avh;
                this.QXN.avh = this.QXN.Pc;
                this.QXN.Pc = i4;
            }
            if (this.QGC != null) {
                this.QXN.QPK = this.QGC.subSequence(this.QXN.avh, this.QXN.Pc).toString();
                if (this.QXT != null) {
                    this.QXT.setPosition(this.QXN.avh, this.QXN.Pc);
                } else {
                    this.QXT = new com.tencent.mm.ui.base.c(this.QXP, this.mContext.getResources().getColor(this.QPi), this.QXN.avh, this.QXN.Pc);
                }
                this.QGC.setSpan(this.QXT, b.aV(this.QXP, b.aQ(this.QXP, this.QXN.avh)), this.QXN.Pc, 17);
                if (this.QXO != null) {
                    this.QXO.as(this.QXN.QPK);
                }
            }
            AppMethodBeat.o(159892);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$a  reason: collision with other inner class name */
    public static class C2147a {
        public int QPi;
        public int QPj;
        View QXP;
        f QXQ;
        View.OnTouchListener QXR;
        com.tencent.mm.ui.widget.b.a QYf;
        public int QYg;
        public int QYh;
        View.OnClickListener hEZ;

        private C2147a(View view, com.tencent.mm.ui.widget.b.a aVar) {
            this.QPj = R.color.kn;
            this.QPi = R.color.a6q;
            this.QYg = 0;
            this.QYh = 0;
            this.QXP = view;
            this.QYf = aVar;
        }

        public C2147a(View view, com.tencent.mm.ui.widget.b.a aVar, f fVar, View.OnClickListener onClickListener, View.OnTouchListener onTouchListener) {
            this(view, aVar);
            this.QXQ = fVar;
            this.hEZ = onClickListener;
            this.QXR = onTouchListener;
        }

        public final a hcW() {
            AppMethodBeat.i(159863);
            a aVar = new a(this);
            AppMethodBeat.o(159863);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends View {
        private int[] PhV = new int[2];
        int[] QLE = new int[2];
        boolean QPA;
        private int QPB;
        private int QPC;
        private int QPD;
        private int QPE;
        private boolean QYi = false;
        private int mHeight = (this.qRY * 2);
        private int mPadding = 25;
        private Paint mPaint;
        PopupWindow mPopupWindow;
        int mWidth = (this.qRY * 2);
        private Point nDV = new Point();
        private int qRY = (a.this.QPk / 2);
        private Rect rect = new Rect();

        b(boolean z) {
            super(a.this.mContext);
            AppMethodBeat.i(159864);
            this.QPA = z;
            this.mPaint = new Paint(1);
            this.mPaint.setColor(a.this.mContext.getResources().getColor(a.this.QPj));
            this.mPopupWindow = new PopupWindow(this);
            this.mPopupWindow.setClippingEnabled(false);
            this.mPopupWindow.setWidth(this.mWidth + (this.mPadding * 2));
            this.mPopupWindow.setHeight(this.mHeight + (this.mPadding / 2));
            AppMethodBeat.o(159864);
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            int i2;
            int i3;
            AppMethodBeat.i(159865);
            if (a.this.QXQ != null) {
                int i4 = this.QPA ? a.this.QXN.avh : a.this.QXN.Pc;
                TextPaint hC = b.hC(a.this.QXP);
                if (hC != null) {
                    i3 = ((int) hC.getFontMetrics().descent) + b.aP(a.this.QXP, b.aQ(a.this.QXP, i4));
                    i2 = (int) b.aR(a.this.QXP, i4);
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                a.this.QXP.getLocationInWindow(this.QLE);
                if (!this.QPA) {
                    i3 = lQ(i2, i3)[1];
                }
                int hbE = hbE() + i3;
                if (!a.this.QXP.getGlobalVisibleRect(this.rect, this.nDV)) {
                    as.d("SelectableTextHelper", "view invisible.", new Object[0]);
                    AppMethodBeat.o(159865);
                    return;
                } else if (hbE >= this.rect.bottom) {
                    if (this.QPA) {
                        as.d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
                        a.this.hbA();
                        a.this.QXW = true;
                        a.this.QXX = true;
                        a.this.hbz();
                        a.this.QXQ.dismiss();
                    }
                    as.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
                    AppMethodBeat.o(159865);
                    return;
                } else if (hbE <= this.rect.top) {
                    if (!this.QPA) {
                        as.d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
                        a.this.hbA();
                        a.this.QXW = true;
                        a.this.QXX = true;
                        a.this.hbz();
                        a.this.QXQ.dismiss();
                    }
                    as.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
                    AppMethodBeat.o(159865);
                    return;
                }
            }
            canvas.drawCircle((float) (this.qRY + this.mPadding), (float) this.qRY, (float) this.qRY, this.mPaint);
            if (this.QPA) {
                canvas.drawRect((float) (this.qRY + this.mPadding), 0.0f, (float) ((this.qRY * 2) + this.mPadding), (float) this.qRY, this.mPaint);
                AppMethodBeat.o(159865);
                return;
            }
            canvas.drawRect((float) this.mPadding, 0.0f, (float) (this.qRY + this.mPadding), (float) this.qRY, this.mPaint);
            AppMethodBeat.o(159865);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(159866);
            switch (motionEvent.getAction()) {
                case 0:
                    this.QPD = a.this.QXN.avh;
                    this.QPE = a.this.QXN.Pc;
                    this.QPB = (int) motionEvent.getX();
                    this.QPC = (int) motionEvent.getY();
                    this.QYi = false;
                    a.this.QXP.getLocationOnScreen(this.PhV);
                    break;
                case 1:
                case 3:
                    if (a.this.QXQ == null || this.QYi) {
                        if (!a.this.QXW) {
                            a.this.hcV();
                            break;
                        }
                    } else {
                        this.QYi = true;
                        a.this.QXQ.gTY();
                        if (a.this.QXN.Pc - a.this.QXN.avh == b.hB(a.this.QXP).length()) {
                            a.this.QXQ.gL(a.this.QXP);
                            a.this.QXW = true;
                            a.this.hcS();
                        } else {
                            a.this.QXQ.dismiss();
                            a.this.QXW = false;
                            a.this.hcV();
                        }
                        a.this.QXQ.gTZ();
                        break;
                    }
                    break;
                case 2:
                    if (a.this.QXQ != null) {
                        a.this.QXQ.gTY();
                        a.this.QXQ.dismiss();
                    }
                    a.this.hcS();
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    if (a.this.QXQ == null) {
                        update(rawX - this.PhV[0], ((rawY + this.QPC) - this.mHeight) - a.this.QPm);
                    } else {
                        update((rawX - this.PhV[0]) + this.qRY, ((rawY + this.QPC) - this.mHeight) - a.this.QPm);
                    }
                    if (a.this.QXQ != null) {
                        a.this.QXQ.gTZ();
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(159866);
            return true;
        }

        private void hbB() {
            AppMethodBeat.i(159867);
            this.QPA = !this.QPA;
            invalidate();
            AppMethodBeat.o(159867);
        }

        private void update(int i2, int i3) {
            int i4;
            AppMethodBeat.i(159868);
            a.this.QXP.getLocationInWindow(this.QLE);
            if (this.QPA) {
                i4 = a.this.QXN.avh;
            } else {
                i4 = a.this.QXN.Pc;
            }
            int f2 = b.f(a.this.QXP, i2, i3 - this.QLE[1], i4);
            if (f2 != i4) {
                a.this.hbA();
                if (this.QPA) {
                    if (f2 > this.QPE) {
                        b a2 = a.a(a.this, false);
                        hbB();
                        a2.hbB();
                        this.QPD = this.QPE;
                        a.this.lE(this.QPE, f2);
                        a2.hbC();
                    } else {
                        a.this.lE(f2, -1);
                    }
                    hbC();
                    AppMethodBeat.o(159868);
                    return;
                }
                if (f2 < this.QPD) {
                    b a3 = a.a(a.this, true);
                    a3.hbB();
                    hbB();
                    this.QPE = this.QPD;
                    a.this.lE(f2, this.QPD);
                    a3.hbC();
                } else {
                    a.this.lE(this.QPD, f2);
                }
                hbC();
            }
            AppMethodBeat.o(159868);
        }

        private void hbC() {
            AppMethodBeat.i(159869);
            a.this.QXP.getLocationInWindow(this.QLE);
            TextPaint hC = b.hC(a.this.QXP);
            if (hC != null) {
                int i2 = (int) hC.getFontMetrics().descent;
                if (this.QPA) {
                    this.mPopupWindow.update((((int) b.aR(a.this.QXP, a.this.QXN.avh)) - this.mWidth) + hbD(), i2 + b.aP(a.this.QXP, b.aQ(a.this.QXP, a.this.QXN.avh)) + hbE(), -1, -1);
                    AppMethodBeat.o(159869);
                    return;
                }
                int[] lQ = lQ((int) b.aR(a.this.QXP, a.this.QXN.Pc), i2 + b.aP(a.this.QXP, b.aQ(a.this.QXP, a.this.QXN.Pc)));
                this.mPopupWindow.update(lQ[0] + hbD(), lQ[1] + hbE(), -1, -1);
            }
            AppMethodBeat.o(159869);
        }

        public final int hbD() {
            AppMethodBeat.i(159870);
            int paddingLeft = (this.QLE[0] - this.mPadding) + a.this.QXP.getPaddingLeft();
            AppMethodBeat.o(159870);
            return paddingLeft;
        }

        public final int hbE() {
            AppMethodBeat.i(159871);
            int paddingTop = this.QLE[1] + a.this.QXP.getPaddingTop();
            AppMethodBeat.o(159871);
            return paddingTop;
        }

        /* access modifiers changed from: package-private */
        public final int[] lQ(int i2, int i3) {
            AppMethodBeat.i(159872);
            int[] iArr = new int[2];
            if (i2 == 0 && a.this.QXN.Pc > 1) {
                a.this.QXP.getLocationInWindow(this.QLE);
                TextPaint hC = b.hC(a.this.QXP);
                if (hC != null) {
                    i2 = (int) b.aU(a.this.QXP, b.aQ(a.this.QXP, a.this.QXN.Pc - 1));
                    i3 = b.aP(a.this.QXP, b.aQ(a.this.QXP, a.this.QXN.Pc - 1)) + ((int) hC.getFontMetrics().descent);
                }
            }
            iArr[0] = i2;
            iArr[1] = i3;
            AppMethodBeat.o(159872);
            return iArr;
        }
    }

    /* access modifiers changed from: package-private */
    public class g {
        int Pc;
        String QPK;
        int avh;

        g() {
        }
    }

    public static abstract class f {
        public void gL(View view) {
        }

        public void dismiss() {
        }

        public void ea(View view) {
        }

        public void gTY() {
        }

        public void gTZ() {
        }

        public void gUa() {
        }
    }

    /* access modifiers changed from: package-private */
    public class c {
        int end;
        int start;

        c() {
        }

        /* access modifiers changed from: package-private */
        public final boolean Nm(int i2) {
            return i2 >= this.start && i2 < this.end;
        }

        public final String toString() {
            AppMethodBeat.i(159877);
            String str = "start: " + this.start + " end: " + this.end;
            AppMethodBeat.o(159877);
            return str;
        }
    }

    private int bU(int i2, boolean z) {
        AppMethodBeat.i(159893);
        if (this.QYd != null) {
            Iterator<c> it = this.QYd.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.Nm(i2)) {
                    if (z) {
                        int i3 = next.start;
                        AppMethodBeat.o(159893);
                        return i3;
                    }
                    int i4 = next.end;
                    AppMethodBeat.o(159893);
                    return i4;
                }
            }
        }
        AppMethodBeat.o(159893);
        return i2;
    }

    static /* synthetic */ b a(a aVar, boolean z) {
        AppMethodBeat.i(198544);
        if (aVar.QXL.QPA == z) {
            b bVar = aVar.QXL;
            AppMethodBeat.o(198544);
            return bVar;
        }
        b bVar2 = aVar.QXM;
        AppMethodBeat.o(198544);
        return bVar2;
    }
}
