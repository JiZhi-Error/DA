package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandNotifySettingsUI extends MMActivity {
    private q Fxt;
    private a Oxq;
    private DataSetObserver Tr;
    private String kIg;
    private ListView mListView;
    private IListener<o> nRQ = new IListener<o>() {
        /* class com.tencent.mm.ui.AppBrandNotifySettingsUI.AnonymousClass1 */

        {
            AppMethodBeat.i(232438);
            this.__eventId = o.class.getName().hashCode();
            AppMethodBeat.o(232438);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(o oVar) {
            AppMethodBeat.i(232439);
            o oVar2 = oVar;
            if (AppBrandNotifySettingsUI.this.Oxq == null) {
                AppMethodBeat.o(232439);
            } else {
                Log.i("MicroMsg.AppBrandNotifySettingsUI", "change notify preferent status by event");
                com.tencent.mm.plugin.appbrand.service.q qVar = (com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class);
                for (int i2 = 0; i2 < AppBrandNotifySettingsUI.this.Oxq.getCount(); i2++) {
                    a.C2071a akG = AppBrandNotifySettingsUI.this.Oxq.akG(i2);
                    if (akG != null) {
                        WxaAttributes Xk = qVar.Xk(akG.username);
                        if (Xk == null) {
                            Log.w("MicroMsg.AppBrandNotifySettingsUI", "can't find local record, username:%s", akG.username);
                        } else if (Util.nullAsNil(Xk.field_appId).equals(oVar2.dCr.appId)) {
                            akG.OxA = oVar2.dCr.dCs;
                        }
                    }
                }
                AppBrandNotifySettingsUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.ui.AppBrandNotifySettingsUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(232437);
                        AppBrandNotifySettingsUI.this.Oxq.notifyDataSetChanged();
                        AppMethodBeat.o(232437);
                    }
                });
                AppMethodBeat.o(232439);
            }
            return true;
        }
    };
    private int rGT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandNotifySettingsUI() {
        AppMethodBeat.i(232454);
        AppMethodBeat.o(232454);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.gt;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(232455);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.kIg = intent.getStringExtra("report_session_id");
        String stringExtra = intent.getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra)) {
            setMMTitle(R.string.axi);
        } else {
            setMMTitle(stringExtra);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.AppBrandNotifySettingsUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(232440);
                AppBrandNotifySettingsUI.this.finish();
                AppMethodBeat.o(232440);
                return false;
            }
        });
        this.mListView = (ListView) findViewById(R.id.ed2);
        this.Oxq = new a(getLayoutInflater());
        this.mListView.setAdapter((ListAdapter) this.Oxq);
        getString(R.string.zb);
        this.Fxt = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.AppBrandNotifySettingsUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(232441);
                AppBrandNotifySettingsUI.this.finish();
                AppMethodBeat.o(232441);
            }
        });
        this.Tr = new DataSetObserver() {
            /* class com.tencent.mm.ui.AppBrandNotifySettingsUI.AnonymousClass4 */

            public final void onChanged() {
                AppMethodBeat.i(232442);
                AppBrandNotifySettingsUI.this.findViewById(R.id.eco).setVisibility(AppBrandNotifySettingsUI.this.Oxq.isEmpty() ? 4 : 0);
                AppMethodBeat.o(232442);
            }
        };
        this.Oxq.registerDataSetObserver(this.Tr);
        g.aAf();
        this.rGT = com.tencent.mm.kernel.a.getUin();
        c.a aVar = c.iIo;
        aa.a(c.a.aXF(), new aa.a() {
            /* class com.tencent.mm.ui.AppBrandNotifySettingsUI.AnonymousClass6 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(232445);
                Log.d("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (AppBrandNotifySettingsUI.this.Fxt != null) {
                    AppBrandNotifySettingsUI.this.Fxt.dismiss();
                }
                if (i2 == 0 && i3 == 0) {
                    final bzh bzh = (bzh) dVar.iLL.iLR;
                    if (bzh.MeZ == null) {
                        Log.e("MicroMsg.AppBrandNotifySettingsUI", "wxa_msg_config_list not exist");
                        AppMethodBeat.o(232445);
                    } else {
                        AppBrandNotifySettingsUI.this.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.ui.AppBrandNotifySettingsUI.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(232444);
                                if (bzh.MeZ == null) {
                                    Log.i("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo, configList is null");
                                    AppMethodBeat.o(232444);
                                    return;
                                }
                                AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this, bzh.MeZ);
                                AppBrandNotifySettingsUI.bK(bzh.MeZ);
                                AppMethodBeat.o(232444);
                            }
                        });
                        AppMethodBeat.o(232445);
                    }
                } else {
                    u.makeText(AppBrandNotifySettingsUI.this, (int) R.string.fh_, 0).show();
                    AppMethodBeat.o(232445);
                }
                return 0;
            }
        }, true, this);
        EventCenter.instance.addListener(this.nRQ);
        AppMethodBeat.o(232455);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(232456);
        com.tencent.mm.plugin.appbrand.service.q qVar = (com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class);
        final LinkedList<fdy> linkedList = new LinkedList<>();
        LinkedList<a.C2071a> linkedList2 = this.Oxq.Oxw;
        if (linkedList2 != null && !linkedList2.isEmpty()) {
            Iterator<a.C2071a> it = linkedList2.iterator();
            while (it.hasNext()) {
                a.C2071a next = it.next();
                fdy fdy = new fdy();
                WxaAttributes Xk = qVar.Xk(next.username);
                if (Xk == null) {
                    Log.i("MicroMsg.AppBrandNotifySettingsUI", "get attribute fail, username: %s", next.username);
                } else {
                    String str = Xk.field_appId;
                    int i2 = next.OxA ? 1 : 0;
                    fdy.dNI = str;
                    fdy.status = i2;
                    linkedList.add(fdy);
                    Log.d("MicroMsg.AppBrandNotifySettingsUI", "stev report(%s), eventId : %d, appId %s, status %d", 19724, 5, str, Integer.valueOf(i2));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(19724, 1, 5, 0, 0, 0, null, 0, 0, 0, str, null, null, null, 0, null, null, 0, null, null, this.kIg);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            dwq dwq = new dwq();
            dwq.MeZ = linkedList;
            dwq.scene = 1;
            d.a aVar = com.tencent.mm.modelappbrand.d.iIp;
            aa.a(d.a.a(dwq), new aa.a() {
                /* class com.tencent.mm.ui.AppBrandNotifySettingsUI.AnonymousClass5 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(232443);
                    Log.d("MicroMsg.AppBrandNotifySettingsUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        AppBrandNotifySettingsUI.bK(linkedList);
                        AppMethodBeat.o(232443);
                    } else {
                        u.makeText(AppBrandNotifySettingsUI.this, (int) R.string.fhl, 0).show();
                        AppMethodBeat.o(232443);
                    }
                    return 0;
                }
            }, true);
        }
        this.Oxq.unregisterDataSetObserver(this.Tr);
        EventCenter.instance.removeListener(this.nRQ);
        super.onDestroy();
        AppMethodBeat.o(232456);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        LinkedList<C2071a> Oxv = new LinkedList<>();
        LinkedList<C2071a> Oxw = new LinkedList<>();
        private b.AbstractC2072a Oxx = new b.AbstractC2072a() {
            /* class com.tencent.mm.ui.AppBrandNotifySettingsUI.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.AppBrandNotifySettingsUI.a.b.AbstractC2072a
            public final void a(C2071a aVar, boolean z) {
                AppMethodBeat.i(232446);
                if (aVar == null) {
                    AppMethodBeat.o(232446);
                    return;
                }
                Iterator it = a.this.Oxv.iterator();
                while (it.hasNext()) {
                    C2071a aVar2 = (C2071a) it.next();
                    if (aVar2 != null && Util.nullAsNil(aVar2.username).equals(aVar.username)) {
                        if (aVar.OxA != z) {
                            a.this.Oxw.add(aVar2);
                            AppMethodBeat.o(232446);
                            return;
                        }
                        a.this.Oxw.remove(aVar2);
                        AppMethodBeat.o(232446);
                        return;
                    }
                }
                AppMethodBeat.o(232446);
            }
        };
        private com.tencent.mm.av.a.a.c Oxy;
        private LayoutInflater mLayoutInflater;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(232453);
            C2071a akG = akG(i2);
            AppMethodBeat.o(232453);
            return akG;
        }

        public a(LayoutInflater layoutInflater) {
            AppMethodBeat.i(232449);
            this.mLayoutInflater = layoutInflater;
            c.a aVar = new c.a();
            aVar.iaT = true;
            aVar.jbu = com.tencent.mm.modelappbrand.a.a.aXX();
            this.Oxy = aVar.bdv();
            AppMethodBeat.o(232449);
        }

        public final int getCount() {
            AppMethodBeat.i(232450);
            int size = this.Oxv.size();
            AppMethodBeat.o(232450);
            return size;
        }

        public final C2071a akG(int i2) {
            AppMethodBeat.i(232451);
            C2071a aVar = this.Oxv.get(i2);
            AppMethodBeat.o(232451);
            return aVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(232452);
            C2071a akG = akG(i2);
            if (view == null) {
                view = this.mLayoutInflater.inflate(R.layout.gu, viewGroup, false);
                cVar = new c((byte) 0);
                cVar.gyr = (ImageView) view.findViewById(R.id.wo);
                cVar.titleTv = (TextView) view.findViewById(R.id.ipq);
                cVar.OxF = (MMSwitchBtn) view.findViewById(R.id.t8);
                cVar.jWr = view.findViewById(R.id.t_);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            com.tencent.mm.av.q.bcV().a(akG.url, cVar.gyr, this.Oxy);
            cVar.titleTv.setText(akG.title);
            cVar.OxF.setCheck(akG.OxA);
            if (cVar.OxF.getTag() == null) {
                b bVar = new b((byte) 0);
                bVar.OxB = akG;
                bVar.OxC = this.Oxx;
                cVar.OxF.setSwitchListener(bVar.OxD);
                cVar.OxF.setTag(bVar);
            } else {
                ((b) cVar.OxF.getTag()).OxB = akG;
            }
            if (i2 == this.Oxv.size() - 1) {
                cVar.jWr.setVisibility(8);
            } else {
                cVar.jWr.setVisibility(0);
            }
            AppMethodBeat.o(232452);
            return view;
        }

        static class c {
            MMSwitchBtn OxF;
            ImageView gyr;
            View jWr;
            TextView titleTv;

            private c() {
            }

            /* synthetic */ c(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.ui.AppBrandNotifySettingsUI$a$a  reason: collision with other inner class name */
        public static class C2071a {
            boolean OxA;
            String title;
            String url;
            String username;

            private C2071a() {
            }

            /* synthetic */ C2071a(byte b2) {
                this();
            }
        }

        static class b {
            C2071a OxB;
            AbstractC2072a OxC;
            MMSwitchBtn.a OxD;

            /* renamed from: com.tencent.mm.ui.AppBrandNotifySettingsUI$a$b$a  reason: collision with other inner class name */
            public interface AbstractC2072a {
                void a(C2071a aVar, boolean z);
            }

            private b() {
                AppMethodBeat.i(232448);
                this.OxD = new MMSwitchBtn.a() {
                    /* class com.tencent.mm.ui.AppBrandNotifySettingsUI.a.b.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
                    public final void onStatusChange(boolean z) {
                        AppMethodBeat.i(232447);
                        if (b.this.OxC != null) {
                            b.this.OxC.a(b.this.OxB, z);
                        }
                        AppMethodBeat.o(232447);
                    }
                };
                AppMethodBeat.o(232448);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }
    }

    static /* synthetic */ void bK(LinkedList linkedList) {
        AppMethodBeat.i(232457);
        if (linkedList == null || linkedList.isEmpty()) {
            Log.i("MicroMsg.AppBrandNotifySettingsUI", "saveNotifyMessageResult, configList is null or empty");
            AppMethodBeat.o(232457);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            fdy fdy = (fdy) it.next();
            if (fdy == null) {
                Log.w("MicroMsg.AppBrandNotifySettingsUI", "scene end, item is null");
            } else {
                yj yjVar = new yj();
                yjVar.eeG.appId = fdy.dNI;
                yjVar.eeG.dCs = fdy.status == 0;
                EventCenter.instance.publish(yjVar);
            }
        }
        AppMethodBeat.o(232457);
    }

    static /* synthetic */ void a(AppBrandNotifySettingsUI appBrandNotifySettingsUI, LinkedList linkedList) {
        boolean z;
        AppMethodBeat.i(232458);
        LinkedList linkedList2 = new LinkedList();
        com.tencent.mm.plugin.appbrand.service.q qVar = (com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            fdy fdy = (fdy) it.next();
            a.C2071a aVar = new a.C2071a((byte) 0);
            String str = fdy.dNI;
            WxaAttributes Xl = qVar.Xl(str);
            if (Xl == null) {
                Log.w("MicroMsg.AppBrandNotifySettingsUI", "can't find local record, appId:%s", str);
            } else {
                aVar.username = Xl.field_username;
                aVar.title = Xl.field_nickname;
                aVar.url = Xl.field_brandIconURL;
                if (fdy.status == 0) {
                    z = true;
                } else {
                    z = false;
                }
                aVar.OxA = z;
                linkedList2.add(aVar);
            }
        }
        a aVar2 = appBrandNotifySettingsUI.Oxq;
        aVar2.Oxv.clear();
        if (!linkedList2.isEmpty()) {
            aVar2.Oxv.addAll(linkedList2);
        }
        appBrandNotifySettingsUI.Oxq.notifyDataSetChanged();
        AppMethodBeat.o(232458);
    }
}
