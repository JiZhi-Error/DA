package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.chatroom.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import java.util.HashMap;

public class SelectDateUI extends MMActivity implements a {
    private DayPickerView gAm;
    private String gAn;
    private HashMap<String, com.tencent.mm.chatroom.d.a> gAo;
    private TextView gAp;
    private long guZ = -1;
    private q gxX = null;
    private MMHandler mHandler;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12923);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.c_), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        setMMTitle(R.string.g9f);
        this.gAm = (DayPickerView) findViewById(R.id.gbw);
        this.gAp = (TextView) findViewById(R.id.heq);
        this.gAo = new HashMap<>();
        this.mHandler = new MMHandler(getMainLooper());
        this.gAn = getIntent().getStringExtra("detail_username");
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.chatroom.ui.SelectDateUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(12921);
                SelectDateUI.a(SelectDateUI.this);
                SelectDateUI.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.chatroom.ui.SelectDateUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(12920);
                        SelectDateUI.this.gAm.setBeginDate(SelectDateUI.this.guZ == -1 ? System.currentTimeMillis() * 1000 : SelectDateUI.this.guZ);
                        SelectDateUI.this.gAm.a(SelectDateUI.this, SelectDateUI.this.gAo.values());
                        if (SelectDateUI.this.gAo.size() == 0) {
                            SelectDateUI.this.gAp.setVisibility(0);
                            SelectDateUI.this.gAm.setVisibility(8);
                            SelectDateUI.this.gAp.setText(SelectDateUI.this.getString(R.string.b1r));
                            AppMethodBeat.o(12920);
                            return;
                        }
                        SelectDateUI.this.gAp.setVisibility(8);
                        SelectDateUI.this.gAm.setVisibility(0);
                        AppMethodBeat.o(12920);
                    }
                });
                AppMethodBeat.o(12921);
            }
        }, "prepare_data");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.SelectDateUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12922);
                SelectDateUI.this.finish();
                AppMethodBeat.o(12922);
                return true;
            }
        });
        AppMethodBeat.o(12923);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bpi;
    }

    @Override // com.tencent.mm.chatroom.a.a
    public final long alZ() {
        AppMethodBeat.i(12924);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(12924);
        return currentTimeMillis;
    }

    @Override // com.tencent.mm.chatroom.a.a
    public final void a(com.tencent.mm.chatroom.d.a aVar) {
        AppMethodBeat.i(12925);
        if (aVar == null) {
            Log.e("MicroMsg.SelectDateUI", "null == calendarDay");
            AppMethodBeat.o(12925);
            return;
        }
        Log.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", Long.valueOf(aVar.grW), Integer.valueOf(aVar.grV), Integer.valueOf(aVar.month), Integer.valueOf(aVar.year));
        long j2 = aVar.msgId;
        Log.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", Long.valueOf(j2));
        c.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.gAn).putExtra("finish_direct", true).putExtra("from_date_search", true).putExtra("msg_local_id", j2));
        AppMethodBeat.o(12925);
    }

    static /* synthetic */ void a(SelectDateUI selectDateUI) {
        AppMethodBeat.i(12926);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor aEv = ((l) g.af(l.class)).eiy().aEv(selectDateUI.gAn);
        try {
            if (aEv.moveToFirst()) {
                while (!aEv.isAfterLast()) {
                    if (-1 == selectDateUI.guZ) {
                        selectDateUI.guZ = aEv.getLong(0);
                    }
                    com.tencent.mm.chatroom.d.a aVar = new com.tencent.mm.chatroom.d.a(aEv.getLong(0));
                    aVar.msgId = aEv.getLong(1);
                    String aVar2 = aVar.toString();
                    if (!selectDateUI.gAo.containsKey(aVar2)) {
                        selectDateUI.gAo.put(aVar2, aVar);
                    }
                    aEv.moveToNext();
                }
            }
            aEv.close();
        } catch (Exception e2) {
            Log.e("MicroMsg.SelectDateUI", e2.toString());
            aEv.close();
        } catch (Throwable th) {
            aEv.close();
            AppMethodBeat.o(12926);
            throw th;
        }
        Log.i("MicroMsg.SelectDateUI", "[prepareData] time:%s", new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis).toString());
        AppMethodBeat.o(12926);
    }
}
