package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;

public class AppPreference extends Preference {
    int FMp;
    a FMr;
    AdapterView.OnItemClickListener FMs;
    AdapterView.OnItemClickListener FMt;
    private View.OnClickListener FMu;
    private int FMv;
    private int FMw;
    private Context context;
    private boolean zgH;

    public AppPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public AppPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(29137);
        this.FMs = null;
        this.FMt = null;
        this.FMu = null;
        this.FMp = 0;
        this.zgH = false;
        this.FMw = 0;
        this.context = context2;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.a.AppPreference);
        this.FMv = obtainStyledAttributes.getInt(0, 8);
        this.zgH = obtainStyledAttributes.getBoolean(1, false);
        this.FMw = obtainStyledAttributes.getResourceId(2, 0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(29137);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(29138);
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.id.dl8);
        this.FMr = new a(this.context, this.FMp);
        mMGridView.setAdapter((ListAdapter) this.FMr);
        mMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.openapi.AppPreference.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(29135);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/subapp/ui/openapi/AppPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (AppPreference.this.FMr.Ox(i2)) {
                    AppPreference.this.FMr.we(false);
                    a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AppPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(29135);
                    return;
                }
                if (AppPreference.this.FMr.FMo) {
                    if (AppPreference.this.FMt != null) {
                        AppPreference.this.FMt.onItemClick(adapterView, view, i2, j2);
                    }
                } else if (AppPreference.this.FMs != null) {
                    AppPreference.this.FMs.onItemClick(adapterView, view, i2, j2);
                }
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AppPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29135);
            }
        });
        if (this.zgH) {
            mMGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.plugin.subapp.ui.openapi.AppPreference.AnonymousClass2 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    boolean z;
                    AppMethodBeat.i(29136);
                    AppPreference appPreference = AppPreference.this;
                    if (appPreference.FMr != null) {
                        a aVar = appPreference.FMr;
                        if (!appPreference.FMr.FMo) {
                            z = true;
                        } else {
                            z = false;
                        }
                        aVar.we(z);
                    }
                    AppMethodBeat.o(29136);
                    return true;
                }
            });
        }
        TextView textView = (TextView) view.findViewById(R.id.c3d);
        if (this.FMr.getCount() == 0) {
            textView.setVisibility(0);
            textView.setText(this.FMw);
            mMGridView.setVisibility(8);
        } else {
            textView.setVisibility(8);
            mMGridView.setVisibility(0);
        }
        Button button = (Button) view.findViewById(R.id.ae_);
        button.setVisibility(this.FMv);
        button.setOnClickListener(this.FMu);
        AppMethodBeat.o(29138);
    }

    public final g abn(int i2) {
        AppMethodBeat.i(29139);
        if (i2 < 0 || i2 >= this.FMr.getCount()) {
            AppMethodBeat.o(29139);
            return null;
        }
        g gVar = (g) this.FMr.getItem(i2);
        AppMethodBeat.o(29139);
        return gVar;
    }

    public final void onResume() {
        AppMethodBeat.i(29140);
        if (this.FMr != null) {
            ao.eAS().add(this.FMr);
        }
        AppMethodBeat.o(29140);
    }

    public final void onPause() {
        AppMethodBeat.i(29141);
        if (this.FMr != null) {
            ao.eAS().remove(this.FMr);
        }
        AppMethodBeat.o(29141);
    }
}
