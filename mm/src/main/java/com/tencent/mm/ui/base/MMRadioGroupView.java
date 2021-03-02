package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMRadioImageButton;

public class MMRadioGroupView extends LinearLayout {
    private int OSD = -1;
    private MMRadioImageButton.a OSE = new a();
    private b OSF;
    private c OSG = new c(this, (byte) 0);
    private MMRadioImageButton OSH;
    private d OSI;
    private int hCc = -1;

    public interface b {
    }

    public interface d {
    }

    static /* synthetic */ void a(MMRadioGroupView mMRadioGroupView, int i2) {
        AppMethodBeat.i(142111);
        mMRadioGroupView.c(i2, false);
        AppMethodBeat.o(142111);
    }

    static /* synthetic */ void a(MMRadioGroupView mMRadioGroupView, MMRadioImageButton mMRadioImageButton) {
        AppMethodBeat.i(142112);
        mMRadioGroupView.setCheckedButton(mMRadioImageButton);
        AppMethodBeat.o(142112);
    }

    static /* synthetic */ void b(MMRadioGroupView mMRadioGroupView, int i2) {
        AppMethodBeat.i(142113);
        mMRadioGroupView.setCheckedId(i2);
        AppMethodBeat.o(142113);
    }

    static /* synthetic */ void c(MMRadioGroupView mMRadioGroupView, int i2) {
        AppMethodBeat.i(142114);
        mMRadioGroupView.setClickedId(i2);
        AppMethodBeat.o(142114);
    }

    public MMRadioGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142106);
        super.setOnHierarchyChangeListener(this.OSG);
        AppMethodBeat.o(142106);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(142107);
        super.onFinishInflate();
        if (this.hCc != -1) {
            c(this.hCc, true);
            setCheckedId(this.hCc);
        }
        AppMethodBeat.o(142107);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(142108);
        if (view instanceof MMRadioImageButton) {
            MMRadioImageButton mMRadioImageButton = (MMRadioImageButton) view;
            if (mMRadioImageButton.isChecked()) {
                if (this.hCc != -1) {
                    c(this.hCc, false);
                }
                setCheckedId(mMRadioImageButton.getId());
                setCheckedButton(mMRadioImageButton);
            }
        }
        super.addView(view, i2, layoutParams);
        AppMethodBeat.o(142108);
    }

    private void c(int i2, boolean z) {
        AppMethodBeat.i(142109);
        View findViewById = findViewById(i2);
        if (findViewById != null && (findViewById instanceof MMRadioImageButton)) {
            ((MMRadioImageButton) findViewById).setChecked(z);
        }
        AppMethodBeat.o(142109);
    }

    private void setCheckedId(int i2) {
        this.hCc = i2;
    }

    private void setClickedId(int i2) {
        this.OSD = i2;
    }

    private void setCheckedButton(MMRadioImageButton mMRadioImageButton) {
        this.OSH = mMRadioImageButton;
    }

    public void setOnMMRadioGroupCheckedChangeListener(b bVar) {
        this.OSF = bVar;
    }

    public int getCheckedRadioButtonId() {
        return this.hCc;
    }

    public int getClickedRadioButtonId() {
        return this.OSD;
    }

    public MMRadioImageButton getCheckedRadioButton() {
        return this.OSH;
    }

    class a implements MMRadioImageButton.a {
        a() {
        }

        @Override // com.tencent.mm.ui.base.MMRadioImageButton.a
        public final void a(MMRadioImageButton mMRadioImageButton) {
            AppMethodBeat.i(142102);
            if (MMRadioGroupView.this.hCc != -1) {
                MMRadioGroupView.a(MMRadioGroupView.this, MMRadioGroupView.this.hCc);
            }
            int id = mMRadioImageButton.getId();
            MMRadioGroupView.a(MMRadioGroupView.this, mMRadioImageButton);
            MMRadioGroupView.b(MMRadioGroupView.this, id);
            AppMethodBeat.o(142102);
        }

        @Override // com.tencent.mm.ui.base.MMRadioImageButton.a
        public final void b(MMRadioImageButton mMRadioImageButton) {
            AppMethodBeat.i(142103);
            MMRadioGroupView.c(MMRadioGroupView.this, mMRadioImageButton.getId());
            AppMethodBeat.o(142103);
        }
    }

    class c implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener qy;

        private c() {
        }

        /* synthetic */ c(MMRadioGroupView mMRadioGroupView, byte b2) {
            this();
        }

        public final void onChildViewAdded(View view, View view2) {
            AppMethodBeat.i(142104);
            if (view == MMRadioGroupView.this && (view2 instanceof MMRadioImageButton)) {
                if (view2.getId() == -1) {
                    int hashCode = view2.hashCode();
                    if (hashCode < 0) {
                        hashCode &= Integer.MAX_VALUE;
                    }
                    view2.setId(hashCode);
                }
                ((MMRadioImageButton) view2).setOnOtherMMRadioButtonCheckedChangeListener(MMRadioGroupView.this.OSE);
            }
            if (this.qy != null) {
                this.qy.onChildViewAdded(view, view2);
            }
            AppMethodBeat.o(142104);
        }

        public final void onChildViewRemoved(View view, View view2) {
            AppMethodBeat.i(142105);
            if (view == MMRadioGroupView.this && (view2 instanceof MMRadioImageButton)) {
                ((MMRadioImageButton) view2).setOnOtherMMRadioButtonCheckedChangeListener(null);
            }
            if (this.qy != null) {
                this.qy.onChildViewRemoved(view, view2);
            }
            AppMethodBeat.o(142105);
        }
    }

    public void setOnSizeChangeObserver(d dVar) {
        this.OSI = dVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142110);
        super.onSizeChanged(i2, i3, i4, i5);
        AppMethodBeat.o(142110);
    }
}
