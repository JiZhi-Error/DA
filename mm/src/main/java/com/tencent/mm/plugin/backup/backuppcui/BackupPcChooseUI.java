package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class BackupPcChooseUI extends MMWizardActivity {
    private static int beK = 0;
    private static long endTime;
    private static int oMY = 0;
    private static long startTime;
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
    private a oOR = new a(this);
    private ListView oOS;
    private b.a oOT = new b.a() {
        /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.backup.c.b.a
        public final void C(LinkedList<f.b> linkedList) {
            AppMethodBeat.i(21637);
            if (linkedList == null) {
                AppMethodBeat.o(21637);
            } else if (linkedList.size() == 0) {
                BackupPcChooseUI.this.oMO.setVisibility(8);
                BackupPcChooseUI.this.oMM.setVisibility(0);
                switch (BackupPcChooseUI.oMY) {
                    case 0:
                        BackupPcChooseUI.this.oMM.setText(R.string.a7d);
                        AppMethodBeat.o(21637);
                        return;
                    case 1:
                        BackupPcChooseUI.this.oMM.setText(R.string.a99);
                        break;
                }
                AppMethodBeat.o(21637);
            } else {
                BackupPcChooseUI.this.oML.setClickable(true);
                BackupPcChooseUI.this.oML.setTextColor(BackupPcChooseUI.this.getResources().getColor(R.color.ev));
                BackupPcChooseUI.this.oMO.setVisibility(8);
                BackupPcChooseUI.this.oOR.notifyDataSetChanged();
                AppMethodBeat.o(21637);
            }
        }
    };

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupPcChooseUI() {
        AppMethodBeat.i(21638);
        AppMethodBeat.o(21638);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21639);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(21639);
            return;
        }
        initView();
        AppMethodBeat.o(21639);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.hm;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(21640);
        super.onStart();
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oOc = this.oOT;
        AppMethodBeat.o(21640);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(21641);
        super.onStop();
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oOc = null;
        AppMethodBeat.o(21641);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(21642);
        setMMTitle(R.string.a8w);
        this.oOS = (ListView) findViewById(R.id.yd);
        this.oOS.setAdapter((ListAdapter) this.oOR);
        this.oOS.setEmptyView(findViewById(R.id.yf));
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
        ((TextView) findViewById(R.id.yn)).setText(R.string.a7e);
        ((TextView) findViewById(R.id.yq)).setText(R.string.a7h);
        ((TextView) findViewById(R.id.yb)).setText(R.string.a7c);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21632);
                BackupPcChooseUI.this.finish();
                AppMethodBeat.o(21632);
                return false;
            }
        });
        this.oMX = (Button) findViewById(R.id.yi);
        this.oMX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.AnonymousClass2 */

            public final void onClick(View view) {
                final LinkedList<f.b> linkedList;
                AppMethodBeat.i(21634);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = BackupPcChooseUI.this.oOR;
                LinkedList<f.b> linkedList2 = new LinkedList<>();
                if (aVar.oMG.size() <= 0) {
                    linkedList = linkedList2;
                } else {
                    LinkedList<f.b> cfr = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr();
                    if (cfr != null) {
                        for (int i2 = 0; i2 < aVar.getCount(); i2++) {
                            if (aVar.oMG.contains(Integer.valueOf(i2))) {
                                linkedList2.add(cfr.get(i2));
                            }
                        }
                    }
                    Log.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", Integer.valueOf(linkedList2.size()));
                    linkedList = linkedList2;
                }
                final LinkedList<String> B = g.B(linkedList);
                bg.aVF();
                boolean booleanValue = ((Boolean) c.azQ().get(ar.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue();
                Log.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(linkedList.size()), Boolean.valueOf(booleanValue), Integer.valueOf(BackupPcChooseUI.oMY), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.endTime), Integer.valueOf(BackupPcChooseUI.beK));
                if (booleanValue) {
                    h.a((Context) BackupPcChooseUI.this, (int) R.string.a8_, 0, (int) R.string.a9l, 0, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(21633);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().H(linkedList);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().Bj(2);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 12;
                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().G(B);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().Bv((long) linkedList.size());
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 8, 1, false);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 10, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                            if (BackupPcChooseUI.oMY == 1 && BackupPcChooseUI.beK == 1) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 32, 1, false);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 35, 1, false);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 13, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                            } else if (BackupPcChooseUI.oMY == 1) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 32, 1, false);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 11, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                            } else if (BackupPcChooseUI.beK == 1) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 35, 1, false);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 12, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                            }
                            BackupPcChooseUI.this.finish();
                            AppMethodBeat.o(21633);
                        }
                    }, (DialogInterface.OnClickListener) null, (int) R.color.ev);
                } else {
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().H(linkedList);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().Bj(2);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 12;
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().G(B);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().Bv((long) linkedList.size());
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 8, 1, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 10, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                    if (BackupPcChooseUI.oMY == 1 && BackupPcChooseUI.beK == 1) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 32, 1, false);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 35, 1, false);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 13, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                    } else if (BackupPcChooseUI.oMY == 1) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 32, 1, false);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 11, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                    } else if (BackupPcChooseUI.beK == 1) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 35, 1, false);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13735, 12, Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq));
                    }
                    BackupPcChooseUI.this.finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21634);
            }
        });
        this.oMX.setEnabled(false);
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOF || com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOG) {
            this.oMN.setVisibility(0);
            jC(true);
            this.oMN.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(21635);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
                    intent.putExtra("BACKUP_MODE", 1);
                    intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.oMY);
                    intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOG);
                    intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.beK);
                    intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
                    intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.endTime);
                    intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oLe);
                    BackupPcChooseUI.this.startActivityForResult(intent, 0);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21635);
                }
            });
        } else {
            this.oMN.setVisibility(8);
        }
        this.oML.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(21636);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oLi) {
                    a aVar = BackupPcChooseUI.this.oOR;
                    if (aVar.oMG.size() == aVar.getCount()) {
                        aVar.oMG.clear();
                        a.oOP = false;
                    } else {
                        for (int i2 = 0; i2 < aVar.getCount(); i2++) {
                            aVar.oMG.add(Integer.valueOf(i2));
                        }
                        a.oOP = true;
                    }
                    aVar.notifyDataSetChanged();
                    aVar.oOO.a(aVar.oMG);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21636);
            }
        });
        if (!com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oLi) {
            this.oML.setTextColor(getResources().getColor(R.color.ex));
            this.oML.setClickable(false);
            this.oMO.setVisibility(0);
            AppMethodBeat.o(21642);
            return;
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr().size() == 0) {
            switch (oMY) {
                case 0:
                    this.oMM.setText(R.string.a7d);
                    break;
                case 1:
                    this.oMM.setText(R.string.a99);
                    break;
            }
            this.oMM.setVisibility(0);
        }
        this.oMO.setVisibility(4);
        AppMethodBeat.o(21642);
    }

    private void jC(boolean z) {
        AppMethodBeat.i(21643);
        if (z) {
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga();
            SharedPreferences ceR = com.tencent.mm.plugin.backup.backuppcmodel.b.ceR();
            oMY = ceR.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
            beK = ceR.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = ceR.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
            endTime = ceR.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOF) {
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
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOG) {
            switch (beK) {
                case 0:
                    this.oMT.setVisibility(8);
                    break;
                case 1:
                    this.oMP.setVisibility(0);
                    this.oMQ.setVisibility(0);
                    this.oMT.setVisibility(0);
                    this.oMW.setText(getContext().getResources().getString(R.string.a8s));
                    break;
            }
        }
        cfQ();
        AppMethodBeat.o(21643);
    }

    public final void a(HashSet<Integer> hashSet) {
        AppMethodBeat.i(21644);
        HashSet hashSet2 = new HashSet();
        int size = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr().size();
        Iterator<Integer> it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue >= size) {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove(Integer.valueOf(((Integer) it2.next()).intValue()));
        }
        if (hashSet.size() != 0) {
            this.oMX.setEnabled(true);
            if (!com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oLi || hashSet.size() != this.oOR.getCount()) {
                this.oML.setText(R.string.a4y);
            } else {
                this.oML.setText(R.string.a4z);
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
        AppMethodBeat.o(21644);
    }

    private void cfQ() {
        AppMethodBeat.i(21645);
        if (this.oMR.getVisibility() == 8 && this.oMS.getVisibility() == 8 && this.oMT.getVisibility() == 8) {
            this.oMP.setVisibility(8);
            this.oMQ.setVisibility(8);
            AppMethodBeat.o(21645);
            return;
        }
        this.oMP.setVisibility(0);
        this.oMQ.setVisibility(0);
        AppMethodBeat.o(21645);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(21646);
        if (i3 != -1) {
            Log.e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", Integer.valueOf(i3));
            AppMethodBeat.o(21646);
            return;
        }
        int i4 = oMY;
        long j2 = startTime;
        long j3 = endTime;
        oMY = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", oMY);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        beK = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", beK);
        Log.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", Integer.valueOf(oMY), Integer.valueOf(i4), Long.valueOf(startTime), Long.valueOf(j2), Long.valueOf(endTime), Long.valueOf(j3), Integer.valueOf(beK));
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc();
        e.f(oMY, startTime, endTime, beK);
        jC(false);
        if (i4 == oMY && (oMY == 0 || (oMY == 1 && startTime == j2 && endTime == j3))) {
            AppMethodBeat.o(21646);
            return;
        }
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().a(oMY, startTime, endTime, com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfq());
        a aVar = this.oOR;
        aVar.oMG.clear();
        aVar.oOO.a(aVar.oMG);
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr() == null || com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr().size() == 0) {
            switch (oMY) {
                case 0:
                    this.oMM.setText(R.string.a7d);
                    break;
                case 1:
                    this.oMM.setText(R.string.a99);
                    break;
            }
            this.oMM.setVisibility(0);
        } else {
            this.oMM.setVisibility(4);
        }
        this.oOR.notifyDataSetChanged();
        AppMethodBeat.o(21646);
    }
}
