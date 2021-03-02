package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.exdevice.g.b.a.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI extends MMActivity {
    private String mAppName;
    private ArrayList<e> rIl;
    private boolean rIm;
    private ListView rIn;
    private a rIo;
    private final int rIp = 30;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        ArrayList<e> arrayList;
        AppMethodBeat.i(24044);
        super.onCreate(bundle);
        this.mAppName = getIntent().getStringExtra("app_username");
        String stringExtra = getIntent().getStringExtra("key_rank_info");
        String stringExtra2 = getIntent().getStringExtra("key_rank_semi");
        this.rIm = getIntent().getBooleanExtra("key_is_like_read_only", false);
        if (!Util.isNullOrNil(stringExtra)) {
            String str = this.mAppName;
            Log.d("MicroMsg.ExdeviceMsgXmlParser", stringExtra);
            if (Util.isNullOrNil(stringExtra)) {
                Log.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
            } else {
                k.b aD = k.b.aD(stringExtra, stringExtra2);
                if (aD != null) {
                    Map<String, String> map = aD.iwG;
                    ArrayList<e> arrayList2 = new ArrayList<>();
                    if (map != null && !map.isEmpty()) {
                        int i2 = 0;
                        while (true) {
                            String str2 = map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".username");
                            if (Util.isNullOrNil(str2)) {
                                break;
                            }
                            String str3 = map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".rankid");
                            String str4 = map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".liketip");
                            StringBuilder sb = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
                            String valueOf = i2 == 0 ? "" : Integer.valueOf(i2);
                            e eVar = new e();
                            eVar.field_appusername = str;
                            eVar.field_rankID = str3;
                            eVar.field_username = str2;
                            eVar.field_timestamp = Util.getInt(map.get(sb.append(valueOf).append(".timestamp").toString()), 0);
                            eVar.field_liketips = str4;
                            arrayList2.add(eVar);
                            i2++;
                        }
                        Log.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", Integer.valueOf(i2));
                        arrayList = arrayList2;
                        this.rIl = arrayList;
                    }
                }
            }
            arrayList = null;
            this.rIl = arrayList;
        } else {
            String stringExtra3 = getIntent().getStringExtra("rank_id");
            if (!Util.isNullOrNil(stringExtra3)) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            this.rIl = ad.cKQ().anG(stringExtra3);
        }
        this.rIn = (ListView) findViewById(R.id.c5v);
        this.rIn.setEmptyView(findViewById(R.id.c2g));
        this.rIo = new a();
        this.rIn.setAdapter((ListAdapter) this.rIo);
        if (!this.rIm) {
            this.rIn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI.AnonymousClass3 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(24039);
                    b bVar = new b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    e eVar = (e) ExdeviceLikeUI.this.rIo.getItem(i2);
                    Intent intent = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
                    intent.putExtra("app_username", eVar.field_appusername);
                    intent.putExtra("rank_id", eVar.field_rankID);
                    intent.putExtra("device_type", 1);
                    ExdeviceLikeUI exdeviceLikeUI = ExdeviceLikeUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(exdeviceLikeUI, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    exdeviceLikeUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(exdeviceLikeUI, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ExdeviceLikeUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(24039);
                }
            });
        }
        this.rIn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(24040);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                e eVar = (e) ExdeviceLikeUI.this.rIl.get(i2);
                Intent intent = new Intent();
                intent.putExtra("rank_id", eVar.field_rankID);
                intent.putExtra("device_type", 1);
                intent.putExtra("locate_to_username", eVar.field_username);
                intent.putExtra("app_username", aa.getDisplayName("gh_43f2581f6fd6"));
                c.b(ExdeviceLikeUI.this, "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(24040);
            }
        });
        setMMTitle(R.string.c0j);
        if (!this.rIm) {
            addTextOptionMenu(0, getString(R.string.c0h), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(24037);
                    Intent intent = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
                    intent.putExtra("app_username", ExdeviceLikeUI.this.mAppName);
                    intent.putExtra("rank_id", "#");
                    intent.putExtra("key_is_latest", true);
                    intent.putExtra("device_type", 1);
                    ExdeviceLikeUI exdeviceLikeUI = ExdeviceLikeUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(exdeviceLikeUI, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    exdeviceLikeUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(exdeviceLikeUI, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ExdeviceLikeUI.this.finish();
                    AppMethodBeat.o(24037);
                    return false;
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24038);
                ExdeviceLikeUI.this.finish();
                AppMethodBeat.o(24038);
                return false;
            }
        });
        AppMethodBeat.o(24044);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a4p;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(24041);
            if (ExdeviceLikeUI.this.rIl == null) {
                AppMethodBeat.o(24041);
                return 0;
            }
            int size = ExdeviceLikeUI.this.rIl.size();
            AppMethodBeat.o(24041);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(24042);
            Object obj = ExdeviceLikeUI.this.rIl.get(i2);
            AppMethodBeat.o(24042);
            return obj;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1001a aVar;
            View view2;
            AppMethodBeat.i(24043);
            e eVar = (e) ExdeviceLikeUI.this.rIl.get(i2);
            if (view == null) {
                if (ExdeviceLikeUI.this.rIm) {
                    view2 = LayoutInflater.from(ExdeviceLikeUI.this).inflate(R.layout.a4o, viewGroup, false);
                } else {
                    view2 = LayoutInflater.from(ExdeviceLikeUI.this).inflate(R.layout.a4n, viewGroup, false);
                }
                C1001a aVar2 = new C1001a();
                aVar2.gyr = (ImageView) view2.findViewById(R.id.c5k);
                aVar2.rIr = (NoMeasuredTextView) view2.findViewById(R.id.c6h);
                aVar2.jBS = (TextView) view2.findViewById(R.id.c6b);
                aVar2.timeTv = (TextView) view2.findViewById(R.id.c6a);
                aVar2.rIr.setTextSize(0, ExdeviceLikeUI.this.getResources().getDimension(R.dimen.is));
                aVar2.rIr.setTextColor(ExdeviceLikeUI.this.getResources().getColor(R.color.a2x));
                aVar2.rIr.setSingleLine(true);
                aVar2.rIr.setShouldEllipsize(true);
                view2.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1001a) view.getTag();
                view2 = view;
            }
            a.b.z(aVar.gyr, eVar.field_username);
            aVar.rIr.setText(l.b(ExdeviceLikeUI.this, aa.getDisplayName(eVar.field_username), aVar.rIr.getTextSize()));
            if (!Util.isNullOrNil(eVar.field_liketips) && aVar.jBS != null) {
                aVar.jBS.setVisibility(0);
                aVar.jBS.setText(eVar.field_liketips);
            } else if (aVar.jBS != null) {
                aVar.jBS.setVisibility(8);
            }
            int currentTimeMillis = (int) ((((System.currentTimeMillis() / 1000) - ((long) eVar.field_timestamp)) / 60) + 1);
            if (currentTimeMillis <= 30) {
                aVar.timeTv.setText(ExdeviceLikeUI.this.getString(R.string.c0i, new Object[]{Integer.valueOf(currentTimeMillis)}));
            } else {
                aVar.timeTv.setText(f.c(ExdeviceLikeUI.this, ((long) eVar.field_timestamp) * 1000, true));
            }
            AppMethodBeat.o(24043);
            return view2;
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI$a$a  reason: collision with other inner class name */
        class C1001a {
            ImageView gyr;
            TextView jBS;
            NoMeasuredTextView rIr;
            TextView timeTv;

            C1001a() {
            }
        }
    }
}
