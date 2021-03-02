package com.tencent.mm.plugin.brandservice.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private Context mContext;
    private int mOrientation;
    private View nEb;
    private final Set<b> nEg = Collections.newSetFromMap(new ConcurrentHashMap());
    private int pNM = 0;

    public a(Context context) {
        AppMethodBeat.i(6269);
        this.mContext = context;
        AppMethodBeat.o(6269);
    }

    public final void N(View view, int i2) {
        AppMethodBeat.i(6270);
        btC();
        this.nEb = view;
        Activity activity = (Activity) this.mContext;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        this.pNM = viewGroup.getSystemUiVisibility();
        viewGroup.addView(view, layoutParams);
        view.setX(0.0f);
        view.setY(0.0f);
        if (d.oE(19)) {
            viewGroup.setSystemUiVisibility(2);
        } else {
            viewGroup.setSystemUiVisibility(4102);
        }
        activity.getWindow().addFlags(1024);
        this.mOrientation = activity.getRequestedOrientation();
        switch (i2) {
            case -90:
                activity.setRequestedOrientation(8);
                break;
            case 0:
                activity.setRequestedOrientation(1);
                break;
            case 90:
                activity.setRequestedOrientation(0);
                break;
            default:
                activity.setRequestedOrientation(9);
                break;
        }
        bTL();
        AppMethodBeat.o(6270);
    }

    public final boolean btC() {
        AppMethodBeat.i(6271);
        if (this.nEb == null) {
            AppMethodBeat.o(6271);
            return false;
        }
        Activity activity = (Activity) this.mContext;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        viewGroup.setSystemUiVisibility(this.pNM);
        viewGroup.removeView(this.nEb);
        activity.getWindow().clearFlags(1024);
        activity.setRequestedOrientation(this.mOrientation);
        this.nEb = null;
        bTM();
        AppMethodBeat.o(6271);
        return true;
    }

    public final void a(b bVar) {
        AppMethodBeat.i(6272);
        if (!this.nEg.contains(bVar)) {
            this.nEg.add(bVar);
        }
        AppMethodBeat.o(6272);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(6273);
        this.nEg.remove(bVar);
        AppMethodBeat.o(6273);
    }

    private void bTL() {
        AppMethodBeat.i(6274);
        Iterator<b> it = this.nEg.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(6274);
    }

    private void bTM() {
        AppMethodBeat.i(6275);
        for (b bVar : this.nEg) {
            bVar.Na();
        }
        AppMethodBeat.o(6275);
    }
}
