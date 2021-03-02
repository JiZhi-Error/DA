package com.tencent.mm.ui.matrix;

import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.resource.analyzer.model.a;
import com.tencent.matrix.resource.analyzer.model.c;
import com.tencent.matrix.resource.analyzer.model.g;
import com.tencent.matrix.resource.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ManualDumpActivity extends MMActivity {
    private String QmC = null;
    private String QmD = null;
    private TextView QmE;
    private TextView QmF;
    private boolean QmG = false;
    private o QmH;
    private MMHandler mainHandler = new MMHandler(Looper.getMainLooper());

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ManualDumpActivity() {
        AppMethodBeat.i(38869);
        AppMethodBeat.o(38869);
    }

    static /* synthetic */ a b(o oVar, String str, Boolean bool) {
        AppMethodBeat.i(169899);
        a a2 = a(oVar, str, bool);
        AppMethodBeat.o(169899);
        return a2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38870);
        super.onCreate(bundle);
        setMMTitle("Activity Leak");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.matrix.ManualDumpActivity.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38863);
                ManualDumpActivity.this.finish();
                AppMethodBeat.o(38863);
                return true;
            }
        });
        this.QmE = (TextView) findViewById(R.id.ea0);
        this.QmF = (TextView) findViewById(R.id.dsr);
        this.QmE.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.ui.matrix.ManualDumpActivity.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(38864);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/ManualDumpActivity$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                ClipboardHelper.setText(ManualDumpActivity.this.QmE.getText().toString());
                h.cD(ManualDumpActivity.this, ManualDumpActivity.this.getString(R.string.ta));
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/matrix/ManualDumpActivity$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(38864);
                return true;
            }
        });
        this.QmD = getIntent().getStringExtra(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        this.QmC = getIntent().getStringExtra("ref_key");
        ((TextView) findViewById(R.id.e_z)).setText(this.QmD);
        AppMethodBeat.o(38870);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b6e;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(38871);
        super.onBackPressed();
        finish();
        AppMethodBeat.o(38871);
    }

    public void onClick(View view) {
        AppMethodBeat.i(38872);
        com.tencent.matrix.resource.b bVar = (com.tencent.matrix.resource.b) com.tencent.matrix.b.RG().Y(com.tencent.matrix.resource.b.class);
        if (bVar == null) {
            AppMethodBeat.o(38872);
            return;
        }
        com.tencent.matrix.resource.e.b bVar2 = bVar.cWQ;
        if (bVar2 == null) {
            AppMethodBeat.o(38872);
        } else if (bVar2.cZJ == null) {
            AppMethodBeat.o(38872);
        } else {
            HandlerThread handlerThread = new HandlerThread("DumpHprofWorker");
            handlerThread.start();
            final Handler handler = new Handler(handlerThread.getLooper());
            final View findViewById = findViewById(R.id.gl7);
            view.animate().alpha(0.0f).setDuration(300).withEndAction(new Runnable() {
                /* class com.tencent.mm.ui.matrix.ManualDumpActivity.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(38868);
                    handler.post(new Runnable() {
                        /* class com.tencent.mm.ui.matrix.ManualDumpActivity.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(38867);
                            if (ManualDumpActivity.this.QmH == null) {
                                long currentTimeMillis = System.currentTimeMillis();
                                d dVar = new d(MMApplicationContext.getContext());
                                ManualDumpActivity.this.QmH = o.X(dVar.Tj());
                                try {
                                    Debug.dumpHprofData(aa.z(ManualDumpActivity.this.QmH.her()));
                                } catch (IOException e2) {
                                    Log.printErrStackTrace("ManualDumpActivity", e2, "", new Object[0]);
                                }
                                Log.i("ManualDumpActivity", String.format("cost=%sms refString=%s path=%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ManualDumpActivity.this.QmC, aa.z(ManualDumpActivity.this.QmH.her())));
                                ManualDumpActivity.this.mainHandler.post(new Runnable() {
                                    /* class com.tencent.mm.ui.matrix.ManualDumpActivity.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(38865);
                                        ManualDumpActivity.this.QmF.setText(aa.z(ManualDumpActivity.this.QmH.her()));
                                        findViewById.setVisibility(0);
                                        AppMethodBeat.o(38865);
                                    }
                                });
                            }
                            final a b2 = ManualDumpActivity.b(ManualDumpActivity.this.QmH, ManualDumpActivity.this.QmC, Boolean.valueOf(ManualDumpActivity.this.QmG));
                            ManualDumpActivity.this.mainHandler.post(new Runnable() {
                                /* class com.tencent.mm.ui.matrix.ManualDumpActivity.AnonymousClass3.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(38866);
                                    if (b2.cWT && b2.cWV != null) {
                                        ManualDumpActivity.this.QmE.setTextColor(ManualDumpActivity.this.getResources().getColor(17170457));
                                        String hVar = b2.cWV.toString();
                                        ManualDumpActivity.this.QmE.setText(hVar);
                                        Log.i("ManualDumpActivity", hVar);
                                        findViewById.setVisibility(8);
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(SharePluginInfo.ISSUE_KEY_STACK, hVar);
                                        hashMap.put("isHardAnalyze", Boolean.valueOf(ManualDumpActivity.this.QmG));
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(18573, b2.mClassName, hashMap, 0, 1000, 0);
                                        Log.i("ManualDumpActivity", hVar);
                                        Toast.makeText(ManualDumpActivity.this.getContext(), "已成功上报", 1).show();
                                        AppMethodBeat.o(38866);
                                    } else if (b2.cWW == null) {
                                        ManualDumpActivity.this.QmE.setTextColor(ManualDumpActivity.this.getResources().getColor(17170453));
                                        ManualDumpActivity.this.QmE.setText("not found!");
                                        findViewById.setVisibility(8);
                                        AppMethodBeat.o(38866);
                                    } else if (ManualDumpActivity.this.QmG) {
                                        ManualDumpActivity.this.QmE.setTextColor(ManualDumpActivity.this.getResources().getColor(17170455));
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            b2.q(jSONObject);
                                        } catch (JSONException e2) {
                                            Log.printErrStackTrace("ManualDumpActivity", e2, "", new Object[0]);
                                        }
                                        ManualDumpActivity.this.QmE.setText(jSONObject.toString());
                                        findViewById.setVisibility(8);
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put(SharePluginInfo.ISSUE_KEY_STACK, jSONObject.toString());
                                        hashMap2.put("isHardAnalyze", Boolean.valueOf(ManualDumpActivity.this.QmG));
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(18573, b2.mClassName, hashMap2, 0, 1000, 1);
                                        Log.i("ManualDumpActivity", jSONObject.toString());
                                        Toast.makeText(ManualDumpActivity.this.getContext(), "已成功上报", 1).show();
                                        AppMethodBeat.o(38866);
                                    } else {
                                        ManualDumpActivity.this.QmG = true;
                                        ManualDumpActivity.this.mainHandler.post(this);
                                        AppMethodBeat.o(38866);
                                    }
                                }
                            });
                            AppMethodBeat.o(38867);
                        }
                    });
                    AppMethodBeat.o(38868);
                }
            }).start();
            AppMethodBeat.o(38872);
        }
    }

    private static a a(o oVar, String str, Boolean bool) {
        com.tencent.matrix.resource.analyzer.model.d SY;
        a a2;
        AppMethodBeat.i(169898);
        if (bool.booleanValue()) {
            SY = c.l(Build.VERSION.SDK_INT, Build.MANUFACTURER).SY();
        } else {
            SY = c.m(Build.VERSION.SDK_INT, Build.MANUFACTURER).SY();
        }
        try {
            a2 = new com.tencent.matrix.resource.analyzer.a(str, SY).a(new g(oVar));
        } catch (IOException e2) {
            a2 = a.a(e2, 0);
        }
        AppMethodBeat.o(169898);
        return a2;
    }
}
