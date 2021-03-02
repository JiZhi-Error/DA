package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.ui.SelectMemberUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectAddRoomManagerUI extends SelectMemberUI {
    private boolean gAj = false;
    private HashSet<String> gAk = new HashSet<>();

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectAddRoomManagerUI() {
        AppMethodBeat.i(12912);
        AppMethodBeat.o(12912);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void anf() {
        AppMethodBeat.i(12913);
        super.anf();
        this.gAj = false;
        for (String str : this.gtd.bax()) {
            if (this.gtd.bjf(str)) {
                this.gAk.add(str);
            }
        }
        AppMethodBeat.o(12913);
    }

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final boolean ang() {
        return true;
    }

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        String string;
        t.b bVar;
        AppMethodBeat.i(12914);
        super.initView();
        setMMTitle(this.gAj ? getString(R.string.g9i) : getString(R.string.g9h));
        if (this.gAj) {
            string = getString(R.string.blk);
        } else {
            string = getString(R.string.vl);
        }
        AnonymousClass1 r3 = new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12911);
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", Util.listToString(SelectAddRoomManagerUI.a(SelectAddRoomManagerUI.this), ","));
                SelectAddRoomManagerUI.this.setResult(-1, intent);
                SelectAddRoomManagerUI.this.finish();
                SelectAddRoomManagerUI.this.hideVKB();
                AppMethodBeat.o(12911);
                return false;
            }
        };
        if (this.gAj) {
            bVar = t.b.RED;
        } else {
            bVar = t.b.GREEN;
        }
        addTextOptionMenu(1, string, r3, null, bVar);
        ani();
        AppMethodBeat.o(12914);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void z(int i2, boolean z) {
        AppMethodBeat.i(12915);
        super.z(i2, z);
        ani();
        AppMethodBeat.o(12915);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(12916);
        hideVKB();
        super.finish();
        AppMethodBeat.o(12916);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void a(View view, int i2, long j2) {
        AppMethodBeat.i(12917);
        super.a(view, i2, j2);
        SelectMemberUI.c cVar = (SelectMemberUI.c) view.getTag();
        String arJ = cVar.gAM.contact.arJ();
        Log.d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", cVar.gAM.contact.field_username, arJ, cVar.gAM.contact.arI());
        cVar.gAQ.performClick();
        AppMethodBeat.o(12917);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final HashSet<String> anh() {
        return this.gAk;
    }

    private void ani() {
        AppMethodBeat.i(12918);
        if (this.gAB.size() > 0) {
            enableOptionMenu(1, true);
            AppMethodBeat.o(12918);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.o(12918);
    }

    static /* synthetic */ ArrayList a(SelectAddRoomManagerUI selectAddRoomManagerUI) {
        AppMethodBeat.i(12919);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(selectAddRoomManagerUI.gAB);
        AppMethodBeat.o(12919);
        return arrayList;
    }
}
