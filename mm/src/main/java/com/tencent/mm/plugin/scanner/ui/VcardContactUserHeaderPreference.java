package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference extends Preference {
    String CHK;
    private ImageView COW;
    private TextView COX;
    private TextView COY;
    private TextView COZ;
    private TextView CPa;
    private final Context context;
    String fullName;
    String nickName;
    String title;

    public VcardContactUserHeaderPreference(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
    }

    public VcardContactUserHeaderPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        this.context = context2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(52014);
        super.onBindView(view);
        Log.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
        this.COW = (ImageView) view.findViewById(R.id.j2i);
        this.COX = (TextView) view.findViewById(R.id.j2j);
        if (this.fullName != null) {
            this.COX.setText(this.fullName);
        }
        this.COY = (TextView) view.findViewById(R.id.j2k);
        if (this.nickName != null) {
            this.COY.setText(this.context.getString(R.string.hut, this.nickName));
            this.COY.setVisibility(0);
        }
        this.COZ = (TextView) view.findViewById(R.id.j2l);
        if (this.CHK != null) {
            this.COZ.setText(this.context.getString(R.string.huy, this.CHK));
            this.COZ.setVisibility(0);
        }
        this.CPa = (TextView) view.findViewById(R.id.j2m);
        if (this.title != null) {
            this.CPa.setText(this.context.getString(R.string.huz, this.title));
            this.CPa.setVisibility(0);
        }
        AppMethodBeat.o(52014);
    }
}
