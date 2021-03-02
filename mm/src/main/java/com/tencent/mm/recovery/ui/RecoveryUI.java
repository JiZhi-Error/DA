package com.tencent.mm.recovery.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.e.c;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.d;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.e;
import com.tencent.mm.recoveryv2.f;
import com.tencent.mm.recoveryv2.i;
import com.tencent.mm.recoveryv2.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.lib.e.b;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class RecoveryUI extends AppCompatActivity {
    private TextView NBi;
    private TextView NBj;
    private RecoveryCrash.Record NBk;
    private ProgressBar krF;
    private Button xRO;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(RecoveryUI recoveryUI) {
        AppMethodBeat.i(193929);
        recoveryUI.guy();
        AppMethodBeat.o(193929);
    }

    @Override // android.support.v7.app.AppCompatActivity
    public Resources getResources() {
        AppMethodBeat.i(193923);
        if (MMApplicationContext.getResources() == null) {
            Resources resources = super.getResources();
            AppMethodBeat.o(193923);
            return resources;
        }
        Resources resources2 = MMApplicationContext.getResources();
        AppMethodBeat.o(193923);
        return resources2;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(193924);
        super.onCreate(bundle);
        f.i("MicroMsg.recovery.ui", "activity onCreate, id = ".concat(String.valueOf(this)));
        try {
            setRequestedOrientation(1);
        } catch (Throwable th) {
            f.w("MicroMsg.recovery.ui", "set portrait mode fail", th);
        }
        try {
            setContentView(R.layout.bw);
        } catch (Throwable th2) {
            f.w("MicroMsg.recovery.ui", "setContentView fail, try raw layout", th2);
            setContentView(R.layout.bx);
        }
        this.NBi = (TextView) findViewById(R.id.ixw);
        this.NBj = (TextView) findViewById(R.id.iyw);
        this.xRO = (Button) findViewById(R.id.aey);
        this.krF = (ProgressBar) findViewById(R.id.glj);
        this.xRO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.recovery.ui.RecoveryUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(193921);
                RecoveryUI.a(RecoveryUI.this);
                RecoveryUI.this.NBj.setText(RecoveryUI.this.getResources().getString(R.string.fxg));
                final CountDownLatch countDownLatch = new CountDownLatch(3);
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.recovery.ui.RecoveryUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(193917);
                        if (countDownLatch.getCount() > 0) {
                            try {
                                countDownLatch.await(10000, TimeUnit.MILLISECONDS);
                            } catch (Throwable th) {
                            }
                        }
                        RecoveryUI.this.NBj.post(new Runnable() {
                            /* class com.tencent.mm.recovery.ui.RecoveryUI.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(193916);
                                if (!RecoveryUI.this.isFinishing()) {
                                    RecoveryUI.c(RecoveryUI.this);
                                    RecoveryUI.this.NBj.setText(RecoveryUI.this.getResources().getString(R.string.fxh));
                                    RecoveryUI.this.xRO.setText(RecoveryUI.this.getResources().getString(R.string.fxc));
                                    RecoveryUI.this.xRO.setOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.recovery.ui.RecoveryUI.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(193915);
                                            RecoveryUI.e(RecoveryUI.this);
                                            AppMethodBeat.o(193915);
                                        }
                                    });
                                }
                                AppMethodBeat.o(193916);
                            }
                        });
                        AppMethodBeat.o(193917);
                    }
                });
                RecoveryUI.this.NBj.postDelayed(new Runnable() {
                    /* class com.tencent.mm.recovery.ui.RecoveryUI.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(193918);
                        countDownLatch.countDown();
                        AppMethodBeat.o(193918);
                    }
                }, 3000);
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.recovery.ui.RecoveryUI.AnonymousClass1.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(193919);
                        RecoveryUI.f(RecoveryUI.this);
                        RecoveryCrash.iI(RecoveryUI.this.getApplication()).guC().save();
                        countDownLatch.countDown();
                        AppMethodBeat.o(193919);
                    }
                });
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.recovery.ui.RecoveryUI.AnonymousClass1.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(193920);
                        RecoveryUI.g(RecoveryUI.this);
                        countDownLatch.countDown();
                        AppMethodBeat.o(193920);
                    }
                });
                AppMethodBeat.o(193921);
            }
        });
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        guy();
        this.NBi.setText(getResources().getString(R.string.fxf));
        this.NBj.setText(getResources().getString(R.string.fxi));
        this.xRO.setText(getResources().getString(R.string.fxd));
        this.NBk = (RecoveryCrash.Record) getIntent().getParcelableExtra("extra_crash_record");
        i iQ = i.iQ(getApplication());
        iQ.NBY = false;
        iQ.NBV = true;
        iQ.save();
        AppMethodBeat.o(193924);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(193925);
        super.onNewIntent(intent);
        f.i("MicroMsg.recovery.ui", "activity onNewIntent, id = ".concat(String.valueOf(this)));
        AppMethodBeat.o(193925);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(193926);
        super.onDestroy();
        f.i("MicroMsg.recovery.ui", "activity onDestroy, id = ".concat(String.valueOf(this)));
        AppMethodBeat.o(193926);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onBackPressed() {
    }

    private void guy() {
        AppMethodBeat.i(193927);
        this.xRO.setClickable(true);
        this.xRO.setVisibility(0);
        this.krF.setVisibility(8);
        AppMethodBeat.o(193927);
    }

    static /* synthetic */ void a(RecoveryUI recoveryUI) {
        AppMethodBeat.i(193928);
        recoveryUI.xRO.setClickable(false);
        recoveryUI.xRO.setVisibility(8);
        recoveryUI.krF.setVisibility(0);
        AppMethodBeat.o(193928);
    }

    static /* synthetic */ void e(RecoveryUI recoveryUI) {
        AppMethodBeat.i(193930);
        f.i("MicroMsg.recovery.ui", "restart WeChat");
        i iQ = i.iQ(recoveryUI.getApplication());
        iQ.NBY = false;
        iQ.NBW = true;
        iQ.save();
        f.iL(recoveryUI.getApplicationContext());
        Intent launchIntentForPackage = recoveryUI.getApplication().getPackageManager().getLaunchIntentForPackage(recoveryUI.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268468224);
            a bl = new a().bl(launchIntentForPackage);
            com.tencent.mm.hellhoundlib.a.a.a(recoveryUI, bl.axQ(), "com/tencent/mm/recovery/ui/RecoveryUI", "restart", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            recoveryUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(recoveryUI, "com/tencent/mm/recovery/ui/RecoveryUI", "restart", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            recoveryUI.overridePendingTransition(0, 0);
        }
        recoveryUI.finish();
        AppMethodBeat.o(193930);
    }

    static /* synthetic */ void f(RecoveryUI recoveryUI) {
        int i2;
        AppMethodBeat.i(193931);
        try {
            com.tencent.mm.recoveryv2.h iM = com.tencent.mm.recoveryv2.h.iM(recoveryUI);
            StringBuilder sb = new StringBuilder("crash count = ");
            if (recoveryUI.NBk == null) {
                i2 = 0;
            } else {
                i2 = recoveryUI.NBk.crashCount;
            }
            f.i("MicroMsg.recovery.ui", sb.append(i2).append(", recovery setting = ").append(iM.NBL).toString());
            if (recoveryUI.NBk != null && recoveryUI.NBk.crashCount >= iM.NBL) {
                f.i("MicroMsg.recovery.ui", "clean tinker path (if exists)");
                b.e(d.dks);
                f.i("MicroMsg.recovery.ui", "clean tinker path done");
            }
            for (Map.Entry<String, e> entry : k.guX().NCt.entrySet()) {
                try {
                    e value = entry.getValue();
                    recoveryUI.getApplicationContext();
                    value.guv();
                    f.w("MicroMsg.recovery.ui", "on recovery fallback, operation: \n" + value.getDescription());
                    if (recoveryUI.NBk != null) {
                        Context applicationContext = recoveryUI.getApplicationContext();
                        String key = entry.getKey();
                        RecoveryCrash.Record record = recoveryUI.NBk;
                        e value2 = entry.getValue();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", "fallback");
                            jSONObject.put("time", record.LKH);
                            jSONObject.put("crash_count", record.crashCount);
                            jSONObject.put("version", record.NBB);
                            jSONObject.put("actions", value2.getDescription());
                            applicationContext.getSharedPreferences("recovery_journal_fallback", 4).edit().putString(key, jSONObject.toString()).apply();
                        } catch (Throwable th) {
                            com.tencent.mm.recoveryv2.a.w("MicroMsg.recovery.journal", "put fallback desc fail", th);
                        }
                    }
                } catch (Throwable th2) {
                    f.w("MicroMsg.recovery.ui", "on recovery fallback fail, key = " + entry.getKey(), th2);
                }
            }
            AppMethodBeat.o(193931);
        } catch (Throwable th3) {
            AppMethodBeat.o(193931);
        }
    }

    static /* synthetic */ void g(RecoveryUI recoveryUI) {
        AppMethodBeat.i(193932);
        final int[] iArr = {0};
        try {
            AnonymousClass2 r2 = new c<Integer>() {
                /* class com.tencent.mm.recovery.ui.RecoveryUI.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.support.v4.e.c
                public final /* synthetic */ void accept(Integer num) {
                    AppMethodBeat.i(193922);
                    Integer num2 = num;
                    f.i("MicroMsg.recovery.ui", "#fetchTinkerPatch callback, status = ".concat(String.valueOf(num2)));
                    iArr[0] = num2.intValue();
                    AppMethodBeat.o(193922);
                }
            };
            Intent intent = recoveryUI.getIntent();
            String stringExtra = intent.getStringExtra("extra_patch_url");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getDataString();
            }
            if (TextUtils.isEmpty(stringExtra)) {
                f.i("MicroMsg.recovery.ui", "#fetchTinkerPatch fetch patch url with cgi");
                com.tencent.mm.recovery.b.b(recoveryUI.getApplicationContext(), r2);
            } else {
                f.i("MicroMsg.recovery.ui", "#fetchTinkerPatch download patch with given url, url = ".concat(String.valueOf(stringExtra)));
                com.tencent.mm.recovery.b.a(recoveryUI.getApplicationContext(), stringExtra, r2);
            }
        } catch (Throwable th) {
            f.w("MicroMsg.recovery.ui", "fetch error", th);
            iArr[0] = 10;
        }
        f.i("MicroMsg.recovery.ui", "#fetchTinkerPatch done, status = " + iArr[0]);
        i iQ = i.iQ(recoveryUI.getApplication());
        iQ.NBY = false;
        iQ.NBX = iArr[0];
        iQ.save();
        AppMethodBeat.o(193932);
    }
}
