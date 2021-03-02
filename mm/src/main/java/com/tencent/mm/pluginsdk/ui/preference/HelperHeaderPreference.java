package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;

public class HelperHeaderPreference extends Preference {
    private a Kpu = new a();

    public static class a {
        public String dWq;
        public String gCv;
        public String hint;
        public int status;
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(152254);
        AppMethodBeat.o(152254);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(152255);
        AppMethodBeat.o(152255);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(152256);
        ImageView imageView = (ImageView) view.findViewById(R.id.x1);
        TextView textView = (TextView) view.findViewById(R.id.i5l);
        TextView textView2 = (TextView) view.findViewById(R.id.fzg);
        TextView textView3 = (TextView) view.findViewById(R.id.dpj);
        final View findViewById = view.findViewById(R.id.gkh);
        ((TextView) view.findViewById(R.id.ce_)).setText(R.string.cdc);
        if (imageView != null) {
            a.b.c(imageView, this.Kpu.dWq);
        }
        if (textView != null) {
            switch (this.Kpu.status) {
                case 0:
                    textView.setVisibility(0);
                    textView.setTextColor(u.kG(this.mContext));
                    textView.setText(R.string.gsy);
                    break;
                case 1:
                    textView.setVisibility(0);
                    textView.setTextColor(u.kF(this.mContext));
                    textView.setText(R.string.gsr);
                    break;
                case 2:
                    textView.setVisibility(8);
                    break;
            }
        }
        if (textView2 != null) {
            textView2.setText(this.Kpu.gCv);
        }
        if (textView3 != null) {
            textView3.setText(this.Kpu.hint);
        }
        super.onBindView(view);
        findViewById.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference.AnonymousClass1 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(152253);
                findViewById.getViewTreeObserver().removeOnPreDrawListener(this);
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(HelperHeaderPreference.this.mContext, 60);
                int statusBarHeight = au.getStatusBarHeight(HelperHeaderPreference.this.mContext);
                int eu = au.eu(HelperHeaderPreference.this.mContext);
                Log.i("MicroMsg.HelperHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", Integer.valueOf(eu), Integer.valueOf(statusBarHeight), Integer.valueOf(i2));
                if (statusBarHeight > 0 && eu > 0) {
                    fromDPToPix = com.tencent.mm.cb.a.aH(HelperHeaderPreference.this.mContext, R.dimen.cb) + eu;
                }
                if (i2 == 0) {
                    fromDPToPix += statusBarHeight;
                }
                if (fromDPToPix != findViewById.getPaddingTop()) {
                    findViewById.setPadding(findViewById.getPaddingLeft(), fromDPToPix, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
                    AppMethodBeat.o(152253);
                    return false;
                }
                AppMethodBeat.o(152253);
                return true;
            }
        });
        AppMethodBeat.o(152256);
    }

    public final void bk(String str, String str2, String str3) {
        AppMethodBeat.i(152257);
        this.Kpu.dWq = str;
        this.Kpu.gCv = str2;
        this.Kpu.hint = str3;
        super.callChangeListener(null);
        AppMethodBeat.o(152257);
    }

    public final void updateStatus(int i2) {
        AppMethodBeat.i(152258);
        this.Kpu.status = i2;
        super.callChangeListener(null);
        AppMethodBeat.o(152258);
    }
}
