package com.tencent.mm.plugin.flash;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import org.json.JSONObject;

public class FaceFlashUI extends MMActivity implements View.OnClickListener {
    private IListener ndY = new IListener<zj>() {
        /* class com.tencent.mm.plugin.flash.FaceFlashUI.AnonymousClass2 */

        {
            AppMethodBeat.i(186479);
            this.__eventId = zj.class.getName().hashCode();
            AppMethodBeat.o(186479);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(186480);
            switch (zjVar.efx.dKy) {
                case 3:
                    FaceFlashUI.this.bm(90030, "finish by voip call");
                    break;
            }
            AppMethodBeat.o(186480);
            return false;
        }
    };
    private long startTime = Util.currentTicks();
    FaceFlashPreviewLayout wHK;
    FaceFlashProcessLayout wHL;
    int wHM = 90004;
    private String wHN = "";
    String wHO = "";
    private IListener wHP = new IListener<gt>() {
        /* class com.tencent.mm.plugin.flash.FaceFlashUI.AnonymousClass3 */

        {
            AppMethodBeat.i(186481);
            this.__eventId = gt.class.getName().hashCode();
            AppMethodBeat.o(186481);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(gt gtVar) {
            gt gtVar2 = gtVar;
            if (gtVar2 != null) {
                gtVar2.dKN.dKO = true;
            }
            return false;
        }
    };
    private WeImageView wgU;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FaceFlashUI() {
        AppMethodBeat.i(186484);
        AppMethodBeat.o(186484);
    }

    static /* synthetic */ Intent axh(String str) {
        AppMethodBeat.i(186505);
        Intent y = y(4, 90030, str);
        AppMethodBeat.o(186505);
        return y;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    public static boolean a(final Activity activity, Bundle bundle, int i2) {
        AppMethodBeat.i(186485);
        AnonymousClass1 r0 = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.flash.FaceFlashUI.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(186478);
                b.s("msgVerify", "camera or mic 正在被占用");
                b.MW(90033);
                activity.setResult(1, FaceFlashUI.axh("finish by voip call"));
                activity.finish();
                AppMethodBeat.o(186478);
            }
        };
        if (a.b(activity, r0) || a.c(activity, r0) || a.a(activity, r0) || a.e(activity, r0) || a.d(activity, r0)) {
            AppMethodBeat.o(186485);
            return false;
        }
        Intent intent = new Intent(activity, FaceFlashUI.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivityForResult(intent, i2);
        AppMethodBeat.o(186485);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a5v;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(186486);
        Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onCreate", Integer.valueOf(hashCode()));
        super.onCreate(bundle);
        b.au(getIntent());
        b.axn("enter");
        b.dLi().erd = System.currentTimeMillis();
        getController().p(this, com.tencent.mm.cb.a.n(getContext(), R.color.am));
        this.wHK = (FaceFlashPreviewLayout) findViewById(R.id.d5x);
        this.wHL = (FaceFlashProcessLayout) findViewById(R.id.d5y);
        this.wgU = (WeImageView) findViewById(R.id.d5u);
        this.wgU.setOnClickListener(this);
        this.ndY.alive();
        EventCenter.instance.addListener(this.wHP);
        com.tencent.mm.plugin.flash.c.a.dLh();
        AppMethodBeat.o(186486);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(186487);
        Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onResume", Integer.valueOf(hashCode()));
        super.onResume();
        YtSDKKitFramework.getInstance().doResume();
        FaceFlashPreviewLayout faceFlashPreviewLayout = this.wHK;
        if (faceFlashPreviewLayout.wHb == -1) {
            faceFlashPreviewLayout.wHb = faceFlashPreviewLayout.getDegree();
        }
        if (faceFlashPreviewLayout.getVisibility() == 0 && !faceFlashPreviewLayout.wGO.sZd && faceFlashPreviewLayout.ltm != null && faceFlashPreviewLayout.wGK.getVisibility() != 0) {
            faceFlashPreviewLayout.wGO.a(faceFlashPreviewLayout.ltm, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0055: INVOKE  
                  (wrap: com.tencent.mm.plugin.flash.b : 0x004c: IGET  (r1v8 com.tencent.mm.plugin.flash.b) = (r0v2 'faceFlashPreviewLayout' com.tencent.mm.plugin.flash.FaceFlashPreviewLayout) com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.wGO com.tencent.mm.plugin.flash.b)
                  (wrap: android.graphics.SurfaceTexture : 0x004e: IGET  (r2v3 android.graphics.SurfaceTexture) = (r0v2 'faceFlashPreviewLayout' com.tencent.mm.plugin.flash.FaceFlashPreviewLayout) com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.ltm android.graphics.SurfaceTexture)
                  (wrap: com.tencent.mm.plugin.flash.FaceFlashPreviewLayout$10 : 0x0052: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.flash.FaceFlashPreviewLayout$10) = (r0v2 'faceFlashPreviewLayout' com.tencent.mm.plugin.flash.FaceFlashPreviewLayout) call: com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.10.<init>(com.tencent.mm.plugin.flash.FaceFlashPreviewLayout):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.flash.b.a(android.graphics.SurfaceTexture, com.tencent.mm.plugin.flash.b$a):boolean in method: com.tencent.mm.plugin.flash.FaceFlashUI.onResume():void, file: classes7.dex
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
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0052: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.flash.FaceFlashPreviewLayout$10) = (r0v2 'faceFlashPreviewLayout' com.tencent.mm.plugin.flash.FaceFlashPreviewLayout) call: com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.10.<init>(com.tencent.mm.plugin.flash.FaceFlashPreviewLayout):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.flash.FaceFlashUI.onResume():void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.flash.FaceFlashPreviewLayout, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
                this = this;
                r5 = 186487(0x2d877, float:2.61324E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                java.lang.String r0 = "MicroMsg.FaceFlashManager"
                java.lang.String r1 = "[%s]FaceFlashActivity onResume"
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                int r4 = r6.hashCode()
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r2[r3] = r4
                com.tencent.mm.sdk.platformtools.Log.i(r0, r1, r2)
                super.onResume()
                com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework r0 = com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.getInstance()
                r0.doResume()
                com.tencent.mm.plugin.flash.FaceFlashPreviewLayout r0 = r6.wHK
                int r1 = r0.wHb
                r2 = -1
                if (r1 != r2) goto L_0x0034
                int r1 = r0.getDegree()
                r0.wHb = r1
            L_0x0034:
                int r1 = r0.getVisibility()
                if (r1 != 0) goto L_0x0058
                com.tencent.mm.plugin.flash.b r1 = r0.wGO
                boolean r1 = r1.sZd
                if (r1 != 0) goto L_0x0058
                android.graphics.SurfaceTexture r1 = r0.ltm
                if (r1 == 0) goto L_0x0058
                android.widget.ProgressBar r1 = r0.wGK
                int r1 = r1.getVisibility()
                if (r1 == 0) goto L_0x0058
                com.tencent.mm.plugin.flash.b r1 = r0.wGO
                android.graphics.SurfaceTexture r2 = r0.ltm
                com.tencent.mm.plugin.flash.FaceFlashPreviewLayout$10 r3 = new com.tencent.mm.plugin.flash.FaceFlashPreviewLayout$10
                r3.<init>()
                r1.a(r2, r3)
            L_0x0058:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.flash.FaceFlashUI.onResume():void");
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
        public void onPause() {
            AppMethodBeat.i(186488);
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onPause", Integer.valueOf(hashCode()));
            super.onPause();
            YtSDKKitFramework.getInstance().doPause();
            FaceFlashPreviewLayout faceFlashPreviewLayout = this.wHK;
            faceFlashPreviewLayout.wGO.stopPreview();
            faceFlashPreviewLayout.dKO();
            AppMethodBeat.o(186488);
        }

        public void onClick(View view) {
            AppMethodBeat.i(186489);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/FaceFlashUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.d5u) {
                dKT();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186489);
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
        public void onDestroy() {
            AppMethodBeat.i(186490);
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onDestroy", Integer.valueOf(hashCode()));
            release();
            super.onDestroy();
            AppMethodBeat.o(186490);
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
        public void finish() {
            AppMethodBeat.i(186491);
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finish", Integer.valueOf(hashCode()));
            release();
            super.finish();
            AppMethodBeat.o(186491);
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
        public void onBackPressed() {
            AppMethodBeat.i(186492);
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onBackPressed", Integer.valueOf(hashCode()));
            dKT();
            AppMethodBeat.o(186492);
        }

        public final void reset() {
            AppMethodBeat.i(186493);
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity reset", Integer.valueOf(hashCode()));
            b.axn("reset");
            b.dLi().erd = System.currentTimeMillis();
            MP(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
            this.wHN = "";
            this.wHO = "";
            this.wHK.reset();
            this.wHK.setVisibility(0);
            this.wHL.setVisibility(8);
            b.dLk().eqF++;
            AppMethodBeat.o(186493);
        }

        private void release() {
            AppMethodBeat.i(186494);
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.flash.FaceFlashUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(186482);
                    FaceFlashProcessLayout faceFlashProcessLayout = FaceFlashUI.this.wHL;
                    faceFlashProcessLayout.wHB.cancel();
                    faceFlashProcessLayout.wHC.cancel();
                    faceFlashProcessLayout.wHD.cancel();
                    FaceFlashPreviewLayout faceFlashPreviewLayout = FaceFlashUI.this.wHK;
                    Log.i("MicroMsg.FaceFlashManager", "release");
                    faceFlashPreviewLayout.wGG.clearAnimation();
                    faceFlashPreviewLayout.wGH.clearAnimation();
                    a.dKS();
                    faceFlashPreviewLayout.wGO.dKU();
                    faceFlashPreviewLayout.wGR.release();
                    faceFlashPreviewLayout.wHi.cancel();
                    if (faceFlashPreviewLayout.wHc != null) {
                        faceFlashPreviewLayout.wHc.cancel(true);
                        faceFlashPreviewLayout.wHc = null;
                    }
                    FaceFlashUI.this.ndY.dead();
                    EventCenter.instance.removeListener(FaceFlashUI.this.wHP);
                    AppMethodBeat.o(186482);
                }
            });
            AppMethodBeat.o(186494);
        }

        public final void MP(int i2) {
            AppMethodBeat.i(186495);
            this.wgU.setIconColor(i2);
            AppMethodBeat.o(186495);
        }

        public final void axf(String str) {
            AppMethodBeat.i(186496);
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity showFailedLayout", Integer.valueOf(hashCode()));
            this.wHM = 90006;
            this.wHN = str;
            MP(com.tencent.mm.cb.a.n(getContext(), R.color.fo));
            this.wHK.setVisibility(8);
            this.wHL.setVisibility(0);
            this.wHL.axe(str);
            b.axl(str);
            AppMethodBeat.o(186496);
        }

        public final void bm(int i2, String str) {
            AppMethodBeat.i(186497);
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByUnexpectedError", Integer.valueOf(hashCode()));
            b.s("msgVerify", str);
            b.MW(i2);
            b.pr(false);
            setResult(1, y(4, i2, str));
            finish();
            AppMethodBeat.o(186497);
        }

        @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
        public void onSwipeBack() {
            AppMethodBeat.i(186498);
            Log.i("MicroMsg.FaceFlashManager", "onSwipeBack");
            dKT();
            super.onSwipeBack();
            AppMethodBeat.o(186498);
        }

        private void dKT() {
            AppMethodBeat.i(186499);
            if (!TextUtils.isEmpty(this.wHO)) {
                axg(this.wHO);
                AppMethodBeat.o(186499);
                return;
            }
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByCancel", Integer.valueOf(hashCode()));
            Intent y = y(1, this.wHM, "cancel");
            y.putExtra("scene", getIntent().getIntExtra("scene", 0));
            y.putExtra("totalTime", Util.ticksToNow(this.startTime));
            try {
                if (!TextUtils.isEmpty(this.wHN)) {
                    JSONObject jSONObject = new JSONObject(this.wHN);
                    y.putExtra("serial_id", jSONObject.optString("serial_id"));
                    aO(jSONObject);
                    AppMethodBeat.o(186499);
                    return;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FaceFlashManager", e2, "", new Object[0]);
            }
            b.axn("usrCancel");
            b.pr(false);
            b.MW(90004);
            setResult(0, y);
            finish();
            AppMethodBeat.o(186499);
        }

        public final void axg(String str) {
            AppMethodBeat.i(186500);
            try {
                aN(new JSONObject(str));
                AppMethodBeat.o(186500);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FaceFlashManager", e2, "", new Object[0]);
                AppMethodBeat.o(186500);
            }
        }

        public final void aN(JSONObject jSONObject) {
            AppMethodBeat.i(186501);
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishBySuccess", Integer.valueOf(hashCode()));
            if (isFinishing() || isDestroyed()) {
                AppMethodBeat.o(186501);
                return;
            }
            b.pr(true);
            Intent intent = new Intent();
            Bundle aP = com.tencent.mm.plugin.flash.d.a.aP(jSONObject);
            aP.putString("click_other_verify_btn", "no");
            aP.putLong("totalTime", Util.ticksToNow(this.startTime));
            intent.putExtras(aP);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(186501);
        }

        public final void aO(JSONObject jSONObject) {
            AppMethodBeat.i(186502);
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByFailed", Integer.valueOf(hashCode()));
            b.pr(false);
            Intent intent = new Intent();
            intent.putExtras(com.tencent.mm.plugin.flash.d.a.aP(jSONObject));
            setResult(1, intent);
            finish();
            AppMethodBeat.o(186502);
        }

        private static Intent y(int i2, int i3, String str) {
            AppMethodBeat.i(186503);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("err_type", i2);
            bundle.putInt("err_code", i3);
            bundle.putString("err_msg", str);
            Log.i("MicroMsg.FaceFlashManager", "face result errorType:%s errorCode:%s errorMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            intent.putExtras(bundle);
            AppMethodBeat.o(186503);
            return intent;
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
        public void onConfigurationChanged(Configuration configuration) {
            AppMethodBeat.i(186504);
            super.onConfigurationChanged(configuration);
            Log.i("MicroMsg.FaceFlashManager", "screen orientation %d", Integer.valueOf(configuration.orientation));
            this.wHK.onConfigurationChanged(configuration);
            AppMethodBeat.o(186504);
        }
    }
