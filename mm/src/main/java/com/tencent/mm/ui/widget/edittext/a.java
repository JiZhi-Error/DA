package com.tencent.mm.ui.widget.edittext;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.w;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.base.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a {
    private ViewTreeObserver.OnPreDrawListener Bl;
    boolean BpG;
    private View.OnLayoutChangeListener OCV;
    private Spannable QGC;
    private Menu QLC;
    Map<Integer, CharSequence> QLD;
    int[] QLE;
    public e QLI;
    b QOY;
    b QOZ;
    private f QPa;
    g QPb;
    private ViewTreeObserver.OnScrollChangedListener QPc;
    private View.OnAttachStateChangeListener QPd;
    public View.OnLongClickListener QPe;
    public View.OnTouchListener QPf;
    public View.OnFocusChangeListener QPg;
    public View.OnClickListener QPh;
    private int QPi;
    int QPj;
    int QPk;
    boolean QPl;
    int QPm;
    boolean QPn;
    boolean QPo;
    int QPp;
    int QPq;
    C2143a QPr;
    boolean QPs;
    private ActionMode.Callback QPt;
    int QPu;
    final Runnable QPv;
    TextView Ws;
    private TextWatcher aws;
    boolean eea;
    Context mContext;
    public boolean mIsPause;
    int ovq;

    public interface e {
        void A(List<c> list, int i2);

        void a(View view, c cVar, String str);
    }

    public static class g {
        public int Pc;
        public String QPK;
        public int avh;
    }

    public /* synthetic */ a(C2143a aVar, byte b2) {
        this(aVar);
    }

    private a(C2143a aVar) {
        AppMethodBeat.i(198331);
        this.QPb = new g();
        this.eea = true;
        this.QPn = false;
        this.QPo = false;
        this.QLD = new HashMap();
        this.QLE = new int[2];
        this.QPt = new ActionMode.Callback() {
            /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass3 */

            public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                AppMethodBeat.i(198302);
                as.d("SelectableEditTextHelper", "mDisableCallback", new Object[0]);
                a.this.g(menu);
                AppMethodBeat.o(198302);
                return false;
            }

            public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public final void onDestroyActionMode(ActionMode actionMode) {
            }
        };
        this.QPu = -1;
        this.QPv = new Runnable() {
            /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(198303);
                if (a.this.eea) {
                    AppMethodBeat.o(198303);
                    return;
                }
                a.a(a.this.hbx());
                a.this.a(a.this.QOY);
                a.this.a(a.this.QOZ);
                AppMethodBeat.o(198303);
            }
        };
        this.mIsPause = false;
        this.QPr = aVar;
        this.Ws = aVar.Ws;
        this.mContext = this.Ws.getContext();
        this.QPi = this.mContext.getResources().getColor(aVar.QPi);
        this.QPj = this.mContext.getResources().getColor(aVar.QPj);
        this.QPk = at.fromDPToPix(this.mContext, (int) aVar.QPx);
        this.QPm = com.tencent.mm.ui.widget.textview.b.hD(this.Ws);
        this.BpG = aVar.BpG;
        this.QPs = Build.VERSION.SDK_INT >= 29 && (av.isMIUI() || av.gKb());
        as.i("SelectableEditTextHelper", "init %s,%s,%s", Boolean.valueOf(this.BpG), this.QPr.QPz, Build.BRAND);
        this.Ws.setText(this.Ws.getText(), TextView.BufferType.SPANNABLE);
        this.QGC = (Spannable) this.Ws.getText();
        this.Ws.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass1 */

            public final boolean onLongClick(View view) {
                boolean z;
                AppMethodBeat.i(198300);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (a.this.QPe != null) {
                    z = a.this.QPe.onLongClick(view);
                } else {
                    z = false;
                }
                if (a.this.BpG) {
                    as.i("SelectableEditTextHelper", "onLongClick:" + a.this.QPn, new Object[0]);
                    a aVar = a.this;
                    if (!TextUtils.isEmpty(Build.BRAND) && "vivo".equals(Build.BRAND.toLowerCase()) && Build.VERSION.SDK_INT < 23) {
                        aVar.Ws.post(new Runnable() {
                            /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(198301);
                                TextView textView = a.this.Ws;
                                try {
                                    Field declaredField = TextView.class.getDeclaredField("mEditor");
                                    declaredField.setAccessible(true);
                                    Object obj = declaredField.get(textView);
                                    Method declaredMethod = Class.forName("android.widget.Editor").getDeclaredMethod("stopSelectionActionMode", new Class[0]);
                                    declaredMethod.setAccessible(true);
                                    declaredMethod.invoke(obj, new Object[0]);
                                    AppMethodBeat.o(198301);
                                } catch (Throwable th) {
                                    as.e("SelectableEditTextHelper", "stopSelectionMode err:%s", th.getMessage());
                                    AppMethodBeat.o(198301);
                                }
                            }
                        });
                    }
                    if (a.this.QPn) {
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(198300);
                        return false;
                    }
                    a.this.QPo = true;
                    a.this.O(a.this.QPp, a.this.QPq, true);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(198300);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(198300);
                return z;
            }
        });
        this.Ws.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass5 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                AppMethodBeat.i(198304);
                if (a.this.QPf != null) {
                    z = a.this.QPf.onTouch(view, motionEvent);
                } else {
                    z = false;
                }
                if (a.this.BpG) {
                    a.this.QPp = (int) motionEvent.getX();
                    a.this.QPq = (int) motionEvent.getY();
                    switch (motionEvent.getAction()) {
                        case 0:
                            a.this.QPo = false;
                            if (a.this.QPs) {
                                a.E(a.this.Ws);
                                a.this.QPs = false;
                            }
                            a aVar = a.this;
                            try {
                                as.d("SelectableEditTextHelper", "setInsertionDisabled", new Object[0]);
                                Field declaredField = TextView.class.getDeclaredField("mEditor");
                                declaredField.setAccessible(true);
                                Object obj = declaredField.get(aVar.Ws);
                                Class<?> cls = Class.forName("android.widget.Editor");
                                Field declaredField2 = cls.getDeclaredField("mInsertionControllerEnabled");
                                declaredField2.setAccessible(true);
                                declaredField2.set(obj, Boolean.FALSE);
                                Field declaredField3 = cls.getDeclaredField("mSelectionControllerEnabled");
                                declaredField3.setAccessible(true);
                                declaredField3.set(obj, Boolean.FALSE);
                                break;
                            } catch (Exception e2) {
                                as.e("SelectableEditTextHelper", "setInsertionDisabled error msg:%s", e2.getMessage());
                                break;
                            }
                        case 1:
                            if (a.this.QPn) {
                                a.this.QPn = false;
                                if (a.this.QPl) {
                                    a.this.QPl = false;
                                    a.this.QPv.run();
                                }
                                AppMethodBeat.o(198304);
                                return true;
                            }
                            break;
                        case 2:
                            if (!av.isMIUI() || !a.this.QPo) {
                                if (a.this.ovq != a.this.Ws.getScrollY()) {
                                    a.this.QPn = true;
                                    if (!a.this.QPl && !a.this.eea) {
                                        a.this.QPl = true;
                                        a.b(a.this.hbx());
                                        a.b(a.this.QOY);
                                        a.b(a.this.QOZ);
                                        break;
                                    }
                                }
                            } else {
                                AppMethodBeat.o(198304);
                                return true;
                            }
                            break;
                    }
                    a.this.ovq = a.this.Ws.getScrollY();
                    AppMethodBeat.o(198304);
                    return false;
                }
                AppMethodBeat.o(198304);
                return z;
            }
        });
        this.Ws.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(198305);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.BpG) {
                    as.i("SelectableEditTextHelper", "onClick", new Object[0]);
                    a.this.Dr(true);
                }
                if (a.this.QPh != null) {
                    a.this.QPh.onClick(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198305);
            }
        });
        this.Ws.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass7 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(198306);
                if (a.this.BpG) {
                    as.d("SelectableEditTextHelper", "onFocusChange:".concat(String.valueOf(z)), new Object[0]);
                    if (!z) {
                        a.this.Dr(false);
                    }
                }
                if (a.this.QPg != null) {
                    a.this.QPg.onFocusChange(view, z);
                }
                AppMethodBeat.o(198306);
            }
        });
        if (this.BpG) {
            this.Ws.setCustomSelectionActionModeCallback(this.QPt);
            if (Build.VERSION.SDK_INT >= 23) {
                this.Ws.setCustomInsertionActionModeCallback(this.QPt);
            }
            this.aws = new TextWatcher() {
                /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass8 */

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    AppMethodBeat.i(198307);
                    if (!a.this.eea) {
                        a.this.hbA();
                        a.this.hbz();
                    }
                    a.this.Ws.setCursorVisible(true);
                    a.this.QPu = a.this.Ws.getSelectionStart();
                    AppMethodBeat.o(198307);
                }

                public final void afterTextChanged(Editable editable) {
                }
            };
            this.QPd = new View.OnAttachStateChangeListener() {
                /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass9 */

                public final void onViewAttachedToWindow(View view) {
                }

                public final void onViewDetachedFromWindow(View view) {
                    AppMethodBeat.i(198308);
                    as.d("SelectableEditTextHelper", "onViewDetachedFromWindow:", new Object[0]);
                    a.this.destroy();
                    AppMethodBeat.o(198308);
                }
            };
            this.OCV = new View.OnLayoutChangeListener() {
                /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass10 */

                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    AppMethodBeat.i(198309);
                    if (a.this.eea) {
                        AppMethodBeat.o(198309);
                        return;
                    }
                    int[] iArr = {a.this.QLE[0], a.this.QLE[1]};
                    a.this.Ws.getLocationInWindow(a.this.QLE);
                    as.d("SelectableEditTextHelper", "LayoutChangeFromWindow l:%d,t:%d,r:%d,b:%d,oldl:%d,oldt:%d,oldr:%d,oldb:%d,oldx:%d, newx:%d, oldy:%d, newy:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(iArr[0]), Integer.valueOf(a.this.QLE[0]), Integer.valueOf(iArr[1]), Integer.valueOf(a.this.QLE[1]));
                    if (!(i3 == i7 && i5 == i9 && iArr[1] == a.this.QLE[1])) {
                        a.this.hby();
                    }
                    AppMethodBeat.o(198309);
                }
            };
            this.Bl = new ViewTreeObserver.OnPreDrawListener() {
                /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass11 */

                public final boolean onPreDraw() {
                    return true;
                }
            };
            this.QPc = new ViewTreeObserver.OnScrollChangedListener() {
                /* class com.tencent.mm.ui.widget.edittext.a.AnonymousClass12 */

                public final void onScrollChanged() {
                }
            };
            this.Ws.addTextChangedListener(this.aws);
            this.Ws.addOnAttachStateChangeListener(this.QPd);
            this.Ws.addOnLayoutChangeListener(this.OCV);
            this.Ws.getViewTreeObserver().addOnPreDrawListener(this.Bl);
            this.Ws.getViewTreeObserver().addOnScrollChangedListener(this.QPc);
        }
        AppMethodBeat.o(198331);
    }

    /* access modifiers changed from: package-private */
    public final void g(Menu menu) {
        AppMethodBeat.i(198332);
        if (menu != null && this.QPr.QHA.size() > 0) {
            for (int i2 = 0; i2 < menu.size(); i2++) {
                MenuItem item = menu.getItem(i2);
                as.d("SelectableEditTextHelper", "filterReuseMenus:%s", item.getTitle());
                if (this.QPr.QHA.contains(item.getTitle())) {
                    as.d("SelectableEditTextHelper", "reuse bingo:%s", item.getTitle());
                    this.QLD.put(Integer.valueOf(item.getItemId()), item.getTitle());
                }
            }
        }
        AppMethodBeat.o(198332);
    }

    private static boolean a(TextView textView, Menu menu) {
        AppMethodBeat.i(198333);
        try {
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(textView);
            Class<?> cls = Class.forName("android.widget.Editor");
            Class<?> cls2 = Class.forName("android.widget.Editor$TextActionModeCallback");
            Object tag = textView.getTag(R.id.iku);
            if (tag == null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls, Integer.TYPE);
                    declaredConstructor.setAccessible(true);
                    tag = declaredConstructor.newInstance(obj, 1);
                } else {
                    Constructor<?> declaredConstructor2 = cls2.getDeclaredConstructor(cls, Boolean.TYPE);
                    declaredConstructor2.setAccessible(true);
                    tag = declaredConstructor2.newInstance(obj, Boolean.FALSE);
                }
            }
            Method declaredMethod = cls2.getDeclaredMethod("populateMenuWithItems", Menu.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(tag, menu);
            textView.setTag(R.id.iku, tag);
            as.i("SelectableEditTextHelper", "populateMenuItems succ", new Object[0]);
            AppMethodBeat.o(198333);
            return true;
        } catch (Throwable th) {
            as.e("SelectableEditTextHelper", "populateMenuItems err", new Object[0]);
            AppMethodBeat.o(198333);
            return false;
        }
    }

    private static boolean haY() {
        AppMethodBeat.i(198334);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                Method method = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                Object invoke = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
                if (invoke == null || method == null) {
                    AppMethodBeat.o(198334);
                    return false;
                }
                try {
                    method.invoke(invoke, new String[]{"L"});
                    AppMethodBeat.o(198334);
                    return true;
                } catch (Throwable th) {
                    AppMethodBeat.o(198334);
                    return false;
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(198334);
                return false;
            }
        } else {
            AppMethodBeat.o(198334);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final f hbx() {
        AppMethodBeat.i(198335);
        if (this.QPa == null) {
            this.QPa = new f(this.mContext);
        }
        f fVar = this.QPa;
        AppMethodBeat.o(198335);
        return fVar;
    }

    public final void hby() {
        AppMethodBeat.i(198336);
        hbA();
        hbz();
        Selection.setSelection(this.Ws.getEditableText(), this.Ws.getSelectionEnd());
        this.Ws.setCursorVisible(true);
        AppMethodBeat.o(198336);
    }

    /* access modifiers changed from: package-private */
    public final void Dr(boolean z) {
        AppMethodBeat.i(198337);
        if (this.mIsPause) {
            AppMethodBeat.o(198337);
        } else if (!z) {
            hby();
            AppMethodBeat.o(198337);
        } else {
            int selectionStart = this.Ws.getSelectionStart();
            if (!this.eea || this.QPu != selectionStart) {
                hby();
            } else {
                O(this.QPp, this.QPq, false);
                this.QPu = selectionStart;
            }
            this.Ws.setCursorVisible(true);
            this.QPu = selectionStart;
            AppMethodBeat.o(198337);
        }
    }

    /* access modifiers changed from: package-private */
    public final void hbz() {
        AppMethodBeat.i(198338);
        this.eea = true;
        b(this.QOY);
        b(this.QOZ);
        b(hbx());
        AppMethodBeat.o(198338);
    }

    /* access modifiers changed from: package-private */
    public final void hbA() {
        this.QPb.QPK = null;
    }

    /* access modifiers changed from: package-private */
    public final void O(int i2, int i3, boolean z) {
        int i4;
        boolean z2 = true;
        AppMethodBeat.i(198339);
        if (this.Ws.getLayout() == null || this.Ws.getWidth() == 0) {
            AppMethodBeat.o(198339);
            return;
        }
        if (this.QOY == null) {
            this.QOY = new b(true);
        }
        if (this.QOZ == null) {
            this.QOZ = new b(false);
        }
        int selectionStart = !z ? this.Ws.getSelectionStart() : this.Ws.getOffsetForPosition((float) i2, (float) i3);
        int i5 = selectionStart + 1;
        if (this.Ws.getText() instanceof Spannable) {
            this.QGC = (Spannable) this.Ws.getText();
        }
        if (this.QGC == null) {
            AppMethodBeat.o(198339);
            return;
        }
        if (selectionStart >= this.Ws.getText().length() || !z) {
            z2 = false;
        }
        if (z2) {
            this.Ws.setCursorVisible(false);
            i4 = i5;
        } else {
            i4 = selectionStart;
        }
        if (!this.eea && this.QPb.avh == selectionStart && this.QPb.Pc == i4) {
            AppMethodBeat.o(198339);
            return;
        }
        hbz();
        hbA();
        this.eea = false;
        lE(selectionStart, i4);
        if (z2) {
            a(this.QOY);
            a(this.QOZ);
        }
        a(hbx());
        AppMethodBeat.o(198339);
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        AppMethodBeat.i(198340);
        if (bVar == null) {
            AppMethodBeat.o(198340);
            return;
        }
        try {
            Layout layout = this.Ws.getLayout();
            int i2 = bVar.QPA ? this.QPb.avh : this.QPb.Pc;
            bVar.lF((int) layout.getPrimaryHorizontal(i2), layout.getLineBottom(layout.getLineForOffset(i2)));
            AppMethodBeat.o(198340);
        } catch (Throwable th) {
            as.e("SelectableEditTextHelper", "show cursor err：%s", Log.getStackTraceString(th));
            AppMethodBeat.o(198340);
        }
    }

    /* access modifiers changed from: package-private */
    public final void lE(int i2, int i3) {
        AppMethodBeat.i(198341);
        if (i2 != -1) {
            this.QPb.avh = i2;
        }
        if (i3 != -1) {
            this.QPb.Pc = i3;
        }
        if (this.QPb.avh > this.QPb.Pc) {
            int i4 = this.QPb.avh;
            this.QPb.avh = this.QPb.Pc;
            this.QPb.Pc = i4;
        }
        if (this.QGC != null) {
            if (i2 >= this.Ws.getText().length()) {
                AppMethodBeat.o(198341);
                return;
            }
            this.QPb.QPK = this.QGC.subSequence(this.QPb.avh, this.QPb.Pc).toString();
            this.Ws.setHighlightColor(this.QPi);
            Selection.setSelection(this.QGC, this.QPb.avh, this.QPb.Pc);
        }
        AppMethodBeat.o(198341);
    }

    public final void destroy() {
        AppMethodBeat.i(198342);
        this.Ws.removeTextChangedListener(this.aws);
        this.Ws.removeOnAttachStateChangeListener(this.QPd);
        this.Ws.removeOnLayoutChangeListener(this.OCV);
        this.Ws.getViewTreeObserver().removeOnScrollChangedListener(this.QPc);
        this.Ws.getViewTreeObserver().removeOnPreDrawListener(this.Bl);
        hbA();
        hbz();
        this.QOY = null;
        this.QOZ = null;
        this.QPa = null;
        AppMethodBeat.o(198342);
    }

    static void a(f fVar) {
        AppMethodBeat.i(198343);
        if (fVar != null) {
            try {
                fVar.show();
                AppMethodBeat.o(198343);
                return;
            } catch (Throwable th) {
                as.e("SelectableEditTextHelper", "show oper err：%s", Log.getStackTraceString(th));
            }
        }
        AppMethodBeat.o(198343);
    }

    static void b(f fVar) {
        AppMethodBeat.i(198344);
        if (fVar != null) {
            fVar.qQv.dismiss();
        }
        AppMethodBeat.o(198344);
    }

    static void b(b bVar) {
        AppMethodBeat.i(198345);
        if (bVar != null) {
            bVar.mPopupWindow.dismiss();
        }
        AppMethodBeat.o(198345);
    }

    static boolean E(TextView textView) {
        AppMethodBeat.i(198346);
        try {
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(textView);
            Class<?> cls = Class.forName("android.widget.Editor");
            Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(cls, "getEmailPopupWindow", null);
            method.setAccessible(true);
            method.invoke(obj, new Object[0]);
            as.i("SelectableEditTextHelper", "getEmailPopupWindow succ", new Object[0]);
            AppMethodBeat.o(198346);
            return true;
        } catch (Throwable th) {
            as.e("SelectableEditTextHelper", "getEmailPopupWindow err:%s", th.getMessage());
            AppMethodBeat.o(198346);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class f {
        ImageView QLA;
        List<c> QLz;
        d QPH;
        private int mHeight;
        RecyclerView mRecyclerView;
        private int mWidth;
        PopupWindow qQv;

        public f(Context context) {
            AppMethodBeat.i(198328);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ayw, (ViewGroup) null);
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.mWidth = inflate.getMeasuredWidth();
            this.mHeight = inflate.getMeasuredHeight();
            this.qQv = new PopupWindow(inflate, -2, -2, false);
            this.qQv.setClippingEnabled(false);
            this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.h_1);
            this.mRecyclerView.setLayoutManager(new LinearLayoutManager(0, false));
            LinkedList linkedList = new LinkedList();
            linkedList.add(new c(a.this.mContext.getResources().getString(R.string.f07), 1, 4));
            linkedList.add(new c(a.this.mContext.getResources().getString(17039373), 16908319, 12));
            linkedList.add(new c(a.this.mContext.getResources().getString(17039363), 16908320, 9));
            linkedList.add(new c(a.this.mContext.getResources().getString(17039361), 16908321, 9));
            linkedList.add(new c(a.this.mContext.getResources().getString(17039371), 16908322));
            this.QLz = linkedList;
            this.QPH = new d(this.QLz, new e(a.this) {
                /* class com.tencent.mm.ui.widget.edittext.a.f.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.edittext.a.e
                public final void A(List<c> list, int i2) {
                }

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.widget.edittext.a.e
                public final void a(View view, c cVar, String str) {
                    AppMethodBeat.i(198326);
                    f fVar = f.this;
                    switch (cVar.id) {
                        case 1:
                            a.this.hbz();
                            int selectionStart = a.this.Ws.getSelectionStart();
                            if (selectionStart > 0) {
                                a.this.lE(selectionStart - 1, selectionStart);
                            } else {
                                a.this.lE(selectionStart, selectionStart + 1);
                            }
                            a.this.eea = false;
                            a.this.a(a.this.QOY);
                            a.this.a(a.this.QOZ);
                            a.a(a.this.hbx());
                            a.this.Ws.setCursorVisible(false);
                            break;
                        case 16908319:
                            a.this.hbz();
                            a.this.lE(0, a.this.Ws.getText().length());
                            a.this.eea = false;
                            a.this.Ws.post(new Runnable() {
                                /* class com.tencent.mm.ui.widget.edittext.a.f.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(198327);
                                    a.this.a(a.this.QOY);
                                    a.this.a(a.this.QOZ);
                                    a.a(a.this.hbx());
                                    AppMethodBeat.o(198327);
                                }
                            });
                            a.this.Ws.setCursorVisible(false);
                            break;
                        case 16908320:
                            ((ClipboardManager) a.this.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(a.this.QPb.QPK, a.this.QPb.QPK));
                            a.this.hbA();
                            a.this.hbz();
                            ((Editable) a.this.Ws.getText()).delete(a.this.QPb.avh, a.this.QPb.Pc);
                            Toast.makeText(a.this.mContext, a.this.mContext.getResources().getString(R.string.ezu), 0).show();
                            a.this.Ws.setCursorVisible(true);
                            break;
                        case 16908321:
                            ((ClipboardManager) a.this.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(a.this.QPb.QPK, a.this.QPb.QPK));
                            a.this.hbA();
                            a.this.hbz();
                            Toast.makeText(a.this.mContext, a.this.mContext.getResources().getString(R.string.ezt), 0).show();
                            a.this.Ws.setCursorVisible(true);
                            Selection.setSelection(a.this.Ws.getEditableText(), a.this.Ws.getSelectionEnd());
                            break;
                        case 16908322:
                            a.this.Ws.onTextContextMenuItem(16908322);
                            a.this.Ws.setCursorVisible(true);
                            a.this.QPu = a.this.Ws.getSelectionStart();
                            break;
                        default:
                            a.this.Ws.setCursorVisible(true);
                            break;
                    }
                    if (a.this.QLD.containsKey(Integer.valueOf(cVar.id))) {
                        a.this.Ws.onTextContextMenuItem(cVar.id);
                        a.this.hbA();
                        a.this.hbz();
                        a.this.Ws.setCursorVisible(true);
                    }
                    if (a.this.QLI != null) {
                        a.this.QLI.a(view, cVar, str);
                    }
                    AppMethodBeat.o(198326);
                }
            }, a.this.QPb);
            this.mRecyclerView.setAdapter(this.QPH);
            w wVar = new w(a.this.mContext, 0);
            wVar.setDrawable(new ColorDrawable(a.this.mContext.getResources().getColor(R.color.w1)));
            this.mRecyclerView.a(wVar);
            this.QLA = (ImageView) inflate.findViewById(R.id.bjj);
            AppMethodBeat.o(198328);
        }

        private void haW() {
            int i2;
            boolean z = true;
            AppMethodBeat.i(198329);
            int length = a.this.Ws.getText().length();
            if (length > 0 && a.this.QPb.avh == 0 && a.this.QPb.Pc == length) {
                i2 = 1;
            } else if (a.this.QPb.avh != a.this.QPb.Pc) {
                i2 = 8;
            } else if (length > 0) {
                i2 = 4;
            } else {
                i2 = 2;
            }
            LinkedList linkedList = new LinkedList();
            for (c cVar : this.QLz) {
                if ((cVar.QPF & i2) != 0) {
                    linkedList.add(cVar);
                }
            }
            a.this.QLD.clear();
            a aVar = a.this;
            if (aVar.QPr.QHA.size() <= 0 || Build.BRAND == null || !aVar.QPr.QPy.contains(Build.BRAND.toLowerCase()) || Build.VERSION.SDK_INT < 23 || !aVar.BpG) {
                z = false;
            }
            if (z) {
                as.i("SelectableEditTextHelper", "tryGetMenus", new Object[0]);
                a.a(a.this);
            }
            if (a.this.QLD.size() > 0) {
                for (Map.Entry<Integer, CharSequence> entry : a.this.QLD.entrySet()) {
                    linkedList.add(new c(entry.getValue().toString(), entry.getKey().intValue()));
                }
            }
            if (a.this.QLI != null) {
                a.this.QLI.A(linkedList, i2);
            }
            this.QPH.qXp = linkedList;
            this.QPH.atj.notifyChanged();
            AppMethodBeat.o(198329);
        }

        public final void show() {
            int i2;
            int i3;
            int i4;
            int i5;
            AppMethodBeat.i(198330);
            haW();
            View contentView = this.qQv.getContentView();
            contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.mWidth = contentView.getMeasuredWidth();
            this.mHeight = contentView.getMeasuredHeight();
            a.this.Ws.getLocationInWindow(a.this.QLE);
            Layout layout = a.this.Ws.getLayout();
            int screenWidth = com.tencent.mm.ui.widget.textview.b.getScreenWidth(a.this.mContext);
            int fromDPToPix = at.fromDPToPix(a.this.mContext, 10);
            int i6 = screenWidth - (fromDPToPix * 2);
            if (this.mWidth >= i6) {
                this.mWidth = i6;
            }
            int primaryHorizontal = ((((((int) layout.getPrimaryHorizontal(a.this.QPb.avh)) + ((int) layout.getPrimaryHorizontal(a.this.QPb.Pc))) / 2) + a.this.QLE[0]) - (this.mWidth / 2)) + a.this.Ws.getPaddingLeft();
            if (a.this.QPb.avh == a.this.QPb.Pc || layout.getLineForOffset(a.this.QPb.avh) == layout.getLineForOffset(a.this.QPb.Pc)) {
                i2 = primaryHorizontal;
            } else {
                i2 = (a.this.QLE[0] + (a.this.Ws.getWidth() / 2)) - (this.mWidth / 2);
            }
            int lineTop = ((((layout.getLineTop(layout.getLineForOffset(a.this.QPb.avh)) + a.this.QLE[1]) - this.mHeight) + a.this.Ws.getPaddingTop()) - a.this.Ws.getScrollY()) - at.fromDPToPix(a.this.mContext, 5);
            int fromDPToPix2 = (a.this.QLE[1] - this.mHeight) - at.fromDPToPix(a.this.mContext, 5);
            int height = ((a.this.QLE[1] + a.this.Ws.getHeight()) - this.mHeight) - at.fromDPToPix(a.this.mContext, 5);
            if (i2 <= fromDPToPix) {
                i3 = fromDPToPix;
            } else {
                i3 = i2;
            }
            if (lineTop < fromDPToPix2) {
                i4 = fromDPToPix2;
            } else {
                i4 = lineTop;
            }
            if (i4 > height) {
                AppMethodBeat.o(198330);
                return;
            }
            if (this.mWidth + i3 > screenWidth) {
                i5 = (screenWidth - this.mWidth) - fromDPToPix;
            } else {
                i5 = i3;
            }
            ((LinearLayout.LayoutParams) this.QLA.getLayoutParams()).leftMargin = i2 - i5;
            if (Build.VERSION.SDK_INT >= 21) {
                this.qQv.setElevation(8.0f);
            }
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(linearLayoutManager, a2.axQ(), "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OperateWindow", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
                linearLayoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(linearLayoutManager, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OperateWindow", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            }
            this.qQv.setWidth(this.mWidth);
            try {
                this.qQv.showAtLocation(a.this.Ws, 0, i5, i4);
                AppMethodBeat.o(198330);
            } catch (Exception e2) {
                as.e("SelectableEditTextHelper", "oper error!:%s", e2.getMessage());
                AppMethodBeat.o(198330);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends View {
        private int[] PhV = new int[2];
        private int[] QLE = new int[2];
        private boolean QPA;
        private int QPB;
        private int QPC;
        private int QPD;
        private int QPE;
        private int mHeight = (this.qRY * 2);
        private int mPadding = 25;
        private Paint mPaint;
        PopupWindow mPopupWindow;
        private int mWidth = (this.qRY * 2);
        private int qRY = (a.this.QPk / 2);

        public b(boolean z) {
            super(a.this.mContext);
            AppMethodBeat.i(198311);
            this.QPA = z;
            this.mPaint = new Paint(1);
            this.mPaint.setColor(a.this.QPj);
            this.mPopupWindow = new PopupWindow(this);
            this.mPopupWindow.setClippingEnabled(false);
            this.mPopupWindow.setWidth(this.mWidth + (this.mPadding * 2));
            this.mPopupWindow.setHeight(this.mHeight + (this.mPadding / 2));
            invalidate();
            AppMethodBeat.o(198311);
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            AppMethodBeat.i(198312);
            canvas.drawCircle((float) (this.qRY + this.mPadding), (float) this.qRY, (float) this.qRY, this.mPaint);
            if (this.QPA) {
                canvas.drawRect((float) (this.qRY + this.mPadding), 0.0f, (float) ((this.qRY * 2) + this.mPadding), (float) this.qRY, this.mPaint);
                AppMethodBeat.o(198312);
                return;
            }
            canvas.drawRect((float) this.mPadding, 0.0f, (float) (this.qRY + this.mPadding), (float) this.qRY, this.mPaint);
            AppMethodBeat.o(198312);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            int i2;
            boolean z;
            AppMethodBeat.i(198313);
            switch (motionEvent.getAction()) {
                case 0:
                    this.QPD = a.this.QPb.avh;
                    this.QPE = a.this.QPb.Pc;
                    this.QPB = (int) motionEvent.getX();
                    this.QPC = (int) motionEvent.getY();
                    a.this.Ws.getLocationInWindow(this.PhV);
                    break;
                case 1:
                case 3:
                    a.a(a.this.hbx());
                    break;
                case 2:
                    a.b(a.this.hbx());
                    int rawX = ((int) motionEvent.getRawX()) - this.PhV[0];
                    int scrollY = a.this.Ws.getScrollY() + (((this.QPC + ((int) motionEvent.getRawY())) - this.mHeight) - a.this.QPm);
                    a.this.Ws.getLocationInWindow(this.QLE);
                    if (this.QPA) {
                        i2 = a.this.QPb.avh;
                    } else {
                        i2 = a.this.QPb.Pc;
                    }
                    int f2 = com.tencent.mm.ui.widget.textview.b.f(a.this.Ws, rawX, scrollY - this.QLE[1], i2);
                    if (f2 != i2) {
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
                        } else {
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
                    }
                    a aVar = a.this;
                    if (!this.QPA) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a.a(aVar, z).hbC();
                    break;
            }
            AppMethodBeat.o(198313);
            return true;
        }

        private void hbB() {
            AppMethodBeat.i(198314);
            this.QPA = !this.QPA;
            invalidate();
            AppMethodBeat.o(198314);
        }

        private void hbC() {
            AppMethodBeat.i(198315);
            a.this.Ws.getLocationInWindow(this.QLE);
            Layout layout = a.this.Ws.getLayout();
            if (this.QPA) {
                lG((((int) layout.getPrimaryHorizontal(a.this.QPb.avh)) - this.mWidth) + hbD(), a(a.this.QPb.avh, layout));
                AppMethodBeat.o(198315);
                return;
            }
            lG(((int) layout.getPrimaryHorizontal(a.this.QPb.Pc)) + hbD(), a(a.this.QPb.Pc, layout));
            AppMethodBeat.o(198315);
        }

        private int a(int i2, Layout layout) {
            AppMethodBeat.i(198316);
            int hbE = hbE() + layout.getLineBottom(layout.getLineForOffset(i2));
            int height = (this.QLE[1] + a.this.Ws.getHeight()) - a.this.Ws.getPaddingBottom();
            if (hbE <= height) {
                height = hbE;
            }
            if (height < this.QLE[1]) {
                height = this.QLE[1];
            }
            AppMethodBeat.o(198316);
            return height;
        }

        public final void lF(int i2, int i3) {
            AppMethodBeat.i(198317);
            a.this.Ws.getLocationInWindow(this.QLE);
            int hbD = (i2 - (this.QPA ? this.mWidth : 0)) + hbD();
            int hbE = hbE() + i3;
            if (hbE < this.QLE[1]) {
                AppMethodBeat.o(198317);
            } else if (hbE > ((this.QLE[1] + a.this.Ws.getHeight()) - a.this.Ws.getPaddingBottom()) + at.fromDPToPix(a.this.mContext, 5)) {
                AppMethodBeat.o(198317);
            } else {
                lG(hbD, hbE);
                AppMethodBeat.o(198317);
            }
        }

        private void lG(int i2, int i3) {
            AppMethodBeat.i(198318);
            try {
                if (this.mPopupWindow.isShowing()) {
                    this.mPopupWindow.update(i2, i3, -1, -1);
                    AppMethodBeat.o(198318);
                    return;
                }
                this.mPopupWindow.showAtLocation(a.this.Ws, 0, i2, i3);
                AppMethodBeat.o(198318);
            } catch (Exception e2) {
                as.e("SelectableEditTextHelper", "cursor error!: %s.", e2.getMessage());
                AppMethodBeat.o(198318);
            }
        }

        private int hbD() {
            AppMethodBeat.i(198319);
            int paddingLeft = (this.QLE[0] - this.mPadding) + a.this.Ws.getPaddingLeft();
            AppMethodBeat.o(198319);
            return paddingLeft;
        }

        private int hbE() {
            AppMethodBeat.i(198320);
            int paddingTop = (this.QLE[1] + a.this.Ws.getPaddingTop()) - a.this.Ws.getScrollY();
            AppMethodBeat.o(198320);
            return paddingTop;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.edittext.a$a  reason: collision with other inner class name */
    public static class C2143a {
        boolean BpG = true;
        public Set<String> QHA = new HashSet();
        int QPi = R.color.a6q;
        int QPj = R.color.kn;
        float QPx = 18.0f;
        public Set<String> QPy = new HashSet();
        public String QPz;
        TextView Ws;

        public C2143a(TextView textView) {
            AppMethodBeat.i(198310);
            this.Ws = textView;
            AppMethodBeat.o(198310);
        }
    }

    public static class c {
        public int QPF;
        public int id;
        public String name;

        public c(String str, int i2, int i3) {
            this.name = str;
            this.id = i2;
            this.QPF = i3;
        }

        public c(String str, int i2) {
            this.name = str;
            this.id = i2;
            this.QPF = 15;
        }
    }

    public static class d extends RecyclerView.a<C2144a> {
        private e QLI;
        private g QPb;
        private List<c> qXp;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(C2144a aVar, int i2) {
            AppMethodBeat.i(198324);
            C2144a aVar2 = aVar;
            c cVar = this.qXp.get(i2);
            aVar2.vr.setText(cVar.name);
            aVar2.vr.setTag(cVar);
            AppMethodBeat.o(198324);
        }

        d(List<c> list, e eVar, g gVar) {
            this.qXp = list;
            this.QLI = eVar;
            this.QPb = gVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(198323);
            int size = this.qXp.size();
            AppMethodBeat.o(198323);
            return size;
        }

        /* renamed from: com.tencent.mm.ui.widget.edittext.a$d$a  reason: collision with other inner class name */
        class C2144a extends RecyclerView.v {
            TextView vr;

            public C2144a(View view) {
                super(view);
                AppMethodBeat.i(198322);
                this.vr = (TextView) view.findViewById(R.id.fd8);
                this.vr.setTextSize(1, 14.0f);
                AppMethodBeat.o(198322);
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ C2144a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(198325);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ayx, viewGroup, false);
            C2144a aVar = new C2144a(inflate);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.widget.edittext.a.d.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(198321);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$MyRecycleViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (view != null || (view.getTag() instanceof c)) {
                        d.this.QLI.a(view, (c) view.getTag(), !TextUtils.isEmpty(d.this.QPb.QPK) ? d.this.QPb.QPK : "");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$MyRecycleViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(198321);
                }
            });
            AppMethodBeat.o(198325);
            return aVar;
        }
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(198347);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Field declaredField = TextView.class.getDeclaredField("mTextSelectHandleRes");
            declaredField.setAccessible(true);
            declaredField.set(aVar.Ws, Integer.valueOf((int) R.drawable.b0m));
        } catch (Exception e2) {
            as.e("SelectableEditTextHelper", "disableSysHandle fail:", e2.getMessage());
        }
        boolean haY = haY();
        TextView textView = aVar.Ws;
        if (aVar.QLC == null) {
            aVar.QLC = new m(aVar.mContext);
        }
        aVar.QLC.clear();
        haY();
        boolean a2 = a(textView, aVar.QLC);
        aVar.g(aVar.QLC);
        as.i("SelectableEditTextHelper", "startInsertionActionMode SDK_INT:%s, exemptRes:%s ,res:%s, duration:%s", Integer.valueOf(Build.VERSION.SDK_INT), Boolean.valueOf(haY), Boolean.valueOf(a2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(198347);
    }

    static /* synthetic */ b a(a aVar, boolean z) {
        AppMethodBeat.i(198348);
        if (aVar.QOY.QPA == z) {
            b bVar = aVar.QOY;
            AppMethodBeat.o(198348);
            return bVar;
        }
        b bVar2 = aVar.QOZ;
        AppMethodBeat.o(198348);
        return bVar2;
    }
}
