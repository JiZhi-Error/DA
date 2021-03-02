package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.yz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.VoiceInputFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;

@a(3)
public class VoiceInputUI extends MMActivity implements g {
    private MMEditText KdO;
    private VoiceInputFooter KdP;
    private String KdQ;
    private long KdR = 0;
    private boolean KdS = true;
    private boolean KdT = false;
    private View.OnTouchListener KdU = new View.OnTouchListener() {
        /* class com.tencent.mm.pluginsdk.ui.VoiceInputUI.AnonymousClass2 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(31310);
            if (motionEvent.getAction() == 0) {
                VoiceInputUI.a(VoiceInputUI.this);
            } else if (motionEvent.getAction() == 1) {
                if (VoiceInputUI.this.KdP.gpa()) {
                    VoiceInputFooter voiceInputFooter = VoiceInputUI.this.KdP;
                    voiceInputFooter.gpb();
                    voiceInputFooter.setVisibility(8);
                }
                if (VoiceInputUI.this.KdP.fjI()) {
                    VoiceInputFooter voiceInputFooter2 = VoiceInputUI.this.KdP;
                    voiceInputFooter2.cbM();
                    voiceInputFooter2.setVisibility(8);
                }
                VoiceInputFooter voiceInputFooter3 = VoiceInputUI.this.KdP;
                voiceInputFooter3.setVisibility(0);
                if (voiceInputFooter3.Kdq != null) {
                    voiceInputFooter3.Kdq.setImageResource(R.drawable.of);
                }
            }
            AppMethodBeat.o(31310);
            return false;
        }
    };
    private MenuItem.OnMenuItemClickListener KdV = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.pluginsdk.ui.VoiceInputUI.AnonymousClass3 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(31311);
            VoiceInputUI.this.KdO.setText("");
            VoiceInputUI.this.KdT = true;
            VoiceInputUI.this.vA(6);
            AppMethodBeat.o(31311);
            return true;
        }
    };
    private VoiceInputFooter.a KdW = new VoiceInputFooter.a() {
        /* class com.tencent.mm.pluginsdk.ui.VoiceInputUI.AnonymousClass4 */

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputFooter.a
        public final void zR(boolean z) {
            AppMethodBeat.i(31312);
            if (z) {
                VoiceInputUI.this.rjk.setVisibility(4);
                AppMethodBeat.o(31312);
                return;
            }
            VoiceInputUI.this.rjk.setVisibility(0);
            AppMethodBeat.o(31312);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputFooter.a
        public final void gpd() {
            AppMethodBeat.i(31313);
            VoiceInputUI.this.vA(8);
            AppMethodBeat.o(31313);
        }
    };
    boolean KdX = false;
    h gyh;
    private String msg;
    private int offset;
    private Button rjk;
    private int textChangeCount = 0;
    private String userCode;
    boolean zzU = false;

    public VoiceInputUI() {
        AppMethodBeat.i(31316);
        AppMethodBeat.o(31316);
    }

    static /* synthetic */ int a(VoiceInputUI voiceInputUI) {
        int i2 = voiceInputUI.textChangeCount;
        voiceInputUI.textChangeCount = i2 + 1;
        return i2;
    }

    static /* synthetic */ void b(VoiceInputBehavior voiceInputBehavior) {
        AppMethodBeat.i(31326);
        a(voiceInputBehavior);
        AppMethodBeat.o(31326);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(31317);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        Intent intent = getIntent();
        if (intent != null) {
            this.msg = intent.getStringExtra("text");
            this.offset = intent.getIntExtra("offset", -1);
            this.KdQ = intent.getStringExtra("punctuation");
            this.userCode = intent.getStringExtra("userCode");
        }
        this.KdR = Util.currentTicks();
        this.textChangeCount = 0;
        this.KdT = false;
        this.KdS = true;
        this.KdO = (MMEditText) findViewById(R.id.j9v);
        this.rjk = (Button) findViewById(R.id.j9u);
        this.KdO.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputUI.AnonymousClass5 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(31314);
                Log.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", Boolean.valueOf(VoiceInputUI.this.KdS), Boolean.valueOf(VoiceInputUI.this.KdT));
                if (VoiceInputUI.this.KdS) {
                    VoiceInputUI.this.KdS = false;
                    AppMethodBeat.o(31314);
                    return;
                }
                VoiceInputUI.this.KdT = true;
                VoiceInputUI.this.KdO.requestLayout();
                AppMethodBeat.o(31314);
            }
        });
        this.rjk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(31315);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/VoiceInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 3;
                VoiceInputUI.b(voiceInputBehavior);
                VoiceInputUI.this.vA(7);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31315);
            }
        });
        setMMTitle(getString(R.string.hz9));
        enableOptionMenu(true);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(31309);
                VoiceInputUI.this.vA(1);
                AppMethodBeat.o(31309);
                return true;
            }
        });
        this.KdO.setOnTouchListener(this.KdU);
        this.KdO.bol(this.msg);
        if (this.offset != -1) {
            this.KdO.setSelection(this.offset);
        }
        this.KdP = (VoiceInputFooter) findViewById(R.id.h_i);
        VoiceInputFooter voiceInputFooter = this.KdP;
        MMEditText mMEditText = this.KdO;
        String str = this.KdQ;
        String str2 = this.userCode;
        voiceInputFooter.EJt = mMEditText;
        mMEditText.setOnClickListener(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bc: INVOKE  
              (r0v20 'mMEditText' com.tencent.mm.ui.widget.MMEditText)
              (wrap: com.tencent.mm.pluginsdk.ui.VoiceInputFooter$1 : 0x00b9: CONSTRUCTOR  (r4v0 com.tencent.mm.pluginsdk.ui.VoiceInputFooter$1) = (r1v5 'voiceInputFooter' com.tencent.mm.pluginsdk.ui.VoiceInputFooter) call: com.tencent.mm.pluginsdk.ui.VoiceInputFooter.1.<init>(com.tencent.mm.pluginsdk.ui.VoiceInputFooter):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.ui.widget.MMEditText.setOnClickListener(android.view.View$OnClickListener):void in method: com.tencent.mm.pluginsdk.ui.VoiceInputUI.onCreate(android.os.Bundle):void, file: classes2.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b9: CONSTRUCTOR  (r4v0 com.tencent.mm.pluginsdk.ui.VoiceInputFooter$1) = (r1v5 'voiceInputFooter' com.tencent.mm.pluginsdk.ui.VoiceInputFooter) call: com.tencent.mm.pluginsdk.ui.VoiceInputFooter.1.<init>(com.tencent.mm.pluginsdk.ui.VoiceInputFooter):void type: CONSTRUCTOR in method: com.tencent.mm.pluginsdk.ui.VoiceInputUI.onCreate(android.os.Bundle):void, file: classes2.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.pluginsdk.ui.VoiceInputFooter, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 357
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.VoiceInputUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(31318);
        super.onResume();
        this.KdO.requestFocus();
        this.gyh.start();
        AppMethodBeat.o(31318);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(31319);
        super.onPause();
        this.gyh.close();
        AppMethodBeat.o(31319);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(179756);
        AppMethodBeat.at(this, z);
        if (z) {
            this.gyh.start();
            AppMethodBeat.o(179756);
            return;
        }
        this.gyh.close();
        AppMethodBeat.o(179756);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(31320);
        super.onDestroy();
        AppMethodBeat.o(31320);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c6k;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onSwipeBack() {
        AppMethodBeat.i(31321);
        vA(3);
        super.onSwipeBack();
        AppMethodBeat.o(31321);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(31322);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            vA(2);
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(31322);
        return onKeyDown;
    }

    public final void vA(int i2) {
        AppMethodBeat.i(31323);
        Log.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", Integer.valueOf(i2), Util.getStack().toString());
        this.zzU = true;
        if (i2 == 8) {
            pl(7);
        } else {
            pl(i2);
        }
        yz yzVar = new yz();
        if (i2 == 7) {
            yzVar.efi.action = 1;
        } else if (i2 == 8) {
            yzVar.efi.action = 4;
        } else {
            yzVar.efi.action = 2;
        }
        if (this.KdT) {
            yzVar.efi.efj = 1;
        } else {
            yzVar.efi.efj = 2;
        }
        yzVar.efi.result = this.KdO.getText().toString();
        yzVar.efi.userCode = this.userCode;
        if (this.KdP != null) {
            this.KdP.release();
        }
        EventCenter.instance.publish(yzVar);
        Util.hideVKB(this.KdO);
        if (this.KdX) {
            super.finish();
        }
        AppMethodBeat.o(31323);
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        AppMethodBeat.i(31324);
        Log.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        com.tencent.mm.plugin.report.service.h.INSTANCE.c(13905, log_13905);
        AppMethodBeat.o(31324);
    }

    private void pl(int i2) {
        AppMethodBeat.i(31325);
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.textChangeCount = this.textChangeCount;
        voiceInputBehavior.textChangeReturn = i2;
        if (this.KdR != 0) {
            voiceInputBehavior.textChangeTime = Util.ticksToNow(this.KdR);
            this.KdR = 0;
        }
        a(voiceInputBehavior);
        AppMethodBeat.o(31325);
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        AppMethodBeat.i(179757);
        if (i2 <= 0) {
            this.KdX = true;
            if (this.zzU) {
                super.finish();
                AppMethodBeat.o(179757);
                return;
            }
        } else {
            this.KdX = false;
        }
        AppMethodBeat.o(179757);
    }
}
