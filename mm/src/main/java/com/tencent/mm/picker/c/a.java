package com.tencent.mm.picker.c;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.picker.base.c.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.d.d;
import com.tencent.mm.picker.d.e;
import com.tencent.smtt.sdk.WebView;
import java.util.Calendar;

public final class a {
    public static b jKQ;
    public ViewGroup Zv;
    public Context context;
    public int endYear;
    public c jKR;
    public e jKS;
    public d jKT;
    public com.tencent.mm.picker.d.b jKU;
    public boolean jKV = false;
    public boolean jKW = false;
    public boolean[] jKX = {true, true, true, false, false, false};
    public Calendar jKY;
    public Calendar jKZ;
    public boolean jKn = false;
    public int jKu = 0;
    public Calendar jLa;
    public String jLb;
    public String jLc;
    public String jLd;
    public String jLe;
    public String jLf;
    public String jLg;
    public int jLh;
    public int jLi = 17;
    public String jLj;
    public String jLk;
    public String jLl;
    public int jLm = -15028967;
    public int jLn = -1979711488;
    public int jLo = WebView.NIGHT_MODE_COLOR;
    public int jLp = -1;
    public int jLq = -657931;
    public int jLr = 24;
    public int jLs = 24;
    public int jLt = -1;
    public float jLu = 1.6f;
    public boolean jLv;
    public WheelView.b jLw = WheelView.b.FILL;
    public int kn = 0;
    public Typeface lC = Typeface.DEFAULT;
    public String label;
    public int option;
    public boolean ox = true;
    public int startYear;

    public a(int i2) {
        AppMethodBeat.i(175332);
        if (i2 == 1) {
            this.jLh = R.layout.bi5;
            AppMethodBeat.o(175332);
            return;
        }
        this.jLh = R.layout.bi7;
        AppMethodBeat.o(175332);
    }
}
