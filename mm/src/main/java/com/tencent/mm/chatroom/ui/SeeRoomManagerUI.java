package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.chatroom.d.d;
import com.tencent.mm.chatroom.d.e;
import com.tencent.mm.chatroom.d.f;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomManagerUI extends MMActivity implements MStorage.IOnStorageChange {
    private ah gtd;
    private String gxP;
    private b gzI;
    private GridView gzv;
    private q tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12839);
        super.onCreate(bundle);
        ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().add(this);
        this.gxP = getIntent().getStringExtra("RoomInfo_Id");
        initView();
        AppMethodBeat.o(12839);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12840);
        super.onDestroy();
        ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().remove(this);
        AppMethodBeat.o(12840);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(12841);
        super.initView();
        setMMTitle(R.string.g7u);
        this.gzv = (GridView) findViewById(R.id.f_q);
        this.gzI = new b(this);
        this.gzv.setAdapter((ListAdapter) this.gzI);
        this.gzv.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomManagerUI.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.gzv.post(new Runnable() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomManagerUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(12825);
                int dimension = (int) (SeeRoomManagerUI.this.getResources().getDimension(R.dimen.k) + SeeRoomManagerUI.this.getResources().getDimension(R.dimen.ij) + SeeRoomManagerUI.this.getResources().getDimension(R.dimen.ka));
                if (SeeRoomManagerUI.this.gzI.getCount() / 4 > 0) {
                    dimension *= (SeeRoomManagerUI.this.gzI.getCount() / 4) + 1;
                }
                SeeRoomManagerUI.this.gzv.setLayoutParams(new LinearLayout.LayoutParams(SeeRoomManagerUI.this.gzv.getWidth(), dimension));
                AppMethodBeat.o(12825);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomManagerUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12826);
                SeeRoomManagerUI.this.finish();
                AppMethodBeat.o(12826);
                return true;
            }
        });
        AppMethodBeat.o(12841);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bpb;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(12842);
        if (mStorageEventData != null) {
            Log.i("MicroMsg.SeeRoomManagerUI", "[onNotifyChange] event:%s [%s:%s]", str, mStorageEventData.event, Integer.valueOf(mStorageEventData.eventId));
        }
        AppMethodBeat.o(12842);
    }

    public class a {
        public as contact;
        public int type;

        public a(int i2, as asVar) {
            this.type = i2;
            this.contact = asVar;
        }
    }

    public class b extends BaseAdapter {
        List<a> dataList = new ArrayList();
        private com.tencent.mm.av.a.a.c gzE;
        Context mContext;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(12837);
            a ol = ol(i2);
            AppMethodBeat.o(12837);
            return ol;
        }

        public b(Context context) {
            AppMethodBeat.i(12831);
            this.mContext = context;
            and();
            notifyDataSetChanged();
            c.a aVar = new c.a();
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.jbq = R.raw.default_avatar;
            this.gzE = aVar.bdv();
            AppMethodBeat.o(12831);
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.i(12832);
            super.notifyDataSetChanged();
            SeeRoomManagerUI.this.gzv.post(new Runnable() {
                /* class com.tencent.mm.chatroom.ui.SeeRoomManagerUI.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(12829);
                    int dimension = (int) (SeeRoomManagerUI.this.getResources().getDimension(R.dimen.k) + SeeRoomManagerUI.this.getResources().getDimension(R.dimen.ij) + SeeRoomManagerUI.this.getResources().getDimension(R.dimen.ka));
                    if (SeeRoomManagerUI.this.gzI.getCount() / 4 > 0) {
                        dimension *= (SeeRoomManagerUI.this.gzI.getCount() / 4) + 1;
                    }
                    SeeRoomManagerUI.this.gzv.setLayoutParams(new LinearLayout.LayoutParams(SeeRoomManagerUI.this.gzv.getWidth(), dimension));
                    AppMethodBeat.o(12829);
                }
            });
            AppMethodBeat.o(12832);
        }

        private void and() {
            AppMethodBeat.i(12833);
            this.dataList.clear();
            SeeRoomManagerUI.this.gtd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(Util.nullAsNil(SeeRoomManagerUI.this.gxP));
            if (SeeRoomManagerUI.this.gtd == null) {
                AppMethodBeat.o(12833);
                return;
            }
            for (String str : SeeRoomManagerUI.this.gtd.bax()) {
                if (SeeRoomManagerUI.this.gtd.bjf(str)) {
                    Log.i("MicroMsg.SeeRoomManagerUI", "[resetData] Room Manager:%s", str);
                    this.dataList.add(new a(1, ((l) g.af(l.class)).aSN().Kn(str)));
                }
            }
            if (z.aTY().equals(SeeRoomManagerUI.this.gtd.field_roomowner)) {
                this.dataList.add(new a(2, null));
                if (this.dataList.size() > 1) {
                    this.dataList.add(new a(3, null));
                }
            }
            AppMethodBeat.o(12833);
        }

        public final int getCount() {
            AppMethodBeat.i(12834);
            int size = this.dataList.size();
            AppMethodBeat.o(12834);
            return size;
        }

        private a ol(int i2) {
            AppMethodBeat.i(12835);
            a aVar = this.dataList.get(i2);
            AppMethodBeat.o(12835);
            return aVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(final int i2, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(12836);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.bnf, null);
                cVar = SeeRoomManagerUI.this.cj(view);
            } else {
                cVar = (c) view.getTag();
                if (cVar == null) {
                    cVar = SeeRoomManagerUI.this.cj(view);
                }
            }
            a ol = ol(i2);
            if (ol == null) {
                Log.e("MicroMsg.SeeRoomManagerUI", "null == item! position:%s, count:%s", Integer.valueOf(i2), Integer.valueOf(getCount()));
                AppMethodBeat.o(12836);
            } else {
                if (ol.type == 1) {
                    cVar.gzG.setVisibility(0);
                    as asVar = ol.contact;
                    cVar.gzG.setText(SeeRoomManagerUI.a(SeeRoomManagerUI.this, asVar.field_username, cVar.gzG));
                    a.b.c(cVar.gvv, asVar.field_username);
                } else if (ol.type == 2) {
                    cVar.gzG.setVisibility(4);
                    cVar.gvv.setImageResource(R.drawable.gg);
                } else if (ol.type == 3) {
                    cVar.gzG.setVisibility(4);
                    cVar.gvv.setImageResource(R.drawable.gh);
                }
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.SeeRoomManagerUI.b.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(12830);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomManagerUI$ManagerAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        a aVar = b.this.dataList.get(i2);
                        if (aVar.type == 1) {
                            as asVar = b.this.dataList.get(i2).contact;
                            SeeRoomManagerUI.a(SeeRoomManagerUI.this, asVar.field_username, b.a(b.this, asVar), asVar.field_nickname);
                        } else if (aVar.type == 2) {
                            Intent intent = new Intent(SeeRoomManagerUI.this, SelectAddRoomManagerUI.class);
                            intent.putExtra("RoomInfo_Id", SeeRoomManagerUI.this.gxP);
                            SeeRoomManagerUI.this.startActivityForResult(intent, 0);
                        } else if (aVar.type == 3) {
                            Intent intent2 = new Intent(SeeRoomManagerUI.this, SelectDelRoomManagerUI.class);
                            intent2.putExtra("RoomInfo_Id", SeeRoomManagerUI.this.gxP);
                            intent2.putExtra("RoomManagers", SeeRoomManagerUI.e(SeeRoomManagerUI.this));
                            SeeRoomManagerUI.this.startActivityForResult(intent2, 1);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomManagerUI$ManagerAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(12830);
                    }
                });
                AppMethodBeat.o(12836);
            }
            return view;
        }

        static /* synthetic */ String a(b bVar, as asVar) {
            String displayName;
            String str;
            cn aEZ;
            AppMethodBeat.i(12838);
            if (!Util.isNullOrNil(asVar.field_conRemark)) {
                displayName = asVar.field_conRemark;
            } else {
                displayName = SeeRoomManagerUI.this.gtd.getDisplayName(asVar.field_username);
            }
            if (Util.isNullOrNil(displayName)) {
                str = asVar.arI();
            } else {
                str = displayName;
            }
            if (!com.tencent.mm.contact.c.oR(asVar.field_type) && (aEZ = ((l) g.af(l.class)).aSO().aEZ(asVar.field_username)) != null && !Util.isNullOrNil(aEZ.field_conRemark)) {
                str = aEZ.field_conRemark;
            }
            AppMethodBeat.o(12838);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public final c cj(View view) {
        AppMethodBeat.i(12843);
        c cVar = new c();
        cVar.gvv = (ImageView) view.findViewById(R.id.h8t);
        cVar.gzG = (TextView) view.findViewById(R.id.h8q);
        AppMethodBeat.o(12843);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public class c {
        public ImageView gvv;
        public TextView gzG;

        c() {
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(12844);
        super.onActivityResult(i2, i3, intent);
        if (intent == null || i3 != -1) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent == null);
            objArr[1] = Integer.valueOf(i3);
            Log.w("MicroMsg.SeeRoomManagerUI", "[onActivityResult] data is null? %s resultCode:%s", objArr);
            AppMethodBeat.o(12844);
            return;
        }
        String stringExtra = intent.getStringExtra("Select_Contact");
        Log.i("MicroMsg.SeeRoomManagerUI", "[onActivityResult] roomName:%s requestCode:%s userListString:%s", this.gxP, Integer.valueOf(i2), stringExtra);
        if (Util.isNullOrNil(stringExtra)) {
            Log.e("MicroMsg.SeeRoomManagerUI", "[onActivityResult] userListString is null!");
            AppMethodBeat.o(12844);
            return;
        }
        String[] split = stringExtra.split(",");
        final LinkedList linkedList = new LinkedList();
        for (String str : split) {
            linkedList.add(str);
        }
        switch (i2) {
            case 0:
                AppCompatActivity context = getContext();
                getString(R.string.zb);
                this.tipDialog = h.a((Context) context, getString(R.string.g5x), false, (DialogInterface.OnCancelListener) null);
                if (ab.Ix(this.gxP)) {
                    new com.tencent.mm.chatroom.d.b(this.gxP, linkedList).aYI().a(this).b(new com.tencent.mm.vending.c.a<Void, c.a<cr>>() {
                        /* class com.tencent.mm.chatroom.ui.SeeRoomManagerUI.AnonymousClass4 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(c.a<cr> aVar) {
                            AppMethodBeat.i(12827);
                            c.a<cr> aVar2 = aVar;
                            if (SeeRoomManagerUI.this.tipDialog != null && SeeRoomManagerUI.this.tipDialog.isShowing()) {
                                SeeRoomManagerUI.this.tipDialog.dismiss();
                            }
                            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(aVar2.errMsg);
                            if (Dk != null) {
                                Dk.a(SeeRoomManagerUI.this, null, null);
                                Void r0 = QZL;
                                AppMethodBeat.o(12827);
                                return r0;
                            }
                            if (aVar2.errType == 0 && aVar2.errCode == 0) {
                                SeeRoomManagerUI.a(SeeRoomManagerUI.this, linkedList);
                                SeeRoomManagerUI.this.gzI.notifyDataSetChanged();
                            } else if (aVar2.dGJ.getType() == 889) {
                                Log.i("MicroMsg.SeeRoomManagerUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", 774, Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType), Util.nullAsNil(aVar2.errMsg));
                                h.c(SeeRoomManagerUI.this.getContext(), Util.nullAs(aVar2.errMsg, SeeRoomManagerUI.this.getString(R.string.db)), SeeRoomManagerUI.this.getString(R.string.zb), true);
                            }
                            AppMethodBeat.o(12827);
                            return null;
                        }
                    });
                    AppMethodBeat.o(12844);
                    return;
                }
                new e(this.gxP, linkedList).aYI().a(this).b(new com.tencent.mm.vending.c.a<Void, c.a<dh>>() {
                    /* class com.tencent.mm.chatroom.ui.SeeRoomManagerUI.AnonymousClass5 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Void call(c.a<dh> aVar) {
                        AppMethodBeat.i(12828);
                        c.a<dh> aVar2 = aVar;
                        if (SeeRoomManagerUI.this.tipDialog != null && SeeRoomManagerUI.this.tipDialog.isShowing()) {
                            SeeRoomManagerUI.this.tipDialog.dismiss();
                        }
                        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(aVar2.errMsg);
                        if (Dk != null) {
                            Dk.a(SeeRoomManagerUI.this, null, null);
                            Void r0 = QZL;
                            AppMethodBeat.o(12828);
                            return r0;
                        }
                        if (aVar2.errType == 0 && aVar2.errCode == 0) {
                            SeeRoomManagerUI.a(SeeRoomManagerUI.this, linkedList);
                            SeeRoomManagerUI.this.gzI.notifyDataSetChanged();
                        } else if (aVar2.dGJ.getType() == 776) {
                            Log.i("MicroMsg.SeeRoomManagerUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", 774, Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType), Util.nullAsNil(aVar2.errMsg));
                            h.c(SeeRoomManagerUI.this.getContext(), Util.nullAs(aVar2.errMsg, SeeRoomManagerUI.this.getString(R.string.db)), SeeRoomManagerUI.this.getString(R.string.zb), true);
                        }
                        AppMethodBeat.o(12828);
                        return null;
                    }
                });
                AppMethodBeat.o(12844);
                return;
            case 1:
                AppCompatActivity context2 = getContext();
                getString(R.string.zb);
                this.tipDialog = h.a((Context) context2, getString(R.string.g6l), false, (DialogInterface.OnCancelListener) null);
                if (!ab.Ix(this.gxP)) {
                    new f(this.gxP, linkedList).aYI().a(this).b(new com.tencent.mm.vending.c.a<Void, c.a<aft>>() {
                        /* class com.tencent.mm.chatroom.ui.SeeRoomManagerUI.AnonymousClass7 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(c.a<aft> aVar) {
                            AppMethodBeat.i(194180);
                            c.a<aft> aVar2 = aVar;
                            if (SeeRoomManagerUI.this.tipDialog != null && SeeRoomManagerUI.this.tipDialog.isShowing()) {
                                SeeRoomManagerUI.this.tipDialog.dismiss();
                            }
                            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(aVar2.errMsg);
                            if (Dk != null) {
                                Dk.a(SeeRoomManagerUI.this, null, null);
                                Void r0 = QZL;
                                AppMethodBeat.o(194180);
                                return r0;
                            }
                            if (aVar2.errType == 0 && aVar2.errCode == 0) {
                                SeeRoomManagerUI.b(SeeRoomManagerUI.this, linkedList);
                                SeeRoomManagerUI.this.gzI.notifyDataSetChanged();
                            } else if (aVar2.dGJ.getType() == 3677) {
                                Log.i("MicroMsg.SeeRoomManagerUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", 774, Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType), Util.nullAsNil(aVar2.errMsg));
                                h.c(SeeRoomManagerUI.this.getContext(), SeeRoomManagerUI.this.getString(R.string.bl6), SeeRoomManagerUI.this.getString(R.string.zb), true);
                            }
                            AppMethodBeat.o(194180);
                            return null;
                        }
                    });
                    break;
                } else {
                    new d(this.gxP, linkedList).aYI().a(this).b(new com.tencent.mm.vending.c.a<Void, c.a<afe>>() {
                        /* class com.tencent.mm.chatroom.ui.SeeRoomManagerUI.AnonymousClass6 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(c.a<afe> aVar) {
                            AppMethodBeat.i(194179);
                            c.a<afe> aVar2 = aVar;
                            if (SeeRoomManagerUI.this.tipDialog != null && SeeRoomManagerUI.this.tipDialog.isShowing()) {
                                SeeRoomManagerUI.this.tipDialog.dismiss();
                            }
                            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(aVar2.errMsg);
                            if (Dk != null) {
                                Dk.a(SeeRoomManagerUI.this, null, null);
                                Void r0 = QZL;
                                AppMethodBeat.o(194179);
                                return r0;
                            }
                            if (aVar2.errType == 0 && aVar2.errCode == 0) {
                                SeeRoomManagerUI.b(SeeRoomManagerUI.this, linkedList);
                                SeeRoomManagerUI.this.gzI.notifyDataSetChanged();
                            } else if (aVar2.dGJ.getType() == 259) {
                                Log.i("MicroMsg.SeeRoomManagerUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", 774, Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType), Util.nullAsNil(aVar2.errMsg));
                                h.c(SeeRoomManagerUI.this.getContext(), SeeRoomManagerUI.this.getString(R.string.bl6), SeeRoomManagerUI.this.getString(R.string.zb), true);
                            }
                            AppMethodBeat.o(194179);
                            return null;
                        }
                    });
                    AppMethodBeat.o(12844);
                    return;
                }
        }
        AppMethodBeat.o(12844);
    }

    static /* synthetic */ SpannableString a(SeeRoomManagerUI seeRoomManagerUI, String str, TextView textView) {
        String displayName;
        AppMethodBeat.i(12845);
        if (textView == null) {
            AppMethodBeat.o(12845);
            return null;
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(Util.nullAsNil(str));
        if (Kn == null) {
            Log.w("MicroMsg.SeeRoomManagerUI", "ct == null");
            AppMethodBeat.o(12845);
            return null;
        }
        if (!Util.isNullOrNil(Kn.field_conRemark)) {
            displayName = Kn.field_conRemark;
        } else {
            displayName = seeRoomManagerUI.gtd != null ? seeRoomManagerUI.gtd.getDisplayName(str) : null;
        }
        if (Util.isNullOrNil(displayName)) {
            displayName = Kn.field_conRemark;
        }
        if (Util.isNullOrNil(displayName)) {
            displayName = Kn.arI();
        }
        SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(seeRoomManagerUI, Util.nullAsNil(displayName), textView.getTextSize());
        AppMethodBeat.o(12845);
        return b2;
    }

    static /* synthetic */ void a(SeeRoomManagerUI seeRoomManagerUI, String str, String str2, String str3) {
        cn aEZ;
        AppMethodBeat.i(12846);
        if (Util.isNullOrNil(str2) && (aEZ = ((l) g.af(l.class)).aSO().aEZ(str)) != null && !Util.isNullOrNil(aEZ.field_encryptUsername)) {
            str2 = aEZ.field_conRemark;
        }
        if (!Util.isNullOrNil(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (seeRoomManagerUI.gtd != null) {
                intent.putExtra("Contact_RoomNickname", seeRoomManagerUI.gtd.getDisplayName(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeRoomManagerUI.gxP);
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
                uj ujVar = new uj();
                ujVar.eaI.intent = intent;
                ujVar.eaI.username = str;
                EventCenter.instance.publish(ujVar);
            }
            if (Kn != null && Kn.gBM()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, Kn.field_username + ",14");
            }
            intent.putExtra("Contact_Scene", 96);
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeRoomManagerUI.gxP);
            com.tencent.mm.br.c.b(seeRoomManagerUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(12846);
    }

    static /* synthetic */ String e(SeeRoomManagerUI seeRoomManagerUI) {
        AppMethodBeat.i(12847);
        LinkedList linkedList = new LinkedList();
        for (a aVar : seeRoomManagerUI.gzI.dataList) {
            if (aVar.type == 1) {
                linkedList.add(aVar.contact.field_username);
            }
        }
        String listToString = Util.listToString(linkedList, ",");
        AppMethodBeat.o(12847);
        return listToString;
    }

    static /* synthetic */ void a(SeeRoomManagerUI seeRoomManagerUI, List list) {
        AppMethodBeat.i(12848);
        Log.i("MicroMsg.SeeRoomManagerUI", "[addRoomManagerSuccessful] roomName:%s size:%s", seeRoomManagerUI.gxP, Integer.valueOf(list.size()));
        LinkedList linkedList = new LinkedList(seeRoomManagerUI.gzI.dataList);
        seeRoomManagerUI.gzI.dataList.clear();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == 1) {
                seeRoomManagerUI.gzI.dataList.add(aVar);
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            as Kn = ((l) g.af(l.class)).aSN().Kn((String) it2.next());
            seeRoomManagerUI.gzI.dataList.add(new a(1, Kn));
            com.tencent.mm.k.a.a.b bje = seeRoomManagerUI.gtd.bje(Kn.field_username);
            if (bje != null) {
                bje.gCw &= 2048;
            }
        }
        seeRoomManagerUI.gzI.dataList.add(new a(2, null));
        if (seeRoomManagerUI.gzI.dataList.size() > 1) {
            seeRoomManagerUI.gzI.dataList.add(new a(3, null));
        } else {
            Log.w("MicroMsg.SeeRoomManagerUI", "[addRoomManagerSuccessful] roomName:%s size:%s mAdapter.dataList size:%s", seeRoomManagerUI.gxP, Integer.valueOf(list.size()), seeRoomManagerUI.gzI.dataList);
        }
        Log.i("MicroMsg.SeeRoomManagerUI", "[addRoomManagerSuccessful] ret:%s", Boolean.valueOf(((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().replace(seeRoomManagerUI.gtd)));
        AppMethodBeat.o(12848);
    }

    static /* synthetic */ void b(SeeRoomManagerUI seeRoomManagerUI, List list) {
        com.tencent.mm.k.a.a.b bje;
        AppMethodBeat.i(12849);
        Log.i("MicroMsg.SeeRoomManagerUI", "[delRoomManagerSuccessful] roomName:%s size:%s", seeRoomManagerUI.gxP, Integer.valueOf(list.size()));
        LinkedList linkedList = new LinkedList(seeRoomManagerUI.gzI.dataList);
        seeRoomManagerUI.gzI.dataList.clear();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == 1 && !list.contains(aVar.contact.field_username)) {
                seeRoomManagerUI.gzI.dataList.add(aVar);
            } else if (aVar.type == 1 && list.contains(aVar.contact.field_username) && (bje = seeRoomManagerUI.gtd.bje(aVar.contact.field_username)) != null) {
                bje.gCw &= -2049;
            }
        }
        seeRoomManagerUI.gzI.dataList.add(new a(2, null));
        if (seeRoomManagerUI.gzI.dataList.size() > 1) {
            seeRoomManagerUI.gzI.dataList.add(new a(3, null));
        } else {
            Log.w("MicroMsg.SeeRoomManagerUI", "[delRoomManagerSuccessful] roomName:%s size:%s mAdapter.dataList size:%s", seeRoomManagerUI.gxP, Integer.valueOf(list.size()), seeRoomManagerUI.gzI.dataList);
        }
        Log.i("MicroMsg.SeeRoomManagerUI", "[delRoomManagerSuccessful] ret:%s", Boolean.valueOf(((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().replace(seeRoomManagerUI.gtd)));
        AppMethodBeat.o(12849);
    }
}
