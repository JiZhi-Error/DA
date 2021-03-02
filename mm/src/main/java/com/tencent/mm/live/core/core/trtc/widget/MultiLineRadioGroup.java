package com.tencent.mm.live.core.core.trtc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MultiLineRadioGroup extends LinearLayout {
    private int hCc;
    private CompoundButton.OnCheckedChangeListener hCd;
    private boolean hCe;
    private b hCf;
    private c hCg;

    public interface b {
    }

    static /* synthetic */ void a(MultiLineRadioGroup multiLineRadioGroup, int i2) {
        AppMethodBeat.i(196324);
        multiLineRadioGroup.c(i2, false);
        AppMethodBeat.o(196324);
    }

    static /* synthetic */ void b(MultiLineRadioGroup multiLineRadioGroup, int i2) {
        AppMethodBeat.i(196325);
        multiLineRadioGroup.setCheckedId(i2);
        AppMethodBeat.o(196325);
    }

    public MultiLineRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(196311);
        this.hCc = -1;
        this.hCe = false;
        this.hCc = -1;
        setOrientation(1);
        this.hCd = new a(this, (byte) 0);
        this.hCg = new c(this, (byte) 0);
        super.setOnHierarchyChangeListener(this.hCg);
        AppMethodBeat.o(196311);
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        AppMethodBeat.i(196312);
        this.hCg.qy = onHierarchyChangeListener;
        AppMethodBeat.o(196312);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(196313);
        super.onFinishInflate();
        if (this.hCc != -1) {
            this.hCe = true;
            c(this.hCc, true);
            this.hCe = false;
            setCheckedId(this.hCc);
        }
        AppMethodBeat.o(196313);
    }

    @Override // android.view.ViewGroup
    public void addView(final View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(196314);
        if (view instanceof RadioButton) {
            view.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.live.core.core.trtc.widget.MultiLineRadioGroup.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(196305);
                    ((RadioButton) view).setChecked(true);
                    MultiLineRadioGroup.a(MultiLineRadioGroup.this, (RadioButton) view);
                    if (MultiLineRadioGroup.this.hCf != null) {
                        b unused = MultiLineRadioGroup.this.hCf;
                        view.getId();
                    }
                    AppMethodBeat.o(196305);
                    return true;
                }
            });
        } else if (view instanceof LinearLayout) {
            int childCount = ((LinearLayout) view).getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = ((LinearLayout) view).getChildAt(i3);
                if (childAt instanceof RadioButton) {
                    final RadioButton radioButton = (RadioButton) childAt;
                    radioButton.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.live.core.core.trtc.widget.MultiLineRadioGroup.AnonymousClass2 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(196306);
                            radioButton.setChecked(true);
                            MultiLineRadioGroup.a(MultiLineRadioGroup.this, radioButton);
                            if (MultiLineRadioGroup.this.hCf != null) {
                                b unused = MultiLineRadioGroup.this.hCf;
                                radioButton.getId();
                            }
                            AppMethodBeat.o(196306);
                            return true;
                        }
                    });
                }
            }
        }
        super.addView(view, i2, layoutParams);
        AppMethodBeat.o(196314);
    }

    private void setCheckedId(int i2) {
        this.hCc = i2;
    }

    private void c(int i2, boolean z) {
        AppMethodBeat.i(196315);
        View findViewById = findViewById(i2);
        if (findViewById != null && (findViewById instanceof RadioButton)) {
            ((RadioButton) findViewById).setChecked(z);
        }
        AppMethodBeat.o(196315);
    }

    public int getCheckedRadioButtonId() {
        return this.hCc;
    }

    public void setOnCheckedChangeListener(b bVar) {
        this.hCf = bVar;
    }

    private LayoutParams h(AttributeSet attributeSet) {
        AppMethodBeat.i(196316);
        LayoutParams layoutParams = new LayoutParams(getContext(), attributeSet);
        AppMethodBeat.o(196316);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.widget.LinearLayout
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(196317);
        LayoutParams layoutParams = new LayoutParams();
        AppMethodBeat.o(196317);
        return layoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(196318);
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MultiLineRadioGroup.class.getName());
        AppMethodBeat.o(196318);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(196319);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MultiLineRadioGroup.class.getName());
        AppMethodBeat.o(196319);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-2, -2);
        }

        /* access modifiers changed from: protected */
        public void setBaseAttributes(TypedArray typedArray, int i2, int i3) {
            AppMethodBeat.i(196308);
            if (typedArray.hasValue(i2)) {
                this.width = typedArray.getLayoutDimension(i2, "layout_width");
            } else {
                this.width = -2;
            }
            if (typedArray.hasValue(i3)) {
                this.height = typedArray.getLayoutDimension(i3, "layout_height");
                AppMethodBeat.o(196308);
                return;
            }
            this.height = -2;
            AppMethodBeat.o(196308);
        }
    }

    class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        /* synthetic */ a(MultiLineRadioGroup multiLineRadioGroup, byte b2) {
            this();
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.i(196307);
            if (MultiLineRadioGroup.this.hCe) {
                AppMethodBeat.o(196307);
                return;
            }
            MultiLineRadioGroup.this.hCe = true;
            if (MultiLineRadioGroup.this.hCc != -1) {
                MultiLineRadioGroup.a(MultiLineRadioGroup.this, MultiLineRadioGroup.this.hCc);
            }
            MultiLineRadioGroup.this.hCe = false;
            MultiLineRadioGroup.b(MultiLineRadioGroup.this, compoundButton.getId());
            AppMethodBeat.o(196307);
        }
    }

    class c implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener qy;

        private c() {
        }

        /* synthetic */ c(MultiLineRadioGroup multiLineRadioGroup, byte b2) {
            this();
        }

        public final void onChildViewAdded(View view, View view2) {
            AppMethodBeat.i(196309);
            if (view == MultiLineRadioGroup.this && (view2 instanceof RadioButton)) {
                if (view2.getId() == -1) {
                    view2.setId(view2.hashCode());
                }
                ((RadioButton) view2).setOnCheckedChangeListener(MultiLineRadioGroup.this.hCd);
            }
            if (this.qy != null) {
                this.qy.onChildViewAdded(view, view2);
            }
            AppMethodBeat.o(196309);
        }

        public final void onChildViewRemoved(View view, View view2) {
            AppMethodBeat.i(196310);
            if (view == MultiLineRadioGroup.this && (view2 instanceof RadioButton)) {
                ((RadioButton) view2).setOnCheckedChangeListener(null);
            }
            if (this.qy != null) {
                this.qy.onChildViewRemoved(view, view2);
            }
            AppMethodBeat.o(196310);
        }
    }

    static /* synthetic */ void a(MultiLineRadioGroup multiLineRadioGroup, RadioButton radioButton) {
        RadioButton radioButton2;
        AppMethodBeat.i(196323);
        int childCount = multiLineRadioGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = multiLineRadioGroup.getChildAt(i2);
            if (childAt instanceof RadioButton) {
                if (childAt != radioButton) {
                    ((RadioButton) childAt).setChecked(false);
                }
            } else if (childAt instanceof LinearLayout) {
                int childCount2 = ((LinearLayout) childAt).getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt2 = ((LinearLayout) childAt).getChildAt(i3);
                    if ((childAt2 instanceof RadioButton) && (radioButton2 = (RadioButton) childAt2) != radioButton) {
                        radioButton2.setChecked(false);
                    }
                }
            }
        }
        AppMethodBeat.o(196323);
    }
}
