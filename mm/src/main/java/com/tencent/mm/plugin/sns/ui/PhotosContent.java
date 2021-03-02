package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFrameLayout;
import java.util.ArrayList;

public class PhotosContent extends MMFrameLayout {
    public ArrayList<TagImageView> EuD = new ArrayList<>();
    private float EuE;
    private int cuv = 120;

    public final void fgF() {
        AppMethodBeat.i(98149);
        this.EuD.clear();
        AppMethodBeat.o(98149);
    }

    public final void a(TagImageView tagImageView) {
        AppMethodBeat.i(98150);
        this.EuD.add(tagImageView);
        AppMethodBeat.o(98150);
    }

    public void setImageViewWidth(int i2) {
        AppMethodBeat.i(98151);
        if (i2 <= 0) {
            AppMethodBeat.o(98151);
            return;
        }
        this.EuE = getResources().getDisplayMetrics().density;
        this.cuv = (int) (((float) this.cuv) * this.EuE);
        if (i2 >= this.cuv) {
            i2 = this.cuv;
        }
        for (int i3 = 0; i3 < this.EuD.size(); i3++) {
            View childAt = getChildAt(i3);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(childAt.getLayoutParams());
            marginLayoutParams.width = i2;
            marginLayoutParams.height = i2;
            marginLayoutParams.leftMargin = (int) (((float) (i3 % 3)) * (((float) i2) + (this.EuE * 3.0f)));
            marginLayoutParams.topMargin = (int) (((float) (i3 / 3)) * (((float) i2) + (this.EuE * 3.0f)));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
            layoutParams.gravity = 51;
            childAt.setLayoutParams(layoutParams);
        }
        int size = this.EuD.size() / 3;
        if (size > 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams2.height = (int) ((((float) (size - 1)) * this.EuE * 3.0f) + ((float) (i2 * size)));
            setLayoutParams(marginLayoutParams2);
        }
        AppMethodBeat.o(98151);
    }

    public final TagImageView ZD(int i2) {
        AppMethodBeat.i(98152);
        if (i2 < this.EuD.size()) {
            TagImageView tagImageView = this.EuD.get(i2);
            AppMethodBeat.o(98152);
            return tagImageView;
        }
        AppMethodBeat.o(98152);
        return null;
    }

    public PhotosContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(98153);
        AppMethodBeat.o(98153);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(98154);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(98154);
    }
}
