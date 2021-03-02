package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeworkRoomUpgradeResultUI extends MMActivity {
    private String gBW;
    private ArrayList<String> gBX;
    private ArrayList<String> gBY;
    private ImageView gBZ;
    private Button gCa;
    private a gCb;
    private int gwE;
    private Button gwO;
    private LinearLayout gwU;
    private RecyclerView gwW;
    private String gwx;
    private LinearLayoutManager gxa;
    private ManagerRoomByWeworkUI.b gxc;
    private TextView titleTv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(182220);
        super.onCreate(bundle);
        setMMTitle("");
        this.gwx = getIntent().getStringExtra("RoomInfo_Id");
        this.gwE = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
        Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "mFromScene:%s", Integer.valueOf(this.gwE));
        if (this.gwE == 3 || !Util.isNullOrNil(this.gwx)) {
            this.gBW = getIntent().getStringExtra("popup_wording");
            this.gBX = getIntent().getStringArrayListExtra("wework_upgrade_success_list");
            this.gBY = getIntent().getStringArrayListExtra("wework_upgrade_fail_list");
            z = true;
        } else {
            Log.e("MicroMsg.WeworkRoomUpgradeResultUI", "mRoomId is null");
            finish();
        }
        if (!z) {
            AppMethodBeat.o(182220);
            return;
        }
        initView();
        AppMethodBeat.o(182220);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ccd;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(182221);
        super.onDestroy();
        AppMethodBeat.o(182221);
    }

    @Override // com.tencent.mm.ui.MMActivity
    @Deprecated
    public void initView() {
        AppMethodBeat.i(182222);
        super.initView();
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.f3045c));
        setBackGroundColorResource(R.color.f3045c);
        setMMTitle("");
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.gBZ = (ImageView) findViewById(R.id.dt5);
        this.titleTv = (TextView) findViewById(R.id.bfd);
        this.gwU = (LinearLayout) findViewById(R.id.dll);
        this.gwW = (RecyclerView) findViewById(R.id.ux);
        this.gwO = (Button) findViewById(R.id.d50);
        this.gCa = (Button) findViewById(R.id.dki);
        if (this.gwE == 3) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gBZ.getLayoutParams();
            layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 48);
            this.gBZ.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.titleTv.getLayoutParams();
            layoutParams2.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 16);
            this.titleTv.setLayoutParams(layoutParams2);
            findViewById(R.id.bep).setVisibility(8);
            this.gwW.setVisibility(0);
            this.gxa = new LinearLayoutManager();
            this.gxa.setOrientation(1);
            this.gwW.setLayoutManager(this.gxa);
            this.gxc = new ManagerRoomByWeworkUI.b(getContext(), 56.0f);
            this.gwW.a(this.gxc);
            this.gCb = new a(getContext(), this.gBX, this.gBY);
            this.gwW.setAdapter(this.gCb);
            this.gCb.atj.notifyChanged();
            this.gwO.setVisibility(8);
            this.gCa.setVisibility(0);
            this.gCa.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.WeworkRoomUpgradeResultUI.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(182219);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "click return wework");
                    WeworkRoomUpgradeResultUI.cr(WeworkRoomUpgradeResultUI.this);
                    WeworkRoomUpgradeResultUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(182219);
                }
            });
            AppMethodBeat.o(182222);
            return;
        }
        ((TextView) findViewById(R.id.bep)).setText(this.gBW);
        this.gwW.setVisibility(8);
        this.gwO.setVisibility(0);
        this.gCa.setVisibility(8);
        this.gwO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.chatroom.ui.WeworkRoomUpgradeResultUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(194200);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "[goToChattingUI] username:%s", WeworkRoomUpgradeResultUI.this.gwx);
                Intent putExtra = new Intent().putExtra("Main_User", WeworkRoomUpgradeResultUI.this.gwx);
                putExtra.putExtra("From_fail_notify", true);
                putExtra.addFlags(67108864);
                putExtra.addFlags(536870912);
                c.f(WeworkRoomUpgradeResultUI.this, "com.tencent.mm.ui.LauncherUI", putExtra);
                WeworkRoomUpgradeResultUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(194200);
            }
        });
        AppMethodBeat.o(182222);
    }

    public static void cr(Context context) {
        AppMethodBeat.i(194206);
        if (context == null) {
            Log.e("MicroMsg.WeworkRoomUpgradeResultUI", "gotoWeWork context null");
            AppMethodBeat.o(194206);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("wxwork://jump"));
        intent.setPackage("com.tencent.wework");
        intent.setFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(194206);
    }

    public static class a extends RecyclerView.a {
        private Context context;
        private ArrayList<String> gBX;
        private ArrayList<String> gBY;
        private List<as> gxh = new ArrayList();

        public a(Context context2, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
            AppMethodBeat.i(194201);
            this.context = context2;
            this.gBX = arrayList;
            this.gBY = arrayList2;
            Iterator<String> it = this.gBX.iterator();
            while (it.hasNext()) {
                this.gxh.add(((l) g.af(l.class)).aSN().Kn(it.next()));
            }
            Iterator<String> it2 = this.gBY.iterator();
            while (it2.hasNext()) {
                this.gxh.add(((l) g.af(l.class)).aSN().Kn(it2.next()));
            }
            AppMethodBeat.o(194201);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(194202);
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ccc, viewGroup, false));
            AppMethodBeat.o(194202);
            return bVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(194203);
            if (this.gxh != null && i2 >= 0 && i2 < this.gxh.size()) {
                b bVar = (b) vVar;
                as asVar = this.gxh.get(i2);
                Log.d("MicroMsg.WeworkRoomUpgradeResultUI", "onBindViewHolder() i:%s username:%s", Integer.valueOf(i2), asVar.field_username);
                bVar.gvQ.setVisibility(0);
                ManagerRoomByWeworkUI.a(asVar.field_username, bVar.gwQ);
                if (this.gBX.contains(asVar.field_username)) {
                    ManagerRoomByWeworkUI.a(this.context, asVar.field_username, bVar.gxs, bVar.gxt, true);
                    bVar.gCd.setVisibility(8);
                    AppMethodBeat.o(194203);
                    return;
                }
                ManagerRoomByWeworkUI.a(this.context, asVar.field_username, bVar.gxs, bVar.gxt, false);
                bVar.gCd.setVisibility(0);
                bVar.gCd.setText(R.string.hu7);
            }
            AppMethodBeat.o(194203);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(194204);
            int size = this.gxh.size();
            AppMethodBeat.o(194204);
            return size;
        }
    }

    public static class b extends RecyclerView.v {
        TextView gCd;
        View gvQ;
        CdnImageView gwQ;
        TextView gxs;
        TextView gxt;

        public b(View view) {
            super(view);
            AppMethodBeat.i(194205);
            this.gvQ = view;
            this.gwQ = (CdnImageView) view.findViewById(R.id.arh);
            this.gCd = (TextView) view.findViewById(R.id.ars);
            this.gxs = (TextView) view.findViewById(R.id.arp);
            this.gxt = (TextView) view.findViewById(R.id.arr);
            AppMethodBeat.o(194205);
        }
    }
}
