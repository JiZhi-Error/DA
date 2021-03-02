package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;

public abstract class CardDetailBaseUI extends MMActivity {
    private TextView mPa;
    private ImageView nZa;
    private View nZg;
    private TextView pYW;
    private ImageView pYX;
    private View pYY;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        int dimensionPixelSize;
        super.onCreate(bundle);
        this.nZg = aa.jQ(getContext()).inflate(R.layout.ml, (ViewGroup) null);
        this.nZg.setBackgroundColor(getResources().getColor(R.color.bj));
        this.mPa = (TextView) this.nZg.findViewById(R.id.ipt);
        this.pYW = (TextView) this.nZg.findViewById(R.id.id2);
        this.nZa = (ImageView) this.nZg.findViewById(R.id.uo);
        this.pYX = (ImageView) this.nZg.findViewById(R.id.fd7);
        this.pYY = this.nZg.findViewById(R.id.brt);
        if (getContentView() != null && ((ViewGroup) getContentView()).getChildCount() > 0) {
            View childAt = ((ViewGroup) getContentView()).getChildAt(0);
            ((ViewGroup) getContentView()).removeView(childAt);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b8);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b9);
            }
            linearLayout.addView(this.nZg, new LinearLayout.LayoutParams(-1, dimensionPixelSize));
            linearLayout.addView(childAt);
            ((ViewGroup) getContentView()).addView(linearLayout);
        }
    }
}
