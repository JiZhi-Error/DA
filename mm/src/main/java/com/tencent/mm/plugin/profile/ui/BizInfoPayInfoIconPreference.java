package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class BizInfoPayInfoIconPreference extends Preference {
    private LinearLayout Bdo;
    private List<String> Bdp;
    private int Bdq;
    private LayoutInflater mInflater;

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(26936);
        this.Bdq = -1;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(26936);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(26937);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        this.mInflater.inflate(R.layout.xt, viewGroup2);
        AppMethodBeat.o(26937);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(26938);
        super.onBindView(view);
        this.Bdo = (LinearLayout) view.findViewById(R.id.ied);
        updateView();
        AppMethodBeat.o(26938);
    }

    public final void UA(int i2) {
        AppMethodBeat.i(26939);
        if (i2 == this.Bdq) {
            AppMethodBeat.o(26939);
            return;
        }
        this.Bdq = i2;
        updateView();
        AppMethodBeat.o(26939);
    }

    public final void fR(List<String> list) {
        AppMethodBeat.i(26940);
        this.Bdp = list;
        updateView();
        AppMethodBeat.o(26940);
    }

    private void updateView() {
        AppMethodBeat.i(26941);
        if (this.Bdo == null) {
            AppMethodBeat.o(26941);
            return;
        }
        this.Bdo.removeAllViews();
        if (this.Bdq >= 0) {
            int i2 = this.Bdq;
            for (int i3 = 0; i3 < 5; i3++) {
                if (i2 <= 0) {
                    UB(R.raw.biz_info_brand_unselect);
                } else if (i2 <= 10) {
                    UB(R.raw.biz_info_brand_half_selected);
                    i2 -= 20;
                } else {
                    UB(R.raw.biz_info_brand_selected);
                    i2 -= 20;
                }
            }
            AppMethodBeat.o(26941);
            return;
        }
        if (this.Bdp != null) {
            for (String str : this.Bdp) {
                aKn(str);
            }
        }
        AppMethodBeat.o(26941);
    }

    private void UB(int i2) {
        AppMethodBeat.i(26942);
        ImageView imageView = (ImageView) this.mInflater.inflate(R.layout.wg, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
        layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
        imageView.setImageResource(i2);
        this.Bdo.addView(imageView, layoutParams);
        AppMethodBeat.o(26942);
    }

    private void aKn(String str) {
        AppMethodBeat.i(26943);
        CdnImageView cdnImageView = new CdnImageView(this.mContext);
        cdnImageView.setUrl(str);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
        layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
        this.Bdo.addView(cdnImageView, layoutParams);
        AppMethodBeat.o(26943);
    }
}
