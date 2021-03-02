package com.tencent.mm.plugin.sight.draft.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public class SightDraftUI extends MMActivity {
    private int DoO = 1;
    SightDraftContainerView DoP;
    private LinkedList<String> DoQ = new LinkedList<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SightDraftUI() {
        AppMethodBeat.i(28699);
        AppMethodBeat.o(28699);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28700);
        super.onCreate(bundle);
        setMMTitle(R.string.h2a);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.fm));
        this.DoP = new SightDraftContainerView(this);
        setContentView(this.DoP);
        this.DoP.eVW();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sight.draft.ui.SightDraftUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28695);
                SightDraftUI.this.finish();
                AppMethodBeat.o(28695);
                return false;
            }
        });
        this.DoP.setSightDraftCallback(new a() {
            /* class com.tencent.mm.plugin.sight.draft.ui.SightDraftUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.sight.draft.ui.a
            public final void eVT() {
                AppMethodBeat.i(28697);
                SightDraftUI.this.addTextOptionMenu(SightDraftUI.this.DoO, SightDraftUI.this.getString(R.string.h20), new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.sight.draft.ui.SightDraftUI.AnonymousClass2.AnonymousClass1 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(28696);
                        SightDraftUI.b(SightDraftUI.this);
                        AppMethodBeat.o(28696);
                        return true;
                    }
                });
                AppMethodBeat.o(28697);
            }

            @Override // com.tencent.mm.plugin.sight.draft.ui.a
            public final void eVU() {
                AppMethodBeat.i(28698);
                SightDraftUI.this.removeOptionMenu(SightDraftUI.this.DoO);
                AppMethodBeat.o(28698);
            }
        });
        AppMethodBeat.o(28700);
    }

    static /* synthetic */ void b(SightDraftUI sightDraftUI) {
        AppMethodBeat.i(28701);
        p.a(sightDraftUI, new Runnable() {
            /* class com.tencent.mm.plugin.sight.draft.ui.SightDraftUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(232060);
                j lastDrafInfo = SightDraftUI.this.DoP.getLastDrafInfo();
                if (lastDrafInfo == null) {
                    AppMethodBeat.o(232060);
                    return;
                }
                String Qh = k.Qh(lastDrafInfo.field_fileName);
                if (SightDraftUI.this.DoQ.contains(Qh)) {
                    AppMethodBeat.o(232060);
                    return;
                }
                SightDraftUI.this.DoQ.add(Qh);
                StringBuilder append = new StringBuilder().append(AndroidMediaUtil.getSysCameraDirPath());
                Object[] objArr = new Object[3];
                objArr[0] = WeChatBrands.AppInfo.current().isMainland() ? "wx_camera_" : "w_camera_";
                objArr[1] = Long.valueOf(System.currentTimeMillis());
                objArr[2] = "mp4";
                String sb = append.append(String.format("%s%d.%s", objArr)).toString();
                Log.i("MicroMsg.SightDraftUI", "save src %s dest %s ", Qh, sb);
                s.nw(Qh, sb);
                AndroidMediaUtil.refreshMediaScanner(sb, SightDraftUI.this);
                u.makeText(SightDraftUI.this, SightDraftUI.this.getString(R.string.h2_, new Object[]{AndroidMediaUtil.getToastSysCameraPath()}), 1).show();
                AppMethodBeat.o(232060);
            }
        }, new Runnable() {
            /* class com.tencent.mm.plugin.sight.draft.ui.SightDraftUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(232061);
                u.makeText(SightDraftUI.this, SightDraftUI.this.getString(R.string.hwt), 1).show();
                AppMethodBeat.o(232061);
            }
        });
        AppMethodBeat.o(28701);
    }
}
