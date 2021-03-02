package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallFunctionSettingsUI extends WalletBaseUI {
    int efI;
    private ListView zkQ;
    private final int zkR = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    private TextView zkS;
    private TextView zkT;
    private a zkU;
    private List<b> zkV = new ArrayList();
    private com.tencent.mm.plugin.mall.a.b zkW;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallFunctionSettingsUI() {
        AppMethodBeat.i(66057);
        AppMethodBeat.o(66057);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        int i2;
        AppMethodBeat.i(66058);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        this.efI = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
        Log.i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", Integer.valueOf(this.efI));
        initView();
        setMMTitle("");
        Log.i("MicroMsg.MallFunctionSettingsUI", "do get function list");
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
        Log.i("MicroMsg.MallFunctionSettingsUI", " walletMallV2 is ：%s", Boolean.valueOf(a2));
        if (a2) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.zkW = new com.tencent.mm.plugin.mall.a.b(this.efI, i2);
        this.zkW.aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<bsh>>() {
            /* class com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<bsh> aVar) {
                AppMethodBeat.i(66049);
                c.a<bsh> aVar2 = aVar;
                Log.i("MicroMsg.MallFunctionSettingsUI", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode), aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    MallFunctionSettingsUI.a(MallFunctionSettingsUI.this, (bsh) aVar2.iLC);
                    MallFunctionSettingsUI.a(MallFunctionSettingsUI.this, ((bsh) aVar2.iLC).LPA);
                    MallFunctionSettingsUI.this.zkU.notifyDataSetChanged();
                } else {
                    m.a(true, aVar2.errCode, 0, aVar2.errMsg).G(MallFunctionSettingsUI.this.getContext(), true);
                }
                AppMethodBeat.o(66049);
                return null;
            }
        });
        AppMethodBeat.o(66058);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(66059);
        this.zkQ = (ListView) findViewById(R.id.fe9);
        this.zkU = new a(this, (byte) 0);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, R.layout.b58, null);
        this.zkQ.addHeaderView(viewGroup, null, false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 80));
        this.zkQ.addFooterView(linearLayout, null, false);
        this.zkQ.setAdapter((ListAdapter) this.zkU);
        this.zkS = (TextView) viewGroup.findViewById(R.id.fe1);
        this.zkT = (TextView) viewGroup.findViewById(R.id.fe0);
        AppMethodBeat.o(66059);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(66060);
        super.onDestroy();
        this.zkW.cancel();
        AppMethodBeat.o(66060);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b5a;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MallFunctionSettingsUI mallFunctionSettingsUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(66055);
            b Qh = Qh(i2);
            AppMethodBeat.o(66055);
            return Qh;
        }

        public final int getCount() {
            AppMethodBeat.i(66051);
            int size = MallFunctionSettingsUI.this.zkV.size();
            AppMethodBeat.o(66051);
            return size;
        }

        private b Qh(int i2) {
            AppMethodBeat.i(66052);
            b bVar = (b) MallFunctionSettingsUI.this.zkV.get(i2);
            AppMethodBeat.o(66052);
            return bVar;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(66053);
            int i3 = ((b) MallFunctionSettingsUI.this.zkV.get(i2)).type;
            AppMethodBeat.o(66053);
            return i3;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.i(66054);
            if (view == null) {
                int itemViewType = getItemViewType(i2);
                c cVar = new c(MallFunctionSettingsUI.this, (byte) 0);
                if (itemViewType == 1) {
                    inflate = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(R.layout.b59, viewGroup, false);
                    cVar.ymf = (CdnImageView) inflate.findViewById(R.id.fe5);
                    cVar.mPa = (TextView) inflate.findViewById(R.id.fe7);
                    cVar.jVn = (TextView) inflate.findViewById(R.id.fe3);
                    cVar.jBx = (MMSwitchBtn) inflate.findViewById(R.id.fe6);
                    cVar.zlb = inflate.findViewById(R.id.fe4);
                    cVar.zlc = inflate.findViewById(R.id.fe2);
                    cVar.oby = (ViewGroup) inflate;
                    cVar.ymf.setUseSdcardCache(true);
                } else {
                    inflate = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(R.layout.b5_, viewGroup, false);
                    cVar.mPa = (TextView) inflate.findViewById(R.id.fe8);
                    cVar.oby = (ViewGroup) inflate;
                }
                inflate.setTag(cVar);
                view = inflate;
            }
            b Qh = Qh(i2);
            c cVar2 = (c) view.getTag();
            if (Qh.type == 1) {
                czt czt = Qh.zkZ;
                if (ao.isDarkMode()) {
                    if (czt.MFb != null) {
                        cVar2.ymf.setUrl(czt.MFb);
                    } else if (czt.MEY != null) {
                        cVar2.ymf.setUrl(czt.MEY);
                    }
                } else if (czt.MEY != null) {
                    cVar2.ymf.setUrl(czt.MEY);
                }
                if (czt.MEX != null) {
                    cVar2.mPa.setText(czt.MEX);
                }
                if (czt.MEZ == null || Util.isNullOrNil(czt.MEZ)) {
                    cVar2.jVn.setVisibility(8);
                } else {
                    cVar2.jVn.setText(czt.MEZ);
                    cVar2.jVn.setVisibility(0);
                }
                if (czt.oTW == 0) {
                    cVar2.jBx.setCheck(true);
                    cVar2.jBx.setEnabled(true);
                    cVar2.mPa.setTextColor(MallFunctionSettingsUI.this.getContext().getResources().getColor(R.color.fq));
                    cVar2.zlc.setVisibility(8);
                } else if (czt.oTW == 1) {
                    cVar2.jBx.setCheck(false);
                    cVar2.jBx.setEnabled(true);
                    cVar2.mPa.setTextColor(MallFunctionSettingsUI.this.getContext().getResources().getColor(R.color.fq));
                    cVar2.zlc.setVisibility(8);
                } else if (czt.oTW == 2) {
                    cVar2.jBx.setCheck(false);
                    cVar2.jBx.setEnabled(false);
                    cVar2.zlc.setVisibility(0);
                }
                cVar2.jBx.setSwitchListener(new MMSwitchBtn.a(czt) {
                    /* class com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI.c.AnonymousClass1 */
                    final /* synthetic */ czt zld;

                    {
                        this.zld = r2;
                    }

                    @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
                    public final void onStatusChange(boolean z) {
                        AppMethodBeat.i(66056);
                        Log.i("MicroMsg.MallFunctionSettingsUI", "click switch: %s, id: %s", Boolean.valueOf(z), this.zld.MEW);
                        if (z) {
                            this.zld.oTW = 0;
                        } else {
                            this.zld.oTW = 1;
                        }
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(this.zld);
                        MallFunctionSettingsUI mallFunctionSettingsUI = MallFunctionSettingsUI.this;
                        Log.i("MicroMsg.MallFunctionSettingsUI", "do batch function operate");
                        com.tencent.mm.plugin.mall.a.a aVar = new com.tencent.mm.plugin.mall.a.a(linkedList, mallFunctionSettingsUI.efI);
                        aVar.aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<kd>>(aVar) {
                            /* class com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI.AnonymousClass2 */
                            final /* synthetic */ com.tencent.mm.plugin.mall.a.a zkY;

                            {
                                this.zkY = r2;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ Object call(c.a<kd> aVar) {
                                AppMethodBeat.i(66050);
                                c.a<kd> aVar2 = aVar;
                                Log.i("MicroMsg.MallFunctionSettingsUI", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode), aVar2.errMsg);
                                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                                    Log.i("MicroMsg.MallFunctionSettingsUI", "retcode: %s, retmsg: %s", Integer.valueOf(((kd) aVar2.iLC).KOt), ((kd) aVar2.iLC).KOu);
                                    if (((kd) aVar2.iLC).KOt != 0) {
                                        for (czt czt : this.zkY.zji) {
                                            czt.oTW = czt.oTW == 0 ? 1 : 0;
                                        }
                                        MallFunctionSettingsUI.this.zkU.notifyDataSetChanged();
                                        m.a(true, ((kd) aVar2.iLC).KOt, 0, ((kd) aVar2.iLC).KOu).G(MallFunctionSettingsUI.this.getContext(), true);
                                    }
                                } else {
                                    for (czt czt2 : this.zkY.zji) {
                                        czt2.oTW = czt2.oTW == 0 ? 1 : 0;
                                    }
                                    MallFunctionSettingsUI.this.zkU.notifyDataSetChanged();
                                    m.jU(aVar2.errCode, aVar2.errType).G(MallFunctionSettingsUI.this.getContext(), true);
                                }
                                AppMethodBeat.o(66050);
                                return null;
                            }
                        });
                        AppMethodBeat.o(66056);
                    }
                });
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar2.zlb.getLayoutParams();
                if (Qh.zla) {
                    layoutParams.leftMargin = 0;
                } else {
                    layoutParams.leftMargin = MallFunctionSettingsUI.this.zkR;
                }
                cVar2.zlb.setLayoutParams(layoutParams);
            } else if (Qh.type == 0) {
                cVar2.mPa.setText(Qh.title);
            }
            AppMethodBeat.o(66054);
            return view;
        }
    }

    class c {
        MMSwitchBtn jBx;
        TextView jVn;
        TextView mPa;
        ViewGroup oby;
        CdnImageView ymf;
        View zlb;
        View zlc;

        private c() {
        }

        /* synthetic */ c(MallFunctionSettingsUI mallFunctionSettingsUI, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        String title;
        int type;
        czt zkZ;
        boolean zla;

        private b() {
            this.zla = false;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(MallFunctionSettingsUI mallFunctionSettingsUI, bsh bsh) {
        AppMethodBeat.i(66061);
        if (bsh.LZp != null) {
            mallFunctionSettingsUI.zkS.setText(bsh.LZp.yO());
        }
        if (bsh.LZq != null) {
            mallFunctionSettingsUI.zkT.setText(bsh.LZq.yO());
        }
        AppMethodBeat.o(66061);
    }

    static /* synthetic */ void a(MallFunctionSettingsUI mallFunctionSettingsUI, List list) {
        AppMethodBeat.i(66062);
        if (list != null) {
            int i2 = -1;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                czt czt = (czt) it.next();
                if (i2 != czt.KOs) {
                    b bVar = new b((byte) 0);
                    bVar.type = 0;
                    bVar.title = czt.MFa;
                    mallFunctionSettingsUI.zkV.add(bVar);
                    if (mallFunctionSettingsUI.zkV.size() - 2 >= 0) {
                        mallFunctionSettingsUI.zkV.get(mallFunctionSettingsUI.zkV.size() - 2).zla = true;
                    }
                }
                b bVar2 = new b((byte) 0);
                bVar2.type = 1;
                bVar2.zkZ = czt;
                mallFunctionSettingsUI.zkV.add(bVar2);
                i2 = czt.KOs;
            }
            if (!mallFunctionSettingsUI.zkV.isEmpty()) {
                mallFunctionSettingsUI.zkV.get(mallFunctionSettingsUI.zkV.size() - 1).zla = true;
            }
        }
        AppMethodBeat.o(66062);
    }
}
