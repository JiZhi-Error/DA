package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.protobuf.ag;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameFeedTitleDescView extends LinearLayout {
    private TextView jVn;
    private TextView mPa;
    private LinearLayout xSK;

    public GameFeedTitleDescView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42136);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.aqg, (ViewGroup) this, true);
        this.xSK = (LinearLayout) inflate.findViewById(R.id.j1r);
        this.mPa = (TextView) inflate.findViewById(R.id.ipm);
        this.jVn = (TextView) inflate.findViewById(R.id.bmr);
        AppMethodBeat.o(42136);
    }

    public final void b(String str, String str2, LinkedList<ag> linkedList) {
        AppMethodBeat.i(42137);
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
            setVisibility(0);
            if (!Util.isNullOrNil(linkedList)) {
                this.xSK.setVisibility(0);
                while (this.xSK.getChildCount() < linkedList.size() + 1) {
                    ImageView imageView = new ImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.gr), getResources().getDimensionPixelSize(R.dimen.gr));
                    layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.gk), 0);
                    layoutParams.gravity = 16;
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.xSK.addView(imageView, 0, layoutParams);
                }
                int i2 = 0;
                while (i2 < linkedList.size()) {
                    ImageView imageView2 = (ImageView) this.xSK.getChildAt(i2);
                    e.dWR().p(imageView2, linkedList.get(i2).xJE);
                    imageView2.setVisibility(0);
                    i2++;
                }
                while (i2 < this.xSK.getChildCount() - 1) {
                    this.xSK.getChildAt(i2).setVisibility(8);
                    i2++;
                }
                if (!Util.isNullOrNil(str)) {
                    ((TextView) this.xSK.getChildAt(i2)).setText(str);
                }
                this.mPa.setVisibility(8);
            } else {
                this.xSK.setVisibility(8);
                if (!Util.isNullOrNil(str)) {
                    this.mPa.setText(str);
                    this.mPa.setVisibility(0);
                } else {
                    this.mPa.setVisibility(8);
                }
            }
            if (!Util.isNullOrNil(str2)) {
                this.jVn.setText(str2);
                this.jVn.setVisibility(0);
            } else {
                this.jVn.setVisibility(8);
            }
            if (a(this.mPa, str, (c.getScreenWidth(getContext()) - ((ViewGroup) getParent()).getPaddingLeft()) - ((ViewGroup) getParent()).getPaddingRight()) > 1) {
                this.jVn.setMaxLines(1);
                AppMethodBeat.o(42137);
                return;
            }
            this.jVn.setMaxLines(2);
            AppMethodBeat.o(42137);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(42137);
    }

    private static int a(TextView textView, String str, int i2) {
        AppMethodBeat.i(42138);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42138);
            return 0;
        } else if (textView.getPaint().measureText(str) > ((float) i2)) {
            AppMethodBeat.o(42138);
            return 2;
        } else {
            AppMethodBeat.o(42138);
            return 1;
        }
    }
}
