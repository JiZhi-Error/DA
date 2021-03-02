package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.model.h.g;
import com.tencent.mm.plugin.ipcall.model.h.h;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.s;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class IPCallMsgUI extends MMActivity {
    private ListView list;
    private View poS;
    private View qdm;
    private boolean qdn = true;
    private a ywt;
    private MStorage.IOnStorageChange ywu = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(25812);
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.AnonymousClass7.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(25811);
                    synchronized (IPCallMsgUI.this.ywt) {
                        try {
                            Log.v("MicroMsg.IPCallMsgUI", "comment notify");
                            IPCallMsgUI.this.ywt.onNotifyChange(null, null);
                        } finally {
                            AppMethodBeat.o(25811);
                        }
                    }
                }
            });
            AppMethodBeat.o(25812);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallMsgUI() {
        AppMethodBeat.i(25824);
        AppMethodBeat.o(25824);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awy;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25825);
        super.onCreate(bundle);
        i.eaB().add(this.ywu);
        initView();
        AppMethodBeat.o(25825);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25826);
        Log.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
        i.eaB().remove(this.ywu);
        this.ywt.ebf();
        h eaB = i.eaB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", (Short) 1);
        eaB.db.update(eaB.getTableName(), contentValues, "isRead!=? ", new String[]{"1"});
        super.onDestroy();
        AppMethodBeat.o(25826);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(25827);
        setMMTitle(R.string.e8l);
        this.poS = findViewById(R.id.e1k);
        this.list = (ListView) findViewById(R.id.e1l);
        this.qdm = aa.jQ(this).inflate(R.layout.b84, (ViewGroup) null);
        this.list.addFooterView(this.qdm);
        this.ywt = new a(this, new g());
        this.ywt.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(25805);
                int positionForView = IPCallMsgUI.this.list.getPositionForView(view);
                AppMethodBeat.o(25805);
                return positionForView;
            }
        });
        this.ywt.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(25806);
                IPCallMsgUI.this.list.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(25806);
            }
        });
        this.ywt.a(new s.a() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(25807);
                if (IPCallMsgUI.this.ywt.getCount() == 0) {
                    IPCallMsgUI.this.list.setVisibility(8);
                    IPCallMsgUI.this.poS.setVisibility(0);
                    AppMethodBeat.o(25807);
                    return;
                }
                IPCallMsgUI.this.list.setVisibility(0);
                IPCallMsgUI.this.poS.setVisibility(8);
                AppMethodBeat.o(25807);
            }
        });
        this.list.setAdapter((ListAdapter) this.ywt);
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(25808);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallMsgUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                g gVar = (g) IPCallMsgUI.this.ywt.getItem(i2);
                if (!Util.isNullOrNil(gVar.field_descUrl)) {
                    int i3 = gVar.field_msgType;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13780, Integer.valueOf(i3));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", gVar.field_descUrl);
                    intent.putExtra("showShare", false);
                    c.b(IPCallMsgUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallMsgUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(25808);
            }
        });
        this.list.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.AnonymousClass5 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(25809);
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    a aVar = IPCallMsgUI.this.ywt;
                    if (!aVar.cwg()) {
                        aVar.qdp += 10;
                        if (aVar.qdp > aVar.gAZ) {
                            aVar.qdp = aVar.gAZ;
                        }
                    } else if (IPCallMsgUI.this.qdm.getParent() != null) {
                        IPCallMsgUI.this.list.removeFooterView(IPCallMsgUI.this.qdm);
                    }
                    IPCallMsgUI.this.ywt.onNotifyChange(null, null);
                    AppMethodBeat.o(25809);
                    return;
                }
                AppMethodBeat.o(25809);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        if (this.ywt.getCount() == 0) {
            this.list.setVisibility(8);
            this.poS.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.list.setVisibility(0);
            this.poS.setVisibility(8);
            enableOptionMenu(true);
        }
        if (this.ywt.cwg()) {
            this.list.removeFooterView(this.qdm);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25810);
                IPCallMsgUI.this.finish();
                AppMethodBeat.o(25810);
                return true;
            }
        });
        if (this.ywt.cwg()) {
            this.list.removeFooterView(this.qdm);
        }
        AppMethodBeat.o(25827);
    }

    /* access modifiers changed from: package-private */
    public class a extends s<g> {
        int gAZ = this.qdp;
        protected MMSlideDelView.g pkY;
        protected MMSlideDelView.c pkZ;
        protected MMSlideDelView.d plb = new MMSlideDelView.d() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                AppMethodBeat.i(25813);
                if (z) {
                    ywx.add(mMSlideDelView);
                    AppMethodBeat.o(25813);
                    return;
                }
                ywx.remove(mMSlideDelView);
                AppMethodBeat.o(25813);
            }

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final boolean ebn() {
                AppMethodBeat.i(25814);
                if (ywx.size() > 0) {
                    AppMethodBeat.o(25814);
                    return true;
                }
                AppMethodBeat.o(25814);
                return false;
            }

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final void ebo() {
                AppMethodBeat.i(25815);
                for (MMSlideDelView mMSlideDelView : ywx) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.gLa();
                    }
                }
                ywx.clear();
                AppMethodBeat.o(25815);
            }

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final void ebp() {
                AppMethodBeat.i(25816);
                for (MMSlideDelView mMSlideDelView : ywx) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.gKZ();
                    }
                }
                ywx.clear();
                AppMethodBeat.o(25816);
            }
        };
        int qdp = 10;
        private Set<MMSlideDelView> ywx = new HashSet();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ g a(g gVar, Cursor cursor) {
            AppMethodBeat.i(25823);
            g gVar2 = gVar;
            if (gVar2 == null) {
                gVar2 = new g();
                Log.d("MicroMsg.IPCallMsgUI", "new IPCallMsg");
            }
            gVar2.convertFrom(cursor);
            AppMethodBeat.o(25823);
            return gVar2;
        }

        public a(Context context, g gVar) {
            super(context, gVar);
            AppMethodBeat.i(25817);
            AppMethodBeat.o(25817);
        }

        @Override // com.tencent.mm.ui.s
        public final long getItemId(int i2) {
            AppMethodBeat.i(25818);
            long j2 = ((g) getItem(i2)).systemRowid;
            AppMethodBeat.o(25818);
            return j2;
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(25819);
            ebf();
            anp();
            AppMethodBeat.o(25819);
        }

        public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
            this.pkY = gVar;
        }

        public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
            this.pkZ = cVar;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.ui.s
        public final synchronized void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(25820);
            super.onNotifyChange(str, mStorageEventData);
            AppMethodBeat.o(25820);
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(25821);
            this.gAZ = i.eaB().getCount();
            setCursor(i.eaB().Pf(this.qdp));
            notifyDataSetChanged();
            AppMethodBeat.o(25821);
        }

        public final boolean cwg() {
            return this.qdp >= this.gAZ;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1445a aVar;
            String str;
            boolean z;
            AppMethodBeat.i(25822);
            g gVar = (g) getItem(i2);
            if (view == null || !(view.getTag() instanceof C1445a)) {
                view = aa.jQ(this.context).inflate(R.layout.awx, (ViewGroup) null);
                aVar = new C1445a();
                aVar.titleTv = (TextView) view.findViewById(R.id.ipq);
                aVar.hXC = (TextView) view.findViewById(R.id.beg);
                aVar.timeTv = (TextView) view.findViewById(R.id.ims);
                view.setTag(aVar);
            } else {
                aVar = (C1445a) view.getTag();
            }
            aVar.titleTv.setText(gVar.field_title);
            aVar.hXC.setText(gVar.field_content);
            TextView textView = aVar.timeTv;
            AppCompatActivity context = IPCallMsgUI.this.getContext();
            long j2 = gVar.field_pushTime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            String str2 = (String) DateFormat.format(context.getString(R.string.dec), j2);
            if (str2.indexOf("-") > 0) {
                String str3 = str2.split("-")[0];
                String str4 = str2.split("-")[1];
                str = (str4 + " " + com.tencent.mm.plugin.ipcall.a.c.bf(context, str3) + " ") + " " + ((String) com.tencent.mm.plugin.ipcall.a.c.j(context, j2));
            } else {
                long timeInMillis = j2 - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY) {
                    long timeInMillis2 = (j2 - gregorianCalendar2.getTimeInMillis()) + Util.MILLSECONDS_OF_DAY;
                    if (timeInMillis2 <= 0 || timeInMillis2 > Util.MILLSECONDS_OF_DAY) {
                        str = str2 + " " + ((String) com.tencent.mm.plugin.ipcall.a.c.j(context, j2));
                    } else {
                        str = context.getString(R.string.dfu) + " " + ((String) com.tencent.mm.plugin.ipcall.a.c.j(context, j2));
                    }
                } else {
                    str = ((String) com.tencent.mm.plugin.ipcall.a.c.j(context, j2));
                }
            }
            textView.setText(str);
            if (gVar.field_isRead == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                aVar.titleTv.setTextColor(IPCallMsgUI.this.getResources().getColor(R.color.w5));
            } else {
                aVar.titleTv.setTextColor(IPCallMsgUI.this.getResources().getColor(R.color.w6));
            }
            AppMethodBeat.o(25822);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$a$a  reason: collision with other inner class name */
        class C1445a {
            TextView hXC;
            TextView timeTv;
            TextView titleTv;

            C1445a() {
            }
        }
    }
}
