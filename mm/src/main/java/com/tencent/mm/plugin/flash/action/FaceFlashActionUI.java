package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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

public class FaceFlashActionUI extends MMActivity implements View.OnClickListener {
    private IListener ndY = new IListener<zj>() {
        /* class com.tencent.mm.plugin.flash.action.FaceFlashActionUI.AnonymousClass2 */

        {
            AppMethodBeat.i(186581);
            this.__eventId = zj.class.getName().hashCode();
            AppMethodBeat.o(186581);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(186582);
            switch (zjVar.efx.dKy) {
                case 3:
                    FaceFlashActionUI.this.bm(90030, "finish by voip call");
                    break;
            }
            AppMethodBeat.o(186582);
            return false;
        }
    };
    private long startTime = Util.currentTicks();
    int wHM = 90004;
    private String wHN = "";
    String wHO = "";
    private IListener wHP = new IListener<gt>() {
        /* class com.tencent.mm.plugin.flash.action.FaceFlashActionUI.AnonymousClass3 */

        {
            AppMethodBeat.i(186583);
            this.__eventId = gt.class.getName().hashCode();
            AppMethodBeat.o(186583);
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
    FaceFlashActionPreviewLayout wIg;
    FaceFlashActionProcessLayout wIh;
    private WeImageView wgU;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FaceFlashActionUI() {
        AppMethodBeat.i(186585);
        AppMethodBeat.o(186585);
    }

    static /* synthetic */ Intent axh(String str) {
        AppMethodBeat.i(186605);
        Intent y = y(4, 90030, str);
        AppMethodBeat.o(186605);
        return y;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    public static boolean d(final Activity activity, Bundle bundle) {
        AppMethodBeat.i(186586);
        AnonymousClass1 r1 = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.flash.action.FaceFlashActionUI.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(186580);
                b.s("msgVerify", "camera or mic 正在被占用");
                b.MX(90033);
                activity.setResult(1, FaceFlashActionUI.axh("finish by voip call"));
                activity.finish();
                AppMethodBeat.o(186580);
            }
        };
        if (a.b(activity, r1) || a.c(activity, r1) || a.a(activity, r1) || a.e(activity, r1) || a.d(activity, r1)) {
            AppMethodBeat.o(186586);
            return false;
        }
        Intent intent = new Intent(activity, FaceFlashActionUI.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivityForResult(intent, 1);
        AppMethodBeat.o(186586);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a5t;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(186587);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity onCreate", Integer.valueOf(hashCode()));
        b.axn("enter");
        super.onCreate(bundle);
        getController().p(this, com.tencent.mm.cb.a.n(getContext(), R.color.am));
        this.wIg = (FaceFlashActionPreviewLayout) findViewById(R.id.d5x);
        this.wIh = (FaceFlashActionProcessLayout) findViewById(R.id.d5y);
        this.wgU = (WeImageView) findViewById(R.id.d5u);
        this.wgU.setOnClickListener(this);
        this.ndY.alive();
        EventCenter.instance.addListener(this.wHP);
        com.tencent.mm.plugin.flash.c.a.dLh();
        AppMethodBeat.o(186587);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(186588);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity onResume", Integer.valueOf(hashCode()));
        super.onResume();
        YtSDKKitFramework.getInstance().doResume();
        FaceFlashActionPreviewLayout faceFlashActionPreviewLayout = this.wIg;
        if (faceFlashActionPreviewLayout.getVisibility() == 0 && !faceFlashActionPreviewLayout.wGO.sZd && faceFlashActionPreviewLayout.ltm != null && faceFlashActionPreviewLayout.wGK.getVisibility() != 0) {
            faceFlashActionPreviewLayout.wGO.a(faceFlashActionPreviewLayout.ltm, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004a: INVOKE  
                  (wrap: com.tencent.mm.plugin.flash.b : 0x0041: IGET  (r1v7 com.tencent.mm.plugin.flash.b) = (r0v2 'faceFlashActionPreviewLayout' com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout) com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.wGO com.tencent.mm.plugin.flash.b)
                  (wrap: android.graphics.SurfaceTexture : 0x0043: IGET  (r2v2 android.graphics.SurfaceTexture) = (r0v2 'faceFlashActionPreviewLayout' com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout) com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.ltm android.graphics.SurfaceTexture)
                  (wrap: com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout$7 : 0x0047: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout$7) = (r0v2 'faceFlashActionPreviewLayout' com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout) call: com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.7.<init>(com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.flash.b.a(android.graphics.SurfaceTexture, com.tencent.mm.plugin.flash.b$a):boolean in method: com.tencent.mm.plugin.flash.action.FaceFlashActionUI.onResume():void, file: classes7.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout$7) = (r0v2 'faceFlashActionPreviewLayout' com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout) call: com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.7.<init>(com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.flash.action.FaceFlashActionUI.onResume():void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
                this = this;
                r5 = 186588(0x2d8dc, float:2.61465E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                java.lang.String r0 = "MicroMsg.FaceFlashManager.FaceFlashActionUI"
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
                com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout r0 = r6.wIg
                int r1 = r0.getVisibility()
                if (r1 != 0) goto L_0x004d
                com.tencent.mm.plugin.flash.b r1 = r0.wGO
                boolean r1 = r1.sZd
                if (r1 != 0) goto L_0x004d
                android.graphics.SurfaceTexture r1 = r0.ltm
                if (r1 == 0) goto L_0x004d
                android.widget.ProgressBar r1 = r0.wGK
                int r1 = r1.getVisibility()
                if (r1 == 0) goto L_0x004d
                com.tencent.mm.plugin.flash.b r1 = r0.wGO
                android.graphics.SurfaceTexture r2 = r0.ltm
                com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout$7 r3 = new com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout$7
                r3.<init>()
                r1.a(r2, r3)
            L_0x004d:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.flash.action.FaceFlashActionUI.onResume():void");
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
        public void onPause() {
            AppMethodBeat.i(186589);
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity onPause", Integer.valueOf(hashCode()));
            super.onPause();
            YtSDKKitFramework.getInstance().doPause();
            FaceFlashActionPreviewLayout faceFlashActionPreviewLayout = this.wIg;
            faceFlashActionPreviewLayout.wGO.stopPreview();
            faceFlashActionPreviewLayout.dKO();
            AppMethodBeat.o(186589);
        }

        public void onClick(View view) {
            AppMethodBeat.i(186590);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/action/FaceFlashActionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.d5u) {
                dKT();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186590);
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
        public void onDestroy() {
            AppMethodBeat.i(186591);
            Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onDestroy", Integer.valueOf(hashCode()));
            release();
            super.onDestroy();
            AppMethodBeat.o(186591);
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
        public void finish() {
            AppMethodBeat.i(186592);
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity finish", Integer.valueOf(hashCode()));
            release();
            super.finish();
            AppMethodBeat.o(186592);
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
        public void onBackPressed() {
            AppMethodBeat.i(186593);
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity onBackPressed", Integer.valueOf(hashCode()));
            dKT();
            AppMethodBeat.o(186593);
        }

        public final void reset() {
            AppMethodBeat.i(186594);
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity reset", Integer.valueOf(hashCode()));
            b.axn("reset");
            MP(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
            this.wHN = "";
            this.wHO = "";
            this.wIg.reset();
            this.wIg.setVisibility(0);
            this.wIh.setVisibility(8);
            AppMethodBeat.o(186594);
        }

        private void release() {
            AppMethodBeat.i(186595);
            this.wIh.release();
            this.wIg.release();
            this.ndY.dead();
            EventCenter.instance.removeListener(this.wHP);
            AppMethodBeat.o(186595);
        }

        public final void MP(int i2) {
            AppMethodBeat.i(186596);
            this.wgU.setIconColor(i2);
            AppMethodBeat.o(186596);
        }

        public final void axf(String str) {
            AppMethodBeat.i(186597);
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity showFailedLayout", Integer.valueOf(hashCode()));
            this.wHM = 90006;
            this.wHN = str;
            MP(com.tencent.mm.cb.a.n(getContext(), R.color.fo));
            this.wIg.setVisibility(8);
            this.wIh.setVisibility(0);
            this.wIh.axe(str);
            b.axm(str);
            AppMethodBeat.o(186597);
        }

        public final void bm(int i2, String str) {
            AppMethodBeat.i(258266);
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity finishByUnexpectedError", Integer.valueOf(hashCode()));
            b.s("msgVerify", str);
            b.MX(i2);
            setResult(1, y(4, i2, "fail"));
            finish();
            AppMethodBeat.o(258266);
        }

        @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
        public void onSwipeBack() {
            AppMethodBeat.i(186599);
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "onSwipeBack");
            dKT();
            super.onSwipeBack();
            AppMethodBeat.o(186599);
        }

        private void dKT() {
            AppMethodBeat.i(186600);
            if (!TextUtils.isEmpty(this.wHO)) {
                axg(this.wHO);
                AppMethodBeat.o(186600);
                return;
            }
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity finishByCancel", Integer.valueOf(hashCode()));
            Intent y = y(1, this.wHM, "cancel");
            y.putExtra("scene", getIntent().getIntExtra("scene", 0));
            y.putExtra("totalTime", Util.ticksToNow(this.startTime));
            try {
                if (!TextUtils.isEmpty(this.wHN)) {
                    JSONObject jSONObject = new JSONObject(this.wHN);
                    y.putExtra("serial_id", jSONObject.optString("serial_id"));
                    aO(jSONObject);
                    AppMethodBeat.o(186600);
                    return;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FaceFlashManager.FaceFlashActionUI", e2, "", new Object[0]);
            }
            b.axn("usrCancel");
            b.MX(90004);
            setResult(0, y);
            finish();
            AppMethodBeat.o(186600);
        }

        public final void axg(String str) {
            AppMethodBeat.i(186601);
            try {
                aN(new JSONObject(str));
                AppMethodBeat.o(186601);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FaceFlashManager.FaceFlashActionUI", e2, "", new Object[0]);
                AppMethodBeat.o(186601);
            }
        }

        public final void aN(JSONObject jSONObject) {
            AppMethodBeat.i(186602);
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity finishBySuccess", Integer.valueOf(hashCode()));
            if (isFinishing() || isDestroyed()) {
                AppMethodBeat.o(186602);
                return;
            }
            Intent intent = new Intent();
            Bundle aP = com.tencent.mm.plugin.flash.d.a.aP(jSONObject);
            aP.putString("err_msg", "ok");
            aP.putString("click_other_verify_btn", "no");
            aP.putLong("totalTime", Util.ticksToNow(this.startTime));
            intent.putExtras(aP);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(186602);
        }

        public final void aO(JSONObject jSONObject) {
            AppMethodBeat.i(186603);
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity finishByFailed", Integer.valueOf(hashCode()));
            Intent intent = new Intent();
            Bundle aP = com.tencent.mm.plugin.flash.d.a.aP(jSONObject);
            aP.putString("err_msg", "fail");
            intent.putExtras(aP);
            setResult(1, intent);
            finish();
            AppMethodBeat.o(186603);
        }

        private static Intent y(int i2, int i3, String str) {
            AppMethodBeat.i(186604);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("err_type", i2);
            bundle.putInt("err_code", i3);
            bundle.putString("err_msg", str);
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "face result errorType:%s errorCode:%s errorMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            intent.putExtras(bundle);
            AppMethodBeat.o(186604);
            return intent;
        }
    }
