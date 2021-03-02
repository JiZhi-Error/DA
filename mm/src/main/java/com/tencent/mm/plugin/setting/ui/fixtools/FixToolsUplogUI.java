package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.ui.widget.picker.b;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class FixToolsUplogUI extends MMWizardActivity {
    private static String BrH;
    private Button CYB;
    private TextView CYC;
    private SimpleDateFormat CYD = new SimpleDateFormat("yyyy.MM.dd");
    private LinearLayout oMS;
    private SimpleDateFormat oMZ = new SimpleDateFormat("yyyyMMdd");

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FixToolsUplogUI() {
        AppMethodBeat.i(73827);
        AppMethodBeat.o(73827);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73828);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(73828);
            return;
        }
        h.INSTANCE.idkeyStat(873, (long) getIntent().getIntExtra("entry_fix_tools_uplog", 5), 1, false);
        h.INSTANCE.idkeyStat(873, 8, 1, false);
        initView();
        AppMethodBeat.o(73828);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.alq;
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(final int i2) {
        AppMethodBeat.i(73829);
        Calendar instance = Calendar.getInstance();
        long nowMilliSecond = Util.nowMilliSecond();
        instance.setTimeInMillis(nowMilliSecond);
        int i3 = instance.get(1);
        int i4 = instance.get(2);
        final long j2 = (((nowMilliSecond / Util.MILLSECONDS_OF_DAY) * Util.MILLSECONDS_OF_DAY) + 57600000) - 1;
        long j3 = (((nowMilliSecond / Util.MILLSECONDS_OF_DAY) * Util.MILLSECONDS_OF_DAY) + 57600000) - 864000000;
        e eVar = new e(getContext(), new DatePickerDialog.OnDateSetListener() {
            /* class com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI.AnonymousClass1 */

            public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                AppMethodBeat.i(73823);
                switch (i2) {
                    case 1:
                        FixToolsUplogUI.this.CYC.setText(new StringBuffer().append(String.format("%02d", Integer.valueOf(i2))).append(".").append(String.format("%02d", Integer.valueOf(i3 + 1))).append(".").append(String.format("%02d", Integer.valueOf(i4))));
                        String unused = FixToolsUplogUI.BrH = new StringBuffer().append(String.format("%02d", Integer.valueOf(i2))).append(String.format("%02d", Integer.valueOf(i3 + 1))).append(String.format("%02d", Integer.valueOf(i4))).toString();
                        Log.i("MicroMsg.FixToolsUplogUI", "uplog choose time maxTime[%d], date[%s]", Long.valueOf(j2), FixToolsUplogUI.BrH);
                        break;
                }
                AppMethodBeat.o(73823);
            }
        }, i3, i4, instance.get(5), instance.getTimeInMillis(), (byte) 0);
        eVar.setCanceledOnTouchOutside(false);
        try {
            eVar.Ob(j3 > 0 ? j3 : 0);
            eVar.Oa(j2);
        } catch (Exception e2) {
            Log.e("MicroMsg.FixToolsUplogUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", Long.valueOf(j3), Long.valueOf(j2), e2);
        }
        AppMethodBeat.o(73829);
        return eVar;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73830);
        setMMTitle(R.string.dcl);
        this.CYB = (Button) findViewById(R.id.d5l);
        this.oMS = (LinearLayout) findViewById(R.id.b18);
        this.CYC = (TextView) findViewById(R.id.d5g);
        this.CYC.setText(this.CYD.format(new Date()));
        BrH = this.oMZ.format(new Date());
        this.CYB.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(73824);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUplogUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.idkeyStat(873, 16, 1, false);
                Intent intent = new Intent(FixToolsUplogUI.this.getContext(), FixToolsUpLogUploadingUI.class);
                intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_DATE, FixToolsUplogUI.BrH);
                MMWizardActivity.ay(FixToolsUplogUI.this, intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUplogUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73824);
            }
        });
        this.oMS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(73825);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUplogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FixToolsUplogUI.b(FixToolsUplogUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUplogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73825);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73826);
                FixToolsUplogUI.this.finish();
                AppMethodBeat.o(73826);
                return true;
            }
        });
        AppMethodBeat.o(73830);
    }

    static /* synthetic */ void b(FixToolsUplogUI fixToolsUplogUI) {
        AppMethodBeat.i(256463);
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        long nowMilliSecond = Util.nowMilliSecond();
        final long j2 = (((nowMilliSecond / Util.MILLSECONDS_OF_DAY) * Util.MILLSECONDS_OF_DAY) + 57600000) - 1;
        long j3 = (((nowMilliSecond / Util.MILLSECONDS_OF_DAY) * Util.MILLSECONDS_OF_DAY) + 57600000) - 864000000;
        if (j3 <= 0) {
            j3 = 0;
        }
        instance.setTimeInMillis(j3);
        instance2.setTimeInMillis(j2);
        com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b(fixToolsUplogUI.getContext());
        bVar.QSU = new b.a() {
            /* class com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.picker.b.a
            public final void onResult(boolean z, int i2, int i3, int i4) {
                AppMethodBeat.i(256462);
                if (z) {
                    FixToolsUplogUI.this.CYC.setText(new StringBuffer().append(String.format("%02d", Integer.valueOf(i2))).append(".").append(String.format("%02d", Integer.valueOf(i3))).append(".").append(String.format("%02d", Integer.valueOf(i4))));
                    String unused = FixToolsUplogUI.BrH = new StringBuffer().append(String.format("%02d", Integer.valueOf(i2))).append(String.format("%02d", Integer.valueOf(i2))).append(String.format("%02d", Integer.valueOf(i3))).toString();
                    Log.i("MicroMsg.FixToolsUplogUI", "uplog choose time maxTime[%d], date[%s]", Long.valueOf(j2), FixToolsUplogUI.BrH);
                }
                AppMethodBeat.o(256462);
            }
        };
        bVar.aX(instance2.get(1), instance2.get(2) + 1, instance2.get(5));
        bVar.aY(instance.get(1), instance.get(2) + 1, instance.get(5));
        bVar.aZ(instance2.get(1), instance2.get(2) + 1, instance2.get(5));
        bVar.show();
        AppMethodBeat.o(256463);
    }
}
