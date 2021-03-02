package com.tencent.mm.msgsubscription.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.o;

public final class b {
    public static final b jDg = new b();

    static {
        AppMethodBeat.i(149818);
        AppMethodBeat.o(149818);
    }

    private b() {
    }

    public static /* synthetic */ View a(Context context, ArrayList arrayList) {
        AppMethodBeat.i(149817);
        View a2 = a(context, arrayList, 0);
        AppMethodBeat.o(149817);
        return a2;
    }

    public static View a(Context context, ArrayList<o<String, String>> arrayList, int i2) {
        AppMethodBeat.i(149816);
        p.h(context, "context");
        p.h(arrayList, "keyWordList");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int i3 = 0;
        for (T t : arrayList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                j.hxH();
            }
            T t2 = t;
            int size = arrayList.size();
            View inflate = LayoutInflater.from(context).inflate(R.layout.c17, (ViewGroup) null, false);
            View findViewById = inflate.findViewById(R.id.e5y);
            p.g(findViewById, "templateItem.findViewById<TextView>(R.id.key)");
            ((TextView) findViewById).setText(t2.first);
            View findViewById2 = inflate.findViewById(R.id.j2e);
            p.g(findViewById2, "templateItem.findViewById<TextView>(R.id.value)");
            ((TextView) findViewById2).setText(t2.second);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i3 != size - 1) {
                layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.hs);
            }
            if (i3 == 0) {
                layoutParams.topMargin = i2;
            }
            p.g(inflate, "templateItem");
            inflate.setLayoutParams(layoutParams);
            linearLayout.addView(inflate);
            i3 = i4;
        }
        LinearLayout linearLayout2 = linearLayout;
        AppMethodBeat.o(149816);
        return linearLayout2;
    }
}
