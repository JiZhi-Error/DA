package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.lang.ref.WeakReference;

public class VerifyQQUI extends MMWizardActivity implements i {
    private String dOX;
    private String dOZ;
    private byte[] iKr = null;
    private long kdE = 0;
    private String kdF = "";
    private String kdG = "";
    private String kdH;
    private b kdI = new b(this);
    private SecurityImage kdp = null;
    private q tipDialog = null;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VerifyQQUI() {
        AppMethodBeat.i(110211);
        AppMethodBeat.o(110211);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(110212);
        super.onCreate(bundle);
        g.azz().a(144, this);
        AppMethodBeat.o(110212);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(110213);
        super.onDestroy();
        g.azz().b(144, this);
        AppMethodBeat.o(110213);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(110214);
        super.onResume();
        initView();
        AppMethodBeat.o(110214);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.j_;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onSwipeBackFinish() {
        AppMethodBeat.i(110215);
        hideVKB();
        finish();
        AppMethodBeat.o(110215);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(110216);
        ka kaVar = new ka();
        kaVar.dOV.context = this;
        EventCenter.instance.publish(kaVar);
        this.dOX = kaVar.dOW.dOX;
        kb kbVar = new kb();
        EventCenter.instance.publish(kbVar);
        this.dOZ = kbVar.dOY.dOZ;
        setMMTitle(R.string.ag7);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(110202);
                VerifyQQUI.this.hideVKB();
                VerifyQQUI.a(VerifyQQUI.this);
                AppMethodBeat.o(110202);
                return true;
            }
        });
        findViewById(R.id.a4r);
        findViewById(R.id.a4q);
        addTextOptionMenu(0, getString(R.string.vl), this.kdI);
        AppMethodBeat.o(110216);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x021d  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r10, int r11, java.lang.String r12, com.tencent.mm.ak.q r13) {
        /*
        // Method dump skipped, instructions count: 622
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    /* access modifiers changed from: package-private */
    public static class b implements MenuItem.OnMenuItemClickListener {
        WeakReference<VerifyQQUI> cMO;

        protected b(VerifyQQUI verifyQQUI) {
            AppMethodBeat.i(110209);
            this.cMO = new WeakReference<>(verifyQQUI);
            AppMethodBeat.o(110209);
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(110210);
            VerifyQQUI verifyQQUI = this.cMO.get();
            if (verifyQQUI == null || verifyQQUI.isFinishing()) {
                AppMethodBeat.o(110210);
            } else {
                String trim = ((EditText) verifyQQUI.findViewById(R.id.a4r)).getText().toString().trim();
                verifyQQUI.kdF = ((EditText) verifyQQUI.findViewById(R.id.a4q)).getText().toString().trim();
                try {
                    verifyQQUI.kdE = Util.getLong(trim, 0);
                    if (verifyQQUI.kdE < 10000) {
                        h.n(verifyQQUI.getContext(), R.string.ag1, R.string.afz);
                        AppMethodBeat.o(110210);
                    } else if (verifyQQUI.kdF.equals("")) {
                        h.n(verifyQQUI.getContext(), R.string.ag0, R.string.afz);
                        AppMethodBeat.o(110210);
                    } else {
                        verifyQQUI.hideVKB();
                        final com.tencent.mm.plugin.account.bind.a.b bVar = new com.tencent.mm.plugin.account.bind.a.b(verifyQQUI.kdE, verifyQQUI.kdF, "", "", "", verifyQQUI.dOX, verifyQQUI.dOZ, false);
                        g.azz().a(bVar, 0);
                        AppCompatActivity context = verifyQQUI.getContext();
                        verifyQQUI.getString(R.string.ag3);
                        verifyQQUI.tipDialog = h.a((Context) context, verifyQQUI.getString(R.string.afu), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.b.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(110208);
                                g.azz().a(bVar);
                                AppMethodBeat.o(110208);
                            }
                        });
                        AppMethodBeat.o(110210);
                    }
                } catch (Exception e2) {
                    h.n(verifyQQUI.getContext(), R.string.ag1, R.string.afz);
                    AppMethodBeat.o(110210);
                }
            }
            return true;
        }
    }

    class a extends SecurityImage.b {
        a() {
        }

        @Override // com.tencent.mm.ui.applet.SecurityImage.b
        public final void bnH() {
            AppMethodBeat.i(110207);
            g.azz().a(new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.this.kdE, VerifyQQUI.this.kdF, VerifyQQUI.this.kdG, "", VerifyQQUI.this.kdH, 2, true), 0);
            AppMethodBeat.o(110207);
        }
    }

    static /* synthetic */ void a(VerifyQQUI verifyQQUI) {
        AppMethodBeat.i(110218);
        verifyQQUI.ala(1);
        AppMethodBeat.o(110218);
    }

    static /* synthetic */ void b(VerifyQQUI verifyQQUI) {
        AppMethodBeat.i(110219);
        verifyQQUI.ala(1);
        AppMethodBeat.o(110219);
    }
}
