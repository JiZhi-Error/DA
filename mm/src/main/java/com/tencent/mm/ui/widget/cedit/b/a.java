package com.tencent.mm.ui.widget.cedit.b;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.b.f;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;
import com.tencent.mm.ui.widget.cedit.util.d;

public final class a extends b implements d {
    private static final Object QLK = new Object();
    private static a QLL;

    private static boolean i(Spannable spannable) {
        AppMethodBeat.i(206053);
        if (MetaKeyKeyListener.getMetaState(spannable, 1) == 1 || MetaKeyKeyListener.getMetaState(spannable, 2048) != 0) {
            AppMethodBeat.o(206053);
            return true;
        }
        AppMethodBeat.o(206053);
        return false;
    }

    private static int a(Spannable spannable, Layout layout) {
        AppMethodBeat.i(206054);
        int lineTop = layout.getLineTop(layout.getLineForOffset(Selection.getSelectionEnd(spannable)));
        AppMethodBeat.o(206054);
        return lineTop;
    }

    private static int d(CustomTextView customTextView) {
        AppMethodBeat.i(206055);
        Rect rect = new Rect();
        if (customTextView.getGlobalVisibleRect(rect)) {
            int height = rect.height();
            AppMethodBeat.o(206055);
            return height;
        }
        AppMethodBeat.o(206055);
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean a(CustomTextView customTextView, Spannable spannable, int i2, int i3, KeyEvent keyEvent) {
        AppMethodBeat.i(206056);
        switch (i2) {
            case 23:
                if (KeyEvent.metaStateHasNoModifiers(i3) && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0 && MetaKeyKeyListener.getMetaState(spannable, 2048, keyEvent) != 0) {
                    boolean showContextMenu = customTextView.showContextMenu();
                    AppMethodBeat.o(206056);
                    return showContextMenu;
                }
        }
        boolean a2 = super.a(customTextView, spannable, i2, i3, keyEvent);
        AppMethodBeat.o(206056);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean a(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206057);
        Layout layout = customTextView.getLayout();
        if (i(spannable)) {
            boolean extendLeft = Selection.extendLeft(spannable, layout);
            AppMethodBeat.o(206057);
            return extendLeft;
        }
        boolean moveLeft = Selection.moveLeft(spannable, layout);
        AppMethodBeat.o(206057);
        return moveLeft;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean b(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206058);
        Layout layout = customTextView.getLayout();
        if (i(spannable)) {
            boolean extendRight = Selection.extendRight(spannable, layout);
            AppMethodBeat.o(206058);
            return extendRight;
        }
        boolean moveRight = Selection.moveRight(spannable, layout);
        AppMethodBeat.o(206058);
        return moveRight;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean c(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206059);
        Layout layout = customTextView.getLayout();
        if (i(spannable)) {
            boolean extendUp = Selection.extendUp(spannable, layout);
            AppMethodBeat.o(206059);
            return extendUp;
        }
        boolean moveUp = Selection.moveUp(spannable, layout);
        AppMethodBeat.o(206059);
        return moveUp;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean d(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206060);
        Layout layout = customTextView.getLayout();
        if (i(spannable)) {
            boolean extendDown = Selection.extendDown(spannable, layout);
            AppMethodBeat.o(206060);
            return extendDown;
        }
        boolean moveDown = Selection.moveDown(spannable, layout);
        AppMethodBeat.o(206060);
        return moveDown;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean e(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206061);
        Layout layout = customTextView.getLayout();
        boolean i2 = i(spannable);
        int a2 = a(spannable, layout) - d(customTextView);
        boolean z = false;
        do {
            int selectionEnd = Selection.getSelectionEnd(spannable);
            if (i2) {
                Selection.extendUp(spannable, layout);
            } else {
                Selection.moveUp(spannable, layout);
            }
            if (Selection.getSelectionEnd(spannable) == selectionEnd) {
                break;
            }
            z = true;
        } while (a(spannable, layout) > a2);
        AppMethodBeat.o(206061);
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean f(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206062);
        Layout layout = customTextView.getLayout();
        boolean i2 = i(spannable);
        int d2 = d(customTextView) + a(spannable, layout);
        boolean z = false;
        do {
            int selectionEnd = Selection.getSelectionEnd(spannable);
            if (i2) {
                Selection.extendDown(spannable, layout);
            } else {
                Selection.moveDown(spannable, layout);
            }
            if (Selection.getSelectionEnd(spannable) == selectionEnd) {
                break;
            }
            z = true;
        } while (a(spannable, layout) < d2);
        AppMethodBeat.o(206062);
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean g(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206063);
        if (i(spannable)) {
            Selection.extendSelection(spannable, 0);
        } else {
            Selection.setSelection(spannable, 0);
        }
        AppMethodBeat.o(206063);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean h(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206064);
        if (i(spannable)) {
            Selection.extendSelection(spannable, spannable.length());
        } else {
            Selection.setSelection(spannable, spannable.length());
        }
        AppMethodBeat.o(206064);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean i(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206065);
        Layout layout = customTextView.getLayout();
        if (i(spannable)) {
            boolean extendToLeftEdge = Selection.extendToLeftEdge(spannable, layout);
            AppMethodBeat.o(206065);
            return extendToLeftEdge;
        }
        boolean moveToLeftEdge = Selection.moveToLeftEdge(spannable, layout);
        AppMethodBeat.o(206065);
        return moveToLeftEdge;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean j(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206066);
        Layout layout = customTextView.getLayout();
        if (i(spannable)) {
            boolean extendToRightEdge = Selection.extendToRightEdge(spannable, layout);
            AppMethodBeat.o(206066);
            return extendToRightEdge;
        }
        boolean moveToRightEdge = Selection.moveToRightEdge(spannable, layout);
        AppMethodBeat.o(206066);
        return moveToRightEdge;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean k(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206067);
        boolean i2 = i(customTextView, spannable);
        AppMethodBeat.o(206067);
        return i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean l(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206068);
        boolean j2 = j(customTextView, spannable);
        AppMethodBeat.o(206068);
        return j2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.b, com.tencent.mm.ui.widget.cedit.b.d
    public final boolean a(CustomTextView customTextView, Spannable spannable, MotionEvent motionEvent) {
        int i2;
        int i3;
        int selectionStart;
        int i4;
        int i5 = -1;
        AppMethodBeat.i(206069);
        int action = motionEvent.getAction();
        if (action == 1) {
            f.a[] aVarArr = (f.a[]) spannable.getSpans(0, spannable.length(), f.a.class);
            i3 = aVarArr.length > 0 ? aVarArr[0].ovp : -1;
            f.a[] aVarArr2 = (f.a[]) spannable.getSpans(0, spannable.length(), f.a.class);
            if (aVarArr2.length > 0) {
                i5 = aVarArr2[0].ovq;
            }
            i2 = i5;
        } else {
            i2 = -1;
            i3 = -1;
        }
        boolean i6 = i(spannable);
        boolean a2 = f.a(customTextView, spannable, motionEvent);
        if (customTextView.didTouchFocusSelect()) {
            AppMethodBeat.o(206069);
            return a2;
        }
        if (action == 0) {
            if (i(spannable)) {
                if (customTextView.isFocused() || customTextView.requestFocus()) {
                    int offsetForPosition = customTextView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    spannable.setSpan(QLK, offsetForPosition, offsetForPosition, 34);
                    customTextView.getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    AppMethodBeat.o(206069);
                    return a2;
                }
            }
        } else if (customTextView.isFocused()) {
            if (action == 2) {
                if (i(spannable) && a2) {
                    int spanStart = spannable.getSpanStart(QLK);
                    customTextView.cancelLongPress();
                    int offsetForPosition2 = customTextView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    Selection.setSelection(spannable, Math.min(spanStart, offsetForPosition2), Math.max(spanStart, offsetForPosition2));
                    AppMethodBeat.o(206069);
                    return true;
                }
            } else if (action == 1) {
                if ((i2 < 0 || i2 == customTextView.getScrollY()) && (i3 < 0 || i3 == customTextView.getScrollX())) {
                    if (i6) {
                        int spanStart2 = spannable.getSpanStart(QLK);
                        int offsetForPosition3 = customTextView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                        Selection.setSelection(spannable, Math.min(spanStart2, offsetForPosition3), Math.max(spanStart2, offsetForPosition3));
                        spannable.removeSpan(QLK);
                    }
                    MetaKeyKeyListener.adjustMetaAfterKeypress(spannable);
                    d.resetLockedMeta(spannable);
                    AppMethodBeat.o(206069);
                    return true;
                }
                if ((customTextView.mText instanceof Spannable) && (selectionStart = customTextView.getSelectionStart()) == customTextView.getSelectionEnd()) {
                    int lineForOffset = customTextView.OVt.getLineForOffset(selectionStart);
                    int lineTop = customTextView.OVt.getLineTop(lineForOffset);
                    int lineTop2 = customTextView.OVt.getLineTop(lineForOffset + 1);
                    int bottom = ((customTextView.getBottom() - customTextView.getTop()) - customTextView.getExtendedPaddingTop()) - customTextView.getExtendedPaddingBottom();
                    int i7 = (lineTop2 - lineTop) / 2;
                    if (i7 > bottom / 4) {
                        i7 = bottom / 4;
                    }
                    int scrollY = customTextView.getScrollY();
                    if (lineTop < scrollY + i7) {
                        i4 = customTextView.OVt.getLineForVertical(i7 + scrollY + (lineTop2 - lineTop));
                    } else if (lineTop2 > (bottom + scrollY) - i7) {
                        i4 = customTextView.OVt.getLineForVertical(((bottom + scrollY) - i7) - (lineTop2 - lineTop));
                    } else {
                        i4 = lineForOffset;
                    }
                    int right = ((customTextView.getRight() - customTextView.getLeft()) - customTextView.getCompoundPaddingLeft()) - customTextView.getCompoundPaddingRight();
                    int scrollX = customTextView.getScrollX();
                    int offsetForHorizontal = customTextView.OVt.getOffsetForHorizontal(i4, (float) scrollX);
                    int offsetForHorizontal2 = customTextView.OVt.getOffsetForHorizontal(i4, (float) (right + scrollX));
                    int i8 = offsetForHorizontal < offsetForHorizontal2 ? offsetForHorizontal : offsetForHorizontal2;
                    if (offsetForHorizontal <= offsetForHorizontal2) {
                        offsetForHorizontal = offsetForHorizontal2;
                    }
                    if (selectionStart >= i8) {
                        if (selectionStart > offsetForHorizontal) {
                            i8 = offsetForHorizontal;
                        } else {
                            i8 = selectionStart;
                        }
                    }
                    if (i8 != selectionStart) {
                        Selection.setSelection(customTextView.QGC, i8);
                    }
                }
                AppMethodBeat.o(206069);
                return true;
            }
        }
        AppMethodBeat.o(206069);
        return a2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.b, com.tencent.mm.ui.widget.cedit.b.d
    public final boolean canSelectArbitrarily() {
        return true;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.b, com.tencent.mm.ui.widget.cedit.b.d
    public final void j(Spannable spannable) {
        AppMethodBeat.i(206070);
        Selection.setSelection(spannable, 0);
        AppMethodBeat.o(206070);
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.b, com.tencent.mm.ui.widget.cedit.b.d
    public final void a(CustomTextView customTextView, Spannable spannable, int i2) {
        AppMethodBeat.i(206071);
        if ((i2 & 130) == 0 || customTextView.getLayout() == null) {
            Selection.setSelection(spannable, spannable.length());
        }
        AppMethodBeat.o(206071);
    }

    public static d haX() {
        AppMethodBeat.i(206072);
        if (QLL == null) {
            QLL = new a();
        }
        a aVar = QLL;
        AppMethodBeat.o(206072);
        return aVar;
    }

    static {
        AppMethodBeat.i(206073);
        AppMethodBeat.o(206073);
    }
}
