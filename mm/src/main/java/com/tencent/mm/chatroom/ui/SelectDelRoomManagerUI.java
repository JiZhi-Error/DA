package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.ui.SelectMemberUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.List;

public class SelectDelRoomManagerUI extends SelectMemberUI {
    private boolean gAj = false;
    private List<String> gAu = new ArrayList();

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectDelRoomManagerUI() {
        AppMethodBeat.i(12939);
        AppMethodBeat.o(12939);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void anf() {
        AppMethodBeat.i(12940);
        super.anf();
        String stringExtra = getIntent().getStringExtra("RoomManagers");
        if (stringExtra != null) {
            String[] split = stringExtra.split(",");
            for (String str : split) {
                this.gAu.add(str);
            }
        }
        this.gAj = true;
        AppMethodBeat.o(12940);
    }

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final boolean ang() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final boolean ank() {
        return false;
    }

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        String string;
        t.b bVar;
        AppMethodBeat.i(12941);
        super.initView();
        setMMTitle(this.gAj ? getString(R.string.g9i) : getString(R.string.g9h));
        if (this.gAj) {
            string = getString(R.string.blk);
        } else {
            string = getString(R.string.vl);
        }
        AnonymousClass1 r3 = new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12938);
                if (SelectDelRoomManagerUI.this.gAj) {
                    h.a(SelectDelRoomManagerUI.this, SelectDelRoomManagerUI.this.getString(R.string.g6p), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(12937);
                            Intent intent = new Intent();
                            intent.putExtra("Select_Contact", Util.listToString(SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this), ","));
                            SelectDelRoomManagerUI.this.setResult(-1, intent);
                            SelectDelRoomManagerUI.this.finish();
                            AppMethodBeat.o(12937);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI.AnonymousClass1.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(12938);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Contact", Util.listToString(SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this), ","));
                    SelectDelRoomManagerUI.this.setResult(-1, intent);
                    SelectDelRoomManagerUI.this.finish();
                    AppMethodBeat.o(12938);
                }
                return true;
            }
        };
        if (this.gAj) {
            bVar = t.b.RED;
        } else {
            bVar = t.b.GREEN;
        }
        addTextOptionMenu(1, string, r3, null, bVar);
        ani();
        AppMethodBeat.o(12941);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(12942);
        hideVKB();
        super.finish();
        AppMethodBeat.o(12942);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void a(View view, int i2, long j2) {
        AppMethodBeat.i(12943);
        super.a(view, i2, j2);
        ((SelectMemberUI.c) view.getTag()).gAQ.performClick();
        AppMethodBeat.o(12943);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final BaseAdapter anl() {
        AppMethodBeat.i(12944);
        BaseAdapter anl = super.anl();
        AppMethodBeat.o(12944);
        return anl;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void z(int i2, boolean z) {
        AppMethodBeat.i(12945);
        super.z(i2, z);
        ani();
        AppMethodBeat.o(12945);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final List<String> anm() {
        return this.gAu;
    }

    private void ani() {
        AppMethodBeat.i(12946);
        if (this.gAB.size() > 0) {
            enableOptionMenu(1, true);
            AppMethodBeat.o(12946);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.o(12946);
    }

    static /* synthetic */ ArrayList b(SelectDelRoomManagerUI selectDelRoomManagerUI) {
        AppMethodBeat.i(12947);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(selectDelRoomManagerUI.gAB);
        AppMethodBeat.o(12947);
        return arrayList;
    }
}
