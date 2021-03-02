package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.ui.SelectMemberUI;
import com.tencent.mm.hellhoundlib.b.a;
import org.xwalk.core.Log;

public class SeeMemberRecordUI extends SelectMemberUI {
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void a(View view, int i2, long j2) {
        AppMethodBeat.i(12823);
        super.a(view, i2, j2);
        SelectMemberUI.a on = this.gAA.on(i2);
        if (on == null) {
            Log.e("MicroMsg.SeeMemberRecordUI", "item is null!");
            AppMethodBeat.o(12823);
        } else if (on.contact == null) {
            Log.e("MicroMsg.SeeMemberRecordUI", "contact is null!");
            AppMethodBeat.o(12823);
        } else {
            String str = on.contact.field_username;
            hideVKB();
            Intent intent = new Intent(this, SelectedMemberChattingRecordUI.class);
            intent.putExtra("RoomInfo_Id", this.gwx);
            intent.putExtra("room_member", str);
            intent.putExtra("title", getString(R.string.ghd));
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/chatroom/ui/SeeMemberRecordUI", "doSeeMemberRecord", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeMemberRecordUI", "doSeeMemberRecord", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(12823);
        }
    }

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final boolean anc() {
        return true;
    }

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12824);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.c_), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        AppMethodBeat.o(12824);
    }
}
