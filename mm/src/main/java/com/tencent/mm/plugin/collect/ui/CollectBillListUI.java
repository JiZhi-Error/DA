package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.collect.model.h;
import com.tencent.mm.plugin.collect.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI extends WalletBaseUI {
    private int limit = 20;
    private View qdm;
    private int qwC = 0;
    private Dialog qzA;
    private boolean qzB = false;
    private boolean qzC = false;
    private boolean qzD = false;
    private boolean qzE = false;
    private boolean qzF = false;
    private boolean qzG = false;
    private boolean qzH = true;
    private boolean qzI = false;
    private boolean qzJ = false;
    private long qzK = 0;
    private long qzL = 0;
    private Calendar qzM;
    private List<h> qzN = new ArrayList();
    private ListView qzv;
    private b qzw;
    private LinearLayout qzx;
    private CollectPullDownView qzy;
    private TextView qzz;
    private int retryCount = 0;
    private Dialog tipDialog;
    private int type = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CollectBillListUI() {
        AppMethodBeat.i(64057);
        AppMethodBeat.o(64057);
    }

    static /* synthetic */ void j(CollectBillListUI collectBillListUI) {
        AppMethodBeat.i(64070);
        collectBillListUI.cAi();
        AppMethodBeat.o(64070);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64058);
        super.onCreate(bundle);
        initView();
        setMMTitle(R.string.b6b);
        if (this.qzJ) {
            addIconOptionMenu(0, R.raw.collect_bill_filter_icon, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(64048);
                    CollectBillListUI.a(CollectBillListUI.this);
                    AppMethodBeat.o(64048);
                    return false;
                }
            });
        }
        this.tipDialog = com.tencent.mm.wallet_core.ui.h.a((Context) this, false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        cAi();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13944, 4);
        AppMethodBeat.o(64058);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64059);
        this.qzv = (ListView) findViewById(R.id.b6c);
        this.qzx = (LinearLayout) findViewById(R.id.b6a);
        this.qzz = (TextView) findViewById(R.id.b6b);
        this.qdm = aa.jQ(this).inflate(R.layout.v1, (ViewGroup) this.qzv, false);
        View view = new View(this);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, a.fromDPToPix((Context) this, 5)));
        this.qzv.addHeaderView(view, null, true);
        new View(this).setLayoutParams(new AbsListView.LayoutParams(-1, a.fromDPToPix((Context) this, 10)));
        this.qzv.addFooterView(view, null, true);
        this.qzv.setOverScrollMode(2);
        this.qzw = new b(this);
        this.qzv.setAdapter((ListAdapter) this.qzw);
        this.qzv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass7 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(64053);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.d("MicroMsg.CollectBillListUI", "click item: %d", Integer.valueOf(i2));
                if (i2 < 0 || i2 >= adapterView.getAdapter().getCount()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(64053);
                    return;
                }
                Intent intent = new Intent(CollectBillListUI.this.getContext(), CollectBillUI.class);
                h hVar = (h) adapterView.getItemAtPosition(i2);
                if (hVar == null) {
                    Log.w("MicroMsg.CollectBillListUI", "invaild record: %d", Integer.valueOf(i2));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(64053);
                    return;
                }
                intent.putExtra("key_type", hVar.type);
                intent.putExtra("key_timestamp", hVar.qwd);
                intent.putExtra("key_from_scene", 2);
                CollectBillListUI collectBillListUI = CollectBillListUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(collectBillListUI, bl.axQ(), "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                collectBillListUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(collectBillListUI, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13944, 3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(64053);
            }
        });
        this.qzv.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass8 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        this.qzy = (CollectPullDownView) findViewById(R.id.b6e);
        this.qzy.setTopViewVisible(false);
        this.qzy.setIsTopShowAll(false);
        this.qzy.setBottomViewVisible(true);
        this.qzy.setIsBottomShowAll(false);
        this.qzy.setCanOverScrool(true);
        this.qzy.setAtTopCallBack(new MMPullDownView.d() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.d
            public final boolean cAk() {
                View childAt;
                AppMethodBeat.i(64054);
                int firstVisiblePosition = CollectBillListUI.this.qzv.getFirstVisiblePosition();
                if (firstVisiblePosition == 0 && (childAt = CollectBillListUI.this.qzv.getChildAt(firstVisiblePosition)) != null && childAt.getX() == 0.0f) {
                    AppMethodBeat.o(64054);
                    return true;
                }
                AppMethodBeat.o(64054);
                return false;
            }
        });
        this.qzy.setAtBottomCallBack(new MMPullDownView.c() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass10 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.c
            public final boolean cAl() {
                AppMethodBeat.i(64055);
                if (CollectBillListUI.this.qzx.getVisibility() == 0) {
                    Log.d("MicroMsg.CollectBillListUI", "empty view");
                    AppMethodBeat.o(64055);
                    return true;
                }
                View childAt = CollectBillListUI.this.qzv.getChildAt(CollectBillListUI.this.qzv.getChildCount() - 1);
                if (childAt == null || childAt.getBottom() > CollectBillListUI.this.qzv.getHeight() || CollectBillListUI.this.qzv.getLastVisiblePosition() != CollectBillListUI.this.qzv.getAdapter().getCount() - 1) {
                    AppMethodBeat.o(64055);
                    return false;
                }
                AppMethodBeat.o(64055);
                return true;
            }
        });
        this.qzy.setOnTopLoadDataListener(new MMPullDownView.g() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.g
            public final boolean cAm() {
                AppMethodBeat.i(64056);
                Log.d("MicroMsg.CollectBillListUI", "top load");
                AppMethodBeat.o(64056);
                return true;
            }
        });
        this.qzy.setOnBottomLoadDataListener(new MMPullDownView.e() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.e
            public final boolean cAj() {
                AppMethodBeat.i(64049);
                Log.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", Boolean.valueOf(CollectBillListUI.this.qzD), Boolean.valueOf(CollectBillListUI.this.qzG));
                if (CollectBillListUI.this.qzD || CollectBillListUI.this.qzG) {
                    AppMethodBeat.o(64049);
                    return true;
                }
                CollectBillListUI.i(CollectBillListUI.this);
                CollectBillListUI.j(CollectBillListUI.this);
                AppMethodBeat.o(64049);
                return false;
            }
        });
        AppMethodBeat.o(64059);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.uz;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64060);
        if (qVar instanceof r) {
            r rVar = (r) qVar;
            if (this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            this.qzy.setLoadDataEnd(true);
            if (i2 == 0 && i3 == 0) {
                if (rVar.qwC != 0) {
                    this.qzG = rVar.iGD;
                    if (rVar.isRetry) {
                        if (!rVar.qwH.isEmpty()) {
                            this.qzN.addAll(rVar.qwH);
                        }
                        if (rVar.qwE != 0 || rVar.qwF <= 0) {
                            this.retryCount = 0;
                            this.qzH = true;
                            this.qzL = rVar.qwd;
                            if (rVar.qwE == 0) {
                                this.qzG = false;
                            } else {
                                this.qzG = true;
                            }
                            if (this.qzN.size() > 0) {
                                this.qzw.setData(this.qzN);
                            } else {
                                Log.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
                                bIo();
                                if (!Util.isNullOrNil(rVar.qwG)) {
                                    this.qzz.setText(rVar.qwG);
                                    this.qzz.setVisibility(0);
                                }
                                b bVar = this.qzw;
                                bVar.qzs.clear();
                                bVar.notifyDataSetChanged();
                            }
                        } else {
                            Log.i("MicroMsg.CollectBillListUI", "continue retry: %d", Integer.valueOf(this.retryCount));
                            a(rVar.qwF, rVar.qwd, rVar.qwD, rVar.qwC);
                        }
                        AppMethodBeat.o(64060);
                        return true;
                    }
                    if (!rVar.qwH.isEmpty()) {
                        this.qzw.setData(rVar.qwH);
                        this.qzK = rVar.qwH.get(0).qwd;
                        this.qzL = rVar.qwH.get(rVar.qwH.size() - 1).qwd;
                    } else if (rVar.qwE != 0 || rVar.qwF <= 0) {
                        bIo();
                    } else {
                        Log.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", Integer.valueOf(rVar.qwF), Long.valueOf(rVar.qwd));
                        a(rVar.qwF, rVar.qwd, rVar.qwD, rVar.qwC);
                        this.qzN.clear();
                    }
                    this.qzF = false;
                    this.qzH = false;
                } else if (this.qzF) {
                    Log.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
                    AppMethodBeat.o(64060);
                    return true;
                } else if (rVar.qwD == 1) {
                    this.qzH = rVar.iGD;
                    if (!rVar.qwH.isEmpty()) {
                        b bVar2 = this.qzw;
                        bVar2.qzs.addAll(0, rVar.qwH);
                        bVar2.notifyDataSetChanged();
                        this.qzK = rVar.qwH.get(0).qwd;
                    } else {
                        this.qzH = true;
                    }
                    this.qzE = false;
                    this.qzC = false;
                } else {
                    this.qzG = rVar.iGD;
                    this.qzv.setVisibility(0);
                    this.qzx.setVisibility(8);
                    if (rVar.isRetry) {
                        if (!rVar.qwH.isEmpty()) {
                            this.qzN.addAll(rVar.qwH);
                        }
                        if (rVar.qwE != 0 || rVar.qwF <= 0 || !rVar.qwH.isEmpty()) {
                            this.retryCount = 0;
                            if (this.qzN.size() > 0) {
                                this.qzw.dd(this.qzN);
                            } else {
                                Log.i("MicroMsg.CollectBillListUI", "retry data is empty");
                                akP(rVar.qwG);
                            }
                            this.qzD = false;
                            this.qzL = rVar.qwd;
                            cAh();
                            kP(this.qzG);
                        } else {
                            Log.i("MicroMsg.CollectBillListUI", "continue retry: %d", Integer.valueOf(this.retryCount));
                            a(rVar.qwF, rVar.qwd, rVar.qwD, rVar.qwC);
                        }
                        AppMethodBeat.o(64060);
                        return true;
                    } else if (!rVar.qwH.isEmpty()) {
                        this.qzw.dd(rVar.qwH);
                        this.qzL = rVar.qwH.get(rVar.qwH.size() - 1).qwd;
                        if (this.qzL > rVar.qwd) {
                            Log.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                            this.qzL = rVar.qwd;
                        } else {
                            Log.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", Long.valueOf(this.qzL), Long.valueOf(rVar.qwd));
                        }
                        this.qzD = false;
                        cAh();
                        kP(this.qzG);
                    } else if (rVar.qwE != 0 || rVar.qwF <= 0) {
                        this.qzD = false;
                        cAh();
                        Log.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
                        akP(rVar.qwG);
                        kP(this.qzG);
                    } else {
                        Log.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", Integer.valueOf(rVar.qwF), Long.valueOf(rVar.qwd));
                        a(rVar.qwF, rVar.qwd, rVar.qwD, rVar.qwC);
                        this.qzN.clear();
                    }
                }
                AppMethodBeat.o(64060);
                return true;
            }
            Log.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(rVar.qwC), Integer.valueOf(rVar.qwD));
            if (rVar.qwC != 0) {
                this.qzF = false;
            } else if (rVar.qwD == 0) {
                this.qzD = false;
                cAh();
            } else {
                this.qzE = false;
            }
            if (this.qzw.isEmpty()) {
                bIo();
            }
            Toast.makeText(this, (int) R.string.b69, 1).show();
            AppMethodBeat.o(64060);
            return true;
        }
        AppMethodBeat.o(64060);
        return false;
    }

    private void cAh() {
        AppMethodBeat.i(64061);
        this.qzy.scrollTo(0, this.qzy.getTopHeight());
        AppMethodBeat.o(64061);
    }

    private void bIo() {
        AppMethodBeat.i(64062);
        this.qzv.setVisibility(8);
        this.qzx.setVisibility(0);
        this.qzz.setVisibility(0);
        AppMethodBeat.o(64062);
    }

    private void akP(String str) {
        AppMethodBeat.i(64063);
        if (this.qzw.getCount() == 0) {
            Log.i("MicroMsg.CollectBillListUI", "show empty view");
            if (!Util.isNullOrNil(str)) {
                this.qzz.setText(str);
            } else if (this.qzG) {
                this.qzz.setText(getString(R.string.b6_));
            } else {
                this.qzz.setText(getString(R.string.b6_) + getString(R.string.b6a));
            }
            bIo();
            AppMethodBeat.o(64063);
            return;
        }
        if (!Util.isNullOrNil(str)) {
            Toast.makeText(getContext(), str, 1).show();
        }
        AppMethodBeat.o(64063);
    }

    private void kP(boolean z) {
        AppMethodBeat.i(64064);
        this.qzy.setBottomViewVisible(!z);
        AppMethodBeat.o(64064);
    }

    private void cAi() {
        AppMethodBeat.i(64065);
        int count = this.qzw.getCount();
        if (count > 0) {
            long j2 = this.qzw.Fd(count - 1).qwd;
            if (j2 < this.qzL) {
                Log.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", Long.valueOf(j2), Long.valueOf(this.qzL));
                this.qzL = j2;
            }
        }
        Log.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", Integer.valueOf(this.type), Long.valueOf(this.qzL));
        doSceneProgress(new r(this.type, this.qzL, this.limit, 0), false);
        this.qzD = true;
        AppMethodBeat.o(64065);
    }

    private void a(int i2, long j2, int i3, int i4) {
        AppMethodBeat.i(64066);
        Log.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", Integer.valueOf(this.type), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        doSceneProgress(new r(this.type, j2, i3, this.limit, i4, i2), false);
        this.retryCount++;
        AppMethodBeat.o(64066);
    }

    static /* synthetic */ void a(CollectBillListUI collectBillListUI) {
        AppMethodBeat.i(64067);
        if (collectBillListUI.qzA == null) {
            collectBillListUI.qzA = new android.support.design.widget.a(collectBillListUI);
            final DatePickerDialogView datePickerDialogView = new DatePickerDialogView(collectBillListUI);
            datePickerDialogView.setDatePickerMode(collectBillListUI.type);
            collectBillListUI.qzA.setContentView(datePickerDialogView);
            datePickerDialogView.setOnOkBtnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass4 */

                public final void onClick(View view) {
                    long timeInMillis;
                    AppMethodBeat.i(64050);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectBillListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (CollectBillListUI.this.qzM == null) {
                        CollectBillListUI.this.qzM = Calendar.getInstance();
                    }
                    CollectBillListUI.this.qzM.clear();
                    int year = datePickerDialogView.getYear();
                    int month = datePickerDialogView.getMonth();
                    int dayOfMonth = datePickerDialogView.getDayOfMonth();
                    CollectBillListUI.this.type = datePickerDialogView.getDatePickerMode();
                    if (CollectBillListUI.this.type == 2) {
                        CollectBillListUI.this.qzM.set(1, year);
                        timeInMillis = CollectBillListUI.this.qzM.getTimeInMillis() / 1000;
                    } else if (CollectBillListUI.this.type == 1) {
                        CollectBillListUI.this.qzM.set(1, year);
                        CollectBillListUI.this.qzM.set(2, month);
                        timeInMillis = CollectBillListUI.this.qzM.getTimeInMillis() / 1000;
                    } else {
                        CollectBillListUI.this.qzM.set(year, month, dayOfMonth);
                        timeInMillis = CollectBillListUI.this.qzM.getTimeInMillis() / 1000;
                    }
                    Log.i("MicroMsg.CollectBillListUI", "year: %d, month: %d, day: %d, type: %d, timestamp: %s", Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth), Integer.valueOf(CollectBillListUI.this.type), Long.valueOf(timeInMillis));
                    CollectBillListUI.a(CollectBillListUI.this, timeInMillis);
                    CollectBillListUI.this.qzA.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64050);
                }
            });
            datePickerDialogView.setOnCancelBtnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(64051);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectBillListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    CollectBillListUI.this.qzA.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64051);
                }
            });
            if (Build.VERSION.SDK_INT >= 21) {
                collectBillListUI.qzA.getWindow().addFlags(Integer.MIN_VALUE);
            }
            final BottomSheetBehavior l = BottomSheetBehavior.l((View) datePickerDialogView.getParent());
            l.ob = false;
            l.setState(3);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.collect.ui.CollectBillListUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(64052);
                    Log.d("MicroMsg.CollectBillListUI", "view height: %d", Integer.valueOf(datePickerDialogView.getHeight()));
                    l.J(datePickerDialogView.getHeight());
                    AppMethodBeat.o(64052);
                }
            }, 300);
        }
        collectBillListUI.qzA.show();
        AppMethodBeat.o(64067);
    }

    static /* synthetic */ void a(CollectBillListUI collectBillListUI, long j2) {
        AppMethodBeat.i(64068);
        Log.i("MicroMsg.CollectBillListUI", "get filter page, type: %d, timestamp: %s", Integer.valueOf(collectBillListUI.type), Long.valueOf(j2));
        collectBillListUI.qzC = false;
        collectBillListUI.cAh();
        collectBillListUI.cleanScenes();
        collectBillListUI.qzD = false;
        collectBillListUI.qzE = false;
        collectBillListUI.doSceneForceProgress(new r(collectBillListUI.type, j2, collectBillListUI.limit, 1));
        collectBillListUI.qzF = true;
        AppMethodBeat.o(64068);
    }

    static /* synthetic */ void i(CollectBillListUI collectBillListUI) {
        AppMethodBeat.i(64069);
        collectBillListUI.qzy.setBottomViewVisible(true);
        AppMethodBeat.o(64069);
    }
}
