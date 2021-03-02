package com.tencent.mm.plugin.backup.backupui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.DatePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.RadioCheckPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.e;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI extends MMPreference {
    private int beK = 0;
    private long endTime = 0;
    private int oIY;
    private long oLe = 0;
    private int oMY = 0;
    private SimpleDateFormat oMZ = new SimpleDateFormat("yyyy.MM.dd");
    private RadioCheckPreference oQT;
    private RadioCheckPreference oQU;
    private RadioCheckPreference oQV;
    private RadioCheckPreference oQW;
    private Preference oQX;
    private Preference oQY;
    private boolean oQZ = false;
    private f screen;
    private long startTime = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupSelectExtUI() {
        AppMethodBeat.i(21786);
        AppMethodBeat.o(21786);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21787);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        initView();
        AppMethodBeat.o(21787);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.o;
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(final int i2) {
        AppMethodBeat.i(21789);
        Calendar instance = Calendar.getInstance();
        switch (i2) {
            case 1:
                instance.setTimeInMillis(this.startTime == 0 ? Util.nowMilliSecond() : this.startTime);
                break;
            case 2:
                instance.setTimeInMillis(this.endTime == 0 ? Util.nowMilliSecond() : this.endTime - Util.MILLSECONDS_OF_DAY);
                break;
        }
        e eVar = new e(getContext(), new DatePickerDialog.OnDateSetListener() {
            /* class com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI.AnonymousClass1 */

            public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                AppMethodBeat.i(21783);
                StringBuffer append = new StringBuffer().append(String.format("%02d", Integer.valueOf(i2))).append(String.format("%02d", Integer.valueOf(i3 + 1))).append(String.format("%02d", Integer.valueOf(i4)));
                switch (i2) {
                    case 1:
                        long agD = g.agD(append.append("000000").toString());
                        BackupSelectExtUI.this.startTime = (agD / 1000) * 1000;
                        BackupSelectExtUI.this.oQY.setSummary(BackupSelectExtUI.this.oMZ.format(new Date(agD)));
                        BackupSelectExtUI.this.screen.notifyDataSetChanged();
                        BackupSelectExtUI.this.enableOptionMenu((BackupSelectExtUI.this.startTime == 0 || BackupSelectExtUI.this.endTime == 0) ? false : true);
                        AppMethodBeat.o(21783);
                        return;
                    case 2:
                        long agD2 = g.agD(append.append("000000").toString());
                        BackupSelectExtUI.this.endTime = ((agD2 / 1000) * 1000) + Util.MILLSECONDS_OF_DAY;
                        BackupSelectExtUI.this.oQX.setSummary(BackupSelectExtUI.this.oMZ.format(new Date(agD2)));
                        BackupSelectExtUI.this.screen.notifyDataSetChanged();
                        BackupSelectExtUI.this.enableOptionMenu((BackupSelectExtUI.this.startTime == 0 || BackupSelectExtUI.this.endTime == 0) ? false : true);
                        break;
                }
                AppMethodBeat.o(21783);
            }
        }, instance.get(1), instance.get(2), instance.get(5), instance.getTimeInMillis(), (byte) 0);
        eVar.setCanceledOnTouchOutside(false);
        long nowMilliSecond = (((Util.nowMilliSecond() / Util.MILLSECONDS_OF_DAY) * Util.MILLSECONDS_OF_DAY) + 57600000) - 1;
        long j2 = (((this.oLe / Util.MILLSECONDS_OF_DAY) * Util.MILLSECONDS_OF_DAY) + 57600000) - Util.MILLSECONDS_OF_DAY;
        if (nowMilliSecond > j2) {
            try {
                eVar.Ob(j2);
                eVar.Oa(nowMilliSecond);
            } catch (Exception e2) {
                Log.e("MicroMsg.BackupSelectExtUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", Long.valueOf(j2), Long.valueOf(nowMilliSecond), e2);
            }
        }
        AppMethodBeat.o(21789);
        return eVar;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(21790);
        this.oIY = getIntent().getIntExtra("BACKUP_MODE", 0);
        setMMTitle(R.string.a9b);
        this.oMY = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
        this.oQZ = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
        this.beK = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
        this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        this.oLe = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0);
        updateView();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21784);
                BackupSelectExtUI.this.finish();
                AppMethodBeat.o(21784);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.a9z), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21785);
                if (BackupSelectExtUI.this.oMY != 1 || BackupSelectExtUI.this.startTime < BackupSelectExtUI.this.endTime) {
                    Intent intent = new Intent();
                    intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupSelectExtUI.this.oMY);
                    intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupSelectExtUI.this.beK);
                    intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupSelectExtUI.this.startTime);
                    intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupSelectExtUI.this.endTime);
                    BackupSelectExtUI.this.setResult(-1, intent);
                    BackupSelectExtUI.this.finish();
                    AppMethodBeat.o(21785);
                } else {
                    if (BackupSelectExtUI.this.oIY == 1) {
                        h.c(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(R.string.a7i), "", true);
                    } else if (BackupSelectExtUI.this.oIY == 2) {
                        h.c(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(R.string.a5b), "", true);
                    }
                    AppMethodBeat.o(21785);
                }
                return true;
            }
        }, null, t.b.GREEN);
        AppMethodBeat.o(21790);
    }

    private void cgT() {
        AppMethodBeat.i(21791);
        switch (this.oMY) {
            case 0:
                this.oQT.xZ(true);
                this.oQU.xZ(false);
                this.screen.e(this.oQY);
                this.screen.e(this.oQX);
                enableOptionMenu(true);
                this.screen.notifyDataSetChanged();
                AppMethodBeat.o(21791);
                return;
            case 1:
                updateView();
                break;
        }
        AppMethodBeat.o(21791);
    }

    private void cgU() {
        AppMethodBeat.i(21792);
        switch (this.beK) {
            case 0:
                this.oQV.xZ(true);
                this.oQW.xZ(false);
                this.screen.notifyDataSetChanged();
                AppMethodBeat.o(21792);
                return;
            case 1:
                this.oQV.xZ(false);
                this.oQW.xZ(true);
                this.screen.notifyDataSetChanged();
                break;
        }
        AppMethodBeat.o(21792);
    }

    private void updateView() {
        AppMethodBeat.i(21793);
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.o);
        this.oQT = (RadioCheckPreference) this.screen.bmg("backup_select_ext_time_all");
        this.oQU = (RadioCheckPreference) this.screen.bmg("backup_select_ext_time_some");
        this.oQY = this.screen.bmg("backup_select_begin_time");
        this.oQX = this.screen.bmg("backup_select_end_time");
        this.oQV = (RadioCheckPreference) this.screen.bmg("backup_select_ext_content_all_msg");
        this.oQW = (RadioCheckPreference) this.screen.bmg("backup_select_ext_content_text_only");
        if (!this.oQZ) {
            this.screen.e(this.screen.bmg("backup_select_ext_content_title"));
            this.screen.e(this.oQV);
            this.screen.e(this.oQW);
        }
        if (this.oIY == 1) {
            this.screen.bmg("backup_select_ext_time_title").setTitle(R.string.a8u);
            if (this.oQZ) {
                this.screen.bmg("backup_select_ext_content_title").setTitle(R.string.a8t);
            }
        } else if (this.oIY == 2) {
            this.screen.bmg("backup_select_ext_time_title").setTitle(R.string.a6z);
            if (this.oQZ) {
                this.screen.bmg("backup_select_ext_content_title").setTitle(R.string.a6y);
            }
        }
        switch (this.oMY) {
            case 0:
                this.oQT.xZ(true);
                this.oQU.xZ(false);
                this.oQY.setEnabled(false);
                this.oQX.setEnabled(false);
                this.screen.e(this.oQY);
                this.screen.e(this.oQX);
                enableOptionMenu(true);
                break;
            case 1:
                cgV();
                this.oQT.xZ(false);
                this.oQU.xZ(true);
                this.oQY.setEnabled(true);
                this.oQX.setEnabled(true);
                break;
        }
        if (this.oQZ) {
            switch (this.beK) {
                case 0:
                    this.oQV.xZ(true);
                    this.oQW.xZ(false);
                    break;
                case 1:
                    this.oQV.xZ(false);
                    this.oQW.xZ(true);
                    break;
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(21793);
    }

    private void cgV() {
        boolean z;
        AppMethodBeat.i(21794);
        if (this.startTime == 0 || this.endTime == 0) {
            this.oQY.setSummary(R.string.a9e);
            this.oQX.setSummary(R.string.a9e);
        } else {
            this.oQY.setSummary(this.oMZ.format(new Date(this.startTime)));
            this.oQX.setSummary(this.oMZ.format(new Date(this.endTime - Util.MILLSECONDS_OF_DAY)));
            if (!(this.startTime == 0 || this.endTime == 0)) {
                z = true;
                enableOptionMenu(z);
                AppMethodBeat.o(21794);
            }
        }
        z = false;
        enableOptionMenu(z);
        AppMethodBeat.o(21794);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(21788);
        String str = preference.mKey;
        if (str.equals("backup_select_ext_time_all")) {
            this.oMY = 0;
            cgT();
            AppMethodBeat.o(21788);
            return true;
        } else if (str.equals("backup_select_ext_time_some")) {
            this.oMY = 1;
            cgT();
            AppMethodBeat.o(21788);
            return true;
        } else if (str.equals("backup_select_ext_content_all_msg")) {
            if (this.oQZ) {
                this.beK = 0;
                cgU();
            } else {
                Log.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content all msg, but not support content type");
            }
            AppMethodBeat.o(21788);
            return true;
        } else if (str.equals("backup_select_ext_content_text_only")) {
            if (this.oQZ) {
                this.beK = 1;
                cgU();
            } else {
                Log.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content text only, but not support content type");
            }
            AppMethodBeat.o(21788);
            return true;
        } else if (str.equals("backup_select_begin_time")) {
            showDialog(1);
            AppMethodBeat.o(21788);
            return true;
        } else if (str.equals("backup_select_end_time")) {
            showDialog(2);
            AppMethodBeat.o(21788);
            return true;
        } else {
            AppMethodBeat.o(21788);
            return false;
        }
    }
}
