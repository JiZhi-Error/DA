package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.l;

public class ShakeItemListUI extends MMActivity {
    public long DjA = 0;
    private boolean DjB = false;
    private a DjC;
    private int dDG;
    private int id;
    private com.tencent.mm.av.a.a jaq = null;
    private ListView khv;
    private o.g plk = new o.g() {
        /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.AnonymousClass8 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(28398);
            m.eUm().Xu(ShakeItemListUI.this.id);
            AppMethodBeat.o(28398);
        }
    };
    private View qdl;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShakeItemListUI() {
        AppMethodBeat.i(28409);
        AppMethodBeat.o(28409);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28410);
        super.onCreate(bundle);
        initView();
        m.eUm().add(this.DjC);
        this.DjC.anq();
        Log.i("MicroMsg.ShakeItemListUI", "onResume");
        AppMethodBeat.o(28410);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(28411);
        this.jaq = new com.tencent.mm.av.a.a(this);
        bg.aVF();
        final int nullAs = Util.nullAs((Integer) c.azQ().get(12290, (Object) null), 0);
        this.dDG = getIntent().getIntExtra("_key_show_type_", 0);
        String stringExtra = getIntent().getStringExtra("_key_title_");
        if (!Util.isNullOrNil(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.DjB = getIntent().getBooleanExtra("_key_show_from_shake_", false);
        addTextOptionMenu(0, getString(R.string.t2), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28391);
                h.a((Context) ShakeItemListUI.this, true, ShakeItemListUI.this.getString(R.string.gay), "", ShakeItemListUI.this.getString(R.string.t2), ShakeItemListUI.this.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(28390);
                        switch (ShakeItemListUI.this.dDG) {
                            case -12:
                            case 11:
                                m.eUm().Xv(11);
                                break;
                            case -6:
                            case 5:
                                m.eUm().Xv(7);
                                m.eUm().Xv(6);
                                m.eUm().Xv(8);
                                m.eUm().Xv(9);
                                m.eUm().Xv(10);
                                m.eUm().Xv(12);
                                break;
                            case -5:
                            case 4:
                                bg.aAk().postToWorker(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0073: INVOKE  
                                      (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x006a: INVOKE  (r0v10 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.model.bg.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
                                      (wrap: com.tencent.mm.plugin.shake.d.a.i$1 : 0x0070: CONSTRUCTOR  (r1v6 com.tencent.mm.plugin.shake.d.a.i$1) =  call: com.tencent.mm.plugin.shake.d.a.i.1.<init>():void type: CONSTRUCTOR)
                                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.plugin.shake.ui.ShakeItemListUI.1.1.onClick(android.content.DialogInterface, int):void, file: classes5.dex
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0070: CONSTRUCTOR  (r1v6 com.tencent.mm.plugin.shake.d.a.i$1) =  call: com.tencent.mm.plugin.shake.d.a.i.1.<init>():void type: CONSTRUCTOR in method: com.tencent.mm.plugin.shake.ui.ShakeItemListUI.1.1.onClick(android.content.DialogInterface, int):void, file: classes5.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 19 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.shake.d.a.i, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 25 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 228
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.shake.ui.ShakeItemListUI.AnonymousClass1.AnonymousClass1.onClick(android.content.DialogInterface, int):void");
                            }
                        }, (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(28391);
                        return true;
                    }
                });
                this.khv = (ListView) findViewById(R.id.fu8);
                this.qdl = getLayoutInflater().inflate(R.layout.bro, (ViewGroup) null);
                this.qdl.findViewById(R.id.hne).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(28392);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        ShakeItemListUI.this.dDG ^= -1;
                        ShakeItemListUI.this.setShowType(ShakeItemListUI.this.dDG);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(28392);
                    }
                });
                this.khv.addFooterView(this.qdl);
                if (this.dDG == -1) {
                    this.qdl.findViewById(R.id.hne).setVisibility(0);
                } else {
                    this.qdl.findViewById(R.id.hne).setVisibility(8);
                }
                this.DjC = new a(this);
                this.DjC.setShowType(this.dDG);
                if (this.DjC.getCount() <= 0) {
                    this.khv.setVisibility(8);
                    TextView textView = (TextView) findViewById(R.id.fu_);
                    textView.setText(XC(this.dDG));
                    textView.setVisibility(0);
                    enableOptionMenu(false);
                } else {
                    this.khv.setAdapter((ListAdapter) this.DjC);
                    this.khv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.AnonymousClass3 */

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                            AppMethodBeat.i(28393);
                            b bVar = new b();
                            bVar.bm(adapterView);
                            bVar.bm(view);
                            bVar.pH(i2);
                            bVar.zo(j2);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                            d dVar = (d) ShakeItemListUI.this.DjC.getItem(i2);
                            if (dVar == null) {
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                                AppMethodBeat.o(28393);
                                return;
                            }
                            e eUm = m.eUm();
                            if (dVar == null) {
                                Log.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
                            } else {
                                dVar.field_insertBatch = 1;
                                dVar.cSx = 1024;
                                if (-1 != eUm.db.update("shakeitem1", dVar.convertTo(), "shakeItemID=? and insertBatch=?", new String[]{new StringBuilder().append(dVar.field_shakeItemID).toString(), "2"})) {
                                    eUm.doNotify();
                                }
                            }
                            int i3 = dVar.field_type;
                            if (i3 == 4) {
                                Intent intent = new Intent();
                                if (com.tencent.mm.ay.e.bem()) {
                                    com.tencent.mm.ay.a.c(i.e(dVar.field_lvbuffer, 0));
                                } else {
                                    com.tencent.mm.ay.a.bea();
                                    intent.putExtra("key_mode", 1);
                                    intent.putExtra("KGlobalShakeMusic", true);
                                    com.tencent.mm.ay.a.d(i.e(dVar.field_lvbuffer, 0));
                                }
                                intent.putExtra("key_scene", 3);
                                com.tencent.mm.br.c.b(ShakeItemListUI.this, "music", ".ui.MusicMainUI", intent);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                                AppMethodBeat.o(28393);
                            } else if (i3 == 11) {
                                if (System.currentTimeMillis() - ShakeItemListUI.this.DjA > 2000) {
                                    ShakeItemListUI.this.DjA = System.currentTimeMillis();
                                    if (dVar.field_reserved3 == null || dVar.field_reserved3.split(",").length != 3 || dVar.field_reserved3.split(",")[0] == null || dVar.field_reserved3.split(",")[0].equals("")) {
                                        Intent intent2 = new Intent();
                                        intent2.putExtra("rawUrl", dVar.getCity());
                                        intent2.putExtra("scene", 27);
                                        intent2.putExtra("stastic_scene", 5);
                                        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                                    } else {
                                        String[] split = dVar.field_reserved3.split(",");
                                        wq wqVar = new wq();
                                        wqVar.ecI.userName = split[0];
                                        wqVar.ecI.ecK = Util.nullAs(split[1], "");
                                        wqVar.ecI.ecL = Integer.parseInt(split[2]);
                                        wqVar.ecI.scene = 1077;
                                        EventCenter.instance.publish(wqVar);
                                    }
                                    if (ShakeItemListUI.this.DjB) {
                                        com.tencent.mm.plugin.shake.d.a.h.a(dVar);
                                        com.tencent.mm.plugin.shake.d.a.h.b(dVar);
                                    }
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                                AppMethodBeat.o(28393);
                            } else if (k.XA(i3)) {
                                k.a(dVar, ShakeItemListUI.this, true);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                                AppMethodBeat.o(28393);
                            } else {
                                String str = dVar.field_username;
                                bg.aVF();
                                as Kn = c.aSN().Kn(str);
                                Log.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i2 + " contactName" + Kn.field_username);
                                Log.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.contact.c.oR(Kn.field_type) + "  contact:" + Kn);
                                if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                                    Intent intent3 = new Intent();
                                    intent3.putExtra("Contact_User", str);
                                    intent3.putExtra("Contact_Scene", nullAs == dVar.field_sex ? 23 : 24);
                                    intent3.putExtra("Sns_from_Scene", 22);
                                    if (str != null && str.length() > 0) {
                                        if (Kn.gBM()) {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, dVar.field_username + "," + intent3.getIntExtra("Contact_Scene", 23));
                                            intent3.putExtra("Contact_Scene", 23);
                                        }
                                        com.tencent.mm.plugin.shake.a.jRt.c(intent3, ShakeItemListUI.this);
                                    }
                                } else {
                                    Log.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i2 + " contactName" + Kn.field_username);
                                    Intent intent4 = new Intent();
                                    intent4.putExtra("Contact_User", dVar.field_username);
                                    intent4.putExtra("Contact_Nick", dVar.field_nickname);
                                    intent4.putExtra("Contact_Distance", dVar.field_distance);
                                    intent4.putExtra("Contact_Signature", dVar.field_signature);
                                    intent4.putExtra("Contact_Province", dVar.getProvince());
                                    intent4.putExtra("Contact_City", dVar.getCity());
                                    intent4.putExtra("Contact_Sex", dVar.field_sex);
                                    intent4.putExtra("Contact_IsLBSFriend", true);
                                    intent4.putExtra("Contact_VUser_Info", dVar.field_reserved3);
                                    intent4.putExtra("Contact_VUser_Info_Flag", dVar.field_reserved1);
                                    intent4.putExtra("Contact_Scene", nullAs == dVar.field_sex ? 23 : 24);
                                    intent4.putExtra("Sns_from_Scene", 22);
                                    intent4.putExtra("Contact_KSnsIFlag", dVar.field_snsFlag);
                                    intent4.putExtra("Contact_KSnsBgUrl", dVar.field_sns_bgurl);
                                    if ((dVar.field_reserved1 & 8) > 0) {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, dVar.field_username + "," + intent4.getIntExtra("Contact_Scene", 23));
                                    }
                                    com.tencent.mm.plugin.shake.a.jRt.c(intent4, ShakeItemListUI.this);
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                                AppMethodBeat.o(28393);
                            }
                        }
                    });
                    final l lVar = new l(this);
                    this.khv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                        /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.AnonymousClass4 */

                        @Override // android.widget.AdapterView.OnItemLongClickListener
                        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                            AppMethodBeat.i(28394);
                            if (i2 < ShakeItemListUI.this.khv.getHeaderViewsCount()) {
                                Log.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
                                AppMethodBeat.o(28394);
                            } else {
                                lVar.a(view, i2, j2, ShakeItemListUI.this, ShakeItemListUI.this.plk);
                                AppMethodBeat.o(28394);
                            }
                            return true;
                        }
                    });
                }
                setBackBtn(new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.AnonymousClass5 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(28395);
                        ShakeItemListUI.this.hideVKB();
                        ShakeItemListUI.this.finish();
                        AppMethodBeat.o(28395);
                        return true;
                    }
                });
                setToTop(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(28396);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(ShakeItemListUI.this.khv);
                        Object obj = new Object();
                        com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(28396);
                    }
                });
                this.khv.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.AnonymousClass7 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(28397);
                        if (ShakeItemListUI.this.DjC != null) {
                            a aVar = ShakeItemListUI.this.DjC;
                            if (aVar.kex != null) {
                                aVar.kex.onTouchEvent(motionEvent);
                            }
                        }
                        AppMethodBeat.o(28397);
                        return false;
                    }
                });
                AppMethodBeat.o(28411);
            }

            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(28412);
                AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
                this.id = ((d) this.DjC.getItem(adapterContextMenuInfo.position)).field_shakeItemID;
                contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.tf);
                AppMethodBeat.o(28412);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onPause() {
                AppMethodBeat.i(28413);
                super.onPause();
                AppMethodBeat.o(28413);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onDestroy() {
                AppMethodBeat.i(28414);
                this.DjC.ebf();
                a aVar = this.DjC;
                if (aVar.kex != null) {
                    aVar.kex.detach();
                    aVar.kex = null;
                }
                m.eUm().remove(this.DjC);
                Log.i("MicroMsg.ShakeItemListUI", "onPause");
                if (this.jaq != null) {
                    this.jaq.detach();
                }
                super.onDestroy();
                AppMethodBeat.o(28414);
            }

            /* access modifiers changed from: protected */
            public final void setShowType(int i2) {
                AppMethodBeat.i(28415);
                this.DjC.setShowType(i2);
                switch (i2) {
                    case -12:
                    case -1:
                        if (this.qdl != null) {
                            this.qdl.findViewById(R.id.hne).setVisibility(0);
                            break;
                        }
                        break;
                    case 0:
                    case 11:
                        if (this.qdl != null) {
                            this.qdl.findViewById(R.id.hne).setVisibility(8);
                            AppMethodBeat.o(28415);
                            return;
                        }
                        break;
                }
                AppMethodBeat.o(28415);
            }

            @Override // com.tencent.mm.ui.MMActivity
            public int getLayoutId() {
                return R.layout.brm;
            }

            public static int XC(int i2) {
                switch (i2) {
                    case -12:
                    case 11:
                        return R.string.gye;
                    case -6:
                    case 5:
                        return R.string.h08;
                    case -5:
                    case 4:
                        return R.string.gz5;
                    case -1:
                    case 0:
                    default:
                        return R.string.gy8;
                    case 100:
                        return R.string.gyb;
                }
            }

            /* access modifiers changed from: package-private */
            public class a extends s<d> {
                private int dDG = 0;
                com.tencent.mm.ui.applet.b kex = new com.tencent.mm.ui.applet.b(new b.a() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.a.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.applet.b.a
                    public final Bitmap Ta(String str) {
                        AppMethodBeat.i(28399);
                        Bitmap a2 = com.tencent.mm.aj.c.a(str, false, -1, null);
                        AppMethodBeat.o(28399);
                        return a2;
                    }
                });
                private b.AbstractC2078b kez = null;

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
                @Override // com.tencent.mm.ui.s
                public final /* synthetic */ d a(d dVar, Cursor cursor) {
                    AppMethodBeat.i(28408);
                    d dVar2 = dVar;
                    if (dVar2 == null) {
                        dVar2 = new d();
                    }
                    if (cursor != null) {
                        dVar2.convertFrom(cursor);
                    }
                    AppMethodBeat.o(28408);
                    return dVar2;
                }

                public a(ShakeItemListUI shakeItemListUI) {
                    super(shakeItemListUI, new d());
                    AppMethodBeat.i(28403);
                    anq();
                    AppMethodBeat.o(28403);
                }

                public final View getView(int i2, View view, ViewGroup viewGroup) {
                    C1694a aVar;
                    AppMethodBeat.i(28404);
                    if (this.kez == null) {
                        this.kez = new b.AbstractC2078b() {
                            /* class com.tencent.mm.plugin.shake.ui.ShakeItemListUI.a.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                            public final String vg(int i2) {
                                AppMethodBeat.i(28400);
                                if (i2 < 0 || i2 >= a.this.getCount()) {
                                    Log.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
                                    AppMethodBeat.o(28400);
                                    return null;
                                }
                                d dVar = (d) a.this.getItem(i2);
                                if (dVar == null) {
                                    AppMethodBeat.o(28400);
                                    return null;
                                }
                                String str = dVar.field_username;
                                AppMethodBeat.o(28400);
                                return str;
                            }

                            @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                            public final int bnW() {
                                AppMethodBeat.i(28401);
                                int count = a.this.getCount();
                                AppMethodBeat.o(28401);
                                return count;
                            }
                        };
                    }
                    if (this.kex != null) {
                        this.kex.a(i2, this.kez);
                    }
                    if (view == null) {
                        aVar = new C1694a();
                        view = View.inflate(this.context, R.layout.brn, null);
                        aVar.keC = (ImageView) view.findViewById(R.id.fu3);
                        aVar.kcS = (TextView) view.findViewById(R.id.fu9);
                        aVar.keD = (TextView) view.findViewById(R.id.fu6);
                        aVar.DjI = (ImageView) view.findViewById(R.id.fua);
                        aVar.uSG = (TextView) view.findViewById(R.id.fu4);
                        aVar.uSH = (TextView) view.findViewById(R.id.fub);
                        aVar.uSI = (ImageView) view.findViewById(R.id.fud);
                        aVar.DjJ = (TextView) view.findViewById(R.id.hon);
                        aVar.DjH = view.findViewById(R.id.h7i);
                        aVar.DjK = (LinearLayout) view.findViewById(R.id.hnj);
                        aVar.DjL = (TextView) view.findViewById(R.id.hnk);
                        view.setTag(aVar);
                    } else {
                        aVar = (C1694a) view.getTag();
                    }
                    d dVar = (d) getItem(i2);
                    if (dVar != null) {
                        aVar.clear();
                        if (4 == dVar.field_type || (k.XA(dVar.field_type) && 6 != dVar.field_type)) {
                            if (4 != dVar.field_type) {
                                aVar.keC.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            }
                            e.a(aVar.keC, dVar.field_sns_bgurl, R.raw.app_attach_file_icon_webpage, false);
                        } else if (11 == dVar.field_type) {
                            ShakeItemListUI.this.jaq.loadImage(dVar.getProvince(), aVar.keC);
                        } else {
                            a.b.c(aVar.keC, dVar.field_username);
                        }
                        aVar.keC.setVisibility(0);
                        if (7 != dVar.field_type && 10 != dVar.field_type && 12 != dVar.field_type && 13 != dVar.field_type && (8 != dVar.field_type || !Util.isNullOrNil(dVar.field_nickname) || !Util.isNullOrNil(dVar.field_username))) {
                            aVar.DjL.setVisibility(8);
                            aVar.DjK.setVisibility(0);
                            if (8 == dVar.field_type && Util.isNullOrNil(dVar.field_nickname)) {
                                dVar.field_nickname = dVar.field_distance;
                                dVar.field_distance = dVar.field_username;
                            }
                            aVar.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, Util.nullAsNil(dVar.field_nickname), aVar.kcS.getTextSize()));
                            aVar.kcS.setVisibility(0);
                            int paddingBottom = view.getPaddingBottom();
                            int paddingTop = view.getPaddingTop();
                            int paddingRight = view.getPaddingRight();
                            int paddingLeft = view.getPaddingLeft();
                            if (dVar.field_insertBatch == 2) {
                                view.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, R.drawable.q_));
                            } else {
                                view.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, R.drawable.qa));
                            }
                            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                            switch (dVar.field_type) {
                                case 1:
                                case 2:
                                case 3:
                                    aVar.DjJ.setText(dVar.field_nickname);
                                    aVar.DjJ.setVisibility(0);
                                    AppMethodBeat.o(28404);
                                    break;
                                default:
                                    aVar.DjH.setVisibility(0);
                                    aVar.uSG.setText(dVar.field_distance);
                                    aVar.uSG.setVisibility(0);
                                    if (dVar.field_signature == null || dVar.field_signature.trim().equals("")) {
                                        aVar.uSH.setVisibility(8);
                                    } else {
                                        aVar.uSH.setVisibility(0);
                                        aVar.uSH.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, dVar.field_signature, aVar.kcS.getTextSize()));
                                    }
                                    if (dVar.field_sex == 1) {
                                        aVar.DjI.setVisibility(0);
                                        aVar.DjI.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.ic_sex_male));
                                        aVar.DjI.setContentDescription(this.context.getString(R.string.evk));
                                    } else if (dVar.field_sex == 2) {
                                        aVar.DjI.setVisibility(0);
                                        aVar.DjI.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.ic_sex_female));
                                        aVar.DjI.setContentDescription(this.context.getString(R.string.cdg));
                                    } else {
                                        aVar.DjI.setVisibility(8);
                                    }
                                    bg.aVF();
                                    as Kn = c.aSN().Kn(dVar.field_username);
                                    if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                                        aVar.keD.setVisibility(8);
                                    } else {
                                        aVar.keD.setVisibility(0);
                                        if (as.akh(dVar.field_reserved1)) {
                                            aVar.keD.setText(this.context.getString(R.string.f_w));
                                        } else {
                                            aVar.keD.setText(this.context.getString(R.string.fa1));
                                        }
                                    }
                                    if (6 == dVar.field_type) {
                                        aVar.uSG.setText(this.context.getString(R.string.gya));
                                        aVar.keD.setVisibility(8);
                                    }
                                    if (dVar.field_reserved1 != 0) {
                                        aVar.uSI.setVisibility(0);
                                        aVar.uSI.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(dVar.field_reserved1), 2.0f));
                                        aVar.DjI.setVisibility(8);
                                    } else {
                                        aVar.uSI.setVisibility(8);
                                    }
                                    AppMethodBeat.o(28404);
                                    break;
                            }
                        } else {
                            if (8 == dVar.field_type) {
                                aVar.DjL.setText(dVar.field_distance);
                            } else {
                                aVar.DjL.setText(dVar.field_nickname);
                            }
                            aVar.DjL.setVisibility(0);
                            aVar.DjK.setVisibility(8);
                            AppMethodBeat.o(28404);
                        }
                    } else {
                        aVar.clear();
                        AppMethodBeat.o(28404);
                    }
                    return view;
                }

                @Override // com.tencent.mm.ui.s
                public final void anq() {
                    AppMethodBeat.i(28405);
                    ebf();
                    anp();
                    AppMethodBeat.o(28405);
                }

                @Override // com.tencent.mm.ui.s
                public final void anp() {
                    AppMethodBeat.i(28406);
                    if (!bg.aAc()) {
                        AppMethodBeat.o(28406);
                        return;
                    }
                    switch (this.dDG) {
                        case -12:
                            setCursor(m.eUm().Xt(ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
                            break;
                        case -6:
                            setCursor(m.eUm().eTY());
                            break;
                        case -5:
                            setCursor(m.eUm().eTW());
                            break;
                        case -1:
                            setCursor(m.eUm().eTT());
                            break;
                        case 0:
                            setCursor(m.eUm().eTU());
                            break;
                        case 4:
                            setCursor(m.eUm().eTV());
                            break;
                        case 5:
                            setCursor(m.eUm().eTX());
                            break;
                        case 11:
                            setCursor(m.eUm().eTZ());
                            break;
                        case 100:
                            setCursor(m.eUm().eTS());
                            break;
                    }
                    super.notifyDataSetChanged();
                    AppMethodBeat.o(28406);
                }

                /* access modifiers changed from: protected */
                public final void setShowType(int i2) {
                    AppMethodBeat.i(28407);
                    this.dDG = i2;
                    anq();
                    AppMethodBeat.o(28407);
                }

                /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$a$a  reason: collision with other inner class name */
                class C1694a {
                    View DjH;
                    ImageView DjI;
                    TextView DjJ;
                    LinearLayout DjK;
                    TextView DjL;
                    TextView kcS;
                    ImageView keC;
                    TextView keD;
                    TextView uSG;
                    TextView uSH;
                    ImageView uSI;

                    C1694a() {
                    }

                    public final void clear() {
                        AppMethodBeat.i(28402);
                        if (this.keC != null) {
                            this.keC.setImageDrawable(null);
                            this.keC.setVisibility(8);
                        }
                        if (this.kcS != null) {
                            this.kcS.setText("");
                            this.kcS.setVisibility(8);
                        }
                        if (this.keD != null) {
                            this.keD.setVisibility(8);
                        }
                        if (this.DjI != null) {
                            this.DjI.setVisibility(8);
                        }
                        if (this.uSG != null) {
                            this.uSG.setText("");
                            this.uSG.setVisibility(8);
                        }
                        if (this.uSH != null) {
                            this.uSH.setVisibility(8);
                            this.DjH.setVisibility(8);
                        }
                        if (this.uSI != null) {
                            this.uSI.setVisibility(8);
                        }
                        if (this.DjJ != null) {
                            this.DjJ.setText("");
                            this.DjJ.setVisibility(8);
                        }
                        AppMethodBeat.o(28402);
                    }
                }
            }
        }
