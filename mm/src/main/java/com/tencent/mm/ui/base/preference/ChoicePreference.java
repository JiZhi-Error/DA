package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference extends Preference {
    private int BaH;
    private RadioGroup OXv;
    private CharSequence[] OXw;
    private CharSequence[] OXx;
    public Preference.a OXy;
    String value;
    private final HashMap<CharSequence, b> values;

    public ChoicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChoicePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142523);
        this.values = new HashMap<>();
        this.BaH = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.ChoicePreference, i2, 0);
        this.OXw = obtainStyledAttributes.getTextArray(0);
        this.OXx = obtainStyledAttributes.getTextArray(1);
        obtainStyledAttributes.recycle();
        gLC();
        AppMethodBeat.o(142523);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void a(Preference.a aVar) {
        this.OXy = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142524);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.b94, viewGroup2);
        this.OXv = (RadioGroup) onCreateView.findViewById(R.id.dl9);
        for (int i2 = 0; i2 < this.OXx.length; i2++) {
            b bVar = this.values.get(this.OXx[i2]);
            if (bVar != null) {
                if (i2 == 0) {
                    RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.b7u, (ViewGroup) null);
                    bVar.a(radioButton);
                    this.OXv.addView(radioButton);
                } else if (i2 == this.OXx.length - 1) {
                    RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.b7w, (ViewGroup) null);
                    bVar.a(radioButton2);
                    this.OXv.addView(radioButton2);
                } else {
                    RadioButton radioButton3 = (RadioButton) layoutInflater.inflate(R.layout.b7v, (ViewGroup) null);
                    bVar.a(radioButton3);
                    this.OXv.addView(radioButton3);
                }
            }
        }
        this.OXv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.tencent.mm.ui.base.preference.ChoicePreference.AnonymousClass1 */

            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                AppMethodBeat.i(142522);
                if (ChoicePreference.this.OXy != null) {
                    if (i2 != -1) {
                        ChoicePreference.this.value = new StringBuilder().append((Object) ChoicePreference.this.OXx[i2 - 1048576]).toString();
                    } else {
                        ChoicePreference.this.value = null;
                    }
                    ChoicePreference.this.BaH = i2;
                    ChoicePreference.this.OXy.a(ChoicePreference.this, ChoicePreference.this.value);
                }
                AppMethodBeat.o(142522);
            }
        });
        AppMethodBeat.o(142524);
        return onCreateView;
    }

    private void gLC() {
        AppMethodBeat.i(142525);
        if (this.OXw == null) {
            this.OXw = new CharSequence[0];
        }
        if (this.OXx == null) {
            this.OXx = new CharSequence[0];
        }
        Assert.assertTrue("entries count different", this.OXw.length == this.OXx.length);
        this.values.clear();
        for (int i2 = 0; i2 < this.OXx.length; i2++) {
            this.values.put(this.OXx[i2], new b(this.OXw[i2], 1048576 + i2));
        }
        AppMethodBeat.o(142525);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142526);
        super.onBindView(view);
        if (this.OXv != null) {
            this.OXv.check(this.BaH);
        }
        AppMethodBeat.o(142526);
    }

    public final void setValue(String str) {
        AppMethodBeat.i(142527);
        this.value = str;
        b bVar = this.values.get(str);
        if (bVar == null) {
            this.BaH = -1;
            AppMethodBeat.o(142527);
            return;
        }
        this.BaH = bVar.id;
        AppMethodBeat.o(142527);
    }
}
