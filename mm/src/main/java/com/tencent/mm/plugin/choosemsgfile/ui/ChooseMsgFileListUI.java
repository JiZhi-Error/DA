package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.choosemsgfile.compat.a;
import com.tencent.mm.plugin.choosemsgfile.b.c.e;
import com.tencent.mm.plugin.choosemsgfile.b.d.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;

public class ChooseMsgFileListUI extends MMActivity implements c {
    private TextView gAp;
    private String goe;
    private int mCount;
    private RecyclerView mRecyclerView;
    private String qnT;
    private String qoP;
    private e qoQ;
    private a qoR = new a();
    private RelativeLayout qoS;
    private Button qoT;
    private ProgressDialog qoU;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChooseMsgFileListUI() {
        AppMethodBeat.i(123388);
        AppMethodBeat.o(123388);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c, com.tencent.mm.ui.MMActivity
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(123401);
        AppCompatActivity context = super.getContext();
        AppMethodBeat.o(123401);
        return context;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(123389);
        h.q(this);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.dq, R.anim.f6do);
        this.goe = getIntent().getStringExtra("USERNAME");
        this.qnT = c.Ir(this.goe);
        this.mCount = getIntent().getIntExtra("COUNT", 9);
        this.qoP = getIntent().getStringExtra("EXTENSION");
        Log.i("MicroMsg.ChooseMsgFileListUI", "onCreate mCount:%d mExtension:%s", Integer.valueOf(this.mCount), this.qoP);
        this.qoQ = new e(this);
        initView();
        findViewById(R.id.bes).setBackgroundColor(getContext().getResources().getColor(R.color.jk));
        this.mRecyclerView.setBackgroundColor(getContext().getResources().getColor(R.color.jk));
        RecyclerView recyclerView = this.mRecyclerView;
        e eVar = this.qoQ;
        if (eVar.oDV == null) {
            eVar.oDV = new LinearLayoutManager();
        }
        recyclerView.setLayoutManager(eVar.oDV);
        this.mRecyclerView.a(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b1: INVOKE  
              (wrap: android.support.v7.widget.RecyclerView : 0x00a8: IGET  (r0v15 android.support.v7.widget.RecyclerView) = (r8v0 'this' com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.mRecyclerView android.support.v7.widget.RecyclerView)
              (wrap: com.tencent.mm.plugin.choosemsgfile.b.c.e$3 : 0x00ae: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.choosemsgfile.b.c.e$3) = 
              (wrap: com.tencent.mm.plugin.choosemsgfile.b.c.e : 0x00aa: IGET  (r1v13 com.tencent.mm.plugin.choosemsgfile.b.c.e) = (r8v0 'this' com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.qoQ com.tencent.mm.plugin.choosemsgfile.b.c.e)
             call: com.tencent.mm.plugin.choosemsgfile.b.c.e.3.<init>(com.tencent.mm.plugin.choosemsgfile.b.c.e):void type: CONSTRUCTOR)
             type: VIRTUAL call: android.support.v7.widget.RecyclerView.a(android.support.v7.widget.RecyclerView$h):void in method: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.onCreate(android.os.Bundle):void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ae: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.choosemsgfile.b.c.e$3) = 
              (wrap: com.tencent.mm.plugin.choosemsgfile.b.c.e : 0x00aa: IGET  (r1v13 com.tencent.mm.plugin.choosemsgfile.b.c.e) = (r8v0 'this' com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.qoQ com.tencent.mm.plugin.choosemsgfile.b.c.e)
             call: com.tencent.mm.plugin.choosemsgfile.b.c.e.3.<init>(com.tencent.mm.plugin.choosemsgfile.b.c.e):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.onCreate(android.os.Bundle):void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.choosemsgfile.b.c.e, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final a cys() {
        return this.qoR;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final String getUserName() {
        return this.goe;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(123390);
        this.gAp = (TextView) findViewById(R.id.g24);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.cgf);
        this.qoS = (RelativeLayout) findViewById(R.id.d8c);
        this.qoT = (Button) findViewById(R.id.ieo);
        AppMethodBeat.o(123390);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(123391);
        super.onResume();
        this.qoQ.onResume();
        AppMethodBeat.o(123391);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(123392);
        super.onPause();
        this.qoQ.onPause();
        AppMethodBeat.o(123392);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(123393);
        super.onDestroy();
        this.qoQ.onDestroy();
        this.qoR.uninit();
        AppMethodBeat.o(123393);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(123394);
        super.finish();
        overridePendingTransition(R.anim.dq, R.anim.f6do);
        AppMethodBeat.o(123394);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.uh;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final void kF(boolean z) {
        AppMethodBeat.i(123395);
        ku(true);
        AppMethodBeat.o(123395);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final void D(boolean z, int i2) {
        AppMethodBeat.i(123396);
        ku(false);
        Log.i("MicroMsg.ChooseMsgFileListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i2));
        if (i2 <= 0) {
            this.gAp.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
            this.gAp.setText(getString(R.string.b3t));
            AppMethodBeat.o(123396);
            return;
        }
        this.gAp.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
        this.mRecyclerView.getAdapter().atj.notifyChanged();
        AppMethodBeat.o(123396);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final View getChildAt(int i2) {
        AppMethodBeat.i(123397);
        View childAt = this.mRecyclerView.getChildAt(i2);
        AppMethodBeat.o(123397);
        return childAt;
    }

    private void ku(boolean z) {
        AppMethodBeat.i(123398);
        Log.i("MicroMsg.ChooseMsgFileListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.qoU = q.a(this, getString(R.string.ekc), true, 0, null);
            AppMethodBeat.o(123398);
            return;
        }
        if (this.qoU != null && this.qoU.isShowing()) {
            this.qoU.dismiss();
            this.qoU = null;
        }
        AppMethodBeat.o(123398);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final void cyJ() {
        AppMethodBeat.i(123399);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(123386);
                ChooseMsgFileListUI.this.qoT.setEnabled(ChooseMsgFileListUI.this.qoR.getSelectCount() > 0);
                AppMethodBeat.o(123386);
            }
        });
        AppMethodBeat.o(123399);
    }

    public static void a(MMActivity mMActivity, String str, int i2, String str2, final a.AbstractC0293a aVar) {
        AppMethodBeat.i(123400);
        Intent intent = new Intent(mMActivity, ChooseMsgFileListUI.class);
        intent.putExtra("USERNAME", str);
        intent.putExtra("COUNT", i2);
        intent.putExtra("EXTENSION", str2);
        mMActivity.mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(123387);
                Log.i("MicroMsg.ChooseMsgFileListUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                Log.d("MicroMsg.ChooseMsgFileListUI", "data:%s", intent);
                c.a(i2, i3, intent, aVar);
                AppMethodBeat.o(123387);
            }
        });
        mMActivity.startActivityForResult(intent, b.qoN);
        AppMethodBeat.o(123400);
    }

    static /* synthetic */ void b(ChooseMsgFileListUI chooseMsgFileListUI) {
        AppMethodBeat.i(123402);
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("FILEPATHS", chooseMsgFileListUI.qoR.cyH());
        chooseMsgFileListUI.setResult(-1, intent);
        chooseMsgFileListUI.finish();
        AppMethodBeat.o(123402);
    }
}
