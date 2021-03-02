package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference extends Preference implements u.a {
    private Context context;
    private ImageView gBZ;
    private int iconHeight;
    private String iconUrl;
    private int iconWidth;
    private f screen;
    private String title;
    private TextView titleTv;

    public CategoryWithTitlePreference(Context context2) {
        this(context2, null);
    }

    public CategoryWithTitlePreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public CategoryWithTitlePreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(51780);
        this.title = "";
        this.iconWidth = 34;
        this.iconHeight = 34;
        setLayoutResource(R.layout.b8p);
        this.context = context2;
        u.a(this);
        AppMethodBeat.o(51780);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(51781);
        if (charSequence != null && charSequence.length() > 0) {
            this.title = charSequence.toString();
            if (this.titleTv != null) {
                this.titleTv.setVisibility(0);
                this.titleTv.setText(charSequence);
                Log.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + ((Object) this.titleTv.getText()));
            }
        } else if (this.titleTv != null) {
            this.titleTv.setVisibility(8);
        }
        super.setTitle(charSequence);
        AppMethodBeat.o(51781);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void setTitle(int i2) {
        AppMethodBeat.i(51782);
        if (this.titleTv != null) {
            if (this.context != null) {
                this.title = this.context.getString(i2);
            }
            if (!Util.isNullOrNil(this.title)) {
                this.titleTv.setVisibility(0);
                this.titleTv.setText(this.title);
            } else {
                this.titleTv.setVisibility(8);
            }
        }
        super.setTitle(i2);
        AppMethodBeat.o(51782);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        Bitmap a2;
        AppMethodBeat.i(51783);
        super.onBindView(view);
        this.titleTv = (TextView) view.findViewById(16908310);
        this.gBZ = (ImageView) view.findViewById(R.id.dt5);
        ViewGroup.LayoutParams layoutParams = this.gBZ.getLayoutParams();
        layoutParams.width = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, (float) (this.iconWidth / 2));
        layoutParams.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, (float) (this.iconHeight / 2));
        this.gBZ.setLayoutParams(layoutParams);
        if (!(this.title == null || this.title.length() <= 0 || this.titleTv == null)) {
            this.titleTv.setVisibility(0);
            this.titleTv.setText(this.title);
            Log.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + ((Object) this.titleTv.getText()));
        }
        if (!Util.isNullOrNil(this.iconUrl) && (a2 = u.a(new q(this.iconUrl))) != null && !a2.isRecycled()) {
            this.gBZ.setImageBitmap(a2);
            this.gBZ.setVisibility(0);
        }
        AppMethodBeat.o(51783);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, final Bitmap bitmap) {
        AppMethodBeat.i(51784);
        Log.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + str + ", iconurl:" + this.iconUrl);
        if (!Util.isNullOrNil(str) && str.equals(this.iconUrl) && bitmap != null && !bitmap.isRecycled() && this.gBZ != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.CategoryWithTitlePreference.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(51779);
                    CategoryWithTitlePreference.this.gBZ.setImageBitmap(bitmap);
                    CategoryWithTitlePreference.this.gBZ.setVisibility(0);
                    if (CategoryWithTitlePreference.this.screen != null) {
                        CategoryWithTitlePreference.this.screen.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(51779);
                }
            });
        }
        AppMethodBeat.o(51784);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final /* bridge */ /* synthetic */ CharSequence getTitle() {
        return this.title;
    }
}
