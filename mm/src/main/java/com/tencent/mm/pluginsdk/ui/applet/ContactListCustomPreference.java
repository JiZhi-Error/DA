package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference extends Preference {
    private final View.OnTouchListener KfV = new View.OnTouchListener() {
        /* class com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference.AnonymousClass1 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    int background = -1;
    View.OnClickListener ko;
    private View vk;

    public ContactListCustomPreference(Context context) {
        super(context);
        AppMethodBeat.i(152207);
        setLayoutResource(R.layout.b8w);
        AppMethodBeat.o(152207);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(152208);
        setLayoutResource(R.layout.b8w);
        AppMethodBeat.o(152208);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(152209);
        setLayoutResource(R.layout.b8w);
        AppMethodBeat.o(152209);
    }

    public final void setCustomView(View view) {
        if (view != null) {
            this.vk = view;
        }
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(152210);
        ViewGroup viewGroup = (ViewGroup) view;
        if (!(this.vk == null || this.vk == null)) {
            viewGroup.removeAllViews();
            if (this.vk.getParent() != null) {
                ((ViewGroup) this.vk.getParent()).removeAllViews();
            }
            viewGroup.addView(this.vk);
            if (this.ko != null) {
                viewGroup.setOnClickListener(this.ko);
            } else {
                viewGroup.setOnTouchListener(this.KfV);
            }
        }
        if (this.background >= 0) {
            view.setBackgroundResource(this.background);
        }
        AppMethodBeat.o(152210);
    }
}
