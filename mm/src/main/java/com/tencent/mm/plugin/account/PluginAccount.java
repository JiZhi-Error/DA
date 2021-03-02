package com.tencent.mm.plugin.account;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.account.model.m;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;

public class PluginAccount extends f implements a {
    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(127754);
        b.bfQ("account");
        pin(new y(m.class));
        pin(new y(a.class));
        pin(new y(com.tencent.mm.plugin.account.security.a.g.class));
        Log.i("MicroMsg.PluginAccount", "execute PluginAccount");
        AppMethodBeat.o(127754);
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public com.tencent.mm.plugin.account.friend.a.b getAddrUploadStg() {
        AppMethodBeat.i(127755);
        com.tencent.mm.plugin.account.friend.a.b addrUploadStg = a.getAddrUploadStg();
        AppMethodBeat.o(127755);
        return addrUploadStg;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public h getFacebookFrdStg() {
        AppMethodBeat.i(127756);
        h facebookFrdStg = a.getFacebookFrdStg();
        AppMethodBeat.o(127756);
        return facebookFrdStg;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public k getFrdExtStg() {
        AppMethodBeat.i(127757);
        k frdExtStg = a.getFrdExtStg();
        AppMethodBeat.o(127757);
        return frdExtStg;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public ar getQQGroupStg() {
        AppMethodBeat.i(127758);
        ar qQGroupStg = a.getQQGroupStg();
        AppMethodBeat.o(127758);
        return qQGroupStg;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public q getInviteFriendOpenStg() {
        AppMethodBeat.i(127759);
        q inviteFriendOpenStg = a.getInviteFriendOpenStg();
        AppMethodBeat.o(127759);
        return inviteFriendOpenStg;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public at getQQListStg() {
        AppMethodBeat.i(127760);
        at qQListStg = a.getQQListStg();
        AppMethodBeat.o(127760);
        return qQListStg;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public o getGoogleFriendStorage() {
        AppMethodBeat.i(127761);
        o googleFriendStorage = a.getGoogleFriendStorage();
        AppMethodBeat.o(127761);
        return googleFriendStorage;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public ap getOldAccountFriendStorage() {
        AppMethodBeat.i(184132);
        ap oldAccountFriendStorage = a.getOldAccountFriendStorage();
        AppMethodBeat.o(184132);
        return oldAccountFriendStorage;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public void setFriendData(LinkedList linkedList) {
        AppMethodBeat.i(127762);
        a.setFriendData(linkedList);
        AppMethodBeat.o(127762);
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public LinkedList<cik> getFriendData() {
        AppMethodBeat.i(127763);
        LinkedList<cik> friendData = a.getFriendData();
        AppMethodBeat.o(127763);
        return friendData;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public void clearFriendData() {
        AppMethodBeat.i(127764);
        a.clearFriendData();
        AppMethodBeat.o(127764);
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public void syncAddrBookAndUpload() {
        AppMethodBeat.i(127765);
        MMApplicationContext.getContext();
        com.tencent.mm.platformtools.a.blm();
        AppMethodBeat.o(127765);
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public void showAddrBookUploadConfirm(Activity activity, Runnable runnable, boolean z, int i2) {
        AppMethodBeat.i(127766);
        com.tencent.mm.platformtools.y.showAddrBookUploadConfirm(activity, runnable, z, i2);
        AppMethodBeat.o(127766);
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public void removeSelfAccount(Context context) {
        AppMethodBeat.i(127767);
        t.ds(context);
        AppMethodBeat.o(127767);
    }

    public String getPhoneNum(Context context, String str) {
        AppMethodBeat.i(127768);
        String phoneNum = com.tencent.mm.platformtools.h.getPhoneNum(context, str);
        AppMethodBeat.o(127768);
        return phoneNum;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public void syncUploadMContactStatus(boolean z, boolean z2) {
        AppMethodBeat.i(127769);
        com.tencent.mm.platformtools.y.syncUploadMContactStatus(z, z2);
        AppMethodBeat.o(127769);
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b bVar) {
        AppMethodBeat.i(127770);
        boolean syncAddrBook = com.tencent.mm.platformtools.a.syncAddrBook(bVar);
        AppMethodBeat.o(127770);
        return syncAddrBook;
    }

    @Override // com.tencent.mm.plugin.account.a.a.a
    public void updateAllContact() {
        AppMethodBeat.i(127771);
        t.dt(MMApplicationContext.getContext());
        AppMethodBeat.o(127771);
    }
}
