package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.snackbar.a;

@a(3)
public class VoipScoreDialog extends MMActivity {
    private VoipScoreState GWj;
    private ViewGroup Hfh;
    private ImageView[] Hfi = new ImageView[5];
    private int Hfj = 0;
    private d alertDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoipScoreDialog() {
        AppMethodBeat.i(115385);
        AppMethodBeat.o(115385);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(115386);
        super.onCreate(bundle);
        this.GWj = (VoipScoreState) getIntent().getParcelableExtra("key_score_state");
        if (this.GWj == null) {
            b.e("MicroMsg.VoipScoreDialog", "onCreate error, scoreState is null", new Object[0]);
            finish();
            AppMethodBeat.o(115386);
            return;
        }
        this.Hfh = (ViewGroup) View.inflate(this, R.layout.c72, null);
        this.Hfi[0] = (ImageView) this.Hfh.findViewById(R.id.hb_);
        this.Hfi[1] = (ImageView) this.Hfh.findViewById(R.id.hba);
        this.Hfi[2] = (ImageView) this.Hfh.findViewById(R.id.hbb);
        this.Hfi[3] = (ImageView) this.Hfh.findViewById(R.id.hbc);
        this.Hfi[4] = (ImageView) this.Hfh.findViewById(R.id.hbd);
        for (final int i2 = 0; i2 < this.Hfi.length; i2++) {
            this.Hfi[i2].setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.voip.ui.VoipScoreDialog.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(115379);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipScoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    VoipScoreDialog.a(VoipScoreDialog.this, i2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipScoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(115379);
                }
            });
        }
        f.a aVar = new f.a(this);
        aVar.aC(this.GWj.GYP);
        aVar.hu(this.Hfh);
        aVar.boA(getString(R.string.i47));
        aVar.b(new f.c() {
            /* class com.tencent.mm.plugin.voip.ui.VoipScoreDialog.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(115380);
                VoipScoreDialog.b(VoipScoreDialog.this, 1);
                VoipScoreDialog.this.finish();
                AppMethodBeat.o(115380);
            }
        });
        aVar.Dq(false);
        aVar.b(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.voip.ui.VoipScoreDialog.AnonymousClass3 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(115381);
                VoipScoreDialog.this.finish();
                AppMethodBeat.o(115381);
            }
        });
        this.alertDialog = aVar.kdo;
        if (this.alertDialog != null) {
            this.alertDialog.show();
            AppMethodBeat.o(115386);
            return;
        }
        finish();
        AppMethodBeat.o(115386);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c73;
    }

    static /* synthetic */ void a(VoipScoreDialog voipScoreDialog, int i2) {
        AppMethodBeat.i(115387);
        b.i("MicroMsg.VoipScoreDialog", "onScoreViewClick %s", Integer.valueOf(i2));
        if (i2 >= 0 && i2 < voipScoreDialog.Hfi.length) {
            for (int i3 = 0; i3 <= i2; i3++) {
                voipScoreDialog.Hfi[i3].setImageResource(R.drawable.cq4);
            }
            for (int i4 = i2 + 1; i4 < voipScoreDialog.Hfi.length; i4++) {
                voipScoreDialog.Hfi[i4].setImageResource(R.drawable.cq3);
            }
            voipScoreDialog.Hfj = i2 + 1;
        }
        if (voipScoreDialog.alertDialog != null) {
            voipScoreDialog.alertDialog.a(R.string.i48, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip.ui.VoipScoreDialog.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(115383);
                    VoipScoreDialog.b(VoipScoreDialog.this, 3);
                    com.tencent.mm.ui.widget.snackbar.b.a(VoipScoreDialog.this, (View) null, VoipScoreDialog.this.getString(R.string.i46), new a.c() {
                        /* class com.tencent.mm.plugin.voip.ui.VoipScoreDialog.AnonymousClass4.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.snackbar.a.c
                        public final void onShow() {
                        }

                        @Override // com.tencent.mm.ui.widget.snackbar.a.c
                        public final void onHide() {
                            AppMethodBeat.i(115382);
                            VoipScoreDialog.this.finish();
                            AppMethodBeat.o(115382);
                        }

                        @Override // com.tencent.mm.ui.widget.snackbar.a.c
                        public final void bDY() {
                        }
                    });
                    if (VoipScoreDialog.this.alertDialog != null) {
                        VoipScoreDialog.this.alertDialog.dismiss();
                    }
                    AppMethodBeat.o(115383);
                }
            });
            voipScoreDialog.alertDialog.b(R.string.sz, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip.ui.VoipScoreDialog.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(115384);
                    VoipScoreDialog.b(VoipScoreDialog.this, 2);
                    VoipScoreDialog.this.finish();
                    AppMethodBeat.o(115384);
                }
            });
        }
        AppMethodBeat.o(115387);
    }

    static /* synthetic */ void b(VoipScoreDialog voipScoreDialog, int i2) {
        AppMethodBeat.i(115388);
        b.i("MicroMsg.VoipScoreDialog", "doScoreStat %s %s %s", Integer.valueOf(voipScoreDialog.Hfj), Integer.valueOf(i2), voipScoreDialog.GWj);
        h.INSTANCE.a(15684, Integer.valueOf(voipScoreDialog.GWj.roomId), Long.valueOf(voipScoreDialog.GWj.ypH), Integer.valueOf(i2), Integer.valueOf(voipScoreDialog.Hfj), Integer.valueOf(voipScoreDialog.GWj.GYQ), Long.valueOf(voipScoreDialog.GWj.GYR), Long.valueOf(voipScoreDialog.GWj.yrb));
        AppMethodBeat.o(115388);
    }
}
