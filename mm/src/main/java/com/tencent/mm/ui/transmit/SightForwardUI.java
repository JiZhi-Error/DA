package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView;
import com.tencent.mm.plugin.sight.encode.ui.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.vfs.s;

public class SightForwardUI extends MMActivity {
    private MainSightForwardContainerView QAy;
    private String mPath;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39483);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getSupportActionBar().hide();
        this.mPath = getIntent().getStringExtra("sight_local_path");
        if (!e.aNw(this.mPath)) {
            Log.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", this.mPath);
            finish();
            AppMethodBeat.o(39483);
        } else if (!bg.aAc()) {
            Log.e("MicroMsg.SightForwardUI", "acc not ready");
            finish();
            AppMethodBeat.o(39483);
        } else {
            String Qu = t.Qu(String.valueOf(SystemClock.elapsedRealtime()));
            o.bhj();
            String Qw = t.Qw(Qu);
            if (s.nw(this.mPath, Qw) <= 0) {
                Log.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", this.mPath, Qw);
                finish();
                AppMethodBeat.o(39483);
                return;
            }
            this.mPath = Qw;
            Log.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", this.mPath);
            this.QAy = (MainSightForwardContainerView) findViewById(R.id.d9j);
            this.QAy.setIMainSightViewCallback(new b() {
                /* class com.tencent.mm.ui.transmit.SightForwardUI.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sight.encode.ui.b
                public final void startChattingUI(String str) {
                    AppMethodBeat.i(39481);
                    Intent intent = new Intent(SightForwardUI.this.getContext(), ChattingUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("Chat_User", str);
                    SightForwardUI sightForwardUI = SightForwardUI.this;
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(sightForwardUI, bl.axQ(), "com/tencent/mm/ui/transmit/SightForwardUI$1", "startChattingUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    sightForwardUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(sightForwardUI, "com/tencent/mm/ui/transmit/SightForwardUI$1", "startChattingUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    SightForwardUI.this.finish();
                    AppMethodBeat.o(39481);
                }

                @Override // com.tencent.mm.plugin.sight.encode.ui.b
                public final void eWf() {
                    AppMethodBeat.i(39482);
                    Intent intent = new Intent();
                    intent.setClass(SightForwardUI.this.getContext(), LauncherUI.class).addFlags(67108864);
                    SightForwardUI sightForwardUI = SightForwardUI.this;
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(sightForwardUI, bl.axQ(), "com/tencent/mm/ui/transmit/SightForwardUI$1", "onDismiss", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    sightForwardUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(sightForwardUI, "com/tencent/mm/ui/transmit/SightForwardUI$1", "onDismiss", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    SightForwardUI.this.finish();
                    AppMethodBeat.o(39482);
                }
            });
            MainSightForwardContainerView mainSightForwardContainerView = this.QAy;
            String str = this.mPath;
            mainSightForwardContainerView.Dpx = this;
            mainSightForwardContainerView.Dpt = str;
            mainSightForwardContainerView.Dpr = s.bhK(str);
            long currentTimeMillis = System.currentTimeMillis();
            mainSightForwardContainerView.Dpu = 1.3333334f;
            mainSightForwardContainerView.Dpk = (SightCameraView) ((ViewStub) mainSightForwardContainerView.findViewById(R.id.ai5)).inflate();
            mainSightForwardContainerView.Dpk.setTargetWidth(com.tencent.mm.pluginsdk.l.a.zuP);
            mainSightForwardContainerView.Dpk.setFixPreviewRate(mainSightForwardContainerView.Dpu);
            mainSightForwardContainerView.Dpk.setVisibility(0);
            mainSightForwardContainerView.Dpo = mainSightForwardContainerView.findViewById(R.id.ite);
            mainSightForwardContainerView.Dpo.setLayoutParams(new RelativeLayout.LayoutParams(-1, getSupportActionBar().getHeight()));
            mainSightForwardContainerView.Dpn = mainSightForwardContainerView.findViewById(R.id.f6h);
            mainSightForwardContainerView.zfy = mainSightForwardContainerView.findViewById(R.id.f6i);
            mainSightForwardContainerView.Dpm = mainSightForwardContainerView.findViewById(R.id.ai3);
            mainSightForwardContainerView.Dpn.setOnClickListener(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0133: INVOKE  
                  (wrap: android.view.View : 0x012c: IGET  (r0v36 android.view.View) = (r1v6 'mainSightForwardContainerView' com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView) com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.Dpn android.view.View)
                  (wrap: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$1 : 0x0130: CONSTRUCTOR  (r4v4 com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$1) = (r1v6 'mainSightForwardContainerView' com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView) call: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.1.<init>(com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.tencent.mm.ui.transmit.SightForwardUI.onCreate(android.os.Bundle):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0130: CONSTRUCTOR  (r4v4 com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$1) = (r1v6 'mainSightForwardContainerView' com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView) call: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.1.<init>(com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView):void type: CONSTRUCTOR in method: com.tencent.mm.ui.transmit.SightForwardUI.onCreate(android.os.Bundle):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 25 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 31 more
                */
            /*
            // Method dump skipped, instructions count: 577
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.SightForwardUI.onCreate(android.os.Bundle):void");
        }

        @Override // com.tencent.mm.ui.MMActivity
        public int getLayoutId() {
            return R.layout.b51;
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
        public void onResume() {
            AppMethodBeat.i(39484);
            super.onResume();
            this.QAy.onResume();
            AppMethodBeat.o(39484);
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
        public void onPause() {
            AppMethodBeat.i(39485);
            super.onPause();
            this.QAy.onPause();
            AppMethodBeat.o(39485);
        }
    }
