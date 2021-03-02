package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.m;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.av.t;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.readerapp.c.b;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@i
public class ReaderAppUI extends MMActivity {
    private static float density;
    private a<String> BCq;
    private f BCr = null;
    private int BCs = 0;
    private int dXa = 0;
    private View kgo;
    private com.tencent.mm.ui.widget.b.a pqr;
    private o.g pso = new o.g() {
        /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.AnonymousClass4 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(161679);
            int groupId = menuItem.getGroupId();
            switch (menuItem.getItemId()) {
                case 0:
                    if (ReaderAppUI.this.dXa == 20) {
                        List<bv> al = g.eHI().al((String) ReaderAppUI.this.BCq.getItem(groupId), ReaderAppUI.this.dXa);
                        if (al.size() > 0) {
                            bv bvVar = al.get(0);
                            k.b bVar = new k.b();
                            bVar.title = bvVar.getTitle();
                            bVar.description = bvVar.getDigest();
                            bVar.action = "view";
                            bVar.type = 5;
                            bVar.url = bvVar.getUrl();
                            String a2 = k.b.a(bVar, null, null);
                            Intent intent = new Intent();
                            intent.putExtra("Retr_Msg_content", a2);
                            intent.putExtra("Retr_Msg_Type", 2);
                            intent.putExtra("Retr_Msg_thumb_path", s.bdu(bvVar.aWd()));
                            intent.putExtra("Retr_Msg_Id", 7377812);
                            String JX = ad.JX(new StringBuilder().append(bvVar.iFs).toString());
                            intent.putExtra("reportSessionId", JX);
                            ad.b G = ad.aVe().G(JX, true);
                            G.l("prePublishId", "msg_" + bvVar.iFs);
                            G.l("preUsername", "newsapp");
                            G.l("preChatName", "newsapp");
                            G.l("preMsgIndex", 0);
                            G.l("sendAppMsgScene", 1);
                            com.tencent.mm.plugin.readerapp.b.a.jRt.k(intent, ReaderAppUI.this);
                        }
                        AppMethodBeat.o(161679);
                        return;
                    }
                    break;
                case 1:
                    if (ReaderAppUI.this.dXa == 20) {
                        String str = (String) ReaderAppUI.this.BCq.getItem(groupId);
                        List<bv> al2 = g.eHI().al(str, ReaderAppUI.this.dXa);
                        if (!al2.isEmpty()) {
                            Log.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", str, Integer.valueOf(ReaderAppUI.this.BCs), Integer.valueOf(al2.size()));
                            if (ReaderAppUI.this.BCs >= al2.size()) {
                                ReaderAppUI.this.BCs = 0;
                            }
                            bv bvVar2 = al2.get(ReaderAppUI.this.BCs);
                            cz czVar = new cz();
                            String JX2 = ad.JX(new StringBuilder().append(bvVar2.iFs).toString());
                            ad.b G2 = ad.aVe().G(JX2, true);
                            G2.l("prePublishId", "msg_" + bvVar2.iFs);
                            G2.l("preUsername", "newsapp");
                            G2.l("preChatName", "newsapp");
                            G2.l("preMsgIndex", 0);
                            G2.l("sendAppMsgScene", 1);
                            czVar.dFZ.sessionId = JX2;
                            int unused = ReaderAppUI.this.BCs;
                            b.a(czVar, bvVar2);
                            czVar.dFZ.dGf = 7;
                            czVar.dFZ.activity = ReaderAppUI.this;
                            EventCenter.instance.publish(czVar);
                            break;
                        }
                    }
                    break;
                case 2:
                    String str2 = (String) ReaderAppUI.this.BCq.getItem(groupId);
                    if (!Util.isNullOrNil(str2)) {
                        g.fi(str2, ReaderAppUI.this.dXa);
                        bw eHI = g.eHI();
                        int i3 = ReaderAppUI.this.dXa;
                        String str3 = "delete from " + bw.se(i3) + " where reserved3 = " + h.Fl(str2);
                        Log.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", str3);
                        if (eHI.iFy.execSQL(bw.se(i3), str3)) {
                            eHI.si(i3);
                            eHI.doNotify();
                        }
                    }
                    ReaderAppUI.this.refresh();
                    AppMethodBeat.o(161679);
                    return;
            }
            AppMethodBeat.o(161679);
        }
    };
    private String yJC = "";
    private ListView zoc;
    private MMPullDownView zog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ReaderAppUI() {
        AppMethodBeat.i(102751);
        AppMethodBeat.o(102751);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(102752);
        super.onCreate(bundle);
        this.dXa = getIntent().getIntExtra("type", 0);
        Log.i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", Integer.valueOf(this.dXa));
        this.dXa = 20;
        density = com.tencent.mm.cb.a.getDensity(this);
        long currentTimeMillis = System.currentTimeMillis();
        initView();
        Log.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        this.yJC = bv.sd(this.dXa);
        if (20 == this.dXa && ac.aI("newsapp", null) > 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13440, 2);
        }
        AppMethodBeat.o(102752);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(102753);
        if (this.BCq != null) {
            this.BCq.ebf();
            this.BCq.gGV();
        }
        super.onDestroy();
        AppMethodBeat.o(102753);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bki;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(102754);
        super.onResume();
        if (this.dXa == 20) {
            setMMTitle(R.string.dz0);
        } else {
            setMMTitle(R.string.dz3);
        }
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().CY(this.yJC);
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(this.yJC);
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bka(this.yJC);
        g.eHI().add(this.BCq);
        this.BCq.onNotifyChange(null, null);
        refresh();
        AppMethodBeat.o(102754);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(102755);
        super.onPause();
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().CY("");
        g.eHI().remove(this.BCq);
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bka(this.yJC);
        AppMethodBeat.o(102755);
    }

    public final void refresh() {
        AppMethodBeat.i(102756);
        TextView textView = (TextView) findViewById(R.id.c30);
        textView.setText(this.dXa == 20 ? R.string.fty : R.string.fu4);
        if (this.BCq.getCount() == 0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        if (this.zoc != null && (this.BCq instanceof a)) {
            this.zoc.post(new Runnable() {
                /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(161678);
                    ((a) ReaderAppUI.this.BCq).hQ(ReaderAppUI.this.zoc.getFirstVisiblePosition(), ReaderAppUI.this.zoc.getLastVisiblePosition());
                    AppMethodBeat.o(161678);
                }
            });
        }
        AppMethodBeat.o(102756);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(102757);
        try {
            this.BCr = new f(Util.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")), this);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ReaderAppUI", e2, "", new Object[0]);
        }
        this.zoc = (ListView) findViewById(R.id.gst);
        this.zog = (MMPullDownView) findViewById(R.id.gsw);
        this.zog.setIsReturnSuperDispatchWhenCancel(true);
        this.kgo = getLayoutInflater().inflate(R.layout.bkm, (ViewGroup) null);
        this.zoc.addHeaderView(this.kgo);
        ((TextView) findViewById(R.id.c30)).setText(R.string.ftq);
        this.BCq = new a(this, "");
        this.zoc.setOnScrollListener(this.BCq);
        this.zoc.setAdapter((ListAdapter) this.BCq);
        this.zoc.setTranscriptMode(0);
        registerForContextMenu(this.zoc);
        this.pqr = new com.tencent.mm.ui.widget.b.a(this);
        this.pqr.QSv = true;
        if (this.BCq.getCount() == 0) {
            Intent intent = new Intent(this, ReaderAppIntroUI.class);
            intent.putExtra("type", this.dXa);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            AppMethodBeat.o(102757);
            return;
        }
        this.zog.setOnTopLoadDataListener(new MMPullDownView.g() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.g
            public final boolean cAm() {
                AppMethodBeat.i(161680);
                if (ReaderAppUI.this.BCq.cwg()) {
                    ReaderAppUI.this.zoc.setSelectionFromTop(0, ReaderAppUI.this.zog.getTopHeight());
                    AppMethodBeat.o(161680);
                } else {
                    int count = ReaderAppUI.this.BCq.getCount();
                    int cwh = ReaderAppUI.this.BCq.cwh();
                    Log.v("MicroMsg.ReaderAppUI", "onLoadData add count:".concat(String.valueOf(cwh)));
                    ReaderAppUI.this.BCq.onNotifyChange(null, null);
                    int count2 = ReaderAppUI.this.BCq.getCount();
                    Log.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", Integer.valueOf(count2), Integer.valueOf(count));
                    if (count2 > count) {
                        Log.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(cwh + 1), Integer.valueOf(ReaderAppUI.this.zog.getTopHeight()));
                        p.a(ReaderAppUI.this.zoc, cwh + 1, ReaderAppUI.this.zog.getTopHeight(), false);
                    }
                    AppMethodBeat.o(161680);
                }
                return true;
            }
        });
        this.zog.setTopViewVisible(true);
        this.zog.setAtBottomCallBack(new MMPullDownView.c() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.c
            public final boolean cAl() {
                AppMethodBeat.i(161681);
                View childAt = ReaderAppUI.this.zoc.getChildAt(ReaderAppUI.this.zoc.getChildCount() - 1);
                if (childAt == null) {
                    AppMethodBeat.o(161681);
                    return false;
                } else if (childAt.getBottom() > ReaderAppUI.this.zoc.getHeight() || ReaderAppUI.this.zoc.getLastVisiblePosition() != ReaderAppUI.this.zoc.getAdapter().getCount() - 1) {
                    AppMethodBeat.o(161681);
                    return false;
                } else {
                    AppMethodBeat.o(161681);
                    return true;
                }
            }
        });
        this.zog.setAtTopCallBack(new MMPullDownView.d() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.d
            public final boolean cAk() {
                AppMethodBeat.i(161682);
                View childAt = ReaderAppUI.this.zoc.getChildAt(ReaderAppUI.this.zoc.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    AppMethodBeat.o(161682);
                    return false;
                }
                AppMethodBeat.o(161682);
                return true;
            }
        });
        this.zog.setIsBottomShowAll(true);
        this.BCq.a(new s.a() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(161683);
                ReaderAppUI.this.zog.setIsTopShowAll(ReaderAppUI.this.BCq.cwg());
                AppMethodBeat.o(161683);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.AnonymousClass9 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(102724);
                ReaderAppUI.this.finish();
                AppMethodBeat.o(102724);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.cx, R.raw.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(161684);
                com.tencent.mm.plugin.readerapp.b.a.jRt.c(new Intent().putExtra("Contact_User", ReaderAppUI.this.yJC), ReaderAppUI.this);
                AppMethodBeat.o(161684);
                return true;
            }
        });
        this.zoc.setSelection((this.BCq.getShowCount() - 1) + this.zoc.getHeaderViewsCount());
        AppMethodBeat.o(102757);
    }

    /* access modifiers changed from: package-private */
    public class a extends a<String> {
        private int BCA = 0;
        private int BCB = 0;
        int BCC = 0;
        int BCD = 1;
        int BCE = 2;
        private Html.ImageGetter BCy = new Html.ImageGetter() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a.AnonymousClass1 */

            public final Drawable getDrawable(String str) {
                AppMethodBeat.i(102726);
                Drawable drawable = ReaderAppUI.this.getResources().getDrawable(Util.getInt(str, 0));
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                AppMethodBeat.o(102726);
                return drawable;
            }
        };
        private int BCz = 0;
        private Context context;
        private int gAZ;
        private int pru;
        private int prv = 0;
        private int prw = 0;
        private int prx = 0;
        private int prz;
        private int qdp;

        static /* synthetic */ void ar(View view, int i2) {
            AppMethodBeat.i(102749);
            W(view, i2);
            AppMethodBeat.o(102749);
        }

        final class c {
            View BCO;
            View BCP;
            ImageView BCQ;
            ImageView BCR;
            TextView BCS;
            MMNeat7extView pIO;
            View ptQ;
            ImageView puw;

            c() {
            }

            /* access modifiers changed from: package-private */
            public final void eHK() {
                AppMethodBeat.i(102729);
                if (this.ptQ == null) {
                    AppMethodBeat.o(102729);
                    return;
                }
                this.puw = (ImageView) this.ptQ.findViewById(R.id.jmq);
                this.BCQ = (ImageView) this.ptQ.findViewById(R.id.ggb);
                this.pIO = (MMNeat7extView) this.ptQ.findViewById(R.id.ir0);
                this.BCS = (TextView) this.ptQ.findViewById(R.id.j3s);
                this.BCR = (ImageView) this.ptQ.findViewById(R.id.gcg);
                this.BCO = this.ptQ.findViewById(R.id.gcn);
                this.BCP = this.ptQ.findViewById(R.id.jmn);
                AppMethodBeat.o(102729);
            }

            /* access modifiers changed from: package-private */
            public final void a(bv bvVar, int i2, String str) {
                AppMethodBeat.i(102730);
                View.OnClickListener a2 = ReaderAppUI.this.a(bvVar, ReaderAppUI.this.dXa, 0, str);
                if (this.ptQ == null) {
                    AppMethodBeat.o(102730);
                    return;
                }
                this.ptQ.setOnClickListener(a2);
                this.ptQ.setTag(Integer.valueOf(i2));
                this.ptQ.setTag(R.id.gsv, Integer.valueOf(i2));
                ReaderAppUI.this.pqr.a(this.ptQ, ReaderAppUI.a(ReaderAppUI.this, false), ReaderAppUI.this.pso);
                this.pIO.aw(bvVar.getTitle());
                String rJ = m.rJ(bvVar.aWg());
                if (!Util.isNullOrNil(rJ)) {
                    this.BCS.setText(rJ);
                    this.BCO.setVisibility(0);
                } else {
                    this.BCO.setVisibility(8);
                }
                this.pIO.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(R.color.wu));
                this.BCP.setBackgroundResource(R.drawable.aij);
                int textSize = (int) (((double) this.BCS.getTextSize()) * 1.7d);
                ViewGroup.LayoutParams layoutParams = this.BCR.getLayoutParams();
                layoutParams.height = textSize;
                layoutParams.width = textSize;
                this.BCR.setLayoutParams(layoutParams);
                a.ar(this.puw, a.this.BCB);
                a.a(a.this, bvVar.aWd(), this.puw, new m.a() {
                    /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a.c.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
                    public final void onFinish() {
                        AppMethodBeat.i(102728);
                        c.this.pIO.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(R.color.ag2));
                        c.this.BCP.setBackgroundResource(R.drawable.b5a);
                        AppMethodBeat.o(102728);
                    }

                    @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
                    public final void onStart() {
                    }
                });
                AppMethodBeat.o(102730);
            }
        }

        /* access modifiers changed from: package-private */
        public final class b {
            ImageView BCI;
            ViewGroup BCJ;
            MMNeat7extView BCK;
            ImageView BCL;
            c BCM;
            c BCN;
            ImageView gyr;
            TextView hbb;
            TextView kcZ;
            View kmV;
            View ptQ;
            ImageView ptS;
            View puc;
            TextView pwO;
            List<C1626a> pxL;
            TextView znW;

            b() {
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$a$a  reason: collision with other inner class name */
        public final class C1626a {
            TextView hbb;
            View jBI;
            ImageView ptE;
            View puO;
            View pxo;
            View pxr;

            C1626a() {
            }
        }

        private static void a(b bVar, C1626a aVar) {
            AppMethodBeat.i(102731);
            if (bVar == null) {
                AppMethodBeat.o(102731);
                return;
            }
            bVar.BCJ.addView(aVar.puO);
            bVar.pxL.add(aVar);
            AppMethodBeat.o(102731);
        }

        public a(Context context2, String str) {
            super(context2, str);
            AppMethodBeat.i(102732);
            this.context = context2;
            this.qdp = 3;
            this.gAZ = g.eHI().sg(ReaderAppUI.this.dXa);
            this.prx = context2.getResources().getDimensionPixelSize(R.dimen.k5);
            this.prv = context2.getResources().getDimensionPixelSize(R.dimen.hs);
            this.BCz = context2.getResources().getDimensionPixelSize(R.dimen.f3062g);
            this.prw = context2.getResources().getDimensionPixelSize(R.dimen.ib);
            this.pru = context2.getResources().getDimensionPixelSize(R.dimen.wz);
            this.prz = context2.getResources().getDimensionPixelSize(R.dimen.wx);
            int jn = com.tencent.mm.cb.a.jn(context2);
            int jo = com.tencent.mm.cb.a.jo(context2);
            jn = jn >= jo ? jo : jn;
            this.BCA = (int) (((double) (jn - ((int) (ReaderAppUI.density * 28.0f)))) / 2.35d);
            this.BCB = (((int) ((((float) jn) - (ReaderAppUI.density * 52.0f)) / 2.0f)) * 4) / 3;
            AppMethodBeat.o(102732);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(102733);
            anp();
            AppMethodBeat.o(102733);
        }

        @Override // com.tencent.mm.plugin.readerapp.ui.a
        public final boolean cwg() {
            return this.qdp >= this.gAZ;
        }

        @Override // com.tencent.mm.plugin.readerapp.ui.a
        public final int getShowCount() {
            return this.qdp;
        }

        @Override // com.tencent.mm.plugin.readerapp.ui.a
        public final int cwh() {
            AppMethodBeat.i(102734);
            if (cwg()) {
                AppMethodBeat.o(102734);
                return 0;
            }
            this.qdp += 3;
            if (this.qdp <= this.gAZ) {
                AppMethodBeat.o(102734);
                return 3;
            }
            this.qdp = this.gAZ;
            int i2 = this.gAZ % 3;
            AppMethodBeat.o(102734);
            return i2;
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(102735);
            long currentTimeMillis = System.currentTimeMillis();
            this.gAZ = g.eHI().sg(20);
            setCursor(g.eHI().sf(this.qdp));
            Log.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.qdp), Integer.valueOf(this.gAZ));
            super.notifyDataSetChanged();
            AppMethodBeat.o(102735);
        }

        @Override // com.tencent.mm.ui.s
        private String getItem(int i2) {
            AppMethodBeat.i(102736);
            String str = (String) super.getItem(i2);
            AppMethodBeat.o(102736);
            return str;
        }

        public final int getItemViewType(int i2) {
            boolean z;
            AppMethodBeat.i(102737);
            List<bv> Vo = Vo(i2);
            if (Util.isNullOrNil(Vo)) {
                Log.e("MicroMsg.ReaderAppUI", "getItemViewType info is null");
                int i3 = this.BCC;
                AppMethodBeat.o(102737);
                return i3;
            }
            if (Vo.get(0).aWf() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z || Vo.size() < 2) {
                int i4 = this.BCC;
                AppMethodBeat.o(102737);
                return i4;
            }
            int i5 = this.BCD;
            AppMethodBeat.o(102737);
            return i5;
        }

        public final int getViewTypeCount() {
            return this.BCE;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            final b bVar;
            final boolean z;
            b bVar2;
            AppMethodBeat.i(102738);
            if (getItemViewType(i2) == this.BCD) {
                if (view == null) {
                    b bVar3 = new b();
                    view = View.inflate(this.context, R.layout.bkt, null);
                    bVar3.pwO = (TextView) view.findViewById(R.id.jmr);
                    bVar3.gyr = (ImageView) view.findViewById(R.id.x1);
                    bVar3.kcZ = (TextView) view.findViewById(R.id.fz_);
                    bVar3.BCM = new c();
                    bVar3.BCM.ptQ = view.findViewById(R.id.bh2);
                    bVar3.BCM.eHK();
                    bVar3.BCN = new c();
                    bVar3.BCN.ptQ = view.findViewById(R.id.bh3);
                    bVar3.BCN.eHK();
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (b) view.getTag();
                }
                List<bv> Vo = Vo(i2);
                if (Vo == null || Vo.size() < 2) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                    bv bvVar = Vo.get(0);
                    bVar2.pwO.setText(com.tencent.mm.pluginsdk.i.f.c(this.context, bvVar.time, false));
                    c.a aVar = new c.a();
                    aVar.jbt = R.drawable.bar;
                    aVar.jbe = true;
                    aVar.iaT = true;
                    q.bcV().a(bvVar.aWc(), bVar2.gyr, aVar.bdv());
                    bVar2.kcZ.setText(bvVar.aWb());
                    bVar2.kcZ.getPaint().setFakeBoldText(true);
                    if (ReaderAppUI.this.BCr != null) {
                        bVar2.pwO.setTextColor(ReaderAppUI.this.BCr.Kbq);
                        if (ReaderAppUI.this.BCr.Kbr) {
                            bVar2.pwO.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.this.BCr.Kbs);
                        } else {
                            bVar2.pwO.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                        }
                        if (ReaderAppUI.this.BCr.Kbt) {
                            bVar2.pwO.setBackgroundResource(R.drawable.mr);
                            bVar2.pwO.setPadding(this.prx, this.BCz, this.prx, this.BCz);
                        } else {
                            bVar2.pwO.setBackgroundColor(0);
                        }
                    }
                    bVar2.BCM.a(bvVar, i2, bvVar.getTitle());
                    bVar2.BCN.a(Vo.get(1), i2, bvVar.getTitle());
                }
                AppMethodBeat.o(102738);
            } else {
                if (view == null) {
                    b bVar4 = new b();
                    view = View.inflate(this.context, R.layout.bko, null);
                    bVar4.pwO = (TextView) view.findViewById(R.id.gsj);
                    bVar4.BCJ = (ViewGroup) view.findViewById(R.id.gse);
                    bVar4.kmV = view.findViewById(R.id.aah);
                    bVar4.puc = view.findViewById(R.id.bh1);
                    bVar4.ptS = (ImageView) view.findViewById(R.id.ggb);
                    bVar4.BCL = (ImageView) view.findViewById(R.id.bhd);
                    bVar4.hbb = (TextView) view.findViewById(R.id.gsk);
                    bVar4.BCI = (ImageView) view.findViewById(R.id.gsi);
                    bVar4.znW = (TextView) view.findViewById(R.id.gsh);
                    bVar4.ptQ = view.findViewById(R.id.isf);
                    bVar4.BCK = (MMNeat7extView) view.findViewById(R.id.ir0);
                    bVar4.pxL = new ArrayList();
                    view.setTag(bVar4);
                    bVar = bVar4;
                } else {
                    bVar = (b) view.getTag();
                }
                for (C1626a aVar2 : bVar.pxL) {
                    bVar.BCJ.removeView(aVar2.puO);
                }
                bVar.pxL.clear();
                List<bv> Vo2 = Vo(i2);
                if (Vo2 != null && Vo2.size() > 0) {
                    int size = Vo2.size();
                    bv bvVar2 = Vo2.get(0);
                    bVar.pwO.setText(com.tencent.mm.pluginsdk.i.f.c(this.context, bvVar2.time, false));
                    if (ReaderAppUI.this.BCr != null) {
                        bVar.pwO.setTextColor(ReaderAppUI.this.BCr.Kbq);
                        if (ReaderAppUI.this.BCr.Kbr) {
                            bVar.pwO.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.this.BCr.Kbs);
                        } else {
                            bVar.pwO.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                        }
                        if (ReaderAppUI.this.BCr.Kbt) {
                            bVar.pwO.setBackgroundResource(R.drawable.mr);
                            bVar.pwO.setPadding(this.prx, this.BCz, this.prx, this.BCz);
                        } else {
                            bVar.pwO.setBackgroundColor(0);
                        }
                    }
                    bVar.ptQ.setOnClickListener(ReaderAppUI.this.a(bvVar2, ReaderAppUI.this.dXa, 0, bvVar2.getTitle()));
                    if (size == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar.hbb.setText(bvVar2.getTitle());
                    bVar.znW.setText(bvVar2.getDigest());
                    boolean z2 = !Util.isNullOrNil(bvVar2.aWd());
                    bVar.BCK.aw(bvVar2.getTitle());
                    bVar.znW.setVisibility((!z || Util.isNullOrNil(bvVar2.getDigest())) ? 8 : 0);
                    bVar.BCL.setVisibility(8);
                    if (z) {
                        bVar.ptS.setBackgroundResource(R.drawable.oj);
                        bVar.kmV.setVisibility(0);
                        bVar.BCK.setVisibility(8);
                        bVar.hbb.setVisibility(0);
                    } else {
                        bVar.ptS.setBackgroundResource(R.drawable.ok);
                        bVar.kmV.setVisibility(z2 ? 8 : 0);
                        bVar.hbb.setVisibility(8);
                        bVar.BCK.setVisibility(0);
                        bVar.BCK.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(R.color.wu));
                        bVar.BCK.setBackgroundResource(R.drawable.aij);
                        bVar.BCK.getPaint().setFakeBoldText(true);
                    }
                    W(bVar.ptS, this.BCA);
                    W(bVar.puc, this.BCA);
                    if (z2) {
                        bVar.puc.setVisibility(0);
                        String aWd = bvVar2.aWd();
                        ImageView imageView = bVar.BCI;
                        int i3 = this.BCA;
                        AnonymousClass2 r9 = new m.a() {
                            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a.AnonymousClass2 */

                            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
                            public final void onFinish() {
                                AppMethodBeat.i(102727);
                                if (!z) {
                                    bVar.BCK.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(R.color.ag2));
                                    bVar.BCK.setBackgroundResource(R.drawable.h7);
                                }
                                bVar.BCL.setVisibility(0);
                                AppMethodBeat.o(102727);
                            }

                            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
                            public final void onStart() {
                            }
                        };
                        String OO = t.OO(aWd);
                        float dimensionPixelSize = (float) imageView.getResources().getDimensionPixelSize(R.dimen.x2);
                        int jn = com.tencent.mm.cb.a.jn(ReaderAppUI.this.getContext()) - ((int) (ReaderAppUI.density * 28.0f));
                        com.tencent.mm.av.a.a bcV = q.bcV();
                        c.a aVar3 = new c.a();
                        aVar3.jbt = R.drawable.h2;
                        aVar3.jbf = true;
                        aVar3.jbv = "2131231240";
                        c.a dr = aVar3.dr(jn, i3);
                        dr.jaU = new n();
                        dr.jbC = new e();
                        dr.fullPath = com.tencent.mm.pluginsdk.model.s.bdu(OO);
                        bcV.a(OO, imageView, dr.bdv(), null, new com.tencent.mm.pluginsdk.ui.applet.m(0, jn, i3, true, false, dimensionPixelSize, r9));
                        bVar.kmV.setBackground(ar.e(ReaderAppUI.this.getResources().getDrawable(R.drawable.ny), this.context.getResources().getColor(R.color.f3045c)));
                        bVar.kmV.setPadding(this.prv, this.prw, this.prv, this.prv);
                        bVar.ptS.setVisibility(0);
                    } else {
                        bVar.puc.setVisibility(8);
                        bVar.hbb.setVisibility(0);
                        bVar.znW.setVisibility(Util.isNullOrNil(bvVar2.getDigest()) ? 8 : 0);
                        if (z) {
                            bVar.kmV.setBackgroundResource(R.drawable.o9);
                        } else {
                            bVar.kmV.setBackgroundResource(R.drawable.o6);
                        }
                        bVar.kmV.setPadding(this.prv, this.prv, this.prv, this.prv);
                        bVar.ptS.setVisibility(8);
                    }
                    if (size > 1) {
                        for (int i4 = 1; i4 < size - 1; i4++) {
                            a(bVar, Vo2, R.layout.bkw, i4, bvVar2.getTitle());
                        }
                        a(bVar, Vo2, R.layout.bkv, size - 1, bvVar2.getTitle());
                    }
                    com.tencent.mm.plugin.brandservice.a.e eVar = (com.tencent.mm.plugin.brandservice.a.e) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class);
                    if (eVar != null) {
                        eVar.a(bvVar2.getUrl(), TbsListener.ErrorCode.STARTDOWNLOAD_5, "wx073f4a4daff0abe8", bvVar2.getTitle(), bvVar2.getDigest(), "message", 8);
                        eVar.cF(bvVar2.getUrl(), 8);
                    }
                }
                bVar.ptQ.setTag(Integer.valueOf(i2));
                bVar.ptQ.setTag(R.id.gsv, 0);
                ReaderAppUI.this.pqr.a(bVar.ptQ, ReaderAppUI.a(ReaderAppUI.this, Vo2.size() == 1), ReaderAppUI.this.pso);
                int i5 = 1;
                for (C1626a aVar4 : bVar.pxL) {
                    aVar4.puO.setTag(Integer.valueOf(i2));
                    int i6 = i5 + 1;
                    aVar4.puO.setTag(R.id.gsv, Integer.valueOf(i5));
                    ReaderAppUI.this.pqr.a(aVar4.puO, ReaderAppUI.a(ReaderAppUI.this, Vo2.size() == 1), ReaderAppUI.this.pso);
                    i5 = i6;
                }
                AppMethodBeat.o(102738);
            }
            return view;
        }

        private List<bv> Vo(int i2) {
            AppMethodBeat.i(102739);
            List<bv> al = g.eHI().al(getItem(i2), 20);
            AppMethodBeat.o(102739);
            return al;
        }

        private void a(b bVar, List<bv> list, int i2, int i3, String str) {
            AppMethodBeat.i(102740);
            C1626a aVar = new C1626a();
            aVar.puO = View.inflate(this.context, i2, null);
            if (i2 == R.layout.bkw) {
                aVar.puO.setBackground(ar.c(ReaderAppUI.this.getResources().getDrawable(R.drawable.o5), at.jW(ReaderAppUI.this.getContext())));
            } else if (i2 == R.layout.bkv) {
                aVar.puO.setBackground(ar.c(ReaderAppUI.this.getResources().getDrawable(R.drawable.o4), at.jW(ReaderAppUI.this.getContext())));
            }
            aVar.hbb = (TextView) aVar.puO.findViewById(R.id.ipm);
            aVar.ptE = (ImageView) aVar.puO.findViewById(R.id.bgv);
            aVar.pxr = aVar.puO.findViewById(R.id.bgx);
            aVar.jBI = aVar.puO.findViewById(R.id.it2);
            aVar.pxo = aVar.puO.findViewById(R.id.bf0);
            a(bVar, aVar);
            bv bvVar = list.get(i3);
            a(aVar, i3, list);
            aVar.hbb.setText(bvVar.getTitle());
            aVar.hbb.setText(bvVar.getTitle());
            if (!Util.isNullOrNil(bvVar.aWd())) {
                aVar.ptE.setVisibility(0);
                a(bvVar.aWd(), aVar.ptE, this.pru, this.pru);
            } else {
                aVar.pxr.setVisibility(8);
            }
            aVar.puO.setOnClickListener(ReaderAppUI.this.a(bvVar, ReaderAppUI.this.dXa, i3, str));
            com.tencent.mm.plugin.brandservice.a.e eVar = (com.tencent.mm.plugin.brandservice.a.e) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class);
            if (eVar != null) {
                eVar.a(bvVar.getUrl(), TbsListener.ErrorCode.STARTDOWNLOAD_5, "wx073f4a4daff0abe8", bvVar.getTitle(), bvVar.getDigest(), "message", 16);
                eVar.cF(bvVar.getUrl(), 16);
            }
            AppMethodBeat.o(102740);
        }

        private static void W(View view, int i2) {
            AppMethodBeat.i(102741);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(102741);
        }

        private static void X(View view, int i2) {
            AppMethodBeat.i(102742);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.rightMargin = i2;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(102742);
        }

        private void a(C1626a aVar, int i2, List<bv> list) {
            AppMethodBeat.i(102743);
            int size = list.size();
            if (i2 != 1) {
                aVar.jBI.setVisibility(0);
                bv bvVar = list.get(i2);
                if (Util.isNullOrNil(list.get(i2 - 1).aWd()) || Util.isNullOrNil(bvVar.aWd())) {
                    X(aVar.jBI, this.prv);
                } else {
                    X(aVar.jBI, this.prz);
                }
            } else if (Util.isNullOrNil(list.get(0).aWd())) {
                aVar.jBI.setVisibility(0);
                X(aVar.jBI, this.prv);
            } else {
                aVar.jBI.setVisibility(8);
            }
            if (i2 == 1) {
                if (i2 == size - 1) {
                    aVar.pxo.setPadding(0, this.prv, 0, this.prv);
                    AppMethodBeat.o(102743);
                    return;
                }
                aVar.pxo.setPadding(0, this.prv, 0, this.prx);
                AppMethodBeat.o(102743);
            } else if (i2 == size - 1) {
                aVar.pxo.setPadding(0, this.prx, 0, this.prv);
                AppMethodBeat.o(102743);
            } else {
                aVar.pxo.setPadding(0, this.prx, 0, this.prx);
                AppMethodBeat.o(102743);
            }
        }

        private static void a(String str, ImageView imageView, int i2, int i3) {
            AppMethodBeat.i(102744);
            String OO = t.OO(str);
            com.tencent.mm.av.a.a bcV = q.bcV();
            c.a aVar = new c.a();
            aVar.jbt = R.color.j6;
            aVar.jbf = true;
            c.a dr = aVar.dr(i2, i3);
            dr.jaU = new n();
            dr.jbC = new e();
            dr.fullPath = com.tencent.mm.pluginsdk.model.s.bdu(OO);
            bcV.a(OO, imageView, dr.bdv(), null, new com.tencent.mm.pluginsdk.ui.applet.m((byte) 0));
            AppMethodBeat.o(102744);
        }

        @Override // com.tencent.mm.plugin.readerapp.ui.a
        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(102745);
            super.onScrollStateChanged(absListView, i2);
            if (absListView != null && i2 == 0) {
                hQ(absListView.getFirstVisiblePosition(), absListView.getLastVisiblePosition());
            }
            AppMethodBeat.o(102745);
        }

        private static e.a a(bv bvVar) {
            AppMethodBeat.i(238574);
            if (bvVar == null) {
                AppMethodBeat.o(238574);
                return null;
            }
            e.a aVar = new e.a();
            aVar.url = bvVar.getUrl();
            aVar.pmM = TbsListener.ErrorCode.STARTDOWNLOAD_5;
            aVar.appId = "wx073f4a4daff0abe8";
            aVar.title = bvVar.getTitle();
            aVar.desc = bvVar.getDigest();
            aVar.from = "message";
            AppMethodBeat.o(238574);
            return aVar;
        }

        public final void hQ(int i2, int i3) {
            AppMethodBeat.i(102746);
            Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth startPos = %s, endPos = %s", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 > i3) {
                AppMethodBeat.o(102746);
                return;
            }
            com.tencent.mm.plugin.brandservice.a.e eVar = (com.tencent.mm.plugin.brandservice.a.e) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class);
            if (eVar == null) {
                Log.v("MicroMsg.ReaderAppUI", "checkPreauth WebPrefetcher null");
                AppMethodBeat.o(102746);
                return;
            }
            LinkedList linkedList = new LinkedList();
            while (i2 <= i3) {
                List<bv> Vo = Vo(i2 - 1);
                if (Vo != null && Vo.size() > 0) {
                    linkedList.clear();
                    e.a a2 = a(Vo.get(0));
                    if (a2 != null) {
                        linkedList.add(a2);
                        eVar.cF(a2.url, 8);
                    }
                    if (linkedList.size() > 0) {
                        eVar.m(linkedList, 8);
                    }
                    Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authTop = %s", Integer.valueOf(linkedList.size()));
                    linkedList.clear();
                    for (int i4 = 1; i4 < Vo.size(); i4++) {
                        e.a a3 = a(Vo.get(i4));
                        if (a3 != null) {
                            linkedList.add(a3);
                            eVar.cF(a3.url, 16);
                        }
                    }
                    if (linkedList.size() > 0) {
                        eVar.m(linkedList, 16);
                    }
                    Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authCommon = %s", Integer.valueOf(linkedList.size()));
                }
                i2++;
            }
            AppMethodBeat.o(102746);
        }

        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(102748);
            String string = cursor.getString(0);
            AppMethodBeat.o(102748);
            return string;
        }

        static /* synthetic */ void a(a aVar, String str, ImageView imageView, m.a aVar2) {
            AppMethodBeat.i(102750);
            String OO = t.OO(str);
            int jn = (int) ((((float) com.tencent.mm.cb.a.jn(ReaderAppUI.this.getContext())) - (ReaderAppUI.density * 52.0f)) / 2.0f);
            float dimensionPixelSize = (float) imageView.getResources().getDimensionPixelSize(R.dimen.ahj);
            com.tencent.mm.av.a.a bcV = q.bcV();
            c.a aVar3 = new c.a();
            aVar3.jbt = R.drawable.h5;
            aVar3.jbf = true;
            aVar3.jbv = "reader_weishi";
            c.a dr = aVar3.dr(jn, aVar.BCB);
            dr.jaU = new n();
            dr.jbC = new com.tencent.mm.pluginsdk.ui.applet.e();
            dr.fullPath = com.tencent.mm.pluginsdk.model.s.bdu(OO);
            bcV.a(OO, imageView, dr.bdv(), null, new com.tencent.mm.pluginsdk.ui.applet.m(0, jn, aVar.BCB, true, true, dimensionPixelSize, aVar2));
            AppMethodBeat.o(102750);
        }
    }

    private PackageInfo aKQ(String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.i(102759);
        if (str.length() == 0) {
            AppMethodBeat.o(102759);
        } else {
            try {
                packageInfo = getContext().getPackageManager().getPackageInfo(str, 0);
                AppMethodBeat.o(102759);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.ReaderAppUI", e2, "", new Object[0]);
                AppMethodBeat.o(102759);
            }
        }
        return packageInfo;
    }

    public final View.OnClickListener a(final bv bvVar, final int i2, final int i3, final String str) {
        AppMethodBeat.i(102758);
        if (bvVar != null) {
            String bfG = z.bfG(bvVar.getUrl());
            String bfG2 = z.bfG(str);
            String bfG3 = z.bfG(bvVar.getTitle());
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15413, 9, bfG2, bfG3, bvVar.avy(), bvVar.aVZ(), bfG, Integer.valueOf(bvVar.aWh()), Integer.valueOf(bvVar.aWf()));
        }
        AnonymousClass2 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(161677);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (20 == i2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15413, 8, str, bvVar.getTitle());
                    Intent intent = new Intent();
                    intent.putExtra("mode", 1);
                    String url = bvVar.getUrl();
                    intent.putExtra("news_svr_id", bvVar.iFs);
                    intent.putExtra("news_svr_tweetid", bvVar.aVZ());
                    intent.putExtra("rawUrl", ReaderAppUI.a(ReaderAppUI.this, url));
                    intent.putExtra("title", bvVar.getName());
                    intent.putExtra("webpageTitle", bvVar.getTitle());
                    intent.putExtra("key_show_web_page_title", true);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    Bundle bundle = new Bundle();
                    bundle.putInt("snsWebSource", 3);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("shortUrl", bvVar.aWa());
                    intent.putExtra("type", bvVar.type);
                    intent.putExtra("tweetid", bvVar.aVZ());
                    intent.putExtra("geta8key_username", "newsapp");
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(bvVar.iFs));
                    intent.putExtra("pre_username", "newsapp");
                    intent.putExtra("prePublishId", "msg_" + Long.toString(bvVar.iFs));
                    intent.putExtra("preUsername", "newsapp");
                    intent.putExtra("preChatName", "newsapp");
                    intent.putExtra("preMsgIndex", i3);
                    intent.putExtra("geta8key_scene", 66);
                    intent.putExtra("webview_scene_type", 1);
                    intent.putExtra("webview_scene_note", z.bfG(String.format("%d|%d|%s|%s|%s", Integer.valueOf(bvVar.aWh()), Integer.valueOf(bvVar.aWf()), bvVar.avy(), str, bvVar.aVZ())));
                    intent.putExtra("bizEnterId", (int) (System.currentTimeMillis() / 1000));
                    intent.putExtra("KOpenArticleSceneFromScene", 0);
                    intent.addFlags(536870912);
                    com.tencent.mm.plugin.readerapp.b.a.jRt.i(intent, ReaderAppUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(161677);
            }
        };
        AppMethodBeat.o(102758);
        return r0;
    }

    static /* synthetic */ o.e a(ReaderAppUI readerAppUI, final boolean z) {
        AppMethodBeat.i(238575);
        AnonymousClass1 r0 = new o.e() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.e
            public final void a(com.tencent.mm.ui.base.m mVar, View view) {
                AppMethodBeat.i(238573);
                int intValue = ((Integer) view.getTag()).intValue();
                mVar.clear();
                if (20 == ReaderAppUI.this.dXa) {
                    if (z) {
                        mVar.a(intValue, 0, ReaderAppUI.this.getResources().getString(R.string.ftw), R.raw.icons_filled_share);
                    }
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        mVar.a(intValue, 1, ReaderAppUI.this.getResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
                    }
                    ReaderAppUI.this.BCs = ((Integer) view.getTag(R.id.gsv)).intValue();
                }
                mVar.a(intValue, 2, ReaderAppUI.this.getResources().getString(R.string.ftv), R.raw.icons_filled_delete);
                AppMethodBeat.o(238573);
            }
        };
        AppMethodBeat.o(238575);
        return r0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.String a(com.tencent.mm.plugin.readerapp.ui.ReaderAppUI r5, java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 221
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a(com.tencent.mm.plugin.readerapp.ui.ReaderAppUI, java.lang.String):java.lang.String");
    }
}
