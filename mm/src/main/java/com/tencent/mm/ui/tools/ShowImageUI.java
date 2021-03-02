package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.LinkedList;

public class ShowImageUI extends MMActivity {
    private boolean QwN;
    private a QwO;
    private MMGestureGallery jUy;
    private boolean lwF;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bsh;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39192);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (!Util.isNullOrNil(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.QwN = getIntent().getBooleanExtra("key_favorite", false);
        this.lwF = getIntent().getBooleanExtra("show_menu", true);
        this.jUy = (MMGestureGallery) findViewById(R.id.dci);
        this.jUy.setVerticalFadingEdgeEnabled(false);
        this.jUy.setHorizontalFadingEdgeEnabled(false);
        this.QwO = new a(this, (byte) 0);
        this.QwO.imagePath = getIntent().getStringExtra("key_image_path");
        this.jUy.setAdapter((SpinnerAdapter) this.QwO);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.tools.ShowImageUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39187);
                ShowImageUI.this.finish();
                AppMethodBeat.o(39187);
                return true;
            }
        });
        if (this.lwF) {
            addIconOptionMenu(0, R.raw.icons_outlined_share, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.tools.ShowImageUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(39189);
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    if (!ShowImageUI.this.QwN || !c.aZU("favorite")) {
                        linkedList2.add(0);
                        linkedList.add(ShowImageUI.this.getString(R.string.g5j));
                        linkedList2.add(2);
                        linkedList.add(ShowImageUI.this.getString(R.string.gau));
                    } else {
                        linkedList2.add(0);
                        linkedList.add(ShowImageUI.this.getString(R.string.g5j));
                        linkedList2.add(1);
                        linkedList.add(ShowImageUI.this.getString(R.string.fn9));
                        linkedList2.add(2);
                        linkedList.add(ShowImageUI.this.getString(R.string.gau));
                    }
                    ef efVar = new ef();
                    efVar.dHy.msgId = ShowImageUI.this.getIntent().getLongExtra("key_message_id", -1);
                    EventCenter.instance.publish(efVar);
                    if (efVar.dHz.dGX) {
                        linkedList2.add(3);
                        linkedList.add(ShowImageUI.this.getString(R.string.b0c));
                    }
                    h.b(ShowImageUI.this, "", linkedList, linkedList2, "", new h.e() {
                        /* class com.tencent.mm.ui.tools.ShowImageUI.AnonymousClass2.AnonymousClass1 */

                        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                        @Override // com.tencent.mm.ui.base.h.e
                        public final void cy(int i2, int i3) {
                            AppMethodBeat.i(39188);
                            switch (i3) {
                                case 0:
                                    ShowImageUI.b(ShowImageUI.this);
                                    AppMethodBeat.o(39188);
                                    return;
                                case 1:
                                    ShowImageUI showImageUI = ShowImageUI.this;
                                    cz czVar = new cz();
                                    long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
                                    if (-1 == longExtra) {
                                        Log.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                                        com.tencent.mm.pluginsdk.model.h.a(czVar, showImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), showImageUI.getIntent().getStringExtra("key_image_path"));
                                    } else {
                                        com.tencent.mm.pluginsdk.model.h.a(czVar, longExtra);
                                    }
                                    czVar.dFZ.activity = showImageUI;
                                    EventCenter.instance.publish(czVar);
                                    AppMethodBeat.o(39188);
                                    return;
                                case 2:
                                    ShowImageUI.c(ShowImageUI.this);
                                    AppMethodBeat.o(39188);
                                    return;
                                case 3:
                                    ShowImageUI.d(ShowImageUI.this);
                                    break;
                            }
                            AppMethodBeat.o(39188);
                        }
                    });
                    AppMethodBeat.o(39189);
                    return true;
                }
            });
        }
        AppMethodBeat.o(39192);
    }

    class a extends BaseAdapter {
        String imagePath;

        private a() {
        }

        /* synthetic */ a(ShowImageUI showImageUI, byte b2) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0079, code lost:
            if (r0 != false) goto L_0x007b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.View getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
            /*
            // Method dump skipped, instructions count: 218
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.ShowImageUI.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }

    static /* synthetic */ void b(ShowImageUI showImageUI) {
        AppMethodBeat.i(39193);
        String stringExtra = showImageUI.getIntent().getStringExtra("key_image_path");
        int intExtra = showImageUI.getIntent().getIntExtra("key_compress_type", 0);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", longExtra);
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(longExtra);
        k.b HD = k.b.HD(Hb.field_content);
        if (ImgUtil.isGif(stringExtra) || (Hb.dOQ() && HD != null && HD.type == 2)) {
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Msg_content", Hb.field_content);
            if (HD != null && HD.type == 2) {
                String JX = ad.JX("msg_" + Hb.field_msgSvrId);
                ad.aVe().G(JX, true).l("prePublishId", "msg_" + Hb.field_msgSvrId);
                intent.putExtra("reportSessionId", JX);
            }
        } else {
            intent.putExtra("Retr_Msg_Type", 0);
        }
        intent.putExtra("Retr_Compress_Type", intExtra);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(showImageUI, bl.axQ(), "com/tencent/mm/ui/tools/ShowImageUI", "doRestransmitMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        showImageUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(showImageUI, "com/tencent/mm/ui/tools/ShowImageUI", "doRestransmitMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(39193);
    }

    static /* synthetic */ void c(ShowImageUI showImageUI) {
        AppMethodBeat.i(39194);
        s.l(showImageUI.getIntent().getStringExtra("key_image_path"), showImageUI);
        AppMethodBeat.o(39194);
    }

    static /* synthetic */ void d(ShowImageUI showImageUI) {
        AppMethodBeat.i(39195);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", longExtra);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(showImageUI, bl.axQ(), "com/tencent/mm/ui/tools/ShowImageUI", "doSendMsgToDevice", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        showImageUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(showImageUI, "com/tencent/mm/ui/tools/ShowImageUI", "doSendMsgToDevice", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(39195);
    }
}
