package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@i
public abstract class MMBaseSelectContactUI extends MMActivity implements AdapterView.OnItemClickListener, MultiSelectContactView.c, MultiSelectContactView.d, MultiSelectContactView.e, VerticalScrollBar.a, n, s.b {
    private View Bnt;
    protected ListView Bvb;
    private View PUm;
    protected AlphabetScrollBar PWj;
    private q PWk;
    public o PWl;
    private View PWm;
    private p PWn;
    private View PWo;
    private View PWp;
    private View PWq;
    private TextView PWr;
    public LabelContainerView PWs;
    private TextView PWt;
    private MMTagPanel PWu;
    private boolean PWv = true;
    private List<String> PWw = new ArrayList();
    boolean PWx = false;
    protected s gzP;
    public int scene;
    public MultiSelectContactView zoy;

    /* access modifiers changed from: protected */
    public abstract boolean bmA();

    /* access modifiers changed from: protected */
    public abstract String bmB();

    /* access modifiers changed from: protected */
    public abstract q bmC();

    /* access modifiers changed from: protected */
    public abstract o bmD();

    /* access modifiers changed from: protected */
    public abstract boolean bmz();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
        if (!g.aAc()) {
            Log.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
            Log.appenderFlushSync();
            finish();
            return;
        }
        amZ();
        Log.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
        initView();
        Log.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
    }

    public p gUP() {
        if (getContentLV().getHeaderViewsCount() > 0) {
            if (getContentLV().getAdapter() instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) getContentLV().getAdapter();
                if (headerViewListAdapter.getWrappedAdapter() instanceof p) {
                    return (p) headerViewListAdapter.getWrappedAdapter();
                }
            }
            return null;
        } else if (getContentLV().getAdapter() instanceof p) {
            return (p) getContentLV().getAdapter();
        } else {
            return null;
        }
    }

    @Override // com.tencent.mm.ui.contact.n
    public ListView getContentLV() {
        return this.Bvb;
    }

    public q gUQ() {
        return this.PWk;
    }

    public final MultiSelectContactView hYI() {
        return this.zoy;
    }

    public final void gUR() {
        if (this.PWm != null) {
            this.PWm.setVisibility(0);
            this.PWo.setBackgroundColor(getResources().getColor(R.color.BW_93));
        }
    }

    public final void gUS() {
        if (this.PWm != null) {
            this.PWm.setVisibility(8);
            this.PWo.setBackgroundColor(getResources().getColor(R.color.afz));
        }
    }

    /* access modifiers changed from: protected */
    public void amZ() {
        this.scene = getIntent().getIntExtra("scene", 0);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        setMMTitle(bmB());
        this.PWm = findViewById(R.id.it7);
        this.PUm = findViewById(R.id.it4);
        this.Bvb = (ListView) findViewById(R.id.hhi);
        Cq(true);
        this.PWl = bmD();
        this.Bnt = findViewById(R.id.hn9);
        if (gUY()) {
            this.PWq = findViewById(R.id.g02);
            this.PWr = (TextView) findViewById(R.id.g01);
            this.PWq.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(102851);
                    MMBaseSelectContactUI.this.gUV();
                    MMBaseSelectContactUI.this.gUW();
                    MMBaseSelectContactUI.this.gUX();
                    AppMethodBeat.o(102851);
                    return false;
                }
            });
            this.zoy = (MultiSelectContactView) findViewById(R.id.bcg);
            this.zoy.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
            this.zoy.setOnSearchTextChangeListener(this);
            this.zoy.setOnSearchTextFouceChangeListener(this);
            this.zoy.setOnContactDeselectListener(this);
            this.PWp = LayoutInflater.from(this).inflate(R.layout.wc, (ViewGroup) null);
            this.PWo = this.PWp.findViewById(R.id.dnu);
            this.Bvb.addHeaderView(this.PWp);
            if (bmz()) {
                hideActionbarLine();
                if (this.zoy != null) {
                    this.zoy.setVisibility(8);
                }
                this.PWm.setVisibility(0);
                this.PWo.setBackgroundColor(getResources().getColor(R.color.BW_93));
                this.PUm.setVisibility(8);
                this.gzP = new s((byte) 0);
                this.gzP.Qwi = this;
                this.PWm.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(102852);
                        b bVar = new b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.d("MicroMsg.MMBaseSelectContactUI", "dancy test topSearchView onClick!!");
                        MMBaseSelectContactUI.this.gzP.CK(true);
                        MMBaseSelectContactUI.this.PWm.setVisibility(8);
                        MMBaseSelectContactUI.this.PUm.setVisibility(0);
                        MMBaseSelectContactUI.this.PWo.setVisibility(8);
                        a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(102852);
                    }
                });
                this.PUm.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass4 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(102853);
                        MMBaseSelectContactUI.this.gzP.gXP();
                        MMBaseSelectContactUI.this.PWm.setVisibility(0);
                        MMBaseSelectContactUI.this.PUm.setVisibility(8);
                        MMBaseSelectContactUI.this.PWo.setVisibility(0);
                        AppMethodBeat.o(102853);
                        return true;
                    }
                });
            } else {
                if (this.PWm != null) {
                    this.PWm.setVisibility(8);
                    this.PWo.setBackgroundColor(getResources().getColor(R.color.afz));
                }
                if (this.PUm != null) {
                    this.PUm.setVisibility(8);
                }
                this.zoy.setVisibility(0);
            }
        }
        a(this.Bvb, 0);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(102854);
                MMBaseSelectContactUI.this.egJ();
                AppMethodBeat.o(102854);
                return true;
            }
        });
        if (this.PWl != null) {
            this.PWl.a(new o.a() {
                /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass6 */

                @Override // com.tencent.mm.ui.contact.o.a
                public final void B(String str, int i2, boolean z) {
                    AppMethodBeat.i(102855);
                    Log.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", Integer.valueOf(i2));
                    if (MMBaseSelectContactUI.this.PUm != null) {
                        MMBaseSelectContactUI.this.PUm.setVisibility(8);
                    }
                    if (!z || i2 != 0) {
                        MMBaseSelectContactUI.g(MMBaseSelectContactUI.this);
                        AppMethodBeat.o(102855);
                    } else if (!Util.isNullOrNil(str)) {
                        MMBaseSelectContactUI.f(MMBaseSelectContactUI.this);
                        AppMethodBeat.o(102855);
                    } else {
                        MMBaseSelectContactUI.this.gUV();
                        AppMethodBeat.o(102855);
                    }
                }
            });
        }
        this.Bvb.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass7 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(102856);
                if (i2 != 0) {
                    MMBaseSelectContactUI.this.hideVKB();
                    MMBaseSelectContactUI.this.gUX();
                }
                AppMethodBeat.o(102856);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(102857);
                if (!MMBaseSelectContactUI.this.bmz() && MMBaseSelectContactUI.this.zoy != null) {
                    View childAt = MMBaseSelectContactUI.this.Bvb.getChildAt(MMBaseSelectContactUI.this.Bvb.getFirstVisiblePosition());
                    if (childAt == null || childAt.getTop() != 0) {
                        MMBaseSelectContactUI.this.Bnt.setVisibility(0);
                    } else {
                        MMBaseSelectContactUI.this.Bnt.setVisibility(8);
                    }
                }
                if (i2 < 2) {
                    AppMethodBeat.o(102857);
                    return;
                }
                g.aAi();
                if (!Util.nullAsFalse((Boolean) g.aAh().azQ().get(12296, (Object) null))) {
                    g.aAi();
                    g.aAh().azQ().set(12296, Boolean.TRUE);
                    if (MMBaseSelectContactUI.this.PWn != null) {
                        MMBaseSelectContactUI.this.PWn.dismiss();
                    }
                    MMBaseSelectContactUI.this.PWn = u.a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.getString(R.string.evh), 4000);
                }
                AppMethodBeat.o(102857);
            }
        });
        this.Bvb.setOnItemClickListener(this);
        if (bmA()) {
            this.PWj = (AlphabetScrollBar) findViewById(R.id.hhk);
            this.PWj.setVisibility(0);
            this.PWj.setOnScrollBarTouchListener(this);
        }
        if (eim()) {
            this.PWs = (LabelContainerView) findViewById(R.id.hhh);
            this.PWt = (TextView) this.PWs.findViewById(16908310);
            this.PWt.setText(R.string.ghg);
            this.PWu = (MMTagPanel) this.PWs.findViewById(R.id.bcb);
            this.PWu.setTagSelectedBG(R.drawable.ayi);
            this.PWu.setTagSelectedTextColorRes(R.color.a2x);
            this.PWs.setOnLabelContainerListener(new LabelContainerView.a() {
                /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass8 */

                @Override // com.tencent.mm.ui.contact.LabelContainerView.a
                public final void cIi() {
                    AppMethodBeat.i(102858);
                    if (MMBaseSelectContactUI.this.zoy != null) {
                        MMBaseSelectContactUI.this.zoy.clearFocus();
                    }
                    if (MMBaseSelectContactUI.this.gzP != null) {
                        MMBaseSelectContactUI.this.gzP.clearFocus();
                        MMBaseSelectContactUI.this.gzP.gXP();
                    }
                    MMBaseSelectContactUI.this.PWs.requestFocus();
                    MMBaseSelectContactUI.this.PWs.setVisibility(8);
                    AppMethodBeat.o(102858);
                }

                @Override // com.tencent.mm.ui.contact.LabelContainerView.a
                public final void cIj() {
                    AppMethodBeat.i(102859);
                    MMBaseSelectContactUI.this.hideVKB();
                    AppMethodBeat.o(102859);
                }
            });
            this.PWu.setCallBack(new MMTagPanel.a() {
                /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass9 */

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void anb(String str) {
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void anc(String str) {
                    AppMethodBeat.i(102860);
                    MMBaseSelectContactUI.this.aDT(str);
                    AppMethodBeat.o(102860);
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void and(String str) {
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void E(boolean z, int i2) {
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void cIk() {
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void ane(String str) {
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void anf(String str) {
                }
            });
        }
    }

    public final void hYJ() {
        if (this.zoy != null) {
            this.zoy.hYa();
        }
    }

    public final void hYK() {
        if (this.zoy != null) {
            this.zoy.hYb();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!bmz()) {
            return super.onCreateOptionsMenu(menu);
        }
        this.gzP.a((FragmentActivity) this, menu);
        if (menu != null) {
            for (int i2 = 0; i2 < menu.size(); i2++) {
                MenuItem item = menu.getItem(i2);
                if (item.getItemId() == R.id.fdi) {
                    item.setVisible(false);
                }
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!bmz()) {
            return super.onPrepareOptionsMenu(menu);
        }
        this.gzP.a((Activity) this, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        int i3;
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        int headerViewsCount = i2 - getContentLV().getHeaderViewsCount();
        if (headerViewsCount >= 0) {
            com.tencent.mm.ui.contact.a.a anH = gUP().getItem(headerViewsCount);
            anH.bmx().a(getContext(), view, anH);
            if (anH.hkH) {
                int i4 = anH.wXQ;
                int i5 = anH.wXR;
                if (anH.dOL()) {
                    i3 = 15;
                } else if (i4 == 131072) {
                    switch (i5) {
                        case 1:
                            i3 = 1;
                            break;
                        case 2:
                            i3 = 2;
                            break;
                        case 3:
                            i3 = 3;
                            break;
                        case 4:
                            i3 = 4;
                            break;
                        case 5:
                            i3 = 5;
                            break;
                        case 6:
                            i3 = 6;
                            break;
                        case 7:
                            i3 = 7;
                            break;
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 13:
                        case 14:
                        default:
                            i3 = 0;
                            break;
                        case 11:
                            i3 = 8;
                            break;
                        case 15:
                            i3 = 16;
                            break;
                        case 16:
                            i3 = 10;
                            break;
                        case 17:
                        case 18:
                            i3 = 9;
                            break;
                    }
                } else if (i4 == 131075) {
                    switch (i5) {
                        case 1:
                        case 5:
                            i3 = 12;
                            break;
                        case 2:
                        case 6:
                            i3 = 13;
                            break;
                        case 3:
                        case 7:
                            i3 = 14;
                            break;
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                            i3 = 11;
                            break;
                        default:
                            i3 = 0;
                            break;
                    }
                } else if (i4 == 65536) {
                    i3 = 17;
                } else {
                    i3 = 0;
                }
                int i6 = 0;
                switch (anH.wXQ) {
                    case 65536:
                        i6 = 5;
                        break;
                    case 131072:
                        i6 = 2;
                        break;
                    case 131075:
                        i6 = 3;
                        break;
                    case 131076:
                        i6 = 4;
                        break;
                }
                if (anH.Qad) {
                    i6 = 1;
                }
                if (anH.qcr == 5) {
                    i6 = 7;
                }
                String format = String.format("%s,%d,%d,%d,%d", anH.query, Integer.valueOf(anH.scene), Integer.valueOf(i6), Integer.valueOf(anH.wXL), Integer.valueOf(i3));
                Log.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", format);
                h.INSTANCE.kvStat(13234, format);
            }
        }
        if (!gUP().anI(i2)) {
            M(view, i2);
        }
        a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    }

    public void M(View view, int i2) {
    }

    private String gUT() {
        if (this.gzP != null) {
            return this.gzP.getSearchContent();
        }
        if (this.zoy != null) {
            return this.zoy.getSearchContent();
        }
        return "";
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gUU() {
        boolean hasFocus;
        if (this.gzP != null) {
            hasFocus = this.gzP.gXp();
        } else {
            hasFocus = this.zoy != null ? this.zoy.hasFocus() : false;
        }
        if (!hasFocus || !Util.isNullOrNil(gUT())) {
            if (this.PWs != null) {
                this.PWs.setVisibility(8);
            }
        } else if (this.PWw == null || this.PWw.size() <= 0) {
            this.PWs.setVisibility(8);
        } else {
            this.PWs.setVisibility(0);
            this.PWu.a((Collection<String>) null, this.PWw);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        if (this.PWn != null) {
            this.PWn.dismiss();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (eim() && this.PWv) {
            this.PWv = false;
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(102862);
                    MMBaseSelectContactUI.this.PWw = com.tencent.mm.plugin.label.a.a.ecg().ecb();
                    MMBaseSelectContactUI.this.PWv = true;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass10.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(102861);
                            MMBaseSelectContactUI.this.gUU();
                            AppMethodBeat.o(102861);
                        }
                    });
                    AppMethodBeat.o(102862);
                }

                public final String toString() {
                    AppMethodBeat.i(102863);
                    String str = super.toString() + "|updateLabelList";
                    AppMethodBeat.o(102863);
                    return str;
                }
            });
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.PWj != null) {
            this.PWj.OWL = null;
        }
        if (this.PWk != null) {
            this.PWk.finish();
        }
        if (this.PWl != null) {
            this.PWl.finish();
        }
        if (this.PWn != null) {
            this.PWn.dismiss();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ba8;
    }

    @Override // com.tencent.mm.pluginsdk.ui.MultiSelectContactView.d
    public final void bey(String str) {
        Log.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", str);
        if (eim()) {
            gUU();
        }
        if (this.PWl == null) {
            return;
        }
        if (!Util.isNullOrNil(str)) {
            this.PWl.b(str, egI());
            return;
        }
        this.PWl.clearData();
        this.PWl.notifyDataSetChanged();
        gUV();
    }

    @Override // com.tencent.mm.pluginsdk.ui.MultiSelectContactView.e
    public final void goT() {
        if (eim()) {
            gUU();
        }
    }

    public int[] egI() {
        return new int[]{131072, 131075, 131081};
    }

    /* access modifiers changed from: protected */
    public void a(ListView listView, int i2) {
    }

    public void egJ() {
        hideVKB();
        finish();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            egJ();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.tencent.mm.ui.base.VerticalScrollBar.a
    public final void DP(String str) {
        int i2;
        ListAdapter adapter = this.Bvb.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
        }
        if (adapter == this.PWk && this.PWk != null) {
            i2 = this.PWk.bnr(str);
        } else if (adapter == this.PWl) {
            i2 = this.PWl.bnr(str);
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            this.Bvb.setSelection(0);
        } else if (i2 <= 0) {
            Log.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", Integer.valueOf(i2), str);
        } else if (bmz()) {
            this.Bvb.setSelection(i2);
        } else if (this.zoy != null) {
            this.Bvb.setSelectionFromTop(i2, this.zoy.getMeasuredHeight());
            Log.i("MicroMsg.MMBaseSelectContactUI", "Select head selectPosition=%d | header=%s | y=%d", Integer.valueOf(i2), str, Integer.valueOf(this.zoy.getMeasuredHeight()));
        }
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final boolean SN(String str) {
        return false;
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void SO(String str) {
        Log.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", str);
        if (eim()) {
            if (this.gzP != null) {
                this.gzP.gXq();
            }
            gUU();
        }
        if (!Util.isNullOrNil(str)) {
            this.PWl.b(str, egI());
            return;
        }
        this.PWl.clearData();
        this.PWl.notifyDataSetChanged();
        gUV();
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bny() {
        gUV();
        if (eim()) {
            gUU();
        }
        if (bmz()) {
            this.PWm.setVisibility(0);
            this.PWo.setBackgroundColor(getResources().getColor(R.color.BW_93));
            this.PUm.setVisibility(8);
            this.PWo.setVisibility(0);
        }
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnz() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gUV() {
        Log.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
        a(this.Bvb, 0);
        if (this.PWk != null) {
            this.Bvb.setAdapter((ListAdapter) this.PWk);
            this.PWk.notifyDataSetChanged();
        } else {
            Cq(false);
        }
        if (bmA() && this.PWj != null) {
            this.PWj.setVisibility(0);
        }
        this.PWq.setVisibility(8);
    }

    private void Cq(final boolean z) {
        if (!this.PWx) {
            if (this.PWk == null) {
                this.PWk = bmC();
            }
            this.Bvb.setAdapter((ListAdapter) this.PWk);
            return;
        }
        com.tencent.f.h.RTc.bqo("InitAdaperAsync_SelectUI");
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass2 */

            public final void run() {
                int i2 = 1;
                AppMethodBeat.i(219808);
                Object[] objArr = new Object[1];
                if (!z) {
                    i2 = 0;
                }
                objArr[0] = Integer.valueOf(i2);
                Log.i("MicroMsg.MMBaseSelectContactUI", "createInitAdapterAnsync start, fromInit:%d", objArr);
                try {
                    if (MMBaseSelectContactUI.this.PWk == null) {
                        MMBaseSelectContactUI.this.PWk = MMBaseSelectContactUI.this.bmC();
                    }
                    if (MMBaseSelectContactUI.this.Bvb != null) {
                        MMBaseSelectContactUI.this.Bvb.post(new Runnable() {
                            /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(219806);
                                if (!(MMBaseSelectContactUI.this.Bvb == null || MMBaseSelectContactUI.this.PWk == null)) {
                                    MMBaseSelectContactUI.this.Bvb.setAdapter((ListAdapter) MMBaseSelectContactUI.this.PWk);
                                }
                                AppMethodBeat.o(219806);
                            }
                        });
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MMBaseSelectContactUI", e2, "createInitAdapterAnsync exception", new Object[0]);
                }
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.ui.contact.MMBaseSelectContactUI.AnonymousClass2.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(219807);
                        if (MMBaseSelectContactUI.this.PWk != null) {
                            MMBaseSelectContactUI.this.PWk.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(219807);
                    }
                });
                AppMethodBeat.o(219808);
            }
        }, "InitAdaperAsync_SelectUI");
    }

    @Override // com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
    public void T(int i2, String str) {
    }

    @Override // com.tencent.mm.ui.contact.n
    public boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.n
    public boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.n
    public Activity getActivity() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean eim() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void aDT(String str) {
        Log.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", str);
    }

    public final void gUW() {
        if (this.gzP != null && !Util.isNullOrNil(this.gzP.getSearchContent())) {
            s sVar = this.gzP;
            if (sVar.Qwh != null) {
                sVar.Qwh.CH(true);
            }
        }
        if (this.zoy != null && !Util.isNullOrNil(this.zoy.getSearchContent())) {
            this.zoy.getInputText().setText("");
        }
    }

    /* access modifiers changed from: protected */
    public final void gUX() {
        if (this.gzP != null) {
            if (this.gzP.gXp()) {
                this.gzP.clearFocus();
            }
        } else if (this.zoy != null && this.zoy.hasFocus()) {
            this.zoy.clearFocus();
        }
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnA() {
        if (this.PUm != null) {
            this.PUm.setVisibility(0);
        }
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnB() {
    }

    public boolean gUY() {
        return this.PWl != null;
    }

    static /* synthetic */ void f(MMBaseSelectContactUI mMBaseSelectContactUI) {
        mMBaseSelectContactUI.gUV();
        mMBaseSelectContactUI.PWq.setVisibility(0);
        if (!Util.isNullOrNil(mMBaseSelectContactUI.gUT()) && mMBaseSelectContactUI.PWr != null) {
            mMBaseSelectContactUI.PWr.setText(f.a(mMBaseSelectContactUI.getString(R.string.gfv), mMBaseSelectContactUI.getString(R.string.gfu), e.c(mMBaseSelectContactUI.gUT(), mMBaseSelectContactUI.gUT())).wWu);
        }
    }

    static /* synthetic */ void g(MMBaseSelectContactUI mMBaseSelectContactUI) {
        Log.i("MicroMsg.MMBaseSelectContactUI", "setSearchStatus");
        mMBaseSelectContactUI.a(mMBaseSelectContactUI.Bvb, 8);
        mMBaseSelectContactUI.Bvb.setAdapter((ListAdapter) mMBaseSelectContactUI.PWl);
        mMBaseSelectContactUI.PWl.notifyDataSetChanged();
        if (mMBaseSelectContactUI.bmA() && mMBaseSelectContactUI.PWj != null) {
            mMBaseSelectContactUI.PWj.setVisibility(mMBaseSelectContactUI.PWl.gUN() ? 0 : 8);
        }
        mMBaseSelectContactUI.PWq.setVisibility(8);
    }
}
