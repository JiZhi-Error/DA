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
import com.tencent.mm.protocal.protobuf.eoz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class FinderRecentLikePreference extends Preference {
    private List<ImageView> Kpq;
    private eoz Kps;
    private MMActivity gte;
    private String mTitle;
    private View zlc;

    public FinderRecentLikePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(232339);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(232339);
    }

    public FinderRecentLikePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(232340);
        this.mTitle = "";
        this.Kpq = new LinkedList();
        this.Kps = null;
        this.gte = (MMActivity) context;
        this.mTitle = context.getString(R.string.cf9);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(232340);
    }

    private void grH() {
        AppMethodBeat.i(232341);
        for (ImageView imageView : this.Kpq) {
            imageView.setVisibility(8);
        }
        eoz eoz = this.Kps;
        if (eoz != null) {
            int size = eoz.LCW.size();
            int i2 = 0;
            while (i2 < size && i2 < this.Kpq.size()) {
                ImageView imageView2 = this.Kpq.get(i2);
                imageView2.setVisibility(0);
                ((aj) g.ah(aj.class)).getFinderUIApi().a(eoz.LCW.get(i2), imageView2);
                i2++;
            }
        }
        AppMethodBeat.o(232341);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(232342);
        if (this.zlc == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b96, viewGroup2);
            this.zlc = onCreateView;
        }
        View view = this.zlc;
        AppMethodBeat.o(232342);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(232343);
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
        AppMethodBeat.o(232343);
    }

    public final void a(eoz eoz) {
        AppMethodBeat.i(232344);
        this.Kps = eoz;
        grH();
        AppMethodBeat.o(232344);
    }
}
