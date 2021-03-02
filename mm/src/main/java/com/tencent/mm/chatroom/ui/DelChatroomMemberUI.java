package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.roomsdk.a.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI extends MMActivity implements i {
    private String chatroomName;
    private ca dTX;
    private ah gtd;
    private a gvb;
    private LinkedList<String> gvc = new LinkedList<>();
    private List<String> gvd = new ArrayList();
    private int gve;
    private int gvf;
    private boolean gvg = false;
    private com.tencent.mm.roomsdk.a.c.a gvh = null;
    private ProgressDialog gvi = null;
    private ListView mListView;
    private int scene;
    private q tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public DelChatroomMemberUI() {
        AppMethodBeat.i(12641);
        AppMethodBeat.o(12641);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12642);
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        this.scene = getIntent().getIntExtra("scene", 0);
        this.gve = getIntent().getIntExtra("local_scene", 0);
        this.gvf = getIntent().getIntExtra("select_record_report_opt", 0);
        this.gvg = getIntent().getBooleanExtra("revoke_record", false);
        if (this.gve == 1) {
            this.dTX = ((l) g.af(l.class)).eiy().Hb(getIntent().getLongExtra("msg_id", -1));
        }
        String stringExtra = getIntent().getStringExtra("members");
        this.gvd = Util.stringToList(getIntent().getStringExtra("origin_members"), ",");
        String[] split = stringExtra.split(",");
        for (String str : split) {
            this.gvc.add(str);
        }
        this.gtd = ((c) g.af(c.class)).aSX().Kd(this.chatroomName);
        initView();
        AppMethodBeat.o(12642);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12643);
        super.onDestroy();
        AppMethodBeat.o(12643);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(12644);
        super.onResume();
        AppMethodBeat.o(12644);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(12645);
        setMMTitle(R.string.g73);
        this.mListView = (ListView) findViewById(R.id.fcs);
        this.gvb = new a();
        a aVar = this.gvb;
        LinkedList<String> linkedList = this.gvc;
        if (linkedList != null) {
            Log.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", Integer.valueOf(linkedList.size()));
            aVar.gvp.clear();
            for (String str : linkedList) {
                as Kn = ((l) g.af(l.class)).aSN().Kn(str);
                if (Kn != null && !Util.isNullOrNil(Kn.field_username) && Kn.field_username.equals(str)) {
                    aVar.gvp.add(Kn);
                }
            }
        }
        this.mListView.setAdapter((ListAdapter) this.gvb);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12629);
                if (DelChatroomMemberUI.this.gve == 1) {
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.dTX, DelChatroomMemberUI.this.gvf, DelChatroomMemberUI.this.gvd, DelChatroomMemberUI.this.gvb.getCount(), 0, 1, "");
                }
                DelChatroomMemberUI.this.finish();
                AppMethodBeat.o(12629);
                return true;
            }
        });
        AppMethodBeat.o(12645);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.pl;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        List<as> gvp = new LinkedList();

        a() {
            AppMethodBeat.i(12636);
            AppMethodBeat.o(12636);
        }

        public final int getCount() {
            AppMethodBeat.i(12637);
            int size = this.gvp.size();
            AppMethodBeat.o(12637);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(12638);
            as asVar = this.gvp.get(i2);
            AppMethodBeat.o(12638);
            return asVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(12639);
            if (view == null) {
                view = View.inflate(DelChatroomMemberUI.this, R.layout.pk, null);
                bVar = new b();
                bVar.gvv = (ImageView) view.findViewById(R.id.are);
                bVar.gvw = (TextView) view.findViewById(R.id.arf);
                bVar.gvx = (TextView) view.findViewById(R.id.ard);
                bVar.gvx.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        String string;
                        String string2;
                        AppMethodBeat.i(12635);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        final as asVar = (as) a.this.getItem(((Integer) view.getTag()).intValue());
                        if (DelChatroomMemberUI.this.gvg) {
                            string = DelChatroomMemberUI.this.getString(R.string.g6r, new Object[]{a.this.b(asVar)});
                        } else {
                            string = DelChatroomMemberUI.this.getString(R.string.g6q, new Object[]{a.this.b(asVar)});
                        }
                        if (DelChatroomMemberUI.this.gvg) {
                            string2 = DelChatroomMemberUI.this.getString(R.string.g70);
                        } else {
                            string2 = DelChatroomMemberUI.this.getString(R.string.g6z);
                        }
                        h.a((Context) DelChatroomMemberUI.this, string, (String) null, string2, DelChatroomMemberUI.this.getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.a.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(12634);
                                if (DelChatroomMemberUI.this.gvg) {
                                    DelChatroomMemberUI.this.gvh = null;
                                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.a(DelChatroomMemberUI.this.chatroomName, DelChatroomMemberUI.this.dTX, 2, asVar.field_username, new e() {
                                        /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.a.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
                                        @Override // com.tencent.mm.roomsdk.a.b.a
                                        public final /* synthetic */ void a(int i2, int i3, String str, e eVar) {
                                            AppMethodBeat.i(194119);
                                            e eVar2 = eVar;
                                            Object[] objArr = new Object[4];
                                            objArr[0] = Integer.valueOf(i2);
                                            objArr[1] = Integer.valueOf(i3);
                                            objArr[2] = Util.nullAs(str, "");
                                            objArr[3] = eVar2 != null ? Integer.valueOf(eVar2.ret) : BuildConfig.COMMAND;
                                            Log.i("Micromsg.RoomOpLogResult", "dealDelChatroomMemberImp errType:%s errCode:%s errMsg:%s ret:%s", objArr);
                                            if (this.ret != 0) {
                                                DelChatroomMemberUI.h(DelChatroomMemberUI.this);
                                                h.a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.getString(R.string.gim), "", DelChatroomMemberUI.this.getString(R.string.x_), new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.a.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                        AppMethodBeat.i(194118);
                                                        Log.i("Micromsg.RoomOpLogResult", "dealDelChatroomMemberImp click i know");
                                                        AppMethodBeat.o(194118);
                                                    }
                                                });
                                                if (DelChatroomMemberUI.this.gve == 1) {
                                                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.dTX, DelChatroomMemberUI.this.gvf, DelChatroomMemberUI.this.gvd, a.this.getCount(), 1, 3, asVar.field_username);
                                                    AppMethodBeat.o(194119);
                                                    return;
                                                }
                                            } else {
                                                DelChatroomMemberUI.this.gvh = DelChatroomMemberUI.a(DelChatroomMemberUI.this, asVar.field_username, true);
                                            }
                                            AppMethodBeat.o(194119);
                                        }
                                    }));
                                    AppMethodBeat.o(12634);
                                    return;
                                }
                                DelChatroomMemberUI.a(DelChatroomMemberUI.this, asVar.field_username, false);
                                AppMethodBeat.o(12634);
                            }
                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.a.AnonymousClass1.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(194120);
                                if (DelChatroomMemberUI.this.gve == 1) {
                                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.dTX, DelChatroomMemberUI.this.gvf, DelChatroomMemberUI.this.gvd, a.this.getCount(), 1, 1, asVar.field_username);
                                }
                                AppMethodBeat.o(194120);
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(12635);
                    }
                });
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gvx.setTag(Integer.valueOf(i2));
            as asVar = (as) getItem(i2);
            String b2 = b(asVar);
            bVar.gvw.setText(b2);
            com.tencent.mm.pluginsdk.ui.span.l.b(DelChatroomMemberUI.this, b2, bVar.gvw.getTextSize());
            a.b.c(bVar.gvv, asVar.field_username);
            AppMethodBeat.o(12639);
            return view;
        }

        public final String b(as asVar) {
            String a2;
            AppMethodBeat.i(12640);
            if (!Util.isNullOrNil(asVar.field_conRemark)) {
                a2 = asVar.field_conRemark;
            } else {
                a2 = DelChatroomMemberUI.a(DelChatroomMemberUI.this, asVar.field_username);
            }
            if (Util.isNullOrNil(a2)) {
                a2 = asVar.field_conRemark;
            }
            if (Util.isNullOrNil(a2)) {
                a2 = asVar.arI();
            }
            AppMethodBeat.o(12640);
            return a2;
        }
    }

    public static d a(String str, ca caVar, int i2, String str2, e eVar) {
        AppMethodBeat.i(194121);
        if (caVar == null) {
            Log.e("MicroMsg.DelChatroomMemberUI", "revokeRecord msgInfo is null");
            AppMethodBeat.o(194121);
            return null;
        }
        cbq cbq = new cbq();
        cbq.Brn = caVar.field_msgSvrId;
        cbq.Mhx = Long.parseLong(caVar.field_historyId);
        cbq.jfM = str;
        cbq.LWr = i2;
        if (i2 == 2) {
            cbq.UserName = str2;
        }
        cbq.KIz = x.x(z.aTY(), caVar.field_createTime);
        d dVar = new d();
        dVar.a(new k.a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, cbq));
        dVar.d(eVar).aJu();
        AppMethodBeat.o(194121);
        return dVar;
    }

    class b {
        public ImageView gvv;
        public TextView gvw;
        public TextView gvx;

        b() {
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(12646);
        Log.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(12646);
    }

    static /* synthetic */ void a(DelChatroomMemberUI delChatroomMemberUI, ca caVar, int i2, List list, int i3, int i4, int i5, String str) {
        int i6;
        String str2;
        AppMethodBeat.i(194122);
        v vVar = (v) g.af(v.class);
        String str3 = delChatroomMemberUI.chatroomName;
        if (list != null) {
            i6 = list.size();
        } else {
            i6 = 0;
        }
        if (caVar != null) {
            str2 = caVar.field_historyId;
        } else {
            str2 = "";
        }
        vVar.a(str3, i6, i3, i2, i4, i5, Util.safeParseLong(str2), str);
        AppMethodBeat.o(194122);
    }

    static /* synthetic */ void h(DelChatroomMemberUI delChatroomMemberUI) {
        AppMethodBeat.i(194123);
        if (delChatroomMemberUI.gvi != null) {
            delChatroomMemberUI.gvi.dismiss();
        }
        AppMethodBeat.o(194123);
    }

    static /* synthetic */ com.tencent.mm.roomsdk.a.c.a a(DelChatroomMemberUI delChatroomMemberUI, final String str, final boolean z) {
        AppMethodBeat.i(194124);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(194124);
            return null;
        }
        final LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        final com.tencent.mm.roomsdk.a.c.a a2 = com.tencent.mm.roomsdk.a.b.bhF(delChatroomMemberUI.chatroomName).a(delChatroomMemberUI.chatroomName, linkedList, delChatroomMemberUI.scene);
        a2.b(new com.tencent.mm.roomsdk.a.b.b() {
            /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.AnonymousClass2 */

            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                String string;
                as asVar;
                AppMethodBeat.i(12631);
                if (DelChatroomMemberUI.this.gve == 1) {
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.dTX, DelChatroomMemberUI.this.gvf, DelChatroomMemberUI.this.gvd, DelChatroomMemberUI.this.gvb.getCount(), 1, 2, str);
                }
                DelChatroomMemberUI.h(DelChatroomMemberUI.this);
                if (z) {
                    string = DelChatroomMemberUI.this.getString(R.string.gil);
                } else {
                    string = DelChatroomMemberUI.this.getString(R.string.g71);
                }
                h.cD(DelChatroomMemberUI.this, string);
                a aVar2 = DelChatroomMemberUI.this.gvb;
                boolean z = false;
                for (String str2 : linkedList) {
                    Iterator<as> it = aVar2.gvp.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            asVar = null;
                            break;
                        }
                        asVar = it.next();
                        if (asVar.field_username.equals(str2)) {
                            break;
                        }
                    }
                    if (asVar != null) {
                        aVar2.gvp.remove(asVar);
                        z = true;
                    } else {
                        z = z;
                    }
                }
                if (z) {
                    aVar2.notifyDataSetChanged();
                }
                DelChatroomMemberUI.this.mListView.post(new Runnable() {
                    /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(12630);
                        if (DelChatroomMemberUI.this.gvb.getCount() == 0) {
                            DelChatroomMemberUI.this.finish();
                        }
                        AppMethodBeat.o(12630);
                    }
                });
                AppMethodBeat.o(12631);
            }
        });
        a2.c(new com.tencent.mm.roomsdk.a.b.b() {
            /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.AnonymousClass3 */

            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(12632);
                DelChatroomMemberUI.h(DelChatroomMemberUI.this);
                if (!(i2 == 0 && i3 == 0)) {
                    if (i3 == -2024) {
                        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                        if (Dk != null) {
                            Dk.a(DelChatroomMemberUI.this, null, null);
                            AppMethodBeat.o(12632);
                            return;
                        }
                        h.a((Context) DelChatroomMemberUI.this.getContext(), DelChatroomMemberUI.this.getString(R.string.g6x), (String) null, DelChatroomMemberUI.this.getString(R.string.g6y), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.AnonymousClass3.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    } else {
                        h.a((Context) DelChatroomMemberUI.this, DelChatroomMemberUI.this.getString(R.string.g77), (String) null, DelChatroomMemberUI.this.getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.AnonymousClass3.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    }
                    if (DelChatroomMemberUI.this.gve == 1) {
                        DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.dTX, DelChatroomMemberUI.this.gvf, DelChatroomMemberUI.this.gvd, DelChatroomMemberUI.this.gvb.getCount(), 1, 3, str);
                    }
                }
                AppMethodBeat.o(12632);
            }
        });
        if (z) {
            a2.aJu();
        } else {
            a2.a(delChatroomMemberUI, delChatroomMemberUI.getString(R.string.zb), delChatroomMemberUI.getString(R.string.g6m), true, true, new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(12633);
                    a2.cancel();
                    AppMethodBeat.o(12633);
                }
            });
        }
        AppMethodBeat.o(194124);
        return a2;
    }

    static /* synthetic */ void a(DelChatroomMemberUI delChatroomMemberUI, final d dVar) {
        AppMethodBeat.i(194125);
        if (delChatroomMemberUI.gvi == null) {
            delChatroomMemberUI.getString(R.string.zb);
            delChatroomMemberUI.gvi = h.a((Context) delChatroomMemberUI, delChatroomMemberUI.getString(R.string.g6m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.chatroom.ui.DelChatroomMemberUI.AnonymousClass5 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(194117);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (DelChatroomMemberUI.this.gvh != null) {
                        DelChatroomMemberUI.this.gvh.cancel();
                    }
                    AppMethodBeat.o(194117);
                }
            });
            AppMethodBeat.o(194125);
            return;
        }
        delChatroomMemberUI.gvi.show();
        AppMethodBeat.o(194125);
    }

    static /* synthetic */ String a(DelChatroomMemberUI delChatroomMemberUI, String str) {
        AppMethodBeat.i(194126);
        if (delChatroomMemberUI.gtd == null) {
            AppMethodBeat.o(194126);
            return null;
        }
        String displayName = delChatroomMemberUI.gtd.getDisplayName(str);
        AppMethodBeat.o(194126);
        return displayName;
    }
}
