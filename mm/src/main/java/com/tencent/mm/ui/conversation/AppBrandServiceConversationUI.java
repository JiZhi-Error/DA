package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.op;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.appbrand.d;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.e;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.l;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Keep
public final class AppBrandServiceConversationUI extends BaseConversationUI {
    private static final String TAG = "MicroMsg.AppBrandServiceConversationUI";
    private View contentView;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.conversation.BaseConversationUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.conversation.BaseConversationUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(38143);
        super.onCreate(bundle);
        this.contentView = aa.jQ(this).inflate(R.layout.la, (ViewGroup) null);
        setContentView(this.contentView);
        this.conversationFm = new AppBrandServiceConversationFmUI();
        getSupportFragmentManager().beginTransaction().a(R.id.fgf, this.conversationFm).commit();
        h.a((MMFragmentActivity) this, this.contentView);
        AppMethodBeat.o(38143);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(38144);
        super.finish();
        AppMethodBeat.o(38144);
    }

    @Keep
    public static class AppBrandServiceConversationFmUI extends BaseConversationUI.BaseConversationFmUI implements o.g {
        private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
        private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
        private static final int CONTEXT_MENU_LONGCLICK_DISMISS = 4;
        private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
        private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
        private e adapter;
        private d appBrandServiceActionSheet;
        private ListView appbrandMessageLV;
        private l contextMenuHelper;
        private az conversation;
        private TextView emptyTipTv;
        private int fromScene;
        private boolean isDeleteCancel = false;
        private String mAppId;
        private String mSceneId;
        private String superUsername;
        private String talker = "";
        private q tipDialog = null;

        static /* synthetic */ void access$200(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI, int i2) {
            AppMethodBeat.i(38141);
            appBrandServiceConversationFmUI.setShowView(i2);
            AppMethodBeat.o(38141);
        }

        static /* synthetic */ void access$800(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI, String str) {
            AppMethodBeat.i(38142);
            appBrandServiceConversationFmUI.delConversationAndMsg(str);
            AppMethodBeat.o(38142);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.i(38124);
            Log.i(TAG, "onActivityCreated");
            super.onActivityCreated(bundle);
            this.superUsername = getStringExtra("Contact_User");
            if (TextUtils.isEmpty(this.superUsername)) {
                this.superUsername = "appbrandcustomerservicemsg";
            }
            this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
            Log.i(TAG, "fromScene:%d", Integer.valueOf(this.fromScene));
            bg.aVF();
            this.mSceneId = System.currentTimeMillis() + intToString(c.getUin());
            initView();
            addIconOptionMenu(1, R.raw.app_brand_setting, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(38106);
                    Intent intent = new Intent(AppBrandServiceConversationFmUI.this.getContext(), ServiceNotifySettingsUI.class);
                    intent.putExtra("mode", 1);
                    intent.putExtra("scene_id", AppBrandServiceConversationFmUI.this.mSceneId);
                    AppBrandServiceConversationFmUI appBrandServiceConversationFmUI = AppBrandServiceConversationFmUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(appBrandServiceConversationFmUI, bl.axQ(), "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    appBrandServiceConversationFmUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(appBrandServiceConversationFmUI, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(38106);
                    return true;
                }
            });
            bg.aVF();
            c.aST().add(this.adapter);
            cleadAllServiceAppBrandUnreadCount();
            enterConversationReport();
            batchSyncForWxaContact();
            AppMethodBeat.o(38124);
        }

        private void cleadAllServiceAppBrandUnreadCount() {
            AppMethodBeat.i(38125);
            EventCenter.instance.publish(new com.tencent.mm.g.a.q());
            AppMethodBeat.o(38125);
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, com.tencent.mm.ui.MMFragment
        public int getLayoutId() {
            return R.layout.c3f;
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI
        public String getUserName() {
            return this.superUsername;
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onDestroy() {
            AppMethodBeat.i(38126);
            if (bg.aAc()) {
                bg.aVF();
                c.aST().remove(this.adapter);
            }
            batchSyncForWxaContact();
            if (this.adapter != null) {
                this.adapter.onDestroy();
            }
            super.onDestroy();
            AppMethodBeat.o(38126);
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onResume() {
            AppMethodBeat.i(38127);
            Log.i(TAG, "on resume");
            if (this.adapter != null) {
                this.adapter.onResume();
            }
            super.onResume();
            AppMethodBeat.o(38127);
        }

        @Override // com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onPause() {
            AppMethodBeat.i(38128);
            Log.i(TAG, "on pause");
            bg.aVF();
            c.aST().bka(this.superUsername);
            if (this.adapter != null) {
                this.adapter.onPause();
            }
            super.onPause();
            AppMethodBeat.o(38128);
        }

        private void batchSyncForWxaContact() {
            List<String> list;
            AppMethodBeat.i(38129);
            if (this.adapter == null || this.adapter.getCount() == 0) {
                AppMethodBeat.o(38129);
                return;
            }
            Log.i(TAG, "batchSyncForWxaContact, size:%d", Integer.valueOf(this.adapter.getCount()));
            if ((this.adapter instanceof a) && (list = ((a) this.adapter).gMT) != null && list.size() > 0) {
                ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).bq(list);
            }
            AppMethodBeat.o(38129);
        }

        private String intToString(int i2) {
            AppMethodBeat.i(38130);
            String bigInteger = new BigInteger(Integer.toBinaryString(i2), 2).toString();
            AppMethodBeat.o(38130);
            return bigInteger;
        }

        private void enterConversationReport() {
            int i2;
            String str;
            int i3;
            int i4;
            AppMethodBeat.i(38131);
            if (this.adapter == null) {
                Log.d(TAG, "adapter is null!");
                AppMethodBeat.o(38131);
                return;
            }
            bg.aVF();
            az bjY = c.aST().bjY("appbrandcustomerservicemsg");
            if (bjY == null || Util.isNullOrNil(bjY.field_username)) {
                i2 = 0;
            } else {
                i2 = bjY.field_unReadCount;
            }
            az azVar = (az) this.adapter.getItem(0);
            if (azVar == null || Util.isNullOrNil(azVar.field_username)) {
                str = "";
            } else {
                String nullAsNil = Util.nullAsNil(azVar.field_content);
                WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(azVar.field_username);
                this.mAppId = Xk == null ? null : Xk.field_appId;
                str = nullAsNil;
            }
            if (i2 > 0) {
                int count = this.adapter.getCount();
                int i5 = 0;
                i3 = 0;
                while (i5 < count) {
                    az azVar2 = (az) this.adapter.getItem(i5);
                    if (azVar2.field_unReadMuteCount + azVar2.field_unReadCount > 0) {
                        i4 = i3 + 1;
                    } else {
                        i4 = i3;
                    }
                    i5++;
                    i3 = i4;
                }
            } else {
                i3 = 0;
            }
            Log.d(TAG, "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", 13797, this.mSceneId, Integer.valueOf(i2), Integer.valueOf(i3), this.mAppId, str);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13797, this.mSceneId, Integer.valueOf(i2), Integer.valueOf(i3), this.mAppId, Long.valueOf(Util.nowSecond()), 0, str);
            AppMethodBeat.o(38131);
        }

        public void customerMsgOperateReport(int i2) {
            AppMethodBeat.i(38132);
            Log.d(TAG, "stev report(%s), eventId : %s, appId %s, sceneId %s", 13798, Integer.valueOf(i2), this.mAppId, this.mSceneId);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13798, Integer.valueOf(i2), this.mAppId, 0, this.mSceneId, Long.valueOf(Util.nowSecond()));
            AppMethodBeat.o(38132);
        }

        public void entryCustomerMsgDialogReport(String str, int i2) {
            AppMethodBeat.i(38133);
            bg.aVF();
            az bjY = c.aST().bjY(str);
            if (bjY == null) {
                Log.e(TAG, "cvs:%s is null, error", str);
                AppMethodBeat.o(38133);
                return;
            }
            int i3 = bjY.field_unReadCount;
            String nullAsNil = Util.nullAsNil(this.mSceneId);
            Log.d(TAG, "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", 13799, this.mAppId, Integer.valueOf(i2), Integer.valueOf(i3), nullAsNil);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13799, this.mAppId, Integer.valueOf(i2), Integer.valueOf(i3), nullAsNil, Long.valueOf(Util.nowSecond()));
            AppMethodBeat.o(38133);
        }

        /* access modifiers changed from: protected */
        public void initView() {
            AppMethodBeat.i(38134);
            setMMTitle(getString(R.string.js));
            this.appbrandMessageLV = (ListView) findViewById(R.id.ir8);
            this.emptyTipTv = (TextView) findViewById(R.id.c30);
            this.emptyTipTv.setText(R.string.kk);
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass6 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(38111);
                    AppBrandServiceConversationFmUI.this.finish();
                    AppMethodBeat.o(38111);
                    return true;
                }
            });
            this.appBrandServiceActionSheet = new d(thisActivity());
            this.adapter = new a(thisActivity(), this.superUsername, new s.a() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass7 */

                @Override // com.tencent.mm.ui.s.a
                public final void bnE() {
                    AppMethodBeat.i(38112);
                    AppBrandServiceConversationFmUI.access$200(AppBrandServiceConversationFmUI.this, AppBrandServiceConversationFmUI.this.adapter.getCount());
                    AppMethodBeat.o(38112);
                }
            });
            this.adapter.setGetViewPositionCallback(new MMSlideDelView.c() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass8 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.c
                public final int dr(View view) {
                    AppMethodBeat.i(38113);
                    int positionForView = AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(view);
                    AppMethodBeat.o(38113);
                    return positionForView;
                }
            });
            this.adapter.setPerformItemClickListener(new MMSlideDelView.g() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass9 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.g
                public final void r(View view, int i2, int i3) {
                    AppMethodBeat.i(38114);
                    AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(view, i2, (long) i3);
                    AppMethodBeat.o(38114);
                }
            });
            this.appbrandMessageLV.setAdapter((ListAdapter) this.adapter);
            this.contextMenuHelper = new l(thisActivity());
            this.appbrandMessageLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass10 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(38115);
                    b bVar = new b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    AppBrandServiceConversationFmUI.this.conversation = (az) AppBrandServiceConversationFmUI.this.adapter.getItem(i2);
                    az azVar = AppBrandServiceConversationFmUI.this.conversation;
                    if (azVar == null) {
                        Log.e(AppBrandServiceConversationFmUI.TAG, "user should not be null. position:%d, size:%d", Integer.valueOf(i2), Integer.valueOf(AppBrandServiceConversationFmUI.this.adapter.getCount()));
                        AppBrandServiceConversationFmUI.this.adapter.notifyDataSetChanged();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(38115);
                        return;
                    }
                    AppBrandServiceConversationFmUI.this.talker = azVar.field_username;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("finish_direct", false);
                    bundle.putBoolean("key_need_send_video", false);
                    bundle.putString("key_scene_id", AppBrandServiceConversationFmUI.this.mSceneId);
                    bundle.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationFmUI.this.fromScene);
                    AppBrandServiceConversationFmUI.this.ui.startChatting(azVar.field_username, bundle, true);
                    AppBrandServiceConversationFmUI.this.entryCustomerMsgDialogReport(azVar.field_username, AppBrandServiceConversationFmUI.this.fromScene);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(38115);
                }
            });
            this.appbrandMessageLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass11 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(38116);
                    AppBrandServiceConversationFmUI.this.conversation = (az) AppBrandServiceConversationFmUI.this.adapter.getItem(i2);
                    AppBrandServiceConversationFmUI.this.talker = AppBrandServiceConversationFmUI.this.conversation.field_username;
                    AppBrandServiceConversationFmUI.this.contextMenuHelper.a(view, i2, j2, AppBrandServiceConversationFmUI.this, AppBrandServiceConversationFmUI.this);
                    AppMethodBeat.o(38116);
                    return true;
                }
            });
            this.adapter.setGetViewPositionCallback(new MMSlideDelView.c() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass12 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.c
                public final int dr(View view) {
                    AppMethodBeat.i(38117);
                    int positionForView = AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(view);
                    AppMethodBeat.o(38117);
                    return positionForView;
                }
            });
            this.adapter.setPerformItemClickListener(new MMSlideDelView.g() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass13 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.g
                public final void r(View view, int i2, int i3) {
                    AppMethodBeat.i(38118);
                    AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(view, i2, (long) i3);
                    AppMethodBeat.o(38118);
                }
            });
            this.adapter.a(new MMSlideDelView.f() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.f
                public final void cZ(Object obj) {
                    AppMethodBeat.i(38107);
                    if (obj == null) {
                        Log.e(AppBrandServiceConversationFmUI.TAG, "onItemDel object null");
                        AppMethodBeat.o(38107);
                        return;
                    }
                    AppBrandServiceConversationFmUI.access$800(AppBrandServiceConversationFmUI.this, obj.toString());
                    AppMethodBeat.o(38107);
                }
            });
            AppMethodBeat.o(38134);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(38135);
            super.onActivityResult(i2, i3, intent);
            if (this.talker != null && !this.talker.isEmpty()) {
                this.talker = "";
            }
            if (i3 != -1) {
                AppMethodBeat.o(38135);
            } else {
                AppMethodBeat.o(38135);
            }
        }

        private void setShowView(int i2) {
            AppMethodBeat.i(38136);
            if (i2 <= 0) {
                this.emptyTipTv.setVisibility(0);
                this.appbrandMessageLV.setVisibility(8);
                AppMethodBeat.o(38136);
                return;
            }
            this.emptyTipTv.setVisibility(8);
            this.appbrandMessageLV.setVisibility(0);
            AppMethodBeat.o(38136);
        }

        private void delConversationAndMsg(String str) {
            AppMethodBeat.i(38137);
            if (Util.isNullOrNil(str)) {
                Log.e(TAG, "Delete Conversation and messages fail because username is null or nil.");
                AppMethodBeat.o(38137);
                return;
            }
            asyncDelMsg(str);
            bg.aVF();
            c.aST().bjW(str);
            com.tencent.f.h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(234095);
                    ((e) g.af(e.class)).c(null);
                    AppMethodBeat.o(234095);
                }
            });
            AppMethodBeat.o(38137);
        }

        private void asyncDelMsg(String str) {
            AppMethodBeat.i(38138);
            Log.i(TAG, "async del msg talker:%s", str);
            bg.aVF();
            ca aEw = c.aSQ().aEw(str);
            afk afk = new afk();
            afk.Lqk = new dqi().bhy(Util.nullAsNil(str));
            afk.Brn = aEw.field_msgSvrId;
            bg.aVF();
            c.aSM().d(new k.a(8, afk));
            this.isDeleteCancel = false;
            FragmentActivity thisActivity = thisActivity();
            getString(R.string.zb);
            final q a2 = com.tencent.mm.ui.base.h.a((Context) thisActivity, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(234096);
                    AppBrandServiceConversationFmUI.this.isDeleteCancel = true;
                    AppMethodBeat.o(234096);
                }
            });
            customerMsgOperateReport(5);
            bp.a(str, new bp.a() {
                /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AnonymousClass5 */

                @Override // com.tencent.mm.model.bp.a
                public final boolean amG() {
                    AppMethodBeat.i(234097);
                    boolean z = AppBrandServiceConversationFmUI.this.isDeleteCancel;
                    AppMethodBeat.o(234097);
                    return z;
                }

                @Override // com.tencent.mm.model.bp.a
                public final void amH() {
                    AppMethodBeat.i(234098);
                    if (a2 != null) {
                        a2.dismiss();
                    }
                    AppMethodBeat.o(234098);
                }
            });
            AppMethodBeat.o(38138);
        }

        /* access modifiers changed from: package-private */
        public static class a extends e {
            private IListener<op> PvR;
            private HashMap<String, Boolean> QaS;
            private HashMap<String, String> QaT;
            List<String> gMT;
            private Paint paint = new Paint();
            private String username;

            a(Context context, String str, s.a aVar) {
                super(context, aVar);
                AppMethodBeat.i(38120);
                this.username = str;
                this.QaS = new HashMap<>();
                this.QaT = new HashMap<>();
                this.gMT = new ArrayList();
                this.PvR = new IListener<op>() {
                    /* class com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a.AnonymousClass1 */

                    {
                        AppMethodBeat.i(161553);
                        this.__eventId = op.class.getName().hashCode();
                        AppMethodBeat.o(161553);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(op opVar) {
                        boolean z = false;
                        AppMethodBeat.i(38119);
                        op opVar2 = opVar;
                        if (opVar2.dUD.dCl != null) {
                            Log.d("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId:%s,event.newValue:%d", opVar2.dUD.dCl, Integer.valueOf(opVar2.dUD.dUE));
                            if ((opVar2.dUD.dUE & 2) > 0) {
                                z = true;
                            }
                            a.this.QaS.remove(opVar2.dUD.dCl);
                            a.this.QaS.put(opVar2.dUD.dCl, Boolean.valueOf(z));
                            a.this.notifyDataSetChanged();
                        } else {
                            Log.e("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId is null");
                        }
                        AppMethodBeat.o(38119);
                        return true;
                    }
                };
                EventCenter.instance.addListener(this.PvR);
                AppMethodBeat.o(38120);
            }

            @Override // com.tencent.mm.ui.s, com.tencent.mm.ui.conversation.e
            public final void anp() {
                AppMethodBeat.i(38121);
                bg.aVF();
                setCursor(c.aST().c(ab.iCL, this.gzY, this.username));
                if (this.OFI != null) {
                    this.OFI.bnE();
                }
                super.notifyDataSetChanged();
                AppMethodBeat.o(38121);
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.ui.conversation.e
            public final void a(String str, e.g gVar) {
                boolean booleanValue;
                int i2;
                int dimensionPixelOffset;
                int dimensionPixelOffset2;
                String str2;
                float measureText;
                float f2;
                float f3;
                AppMethodBeat.i(38122);
                Boolean bool = this.QaS.get(str);
                if (bool == null) {
                    WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(str);
                    booleanValue = Xk != null && (Xk.field_appOpt & 2) > 0;
                    this.QaS.put(str, bool);
                } else {
                    booleanValue = bool.booleanValue();
                }
                if (booleanValue) {
                    gVar.PaH.setVisibility(0);
                    gVar.PaH.setImageResource(R.raw.chat_reject_icon);
                } else {
                    gVar.PaH.setVisibility(8);
                }
                String str3 = this.QaT.get(str);
                if (TextUtils.isEmpty(str3)) {
                    str3 = com.tencent.mm.ui.appbrand.e.blY(com.tencent.mm.ui.appbrand.e.blX(str));
                    if (!TextUtils.isEmpty(str3)) {
                        this.QaT.put(str, str3);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    gVar.Qcr.setVisibility(0);
                    gVar.Qcr.setText(this.context.getString(R.string.rs, str3));
                    if (this.context.getResources().getDisplayMetrics() != null) {
                        i2 = this.context.getResources().getDisplayMetrics().widthPixels;
                    } else {
                        i2 = 0;
                    }
                    if (com.tencent.mm.cb.a.jk(this.context)) {
                        dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.dimen.ik);
                        dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.dimen.b4);
                    } else {
                        dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.dimen.il);
                        dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.dimen.b5);
                    }
                    int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(R.dimen.hs);
                    int dimensionPixelOffset4 = this.context.getResources().getDimensionPixelOffset(R.dimen.ir);
                    e.d dVar = this.Pax.get(str);
                    if (dVar == null || dVar.nickName == null) {
                        str2 = "";
                    } else {
                        str2 = dVar.nickName.toString();
                    }
                    if (str2 == null) {
                        measureText = 0.0f;
                    } else {
                        this.paint.setTextSize(this.Pat);
                        measureText = this.paint.measureText(str2);
                    }
                    float f4 = 48.0f + measureText;
                    int dimensionPixelOffset5 = this.context.getResources().getDimensionPixelOffset(R.dimen.b5);
                    int dimensionPixelOffset6 = this.context.getResources().getDimensionPixelOffset(R.dimen.i2);
                    Log.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", Integer.valueOf(i2), Integer.valueOf(dimensionPixelOffset), Integer.valueOf(dimensionPixelOffset2));
                    float f5 = 0.0f;
                    if (i2 > 0) {
                        f5 = (float) ((((i2 - dimensionPixelOffset) - dimensionPixelOffset3) - dimensionPixelOffset4) - dimensionPixelOffset2);
                    }
                    if (f4 > f5 || f4 >= f5 || f5 <= 0.0f) {
                        f2 = 0.4f;
                        f3 = 0.6f;
                    } else {
                        float min = Math.min(f4 / f5, (((f5 - ((float) dimensionPixelOffset5)) - ((float) dimensionPixelOffset6)) - 48.0f) / f5);
                        f2 = 1.0f - min;
                        f3 = min;
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.PaE.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = f3;
                    gVar.PaE.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.Qcr.getLayoutParams();
                    layoutParams2.width = 0;
                    layoutParams2.weight = f2;
                    gVar.Qcr.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) gVar.PaE.getLayoutParams();
                    layoutParams3.width = -1;
                    layoutParams3.weight = 0.0f;
                    gVar.PaE.setLayoutParams(layoutParams3);
                }
                a.b.d(gVar.gvv, str);
                if (!this.gMT.contains(str)) {
                    this.gMT.add(str);
                }
                AppMethodBeat.o(38122);
            }

            @Override // com.tencent.mm.ui.conversation.e
            public final void detach() {
                AppMethodBeat.i(38123);
                this.QaS = null;
                EventCenter.instance.removeListener(this.PvR);
                AppMethodBeat.o(38123);
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(38139);
            bg.aVF();
            as Kn = c.aSN().Kn(this.talker);
            if (Kn == null || ((int) Kn.gMZ) == 0) {
                Log.e(TAG, "changed biz stick status failed, contact is null, talker = " + this.talker);
                AppMethodBeat.o(38139);
                return;
            }
            switch (menuItem.getItemId()) {
                case 1:
                    this.appBrandServiceActionSheet.username = this.talker;
                    this.appBrandServiceActionSheet.scene = this.fromScene;
                    this.appBrandServiceActionSheet.OMW = this.mSceneId;
                    this.appBrandServiceActionSheet.oDm = true;
                    this.appBrandServiceActionSheet.show(3);
                    AppMethodBeat.o(38139);
                    return;
                case 2:
                    this.appBrandServiceActionSheet.username = this.talker;
                    this.appBrandServiceActionSheet.scene = this.fromScene;
                    this.appBrandServiceActionSheet.OMW = this.mSceneId;
                    this.appBrandServiceActionSheet.oDm = true;
                    this.appBrandServiceActionSheet.show(4);
                    AppMethodBeat.o(38139);
                    return;
                case 3:
                    delConversationAndMsg(this.talker);
                    break;
                case 4:
                    AppMethodBeat.o(38139);
                    return;
            }
            AppMethodBeat.o(38139);
        }

        @Override // android.support.v4.app.Fragment
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(38140);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
            WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(this.talker);
            if (Xk != null && (Xk.field_appOpt & 2) > 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.nj);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.nl);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.string.blj);
            AppMethodBeat.o(38140);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.conversation.BaseConversationUI
    public final ChattingUIFragment getChattingUIFragment() {
        AppMethodBeat.i(38145);
        AppBrandServiceChattingUI.AppBrandServiceChattingFmUI appBrandServiceChattingFmUI = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI();
        AppMethodBeat.o(38145);
        return appBrandServiceChattingFmUI;
    }
}
