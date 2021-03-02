package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class c extends Preference implements u.a {
    private TextView CKk = null;
    String CKl;
    String mContent;
    private TextView mPa = null;
    private View mView = null;
    String qnT;
    private ImageView qyu = null;
    private f screen;

    public c(Context context) {
        super(context);
        AppMethodBeat.i(51785);
        setLayoutResource(R.layout.bir);
        u.a(this);
        AppMethodBeat.o(51785);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(51786);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(51786);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(51787);
        super.onBindView(view);
        this.qyu = (ImageView) view.findViewById(R.id.b8i);
        this.mPa = (TextView) view.findViewById(R.id.b99);
        this.CKk = (TextView) view.findViewById(R.id.b8l);
        if (!Util.isNullOrNil(this.CKl)) {
            Bitmap a2 = u.a(new q(this.CKl));
            if (a2 == null || a2.isRecycled()) {
                try {
                    this.qyu.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null)));
                } catch (IOException e2) {
                    this.qyu.setImageBitmap(null);
                }
            } else {
                this.qyu.setImageBitmap(a2);
                this.qyu.setBackgroundColor(0);
            }
        } else {
            this.qyu.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.qnT)) {
            this.mPa.setText(l.b(this.mContext, this.qnT, this.mPa.getTextSize()));
        } else {
            this.mPa.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.mContent)) {
            this.CKk.setText(this.mContent);
        } else {
            this.CKk.setVisibility(8);
        }
        if (Util.isNullOrNil(this.qnT) && Util.isNullOrNil(this.CKl)) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.b8k);
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.ag5);
            linearLayout.setPadding(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 9.0f), 0, 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(51787);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, Bitmap bitmap) {
        AppMethodBeat.i(51788);
        if (!Util.isNullOrNil(str) && str.equals(this.CKl) && bitmap != null && !bitmap.isRecycled()) {
            this.qyu.setImageBitmap(bitmap);
            this.qyu.setBackgroundColor(0);
            if (this.screen != null) {
                this.screen.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(51788);
    }
}
