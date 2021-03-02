package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.a.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/ProfileWordingSetHelper;", "", "()V", "permissionTitle", "", "v", "Landroid/view/View;", "talkOnlyTips", "app_release"})
public final class t {
    public static final t Vay = new t();

    static {
        AppMethodBeat.i(259059);
        AppMethodBeat.o(259059);
    }

    private t() {
    }

    public static void hU(View view) {
        int i2;
        AppMethodBeat.i(259057);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (p.fvC()) {
                i2 = R.string.jdr;
            } else {
                i2 = R.string.fq8;
            }
            textView.setText(i2);
        }
        AppMethodBeat.o(259057);
    }

    public static void hV(View view) {
        int i2;
        AppMethodBeat.i(259058);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (p.fvC()) {
                i2 = R.string.jds;
            } else {
                i2 = R.string.fqa;
            }
            textView.setText(i2);
        }
        AppMethodBeat.o(259058);
    }
}
