package com.tencent.mm.plugin.performance.diagnostic;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.performance.diagnostic.b.a;
import com.tencent.mm.plugin.performance.diagnostic.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;

public class DiagnosticSettingsUI extends MMActivity implements View.OnClickListener {
    private CheckBox ASD;
    private CheckBox ASE;
    private CheckBox ASF;
    private CheckBox ASG;
    private CheckBox ASH;
    private CheckBox ASI;
    private CheckBox ASJ;
    private CheckBox ASK;
    private EditText ASL;
    private EditText ASM;
    private EditText ASN;
    private EditText ASO;
    private EditText ASP;
    private EditText ASQ;
    private EditText ASR;
    private Button ASS;
    private Button AST;
    private CheckBox ASU;
    private CheckBox ASV;
    private CheckBox ASW;
    private CheckBox ASX;
    private CheckBox ASY;
    private EditText ASZ;
    private EditText ATa;
    private EditText ATb;
    private EditText ATc;
    private Button ATd;
    private Button ATe;
    private a ATf;
    private com.tencent.mm.plugin.performance.diagnostic.c.a ATg;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public DiagnosticSettingsUI() {
        AppMethodBeat.i(124910);
        AppMethodBeat.o(124910);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124911);
        getWindow().setSoftInputMode(32);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124909);
                DiagnosticSettingsUI.this.finish();
                AppMethodBeat.o(124909);
                return true;
            }
        });
        setMMTitle("诊断模式");
        this.ATf = ((b) com.tencent.mm.plugin.performance.a.a.INSTANCE.aT(b.class)).ATQ;
        this.ATg = ((com.tencent.mm.plugin.performance.diagnostic.c.b) com.tencent.mm.plugin.performance.a.a.INSTANCE.aT(com.tencent.mm.plugin.performance.diagnostic.c.b.class)).ATZ;
        this.ASD = (CheckBox) findViewById(R.id.bp5);
        this.ASE = (CheckBox) findViewById(R.id.bpb);
        this.ASF = (CheckBox) findViewById(R.id.bp_);
        this.ASG = (CheckBox) findViewById(R.id.bp9);
        this.ASH = (CheckBox) findViewById(R.id.bpa);
        this.ASI = (CheckBox) findViewById(R.id.bp8);
        this.ASJ = (CheckBox) findViewById(R.id.bp6);
        this.ASK = (CheckBox) findViewById(R.id.bp7);
        this.ASF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI.AnonymousClass2 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(201031);
                if (z) {
                    DiagnosticSettingsUI.this.ASI.setChecked(false);
                }
                AppMethodBeat.o(201031);
            }
        });
        this.ASG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI.AnonymousClass3 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(201032);
                if (z) {
                    DiagnosticSettingsUI.this.ASI.setChecked(false);
                }
                AppMethodBeat.o(201032);
            }
        });
        this.ASH.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI.AnonymousClass4 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(201033);
                if (z) {
                    DiagnosticSettingsUI.this.ASI.setChecked(false);
                }
                AppMethodBeat.o(201033);
            }
        });
        this.ASI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI.AnonymousClass5 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(201034);
                if (z) {
                    DiagnosticSettingsUI.this.ASF.setChecked(false);
                    DiagnosticSettingsUI.this.ASG.setChecked(false);
                    DiagnosticSettingsUI.this.ASH.setChecked(false);
                }
                AppMethodBeat.o(201034);
            }
        });
        this.ASL = (EditText) findViewById(R.id.bpi);
        this.ASM = (EditText) findViewById(R.id.bpj);
        this.ASN = (EditText) findViewById(R.id.bph);
        this.ASO = (EditText) findViewById(R.id.bpl);
        this.ASP = (EditText) findViewById(R.id.bpk);
        this.ASQ = (EditText) findViewById(R.id.bpm);
        this.ASR = (EditText) findViewById(R.id.bpn);
        this.ASS = (Button) findViewById(R.id.bp1);
        this.AST = (Button) findViewById(R.id.bp2);
        this.ASS.setOnClickListener(this);
        this.AST.setOnClickListener(this);
        this.ASD.setChecked(this.ATf.eBO());
        this.ASE.setChecked(this.ATf.eCb());
        this.ASF.setChecked(this.ATf.getTargetProcess().contains("mm"));
        this.ASG.setChecked(this.ATf.getTargetProcess().contains("appbrand"));
        this.ASH.setChecked(this.ATf.getTargetProcess().contains("tools"));
        this.ASI.setChecked(this.ATf.getTargetProcess().contains("all"));
        this.ASJ.setChecked(this.ATf.eCf());
        this.ASK.setChecked(this.ATf.eCg());
        this.ASL.setText(this.ATf.aJV(".*com\\.tencent\\.mm.*\\.so$"));
        this.ASM.setText(this.ATf.eCa());
        this.ASN.setText(Long.toString((long) this.ATf.Up(1)));
        this.ASO.setText(Integer.toString(this.ATf.eCc()));
        this.ASP.setText(Integer.toString(this.ATf.eCd()));
        this.ASQ.setText(Double.toString(this.ATf.eCe()));
        this.ASU = (CheckBox) findViewById(R.id.bpc);
        this.ASV = (CheckBox) findViewById(R.id.bpf);
        this.ASW = (CheckBox) findViewById(R.id.bpe);
        this.ASX = (CheckBox) findViewById(R.id.bpg);
        this.ASY = (CheckBox) findViewById(R.id.bpd);
        this.ASZ = (EditText) findViewById(R.id.bpp);
        this.ATa = (EditText) findViewById(R.id.bpr);
        this.ATb = (EditText) findViewById(R.id.bpq);
        this.ATc = (EditText) findViewById(R.id.bpo);
        this.ATd = (Button) findViewById(R.id.bp3);
        this.ATe = (Button) findViewById(R.id.bp4);
        this.ASV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI.AnonymousClass6 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(201035);
                if (z) {
                    DiagnosticSettingsUI.this.ASY.setChecked(false);
                }
                AppMethodBeat.o(201035);
            }
        });
        this.ASW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI.AnonymousClass7 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(201036);
                if (z) {
                    DiagnosticSettingsUI.this.ASY.setChecked(false);
                }
                AppMethodBeat.o(201036);
            }
        });
        this.ASX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI.AnonymousClass8 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(201037);
                if (z) {
                    DiagnosticSettingsUI.this.ASY.setChecked(false);
                }
                AppMethodBeat.o(201037);
            }
        });
        this.ASY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI.AnonymousClass9 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(201038);
                if (z) {
                    DiagnosticSettingsUI.this.ASV.setChecked(false);
                    DiagnosticSettingsUI.this.ASW.setChecked(false);
                    DiagnosticSettingsUI.this.ASX.setChecked(false);
                }
                AppMethodBeat.o(201038);
            }
        });
        this.ASU.setChecked(this.ATg.eBO());
        this.ASZ.setText(this.ATg.aJV(".*\\.so$"));
        this.ATa.setText(this.ATg.eCa());
        this.ATb.setText(this.ATg.aJW(".*"));
        this.ATc.setText(Integer.toString(this.ATg.Up(1)));
        this.ASV.setChecked(this.ATg.getTargetProcess().contains("mm"));
        this.ASW.setChecked(this.ATg.getTargetProcess().contains("appbrand"));
        this.ASX.setChecked(this.ATg.getTargetProcess().contains("tools"));
        this.ASY.setChecked(this.ATg.getTargetProcess().contains("all"));
        this.ATd.setOnClickListener(this);
        this.ATe.setOnClickListener(this);
        AppMethodBeat.o(124911);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.zn;
    }

    public void onClick(View view) {
        String str;
        int i2;
        String str2;
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(124912);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        int id = view.getId();
        if (R.id.bp1 == id) {
            if (this.ASI.isChecked()) {
                str2 = "all";
            } else {
                str2 = (this.ASF.isChecked() ? "mm;" : "") + (this.ASG.isChecked() ? "appbrand;" : "") + (this.ASH.isChecked() ? "tools;" : "");
            }
            StringBuilder sb = new StringBuilder("<cmd><diagnostic><MemoryHook enable='");
            if (this.ASD.isChecked()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            StringBuilder append = sb.append(i3).append("' process='").append(str2).append("' source='push' duration='").append(Util.getInt(this.ASN.getText().toString(), 1)).append("' stacklog='").append(Util.getInt(this.ASR.getText().toString(), 52428800)).append("' hook='").append(this.ASL.getText().toString()).append("' ignore='").append(this.ASM.getText().toString()).append("' stack='");
            if (this.ASE.isChecked()) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            StringBuilder append2 = append.append(i4).append("' min='").append(Util.getInt(this.ASO.getText().toString(), 0)).append("' max='").append(Util.getInt(this.ASP.getText().toString(), 0)).append("' sampling='").append(Util.getDouble(this.ASQ.getText().toString(), 1.0d)).append("' extreme='");
            if (this.ASJ.isChecked()) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            StringBuilder append3 = append2.append(i5).append("' mmap='");
            if (this.ASK.isChecked()) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            String sb2 = append3.append(i6).append("'/></diagnostic></cmd>").toString();
            Log.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", sb2);
            com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ(sb2);
            Toast.makeText(this, "MemoryHook:Confirmed, pls restart process", 0).show();
        } else if (R.id.bp2 == id) {
            com.tencent.mm.plugin.performance.a.a.INSTANCE.aA(XmlParser.parseXml("<cmd><diagnostic><report><MemoryHook/></report></diagnostic></cmd>", "cmd", null));
            Toast.makeText(this, "MemoryHook:Reported, pls run `logcat |grep MemoryHookLogic` for result", 0).show();
        } else if (R.id.bp3 == id) {
            if (this.ASY.isChecked()) {
                str = "all";
            } else {
                str = (this.ASV.isChecked() ? "mm;" : "") + (this.ASW.isChecked() ? "appbrand;" : "") + (this.ASX.isChecked() ? "tools;" : "");
            }
            StringBuilder sb3 = new StringBuilder("<cmd><diagnostic><PthreadHook enable='");
            if (this.ASU.isChecked()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            String sb4 = sb3.append(i2).append("' source='push' process='").append(str).append("' duration='").append(Util.getInt(this.ATc.getText().toString(), 1)).append("' hook='").append(this.ASZ.getText().toString()).append("' ignore='").append(this.ATa.getText().toString()).append("' thread='").append(this.ATb.getText().toString()).append("'/></diagnostic></cmd>").toString();
            Log.d("MicroMsg.DiagnosticSettingsUI", "cmd = [%s]", sb4);
            com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ(sb4);
            Toast.makeText(this, "PthreadHook:Confirmed, pls restart process", 0).show();
        } else if (R.id.bp4 == id) {
            com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic><report><PthreadHook/></report></diagnostic></cmd>");
            Toast.makeText(this, "PthreadHook:Reported, pls run `logcat |grep PthreadHookLogic` for result", 0).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/performance/diagnostic/DiagnosticSettingsUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(124912);
    }
}
