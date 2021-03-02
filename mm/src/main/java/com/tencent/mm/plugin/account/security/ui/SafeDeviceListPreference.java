package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SafeDeviceListPreference extends Preference implements i {
    private Context context;
    private ProgressDialog gtM;
    d kjm;
    private boolean kjn;
    private Button kjo;
    a kjp;
    b kjq;
    int mode;

    public interface a {
        void Tp(String str);
    }

    public interface b {
        void onSucceed(String str);
    }

    static /* synthetic */ void c(SafeDeviceListPreference safeDeviceListPreference) {
        AppMethodBeat.i(125583);
        safeDeviceListPreference.bit();
        AppMethodBeat.o(125583);
    }

    public SafeDeviceListPreference(Context context2) {
        this(context2, null);
    }

    public SafeDeviceListPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public SafeDeviceListPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        this.mode = -2;
        this.kjn = false;
        this.context = context2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(125577);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            layoutInflater.inflate(R.layout.b9z, viewGroup2);
        }
        AppMethodBeat.o(125577);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(125578);
        this.kjn = true;
        this.kjo = (Button) view.findViewById(R.id.bln);
        initView();
        super.onBindView(view);
        AppMethodBeat.o(125578);
    }

    private void bit() {
        AppMethodBeat.i(125579);
        g.azz().b(362, this);
        AppMethodBeat.o(125579);
    }

    /* access modifiers changed from: package-private */
    public final void initView() {
        AppMethodBeat.i(125580);
        if (!this.kjn) {
            Log.d("MicroMsg.SafeDeviceListPreference", "has not binded");
            AppMethodBeat.o(125580);
            return;
        }
        switch (this.mode) {
            case -2:
                setWidgetLayoutResource(0);
                alO(0);
                AppMethodBeat.o(125580);
                return;
            case -1:
            case 0:
            default:
                setWidgetLayoutResource(0);
                alO(0);
                AppMethodBeat.o(125580);
                return;
            case 1:
                setWidgetLayoutResource(R.layout.z6);
                if (this.kjo != null) {
                    this.kjo.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.AnonymousClass3 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(125576);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SafeDeviceListPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            SafeDeviceListPreference.d(SafeDeviceListPreference.this);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SafeDeviceListPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(125576);
                        }
                    });
                }
                alO(8);
                AppMethodBeat.o(125580);
                return;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(125581);
        bit();
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i3 == 0 && i3 == 0) {
            com.tencent.mm.plugin.account.security.a.g.boR().delete(this.kjm, new String[0]);
            if (this.kjq != null) {
                this.kjq.onSucceed(this.mKey);
                AppMethodBeat.o(125581);
                return;
            }
        } else if (com.tencent.mm.plugin.account.a.a.jRu.a(this.context, i2, i3, str)) {
            AppMethodBeat.o(125581);
            return;
        } else {
            Toast.makeText(this.context, this.context.getString(R.string.ga2, Integer.valueOf(i2), Integer.valueOf(i3)), 0).show();
            if (this.kjp != null) {
                this.kjp.Tp(this.kjm.field_uid);
            }
        }
        AppMethodBeat.o(125581);
    }

    static /* synthetic */ void a(SafeDeviceListPreference safeDeviceListPreference) {
        AppMethodBeat.i(125582);
        g.azz().a(362, safeDeviceListPreference);
        AppMethodBeat.o(125582);
    }

    static /* synthetic */ void d(SafeDeviceListPreference safeDeviceListPreference) {
        AppMethodBeat.i(125584);
        h.c(safeDeviceListPreference.context, safeDeviceListPreference.context.getString(R.string.ga0, safeDeviceListPreference.kjm.field_name), "", com.tencent.mm.cb.a.aI(safeDeviceListPreference.context, R.string.ga1), com.tencent.mm.cb.a.aI(safeDeviceListPreference.context, R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(125575);
                SafeDeviceListPreference.a(SafeDeviceListPreference.this);
                final com.tencent.mm.plugin.account.security.a.a aVar = new com.tencent.mm.plugin.account.security.a.a(SafeDeviceListPreference.this.kjm.field_uid);
                g.azz().a(aVar, 0);
                SafeDeviceListPreference.this.gtM = h.a(SafeDeviceListPreference.this.context, com.tencent.mm.cb.a.aI(SafeDeviceListPreference.this.context, R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.AnonymousClass1.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125574);
                        g.azz().a(aVar);
                        SafeDeviceListPreference.c(SafeDeviceListPreference.this);
                        AppMethodBeat.o(125574);
                    }
                });
                AppMethodBeat.o(125575);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(125584);
    }
}
