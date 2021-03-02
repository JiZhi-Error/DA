package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.b.o;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI extends MMPreference implements i {
    private static LinkedList<cla> ppS;
    private ProgressDialog gtM;
    protected f nRm;
    private String ppR;
    private boolean ppT = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.base.preference.MMPreference
    public int getLayoutId() {
        return R.layout.bl7;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bx;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getHeaderResourceId() {
        return R.layout.bl6;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(5762);
        super.onCreate(bundle);
        g.azz().a(1031, this);
        g.azz().a(1030, this);
        initView();
        AppMethodBeat.o(5762);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(5763);
        if (this.ppT) {
            Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
            this.ppT = false;
            g.azz().a(new o(this.ppR, ppS), 0);
        }
        super.onPause();
        AppMethodBeat.o(5763);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(5764);
        g.azz().b(1031, this);
        g.azz().b(1030, this);
        super.onDestroy();
        AppMethodBeat.o(5764);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(5765);
        setMMTitle(R.string.bej);
        this.nRm = getPreferenceScreen();
        this.ppR = getIntent().getStringExtra("enterprise_biz_name");
        if (Util.isNullOrNil(this.ppR)) {
            Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
            finish();
            AppMethodBeat.o(5765);
            return;
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(5759);
                ReceiveTemplateMsgMgrUI.this.finish();
                AppMethodBeat.o(5759);
                return true;
            }
        });
        final h hVar = new h(this.ppR);
        g.azz().a(hVar, 0);
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fuw), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(5760);
                g.azz().a(hVar);
                AppMethodBeat.o(5760);
            }
        });
        AppMethodBeat.o(5765);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(5766);
        if (ppS == null) {
            Log.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
            AppMethodBeat.o(5766);
        } else {
            String str = preference.mKey;
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
                AppMethodBeat.o(5766);
            } else {
                Iterator<cla> it = ppS.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cla next = it.next();
                    if (str.equals(Util.nullAsNil(next.Mqy))) {
                        this.ppT = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            next.KHa = 0;
                        } else {
                            next.KHa = 1;
                        }
                    }
                }
                if (this.ppT) {
                    Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(5761);
                            if (ReceiveTemplateMsgMgrUI.this.ppT) {
                                ReceiveTemplateMsgMgrUI.this.ppT = false;
                                g.azz().a(new o(ReceiveTemplateMsgMgrUI.this.ppR, ReceiveTemplateMsgMgrUI.ppS), 0);
                            }
                            AppMethodBeat.o(5761);
                        }
                    }, 4000);
                }
                AppMethodBeat.o(5766);
            }
        }
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        clc clc;
        boolean z;
        AppMethodBeat.i(5767);
        if (qVar == null) {
            Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", Integer.valueOf(i2), Integer.valueOf(i3), str);
            AppMethodBeat.o(5767);
            return;
        }
        Log.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
        if (qVar.getType() == 1031) {
            if (this.gtM != null && this.gtM.isShowing()) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            if (i2 == 0 && i3 == 0) {
                h hVar = (h) qVar;
                if (hVar.rr == null || hVar.rr.iLL.iLR == null) {
                    clc = null;
                } else {
                    clc = (clc) hVar.rr.iLL.iLR;
                }
                ppS = clc.Mqz;
                LinkedList<cla> linkedList = ppS;
                this.nRm.removeAll();
                if (linkedList == null || linkedList.size() <= 0) {
                    Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
                    iH(true);
                    AppMethodBeat.o(5767);
                    return;
                }
                iH(false);
                Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", Integer.valueOf(linkedList.size()));
                Iterator<cla> it = linkedList.iterator();
                while (it.hasNext()) {
                    cla next = it.next();
                    CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this);
                    checkBoxPreference.OZw = false;
                    checkBoxPreference.setKey(next.Mqy);
                    checkBoxPreference.setTitle(next.Title);
                    if (next.KHa == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    checkBoxPreference.setChecked(z);
                    this.nRm.c(checkBoxPreference);
                }
                this.nRm.notifyDataSetChanged();
                Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
                AppMethodBeat.o(5767);
                return;
            }
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.fut), 1).show();
            iH(true);
            AppMethodBeat.o(5767);
        } else if (qVar.getType() != 1030 || (i2 == 0 && i3 == 0)) {
            AppMethodBeat.o(5767);
        } else {
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.fuu), 0).show();
            AppMethodBeat.o(5767);
        }
    }

    private void iH(boolean z) {
        AppMethodBeat.i(5768);
        View findViewById = findViewById(R.id.gu1);
        View findViewById2 = findViewById(R.id.gu2);
        if (findViewById != null) {
            if (z) {
                ((TextView) findViewById).setVisibility(0);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                    AppMethodBeat.o(5768);
                    return;
                }
            } else {
                ((TextView) findViewById).setVisibility(8);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(0);
                }
            }
        }
        AppMethodBeat.o(5768);
    }
}
