package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.f.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference extends Preference {
    private ToggleButton Kqs;
    private ToggleButton Kqt;
    private ToggleButton Kqu;
    private CompoundButton.OnCheckedChangeListener Kqv = new CompoundButton.OnCheckedChangeListener() {
        /* class com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference.AnonymousClass1 */

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.i(31913);
            int id = compoundButton.getId();
            if (id == R.id.h8e) {
                SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
                AppMethodBeat.o(31913);
            } else if (id == R.id.h8d) {
                SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
                AppMethodBeat.o(31913);
            } else {
                if (id == R.id.h8l) {
                    SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
                }
                AppMethodBeat.o(31913);
            }
        }
    };
    private boolean dRx;
    private boolean gtO;
    private boolean guh = false;
    private Context mContext;
    private as rjX;
    private String roomId;

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(31914);
        this.mContext = context;
        AppMethodBeat.o(31914);
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(31915);
        this.mContext = context;
        AppMethodBeat.o(31915);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(31916);
        super.onBindView(view);
        this.Kqs = (ToggleButton) view.findViewById(R.id.h8e);
        this.Kqt = (ToggleButton) view.findViewById(R.id.h8d);
        this.Kqu = (ToggleButton) view.findViewById(R.id.h8l);
        this.roomId = ((MMActivity) this.mContext).getIntent().getStringExtra("RoomInfo_Id");
        this.dRx = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
        this.gtO = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
        bg.aVF();
        this.rjX = c.aSN().Kn(this.roomId);
        if (this.rjX != null) {
            ToggleButton toggleButton = this.Kqs;
            bg.aVF();
            toggleButton.setChecked(c.aST().bkg(this.rjX.field_username));
            this.Kqu.setChecked(com.tencent.mm.contact.c.oR(this.rjX.field_type));
            this.Kqt.setChecked(grT());
        }
        this.Kqs.setOnCheckedChangeListener(this.Kqv);
        this.Kqt.setOnCheckedChangeListener(this.Kqv);
        this.Kqu.setOnCheckedChangeListener(this.Kqv);
        AppMethodBeat.o(31916);
    }

    private boolean grT() {
        AppMethodBeat.i(31917);
        if (this.dRx) {
            this.guh = this.rjX.fuH == 0;
        } else if (!this.gtO) {
            this.guh = this.rjX.Zx();
        }
        if (!(this.mContext instanceof MMActivity)) {
            AppMethodBeat.o(31917);
            return false;
        } else if (this.guh) {
            ((MMActivity) this.mContext).setTitleMuteIconVisibility(0);
            AppMethodBeat.o(31917);
            return true;
        } else {
            ((MMActivity) this.mContext).setTitleMuteIconVisibility(8);
            AppMethodBeat.o(31917);
            return false;
        }
    }

    static /* synthetic */ void a(SpecialCheckBoxPreference specialCheckBoxPreference) {
        AppMethodBeat.i(31918);
        if (specialCheckBoxPreference.rjX != null) {
            bg.aVF();
            if (c.aST().bkg(specialCheckBoxPreference.rjX.field_username)) {
                ab.F(specialCheckBoxPreference.rjX.field_username, true);
                AppMethodBeat.o(31918);
                return;
            }
            ab.E(specialCheckBoxPreference.rjX.field_username, true);
        }
        AppMethodBeat.o(31918);
    }

    static /* synthetic */ void b(SpecialCheckBoxPreference specialCheckBoxPreference) {
        int i2 = 0;
        AppMethodBeat.i(31919);
        specialCheckBoxPreference.guh = !specialCheckBoxPreference.guh;
        if (specialCheckBoxPreference.dRx) {
            if (!specialCheckBoxPreference.guh) {
                i2 = 1;
            }
            bg.aVF();
            c.aSM().d(new a(specialCheckBoxPreference.roomId, i2));
            specialCheckBoxPreference.rjX.nm(i2);
            bg.aVF();
            c.aSN().c(specialCheckBoxPreference.roomId, specialCheckBoxPreference.rjX);
        }
        specialCheckBoxPreference.grT();
        AppMethodBeat.o(31919);
    }

    static /* synthetic */ void c(SpecialCheckBoxPreference specialCheckBoxPreference) {
        AppMethodBeat.i(31920);
        if (specialCheckBoxPreference.rjX != null) {
            if (com.tencent.mm.contact.c.oR(specialCheckBoxPreference.rjX.field_type)) {
                specialCheckBoxPreference.rjX.aqR();
                ab.G(specialCheckBoxPreference.rjX);
                h.cD(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.string.g8x));
                AppMethodBeat.o(31920);
                return;
            }
            ab.C(specialCheckBoxPreference.rjX);
            h.cD(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.string.g9c));
        }
        AppMethodBeat.o(31920);
    }
}
