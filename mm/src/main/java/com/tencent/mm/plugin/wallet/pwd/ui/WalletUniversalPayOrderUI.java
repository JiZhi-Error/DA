package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet.pwd.a.d;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.abk;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.eli;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.elk;
import com.tencent.mm.protocal.protobuf.emj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;
import java.util.List;

public class WalletUniversalPayOrderUI extends WalletBaseUI {
    private DragSortListView HLG;
    private a HLH;
    private TextView HLI;
    private TextView HLJ;
    private TextView HLK;
    private MMSwitchBtn HLL;
    private TextView HLM;
    private TextView HLN;
    private Dialog HLO;
    private boolean HLP = true;
    private ViewGroup qgZ;
    private ViewGroup ykw;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69836);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        setMMTitle("");
        initView();
        Log.i("MicroMsg.WalletUniversalPayOrderUI", "do query uni pay order");
        getString(R.string.ty);
        this.HLO = h.a((Context) this, getString(R.string.inu), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new c().aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<dih>>() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass7 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<dih> aVar) {
                AppMethodBeat.i(69827);
                c.a<dih> aVar2 = aVar;
                Log.i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                if (WalletUniversalPayOrderUI.this.HLO != null) {
                    WalletUniversalPayOrderUI.this.HLO.dismiss();
                }
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    dih dih = (dih) aVar2.iLC;
                    Log.i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((dih) aVar2.iLC).dDN), ((dih) aVar2.iLC).qwn);
                    if (dih.dDN == 0) {
                        elk elk = dih.MMO;
                        WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, elk);
                        WalletUniversalPayOrderUI.this.HLH.pXz = elk.KDk;
                        WalletUniversalPayOrderUI.this.HLH.notifyDataSetChanged();
                    } else {
                        f.bpB(dih.qwn);
                    }
                } else {
                    f.ar(WalletUniversalPayOrderUI.this.getContext(), "");
                }
                AppMethodBeat.o(69827);
                return null;
            }
        });
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 1);
        AppMethodBeat.o(69836);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8t;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69837);
        this.HLG = (DragSortListView) findViewById(R.id.jjy);
        this.qgZ = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.c8r, (ViewGroup) null, false);
        this.HLI = (TextView) this.qgZ.findViewById(R.id.jju);
        this.HLJ = (TextView) this.qgZ.findViewById(R.id.jjq);
        this.HLK = (TextView) this.qgZ.findViewById(R.id.jjs);
        this.HLL = (MMSwitchBtn) this.qgZ.findViewById(R.id.jjr);
        this.HLM = (TextView) this.qgZ.findViewById(R.id.jjt);
        this.HLG.addHeaderView(this.qgZ, null, false);
        this.ykw = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.c8q, (ViewGroup) null, false);
        this.HLN = (TextView) this.ykw.findViewById(R.id.jjp);
        this.HLG.addFooterView(this.ykw, null, false);
        this.HLH = new a(this);
        this.HLG.setAdapter((ListAdapter) this.HLH);
        this.HLG.setDropListener(new DragSortListView.h() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.h
            public final void ey(int i2, int i3) {
                AppMethodBeat.i(69819);
                if (i2 == i3) {
                    Log.d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", Integer.valueOf(i2));
                    AppMethodBeat.o(69819);
                    return;
                }
                WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, i2, i3);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 10);
                AppMethodBeat.o(69819);
            }
        });
        this.HLG.setRemoveListener(new DragSortListView.l() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.l
            public final void remove(int i2) {
            }
        });
        AppMethodBeat.o(69837);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        private Context mContext;
        List<eli> pXz;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(69834);
            eli aeE = aeE(i2);
            AppMethodBeat.o(69834);
            return aeE;
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final void jS(int i2, int i3) {
            AppMethodBeat.i(69830);
            Log.i("MicroMsg.WalletUniversalPayOrderUI", "swipe: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
            this.pXz.add(i3, this.pXz.remove(i2));
            AppMethodBeat.o(69830);
        }

        public final int getCount() {
            AppMethodBeat.i(69831);
            if (this.pXz == null) {
                AppMethodBeat.o(69831);
                return 0;
            }
            int size = this.pXz.size();
            AppMethodBeat.o(69831);
            return size;
        }

        private eli aeE(int i2) {
            AppMethodBeat.i(69832);
            if (this.pXz == null) {
                AppMethodBeat.o(69832);
                return null;
            }
            eli eli = this.pXz.get(i2);
            AppMethodBeat.o(69832);
            return eli;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(69833);
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.c8s, viewGroup, false);
                view.setTag(new b(view));
            }
            eli aeE = aeE(i2);
            b bVar = (b) view.getTag();
            bVar.HLU.setImageBitmap(null);
            bVar.HLU.gI(aeE.iwv, R.drawable.b0w);
            bVar.HLV.setText(aeE.ynT);
            AppMethodBeat.o(69833);
            return view;
        }
    }

    static class b {
        public CdnImageView HLU;
        public TextView HLV;
        public ImageView HLW;
        public View lJI;

        public b(View view) {
            AppMethodBeat.i(69835);
            this.lJI = view;
            this.HLU = (CdnImageView) view.findViewById(R.id.jjw);
            this.HLV = (TextView) view.findViewById(R.id.jjx);
            this.HLW = (ImageView) view.findViewById(R.id.jjv);
            AppMethodBeat.o(69835);
        }
    }

    static /* synthetic */ void a(WalletUniversalPayOrderUI walletUniversalPayOrderUI, final int i2, final int i3) {
        AppMethodBeat.i(69838);
        Log.i("MicroMsg.WalletUniversalPayOrderUI", "do update unipay order");
        walletUniversalPayOrderUI.getString(R.string.ty);
        walletUniversalPayOrderUI.HLO = h.a((Context) walletUniversalPayOrderUI, walletUniversalPayOrderUI.getString(R.string.inu), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass12 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        walletUniversalPayOrderUI.HLH.jS(i2, i3);
        walletUniversalPayOrderUI.HLH.notifyDataSetChanged();
        LinkedList linkedList = new LinkedList();
        if (walletUniversalPayOrderUI.HLH.pXz != null) {
            linkedList.addAll(walletUniversalPayOrderUI.HLH.pXz);
        }
        new d(linkedList).aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<emj>>() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<emj> aVar) {
                AppMethodBeat.i(69820);
                c.a<emj> aVar2 = aVar;
                Log.i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                if (WalletUniversalPayOrderUI.this.HLO != null) {
                    WalletUniversalPayOrderUI.this.HLO.dismiss();
                }
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    emj emj = (emj) aVar2.iLC;
                    Log.i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((emj) aVar2.iLC).dDN), ((emj) aVar2.iLC).qwn);
                    if (emj.dDN == 0) {
                        WalletUniversalPayOrderUI.c(WalletUniversalPayOrderUI.this);
                    } else {
                        f.bpB(emj.qwn);
                        WalletUniversalPayOrderUI.this.HLH.jS(i3, i2);
                        WalletUniversalPayOrderUI.this.HLH.notifyDataSetChanged();
                    }
                } else {
                    f.ar(WalletUniversalPayOrderUI.this.getContext(), "");
                    WalletUniversalPayOrderUI.this.HLH.jS(i3, i2);
                    WalletUniversalPayOrderUI.this.HLH.notifyDataSetChanged();
                }
                AppMethodBeat.o(69820);
                return null;
            }
        });
        AppMethodBeat.o(69838);
    }

    static /* synthetic */ void a(WalletUniversalPayOrderUI walletUniversalPayOrderUI, final elk elk) {
        AppMethodBeat.i(69839);
        if (!Util.isNullOrNil(elk.title)) {
            walletUniversalPayOrderUI.HLI.setText(elk.title);
        }
        if (!Util.isNullOrNil(elk.desc)) {
            walletUniversalPayOrderUI.HLJ.setText(elk.desc);
        }
        if (!Util.isNullOrNil(elk.Nkr)) {
            walletUniversalPayOrderUI.HLK.setText(elk.Nkr);
        }
        if (!Util.isNullOrNil(elk.Nks)) {
            walletUniversalPayOrderUI.HLM.setText(elk.Nks);
        }
        walletUniversalPayOrderUI.HLL.setCheck(elk.MMP == 1);
        walletUniversalPayOrderUI.HLL.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(69825);
                Log.i("MicroMsg.WalletUniversalPayOrderUI", "click switch: %s", Boolean.valueOf(z));
                WalletUniversalPayOrderUI.this.HLG.setDragEnabled(z);
                if (z) {
                    if (elk.Nku != 1 || elk.Nkv == null || Util.isNullOrNil(elk.Nkv.title)) {
                        WalletUniversalPayOrderUI.f(WalletUniversalPayOrderUI.this);
                    } else {
                        Log.i("MicroMsg.WalletUniversalPayOrderUI", "show open dialog");
                        elj elj = elk.Nkv;
                        d.a aVar = new d.a(WalletUniversalPayOrderUI.this.getContext());
                        aVar.bon(elj.title);
                        aVar.boo(elj.content);
                        aVar.Dk(false);
                        if (elj.Nkp != null) {
                            aVar.bov(elj.Nkp.title);
                            aVar.d(new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass3.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(69821);
                                    WalletUniversalPayOrderUI.this.HLL.setCheck(false);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 4);
                                    AppMethodBeat.o(69821);
                                }
                            });
                        }
                        if (elj.Nkq != null) {
                            aVar.bou(elj.Nkq.title);
                            aVar.c(new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass3.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(69822);
                                    WalletUniversalPayOrderUI.f(WalletUniversalPayOrderUI.this);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 5);
                                    AppMethodBeat.o(69822);
                                }
                            });
                        }
                        com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
                        WalletUniversalPayOrderUI.this.addDialog(hbn);
                        hbn.show();
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 3);
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 2);
                    AppMethodBeat.o(69825);
                    return;
                }
                if (WalletUniversalPayOrderUI.this.HLP) {
                    WalletUniversalPayOrderUI.this.HLP = false;
                    if (elk.Nkw == null || Util.isNullOrNil(elk.Nkw.title)) {
                        WalletUniversalPayOrderUI.i(WalletUniversalPayOrderUI.this);
                    } else {
                        Log.i("MicroMsg.WalletUniversalPayOrderUI", "show close dialog");
                        elj elj2 = elk.Nkw;
                        d.a aVar2 = new d.a(WalletUniversalPayOrderUI.this.getContext());
                        aVar2.bon(elj2.title);
                        aVar2.boo(elj2.content);
                        aVar2.Dk(false);
                        if (elj2.Nkp != null) {
                            aVar2.bov(elj2.Nkp.title);
                            aVar2.d(new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass3.AnonymousClass3 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(69823);
                                    WalletUniversalPayOrderUI.this.HLL.setCheck(true);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 8);
                                    AppMethodBeat.o(69823);
                                }
                            });
                        }
                        if (elj2.Nkq != null) {
                            aVar2.bou(elj2.Nkq.title);
                            aVar2.c(new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass3.AnonymousClass4 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(69824);
                                    WalletUniversalPayOrderUI.i(WalletUniversalPayOrderUI.this);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 9);
                                    AppMethodBeat.o(69824);
                                }
                            });
                        }
                        com.tencent.mm.ui.widget.a.d hbn2 = aVar2.hbn();
                        WalletUniversalPayOrderUI.this.addDialog(hbn2);
                        hbn2.show();
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 7);
                    }
                } else {
                    WalletUniversalPayOrderUI.i(WalletUniversalPayOrderUI.this);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 6);
                AppMethodBeat.o(69825);
            }
        });
        if (elk.Nkt == null || Util.isNullOrNil(elk.Nkt.title)) {
            walletUniversalPayOrderUI.HLN.setVisibility(8);
            AppMethodBeat.o(69839);
            return;
        }
        com.tencent.mm.plugin.wallet_core.ui.q qVar = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(69826);
                f.p(WalletUniversalPayOrderUI.this.getContext(), elk.Nkt.url, true);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16343, 11);
                AppMethodBeat.o(69826);
            }
        });
        SpannableString spannableString = new SpannableString(elk.Nkt.title);
        spannableString.setSpan(qVar, 0, spannableString.length(), 18);
        walletUniversalPayOrderUI.HLN.setOnTouchListener(new o(walletUniversalPayOrderUI.getContext()));
        walletUniversalPayOrderUI.HLN.setClickable(true);
        walletUniversalPayOrderUI.HLN.setText(spannableString);
        walletUniversalPayOrderUI.HLN.setVisibility(0);
        AppMethodBeat.o(69839);
    }

    static /* synthetic */ void c(WalletUniversalPayOrderUI walletUniversalPayOrderUI) {
        AppMethodBeat.i(69840);
        walletUniversalPayOrderUI.setResult(-1);
        AppMethodBeat.o(69840);
    }

    static /* synthetic */ void f(WalletUniversalPayOrderUI walletUniversalPayOrderUI) {
        AppMethodBeat.i(69841);
        Log.i("MicroMsg.WalletUniversalPayOrderUI", "do open unipay order");
        walletUniversalPayOrderUI.getString(R.string.ty);
        walletUniversalPayOrderUI.HLO = h.a((Context) walletUniversalPayOrderUI, walletUniversalPayOrderUI.getString(R.string.inu), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new com.tencent.mm.plugin.wallet.pwd.a.b().aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<cxe>>() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass9 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<cxe> aVar) {
                AppMethodBeat.i(69828);
                c.a<cxe> aVar2 = aVar;
                Log.i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                if (WalletUniversalPayOrderUI.this.HLO != null) {
                    WalletUniversalPayOrderUI.this.HLO.dismiss();
                }
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    cxe cxe = (cxe) aVar2.iLC;
                    Log.i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((cxe) aVar2.iLC).dDN), ((cxe) aVar2.iLC).qwn);
                    if (cxe.dDN == 0) {
                        WalletUniversalPayOrderUI.this.HLH.pXz = cxe.KDk;
                        WalletUniversalPayOrderUI.this.HLH.notifyDataSetChanged();
                        WalletUniversalPayOrderUI.c(WalletUniversalPayOrderUI.this);
                    } else {
                        f.bpB(cxe.qwn);
                        WalletUniversalPayOrderUI.this.HLL.setCheck(false);
                    }
                } else {
                    f.ar(WalletUniversalPayOrderUI.this.getContext(), "");
                    WalletUniversalPayOrderUI.this.HLL.setCheck(false);
                }
                AppMethodBeat.o(69828);
                return null;
            }
        });
        AppMethodBeat.o(69841);
    }

    static /* synthetic */ void i(WalletUniversalPayOrderUI walletUniversalPayOrderUI) {
        AppMethodBeat.i(69842);
        Log.i("MicroMsg.WalletUniversalPayOrderUI", "do close unipay order");
        walletUniversalPayOrderUI.getString(R.string.ty);
        walletUniversalPayOrderUI.HLO = h.a((Context) walletUniversalPayOrderUI, walletUniversalPayOrderUI.getString(R.string.inu), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass10 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new com.tencent.mm.plugin.wallet.pwd.a.a().aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<abk>>() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.AnonymousClass11 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<abk> aVar) {
                AppMethodBeat.i(69829);
                c.a<abk> aVar2 = aVar;
                Log.i("MicroMsg.WalletUniversalPayOrderUI", "errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                if (WalletUniversalPayOrderUI.this.HLO != null) {
                    WalletUniversalPayOrderUI.this.HLO.dismiss();
                }
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    abk abk = (abk) aVar2.iLC;
                    Log.i("MicroMsg.WalletUniversalPayOrderUI", "retcode: %s, retmsg: %s", Integer.valueOf(((abk) aVar2.iLC).dDN), ((abk) aVar2.iLC).qwn);
                    if (abk.dDN == 0) {
                        a aVar3 = WalletUniversalPayOrderUI.this.HLH;
                        if (aVar3.pXz != null) {
                            aVar3.pXz.clear();
                        }
                        WalletUniversalPayOrderUI.this.HLH.notifyDataSetChanged();
                        WalletUniversalPayOrderUI.c(WalletUniversalPayOrderUI.this);
                    } else {
                        f.bpB(abk.qwn);
                        WalletUniversalPayOrderUI.this.HLL.setCheck(true);
                    }
                } else {
                    f.ar(WalletUniversalPayOrderUI.this.getContext(), "");
                    WalletUniversalPayOrderUI.this.HLL.setCheck(true);
                }
                AppMethodBeat.o(69829);
                return null;
            }
        });
        AppMethodBeat.o(69842);
    }
}
