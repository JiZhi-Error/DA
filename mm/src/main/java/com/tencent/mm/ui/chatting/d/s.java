package com.tencent.mm.ui.chatting.d;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.view.DragEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.aq;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.d.b.u;

@a(gRF = p.class)
public class s extends a implements p {
    @Override // com.tencent.mm.ui.chatting.d.b.p
    @TargetApi(11)
    public final void gPM() {
        AppMethodBeat.i(35278);
        if (Build.VERSION.SDK_INT < 11) {
            Log.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
            AppMethodBeat.o(35278);
            return;
        }
        if (this.dom.getListView() != null) {
            this.dom.getListView().setOnDragListener(null);
        }
        ChatFooter gPO = ((u) this.dom.bh(u.class)).gPO();
        if (gPO != null) {
            gPO.setOnDragListener(null);
            gPO.setEditTextOnDragListener(null);
        }
        AppMethodBeat.o(35278);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.p
    @TargetApi(11)
    public final void fjK() {
        AppMethodBeat.i(35279);
        boolean gQZ = ((am) this.dom.bh(am.class)).gQZ();
        boolean gRa = ((am) this.dom.bh(am.class)).gRa();
        if (gQZ || gRa) {
            AppMethodBeat.o(35279);
        } else if (Build.VERSION.SDK_INT < 11) {
            Log.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
            AppMethodBeat.o(35279);
        } else {
            new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.s.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(35277);
                    AnonymousClass1 r1 = new View.OnDragListener() {
                        /* class com.tencent.mm.ui.chatting.d.s.AnonymousClass1.AnonymousClass1 */

                        public final boolean onDrag(View view, DragEvent dragEvent) {
                            AppMethodBeat.i(35276);
                            b bVar = new b();
                            bVar.bm(view);
                            bVar.bm(dragEvent);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, bVar.axR());
                            boolean z = false;
                            switch (dragEvent.getAction()) {
                                case 1:
                                    z = true;
                                    Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_STARTED");
                                    break;
                                case 2:
                                    z = true;
                                    Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_LOCATION");
                                    break;
                                case 3:
                                    Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DROP");
                                    ClipData clipData = dragEvent.getClipData();
                                    if (clipData != null) {
                                        int itemCount = clipData.getItemCount();
                                        for (int i2 = 0; i2 < itemCount; i2++) {
                                            ClipData.Item itemAt = clipData.getItemAt(i2);
                                            if (itemAt == null) {
                                                Log.e("MicroMsg.ChattingUI.DragDropComponent", "item == null");
                                            } else if (itemAt.getIntent() != null) {
                                                BaseChattingUIFragment baseChattingUIFragment = s.this.dom.Pwc;
                                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(itemAt.getIntent());
                                                com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                                                com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            } else if (itemAt.getUri() != null) {
                                                t tVar = new t(s.this.dom.Pwc.getContext(), itemAt.getUri());
                                                if (tVar.fileType == 0 || tVar.filePath == null) {
                                                    Log.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
                                                } else {
                                                    switch (tVar.fileType) {
                                                        case 3:
                                                            String str = tVar.filePath;
                                                            ((an) s.this.dom.bh(an.class)).T(z.f(str, s.this.dom.getTalkerUserName(), true) ? 1 : 0, 0, str);
                                                            continue;
                                                        case 4:
                                                            Intent intent = new Intent();
                                                            intent.setData(itemAt.getUri());
                                                            ((av) s.this.dom.bh(av.class)).aK(intent);
                                                            continue;
                                                        default:
                                                            ((com.tencent.mm.ui.chatting.d.b.b) s.this.dom.bh(com.tencent.mm.ui.chatting.d.b.b.class)).a(tVar);
                                                            continue;
                                                    }
                                                }
                                            } else if (itemAt.getText() != null && itemAt.getText().length() > 0) {
                                                ((aq) s.this.dom.bh(aq.class)).bmO(itemAt.getText().toString());
                                            }
                                        }
                                        z = true;
                                        break;
                                    } else {
                                        z = true;
                                        break;
                                    }
                                    break;
                                case 4:
                                    z = true;
                                    Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENDED");
                                    break;
                                case 5:
                                    z = true;
                                    Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENTERED");
                                    break;
                                default:
                                    Log.e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
                                    break;
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
                            AppMethodBeat.o(35276);
                            return z;
                        }
                    };
                    if (s.this.dom.getListView() != null) {
                        s.this.dom.getListView().setOnDragListener(r1);
                    }
                    ChatFooter gPO = ((u) s.this.dom.bh(u.class)).gPO();
                    if (gPO != null) {
                        gPO.setOnDragListener(r1);
                        gPO.setEditTextOnDragListener(r1);
                    }
                    AppMethodBeat.o(35277);
                }
            }.run();
            AppMethodBeat.o(35279);
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35280);
        fjK();
        AppMethodBeat.o(35280);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35281);
        gPM();
        AppMethodBeat.o(35281);
    }
}
