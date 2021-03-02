package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.b.b;
import com.tencent.mm.plugin.aa.ui.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

public class AAQueryListUI extends BaseAAPresenterActivity {
    private b jUS = ((b) aq(b.class));
    private ListView jUT;
    private b jUU;
    private Dialog jUV;
    private boolean jUW = false;
    private boolean jUX = false;
    private View jUY;
    private AAQueryListH5UrlFooterView jUZ;
    private String jVa;
    private int mode = 1;

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AAQueryListUI() {
        AppMethodBeat.i(63518);
        AppMethodBeat.o(63518);
    }

    static /* synthetic */ void a(AAQueryListUI aAQueryListUI, boolean z, int i2) {
        AppMethodBeat.i(63522);
        aAQueryListUI.m(z, i2);
        AppMethodBeat.o(63522);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(63519);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AAQueryListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(63509);
                AAQueryListUI.this.finish();
                AppMethodBeat.o(63509);
                return false;
            }
        });
        setMMTitle(R.string.ar);
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AAQueryListUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(63514);
                e eVar = new e((Context) AAQueryListUI.this, 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.aa.ui.AAQueryListUI.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(63512);
                        mVar.add(0, 1, 1, R.string.as);
                        mVar.add(1, 2, 1, R.string.at);
                        AppMethodBeat.o(63512);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.aa.ui.AAQueryListUI.AnonymousClass4.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(63513);
                        switch (menuItem.getItemId()) {
                            case 1:
                                Log.i("MicroMsg.AAQueryListUI", "go to launch list: %d", Integer.valueOf(AAQueryListUI.this.mode));
                                if (AAQueryListUI.this.mode == 1) {
                                    AppMethodBeat.o(63513);
                                    return;
                                }
                                AAQueryListUI.this.mode = 1;
                                AAQueryListUI.this.setMMTitle(R.string.ar);
                                AAQueryListUI.this.jUU.mode = AAQueryListUI.this.mode;
                                AAQueryListUI.this.jUU.bmv();
                                AAQueryListUI.this.jUU.notifyDataSetChanged();
                                AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.this.mode);
                                AppMethodBeat.o(63513);
                                return;
                            case 2:
                                Log.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", Integer.valueOf(AAQueryListUI.this.mode));
                                if (AAQueryListUI.this.mode != 2) {
                                    AAQueryListUI.this.setMMTitle(R.string.au);
                                    AAQueryListUI.this.jUU.mode = AAQueryListUI.this.mode;
                                    AAQueryListUI.this.jUU.bmv();
                                    AAQueryListUI.this.jUU.notifyDataSetChanged();
                                    AAQueryListUI.this.mode = 2;
                                    AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.this.mode);
                                    break;
                                } else {
                                    AppMethodBeat.o(63513);
                                    return;
                                }
                        }
                        AppMethodBeat.o(63513);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(63514);
                return true;
            }
        });
        this.jUT = (ListView) findViewById(R.id.aj);
        this.jUT.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.aa.ui.AAQueryListUI.AnonymousClass2 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(63510);
                if (AAQueryListUI.this.jUT.getLastVisiblePosition() == AAQueryListUI.this.jUT.getCount() - 1 && AAQueryListUI.this.jUT.getCount() > 0 && !AAQueryListUI.this.jUX && !AAQueryListUI.this.jUW) {
                    AAQueryListUI.this.jUT.addFooterView(AAQueryListUI.this.jUY);
                    AAQueryListUI.a(AAQueryListUI.this, false, AAQueryListUI.this.mode);
                }
                AppMethodBeat.o(63510);
            }
        });
        this.jUT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AAQueryListUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(63511);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (AAQueryListUI.this.jUU != null) {
                    if (i2 < 0 || i2 >= AAQueryListUI.this.jUU.getCount()) {
                        Log.i("MicroMsg.AAQueryListUI", "click out of bound! %s", Integer.valueOf(i2));
                        a.a(this, "com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(63511);
                        return;
                    }
                    int top = view.getTop();
                    com.tencent.mm.protocal.protobuf.m mVar = (com.tencent.mm.protocal.protobuf.m) AAQueryListUI.this.jUU.getItem(i2);
                    if (mVar != null) {
                        if (!Util.isNullOrNil(mVar.KBH)) {
                            f.p(AAQueryListUI.this.getContext(), mVar.KBH, true);
                        } else if (!Util.isNullOrNil(mVar.KBs)) {
                            String str = null;
                            if (mVar.role == 2) {
                                str = z.aTY();
                            }
                            Intent intent = new Intent(AAQueryListUI.this, PaylistAAUI.class);
                            intent.putExtra("bill_no", mVar.KBs);
                            intent.putExtra("launcher_user_name", str);
                            intent.putExtra("enter_scene", 4);
                            intent.putExtra("chatroom", mVar.KBt);
                            intent.putExtra("item_position", i2);
                            intent.putExtra("item_offset", top);
                            AAQueryListUI.this.startActivityForResult(intent, 1);
                        }
                    }
                }
                h.INSTANCE.a(13721, 5, 3);
                a.a(this, "com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(63511);
            }
        });
        this.jUY = new AAQueryListLoadingMoreView(this);
        this.jUZ = new AAQueryListH5UrlFooterView(this);
        this.jUV = com.tencent.mm.wallet_core.ui.h.a((Context) this, false, (DialogInterface.OnCancelListener) null);
        this.jUU = new b(this, this.mode);
        this.jUT.setAdapter((ListAdapter) this.jUU);
        this.jUT.setVisibility(4);
        m(false, this.mode);
        AppMethodBeat.o(63519);
    }

    private void m(final boolean z, int i2) {
        AppMethodBeat.i(63520);
        if (this.jUW) {
            Log.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
            AppMethodBeat.o(63520);
            return;
        }
        if (z) {
            this.jUX = false;
            this.jUT.removeFooterView(this.jUZ);
        }
        this.jUW = true;
        this.jUS.jTT.l(z, i2).f(new com.tencent.mm.vending.c.a<Object, d<List, String, Boolean>>() {
            /* class com.tencent.mm.plugin.aa.ui.AAQueryListUI.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(d<List, String, Boolean> dVar) {
                AppMethodBeat.i(63516);
                d<List, String, Boolean> dVar2 = dVar;
                List list = (List) dVar2.get(0);
                Log.i("MicroMsg.AAQueryListUI", "record list size: %s, h5Url: %s, lastFlag: %s", Integer.valueOf(list.size()), dVar2.get(1), dVar2.get(2));
                if (!Util.isNullOrNil((String) dVar2.get(1))) {
                    AAQueryListUI.this.jVa = (String) dVar2.get(1);
                }
                if (z) {
                    AAQueryListUI.this.jUU.bmv();
                }
                b bVar = AAQueryListUI.this.jUU;
                Log.i("MicroMsg.AAQueryListAdapter", "addNewRecord: %s", list);
                if (list != null && list.size() > 0) {
                    Log.i("MicroMsg.AAQueryListAdapter", "addNewRecord size: %s", Integer.valueOf(list.size()));
                    bVar.dataList.addAll(list);
                    bVar.notifyDataSetChanged();
                }
                if (AAQueryListUI.this.jUV != null) {
                    AAQueryListUI.this.jUV.dismiss();
                    AAQueryListUI.this.jUV = null;
                }
                if (AAQueryListUI.this.jUT.getVisibility() != 0) {
                    AAQueryListUI.this.jUT.setVisibility(0);
                }
                AAQueryListUI.this.jUW = false;
                if (!((Boolean) dVar2.get(2)).booleanValue()) {
                    AAQueryListUI.this.jUX = true;
                }
                if (AAQueryListUI.this.jUT.getFooterViewsCount() > 0) {
                    AAQueryListUI.this.jUT.removeFooterView(AAQueryListUI.this.jUY);
                }
                if (AAQueryListUI.this.jUX) {
                    AAQueryListUI.k(AAQueryListUI.this);
                    if (AAQueryListUI.this.jUZ.getVisibility() == 0) {
                        AAQueryListUI.this.jUT.addFooterView(AAQueryListUI.this.jUZ, null, false);
                    }
                }
                Void r0 = QZL;
                AppMethodBeat.o(63516);
                return r0;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.aa.ui.AAQueryListUI.AnonymousClass5 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(63515);
                Log.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", obj);
                if (AAQueryListUI.this.jUV != null) {
                    AAQueryListUI.this.jUV.dismiss();
                    AAQueryListUI.this.jUV = null;
                }
                AAQueryListUI.this.jUW = false;
                if (AAQueryListUI.this.jUT.getFooterViewsCount() > 0) {
                    AAQueryListUI.this.jUT.removeFooterView(AAQueryListUI.this.jUY);
                }
                if (obj instanceof String) {
                    Toast.makeText(AAQueryListUI.this, obj.toString(), 1).show();
                    AppMethodBeat.o(63515);
                    return;
                }
                Toast.makeText(AAQueryListUI.this, (int) R.string.dv5, 1).show();
                AppMethodBeat.o(63515);
            }
        });
        AppMethodBeat.o(63520);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ab;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(63521);
        if (i2 == 1 && i3 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("close_aa", false);
            int intExtra = intent.getIntExtra("item_position", 0);
            int intExtra2 = intent.getIntExtra("item_offset", 0);
            if (booleanExtra) {
                this.jUT.setSelectionFromTop(intExtra, intExtra2);
                m(true, this.mode);
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(63521);
    }

    static /* synthetic */ void k(AAQueryListUI aAQueryListUI) {
        AppMethodBeat.i(63523);
        if (Util.isNullOrNil(aAQueryListUI.jVa)) {
            Log.i("MicroMsg.AAQueryListUI", "empty h5 url!");
            aAQueryListUI.jUZ.setVisibility(8);
            AppMethodBeat.o(63523);
            return;
        }
        TextView bottomLinkTv = aAQueryListUI.jUZ.getBottomLinkTv();
        bottomLinkTv.setClickable(true);
        bottomLinkTv.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(aAQueryListUI));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aAQueryListUI.getString(R.string.a4));
        spannableStringBuilder.setSpan(new a(new a.AbstractC0509a() {
            /* class com.tencent.mm.plugin.aa.ui.AAQueryListUI.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.aa.ui.a.AbstractC0509a
            public final void bmr() {
                AppMethodBeat.i(63517);
                f.p(AAQueryListUI.this.getContext(), AAQueryListUI.this.jVa, true);
                AppMethodBeat.o(63517);
            }
        }), 0, spannableStringBuilder.length(), 18);
        bottomLinkTv.setText(spannableStringBuilder);
        AppMethodBeat.o(63523);
    }
}
