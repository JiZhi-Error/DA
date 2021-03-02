package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.d;

public final class DialogPreference extends Preference {
    private final d OXA;
    a OXB;
    private Preference.a OXy;
    private d kdo;

    public interface a {
        void gLD();
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142532);
        this.OXA = new d(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.ChoicePreference, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            this.OXA.OXw = context.getResources().getStringArray(resourceId);
        }
        this.OXA.OXx = obtainStyledAttributes.getTextArray(1);
        obtainStyledAttributes.recycle();
        this.OXA.gLC();
        AppMethodBeat.o(142532);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void a(Preference.a aVar) {
        this.OXy = aVar;
    }

    public final String getValue() {
        return this.OXA.value;
    }

    public final void setValue(String str) {
        AppMethodBeat.i(142533);
        this.OXA.value = str;
        c cVar = this.OXA.values.get(str);
        if (cVar == null) {
            this.OXA.BaH = -1;
            AppMethodBeat.o(142533);
            return;
        }
        this.OXA.BaH = cVar.id;
        AppMethodBeat.o(142533);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142534);
        c cVar = this.OXA.values.get(this.OXA.value);
        if (cVar != null) {
            setSummary(cVar.text);
        }
        super.onBindView(view);
        AppMethodBeat.o(142534);
    }

    /* access modifiers changed from: protected */
    public final void showDialog() {
        AppMethodBeat.i(142535);
        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this.mContext, R.layout.b8c, null);
        listViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.base.preference.DialogPreference.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(142531);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/preference/DialogPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (DialogPreference.this.kdo != null) {
                    DialogPreference.this.kdo.dismiss();
                }
                DialogPreference.this.setValue((String) DialogPreference.this.OXA.OXx[i2]);
                if (DialogPreference.this.OXB != null) {
                    DialogPreference.this.OXB.gLD();
                }
                if (DialogPreference.this.OXy != null) {
                    DialogPreference.this.OXy.a(DialogPreference.this, DialogPreference.this.getValue());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/preference/DialogPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(142531);
            }
        });
        listViewInScrollView.setAdapter((ListAdapter) this.OXA);
        d.a aVar = new d.a(this.mContext);
        aVar.bon(getTitle().toString());
        aVar.hs(listViewInScrollView);
        this.kdo = aVar.hbn();
        this.kdo.show();
        h.a(this.mContext, this.kdo);
        AppMethodBeat.o(142535);
    }
}
