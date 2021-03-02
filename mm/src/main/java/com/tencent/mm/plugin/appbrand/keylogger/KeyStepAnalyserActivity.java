package com.tencent.mm.plugin.appbrand.keylogger;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.tav.coremedia.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class KeyStepAnalyserActivity extends KeyStepBaseActivity {
    private int mDay;
    private int mMonth;
    private Pattern mOA;
    private Class mOB;
    private String mOC;
    private a mOz;
    private String mProcessName;
    private int mYear;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(KeyStepAnalyserActivity keyStepAnalyserActivity, long j2) {
        AppMethodBeat.i(221259);
        keyStepAnalyserActivity.Bj(j2);
        AppMethodBeat.o(221259);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(221255);
        super.onCreate(bundle);
        this.mOB = (Class) getIntent().getSerializableExtra("process");
        this.mOC = getIntent().getStringExtra("category");
        this.mProcessName = f.aC(this.mOB);
        this.mOA = (Pattern) getIntent().getSerializableExtra("session_id_prefix");
        setTitle(getString(R.string.e_o));
        Calendar instance = Calendar.getInstance();
        this.mYear = instance.get(1);
        this.mMonth = instance.get(2);
        this.mDay = instance.get(5);
        findViewById(R.id.bkm).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(221244);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(221244);
            }
        });
        this.mOz = new a();
        Bj(System.currentTimeMillis());
        AppMethodBeat.o(221255);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity
    public final int getLayoutId() {
        return R.layout.bt;
    }

    private void Bj(long j2) {
        AppMethodBeat.i(221256);
        Log.i("MicroMsg.KeyStepBaseActivity", "analyse time:%d", Long.valueOf(j2));
        this.mOz.a(this.mProcessName, this.mOA, j2, new IKeyStepAnalyser.a() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.a
            public final void bM(final List<IKeyStepAnalyser.b> list) {
                AppMethodBeat.i(221246);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(221245);
                        KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this, list);
                        AppMethodBeat.o(221245);
                    }
                });
                AppMethodBeat.o(221246);
            }
        });
        AppMethodBeat.o(221256);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        private static SimpleDateFormat sDateFormat = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS);
        private final LayoutInflater mInflater;
        List<IKeyStepAnalyser.b> mOH;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(221253);
            IKeyStepAnalyser.b yd = yd(i2);
            AppMethodBeat.o(221253);
            return yd;
        }

        static {
            AppMethodBeat.i(221254);
            AppMethodBeat.o(221254);
        }

        a(Context context) {
            AppMethodBeat.i(221249);
            this.mInflater = LayoutInflater.from(context);
            AppMethodBeat.o(221249);
        }

        public final int getCount() {
            AppMethodBeat.i(221250);
            if (this.mOH == null) {
                AppMethodBeat.o(221250);
                return 0;
            }
            int size = this.mOH.size();
            AppMethodBeat.o(221250);
            return size;
        }

        public final IKeyStepAnalyser.b yd(int i2) {
            AppMethodBeat.i(221251);
            IKeyStepAnalyser.b bVar = this.mOH.get(i2);
            AppMethodBeat.o(221251);
            return bVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            String str;
            AppMethodBeat.i(221252);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.c60, viewGroup, false);
                bVar = new b();
                bVar.jUO = (TextView) view.findViewById(R.id.bki);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (!yd(i2).mPu.isEmpty()) {
                IKeyStepAnalyser.StepLogInfo stepLogInfo = yd(i2).mPu.get(0);
                str = stepLogInfo == null ? null : sDateFormat.format(Long.valueOf(stepLogInfo.time));
            } else {
                bVar.jUO.setText((CharSequence) null);
                str = null;
            }
            bVar.jUO.setText(str);
            AppMethodBeat.o(221252);
            return view;
        }
    }

    static class b {
        public TextView jUO;

        b() {
        }
    }

    static /* synthetic */ void a(KeyStepAnalyserActivity keyStepAnalyserActivity) {
        AppMethodBeat.i(221257);
        new DatePickerDialog(keyStepAnalyserActivity, new DatePickerDialog.OnDateSetListener() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.AnonymousClass3 */

            public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                AppMethodBeat.i(221247);
                Calendar instance = Calendar.getInstance();
                KeyStepAnalyserActivity.this.mYear = i2;
                KeyStepAnalyserActivity.this.mMonth = i3;
                KeyStepAnalyserActivity.this.mDay = i4;
                instance.set(i2, i3, i4);
                KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this, instance.getTimeInMillis());
                AppMethodBeat.o(221247);
            }
        }, keyStepAnalyserActivity.mYear, keyStepAnalyserActivity.mMonth, keyStepAnalyserActivity.mDay).show();
        AppMethodBeat.o(221257);
    }

    static /* synthetic */ void a(KeyStepAnalyserActivity keyStepAnalyserActivity, List list) {
        AppMethodBeat.i(221258);
        ListView listView = (ListView) keyStepAnalyserActivity.findViewById(R.id.ecm);
        if (listView == null) {
            keyStepAnalyserActivity.finish();
            AppMethodBeat.o(221258);
            return;
        }
        final a aVar = new a(keyStepAnalyserActivity);
        listView.setAdapter((ListAdapter) aVar);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(221248);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this, aVar.yd(i2));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(221248);
            }
        });
        aVar.mOH = list;
        aVar.notifyDataSetChanged();
        AppMethodBeat.o(221258);
    }

    static /* synthetic */ void a(KeyStepAnalyserActivity keyStepAnalyserActivity, IKeyStepAnalyser.b bVar) {
        AppMethodBeat.i(221260);
        Intent intent = new Intent();
        intent.setClass(keyStepAnalyserActivity, KeyStepAnalyserDetailActivity.class);
        intent.putExtra("steps", bVar.mPu);
        intent.putExtra("key_info", bVar.mPv.toString());
        intent.putExtra("key_process_class", keyStepAnalyserActivity.mOB);
        intent.putExtra("key_process_category", keyStepAnalyserActivity.mOC);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(keyStepAnalyserActivity, bl.axQ(), "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity", "goToDetail", "(Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepAnalyser$ProcessLogInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        keyStepAnalyserActivity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(keyStepAnalyserActivity, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity", "goToDetail", "(Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepAnalyser$ProcessLogInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(221260);
    }
}
