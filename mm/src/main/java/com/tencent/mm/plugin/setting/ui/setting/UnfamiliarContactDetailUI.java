package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ba.b;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.setting.model.o;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UnfamiliarContactDetailUI extends MMActivity implements i {
    public static final String gAH = new String(Character.toChars(123));
    private boolean CXV;
    private boolean CXW;
    private boolean CXX;
    private RecyclerView DeP;
    private TextView DeQ;
    private View DeR;
    private View DeS;
    private View DeT;
    private View DeU;
    private TextView DeV;
    private a DeW;
    private RealAlphabetScrollBar DeX;
    HashMap<String, Integer> DeY = new HashMap<>();
    private HashMap<Integer, String> DeZ = new HashMap<>();
    private HashSet<Integer> Dfa = new HashSet<>();
    private d Dfb;
    private int Dfc = -1;
    private HashSet<String> Dfd = new HashSet<>();
    private o Dfe;
    private boolean Dff;
    private q gxX = null;
    private ArrayList<b> jBE = new ArrayList<>();

    /* access modifiers changed from: package-private */
    public static class f {
        static int DfD;
        static int DfE;
        static int DfF;
        static int DfG;
        static int DfH;
        static int DfI;
    }

    /* access modifiers changed from: package-private */
    public interface g {
        void eTJ();

        void eTK();

        void il(int i2, int i3);
    }

    public interface h {
        void a(e eVar);

        void e(HashSet hashSet);

        void onError();

        void onSuccess();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public UnfamiliarContactDetailUI() {
        AppMethodBeat.i(74605);
        AppMethodBeat.o(74605);
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, List list) {
        AppMethodBeat.i(74618);
        unfamiliarContactDetailUI.gJ(list);
        AppMethodBeat.o(74618);
    }

    static /* synthetic */ void c(UnfamiliarContactDetailUI unfamiliarContactDetailUI, boolean z) {
        AppMethodBeat.i(74615);
        unfamiliarContactDetailUI.ku(z);
        AppMethodBeat.o(74615);
    }

    public enum e {
        OVER_ONE_MIN,
        NORMAL;

        public static e valueOf(String str) {
            AppMethodBeat.i(74603);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(74603);
            return eVar;
        }

        static {
            AppMethodBeat.i(74604);
            AppMethodBeat.o(74604);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.brj;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74606);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.azz().a(291, this);
        this.CXV = getIntent().getBooleanExtra("half_year_not_chat", false);
        this.CXW = getIntent().getBooleanExtra("half_year_not_response", false);
        this.CXX = getIntent().getBooleanExtra("has_not_same_chatroom", false);
        initView();
        this.Dfe = new o(this.CXV, this.CXW, this.CXX, new h() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass11 */
            long start = System.currentTimeMillis();

            {
                AppMethodBeat.i(74584);
                AppMethodBeat.o(74584);
            }

            @Override // com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h
            public final void onSuccess() {
                AppMethodBeat.i(74585);
                Log.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", Integer.valueOf(UnfamiliarContactDetailUI.this.jBE.size()), Long.valueOf(System.currentTimeMillis() - this.start));
                UnfamiliarContactDetailUI.this.DeQ.setText(UnfamiliarContactDetailUI.this.getString(R.string.hs8) + "(" + UnfamiliarContactDetailUI.this.jBE.size() + ")");
                if (UnfamiliarContactDetailUI.this.jBE.size() == 0) {
                    UnfamiliarContactDetailUI.this.findViewById(R.id.iok).setVisibility(0);
                    UnfamiliarContactDetailUI.this.findViewById(R.id.gl_).setVisibility(8);
                    UnfamiliarContactDetailUI.this.findViewById(R.id.ecu).setVisibility(8);
                    UnfamiliarContactDetailUI.this.DeV.setText(UnfamiliarContactDetailUI.this.getString(R.string.ek9));
                    AppMethodBeat.o(74585);
                    return;
                }
                UnfamiliarContactDetailUI.this.findViewById(R.id.iok).setVisibility(8);
                UnfamiliarContactDetailUI.this.findViewById(R.id.ecu).setVisibility(0);
                if (UnfamiliarContactDetailUI.this.DeW != null) {
                    UnfamiliarContactDetailUI.this.DeW.atj.notifyChanged();
                }
                AppMethodBeat.o(74585);
            }

            @Override // com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h
            public final void onError() {
                AppMethodBeat.i(74586);
                Log.e("MicroMsg.UnfamiliarContactUI", "[onError]");
                UnfamiliarContactDetailUI.this.findViewById(R.id.iok).setVisibility(0);
                UnfamiliarContactDetailUI.this.findViewById(R.id.gl_).setVisibility(8);
                UnfamiliarContactDetailUI.this.DeV.setText(UnfamiliarContactDetailUI.this.getString(R.string.hsd));
                AppMethodBeat.o(74586);
            }

            @Override // com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h
            public final void a(e eVar) {
                AppMethodBeat.i(74587);
                Log.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", eVar.name());
                UnfamiliarContactDetailUI.this.findViewById(R.id.iok).setVisibility(0);
                UnfamiliarContactDetailUI.this.findViewById(R.id.gl_).setVisibility(0);
                if (eVar == e.NORMAL) {
                    UnfamiliarContactDetailUI.this.DeV.setText(UnfamiliarContactDetailUI.this.getString(R.string.ekc));
                    AppMethodBeat.o(74587);
                    return;
                }
                if (eVar == e.OVER_ONE_MIN) {
                    UnfamiliarContactDetailUI.this.DeV.setText(UnfamiliarContactDetailUI.this.getString(R.string.hse));
                }
                AppMethodBeat.o(74587);
            }

            @Override // com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h
            public final void e(HashSet hashSet) {
                AppMethodBeat.i(74588);
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(hashSet == null ? 0 : hashSet.size());
                Log.i("MicroMsg.UnfamiliarContactUI", "[onResult] size:%s", objArr);
                if (hashSet != null) {
                    UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, hashSet);
                }
                AppMethodBeat.o(74588);
            }
        });
        o oVar = this.Dfe;
        oVar.CYf = System.currentTimeMillis();
        oVar.CYe.a(e.NORMAL);
        oVar.qmq.postToWorker(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0065: INVOKE  
              (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x005e: IGET  (r1v6 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v8 'oVar' com.tencent.mm.plugin.setting.model.o) com.tencent.mm.plugin.setting.model.o.qmq com.tencent.mm.sdk.platformtools.MMHandler)
              (wrap: com.tencent.mm.plugin.setting.model.o$1 : 0x0062: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.setting.model.o$1) = (r0v8 'oVar' com.tencent.mm.plugin.setting.model.o) call: com.tencent.mm.plugin.setting.model.o.1.<init>(com.tencent.mm.plugin.setting.model.o):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.postToWorker(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.onCreate(android.os.Bundle):void, file: classes8.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0062: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.setting.model.o$1) = (r0v8 'oVar' com.tencent.mm.plugin.setting.model.o) call: com.tencent.mm.plugin.setting.model.o.1.<init>(com.tencent.mm.plugin.setting.model.o):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.onCreate(android.os.Bundle):void, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.setting.model.o, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        boolean z;
        AppMethodBeat.i(74607);
        super.onResume();
        if (-1 != this.Dfc) {
            if (-1 == this.Dfc) {
                z = false;
            } else {
                b bVar = this.jBE.get(this.Dfc);
                as asVar = bVar.contact;
                as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(asVar.field_username);
                if (com.tencent.mm.contact.c.oR(Kn.field_type) || !com.tencent.mm.contact.c.oR(asVar.field_type)) {
                    bVar.contact = Kn;
                    z = false;
                } else {
                    this.jBE.remove(this.Dfc);
                    z = true;
                }
            }
            if (z) {
                f.DfE++;
            }
            this.Dfc = -1;
        }
        this.Dfd.clear();
        if (this.DeW != null) {
            this.DeW.atj.notifyChanged();
        }
        AppMethodBeat.o(74607);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74608);
        super.onDestroy();
        int i2 = (this.CXW ? 4 : 0) | (this.CXX ? 2 : 0) | (this.CXV ? 1 : 0);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14434, Integer.valueOf(i2), Integer.valueOf(f.DfE), Integer.valueOf(f.DfD), Integer.valueOf(f.DfI), Integer.valueOf(f.DfF), Integer.valueOf(f.DfH), Integer.valueOf(f.DfG));
        Log.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", Integer.valueOf(i2), Integer.valueOf(f.DfE), Integer.valueOf(f.DfD), Integer.valueOf(f.DfI), Integer.valueOf(f.DfF), Integer.valueOf(f.DfH), Integer.valueOf(f.DfG));
        f.DfD = 0;
        f.DfE = 0;
        f.DfF = 0;
        f.DfG = 0;
        f.DfH = 0;
        f.DfI = 0;
        com.tencent.mm.kernel.g.azz().b(291, this);
        com.tencent.mm.kernel.g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.pay.d.CTRL_INDEX, this.Dfb);
        o oVar = this.Dfe;
        Log.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", Boolean.valueOf(oVar.CXW), Boolean.valueOf(oVar.CXV), Boolean.valueOf(oVar.CXX));
        if (oVar.CYd != null) {
            com.tencent.mm.kernel.g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX, oVar.CYd);
        }
        if (oVar.CYg != null) {
            oVar.CYg.cancel();
        }
        oVar.qmq.quit();
        AppMethodBeat.o(74608);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(74609);
        super.initView();
        setMMTitle(R.string.gw2);
        addTextOptionMenu(1, getString(R.string.hs_), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74568);
                UnfamiliarContactDetailUI.this.Dff = !UnfamiliarContactDetailUI.this.Dff;
                UnfamiliarContactDetailUI.this.Dfa.clear();
                UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.Dff);
                if (UnfamiliarContactDetailUI.this.Dff) {
                    UnfamiliarContactDetailUI.this.DeS.setEnabled(false);
                    UnfamiliarContactDetailUI.this.DeT.setEnabled(false);
                    UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(R.string.hs4));
                } else {
                    UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(R.string.hs_));
                }
                if (UnfamiliarContactDetailUI.this.DeW != null) {
                    UnfamiliarContactDetailUI.this.DeW.atj.notifyChanged();
                }
                AppMethodBeat.o(74568);
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74573);
                UnfamiliarContactDetailUI.this.finish();
                AppMethodBeat.o(74573);
                return true;
            }
        });
        findViewById(R.id.hml).setVisibility(this.CXV ? 0 : 8);
        View findViewById = findViewById(R.id.hmn);
        if (this.CXX) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        View findViewById2 = findViewById(R.id.hmm);
        if (!this.CXW) {
            i3 = 8;
        }
        findViewById2.setVisibility(i3);
        this.DeP = (RecyclerView) findViewById(R.id.izu);
        this.DeR = findViewById(R.id.aa7);
        this.DeQ = (TextView) findViewById(R.id.fcm);
        this.Dfb = new d(this.Dfa, new g() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.g
            public final void il(int i2, int i3) {
                AppMethodBeat.i(74574);
                f.DfD += i2;
                UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
                UnfamiliarContactDetailUI.this.DeQ.setText(UnfamiliarContactDetailUI.this.getString(R.string.hs8) + "(" + UnfamiliarContactDetailUI.this.jBE.size() + ")");
                if (UnfamiliarContactDetailUI.this.DeW != null) {
                    UnfamiliarContactDetailUI.this.DeW.atj.notifyChanged();
                }
                if (i3 < i2) {
                    Log.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", Integer.valueOf(i3), Integer.valueOf(i2));
                    com.tencent.mm.ui.base.h.c(UnfamiliarContactDetailUI.this.getContext(), UnfamiliarContactDetailUI.this.getString(R.string.hs5, new Object[]{Integer.valueOf(i2 - i3)}), "", true);
                }
                AppMethodBeat.o(74574);
            }

            @Override // com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.g
            public final void eTJ() {
                AppMethodBeat.i(182595);
                UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
                UnfamiliarContactDetailUI.this.DeQ.setText(UnfamiliarContactDetailUI.this.getString(R.string.hs8) + "(" + UnfamiliarContactDetailUI.this.jBE.size() + ")");
                if (UnfamiliarContactDetailUI.this.DeW != null) {
                    UnfamiliarContactDetailUI.this.DeW.atj.notifyChanged();
                }
                AppMethodBeat.o(182595);
            }

            @Override // com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.g
            public final void eTK() {
                AppMethodBeat.i(74575);
                UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, true);
                AppMethodBeat.o(74575);
            }
        });
        this.DeS = findViewById(R.id.izr);
        this.DeS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(74577);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.ui.base.h.a(UnfamiliarContactDetailUI.this.getContext(), true, UnfamiliarContactDetailUI.this.getContext().getString(R.string.hsc), UnfamiliarContactDetailUI.this.getContext().getString(R.string.bad), UnfamiliarContactDetailUI.this.getContext().getString(R.string.tf), UnfamiliarContactDetailUI.this.getContext().getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass7.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(74576);
                        if (UnfamiliarContactDetailUI.this.Dfb != null) {
                            com.tencent.mm.kernel.g.aAi();
                            com.tencent.mm.kernel.g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.pay.d.CTRL_INDEX, UnfamiliarContactDetailUI.this.Dfb);
                            d dVar = UnfamiliarContactDetailUI.this.Dfb;
                            dVar.index = 0;
                            dVar.zqp = 0;
                            dVar.Dfw = 0;
                            dVar.Dfx.clear();
                            dVar.Dfy.clear();
                            dVar.cancel();
                            if (dVar.Dfu != null) {
                                dVar.Dfu.eTK();
                            }
                            com.tencent.f.h.RTc.aX(dVar);
                        }
                        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
                        AppMethodBeat.o(74576);
                    }
                }, null, R.color.cd, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74577);
            }
        });
        this.DeT = findViewById(R.id.izs);
        this.DeT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(74580);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) UnfamiliarContactDetailUI.this, 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass8.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(74578);
                        mVar.a(0, (CharSequence) UnfamiliarContactDetailUI.this.getString(R.string.fe0), (CharSequence) UnfamiliarContactDetailUI.this.getString(R.string.glv), UnfamiliarContactDetailUI.this.getResources().getDrawable(R.raw.circle_notreceive), false);
                        mVar.a(1, (CharSequence) UnfamiliarContactDetailUI.this.getString(R.string.fe1), (CharSequence) UnfamiliarContactDetailUI.this.getString(R.string.glv), UnfamiliarContactDetailUI.this.getResources().getDrawable(R.raw.circle_notvisible), false);
                        AppMethodBeat.o(74578);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass8.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(74579);
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.pay.d.CTRL_INDEX, UnfamiliarContactDetailUI.this.Dfb);
                        UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.Dfa, i2);
                        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
                        if (UnfamiliarContactDetailUI.this.DeW != null) {
                            UnfamiliarContactDetailUI.this.DeW.atj.notifyChanged();
                        }
                        AppMethodBeat.o(74579);
                    }
                };
                eVar.dGm();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74580);
            }
        });
        this.DeU = findViewById(R.id.izt);
        this.DeU.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(74582);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CheckBox checkBox = (CheckBox) UnfamiliarContactDetailUI.this.DeU.findViewById(R.id.b0m);
                checkBox.setChecked(!checkBox.isChecked());
                if (checkBox.isChecked()) {
                    for (int i2 = 0; i2 < UnfamiliarContactDetailUI.this.jBE.size(); i2++) {
                        UnfamiliarContactDetailUI.this.Dfa.add(Integer.valueOf(i2));
                    }
                } else {
                    UnfamiliarContactDetailUI.this.Dfa.clear();
                }
                if (UnfamiliarContactDetailUI.this.Dfa.size() > 0) {
                    UnfamiliarContactDetailUI.this.DeT.setEnabled(true);
                    UnfamiliarContactDetailUI.this.DeS.setEnabled(true);
                } else {
                    UnfamiliarContactDetailUI.this.DeT.setEnabled(false);
                    UnfamiliarContactDetailUI.this.DeS.setEnabled(false);
                }
                UnfamiliarContactDetailUI.this.DeP.post(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(74581);
                        UnfamiliarContactDetailUI.this.DeW.atj.notifyChanged();
                        AppMethodBeat.o(74581);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74582);
            }
        });
        this.DeV = (TextView) findViewById(R.id.ior);
        this.DeP.setLayoutManager(new LinearLayoutManager());
        this.DeW = new a();
        this.DeP.setAdapter(this.DeW);
        this.DeX = (RealAlphabetScrollBar) findViewById(R.id.izv);
        this.DeX.setOnScrollBarTouchListener(new VerticalScrollBar.a() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass10 */

            @Override // com.tencent.mm.ui.base.VerticalScrollBar.a
            public final void DP(String str) {
                int i2;
                AppMethodBeat.i(74583);
                UnfamiliarContactDetailUI unfamiliarContactDetailUI = UnfamiliarContactDetailUI.this;
                if (unfamiliarContactDetailUI.DeY == null || !unfamiliarContactDetailUI.DeY.containsKey(str)) {
                    i2 = -1;
                } else {
                    i2 = unfamiliarContactDetailUI.DeY.get(str).intValue();
                }
                Log.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", str, Integer.valueOf(i2));
                if (i2 != -1) {
                    RecyclerView recyclerView = UnfamiliarContactDetailUI.this.DeP;
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
                }
                AppMethodBeat.o(74583);
            }
        });
        AppMethodBeat.o(74609);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(74610);
        if (i2 == 4) {
            onBackPressed();
            AppMethodBeat.o(74610);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(74610);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(74611);
        Log.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " " + qVar.getType());
        if (!(i2 == 0 && i3 == 0)) {
            Toast.makeText(this, getString(R.string.hsb), 1).show();
        }
        if (qVar.getType() == 291) {
            ku(false);
            this.Dfd.clear();
            this.DeW.atj.notifyChanged();
        }
        AppMethodBeat.o(74611);
    }

    private void gJ(List<b> list) {
        AppMethodBeat.i(74612);
        this.DeY.clear();
        this.DeZ.clear();
        int i2 = 0;
        String str = null;
        for (b bVar : list) {
            if (gAH.equalsIgnoreCase(bVar.Dfm)) {
                bVar.Dfm = "#";
            }
            str = bVar.Dfm;
            if (!str.equalsIgnoreCase(str)) {
                this.DeY.put(str.toUpperCase(), Integer.valueOf(i2));
                this.DeZ.put(Integer.valueOf(i2), str.toUpperCase());
            }
            i2++;
        }
        AppMethodBeat.o(74612);
    }

    static {
        AppMethodBeat.i(74619);
        AppMethodBeat.o(74619);
    }

    private void ku(boolean z) {
        AppMethodBeat.i(74613);
        Log.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.gxX = q.a(this, getString(R.string.hs7), true, 0, null);
            AppMethodBeat.o(74613);
            return;
        }
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
            this.gxX = null;
        }
        AppMethodBeat.o(74613);
    }

    /* access modifiers changed from: package-private */
    public class a extends RecyclerView.a {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(74590);
            c cVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c4u, viewGroup, false));
            AppMethodBeat.o(74590);
            return cVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            int i3;
            AppMethodBeat.i(74591);
            if (vVar instanceof c) {
                c cVar = (c) vVar;
                cVar.Dfq.setTag(Integer.valueOf(i2));
                cVar.aus.setTag(Integer.valueOf(i2));
                b bVar = (b) UnfamiliarContactDetailUI.this.jBE.get(i2);
                a.b.c((ImageView) cVar.gAN.getContentView(), bVar.contact.field_username);
                cVar.pIN.setText(com.tencent.mm.pluginsdk.ui.span.l.b(UnfamiliarContactDetailUI.this.getContext(), bVar.gCv, cVar.pIN.getTextSize()));
                cVar.Dfp.setVisibility(bVar.contact.arB() ? 0 : 8);
                ImageView imageView = cVar.Dfo;
                String str = bVar.contact.field_username;
                if (com.tencent.mm.plugin.sns.b.o.DCP != null && UnfamiliarContactDetailUI.this.Dfd.size() == 0) {
                    UnfamiliarContactDetailUI.this.Dfd.addAll(com.tencent.mm.plugin.sns.b.o.DCP.IZ(5));
                }
                if (UnfamiliarContactDetailUI.this.Dfd.contains(str)) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
                if (UnfamiliarContactDetailUI.this.DeZ.containsKey(Integer.valueOf(i2))) {
                    cVar.Dfn.setVisibility(0);
                    cVar.Dfn.setText((CharSequence) UnfamiliarContactDetailUI.this.DeZ.get(Integer.valueOf(i2)));
                } else {
                    cVar.Dfn.setVisibility(8);
                }
                if (UnfamiliarContactDetailUI.this.Dff) {
                    cVar.Dfr.setPadding(cVar.Dfr.getPaddingLeft(), cVar.Dfr.getPaddingTop(), 0, cVar.Dfr.getPaddingBottom());
                    if (UnfamiliarContactDetailUI.this.Dfa.contains(Integer.valueOf(i2))) {
                        cVar.checkBox.setChecked(true);
                    } else {
                        cVar.checkBox.setChecked(false);
                    }
                    cVar.Dfq.setVisibility(0);
                    AppMethodBeat.o(74591);
                    return;
                }
                cVar.Dfr.setPadding(cVar.Dfr.getPaddingLeft(), cVar.Dfr.getPaddingTop(), (int) UnfamiliarContactDetailUI.this.getResources().getDimension(R.dimen.i1), cVar.Dfr.getPaddingBottom());
                cVar.Dfq.setVisibility(8);
            }
            AppMethodBeat.o(74591);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(74592);
            int size = UnfamiliarContactDetailUI.this.jBE.size();
            AppMethodBeat.o(74592);
            return size;
        }

        public final b Xs(int i2) {
            AppMethodBeat.i(74593);
            if (UnfamiliarContactDetailUI.this.jBE.size() > i2) {
                b bVar = (b) UnfamiliarContactDetailUI.this.jBE.get(i2);
                AppMethodBeat.o(74593);
                return bVar;
            }
            b bVar2 = new b(new as());
            AppMethodBeat.o(74593);
            return bVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        String Dfm;
        as contact;
        String gCv;

        public b(as asVar) {
            this.contact = asVar;
        }
    }

    class c extends RecyclerView.v {
        TextView Dfn;
        ImageView Dfo;
        ImageView Dfp;
        LinearLayout Dfq;
        LinearLayout Dfr;
        View aus;
        CheckBox checkBox;
        MaskLayout gAN;
        TextView pIN;

        public c(View view) {
            super(view);
            AppMethodBeat.i(74596);
            this.aus = view;
            this.gAN = (MaskLayout) view.findViewById(R.id.b_y);
            this.pIN = (TextView) view.findViewById(R.id.bci);
            this.Dfn = (TextView) view.findViewById(R.id.b_x);
            this.Dfo = (ImageView) view.findViewById(R.id.bdg);
            this.Dfp = (ImageView) view.findViewById(R.id.bdh);
            this.Dfq = (LinearLayout) view.findViewById(R.id.b0n);
            this.checkBox = (CheckBox) view.findViewById(R.id.b0m);
            this.Dfr = (LinearLayout) view.findViewById(R.id.e23);
            this.Dfq.setOnClickListener(new View.OnClickListener(UnfamiliarContactDetailUI.this) {
                /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74594);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    int intValue = ((Integer) view.getTag()).intValue();
                    c.this.checkBox.setChecked(!c.this.checkBox.isChecked());
                    if (c.this.checkBox.isChecked()) {
                        UnfamiliarContactDetailUI.this.Dfa.add(Integer.valueOf(intValue));
                    } else {
                        UnfamiliarContactDetailUI.this.Dfa.remove(Integer.valueOf(intValue));
                    }
                    if (UnfamiliarContactDetailUI.this.Dfa.size() == 0) {
                        UnfamiliarContactDetailUI.this.DeT.setEnabled(false);
                        UnfamiliarContactDetailUI.this.DeS.setEnabled(false);
                    } else {
                        UnfamiliarContactDetailUI.this.DeT.setEnabled(true);
                        UnfamiliarContactDetailUI.this.DeS.setEnabled(true);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74594);
                }
            });
            view.setOnClickListener(new View.OnClickListener(UnfamiliarContactDetailUI.this) {
                /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74595);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    int intValue = ((Integer) view.getTag()).intValue();
                    b Xs = UnfamiliarContactDetailUI.this.DeW.Xs(intValue);
                    Log.i("MicroMsg.UnfamiliarContactUI", "position:%s", Integer.valueOf(intValue), Xs.gCv);
                    c.a(c.this, Xs, intValue);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74595);
                }
            });
            AppMethodBeat.o(74596);
        }

        static /* synthetic */ void a(c cVar, b bVar, int i2) {
            String str;
            cn aEZ;
            AppMethodBeat.i(74597);
            if (bVar == null) {
                AppMethodBeat.o(74597);
                return;
            }
            if (UnfamiliarContactDetailUI.this.Dff) {
                f.DfH++;
            } else {
                f.DfI++;
            }
            String str2 = bVar.gCv;
            String str3 = bVar.contact.field_username;
            String str4 = bVar.contact.field_nickname;
            if (!Util.isNullOrNil(str2) || (aEZ = ((l) com.tencent.mm.kernel.g.af(l.class)).aSO().aEZ(str3)) == null || Util.isNullOrNil(aEZ.field_encryptUsername)) {
                str = str2;
            } else {
                str = aEZ.field_conRemark;
            }
            if (!Util.isNullOrNil(str3)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str3);
                intent.putExtra("Contact_RemarkName", str);
                intent.putExtra("Contact_Nick", str4);
                com.tencent.mm.plugin.setting.c.jRt.c(intent, UnfamiliarContactDetailUI.this);
                UnfamiliarContactDetailUI.this.Dfc = i2;
            }
            AppMethodBeat.o(74597);
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends com.tencent.f.i.b implements i {
        g Dfu;
        Collection<Integer> Dfv;
        int Dfw = 0;
        LinkedList<String> Dfx = new LinkedList<>();
        LinkedList<k.b> Dfy = new LinkedList<>();
        int index = 0;
        int zqp = 0;

        d(Collection<Integer> collection, g gVar) {
            AppMethodBeat.i(74599);
            this.Dfv = collection;
            this.Dfu = gVar;
            AppMethodBeat.o(74599);
        }

        @Override // com.tencent.f.i.b
        public final boolean cancel() {
            AppMethodBeat.i(182596);
            super.cancel();
            if (this.Dfu != null) {
                UnfamiliarContactDetailUI.this.Dfa.clear();
                this.Dfu.eTJ();
            }
            AppMethodBeat.o(182596);
            return false;
        }

        public final void run() {
            AppMethodBeat.i(74600);
            this.zqp = this.Dfv.size();
            for (Integer num : this.Dfv) {
                int intValue = num.intValue();
                this.index++;
                int size = this.Dfv.size();
                int i2 = this.index;
                if (UnfamiliarContactDetailUI.this.DeW != null) {
                    as asVar = UnfamiliarContactDetailUI.this.DeW.Xs(intValue).contact;
                    if (as.bjp(asVar.field_username)) {
                        ((r) com.tencent.mm.kernel.g.af(r.class)).EG(asVar.field_username);
                    } else {
                        afh afh = new afh();
                        afh.Lqk = new dqi().bhy(Util.nullAsNil(asVar.field_username));
                        this.Dfy.add(new k.a(4, afh));
                        if (this.Dfy.size() % 20 == 0 || i2 == size) {
                            com.tencent.mm.kernel.g.aAi();
                            com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.ba.b(this.Dfy), 0);
                            this.Dfy.clear();
                        }
                    }
                }
            }
            AppMethodBeat.o(74600);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(74601);
            if (qVar.getType() == 681) {
                if (((com.tencent.mm.ba.b) qVar).jgb == null || ((b.c) ((com.tencent.mm.ba.b) qVar).jgb.getRespObj()) == null) {
                    Log.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
                    AppMethodBeat.o(74601);
                    return;
                }
                cxn cxn = ((b.c) ((com.tencent.mm.ba.b) qVar).jgb.getRespObj()).jgg;
                if (cxn.Ret != 0 || cxn.MBY == null || cxn.MBY.LRr == null) {
                    Log.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", Integer.valueOf(cxn.Ret));
                    AppMethodBeat.o(74601);
                    return;
                }
                List<k.b> list = ((com.tencent.mm.ba.b) qVar).jgc;
                LinkedList<Integer> linkedList = cxn.MBY.LRr;
                Log.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", Integer.valueOf(list.size()), Integer.valueOf(linkedList.size()));
                for (int i4 = 0; i4 < list.size(); i4++) {
                    k.b bVar = list.get(i4);
                    if (bVar.getCmdId() != 4) {
                        Log.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", Integer.valueOf(bVar.getCmdId()), bVar.toString());
                    } else {
                        this.zqp--;
                        afh afh = (afh) bVar.zqv;
                        if (linkedList.get(i4).intValue() == 0) {
                            this.Dfw++;
                            as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(z.a(afh.Lqk));
                            if (Kn != null) {
                                Kn.aqR();
                                bp.a(Kn.field_username, (bp.a) null);
                                ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().c(Kn.field_username, Kn);
                                ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjW(Kn.field_username);
                                this.Dfx.add(Kn.field_username);
                            }
                        } else {
                            Log.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", linkedList.get(i4), z.a(afh.Lqk));
                        }
                    }
                }
                if (this.zqp <= 0) {
                    Iterator<String> it = this.Dfx.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        Iterator it2 = UnfamiliarContactDetailUI.this.jBE.iterator();
                        while (it2.hasNext()) {
                            if (((b) it2.next()).contact.field_username.equals(next)) {
                                it2.remove();
                            }
                        }
                    }
                    UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.jBE);
                    UnfamiliarContactDetailUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.d.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(74598);
                            if (d.this.Dfu != null) {
                                d.this.Dfu.il(UnfamiliarContactDetailUI.this.Dfa.size(), d.this.Dfw);
                                UnfamiliarContactDetailUI.this.Dfa.clear();
                            }
                            AppMethodBeat.o(74598);
                        }
                    });
                }
            }
            AppMethodBeat.o(74601);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "delete_contact_task";
        }
    }

    static /* synthetic */ void b(UnfamiliarContactDetailUI unfamiliarContactDetailUI, boolean z) {
        AppMethodBeat.i(74614);
        if (!z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, R.anim.f6do);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass12 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(74589);
                    UnfamiliarContactDetailUI.this.DeR.setVisibility(8);
                    AppMethodBeat.o(74589);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            unfamiliarContactDetailUI.DeR.startAnimation(loadAnimation);
        } else {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, R.anim.dq);
            loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass2 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(74569);
                    UnfamiliarContactDetailUI.this.DeR.setVisibility(0);
                    AppMethodBeat.o(74569);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            unfamiliarContactDetailUI.DeR.startAnimation(loadAnimation2);
        }
        unfamiliarContactDetailUI.Dff = z;
        if (unfamiliarContactDetailUI.Dff) {
            unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(R.string.hs4));
            AppMethodBeat.o(74614);
            return;
        }
        unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(R.string.hs_));
        ((CheckBox) unfamiliarContactDetailUI.DeU.findViewById(R.id.b0m)).setChecked(false);
        AppMethodBeat.o(74614);
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, final HashSet hashSet, final int i2) {
        AppMethodBeat.i(74616);
        unfamiliarContactDetailUI.ku(true);
        if (i2 == 0) {
            f.DfG += hashSet.size();
        } else if (i2 == 1) {
            f.DfF += hashSet.size();
        }
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(74572);
                LinkedList linkedList = new LinkedList();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    b Xs = UnfamiliarContactDetailUI.this.DeW.Xs(((Integer) it.next()).intValue());
                    Log.i("MicroMsg.UnfamiliarContactUI", "username:%s index:%s", Xs.contact.field_username, Integer.valueOf(i2));
                    if (i2 == 0) {
                        vx vxVar = new vx();
                        vxVar.ebX.ebZ = false;
                        vxVar.ebX.ebY = true;
                        vxVar.ebX.username = Xs.contact.field_username;
                        EventCenter.instance.publish(vxVar);
                        linkedList.add(Xs.contact.field_username);
                    } else if (i2 == 1) {
                        Xs.contact.arf();
                        vx vxVar2 = new vx();
                        vxVar2.ebX.ebZ = true;
                        vxVar2.ebX.ebY = false;
                        vxVar2.ebX.username = Xs.contact.field_username;
                        EventCenter.instance.publish(vxVar2);
                        ab.v(Xs.contact);
                    }
                }
                if (linkedList.size() > 0) {
                    pr prVar = new pr();
                    prVar.dVH.list = linkedList;
                    prVar.dVH.dJY = 1;
                    prVar.dVH.dVI = 5;
                    EventCenter.instance.publish(prVar);
                    AppMethodBeat.o(74572);
                    return;
                }
                UnfamiliarContactDetailUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(74571);
                        UnfamiliarContactDetailUI.this.DeW.atj.notifyChanged();
                        UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
                        AppMethodBeat.o(74571);
                    }
                });
                AppMethodBeat.o(74572);
            }
        });
        AppMethodBeat.o(74616);
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, HashSet hashSet) {
        String str;
        String substring;
        AppMethodBeat.i(74617);
        unfamiliarContactDetailUI.jBE.clear();
        LinkedList linkedList = new LinkedList();
        Iterator it = hashSet.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            linkedList.add((String) it.next());
            i2++;
            if (i2 % 200 == 0 || i2 == hashSet.size()) {
                Cursor iJ = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().iJ(linkedList);
                if (iJ != null) {
                    iJ.moveToFirst();
                    while (!iJ.isAfterLast()) {
                        as asVar = new as();
                        asVar.convertFrom(iJ);
                        if (!com.tencent.mm.contact.c.oR(asVar.field_type)) {
                            Log.d("MicroMsg.UnfamiliarContactUI", "contact:%s username:%s", asVar.field_nickname, asVar.field_username);
                            iJ.moveToNext();
                        } else {
                            b bVar = new b(asVar);
                            as asVar2 = bVar.contact;
                            if (asVar2 == null) {
                                str = null;
                            } else {
                                str = asVar2.field_nickname;
                                if (!Util.isNullOrNil(asVar2.field_conRemark)) {
                                    str = asVar2.field_conRemark;
                                } else if (Util.isNullOrNil(str)) {
                                    str = asVar2.arI();
                                }
                            }
                            String str2 = "";
                            if (TextUtils.isEmpty(str)) {
                                Log.w("MicroMsg.UnfamiliarContactUI", "[%s:%s]", asVar.field_username, asVar.field_nickname);
                            } else {
                                str2 = SpellMap.x(str.charAt(0));
                            }
                            if (Util.isNullOrNil(str2)) {
                                substring = gAH;
                            } else if (!str2.matches("[a-zA-Z]+$")) {
                                substring = gAH;
                            } else {
                                substring = str2.toLowerCase().substring(0, 1);
                            }
                            bVar.Dfm = substring;
                            bVar.gCv = str;
                            unfamiliarContactDetailUI.jBE.add(bVar);
                            iJ.moveToNext();
                        }
                    }
                    iJ.close();
                }
                linkedList.clear();
            }
        }
        Collections.sort(unfamiliarContactDetailUI.jBE, new Comparator<b>() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(b bVar, b bVar2) {
                AppMethodBeat.i(74570);
                int compareTo = bVar.Dfm.compareTo(bVar2.Dfm);
                AppMethodBeat.o(74570);
                return compareTo;
            }
        });
        unfamiliarContactDetailUI.gJ(unfamiliarContactDetailUI.jBE);
        AppMethodBeat.o(74617);
    }
}
