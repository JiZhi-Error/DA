package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.a.j;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.m;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bizchat.BizChatSearchListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class BizChatSearchUI extends MMActivity implements b.a, BizChatSearchListView.a {
    String PaZ;
    private String Pba;
    private c Pbb;
    private BizChatSearchListView Pbc;
    private a Pbd;
    com.tencent.mm.modelvoiceaddr.ui.b poM;
    String ppO;
    private int scene;
    private TextView tipView;
    private AbsListView.OnScrollListener xPk = new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.ui.bizchat.BizChatSearchUI.AnonymousClass1 */
        boolean poB = false;

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(33989);
            if (i2 == 0 && this.poB && BizChatSearchUI.this.Pbd.Pby) {
                a aVar = BizChatSearchUI.this.Pbd;
                if (aVar.gMd() && !aVar.PbA) {
                    aVar.PbA = true;
                    bg.azz().a(new m(aVar.ppO, aVar.gzZ, aVar.PbG), 0);
                    aVar.gMh();
                }
            }
            AppMethodBeat.o(33989);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i2 + i3 == i4) {
                this.poB = true;
            } else {
                this.poB = false;
            }
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizChatSearchUI() {
        AppMethodBeat.i(34012);
        AppMethodBeat.o(34012);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34013);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(34013);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnA() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnB() {
    }

    public final void a(a aVar) {
        AppMethodBeat.i(34015);
        if (!a.c(aVar)) {
            if (Util.isNullOrNil(aVar.gzZ)) {
                this.tipView.setVisibility(0);
                this.tipView.setText("");
                this.Pbc.setVisibility(8);
            } else if (a.b(aVar) && aVar.Pbz) {
                this.tipView.setVisibility(0);
                this.tipView.setText(R.string.ak6);
                this.Pbc.setVisibility(8);
            } else if (a.b(aVar) && aVar.PbF) {
                this.tipView.setVisibility(0);
                this.tipView.setText(R.string.ak7);
                this.Pbc.setVisibility(8);
            } else if (aVar.getCount() <= 0) {
                this.tipView.setVisibility(0);
                this.tipView.setText(com.tencent.mm.plugin.fts.a.f.a(getString(R.string.gfv), getString(R.string.gfu), com.tencent.mm.plugin.fts.a.a.e.c(aVar.gzZ, aVar.gzZ)).wWu);
                this.Pbc.setVisibility(8);
            } else {
                this.tipView.setVisibility(8);
                this.Pbc.setVisibility(0);
            }
            if (a.b(aVar)) {
                if (aVar.PbA) {
                    alR(1);
                    AppMethodBeat.o(34015);
                    return;
                } else if (aVar.Pby) {
                    alR(2);
                    AppMethodBeat.o(34015);
                    return;
                } else {
                    alR(0);
                }
            }
            AppMethodBeat.o(34015);
        } else if (Util.isNullOrNil(aVar.gzZ)) {
            this.tipView.setVisibility(8);
            this.Pbc.setVisibility(8);
            AppMethodBeat.o(34015);
        } else if (aVar.getCount() <= 0) {
            this.tipView.setVisibility(0);
            this.Pbc.setVisibility(8);
            AppMethodBeat.o(34015);
        } else {
            this.tipView.setVisibility(8);
            this.Pbc.setVisibility(0);
            AppMethodBeat.o(34015);
        }
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnz() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bny() {
        AppMethodBeat.i(34016);
        finish();
        AppMethodBeat.o(34016);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void SO(String str) {
        boolean z;
        String str2 = null;
        AppMethodBeat.i(34017);
        if (!Util.isNullOrNil(str) || this.Pba == null) {
            a aVar = this.Pbd;
            aVar.gzZ = str;
            if (Util.isNullOrNil(str)) {
                aVar.clearData();
                aVar.Pbz = false;
                aVar.PbF = false;
                aVar.BG(true);
                AppMethodBeat.o(34017);
                return;
            }
            if (aVar.scene == 4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                aVar.clearData();
                aVar.Pbz = false;
                aVar.PbF = false;
                aVar.bmq(str);
                AppMethodBeat.o(34017);
            } else if (aVar.gMd()) {
                aVar.Pbz = true;
                aVar.PbF = false;
                aVar.gMh();
                aVar.dp(str, false);
                aVar.bmr(str);
                AppMethodBeat.o(34017);
            } else {
                aVar.dp(str, true);
                if (aVar.Pbh && aVar.Pbz) {
                    aVar.bmr(str);
                }
                if (aVar.Pbj) {
                    aVar.bmq(str);
                }
                AppMethodBeat.o(34017);
            }
        } else {
            String str3 = this.Pba;
            this.Pba = null;
            if (!str3.equals("")) {
                this.poM.setSearchContent(str3);
            }
            com.tencent.mm.modelvoiceaddr.ui.b bVar = this.poM;
            if (a.c(this.Pbd)) {
                str2 = getContext().getResources().getString(R.string.ak8);
            } else if (a.b(this.Pbd)) {
                str2 = getContext().getResources().getString(R.string.akc);
            } else if (a.e(this.Pbd)) {
                str2 = getContext().getResources().getString(R.string.ak5);
            }
            bVar.setHint(str2);
            this.poM.clearFocus();
            AppMethodBeat.o(34017);
        }
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final boolean SN(String str) {
        AppMethodBeat.i(34018);
        hideVKB();
        AppMethodBeat.o(34018);
        return true;
    }

    @Override // com.tencent.mm.modelvoiceaddr.ui.b.a
    public final void biM() {
        AppMethodBeat.i(34019);
        hideVKB();
        AppMethodBeat.o(34019);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(34020);
        super.onPause();
        this.poM.cancel();
        this.poM.clearFocus();
        AppMethodBeat.o(34020);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(34021);
        super.onDestroy();
        AppMethodBeat.o(34021);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(34022);
        this.poM.a((FragmentActivity) this, menu);
        AppMethodBeat.o(34022);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(34023);
        this.poM.a((Activity) this, menu);
        AppMethodBeat.o(34023);
        return true;
    }

    @Override // com.tencent.mm.modelvoiceaddr.ui.b.a
    public final void a(boolean z, String[] strArr, long j2, int i2) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a42;
    }

    @Override // com.tencent.mm.ui.bizchat.BizChatSearchListView.a
    public final boolean clY() {
        AppMethodBeat.i(34024);
        hideVKB();
        AppMethodBeat.o(34024);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void a(com.tencent.mm.api.c cVar, int i2) {
        AppMethodBeat.i(232792);
        com.tencent.mm.al.d MO = ag.bar().MO(this.PaZ);
        long j2 = MO != null ? MO.field_wwCorpId : 0;
        long j3 = MO != null ? MO.field_wwUserVid : 0;
        long UK = cVar.UK();
        h.INSTANCE.a(14507, Long.valueOf(j2), Long.valueOf(UK), Long.valueOf(j3), 2, 2, Integer.valueOf(i2));
        Log.d("MicroMsg.BizChatSearchUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", Long.valueOf(j2), Long.valueOf(UK), Long.valueOf(j3), 1, 2, Integer.valueOf(i2));
        AppMethodBeat.o(232792);
    }

    private void alR(int i2) {
        AppMethodBeat.i(34025);
        if (this.Pbb != null) {
            this.Pbb.updateStatus(i2);
        }
        AppMethodBeat.o(34025);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter implements i {
        public static int Pbf = 3;
        private String PaZ;
        public boolean PbA = false;
        private boolean PbB = true;
        private boolean PbC = true;
        private int PbD = 0;
        private int PbE = 0;
        public boolean PbF = false;
        int PbG = 0;
        private int Pbg;
        boolean Pbh;
        boolean Pbi;
        boolean Pbj;
        private ArrayList<com.tencent.mm.al.a.c> Pbk = new ArrayList<>();
        private ArrayList<Object> Pbl = new ArrayList<>();
        private ArrayList<com.tencent.mm.al.a.c> Pbm = new ArrayList<>();
        private ArrayList<com.tencent.mm.ui.base.sortview.d> Pbn = new ArrayList<>();
        private List<com.tencent.mm.ui.base.sortview.d> Pbo;
        private g Pbp;
        private ArrayList<g> Pbq = new ArrayList<>();
        private g Pbr;
        private g Pbs;
        private ArrayList<g> Pbt = new ArrayList<>();
        private g Pbu;
        private g Pbv;
        private ArrayList<g> Pbw = new ArrayList<>();
        private g Pbx;
        public boolean Pby = true;
        public boolean Pbz = false;
        private int akb = 0;
        private Context context;
        String gzZ;
        private com.tencent.mm.av.a.a.c jaR;
        String ppO;
        int scene;

        static /* synthetic */ boolean b(a aVar) {
            AppMethodBeat.i(34007);
            boolean gMd = aVar.gMd();
            AppMethodBeat.o(34007);
            return gMd;
        }

        static /* synthetic */ boolean c(a aVar) {
            AppMethodBeat.i(34008);
            boolean gMc = aVar.gMc();
            AppMethodBeat.o(34008);
            return gMc;
        }

        static /* synthetic */ boolean e(a aVar) {
            AppMethodBeat.i(34009);
            boolean gMe = aVar.gMe();
            AppMethodBeat.o(34009);
            return gMe;
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(34006);
            g alS = alS(i2);
            AppMethodBeat.o(34006);
            return alS;
        }

        public a(Context context2, String str, String str2, int i2) {
            boolean z;
            boolean z2 = false;
            AppMethodBeat.i(232788);
            this.context = context2;
            this.ppO = str;
            this.PaZ = str2;
            this.scene = i2;
            this.Pbh = this.scene == 1 || this.scene == 2;
            if (this.scene == 1 || this.scene == 3) {
                z = true;
            } else {
                z = false;
            }
            this.Pbi = z;
            if (!Util.isNullOrNil(this.PaZ) && (this.scene == 1 || this.scene == 4)) {
                z2 = true;
            }
            this.Pbj = z2;
            this.Pbg = this.scene == 1 ? Pbf : Integer.MAX_VALUE;
            c.a aVar = new c.a();
            aVar.prefixPath = com.tencent.mm.al.a.e.fe(this.ppO);
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.jbq = R.raw.default_avatar;
            this.jaR = aVar.bdv();
            if (this.Pbj) {
                this.Pbo = getSortEntityList();
            }
            if (this.Pbh) {
                bg.azz().a(1364, this);
            }
            AppMethodBeat.o(232788);
        }

        /* access modifiers changed from: package-private */
        public final void bmq(String str) {
            AppMethodBeat.i(232789);
            this.Pbn.clear();
            if (!Util.isNullOrNil(str) && this.Pbo != null) {
                for (com.tencent.mm.ui.base.sortview.d dVar : this.Pbo) {
                    if (a(str, dVar)) {
                        this.Pbn.add(dVar);
                    }
                }
            }
            BG(true);
            AppMethodBeat.o(232789);
        }

        private static boolean a(String str, com.tencent.mm.ui.base.sortview.d dVar) {
            AppMethodBeat.i(232790);
            if (!Util.isNullOrNil(str) && dVar != null) {
                qw qwVar = (qw) dVar.data;
                if (qwVar == null) {
                    AppMethodBeat.o(232790);
                    return false;
                }
                String arJ = qwVar.contact.arJ();
                String ajz = qwVar.contact.ajz();
                String ajA = qwVar.contact.ajA();
                String upperCase = str.toUpperCase();
                if ((!Util.isNullOrNil(arJ) && arJ.toUpperCase().indexOf(upperCase) != -1) || ((!Util.isNullOrNil(ajz) && ajz.toUpperCase().indexOf(upperCase) != -1) || (!Util.isNullOrNil(ajA) && ajA.toUpperCase().startsWith(upperCase)))) {
                    AppMethodBeat.o(232790);
                    return true;
                }
            }
            AppMethodBeat.o(232790);
            return false;
        }

        public final int getCount() {
            return this.akb;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(33993);
            g alS = alS(i2);
            if (alS != null) {
                int i3 = alS.qcr;
                AppMethodBeat.o(33993);
                return i3;
            }
            int i4 = g.PbJ;
            AppMethodBeat.o(33993);
            return i4;
        }

        public final int getViewTypeCount() {
            return g.PbQ;
        }

        public final g alS(int i2) {
            AppMethodBeat.i(33994);
            if (i2 < this.PbD) {
                if (i2 == 0) {
                    if (this.Pbp == null) {
                        this.Pbp = new g(g.PbO, Integer.valueOf(g.PbR));
                    }
                    g gVar = this.Pbp;
                    AppMethodBeat.o(33994);
                    return gVar;
                } else if (i2 == this.PbD - 1 && this.Pbz && gMc()) {
                    if (this.Pbr == null) {
                        this.Pbr = new g();
                    }
                    this.Pbr.qcr = g.PbN;
                    this.Pbr.data = Integer.valueOf(g.PbR);
                    g gVar2 = this.Pbr;
                    AppMethodBeat.o(33994);
                    return gVar2;
                } else if (i2 != this.PbD - 1 || !this.Pby || !gMc()) {
                    int i3 = i2 - 1;
                    if (i3 >= 0 && i3 < this.Pbq.size()) {
                        g gVar3 = this.Pbq.get(i3);
                        AppMethodBeat.o(33994);
                        return gVar3;
                    }
                } else {
                    if (this.Pbr == null) {
                        this.Pbr = new g();
                    }
                    this.Pbr.qcr = g.PbM;
                    this.Pbr.data = Integer.valueOf(g.PbR);
                    g gVar4 = this.Pbr;
                    AppMethodBeat.o(33994);
                    return gVar4;
                }
            } else if (i2 < this.PbE) {
                if (i2 == this.PbD) {
                    if (this.Pbs == null) {
                        this.Pbs = new g(g.PbO, Integer.valueOf(g.PbS));
                    }
                    g gVar5 = this.Pbs;
                    AppMethodBeat.o(33994);
                    return gVar5;
                } else if (i2 != this.akb - 1 || !this.PbB || !gMc()) {
                    int i4 = (i2 - this.PbD) - 1;
                    if (i4 >= 0 && i4 < this.Pbt.size()) {
                        g gVar6 = this.Pbt.get(i4);
                        AppMethodBeat.o(33994);
                        return gVar6;
                    }
                } else {
                    if (this.Pbu == null) {
                        this.Pbu = new g(g.PbM, Integer.valueOf(g.PbS));
                    }
                    g gVar7 = this.Pbu;
                    AppMethodBeat.o(33994);
                    return gVar7;
                }
            } else if (i2 == this.PbE) {
                if (this.Pbv == null) {
                    this.Pbv = new g(g.PbO, Integer.valueOf(g.PbT));
                }
                g gVar8 = this.Pbv;
                AppMethodBeat.o(33994);
                return gVar8;
            } else if (i2 != this.akb - 1 || !this.PbC || !gMc()) {
                int i5 = (i2 - this.PbE) - 1;
                if (i5 >= 0 && i5 < this.Pbw.size()) {
                    g gVar9 = this.Pbw.get(i5);
                    AppMethodBeat.o(33994);
                    return gVar9;
                }
            } else {
                if (this.Pbx == null) {
                    this.Pbx = new g(g.PbM, Integer.valueOf(g.PbT));
                }
                g gVar10 = this.Pbx;
                AppMethodBeat.o(33994);
                return gVar10;
            }
            g gVar11 = new g();
            AppMethodBeat.o(33994);
            return gVar11;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            boolean z;
            String str;
            String str2;
            SpannableString a2;
            CharSequence charSequence;
            String str3;
            k fB;
            boolean z2;
            boolean z3;
            String str4;
            AppMethodBeat.i(33995);
            g alS = alS(i2);
            if (alS.qcr == g.PbK || alS.qcr == g.PbL || alS.qcr == g.PbP) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.layout.an2, viewGroup, false);
                    view.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
                    f fVar = new f((byte) 0);
                    fVar.gvv = (ImageView) view.findViewById(R.id.x1);
                    fVar.jVO = (TextView) view.findViewById(R.id.ir3);
                    fVar.jBR = (TextView) view.findViewById(R.id.bn6);
                    fVar.contentView = view.findViewById(R.id.hee);
                    view.setTag(fVar);
                }
                f fVar2 = (f) view.getTag();
                String str5 = "";
                String str6 = "";
                boolean z4 = false;
                String str7 = "";
                if (alS.data instanceof com.tencent.mm.al.a.c) {
                    com.tencent.mm.al.a.c cVar = (com.tencent.mm.al.a.c) alS.data;
                    if (cVar == null) {
                        str3 = str6;
                    } else if (cVar.isGroup() || (fB = ag.bal().fB(cVar.field_bizChatServId)) == null) {
                        String str8 = cVar.field_chatName;
                        str3 = cVar.field_headImageUrl;
                        str5 = str8;
                    } else {
                        String str9 = fB.field_userName;
                        str3 = fB.field_headImageUrl;
                        str5 = str9;
                    }
                    z4 = false;
                    z = true;
                    str = str3;
                    str2 = str5;
                } else if (alS.data instanceof nx) {
                    nx nxVar = (nx) alS.data;
                    oa oaVar = nxVar.KTw;
                    str2 = oaVar.pWm;
                    str = oaVar.KTm;
                    boolean equals = "userid".equals(nxVar.KTx);
                    boolean z5 = !equals;
                    str7 = nxVar.KTy;
                    z = z5;
                    z4 = equals;
                } else if (alS.data instanceof com.tencent.mm.ui.base.sortview.d) {
                    qw qwVar = (qw) ((com.tencent.mm.ui.base.sortview.d) alS.data).data;
                    if (qwVar != null) {
                        if (qwVar.contact != null) {
                            str5 = qwVar.contact.arJ();
                        }
                        if (qwVar.Bdk != null) {
                            str6 = qwVar.Bdk.field_brandIconURL;
                        }
                    }
                    z4 = false;
                    z = true;
                    str = str6;
                    str2 = str5;
                } else {
                    z = false;
                    str = str6;
                    str2 = str5;
                }
                if (z) {
                    a2 = a(this.context, com.tencent.mm.plugin.fts.a.f.b(str2, this.gzZ), b.c.wZV);
                } else {
                    a2 = a(this.context, new SpannableString(str2), b.c.wZV);
                }
                if (z4) {
                    charSequence = TextUtils.concat(this.context.getString(R.string.akd), a(this.context, com.tencent.mm.plugin.fts.a.f.b(str7, this.gzZ), b.c.wZV));
                } else {
                    charSequence = "";
                }
                boolean z6 = true;
                if (alS.qcr == g.PbK && i2 == this.PbD - 1 && this.PbD != this.akb) {
                    z6 = false;
                }
                n.r(fVar2.contentView, z6);
                q.bcV().a(str, fVar2.gvv, this.jaR);
                n.a(a2, fVar2.jVO);
                n.a(charSequence, fVar2.jBR);
                AppMethodBeat.o(33995);
                return view;
            } else if (alS.qcr == g.PbO) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.layout.je, viewGroup, false);
                    b bVar = new b((byte) 0);
                    bVar.qqq = (TextView) view.findViewById(R.id.ior);
                    bVar.xcK = view.findViewById(R.id.g8b);
                    bVar.contentView = view.findViewById(R.id.hee);
                    view.setTag(bVar);
                }
                b bVar2 = (b) view.getTag();
                if (((Integer) alS.data).intValue() == g.PbR) {
                    str4 = this.context.getResources().getString(R.string.akb);
                } else if (((Integer) alS.data).intValue() == g.PbS) {
                    str4 = this.context.getResources().getString(R.string.ak4);
                } else if (((Integer) alS.data).intValue() == g.PbT) {
                    str4 = this.context.getResources().getString(R.string.ak3);
                } else {
                    str4 = "";
                }
                n.b(str4, bVar2.qqq);
                if (i2 == 0) {
                    bVar2.xcK.setVisibility(8);
                } else {
                    bVar2.xcK.setVisibility(0);
                }
                bVar2.contentView.setBackgroundResource(R.drawable.b9x);
                AppMethodBeat.o(33995);
                return view;
            } else if (alS.qcr == g.PbM) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.layout.jf, viewGroup, false);
                    e eVar = new e((byte) 0);
                    eVar.xcs = (TextView) view.findViewById(R.id.ior);
                    eVar.nnL = (ImageView) view.findViewById(R.id.dtx);
                    eVar.contentView = view.findViewById(R.id.hee);
                    view.setTag(eVar);
                }
                e eVar2 = (e) view.getTag();
                String str10 = "";
                if (((Integer) alS.data).intValue() == g.PbR) {
                    str10 = this.context.getResources().getString(R.string.aka);
                } else if (((Integer) alS.data).intValue() == g.PbS) {
                    str10 = this.context.getResources().getString(R.string.ak_);
                } else if (((Integer) alS.data).intValue() == g.PbT) {
                    str10 = this.context.getResources().getString(R.string.ak9);
                }
                if (((Integer) alS.data).intValue() != g.PbR || this.PbD == this.akb) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                n.r(eVar2.contentView, z3);
                eVar2.xcs.setText(str10);
                eVar2.nnL.setImageResource(R.raw.fts_more_button_icon);
                AppMethodBeat.o(33995);
                return view;
            } else if (alS.qcr == g.PbN) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.layout.anj, viewGroup, false);
                    d dVar = new d((byte) 0);
                    dVar.xcs = (TextView) view.findViewById(R.id.ior);
                    dVar.contentView = view.findViewById(R.id.hee);
                    view.setTag(dVar);
                }
                d dVar2 = (d) view.getTag();
                if (((Integer) alS.data).intValue() != g.PbR || this.PbD == this.akb) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                n.r(dVar2.contentView, z2);
                dVar2.xcs.setText(this.context.getResources().getString(R.string.ak6));
                AppMethodBeat.o(33995);
                return view;
            } else {
                AppMethodBeat.o(33995);
                return null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c3, code lost:
            if (r9.Pbl.size() <= r9.Pbk.size()) goto L_0x00c5;
         */
        @Override // com.tencent.mm.ak.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int r10, int r11, java.lang.String r12, com.tencent.mm.ak.q r13) {
            /*
            // Method dump skipped, instructions count: 285
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.bizchat.BizChatSearchUI.a.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
        }

        private void gMb() {
            AppMethodBeat.i(33997);
            if (gMd()) {
                this.Pbz = false;
                this.PbF = true;
                gMh();
            }
            AppMethodBeat.o(33997);
        }

        private boolean gMc() {
            return this.scene == 1;
        }

        /* access modifiers changed from: package-private */
        public final boolean gMd() {
            return this.scene == 2;
        }

        private boolean gMe() {
            return this.scene == 3;
        }

        private static SpannableString a(Context context2, Spannable spannable, int i2) {
            AppMethodBeat.i(33998);
            SpannableString e2 = l.e(context2, (CharSequence) spannable, i2);
            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
            if (foregroundColorSpanArr != null) {
                for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                    e2.setSpan(foregroundColorSpan, spannable.getSpanStart(foregroundColorSpan), spannable.getSpanEnd(foregroundColorSpan), spannable.getSpanFlags(foregroundColorSpan));
                }
            }
            AppMethodBeat.o(33998);
            return e2;
        }

        /* access modifiers changed from: package-private */
        public final void dp(String str, boolean z) {
            AppMethodBeat.i(33999);
            List<com.tencent.mm.al.a.c> bi = ag.bak().bi(this.ppO, str);
            clearData();
            for (com.tencent.mm.al.a.c cVar : bi) {
                boolean isGroup = cVar.isGroup();
                if (isGroup && this.Pbi) {
                    this.Pbm.add(cVar);
                } else if (!isGroup && this.Pbh) {
                    this.Pbl.add(cVar);
                    this.Pbk.add(cVar);
                }
            }
            if (this.Pbh) {
                this.Pbz = this.Pbl.size() <= this.Pbg;
            }
            BG(z);
            AppMethodBeat.o(33999);
        }

        /* access modifiers changed from: package-private */
        public final void bmr(final String str) {
            AppMethodBeat.i(34000);
            if (!this.Pbh) {
                AppMethodBeat.o(34000);
                return;
            }
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.ui.bizchat.BizChatSearchUI.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(33991);
                    if (!str.equals(a.this.gzZ)) {
                        AppMethodBeat.o(33991);
                        return;
                    }
                    bg.azz().a(new m(a.this.ppO, str, 0), 0);
                    AppMethodBeat.o(33991);
                }
            }, 200);
            AppMethodBeat.o(34000);
        }

        private void gMf() {
            boolean z;
            boolean z2;
            int i2;
            int i3;
            int i4;
            int i5 = 1;
            AppMethodBeat.i(34001);
            int size = this.Pbl.size();
            int size2 = this.Pbm.size();
            int size3 = this.Pbn.size();
            if (this.scene != 2) {
                this.Pby = this.Pbl.size() > this.Pbg;
            }
            if (this.Pbm.size() > this.Pbg) {
                z = true;
            } else {
                z = false;
            }
            this.PbB = z;
            if (this.Pbn.size() > this.Pbg) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.PbC = z2;
            if (size > 0 || this.Pbz) {
                int min = Math.min(size, this.Pbg) + 1;
                if (gMc()) {
                    if (this.Pbz || this.Pby) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    i2 = i4 + min;
                } else {
                    i2 = min;
                }
            } else {
                i2 = 0;
            }
            this.PbD = i2;
            if (size2 > 0) {
                int min2 = Math.min(size2, this.Pbg) + i2 + 1;
                if (gMc()) {
                    if (this.PbB) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    i2 = i3 + min2;
                } else {
                    i2 = min2;
                }
            }
            this.PbE = i2;
            if (size3 > 0) {
                i2 = i2 + 1 + Math.min(size3, this.Pbg);
                if (gMc()) {
                    if (!this.PbC) {
                        i5 = 0;
                    }
                    i2 += i5;
                }
            }
            this.akb = i2;
            AppMethodBeat.o(34001);
        }

        private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList() {
            AppMethodBeat.i(232791);
            ArrayList arrayList = new ArrayList();
            ag.bah();
            Cursor O = com.tencent.mm.al.f.O(this.PaZ, true);
            while (O.moveToNext()) {
                qw qwVar = new qw();
                if (O != null) {
                    as asVar = new as();
                    asVar.convertFrom(O);
                    com.tencent.mm.api.c cVar = new com.tencent.mm.api.c();
                    cVar.convertFrom(O);
                    qwVar.userName = asVar.field_username;
                    qwVar.contact = asVar;
                    qwVar.Bdk = cVar;
                }
                if (qwVar.contact != null) {
                    com.tencent.mm.ui.base.sortview.d dVar = new com.tencent.mm.ui.base.sortview.d();
                    dVar.data = qwVar;
                    if (qwVar.Bdk.UH()) {
                        dVar.Pae = "!1";
                    } else if (qwVar.contact.arE()) {
                        dVar.Pae = "!2";
                    } else {
                        int aqN = qwVar.contact.aqN();
                        if (aqN >= 97 && aqN <= 122) {
                            aqN -= 32;
                        }
                        if (aqN < 65 || aqN > 90) {
                            dVar.Pae = "#";
                        } else {
                            dVar.Pae = new StringBuilder().append((char) aqN).toString();
                        }
                    }
                    arrayList.add(dVar);
                }
            }
            O.close();
            Collections.sort(arrayList, new C2083a(this, (byte) 0));
            AppMethodBeat.o(232791);
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI$a$a  reason: collision with other inner class name */
        public class C2083a implements Comparator<com.tencent.mm.ui.base.sortview.d> {
            private C2083a() {
            }

            /* synthetic */ C2083a(a aVar, byte b2) {
                this();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(com.tencent.mm.ui.base.sortview.d dVar, com.tencent.mm.ui.base.sortview.d dVar2) {
                int i2;
                int i3;
                int i4;
                int i5;
                boolean z;
                boolean z2;
                AppMethodBeat.i(232787);
                com.tencent.mm.ui.base.sortview.d dVar3 = dVar;
                com.tencent.mm.ui.base.sortview.d dVar4 = dVar2;
                String str = dVar3.Pae;
                String str2 = dVar4.Pae;
                if (str == null || str2 == null) {
                    i2 = 0;
                } else {
                    i2 = str.compareToIgnoreCase(str2);
                }
                if (i2 != 0) {
                    if (str.equalsIgnoreCase("#")) {
                        i2 = 1;
                    }
                    if (str2.equalsIgnoreCase("#")) {
                        i2 = -1;
                    }
                    AppMethodBeat.o(232787);
                    return i2;
                }
                qw qwVar = (qw) dVar3.data;
                qw qwVar2 = (qw) dVar4.data;
                if (!(str == null || str2 == null || (!str.equalsIgnoreCase("!2") && !str.equalsIgnoreCase("!1")))) {
                    int aqN = qwVar.contact.aqN();
                    int aqN2 = qwVar2.contact.aqN();
                    if ((aqN < 97 || aqN > 122) && (aqN < 65 || aqN > 90)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if ((aqN2 < 97 || aqN2 > 122) && (aqN2 < 65 || aqN2 > 90)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && !z2) {
                        AppMethodBeat.o(232787);
                        return 1;
                    } else if (!z && z2) {
                        AppMethodBeat.o(232787);
                        return -1;
                    }
                }
                if (qwVar.contact == null || qwVar.contact.ajA() == null || qwVar.contact.ajA().length() <= 0 || qwVar2.contact == null || qwVar2.contact.ajA() == null || qwVar2.contact.ajA().length() <= 0) {
                    i3 = 0;
                } else {
                    i3 = qwVar.contact.ajA().compareToIgnoreCase(qwVar2.contact.ajA());
                }
                if (i3 != 0) {
                    AppMethodBeat.o(232787);
                    return i3;
                }
                if (qwVar.contact == null || qwVar.contact.field_nickname == null || qwVar.contact.field_nickname.length() <= 0 || qwVar2.contact == null || qwVar2.contact.field_nickname == null || qwVar2.contact.field_nickname.length() <= 0) {
                    i4 = 0;
                } else {
                    i4 = qwVar.contact.field_nickname.compareToIgnoreCase(qwVar2.contact.field_nickname);
                }
                if (i4 != 0) {
                    AppMethodBeat.o(232787);
                    return i4;
                }
                if (qwVar.contact == null || qwVar.contact.field_username == null || qwVar.contact.field_username.length() <= 0 || qwVar2.contact == null || qwVar2.contact.field_username == null || qwVar2.contact.field_username.length() <= 0) {
                    i5 = 0;
                } else {
                    i5 = qwVar.contact.field_username.compareToIgnoreCase(qwVar2.contact.field_username);
                }
                if (i5 != 0) {
                    AppMethodBeat.o(232787);
                    return i5;
                }
                AppMethodBeat.o(232787);
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public final void clearData() {
            AppMethodBeat.i(34002);
            this.PbG = 0;
            this.Pbl.clear();
            this.Pbk.clear();
            this.Pbm.clear();
            AppMethodBeat.o(34002);
        }

        /* access modifiers changed from: package-private */
        public final void BG(boolean z) {
            AppMethodBeat.i(34003);
            gMg();
            gMf();
            if (z) {
                notifyDataSetChanged();
                gMh();
            }
            AppMethodBeat.o(34003);
        }

        private void gMg() {
            AppMethodBeat.i(34004);
            this.Pbq.clear();
            this.Pbt.clear();
            this.Pbw.clear();
            for (int i2 = 0; i2 < Math.min(this.Pbg, this.Pbl.size()); i2++) {
                this.Pbq.add(new g(g.PbK, this.Pbl.get(i2)));
            }
            for (int i3 = 0; i3 < Math.min(this.Pbg, this.Pbm.size()); i3++) {
                this.Pbt.add(new g(g.PbL, this.Pbm.get(i3)));
            }
            for (int i4 = 0; i4 < Math.min(this.Pbg, this.Pbn.size()); i4++) {
                this.Pbw.add(new g(g.PbP, this.Pbn.get(i4)));
            }
            AppMethodBeat.o(34004);
        }

        /* access modifiers changed from: package-private */
        public final void gMh() {
            AppMethodBeat.i(34005);
            ((BizChatSearchUI) this.context).a(this);
            AppMethodBeat.o(34005);
        }
    }

    /* access modifiers changed from: package-private */
    public static class g {
        public static int PbJ = 0;
        public static int PbK = 1;
        public static int PbL = 2;
        public static int PbM = 3;
        public static int PbN = 4;
        public static int PbO = 5;
        public static int PbP = 6;
        public static int PbQ = 7;
        public static int PbR = 1;
        public static int PbS = 2;
        public static int PbT = 3;
        public Object data;
        public int qcr;

        public g() {
            this.qcr = PbJ;
            this.data = null;
        }

        public g(int i2, Object obj) {
            this.qcr = i2;
            this.data = obj;
        }
    }

    static class f {
        public View contentView;
        public ImageView gvv;
        public TextView jBR;
        public TextView jVO;

        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }
    }

    static class e {
        public View contentView;
        public ImageView nnL;
        public TextView xcs;

        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }

    static class b {
        public View contentView;
        public TextView qqq;
        public View xcK;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static class d {
        public View contentView;
        public TextView xcs;

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        View poD;
        View poE;
        View poF;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final void updateStatus(int i2) {
            AppMethodBeat.i(34010);
            switch (i2) {
                case 1:
                    G(true, false);
                    AppMethodBeat.o(34010);
                    return;
                case 2:
                    G(false, true);
                    AppMethodBeat.o(34010);
                    return;
                default:
                    G(false, false);
                    AppMethodBeat.o(34010);
                    return;
            }
        }

        private void G(boolean z, boolean z2) {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(34011);
            View view = this.poD;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
            this.poE.setVisibility(8);
            View view2 = this.poF;
            if (!z2) {
                i3 = 8;
            }
            view2.setVisibility(i3);
            AppMethodBeat.o(34011);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(34014);
        if (Util.isNullOrNil(this.ppO)) {
            this.ppO = getIntent().getStringExtra("enterprise_biz_name");
            this.PaZ = getIntent().getStringExtra("enterprise_biz_father_name");
            this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
            this.Pba = getIntent().getStringExtra("biz_chat_search_text");
            if (Util.isNullOrNil(this.ppO)) {
                finish();
            }
        }
        this.Pbc = (BizChatSearchListView) findViewById(R.id.a_b);
        this.tipView = (TextView) findViewById(R.id.g01);
        this.Pbd = new a(getContext(), this.ppO, this.PaZ, this.scene);
        if (a.b(this.Pbd)) {
            this.Pbb = new c((byte) 0);
            BizChatSearchListView bizChatSearchListView = this.Pbc;
            c cVar = this.Pbb;
            View inflate = View.inflate(getContext(), R.layout.b27, null);
            cVar.poD = inflate.findViewById(R.id.epq);
            cVar.poE = inflate.findViewById(R.id.epf);
            cVar.poF = inflate.findViewById(R.id.ept);
            cVar.poD.setVisibility(8);
            cVar.poE.setVisibility(8);
            cVar.poF.setVisibility(8);
            bizChatSearchListView.addFooterView(inflate);
            alR(0);
        }
        this.Pbc.setAdapter((ListAdapter) this.Pbd);
        this.Pbc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatSearchUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(33990);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                g alS = BizChatSearchUI.this.Pbd.alS(i2);
                BizChatSearchUI bizChatSearchUI = BizChatSearchUI.this;
                if (alS.qcr == g.PbK || alS.qcr == g.PbL) {
                    long j3 = -1;
                    if (alS.data instanceof com.tencent.mm.al.a.c) {
                        com.tencent.mm.al.a.c cVar = (com.tencent.mm.al.a.c) alS.data;
                        if (cVar != null) {
                            j3 = cVar.field_bizChatLocalId;
                        }
                    } else if (alS.data instanceof nx) {
                        oa oaVar = ((nx) alS.data).KTw;
                        String str = bizChatSearchUI.ppO;
                        boolean z = true;
                        k kVar = new k();
                        kVar.field_userId = oaVar.KTu;
                        kVar.field_userName = oaVar.pWm;
                        kVar.field_brandUserName = str;
                        kVar.field_headImageUrl = oaVar.KTm;
                        kVar.field_profileUrl = oaVar.gTH;
                        kVar.field_UserVersion = oaVar.ver;
                        kVar.field_addMemberUrl = oaVar.KTr;
                        if (!ag.bal().b(kVar)) {
                            z = ag.bal().a(kVar);
                        }
                        if (!z) {
                            j3 = -1;
                        } else {
                            com.tencent.mm.al.a.c cVar2 = new com.tencent.mm.al.a.c();
                            cVar2.field_bizChatServId = kVar.field_userId;
                            cVar2.field_brandUserName = kVar.field_brandUserName;
                            cVar2.field_chatName = kVar.field_userName;
                            cVar2.field_chatType = j.BIZ_CHAT_TYPE_GROUP.iQq;
                            com.tencent.mm.al.a.c e2 = com.tencent.mm.al.a.e.e(cVar2);
                            if (e2 == null) {
                                j3 = -1;
                            } else {
                                com.tencent.mm.al.a.a Al = ag.bak().Al(e2.field_bizChatLocalId);
                                Al.field_bizChatId = e2.field_bizChatLocalId;
                                Al.field_unReadCount = 0;
                                if (Util.isNullOrNil(Al.field_brandUserName)) {
                                    Al.field_brandUserName = e2.field_brandUserName;
                                    Al.field_lastMsgTime = System.currentTimeMillis();
                                    Al.field_flag = Al.field_lastMsgTime;
                                }
                                if (!ag.bak().b(Al)) {
                                    ag.bak().a(Al);
                                }
                                j3 = e2.field_bizChatLocalId;
                            }
                        }
                    }
                    if (!Util.isNullOrNil(bizChatSearchUI.ppO) && j3 >= 0) {
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", bizChatSearchUI.ppO);
                        intent.putExtra("key_biz_chat_id", j3);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("key_need_send_video", false);
                        intent.putExtra("key_is_biz_chat", true);
                        com.tencent.mm.br.c.f(bizChatSearchUI.getContext(), ".ui.chatting.ChattingUI", intent);
                    }
                } else if (alS.qcr == g.PbP) {
                    try {
                        qw qwVar = (qw) ((com.tencent.mm.ui.base.sortview.d) alS.data).data;
                        if (qwVar != null) {
                            boolean Nh = com.tencent.mm.al.g.Nh(qwVar.userName);
                            boolean DQ = com.tencent.mm.al.g.DQ(qwVar.userName);
                            com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(qwVar.userName);
                            String UJ = fJ == null ? null : fJ.UJ();
                            if (UJ == null) {
                                UJ = "";
                            }
                            if (Nh) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", UJ);
                                intent2.putExtra("useJs", true);
                                intent2.putExtra("srcUsername", qwVar.userName);
                                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                                intent2.addFlags(67108864);
                                com.tencent.mm.br.c.b(bizChatSearchUI.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                                bizChatSearchUI.a(fJ, 2);
                            } else if (DQ) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("Contact_User", qwVar.userName);
                                intent3.addFlags(67108864);
                                intent3.putExtra("biz_chat_from_scene", 3);
                                com.tencent.mm.br.c.f(bizChatSearchUI.getContext(), ".ui.bizchat.BizChatConversationUI", intent3);
                            } else {
                                Intent intent4 = new Intent();
                                intent4.addFlags(67108864);
                                intent4.putExtra("finish_direct", true);
                                intent4.putExtra("Chat_User", qwVar.userName);
                                intent4.putExtra("chat_from_scene", 2);
                                com.tencent.mm.plugin.brandservice.b.d(intent4, bizChatSearchUI.getContext());
                                bizChatSearchUI.a(fJ, 1);
                            }
                        }
                    } catch (Throwable th) {
                    }
                } else if (alS.qcr == g.PbM) {
                    if (((Integer) alS.data).intValue() == g.PbR) {
                        Intent intent5 = new Intent(bizChatSearchUI.getContext(), BizChatSearchUI.class);
                        intent5.putExtra("enterprise_biz_name", bizChatSearchUI.ppO);
                        intent5.putExtra("biz_chat_search_scene", 2);
                        intent5.putExtra("biz_chat_search_text", bizChatSearchUI.poM.getSearchContent());
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent5);
                        com.tencent.mm.hellhoundlib.a.a.a(bizChatSearchUI, bl.axQ(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        bizChatSearchUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(bizChatSearchUI, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else if (((Integer) alS.data).intValue() == g.PbS) {
                        Intent intent6 = new Intent(bizChatSearchUI.getContext(), BizChatSearchUI.class);
                        intent6.putExtra("enterprise_biz_name", bizChatSearchUI.ppO);
                        intent6.putExtra("biz_chat_search_scene", 3);
                        intent6.putExtra("biz_chat_search_text", bizChatSearchUI.poM.getSearchContent());
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent6);
                        com.tencent.mm.hellhoundlib.a.a.a(bizChatSearchUI, bl2.axQ(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        bizChatSearchUI.startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(bizChatSearchUI, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else if (((Integer) alS.data).intValue() == g.PbT) {
                        Intent intent7 = new Intent(bizChatSearchUI.getContext(), BizChatSearchUI.class);
                        intent7.putExtra("enterprise_biz_name", bizChatSearchUI.ppO);
                        intent7.putExtra("enterprise_biz_father_name", bizChatSearchUI.PaZ);
                        intent7.putExtra("biz_chat_search_scene", 4);
                        intent7.putExtra("biz_chat_search_text", bizChatSearchUI.poM.getSearchContent());
                        com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent7);
                        com.tencent.mm.hellhoundlib.a.a.a(bizChatSearchUI, bl3.axQ(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        bizChatSearchUI.startActivity((Intent) bl3.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(bizChatSearchUI, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(33990);
            }
        });
        this.Pbc.setOnTouchListener(this);
        if (a.b(this.Pbd)) {
            this.Pbc.setOnScrollListener(this.xPk);
        }
        this.poM = new com.tencent.mm.modelvoiceaddr.ui.b();
        this.poM.CK(a.c(this.Pbd));
        this.poM.a((b.a) this);
        this.poM.jxF = false;
        AppMethodBeat.o(34014);
    }
}
