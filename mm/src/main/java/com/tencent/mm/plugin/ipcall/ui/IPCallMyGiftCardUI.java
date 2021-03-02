package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.e.d;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.ewi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;
import junit.framework.Assert;

public class IPCallMyGiftCardUI extends MMActivity implements i {
    private View GQ;
    private ProgressDialog jZH;
    private ListView mListView;
    private d ywA;
    private a ywz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25835);
        super.onCreate(bundle);
        bg.azz().a(288, this);
        setMMTitle(R.string.e8o);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25828);
                IPCallMyGiftCardUI.this.finish();
                AppMethodBeat.o(25828);
                return true;
            }
        });
        addTextOptionMenu(0, getContext().getString(R.string.e8m), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25829);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", IPCallMyGiftCardUI.this.getString(R.string.e6f));
                intent.putExtra("showShare", false);
                c.b(IPCallMyGiftCardUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(25829);
                return true;
            }
        });
        this.GQ = findViewById(R.id.e1m);
        this.mListView = (ListView) findViewById(R.id.e1n);
        this.ywz = new a(this);
        this.mListView.setAdapter((ListAdapter) this.ywz);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.jZH = h.a((Context) context, getString(R.string.e6r), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(25830);
                try {
                    if (IPCallMyGiftCardUI.this.ywA != null) {
                        bg.azz().a(IPCallMyGiftCardUI.this.ywA);
                    }
                    IPCallMyGiftCardUI.this.finish();
                    AppMethodBeat.o(25830);
                } catch (Exception e2) {
                    Log.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", e2.getMessage());
                    AppMethodBeat.o(25830);
                }
            }
        });
        this.ywA = new d();
        bg.azz().a(this.ywA, 0);
        AppMethodBeat.o(25835);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(25836);
        super.onResume();
        AppMethodBeat.o(25836);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25837);
        super.onDestroy();
        bg.azz().b(288, this);
        AppMethodBeat.o(25837);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ax0;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(25838);
        Log.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", Integer.valueOf(i3), str);
        if (qVar instanceof d) {
            if (i2 == 0 && i3 == 0) {
                bxv bxv = ((d) qVar).yru;
                if (this.jZH != null && this.jZH.isShowing()) {
                    this.jZH.dismiss();
                }
                this.ywz.cvc = bxv.Mdt;
                this.ywz.ywD = bxv;
                this.ywz.notifyDataSetChanged();
                if (bxv.Mdt.size() == 0) {
                    this.GQ.setVisibility(0);
                }
                AppMethodBeat.o(25838);
                return;
            }
            if (this.jZH != null && this.jZH.isShowing()) {
                this.jZH.dismiss();
            }
            this.GQ.setVisibility(0);
            Toast.makeText(getContext(), getString(R.string.e6o), 0).show();
        }
        AppMethodBeat.o(25838);
    }

    static class a extends BaseAdapter {
        List<ewi> cvc = null;
        private IPCallMyGiftCardUI ywC = null;
        bxv ywD = null;

        public a(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
            AppMethodBeat.i(25831);
            Assert.assertTrue(true);
            this.ywC = iPCallMyGiftCardUI;
            AppMethodBeat.o(25831);
        }

        public final int getCount() {
            AppMethodBeat.i(25832);
            if (this.cvc == null) {
                AppMethodBeat.o(25832);
                return 0;
            }
            int size = this.cvc.size();
            AppMethodBeat.o(25832);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(25833);
            if (this.cvc != null) {
                ewi ewi = this.cvc.get(i2);
                AppMethodBeat.o(25833);
                return ewi;
            }
            AppMethodBeat.o(25833);
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1446a aVar;
            AppMethodBeat.i(25834);
            if (view == null) {
                view = ((LayoutInflater) this.ywC.getSystemService("layout_inflater")).inflate(R.layout.awz, viewGroup, false);
                aVar = new C1446a(this, (byte) 0);
                aVar.ywE = (TextView) view.findViewById(R.id.bgs);
                aVar.ywF = (TextView) view.findViewById(R.id.bkh);
                aVar.ywG = (TextView) view.findViewById(R.id.c6s);
                aVar.ywH = (CdnImageView) view.findViewById(R.id.dod);
                aVar.ywI = (ImageView) view.findViewById(R.id.blc);
                view.setTag(aVar);
            } else {
                aVar = (C1446a) view.getTag();
            }
            ewi ewi = (ewi) getItem(i2);
            if (ewi == null) {
                AppMethodBeat.o(25834);
            } else {
                if (Util.isNullOrNil(ewi.Nuf)) {
                    aVar.ywE.setVisibility(0);
                    aVar.ywF.setVisibility(0);
                    aVar.ywG.setVisibility(8);
                    aVar.ywE.setText(ewi.MJz);
                    aVar.ywF.setText(ewi.Nue);
                } else {
                    aVar.ywE.setVisibility(8);
                    aVar.ywF.setVisibility(8);
                    aVar.ywG.setVisibility(0);
                    aVar.ywG.setText(ewi.Nuf);
                }
                a.b.a(aVar.ywI, "", 0.5f, false);
                if (!Util.isNullOrNil(ewi.xJE)) {
                    aVar.ywH.setVisibility(0);
                    aVar.ywH.setUrl(ewi.xJE);
                    aVar.ywI.setVisibility(4);
                } else {
                    aVar.ywI.setVisibility(0);
                    aVar.ywH.setVisibility(4);
                }
                AppMethodBeat.o(25834);
            }
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI$a$a  reason: collision with other inner class name */
        class C1446a {
            TextView ywE;
            TextView ywF;
            TextView ywG;
            CdnImageView ywH;
            ImageView ywI;

            private C1446a() {
            }

            /* synthetic */ C1446a(a aVar, byte b2) {
                this();
            }
        }
    }
}
