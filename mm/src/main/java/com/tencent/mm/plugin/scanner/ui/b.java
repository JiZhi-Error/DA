package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class b extends Preference implements u.a {
    private ImageView CJe = null;
    String CJf;
    private Context mContext;
    private View mView = null;
    f screen;

    public b(Context context) {
        super(context);
        AppMethodBeat.i(51677);
        setLayoutResource(R.layout.bip);
        u.a(this);
        this.mContext = context;
        AppMethodBeat.o(51677);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(51678);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(51678);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(51679);
        super.onBindView(view);
        this.CJe = (ImageView) view.findViewById(R.id.a2a);
        if (!Util.isNullOrNil(this.CJf)) {
            Bitmap a2 = u.a(new q(this.CJf));
            if (a2 == null || a2.isRecycled()) {
                this.CJe.setBackgroundColor(this.mContext.getResources().getColor(R.color.u9));
                this.CJe.setImageBitmap(null);
            } else {
                this.CJe.setImageBitmap(a2);
                this.CJe.setBackgroundColor(0);
                AppMethodBeat.o(51679);
                return;
            }
        }
        AppMethodBeat.o(51679);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, Bitmap bitmap) {
        AppMethodBeat.i(51680);
        if (!Util.isNullOrNil(str) && str.equals(this.CJf) && bitmap != null && !bitmap.isRecycled()) {
            this.CJe.setImageBitmap(bitmap);
            this.CJe.setBackgroundColor(0);
            if (this.screen != null) {
                this.screen.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(51680);
    }
}
