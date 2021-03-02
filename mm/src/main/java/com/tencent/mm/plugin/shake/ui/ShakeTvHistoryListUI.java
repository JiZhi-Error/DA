package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ShakeTvHistoryListUI extends MMActivity {
    private a Dlv;
    private ListView Dlw;
    private o.g plk = new o.g() {
        /* class com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.AnonymousClass5 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            int delete;
            AppMethodBeat.i(28566);
            switch (menuItem.getItemId()) {
                case 0:
                    h.INSTANCE.a(12662, 1, Util.nullAsNil(ShakeTvHistoryListUI.this.username));
                    com.tencent.mm.plugin.shake.d.a.o eUo = m.eUo();
                    String str = ShakeTvHistoryListUI.this.username;
                    if (Util.isNullOrNil(str)) {
                        delete = -1;
                    } else {
                        delete = eUo.db.delete(eUo.getTableName(), "username = '" + str + "'", null);
                        Log.d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = ".concat(String.valueOf(delete)));
                    }
                    if (delete < 0) {
                        Log.i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", Integer.valueOf(delete));
                    } else {
                        bg.azz().a(new c(1, ShakeTvHistoryListUI.this.username), 0);
                    }
                    ShakeTvHistoryListUI.this.Dlv.onNotifyChange(null, null);
                    break;
            }
            AppMethodBeat.o(28566);
        }
    };
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShakeTvHistoryListUI() {
        AppMethodBeat.i(28572);
        AppMethodBeat.o(28572);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28573);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(28573);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(28574);
        this.Dlv.ebf();
        super.onDestroy();
        AppMethodBeat.o(28574);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(28575);
        setMMTitle(R.string.h0_);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28561);
                ShakeTvHistoryListUI.this.hideVKB();
                ShakeTvHistoryListUI.this.finish();
                AppMethodBeat.o(28561);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.t2), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28563);
                com.tencent.mm.ui.base.h.a((Context) ShakeTvHistoryListUI.this.getContext(), true, ShakeTvHistoryListUI.this.getString(R.string.h09), "", ShakeTvHistoryListUI.this.getString(R.string.gax), ShakeTvHistoryListUI.this.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.AnonymousClass2.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(28562);
                        h hVar = h.INSTANCE;
                        Object[] objArr = new Object[2];
                        objArr[0] = 2;
                        com.tencent.mm.plugin.shake.d.a.o eUo = m.eUo();
                        ArrayList<n> arrayList = new ArrayList();
                        Cursor eUR = eUo.eUR();
                        if (eUR != null) {
                            while (eUR.moveToNext()) {
                                n nVar = new n();
                                nVar.convertFrom(eUR);
                                arrayList.add(nVar);
                            }
                            eUR.close();
                        }
                        StringBuilder sb = new StringBuilder();
                        for (n nVar2 : arrayList) {
                            sb.append(nVar2.field_username);
                            sb.append("|");
                        }
                        objArr[1] = sb.toString();
                        hVar.a(12662, objArr);
                        m.eUo().db.delete("shaketvhistory", null, null);
                        bg.azz().a(new c(2, null), 0);
                        ShakeTvHistoryListUI.this.Dlv.anp();
                        ShakeTvHistoryListUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(28562);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.AnonymousClass2.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(28563);
                return true;
            }
        });
        this.Dlw = (ListView) findViewById(R.id.hoz);
        this.Dlv = new a(this);
        this.Dlw.setAdapter((ListAdapter) this.Dlv);
        this.Dlw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(28564);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeTvHistoryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                n nVar = (n) ShakeTvHistoryListUI.this.Dlv.getItem(i2);
                AppCompatActivity context = ShakeTvHistoryListUI.this.getContext();
                if (nVar != null) {
                    if (!Util.isNullOrNil(nVar.field_username) || !Util.isNullOrNil(nVar.field_deeplink)) {
                        k.a(nVar.field_username, nVar.field_deeplink, 2, context);
                        Log.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
                    } else {
                        h.INSTANCE.a(12108, Util.nullAsNil(nVar.field_username), 2, 0);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeTvHistoryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(28564);
            }
        });
        final l lVar = new l(this);
        this.Dlw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(28565);
                if (i2 < ShakeTvHistoryListUI.this.Dlw.getHeaderViewsCount()) {
                    AppMethodBeat.o(28565);
                } else {
                    lVar.a(view, i2, j2, ShakeTvHistoryListUI.this.getContext(), ShakeTvHistoryListUI.this.plk);
                    AppMethodBeat.o(28565);
                }
                return true;
            }
        });
        AppMethodBeat.o(28575);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(28576);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        this.username = ((n) this.Dlv.getItem(adapterContextMenuInfo.position)).field_username;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.tf);
        AppMethodBeat.o(28576);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.brw;
    }

    /* access modifiers changed from: package-private */
    public class a extends s<n> {
        private LayoutInflater mInflater;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ n a(n nVar, Cursor cursor) {
            AppMethodBeat.i(28571);
            n nVar2 = nVar;
            if (nVar2 == null) {
                nVar2 = new n();
            }
            nVar2.convertFrom(cursor);
            AppMethodBeat.o(28571);
            return nVar2;
        }

        public a(Context context) {
            super(context, new n());
            AppMethodBeat.i(28567);
            this.mInflater = LayoutInflater.from(context);
            AppMethodBeat.o(28567);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1695a aVar;
            String formatTime;
            AppMethodBeat.i(28568);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.brv, viewGroup, false);
                aVar = new C1695a();
                aVar.Dlz = (MMImageView) view.findViewById(R.id.how);
                aVar.mPa = (TextView) view.findViewById(R.id.hoy);
                aVar.yQj = (TextView) view.findViewById(R.id.hox);
                view.setTag(aVar);
            } else {
                aVar = (C1695a) view.getTag();
            }
            n nVar = (n) getItem(i2);
            e.a(aVar.Dlz, nVar.field_iconurl, 0, true);
            aVar.mPa.setText(nVar.field_title);
            TextView textView = aVar.yQj;
            AppCompatActivity context = ShakeTvHistoryListUI.this.getContext();
            long j2 = nVar.field_createtime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j2 < Util.MILLSECONDS_OF_HOUR) {
                formatTime = "";
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis = j2 - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY) {
                    long timeInMillis2 = (j2 - gregorianCalendar2.getTimeInMillis()) + Util.MILLSECONDS_OF_DAY;
                    if (timeInMillis2 <= 0 || timeInMillis2 > Util.MILLSECONDS_OF_DAY) {
                        formatTime = f.formatTime(context.getString(R.string.dev), j2 / 1000);
                    } else {
                        formatTime = context.getString(R.string.dfu);
                    }
                } else {
                    formatTime = f.formatTime(context.getString(R.string.df7), j2 / 1000);
                }
            }
            textView.setText(formatTime);
            AppMethodBeat.o(28568);
            return view;
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(28569);
            setCursor(m.eUo().eUR());
            super.notifyDataSetChanged();
            AppMethodBeat.o(28569);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(28570);
            anp();
            AppMethodBeat.o(28570);
        }

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI$a$a  reason: collision with other inner class name */
        class C1695a {
            MMImageView Dlz;
            TextView mPa;
            TextView yQj;

            C1695a() {
            }
        }
    }
}
