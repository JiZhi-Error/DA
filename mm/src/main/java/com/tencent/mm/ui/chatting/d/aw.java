package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;

@a(gRF = am.class)
public class aw extends a implements am {
    private v PtA;
    public boolean PtB = false;
    private boolean PtC = true;
    private int PtD = 0;
    private boolean PtE = false;
    private View Pto;
    public boolean Ptp = false;
    public boolean Ptq = false;
    public boolean Ptr = false;
    public boolean Pts = false;
    public boolean Ptt = false;
    private long Ptu = -1;
    private ArrayList<String> Ptv;
    public boolean Ptw = false;
    private TextView Ptx;
    private ListView Pty;
    private View Ptz;
    private s gzP = null;

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final ArrayList<String> gQU() {
        return this.Ptv;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final boolean Nz(long j2) {
        AppMethodBeat.i(35550);
        if (this.Ptu != j2 || !this.Pts || this.Ptv == null || this.Ptv.size() <= 0) {
            AppMethodBeat.o(35550);
            return false;
        }
        AppMethodBeat.o(35550);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final void gQV() {
        AppMethodBeat.i(35551);
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.Pto == null);
        Log.v("MicroMsg.ChattingUI.SearchComponent", "enter edit search mode, search stub view is null?%B", objArr);
        this.PtB = true;
        this.dom.amo(8);
        if (this.Pto != null) {
            this.Pto.setVisibility(0);
            if (this.PtA != null) {
                this.PtA.talker = this.dom.getTalkerUserName();
            }
        } else {
            l.a(this.dom.Pwc, (int) R.id.hdh);
            this.Pto = this.dom.findViewById(R.id.hdo);
            this.Pto.setVisibility(0);
            this.Ptz = this.dom.findViewById(R.id.hdf);
            this.dom.getListView().setFocusable(false);
            this.dom.getListView().setFocusableInTouchMode(false);
            this.Ptz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(35547);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35547);
                }
            });
            this.Ptz.setVisibility(8);
            this.Ptx = (TextView) this.dom.findViewById(R.id.c33);
            this.PtA = new v(this.dom.Pwc.getContext(), new ca(), this.dom.getTalkerUserName(), this.dom.gRI(), this.dom.gRL() || ((d) this.dom.bh(d.class)).gOQ());
            this.PtA.Pit = new v.a() {
                /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass9 */

                @Override // com.tencent.mm.ui.chatting.v.a
                public final void amk(int i2) {
                    AppMethodBeat.i(35548);
                    aw.this.amE(i2);
                    AppMethodBeat.o(35548);
                }
            };
            this.Pty = (ListView) this.dom.findViewById(R.id.hdg);
            this.Pty.setVisibility(0);
            this.Pty.setAdapter((ListAdapter) this.PtA);
            this.Pty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass10 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(35549);
                    b bVar = new b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    ca caVar = (ca) aw.this.PtA.getItem(i2);
                    if (caVar != null && !Util.isNullOrNil(caVar.field_talker)) {
                        aw.this.gQW();
                        ((l) aw.this.dom.bh(l.class)).bW(caVar);
                        if (!aw.this.Ptw) {
                            aw.this.Ptw = true;
                            aw.this.dom.Pwe.setBottomViewVisible(true);
                            aw.this.dom.Pwd.gOc();
                        }
                        aw.this.dom.Pwe.gOa();
                        aw.this.dom.Pwe.setIsBottomShowAll(false);
                        ((k) aw.this.dom.bh(k.class)).a(caVar.field_msgId, false, d.a.ACTION_POSITION);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(35549);
                }
            });
            this.Pty.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass2 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(35539);
                    aw.this.dom.hideVKB();
                    AppMethodBeat.o(35539);
                    return false;
                }
            });
        }
        amE(-1);
        AppMethodBeat.o(35551);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final void gQW() {
        AppMethodBeat.i(35552);
        Log.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
        this.PtB = false;
        this.PtC = true;
        if (this.Ptx != null) {
            this.Ptx.setVisibility(8);
        }
        if (this.Ptz != null) {
            this.Ptz.setVisibility(8);
        }
        if (this.Pty != null) {
            this.Pty.setVisibility(8);
        }
        this.dom.amo(0);
        this.dom.hideVKB();
        AppMethodBeat.o(35552);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final boolean gQX() {
        return this.PtB;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final void amE(int i2) {
        AppMethodBeat.i(35553);
        Log.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", Integer.valueOf(i2), Boolean.valueOf(this.PtB), Boolean.valueOf(this.PtC));
        if (this.Ptp || this.PtB) {
            if (this.PtC && i2 >= 0) {
                this.PtC = false;
                h.INSTANCE.a(10811, 2);
            }
            if (i2 > 0) {
                this.Pty.setVisibility(0);
                this.dom.amo(8);
                this.Ptx.setVisibility(8);
                this.Ptz.setVisibility(8);
                AppMethodBeat.o(35553);
            } else if (i2 == 0) {
                this.Pty.setVisibility(8);
                this.dom.amo(8);
                this.Ptx.setVisibility(0);
                this.Ptz.setVisibility(8);
                AppMethodBeat.o(35553);
            } else {
                this.Pty.setVisibility(8);
                this.dom.amo(0);
                this.Ptx.setVisibility(8);
                this.Ptz.setVisibility(0);
                AppMethodBeat.o(35553);
            }
        } else {
            Log.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
            AppMethodBeat.o(35553);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final v gQY() {
        return this.PtA;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final boolean gQZ() {
        return this.Ptq;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final boolean gRa() {
        return this.Ptp;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final boolean gRb() {
        return this.Pts;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final boolean gRc() {
        return this.Ptt;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.am
    public final boolean gRd() {
        return this.Ptw;
    }

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(35554);
        super.onActivityResult(i2, i3, intent);
        if (((k) this.dom.bh(k.class)).isInEditMode() && this.PtB) {
            gQW();
        }
        AppMethodBeat.o(35554);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35555);
        super.gOK();
        this.PtE = true;
        if (this.PtA != null) {
            this.PtA.ebf();
        }
        if (this.gzP != null) {
            this.gzP.clearFocus();
        }
        AppMethodBeat.o(35555);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35556);
        this.Ptp = this.dom.Pwc.getBooleanExtra("search_chat_content", false).booleanValue();
        this.Ptq = this.dom.Pwc.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
        this.Ptv = this.dom.Pwc.getStringArrayList("highlight_keyword_list");
        this.Ptu = this.dom.Pwc.getLongExtra("msg_local_id", -1);
        this.Pts = this.dom.Pwc.getBooleanExtra("from_global_search", false).booleanValue();
        this.Ptt = this.dom.Pwc.getBooleanExtra("from_date_search", false).booleanValue();
        this.Ptr = this.dom.Pwc.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
        AppMethodBeat.o(35556);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35557);
        if (this.Ptu >= 0 && !this.PtE) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(35538);
                    if (!aw.this.PtE) {
                        aw.this.PtE = true;
                        aw.this.Ptu = -1;
                        if (aw.this.dom != null) {
                            aw.this.dom.cmy();
                        }
                        Log.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
                    }
                    AppMethodBeat.o(35538);
                }
            }, 2000);
        }
        if (this.Ptp) {
            Log.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
            h.INSTANCE.idkeyStat(219, 11, 1, true);
            l.a(this.dom.Pwc, (int) R.id.hdh);
            this.Pto = this.dom.findViewById(R.id.hdo);
            this.Ptz = this.dom.findViewById(R.id.hdf);
            this.dom.getListView().setFocusable(false);
            this.dom.getListView().setFocusableInTouchMode(false);
            this.Ptz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(35540);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35540);
                }
            });
            if (this.Ptx == null) {
                l.a(this.dom.Pwc, (int) R.id.j7w);
                this.Ptx = (TextView) this.dom.findViewById(R.id.c33);
            }
            this.PtA = new v(this.dom.Pwc.getContext(), new ca(), this.dom.getTalkerUserName(), this.dom.gRI(), this.dom.gRL() || ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ());
            this.PtA.Pit = new v.a() {
                /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass4 */

                @Override // com.tencent.mm.ui.chatting.v.a
                public final void amk(int i2) {
                    AppMethodBeat.i(35541);
                    aw.this.amE(i2);
                    AppMethodBeat.o(35541);
                }
            };
            this.Pty = (ListView) this.dom.findViewById(R.id.hdg);
            this.Pty.setAdapter((ListAdapter) this.PtA);
            this.Pty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass5 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(35542);
                    b bVar = new b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    ca caVar = (ca) aw.this.PtA.getItem(i2);
                    if (caVar != null && !Util.isNullOrNil(caVar.field_talker)) {
                        h.INSTANCE.a(10450, 1);
                        Intent intent = new Intent(aw.this.dom.Pwc.getContext(), ChattingUI.class);
                        intent.putExtra("Chat_User", caVar.field_talker);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("show_search_chat_content_result", false);
                        intent.putExtra("msg_local_id", caVar.field_msgId);
                        intent.putExtra("img_gallery_enter_from_chatting_ui", true);
                        BaseChattingUIFragment baseChattingUIFragment = aw.this.dom.Pwc;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(35542);
                }
            });
            this.Pty.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass6 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(35543);
                    aw.this.dom.hideVKB();
                    AppMethodBeat.o(35543);
                    return false;
                }
            });
            this.gzP = new s();
            this.gzP.Qwi = new s.b() {
                /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass7 */
                private int PtG = 0;

                @Override // com.tencent.mm.ui.tools.s.b
                public final void SO(String str) {
                    AppMethodBeat.i(35545);
                    if (Util.isNullOrNil(str)) {
                        this.PtG = 0;
                        aw.this.amE(-1);
                        AppMethodBeat.o(35545);
                        return;
                    }
                    if (str.length() > this.PtG) {
                        h.INSTANCE.a(10451, 1);
                    }
                    this.PtG = str.length();
                    h.INSTANCE.a(10456, 1);
                    aw.this.PtA.SM(str);
                    AppMethodBeat.o(35545);
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bny() {
                    AppMethodBeat.i(35546);
                    new MMHandler().post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.d.aw.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(35544);
                            aw.this.dom.Pwc.gNh();
                            AppMethodBeat.o(35544);
                        }
                    });
                    AppMethodBeat.o(35546);
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bnz() {
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final boolean SN(String str) {
                    return false;
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bnA() {
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bnB() {
                }
            };
            this.dom.Pwc.addSearchMenu(true, this.gzP);
            this.gzP.CK(true);
        }
        if (this.Ptq || this.Pts || this.Ptt) {
            ((k) this.dom.bh(k.class)).a(this.dom.Pwc.getLongExtra("msg_local_id", -1), false, d.a.ACTION_POSITION);
        }
        AppMethodBeat.o(35557);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35558);
        if (this.PtB) {
            gQW();
            ((l) this.dom.bh(l.class)).gPC();
        }
        AppMethodBeat.o(35558);
    }
}
