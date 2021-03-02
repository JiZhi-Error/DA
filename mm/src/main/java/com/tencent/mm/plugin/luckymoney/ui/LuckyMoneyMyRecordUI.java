package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI extends LuckyMoneyBaseUI {
    private int fs = 0;
    private View kgo;
    private int mType;
    private boolean mwr = false;
    private ImageView qyu;
    private TextView qzz;
    private List<y> yQe = new LinkedList();
    private TextView yQk;
    public String yXA = "";
    private MMLoadMoreListView zcN;
    private f zcO;
    private boolean zci = true;
    private Map<String, Integer> zcn = new HashMap();
    public String zcp = "";
    private TextView zeG;
    private TextView zeH;
    private TextView zeI;
    private TextView zeJ;
    private TextView zeK;
    private TextView zeL;
    private TextView zeM;
    private String zeN;
    private int zeO = -1;
    public List<String> zeP = new ArrayList();

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyMyRecordUI() {
        AppMethodBeat.i(65648);
        AppMethodBeat.o(65648);
    }

    static /* synthetic */ void c(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.i(65656);
        luckyMoneyMyRecordUI.egm();
        AppMethodBeat.o(65656);
    }

    static /* synthetic */ void d(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.i(65657);
        luckyMoneyMyRecordUI.egc();
        AppMethodBeat.o(65657);
    }

    static /* synthetic */ int e(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.i(65658);
        int egn = luckyMoneyMyRecordUI.egn();
        AppMethodBeat.o(65658);
        return egn;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65649);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.z1));
        setActionbarElementColor(getResources().getColor(R.color.yl));
        this.mType = getIntent().getIntExtra("key_type", 2);
        initView();
        egc();
        h.INSTANCE.a(11701, Integer.valueOf(egn()), 0, 0, 0, 1);
        AppMethodBeat.o(65649);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65650);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65633);
                LuckyMoneyMyRecordUI.this.finish();
                AppMethodBeat.o(65633);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65636);
                e eVar = new e((Context) LuckyMoneyMyRecordUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(65634);
                        mVar.kV(1, R.string.eqb);
                        mVar.kV(2, R.string.eqd);
                        AppMethodBeat.o(65634);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(65635);
                        switch (menuItem.getItemId()) {
                            case 1:
                                if (LuckyMoneyMyRecordUI.this.mType != 2) {
                                    LuckyMoneyMyRecordUI.this.mType = 2;
                                    LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this);
                                    LuckyMoneyMyRecordUI.c(LuckyMoneyMyRecordUI.this);
                                    LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
                                    AppMethodBeat.o(65635);
                                    return;
                                }
                                break;
                            case 2:
                                if (LuckyMoneyMyRecordUI.this.mType != 1) {
                                    LuckyMoneyMyRecordUI.this.mType = 1;
                                    LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this);
                                    LuckyMoneyMyRecordUI.c(LuckyMoneyMyRecordUI.this);
                                    LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.o(65635);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(65636);
                return false;
            }
        });
        this.qzz = (TextView) findViewById(R.id.f25);
        this.zcN = (MMLoadMoreListView) findViewById(R.id.f27);
        this.kgo = LayoutInflater.from(this).inflate(R.layout.b40, (ViewGroup) null);
        this.zcN.addHeaderView(this.kgo);
        this.qyu = (ImageView) this.kgo.findViewById(R.id.f1s);
        this.zeH = (TextView) this.kgo.findViewById(R.id.f1v);
        this.yQk = (TextView) this.kgo.findViewById(R.id.f1r);
        this.zeI = (TextView) this.kgo.findViewById(R.id.f1w);
        this.zeJ = (TextView) this.kgo.findViewById(R.id.f1x);
        this.zeK = (TextView) this.kgo.findViewById(R.id.f1t);
        this.zeL = (TextView) this.kgo.findViewById(R.id.f1u);
        this.zeM = (TextView) this.kgo.findViewById(R.id.f20);
        this.zeG = (TextView) this.kgo.findViewById(R.id.f1z);
        this.zcN.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                y PT;
                AppMethodBeat.i(65637);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                int i3 = (int) j2;
                h.INSTANCE.a(11701, Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), 0, 0, 0, 2);
                if (i3 >= 0 && i3 < LuckyMoneyMyRecordUI.this.zcO.getCount() && (PT = LuckyMoneyMyRecordUI.this.zcO.getItem(i3)) != null && !Util.isNullOrNil(PT.yQE)) {
                    Intent intent = new Intent();
                    if (PT.yVv == 2) {
                        Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
                        intent.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                    } else if (PT.yVv == 5) {
                        Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go union detail");
                        intent.putExtra("key_hb_kind", PT.yVv);
                        intent.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
                    } else if (PT.yVv == 6) {
                        intent.putExtra("key_hb_kind", PT.yVv);
                        intent.putExtra("key_hk_scene", 2);
                        intent.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyHKBeforeDetailUI.class);
                    } else if (PT.yVv == 7) {
                        intent.putExtra("key_hb_kind", PT.yVv);
                        intent.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
                    } else {
                        Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
                        intent.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
                    }
                    intent.putExtra("key_sendid", PT.yQE);
                    intent.putExtra("key_jump_from", LuckyMoneyMyRecordUI.this.mType == 1 ? 3 : 1);
                    LuckyMoneyMyRecordUI luckyMoneyMyRecordUI = LuckyMoneyMyRecordUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyMyRecordUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    luckyMoneyMyRecordUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyMyRecordUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(65637);
            }
        });
        this.zcN.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(65639);
                if (i2 <= 0 || i2 > LuckyMoneyMyRecordUI.this.zcO.getCount()) {
                    AppMethodBeat.o(65639);
                } else {
                    final int i3 = i2 - 1;
                    com.tencent.mm.ui.base.h.a(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.getResources().getString(R.string.eq0), (String[]) null, LuckyMoneyMyRecordUI.this.getResources().getString(R.string.tf), new h.d() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass4.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.h.d
                        public final void oj(int i2) {
                            AppMethodBeat.i(65638);
                            switch (i2) {
                                case 0:
                                    y PT = LuckyMoneyMyRecordUI.this.zcO.getItem(i3);
                                    if (PT != null) {
                                        LuckyMoneyMyRecordUI.this.zeO = i3;
                                        LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, PT, i3);
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(65638);
                        }
                    });
                    AppMethodBeat.o(65639);
                }
                return true;
            }
        });
        this.zcN.setOnLoadMoreListener(new MMLoadMoreListView.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.MMLoadMoreListView.a
            public final void onLoadMore() {
                AppMethodBeat.i(65640);
                if (!LuckyMoneyMyRecordUI.this.zbX.isProcessing()) {
                    LuckyMoneyMyRecordUI.this.mwr = false;
                }
                if (LuckyMoneyMyRecordUI.this.zci && !LuckyMoneyMyRecordUI.this.mwr) {
                    LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
                }
                AppMethodBeat.o(65640);
            }
        });
        this.qyu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(65641);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!Util.isNullOrNil(LuckyMoneyMyRecordUI.this.yXA)) {
                    f.p(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.yXA, true);
                } else {
                    Log.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65641);
            }
        });
        egm();
        AppMethodBeat.o(65650);
    }

    private void egm() {
        AppMethodBeat.i(65651);
        this.zeG.setVisibility(8);
        this.kgo.findViewById(R.id.f1y).setVisibility(8);
        if (this.mType == 1) {
            setMMTitle(getString(R.string.eqd));
            af.a(getContext(), this.zeH, getString(R.string.erw, new Object[]{z.aUa()}));
            this.zeJ.setText(R.string.es2);
            this.zcO = new g(getContext());
            this.zeG.setVisibility(0);
        } else {
            setMMTitle(getString(R.string.eqb));
            af.a(getContext(), this.zeH, getString(R.string.erj, new Object[]{z.aUa()}));
            this.zeJ.setText(R.string.erk);
            this.zcO = new e(getContext());
            this.kgo.findViewById(R.id.f1y).setVisibility(0);
        }
        this.zcN.setAdapter((ListAdapter) this.zcO);
        a.b.a(this.qyu, z.aTY(), 0.0f, false);
        this.zeM.setText(getString(R.string.erl, new Object[]{Util.nullAsNil(this.zeN)}));
        AppMethodBeat.o(65651);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(65652);
        if (qVar instanceof at) {
            if (i2 == 0 && i3 == 0) {
                at atVar = (at) qVar;
                LinkedList<y> linkedList = atVar.yXx.yVw;
                this.zcp = atVar.yXg;
                this.yXA = atVar.yXA;
                if (this.fs == 0) {
                    this.zeP = atVar.yXy;
                    this.zeN = atVar.yXz;
                    View findViewById = findViewById(R.id.f22);
                    ImageView imageView = (ImageView) findViewById(R.id.f21);
                    if (this.zeP.size() > 1) {
                        imageView.setVisibility(0);
                        findViewById.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass7 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(65642);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                LuckyMoneyMyRecordUI.this.showDialog(1);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65642);
                            }
                        });
                    }
                    this.zeM.setText(getString(R.string.erl, new Object[]{this.zeN}));
                }
                x xVar = atVar.yXx;
                if (xVar != null) {
                    if (this.mType == 1) {
                        this.yQk.setText(f.formatMoney2f(((double) xVar.yWl) / 100.0d));
                        String sb = new StringBuilder().append(xVar.yWk).toString();
                        String string = getString(R.string.es1, new Object[]{sb});
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.yj));
                        int indexOf = string.indexOf(sb);
                        SpannableString spannableString = new SpannableString(string);
                        spannableString.setSpan(foregroundColorSpan, indexOf, sb.length() + indexOf, 33);
                        this.zeG.setText(spannableString);
                    } else {
                        this.yQk.setText(f.formatMoney2f(((double) xVar.yWj) / 100.0d));
                        this.zeI.setText(new StringBuilder().append(xVar.yWi).toString());
                        this.zeK.setText(new StringBuilder().append(xVar.yWm).toString());
                    }
                }
                if (linkedList != null) {
                    for (int i4 = 0; i4 < linkedList.size(); i4++) {
                        y yVar = linkedList.get(i4);
                        if (!this.zcn.containsKey(yVar.yQE)) {
                            this.yQe.add(linkedList.get(i4));
                            this.zcn.put(yVar.yQE, 1);
                        }
                    }
                    this.fs += linkedList.size();
                    this.zci = atVar.efl();
                    this.mwr = false;
                    this.zcO.fq(this.yQe);
                }
                if (this.yQe == null || this.yQe.size() == 0) {
                    this.qzz.setVisibility(0);
                } else {
                    this.qzz.setVisibility(8);
                }
                if (this.zci) {
                    this.zcN.gKM();
                } else {
                    this.zcN.gKN();
                }
                AppMethodBeat.o(65652);
                return true;
            }
            this.yXA = null;
        } else if (qVar instanceof au) {
            int i5 = this.zeO;
            this.zeO = -1;
            if (i2 == 0 && i3 == 0) {
                y PT = this.zcO.getItem(i5);
                if (PT != null) {
                    Toast.makeText(this, (int) R.string.eq1, 0).show();
                    this.zcO.a(PT);
                    this.zcO.notifyDataSetChanged();
                } else {
                    Log.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
                }
                AppMethodBeat.o(65652);
                return true;
            }
        }
        AppMethodBeat.o(65652);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b42;
    }

    private void egc() {
        AppMethodBeat.i(65653);
        this.mwr = true;
        if (this.fs == 0) {
            this.zcp = "";
        }
        doSceneProgress(new at(11, this.fs, this.mType, this.zeN, "v1.0", this.zcp));
        AppMethodBeat.o(65653);
    }

    class a extends BaseAdapter {
        int bxP;
        List<String> zeP;

        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(65644);
            int size = this.zeP.size();
            AppMethodBeat.o(65644);
            return size;
        }

        public final String getItem(int i2) {
            AppMethodBeat.i(65645);
            String str = this.zeP.get(i2);
            AppMethodBeat.o(65645);
            return str;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(65646);
            CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(LuckyMoneyMyRecordUI.this.getContext()).inflate(R.layout.c9i, viewGroup, false);
            checkedTextView.setText(getItem(i2));
            if (i2 == this.bxP) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            AppMethodBeat.o(65646);
            return checkedTextView;
        }
    }

    private int egn() {
        if (this.mType == 1) {
            return 8;
        }
        return 9;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ Dialog onCreateDialog(int i2) {
        AppMethodBeat.i(65654);
        switch (i2) {
            case 1:
                View inflate = LayoutInflater.from(this).inflate(R.layout.b4h, (ViewGroup) null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(R.id.f5a);
                final a aVar = new a();
                List<String> list = this.zeP;
                if (list == null) {
                    aVar.zeP = new ArrayList();
                } else {
                    aVar.zeP = list;
                }
                aVar.notifyDataSetChanged();
                aVar.bxP = 0;
                listViewInScrollView.setAdapter((ListAdapter) aVar);
                listViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.AnonymousClass8 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(65643);
                        b bVar = new b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        LuckyMoneyMyRecordUI.this.dismissDialog(1);
                        String item = aVar.getItem(i2);
                        aVar.bxP = i2;
                        if (!item.equals(LuckyMoneyMyRecordUI.this.zeN)) {
                            LuckyMoneyMyRecordUI.this.zeN = item;
                            LuckyMoneyMyRecordUI.this.zeM.setText(LuckyMoneyMyRecordUI.this.getString(R.string.erl, new Object[]{LuckyMoneyMyRecordUI.this.zeN}));
                            LuckyMoneyMyRecordUI.this.fs = 0;
                            LuckyMoneyMyRecordUI.this.yQe.clear();
                            LuckyMoneyMyRecordUI.this.zcn.clear();
                            LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), 0, 0, 0, 3, item);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(65643);
                    }
                });
                d.a aVar2 = new d.a(this);
                aVar2.aoO(R.string.erv);
                aVar2.hs(inflate);
                aVar2.f(null);
                d hbn = aVar2.hbn();
                AppMethodBeat.o(65654);
                return hbn;
            default:
                AppMethodBeat.o(65654);
                return null;
        }
    }

    static /* synthetic */ void b(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.i(65655);
        if (luckyMoneyMyRecordUI.yQe != null) {
            luckyMoneyMyRecordUI.yQe.clear();
        }
        if (luckyMoneyMyRecordUI.zcn != null) {
            luckyMoneyMyRecordUI.zcn.clear();
        }
        luckyMoneyMyRecordUI.fs = 0;
        AppMethodBeat.o(65655);
    }

    static /* synthetic */ void a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI, y yVar, int i2) {
        AppMethodBeat.i(65659);
        if (yVar == null || i2 < 0 || i2 > luckyMoneyMyRecordUI.zcO.getCount()) {
            Log.e("MicroMsg.LuckyMoneyMyRecordUI", "param is illegal");
            AppMethodBeat.o(65659);
            return;
        }
        luckyMoneyMyRecordUI.doSceneProgress(new au(yVar.yQE, yVar.yVk, luckyMoneyMyRecordUI.mType, i2, "v1.0"));
        AppMethodBeat.o(65659);
    }
}
