package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.k;
import com.tencent.mm.audio.a.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.plugin.masssend.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.l;
import junit.framework.Assert;

public class MassSendHistoryUI extends MMActivity implements k.a, k.b, SensorController.SensorEventCallBack {
    private static SensorController qUq;
    private a doD;
    private View poS;
    private o.g pso = new o.g() {
        /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass4 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(26419);
            if (menuItem.getItemId() == 1) {
                com.tencent.mm.plugin.masssend.a.a aVar = (com.tencent.mm.plugin.masssend.a.a) MassSendHistoryUI.this.zod.getItem(menuItem.getGroupId());
                if (aVar == null) {
                    AppMethodBeat.o(26419);
                    return;
                }
                if (aVar.ehw().equals(MassSendHistoryUI.this.zod.znR)) {
                    MassSendHistoryUI.h(MassSendHistoryUI.this);
                }
                b ehF = h.ehF();
                String ehw = aVar.ehw();
                Cursor rawQuery = ehF.iFy.rawQuery("select * from massendinfo ORDER BY createtime DESC  limit 2", null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() == 0) {
                        rawQuery.close();
                    } else if (rawQuery.getCount() == 1) {
                        rawQuery.moveToFirst();
                        com.tencent.mm.plugin.masssend.a.a aVar2 = new com.tencent.mm.plugin.masssend.a.a();
                        aVar2.convertFrom(rawQuery);
                        rawQuery.close();
                        az azVar = new az();
                        azVar.setUsername("masssendapp");
                        azVar.setContent(MMApplicationContext.getContext().getResources().getString(R.string.bcm));
                        azVar.yA(aVar2.createTime);
                        azVar.nv(0);
                        azVar.nt(0);
                        bg.aVF();
                        c.aST().a(azVar, "masssendapp");
                    } else {
                        rawQuery.moveToPosition(1);
                        com.tencent.mm.plugin.masssend.a.a aVar3 = new com.tencent.mm.plugin.masssend.a.a();
                        aVar3.convertFrom(rawQuery);
                        rawQuery.close();
                        az azVar2 = new az();
                        azVar2.setUsername("masssendapp");
                        azVar2.setContent(b.a(aVar3));
                        azVar2.yA(aVar3.createTime);
                        azVar2.nv(0);
                        azVar2.nt(0);
                        bg.aVF();
                        c.aST().a(azVar2, "masssendapp");
                    }
                }
                if (ehF.iFy.delete("massendinfo", "clientid= ?", new String[]{String.valueOf(ehw)}) > 0) {
                    ehF.doNotify();
                }
            }
            AppMethodBeat.o(26419);
        }
    };
    private boolean qUm = true;
    private boolean yMq = false;
    private ListView zoc;
    private c zod;
    private Button zoe;
    private Button zof;
    private MMPullDownView zog;
    private LinearLayout zoh;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MassSendHistoryUI() {
        AppMethodBeat.i(26428);
        AppMethodBeat.o(26428);
    }

    static /* synthetic */ boolean a(MassSendHistoryUI massSendHistoryUI, String str) {
        AppMethodBeat.i(26443);
        boolean startPlay = massSendHistoryUI.startPlay(str);
        AppMethodBeat.o(26443);
        return startPlay;
    }

    static /* synthetic */ void h(MassSendHistoryUI massSendHistoryUI) {
        AppMethodBeat.i(26444);
        massSendHistoryUI.stopPlay();
        AppMethodBeat.o(26444);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26429);
        super.onCreate(bundle);
        setMMTitle(R.string.ey9);
        if (qUq == null) {
            qUq = new SensorController(getApplicationContext());
        }
        initView();
        this.doD = new a(this);
        this.doD.dyn = this;
        this.doD.dym = this;
        this.zod.znS = new c.e() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.masssend.ui.c.e
            public final String aDQ(String str) {
                AppMethodBeat.i(26416);
                bg.aVF();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    u.g(MassSendHistoryUI.this, null);
                    AppMethodBeat.o(26416);
                    return "";
                }
                String nullAsNil = Util.nullAsNil(str);
                if (MassSendHistoryUI.this.doD.isPlaying() && nullAsNil.equals(MassSendHistoryUI.this.zod.znR)) {
                    MassSendHistoryUI.ehS();
                    MassSendHistoryUI.this.releaseWakeLock();
                    MassSendHistoryUI.this.doD.stop(false);
                    AppMethodBeat.o(26416);
                    return "";
                } else if (MassSendHistoryUI.a(MassSendHistoryUI.this, nullAsNil)) {
                    AppMethodBeat.o(26416);
                    return nullAsNil;
                } else {
                    AppMethodBeat.o(26416);
                    return "";
                }
            }
        };
        if (this.mController != null) {
            this.mController.bF(3, false);
        }
        AppMethodBeat.o(26429);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(26430);
        super.onResume();
        h.ehF().add(this.zod);
        this.zod.onNotifyChange(null, null);
        this.zoc.setSelection(this.zod.getCount() - 1);
        AppMethodBeat.o(26430);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(26431);
        super.onPause();
        h.ehF().remove(this.zod);
        qUq.removeSensorCallBack();
        AppMethodBeat.o(26431);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(26432);
        stopPlay();
        this.zod.ebf();
        super.onDestroy();
        AppMethodBeat.o(26432);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b6j;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(26433);
        this.yMq = getIntent().getBooleanExtra("finish_direct", false);
        Log.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.yMq);
        this.zoh = (LinearLayout) findViewById(R.id.faw);
        this.zoc = (ListView) findViewById(R.id.faf);
        this.zoc.setTranscriptMode(0);
        this.zog = (MMPullDownView) findViewById(R.id.fag);
        this.zog.setOnTopLoadDataListener(new MMPullDownView.g() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.g
            public final boolean cAm() {
                int i2 = 0;
                AppMethodBeat.i(26420);
                if (MassSendHistoryUI.this.zod.cwg()) {
                    MassSendHistoryUI.this.zoc.setSelectionFromTop(0, MassSendHistoryUI.this.zog.getTopHeight());
                    AppMethodBeat.o(26420);
                } else {
                    c cVar = MassSendHistoryUI.this.zod;
                    if (!cVar.cwg()) {
                        cVar.qdp += 10;
                        if (cVar.qdp <= cVar.gAZ) {
                            i2 = 10;
                        } else {
                            cVar.qdp = cVar.gAZ;
                            i2 = cVar.gAZ % 10;
                        }
                    }
                    Log.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:".concat(String.valueOf(i2)));
                    MassSendHistoryUI.this.zod.onNotifyChange(null, null);
                    MassSendHistoryUI.this.zoc.setSelectionFromTop(i2, MassSendHistoryUI.this.zog.getTopHeight());
                    AppMethodBeat.o(26420);
                }
                return true;
            }
        });
        this.zog.setTopViewVisible(true);
        this.zog.setAtBottomCallBack(new MMPullDownView.c() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.c
            public final boolean cAl() {
                AppMethodBeat.i(26421);
                if (MassSendHistoryUI.this.zoc.getChildAt(MassSendHistoryUI.this.zoc.getChildCount() - 1).getBottom() > MassSendHistoryUI.this.zoc.getHeight() || MassSendHistoryUI.this.zoc.getLastVisiblePosition() != MassSendHistoryUI.this.zoc.getAdapter().getCount() - 1) {
                    AppMethodBeat.o(26421);
                    return false;
                }
                AppMethodBeat.o(26421);
                return true;
            }
        });
        this.zog.setAtTopCallBack(new MMPullDownView.d() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.d
            public final boolean cAk() {
                AppMethodBeat.i(26422);
                View childAt = MassSendHistoryUI.this.zoc.getChildAt(MassSendHistoryUI.this.zoc.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    AppMethodBeat.o(26422);
                    return false;
                }
                AppMethodBeat.o(26422);
                return true;
            }
        });
        this.zog.setIsBottomShowAll(true);
        this.zod = new c(this);
        this.zod.a(new s.a() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(26423);
                MassSendHistoryUI.this.zog.setIsTopShowAll(MassSendHistoryUI.this.zod.cwg());
                if (MassSendHistoryUI.this.zod.getCount() == 0) {
                    MassSendHistoryUI.this.zog.setVisibility(8);
                    MassSendHistoryUI.this.poS.setVisibility(0);
                    MassSendHistoryUI.this.zoh.setVisibility(8);
                    AppMethodBeat.o(26423);
                    return;
                }
                MassSendHistoryUI.this.zog.setVisibility(0);
                MassSendHistoryUI.this.poS.setVisibility(8);
                MassSendHistoryUI.this.zoh.setVisibility(0);
                AppMethodBeat.o(26423);
            }
        });
        this.poS = findViewById(R.id.fae);
        this.zoc.setAdapter((ListAdapter) this.zod);
        this.zoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass9 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(26424);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.v("MicroMsg.MassSendHistoryUI", "onItemClick");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(26424);
            }
        });
        this.zoc.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass10 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(26425);
                Log.v("MicroMsg.MassSendHistoryUI", "onTouch");
                AppMethodBeat.o(26425);
                return false;
            }
        });
        this.zoe = (Button) findViewById(R.id.fav);
        this.zoe.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(26426);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class);
                MassSendHistoryUI massSendHistoryUI = MassSendHistoryUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(massSendHistoryUI, bl.axQ(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                massSendHistoryUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(massSendHistoryUI, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26426);
            }
        });
        this.zof = (Button) findViewById(R.id.fax);
        this.zof.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(26427);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class);
                MassSendHistoryUI massSendHistoryUI = MassSendHistoryUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(massSendHistoryUI, bl.axQ(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                massSendHistoryUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(massSendHistoryUI, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26427);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26417);
                if (MassSendHistoryUI.this.yMq) {
                    MassSendHistoryUI.this.finish();
                } else {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.masssend.a.jRt.o(intent, MassSendHistoryUI.this);
                    MassSendHistoryUI.this.finish();
                }
                AppMethodBeat.o(26417);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.yv, R.raw.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26418);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "masssendapp");
                com.tencent.mm.plugin.masssend.a.jRt.c(intent, MassSendHistoryUI.this);
                AppMethodBeat.o(26418);
                return true;
            }
        });
        new l(this).a(this.zoc, this, this.pso);
        AppMethodBeat.o(26433);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(26434);
        if (i2 == 4) {
            if (this.yMq) {
                finish();
            } else {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.masssend.a.jRt.o(intent, this);
                finish();
            }
            AppMethodBeat.o(26434);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(26434);
        return onKeyDown;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(26435);
        Log.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        String[] split = ((com.tencent.mm.plugin.masssend.a.a) this.zod.getItem(adapterContextMenuInfo.position)).ehz().split(";");
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(str);
            if (Kn != null) {
                sb.append(Kn.arJ() + ";");
            }
        }
        contextMenu.setHeaderTitle(sb.toString());
        contextMenu.add(adapterContextMenuInfo.position, 1, 0, getString(R.string.b06));
        AppMethodBeat.o(26435);
    }

    /* access modifiers changed from: protected */
    public final void releaseWakeLock() {
        AppMethodBeat.i(26436);
        this.zoc.setKeepScreenOn(false);
        AppMethodBeat.o(26436);
    }

    @Override // com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack
    public void onSensorEvent(boolean z) {
        AppMethodBeat.i(26437);
        if (this.doD == null) {
            AppMethodBeat.o(26437);
        } else if (!this.doD.isPlaying()) {
            this.doD.cU(true);
            com.tencent.mm.plugin.audio.c.a.agr("music").jp(true);
            this.qUm = true;
            AppMethodBeat.o(26437);
        } else {
            this.doD.cU(z);
            com.tencent.mm.plugin.audio.c.a.agr("music").jp(z);
            this.qUm = z;
            if (!z) {
                if (startPlay(this.zod.znR)) {
                    this.zod.aDP(this.zod.znR);
                    AppMethodBeat.o(26437);
                    return;
                }
                this.zod.aDP("");
            }
            AppMethodBeat.o(26437);
        }
    }

    private boolean startPlay(String str) {
        AppMethodBeat.i(26438);
        Assert.assertTrue(str != null);
        qUq.setSensorCallBack(this);
        com.tencent.mm.plugin.masssend.a.a aDL = h.ehF().aDL(str);
        bg.aVF();
        if (com.tencent.mm.model.c.isSDCardAvailable() || Util.isNullOrNil(aDL.ehx())) {
            if (this.doD == null) {
                this.doD = new a(this);
            }
            this.doD.stop(false);
            if (this.doD.n(aDL.ehx(), this.qUm)) {
                com.tencent.mm.plugin.audio.c.a.agr("music").jp(this.qUm);
                this.doD.dyn = this;
                this.doD.dym = this;
                AppMethodBeat.o(26438);
                return true;
            }
            Toast.makeText(this, getString(R.string.b1n), 0).show();
            AppMethodBeat.o(26438);
            return false;
        }
        u.g(this, null);
        AppMethodBeat.o(26438);
        return false;
    }

    @Override // com.tencent.mm.ak.k.a
    public final void onCompletion() {
        AppMethodBeat.i(26440);
        stopPlay();
        AppMethodBeat.o(26440);
    }

    @Override // com.tencent.mm.ak.k.b
    public final void onError() {
        AppMethodBeat.i(26441);
        stopPlay();
        AppMethodBeat.o(26441);
    }

    private void stopPlay() {
        AppMethodBeat.i(26439);
        qUq.removeSensorCallBack();
        this.doD.stop(false);
        this.zod.aDP("");
        releaseWakeLock();
        AppMethodBeat.o(26439);
    }

    static /* synthetic */ void ehS() {
        AppMethodBeat.i(26442);
        qUq.removeSensorCallBack();
        AppMethodBeat.o(26442);
    }
}
