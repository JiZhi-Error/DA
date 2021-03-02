package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.q;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.protocal.protobuf.epa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceRankDataSourceUI extends MMActivity implements i {
    private ListView mListView;
    private b rKh;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a52;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24196);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24186);
                ExdeviceRankDataSourceUI.a(ExdeviceRankDataSourceUI.this);
                AppMethodBeat.o(24186);
                return true;
            }
        });
        setMMTitle(R.string.ben);
        bg.azz().a(1267, this);
        initView();
        bg.azz().a(new q(), 0);
        AppMethodBeat.o(24196);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(24197);
        this.mListView = (ListView) findViewById(R.id.ed2);
        View inflate = View.inflate(this, R.layout.a54, null);
        View inflate2 = View.inflate(this, R.layout.a53, null);
        this.mListView.addHeaderView(inflate, null, false);
        this.mListView.addFooterView(inflate2, null, false);
        this.rKh = new b();
        this.mListView.setAdapter((ListAdapter) this.rKh);
        ((ScrollView) findViewById(R.id.hcv)).scrollTo(0, 0);
        inflate2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(24187);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ExdeviceRankDataSourceUI.this.startActivityForResult(new Intent(ExdeviceRankDataSourceUI.this.getContext(), ExdeviceAddDataSourceUI.class), 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24187);
            }
        });
        AppMethodBeat.o(24197);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(24199);
        super.onDestroy();
        bg.azz().b(1267, this);
        AppMethodBeat.o(24199);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(24200);
        Log.d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 1 && i3 == -1 && intent != null) {
            long longExtra = intent.getLongExtra("device_mac", 0);
            intent.getIntExtra("step", 0);
            if (longExtra == 0) {
                Log.e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
                AppMethodBeat.o(24200);
                return;
            }
            String Dj = com.tencent.mm.plugin.exdevice.k.b.Dj(longExtra);
            if (Dj == null) {
                Log.e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", Dj);
                AppMethodBeat.o(24200);
                return;
            } else if (this.rKh.anU(Dj) != null) {
                Log.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                AppMethodBeat.o(24200);
                return;
            } else {
                com.tencent.mm.plugin.exdevice.i.b Di = ad.cKL().Di(longExtra);
                if (Di == null) {
                    Log.w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", Long.valueOf(longExtra));
                    AppMethodBeat.o(24200);
                    return;
                } else if (this.rKh.gf(Di.field_deviceID, Di.field_deviceType) != null) {
                    Log.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                    AppMethodBeat.o(24200);
                    return;
                } else {
                    bg.azz().a(1267, this);
                    bg.azz().a(new q(), 0);
                }
            }
        }
        AppMethodBeat.o(24200);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(24201);
        if (qVar == null) {
            Log.e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
            AppMethodBeat.o(24201);
            return;
        }
        if (qVar instanceof q) {
            bg.azz().b(1267, this);
            if (i2 == 0 && i3 == 0) {
                bvo bvo = (bvo) ((q) qVar).rr.iLL.iLR;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bvo.LTo != null ? bvo.LTo.size() : 0);
                Log.d("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, get sport device list succ.(size : %d)", objArr);
                final LinkedList<epa> linkedList = bvo.LTo;
                runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(24188);
                        b bVar = ExdeviceRankDataSourceUI.this.rKh;
                        List<epa> list = linkedList;
                        bVar.rKm.clear();
                        if (!(list == null || list.size() == 0)) {
                            for (epa epa : list) {
                                if (epa != null) {
                                    bVar.rKm.add(ExdeviceRankDataSourceUI.a(epa));
                                }
                            }
                        }
                        ExdeviceRankDataSourceUI.this.rKh.notifyDataSetChanged();
                        AppMethodBeat.o(24188);
                    }
                });
            }
        }
        AppMethodBeat.o(24201);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String mac;
        epa rKk;
        com.tencent.mm.plugin.exdevice.i.b rKl;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends BaseAdapter {
        private c rFu;
        List<a> rKm = new LinkedList();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(24195);
            a GJ = GJ(i2);
            AppMethodBeat.o(24195);
            return GJ;
        }

        public b() {
            AppMethodBeat.i(24189);
            c.a aVar = new c.a();
            aVar.jbq = R.drawable.c69;
            this.rFu = aVar.bdv();
            AppMethodBeat.o(24189);
        }

        public final synchronized a anU(String str) {
            a aVar;
            AppMethodBeat.i(24190);
            if (!Util.isNullOrNil(str)) {
                Iterator<a> it = this.rKm.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    aVar = it.next();
                    if (str.equals(aVar.mac)) {
                        AppMethodBeat.o(24190);
                        break;
                    }
                }
            }
            aVar = null;
            AppMethodBeat.o(24190);
            return aVar;
        }

        public final synchronized a gf(String str, String str2) {
            a aVar;
            AppMethodBeat.i(24191);
            Iterator<a> it = this.rKm.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    AppMethodBeat.o(24191);
                    break;
                }
                aVar = it.next();
                if (aVar != null && ExdeviceRankDataSourceUI.a(str, str2, aVar.rKk)) {
                    AppMethodBeat.o(24191);
                    break;
                }
            }
            return aVar;
        }

        public final int getCount() {
            AppMethodBeat.i(24192);
            int size = this.rKm.size();
            AppMethodBeat.o(24192);
            return size;
        }

        private a GJ(int i2) {
            AppMethodBeat.i(24193);
            a aVar = this.rKm.get(i2);
            AppMethodBeat.o(24193);
            return aVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(24194);
            a GJ = GJ(i2);
            if (view == null) {
                a aVar2 = new a((byte) 0);
                view = View.inflate(viewGroup.getContext(), R.layout.a51, null);
                aVar2.kgE = (TextView) view.findViewById(R.id.ft9);
                aVar2.nnL = (ImageView) view.findViewById(R.id.dtb);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            String a2 = ExdeviceRankDataSourceUI.a(GJ);
            Log.d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i2), a2, GJ.mac);
            aVar.kgE.setText(a2);
            com.tencent.mm.av.q.bcV().a(GJ.rKk.IconUrl, aVar.nnL, this.rFu);
            AppMethodBeat.o(24194);
            return view;
        }

        static class a {
            TextView kgE;
            ImageView nnL;

            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(24198);
        finish();
        AppMethodBeat.o(24198);
    }

    static /* synthetic */ void a(ExdeviceRankDataSourceUI exdeviceRankDataSourceUI) {
        AppMethodBeat.i(24202);
        exdeviceRankDataSourceUI.finish();
        AppMethodBeat.o(24202);
    }

    static /* synthetic */ a a(epa epa) {
        AppMethodBeat.i(24203);
        a aVar = new a((byte) 0);
        aVar.rKl = null;
        if (epa == null) {
            aVar.rKk = null;
        } else {
            aVar.rKk = epa;
        }
        AppMethodBeat.o(24203);
        return aVar;
    }

    static /* synthetic */ boolean a(String str, String str2, epa epa) {
        AppMethodBeat.i(24204);
        if (epa == null || str == null || str2 == null || !str.equals(epa.Lox) || !str2.equals(epa.KLO)) {
            AppMethodBeat.o(24204);
            return false;
        }
        AppMethodBeat.o(24204);
        return true;
    }

    static /* synthetic */ String a(a aVar) {
        AppMethodBeat.i(24205);
        if (aVar == null || aVar.rKk == null) {
            AppMethodBeat.o(24205);
            return "";
        } else if (!Util.isNullOrNil(aVar.rKk.oTI)) {
            String str = aVar.rKk.oTI;
            AppMethodBeat.o(24205);
            return str;
        } else {
            com.tencent.mm.plugin.exdevice.i.b bVar = aVar.rKl;
            String str2 = null;
            if (bVar == null) {
                AppMethodBeat.o(24205);
                return "";
            }
            if (!Util.isNullOrNil(bVar.fMb)) {
                str2 = bVar.fMb;
            } else if (!Util.isNullOrNil(bVar.fMc)) {
                str2 = bVar.fMc;
            } else if (bVar.field_mac != 0) {
                str2 = com.tencent.mm.plugin.exdevice.k.b.Dj(bVar.field_mac);
            } else if (!Util.isNullOrNil(bVar.field_deviceID)) {
                str2 = bVar.field_deviceID;
            }
            String nullAsNil = Util.nullAsNil(str2);
            AppMethodBeat.o(24205);
            return nullAsNil;
        }
    }
}
