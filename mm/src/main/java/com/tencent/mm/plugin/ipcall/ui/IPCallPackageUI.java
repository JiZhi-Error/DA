package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.e.e;
import com.tencent.mm.plugin.ipcall.model.e.j;
import com.tencent.mm.plugin.ipcall.model.f.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ewk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class IPCallPackageUI extends MMActivity implements i {
    private ListView ywK = null;
    private TextView ywL = null;
    private ProgressDialog ywM = null;
    private ProgressDialog ywN = null;
    private a ywO = null;
    private e ywP = null;
    private j ywQ = null;
    private f ywR = new f();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallPackageUI() {
        AppMethodBeat.i(25849);
        AppMethodBeat.o(25849);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25850);
        super.onCreate(bundle);
        bg.azz().a(831, this);
        bg.azz().a(277, this);
        this.ywR.start();
        this.ywR.yrZ++;
        this.ywR.finish();
        setMMTitle(R.string.e91);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25839);
                IPCallPackageUI.this.finish();
                AppMethodBeat.o(25839);
                return true;
            }
        });
        this.ywK = (ListView) findViewById(R.id.g86);
        this.ywO = new a(this);
        this.ywK.setAdapter((ListAdapter) this.ywO);
        this.ywL = (TextView) findViewById(R.id.fzv);
        ebq();
        AppMethodBeat.o(25850);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25851);
        super.onDestroy();
        bg.azz().b(831, this);
        bg.azz().b(277, this);
        AppMethodBeat.o(25851);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ax2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    private void ebq() {
        AppMethodBeat.i(25852);
        Log.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
        if (this.ywO != null) {
            this.ywO.cvc = null;
            this.ywO.notifyDataSetChanged();
        }
        if (this.ywK != null) {
            this.ywK.setVisibility(8);
        }
        if (this.ywL != null) {
            this.ywL.setVisibility(8);
        }
        ebr();
        this.ywP = new e();
        bg.azz().a(this.ywP, 0);
        AppMethodBeat.o(25852);
    }

    private void ebr() {
        AppMethodBeat.i(25853);
        if (this.ywM == null) {
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.ywM = h.a((Context) context, getString(R.string.e6r), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(25840);
                    try {
                        if (IPCallPackageUI.this.ywP != null) {
                            bg.azz().a(IPCallPackageUI.this.ywP);
                        }
                        IPCallPackageUI.this.finish();
                        AppMethodBeat.o(25840);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", e2.getMessage());
                        AppMethodBeat.o(25840);
                    }
                }
            });
            AppMethodBeat.o(25853);
            return;
        }
        this.ywM.show();
        AppMethodBeat.o(25853);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        List<ewk> cvc = null;
        private IPCallPackageUI ywT = null;

        public a(IPCallPackageUI iPCallPackageUI) {
            this.ywT = iPCallPackageUI;
        }

        public final int getCount() {
            AppMethodBeat.i(25846);
            if (this.cvc == null) {
                AppMethodBeat.o(25846);
                return 0;
            }
            int size = this.cvc.size();
            AppMethodBeat.o(25846);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(25847);
            if (this.cvc != null) {
                ewk ewk = this.cvc.get(i2);
                AppMethodBeat.o(25847);
                return ewk;
            }
            AppMethodBeat.o(25847);
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1447a aVar;
            AppMethodBeat.i(25848);
            if (view == null) {
                view = ((LayoutInflater) this.ywT.getSystemService("layout_inflater")).inflate(R.layout.ax1, viewGroup, false);
                aVar = new C1447a(this, (byte) 0);
                aVar.ywX = (CdnImageView) view.findViewById(R.id.g83);
                aVar.gxs = (TextView) view.findViewById(R.id.g87);
                aVar.ywY = (TextView) view.findViewById(R.id.g88);
                aVar.hXK = (TextView) view.findViewById(R.id.g7y);
                aVar.hPW = (TextView) view.findViewById(R.id.g7z);
                aVar.ywZ = (Button) view.findViewById(R.id.g7x);
                view.setTag(aVar);
            } else {
                aVar = (C1447a) view.getTag();
            }
            ewk ewk = (ewk) getItem(i2);
            if (ewk == null) {
                AppMethodBeat.o(25848);
            } else {
                aVar.gxs.setText(ewk.Title);
                aVar.ywY.setText(ewk.MJz);
                aVar.hPW.setText(ewk.Desc);
                aVar.hXK.setText(ewk.xJH);
                aVar.ywX.setVisibility(0);
                aVar.ywX.setUrl(ewk.Nuh);
                if (ewk.KHa == 0) {
                    aVar.ywZ.setEnabled(true);
                } else {
                    aVar.ywZ.setEnabled(false);
                }
                aVar.ywZ.setTag(Integer.valueOf(i2));
                aVar.ywZ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(25845);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        final ewk ewk = (ewk) a.this.getItem(((Integer) view.getTag()).intValue());
                        if (ewk == null || Util.isNullOrNil(ewk.ProductID)) {
                            Log.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(25845);
                            return;
                        }
                        a.this.ywT.ywR.start();
                        a.this.ywT.ywR.ysa++;
                        a.this.ywT.ywR.yse = ewk.ProductID;
                        h.a((Context) a.this.ywT, a.this.ywT.getString(R.string.e8v, new Object[]{ewk.MJz, ewk.Title}), a.this.ywT.getString(R.string.e8w), a.this.ywT.getString(R.string.e8t), a.this.ywT.getString(R.string.e8u), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(25843);
                                a.this.ywT.ywR.ysb++;
                                IPCallPackageUI.a(a.this.ywT, ewk.ProductID);
                                AppMethodBeat.o(25843);
                            }
                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a.AnonymousClass1.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(25844);
                                a.this.ywT.ywR.ysc++;
                                a.this.ywT.ywR.finish();
                                AppMethodBeat.o(25844);
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(25845);
                    }
                });
                AppMethodBeat.o(25848);
            }
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI$a$a  reason: collision with other inner class name */
        class C1447a {
            TextView gxs;
            TextView hPW;
            TextView hXK;
            CdnImageView ywX;
            TextView ywY;
            Button ywZ;

            private C1447a() {
            }

            /* synthetic */ C1447a(a aVar, byte b2) {
                this();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013b  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r10, int r11, java.lang.String r12, com.tencent.mm.ak.q r13) {
        /*
        // Method dump skipped, instructions count: 443
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    static /* synthetic */ void a(IPCallPackageUI iPCallPackageUI, String str) {
        AppMethodBeat.i(25855);
        Log.i("MicroMsg.IPCallPackageUI", "startPurchasePackage productID:%s", str);
        if (iPCallPackageUI.ywN == null) {
            AppCompatActivity context = iPCallPackageUI.getContext();
            iPCallPackageUI.getString(R.string.zb);
            iPCallPackageUI.ywN = h.a((Context) context, iPCallPackageUI.getString(R.string.e92), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        } else {
            iPCallPackageUI.ywN.show();
        }
        iPCallPackageUI.ywQ = new j(str);
        bg.azz().a(iPCallPackageUI.ywQ, 0);
        AppMethodBeat.o(25855);
    }
}
