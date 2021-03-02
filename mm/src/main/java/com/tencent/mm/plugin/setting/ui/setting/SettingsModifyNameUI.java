package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;

public class SettingsModifyNameUI extends MMActivity implements c.a {
    private MMEditText DcX;
    private k.b DcY;
    private boolean DcZ = false;
    private q gut = null;
    private IListener gyj = new IListener<pd>() {
        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161721);
            this.__eventId = pd.class.getName().hashCode();
            AppMethodBeat.o(161721);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pd pdVar) {
            AppMethodBeat.i(74243);
            boolean a2 = a(pdVar);
            AppMethodBeat.o(74243);
            return a2;
        }

        private boolean a(pd pdVar) {
            AppMethodBeat.i(74242);
            String str = pdVar.dVh.dVi;
            String str2 = pdVar.dVh.dVj;
            int i2 = pdVar.dVh.ret;
            if (i2 != 0 && str2 != null) {
                h.c(SettingsModifyNameUI.this, str2, str, true);
                if (SettingsModifyNameUI.this.DcY != null) {
                    ((l) g.af(l.class)).aSM().e(SettingsModifyNameUI.this.DcY);
                }
            } else if (i2 == 0 && SettingsModifyNameUI.this.DcZ) {
                g.aAh().azQ().set(4, SettingsModifyNameUI.this.DcX.getText().toString());
                ((b) g.af(b.class)).bdS().tE(7);
                SettingsModifyNameUI.this.finish();
            }
            if (SettingsModifyNameUI.this.gut != null) {
                SettingsModifyNameUI.this.gut.dismiss();
            }
            AppMethodBeat.o(74242);
            return true;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsModifyNameUI() {
        AppMethodBeat.i(74247);
        AppMethodBeat.o(74247);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74248);
        super.onCreate(bundle);
        EventCenter.instance.addListener(this.gyj);
        initView();
        AppMethodBeat.o(74248);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74249);
        EventCenter.instance.removeListener(this.gyj);
        super.onDestroy();
        AppMethodBeat.o(74249);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.br2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74250);
        setMMTitle(R.string.gqu);
        this.DcX = (MMEditText) findViewById(R.id.hmx);
        this.DcX.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (String) g.aAh().azQ().get(4, (Object) null), this.DcX.getTextSize()));
        this.DcX.setSelection(this.DcX.getText().length());
        this.DcX.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI.AnonymousClass2 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(74244);
                SettingsModifyNameUI.this.enableOptionMenu(true);
                AppMethodBeat.o(74244);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        c.f(this.DcX).lv(1, 32).CN(false).a((c.a) null);
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74245);
                String obj = SettingsModifyNameUI.this.DcX.getText().toString();
                String aqt = com.tencent.mm.n.c.aqt();
                if (Util.isNullOrNil(aqt) || !obj.matches(".*[" + aqt + "].*")) {
                    c.f(SettingsModifyNameUI.this.DcX).lv(1, 32).a(SettingsModifyNameUI.this);
                    AppMethodBeat.o(74245);
                    return true;
                }
                h.c(SettingsModifyNameUI.this.getContext(), SettingsModifyNameUI.this.getString(R.string.e3v, new Object[]{aqt}), SettingsModifyNameUI.this.getString(R.string.zb), true);
                AppMethodBeat.o(74245);
                return false;
            }
        }, null, t.b.GREEN);
        enableOptionMenu(false);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74246);
                SettingsModifyNameUI.this.hideVKB();
                SettingsModifyNameUI.this.finish();
                AppMethodBeat.o(74246);
                return true;
            }
        });
        AppMethodBeat.o(74250);
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void Tw(String str) {
        AppMethodBeat.i(74251);
        Log.i("MiroMsg.SettingsModifyNameUI", "Set New NickName : ".concat(String.valueOf(str)));
        this.DcZ = true;
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gut = h.a((Context) context, getString(R.string.b_z), false, (DialogInterface.OnCancelListener) null);
        this.DcY = z.Io(str);
        AppMethodBeat.o(74251);
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void Tx(String str) {
        AppMethodBeat.i(256572);
        h.n(this, R.string.gqv, R.string.gqy);
        AppMethodBeat.o(256572);
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void dv(String str) {
        AppMethodBeat.i(164136);
        h.n(this, R.string.gqw, R.string.gqy);
        AppMethodBeat.o(164136);
    }
}
