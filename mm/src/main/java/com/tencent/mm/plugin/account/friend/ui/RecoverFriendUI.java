package com.tencent.mm.plugin.account.friend.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.account.friend.a.av;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class RecoverFriendUI extends MMActivity {
    private av khE = new av(this);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RecoverFriendUI() {
        AppMethodBeat.i(184454);
        AppMethodBeat.o(184454);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(184455);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_session_id");
        String stringExtra2 = getIntent().getStringExtra("key_old_username");
        this.khE.sessionId = stringExtra;
        this.khE.kgb = stringExtra2;
        setMMTitle(R.string.e39);
        av avVar = this.khE;
        Log.i("MicroMsg.RecoverFriendPresenter", "onUICreate");
        avVar.kga = (RecoverFriendSortView) avVar.activity.findViewById(R.id.dau);
        g.azz().a(3513, avVar);
        avVar.vk(au.Ti(avVar.kgb));
        avVar.kga.getScrollBar().setVisibility(8);
        avVar.kga.getListView().setOnScrollListener(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006d: INVOKE  
              (wrap: android.widget.ListView : 0x0064: INVOKE  (r0v14 android.widget.ListView) = 
              (wrap: com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView : 0x0062: IGET  (r0v13 com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView) = (r1v3 'avVar' com.tencent.mm.plugin.account.friend.a.av) com.tencent.mm.plugin.account.friend.a.av.kga com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView)
             type: VIRTUAL call: com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView.getListView():android.widget.ListView)
              (wrap: com.tencent.mm.plugin.account.friend.a.av$1 : 0x006a: CONSTRUCTOR  (r2v6 com.tencent.mm.plugin.account.friend.a.av$1) = (r1v3 'avVar' com.tencent.mm.plugin.account.friend.a.av) call: com.tencent.mm.plugin.account.friend.a.av.1.<init>(com.tencent.mm.plugin.account.friend.a.av):void type: CONSTRUCTOR)
             type: VIRTUAL call: android.widget.ListView.setOnScrollListener(android.widget.AbsListView$OnScrollListener):void in method: com.tencent.mm.plugin.account.friend.ui.RecoverFriendUI.onCreate(android.os.Bundle):void, file: classes4.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006a: CONSTRUCTOR  (r2v6 com.tencent.mm.plugin.account.friend.a.av$1) = (r1v3 'avVar' com.tencent.mm.plugin.account.friend.a.av) call: com.tencent.mm.plugin.account.friend.a.av.1.<init>(com.tencent.mm.plugin.account.friend.a.av):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.account.friend.ui.RecoverFriendUI.onCreate(android.os.Bundle):void, file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.account.friend.a.av, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.friend.ui.RecoverFriendUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(184456);
        super.onDestroy();
        av avVar = this.khE;
        Log.i("MicroMsg.RecoverFriendPresenter", "onUIDestroy");
        g.azz().b(3513, avVar);
        avVar.dead();
        AppMethodBeat.o(184456);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bm1;
    }
}
