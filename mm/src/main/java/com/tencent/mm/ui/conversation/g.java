package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.l;
import com.tencent.mm.g.b.a.fd;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.b.a;

public final class g implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener {
    private ListView Qbd;
    private i Qct;
    private Activity activity;
    private az conversation = null;
    private int position;
    private o.g pso = new o.g() {
        /* class com.tencent.mm.ui.conversation.g.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            ca caVar;
            int i3 = 4;
            AppMethodBeat.i(38390);
            switch (menuItem.getItemId()) {
                case 4:
                    g.a(g.this, 1);
                    if (ab.Eq(g.this.talker)) {
                        h.INSTANCE.a(14553, 1, 1, g.this.talker);
                    } else {
                        h.INSTANCE.a(14553, 0, 1, g.this.talker);
                    }
                    ca caVar2 = g.this.conversation.OoM;
                    if (caVar2 != null) {
                        Log.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", g.this.talker, g.this.activity, g.this.conversation.field_username, Long.valueOf(caVar2.field_msgId), caVar2.field_content, Long.valueOf(caVar2.field_createTime));
                    } else {
                        Log.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", g.this.talker, g.this.activity, g.this.conversation.field_username);
                    }
                    if (com.tencent.mm.al.g.Nb(g.this.talker)) {
                        l bat = ag.bat();
                        int i4 = g.this.position;
                        int i5 = g.this.conversation.field_unReadCount;
                        String str = g.this.talker;
                        bat.iOA = new dvm();
                        bat.iOA.MWC = i4;
                        bat.iOA.MWA = i5;
                        if (caVar2 == null) {
                            caVar = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(str);
                        } else {
                            caVar = caVar2;
                        }
                        if (caVar != null) {
                            bat.iOA.MWB = caVar.getType();
                            if (bat.iOA.MWA > 0) {
                                bat.iOA.MWz = ((int) (System.currentTimeMillis() - caVar.field_createTime)) / 1000;
                            }
                        }
                        l.a(bat.iOA, str);
                    }
                    c.a(g.this.talker, g.this.activity, g.this.conversation, null, true, false);
                    i3 = 12;
                    break;
                case 5:
                    Log.d("MicroMsg.ConversationClickListener", "placed to the top");
                    ab.E(g.this.talker, true);
                    bg.aVF();
                    as Kn = c.aSN().Kn(g.this.talker);
                    if (Kn != null && Kn.gBM()) {
                        h.INSTANCE.a(13307, Kn.field_username, 1, 1, 1);
                    }
                    com.tencent.mm.ui.base.h.cD(g.this.activity, g.this.activity.getString(R.string.euw));
                    b.jmd.c(true, g.this.talker, true);
                    break;
                case 6:
                    Log.d("MicroMsg.ConversationClickListener", "unplaced to the top");
                    ab.F(g.this.talker, true);
                    bg.aVF();
                    as Kn2 = c.aSN().Kn(g.this.talker);
                    if (Kn2 != null && Kn2.gBM()) {
                        h.INSTANCE.a(13307, Kn2.field_username, 1, 2, 1);
                    }
                    com.tencent.mm.ui.base.h.cD(g.this.activity, g.this.activity.getString(R.string.eux));
                    b.jmd.c(true, g.this.talker, false);
                    i3 = 5;
                    break;
                case 7:
                    Log.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", g.this.talker);
                    bg.aVF();
                    c.aST().bka(g.this.talker);
                    MMAppMgr.cancelNotification(g.this.talker);
                    com.tencent.mm.modelsimple.ab.av(g.this.talker, 1);
                    b.jmd.V(g.this.talker, false);
                    com.tencent.mm.as.b.bch();
                    com.tencent.mm.as.b.Om(g.this.talker);
                    i3 = 3;
                    break;
                case 8:
                    Log.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", g.this.talker);
                    bg.aVF();
                    c.aST().bkc(g.this.talker);
                    b.jmd.V(g.this.talker, true);
                    com.tencent.mm.modelsimple.ab.av(g.this.talker, 13);
                    i3 = 2;
                    break;
                case 9:
                    Log.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", g.this.talker);
                    ab.Eq(g.this.talker);
                    String str2 = g.this.talker;
                    Activity activity = g.this.activity;
                    PBool pBool = new PBool();
                    pBool.value = false;
                    activity.getString(R.string.zb);
                    bp.a(str2, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0332: INVOKE  
                          (r0v8 'str2' java.lang.String)
                          (wrap: com.tencent.mm.ui.conversation.c$10 : 0x032f: CONSTRUCTOR  (r6v8 com.tencent.mm.ui.conversation.c$10) = 
                          (r3v5 'pBool' com.tencent.mm.pointers.PBool)
                          (wrap: com.tencent.mm.ui.base.q : 0x0329: INVOKE  (r2v10 com.tencent.mm.ui.base.q) = 
                          (wrap: android.content.Context : ?: CAST (android.content.Context) (r2v9 'activity' android.app.Activity))
                          (wrap: java.lang.String : 0x0320: INVOKE  (r6v7 java.lang.String) = (r2v9 'activity' android.app.Activity), (wrap: int : ?: SGET   com.tencent.mm.R.string.a06 int) type: VIRTUAL call: android.content.Context.getString(int):java.lang.String)
                          true
                          (wrap: android.content.DialogInterface$OnCancelListener : ?: CAST (android.content.DialogInterface$OnCancelListener) (wrap: com.tencent.mm.ui.conversation.c$9 : 0x0326: CONSTRUCTOR  (r7v0 com.tencent.mm.ui.conversation.c$9) = (r3v5 'pBool' com.tencent.mm.pointers.PBool) call: com.tencent.mm.ui.conversation.c.9.<init>(com.tencent.mm.pointers.PBool):void type: CONSTRUCTOR))
                         type: STATIC call: com.tencent.mm.ui.base.h.a(android.content.Context, java.lang.String, boolean, android.content.DialogInterface$OnCancelListener):com.tencent.mm.ui.base.q)
                         call: com.tencent.mm.ui.conversation.c.10.<init>(com.tencent.mm.pointers.PBool, android.app.ProgressDialog):void type: CONSTRUCTOR)
                         type: STATIC call: com.tencent.mm.model.bp.a(java.lang.String, com.tencent.mm.model.bp$a):int in method: com.tencent.mm.ui.conversation.g.1.onMMMenuItemSelected(android.view.MenuItem, int):void, file: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x032f: CONSTRUCTOR  (r6v8 com.tencent.mm.ui.conversation.c$10) = 
                          (r3v5 'pBool' com.tencent.mm.pointers.PBool)
                          (wrap: com.tencent.mm.ui.base.q : 0x0329: INVOKE  (r2v10 com.tencent.mm.ui.base.q) = 
                          (wrap: android.content.Context : ?: CAST (android.content.Context) (r2v9 'activity' android.app.Activity))
                          (wrap: java.lang.String : 0x0320: INVOKE  (r6v7 java.lang.String) = (r2v9 'activity' android.app.Activity), (wrap: int : ?: SGET   com.tencent.mm.R.string.a06 int) type: VIRTUAL call: android.content.Context.getString(int):java.lang.String)
                          true
                          (wrap: android.content.DialogInterface$OnCancelListener : ?: CAST (android.content.DialogInterface$OnCancelListener) (wrap: com.tencent.mm.ui.conversation.c$9 : 0x0326: CONSTRUCTOR  (r7v0 com.tencent.mm.ui.conversation.c$9) = (r3v5 'pBool' com.tencent.mm.pointers.PBool) call: com.tencent.mm.ui.conversation.c.9.<init>(com.tencent.mm.pointers.PBool):void type: CONSTRUCTOR))
                         type: STATIC call: com.tencent.mm.ui.base.h.a(android.content.Context, java.lang.String, boolean, android.content.DialogInterface$OnCancelListener):com.tencent.mm.ui.base.q)
                         call: com.tencent.mm.ui.conversation.c.10.<init>(com.tencent.mm.pointers.PBool, android.app.ProgressDialog):void type: CONSTRUCTOR in method: com.tencent.mm.ui.conversation.g.1.onMMMenuItemSelected(android.view.MenuItem, int):void, file: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 19 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.conversation.c, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 25 more
                        */
                    /*
                    // Method dump skipped, instructions count: 904
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.g.AnonymousClass1.onMMMenuItemSelected(android.view.MenuItem, int):void");
                }
            };
            private String talker = "";
            private int[] utT = new int[2];

            static /* synthetic */ void a(g gVar, int i2) {
                AppMethodBeat.i(234141);
                gVar.pl(i2);
                AppMethodBeat.o(234141);
            }

            public g(i iVar, ListView listView, Activity activity2, int[] iArr) {
                AppMethodBeat.i(38391);
                this.Qct = iVar;
                this.Qbd = listView;
                this.activity = activity2;
                this.utT = iArr;
                AppMethodBeat.o(38391);
            }

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(38392);
                if (i2 < this.Qbd.getHeaderViewsCount()) {
                    Log.d("MicroMsg.ConversationClickListener", "on long click header view");
                    AppMethodBeat.o(38392);
                    return true;
                }
                this.position = i2 - this.Qbd.getHeaderViewsCount();
                this.conversation = (az) this.Qct.getItem(i2 - this.Qbd.getHeaderViewsCount());
                if (this.conversation == null) {
                    Log.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", Integer.valueOf(this.Qbd.getHeaderViewsCount()), Integer.valueOf(i2));
                    AppMethodBeat.o(38392);
                    return true;
                }
                this.talker = this.conversation.field_username;
                a aVar = new a(this.activity);
                aVar.a(view, i2, j2, this, this.pso, this.utT[0], this.utT[1]);
                aVar.QwU = this;
                if (ab.Eq(this.talker)) {
                    h.INSTANCE.a(14553, 1, 0, this.talker);
                } else {
                    h.INSTANCE.a(14553, 0, 0, this.talker);
                }
                pl(100);
                AppMethodBeat.o(38392);
                return true;
            }

            public final void onDismiss() {
                AppMethodBeat.i(38393);
                i iVar = this.Qct;
                iVar.QeD = false;
                iVar.notifyDataSetChanged();
                AppMethodBeat.o(38393);
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                com.tencent.mm.api.c fJ;
                AppMethodBeat.i(38394);
                i iVar = this.Qct;
                Log.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", Util.getStack());
                iVar.QeD = true;
                bg.aVF();
                as Kn = c.aSN().Kn(this.talker);
                if (Kn == null) {
                    Log.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
                    AppMethodBeat.o(38394);
                    return;
                }
                String arJ = Kn.arJ();
                if (arJ.toLowerCase().endsWith("@chatroom") && Util.isNullOrNil(Kn.field_nickname)) {
                    arJ = this.activity.getString(R.string.b25);
                }
                AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
                contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(this.activity, arJ));
                if ((this.conversation != null) && ab.b(this.conversation)) {
                    String str = this.talker;
                    bg.aVF();
                    az bjY = c.aST().bjY(str);
                    if (bjY != null ? bjY.field_unReadCount <= 0 && !bjY.oV(1048576) : false) {
                        contextMenu.add(adapterContextMenuInfo.position, 8, 0, R.string.euu);
                    } else {
                        contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.string.eus);
                    }
                }
                if (this.conversation != null && ab.a(this.conversation)) {
                    bg.aVF();
                    if (c.aST().bkg(this.talker)) {
                        contextMenu.add(adapterContextMenuInfo.position, 6, 0, R.string.euv);
                    } else if (!Kn.gBM()) {
                        contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.string.eut);
                    } else if (ab.IK(Kn.field_username) || ab.IL(Kn.field_username) || (1 == ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_minishop_plugin_enabled, 0) && ab.IM(Kn.field_username))) {
                        contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.string.bh1);
                    } else {
                        contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.string.bh2);
                    }
                }
                if (Kn.gBM() && com.tencent.mm.contact.c.oR(Kn.field_type) && !ab.JF(Kn.field_username) && !ab.Jf(Kn.field_username) && (fJ = com.tencent.mm.al.g.fJ(Kn.field_username)) != null && fJ.UC() && !ab.IK(Kn.field_username) && !ab.IL(Kn.field_username) && (1 != ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_minishop_plugin_enabled, 0) || !ab.IM(Kn.field_username))) {
                    contextMenu.add(adapterContextMenuInfo.position, 10, 0, R.string.eur);
                }
                if (!(this.conversation == null || this.conversation.field_conversationTime == -1)) {
                    if (ab.IY(this.talker)) {
                        contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.string.ev2);
                        AppMethodBeat.o(38394);
                        return;
                    } else if (ab.IZ(this.talker)) {
                        contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.string.ev0);
                        AppMethodBeat.o(38394);
                        return;
                    } else {
                        contextMenu.add(adapterContextMenuInfo.position, 11, 0, R.string.eul);
                        contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.string.euz);
                    }
                }
                AppMethodBeat.o(38394);
            }

            private void pl(int i2) {
                long j2;
                AppMethodBeat.i(234140);
                fd fdVar = new fd();
                fdVar.enl = (long) i2;
                fdVar.sa(this.talker);
                fdVar.enE = (long) this.conversation.field_unReadCount;
                fdVar.eFa = (long) ac.JT(this.talker);
                if (i2 == 13 || i2 == 14) {
                    if (com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_CONVERSATION_DISMISS_INTRO_BOOLEAN_SYNC, true)) {
                        j2 = 1;
                    } else {
                        j2 = 2;
                    }
                    fdVar.eFb = j2;
                }
                fdVar.bfK();
                AppMethodBeat.o(234140);
            }
        }
