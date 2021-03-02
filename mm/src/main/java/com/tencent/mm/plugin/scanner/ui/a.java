package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a extends Preference implements u.a {
    private TextView CJb = null;
    String CJc = null;
    private ImageView lIM;
    private View mView = null;
    private f nRm;
    String rcG;

    public a(Context context) {
        super(context);
        AppMethodBeat.i(51673);
        setLayoutResource(R.layout.bo4);
        u.a(this);
        AppMethodBeat.o(51673);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(51674);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(51674);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        Bitmap a2;
        AppMethodBeat.i(51675);
        super.onBindView(view);
        this.CJb = (TextView) view.findViewById(R.id.br_);
        this.lIM = (ImageView) view.findViewById(R.id.ek);
        if (!Util.isNullOrNil(this.CJc)) {
            this.CJb.setText(this.CJc);
            this.CJb.setVisibility(0);
        } else {
            this.CJb.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.rcG) && (a2 = u.a(new q(this.rcG))) != null && !a2.isRecycled()) {
            this.lIM.setImageBitmap(a2);
            this.lIM.setVisibility(0);
        }
        AppMethodBeat.o(51675);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, final Bitmap bitmap) {
        AppMethodBeat.i(51676);
        if (!Util.isNullOrNil(str) && str.equals(this.rcG) && bitmap != null && !bitmap.isRecycled() && this.lIM != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(51672);
                    a.this.lIM.setImageBitmap(bitmap);
                    a.this.lIM.setVisibility(0);
                    if (a.this.nRm != null) {
                        a.this.nRm.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(51672);
                }
            });
        }
        AppMethodBeat.o(51676);
    }
}
