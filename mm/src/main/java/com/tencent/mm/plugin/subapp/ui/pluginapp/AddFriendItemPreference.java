package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendItemPreference extends Preference {
    private String Bgn;
    private int CZk;
    int CZl;
    private Context context;
    private Drawable drawable;
    private int height;

    public AddFriendItemPreference(Context context2) {
        this(context2, null);
    }

    public AddFriendItemPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public AddFriendItemPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(29182);
        this.Bgn = "";
        this.CZk = -1;
        this.CZl = 8;
        this.height = -1;
        this.context = context2;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(29182);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(29183);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b8y, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), viewGroup2.getPaddingRight(), viewGroup2.getPaddingBottom());
        AppMethodBeat.o(29183);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(29184);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.dvz);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.Xw != null) {
                imageView.setImageDrawable(this.Xw);
                imageView.setVisibility(0);
            } else if (this.aeN != 0) {
                imageView.setImageResource(this.aeN);
                imageView.setVisibility(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fg1);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(R.id.ikq);
        if (textView != null) {
            textView.setVisibility(this.CZl);
            textView.setText(this.Bgn);
            if (this.CZk != -1) {
                textView.setBackgroundDrawable(a.l(this.context, this.CZk));
            }
        }
        AppMethodBeat.o(29184);
    }
}
