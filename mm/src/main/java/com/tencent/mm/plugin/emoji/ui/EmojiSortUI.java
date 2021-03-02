package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.plugin.emoji.f.t;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.ArrayList;
import java.util.Iterator;

public class EmojiSortUI extends EmojiBaseActivity implements i, MStorage.IOnStorageChange {
    ProgressDialog jZH;
    private ArrayList<EmojiGroupInfo> mData = new ArrayList<>();
    private e rhf;
    private DragSortListView rhg;
    private t rhh;
    private DragSortListView.h rhi = new DragSortListView.h() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiSortUI.AnonymousClass4 */

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.h
        public final void ey(int i2, int i3) {
            AppMethodBeat.i(108972);
            EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) EmojiSortUI.this.rhf.getItem(i2);
            EmojiSortUI.this.rhf.remove(emojiGroupInfo);
            EmojiSortUI.this.rhf.insert(emojiGroupInfo, i3);
            AppMethodBeat.o(108972);
        }
    };
    private DragSortListView.l rhj = new DragSortListView.l() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiSortUI.AnonymousClass5 */

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.l
        public final void remove(int i2) {
            AppMethodBeat.i(108973);
            EmojiSortUI.this.rhf.remove(EmojiSortUI.this.rhf.getItem(i2));
            AppMethodBeat.o(108973);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiSortUI() {
        AppMethodBeat.i(108974);
        AppMethodBeat.o(108974);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(108975);
        super.onCreate(bundle);
        initView();
        this.mData = k.getEmojiStorageMgr().OpO.gES();
        this.rhg = (DragSortListView) findViewById(16908298);
        this.rhg.setDropListener(this.rhi);
        this.rhg.setRemoveListener(this.rhj);
        this.rhf = new e(getContext(), this.mData);
        this.rhg.setAdapter((ListAdapter) this.rhf);
        k.getEmojiStorageMgr().OpO.add(this);
        g.aAg().hqi.a(717, this);
        AppMethodBeat.o(108975);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(108976);
        k.getEmojiStorageMgr().OpO.remove(this);
        g.aAg().hqi.b(717, this);
        super.onDestroy();
        AppMethodBeat.o(108976);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a2h;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(108977);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiSortUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108969);
                EmojiSortUI.this.finish();
                AppMethodBeat.o(108969);
                return true;
            }
        });
        setMMTitle(getString(R.string.gof));
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiSortUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108970);
                if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                    EmojiSortUI.a(EmojiSortUI.this);
                } else {
                    EmojiSortUI emojiSortUI = EmojiSortUI.this;
                    emojiSortUI.getString(R.string.zb);
                    emojiSortUI.jZH = h.a((Context) emojiSortUI, emojiSortUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.emoji.ui.EmojiSortUI.AnonymousClass3 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(108971);
                            if (EmojiSortUI.this.rhh != null) {
                                g.aAg().hqi.a(EmojiSortUI.this.rhh);
                            }
                            AppMethodBeat.o(108971);
                        }
                    });
                    ArrayList arrayList = new ArrayList();
                    if (!(EmojiSortUI.this.rhf == null || EmojiSortUI.this.rhf.qXp == null)) {
                        for (EmojiGroupInfo emojiGroupInfo : EmojiSortUI.this.rhf.qXp) {
                            arrayList.add(emojiGroupInfo.field_productID);
                        }
                    }
                    EmojiSortUI.this.rhh = new t(arrayList, 2);
                    g.aAg().hqi.a(EmojiSortUI.this.rhh, 0);
                }
                AppMethodBeat.o(108970);
                return true;
            }
        });
        ((TextView) findViewById(16908310)).setText(R.string.bum);
        AppMethodBeat.o(108977);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(108978);
        if (!(str == null || !str.equals("event_update_group") || this.rhf == null)) {
            e eVar = this.rhf;
            ArrayList<EmojiGroupInfo> gES = k.getEmojiStorageMgr().OpO.gES();
            eVar.clear();
            Iterator<EmojiGroupInfo> it = gES.iterator();
            while (it.hasNext()) {
                eVar.insert(it.next(), eVar.getCount());
            }
            eVar.notifyDataSetChanged();
        }
        AppMethodBeat.o(108978);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
    public final void j(Message message) {
    }

    @Override // com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
    public final void k(Message message) {
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(108979);
        Log.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + i2 + "   errCode:" + i3);
        if (this.jZH != null) {
            this.jZH.dismiss();
        }
        if (i2 == 0 && i2 == 0) {
            this.rhf.cFn();
            finish();
            AppMethodBeat.o(108979);
            return;
        }
        h.d(this, getString(R.string.btr), "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiSortUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(108979);
    }

    static /* synthetic */ void a(EmojiSortUI emojiSortUI) {
        AppMethodBeat.i(108980);
        h.a(emojiSortUI, emojiSortUI.getString(R.string.btt), "", emojiSortUI.getString(R.string.bts), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiSortUI.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(108980);
    }
}
