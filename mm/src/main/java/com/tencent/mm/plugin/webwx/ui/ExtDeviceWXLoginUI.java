package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class ExtDeviceWXLoginUI extends MMActivity implements i {
    private int JFo;
    private int JFp;
    private boolean JFq = false;
    private Button JFr;
    private TextView JFs;
    private ImageView JFt;
    private String JFu = "";
    private boolean dSp = false;
    private String dZW = null;
    private int jjN = 0;
    private int type = 0;
    private ProgressDialog vIA = null;
    private boolean yAX = false;
    private String yBa = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ View e(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        AppMethodBeat.i(30211);
        View contentView = extDeviceWXLoginUI.getContentView();
        AppMethodBeat.o(30211);
        return contentView;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30202);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        setActionbarColor(getResources().getColor(R.color.f3045c));
        initView();
        overridePendingTransition(R.anim.dq, R.anim.s);
        AppMethodBeat.o(30202);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(30203);
        super.onResume();
        AppMethodBeat.o(30203);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0280, code lost:
        if (((java.lang.Boolean) com.tencent.mm.model.c.azQ().get(com.tencent.mm.storage.ar.a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, java.lang.Boolean.TRUE)).booleanValue() == false) goto L_0x0282;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x030d  */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 804
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.initView():void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(30205);
        super.onPause();
        if (this.JFq && bg.aAc()) {
            bfx bfx = new bfx();
            bfx.LPB = 27;
            bfx.BsD = z.aqE() ? 1 : 2;
            bg.aVF();
            c.aSM().d(new k.a(23, bfx));
            this.JFq = false;
        }
        AppMethodBeat.o(30205);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.zm;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(30206);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(30206);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(30207);
        super.onDestroy();
        bg.azz().b(972, this);
        bg.azz().b(973, this);
        AppMethodBeat.o(30207);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        byte[] bArr;
        AppMethodBeat.i(30208);
        if (this.vIA != null) {
            this.vIA.dismiss();
            this.vIA = null;
        }
        if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", Integer.valueOf(qVar.getType()), Integer.valueOf(i3), Integer.valueOf(i2));
            bg.azz().b(972, this);
            if (qVar.getType() == 972) {
                e eVar = (e) qVar;
                if (eVar.yAX || this.dSp) {
                    aky aky = (aky) eVar.iUB.iLL.iLR;
                    if (aky == null || aky.LtO == null) {
                        bArr = null;
                    } else {
                        bArr = aky.LtO.toByteArray();
                    }
                    ms msVar = new ms();
                    msVar.dSm.dSn = bArr;
                    msVar.dSm.dSo = this.jjN;
                    msVar.dSm.dSp = this.dSp;
                    EventCenter.instance.publish(msVar);
                }
            } else {
                qVar.getType();
            }
            this.type = 0;
            finish();
            AppMethodBeat.o(30208);
            return;
        }
        if (i3 == -1) {
            this.type = -1;
        } else if (i3 == -2) {
            this.type = -2;
        }
        if (!Util.isNullOrNil(str)) {
            ((CheckBox) findViewById(R.id.i5b)).setVisibility(8);
            ((TextView) findViewById(R.id.i5a)).setVisibility(0);
            ((TextView) findViewById(R.id.i5a)).setText(str);
        }
        if (this.type == -1) {
            if (this.JFr != null) {
                this.JFr.setEnabled(false);
            }
        } else if (this.type == -2) {
            if (this.JFr != null) {
                this.JFr.setEnabled(true);
                this.JFr.setText(R.string.j13);
            }
            if (this.JFs != null) {
                this.JFs.setVisibility(4);
            }
        }
        Log.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        AppMethodBeat.o(30208);
    }

    static /* synthetic */ boolean c(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        AppMethodBeat.i(30209);
        final com.tencent.mm.plugin.webwx.a.c cVar = new com.tencent.mm.plugin.webwx.a.c(extDeviceWXLoginUI.dZW);
        bg.azz().a(cVar, 0);
        extDeviceWXLoginUI.vIA = h.a((Context) extDeviceWXLoginUI.getContext(), extDeviceWXLoginUI.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(30201);
                bg.azz().a(cVar);
                if (ExtDeviceWXLoginUI.this.vIA != null) {
                    ExtDeviceWXLoginUI.this.vIA.cancel();
                }
                AppMethodBeat.o(30201);
            }
        });
        AppMethodBeat.o(30209);
        return true;
    }

    static /* synthetic */ boolean b(ExtDeviceWXLoginUI extDeviceWXLoginUI, boolean z) {
        AppMethodBeat.i(30210);
        final e eVar = new e(extDeviceWXLoginUI.dZW, extDeviceWXLoginUI.yBa, z);
        bg.azz().a(eVar, 0);
        extDeviceWXLoginUI.vIA = h.a((Context) extDeviceWXLoginUI.getContext(), extDeviceWXLoginUI.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(30200);
                bg.azz().a(eVar);
                if (ExtDeviceWXLoginUI.this.vIA != null) {
                    ExtDeviceWXLoginUI.this.vIA.cancel();
                }
                AppMethodBeat.o(30200);
            }
        });
        AppMethodBeat.o(30210);
        return true;
    }

    static /* synthetic */ void f(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        AppMethodBeat.i(30212);
        int height = extDeviceWXLoginUI.findViewById(R.id.jlf).getHeight();
        int statusBarHeight = ao.getStatusBarHeight(extDeviceWXLoginUI);
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        int i2 = point.y;
        Log.i("MicroMsg.ExtDeviceWXLoginUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", Integer.valueOf(statusBarHeight), Integer.valueOf(i2), Integer.valueOf(height));
        ImageView imageView = (ImageView) extDeviceWXLoginUI.findViewById(R.id.i5e);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = (((int) (((double) i2) / 4.0d)) - statusBarHeight) - height;
        imageView.setLayoutParams(layoutParams);
        AppMethodBeat.o(30212);
    }
}
