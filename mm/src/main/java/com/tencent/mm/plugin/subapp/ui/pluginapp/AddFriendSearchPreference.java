package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference extends Preference {
    private String FMN;
    String FMO;
    private View.OnClickListener FMP;
    View.OnClickListener FMQ;
    private View FMR;
    private Context context;
    private TextView knK;

    public AddFriendSearchPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public AddFriendSearchPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(29186);
        this.FMN = "";
        this.FMO = "";
        this.FMP = null;
        this.FMQ = null;
        this.knK = null;
        this.FMR = null;
        this.context = context2;
        setLayoutResource(R.layout.b8z);
        AppMethodBeat.o(29186);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(29187);
        super.onBindView(view);
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.knK = (TextView) view.findViewById(R.id.hl0);
        this.knK.setText(this.FMO);
        this.FMR = view.findViewById(R.id.hej);
        if (this.FMQ != null) {
            this.FMR.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference.AnonymousClass2 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(29185);
                    if (motionEvent.getAction() == 1) {
                        AddFriendSearchPreference.this.FMQ.onClick(view);
                    }
                    AppMethodBeat.o(29185);
                    return true;
                }
            });
        }
        alO(8);
        AppMethodBeat.o(29187);
    }
}
