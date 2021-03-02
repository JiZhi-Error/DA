package com.tencent.mm.ui.widget.cedit.b;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;
import com.tencent.mm.ui.widget.cedit.util.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class b implements d {
    @Override // com.tencent.mm.ui.widget.cedit.b.d
    public boolean canSelectArbitrarily() {
        return false;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.d
    public void j(Spannable spannable) {
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.d
    public final boolean a(CustomTextView customTextView, Spannable spannable, int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(206074);
        boolean a2 = a(customTextView, spannable, i2, getMovementMetaState(spannable, keyEvent), keyEvent);
        if (a2) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(spannable);
            d.resetLockedMeta(spannable);
        }
        AppMethodBeat.o(206074);
        return a2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.d
    public final boolean a(CustomTextView customTextView, Spannable spannable, KeyEvent keyEvent) {
        AppMethodBeat.i(206075);
        int movementMetaState = getMovementMetaState(spannable, keyEvent);
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 0 || keyEvent.getAction() != 2) {
            AppMethodBeat.o(206075);
            return false;
        }
        int repeatCount = keyEvent.getRepeatCount();
        boolean z = false;
        for (int i2 = 0; i2 < repeatCount && a(customTextView, spannable, keyCode, movementMetaState, keyEvent); i2++) {
            z = true;
        }
        if (z) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(spannable);
            d.resetLockedMeta(spannable);
        }
        AppMethodBeat.o(206075);
        return z;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.d
    public void a(CustomTextView customTextView, Spannable spannable, int i2) {
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.d
    public boolean a(CustomTextView customTextView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.d
    public final boolean a(CustomTextView customTextView, MotionEvent motionEvent) {
        float f2;
        float axisValue;
        boolean z = false;
        AppMethodBeat.i(206076);
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if ((motionEvent.getMetaState() & 1) != 0) {
                        axisValue = motionEvent.getAxisValue(9);
                        f2 = 0.0f;
                    } else {
                        f2 = -motionEvent.getAxisValue(9);
                        axisValue = motionEvent.getAxisValue(10);
                    }
                    if (axisValue < 0.0f) {
                        z = b(customTextView, (int) Math.ceil((double) (-axisValue))) | false;
                    } else if (axisValue > 0.0f) {
                        z = c(customTextView, (int) Math.ceil((double) axisValue)) | false;
                    }
                    if (f2 < 0.0f) {
                        z |= d(customTextView, (int) Math.ceil((double) (-f2)));
                    } else if (f2 > 0.0f) {
                        z |= e(customTextView, (int) Math.ceil((double) f2));
                    }
                    AppMethodBeat.o(206076);
                    break;
            }
            return z;
        }
        AppMethodBeat.o(206076);
        return z;
    }

    private static int getMovementMetaState(Spannable spannable, KeyEvent keyEvent) {
        AppMethodBeat.i(206077);
        int normalizeMetaState = KeyEvent.normalizeMetaState(MetaKeyKeyListener.getMetaState(spannable, keyEvent) & -1537) & -194;
        AppMethodBeat.o(206077);
        return normalizeMetaState;
    }

    /* access modifiers changed from: protected */
    public boolean a(CustomTextView customTextView, Spannable spannable, int i2, int i3, KeyEvent keyEvent) {
        AppMethodBeat.i(206078);
        switch (i2) {
            case 19:
                if (KeyEvent.metaStateHasNoModifiers(i3)) {
                    boolean c2 = c(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return c2;
                } else if (KeyEvent.metaStateHasModifiers(i3, 2)) {
                    boolean g2 = g(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return g2;
                }
                break;
            case 20:
                if (KeyEvent.metaStateHasNoModifiers(i3)) {
                    boolean d2 = d(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return d2;
                } else if (KeyEvent.metaStateHasModifiers(i3, 2)) {
                    boolean h2 = h(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return h2;
                }
                break;
            case 21:
                if (KeyEvent.metaStateHasNoModifiers(i3)) {
                    boolean a2 = a(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return a2;
                } else if (KeyEvent.metaStateHasModifiers(i3, 4096)) {
                    AppMethodBeat.o(206078);
                    return false;
                } else if (KeyEvent.metaStateHasModifiers(i3, 2)) {
                    boolean i4 = i(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return i4;
                }
                break;
            case 22:
                if (KeyEvent.metaStateHasNoModifiers(i3)) {
                    boolean b2 = b(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return b2;
                } else if (KeyEvent.metaStateHasModifiers(i3, 4096)) {
                    AppMethodBeat.o(206078);
                    return false;
                } else if (KeyEvent.metaStateHasModifiers(i3, 2)) {
                    boolean j2 = j(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return j2;
                }
                break;
            case 92:
                if (KeyEvent.metaStateHasNoModifiers(i3)) {
                    boolean e2 = e(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return e2;
                } else if (KeyEvent.metaStateHasModifiers(i3, 2)) {
                    boolean g3 = g(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return g3;
                }
                break;
            case PlayerException.EXCEPTION_IN_PAUSE /*{ENCODED_INT: 93}*/:
                if (KeyEvent.metaStateHasNoModifiers(i3)) {
                    boolean f2 = f(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return f2;
                } else if (KeyEvent.metaStateHasModifiers(i3, 2)) {
                    boolean h3 = h(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return h3;
                }
                break;
            case 122:
                if (KeyEvent.metaStateHasNoModifiers(i3)) {
                    boolean k = k(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return k;
                } else if (KeyEvent.metaStateHasModifiers(i3, 4096)) {
                    boolean g4 = g(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return g4;
                }
                break;
            case 123:
                if (KeyEvent.metaStateHasNoModifiers(i3)) {
                    boolean l = l(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return l;
                } else if (KeyEvent.metaStateHasModifiers(i3, 4096)) {
                    boolean h4 = h(customTextView, spannable);
                    AppMethodBeat.o(206078);
                    return h4;
                }
                break;
        }
        AppMethodBeat.o(206078);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean b(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean c(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean d(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean e(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean f(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean g(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean h(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean i(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean j(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean k(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean l(CustomTextView customTextView, Spannable spannable) {
        return false;
    }

    static int e(CustomTextView customTextView) {
        AppMethodBeat.i(206079);
        int lineForVertical = customTextView.getLayout().getLineForVertical(customTextView.getScrollY());
        AppMethodBeat.o(206079);
        return lineForVertical;
    }

    static int f(CustomTextView customTextView) {
        AppMethodBeat.i(206080);
        int lineForVertical = customTextView.getLayout().getLineForVertical(customTextView.getScrollY() + h(customTextView));
        AppMethodBeat.o(206080);
        return lineForVertical;
    }

    static int g(CustomTextView customTextView) {
        AppMethodBeat.i(206081);
        int width = (customTextView.getWidth() - customTextView.getTotalPaddingLeft()) - customTextView.getTotalPaddingRight();
        AppMethodBeat.o(206081);
        return width;
    }

    static int h(CustomTextView customTextView) {
        AppMethodBeat.i(206082);
        int height = (customTextView.getHeight() - customTextView.getTotalPaddingTop()) - customTextView.getTotalPaddingBottom();
        AppMethodBeat.o(206082);
        return height;
    }

    private static int i(CustomTextView customTextView) {
        AppMethodBeat.i(206083);
        int ceil = (int) Math.ceil((double) customTextView.getPaint().getFontSpacing());
        AppMethodBeat.o(206083);
        return ceil;
    }

    static int j(CustomTextView customTextView) {
        AppMethodBeat.i(206084);
        Layout layout = customTextView.getLayout();
        int e2 = e(customTextView);
        int f2 = f(customTextView);
        if (e2 > f2) {
            AppMethodBeat.o(206084);
            return 0;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = e2;
        while (i3 <= f2) {
            int floor = (int) Math.floor((double) layout.getLineLeft(i3));
            if (floor >= i2) {
                floor = i2;
            }
            i3++;
            i2 = floor;
        }
        AppMethodBeat.o(206084);
        return i2;
    }

    static int k(CustomTextView customTextView) {
        AppMethodBeat.i(206085);
        Layout layout = customTextView.getLayout();
        int e2 = e(customTextView);
        int f2 = f(customTextView);
        if (e2 > f2) {
            AppMethodBeat.o(206085);
            return 0;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = e2;
        while (i3 <= f2) {
            int ceil = (int) Math.ceil((double) layout.getLineRight(i3));
            if (ceil <= i2) {
                ceil = i2;
            }
            i3++;
            i2 = ceil;
        }
        AppMethodBeat.o(206085);
        return i2;
    }

    /* access modifiers changed from: protected */
    public final boolean b(CustomTextView customTextView, int i2) {
        AppMethodBeat.i(206086);
        int j2 = j(customTextView);
        int scrollX = customTextView.getScrollX();
        if (scrollX > j2) {
            customTextView.scrollTo(Math.max(scrollX - (i(customTextView) * i2), j2), customTextView.getScrollY());
            AppMethodBeat.o(206086);
            return true;
        }
        AppMethodBeat.o(206086);
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean c(CustomTextView customTextView, int i2) {
        AppMethodBeat.i(206087);
        int k = k(customTextView) - g(customTextView);
        int scrollX = customTextView.getScrollX();
        if (scrollX < k) {
            customTextView.scrollTo(Math.min(scrollX + (i(customTextView) * i2), k), customTextView.getScrollY());
            AppMethodBeat.o(206087);
            return true;
        }
        AppMethodBeat.o(206087);
        return false;
    }

    protected static boolean d(CustomTextView customTextView, int i2) {
        AppMethodBeat.i(206088);
        Layout layout = customTextView.getLayout();
        int scrollY = customTextView.getScrollY();
        int lineForVertical = layout.getLineForVertical(scrollY);
        if (layout.getLineTop(lineForVertical) == scrollY) {
            lineForVertical--;
        }
        if (lineForVertical >= 0) {
            f.a(customTextView, layout, customTextView.getScrollX(), layout.getLineTop(Math.max((lineForVertical - i2) + 1, 0)));
            AppMethodBeat.o(206088);
            return true;
        }
        AppMethodBeat.o(206088);
        return false;
    }

    protected static boolean e(CustomTextView customTextView, int i2) {
        AppMethodBeat.i(206089);
        Layout layout = customTextView.getLayout();
        int h2 = h(customTextView);
        int scrollY = customTextView.getScrollY() + h2;
        int lineForVertical = layout.getLineForVertical(scrollY);
        if (layout.getLineTop(lineForVertical + 1) < scrollY + 1) {
            lineForVertical++;
        }
        int lineCount = layout.getLineCount() - 1;
        if (lineForVertical <= lineCount) {
            f.a(customTextView, layout, customTextView.getScrollX(), layout.getLineTop(Math.min((lineForVertical + i2) - 1, lineCount) + 1) - h2);
            AppMethodBeat.o(206089);
            return true;
        }
        AppMethodBeat.o(206089);
        return false;
    }
}
