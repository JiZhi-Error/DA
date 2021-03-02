package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.Preference;

public final class c extends Preference {
    private TextView ALg;
    private ImageView AQx;
    String AQy = "";
    Bitmap iKs = null;
    View.OnClickListener mOnClickListener;
    private View mView = null;

    public c(Context context) {
        super(context);
        AppMethodBeat.i(66805);
        setLayoutResource(R.layout.b5r);
        AppMethodBeat.o(66805);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(66806);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(66806);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(66807);
        super.onBindView(view);
        this.ALg = (TextView) view.findViewById(R.id.f7f);
        this.AQx = (ImageView) view.findViewById(R.id.f7e);
        this.ALg.setText(this.AQy);
        this.AQx.setImageBitmap(this.iKs);
        this.AQx.setOnClickListener(this.mOnClickListener);
        if (this.AQy != null && this.AQy.length() > 48) {
            this.ALg.setTextSize(0, (float) a.aG(this.mContext, R.dimen.hc));
        }
        AppMethodBeat.o(66807);
    }
}
