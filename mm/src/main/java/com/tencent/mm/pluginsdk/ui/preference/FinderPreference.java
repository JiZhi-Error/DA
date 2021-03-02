package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.eoy;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class FinderPreference extends Preference {
    public static String NAME = "contact_profile_finder";
    private List<ImageView> Kpq;
    public eoy Kpr;
    private MMActivity gte;
    private String mTitle;
    private View zlc;

    public FinderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(232333);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(232333);
    }

    public FinderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(232334);
        this.mTitle = "";
        this.Kpq = new LinkedList();
        this.Kpr = null;
        this.gte = (MMActivity) context;
        this.mTitle = context.getString(R.string.ceo);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(232334);
    }

    private void grH() {
        AppMethodBeat.i(232335);
        for (ImageView imageView : this.Kpq) {
            imageView.setVisibility(8);
        }
        eoy eoy = this.Kpr;
        if (eoy != null && eoy.LNG == 0) {
            int size = eoy.LCW.size();
            int i2 = 0;
            while (i2 < size && i2 < this.Kpq.size()) {
                ImageView imageView2 = this.Kpq.get(i2);
                imageView2.setVisibility(0);
                ((aj) g.ah(aj.class)).getFinderUIApi().a(eoy.LCW.get(i2), imageView2);
                i2++;
            }
        }
        AppMethodBeat.o(232335);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(232336);
        if (this.zlc == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b96, viewGroup2);
            this.zlc = onCreateView;
        }
        View view = this.zlc;
        AppMethodBeat.o(232336);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(232337);
        super.onBindView(view);
        this.Kpq.clear();
        this.Kpq.add((ImageView) view.findViewById(R.id.dw0));
        this.Kpq.add((ImageView) view.findViewById(R.id.dw1));
        this.Kpq.add((ImageView) view.findViewById(R.id.dw2));
        this.Kpq.add((ImageView) view.findViewById(R.id.dw3));
        TextView textView = (TextView) view.findViewById(R.id.ld);
        if (!Util.isNullOrNil(this.mTitle)) {
            textView.setText(this.mTitle);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = a.aG(this.mContext, R.dimen.em);
            textView.setLayoutParams(layoutParams);
        }
        grH();
        AppMethodBeat.o(232337);
    }

    public final void a(eoy eoy) {
        AppMethodBeat.i(232338);
        this.Kpr = eoy;
        grH();
        AppMethodBeat.o(232338);
    }
}
