package com.tencent.mm.plugin.soter.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.core.a.a;
import com.tencent.soter.core.c.i;
import com.tencent.soter.core.c.j;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.security.Signature;
import java.security.SignatureException;

public class SoterTestUI extends MMActivity {
    private Button FiA = null;
    private Button FiB = null;
    private Button FiC = null;
    private Button FiD = null;
    private Button FiE = null;
    private Button FiF = null;
    private TextView FiG = null;
    private Button Fix = null;
    private Button Fiy = null;
    private Button Fiz = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(130918);
        super.onCreate(bundle);
        this.Fix = (Button) findViewById(R.id.i2w);
        this.Fiy = (Button) findViewById(R.id.i2r);
        this.Fiz = (Button) findViewById(R.id.i2v);
        this.FiA = (Button) findViewById(R.id.i2t);
        this.FiB = (Button) findViewById(R.id.i2q);
        this.FiC = (Button) findViewById(R.id.i2u);
        this.FiD = (Button) findViewById(R.id.i2s);
        this.FiE = (Button) findViewById(R.id.i2p);
        this.FiF = (Button) findViewById(R.id.i2o);
        this.FiG = (TextView) findViewById(R.id.h5p);
        this.Fix.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.soter.ui.SoterTestUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(130905);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SoterTestUI.this.FiG.setText(com.tencent.soter.a.a.hlC() ? "passed" : "not support");
                a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(130905);
            }
        });
        this.Fiy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.soter.ui.SoterTestUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(130906);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SoterTestUI.this.FiG.setText(com.tencent.soter.core.a.hlk().isSuccess() ? "passed" : "not support");
                a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(130906);
            }
        });
        this.Fiz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.soter.ui.SoterTestUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(130907);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SoterTestUI.this.FiG.setText(com.tencent.soter.core.a.hll().isSuccess() ? "passed" : "not passed");
                a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(130907);
            }
        });
        this.FiA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.soter.ui.SoterTestUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(130908);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                i hlo = com.tencent.soter.core.a.hlo();
                if (hlo == null) {
                    SoterTestUI.this.FiG.setText("not passed: no certificate");
                    a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(130908);
                    return;
                }
                SoterTestUI.this.FiG.setText("model available: " + hlo.toString());
                a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(130908);
            }
        });
        this.FiB.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.soter.ui.SoterTestUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(130909);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SoterTestUI.this.FiG.setText(com.tencent.soter.core.a.bqg("sample_auth_key_name").isSuccess() ? StateEvent.ActionValue.STAGE_PASS : "not passed");
                a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(130909);
            }
        });
        this.FiC.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.soter.ui.SoterTestUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(130910);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SoterTestUI.this.FiG.setText(com.tencent.soter.core.a.dE("sample_auth_key_name", false).isSuccess() ? StateEvent.ActionValue.STAGE_PASS : "not passed");
                a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(130910);
            }
        });
        this.FiD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.soter.ui.SoterTestUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(130911);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                i bqj = com.tencent.soter.core.a.bqj("sample_auth_key_name");
                if (bqj == null) {
                    SoterTestUI.this.FiG.setText("not passed: no certificate");
                    a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(130911);
                    return;
                }
                SoterTestUI.this.FiG.setText("model available: " + bqj.toString());
                a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(130911);
            }
        });
        this.FiE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.soter.ui.SoterTestUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(130917);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final Signature bqk = com.tencent.soter.core.a.bqk("sample_auth_key_name");
                if (bqk != null) {
                    try {
                        bqk.update("challenge".getBytes());
                        bqk.sign();
                        Log.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
                        SoterTestUI.this.FiG.setText("not passed: signature success without fingerprint authentication");
                        a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(130917);
                    } catch (SignatureException e2) {
                        Log.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e2.toString());
                        com.tencent.soter.core.a.a lf = com.tencent.soter.core.a.a.lf(SoterTestUI.this);
                        if (!com.tencent.soter.core.a.a.RPk.isHardwareDetected(lf.mContext) || !lf.hasEnrolledFingerprints()) {
                            Log.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
                        } else {
                            lf.a(new a.d(bqk), null, new a.b() {
                                /* class com.tencent.mm.plugin.soter.ui.SoterTestUI.AnonymousClass8.AnonymousClass1 */

                                @Override // com.tencent.soter.core.a.a.b
                                public final void onAuthenticationError(int i2, CharSequence charSequence) {
                                    AppMethodBeat.i(130912);
                                    Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
                                    AppMethodBeat.o(130912);
                                }

                                @Override // com.tencent.soter.core.a.a.b
                                public final void onAuthenticationHelp(int i2, CharSequence charSequence) {
                                    AppMethodBeat.i(130913);
                                    Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
                                    AppMethodBeat.o(130913);
                                }

                                @Override // com.tencent.soter.core.a.a.b
                                public final void fme() {
                                    AppMethodBeat.i(130914);
                                    Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
                                    try {
                                        bqk.update("challenge".getBytes());
                                        j cY = com.tencent.soter.core.a.cY(bqk.sign());
                                        SoterTestUI.this.FiG.setText(cY == null ? "not pass: exception occurs" : cY.toString());
                                        AppMethodBeat.o(130914);
                                    } catch (SignatureException e2) {
                                        Log.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e2.toString());
                                        AppMethodBeat.o(130914);
                                    }
                                }

                                @Override // com.tencent.soter.core.a.a.b
                                public final void onAuthenticationFailed() {
                                    AppMethodBeat.i(130915);
                                    Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
                                    AppMethodBeat.o(130915);
                                }

                                @Override // com.tencent.soter.core.a.a.b
                                public final void onAuthenticationCancelled() {
                                    AppMethodBeat.i(130916);
                                    super.onAuthenticationCancelled();
                                    AppMethodBeat.o(130916);
                                }
                            });
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(130917);
                    }
                } else {
                    Log.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(130917);
                }
            }
        });
        AppMethodBeat.o(130918);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.byj;
    }
}
