package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class AutoAddFriendUI extends MMActivity {
    private MMSwitchBtn FKr = null;
    private TextView FKs = null;
    private MMSwitchBtn FKt = null;
    private SparseIntArray FKu = new SparseIntArray();
    private int status;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AutoAddFriendUI() {
        AppMethodBeat.i(29009);
        AppMethodBeat.o(29009);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29010);
        super.onCreate(bundle);
        setMMTitle(R.string.a4p);
        this.status = z.aUc();
        initView();
        AppMethodBeat.o(29010);
    }

    private boolean ftj() {
        AppMethodBeat.i(29011);
        bg.aVF();
        c.azQ().set(7, Integer.valueOf(this.status));
        for (int i2 = 0; i2 < this.FKu.size(); i2++) {
            int keyAt = this.FKu.keyAt(i2);
            int valueAt = this.FKu.valueAt(i2);
            bfx bfx = new bfx();
            bfx.LPB = keyAt;
            bfx.BsD = valueAt;
            bg.aVF();
            c.aSM().d(new k.a(23, bfx));
            Log.d("MicroMsg.AutoAddFriendUI", "switch  " + keyAt + " " + valueAt);
        }
        this.FKu.clear();
        AppMethodBeat.o(29011);
        return true;
    }

    private boolean UM(int i2) {
        return (this.status & i2) != 0;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.he;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29012);
        this.FKr = (MMSwitchBtn) findViewById(R.id.fut);
        this.FKs = (TextView) findViewById(R.id.wb);
        this.FKt = (MMSwitchBtn) findViewById(R.id.wa);
        this.FKr.setCheck(UM(32));
        if (ftk() == 1) {
            this.FKt.setCheck(UM(TPMediaCodecProfileLevel.HEVCHighTierLevel6));
            this.FKt.setSwitchListener(new MMSwitchBtn.a() {
                /* class com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
                public final void onStatusChange(boolean z) {
                    AppMethodBeat.i(29006);
                    AutoAddFriendUI.a(AutoAddFriendUI.this, z, TPMediaCodecProfileLevel.HEVCHighTierLevel6, 32);
                    AppMethodBeat.o(29006);
                }
            });
        } else {
            this.FKs.setVisibility(8);
            this.FKt.setVisibility(8);
        }
        this.FKr.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(29007);
                AutoAddFriendUI.a(AutoAddFriendUI.this, z, 32, 4);
                AppMethodBeat.o(29007);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29008);
                AutoAddFriendUI.this.finish();
                AppMethodBeat.o(29008);
                return true;
            }
        });
        AppMethodBeat.o(29012);
    }

    private static int ftk() {
        int i2;
        AppMethodBeat.i(29013);
        String value = h.aqJ().getValue("AutoAddFriendShow");
        if (Util.isNullOrNil(value)) {
            value = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        try {
            i2 = Util.getInt(value, 0);
        } catch (Exception e2) {
            i2 = 0;
        }
        Log.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", Integer.valueOf(i2));
        AppMethodBeat.o(29013);
        return i2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(29014);
        super.onResume();
        AppMethodBeat.o(29014);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29015);
        super.onPause();
        ftj();
        AppMethodBeat.o(29015);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29016);
        super.onDestroy();
        AppMethodBeat.o(29016);
    }

    static /* synthetic */ boolean a(AutoAddFriendUI autoAddFriendUI, boolean z, int i2, int i3) {
        AppMethodBeat.i(29017);
        Log.d("MicroMsg.AutoAddFriendUI", "switch change : open = " + z + " item value = " + i2 + " functionId = " + i3);
        if (z) {
            autoAddFriendUI.status |= i2;
        } else {
            autoAddFriendUI.status &= i2 ^ -1;
        }
        autoAddFriendUI.FKu.put(i3, z ? 1 : 2);
        AppMethodBeat.o(29017);
        return true;
    }
}
