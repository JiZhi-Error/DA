package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.choosemsgfile.compat.a;
import com.tencent.mm.plugin.choosemsgfile.b.c.f;
import com.tencent.mm.plugin.choosemsgfile.b.d.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.e;

public class ChooseMsgFileUI extends MMActivity implements c {
    private TextView gAp;
    private String goe;
    private int mCount;
    private String mType;
    private String qnT;
    private String qoP;
    private a qoR = new a();
    private RelativeLayout qoS;
    private Button qoT;
    private ProgressDialog qoU;
    private f qpe;
    private TextView qpf;
    private RecyclerView qpg;
    private TextView qph;
    private TextView qpi;
    private ImageButton qpj;
    private TextView qpk;
    private boolean qpl = true;
    private int qpm;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChooseMsgFileUI() {
        AppMethodBeat.i(123435);
        AppMethodBeat.o(123435);
    }

    static /* synthetic */ void a(ChooseMsgFileUI chooseMsgFileUI, String str) {
        AppMethodBeat.i(123452);
        chooseMsgFileUI.akD(str);
        AppMethodBeat.o(123452);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c, com.tencent.mm.ui.MMActivity
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(123449);
        AppCompatActivity context = super.getContext();
        AppMethodBeat.o(123449);
        return context;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(123436);
        h.q(this);
        super.onCreate(bundle);
        this.goe = getIntent().getStringExtra("USERNAME");
        this.qnT = c.Ir(this.goe);
        this.mType = c.akA(getIntent().getStringExtra("TYPE"));
        this.mCount = getIntent().getIntExtra("COUNT", 9);
        this.qoP = getIntent().getStringExtra("EXTENSION");
        Log.i("MicroMsg.ChooseMsgFileUI", "select msg file from username:%s nickname:%s, type:%s, count:%d", this.goe, this.qnT, this.mType, Integer.valueOf(this.mCount));
        Log.i("MicroMsg.ChooseMsgFileUI", "select msg file from extension:%s", this.qoP);
        this.qoR.init(this.mCount);
        this.qpe = new f(this);
        initView();
        this.qpg.setLayoutManager(this.qpe.eS(this));
        this.qpg.a(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a6: INVOKE  
              (wrap: android.support.v7.widget.RecyclerView : 0x009d: IGET  (r0v16 android.support.v7.widget.RecyclerView) = (r8v0 'this' com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.qpg android.support.v7.widget.RecyclerView)
              (wrap: com.tencent.mm.plugin.choosemsgfile.b.c.f$4 : 0x00a3: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.choosemsgfile.b.c.f$4) = 
              (wrap: com.tencent.mm.plugin.choosemsgfile.b.c.f : 0x009f: IGET  (r1v9 com.tencent.mm.plugin.choosemsgfile.b.c.f) = (r8v0 'this' com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.qpe com.tencent.mm.plugin.choosemsgfile.b.c.f)
              (r8v0 'this' com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI A[IMMUTABLE_TYPE, THIS])
             call: com.tencent.mm.plugin.choosemsgfile.b.c.f.4.<init>(com.tencent.mm.plugin.choosemsgfile.b.c.f, android.content.Context):void type: CONSTRUCTOR)
             type: VIRTUAL call: android.support.v7.widget.RecyclerView.a(android.support.v7.widget.RecyclerView$h):void in method: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.onCreate(android.os.Bundle):void, file: classes5.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a3: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.choosemsgfile.b.c.f$4) = 
              (wrap: com.tencent.mm.plugin.choosemsgfile.b.c.f : 0x009f: IGET  (r1v9 com.tencent.mm.plugin.choosemsgfile.b.c.f) = (r8v0 'this' com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.qpe com.tencent.mm.plugin.choosemsgfile.b.c.f)
              (r8v0 'this' com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI A[IMMUTABLE_TYPE, THIS])
             call: com.tencent.mm.plugin.choosemsgfile.b.c.f.4.<init>(com.tencent.mm.plugin.choosemsgfile.b.c.f, android.content.Context):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.onCreate(android.os.Bundle):void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.choosemsgfile.b.c.f, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 294
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final a cys() {
        return this.qoR;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final String getUserName() {
        return this.goe;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(123437);
        super.onResume();
        this.qpe.onResume();
        AppMethodBeat.o(123437);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(123438);
        super.onPause();
        Log.i("MicroMsg.ChooseMsgFileUIController", "onPause");
        AppMethodBeat.o(123438);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(123439);
        super.onDestroy();
        this.qpe.onDestroy();
        this.qoR.uninit();
        AppMethodBeat.o(123439);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(123440);
        this.gAp = (TextView) findViewById(R.id.g24);
        this.qpf = (TextView) findViewById(R.id.bki);
        this.qpg = (RecyclerView) findViewById(R.id.cgf);
        this.qoS = (RelativeLayout) findViewById(R.id.d8c);
        this.qph = (TextView) findViewById(R.id.cib);
        this.qpi = (TextView) findViewById(R.id.cic);
        this.qpj = (ImageButton) findViewById(R.id.g74);
        this.qpk = (TextView) findViewById(R.id.g76);
        this.qoT = (Button) findViewById(R.id.ieo);
        AppMethodBeat.o(123440);
    }

    private void akD(String str) {
        AppMethodBeat.i(123441);
        if ("image".equals(str) || "all".equals(str)) {
            this.qpj.setVisibility(0);
            this.qpk.setVisibility(0);
        } else {
            this.qpj.setVisibility(4);
            this.qpk.setVisibility(4);
        }
        if ("all".equals(this.mType)) {
            this.qph.setVisibility(0);
            this.qpi.setVisibility(0);
            akE(str);
            AppMethodBeat.o(123441);
            return;
        }
        this.qph.setVisibility(4);
        this.qpi.setVisibility(4);
        AppMethodBeat.o(123441);
    }

    private void akE(String str) {
        AppMethodBeat.i(123442);
        if ("all".equals(str)) {
            this.qpi.setText("");
            AppMethodBeat.o(123442);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        if ("image".equals(str)) {
            sb.append(getString(R.string.b3x));
        } else if ("video".equals(str)) {
            sb.append(getString(R.string.b3y));
        } else if ("file".equals(str)) {
            sb.append(getString(R.string.b3w));
        }
        sb.append(")");
        this.qpi.setText(sb.toString());
        AppMethodBeat.o(123442);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final void kF(boolean z) {
        AppMethodBeat.i(123443);
        if (z) {
            kH(true);
            AppMethodBeat.o(123443);
            return;
        }
        this.qpm = ((GridLayoutManager) this.qpg.getLayoutManager()).ku();
        AppMethodBeat.o(123443);
    }

    private void kH(boolean z) {
        AppMethodBeat.i(123444);
        Log.i("MicroMsg.ChooseMsgFileUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.qoU = q.a(this, getString(R.string.ekc), true, 0, null);
            AppMethodBeat.o(123444);
            return;
        }
        if (this.qoU != null && this.qoU.isShowing()) {
            this.qoU.dismiss();
            this.qoU = null;
        }
        AppMethodBeat.o(123444);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final void D(boolean z, int i2) {
        AppMethodBeat.i(123445);
        Log.i("MicroMsg.ChooseMsgFileUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i2));
        if (z) {
            kH(false);
            this.qpg.getAdapter().atj.notifyChanged();
            int itemCount = this.qpg.getAdapter().getItemCount();
            RecyclerView recyclerView = this.qpg;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(itemCount - 1, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
            recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
            if (i2 <= 0) {
                this.gAp.setVisibility(0);
                this.qpg.setVisibility(8);
                this.gAp.setText(getString(R.string.b3t));
                AppMethodBeat.o(123445);
                return;
            }
            this.gAp.setVisibility(8);
            this.qpg.setVisibility(0);
            AppMethodBeat.o(123445);
        } else if (i2 > 0) {
            this.qpg.getAdapter().as(0, i2);
            this.qpg.getAdapter().aq(i2, this.qpm + i2);
            AppMethodBeat.o(123445);
        } else {
            this.qpg.getAdapter().ci(0);
            AppMethodBeat.o(123445);
        }
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final void cyJ() {
        AppMethodBeat.i(123446);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(123424);
                ChooseMsgFileUI.this.qoT.setEnabled(ChooseMsgFileUI.this.qoR.getSelectCount() > 0);
                AppMethodBeat.o(123424);
            }
        });
        AppMethodBeat.o(123446);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.ui.c
    public final View getChildAt(int i2) {
        AppMethodBeat.i(123447);
        View childAt = this.qpg.getChildAt(i2);
        AppMethodBeat.o(123447);
        return childAt;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ui;
    }

    public static void a(MMActivity mMActivity, String str, String str2, int i2, String str3, final a.AbstractC0293a aVar) {
        AppMethodBeat.i(123448);
        Intent intent = new Intent(mMActivity, ChooseMsgFileUI.class);
        intent.putExtra("USERNAME", str);
        intent.putExtra("TYPE", str2);
        intent.putExtra("COUNT", i2);
        intent.putExtra("EXTENSION", str3);
        mMActivity.mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(123425);
                Log.i("MicroMsg.ChooseMsgFileUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                Log.d("MicroMsg.ChooseMsgFileUI", "data:%s", intent);
                c.a(i2, i3, intent, aVar);
                AppMethodBeat.o(123425);
            }
        });
        mMActivity.startActivityForResult(intent, b.qoN);
        AppMethodBeat.o(123448);
    }

    static /* synthetic */ void c(ChooseMsgFileUI chooseMsgFileUI) {
        AppMethodBeat.i(123450);
        e eVar = new e((Context) chooseMsgFileUI.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(123433);
                mVar.d(0, ChooseMsgFileUI.this.getString(R.string.b3v));
                mVar.d(1, ChooseMsgFileUI.this.getString(R.string.b3x));
                mVar.d(2, ChooseMsgFileUI.this.getString(R.string.b3y));
                mVar.d(3, ChooseMsgFileUI.this.getString(R.string.b3w));
                AppMethodBeat.o(123433);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                String str;
                AppMethodBeat.i(123434);
                String unused = ChooseMsgFileUI.this.mType;
                switch (i2) {
                    case 0:
                        str = "all";
                        break;
                    case 1:
                        str = "image";
                        break;
                    case 2:
                        str = "video";
                        break;
                    case 3:
                        str = "file";
                        break;
                    default:
                        str = "all";
                        break;
                }
                ChooseMsgFileUI.this.qpe.c(true, str, ChooseMsgFileUI.this.qoP);
                ChooseMsgFileUI.a(ChooseMsgFileUI.this, str);
                AppMethodBeat.o(123434);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(123450);
    }

    static /* synthetic */ void d(ChooseMsgFileUI chooseMsgFileUI) {
        AppMethodBeat.i(123451);
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("FILEPATHS", chooseMsgFileUI.qoR.cyH());
        chooseMsgFileUI.setResult(-1, intent);
        chooseMsgFileUI.finish();
        AppMethodBeat.o(123451);
    }
}
