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
import java.util.List;

public class ServicePreference extends Preference {
    List<g> Dcn;
    b FML;
    AdapterView.OnItemClickListener FMs;
    private AdapterView.OnItemClickListener FMt;
    private View.OnClickListener FMu;
    private int FMv;
    private int FMw;
    private Context context;
    private boolean zgH;

    public ServicePreference(Context context2) {
        this(context2, null);
    }

    public ServicePreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public ServicePreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(29177);
        this.FMs = null;
        this.FMt = null;
        this.FMu = null;
        this.zgH = false;
        this.FMw = 0;
        this.context = context2;
        setLayoutResource(R.layout.gg);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.a.AppPreference);
        this.FMv = obtainStyledAttributes.getInt(0, 8);
        this.zgH = obtainStyledAttributes.getBoolean(1, false);
        this.FMw = obtainStyledAttributes.getResourceId(2, 0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(29177);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(29178);
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.id.dl8);
        if (mMGridView == null) {
            AppMethodBeat.o(29178);
            return;
        }
        this.FML = new b(this.context, this.Dcn);
        ao.eAS().remove(this.FML);
        ao.eAS().add(this.FML);
        mMGridView.setAdapter((ListAdapter) this.FML);
        mMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(29175);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/subapp/ui/openapi/ServicePreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (ServicePreference.this.FML.Ox(i2)) {
                    ServicePreference.this.FML.we(false);
                    a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServicePreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(29175);
                    return;
                }
                if (ServicePreference.this.FML.FMo) {
                    if (ServicePreference.this.FMt != null) {
                        ServicePreference.this.FMt.onItemClick(adapterView, view, i2, j2);
                    }
                } else if (ServicePreference.this.FMs != null) {
                    ServicePreference.this.FMs.onItemClick(adapterView, view, i2, j2);
                }
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServicePreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29175);
            }
        });
        if (this.zgH) {
            mMGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference.AnonymousClass2 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    boolean z;
                    AppMethodBeat.i(29176);
                    ServicePreference servicePreference = ServicePreference.this;
                    if (servicePreference.FML != null) {
                        b bVar = servicePreference.FML;
                        if (!servicePreference.FML.FMo) {
                            z = true;
                        } else {
                            z = false;
                        }
                        bVar.we(z);
                    }
                    AppMethodBeat.o(29176);
                    return true;
                }
            });
        }
        TextView textView = (TextView) view.findViewById(R.id.c3d);
        if (this.FML.getCount() == 0) {
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
        AppMethodBeat.o(29178);
    }

    public final g abn(int i2) {
        AppMethodBeat.i(29179);
        if (i2 < 0 || i2 >= this.FML.getCount()) {
            AppMethodBeat.o(29179);
            return null;
        }
        g gVar = (g) this.FML.getItem(i2);
        AppMethodBeat.o(29179);
        return gVar;
    }

    public final void onResume() {
        AppMethodBeat.i(29180);
        if (this.FML != null) {
            ao.eAS().add(this.FML);
        }
        AppMethodBeat.o(29180);
    }

    public final void onPause() {
        AppMethodBeat.i(29181);
        if (this.FML != null) {
            ao.eAS().remove(this.FML);
        }
        AppMethodBeat.o(29181);
    }
}
