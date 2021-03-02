package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import junit.framework.Assert;

public class HelperHeaderPreference extends Preference {
    private a Bgj;
    private as contact;
    private TextView gCd;
    private ImageView gyr;
    private boolean kac = false;
    private TextView kib;
    private TextView kuu;

    public interface a {
        void a(HelperHeaderPreference helperHeaderPreference);

        CharSequence getHint();
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27251);
        this.gyr = (ImageView) view.findViewById(R.id.baa);
        this.gCd = (TextView) view.findViewById(R.id.bbn);
        this.kib = (TextView) view.findViewById(R.id.bb8);
        this.kuu = (TextView) view.findViewById(R.id.bau);
        this.kac = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.o(27251);
    }

    private void Mg(String str) {
        AppMethodBeat.i(27252);
        Log.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(str)));
        if (this.gyr != null && this.contact.field_username.equals(str)) {
            a.b.c(this.gyr, str);
        }
        AppMethodBeat.o(27252);
    }

    public final void sK(boolean z) {
        AppMethodBeat.i(27253);
        if (this.Bgj == null) {
            AppMethodBeat.o(27253);
        } else if (z) {
            this.gCd.setTextColor(u.kF(this.mContext));
            this.gCd.setText(R.string.gsr);
            this.gCd.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bo8, 0, 0, 0);
            AppMethodBeat.o(27253);
        } else {
            this.gCd.setTextColor(u.kG(this.mContext));
            this.gCd.setText(R.string.gsy);
            this.gCd.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bo7, 0, 0, 0);
            AppMethodBeat.o(27253);
        }
    }

    private void initView() {
        AppMethodBeat.i(27254);
        if (!this.kac || this.contact == null) {
            Log.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.kac + "contact = " + this.contact);
            AppMethodBeat.o(27254);
            return;
        }
        Mg(this.contact.field_username);
        if (this.kib != null) {
            this.kib.setText(this.contact.arI());
        }
        if (this.Bgj != null) {
            this.Bgj.a(this);
            CharSequence hint = this.Bgj.getHint();
            if (hint != null) {
                this.kuu.setText(hint);
                this.kuu.setVisibility(0);
                AppMethodBeat.o(27254);
                return;
            }
            this.kuu.setVisibility(8);
        }
        AppMethodBeat.o(27254);
    }

    public final void a(as asVar, a aVar) {
        AppMethodBeat.i(27255);
        Assert.assertTrue(asVar != null);
        this.contact = asVar;
        this.Bgj = aVar;
        initView();
        AppMethodBeat.o(27255);
    }
}
