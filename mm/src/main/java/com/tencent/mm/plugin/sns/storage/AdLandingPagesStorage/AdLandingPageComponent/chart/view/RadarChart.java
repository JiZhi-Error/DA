package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.Chart;
import java.util.ArrayList;

public class RadarChart extends Chart {
    public ArrayList<a> EaV;
    private c EaW = new c();
    public TextView EaX;
    private RadarGrid EaY;
    private RadarDataLayer[] EaZ;
    private a Eba;
    private boolean Ebb = true;
    private boolean Ebc = true;
    public int Ebd = 3;
    public int Ebe = 0;
    private int Ebf = 4;
    public Spannable[] Ebg;
    private Context context;
    private float maxValue = 1.0f;

    public RadarChart(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(96338);
        this.context = context2;
        AppMethodBeat.o(96338);
    }

    public RadarChart(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(96339);
        this.context = context2;
        AppMethodBeat.o(96339);
    }

    public void setData(a... aVarArr) {
        int i2 = 0;
        AppMethodBeat.i(96340);
        removeAllViews();
        for (a aVar : aVarArr) {
            if (aVar.size() <= 0) {
                Exception exc = new Exception("Not enough elements.");
                AppMethodBeat.o(96340);
                throw exc;
            }
        }
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            for (a aVar2 : aVarArr) {
                if (!aVarArr[i3].a(aVar2)) {
                    Error error = new Error("Layer not compatible.");
                    AppMethodBeat.o(96340);
                    throw error;
                }
            }
        }
        this.Ebg = aVarArr[0].fcQ();
        this.Ebe = aVarArr[0].size();
        if (this.EaV == null) {
            this.EaV = new ArrayList<>();
        }
        for (a aVar3 : aVarArr) {
            this.EaV.add(aVar3);
        }
        this.EaY = new RadarGrid(this.context, this.Ebe, this.Ebf, this.maxValue, this.Ebg, this.EaW);
        addView(this.EaY);
        this.EaZ = new RadarDataLayer[this.Ebd];
        while (i2 < this.EaZ.length && this.EaV.size() > i2) {
            this.EaZ[i2] = new RadarDataLayer(this.context, this.maxValue, this.EaV.get(i2));
            addView(this.EaZ[i2]);
            i2++;
        }
        if (this.Eba == null) {
            this.Eba = new a(this.context, this.EaW);
        }
        addView(this.Eba);
        AppMethodBeat.o(96340);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(96341);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
        AppMethodBeat.o(96341);
    }

    public void setLatitudeNum(int i2) {
        this.Ebf = i2;
    }

    public void setGridStyle(c cVar) {
        AppMethodBeat.i(96342);
        this.EaW = cVar;
        if (this.EaY != null) {
            this.EaY.setGridStyle(cVar);
        }
        AppMethodBeat.o(96342);
    }

    public c getGridStyle() {
        AppMethodBeat.i(96343);
        if (this.EaY == null) {
            c cVar = this.EaW;
            AppMethodBeat.o(96343);
            return cVar;
        }
        this.EaW = this.EaY.getGridStyle();
        c gridStyle = this.EaY.getGridStyle();
        AppMethodBeat.o(96343);
        return gridStyle;
    }
}
