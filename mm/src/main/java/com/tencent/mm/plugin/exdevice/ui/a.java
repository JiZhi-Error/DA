package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;

/* access modifiers changed from: package-private */
public final class a extends BaseAdapter {
    private Context context;
    private boolean rIK;
    private String username;

    public a(Context context2, String str) {
        AppMethodBeat.i(231697);
        this.context = context2;
        this.username = str;
        this.rIK = z.aTY().equals(str);
        AppMethodBeat.o(231697);
    }

    public final int getCount() {
        return this.rIK ? 2 : 1;
    }

    public final int getViewTypeCount() {
        return this.rIK ? 2 : 1;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(24077);
        Integer valueOf = Integer.valueOf(i2);
        AppMethodBeat.o(24077);
        return valueOf;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getItemViewType(int i2) {
        if (i2 == 0) {
            return 0;
        }
        return 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0414  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x045c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
        /*
        // Method dump skipped, instructions count: 1140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
