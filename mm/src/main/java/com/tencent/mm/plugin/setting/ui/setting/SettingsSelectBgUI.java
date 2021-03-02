package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.s;
import com.tencent.mm.bb.m;
import com.tencent.mm.bb.n;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsSelectBgUI extends MMActivity implements i {
    private boolean Dbz;
    private a Dea;
    private GridView Deb;
    private m Dec;
    private MTimerHandler Ded = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(74406);
            if (SettingsSelectBgUI.this.findViewById(R.id.hn4).getWidth() <= 0) {
                AppMethodBeat.o(74406);
                return true;
            }
            SettingsSelectBgUI.a(SettingsSelectBgUI.this);
            AppMethodBeat.o(74406);
            return false;
        }
    }, true);
    private List<m> hiK = new ArrayList();
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsSelectBgUI() {
        AppMethodBeat.i(74416);
        AppMethodBeat.o(74416);
    }

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI, List list) {
        AppMethodBeat.i(74424);
        settingsSelectBgUI.gI(list);
        AppMethodBeat.o(74424);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.br8;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74417);
        super.onCreate(bundle);
        initView();
        g.azz().a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        g.azz().a(160, this);
        if (g.aAh().isSDCardAvailable()) {
            g.azz().a(new n(1), 0);
        }
        AppMethodBeat.o(74417);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74418);
        super.onDestroy();
        if (this.Dec != null) {
            g.azz().a(this.Dec);
            v.bev().dx(this.Dec.jho, 1);
        }
        List<m> list = this.hiK;
        for (m mVar : list) {
            v.bev().dx(mVar.jho, 1);
        }
        list.clear();
        g.azz().b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        g.azz().b(160, this);
        this.Dea.ebf();
        v.bev().remove(this.Dea);
        AppMethodBeat.o(74418);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74419);
        setMMTitle(R.string.go2);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74407);
                SettingsSelectBgUI.this.finish();
                AppMethodBeat.o(74407);
                return true;
            }
        });
        this.Dbz = getIntent().getBooleanExtra("isApplyToAll", true);
        this.username = getIntent().getStringExtra(ch.COL_USERNAME);
        this.Ded.startTimer(20);
        AppMethodBeat.o(74419);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(74420);
        if (!(qVar instanceof s) || ((s) qVar).aYR() != 1) {
            Log.d("MicroMsg.SettingsSelectBgUI", "another scene");
            AppMethodBeat.o(74420);
            return;
        }
        int type = qVar.getType();
        if (type == 159 || type == 160) {
            if (type == 160) {
                gI(this.hiK);
            }
            if (i2 == 0 && i3 == 0) {
                AppMethodBeat.o(74420);
            } else {
                AppMethodBeat.o(74420);
            }
        } else {
            AppMethodBeat.o(74420);
        }
    }

    private void gI(List<m> list) {
        AppMethodBeat.i(74421);
        if (list.size() > 0) {
            this.Dec = list.remove(0);
            g.azz().a(this.Dec, 0);
            AppMethodBeat.o(74421);
            return;
        }
        this.Dec = null;
        AppMethodBeat.o(74421);
    }

    /* access modifiers changed from: package-private */
    public class a extends com.tencent.mm.ui.s<com.tencent.mm.bb.q> {
        private Context context;
        private int qmd;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ com.tencent.mm.bb.q a(com.tencent.mm.bb.q qVar, Cursor cursor) {
            AppMethodBeat.i(74415);
            com.tencent.mm.bb.q qVar2 = qVar;
            if (qVar2 == null) {
                qVar2 = new com.tencent.mm.bb.q();
            }
            qVar2.convertFrom(cursor);
            AppMethodBeat.o(74415);
            return qVar2;
        }

        public a(Context context2, int i2) {
            super(context2, new com.tencent.mm.bb.q());
            AppMethodBeat.i(74410);
            this.context = context2;
            this.qmd = i2;
            AppMethodBeat.o(74410);
        }

        @Override // com.tencent.mm.ui.s
        public final int getCount() {
            AppMethodBeat.i(74411);
            int count = getCursor().getCount() + 2;
            AppMethodBeat.o(74411);
            return count;
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(74412);
            anp();
            AppMethodBeat.o(74412);
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(74413);
            setCursor(v.bev().ber());
            super.notifyDataSetChanged();
            AppMethodBeat.o(74413);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            Bitmap bitmapNative;
            AppMethodBeat.i(74414);
            if (view == null) {
                view = View.inflate(this.context, R.layout.br9, null);
                view.setLayoutParams(new AbsListView.LayoutParams(this.qmd, this.qmd));
                b bVar2 = new b();
                bVar2.DfK = (LinearLayout) view.findViewById(R.id.hh6);
                bVar2.DfL = (LinearLayout) view.findViewById(R.id.hh5);
                bVar2.DfM = (LinearLayout) view.findViewById(R.id.hh_);
                bVar2.DfN = (LinearLayout) view.findViewById(R.id.hha);
                bVar2.DfO = (LinearLayout) view.findViewById(R.id.hh4);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(12311, (Object) null), -2);
            com.tencent.mm.bb.a Pp = v.bew().Pp(SettingsSelectBgUI.this.username);
            if (i2 == 0) {
                if ((!SettingsSelectBgUI.this.Dbz || nullAs != -2) && (!(!SettingsSelectBgUI.this.Dbz && nullAs == -2 && Pp == null) && (Pp == null || Pp.jgE != -2))) {
                    bVar.aNi("downloaded");
                } else {
                    bVar.aNi("using");
                }
                ((ImageView) view.findViewById(R.id.hh8)).setImageBitmap(BitmapUtil.getRoundedCornerBitmap(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.bbn), true, 10.0f));
                AppMethodBeat.o(74414);
            } else if (i2 == 1) {
                if ((!SettingsSelectBgUI.this.Dbz || nullAs != 0) && (!(!SettingsSelectBgUI.this.Dbz && nullAs == 0 && Pp == null) && (Pp == null || Pp.jgE != 0))) {
                    bVar.aNi("downloaded");
                } else {
                    bVar.aNi("using");
                }
                ((ImageView) view.findViewById(R.id.hh8)).setImageBitmap(BitmapUtil.getRoundedCornerBitmap(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.bbm), true, 10.0f));
                AppMethodBeat.o(74414);
            } else {
                com.tencent.mm.bb.q qVar = (com.tencent.mm.bb.q) getItem(i2 - 2);
                r bev = v.bev();
                if (!g.aAh().isSDCardAvailable()) {
                    bitmapNative = BitmapFactory.decodeResource(SettingsSelectBgUI.this.getResources(), R.drawable.bjo);
                } else {
                    bitmapNative = BitmapUtil.getBitmapNative(r.bes() + r.du(qVar.id, qVar.dMe));
                }
                if (bitmapNative == null) {
                    int i3 = qVar.id;
                    int i4 = qVar.dMe;
                    if (bev.iFy.delete("packageinfo2", "id= ? and type =?", new String[]{String.valueOf(i3), String.valueOf(i4)}) > 0) {
                        bev.doNotify();
                    }
                    AppMethodBeat.o(74414);
                } else {
                    ((ImageView) view.findViewById(R.id.hh8)).setImageBitmap(BitmapUtil.getRoundedCornerBitmap(bitmapNative, true, 10.0f));
                    switch (qVar.status) {
                        case 1:
                            if (!SettingsSelectBgUI.this.Dbz && Pp != null && Pp.jgE != qVar.id) {
                                bVar.aNi("downloaded");
                                break;
                            } else {
                                bVar.aNi("using");
                                break;
                            }
                        case 2:
                            if (!SettingsSelectBgUI.this.Dbz && Pp != null && Pp.jgE == qVar.id) {
                                bVar.aNi("using");
                                break;
                            } else {
                                bVar.aNi("downloaded");
                                break;
                            }
                        case 3:
                            bVar.aNi("downloading");
                            break;
                        case 4:
                            bVar.aNi("canceling");
                            break;
                        case 5:
                            bVar.aNi("undownloaded");
                            break;
                    }
                    AppMethodBeat.o(74414);
                }
            }
            return view;
        }
    }

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI) {
        AppMethodBeat.i(74422);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) settingsSelectBgUI.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        settingsSelectBgUI.Dea = new a(settingsSelectBgUI, ((displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels) - 60) / 3);
        settingsSelectBgUI.Deb = (GridView) settingsSelectBgUI.findViewById(R.id.hn4);
        v.bev().add(settingsSelectBgUI.Dea);
        settingsSelectBgUI.Deb.setAdapter((ListAdapter) settingsSelectBgUI.Dea);
        settingsSelectBgUI.Deb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(74409);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSelectBgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 == 0) {
                    SettingsSelectBgUI.a(SettingsSelectBgUI.this, -2);
                    SettingsSelectBgUI.this.Dea.anp();
                    if (!SettingsSelectBgUI.this.Dbz) {
                        SettingsSelectBgUI.this.setResult(-1);
                        SettingsSelectBgUI.this.finish();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSelectBgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(74409);
                } else if (i2 == 1) {
                    SettingsSelectBgUI.a(SettingsSelectBgUI.this, 0);
                    SettingsSelectBgUI.this.Dea.anp();
                    if (!SettingsSelectBgUI.this.Dbz) {
                        SettingsSelectBgUI.this.setResult(-1);
                        SettingsSelectBgUI.this.finish();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSelectBgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(74409);
                } else if (!g.aAh().isSDCardAvailable()) {
                    Toast.makeText(SettingsSelectBgUI.this, (int) R.string.gtr, 1).show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSelectBgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(74409);
                } else {
                    com.tencent.mm.bb.q qVar = (com.tencent.mm.bb.q) adapterView.getItemAtPosition(i2 - 2);
                    if (qVar == null) {
                        Log.e("MicroMsg.SettingsSelectBgUI", "onItemClick fail, info is null, position = ".concat(String.valueOf(i2)));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSelectBgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(74409);
                        return;
                    }
                    switch (qVar.status) {
                        case 1:
                        case 2:
                            SettingsSelectBgUI.a(SettingsSelectBgUI.this, qVar.id);
                            if (SettingsSelectBgUI.this.Dbz) {
                                qVar.status = 1;
                                r bev = v.bev();
                                bev.tH(qVar.dMe);
                                qVar.status = 1;
                                bev.b(qVar);
                            } else {
                                SettingsSelectBgUI.this.Dea.anp();
                            }
                            if (!SettingsSelectBgUI.this.Dbz) {
                                SettingsSelectBgUI.this.setResult(-1);
                                SettingsSelectBgUI.this.finish();
                                break;
                            }
                            break;
                        case 3:
                            if (SettingsSelectBgUI.this.Dec != null && SettingsSelectBgUI.this.Dec.jho == qVar.id) {
                                g.azz().a(SettingsSelectBgUI.this.Dec);
                                v.bev().dx(SettingsSelectBgUI.this.Dec.jho, 1);
                                SettingsSelectBgUI.a(SettingsSelectBgUI.this, SettingsSelectBgUI.this.hiK);
                            }
                            SettingsSelectBgUI.s(qVar.id, SettingsSelectBgUI.this.hiK);
                            final r bev2 = v.bev();
                            qVar.status = 4;
                            bev2.b(qVar);
                            final int i3 = qVar.id;
                            new MMHandler() {
                                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.AnonymousClass3.AnonymousClass1 */

                                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                                public final void handleMessage(Message message) {
                                    AppMethodBeat.i(74408);
                                    bev2.dx(i3, 1);
                                    AppMethodBeat.o(74408);
                                }
                            }.sendEmptyMessageDelayed(0, 1000);
                            break;
                        case 4:
                            v.bev().dx(qVar.id, 1);
                            break;
                        case 5:
                            if (SettingsSelectBgUI.this.Dec != null) {
                                SettingsSelectBgUI.this.hiK.add(new m(qVar.id, 1));
                                break;
                            } else {
                                SettingsSelectBgUI.this.Dec = new m(qVar.id, 1);
                                g.azz().a(SettingsSelectBgUI.this.Dec, 0);
                                break;
                            }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSelectBgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(74409);
                }
            }
        });
        AppMethodBeat.o(74422);
    }

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI, int i2) {
        AppMethodBeat.i(74423);
        g.aAh().azQ().set(66820, Integer.valueOf(i2));
        h.INSTANCE.a(10198, Integer.valueOf(i2));
        Log.i("MicroMsg.SettingsSelectBgUI", "set chating bg id:%d", Integer.valueOf(i2));
        if (settingsSelectBgUI.Dbz) {
            g.aAh().azQ().set(12311, Integer.valueOf(i2));
            v.bev().tH(1);
            AppMethodBeat.o(74423);
            return;
        }
        com.tencent.mm.bb.b bew = v.bew();
        com.tencent.mm.bb.a Pp = bew.Pp(settingsSelectBgUI.username);
        if (Pp == null) {
            com.tencent.mm.bb.a aVar = new com.tencent.mm.bb.a();
            aVar.username = settingsSelectBgUI.username;
            aVar.jgE = i2;
            bew.a(aVar);
            AppMethodBeat.o(74423);
            return;
        }
        Pp.jgE = i2;
        bew.b(Pp);
        AppMethodBeat.o(74423);
    }

    static /* synthetic */ void s(int i2, List list) {
        AppMethodBeat.i(74425);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (mVar.jho == i2) {
                v.bev().dx(mVar.jho, 1);
                list.remove(mVar);
                AppMethodBeat.o(74425);
                return;
            }
        }
        AppMethodBeat.o(74425);
    }
}
