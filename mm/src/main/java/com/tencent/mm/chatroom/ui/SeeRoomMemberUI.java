package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.chatroom.g.a;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ci;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.contact.ac;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.widget.MMEditText;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI extends MMActivity implements i, a.b {
    private static int gzT = 5;
    private boolean dRx;
    private int fs;
    private boolean gtO;
    private ah gtd;
    private String gwx;
    private String gxP;
    private int gxQ;
    private String gxR;
    private boolean gxS;
    private q gxX;
    private b gzM;
    private String gzN;
    private String gzO;
    private s gzP;
    private String gzQ;
    private MMEditText gzR;
    private int gzS;
    private AdapterView.OnItemClickListener gzU = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass5 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(194183);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (i2 > SeeRoomMemberUI.this.gzM.getCount() - 1) {
                Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick]count=%s position=%s", Integer.valueOf(SeeRoomMemberUI.this.gzM.getCount()), Integer.valueOf(i2));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(194183);
                return;
            }
            a om = SeeRoomMemberUI.this.gzM.om(i2);
            if (om.type == 2) {
                Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
                h.INSTANCE.idkeyStat(219, 6, 1, true);
                SeeRoomMemberUI.f(SeeRoomMemberUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(194183);
            } else if (om.type == 3) {
                Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
                SeeRoomMemberUI.g(SeeRoomMemberUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(194183);
            } else {
                if (om.type == 1) {
                    as asVar = SeeRoomMemberUI.this.gzM.om(i2).contact;
                    if (asVar == null) {
                        Log.e("MicroMsg.SeeRoomMemberUI", "cont is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(194183);
                        return;
                    }
                    SeeRoomMemberUI.this.username = asVar.field_username;
                    String str = asVar.field_nickname;
                    String a2 = SeeRoomMemberUI.a(SeeRoomMemberUI.this.gtd, SeeRoomMemberUI.this.username);
                    if (Util.isNullOrNil(a2)) {
                        SeeRoomMemberUI.this.gzQ = asVar.arJ();
                    } else {
                        SeeRoomMemberUI.this.gzQ = a2;
                    }
                    ac.u(SeeRoomMemberUI.this.gzR.getText().toString(), 1, 6, i2 + 1);
                    SeeRoomMemberUI.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.username, SeeRoomMemberUI.this.gzQ, str);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(194183);
            }
        }
    };
    private GridView gzv;
    private String mTitle;
    private String talker;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SeeRoomMemberUI() {
        AppMethodBeat.i(194188);
        AppMethodBeat.o(194188);
    }

    static /* synthetic */ Object a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        AppMethodBeat.i(12894);
        Object invokeMethod = invokeMethod(obj, str, objArr, clsArr);
        AppMethodBeat.o(12894);
        return invokeMethod;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12876);
        super.onCreate(bundle);
        h.INSTANCE.idkeyStat(219, 2, 1, true);
        g.aAg().hqi.a(di.CTRL_INDEX, this);
        this.gwx = getIntent().getStringExtra("RoomInfo_Id");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.gzO = getIntent().getStringExtra("Chatroom_member_list");
        this.dRx = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.gtO = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.gxS = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.gxR = getIntent().getStringExtra("room_owner_name");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.gtd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.talker == null ? this.gwx : this.talker);
        this.gxQ = getIntent().getIntExtra("room_member_count", 0);
        this.gxP = getIntent().getStringExtra("room_name");
        this.fs = getIntent().getIntExtra("offset", 0);
        this.gzS = getIntent().getIntExtra("first_pos", 0);
        initView();
        if (this.gzM != null) {
            ami();
            this.gzv.setSelection(this.gzS * gzT < this.gzM.getCount() ? this.gzS * gzT : this.gzM.getCount() - 1);
            this.gzv.postDelayed(new Runnable() {
                /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(12850);
                    if (Build.VERSION.SDK_INT >= 19) {
                        SeeRoomMemberUI.this.gzv.scrollListBy(SeeRoomMemberUI.this.fs);
                        AppMethodBeat.o(12850);
                        return;
                    }
                    SeeRoomMemberUI.a(SeeRoomMemberUI.this.gzv, "trackMotionScroll", new Object[]{Integer.valueOf(-SeeRoomMemberUI.this.fs), Integer.valueOf(-SeeRoomMemberUI.this.fs)}, new Class[]{Integer.TYPE, Integer.TYPE});
                    AppMethodBeat.o(12850);
                }
            }, 100);
        }
        AppMethodBeat.o(12876);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(12877);
        super.onResume();
        if (this.gzM != null) {
            this.gzM.DO(this.gzR.getText().toString());
        }
        AppMethodBeat.o(12877);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(12878);
        super.onConfigurationChanged(configuration);
        this.gzv.setNumColumns(cq(this));
        AppMethodBeat.o(12878);
    }

    private static int cq(Context context) {
        AppMethodBeat.i(12879);
        int width = (int) ((((float) ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth()) - (context.getResources().getDimension(R.dimen.i1) * 1.0f)) / ((float) ((int) ((context.getResources().getDimension(R.dimen.ib) * 2.0f) + context.getResources().getDimension(R.dimen.ij)))));
        Log.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", Integer.valueOf(width));
        gzT = width;
        AppMethodBeat.o(12879);
        return width;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(12880);
        setMMTitle(this.mTitle + "(" + this.gxQ + ")");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12859);
                SeeRoomMemberUI.this.setResult(0);
                SeeRoomMemberUI.this.finish();
                AppMethodBeat.o(12859);
                return true;
            }
        });
        this.gzR = (MMEditText) findViewById(R.id.fqx);
        this.gzv = (GridView) findViewById(R.id.arj);
        this.gzv.setNumColumns(cq(this));
        this.gzv.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.i1));
        ah ahVar = this.gtd;
        String str = this.gwx;
        List linkedList = new LinkedList();
        if (!Util.isNullOrNil(this.gzN)) {
            linkedList = Util.stringsToList(this.gzN.split(","));
        }
        ci aEY = ((l) g.af(l.class)).aSW().aEY("@t.qq.com");
        if (aEY != null) {
            linkedList.add(aEY.name);
        }
        this.gzM = new b(this, ahVar, str, linkedList, this.gxR);
        this.gzR.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass3 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(12860);
                SeeRoomMemberUI.this.gzM.DO(charSequence.toString());
                AppMethodBeat.o(12860);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.gzv.setOnItemClickListener(this.gzU);
        this.gzv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i2, long j2) {
                AppMethodBeat.i(194182);
                if (SeeRoomMemberUI.this.gxS) {
                    as asVar = SeeRoomMemberUI.this.gzM.om(i2).contact;
                    if (asVar == null) {
                        AppMethodBeat.o(194182);
                    } else {
                        if (SeeRoomMemberUI.this.gtd.field_roomowner.equals(asVar.field_username)) {
                            AppMethodBeat.o(194182);
                        } else {
                            com.tencent.mm.ui.base.h.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(R.string.g6o), "", new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass4.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(194181);
                                    SeeRoomMemberUI.a(SeeRoomMemberUI.this, i2);
                                    AppMethodBeat.o(194181);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass4.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            });
                            AppMethodBeat.o(194182);
                        }
                    }
                } else {
                    Log.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
                    AppMethodBeat.o(194182);
                }
                return true;
            }
        });
        this.gzv.setAdapter((ListAdapter) this.gzM);
        AppMethodBeat.o(12880);
    }

    @Override // com.tencent.mm.chatroom.g.a.b
    public final void ami() {
        AppMethodBeat.i(12881);
        this.gtd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.talker == null ? this.gwx : this.talker);
        final List<String> Ic = v.Ic(this.gwx);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(194184);
                if (SeeRoomMemberUI.this.gzM != null) {
                    SeeRoomMemberUI.this.gzM.Y(Ic);
                }
                AppMethodBeat.o(194184);
            }
        });
        AppMethodBeat.o(12881);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(12882);
        super.onPause();
        if (this.gzP != null) {
            this.gzP.gXP();
        }
        AppMethodBeat.o(12882);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12883);
        g.aAg().hqi.b(di.CTRL_INDEX, this);
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.o(12883);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bpd;
    }

    @Override // com.tencent.mm.chatroom.g.a.b
    public final void amj() {
        AppMethodBeat.i(194189);
        if (this.gtd != null) {
            setMMTitle(this.mTitle + "(" + this.gtd.bax().size() + ")");
        }
        AppMethodBeat.o(194189);
    }

    private void DM(String str) {
        AppMethodBeat.i(12884);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(12884);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        final com.tencent.mm.roomsdk.a.c.a a2 = com.tencent.mm.roomsdk.a.b.bhF(this.gwx).a(this.gwx, linkedList, 0);
        a2.b(new com.tencent.mm.roomsdk.a.b.b() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass7 */

            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(12865);
                SeeRoomMemberUI.this.ami();
                SeeRoomMemberUI.this.amj();
                AppMethodBeat.o(12865);
            }
        });
        a2.c(new com.tencent.mm.roomsdk.a.b.b() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass8 */

            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(194185);
                com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                if (Dk != null) {
                    Dk.a(SeeRoomMemberUI.this, null, null);
                    AppMethodBeat.o(194185);
                    return;
                }
                if (i3 == -66) {
                    com.tencent.mm.ui.base.h.c(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(R.string.bl8), SeeRoomMemberUI.this.getString(R.string.zb), true);
                    SeeRoomMemberUI.this.ami();
                    SeeRoomMemberUI.this.amj();
                }
                AppMethodBeat.o(194185);
            }
        });
        a2.a(this, getString(R.string.zb), getString(R.string.g6m), true, true, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.AnonymousClass9 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(194186);
                a2.cancel();
                AppMethodBeat.o(194186);
            }
        });
        AppMethodBeat.o(12884);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(12885);
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
        }
        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
        if (Dk != null) {
            Dk.a(this, null, null);
            AppMethodBeat.o(12885);
            return;
        }
        AppMethodBeat.o(12885);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z = false;
        AppMethodBeat.i(12886);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(12886);
                    return;
                }
                String stringExtra = intent.getStringExtra("Select_Contact");
                ChatroomInfoUI.LocalHistoryInfo localHistoryInfo = (ChatroomInfoUI.LocalHistoryInfo) intent.getParcelableExtra("select_record_msg_info");
                if (!ab.Ix(this.gwx) || ab.IB(this.gwx) || u.HQ(stringExtra)) {
                    if (Util.nullAsNil(z.aTY()).equals(stringExtra)) {
                        z = true;
                    } else {
                        List<String> Ic = v.Ic(this.gwx);
                        if (Ic != null) {
                            for (String str : Ic) {
                                z = str.equals(stringExtra) ? true : z;
                            }
                            z = z;
                        }
                    }
                    if (z) {
                        com.tencent.mm.ui.base.h.c(this, getString(R.string.di), getString(R.string.zb), true);
                        AppMethodBeat.o(12886);
                        return;
                    } else if (Util.stringsToList(stringExtra.split(",")) == null) {
                        AppMethodBeat.o(12886);
                        return;
                    } else {
                        new com.tencent.mm.chatroom.g.a(this, this.gwx, intent.getStringExtra("Select_Contact"), localHistoryInfo, intent.getLongExtra("select_record_fake_msg_id", 0), this);
                        AppMethodBeat.o(12886);
                        return;
                    }
                } else {
                    com.tencent.mm.ui.base.h.c(this, getString(R.string.g81), getString(R.string.zb), true);
                    AppMethodBeat.o(12886);
                    return;
                }
            case 2:
                if (intent != null) {
                    DM(intent.getStringExtra("Select_Contact"));
                    break;
                } else {
                    AppMethodBeat.o(12886);
                    return;
                }
        }
        AppMethodBeat.o(12886);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        as contact;
        int order;
        int type;

        public a(as asVar, int i2) {
            this.order = 0;
            this.type = 1;
            this.contact = asVar;
            this.order = i2;
        }

        public a(int i2) {
            this.order = 0;
            this.type = i2;
            this.contact = null;
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        private List<a> dSU = new ArrayList();
        private boolean gAa = false;
        private String gAb = null;
        private List<a> gAc;
        private l gAd;
        private ah gtd;
        private List<String> gzY;
        public String gzZ;
        private Context mContext;
        private String roomId;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(12875);
            a om = om(i2);
            AppMethodBeat.o(12875);
            return om;
        }

        public b(Context context, ah ahVar, String str, List<String> list, String str2) {
            AppMethodBeat.i(12868);
            this.gtd = ahVar;
            this.roomId = str;
            this.gzY = list;
            this.gAb = str2;
            this.mContext = context;
            this.gAd = (l) g.af(l.class);
            Y(v.Ic(str));
            AppMethodBeat.o(12868);
        }

        public final void Y(List<String> list) {
            AppMethodBeat.i(12869);
            if (list == null) {
                AppMethodBeat.o(12869);
                return;
            }
            this.dSU.clear();
            for (int i2 = 0; i2 < list.size(); i2++) {
                as Kn = this.gAd.aSN().Kn(list.get(i2));
                if (this.gtd.JO(Kn.field_username)) {
                    this.dSU.add(new a(Kn, 3));
                } else if (this.gtd.bjf(Kn.field_username)) {
                    this.dSU.add(new a(Kn, 2));
                } else {
                    this.dSU.add(new a(Kn, 1));
                }
            }
            Collections.sort(this.dSU, new Comparator<a>() {
                /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
                    return aVar2.order - aVar.order;
                }
            });
            this.dSU.add(new a(2));
            if (this.gtd.amD()) {
                this.dSU.add(new a(3));
            }
            this.gAc = this.dSU;
            notifyDataSetChanged();
            AppMethodBeat.o(12869);
        }

        private void DN(String str) {
            cn aEZ;
            AppMethodBeat.i(12870);
            ArrayList arrayList = new ArrayList();
            if (!Util.isNullOrNil(str)) {
                for (a aVar : this.gAc) {
                    if (!(aVar == null || aVar.contact == null || aVar.type != 1)) {
                        as asVar = aVar.contact;
                        if (asVar.field_conRemark != null && asVar.field_conRemark.toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (!Util.isNullOrNil(SeeRoomMemberUI.a(this.gtd, asVar.field_username)) && SeeRoomMemberUI.a(this.gtd, asVar.field_username).contains(str)) {
                            arrayList.add(aVar);
                        } else if (asVar.arI() != null && asVar.arI().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (asVar.ajz() != null && asVar.ajz().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (asVar.ajx() != null && asVar.ajx().contains(str)) {
                            arrayList.add(aVar);
                        } else if (asVar.field_username != null && asVar.field_username.contains(str)) {
                            arrayList.add(aVar);
                        } else if (!com.tencent.mm.contact.c.oR(asVar.field_type) && (aEZ = ((l) g.af(l.class)).aSO().aEZ(asVar.field_username)) != null && aEZ.field_conRemark != null && aEZ.field_conRemark.toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        }
                    }
                }
                Log.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
                this.dSU = arrayList;
            } else {
                this.dSU = this.gAc;
            }
            notifyDataSetChanged();
            AppMethodBeat.o(12870);
        }

        public final a om(int i2) {
            AppMethodBeat.i(12871);
            a aVar = this.dSU.get(i2);
            AppMethodBeat.o(12871);
            return aVar;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            String str;
            AppMethodBeat.i(12872);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.bpc, null);
                cVar = new c((byte) 0);
                cVar.gAf = (AvatarPatTipImageView) view.findViewById(R.id.hgi);
                cVar.gwR = (TextView) view.findViewById(R.id.hgk);
                cVar.gwR.setMaxWidth((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * 2) / 3);
                cVar.gAg = (TextView) view.findViewById(R.id.hgl);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.gAf.setTag(Integer.valueOf(i2));
            if (cVar.gAg != null) {
                cVar.gAg.setVisibility(8);
            }
            a aVar = this.dSU.get(i2);
            if (aVar != null && aVar.type == 1) {
                as asVar = aVar.contact;
                a.b.c(cVar.gAf, asVar.field_username);
                String a2 = SeeRoomMemberUI.a(this.gtd, asVar.field_username);
                if (!Util.isNullOrNil(asVar.field_conRemark)) {
                    str = asVar.field_conRemark;
                } else {
                    str = a2;
                }
                if (Util.isNullOrNil(str)) {
                    str = asVar.arI();
                }
                if (a2 != null && !a2.equals("") && !str.equals(a2)) {
                    str = a2 + "( " + str + " )";
                }
                cVar.gwR.setVisibility(0);
                cVar.gwR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, str, cVar.gwR.getTextSize()));
                cVar.gAf.setTagUsername(asVar.field_username);
                cVar.gAf.setTagTalker(this.roomId);
                cVar.gAf.setTagScene(4);
                cVar.gAf.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.SeeRoomMemberUI.b.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(194187);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.SeeRoomMemberUI", "onItemClick %s%s", view, view.getTag());
                        if (view.getTag() != null) {
                            int intValue = ((Integer) view.getTag()).intValue();
                            SeeRoomMemberUI.this.gzU.onItemClick(SeeRoomMemberUI.this.gzv, view, intValue, b.this.getItemId(intValue));
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(194187);
                    }
                });
                if (cVar.gAg != null) {
                    String O = com.tencent.mm.openim.room.a.a.O(asVar);
                    if (TextUtils.isEmpty(O)) {
                        cVar.gAg.setVisibility(8);
                    } else {
                        cVar.gAg.setVisibility(0);
                        cVar.gAg.setText(O);
                    }
                }
            } else if (aVar != null && aVar.type == 2) {
                cVar.gwR.setVisibility(4);
                cVar.gAf.setImageResource(R.drawable.gg);
                cVar.gAf.setTagUsername("");
            } else if (aVar != null && aVar.type == 3) {
                cVar.gwR.setVisibility(4);
                cVar.gAf.setImageResource(R.drawable.gh);
                cVar.gAf.setTagUsername("");
            }
            AppMethodBeat.o(12872);
            return view;
        }

        public final void DO(String str) {
            AppMethodBeat.i(12873);
            this.gAa = true;
            this.gzZ = str;
            DN(str);
            AppMethodBeat.o(12873);
        }

        public final int getCount() {
            AppMethodBeat.i(12874);
            int size = this.dSU.size();
            AppMethodBeat.o(12874);
            return size;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }
    }

    protected static String a(ah ahVar, String str) {
        AppMethodBeat.i(12892);
        if (ahVar == null) {
            AppMethodBeat.o(12892);
            return "";
        }
        String displayName = ahVar.getDisplayName(str);
        AppMethodBeat.o(12892);
        return displayName;
    }

    static class c {
        public AvatarPatTipImageView gAf;
        public TextView gAg;
        public TextView gwR;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    private static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        Method method;
        Object obj2;
        AppMethodBeat.i(12893);
        if (obj == null) {
            AppMethodBeat.o(12893);
            return null;
        }
        Class<?> cls = obj.getClass();
        while (true) {
            if (cls == Object.class) {
                method = null;
                break;
            }
            try {
                method = cls.getDeclaredMethod(str, clsArr);
                break;
            } catch (NoSuchMethodException e2) {
                Log.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e2, "", new Object[0]);
            } catch (SecurityException e3) {
                Log.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e3, "", new Object[0]);
            }
            cls = cls.getSuperclass();
        }
        if (method != null) {
            method.setAccessible(true);
            try {
                obj2 = method.invoke(obj, objArr);
            } catch (IllegalAccessException e4) {
                Log.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e4, "", new Object[0]);
                obj2 = null;
            } catch (IllegalArgumentException e5) {
                Log.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e5, "", new Object[0]);
                obj2 = null;
            } catch (InvocationTargetException e6) {
                Log.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e6, "", new Object[0]);
            }
            AppMethodBeat.o(12893);
            return obj2;
        }
        obj2 = null;
        AppMethodBeat.o(12893);
        return obj2;
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, int i2) {
        AppMethodBeat.i(194190);
        if (seeRoomMemberUI.gzM.om(i2).type == 1) {
            String str = seeRoomMemberUI.gzM.om(i2).contact.field_username;
            Log.d("MicroMsg.SeeRoomMemberUI", "roomPref del " + i2 + " userName : " + str);
            if (Util.nullAs((String) g.aAh().azQ().get(2, (Object) null), "").equals(str)) {
                com.tencent.mm.ui.base.h.n(seeRoomMemberUI.getContext(), R.string.g76, R.string.zb);
                AppMethodBeat.o(194190);
                return;
            }
            seeRoomMemberUI.DM(str);
        }
        AppMethodBeat.o(194190);
    }

    static /* synthetic */ void f(SeeRoomMemberUI seeRoomMemberUI) {
        AppMethodBeat.i(194191);
        String listToString = Util.listToString(v.Ic(seeRoomMemberUI.gwx), ",");
        Intent intent = new Intent();
        intent.putExtra("titile", seeRoomMemberUI.getString(R.string.g4));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.u.PWT);
        intent.putExtra("always_select_contact", listToString);
        intent.putExtra("scene", 4);
        intent.putExtra("KBlockOpenImFav", ab.Ix(seeRoomMemberUI.gwx));
        intent.putExtra("is_select_record_msg_mode", ab.Ix(seeRoomMemberUI.gwx));
        intent.putExtra("menu_mode", 2);
        intent.putExtra("chatroomName", seeRoomMemberUI.gwx);
        com.tencent.mm.br.c.c(seeRoomMemberUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(194191);
    }

    static /* synthetic */ void g(SeeRoomMemberUI seeRoomMemberUI) {
        AppMethodBeat.i(194192);
        h.INSTANCE.idkeyStat(219, 8, 1, true);
        List<String> Ic = v.Ic(seeRoomMemberUI.gwx);
        String listToString = Util.listToString(Ic, ",");
        int size = Ic.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", seeRoomMemberUI.gwx);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", listToString);
        intent.putExtra("room_member_count", size);
        intent.putExtra("Is_RoomOwner", seeRoomMemberUI.gxS);
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.u.PWT);
        intent.putExtra("room_name", seeRoomMemberUI.gwx);
        intent.putExtra("room_owner_name", seeRoomMemberUI.gtd.field_roomowner);
        intent.setClass(seeRoomMemberUI, SelectDelMemberUI.class);
        seeRoomMemberUI.startActivityForResult(intent, 2);
        AppMethodBeat.o(194192);
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, String str, String str2, String str3) {
        cn aEZ;
        AppMethodBeat.i(194193);
        if (Util.isNullOrNil(str2) && (aEZ = ((l) g.af(l.class)).aSO().aEZ(str)) != null && !Util.isNullOrNil(aEZ.field_encryptUsername)) {
            str2 = aEZ.field_conRemark;
        }
        if (!Util.isNullOrNil(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (seeRoomMemberUI.dRx && seeRoomMemberUI.gtd != null) {
                intent.putExtra("Contact_RoomNickname", seeRoomMemberUI.gtd.getDisplayName(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeRoomMemberUI.gxP);
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
                uj ujVar = new uj();
                ujVar.eaI.intent = intent;
                ujVar.eaI.username = str;
                EventCenter.instance.publish(ujVar);
            }
            if (seeRoomMemberUI.dRx) {
                if (Kn != null && Kn.gBM()) {
                    h.INSTANCE.kvStat(10298, Kn.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 14);
            } else if (seeRoomMemberUI.gtO) {
                intent.putExtra("Contact_Scene", 44);
                if (!z.Im(Kn.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            intent.putExtra("Is_RoomOwner", seeRoomMemberUI.gxS);
            intent.putExtra("Contact_ChatRoomId", seeRoomMemberUI.gwx);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 10);
            com.tencent.mm.br.c.b(seeRoomMemberUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(194193);
    }
}
