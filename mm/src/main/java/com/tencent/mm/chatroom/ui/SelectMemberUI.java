package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SelectMemberUI extends MMActivity {
    protected b gAA;
    protected HashSet<String> gAB;
    private boolean gAC;
    private boolean gAD;
    private View gAx;
    private View gAy;
    private SelectMemberScrollBar gAz;
    protected ah gtd;
    protected int gwE;
    protected String gwx;
    private MMEditText gzR;
    private ListView mListView;
    protected String mTitle;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12970);
        super.onCreate(bundle);
        Log.i("MicroMsg.SelectMemberUI", "[onCreate]");
        anf();
        initView();
        AppMethodBeat.o(12970);
    }

    /* access modifiers changed from: protected */
    public void anf() {
        AppMethodBeat.i(12971);
        this.gwx = getIntent().getStringExtra("RoomInfo_Id");
        Log.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", this.gwx);
        this.gtd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(this.gwx);
        this.gwE = getIntent().getIntExtra("from_scene", 0);
        this.mTitle = getIntent().getStringExtra("title");
        this.gAC = getIntent().getBooleanExtra("is_show_owner", true);
        this.gAD = getIntent().getBooleanExtra("is_mulit_select_mode", false);
        this.gAB = new HashSet<>();
        AppMethodBeat.o(12971);
    }

    public final ah ano() {
        return this.gtd;
    }

    /* access modifiers changed from: protected */
    public BaseAdapter anl() {
        return this.gAA;
    }

    /* access modifiers changed from: protected */
    public boolean ank() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(12972);
        setMMTitle(Util.nullAsNil(this.mTitle));
        this.mListView = (ListView) findViewById(R.id.fcl);
        this.gAx = findViewById(R.id.hi8);
        this.gAy = findViewById(R.id.hi_);
        this.gAA = new b(this, this.gtd, this.gwx, this.gtd.field_roomowner);
        this.mListView.setAdapter((ListAdapter) anl());
        this.gAz = (SelectMemberScrollBar) findViewById(R.id.fco);
        this.gAz.setOnScrollBarTouchListener(new VerticalScrollBar.a() {
            /* class com.tencent.mm.chatroom.ui.SelectMemberUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.VerticalScrollBar.a
            public final void DP(String str) {
                int i2;
                AppMethodBeat.i(12948);
                if ("↑".equals(str)) {
                    SelectMemberUI.this.mListView.setSelection(0);
                    AppMethodBeat.o(12948);
                    return;
                }
                b bVar = SelectMemberUI.this.gAA;
                if (bVar.gAI.containsKey(str)) {
                    i2 = bVar.gAI.get(str).intValue();
                } else {
                    i2 = -1;
                }
                if (i2 != -1) {
                    SelectMemberUI.this.mListView.setSelection(i2);
                }
                AppMethodBeat.o(12948);
            }
        });
        if (ank()) {
            this.gAz.setVisibility(0);
        } else {
            this.gAz.setVisibility(8);
        }
        this.gzR = (MMEditText) findViewById(R.id.hi6);
        this.gzR.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.chatroom.ui.SelectMemberUI.AnonymousClass2 */
            private MTimerHandler gAF = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.chatroom.ui.SelectMemberUI.AnonymousClass2.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(12949);
                    Log.d("MicroMsg.SelectMemberUI", "searchEvent onTimerExpired");
                    b bVar = SelectMemberUI.this.gAA;
                    String obj = SelectMemberUI.this.gzR.getText().toString();
                    Log.i("MicroMsg.SelectMemberAdapter", "search:%s isLoading:%s", Util.secPrint(obj), Boolean.valueOf(bVar.isLoading));
                    if (!bVar.isLoading) {
                        bVar.gzZ = obj;
                        bVar.DN(obj);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.chatroom.ui.SelectMemberUI.b.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(12955);
                                b.this.notifyDataSetChanged();
                                if (b.this.dSU == null || b.this.dSU.size() != 0) {
                                    SelectMemberUI.this.mListView.setVisibility(0);
                                    SelectMemberUI.this.gAx.setVisibility(8);
                                    AppMethodBeat.o(12955);
                                    return;
                                }
                                SelectMemberUI.this.mListView.setVisibility(8);
                                SelectMemberUI.this.gAx.setVisibility(0);
                                AppMethodBeat.o(12955);
                            }
                        });
                    }
                    AppMethodBeat.o(12949);
                    return false;
                }
            }, false);

            {
                AppMethodBeat.i(12950);
                AppMethodBeat.o(12950);
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(12951);
                this.gAF.stopTimer();
                this.gAF.startTimer(500);
                AppMethodBeat.o(12951);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        b bVar = this.gAA;
        SelectMemberUI.this.gAy.setVisibility(0);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.chatroom.ui.SelectMemberUI.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(12954);
                b.this.isLoading = true;
                long currentTimeMillis = System.currentTimeMillis();
                b.this.Y(SelectMemberUI.this.anm());
                b.a(b.this);
                Log.i("MicroMsg.SelectMemberAdapter", "[load data] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.chatroom.ui.SelectMemberUI.b.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(12953);
                        b.this.isLoading = false;
                        SelectMemberUI.this.gAy.setVisibility(8);
                        b.this.notifyDataSetChanged();
                        AppMethodBeat.o(12953);
                    }
                });
                AppMethodBeat.o(12954);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.SelectMemberUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12952);
                SelectMemberUI.this.setResult(0, new Intent());
                SelectMemberUI.this.finish();
                AppMethodBeat.o(12952);
                return true;
            }
        });
        AppMethodBeat.o(12972);
    }

    /* access modifiers changed from: protected */
    public HashSet<String> anj() {
        AppMethodBeat.i(12973);
        HashSet<String> hashSet = new HashSet<>();
        AppMethodBeat.o(12973);
        return hashSet;
    }

    public boolean ang() {
        return this.gAD;
    }

    public boolean anc() {
        return false;
    }

    /* access modifiers changed from: protected */
    public HashSet<String> anh() {
        AppMethodBeat.i(12974);
        HashSet<String> hashSet = new HashSet<>();
        AppMethodBeat.o(12974);
        return hashSet;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i2, long j2) {
    }

    /* access modifiers changed from: protected */
    public void z(int i2, boolean z) {
    }

    /* access modifiers changed from: protected */
    public List<String> anm() {
        AppMethodBeat.i(12975);
        List<String> bax = this.gtd.bax();
        AppMethodBeat.o(12975);
        return bax;
    }

    public class b extends BaseAdapter {
        private List<a> dSU = new ArrayList();
        public final String gAH = new String(Character.toChars(91));
        HashMap<String, Integer> gAI = new HashMap<>();
        private String gAb = null;
        private List<a> gAc = new ArrayList(0);
        private ah gtd;
        private String gwx;
        public String gzZ;
        volatile boolean isLoading = false;
        private Context mContext;

        static /* synthetic */ String a(b bVar, as asVar) {
            AppMethodBeat.i(12969);
            String b2 = bVar.b(asVar);
            AppMethodBeat.o(12969);
            return b2;
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(12967);
            a on = on(i2);
            AppMethodBeat.o(12967);
            return on;
        }

        public b(Context context, ah ahVar, String str, String str2) {
            AppMethodBeat.i(12960);
            this.gtd = ahVar;
            this.gwx = str;
            this.gAb = str2;
            this.mContext = context;
            AppMethodBeat.o(12960);
        }

        public final void DN(String str) {
            cn aEZ;
            AppMethodBeat.i(12961);
            Log.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
            ArrayList arrayList = new ArrayList();
            if (!Util.isNullOrNil(str)) {
                for (a aVar : this.gAc) {
                    if (!(aVar == null || aVar.contact == null || aVar.type != 1)) {
                        as asVar = aVar.contact;
                        if (asVar.field_conRemark != null && asVar.field_conRemark.contains(str)) {
                            arrayList.add(aVar);
                        } else if (!Util.isNullOrNil(SeeRoomMemberUI.a(this.gtd, asVar.field_username)) && SeeRoomMemberUI.a(this.gtd, asVar.field_username).contains(str)) {
                            arrayList.add(aVar);
                        } else if (asVar.arI() != null && asVar.arI().contains(str)) {
                            arrayList.add(aVar);
                        } else if (asVar.ajz() != null && asVar.ajz().contains(str)) {
                            arrayList.add(aVar);
                        } else if (asVar.ajx() != null && asVar.ajx().contains(str)) {
                            arrayList.add(aVar);
                        } else if (asVar.field_username != null && asVar.field_username.contains(str)) {
                            arrayList.add(aVar);
                        } else if (!com.tencent.mm.contact.c.oR(asVar.field_type) && (aEZ = ((l) g.af(l.class)).aSO().aEZ(asVar.field_username)) != null && aEZ.field_conRemark != null && aEZ.field_conRemark.contains(str)) {
                            arrayList.add(aVar);
                        }
                    }
                }
                this.dSU = arrayList;
                AppMethodBeat.o(12961);
                return;
            }
            this.dSU = this.gAc;
            AppMethodBeat.o(12961);
        }

        public final int getCount() {
            AppMethodBeat.i(12962);
            if (this.dSU == null || this.isLoading) {
                AppMethodBeat.o(12962);
                return 0;
            }
            int size = this.dSU.size();
            AppMethodBeat.o(12962);
            return size;
        }

        public final a on(int i2) {
            AppMethodBeat.i(12963);
            if (this.dSU.size() > i2) {
                a aVar = this.dSU.get(i2);
                AppMethodBeat.o(12963);
                return aVar;
            }
            AppMethodBeat.o(12963);
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            int i3;
            AppMethodBeat.i(12964);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.bpr, null);
                final c cVar2 = new c();
                cVar2.gAN = (MaskLayout) view.findViewById(R.id.hib);
                cVar2.gwR = (EllipsizeTextView) view.findViewById(R.id.hid);
                cVar2.gwR = (TextView) view.findViewById(R.id.hid);
                cVar2.gAP = (ImageButton) view.findViewById(R.id.af5);
                cVar2.gAQ = (LinearLayout) view.findViewById(R.id.af6);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                cVar2.gwR.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                cVar2.gAO = (TextView) view.findViewById(R.id.hic);
                cVar2.gAO.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                view.setTag(cVar2);
                cVar2.gAP.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.SelectMemberUI.b.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(12956);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        cVar2.gAQ.performClick();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(12956);
                    }
                });
                cVar2.gAQ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.SelectMemberUI.b.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(12957);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        int intValue = ((Integer) view.getTag()).intValue();
                        a on = b.this.on(intValue);
                        if (on == null) {
                            Log.e("MicroMsg.SelectMemberAdapter", "item is null");
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(12957);
                        } else if (SelectMemberUI.this.anh().contains(on.contact.field_username)) {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(12957);
                        } else {
                            if (SelectMemberUI.this.gAB.contains(on.contact.field_username)) {
                                SelectMemberUI.this.gAB.remove(on.contact.field_username);
                                cVar2.gAP.setImageResource(R.drawable.p5);
                                SelectMemberUI.this.z(intValue, false);
                            } else {
                                SelectMemberUI.this.gAB.add(on.contact.field_username);
                                cVar2.gAP.setImageResource(R.raw.checkbox_selected);
                                SelectMemberUI.this.z(intValue, true);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(12957);
                        }
                    }
                });
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.SelectMemberUI.b.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(12958);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        SelectMemberUI.this.a(view, ((c) view.getTag()).position, (long) view.getId());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(12958);
                    }
                });
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            a on = on(i2);
            cVar.gAQ.setTag(Integer.valueOf(i2));
            if (on == null) {
                Log.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", Integer.valueOf(i2), Integer.valueOf(getCount()));
                AppMethodBeat.o(12964);
            } else {
                as asVar = on.contact;
                a.b.c((ImageView) cVar.gAN.getContentView(), asVar.field_username);
                if (asVar.field_verifyFlag == 0) {
                    cVar.gAN.setMaskDrawable(null);
                } else if (ay.a.iDs != null) {
                    String rW = ay.a.iDs.rW(asVar.field_verifyFlag);
                    if (rW != null) {
                        cVar.gAN.a(o.Nw(rW), MaskLayout.a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                    } else {
                        cVar.gAN.setMaskDrawable(null);
                    }
                } else {
                    cVar.gAN.setMaskDrawable(null);
                }
                String b2 = b(asVar);
                String str = "";
                if (com.tencent.mm.contact.c.oR(asVar.field_type)) {
                    str = asVar.fuR;
                }
                if (!Util.isNullOrNil(str)) {
                    cVar.gAO.setVisibility(0);
                    cVar.gAO.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, str, cVar.gAO.getTextSize()));
                } else {
                    cVar.gAO.setVisibility(8);
                    cVar.gAO.setText("");
                }
                if (as.bjp(asVar.field_username)) {
                    ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(this.mContext, cVar.gwR, b2, asVar.field_openImAppid, asVar.field_descWordingId, (int) cVar.gwR.getTextSize());
                } else {
                    cVar.gwR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, b2, cVar.gwR.getTextSize()));
                }
                if (SelectMemberUI.this.ang()) {
                    cVar.gAP.setVisibility(0);
                    cVar.gAQ.setVisibility(0);
                    if (SelectMemberUI.this.anh().contains(asVar.field_username)) {
                        cVar.gAQ.setEnabled(false);
                        cVar.gAP.setEnabled(false);
                        ImageButton imageButton = cVar.gAP;
                        if (ao.isDarkMode()) {
                            i3 = R.raw.checkbox_selected_grey_dark;
                        } else {
                            i3 = R.raw.checkbox_selected_grey;
                        }
                        imageButton.setImageResource(i3);
                    } else {
                        cVar.gAQ.setEnabled(true);
                        cVar.gAP.setEnabled(true);
                        if (SelectMemberUI.this.gAB.contains(on.contact.field_username)) {
                            cVar.gAP.setImageResource(R.raw.checkbox_selected);
                        } else {
                            cVar.gAP.setImageResource(R.drawable.p5);
                        }
                    }
                } else {
                    cVar.gAP.setVisibility(8);
                    cVar.gAQ.setVisibility(8);
                }
                cVar.gAM = on;
                cVar.position = i2;
                AppMethodBeat.o(12964);
            }
            return view;
        }

        public final void Y(List<String> list) {
            boolean equals;
            AppMethodBeat.i(12966);
            if (list == null) {
                AppMethodBeat.o(12966);
                return;
            }
            this.dSU.clear();
            for (int i2 = 0; i2 < list.size(); i2++) {
                as Kn = ((l) g.af(l.class)).aSN().Kn(list.get(i2));
                if ((SelectMemberUI.this.anc() || !z.Im(Kn.field_username)) && ((!(equals = Kn.field_username.equals(this.gAb)) || SelectMemberUI.this.gAC) && !SelectMemberUI.this.anj().contains(Kn.field_username))) {
                    if (!equals || !SelectMemberUI.this.gAC) {
                        this.dSU.add(new a(Kn));
                    } else {
                        this.dSU.add(0, new a(Kn));
                    }
                }
            }
            Collections.sort(this.dSU, new Comparator<a>() {
                /* class com.tencent.mm.chatroom.ui.SelectMemberUI.b.AnonymousClass6 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(a aVar, a aVar2) {
                    AppMethodBeat.i(12959);
                    int compareToIgnoreCase = f.Sh(b.a(b.this, aVar.contact)).compareToIgnoreCase(f.Sh(b.a(b.this, aVar2.contact)));
                    AppMethodBeat.o(12959);
                    return compareToIgnoreCase;
                }
            });
            this.gAc = this.dSU;
            AppMethodBeat.o(12966);
        }

        private String b(as asVar) {
            String a2;
            String str;
            cn aEZ;
            AppMethodBeat.i(12965);
            if (!Util.isNullOrNil(asVar.field_conRemark)) {
                a2 = asVar.field_conRemark;
            } else {
                a2 = SelectMemberUI.a(this.gtd, asVar.field_username);
            }
            if (Util.isNullOrNil(a2)) {
                str = asVar.arI();
            } else {
                str = a2;
            }
            if (!com.tencent.mm.contact.c.oR(asVar.field_type) && (aEZ = ((l) g.af(l.class)).aSO().aEZ(asVar.field_username)) != null && !Util.isNullOrNil(aEZ.field_conRemark)) {
                str = aEZ.field_conRemark;
            }
            AppMethodBeat.o(12965);
            return str;
        }

        static /* synthetic */ void a(b bVar) {
            String str;
            AppMethodBeat.i(12968);
            if (bVar.dSU != null) {
                String str2 = null;
                int i2 = 0;
                for (a aVar : bVar.dSU) {
                    if (aVar.contact != null) {
                        String Sh = f.Sh(bVar.b(aVar.contact));
                        if (Util.isNullOrNil(Sh)) {
                            str = "";
                        } else if (Sh.startsWith(bVar.gAH)) {
                            str = "#";
                        } else {
                            str = Sh.toUpperCase().substring(0, 1);
                        }
                        if (i2 == 0) {
                            bVar.gAI.put(str, Integer.valueOf(i2));
                        } else if (str2 != null && !str.equals(str2)) {
                            bVar.gAI.put(str, Integer.valueOf(i2));
                        }
                    } else {
                        str = null;
                    }
                    i2++;
                    str2 = str;
                }
            }
            AppMethodBeat.o(12968);
        }
    }

    public class a {
        public as contact;
        public int type = 1;

        public a(as asVar) {
            this.contact = asVar;
        }
    }

    protected static class c {
        public a gAM;
        public MaskLayout gAN;
        public TextView gAO;
        public ImageButton gAP;
        public LinearLayout gAQ;
        public TextView gwR;
        public int position;

        protected c() {
        }
    }

    protected static String a(ah ahVar, String str) {
        AppMethodBeat.i(12976);
        if (ahVar == null) {
            AppMethodBeat.o(12976);
            return null;
        }
        String displayName = ahVar.getDisplayName(str);
        AppMethodBeat.o(12976);
        return displayName;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bps;
    }
}
