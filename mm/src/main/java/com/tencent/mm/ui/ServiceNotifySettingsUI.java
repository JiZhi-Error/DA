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
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.msgsubscription.api.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI extends MMActivity implements i {
    private q Fxt;
    private a OKI;
    private String OKJ;
    private DataSetObserver Tr;
    private MMSwitchBtn jBx;
    private ListView mListView;
    private int mMode;
    private String mSceneId;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqc;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33714);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mMode = intent.getIntExtra("mode", 0);
        this.mSceneId = intent.getStringExtra("scene_id");
        this.OKJ = intent.getStringExtra("from_scene");
        intent.putExtra("scene_id", this.mSceneId);
        String stringExtra = intent.getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra)) {
            setMMTitle(R.string.fhu);
        } else {
            setMMTitle(stringExtra);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.ServiceNotifySettingsUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33702);
                ServiceNotifySettingsUI.this.finish();
                AppMethodBeat.o(33702);
                return false;
            }
        });
        this.jBx = (MMSwitchBtn) findViewById(R.id.b0m);
        this.mListView = (ListView) findViewById(R.id.ed2);
        ((TextView) findViewById(R.id.eco)).setText(this.mMode == 1 ? R.string.fh3 : R.string.fgw);
        ((TextView) findViewById(R.id.ipf)).setText(this.mMode == 1 ? R.string.fh4 : R.string.fh6);
        this.OKI = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
        this.mListView.setAdapter((ListAdapter) this.OKI);
        this.Tr = new DataSetObserver() {
            /* class com.tencent.mm.ui.ServiceNotifySettingsUI.AnonymousClass2 */

            public final void onChanged() {
                AppMethodBeat.i(232711);
                ServiceNotifySettingsUI.this.findViewById(R.id.eco).setVisibility(ServiceNotifySettingsUI.this.OKI.isEmpty() ? 4 : 0);
                AppMethodBeat.o(232711);
            }
        };
        this.OKI.registerDataSetObserver(this.Tr);
        if (this.mMode == 1) {
            bg.azz().a(1145, this);
            bg.azz().a(new r(12), 0);
            getString(R.string.zb);
            this.Fxt = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.ServiceNotifySettingsUI.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(232712);
                    ServiceNotifySettingsUI.this.finish();
                    AppMethodBeat.o(232712);
                }
            });
        }
        this.jBx.setCheck(gJC());
        AppMethodBeat.o(33714);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        final int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7 = 3;
        AppMethodBeat.i(33715);
        bg.azz().b(1145, this);
        final boolean gJC = gJC();
        final boolean z2 = this.jBx.QDw != gJC;
        final LinkedList linkedList = new LinkedList();
        if (z2) {
            eft eft = new eft();
            if (this.jBx.QDw) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            eft.NfL = i3;
            if (this.mMode == 1) {
                i4 = 2;
            } else {
                i4 = 0;
            }
            eft.oUv = i4;
            linkedList.add(eft);
            if (!gJC) {
                z = true;
            } else {
                z = false;
            }
            ar.a aVar = ar.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
            if (this.mMode == 1) {
                aVar = ar.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
            }
            bg.aVF();
            c.azQ().set(aVar, Boolean.valueOf(z));
            EventCenter.instance.publish(new ri());
            if (this.mMode == 1) {
                if (eft.NfL == 1) {
                    i6 = 3;
                } else {
                    i6 = 2;
                }
                Log.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", 13798, Integer.valueOf(i6), this.mSceneId);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13798, Integer.valueOf(i6), "", 0, this.mSceneId, Long.valueOf(Util.nowSecond()));
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13796, Integer.valueOf(eft.NfL == 1 ? 11 : 10), "", "", 0, Long.valueOf(Util.nowSecond()));
            }
            if ("scene_service_notify_conversation".equals(this.OKJ)) {
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[8];
                objArr[0] = 3;
                objArr[1] = null;
                objArr[2] = Long.valueOf(Util.nowSecond());
                objArr[3] = null;
                objArr[4] = null;
                objArr[5] = 0;
                objArr[6] = 0;
                if (this.jBx.QDw) {
                    i5 = 1;
                } else {
                    i5 = 2;
                }
                objArr[7] = Integer.valueOf(i5);
                hVar.a(21825, objArr);
            }
        }
        if (this.mMode == 1) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        LinkedList<a.C2073a> linkedList2 = this.OKI.OKP;
        if (linkedList2 != null && !linkedList2.isEmpty()) {
            if (this.mMode != 1) {
                i7 = 1;
            }
            Iterator<a.C2073a> it = linkedList2.iterator();
            while (it.hasNext()) {
                a.C2073a next = it.next();
                eft eft2 = new eft();
                eft2.NfM = next.username;
                eft2.oUv = i7;
                eft2.NfL = 1;
                linkedList.add(eft2);
                yw ywVar = new yw();
                ywVar.efe.dCl = next.username;
                ywVar.efe.action = 2;
                ywVar.efe.option = i2;
                EventCenter.instance.publish(ywVar);
            }
        }
        if (!linkedList.isEmpty()) {
            bg.azz().a(1176, new i() {
                /* class com.tencent.mm.ui.ServiceNotifySettingsUI.AnonymousClass4 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(33705);
                    bg.azz().b(1176, this);
                    Log.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        b bVar = b.jza;
                        com.tencent.mm.msgsubscription.b.a Ru = b.Ru("name_wxa");
                        for (int i4 = 0; i4 < linkedList.size(); i4++) {
                            eft eft = (eft) linkedList.get(i4);
                            if (!(Ru == null || eft == null || Util.isNullOrNil(eft.NfM))) {
                                Ru.Z(eft.NfM, eft.NfL == 1);
                            }
                        }
                        AppMethodBeat.o(33705);
                        return;
                    }
                    u.makeText(ServiceNotifySettingsUI.this, (int) R.string.fhl, 0).show();
                    if (z2) {
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(gJC));
                        EventCenter.instance.publish(new ri());
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        yw ywVar = new yw();
                        ywVar.efe.dCl = ((eft) it.next()).NfM;
                        ywVar.efe.action = 1;
                        ywVar.efe.option = i2;
                        EventCenter.instance.publish(ywVar);
                    }
                    AppMethodBeat.o(33705);
                }
            });
            bg.azz().a(new com.tencent.mm.modelappbrand.q(linkedList), 0);
        }
        this.OKI.unregisterDataSetObserver(this.Tr);
        super.onDestroy();
        AppMethodBeat.o(33715);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(33716);
        if (this.Fxt != null) {
            this.Fxt.dismiss();
        }
        Log.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            final buy aXQ = ((r) qVar).aXQ();
            if (this.mMode == 1) {
                this.jBx.setCheck(aXQ.Mbo);
            } else {
                this.jBx.setCheck(aXQ.KPb);
            }
            runOnUiThread(new Runnable() {
                /* class com.tencent.mm.ui.ServiceNotifySettingsUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(33706);
                    if (ServiceNotifySettingsUI.this.mMode == 1) {
                        ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, aXQ.Mbp);
                    }
                    AppMethodBeat.o(33706);
                }
            });
            AppMethodBeat.o(33716);
            return;
        }
        u.makeText(this, (int) R.string.fh_, 0).show();
        AppMethodBeat.o(33716);
    }

    private boolean gJC() {
        AppMethodBeat.i(33717);
        ar.a aVar = ar.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
        if (this.mMode == 1) {
            aVar = ar.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
        }
        bg.aVF();
        boolean z = c.azQ().getBoolean(aVar, true);
        AppMethodBeat.o(33717);
        return z;
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        LinkedList<C2073a> OKP = new LinkedList<>();
        LinkedList<C2073a> Oxv = new LinkedList<>();
        private com.tencent.mm.av.a.a.c Oxy;
        private Context mContext;
        private LayoutInflater mLayoutInflater;
        private int mMode;
        private View.OnClickListener mOnClickListener;
        private String mSceneId;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(33713);
            C2073a alm = alm(i2);
            AppMethodBeat.o(33713);
            return alm;
        }

        public a(Context context, LayoutInflater layoutInflater, final int i2, String str) {
            AppMethodBeat.i(33709);
            this.mContext = context;
            this.mMode = i2;
            this.mSceneId = str;
            this.mLayoutInflater = layoutInflater;
            this.mOnClickListener = new View.OnClickListener() {
                /* class com.tencent.mm.ui.ServiceNotifySettingsUI.a.AnonymousClass1 */

                public final void onClick(View view) {
                    int i2;
                    int i3;
                    AppMethodBeat.i(33708);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    final String str = (String) view.getTag();
                    if (TextUtils.isEmpty(str)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(33708);
                        return;
                    }
                    Context context = view.getContext();
                    if (i2 == 1) {
                        i2 = R.string.fhf;
                    } else {
                        i2 = R.string.fhi;
                    }
                    if (i2 == 1) {
                        i3 = R.string.fhg;
                    } else {
                        i3 = R.string.x_;
                    }
                    h.a(context, i2, 0, i3, (int) R.string.amn, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.ServiceNotifySettingsUI.a.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(33707);
                            for (int i3 = 0; i3 < a.this.Oxv.size(); i3++) {
                                C2073a aVar = (C2073a) a.this.Oxv.get(i3);
                                if (aVar != null && str.equals(aVar.username)) {
                                    a.this.OKP.add(a.this.Oxv.remove(i3));
                                    a.this.notifyDataSetChanged();
                                    WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(str);
                                    String str = Xk == null ? "" : Xk.field_appId;
                                    if (i2 == 1) {
                                        Log.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", 13798, 4, str, a.this.mSceneId);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13798, 4, str, 0, a.this.mSceneId, Long.valueOf(Util.nowSecond()));
                                        AppMethodBeat.o(33707);
                                        return;
                                    }
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13796, 12, str, "", 0, Long.valueOf(Util.nowSecond()));
                                    AppMethodBeat.o(33707);
                                    return;
                                }
                            }
                            AppMethodBeat.o(33707);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.ServiceNotifySettingsUI.a.AnonymousClass1.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }, (int) R.color.ts);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(33708);
                }
            };
            c.a aVar = new c.a();
            aVar.iaT = true;
            aVar.jbu = com.tencent.mm.modelappbrand.a.a.aXX();
            this.Oxy = aVar.bdv();
            AppMethodBeat.o(33709);
        }

        public final int getCount() {
            AppMethodBeat.i(33710);
            int size = this.Oxv.size();
            AppMethodBeat.o(33710);
            return size;
        }

        private C2073a alm(int i2) {
            AppMethodBeat.i(33711);
            C2073a aVar = this.Oxv.get(i2);
            AppMethodBeat.o(33711);
            return aVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(33712);
            C2073a alm = alm(i2);
            if (view == null) {
                view = this.mLayoutInflater.inflate(R.layout.bqb, viewGroup, false);
                b bVar2 = new b((byte) 0);
                bVar2.gyr = (ImageView) view.findViewById(R.id.wo);
                bVar2.titleTv = (TextView) view.findViewById(R.id.ipq);
                bVar2.OKS = (TextView) view.findViewById(R.id.h5q);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            com.tencent.mm.av.q.bcV().a(alm.url, bVar.gyr, this.Oxy);
            bVar.titleTv.setText(alm.title);
            if (this.mMode == 1) {
                bVar.OKS.setText(this.mContext.getString(R.string.fhb));
            } else {
                bVar.OKS.setText(this.mContext.getString(R.string.fhc));
            }
            bVar.OKS.setTag(alm.username);
            bVar.OKS.setOnClickListener(this.mOnClickListener);
            AppMethodBeat.o(33712);
            return view;
        }

        static class b {
            TextView OKS;
            ImageView gyr;
            TextView titleTv;

            private b() {
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.ui.ServiceNotifySettingsUI$a$a  reason: collision with other inner class name */
        public static class C2073a {
            String title;
            String url;
            String username;

            private C2073a() {
            }

            /* synthetic */ C2073a(byte b2) {
                this();
            }
        }
    }

    static /* synthetic */ void a(ServiceNotifySettingsUI serviceNotifySettingsUI, LinkedList linkedList) {
        AppMethodBeat.i(33718);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            duw duw = (duw) it.next();
            a.C2073a aVar = new a.C2073a((byte) 0);
            aVar.username = duw.username;
            aVar.title = duw.nickname;
            aVar.url = duw.lHM;
            linkedList2.add(aVar);
        }
        a aVar2 = serviceNotifySettingsUI.OKI;
        aVar2.Oxv.clear();
        if (!linkedList2.isEmpty()) {
            aVar2.Oxv.addAll(linkedList2);
        }
        serviceNotifySettingsUI.OKI.notifyDataSetChanged();
        AppMethodBeat.o(33718);
    }
}
