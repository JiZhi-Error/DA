package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMAutoSwitchEditText;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView extends LinearLayout {
    private int Clf;
    private int OPG;
    private String OPH;
    private ArrayList<MMAutoSwitchEditText> OPI = new ArrayList<>();
    private c OPJ = new c(this, (byte) 0);
    private a OPK;
    private b OPL;
    private Context mContext;
    private int mScreenWidth;
    private int opk = 100;
    private int yDE;

    public interface a {
        void Tq(String str);
    }

    public interface b {
        void boW();
    }

    public void setOnInputFinished(a aVar) {
        this.OPK = aVar;
    }

    public void setOnTextChanged(b bVar) {
        this.OPL = bVar;
    }

    public String getText() {
        String str;
        AppMethodBeat.i(141869);
        String str2 = "";
        Iterator<MMAutoSwitchEditText> it = this.OPI.iterator();
        while (it.hasNext()) {
            MMAutoSwitchEditText next = it.next();
            if (!Util.isNullOrNil(next.getText().toString().trim())) {
                str = str2 + next.getText().toString().trim();
            } else {
                str = str2;
            }
            str2 = str;
        }
        AppMethodBeat.o(141869);
        return str2;
    }

    public MMAutoSwitchEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141870);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.AutoSwitchLayout);
        this.OPG = obtainStyledAttributes.getInteger(0, 3);
        this.yDE = obtainStyledAttributes.getInteger(3, 4);
        this.Clf = obtainStyledAttributes.getInteger(2, 2);
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            this.OPH = context.getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (context instanceof Activity) {
            this.mScreenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
            this.opk = ((this.mScreenWidth - 80) - ((this.OPG - 1) * 20)) / this.OPG;
        }
        setPadding(com.tencent.mm.cb.a.fromDPToPix(context, 20), 0, com.tencent.mm.cb.a.fromDPToPix(context, 20), 0);
        gKE();
        AppMethodBeat.o(141870);
    }

    private void gKE() {
        AppMethodBeat.i(141871);
        for (int i2 = 0; i2 < this.OPG; i2++) {
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) View.inflate(this.mContext, R.layout.hg, null);
            mMAutoSwitchEditText.setInputType(this.Clf);
            if (this.OPH != null && this.OPH.length() > 0) {
                mMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.OPH));
            }
            mMAutoSwitchEditText.OPB.mIndex = i2;
            mMAutoSwitchEditText.OPB.OPF = this.yDE;
            mMAutoSwitchEditText.OPB.OPC = this.OPJ;
            mMAutoSwitchEditText.OPB.OPD = this.OPJ;
            mMAutoSwitchEditText.OPB.OPE = this.OPJ;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.opk, -2);
            if (i2 > 0) {
                layoutParams.leftMargin = 20;
            } else {
                layoutParams.leftMargin = 0;
            }
            layoutParams.weight = 1.0f;
            mMAutoSwitchEditText.setLayoutParams(layoutParams);
            this.OPI.add(mMAutoSwitchEditText);
            addView(mMAutoSwitchEditText);
        }
        AppMethodBeat.o(141871);
    }

    /* access modifiers changed from: package-private */
    public class c implements MMAutoSwitchEditText.b, MMAutoSwitchEditText.c, MMAutoSwitchEditText.d {
        private c() {
        }

        /* synthetic */ c(MMAutoSwitchEditTextView mMAutoSwitchEditTextView, byte b2) {
            this();
        }

        @Override // com.tencent.mm.ui.base.MMAutoSwitchEditText.c
        public final void alw(int i2) {
            MMAutoSwitchEditText mMAutoSwitchEditText;
            String str;
            AppMethodBeat.i(141866);
            String str2 = "";
            Iterator it = MMAutoSwitchEditTextView.this.OPI.iterator();
            while (it.hasNext()) {
                MMAutoSwitchEditText mMAutoSwitchEditText2 = (MMAutoSwitchEditText) it.next();
                if (!Util.isNullOrNil(mMAutoSwitchEditText2.getText().toString().trim())) {
                    str = str2 + mMAutoSwitchEditText2.getText().toString().trim();
                } else {
                    str = str2;
                }
                str2 = str;
            }
            if (Util.isNullOrNil(str2) || str2.length() != MMAutoSwitchEditTextView.this.OPG * MMAutoSwitchEditTextView.this.yDE) {
                if (MMAutoSwitchEditTextView.this.OPL != null) {
                    MMAutoSwitchEditTextView.this.OPL.boW();
                }
                if (!(MMAutoSwitchEditTextView.this.OPI == null || i2 >= MMAutoSwitchEditTextView.this.OPI.size() - 1 || (mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.this.OPI.get(i2 + 1)) == null)) {
                    mMAutoSwitchEditText.requestFocus();
                }
                AppMethodBeat.o(141866);
                return;
            }
            if (MMAutoSwitchEditTextView.this.OPK != null) {
                MMAutoSwitchEditTextView.this.OPK.Tq(str2);
            }
            AppMethodBeat.o(141866);
        }

        @Override // com.tencent.mm.ui.base.MMAutoSwitchEditText.b
        public final void alv(int i2) {
            AppMethodBeat.i(141867);
            if (MMAutoSwitchEditTextView.this.OPI != null && i2 < MMAutoSwitchEditTextView.this.OPI.size()) {
                if (i2 == 0) {
                    AppMethodBeat.o(141867);
                    return;
                }
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.this.OPI.get(i2 - 1);
                if (mMAutoSwitchEditText != null) {
                    mMAutoSwitchEditText.requestFocus();
                }
            }
            AppMethodBeat.o(141867);
        }

        @Override // com.tencent.mm.ui.base.MMAutoSwitchEditText.d
        public final void cCU() {
            String str;
            AppMethodBeat.i(141868);
            String str2 = "";
            Iterator it = MMAutoSwitchEditTextView.this.OPI.iterator();
            while (it.hasNext()) {
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (!Util.isNullOrNil(mMAutoSwitchEditText.getText().toString().trim())) {
                    str = str2 + mMAutoSwitchEditText.getText().toString().trim();
                } else {
                    str = str2;
                }
                str2 = str;
            }
            if (MMAutoSwitchEditTextView.this.OPL != null) {
                MMAutoSwitchEditTextView.this.OPL.boW();
            }
            AppMethodBeat.o(141868);
        }
    }
}
