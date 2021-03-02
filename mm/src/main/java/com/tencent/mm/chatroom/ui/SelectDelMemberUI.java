package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.ui.SelectMemberUI;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectDelMemberUI extends SelectMemberUI {
    private int gxQ;

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void anf() {
        AppMethodBeat.i(12929);
        super.anf();
        this.gxQ = getIntent().getIntExtra("room_member_count", 0);
        AppMethodBeat.o(12929);
    }

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final boolean ang() {
        return true;
    }

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(12930);
        super.initView();
        setMMTitle(getString(R.string.g9g) + "(" + this.gxQ + ")");
        addTextOptionMenu(1, getString(R.string.blk), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.SelectDelMemberUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12928);
                h.a(SelectDelMemberUI.this, SelectDelMemberUI.this.getString(R.string.g6p), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.SelectDelMemberUI.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(12927);
                        Intent intent = new Intent();
                        intent.putExtra("Select_Contact", Util.listToString(SelectDelMemberUI.a(SelectDelMemberUI.this), ","));
                        SelectDelMemberUI.this.setResult(-1, intent);
                        SelectDelMemberUI.this.finish();
                        AppMethodBeat.o(12927);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.SelectDelMemberUI.AnonymousClass1.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(12928);
                return false;
            }
        }, null, t.b.RED);
        ani();
        AppMethodBeat.o(12930);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(12931);
        hideVKB();
        super.finish();
        AppMethodBeat.o(12931);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final HashSet<String> anj() {
        AppMethodBeat.i(12932);
        HashSet<String> anj = super.anj();
        if (ano().JO(z.aTY())) {
            AppMethodBeat.o(12932);
            return anj;
        }
        for (String str : ano().bax()) {
            if (ano().bjf(str) || ano().JO(str)) {
                anj.add(str);
            }
        }
        AppMethodBeat.o(12932);
        return anj;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void z(int i2, boolean z) {
        AppMethodBeat.i(12933);
        super.z(i2, z);
        ani();
        AppMethodBeat.o(12933);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void a(View view, int i2, long j2) {
        AppMethodBeat.i(12934);
        super.a(view, i2, j2);
        ((SelectMemberUI.c) view.getTag()).gAQ.performClick();
        AppMethodBeat.o(12934);
    }

    private void ani() {
        AppMethodBeat.i(12935);
        if (this.gAB.size() > 0) {
            updateOptionMenuText(1, getString(R.string.blk) + "(" + this.gAB.size() + ")");
            enableOptionMenu(1, true);
            AppMethodBeat.o(12935);
            return;
        }
        updateOptionMenuText(1, getString(R.string.blk));
        enableOptionMenu(1, false);
        AppMethodBeat.o(12935);
    }

    static /* synthetic */ ArrayList a(SelectDelMemberUI selectDelMemberUI) {
        AppMethodBeat.i(12936);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(selectDelMemberUI.gAB);
        AppMethodBeat.o(12936);
        return arrayList;
    }
}
