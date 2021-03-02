package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI extends RecordMsgBaseUI {
    private boolean BHA = true;
    private boolean BHB = false;
    private i BHC;
    private long BHz = -1;
    private boolean dUo = true;
    private MStorage.IOnStorageChange tbR = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.record.ui.FavRecordDetailUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(27843);
            if (mStorageEventData == null) {
                AppMethodBeat.o(27843);
            } else if (mStorageEventData.obj == null) {
                AppMethodBeat.o(27843);
            } else {
                long longValue = ((Long) mStorageEventData.obj).longValue();
                if (longValue < 0) {
                    AppMethodBeat.o(27843);
                    return;
                }
                if (FavRecordDetailUI.this.BHz == longValue) {
                    g HT = h.HT(FavRecordDetailUI.this.BHz);
                    final b bVar = new b();
                    bVar.qNT = HT;
                    if (!(HT == null || HT.field_favProto == null)) {
                        bVar.BHs = HT.field_favProto.ppH;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.record.ui.FavRecordDetailUI.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(27842);
                                FavRecordDetailUI.this.BHV.a(bVar);
                                AppMethodBeat.o(27842);
                            }
                        });
                    }
                }
                AppMethodBeat.o(27843);
            }
        }
    };
    private g tfP;

    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavRecordDetailUI() {
        AppMethodBeat.i(27851);
        AppMethodBeat.o(27851);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.record.ui.RecordMsgBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27852);
        super.onCreate(bundle);
        AppMethodBeat.o(27852);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final void eIs() {
        AppMethodBeat.i(27853);
        this.BHz = getIntent().getLongExtra("key_detail_info_id", -1);
        this.dUo = getIntent().getBooleanExtra("show_share", true);
        this.tfP = h.HT(this.BHz);
        if (this.tfP == null) {
            finish();
            AppMethodBeat.o(27853);
            return;
        }
        H(this.tfP);
        b bVar = new b();
        bVar.qNT = this.tfP;
        bVar.BHs = this.tfP.field_favProto.ppH;
        bVar.BHt = new x();
        List list = bVar.BHs;
        if (list != null) {
            if (list.size() != 0) {
                Iterator it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((aml) it.next()).Lwv != 0) {
                            this.BHA = false;
                            break;
                        }
                    } else {
                        this.BHA = true;
                        break;
                    }
                }
            } else {
                this.BHA = false;
            }
        } else {
            this.BHA = false;
        }
        super.eIs();
        this.BHV.a(bVar);
        this.BHC = new i(this, this.BHV, bVar);
        final List list2 = bVar.BHs;
        if (list2 != null) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.record.ui.FavRecordDetailUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(27850);
                    if (list2 == null) {
                        AppMethodBeat.o(27850);
                        return;
                    }
                    Log.i("MicroMsg.FavRecordDetailUI", "start calc");
                    long j2 = 0;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    for (aml aml : list2) {
                        if (aml != null && !FavRecordDetailUI.this.BHB) {
                            switch (aml.dataType) {
                                case 1:
                                    i5++;
                                    j2 = (aml.desc != null ? (long) aml.desc.getBytes().length : 0) + j2;
                                    continue;
                                case 2:
                                    i4++;
                                    continue;
                                case 4:
                                case 15:
                                    i3++;
                                    continue;
                                default:
                                    i2++;
                                    continue;
                            }
                        }
                    }
                    String format = String.format("%s:%s:%s:%s:%s", Integer.valueOf(i5), Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2));
                    FavRecordDetailUI.a(FavRecordDetailUI.this, format);
                    Log.v("MicroMsg.FavRecordDetailUI", "start calc finish %s", format);
                    AppMethodBeat.o(27850);
                }
            }, "calc_fav_record_info");
        }
        this.BHV.BHC = this.BHC;
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().add(this.tbR);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(((d) this.BHV).BHv);
        AppMethodBeat.o(27853);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final h eIt() {
        AppMethodBeat.i(27854);
        d dVar = new d(this, new c(this));
        AppMethodBeat.o(27854);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        boolean z;
        AppMethodBeat.i(27855);
        super.onResume();
        b bVar = (b) ((d) this.BHV).BHQ;
        if (bVar.qNT != null) {
            g HT = h.HT(bVar.qNT.field_localId);
            if (HT == null || HT.field_favProto == null) {
                AppMethodBeat.o(27855);
                return;
            }
            LinkedList<aml> linkedList = HT.field_favProto.ppH;
            Iterator it = bVar.BHs.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!linkedList.contains((aml) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                b bVar2 = new b();
                bVar2.qNT = HT;
                bVar2.BHs = HT.field_favProto.ppH;
                this.BHV.a(bVar2);
            }
        }
        AppMethodBeat.o(27855);
    }

    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(232023);
        super.onPause();
        if (this.BHC != null) {
            this.BHC.BID = false;
        }
        AppMethodBeat.o(232023);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(27856);
        super.onStop();
        AppMethodBeat.o(27856);
    }

    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(27857);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().remove(this.tbR);
        if (this.BHV != null) {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(((d) this.BHV).BHv);
        }
        this.BHB = true;
        if (this.BHC != null) {
            this.BHC.eID();
        }
        super.onDestroy();
        AppMethodBeat.o(27857);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final String eIu() {
        String Is;
        AppMethodBeat.i(27858);
        if (14 != this.tfP.field_type || Util.isNullOrNil(this.tfP.field_favProto.title)) {
            anh anh = this.tfP.field_favProto.Lya;
            if (anh == null || Util.isNullOrNil(anh.LxA)) {
                Log.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", this.tfP.field_fromUser);
                Is = p.Is(this.tfP.field_fromUser);
            } else {
                Is = aa.getDisplayName(anh.LxA);
                if (z.aTY().equals(anh.dRL)) {
                    String Is2 = p.Is(anh.toUser);
                    if (!Util.nullAs(Is2, "").equals(anh.toUser)) {
                        Is = Is + " - " + Is2;
                    }
                } else {
                    String Is3 = p.Is(anh.dRL);
                    if (!Util.nullAs(Is3, "").equals(anh.dRL)) {
                        Is = Is + " - " + Is3;
                    }
                }
                Log.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", anh.dRL, anh.toUser);
            }
        } else {
            Is = this.tfP.field_favProto.title;
        }
        AppMethodBeat.o(27858);
        return Is;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final String eIv() {
        AppMethodBeat.i(27859);
        LinkedList<aml> linkedList = this.tfP.field_favProto.ppH;
        if (linkedList.size() > 0) {
            String str = linkedList.getFirst().Lwl;
            AppMethodBeat.o(27859);
            return str;
        }
        AppMethodBeat.o(27859);
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final String eIw() {
        AppMethodBeat.i(27860);
        LinkedList<aml> linkedList = this.tfP.field_favProto.ppH;
        if (linkedList.size() > 0) {
            String str = linkedList.getLast().Lwl;
            AppMethodBeat.o(27860);
            return str;
        }
        AppMethodBeat.o(27860);
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final void eIx() {
        AppMethodBeat.i(27861);
        if (!this.dUo) {
            AppMethodBeat.o(27861);
            return;
        }
        addIconOptionMenu(0, R.string.hp_, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.record.ui.FavRecordDetailUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27848);
                e eVar = new e((Context) FavRecordDetailUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.record.ui.FavRecordDetailUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(27844);
                        Log.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", Integer.valueOf(FavRecordDetailUI.this.tfP.field_id), Integer.valueOf(FavRecordDetailUI.this.tfP.field_itemStatus));
                        if (FavRecordDetailUI.this.tfP.field_id > 0 && !FavRecordDetailUI.this.tfP.cUx() && !FavRecordDetailUI.this.tfP.cUy() && FavRecordDetailUI.this.BHA) {
                            mVar.d(0, FavRecordDetailUI.this.getString(R.string.cc8));
                        }
                        mVar.d(5, FavRecordDetailUI.this.getString(R.string.cbv));
                        mVar.d(3, FavRecordDetailUI.this.getString(R.string.c9s));
                        mVar.d(2, FavRecordDetailUI.this.getString(R.string.tf));
                        AppMethodBeat.o(27844);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.record.ui.FavRecordDetailUI.AnonymousClass2.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(27847);
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (FavRecordDetailUI.HW(FavRecordDetailUI.this.tfP.field_localId)) {
                                    int i3 = R.string.c9h;
                                    if (FavRecordDetailUI.this.tfP.field_type == 18) {
                                        i3 = R.string.c9g;
                                    }
                                    com.tencent.mm.ui.base.h.cD(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(i3, new Object[]{Util.getSizeKB(c.aqu())}));
                                    AppMethodBeat.o(27847);
                                    return;
                                }
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", FavRecordDetailUI.this.tfP.field_localId);
                                com.tencent.mm.br.c.c(FavRecordDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 4097);
                                com.tencent.mm.plugin.fav.a.h.w(FavRecordDetailUI.this.tfP.field_localId, 1);
                                AppMethodBeat.o(27847);
                                return;
                            case 2:
                                com.tencent.mm.ui.base.h.a(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(R.string.th), "", new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.record.ui.FavRecordDetailUI.AnonymousClass2.AnonymousClass2.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(27846);
                                        final q a2 = com.tencent.mm.ui.base.h.a((Context) FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(R.string.th), false, (DialogInterface.OnCancelListener) null);
                                        hb hbVar = new hb();
                                        hbVar.dLm.type = 12;
                                        hbVar.dLm.dFW = FavRecordDetailUI.this.BHz;
                                        hbVar.dLm.dLr = new Runnable() {
                                            /* class com.tencent.mm.plugin.record.ui.FavRecordDetailUI.AnonymousClass2.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(27845);
                                                a2.dismiss();
                                                Log.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", Long.valueOf(FavRecordDetailUI.this.BHz));
                                                FavRecordDetailUI.this.finish();
                                                AppMethodBeat.o(27845);
                                            }
                                        };
                                        EventCenter.instance.publish(hbVar);
                                        AppMethodBeat.o(27846);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                AppMethodBeat.o(27847);
                                return;
                            case 3:
                                Intent intent2 = new Intent();
                                intent2.putExtra("key_fav_scene", 2);
                                intent2.putExtra("key_fav_item_id", FavRecordDetailUI.this.BHz);
                                b.b(FavRecordDetailUI.this.getContext(), ".ui.FavTagEditUI", intent2);
                                AppMethodBeat.o(27847);
                                return;
                            case 4:
                                Intent intent3 = new Intent();
                                intent3.putExtra("key_fav_scene", 1);
                                intent3.putExtra("key_fav_item_id", FavRecordDetailUI.this.tfP.field_localId);
                                b.b(FavRecordDetailUI.this.getContext(), ".ui.FavTagEditUI", intent3);
                                AppMethodBeat.o(27847);
                                return;
                            case 5:
                                j.a(FavRecordDetailUI.this, FavRecordDetailUI.this.BHz, FavRecordDetailUI.this.thD);
                                break;
                        }
                        AppMethodBeat.o(27847);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(27848);
                return true;
            }
        });
        AppMethodBeat.o(27861);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final void f(int i2, int i3, Intent intent) {
        String stringExtra;
        AppMethodBeat.i(27862);
        if (4097 == i2 && -1 == i3) {
            hb hbVar = new hb();
            hbVar.dLm.type = 32;
            hbVar.dLm.dFW = this.BHz;
            EventCenter.instance.publish(hbVar);
            if (hbVar.dLn.dLD) {
                com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.f3146c));
                AppMethodBeat.o(27862);
                return;
            }
            String stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                stringExtra = null;
            } else {
                stringExtra = intent.getStringExtra("custom_send_text");
            }
            final q a2 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            hb hbVar2 = new hb();
            hbVar2.dLm.type = 13;
            hbVar2.dLm.context = getContext();
            hbVar2.dLm.toUser = stringExtra2;
            hbVar2.dLm.dLs = stringExtra;
            hbVar2.dLm.dFW = this.BHz;
            hbVar2.dLm.dLr = new Runnable() {
                /* class com.tencent.mm.plugin.record.ui.FavRecordDetailUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(27849);
                    a2.dismiss();
                    com.tencent.mm.ui.widget.snackbar.b.r(FavRecordDetailUI.this, FavRecordDetailUI.this.getString(R.string.dc_));
                    AppMethodBeat.o(27849);
                }
            };
            EventCenter.instance.publish(hbVar2);
            AppMethodBeat.o(27862);
            return;
        }
        AppMethodBeat.o(27862);
    }

    static /* synthetic */ boolean HW(long j2) {
        AppMethodBeat.i(169762);
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
        long j3 = 0;
        if (DY != null) {
            j3 = DY.field_datatotalsize;
        }
        Log.i("MicroMsg.FavRecordDetailUI", "note2Send, totalSize:%s", Long.valueOf(j3));
        if (j3 > c.aqu()) {
            AppMethodBeat.o(169762);
            return true;
        }
        AppMethodBeat.o(169762);
        return false;
    }

    static /* synthetic */ void a(FavRecordDetailUI favRecordDetailUI, String str) {
        favRecordDetailUI.thD.tam = str;
    }
}
