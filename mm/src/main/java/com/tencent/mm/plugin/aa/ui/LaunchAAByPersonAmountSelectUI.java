package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.b.c;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LaunchAAByPersonAmountSelectUI extends BaseAAPresenterActivity {
    private String dFl;
    private MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private HashMap<String, Double> jTW;
    private Map<String, String> jWA = new HashMap();
    private a jWB = null;
    private double jWC;
    private long jWD = -1;
    private int jWE = -1;
    private boolean jWF;
    private boolean jWG = false;
    private Runnable jWH = new Runnable() {
        /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(63587);
            LaunchAAByPersonAmountSelectUI.a(LaunchAAByPersonAmountSelectUI.this);
            LaunchAAByPersonAmountSelectUI.b(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.o(63587);
        }
    };
    private com.tencent.mm.plugin.aa.model.b.c jWt = ((com.tencent.mm.plugin.aa.model.b.c) au(com.tencent.mm.plugin.aa.model.b.c.class));
    private ListView jWu;
    private TextView jWv;
    private TextView jWw;
    private View jWx;
    private TextView jWy;
    private boolean jWz = false;
    private int scene;

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LaunchAAByPersonAmountSelectUI() {
        AppMethodBeat.i(63606);
        AppMethodBeat.o(63606);
    }

    static /* synthetic */ void a(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.i(63611);
        launchAAByPersonAmountSelectUI.bmG();
        AppMethodBeat.o(63611);
    }

    static /* synthetic */ void b(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.i(63612);
        launchAAByPersonAmountSelectUI.bmH();
        AppMethodBeat.o(63612);
    }

    static /* synthetic */ void n(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.i(213020);
        launchAAByPersonAmountSelectUI.bmI();
        AppMethodBeat.o(213020);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(63607);
        super.onCreate(bundle);
        setMMTitle(R.string.ecj);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:20:0x0090  */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x00bf  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onMenuItemClick(android.view.MenuItem r11) {
                /*
                // Method dump skipped, instructions count: 205
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.AnonymousClass2.onMenuItemClick(android.view.MenuItem):boolean");
            }
        });
        addTextOptionMenu(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, getString(R.string.x_), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(63591);
                if (LaunchAAByPersonAmountSelectUI.this.jWE <= 0 || LaunchAAByPersonAmountSelectUI.this.jWA == null || LaunchAAByPersonAmountSelectUI.this.jWA.size() <= LaunchAAByPersonAmountSelectUI.this.jWE) {
                    LaunchAAByPersonAmountSelectUI.e(LaunchAAByPersonAmountSelectUI.this);
                    h.INSTANCE.a(13721, 3, 4);
                    AppMethodBeat.o(63591);
                } else {
                    com.tencent.mm.ui.base.h.c(LaunchAAByPersonAmountSelectUI.this.getContext(), LaunchAAByPersonAmountSelectUI.this.getString(R.string.ecq, new Object[]{Integer.valueOf(LaunchAAByPersonAmountSelectUI.this.jWE)}), "", true);
                    h.INSTANCE.a(13722, 8);
                    AppMethodBeat.o(63591);
                }
                return true;
            }
        }, null, t.b.GREEN);
        this.jWu = (ListView) findViewById(R.id.mc);
        this.jWv = (TextView) findViewById(R.id.b3f);
        this.jWw = (TextView) findViewById(R.id.md);
        this.jWw.setText(getString(R.string.eci, new Object[]{Float.valueOf(0.0f)}));
        this.jWx = findViewById(R.id.iej);
        this.jWy = (TextView) findViewById(R.id.lm);
        this.jWj = this.jWu;
        this.jWx.setVisibility(8);
        ao.a(this.jWv.getPaint(), 0.8f);
        this.jWv.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.AnonymousClass5 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(63593);
                if (!LaunchAAByPersonAmountSelectUI.this.jWz) {
                    AppMethodBeat.o(63593);
                    return true;
                }
                if (LaunchAAByPersonAmountSelectUI.this.jWz) {
                    LaunchAAByPersonAmountSelectUI.this.jWv.setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(R.color.x0));
                } else {
                    LaunchAAByPersonAmountSelectUI.n(LaunchAAByPersonAmountSelectUI.this);
                }
                AppMethodBeat.o(63593);
                return false;
            }
        });
        this.jWv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(63596);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (LaunchAAByPersonAmountSelectUI.this.jWA != null && LaunchAAByPersonAmountSelectUI.this.jWA.size() > 0) {
                    try {
                        d.a aVar = new d.a(LaunchAAByPersonAmountSelectUI.this);
                        aVar.aoS(R.string.l);
                        aVar.aoV(R.string.m).c(new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.AnonymousClass6.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(63594);
                                LaunchAAByPersonAmountSelectUI.o(LaunchAAByPersonAmountSelectUI.this);
                                AppMethodBeat.o(63594);
                            }
                        });
                        aVar.aoW(R.string.n).d(new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.AnonymousClass6.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(63595);
                                h.INSTANCE.a(13721, 3, 10);
                                AppMethodBeat.o(63595);
                            }
                        });
                        aVar.hbn().show();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
                    }
                }
                h.INSTANCE.a(13721, 3, 8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(63596);
            }
        });
        this.jWz = true;
        this.jWu.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.AnonymousClass7 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(63597);
                if (i2 == 1) {
                    LaunchAAByPersonAmountSelectUI.this.hideTenpayKB();
                }
                AppMethodBeat.o(63597);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        this.scene = getIntent().getIntExtra("enter_scene", 1);
        this.dFl = getIntent().getStringExtra("chatroom");
        this.jWD = getIntent().getLongExtra("maxPerAmount", -1);
        this.jWE = getIntent().getIntExtra("maxUserNumber", -1);
        Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, ", this.dFl, Long.valueOf(this.jWD));
        this.jWt.bk(c.a.class);
        this.jWt.a(c.a.class, new a.b<c.a>() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.app.a.b
            public final /* synthetic */ void co(c.a aVar) {
                Object obj;
                AppMethodBeat.i(63592);
                c.a aVar2 = aVar;
                Object[] objArr = new Object[2];
                objArr[0] = aVar2;
                if (aVar2 != null) {
                    obj = aVar2.gMT != null ? Integer.valueOf(aVar2.gMT.size()) : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } else {
                    obj = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                objArr[1] = obj;
                Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "get selectMembers: %s, list.size: %s", objArr);
                LaunchAAByPersonAmountSelectUI.this.jWu.addFooterView(aa.jQ(LaunchAAByPersonAmountSelectUI.this).inflate(R.layout.a9, (ViewGroup) null), null, false);
                View inflate = aa.jQ(LaunchAAByPersonAmountSelectUI.this).inflate(R.layout.ag, (ViewGroup) null);
                if (LaunchAAByPersonAmountSelectUI.a(aVar2)) {
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.au);
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.height = com.tencent.mm.cb.a.fromDPToPix((Context) LaunchAAByPersonAmountSelectUI.this.getContext(), 44);
                    linearLayout.setLayoutParams(layoutParams);
                    inflate.findViewById(R.id.av).setVisibility(0);
                }
                LaunchAAByPersonAmountSelectUI.this.jWu.addHeaderView(inflate, null, false);
                if (aVar2 != null) {
                    if (aVar2.jTW != null) {
                        for (String str : aVar2.jTW.keySet()) {
                            LaunchAAByPersonAmountSelectUI.this.jWA.put(str, LaunchAAByPersonAmountSelectUI.this.getString(R.string.f3153j, new Object[]{aVar2.jTW.get(str)}));
                        }
                        LaunchAAByPersonAmountSelectUI.this.jTW = aVar2.jTW;
                    }
                    if (aVar2.gMT != null && aVar2.gMT.size() > 0) {
                        LaunchAAByPersonAmountSelectUI.this.jWB = new a(aVar2.gMT, aVar2.jTW);
                        LaunchAAByPersonAmountSelectUI.this.jWu.setAdapter((ListAdapter) LaunchAAByPersonAmountSelectUI.this.jWB);
                    }
                }
                LaunchAAByPersonAmountSelectUI.this.jWx.setVisibility(0);
                LaunchAAByPersonAmountSelectUI.this.hAk.post(LaunchAAByPersonAmountSelectUI.this.jWH);
                AppMethodBeat.o(63592);
            }
        });
        AppMethodBeat.o(63607);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    private void bmG() {
        AppMethodBeat.i(63608);
        try {
            this.jWC = 0.0d;
            this.jWF = false;
            if (this.jWA != null) {
                for (String str : this.jWA.values()) {
                    double d2 = Util.getDouble(str, 0.0d);
                    this.jWC += d2;
                    if (this.jWD > 0 && d2 * 100.0d > ((double) this.jWD)) {
                        this.jWF = true;
                    }
                }
                if (this.jWB != null) {
                    a aVar = this.jWB;
                    Map<String, String> map = this.jWA;
                    for (b bVar : aVar.dataList) {
                        bVar.jWR = "";
                    }
                    if (map != null && map.size() > 0) {
                        for (b bVar2 : aVar.dataList) {
                            if (map.containsKey(bVar2.username)) {
                                bVar2.jWR = map.get(bVar2.username);
                            }
                        }
                    }
                }
            }
            this.jWw.setText(getString(R.string.eci, new Object[]{Double.valueOf(this.jWC)}));
            if (this.jWA == null || this.jWA.size() <= 0) {
                updateOptionMenuText(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, getString(R.string.x_));
            } else {
                updateOptionMenuText(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, getString(R.string.v, new Object[]{Integer.valueOf(this.jWA.size())}));
            }
            if (this.jWF) {
                h.INSTANCE.a(13722, 7);
                enableOptionMenu(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, false);
                String string = getString(R.string.ed9, new Object[]{Float.valueOf(((float) this.jWD) / 100.0f)});
                if (!Util.isNullOrNil(string)) {
                    this.jWy.setText(string);
                    if (!this.jWy.isShown()) {
                        this.jWy.startAnimation(AnimationUtils.loadAnimation(this, R.anim.cc));
                        this.jWy.setVisibility(0);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jWu.getLayoutParams();
                        layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 55);
                        this.jWu.setLayoutParams(layoutParams);
                    }
                }
            } else {
                if (this.jWA == null || this.jWA.size() <= 0) {
                    enableOptionMenu(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, false);
                } else {
                    enableOptionMenu(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, true);
                }
                if (this.jWy.isShown()) {
                    this.jWy.setText("");
                    this.jWy.startAnimation(AnimationUtils.loadAnimation(this, R.anim.d5));
                    this.jWy.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jWu.getLayoutParams();
                    layoutParams2.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 0);
                    this.jWu.setLayoutParams(layoutParams2);
                }
            }
            if (this.jWv.getRight() > this.jWw.getLeft()) {
                this.jWw.setMaxEms(this.jWw.length() / 2);
            }
            AppMethodBeat.o(63608);
        } catch (Exception e2) {
            Log.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", e2.getMessage());
            AppMethodBeat.o(63608);
        }
    }

    private void bmH() {
        AppMethodBeat.i(63609);
        if (this.jWC > 0.0d) {
            this.jWz = true;
            this.jWv.setTextColor(getResources().getColor(R.color.x0));
            AppMethodBeat.o(63609);
            return;
        }
        this.jWz = false;
        bmI();
        AppMethodBeat.o(63609);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ay8;
    }

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(63610);
        super.onDestroy();
        if (this.jWA != null) {
            this.jWA.clear();
        }
        AppMethodBeat.o(63610);
    }

    protected class c implements TextWatcher {
        String username;

        public c(String str) {
            this.username = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(63605);
            try {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                int lastIndexOf = obj.lastIndexOf(".");
                if (lastIndexOf != indexOf && lastIndexOf > 0 && length > lastIndexOf) {
                    editable.delete(lastIndexOf, length);
                }
            } catch (Exception e2) {
            }
            if (Util.isNullOrNil(editable) || Util.getDouble(editable.toString(), 0.0d) <= 0.0d) {
                LaunchAAByPersonAmountSelectUI.this.jWA.remove(this.username);
            } else {
                LaunchAAByPersonAmountSelectUI.this.jWA.put(this.username, editable.toString());
            }
            LaunchAAByPersonAmountSelectUI.this.hAk.removeCallbacks(LaunchAAByPersonAmountSelectUI.this.jWH);
            LaunchAAByPersonAmountSelectUI.this.hAk.postDelayed(LaunchAAByPersonAmountSelectUI.this.jWH, 50);
            if (LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)) {
                i.uZ(3);
            }
            AppMethodBeat.o(63605);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        List<b> dataList;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(63604);
            b vb = vb(i2);
            AppMethodBeat.o(63604);
            return vb;
        }

        public a(List<String> list, Map<String, Double> map) {
            AppMethodBeat.i(63600);
            this.dataList = null;
            this.dataList = new ArrayList();
            for (String str : list) {
                b bVar = new b(LaunchAAByPersonAmountSelectUI.this, (byte) 0);
                bVar.username = str;
                if (map == null || !map.containsKey(str)) {
                    bVar.jWR = "";
                } else {
                    bVar.jWR = LaunchAAByPersonAmountSelectUI.this.getString(R.string.f3153j, new Object[]{map.get(str)});
                }
                this.dataList.add(bVar);
            }
            AppMethodBeat.o(63600);
        }

        public final int getCount() {
            AppMethodBeat.i(63601);
            int size = this.dataList.size();
            AppMethodBeat.o(63601);
            return size;
        }

        private b vb(int i2) {
            AppMethodBeat.i(63602);
            b bVar = this.dataList.get(i2);
            AppMethodBeat.o(63602);
            return bVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(63603);
            b vb = vb(i2);
            if (vb != null && !Util.isNullOrNil(vb.username)) {
                if (view == null) {
                    view = aa.jQ(LaunchAAByPersonAmountSelectUI.this).inflate(R.layout.ay7, viewGroup, false);
                    final C0508a aVar = new C0508a(this, (byte) 0);
                    aVar.jWN = (LinearLayout) view.findViewById(R.id.h8v);
                    aVar.gyr = (ImageView) view.findViewById(R.id.wm);
                    aVar.hXv = (TextView) view.findViewById(R.id.j1t);
                    aVar.jWO = (TextView) view.findViewById(R.id.idf);
                    aVar.jWq = (WalletFormView) view.findViewById(R.id.fjd);
                    aVar.jWP = (TextView) view.findViewById(R.id.e84);
                    aVar.jWQ = new c(vb.username);
                    aVar.jWq.a(aVar.jWQ);
                    aVar.jWN.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.a.AnonymousClass1 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(63598);
                            aVar.jWq.d(LaunchAAByPersonAmountSelectUI.this);
                            AppMethodBeat.o(63598);
                            return false;
                        }
                    });
                    aVar.gyr.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.a.AnonymousClass2 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(63599);
                            aVar.jWq.d(LaunchAAByPersonAmountSelectUI.this);
                            AppMethodBeat.o(63599);
                            return false;
                        }
                    });
                    aVar.hXv.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.a.AnonymousClass3 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(213015);
                            aVar.jWq.d(LaunchAAByPersonAmountSelectUI.this);
                            AppMethodBeat.o(213015);
                            return false;
                        }
                    });
                    view.setTag(aVar);
                    LaunchAAByPersonAmountSelectUI.this.setEditFocusListener(aVar.jWq, 2, false, true);
                }
                final C0508a aVar2 = (C0508a) view.getTag();
                if (!Util.isNullOrNil(vb.username)) {
                    aVar2.jWQ.username = vb.username;
                    a.b.c(aVar2.gyr, vb.username);
                    aVar2.hXv.setText(l.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(vb.username, LaunchAAByPersonAmountSelectUI.this.dFl), aVar2.hXv.getTextSize()));
                }
                if (!(vb.jWR == null || aVar2.jWq.getText() == null || vb.jWR.equals(aVar2.jWq.getText().toLowerCase()))) {
                    WalletFormView walletFormView = aVar2.jWq;
                    c cVar = aVar2.jWQ;
                    if (walletFormView.Rwe != null) {
                        walletFormView.Rwe.removeTextChangedListener(cVar);
                    }
                    aVar2.jWq.setText(vb.jWR);
                    aVar2.jWq.a(aVar2.jWQ);
                }
                if (i2 == 0) {
                    aVar2.jWN.setBackgroundResource(R.drawable.a9o);
                } else if (i2 == this.dataList.size() - 1) {
                    aVar2.jWN.setBackgroundResource(R.drawable.a9p);
                } else {
                    aVar2.jWN.setBackgroundResource(R.drawable.a9n);
                }
                if (as.bjp(vb.username)) {
                    aVar2.gyr.setAlpha(0.3f);
                    aVar2.hXv.setAlpha(0.3f);
                    aVar2.jWP.setAlpha(0.3f);
                    aVar2.jWq.setAlpha(0.15f);
                    aVar2.gyr.setAlpha(0.3f);
                    aVar2.gyr.setOnTouchListener(null);
                    aVar2.hXv.setAlpha(0.3f);
                    aVar2.hXv.setOnTouchListener(null);
                    aVar2.jWP.setAlpha(0.3f);
                    aVar2.jWq.setAlpha(0.15f);
                    aVar2.jWq.findViewById(R.id.jf4).setFocusable(false);
                    aVar2.jWq.findViewById(R.id.jf4).setFocusableInTouchMode(false);
                    aVar2.jWq.findViewById(R.id.jf4).setClickable(false);
                    String O = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(vb.username));
                    aVar2.jWO.setVisibility(0);
                    aVar2.jWO.setText(O);
                    aVar2.jWO.setAlpha(0.3f);
                    Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s,subName:%s", l.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(vb.username, LaunchAAByPersonAmountSelectUI.this.dFl), aVar2.hXv.getTextSize()).toString(), vb.username, O);
                } else {
                    aVar2.gyr.setAlpha(1.0f);
                    aVar2.hXv.setAlpha(1.0f);
                    aVar2.jWP.setAlpha(1.0f);
                    aVar2.jWq.setAlpha(1.0f);
                    aVar2.gyr.setAlpha(1.0f);
                    aVar2.gyr.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.a.AnonymousClass4 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(213016);
                            aVar2.jWq.d(LaunchAAByPersonAmountSelectUI.this);
                            AppMethodBeat.o(213016);
                            return false;
                        }
                    });
                    aVar2.hXv.setAlpha(1.0f);
                    aVar2.hXv.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.a.AnonymousClass5 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(213017);
                            aVar2.jWq.d(LaunchAAByPersonAmountSelectUI.this);
                            AppMethodBeat.o(213017);
                            return false;
                        }
                    });
                    aVar2.jWP.setAlpha(1.0f);
                    aVar2.jWq.setAlpha(1.0f);
                    aVar2.jWq.findViewById(R.id.jf4).setFocusable(true);
                    aVar2.jWq.findViewById(R.id.jf4).setFocusableInTouchMode(true);
                    aVar2.jWq.findViewById(R.id.jf4).setClickable(true);
                    aVar2.jWO.setVisibility(4);
                    Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s", l.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(vb.username, LaunchAAByPersonAmountSelectUI.this.dFl), aVar2.hXv.getTextSize()).toString(), vb.username);
                }
            }
            AppMethodBeat.o(63603);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$a$a  reason: collision with other inner class name */
        class C0508a {
            ImageView gyr;
            TextView hXv;
            LinearLayout jWN;
            TextView jWO;
            TextView jWP;
            c jWQ;
            WalletFormView jWq;

            private C0508a() {
            }

            /* synthetic */ C0508a(a aVar, byte b2) {
                this();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        String jWR;
        String username;

        private b() {
            this.username = null;
            this.jWR = null;
        }

        /* synthetic */ b(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, byte b2) {
            this();
        }
    }

    private void bmI() {
        AppMethodBeat.i(213018);
        if (!ao.isDarkMode()) {
            this.jWv.setTextColor(Color.parseColor("#4c576B95"));
            AppMethodBeat.o(213018);
            return;
        }
        this.jWv.setTextColor(Color.parseColor("#4c7D90A9"));
        AppMethodBeat.o(213018);
    }

    static /* synthetic */ void e(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.i(63613);
        launchAAByPersonAmountSelectUI.bmG();
        launchAAByPersonAmountSelectUI.bmH();
        if (!launchAAByPersonAmountSelectUI.jWF) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : launchAAByPersonAmountSelectUI.jWA.keySet()) {
                arrayList.add(str + "," + launchAAByPersonAmountSelectUI.jWA.get(str));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selectUI", arrayList);
            launchAAByPersonAmountSelectUI.setResult(-1, intent);
            launchAAByPersonAmountSelectUI.finish();
        }
        AppMethodBeat.o(63613);
    }

    static /* synthetic */ boolean a(c.a aVar) {
        AppMethodBeat.i(213019);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!(aVar == null || aVar.gMT == null || aVar.gMT.size() <= 0)) {
            for (String str : aVar.gMT) {
                if (as.bjp(str)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
            if (arrayList.size() > 0) {
                aVar.gMT.clear();
                aVar.gMT.addAll(arrayList2);
                aVar.gMT.addAll(arrayList);
                AppMethodBeat.o(213019);
                return true;
            }
        }
        AppMethodBeat.o(213019);
        return false;
    }

    static /* synthetic */ void o(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.i(213021);
        try {
            launchAAByPersonAmountSelectUI.bmI();
            launchAAByPersonAmountSelectUI.jWz = false;
            launchAAByPersonAmountSelectUI.jWC = 0.0d;
            launchAAByPersonAmountSelectUI.jWw.setText(launchAAByPersonAmountSelectUI.getString(R.string.eci, new Object[]{Double.valueOf(launchAAByPersonAmountSelectUI.jWC)}));
            launchAAByPersonAmountSelectUI.jWA.clear();
            launchAAByPersonAmountSelectUI.bmG();
            launchAAByPersonAmountSelectUI.bmH();
            if (launchAAByPersonAmountSelectUI.jWB != null) {
                a aVar = launchAAByPersonAmountSelectUI.jWB;
                for (b bVar : aVar.dataList) {
                    bVar.jWR = "";
                }
                aVar.notifyDataSetChanged();
            }
        } catch (Exception e2) {
            Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "clearAmount error: %s", e2.getMessage());
        }
        h.INSTANCE.a(13721, 3, 9);
        AppMethodBeat.o(213021);
    }

    static /* synthetic */ boolean p(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        return launchAAByPersonAmountSelectUI.scene == 6;
    }
}
