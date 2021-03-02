package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class BackupMoveChooseUI extends MMWizardActivity {
    private static int beK = 0;
    private static long endTime;
    private static int oMY = 0;
    private static long startTime;
    private a oMJ = new a(this);
    private ListView oMK;
    private TextView oML;
    private TextView oMM;
    private TextView oMN;
    private ProgressBar oMO;
    private View oMP;
    private LinearLayout oMQ;
    private LinearLayout oMR;
    private LinearLayout oMS;
    private LinearLayout oMT;
    private TextView oMU;
    private TextView oMV;
    private TextView oMW;
    private Button oMX;
    private SimpleDateFormat oMZ = new SimpleDateFormat("yyyy.MM.dd");
    private b.AbstractC0842b oNa = new b.AbstractC0842b() {
        /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.backup.c.b.AbstractC0842b
        public final void a(LinkedList<f.b> linkedList, f.b bVar, int i2) {
        }

        @Override // com.tencent.mm.plugin.backup.c.b.AbstractC0842b
        public final void D(LinkedList<f.b> linkedList) {
        }

        @Override // com.tencent.mm.plugin.backup.c.b.a
        public final void C(LinkedList<f.b> linkedList) {
            AppMethodBeat.i(21386);
            if (linkedList == null) {
                AppMethodBeat.o(21386);
            } else if (linkedList.size() == 0) {
                BackupMoveChooseUI.this.oMO.setVisibility(8);
                BackupMoveChooseUI.this.oMM.setVisibility(0);
                switch (BackupMoveChooseUI.oMY) {
                    case 0:
                        BackupMoveChooseUI.this.oMM.setText(R.string.a58);
                        AppMethodBeat.o(21386);
                        return;
                    case 1:
                        BackupMoveChooseUI.this.oMM.setText(R.string.a99);
                        break;
                }
                AppMethodBeat.o(21386);
            } else {
                BackupMoveChooseUI.this.oML.setClickable(true);
                BackupMoveChooseUI.this.oML.setTextColor(BackupMoveChooseUI.this.getResources().getColor(R.color.ev));
                BackupMoveChooseUI.this.oMO.setVisibility(8);
                BackupMoveChooseUI.this.oMJ.notifyDataSetChanged();
                AppMethodBeat.o(21386);
            }
        }
    };

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupMoveChooseUI() {
        AppMethodBeat.i(21387);
        AppMethodBeat.o(21387);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21388);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(21388);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(21389);
        super.onStart();
        com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLd = this.oNa;
        AppMethodBeat.o(21389);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(21390);
        super.onStop();
        com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLd = null;
        AppMethodBeat.o(21390);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(21391);
        setMMTitle(R.string.a9h);
        this.oMK = (ListView) findViewById(R.id.yd);
        this.oMK.setAdapter((ListAdapter) this.oMJ);
        this.oMK.setEmptyView(findViewById(R.id.yf));
        this.oML = (TextView) findViewById(R.id.yl);
        this.oMM = (TextView) findViewById(R.id.ye);
        this.oMO = (ProgressBar) findViewById(R.id.yk);
        this.oMN = (TextView) findViewById(R.id.yg);
        this.oMP = findViewById(R.id.yj);
        this.oMQ = (LinearLayout) findViewById(R.id.yh);
        this.oMR = (LinearLayout) findViewById(R.id.ym);
        this.oMS = (LinearLayout) findViewById(R.id.yp);
        this.oMT = (LinearLayout) findViewById(R.id.ya);
        this.oMU = (TextView) findViewById(R.id.yo);
        this.oMV = (TextView) findViewById(R.id.yr);
        this.oMW = (TextView) findViewById(R.id.yc);
        ((TextView) findViewById(R.id.yn)).setText(R.string.a59);
        ((TextView) findViewById(R.id.yq)).setText(R.string.a5a);
        ((TextView) findViewById(R.id.yb)).setText(R.string.a57);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21382);
                BackupMoveChooseUI.this.finish();
                AppMethodBeat.o(21382);
                return false;
            }
        });
        this.oMX = (Button) findViewById(R.id.yi);
        this.oMX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.AnonymousClass2 */

            public final void onClick(View view) {
                LinkedList linkedList;
                boolean z;
                boolean z2;
                AppMethodBeat.i(21383);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                PLong pLong = new PLong();
                PInt pInt = new PInt();
                a aVar = BackupMoveChooseUI.this.oMJ;
                LinkedList linkedList2 = new LinkedList();
                if (aVar.oMG.size() <= 0) {
                    linkedList = linkedList2;
                } else {
                    pLong.value = 0;
                    pInt.value = 0;
                    LinkedList<f.b> cfr = com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr();
                    if (cfr != null) {
                        for (int i2 = 0; i2 < aVar.getCount(); i2++) {
                            if (aVar.oMG.contains(Integer.valueOf(i2))) {
                                linkedList2.add(cfr.get(i2));
                                pLong.value += cfr.get(i2).oJt;
                                pInt.value = (int) (((long) pInt.value) + cfr.get(i2).oJu);
                            }
                        }
                    }
                    Log.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(pInt.value));
                    linkedList = linkedList2;
                }
                LinkedList<String> B = g.B(linkedList);
                com.tencent.mm.plugin.backup.d.a cfz = com.tencent.mm.plugin.backup.d.b.cfv().cfz();
                if (linkedList.size() == 0) {
                    cfz.oLh = new LinkedList<>();
                } else {
                    cfz.oLh = new LinkedList<>(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
                    cfz.oLh.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
                }
                com.tencent.mm.plugin.backup.d.b.cfv().cfx().G(B);
                com.tencent.mm.plugin.backup.d.a cfz2 = com.tencent.mm.plugin.backup.d.b.cfv().cfz();
                if (cfz2.oLc != null) {
                    cfz2.oLc.cancel();
                }
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.backup.d.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(21276);
                        Log.i("MicroMsg.BackupMoveChooseServer", "start calculateChooseConvSize");
                        a.this.oLc = new b();
                        b bVar = a.this.oLc;
                        LinkedList<f.b> cfs = a.this.cfs();
                        a aVar = a.this;
                        long j2 = b.cfv().ceM().oJk;
                        long nowMilliSecond = Util.nowMilliSecond();
                        String str = (String) d.cgP().cgQ().azQ().get(2, (Object) null);
                        int i2 = 0;
                        Iterator<f.b> it = cfs.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                f.b next = it.next();
                                if (next.oJt < 0) {
                                    if (bVar.a(next, str, j2)) {
                                        break;
                                    }
                                    i2++;
                                    if (!bVar.oJF && aVar != null) {
                                        MMHandlerThread.postToMainThread(new Runnable(aVar, cfs, next.ceW(), i2) {
                                            /* class com.tencent.mm.plugin.backup.c.b.AnonymousClass3 */
                                            final /* synthetic */ AbstractC0842b oJJ;
                                            final /* synthetic */ LinkedList oJK;
                                            final /* synthetic */ f.b oJL;
                                            final /* synthetic */ int oJM;

                                            {
                                                this.oJJ = r2;
                                                this.oJK = r3;
                                                this.oJL = r4;
                                                this.oJM = r5;
                                            }

                                            public final void run() {
                                                AppMethodBeat.i(21227);
                                                if (!b.this.oJF && this.oJJ != null) {
                                                    this.oJJ.a(this.oJK, this.oJL, this.oJM);
                                                }
                                                AppMethodBeat.o(21227);
                                            }
                                        });
                                    }
                                } else {
                                    i2++;
                                }
                            } else {
                                Log.i("MicroMsg.BackupCalculator", "calculChooseConvSize all, userSize:%d", Integer.valueOf(cfs.size()));
                                if (!bVar.oJF && aVar != null) {
                                    MMHandlerThread.postToMainThread(new Runnable(aVar, cfs) {
                                        /* class com.tencent.mm.plugin.backup.c.b.AnonymousClass4 */
                                        final /* synthetic */ AbstractC0842b oJJ;
                                        final /* synthetic */ LinkedList oJK;

                                        {
                                            this.oJJ = r2;
                                            this.oJK = r3;
                                        }

                                        public final void run() {
                                            AppMethodBeat.i(21228);
                                            if (!b.this.oJF && this.oJJ != null) {
                                                this.oJJ.D(this.oJK);
                                            }
                                            AppMethodBeat.o(21228);
                                        }
                                    });
                                }
                                Log.d("MicroMsg.BackupCalculator", "calculChooseConvSize loading time[%d]", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
                            }
                        }
                        AppMethodBeat.o(21276);
                    }
                }, "BackupMoveChooseServer.calculateChooseConvSize");
                boolean z3 = false;
                if (BackupMoveChooseUI.oMY == 1 && BackupMoveChooseUI.beK == 1) {
                    h.INSTANCE.idkeyStat(485, 26, 1, false);
                    h.INSTANCE.idkeyStat(485, 27, 1, false);
                    h.INSTANCE.a(11788, 7);
                    h.INSTANCE.a(11788, 14, Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.startTime), Long.valueOf(BackupMoveChooseUI.endTime));
                    z2 = false;
                } else if (BackupMoveChooseUI.oMY == 1) {
                    h.INSTANCE.idkeyStat(485, 26, 1, false);
                    h.INSTANCE.a(11788, 5);
                    h.INSTANCE.a(11788, 14, Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.startTime), Long.valueOf(BackupMoveChooseUI.endTime));
                    z2 = false;
                } else if (BackupMoveChooseUI.beK == 1) {
                    h.INSTANCE.idkeyStat(485, 27, 1, false);
                    h.INSTANCE.a(11788, 6);
                    z2 = false;
                } else {
                    a aVar2 = BackupMoveChooseUI.this.oMJ;
                    if (aVar2.oMG.size() == aVar2.getCount()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        z3 = true;
                        h.INSTANCE.idkeyStat(485, 22, 1, false);
                        h.INSTANCE.a(11788, 4);
                    }
                    z2 = z3;
                }
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[3];
                objArr[0] = 13;
                objArr[1] = Integer.valueOf(linkedList.size());
                objArr[2] = Integer.valueOf(z2 ? 1 : 0);
                hVar.a(11788, objArr);
                h.INSTANCE.a(11788, 8);
                MMWizardActivity.ay(BackupMoveChooseUI.this, new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class));
                h.INSTANCE.idkeyStat(485, 23, 1, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21383);
            }
        });
        this.oMX.setEnabled(false);
        jC(true);
        this.oMN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(21384);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
                intent.putExtra("BACKUP_MODE", 2);
                intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.oMY);
                intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
                intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.beK);
                intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.startTime);
                intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
                intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLe);
                BackupMoveChooseUI.this.startActivityForResult(intent, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21384);
            }
        });
        this.oML.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(21385);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLi) {
                    a aVar = BackupMoveChooseUI.this.oMJ;
                    if (aVar.oMG.size() == aVar.getCount()) {
                        aVar.oMG.clear();
                    } else {
                        for (int i2 = 0; i2 < aVar.getCount(); i2++) {
                            aVar.oMG.add(Integer.valueOf(i2));
                        }
                    }
                    aVar.notifyDataSetChanged();
                    aVar.oMF.a(aVar.oMG);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21385);
            }
        });
        if (com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLi) {
            if (com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr() == null || com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr().size() == 0) {
                switch (oMY) {
                    case 0:
                        this.oMM.setText(R.string.a58);
                        break;
                    case 1:
                        this.oMM.setText(R.string.a99);
                        break;
                }
                this.oMM.setVisibility(0);
            }
            this.oMO.setVisibility(4);
            AppMethodBeat.o(21391);
        } else if (!com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLi) {
            this.oML.setTextColor(getResources().getColor(R.color.ex));
            this.oML.setClickable(false);
            this.oMO.setVisibility(0);
            AppMethodBeat.o(21391);
        } else {
            this.oMO.setVisibility(4);
            AppMethodBeat.o(21391);
        }
    }

    private void jC(boolean z) {
        AppMethodBeat.i(21392);
        if (z) {
            com.tencent.mm.plugin.backup.d.b.cfv();
            SharedPreferences ceR = com.tencent.mm.plugin.backup.d.b.ceR();
            oMY = ceR.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
            beK = ceR.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = ceR.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
            endTime = ceR.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        }
        switch (oMY) {
            case 0:
                this.oMS.setVisibility(8);
                break;
            case 1:
                this.oMP.setVisibility(0);
                this.oMQ.setVisibility(0);
                this.oMS.setVisibility(0);
                this.oMV.setText(this.oMZ.format(new Date(startTime)) + "~" + this.oMZ.format(new Date(endTime - Util.MILLSECONDS_OF_DAY)));
                break;
        }
        switch (beK) {
            case 0:
                this.oMT.setVisibility(8);
                break;
            case 1:
                this.oMP.setVisibility(0);
                this.oMQ.setVisibility(0);
                this.oMT.setVisibility(0);
                this.oMW.setText(getContext().getResources().getString(R.string.a6x));
                break;
        }
        cfQ();
        AppMethodBeat.o(21392);
    }

    public final void a(HashSet<Integer> hashSet) {
        AppMethodBeat.i(21393);
        LinkedList<f.b> cfr = com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr();
        if (cfr == null) {
            Log.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
            AppMethodBeat.o(21393);
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator<Integer> it = hashSet.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue < cfr.size()) {
                j2 = cfr.get(intValue).oJt + j2;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j2 > 0) {
            this.oMX.setEnabled(true);
            if (hashSet.size() == this.oMJ.getCount()) {
                this.oML.setText(R.string.a4z);
            } else {
                this.oML.setText(R.string.a4y);
            }
            this.oMP.setVisibility(0);
            this.oMQ.setVisibility(0);
            this.oMR.setVisibility(0);
            this.oMU.setText(getString(R.string.a51, new Object[]{Integer.valueOf(hashSet.size())}));
        } else {
            this.oMX.setEnabled(false);
            this.oML.setText(R.string.a4y);
            this.oMR.setVisibility(8);
            this.oMU.setText("");
        }
        cfQ();
        AppMethodBeat.o(21393);
    }

    private void cfQ() {
        AppMethodBeat.i(21394);
        if (this.oMR.getVisibility() == 8 && this.oMS.getVisibility() == 8 && this.oMT.getVisibility() == 8) {
            this.oMP.setVisibility(8);
            this.oMQ.setVisibility(8);
            AppMethodBeat.o(21394);
            return;
        }
        this.oMP.setVisibility(0);
        this.oMQ.setVisibility(0);
        AppMethodBeat.o(21394);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(21395);
        if (i3 != -1) {
            Log.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", Integer.valueOf(i3));
            AppMethodBeat.o(21395);
            return;
        }
        int i4 = oMY;
        long j2 = startTime;
        long j3 = endTime;
        oMY = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", oMY);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        beK = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", beK);
        Log.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", Integer.valueOf(oMY), Integer.valueOf(i4), Long.valueOf(startTime), Long.valueOf(j2), Long.valueOf(endTime), Long.valueOf(j3), Integer.valueOf(beK));
        com.tencent.mm.plugin.backup.d.b.cfv().cfx();
        com.tencent.mm.plugin.backup.d.d.e(oMY, startTime, endTime, beK);
        jC(false);
        if (i4 == oMY && (oMY == 0 || (oMY == 1 && startTime == j2 && endTime == j3))) {
            AppMethodBeat.o(21395);
            return;
        }
        com.tencent.mm.plugin.backup.d.b.cfv().cfz().a(oMY, startTime, endTime, com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfq());
        a aVar = this.oMJ;
        aVar.oMG.clear();
        aVar.oMF.a(aVar.oMG);
        if (com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr() == null || com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr().size() == 0) {
            switch (oMY) {
                case 0:
                    this.oMM.setText(R.string.a58);
                    break;
                case 1:
                    this.oMM.setText(R.string.a99);
                    break;
            }
            this.oMM.setVisibility(0);
        } else {
            this.oMM.setVisibility(4);
        }
        this.oMJ.notifyDataSetChanged();
        AppMethodBeat.o(21395);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.hm;
    }
}
