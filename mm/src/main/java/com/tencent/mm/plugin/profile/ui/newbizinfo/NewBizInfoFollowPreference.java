package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.m;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoFollowPreference extends Preference {
    a Bdv;
    private TextView Bjr;
    private TextView Bjs;
    private MMActivity gte;
    private boolean rFe = false;

    public NewBizInfoFollowPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27501);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(27501);
    }

    public NewBizInfoFollowPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27502);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(27502);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27503);
        this.rFe = true;
        this.Bjr = (TextView) view.findViewById(R.id.bas);
        if (this.Bjr.getPaint() != null) {
            this.Bjr.getPaint().setFakeBoldText(true);
        }
        this.Bjs = (TextView) view.findViewById(R.id.baj);
        if (this.Bjs.getPaint() != null) {
            this.Bjs.getPaint().setFakeBoldText(true);
        }
        if (this.rFe) {
            this.Bjr.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27499);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (NewBizInfoFollowPreference.this.Bdv != null && (NewBizInfoFollowPreference.this.Bdv instanceof ContactWidgetNewBizInfo)) {
                        ContactWidgetNewBizInfo contactWidgetNewBizInfo = (ContactWidgetNewBizInfo) NewBizInfoFollowPreference.this.Bdv;
                        if (contactWidgetNewBizInfo.Bfh != null) {
                            rr rrVar = new rr();
                            contactWidgetNewBizInfo.Bfh.jkU = 5;
                            rrVar.dYk.dYl = contactWidgetNewBizInfo.Bfh;
                            EventCenter.instance.publish(rrVar);
                        }
                        Intent intent = new Intent();
                        if (contactWidgetNewBizInfo.BiT.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                            intent.setFlags(268435456);
                        }
                        intent.putExtra("chat_from_scene", contactWidgetNewBizInfo.BiT.getIntent().getIntExtra("chat_from_scene", 0));
                        intent.putExtra("KOpenArticleSceneFromScene", 126);
                        intent.putExtra("specific_chat_from_scene", 5);
                        if (contactWidgetNewBizInfo.Bdx) {
                            intent.putExtra("Chat_User", contactWidgetNewBizInfo.contact.field_username);
                            intent.putExtra("Chat_Mode", 1);
                            contactWidgetNewBizInfo.BiT.setResult(-1, intent);
                        } else {
                            intent.putExtra("Chat_User", contactWidgetNewBizInfo.contact.field_username);
                            intent.putExtra("Chat_Mode", 1);
                            intent.putExtra("finish_direct", true);
                            com.tencent.mm.plugin.profile.b.jRt.d(intent, contactWidgetNewBizInfo.BiT);
                        }
                        contactWidgetNewBizInfo.US(5);
                        c.c(contactWidgetNewBizInfo.contact.field_username, 300, contactWidgetNewBizInfo.kgm, contactWidgetNewBizInfo.enterTime);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27499);
                }
            });
            this.Bjs.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27500);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (NewBizInfoFollowPreference.this.Bdv != null && (NewBizInfoFollowPreference.this.Bdv instanceof ContactWidgetNewBizInfo)) {
                        ContactWidgetNewBizInfo contactWidgetNewBizInfo = (ContactWidgetNewBizInfo) NewBizInfoFollowPreference.this.Bdv;
                        ((m) g.af(m.class)).a(contactWidgetNewBizInfo.Bdk, contactWidgetNewBizInfo.BiT, contactWidgetNewBizInfo.contact, true, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: INVOKE  
                              (wrap: com.tencent.mm.api.m : 0x0042: CHECK_CAST (r0v11 com.tencent.mm.api.m) = (com.tencent.mm.api.m) (wrap: com.tencent.mm.kernel.c.a : 0x003e: INVOKE  (r0v10 com.tencent.mm.kernel.c.a) = (wrap: java.lang.Class : 0x003c: CONST_CLASS   com.tencent.mm.api.m.class) type: STATIC call: com.tencent.mm.kernel.g.af(java.lang.Class):com.tencent.mm.kernel.c.a))
                              (wrap: com.tencent.mm.api.c : 0x0044: IGET  (r1v2 com.tencent.mm.api.c) = (r6v1 'contactWidgetNewBizInfo' com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo) com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.Bdk com.tencent.mm.api.c)
                              (wrap: com.tencent.mm.plugin.profile.ui.ContactInfoUI : 0x0046: IGET  (r2v2 com.tencent.mm.plugin.profile.ui.ContactInfoUI) = (r6v1 'contactWidgetNewBizInfo' com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo) com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.BiT com.tencent.mm.plugin.profile.ui.ContactInfoUI)
                              (wrap: com.tencent.mm.storage.as : 0x0048: IGET  (r3v2 com.tencent.mm.storage.as) = (r6v1 'contactWidgetNewBizInfo' com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo) com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.contact com.tencent.mm.storage.as)
                              true
                              (wrap: com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo$6 : 0x004d: CONSTRUCTOR  (r5v1 com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo$6) = (r6v1 'contactWidgetNewBizInfo' com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo) call: com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.6.<init>(com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo):void type: CONSTRUCTOR)
                             type: INTERFACE call: com.tencent.mm.api.m.a(com.tencent.mm.api.c, android.app.Activity, com.tencent.mm.storage.as, boolean, java.lang.Runnable):void in method: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference.2.onClick(android.view.View):void, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004d: CONSTRUCTOR  (r5v1 com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo$6) = (r6v1 'contactWidgetNewBizInfo' com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo) call: com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.6.<init>(com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference.2.onClick(android.view.View):void, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 19 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 25 more
                            */
                        /*
                        // Method dump skipped, instructions count: 115
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference.AnonymousClass2.onClick(android.view.View):void");
                    }
                });
            }
            AppMethodBeat.o(27503);
        }
    }
