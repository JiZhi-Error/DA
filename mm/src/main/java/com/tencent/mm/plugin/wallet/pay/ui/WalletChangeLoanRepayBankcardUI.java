package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.ui.base.a;
import java.util.Collections;

@a(3)
public class WalletChangeLoanRepayBankcardUI extends WalletChangeBankcardUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69337);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69336);
                WalletChangeLoanRepayBankcardUI.this.setResult(-1, null);
                AppMethodBeat.o(69336);
                return true;
            }
        });
        AppMethodBeat.o(69337);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public final k fOr() {
        AppMethodBeat.i(69338);
        this.Hva = t.fQJ().IbD;
        if (this.Hva != null) {
            Collections.sort(this.Hva, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: INVOKE  
                  (wrap: java.util.ArrayList<com.tencent.mm.plugin.wallet_core.model.Bankcard> : 0x0012: IGET  (r0v4 java.util.ArrayList<com.tencent.mm.plugin.wallet_core.model.Bankcard>) = (r5v0 'this' com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.Hva java.util.ArrayList)
                  (wrap: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$2 : 0x0016: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$2) = (r5v0 'this' com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI A[IMMUTABLE_TYPE, THIS]) call: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.2.<init>(com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI):void type: CONSTRUCTOR)
                 type: STATIC call: java.util.Collections.sort(java.util.List, java.util.Comparator):void in method: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI.fOr():com.tencent.mm.plugin.wallet_core.ui.k, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$2) = (r5v0 'this' com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI A[IMMUTABLE_TYPE, THIS]) call: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.2.<init>(com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI.fOr():com.tencent.mm.plugin.wallet_core.ui.k, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
                this = this;
                r4 = 69338(0x10eda, float:9.7163E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                com.tencent.mm.plugin.wallet_core.model.ak r0 = com.tencent.mm.plugin.wallet_core.model.t.fQJ()
                java.util.ArrayList<com.tencent.mm.plugin.wallet_core.model.Bankcard> r0 = r0.IbD
                r5.Hva = r0
                java.util.ArrayList<com.tencent.mm.plugin.wallet_core.model.Bankcard> r0 = r5.Hva
                if (r0 == 0) goto L_0x001c
                java.util.ArrayList<com.tencent.mm.plugin.wallet_core.model.Bankcard> r0 = r5.Hva
                com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$2 r1 = new com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$2
                r1.<init>()
                java.util.Collections.sort(r0, r1)
            L_0x001c:
                com.tencent.mm.plugin.wallet_core.ui.k r0 = new com.tencent.mm.plugin.wallet_core.ui.k
                java.util.ArrayList r1 = r5.Hva
                int r2 = r5.HGc
                com.tencent.mm.plugin.wallet_core.model.Orders r3 = r5.CwO
                r0.<init>(r5, r1, r2, r3)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI.fOr():com.tencent.mm.plugin.wallet_core.ui.k");
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
        public final void aex(int i2) {
            AppMethodBeat.i(69339);
            int size = this.Hva != null ? this.Hva.size() : 0;
            if (this.Hva != null && i2 < size) {
                Bankcard bankcard = (Bankcard) this.Hva.get(i2);
                this.Hvb = bankcard;
                this.HGd.IfW = bankcard.field_bindSerial;
                this.Cwg.setEnabled(true);
                this.HGd.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.putExtra("bindSerial", bankcard.field_bindSerial);
                intent.putExtra("ret", 0);
                setResult(-1, intent);
            } else if (size == i2) {
                Intent intent2 = new Intent();
                intent2.putExtra("ret", -1003);
                setResult(-1, intent2);
            }
            finish();
            AppMethodBeat.o(69339);
        }

        @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
        public int getForceOrientation() {
            return 1;
        }
    }
