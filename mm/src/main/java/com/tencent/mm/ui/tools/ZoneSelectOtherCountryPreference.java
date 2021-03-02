package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneSelectOtherCountryPreference extends Preference {
    a QxB;
    String text;

    public interface a {
        void onClick();
    }

    public ZoneSelectOtherCountryPreference(Context context) {
        this(context, null);
    }

    public ZoneSelectOtherCountryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneSelectOtherCountryPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(39217);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(39217);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(39218);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9s, viewGroup2);
        AppMethodBeat.o(39218);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(39219);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.jsn);
        if (!Util.isNullOrNil(this.text)) {
            textView.setText(this.text);
        }
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(39216);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ZoneSelectOtherCountryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ZoneSelectOtherCountryPreference.this.QxB != null) {
                    ZoneSelectOtherCountryPreference.this.QxB.onClick();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ZoneSelectOtherCountryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(39216);
            }
        });
        AppMethodBeat.o(39219);
    }
}
