package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.y;

public class SeeRoomOwnerManagerUI extends MMPreference {
    private ah gtd;
    private String gwx;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(12909);
        super.onCreate(bundle);
        setMMTitle(R.string.g7p);
        setBackBtn(new y() {
            /* class com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.y
            public final void ane() {
                AppMethodBeat.i(12906);
                SeeRoomOwnerManagerUI.this.finish();
                AppMethodBeat.o(12906);
            }
        });
        this.gwx = getIntent().getStringExtra("RoomInfo_Id");
        this.gtd = ((c) g.af(c.class)).aSX().Kd(Util.nullAsNil(this.gwx));
        if (this.gtd != null) {
            PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(getContext());
            preferenceTitleCategory.setTitle(R.string.g_6);
            getPreferenceScreen().c(preferenceTitleCategory);
            Log.i("MicroMsg.SeeRoomOwnerManagerUI", "[onCreate] owner:%s", this.gtd.field_roomowner);
            final as Kn = ((l) g.af(l.class)).aSN().Kn(this.gtd.field_roomowner);
            AnonymousClass2 r1 = new NormalIconPreference(getContext()) {
                /* class com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference
                public final void onBindView(View view) {
                    AppMethodBeat.i(12907);
                    super.onBindView(view);
                    a.b.a(this.OYh, Kn.field_username, 0.15f, false);
                    this.OYh.setVisibility(0);
                    AppMethodBeat.o(12907);
                }
            };
            r1.setKey(Kn.field_username);
            r1.getExtras().putString(ch.COL_USERNAME, Kn.field_username);
            r1.setTitle(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), Kn.arJ()));
            getPreferenceScreen().c(r1);
            PreferenceTitleCategory preferenceTitleCategory2 = new PreferenceTitleCategory(getContext());
            preferenceTitleCategory2.setTitle(R.string.g7u);
            boolean z2 = false;
            for (String str : this.gtd.bax()) {
                if (this.gtd.bjf(str)) {
                    Log.i("MicroMsg.SeeRoomOwnerManagerUI", "[resetData] Room Manager:%s", str);
                    if (!z2) {
                        getPreferenceScreen().c(preferenceTitleCategory2);
                        z = true;
                    } else {
                        z = z2;
                    }
                    final as Kn2 = ((l) g.af(l.class)).aSN().Kn(str);
                    AnonymousClass3 r7 = new NormalIconPreference(getContext()) {
                        /* class com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI.AnonymousClass3 */

                        @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference
                        public final void onBindView(View view) {
                            AppMethodBeat.i(12908);
                            super.onBindView(view);
                            a.b.a(this.OYh, Kn2.field_username, 0.15f, false);
                            this.OYh.setVisibility(0);
                            AppMethodBeat.o(12908);
                        }
                    };
                    r7.setKey(str);
                    r7.getExtras().putString(ch.COL_USERNAME, Kn2.field_username);
                    r7.setTitle(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), Kn2.arJ()));
                    getPreferenceScreen().c(r7);
                    z2 = z;
                }
            }
            getPreferenceScreen().notifyDataSetChanged();
        }
        AppMethodBeat.o(12909);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.c4;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String str;
        cn aEZ;
        AppMethodBeat.i(12910);
        if (preference instanceof NormalIconPreference) {
            as Kn = ((l) g.af(l.class)).aSN().Kn(preference.getExtras().getString(ch.COL_USERNAME));
            String str2 = Kn.field_username;
            String arJ = Kn.arJ();
            String str3 = Kn.field_nickname;
            if (!Util.isNullOrNil(arJ) || (aEZ = ((l) g.af(l.class)).aSO().aEZ(str2)) == null || Util.isNullOrNil(aEZ.field_encryptUsername)) {
                str = arJ;
            } else {
                str = aEZ.field_conRemark;
            }
            if (!Util.isNullOrNil(str2)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str2);
                intent.putExtra("Contact_RemarkName", str);
                if (this.gtd != null) {
                    intent.putExtra("Contact_RoomNickname", this.gtd.getDisplayName(str2));
                }
                intent.putExtra("Contact_Nick", str3);
                intent.putExtra("Contact_RoomMember", true);
                intent.putExtra("room_name", this.gwx);
                as Kn2 = ((l) g.af(l.class)).aSN().Kn(str2);
                if (Kn2 != null && ((int) Kn2.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn2.field_type)) {
                    uj ujVar = new uj();
                    ujVar.eaI.intent = intent;
                    ujVar.eaI.username = str2;
                    EventCenter.instance.publish(ujVar);
                }
                if (Kn2 != null && Kn2.gBM()) {
                    h.INSTANCE.kvStat(10298, Kn2.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 96);
                intent.putExtra("Is_RoomOwner", true);
                intent.putExtra("Contact_ChatRoomId", this.gwx);
                com.tencent.mm.br.c.b(this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            }
        }
        AppMethodBeat.o(12910);
        return false;
    }
}
