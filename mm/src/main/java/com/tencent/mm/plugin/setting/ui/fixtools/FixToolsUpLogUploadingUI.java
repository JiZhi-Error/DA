package com.tencent.mm.plugin.setting.ui.fixtools;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class FixToolsUpLogUploadingUI extends MMWizardActivity {
    public a.AbstractC1686a CXD = new a.AbstractC1686a() {
        /* class com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.setting.model.a.AbstractC1686a
        public final void Xn(int i2) {
            AppMethodBeat.i(73817);
            Log.i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", Integer.valueOf(i2));
            if (i2 < 0) {
                h.INSTANCE.idkeyStat(873, 18, 1, false);
                FixToolsUpLogUploadingUI.this.CYy.setImageResource(R.raw.fix_tools_failed);
                FixToolsUpLogUploadingUI.this.CYx.setText(R.string.dcn);
                FixToolsUpLogUploadingUI.this.CYz.setVisibility(8);
                FixToolsUpLogUploadingUI.this.gwO.setVisibility(0);
                AppMethodBeat.o(73817);
            } else if (i2 >= 100) {
                h.INSTANCE.idkeyStat(873, 17, 1, false);
                FixToolsUpLogUploadingUI.this.CYy.setImageResource(R.raw.fix_tools_finish);
                FixToolsUpLogUploadingUI.this.CYx.setText(R.string.dco);
                FixToolsUpLogUploadingUI.this.CYz.setVisibility(8);
                FixToolsUpLogUploadingUI.this.gwO.setVisibility(0);
                AppMethodBeat.o(73817);
            } else {
                FixToolsUpLogUploadingUI.this.CYz.setProgress(i2);
                AppMethodBeat.o(73817);
            }
        }
    };
    private TextView CYx;
    private ImageView CYy;
    protected ProgressBar CYz;
    private Button gwO;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FixToolsUpLogUploadingUI() {
        AppMethodBeat.i(73818);
        AppMethodBeat.o(73818);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73819);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(73819);
            return;
        }
        setMMTitle(R.string.dcl);
        this.CYx = (TextView) findViewById(R.id.d5m);
        this.CYy = (ImageView) findViewById(R.id.d5j);
        this.gwO = (Button) findViewById(R.id.d5i);
        this.CYz = (ProgressBar) findViewById(R.id.d5k);
        this.CYy.setImageResource(R.raw.fix_tools_uplog);
        this.CYx.setText(R.string.dcr);
        this.gwO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(73815);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUpLogUploadingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FixToolsUpLogUploadingUI.a(FixToolsUpLogUploadingUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUpLogUploadingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73815);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73816);
                FixToolsUpLogUploadingUI.b(FixToolsUpLogUploadingUI.this);
                AppMethodBeat.o(73816);
                return true;
            }
        });
        this.CYz.setVisibility(0);
        this.gwO.setVisibility(8);
        String stringExtra = getIntent().getStringExtra(FFmpegMetadataRetriever.METADATA_KEY_DATE);
        com.tencent.mm.plugin.setting.model.a eSG = com.tencent.mm.plugin.setting.model.a.eSG();
        com.tencent.mm.plugin.setting.model.a.CXD = this.CXD;
        Log.i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", stringExtra, Boolean.valueOf(eSG.jkK));
        if (!eSG.jkK) {
            eSG.jkK = true;
            String str = "weixin";
            if (g.aAc()) {
                str = z.aTY();
            }
            long agD = com.tencent.mm.plugin.setting.model.a.agD(new StringBuffer(stringExtra).append("000000").toString());
            int nowMilliSecond = (int) ((((((Util.nowMilliSecond() / Util.MILLSECONDS_OF_DAY) * Util.MILLSECONDS_OF_DAY) + 57600000) - 1) - agD) / Util.MILLSECONDS_OF_DAY);
            Log.i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", Long.valueOf(agD), Integer.valueOf(nowMilliSecond));
            g.azz().a(new bu(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0108: INVOKE  
                  (wrap: com.tencent.mm.ak.t : 0x00fa: INVOKE  (r3v4 com.tencent.mm.ak.t) =  type: STATIC call: com.tencent.mm.kernel.g.azz():com.tencent.mm.ak.t)
                  (wrap: com.tencent.mm.model.bu : 0x0105: CONSTRUCTOR  (r4v9 com.tencent.mm.model.bu) = 
                  (wrap: com.tencent.mm.plugin.setting.model.a$1 : 0x0102: CONSTRUCTOR  (r5v3 com.tencent.mm.plugin.setting.model.a$1) = (r2v0 'eSG' com.tencent.mm.plugin.setting.model.a), (r0v27 'str' java.lang.String), (r1v10 'nowMilliSecond' int) call: com.tencent.mm.plugin.setting.model.a.1.<init>(com.tencent.mm.plugin.setting.model.a, java.lang.String, int):void type: CONSTRUCTOR)
                 call: com.tencent.mm.model.bu.<init>(com.tencent.mm.model.bu$a):void type: CONSTRUCTOR)
                  (0 int)
                 type: VIRTUAL call: com.tencent.mm.ak.t.a(com.tencent.mm.ak.q, int):boolean in method: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI.onCreate(android.os.Bundle):void, file: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0105: CONSTRUCTOR  (r4v9 com.tencent.mm.model.bu) = 
                  (wrap: com.tencent.mm.plugin.setting.model.a$1 : 0x0102: CONSTRUCTOR  (r5v3 com.tencent.mm.plugin.setting.model.a$1) = (r2v0 'eSG' com.tencent.mm.plugin.setting.model.a), (r0v27 'str' java.lang.String), (r1v10 'nowMilliSecond' int) call: com.tencent.mm.plugin.setting.model.a.1.<init>(com.tencent.mm.plugin.setting.model.a, java.lang.String, int):void type: CONSTRUCTOR)
                 call: com.tencent.mm.model.bu.<init>(com.tencent.mm.model.bu$a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI.onCreate(android.os.Bundle):void, file: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 23 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0102: CONSTRUCTOR  (r5v3 com.tencent.mm.plugin.setting.model.a$1) = (r2v0 'eSG' com.tencent.mm.plugin.setting.model.a), (r0v27 'str' java.lang.String), (r1v10 'nowMilliSecond' int) call: com.tencent.mm.plugin.setting.model.a.1.<init>(com.tencent.mm.plugin.setting.model.a, java.lang.String, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI.onCreate(android.os.Bundle):void, file: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:663)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 29 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.setting.model.a, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 35 more
                */
            /*
            // Method dump skipped, instructions count: 280
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI.onCreate(android.os.Bundle):void");
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            AppMethodBeat.i(73820);
            if (i2 == 4) {
                ala(1);
                AppMethodBeat.o(73820);
                return true;
            }
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(73820);
            return onKeyDown;
        }

        @Override // com.tencent.mm.ui.MMActivity
        public int getLayoutId() {
            return R.layout.alr;
        }

        static /* synthetic */ void a(FixToolsUpLogUploadingUI fixToolsUpLogUploadingUI) {
            AppMethodBeat.i(73821);
            fixToolsUpLogUploadingUI.ala(1);
            AppMethodBeat.o(73821);
        }

        static /* synthetic */ void b(FixToolsUpLogUploadingUI fixToolsUpLogUploadingUI) {
            AppMethodBeat.i(73822);
            fixToolsUpLogUploadingUI.ala(1);
            AppMethodBeat.o(73822);
        }
    }
