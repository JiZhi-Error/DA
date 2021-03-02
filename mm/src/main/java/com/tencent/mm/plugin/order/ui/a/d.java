package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    String mName;
    View.OnClickListener mOnClickListener;
    private View mView = null;
    String rcG;

    public d(Context context) {
        super(context);
        AppMethodBeat.i(66808);
        setLayoutResource(R.layout.b5s);
        AppMethodBeat.o(66808);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(66809);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(66809);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(66810);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.f7h);
        TextView textView = (TextView) view.findViewById(R.id.f7i);
        imageView.setImageBitmap(null);
        if (!Util.isNullOrNil(this.rcG)) {
            c.a aVar = new c.a();
            b.eBa();
            aVar.prefixPath = b.eeA();
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.iaT = true;
            q.bcV().a(this.rcG, imageView, aVar.bdv());
        }
        textView.setText(this.mName);
        view.findViewById(R.id.f7g).setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(66810);
    }
}
