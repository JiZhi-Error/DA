package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.lc;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.ejw;
import com.tencent.mm.protocal.protobuf.ejy;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MobileRemitHistoryRecodUI extends MobileRemitBaseUI {
    private b CmA;
    private c CmB;
    private int CmC = 0;
    private Runnable CmD = new Runnable() {
        /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.AnonymousClass5 */

        public final void run() {
            AppMethodBeat.i(67689);
            if (MobileRemitHistoryRecodUI.this.Cmu.getScrollState() == 0 && !MobileRemitHistoryRecodUI.this.CmA.dgZ && MobileRemitHistoryRecodUI.this.gxa.ku() + 1 == MobileRemitHistoryRecodUI.this.CmA.getItemCount()) {
                Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "first screen refresh data!");
                MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
            }
            AppMethodBeat.o(67689);
        }
    };
    private RecyclerView Cmu;
    private TextView Cmv;
    private String Cmw = null;
    private String Cmx = null;
    private boolean Cmy = false;
    private List<cbp> Cmz = new ArrayList();
    private LinearLayoutManager gxa;
    private int[] tef = new int[2];

    /* access modifiers changed from: package-private */
    public interface d {
        void onClick(View view);

        boolean onLongClick(View view);
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MobileRemitHistoryRecodUI() {
        AppMethodBeat.i(67706);
        AppMethodBeat.o(67706);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bb3;
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67707);
        super.onCreate(bundle);
        this.Cmw = getIntent().getStringExtra("key_homepage_ext");
        this.Cmy = getIntent().getBooleanExtra("key_finish", true);
        this.Cmx = getIntent().getStringExtra("key_last_id");
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_history_record");
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            this.Cmz.addAll(NetSceneMobileRemitGetRecord.gp(parcelableArrayListExtra));
        }
        Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "initData() mFinish:%s mLastId:%s mHisRecord.size:%s", Boolean.valueOf(this.Cmy), this.Cmx, Integer.valueOf(this.Cmz.size()));
        initView();
        addSceneEndListener(2993);
        addSceneEndListener(1495);
        addSceneEndListener(1275);
        AppMethodBeat.o(67707);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67708);
        super.initView();
        setMMTitle(getString(R.string.f1y));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67681);
                MobileRemitHistoryRecodUI.this.finish();
                AppMethodBeat.o(67681);
                return true;
            }
        });
        this.Cmu = (RecyclerView) findViewById(R.id.fhi);
        this.Cmv = (TextView) findViewById(R.id.fhh);
        if (this.Cmz.isEmpty()) {
            this.Cmu.setVisibility(8);
            this.Cmv.setVisibility(0);
            AppMethodBeat.o(67708);
            return;
        }
        this.gxa = new LinearLayoutManager();
        this.gxa.setOrientation(1);
        this.Cmu.setLayoutManager(this.gxa);
        this.CmB = new c(getContext());
        this.Cmu.a(this.CmB);
        this.CmA = new b(getContext(), this.Cmy, this.Cmz, new d() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.d
            public final void onClick(View view) {
                AppMethodBeat.i(67684);
                Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv click!");
                cbp cbp = (cbp) view.getTag();
                if (cbp.ClW != 0) {
                    h.a((Context) MobileRemitHistoryRecodUI.this.getContext(), MobileRemitHistoryRecodUI.this.getResources().getString(R.string.f1w), "", MobileRemitHistoryRecodUI.this.getResources().getString(R.string.f1r), false, (DialogInterface.OnClickListener) null).show();
                } else {
                    MobileRemitHistoryRecodUI.this.doSceneProgress(new NetSceneMobileRemitGetRecvInfo("", cbp.id, MobileRemitHistoryRecodUI.this.Cmw, 2), true);
                }
                MobileRemitHistoryRecodUI.Wb(13);
                AppMethodBeat.o(67684);
            }

            @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.d
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(67685);
                Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv longclick!");
                final cbp cbp = (cbp) view.getTag();
                new com.tencent.mm.ui.widget.b.a(MobileRemitHistoryRecodUI.this, view).a(view, new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.AnonymousClass2.AnonymousClass1 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(67682);
                        contextMenu.add(0, 0, 0, R.string.tf);
                        AppMethodBeat.o(67682);
                    }
                }, new o.g() {
                    /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(67683);
                        if (menuItem == null) {
                            AppMethodBeat.o(67683);
                            return;
                        }
                        if (menuItem.getItemId() == 0) {
                            Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "delete HisRcvr id:%s", cbp.id);
                            MobileRemitHistoryRecodUI.this.doSceneProgress(new com.tencent.mm.plugin.remittance.mobile.cgi.c(cbp.id), false);
                            MobileRemitHistoryRecodUI.this.Cmz.remove(cbp);
                            MobileRemitHistoryRecodUI.this.CmA.atj.notifyChanged();
                            MobileRemitHistoryRecodUI.Wb(14);
                        }
                        AppMethodBeat.o(67683);
                    }
                }, MobileRemitHistoryRecodUI.this.tef[0], MobileRemitHistoryRecodUI.this.tef[1]);
                AppMethodBeat.o(67685);
                return true;
            }
        });
        this.Cmu.setAdapter(this.CmA);
        this.Cmu.a(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.AnonymousClass3 */

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(67686);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv onScrollStateChanged() newState:%s mLastVisibleItem:%s isFinish:%s itemCount:%s", Integer.valueOf(i2), Integer.valueOf(MobileRemitHistoryRecodUI.this.CmC), Boolean.valueOf(MobileRemitHistoryRecodUI.this.CmA.dgZ), Integer.valueOf(MobileRemitHistoryRecodUI.this.CmA.getItemCount()));
                if (i2 == 0 && !MobileRemitHistoryRecodUI.this.CmA.dgZ && MobileRemitHistoryRecodUI.this.CmC + 1 == MobileRemitHistoryRecodUI.this.CmA.getItemCount()) {
                    MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(67686);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(67687);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                MobileRemitHistoryRecodUI.this.CmC = MobileRemitHistoryRecodUI.this.gxa.ku();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(67687);
            }
        });
        this.CmA.atj.notifyChanged();
        this.Cmu.post(this.CmD);
        this.Cmu.a(new RecyclerView.k() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.AnonymousClass4 */

            @Override // android.support.v7.widget.RecyclerView.k
            public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
                AppMethodBeat.i(213713);
                MobileRemitHistoryRecodUI.this.tef[0] = (int) motionEvent.getRawX();
                MobileRemitHistoryRecodUI.this.tef[1] = (int) motionEvent.getRawY();
                Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onTouchEvent() (%s, %s)", Integer.valueOf(MobileRemitHistoryRecodUI.this.tef[0]), Integer.valueOf(MobileRemitHistoryRecodUI.this.tef[1]));
                AppMethodBeat.o(213713);
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.k
            public final void b(RecyclerView recyclerView, MotionEvent motionEvent) {
                AppMethodBeat.i(213714);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$4", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$4", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(213714);
            }

            @Override // android.support.v7.widget.RecyclerView.k
            public final void ah(boolean z) {
            }
        });
        this.Cmu.setVisibility(0);
        this.Cmv.setVisibility(8);
        AppMethodBeat.o(67708);
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67709);
        super.onDestroy();
        removeSceneEndListener(2993);
        removeSceneEndListener(1495);
        removeSceneEndListener(1275);
        AppMethodBeat.o(67709);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        ejw ejw;
        String str2;
        AppMethodBeat.i(67710);
        Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof NetSceneMobileRemitGetRecord) {
                ejy eNm = ((NetSceneMobileRemitGetRecord) qVar).eNm();
                if (eNm == null || eNm.pTZ != 0) {
                    u.makeText(getContext(), (eNm == null || Util.isNullOrNil(eNm.pUa)) ? getString(R.string.ibn) : eNm.pUa, 0).show();
                } else {
                    this.Cmx = eNm.Nji;
                    this.Cmy = eNm.chA;
                    this.CmA.dgZ = this.Cmy;
                    if (!eNm.Njk.isEmpty()) {
                        this.Cmz.addAll(eNm.Njk);
                    }
                    this.CmA.atj.notifyChanged();
                }
                AppMethodBeat.o(67710);
                return true;
            } else if (qVar instanceof NetSceneMobileRemitGetRecvInfo) {
                final eka eNn = ((NetSceneMobileRemitGetRecvInfo) qVar).eNn();
                if (eNn == null) {
                    Log.e("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
                    AppMethodBeat.o(67710);
                    return true;
                }
                String str3 = ((NetSceneMobileRemitGetRecvInfo) qVar).ClX;
                Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrId:%s ret_code:%s ret_msg:%s", str3, Integer.valueOf(eNn.pTZ), eNn.pUa);
                if (eNn.pTZ != 0) {
                    if (eNn.ClW == 1) {
                        Iterator<cbp> it = this.Cmz.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            cbp next = it.next();
                            if (Util.isEqual(next.id, str3)) {
                                next.ClW = 1;
                                break;
                            }
                        }
                        this.CmA.atj.notifyChanged();
                    }
                    AppCompatActivity context = getContext();
                    if (Util.isNullOrNil(eNn.pUa)) {
                        str2 = getString(R.string.ibn);
                    } else {
                        str2 = eNn.pUa;
                    }
                    h.a((Context) context, str2, "", getResources().getString(R.string.f1r), false, (DialogInterface.OnClickListener) null).show();
                    AppMethodBeat.o(67710);
                    return true;
                }
                if (eNn.Njl != null) {
                    Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show remark or nickname change dialog!");
                    l.a(this, eNn.Njl, (Object) null, new com.tencent.mm.plugin.remittance.mobile.a.a() {
                        /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.AnonymousClass6 */

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void eNw() {
                            AppMethodBeat.i(67690);
                            Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:exit");
                            MobileRemitHistoryRecodUI.this.eNv();
                            AppMethodBeat.o(67690);
                        }

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void dP(Object obj) {
                            AppMethodBeat.i(67691);
                            Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:continue");
                            com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), eNn);
                            AppMethodBeat.o(67691);
                        }
                    });
                } else if (eNn.Nja != null) {
                    Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show free oneself from dialog!");
                    l.a(this, eNn.Nja, (Object) null, new com.tencent.mm.plugin.remittance.mobile.a.a() {
                        /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.AnonymousClass7 */

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void eNw() {
                            AppMethodBeat.i(67692);
                            Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:exit");
                            MobileRemitHistoryRecodUI.this.eNv();
                            AppMethodBeat.o(67692);
                        }

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void dP(Object obj) {
                            AppMethodBeat.i(67693);
                            Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:continue");
                            com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), eNn);
                            AppMethodBeat.o(67693);
                        }
                    });
                } else {
                    com.tencent.mm.plugin.remittance.mobile.a.b.a(getContext(), eNn);
                }
                AppMethodBeat.o(67710);
                return true;
            } else if (qVar instanceof com.tencent.mm.plugin.remittance.mobile.cgi.c) {
                com.tencent.mm.plugin.remittance.mobile.cgi.c cVar = (com.tencent.mm.plugin.remittance.mobile.cgi.c) qVar;
                if (cVar.ClR == null) {
                    ejw = null;
                } else {
                    ejw = cVar.ClR;
                }
                if (ejw == null || ejw.pTZ != 0) {
                    u.makeText(getContext(), (ejw == null || Util.isNullOrNil(ejw.pUa)) ? getString(R.string.ibn) : ejw.pUa, 0).show();
                }
                AppMethodBeat.o(67710);
                return true;
            }
        } else if (i3 == 0) {
            AppCompatActivity context2 = getContext();
            if (Util.isNullOrNil(str)) {
                str = getString(R.string.f1s);
            }
            u.makeText(context2, str, 0).show();
        }
        AppMethodBeat.o(67710);
        return false;
    }

    public static class b extends RecyclerView.a {
        private List<cbp> CmI;
        private int CmJ;
        private int CmK;
        private int CmL;
        private d CmM;
        private Context context;
        boolean dgZ;

        public b(Context context2, boolean z, List<cbp> list, d dVar) {
            AppMethodBeat.i(67697);
            this.context = context2;
            this.dgZ = z;
            this.CmI = list;
            this.CmM = dVar;
            this.CmJ = context2.getResources().getColor(R.color.fr);
            this.CmK = context2.getResources().getColor(R.color.BW_0_Alpha_0_5);
            this.CmL = context2.getResources().getColor(R.color.BW_0_Alpha_0_3);
            AppMethodBeat.o(67697);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(67698);
            if (i2 == 0) {
                e eVar = new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bb4, viewGroup, false));
                AppMethodBeat.o(67698);
                return eVar;
            }
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bb5, viewGroup, false));
            AppMethodBeat.o(67698);
            return aVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(67699);
            if (!(vVar instanceof e)) {
                a aVar = (a) vVar;
                if (this.dgZ) {
                    aVar.gvQ.setVisibility(8);
                    AppMethodBeat.o(67699);
                    return;
                }
                aVar.gvQ.setVisibility(0);
            } else if (this.CmI != null && i2 >= 0 && i2 < this.CmI.size()) {
                final e eVar = (e) vVar;
                final cbp cbp = this.CmI.get(i2);
                Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onBindViewHolder() i:%s invalid:%s", Integer.valueOf(i2), Integer.valueOf(cbp.ClW));
                eVar.gvQ.setVisibility(0);
                eVar.CmP.post(new Runnable() {
                    /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(67694);
                        int measuredWidth = eVar.CmP.getMeasuredWidth();
                        if (measuredWidth != 0) {
                            float measureText = eVar.kcZ.getPaint().measureText(cbp.ClU);
                            float measureText2 = eVar.CmQ.getPaint().measureText(cbp.ClV);
                            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(b.this.context, 14);
                            if (measureText + measureText2 + ((float) fromDPToPix) > ((float) measuredWidth)) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) eVar.kcZ.getLayoutParams();
                                layoutParams.width = (int) ((((float) measuredWidth) - measureText2) - ((float) fromDPToPix));
                                eVar.kcZ.setLayoutParams(layoutParams);
                            }
                        }
                        eVar.kcZ.setText(cbp.ClU);
                        eVar.CmQ.setText(cbp.ClV);
                        AppMethodBeat.o(67694);
                    }
                });
                eVar.nzh.setText(cbp.pSm);
                if (cbp.ClW == 0) {
                    eVar.kcZ.setTextColor(this.CmJ);
                    eVar.CmQ.setTextColor(this.CmJ);
                    eVar.nzh.setTextColor(this.CmK);
                    eVar.uzB.setVisibility(8);
                } else {
                    eVar.kcZ.setTextColor(this.CmL);
                    eVar.CmQ.setTextColor(this.CmL);
                    eVar.nzh.setTextColor(this.CmL);
                    eVar.uzB.setVisibility(0);
                }
                eVar.gvQ.setTag(cbp);
                eVar.gvQ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.b.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(67695);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (b.this.CmM != null) {
                            b.this.CmM.onClick(view);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(67695);
                    }
                });
                eVar.gvQ.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.b.AnonymousClass3 */

                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(67696);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                        if (b.this.CmM != null) {
                            boolean onLongClick = b.this.CmM.onLongClick(view);
                            com.tencent.mm.hellhoundlib.a.a.a(onLongClick, this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                            AppMethodBeat.o(67696);
                            return onLongClick;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(67696);
                        return false;
                    }
                });
                AppMethodBeat.o(67699);
                return;
            }
            AppMethodBeat.o(67699);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(67700);
            if (this.dgZ) {
                AppMethodBeat.o(67700);
                return 0;
            } else if (i2 == getItemCount() - 1) {
                AppMethodBeat.o(67700);
                return 1;
            } else {
                AppMethodBeat.o(67700);
                return 0;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(67701);
            if (this.dgZ) {
                int size = this.CmI.size();
                AppMethodBeat.o(67701);
                return size;
            }
            int size2 = this.CmI.size() + 1;
            AppMethodBeat.o(67701);
            return size2;
        }
    }

    public static class e extends RecyclerView.v {
        LinearLayout CmP;
        TextView CmQ;
        View gvQ;
        TextView kcZ;
        TextView nzh;
        TextView uzB;

        public e(View view) {
            super(view);
            AppMethodBeat.i(67705);
            this.gvQ = view;
            this.CmP = (LinearLayout) view.findViewById(R.id.ftc);
            this.kcZ = (TextView) view.findViewById(R.id.fzg);
            this.CmQ = (TextView) view.findViewById(R.id.gtr);
            this.nzh = (TextView) view.findViewById(R.id.gb0);
            this.uzB = (TextView) view.findViewById(R.id.i50);
            AppMethodBeat.o(67705);
        }
    }

    public static class a extends RecyclerView.v {
        View gvQ;

        public a(View view) {
            super(view);
            this.gvQ = view;
        }
    }

    public static class c extends RecyclerView.h {
        private int dividerHeight;
        private Paint gwh = new Paint();
        private Paint gxp;
        private int gxq;

        public c(Context context) {
            AppMethodBeat.i(67702);
            this.dividerHeight = com.tencent.mm.cb.a.fromDPToPix(context, 0.5f);
            this.gxq = com.tencent.mm.cb.a.fromDPToPix(context, 16);
            this.gwh.setColor(context.getResources().getColor(R.color.BW_0_Alpha_0_1));
            this.gxp = new Paint();
            this.gxp.setColor(context.getResources().getColor(R.color.BW_93));
            AppMethodBeat.o(67702);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(67703);
            super.a(canvas, recyclerView, sVar);
            int childCount = recyclerView.getChildCount();
            int paddingLeft = recyclerView.getPaddingLeft();
            int i2 = paddingLeft + this.gxq;
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                float bottom = (float) childAt.getBottom();
                float bottom2 = (float) (childAt.getBottom() + this.dividerHeight);
                if (i3 == childCount - 1) {
                    canvas.drawRect((float) paddingLeft, bottom, (float) width, bottom2, this.gxp);
                } else {
                    canvas.drawRect((float) i2, bottom, (float) width, bottom2, this.gwh);
                }
            }
            AppMethodBeat.o(67703);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(67704);
            super.a(rect, view, recyclerView, sVar);
            rect.bottom = this.dividerHeight;
            AppMethodBeat.o(67704);
        }
    }

    static /* synthetic */ void Wb(int i2) {
        AppMethodBeat.i(67711);
        lc lcVar = new lc();
        lcVar.ejA = (long) i2;
        lcVar.bfK();
        AppMethodBeat.o(67711);
    }

    static /* synthetic */ void f(MobileRemitHistoryRecodUI mobileRemitHistoryRecodUI) {
        AppMethodBeat.i(67712);
        Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "doFetchHistoryRecord() mLastId:%s", mobileRemitHistoryRecodUI.Cmx);
        mobileRemitHistoryRecodUI.doSceneProgress(new NetSceneMobileRemitGetRecord(mobileRemitHistoryRecodUI.Cmx, mobileRemitHistoryRecodUI.Cmw), false);
        AppMethodBeat.o(67712);
    }
}
