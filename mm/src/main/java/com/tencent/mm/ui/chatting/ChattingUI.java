package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.c;
import com.tencent.mm.ui.tools.x;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@i
@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI extends MMSecDataFragmentActivity {
    public ChattingUIFragment Pjl;
    public MMHandler Pjm = new MMHandler();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChattingUI() {
        AppMethodBeat.i(34694);
        AppMethodBeat.o(34694);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34695);
        getWindow().setFormat(-2);
        if (!ao.gJK()) {
            h.aU(this);
        }
        super.onCreate(null);
        if (c.bC(getIntent())) {
            finish();
            AppMethodBeat.o(34695);
            return;
        }
        setContentView(R.layout.u8);
        this.Pjl = gMI();
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_CHATTING_ACTIVITY", true);
        this.Pjl.setArguments(extras);
        getSupportFragmentManager().beginTransaction().a(R.id.fgf, this.Pjl).commit();
        getSupportActionBar().show();
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.ui.chatting.ChattingUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(34692);
                    com.tencent.mm.ui.base.h.c(ChattingUI.this, ChattingUI.this.getString(R.string.ffz), "", ChattingUI.this.getString(R.string.fg0), ChattingUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.ChattingUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(34690);
                            EventCenter.instance.publish(new sj());
                            AppMethodBeat.o(34690);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.ChattingUI.AnonymousClass1.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(34691);
                            EventCenter.instance.publish(new oh());
                            AppMethodBeat.o(34691);
                        }
                    });
                    AppMethodBeat.o(34692);
                }
            }, 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        initNavigationSwipeBack();
        this.Pjm.post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.ChattingUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(34693);
                if (ChattingUI.this.Pjl != null && !ao.gJK()) {
                    h.a((MMFragmentActivity) ChattingUI.this, ChattingUI.this.Pjl.getBodyView());
                }
                b.cw(ChattingUI.this.Pjl.getContext());
                AppMethodBeat.o(34693);
            }
        });
        AppMethodBeat.o(34695);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(232883);
        super.onResume();
        if (ao.gJK()) {
            bg.getNotification().di(true);
        }
        AppMethodBeat.o(232883);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(232884);
        super.onPause();
        if (ao.gJK()) {
            bg.getNotification().di(false);
        }
        AppMethodBeat.o(232884);
    }

    /* access modifiers changed from: protected */
    public ChattingUIFragment gMI() {
        AppMethodBeat.i(34696);
        ChattingUIFragment chattingUIFragment = new ChattingUIFragment((byte) 0);
        AppMethodBeat.o(34696);
        return chattingUIFragment;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(232885);
        if (this.Pjl != null && ((ai) this.Pjl.dom.bh(ai.class)).gQN() && !((ai) this.Pjl.dom.bh(ai.class)).gQQ()) {
            int gQS = ((ai) this.Pjl.dom.bh(ai.class)).gQS();
            getIntent().putExtra("select_record_msg_num", gQS);
            Set<Long> gOs = ((k) this.Pjl.dom.bh(k.class)).gOs();
            if (gOs != null) {
                long j2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                for (Long l : gOs) {
                    if (l.longValue() < j2) {
                        j2 = l.longValue();
                    } else {
                        j2 = j2;
                    }
                }
                getIntent().putExtra("select_record_min_msg_id", j2);
            }
            CopyOnWriteArraySet<Long> gQR = ((ai) this.Pjl.dom.bh(ai.class)).gQR();
            if (gQR != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (Long l2 : gQR) {
                    arrayList.add(String.valueOf(l2.longValue()));
                }
                getIntent().putStringArrayListExtra("key_select_record_msg_black_list", arrayList);
            }
            Log.i("MicroMsg.ChattingUI", "select record msg %s", Integer.valueOf(gQS));
            setResult(-1, getIntent());
        }
        super.finish();
        AppMethodBeat.o(232885);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(34697);
        Log.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", keyEvent);
        if (this.Pjl == null || !this.Pjl.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(34697);
            return dispatchKeyEvent;
        }
        AppMethodBeat.o(34697);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(34698);
        Log.d("MicroMsg.ChattingUI", "chatting ui on key up");
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(34698);
        return onKeyUp;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(34699);
        Log.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", Integer.valueOf(i2), keyEvent);
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(34699);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(34700);
        Log.i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
        this.Pjl.onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(34700);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(34701);
        super.onActivityResult(i2, i3, intent);
        this.Pjl.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(34701);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(232886);
        if (!(intent == null || intent.getComponent() == null)) {
            x xVar = x.Qxl;
            x.bnV(intent.getComponent().getClassName());
        }
        super.startActivityForResult(intent, i2, bundle);
        AppMethodBeat.o(232886);
    }
}
