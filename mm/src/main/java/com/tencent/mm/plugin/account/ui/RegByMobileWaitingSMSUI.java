package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cc.h;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegByMobileWaitingSMSUI extends MMActivity {
    private String dSf;
    private String kbV;
    private int kpb = 30;
    private TextView kqZ;
    private boolean kqk;
    private CountDownTimer kra;
    private ListView krb;
    private a krc;
    private List<Integer> krd = new ArrayList();
    String[] kre = {"你好", "可以请你喝一杯吗？", "Здравствуйте!", "Darf ich Ihnen einen Drink ausgeben?", "Ich habe Gefühle für Dich.", "Bonjour!", "Prends soins de toi.", "?Hola! ", "Soy un ingeniero.", "Tu novio es un hombre bonito", "今日は!", "カッコいいですね", "Buona notte!", "Ayons une fête ce soir!", "Let's enjoy the holidays.", "Hello!"};
    private Drawable krf;
    private List<Drawable> krg = new ArrayList();
    private boolean krh = false;
    private ProgressBar progressBar;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RegByMobileWaitingSMSUI() {
        AppMethodBeat.i(128648);
        AppMethodBeat.o(128648);
    }

    static /* synthetic */ void a(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI) {
        AppMethodBeat.i(128657);
        regByMobileWaitingSMSUI.goBack();
        AppMethodBeat.o(128657);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128649);
        super.onCreate(bundle);
        this.krg.add(getResources().getDrawable(R.drawable.bg7));
        this.krg.add(getResources().getDrawable(R.drawable.bg8));
        this.krg.add(getResources().getDrawable(R.drawable.bg9));
        this.krg.add(getResources().getDrawable(R.drawable.bg_));
        this.krg.add(getResources().getDrawable(R.drawable.bga));
        this.krg.add(getResources().getDrawable(R.drawable.bgb));
        initView();
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        AppMethodBeat.o(128649);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128650);
        super.onDestroy();
        AppMethodBeat.o(128650);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128651);
        super.onResume();
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE200_250,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("RE200_250")).append(",1").toString());
        AppMethodBeat.o(128651);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128652);
        super.onPause();
        com.tencent.mm.plugin.b.a.bxk("RE200_250");
        if (this.krh) {
            com.tencent.mm.plugin.b.a.bxl(this.kbV);
        } else {
            com.tencent.mm.plugin.b.a.bxl("RE200_300");
        }
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE200_250,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("RE200_250")).append(",2").toString());
        AppMethodBeat.o(128652);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128653);
        this.kqZ = (TextView) findViewById(R.id.jd2);
        this.progressBar = (ProgressBar) findViewById(R.id.jd6);
        this.krb = (ListView) findViewById(R.id.jd3);
        this.kqk = false;
        String string = getString(R.string.ael);
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            string = getString(R.string.wx) + h.jr(this);
        }
        setMMTitle(string);
        this.dSf = getIntent().getExtras().getString("bindmcontact_mobile");
        this.dSf = PhoneFormater.pureNumber(this.dSf);
        this.kpb = getIntent().getIntExtra("mobileverify_countdownsec", this.kpb);
        Random random = new Random();
        for (int i2 = 0; i2 < this.kpb; i2++) {
            this.krd.add(Integer.valueOf(random.nextInt(1000)));
        }
        int nextInt = random.nextInt(1000) % this.krg.size();
        this.krf = this.krg.get(nextInt);
        this.krg.remove(nextInt);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128636);
                RegByMobileWaitingSMSUI.a(RegByMobileWaitingSMSUI.this);
                AppMethodBeat.o(128636);
                return true;
            }
        });
        PhoneFormater phoneFormater = new PhoneFormater();
        String str = "86";
        if (this.dSf.startsWith("+")) {
            this.dSf = this.dSf.replace("+", "");
            str = PhoneFormater.extractCountryCode(this.dSf);
            if (str != null) {
                this.dSf = this.dSf.substring(str.length());
            }
        }
        String formatNumber = phoneFormater.formatNumber(str, this.dSf);
        if (str == null || str.length() <= 0) {
            this.kqZ.setText(formatNumber);
        } else {
            this.kqZ.setText("+" + str + " " + formatNumber);
        }
        this.krb.setVisibility(4);
        if (this.kra == null) {
            this.kra = new CountDownTimer((long) (this.kpb * 1000)) {
                /* class com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI.AnonymousClass2 */

                public final void onFinish() {
                    AppMethodBeat.i(128638);
                    RegByMobileWaitingSMSUI.b(RegByMobileWaitingSMSUI.this);
                    AppMethodBeat.o(128638);
                }

                public final void onTick(long j2) {
                    AppMethodBeat.i(128639);
                    int i2 = (int) (((long) RegByMobileWaitingSMSUI.this.kpb) - (j2 / 1000));
                    RegByMobileWaitingSMSUI.this.progressBar.setProgress(i2);
                    if (i2 % 2 == 0 && RegByMobileWaitingSMSUI.this.krc != null) {
                        RegByMobileWaitingSMSUI.this.krc.add(RegByMobileWaitingSMSUI.this.kre[(i2 / 2) % RegByMobileWaitingSMSUI.this.kre.length]);
                        RegByMobileWaitingSMSUI.this.krb.post(new Runnable() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(128637);
                                if (Build.VERSION.SDK_INT >= 8) {
                                    ListView listView = RegByMobileWaitingSMSUI.this.krb;
                                    com.tencent.mm.hellhoundlib.b.a a2 = c.a(RegByMobileWaitingSMSUI.this.krc.getCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
                                    com.tencent.mm.hellhoundlib.a.a.a(listView, a2.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileWaitingSMSUI$2$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                                    listView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                                    com.tencent.mm.hellhoundlib.a.a.a(listView, "com/tencent/mm/plugin/account/ui/RegByMobileWaitingSMSUI$2$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                                    AppMethodBeat.o(128637);
                                    return;
                                }
                                RegByMobileWaitingSMSUI.this.krb.setSelection(RegByMobileWaitingSMSUI.this.krc.getCount() - 1);
                                AppMethodBeat.o(128637);
                            }
                        });
                    }
                    AppMethodBeat.o(128639);
                }
            };
            this.progressBar.setMax(this.kpb);
            this.kra.start();
        }
        AppMethodBeat.o(128653);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bbc;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128654);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(128654);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128654);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(128655);
        com.tencent.mm.ui.base.h.c(this, getString(R.string.f2i), "", getString(R.string.f2j), getString(R.string.f2k), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(128640);
                RegByMobileWaitingSMSUI.this.krh = true;
                RegByMobileWaitingSMSUI.this.finish();
                AppMethodBeat.o(128640);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(128655);
    }

    private synchronized void bpF() {
        AppMethodBeat.i(128656);
        if (!(this.kra == null || this.kra == null)) {
            this.kra.cancel();
            this.kra = null;
        }
        if (!this.kqk) {
            this.kqk = true;
            Intent intent = getIntent();
            intent.putExtra("mobile_verify_purpose", 2);
            startActivity(MobileVerifyUI.class, intent);
            finish();
        }
        AppMethodBeat.o(128656);
    }

    class b {
        public ImageView keC;
        public TextView krl;

        private b() {
        }

        /* synthetic */ b(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends ArrayAdapter<String> {
        private final LayoutInflater kgB;
        final /* synthetic */ RegByMobileWaitingSMSUI kri;
        private final ArrayList<String> krk;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.widget.ArrayAdapter
        public final /* bridge */ /* synthetic */ void add(String str) {
            AppMethodBeat.i(128647);
            add(str);
            AppMethodBeat.o(128647);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            View view2;
            AppMethodBeat.i(128641);
            int itemViewType = getItemViewType(i2);
            if (view == null) {
                bVar = new b(this.kri, (byte) 0);
                switch (itemViewType) {
                    case 0:
                        view2 = this.kgB.inflate(R.layout.cr, (ViewGroup) null);
                        break;
                    case 1:
                        view2 = this.kgB.inflate(R.layout.cs, (ViewGroup) null);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("UNIMPLEMENT TYPE");
                        AppMethodBeat.o(128641);
                        throw illegalArgumentException;
                }
                bVar.krl = (TextView) view2.findViewById(R.id.auk);
                bVar.keC = (ImageView) view2.findViewById(R.id.au2);
                view2.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            int intValue = ((Integer) this.kri.krd.get(i2 % this.kri.krd.size())).intValue();
            switch (itemViewType) {
                case 0:
                    bVar.keC.setImageDrawable((Drawable) this.kri.krg.get(intValue % this.kri.krg.size()));
                    break;
                case 1:
                    bVar.keC.setImageDrawable(this.kri.krf);
                    break;
            }
            bVar.krl.setText(getItem(i2));
            AppMethodBeat.o(128641);
            return view2;
        }

        public final int getCount() {
            AppMethodBeat.i(128642);
            int size = this.krk.size();
            AppMethodBeat.o(128642);
            return size;
        }

        @Override // android.widget.ArrayAdapter
        private String getItem(int i2) {
            AppMethodBeat.i(128643);
            String str = this.krk.get(i2);
            AppMethodBeat.o(128643);
            return str;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(128644);
            if (((Integer) this.kri.krd.get(i2 % this.kri.krd.size())).intValue() % 4 == 0) {
                AppMethodBeat.o(128644);
                return 1;
            }
            AppMethodBeat.o(128644);
            return 0;
        }

        public final void add(String str) {
            AppMethodBeat.i(128645);
            this.krk.add(str);
            notifyDataSetChanged();
            AppMethodBeat.o(128645);
        }
    }

    static /* synthetic */ void b(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI) {
        AppMethodBeat.i(128658);
        regByMobileWaitingSMSUI.bpF();
        AppMethodBeat.o(128658);
    }
}
