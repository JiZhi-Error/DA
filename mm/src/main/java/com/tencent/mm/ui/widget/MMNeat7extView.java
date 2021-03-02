package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.neattextview.textview.view.NeatTextView;

public class MMNeat7extView extends NeatTextView {
    public static boolean QCT = false;
    private static final String QCU = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    private static boolean VC = true;
    private View.OnLongClickListener QCV;
    private a QCW;
    private b QCX;
    private GestureDetector mDJ;

    public interface a {
        void at(CharSequence charSequence);
    }

    public interface b {
        void a(Exception exc, String str, String str2);
    }

    static {
        AppMethodBeat.i(143376);
        AppMethodBeat.o(143376);
    }

    public MMNeat7extView(Context context) {
        super(context);
        AppMethodBeat.i(164209);
        init();
        AppMethodBeat.o(164209);
    }

    public MMNeat7extView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143366);
        init();
        AppMethodBeat.o(143366);
    }

    private void init() {
        AppMethodBeat.i(164210);
        this.mDJ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.ui.widget.MMNeat7extView.AnonymousClass1 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(205403);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(205403);
                return onContextClick;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(205402);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(205402);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(205401);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(205401);
                return onSingleTapUp;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(143364);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                if (MMNeat7extView.this.getOnDoubleClickListener() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(143364);
                    return false;
                }
                boolean gS = MMNeat7extView.this.getOnDoubleClickListener().gS(MMNeat7extView.this);
                com.tencent.mm.hellhoundlib.a.a.a(gS, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(143364);
                return gS;
            }
        });
        AppMethodBeat.o(164210);
    }

    @Override // com.tencent.neattextview.textview.view.a, com.tencent.neattextview.textview.view.NeatTextView
    public float getVerticalOffset() {
        AppMethodBeat.i(143367);
        if (QCT) {
            float verticalOffset = super.getVerticalOffset();
            getMeasuredHeight();
            AppMethodBeat.o(143367);
            return verticalOffset;
        }
        float verticalOffset2 = super.getVerticalOffset();
        AppMethodBeat.o(143367);
        return verticalOffset2;
    }

    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        boolean z;
        AppMethodBeat.i(143368);
        Log.d("MicroMsg.MMNeat7extView", "[isOpen] %s", Boolean.FALSE);
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        boolean isEnabled = accessibilityManager.isEnabled();
        boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        if (!isEnabled || !isTouchExplorationEnabled) {
            z = false;
        } else {
            z = true;
        }
        if (z || CrashReportFactory.hasDebuger()) {
            CharSequence hiT = super.hiT();
            AppMethodBeat.o(143368);
            return hiT;
        }
        AppMethodBeat.o(143368);
        return "";
    }

    @Override // com.tencent.neattextview.textview.view.NeatTextView
    public final boolean gYM() {
        return VC;
    }

    @Override // com.tencent.neattextview.textview.view.NeatTextView
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143370);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(143370);
        } catch (Exception e2) {
            String replaceAll = hiT().toString().replaceAll(QCU, "*");
            Log.e("MicroMsg.MMNeat7extView", "[onDraw] replaceContent:%s exception:%s", replaceAll, e2);
            if (this.QCX != null) {
                this.QCX.a(e2, replaceAll, "onDraw");
                AppMethodBeat.o(143370);
                return;
            }
            AppMethodBeat.o(143370);
            throw e2;
        }
    }

    @Override // com.tencent.neattextview.textview.view.NeatTextView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(143371);
        try {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(143371);
        } catch (Exception e2) {
            String replaceAll = hiT().toString().replaceAll(QCU, "*");
            Log.e("MicroMsg.MMNeat7extView", "[onMeasure] replaceContent:%s exception:%s", replaceAll, e2);
            if (this.QCX != null) {
                this.QCX.a(e2, replaceAll, "onMeasure");
                AppMethodBeat.o(143371);
                return;
            }
            AppMethodBeat.o(143371);
            throw e2;
        }
    }

    @Override // com.tencent.neattextview.textview.view.NeatTextView
    public final void aw(CharSequence charSequence) {
        AppMethodBeat.i(143372);
        try {
            super.aw(charSequence);
            if (this.pMM && this.QCX != null) {
                charSequence.toString();
            }
        } catch (Exception e2) {
            String replaceAll = hiT().toString().replaceAll(QCU, "*");
            Log.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", replaceAll, e2);
            if (this.QCX != null) {
                this.QCX.a(e2, replaceAll, "_setText");
            } else {
                AppMethodBeat.o(143372);
                throw e2;
            }
        }
        if (this.QCW != null) {
            a aVar = this.QCW;
            if (charSequence instanceof Spannable) {
                TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
            } else {
                TextView.BufferType bufferType2 = TextView.BufferType.NORMAL;
            }
            aVar.at(charSequence);
        }
        AppMethodBeat.o(143372);
    }

    @Override // com.tencent.neattextview.textview.view.NeatTextView
    public final void a(CharSequence charSequence, TextView.BufferType bufferType) {
        AppMethodBeat.i(143373);
        try {
            super.a(charSequence, bufferType);
            if (this.pMM && this.QCX != null) {
                charSequence.toString();
            }
        } catch (Exception e2) {
            String replaceAll = hiT().toString().replaceAll(QCU, "*");
            Log.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", replaceAll, e2);
            if (this.QCX != null) {
                this.QCX.a(e2, replaceAll, "_setText");
            } else {
                AppMethodBeat.o(143373);
                throw e2;
            }
        }
        if (this.QCW != null) {
            this.QCW.at(charSequence);
        }
        AppMethodBeat.o(143373);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(143374);
        this.QCV = onLongClickListener;
        super.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.ui.widget.MMNeat7extView.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(143365);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMNeat7extView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (MMNeat7extView.QCT) {
                    Toast.makeText(MMNeat7extView.this.getContext(), MMNeat7extView.bom(MMNeat7extView.this.hiT().toString()), 1).show();
                }
                if (MMNeat7extView.this.QCV != null) {
                    boolean onLongClick = MMNeat7extView.this.QCV.onLongClick(view);
                    com.tencent.mm.hellhoundlib.a.a.a(onLongClick, this, "com/tencent/mm/ui/widget/MMNeat7extView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(143365);
                    return onLongClick;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/widget/MMNeat7extView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(143365);
                return false;
            }
        });
        AppMethodBeat.o(143374);
    }

    public void setIsOpen(boolean z) {
        VC = z;
    }

    public void setTextListener(a aVar) {
        this.QCW = aVar;
    }

    public void setTextCrashListener(b bVar) {
        this.QCX = bVar;
    }

    @Override // com.tencent.neattextview.textview.view.NeatTextView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(143369);
        if (!VC || (this.pMM && this.mDJ != null)) {
            GestureDetector gestureDetector = this.mDJ;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/widget/MMNeat7extView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/widget/MMNeat7extView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(143369);
        return onTouchEvent;
    }

    static /* synthetic */ String bom(String str) {
        AppMethodBeat.i(143375);
        String replaceAll = str.replaceAll(QCU, "*");
        StringBuilder sb = new StringBuilder(replaceAll);
        sb.append('\n');
        sb.append('[');
        char[] charArray = replaceAll.toCharArray();
        for (char c2 : charArray) {
            if (c2 != '*') {
                sb.append("{\\u").append(String.format("%x", Integer.valueOf(c2))).append("}");
            }
        }
        sb.append(']');
        String sb2 = sb.toString();
        AppMethodBeat.o(143375);
        return sb2;
    }
}
